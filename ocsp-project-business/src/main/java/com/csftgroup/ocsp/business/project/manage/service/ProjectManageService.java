package com.csftgroup.ocsp.business.project.manage.service;

import com.csftgroup.ocsp.business.project.manage.endpoint.ProjectManageClient;
import com.csftgroup.ocsp.business.project.manage.model.Project;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.RspModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProjectManageService {

    @Resource
    private ProjectManageClient projectManageClient;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RspModel queryProjectPaging(ReqModel<Project> reqModel) throws Exception{
        try {
            return projectManageClient.queryProjectPaging(reqModel);
        } catch (Exception e) {
            logger.error("err",e);
            throw e;
        }
    }

    public RspModel addProject(ReqModel<Project> reqModel) throws Exception{
        try {
            return projectManageClient.addProject(reqModel);
        } catch (Exception e) {
            logger.error("err",e);
            throw e;
        }
    }

    public RspModel updateProject(ReqModel<Project> reqModel) throws Exception{
        try {
            return projectManageClient.updateProject(reqModel);
        } catch (Exception e) {
            logger.error("err",e);
            throw e;
        }
    }

    public RspModel deleteProject(ReqModel<Project> reqModel) throws Exception{
        try {
            return projectManageClient.deleteProject(reqModel);
        } catch (Exception e) {
            logger.error("err",e);
            throw e;
        }
    }
}
