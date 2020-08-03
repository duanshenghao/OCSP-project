package com.csftgroup.ocsp.atomic.project.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csftgroup.ocsp.atomic.project.manage.entity.Project;
import com.csftgroup.ocsp.atomic.project.manage.entity.SubProject;
import com.csftgroup.ocsp.atomic.project.manage.mapper.ProjectMapper;
import com.csftgroup.ocsp.atomic.project.manage.service.ProjectManageService;
import com.csftgroup.ocsp.component.sequence.util.Sequence;
import com.csftgroup.ocsp.core.component.exception.BusinessException;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.header.ReqHeader;
import com.csftgroup.ocsp.atomic.project.manage.mapper.SubProjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectManageServiceImpl extends ServiceImpl<ProjectMapper,Project> implements ProjectManageService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private SubProjectMapper subProjectMapper;
    public List<Project> queryProjectPaging(ReqModel<Project> reqModel)throws BusinessException {
        ReqHeader header = reqModel.getHeader();
        Integer pageSize = header.getPageSize();
        Integer pageNo = header.getPageIndex();
        Page<Project> page=new Page<>(pageNo,pageSize);
        QueryWrapper<Project> wrapper = new QueryWrapper<>();
        wrapper.setEntity(reqModel.getBody());
        return projectMapper.selectPage(page,wrapper).getRecords();
    }

    public Boolean addProject(ReqModel<Project> reqModel)throws BusinessException {
        Project project = reqModel.getBody();
        project.setId(Long.parseLong(Sequence.getSequenceNo()));
        project.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        projectMapper.insert(project);
        return true;
    }

    public Boolean updateProject(ReqModel<Project> reqModel)throws BusinessException {
        Project project=reqModel.getBody();
        Long id = project.getId();
        String projectId = projectMapper.queryCount(id);
        Project wapperProject = new Project();
        wapperProject.setId(id);
        SubProject wapperSubProject = new SubProject();
        wapperSubProject.setProjectId(projectId);
        if(StringUtils.isEmpty(projectId)){
            QueryWrapper<Project> wrapper = new QueryWrapper<>();
            wrapper.setEntity(wapperProject);
            projectMapper.update(project,wrapper);
            return true;
        }else{
            SubProject subProject = new SubProject();
            subProject.setProjectId(project.getProjectId());
            QueryWrapper<SubProject> subwrapper = new QueryWrapper<>();
            subwrapper.setEntity(wapperSubProject);
            subProjectMapper.update(subProject,subwrapper);
            QueryWrapper<Project> wrapper = new QueryWrapper<>();
            wrapper.setEntity(wapperProject);
            projectMapper.update(project,wrapper);
            return true;
        }
    }

    public Boolean deleteProject(ReqModel<Project> reqModel)throws BusinessException {
        Project project=reqModel.getBody();
        Long id = project.getId();
        String projectId = projectMapper.queryCount(id);
        if(StringUtils.isEmpty(projectId)){
            QueryWrapper<Project> wrapper = new QueryWrapper<>();
            wrapper.setEntity(project);
            projectMapper.delete(wrapper);
            return true;
        }else{
            SubProject subProject = new SubProject();
            subProject.setProjectId(projectId);
            QueryWrapper<SubProject> subwrapper = new QueryWrapper<>();
            subwrapper.setEntity(subProject);
            subProjectMapper.delete(subwrapper);
            QueryWrapper<Project> wrapper = new QueryWrapper<>();
            wrapper.setEntity(project);
            projectMapper.delete(wrapper);
            return true;
        }

    }
}
