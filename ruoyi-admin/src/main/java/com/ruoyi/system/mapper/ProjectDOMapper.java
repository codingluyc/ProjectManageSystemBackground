package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ProjectDO;

/**
 * 项目Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
public interface ProjectDOMapper 
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
     * 删除项目
     * 
     * @param id 项目主键
     * @return 结果
     */
    public int deleteProjectDOById(Long id);

    /**
     * 批量删除项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProjectDOByIds(Long[] ids);
}
