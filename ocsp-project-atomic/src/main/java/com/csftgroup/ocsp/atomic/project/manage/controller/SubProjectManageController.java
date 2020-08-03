package com.csftgroup.ocsp.atomic.project.manage.controller;

import com.csftgroup.ocsp.atomic.project.manage.service.impl.SubProjectManageServiceImpl;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.RspModel;
import com.csftgroup.ocsp.core.component.model.header.ReqHeader;
import com.csftgroup.ocsp.core.component.model.header.RspHeader;
import com.csftgroup.ocsp.atomic.project.manage.entity.SubProject;
import com.csftgroup.ocsp.atomic.project.manage.utils.RspDataBind;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/subProjectManage")
@RestController
@Api(tags ="子项目管理-微服务层")
public class SubProjectManageController {
    @Autowired
    private SubProjectManageServiceImpl subProjectManageService;
    @Autowired
    private RspDataBind rspDataBind;
    /**
     * 查询所有
     * @return
     */
    @PostMapping("/querySubProjectPaging")
    @ApiOperation(value = "查询所有子项目",notes = "分页查询")
    public RspModel<SubProject> querySubProjectPaging(@RequestBody @Validated ReqModel<SubProject> reqModel) {
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.buildHeaderAndEmptyBody();

        try {
            List<SubProject> list = subProjectManageService.querySubProjectPaging(reqModel);
            RspHeader rspHeader =  rspModel.getHeader();
            rspHeader.setTotalNum(list.size());
            rspModel.setBody(list);
            return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
        } catch (Exception e) {
            return rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 新增
     * @return
     */
    @PostMapping("/addSubProject")
    @ApiOperation(value = "新增子项目",notes = "新增子项目")
    public RspModel addSubProject(@RequestBody @Validated ReqModel<SubProject> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try {
            SubProject project = reqModel.getBody();
            Boolean flag = subProjectManageService.addSubProject(reqModel);
            Map result = new HashMap();
            result.put("flag",flag);
            rspModel.setBody(result);
            return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
        } catch (Exception e) {
            return rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 修改
     * @return
     */
    @PostMapping("/updateSubProject")
    @ApiOperation(value = "修改子项目",notes = "修改子项目")
    public RspModel updateSubProject(@RequestBody @Validated ReqModel<SubProject> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{

            Boolean flag =  subProjectManageService.updateSubProject(reqModel);

            Map result = new HashMap();
            result.put("flag",flag);
            rspModel.setBody(result);
            return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
        }catch (Exception e){
            return rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 删除
     * @return
     */
    @PostMapping("/deleteSubProject")
    @ApiOperation(value = "删除子项目",notes = "删除子项目")
    public RspModel deleteSubProject(@RequestBody @Validated ReqModel<SubProject> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            Map result = new HashMap();
            result.put("flag",subProjectManageService.deleteSubProject(reqModel));
            rspModel.setBody(result);
            return rspDataBind.setRspModelSuccess(reqHeader,rspModel);

        }catch (Exception e){
            return rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }
}
