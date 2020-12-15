package com.medcine.service.depart.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.medcine.base.entity.depart.Depart;
import com.medcine.base.entity.depart.DepartAndroid;
import com.medcine.base.entity.depart.DepartAndroidBO;
import com.medcine.base.entity.depart.DepartQO;
import com.medcine.dao.DepartMapper;
import com.medcine.dao.NumeralMapper;
import com.medcine.dao.PersonMapper;
import com.medcine.service.depart.DepartService;
import com.medcine.utils.enums.CommonLongEnums;
import com.medcine.utils.vo.PageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/3 17:17
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Resource
    private DepartMapper departMapper;

    @Resource
    private PersonMapper personMapper;

    @Resource
    private NumeralMapper numeralMapper;

    @Override
    public PageVo<Depart> pageByQuery(DepartQO qo) throws Exception {
        PageVo<Depart> page = new PageVo<Depart>().setCurrentAndSize(qo);
        page.setRecords(departMapper.pageByQuery(qo));
        page.setTotal(departMapper.getCount(qo));
        return page;
    }

    @Override
    public List<DepartAndroid> getList(String orgNo) throws Exception {
        List<DepartAndroid> list = departMapper.getList(orgNo, CommonLongEnums.CATEGORY_100401.getCode());
        list.forEach(bo -> {
            List<DepartAndroidBO> bos = departMapper.getByClassify(orgNo, bo.getCategoryCode(), bo.getClassifyCode());
            if (CollectionUtils.isNotEmpty(bos)) {
                bo.setDeparts(bos);
            }
        });
        return list;
    }

    @Override
    @Transactional
    public Integer add(Depart depart) throws Exception {
        Depart data = departMapper.selectByOne(depart.getOrgNo(), depart.getDepartNo(), 0);
        if (data != null) {
            return -1;
        }
        return departMapper.insert(depart);
    }

    @Override
    @Transactional
    public Integer update(Depart depart) throws Exception {
        Depart departData = departMapper.selectByOne(depart.getOrgNo(), depart.getDepartNo(), 0);
        if (departData != null && departData.getId() != depart.getId()) {
            return -1;
        }
        //编辑科室相关联的信息
        Depart oldInfo = departMapper.selectById(depart.getId());
        if (!oldInfo.getDepartNo().equals(depart.getDepartNo())
                || !oldInfo.getDepartName().equals(depart.getDepartName())) {
            personMapper.updateDepartInfo(depart.getDepartNo(), depart.getDepartName(), oldInfo.getDepartNo(), oldInfo.getOrgNo());
            numeralMapper.updateDepartInfo(depart.getDepartNo(), depart.getDepartName(), oldInfo.getDepartNo(), oldInfo.getOrgNo());
        }
        return departMapper.updateById(depart);
    }

    @Override
    public Depart get(Long id) throws Exception {
        return departMapper.selectById(id);
    }

    @Override
    @Transactional
    public Integer deleteById(String ids) throws Exception {
        Arrays.asList(ids.split(",")).forEach(id -> {
            //获取图片路径
            if (StringUtils.isNoneEmpty(id)) {
                Depart depart = departMapper.selectById(Long.valueOf(id));
                if (depart != null) {
                    departMapper.updateStateById(depart.getId(), 1);
                    //删除科室对应的人员信息
                    personMapper.updateStateByDepartNo(depart.getDepartNo(), 1);
                    //删除医生对应的排号信息
                    numeralMapper.updateStateByDepartNo(depart.getDepartNo(), 1);
                }
            }
        });
        return 1;
    }
}
