package com.medcine.controller;

import com.medcine.base.entity.code.BasyWjtCodeDic;
import com.medcine.service.code.BaseCodeService;
import com.medcine.utils.common.ResultVoUtil;
import com.medcine.utils.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkq
 * @date 2020/11/5 9:57
 */
@RestController
@RequestMapping("/base/code")
@Api(tags = "字典")
@CrossOrigin
public class BaseCodeController {

    @Resource
    private BaseCodeService baseCodeService;

    @ApiOperation("科室字典列表")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = BasyWjtCodeDic.class)
    )
    @GetMapping("/ks")
    public ResultVo selectByList() throws Exception {
        List<BasyWjtCodeDic> list = baseCodeService.selectByList("科室分类", "");
        return ResultVoUtil.success(list);
    }
}
