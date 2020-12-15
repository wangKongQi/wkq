package com.medcine.controller;

import com.medcine.base.entity.zzj.SelfMachine;
import com.medcine.base.entity.zzj.SelfMachineQO;
import com.medcine.service.zzj.SelfMachineService;
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
@RequestMapping("/self/machine")
@Api(tags = "自助机信息")
@CrossOrigin
public class SelfMachineController {

    @Autowired
    private SelfMachineService selfMachineService;

    @ApiOperation("获取自助机列表")
    @GetMapping("/page")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = SelfMachine.class)
    )
    public ResultVo pageByQuery(@Validated SelfMachineQO qo) throws Exception {
        return ResultVoUtil.success(selfMachineService.pageQuery(qo));
    }

    @ApiOperation("添加自助机信息")
    @PostMapping("/add")
    public ResultVo add(@Validated @RequestBody SelfMachine selfMachine) throws Exception {
        Integer n = selfMachineService.add(selfMachine);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else if (n == -1) {
            return ResultVoUtil.error("自助机编号重复");
        } else {
            return ResultVoUtil.error(ResultEnum.ADD_ERROR);
        }
    }

    @ApiOperation("编辑自助机信息")
    @PutMapping("/update")
    public ResultVo update(@Validated @RequestBody SelfMachine selfMachine) throws Exception {
        if (selfMachine.getId() == null || selfMachine.getId() == 0) {
            return ResultVoUtil.error("人员id不能为空");
        }
        Integer n = selfMachineService.update(selfMachine);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else if (n == -1) {
            return ResultVoUtil.error("自助机编号重复");
        } else {
            return ResultVoUtil.error(ResultEnum.UPDATE_ERROR);
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping("/get")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = SelfMachine.class)
    )
    public ResultVo get(@RequestParam("id") Long id) throws Exception {
        if (selfMachineService.get(id) != null) {
            return ResultVoUtil.success(selfMachineService.get(id));
        } else {
            return ResultVoUtil.error(ResultEnum.GET_ERROR);
        }
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("/delete")
    public ResultVo delete(@RequestParam("ids") String ids) throws Exception {
        if (StringUtils.isEmpty(ids)) {
            return ResultVoUtil.error("请选择自助机信息");
        }
        Integer n = selfMachineService.delete(ids);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else {
            return ResultVoUtil.error(ResultEnum.DELETE_ERROR);
        }
    }

}
