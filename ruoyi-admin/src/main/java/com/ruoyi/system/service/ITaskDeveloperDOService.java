package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TaskDeveloperDO;

/**
 * 任务-开发者Service接口
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
public interface ITaskDeveloperDOService 
{
    /**
     * 查询任务-开发者
     * 
     * @param id 任务-开发者主键
     * @return 任务-开发者
     */
    public TaskDeveloperDO selectTaskDeveloperDOById(Long id);

    /**
     * 查询任务-开发者列表
     * 
     * @param taskDeveloperDO 任务-开发者
     * @return 任务-开发者集合
     */
    public List<TaskDeveloperDO> selectTaskDeveloperDOList(TaskDeveloperDO taskDeveloperDO);

    /**
     * 新增任务-开发者
     * 
     * @param taskDeveloperDO 任务-开发者
     * @return 结果
     */
    public int insertTaskDeveloperDO(TaskDeveloperDO taskDeveloperDO);

    /**
     * 修改任务-开发者
     * 
     * @param taskDeveloperDO 任务-开发者
     * @return 结果
     */
    public int updateTaskDeveloperDO(TaskDeveloperDO taskDeveloperDO);

    /**
     * 批量删除任务-开发者
     * 
     * @param ids 需要删除的任务-开发者主键集合
     * @return 结果
     */
    public int deleteTaskDeveloperDOByIds(Long[] ids);

    /**
     * 删除任务-开发者信息
     * 
     * @param id 任务-开发者主键
     * @return 结果
     */
    public int deleteTaskDeveloperDOById(Long id);
}
