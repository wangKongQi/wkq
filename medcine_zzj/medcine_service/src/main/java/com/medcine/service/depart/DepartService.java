package com.medcine.service.depart;

import com.medcine.base.entity.depart.Depart;
import com.medcine.base.entity.depart.DepartAndroid;
import com.medcine.base.entity.depart.DepartQO;
import com.medcine.utils.vo.PageVo;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/3 17:17
 */
public interface DepartService {

    /**
     * 分页
     *
     * @param qo
     * @author wkq
     * @date 2020/11/4 8:13
     * @return com.medcine.utils.vo.PageVo<com.medcine.base.entity.depart.Depart>
     */
    PageVo<Depart> pageByQuery(DepartQO qo) throws Exception;

    /**
     * 安卓端列表
     *
     * @param orgNo
     * @author wkq
     * @date 2020/11/24 9:26
     * @return java.util.List<com.medcine.base.entity.depart.DepartAndroid>
     */
    List<DepartAndroid> getList(String orgNo) throws Exception;


    /**
     * add
     *
     * @param depart
     * @author wkq
     * @date 2020/11/3 15:08
     * @return java.lang.Boolean
     */
    Integer add(Depart depart) throws Exception;

    /**
     * update
     *
     * @param depart
     * @author wkq
     * @date 2020/11/3 15:19
     * @return java.lang.Boolean
     */
    Integer update(Depart depart) throws Exception;

    /**
     * 查询
     *
     * @param id
     * @author wkq
     * @date 2020/11/3 16:28
     * @return com.medcine.base.entity.depart.Depart
     */
    Depart get(Long id) throws Exception;

    /**
     * 删除
     *
     * @param ids
     * @author wkq
     * @date 2020/11/3 16:34
     * @return java.lang.Integer
     */
    Integer deleteById(String ids) throws Exception;
}
