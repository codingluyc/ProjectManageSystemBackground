package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ProjectDO;

/**
 * 项目Service接口
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
public interface IProjectDOService 
{
    /**
     * 查询项目
     * 
     * @param id 项目主键
     * @return 项目
     */
    public ProjectDO selectProjectDOById(Long id);

    /**
     * 查询项目列表
     * 
     * @param projectDO 项目
     * @return 项目集合
     */
    public List<ProjectDO> selectProjectDOList(ProjectDO projectDO);

    /**
     * 新增项目
     * 
     * @param projectDO 项目
     * @return 结果
     */
    public int insertProjectDO(ProjectDO projectDO);

    /**
     * 修改项目
     * 
     * @param projectDO 项目
     * @return 结果
     */
    public int updateProjectDO(ProjectDO projectDO);

    /**
     * 批量删除项目
     * 
     * @param ids 需要删除的项目主键集合
     * @return 结果
     */
    public int deleteProjectDOByIds(Long[] ids);

    /**
     * 删除项目信息
     * 
     * @param id 项目主键
     * @return 结果
     */
    public int deleteProjectDOById(Long id);
}
