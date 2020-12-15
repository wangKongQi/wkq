package com.medcine.controller;/**
 * @author wkq
 * @date 2020/11/4 15:16
 */

import com.medcine.base.entity.num.DoctorBO;
import com.medcine.base.entity.num.Numeral;
import com.medcine.base.entity.num.NumeralPageQO;
import com.medcine.base.entity.num.NumeralQO;
import com.medcine.service.num.NumeralService;
import com.medcine.utils.common.ResultVoUtil;
import com.medcine.utils.enums.ResultEnum;
import com.medcine.utils.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wkq
 * @date 2020/11/4 15:16
 */
@RestController
@RequestMapping("/num")
@Api(tags = "排号信息")
@CrossOrigin
public class NumeralController {
    @Resource
    private NumeralService numeralService;

    @ApiOperation("查询医生/科室当天排号")
    @GetMapping("/get")
    public ResultVo getNum(NumeralQO qo) throws Exception {
        return ResultVoUtil.success(numeralService.getNum(qo));
    }

    @ApiOperation("添加排号")
    @PostMapping("/add")
    public ResultVo addOrg(@Validated @RequestBody Numeral numeral) throws Exception {
        if (numeralService.add(numeral) > 0) {
            return ResultVoUtil.success(numeralService.add(numeral));
        } else {
            return ResultVoUtil.error(ResultEnum.ADD_ERROR);
        }
    }

    @ApiOperation("获取排号信息列表")
    @GetMapping("/page")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = Numeral.class)
    )
    public ResultVo pageByQuery(@Validated NumeralPageQO qo) throws Exception {
        return ResultVoUtil.success(numeralService.pageQuery(qo));
    }

    @ApiOperation("获取科室医生字典")
    @GetMapping("/doctor/list")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = DoctorBO.class)
    )
    public ResultVo getDoctorList(@RequestParam("orgNo") String orgNo, @RequestParam("departNo") String departNo) throws Exception {
        if (StringUtils.isEmpty(orgNo)) {
            return ResultVoUtil.error("机构编号不能为空");
        }
        if (StringUtils.isEmpty(departNo)) {
            return ResultVoUtil.error("科室编号不能为空");
        }
        return ResultVoUtil.success(numeralService.getDoctorList(orgNo, departNo));
    }
}
