package com.medcine.service.num;

import com.medcine.base.entity.num.DoctorBO;
import com.medcine.base.entity.num.Numeral;
import com.medcine.base.entity.num.NumeralPageQO;
import com.medcine.base.entity.num.NumeralQO;
import com.medcine.utils.vo.PageVo;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/4 14:38
 */
public interface NumeralService {

    /**
     * 新增排号
     *
     * @param numeral
     * @return java.lang.Integer
     * @author wkq
     * @date 2020/11/4 14:49
     */
    Integer add(Numeral numeral) throws Exception;

    /**
     * 获取今天当前号
     *
     * @param qo
     * @author wkq
     * @date 2020/11/4 15:00
     * @return java.lang.Integer
     */
    Integer getNum(NumeralQO qo) throws Exception;

    /**
     * 排号信息分页
     *
     * @param qo
     * @author wkq
     * @date 2020/12/1 14:42
     * @return com.medcine.utils.vo.PageVo<com.medcine.base.entity.num.Numeral>
     */
    PageVo<Numeral> pageQuery(NumeralPageQO qo) throws Exception;

    /**
     * 获取科室下医生列表
     *
     * @param orgNo
     * @param departNo
     * @author wkq
     * @date 2020/12/2 8:55
     * @return java.util.List<com.medcine.base.entity.num.DoctorBO>
     */
    List<DoctorBO> getDoctorList(String orgNo, String departNo);
}
