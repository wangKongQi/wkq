package com.medcine.service.zzj.impl;

import com.medcine.base.entity.zzj.SelfMachine;
import com.medcine.base.entity.zzj.SelfMachineQO;
import com.medcine.dao.SelfMachineMapper;
import com.medcine.service.zzj.SelfMachineService;
import com.medcine.utils.vo.PageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author wkq
 * @date 2020/11/4 9:44
 */
@Service
public class SelfMachineServiceImpl implements SelfMachineService {

    @Resource
    private SelfMachineMapper selfMachineMapper;

    @Override
    public PageVo<SelfMachine> pageQuery(SelfMachineQO qo) throws Exception {
        PageVo<SelfMachine> pageVo = new PageVo<SelfMachine>().setCurrentAndSize(qo);
        pageVo.setRecords(selfMachineMapper.pageQuery(qo));
        pageVo.setTotal(selfMachineMapper.getCount(qo));
        return pageVo;
    }

    @Override
    @Transactional
    public Integer add(SelfMachine selfMachine) throws Exception {
        SelfMachine data = selfMachineMapper.selectByOne(selfMachine.getOrgNo(), selfMachine.getMachineNo(), 0);
        if (data != null) {
            return -1;
        }
        return selfMachineMapper.insert(selfMachine);
    }

    @Override
    @Transactional
    public Integer update(SelfMachine selfMachine) throws Exception {
        SelfMachine data = selfMachineMapper.selectByOne(selfMachine.getOrgNo(), selfMachine.getMachineNo(), 0);
        if (data != null && data.getId() != data.getId()) {
            return -1;
        }
        return selfMachineMapper.updateById(selfMachine);
    }

    @Override
    public SelfMachine get(Long id) throws Exception {
        return selfMachineMapper.selectById(id);
    }

    @Override
    @Transactional
    public Integer delete(String ids) throws Exception {
        Arrays.asList(ids.split(",")).forEach(id -> {
            if (StringUtils.isNoneEmpty(id)) {
                selfMachineMapper.updateStateById(Long.valueOf(id), 1);
            }
        });
        return 1;
    }
}
