package com.medcine.service.person;

import com.medcine.base.entity.org.Org;
import com.medcine.base.entity.person.Person;
import com.medcine.base.entity.person.PersonBO;
import com.medcine.base.entity.person.PersonPageBO;
import com.medcine.base.entity.person.PersonQO;
import com.medcine.utils.vo.PageVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wkq
 * @date 2020/11/4 8:24
 */
public interface PersonService {


    /**
     * 列表
     *
     * @param qo
     * @author wkq
     * @date 2020/11/3 14:48
     * @return com.medcine.utils.vo.PageVo<com.medcine.base.entity.person.Person>
     */
    PageVo<PersonPageBO> pageQuery(PersonQO qo) throws Exception;

    /**
     * add
     *
     * @param person
     * @author wkq
     * @date 2020/11/3 15:08
     * @return java.lang.Boolean
     */
    Integer add(Person person) throws Exception;

    /**
     * update
     *
     * @param person
     * @author wkq
     * @date 2020/11/3 15:19
     * @return java.lang.Integer
     */
    Integer update(Person person) throws Exception;

    /**
     * 查询
     *
     * @param id
     * @author wkq
     * @date 2020/11/3 16:28
     * @return com.medcine.base.entity.person.Person
     */
    Person get(Long id) throws Exception;

    /**
     * 删除
     *
     * @param ids
     * @author wkq
     * @date 2020/11/3 16:34
     * @return java.lang.Integer
     */
    Integer delete(String ids) throws Exception;

    /**
     * 图片上传
     *
     * @param file
     * @author wkq
     * @date 2020/11/4 16:57
     * @return java.lang.Long
     */
    Long uploadFile(MultipartFile file) throws Exception;

    /**
     * 查询账号
     *
     * @param personNo
     * @param password
     * @author wkq
     * @date 2020/11/5 10:25
     * @return com.medcine.base.entity.person.Person
     */
    Person getInfo(String personNo, String password) throws Exception;

    /**
     * 机构创建管理员账号
     *
     * @param org
     * @author wkq
     * @date 2020/11/5 11:02
     * @return java.lang.Integer
     */
    Integer insertByOrg(Org org) throws Exception;

    /**
     * 修改密码
     *
     * @param id
     * @param password
     * @author wkq
     * @date 2020/11/25 16:16
     * @return java.lang.Integer
     */
    Integer updatePassword(Long id, String password);

    /**
     * 安卓获取科室医生信息
     *
     * @param orgNo
     * @param departNo
     * @author wkq
     * @date 2020/12/3 14:56
     * @return java.util.List<com.medcine.base.entity.person.PersonBO>
     */
    List<PersonBO> getDoctorList(String orgNo, String departNo);
}
