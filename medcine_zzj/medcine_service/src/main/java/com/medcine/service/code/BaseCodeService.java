package com.medcine.service.code;

import com.medcine.base.entity.code.BasyWjtCodeDic;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/5 9:51
 */
public interface BaseCodeService {

    /**
     * 科室字典
     *
     * @param type
     * @param parentCode
     * @author wkq
     * @date 2020/11/5 9:54
     * @return java.util.List<com.medcine.base.entity.code.BasyWjtCodeDic>
     */
    List<BasyWjtCodeDic> selectByList(String type, String parentCode) throws Exception;
}
