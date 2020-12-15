package com.medcine.controller;

import com.medcine.base.entity.org.Org;
import com.medcine.base.entity.org.OrgPageBO;
import com.medcine.base.entity.org.OrgQO;
import com.medcine.service.org.OrgService;
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
@RequestMapping("/org")
@Api(tags = "机构信息")
@CrossOrigin
public class OrgController {

    @Autowired
    private OrgService orgService;

    @ApiOperation("获取机构列表")
    @GetMapping("/page")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = Org.class)
    )
    public ResultVo pageByQuery(@Validated OrgQO qo) throws Exception {
        List<OrgPageBO> list = orgService.pageQuery(qo);
        PageVo<OrgPageBO> pageVo = new PageVo<OrgPageBO>().setCurrentAndSize(qo);
        pageVo.setRecords(list);
        pageVo.setTotal(orgService.getCount(qo));
        return ResultVoUtil.success(pageVo);
    }

    @ApiOperation("添加机构")
    @PostMapping("/add")
    public ResultVo addOrg(@Validated @RequestBody Org org) throws Exception {
        Integer n = orgService.addOrg(org);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else if (n == -1) {
            return ResultVoUtil.error("机构重复");
        } else {
            return ResultVoUtil.error(ResultEnum.ADD_ERROR);
        }
    }

    @ApiOperation("编辑机构")
    @PutMapping("/update")
    public ResultVo updateOrg(@Validated @RequestBody Org org) throws Exception {
        if (org.getId() == null || org.getId() == 0) {
            return ResultVoUtil.error("机构id不能为空");
        }
        Integer n = orgService.updateOrg(org);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else if (n == -1) {
            return ResultVoUtil.error("机构重复");
        } else {
            return ResultVoUtil.error(ResultEnum.UPDATE_ERROR);
        }
    }

    @ApiOperation("根据机构id查询")
    @GetMapping("/get")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = Org.class)
    )
    public ResultVo get(@RequestParam("id") Long id) throws Exception {
        if (orgService.get(id) != null) {
            return ResultVoUtil.success(orgService.get(id));
        } else {
            return ResultVoUtil.error(ResultEnum.GET_ERROR);
        }
    }

    @ApiOperation("根据机构id删除")
    @DeleteMapping("/delete")
    public ResultVo delete(@RequestParam(value = "ids", required = false) String ids) throws Exception {
        if (StringUtils.isEmpty(ids)) {
            return ResultVoUtil.error("请选择机构信息");
        }
        Integer n = orgService.deleteByOrgId(ids);
        if (n > 0) {
            return ResultVoUtil.success(n);
        } else {
            return ResultVoUtil.error(ResultEnum.DELETE_ERROR);
        }
    }

    @ApiOperation("图片上传")
    @PostMapping("/upload")
    public ResultVo upload(@RequestBody MultipartFile[] files) throws Exception {
        List<Long> idList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            Long id = orgService.uploadFile(files[i]);
            idList.add(id);
        }
        if (idList.size() > 0) {
            return ResultVoUtil.success(idList);
        } else {
            return ResultVoUtil.error("图片上传失败");
        }
    }

}
