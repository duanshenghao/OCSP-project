package com.csftgroup.ocsp.atomic.project.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csftgroup.ocsp.atomic.project.manage.entity.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMapper extends BaseMapper<Project> {
    String queryCount(Long id);
}
