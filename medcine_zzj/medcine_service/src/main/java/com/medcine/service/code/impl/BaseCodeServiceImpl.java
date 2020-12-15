package com.medcine.service.code.impl;

import com.medcine.base.entity.code.BasyWjtCodeDic;
import com.medcine.dao.BasyWjtCodeDicMapper;
import com.medcine.service.code.BaseCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/5 9:51
 */
@Service
public class BaseCodeServiceImpl implements BaseCodeService {

    @Resource
    private BasyWjtCodeDicMapper basyWjtCodeDicMapper;

    @Override
    public List<BasyWjtCodeDic> selectByList(String type, String parentCode) throws Exception {
        return basyWjtCodeDicMapper.selectByList(type, parentCode);
    }
}
