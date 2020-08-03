package com.csftgroup.ocsp.atomic.project.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csftgroup.ocsp.component.sequence.util.Sequence;
import com.csftgroup.ocsp.core.component.exception.BusinessException;
import com.csftgroup.ocsp.core.component.model.ReqModel;
import com.csftgroup.ocsp.core.component.model.header.ReqHeader;
import com.csftgroup.ocsp.atomic.project.manage.entity.SubProject;
import com.csftgroup.ocsp.atomic.project.manage.mapper.SubProjectMapper;
import com.csftgroup.ocsp.atomic.project.manage.service.SubProjectManegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SubProjectManageServiceImpl extends ServiceImpl<SubProjectMapper,SubProject> implements SubProjectManegeService {
    @Autowired
    private SubProjectMapper subProjectMappers;

    public List<SubProject> querySubProjectPaging(ReqModel<SubProject> reqModel) throws BusinessException {
        ReqHeader header = reqModel.getHeader();
        Integer pageSize = header.getPageSize();
        Integer pageNo = header.getPageIndex();
        IPage<SubProject> page=new Page<>(pageNo,pageSize);
        QueryWrapper<SubProject> wrapper = new QueryWrapper<>();
        wrapper.setEntity(reqModel.getBody());
        return subProjectMappers.selectPage(page,wrapper).getRecords();
    }

    public Boolean addSubProject(ReqModel<SubProject> reqModel)throws BusinessException {
        SubProject subProject = reqModel.getBody();
        subProject.setId(Long.parseLong(Sequence.getSequenceNo()));
        subProject.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        subProjectMappers.insert(subProject);
        return true;
    }

    public Boolean updateSubProject(ReqModel<SubProject> reqModel)throws BusinessException {
        SubProject subProject = reqModel.getBody();
        subProject.setLstModiTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        SubProject wapperSubProject = new SubProject();
        wapperSubProject.setId(subProject.getId());
        QueryWrapper<SubProject> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(wapperSubProject);
        subProjectMappers.update(subProject,queryWrapper);
        return true;
    }

    public Boolean deleteSubProject(ReqModel<SubProject> reqModel)throws BusinessException {
        SubProject subProject = reqModel.getBody();
        QueryWrapper<SubProject> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(subProject);
        subProjectMappers.delete(queryWrapper);
        return true;
    }
}
