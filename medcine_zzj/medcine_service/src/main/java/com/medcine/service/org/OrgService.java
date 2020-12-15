package com.medcine.service.org;

import com.medcine.base.entity.org.Org;
import com.medcine.base.entity.org.OrgPageBO;
import com.medcine.base.entity.org.OrgQO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/2 18:03
 */
public interface OrgService {

    /**
     * 列表
     *
     * @param qo
     * @author wkq
     * @date 2020/11/3 14:48
     * @return com.medcine.utils.vo.PageVo<com.medcine.base.entity.org.OrgPageBO>
     */
    List<OrgPageBO> pageQuery(OrgQO qo) throws Exception;

    Integer getCount(OrgQO qo) throws Exception;

    /**
     * add
     *
     * @param org
     * @author wkq
     * @date 2020/11/3 15:08
     * @return java.lang.Boolean
     */
    Integer addOrg(Org org) throws Exception;

    /**
     * update
     *
     * @param org
     * @author wkq
     * @date 2020/11/3 15:19
     * @return java.lang.Boolean
     */
    Integer updateOrg(Org org) throws Exception;

    /**
     * 查询
     *
     * @param id
     * @author wkq
     * @date 2020/11/3 16:28
     * @return com.medcine.base.entity.org.Org
     */
    Org get(Long id) throws Exception;

    /**
     * 根据id删除
     *
     * @param ids
     * @author wkq
     * @date 2020/11/3 16:34
     * @return java.lang.Integer
     */
    Integer deleteByOrgId(String ids) throws Exception;

    /**
     * 图片上传
     *
     * @param file
     * @author wkq
     * @date 2020/11/4 16:57
     * @return java.lang.Long
     */
    Long uploadFile(MultipartFile file) throws Exception;
}
