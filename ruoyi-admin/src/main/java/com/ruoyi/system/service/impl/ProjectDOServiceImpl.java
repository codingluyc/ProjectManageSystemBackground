package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProjectDOMapper;
import com.ruoyi.system.domain.ProjectDO;
import com.ruoyi.system.service.IProjectDOService;

/**
 * 项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Service
public class ProjectDOServiceImpl implements IProjectDOService 
{
    @Autowired
    private ProjectDOMapper projectDOMapper;

    /**
     * 查询项目
     * 
     * @param id 项目主键
     * @return 项目
     */
    @Override
    public ProjectDO selectProjectDOById(Long id)
    {
        return projectDOMapper.selectProjectDOById(id);
    }

    /**
     * 查询项目列表
     * 
     * @param projectDO 项目
     * @return 项目
     */
    @Override
    public List<ProjectDO> selectProjectDOList(ProjectDO projectDO)
    {
        return projectDOMapper.selectProjectDOList(projectDO);
    }

    /**
     * 新增项目
     * 
     * @param projectDO 项目
     * @return 结果
     */
    @Override
    public int insertProjectDO(ProjectDO projectDO)
    {
        projectDO.setCreateTime(DateUtils.getNowDate());
        return projectDOMapper.insertProjectDO(projectDO);
    }

    /**
     * 修改项目
     * 
     * @param projectDO 项目
     * @return 结果
     */
    @Override
    public int updateProjectDO(ProjectDO projectDO)
    {
        projectDO.setUpdateTime(DateUtils.getNowDate());
        return projectDOMapper.updateProjectDO(projectDO);
    }

    /**
     * 批量删除项目
     * 
     * @param ids 需要删除的项目主键
     * @return 结果
     */
    @Override
    public int deleteProjectDOByIds(Long[] ids)
    {
        return projectDOMapper.deleteProjectDOByIds(ids);
    }

    /**
     * 删除项目信息
     * 
     * @param id 项目主键
     * @return 结果
     */
    @Override
    public int deleteProjectDOById(Long id)
    {
        return projectDOMapper.deleteProjectDOById(id);
    }
}
