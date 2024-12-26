package com.ruoyi.system.scheduling.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.scheduling.vo.TaskVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.scheduling.domain.TaskDO;
import com.ruoyi.system.scheduling.service.ITaskDOService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务Controller
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@RestController
@RequestMapping("/scheduling/task")
public class TaskDOController extends BaseController
{
    @Autowired
    private ITaskDOService taskDOService;

    /**
     * 查询任务列表
     */
    @GetMapping("/allTask")
    public AjaxResult allTask(TaskDO taskDO)
    {
        List<TaskDO> list = taskDOService.selectTaskDOList(taskDO);
        List<TaskVO> allTasks = list.stream().map(s->TaskVO.fromTask(s)).collect(Collectors.toList());
        return AjaxResult.success(allTasks);
    }

    /**
     * 查询任务列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(TaskDO taskDO)
    {
        startPage();
        List<TaskDO> list = taskDOService.selectTaskDOList(taskDO);
        return getDataTable(list);
    }

    /**
     * 导出任务列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:task:export')")
    @Log(title = "任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskDO taskDO)
    {
        List<TaskDO> list = taskDOService.selectTaskDOList(taskDO);
        ExcelUtil<TaskDO> util = new ExcelUtil<TaskDO>(TaskDO.class);
        util.exportExcel(response, list, "任务数据");
    }

    /**
     * 获取任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('scheduling:task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(taskDOService.selectTaskDOById(id));
    }

    /**
     * 新增任务
     */
    @PreAuthorize("@ss.hasPermi('scheduling:task:add')")
    @Log(title = "任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskDO taskDO)
    {
        return toAjax(taskDOService.insertTaskDO(taskDO));
    }

    /**
     * 修改任务
     */
    @PreAuthorize("@ss.hasPermi('scheduling:task:edit')")
    @Log(title = "任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskDO taskDO)
    {
        return toAjax(taskDOService.updateTaskDO(taskDO));
    }

    /**
     * 删除任务
     */
    @PreAuthorize("@ss.hasPermi('scheduling:task:remove')")
    @Log(title = "任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(taskDOService.deleteTaskDOByIds(ids));
    }
}
