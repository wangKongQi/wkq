package com.medcine.service.person.impl;

import com.medcine.base.entity.file.FileInfo;
import com.medcine.base.entity.org.Org;
import com.medcine.base.entity.person.Person;
import com.medcine.base.entity.person.PersonBO;
import com.medcine.base.entity.person.PersonPageBO;
import com.medcine.base.entity.person.PersonQO;
import com.medcine.dao.FileMapper;
import com.medcine.dao.NumeralMapper;
import com.medcine.dao.PersonMapper;
import com.medcine.service.person.PersonService;
import com.medcine.utils.common.FileUtils;
import com.medcine.utils.enums.CommonStringEnums;
import com.medcine.utils.enums.CommonLongEnums;
import com.medcine.utils.vo.PageVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author wkq
 * @date 2020/11/4 8:24
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Resource
    private FileMapper fileMapper;

    @Resource
    private NumeralMapper numeralMapper;


    @Override
    public PageVo<PersonPageBO> pageQuery(PersonQO qo) throws Exception {
        PageVo<PersonPageBO> pageVo = new PageVo<PersonPageBO>().setCurrentAndSize(qo);
        List<PersonPageBO> page = personMapper.pageQuery(qo);
        page.forEach(bo -> {
            List<String> imgPaths = new ArrayList<>();
            if (bo.getImgArray() != null && !"".equals(bo.getImgArray())) {
                Arrays.asList(bo.getImgArray().split(",")).forEach(id -> {
                    //获取图片路径
                    if (StringUtils.isNoneEmpty(id)) {
                        FileInfo file = fileMapper.getById(Long.valueOf(id));
                        if (file != null && file.getPath() != null) {
                            imgPaths.add(file.getPath());
                        }
                    }
                });
                bo.setImgPaths(imgPaths);
            }
        });
        pageVo.setRecords(page);
        pageVo.setTotal(personMapper.getCount(qo));
        return pageVo;
    }

    @Override
    @Transactional
    public Integer add(Person person) throws Exception {
        Person data = personMapper.selectByOne(person.getOrgNo(), person.getDepartNo(), person.getPersonNo(), 0);
        if (data != null) {
            return -1;
        }
        //超级管理员 0, 机构人员管理员账号 1
        return personMapper.insert(person);
    }

    @Override
    @Transactional
    public Integer update(Person person) throws Exception {
        Person data = personMapper.selectByOne(person.getOrgNo(), person.getDepartNo(), person.getPersonNo(), 0);
        if (data != null && data.getId() != person.getId()) {
            return -1;
        }
        //编辑人员相关信息
        Person oldInfo = personMapper.selectById(person.getId());
        if (!oldInfo.getPersonNo().equals(person.getPersonNo())
                || !oldInfo.getName().equals(person.getName())) {
            numeralMapper.updatePersonInfo(person.getPersonNo(), person.getName(),
                    oldInfo.getOrgNo(), oldInfo.getDepartNo(), oldInfo.getPersonNo());
        }
        return personMapper.updateById(person);
    }

    @Override
    public Person get(Long id) throws Exception {
        return personMapper.selectById(id);
    }

    @Override
    @Transactional
    public Integer delete(String ids) throws Exception {
        Arrays.asList(ids.split(",")).forEach(id -> {
            //获取图片路径
            if (StringUtils.isNoneEmpty(id)) {
                Person person = personMapper.selectById(id);
                if (person != null) {
                    personMapper.updateStateById(Long.valueOf(id), 1);
                    //删除排号信息
                    numeralMapper.updateStateByDoctorNo(person.getPersonNo(), 1);
                }
            }
        });
        return 1;
    }

    @Value("${img.location}")
    private String pathStr;

    @Override
    @Transactional
    public Long uploadFile(MultipartFile file) throws Exception {
        // 文件名
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String path = pathStr + "/person";
        FileUtils.upload(file, path, fileName);
        FileInfo f = new FileInfo();
        f.setFileName(fileName);
        f.setFileSize(file.getSize());
        f.setFileType(suffixName);
        f.setPath("/person/" + fileName);
        //根据文件名判断是否存在
        FileInfo fileInfo = fileMapper.getByName(fileName);
        Long id = 0L;
        if (fileInfo == null) {
            fileMapper.insertPK(f);
            id = f.getFileId();
        } else {
            f.setFileId(fileInfo.getFileId());
            fileMapper.updateById(f);
            id = fileInfo.getFileId();
        }
        return id;
    }

    @Override
    public Person getInfo(String personNo, String password) throws Exception {
        return personMapper.getInfo(personNo, password);
    }

    @Override
    public Integer insertByOrg(Org org) throws Exception {
        Person person = new Person();
        person.setPersonNo(org.getOrgNo());
        person.setName(org.getOrgName());
        person.setIntroduce("");
        person.setPermissions(1);
        person.setPassword(org.getOrgNo());
        person.setBirthday(new Date());
        person.setDepartNo("");
        person.setDepartName("");
        person.setIdCardNo("");
        person.setTel(org.getTel());
        person.setOrgNo(org.getOrgNo());
        person.setOrgName(org.getOrgName());
        person.setZgState(CommonLongEnums.ON_JOB.getCode());
        return personMapper.insert(person);
    }

    @Override
    public Integer updatePassword(Long id, String password) {
        return personMapper.updatePassword(id, password);
    }

    @Override
    public List<PersonBO> getDoctorList(String orgNo, String departNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("org_no", orgNo);
        map.put("depart_no", departNo);
        map.put("zg_state", CommonLongEnums.ON_JOB.getCode());
        List<Person> list = personMapper.selectByMap(map);
        List<PersonBO> personBOS = new ArrayList<>();
        list.forEach(bo -> {
            PersonBO personBO = new PersonBO();
            BeanUtils.copyProperties(bo, personBO);
            if (bo.getJxLevel() != null) {
                personBO.setJxLevelName(CommonStringEnums.getNameByCode(bo.getJxLevel().toString()));
            }
            List<String> imgPaths = new ArrayList<>();
            if (bo.getImgArray() != null && !"".equals(bo.getImgArray())) {
                Arrays.asList(bo.getImgArray().split(",")).forEach(id -> {
                    //获取图片路径
                    if (StringUtils.isNoneEmpty(id)) {
                        FileInfo file = fileMapper.getById(Long.valueOf(id));
                        if (file != null && file.getPath() != null) {
                            imgPaths.add(file.getPath());
                        }
                    }
                });
                personBO.setImgPaths(imgPaths);
            }
            personBOS.add(personBO);
        });
        return personBOS;
    }
}
