package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.ModuleDeveloperDO;
import com.ruoyi.system.domain.TaskDeveloperDO;
import com.ruoyi.system.mapper.ModuleDeveloperDOMapper;
import com.ruoyi.system.mapper.TaskDeveloperDOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TaskDOMapper;
import com.ruoyi.system.domain.TaskDO;
import com.ruoyi.system.service.ITaskDOService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Service
public class TaskDOServiceImpl implements ITaskDOService 
{
    @Autowired
    private TaskDOMapper taskDOMapper;

    @Resource
    TaskDeveloperDOMapper taskDeveloperDOMapper;
    @Resource
    ModuleDeveloperDOMapper moduleDeveloperDOMapper;

    /**
     * 查询任务
     * 
     * @param id 任务主键
     * @return 任务
     */
    @Override
    public TaskDO selectTaskDOById(Long id)
    {
        return taskDOMapper.selectTaskDOById(id);
    }

    /**
     * 查询任务列表
     * 
     * @param taskDO 任务
     * @return 任务
     */
    @Override
    public List<TaskDO> selectTaskDOList(TaskDO taskDO)
    {
        return taskDOMapper.selectTaskDOList(taskDO);
    }

    /**
     * 新增任务
     * 
     * @param taskDO 任务
     * @return 结果
     */
    @Override
    @Transactional
    public int insertTaskDO(TaskDO taskDO)
    {
        int result;
        taskDO.setCreateTime(DateUtils.getNowDate());
        if(taskDO.getModuleIds() == null || taskDO.getModuleIds().length < 2){
            if( taskDO.getModuleIds().length < 2 && taskDO.getModuleIds().length > 0){
                taskDO.setModuleId(taskDO.getModuleIds()[0]);
            }
            result = taskDOMapper.insertTaskDO(taskDO);
            if(taskDO.getAuto() == 1){
                // 自动任务
                division(taskDO);
            }
        }else{
            List<TaskDO> taskList = new ArrayList<>(taskDO.getModuleIds().length);
            for(Long moduleId : taskDO.getModuleIds()){
                TaskDO d = new TaskDO();
                BeanUtils.copyProperties(taskDO,d);
                d.setModuleId(moduleId);
                taskList.add(d);
            }
            result = taskDOMapper.insertTaskDOByBatch(taskList);
            if(taskDO.getAuto() == 1){
                // 自动任务
                division(taskList);
            }
        }


        return result;
    }


    /**
     * 将任务根据模块职责进行分工
     * @param taskDO
     */
    private void division(TaskDO taskDO){
        ModuleDeveloperDO md = new ModuleDeveloperDO();
        md.setModuleId(taskDO.getModuleId());
        if(taskDO.getDuties() != null && taskDO.getDuties().length > 0){
            md.setDevTypeList(Arrays.asList(taskDO.getDuties()));
        }
        List<ModuleDeveloperDO> devs = moduleDeveloperDOMapper.selectModuleDeveloperDOList(md);
        if(devs != null && devs.size() > 0){
            List<TaskDeveloperDO> tdList = new ArrayList<>();
            for(ModuleDeveloperDO d : devs){
                TaskDeveloperDO td = new TaskDeveloperDO();
                td.setProjectId(taskDO.getProjectId());
                td.setModuleId(taskDO.getModuleId());
                td.setTaskId(taskDO.getId());
                td.setDeveloperId(d.getUserId());
                td.setStartDate(taskDO.getStartDate());
                td.setEndDate(taskDO.getEndDate());
                td.setState(taskDO.getState());
                tdList.add(td);
            }
            taskDeveloperDOMapper.insertTaskDeveloperDOByBatch(tdList);
        }
    }

    /**
     * 批量任务自动分工
     * @param taskList
     */
    private void division(List<TaskDO> taskList){
        for(TaskDO taskDO:taskList){
            division(taskDO);
        }
    }

    /**
     * 修改任务
     * 
     * @param taskDO 任务
     * @return 结果
     */
    @Override
    public int updateTaskDO(TaskDO taskDO)
    {
        taskDO.setUpdateTime(DateUtils.getNowDate());
        return taskDOMapper.updateTaskDO(taskDO);
    }

    /**
     * 批量删除任务
     * 
     * @param ids 需要删除的任务主键
     * @return 结果
     */
    @Override
    public int deleteTaskDOByIds(Long[] ids)
    {
        return taskDOMapper.deleteTaskDOByIds(ids);
    }

    /**
     * 删除任务信息
     * 
     * @param id 任务主键
     * @return 结果
     */
    @Override
    public int deleteTaskDOById(Long id)
    {
        return taskDOMapper.deleteTaskDOById(id);
    }
}
