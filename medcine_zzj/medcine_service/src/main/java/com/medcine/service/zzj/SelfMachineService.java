package com.medcine.service.zzj;

import com.medcine.base.entity.zzj.SelfMachine;
import com.medcine.base.entity.zzj.SelfMachineQO;
import com.medcine.utils.vo.PageVo;

/**
 * @author wkq
 * @date 2020/11/4 9:44
 */
public interface SelfMachineService {

    /**
     * 列表
     *
     * @param qo
     * @author wkq
     * @date 2020/11/3 14:48
     * @return com.medcine.utils.vo.PageVo<com.medcine.base.entity.zzj.SelfMachine>
     */
    PageVo<SelfMachine> pageQuery(SelfMachineQO qo) throws Exception;

    /**
     * add
     *
     * @param selfMachine
     * @author wkq
     * @date 2020/11/3 15:08
     * @return java.lang.Boolean
     */
    Integer add(SelfMachine selfMachine) throws Exception;

    /**
     * update
     *
     * @param selfMachine
     * @author wkq
     * @date 2020/11/3 15:19
     * @return java.lang.Integer
     */
    Integer update(SelfMachine selfMachine) throws Exception;

    /**
     * 查询
     *
     * @param id
     * @author wkq
     * @date 2020/11/3 16:28
     * @return com.medcine.base.entity.zzj.SelfMachine
     */
    SelfMachine get(Long id) throws Exception;

    /**
     * 删除
     *
     * @param ids
     * @author wkq
     * @date 2020/11/3 16:34
     * @return java.lang.Integer
     */
    Integer delete(String ids) throws Exception;
}
