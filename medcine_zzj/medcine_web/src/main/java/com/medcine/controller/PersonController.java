package com.medcine.controller;

import com.medcine.base.entity.person.*;
import com.medcine.service.person.PersonService;
import com.medcine.utils.common.ResultVoUtil;
import com.medcine.utils.enums.ResultEnum;
import com.medcine.utils.vo.PageVo;
import com.medcine.utils.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/3 8:32
 */
@RestController
@RequestMapping("/person")
@Api(tags = "人员信息")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonService personService;

    @ApiOperation("获取人员列表")
    @GetMapping("/page")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = PersonPageBO.class)
    )
    public ResultVo pageByQuery(@Validated PersonQO qo) throws Exception {
        PageVo<PersonPageBO> page = personService.pageQuery(qo);
        return ResultVoUtil.success(page);
    }

    @ApiOperation("添加人员信息")
    @PostMapping("/add")
    public ResultVo add(@Validated @RequestBody Person person) throws Exception {
        Integer n = personService.add(person);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else if (n == -1) {
            return ResultVoUtil.error("人员编号重复");
        } else {
            return ResultVoUtil.error(ResultEnum.ADD_ERROR);
        }
    }

    @ApiOperation("编辑人员信息")
    @PutMapping("/update")
    public ResultVo update(@Validated @RequestBody Person person) throws Exception {
        if (person.getId() == null || person.getId() == 0) {
            return ResultVoUtil.error("人员id不能为空");
        }
        Integer n = personService.update(person);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else if (n == -1) {
            return ResultVoUtil.error("人员编号重复");
        } else {
            return ResultVoUtil.error(ResultEnum.UPDATE_ERROR);
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping("/get")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = PersonPageBO.class)
    )
    public ResultVo get(@RequestParam("id") Long id) throws Exception {
        Person person = personService.get(id);
        if (person != null) {
            return ResultVoUtil.success(person);
        } else {
            return ResultVoUtil.error(ResultEnum.GET_ERROR);
        }
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("/delete")
    public ResultVo delete(@RequestParam("ids") String ids) throws Exception {
        if (StringUtils.isEmpty(ids)) {
            return ResultVoUtil.error("请选择人员信息");
        }
        Integer n = personService.delete(ids);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else {
            return ResultVoUtil.error(ResultEnum.DELETE_ERROR);
        }
    }

    @ApiOperation("图片上传")
    @PostMapping("/upload")
    public Object upload(@RequestBody MultipartFile[] files) throws Exception {
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            Long id = personService.uploadFile(files[i]);
            idList.add(id);
        }
        if (idList.size() > 0) {
            return ResultVoUtil.success(idList);
        } else {
            return ResultVoUtil.error("图片上传失败");
        }
    }

    @ApiOperation("登录信息查询")
    @GetMapping("/login")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = Person.class)
    )
    public ResultVo login(@RequestParam("personNo") String personNo, @RequestParam("password") String password) throws Exception {
        Person data = personService.getInfo(personNo, password);
        if (data != null) {
            return ResultVoUtil.success(data);
        } else {
            return ResultVoUtil.error("账号或密码错误");
        }
    }

    @ApiOperation("修改密码")
    @PutMapping("/update/password")
    public ResultVo updatePassword(@Validated @RequestBody UpdatePassWordDTO dto) throws Exception {
        Integer n = personService.updatePassword(dto.getId(), dto.getPassword());
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else {
            return ResultVoUtil.error("账号或密码错误");
        }
    }

    @ApiOperation("安卓端获取科室医生列表")
    @GetMapping("/doctor/list")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = PersonBO.class)
    )
    public ResultVo getDoctorList(@RequestParam("orgNo") String orgNo, @RequestParam("departNo") String departNo) throws Exception {
        if (StringUtils.isEmpty(orgNo)) {
            return ResultVoUtil.error("机构编号不能为空");
        }
        if (StringUtils.isEmpty(departNo)) {
            return ResultVoUtil.error("科室编号不能为空");
        }
        return ResultVoUtil.success(personService.getDoctorList(orgNo, departNo));
    }

}
