package com.medcine.controller;

import com.medcine.base.entity.depart.Depart;
import com.medcine.base.entity.depart.DepartAndroid;
import com.medcine.base.entity.depart.DepartQO;
import com.medcine.service.depart.DepartService;
import com.medcine.utils.common.ResultVoUtil;
import com.medcine.utils.enums.ResultEnum;
import com.medcine.utils.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author wkq
 * @date 2020/11/3 8:32
 */
@RestController
@RequestMapping("/depart")
@Api(tags = "科室信息")
@CrossOrigin
public class DepartController {

    @Autowired
    private DepartService departService;

    @ApiOperation("后台管理科室列表")
    @GetMapping("/page/web")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = Depart.class)
    )
    public ResultVo pageWeb(@Validated DepartQO qo) throws Exception {
        return ResultVoUtil.success(departService.pageByQuery(qo));
    }

    @ApiOperation("安卓端科室列表")
    @GetMapping("/page/android")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = DepartAndroid.class)
    )
    public ResultVo pageAndroid(@RequestParam("orgNo") String orgNo) throws Exception {
        return ResultVoUtil.success(departService.getList(orgNo));
    }

    @ApiOperation("添加科室")
    @PostMapping("/add")
    public ResultVo add(@Validated @RequestBody Depart depart) throws Exception {
        Integer n = departService.add(depart);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else if (n == -1) {
            return ResultVoUtil.error("科室重复");
        } else {
            return ResultVoUtil.error(ResultEnum.ADD_ERROR);
        }
    }

    @ApiOperation("编辑科室")
    @PutMapping("/update")
    public ResultVo update(@Validated @RequestBody Depart depart) throws Exception {
        if (depart.getId() == null || depart.getId() == 0) {
            return ResultVoUtil.error("科室id不能为空");
        }
        Integer n = departService.update(depart);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else if (n == -1) {
            return ResultVoUtil.error("科室重复");
        } else {
            return ResultVoUtil.error(ResultEnum.UPDATE_ERROR);
        }
    }

    @ApiOperation("根据科室编码查询")
    @GetMapping("/get")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = Depart.class)
    )
    public ResultVo get(@RequestParam("id") Long id) throws Exception {
        if (departService.get(id) != null) {
            return ResultVoUtil.success(departService.get(id));
        } else {
            return ResultVoUtil.error(ResultEnum.GET_ERROR);
        }
    }

    @ApiOperation("根据科室编码删除")
    @DeleteMapping("/delete")
    public ResultVo delete(@RequestParam("ids") String ids) throws Exception {
        if (StringUtils.isEmpty(ids)) {
            return ResultVoUtil.error("请选择科室信息");
        }
        Integer n = departService.deleteById(ids);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else {
            return ResultVoUtil.error(ResultEnum.DELETE_ERROR);
        }
    }

}
