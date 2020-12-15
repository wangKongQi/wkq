package com.medcine.service.org.impl;

import com.medcine.base.entity.file.FileInfo;
import com.medcine.base.entity.org.Org;
import com.medcine.base.entity.org.OrgPageBO;
import com.medcine.base.entity.org.OrgQO;
import com.medcine.dao.*;
import com.medcine.service.org.OrgService;
import com.medcine.service.person.PersonService;
import com.medcine.utils.common.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 18:03
 */
@Service
public class OrgServiceImpl implements OrgService {

    @Resource
    private OrgMapper orgMapper;

    @Resource
    private FileMapper fileMapper;

    @Resource
    private PersonMapper personMapper;

    @Resource
    private DepartMapper departMapper;

    @Resource
    private PersonService personService;

    @Resource
    private SelfMachineMapper selfMachineMapper;

    @Resource
    private NumeralMapper numeralMapper;

    @Override
    @Cacheable(cacheNames  = "org", key= "#qo.page")
    public List<OrgPageBO> pageQuery(OrgQO qo) throws Exception {
//        PageVo<OrgPageBO> pageVo = new PageVo<OrgPageBO>().setCurrentAndSize(qo);
        List<OrgPageBO> page = orgMapper.pageQuery(qo);
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
//        pageVo.setRecords(page);
//        pageVo.setTotal(orgMapper.getCount(qo));
//        return pageVo;
        return page;
    }

    @Override
    @Cacheable(cacheNames  = "org", key= "'count_'+#qo.orgNo")
    public Integer getCount(OrgQO qo) throws Exception {
        return orgMapper.getCount(qo);
    }

    @Override
    @Transactional
    public Integer addOrg(Org org) throws Exception {
        Org data = orgMapper.selectByOrgNo(org.getOrgNo(), 0);
        if (data != null) {
            return -1;
        }
        orgMapper.insert(org);
        //生成管理员账号
        return personService.insertByOrg(org);
    }

    @Override
    @Transactional
    public Integer updateOrg(Org org) throws Exception {
        Org data = orgMapper.selectByOrgNo(org.getOrgNo(), 0);
        if (data != null && data.getId() != org.getId()) {
            return -1;
        }
        //修改所有关于机构的信息
        Org oldInfo = orgMapper.selectById(org.getId());
        if (!oldInfo.getOrgNo().equals(org.getOrgNo())
                || !oldInfo.getOrgName().equals(org.getOrgName())) {
            departMapper.updateOrgInfo(org.getOrgNo(), org.getOrgName(), oldInfo.getOrgNo());
            personMapper.updateOrgInfo(org.getOrgNo(), org.getOrgName(), oldInfo.getOrgNo());
            selfMachineMapper.updateOrgInfo(org.getOrgNo(), org.getOrgName(), oldInfo.getOrgNo());
            numeralMapper.updateOrgInfo(org.getOrgNo(), org.getOrgName(), oldInfo.getOrgNo());
        }
        return orgMapper.updateById(org);
    }

    @Override
    public Org get(Long id) throws Exception {
        return orgMapper.selectById(id);
    }

    @Override
    @Transactional
    public Integer deleteByOrgId(String ids) throws Exception {
        Arrays.asList(ids.split(",")).forEach(id -> {
            //获取图片路径
            if (StringUtils.isNoneEmpty(id)) {
                Org org = orgMapper.selectById(id);
                if (org != null) {
                    orgMapper.updateState(Long.valueOf(id), 1);
                    //删除科室
                    departMapper.updateStateByOrgNo(org.getOrgNo(), 1);
                    //删除机构管理员账号
                    personMapper.deleteByOrgNo(org.getOrgNo());
                    //删除机构自助机
                    selfMachineMapper.updateStateByOrgNo(org.getOrgNo(), 1);
                    //删除医生对应的排号信息
                    numeralMapper.updateStateByOrgNo(org.getOrgNo(), 1);
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

        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String path = pathStr + "/org";
        FileUtils.upload(file, path, fileName);

        FileInfo f = new FileInfo();
        f.setFileName(fileName);
        f.setFileSize(file.getSize());
        f.setFileType(suffixName);
        f.setPath("/org/" + fileName);

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

}
