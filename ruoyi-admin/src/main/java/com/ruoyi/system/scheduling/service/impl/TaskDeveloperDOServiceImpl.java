package com.ruoyi.system.scheduling.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.scheduling.mapper.TaskDeveloperDOMapper;
import com.ruoyi.system.scheduling.domain.TaskDeveloperDO;
import com.ruoyi.system.scheduling.service.ITaskDeveloperDOService;

/**
 * 任务-开发者Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Service
public class TaskDeveloperDOServiceImpl implements ITaskDeveloperDOService 
{
    @Autowired
    private TaskDeveloperDOMapper taskDeveloperDOMapper;

    /**
     * 查询任务-开发者
     * 
     * @param id 任务-开发者主键
     * @return 任务-开发者
     */
    @Override
    public TaskDeveloperDO selectTaskDeveloperDOById(Long id)
    {
        return taskDeveloperDOMapper.selectTaskDeveloperDOById(id);
    }

    /**
     * 查询任务-开发者列表
     * 
     * @param taskDeveloperDO 任务-开发者
     * @return 任务-开发者
     */
    @Override
    public List<TaskDeveloperDO> selectTaskDeveloperDOList(TaskDeveloperDO taskDeveloperDO)
    {
        return taskDeveloperDOMapper.selectTaskDeveloperDOList(taskDeveloperDO);
    }

    /**
     * 新增任务-开发者
     * 
     * @param taskDeveloperDO 任务-开发者
     * @return 结果
     */
    @Override
    public int insertTaskDeveloperDO(TaskDeveloperDO taskDeveloperDO)
    {
        taskDeveloperDO.setCreateTime(DateUtils.getNowDate());
        return taskDeveloperDOMapper.insertTaskDeveloperDO(taskDeveloperDO);
    }

    /**
     * 修改任务-开发者
     * 
     * @param taskDeveloperDO 任务-开发者
     * @return 结果
     */
    @Override
    public int updateTaskDeveloperDO(TaskDeveloperDO taskDeveloperDO)
    {
        taskDeveloperDO.setUpdateTime(DateUtils.getNowDate());
        return taskDeveloperDOMapper.updateTaskDeveloperDO(taskDeveloperDO);
    }

    /**
     * 批量删除任务-开发者
     * 
     * @param ids 需要删除的任务-开发者主键
     * @return 结果
     */
    @Override
    public int deleteTaskDeveloperDOByIds(Long[] ids)
    {
        return taskDeveloperDOMapper.deleteTaskDeveloperDOByIds(ids);
    }

    /**
     * 删除任务-开发者信息
     * 
     * @param id 任务-开发者主键
     * @return 结果
     */
    @Override
    public int deleteTaskDeveloperDOById(Long id)
    {
        return taskDeveloperDOMapper.deleteTaskDeveloperDOById(id);
    }
}
