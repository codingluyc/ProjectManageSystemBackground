package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TaskDO;

/**
 * 任务Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
public interface TaskDOMapper 
{
    /**
     * 查询任务
     * 
     * @param id 任务主键
     * @return 任务
     */
    public TaskDO selectTaskDOById(Long id);

    /**
     * 查询任务列表
     * 
     * @param taskDO 任务
     * @return 任务集合
     */
    public List<TaskDO> selectTaskDOList(TaskDO taskDO);

    /**
     * 新增任务
     * 
     * @param taskDO 任务
     * @return 结果
     */
    public int insertTaskDO(TaskDO taskDO);

    /**
     * 修改任务
     * 
     * @param taskDO 任务
     * @return 结果
     */
    public int updateTaskDO(TaskDO taskDO);

    /**
     * 删除任务
     * 
     * @param id 任务主键
     * @return 结果
     */
    public int deleteTaskDOById(Long id);

    /**
     * 批量删除任务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTaskDOByIds(Long[] ids);
}
