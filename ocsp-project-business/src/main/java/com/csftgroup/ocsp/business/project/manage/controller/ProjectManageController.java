package com.csftgroup.ocsp.business.project.manage.controller;

import com.csftgroup.ocsp.business.project.manage.model.Project;
import com.csftgroup.ocsp.business.project.manage.service.ProjectManageService;
import com.csftgroup.ocsp.core.component.code.ErrorEnum;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.RspModel;
import com.csftgroup.ocsp.core.component.model.header.ReqHeader;
import com.csftgroup.ocsp.core.component.model.header.RspHeader;
import com.csftgroup.ocsp.business.project.manage.utils.RspDataBind;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/projectManage")
@Api(tags ="项目管理-业务层")
public class ProjectManageController {

    @Autowired
    private ProjectManageService projectManageService;

    @Autowired
    private RspDataBind rspDataBind;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 查询所有
     * @return
     */
    @PostMapping("/queryProjectPaging")
    @ApiOperation(value = "查询所有项目",notes = "分页查询")
    public RspModel queryProjectPaging(@RequestBody @Valid ReqModel<Project> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            RspModel rspModel1 =  projectManageService.queryProjectPaging(reqModel);
            RspHeader rspHeader  = rspModel1.getHeader();
            if(ErrorEnum.OCSP_SUCCESS.getCode().equals(rspHeader.getRspCode())){//成功
                rspModel.setBody(rspModel1.getBody());
                rspModel.getHeader().setTotalNum(rspHeader.getTotalNum());
                return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
            }else{
                return rspDataBind.setRspModelFail(reqHeader,rspModel,rspHeader);
            }
        }catch (Exception e){
            logger.error("err",e);
            return  rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 新增
     * @return
     */
    @PostMapping("/addProject")
    @ApiOperation(value = "新增项目",notes = "新增项目")
    public RspModel addProject(@RequestBody @Valid ReqModel<Project> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            RspModel rspModel1 =  projectManageService.addProject(reqModel);
            RspHeader rspHeader  = rspModel1.getHeader();
            if(ErrorEnum.OCSP_SUCCESS.getCode().equals(rspHeader.getRspCode())){//成功
                rspModel.setBody(rspModel1.getBody());
                rspModel.getHeader().setTotalNum(rspHeader.getTotalNum());
                return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
            }else{
                return rspDataBind.setRspModelFail(reqHeader,rspModel,rspHeader);
            }
        }catch (Exception e){
            logger.error("err",e);
            return  rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 修改
     * @return
     */
    @PostMapping("/updateProject")
    @ApiOperation(value = "修改项目",notes = "修改项目")
    public RspModel updateProject(@RequestBody @Valid ReqModel<Project> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            RspModel rspModel1 =  projectManageService.updateProject(reqModel);
            RspHeader rspHeader  = rspModel1.getHeader();
            if(ErrorEnum.OCSP_SUCCESS.getCode().equals(rspHeader.getRspCode())){//成功
                rspModel.setBody(rspModel1.getBody());
                rspModel.getHeader().setTotalNum(rspHeader.getTotalNum());
                return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
            }else{
                return rspDataBind.setRspModelFail(reqHeader,rspModel,rspHeader);
            }
        }catch (Exception e){
            logger.error("err",e);
            return  rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }

    /**
     * 删除
     * @return
     */
    @PostMapping("/deleteProject")
    @ApiOperation(value = "删除项目",notes = "删除项目")
    public RspModel deleteProject(@RequestBody @Valid ReqModel<Project> reqModel){
        ReqHeader reqHeader = reqModel.getHeader();
        RspModel rspModel = new RspModel();
        rspModel.setHeader(new RspHeader());
        try{
            RspModel rspModel1 =  projectManageService.deleteProject(reqModel);
            RspHeader rspHeader  = rspModel1.getHeader();
            if(ErrorEnum.OCSP_SUCCESS.getCode().equals(rspHeader.getRspCode())){//成功
                rspModel.setBody(rspModel1.getBody());
                rspModel.getHeader().setTotalNum(rspHeader.getTotalNum());
                return rspDataBind.setRspModelSuccess(reqHeader,rspModel);
            }else{
                return rspDataBind.setRspModelFail(reqHeader,rspModel,rspHeader);
            }
        }catch (Exception e){
            logger.error("err",e);
            return  rspDataBind.setRspModelFail(reqHeader,rspModel,e);
        }
    }
}
