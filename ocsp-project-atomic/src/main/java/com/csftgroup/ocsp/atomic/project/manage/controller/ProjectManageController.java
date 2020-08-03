package com.csftgroup.ocsp.atomic.project.manage.controller;

import com.csftgroup.ocsp.atomic.project.manage.entity.Project;
import com.csftgroup.ocsp.atomic.project.manage.service.ProjectManageService;
import com.csftgroup.ocsp.atomic.project.manage.service.impl.ProjectManageServiceImpl;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.RspModel;
import com.csftgroup.ocsp.core.component.model.header.ReqHeader;
import com.csftgroup.ocsp.core.component.model.header.RspHeader;
import com.csftgroup.ocsp.atomic.project.manage.utils.RspDataBind;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projectManage")
@Api(tags ="项目管理-微服务层")
public class ProjectManageController {

    @Autowired
    private ProjectManageServiceImpl projectManegeService;

    @Autowired
    private RspDataBind rspDataBind;

    /**
     * 查询所有
     * @return
     */
    @PostMapping("/queryProjectPaging")
    @ApiOperation(value = "查询所有项目",notes = "分页查询")
    public RspModel queryProjectPaging(@RequestBody @Validated ReqModel<Project> reqModel) {
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.buildHeaderAndEmptyBody();

        try {
            List<Project> list = projectManegeService.queryProjectPaging(reqModel);
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
    @PostMapping("/addProject")
    @ApiOperation(value = "新增项目",notes = "新增项目")
    public RspModel addProject(@RequestBody @Validated ReqModel<Project> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try {
            Project project = reqModel.getBody();
            Boolean flag = projectManegeService.addProject(reqModel);
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
    @PostMapping("/updateProject")
    @ApiOperation(value = "修改项目",notes = "修改项目")
    public RspModel updateProject(@RequestBody @Validated ReqModel<Project> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{

            Boolean flag =  projectManegeService.updateProject(reqModel);

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
    @PostMapping("/deleteProject")
    @ApiOperation(value = "删除项目",notes = "删除项目")
    public RspModel deleteProject(@RequestBody @Validated ReqModel<Project> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            Map result = new HashMap();
            result.put("flag",projectManegeService.deleteProject(reqModel));
            rspModel.setBody(result);
            return rspDataBind.setRspModelSuccess(reqHeader,rspModel);

        }catch (Exception e){
            return rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }
}
