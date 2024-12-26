package com.ruoyi.system.scheduling.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.scheduling.domain.TaskDeveloperDO;
import com.ruoyi.system.scheduling.service.ITaskDeveloperDOService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务-开发者Controller
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@RestController
@RequestMapping("/scheduling/taskDeveloper")
public class TaskDeveloperDOController extends BaseController
{
    @Autowired
    private ITaskDeveloperDOService taskDeveloperDOService;

    /**
     * 查询任务-开发者列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:taskDeveloper:list')")
    @GetMapping("/list")
    public TableDataInfo list(TaskDeveloperDO taskDeveloperDO)
    {
        startPage();
        List<TaskDeveloperDO> list = taskDeveloperDOService.selectTaskDeveloperDOList(taskDeveloperDO);
        return getDataTable(list);
    }

    /**
     * 查询任务-开发者列表
     */

    @GetMapping("/allList")
    public AjaxResult allList(TaskDeveloperDO taskDeveloperDO)
    {
        List<TaskDeveloperDO> list = taskDeveloperDOService.selectTaskDeveloperDOList(taskDeveloperDO);
        return AjaxResult.success(list);
    }

    /**
     * 导出任务-开发者列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:taskDeveloper:export')")
    @Log(title = "任务-开发者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskDeveloperDO taskDeveloperDO)
    {
        List<TaskDeveloperDO> list = taskDeveloperDOService.selectTaskDeveloperDOList(taskDeveloperDO);
        ExcelUtil<TaskDeveloperDO> util = new ExcelUtil<TaskDeveloperDO>(TaskDeveloperDO.class);
        util.exportExcel(response, list, "任务-开发者数据");
    }

    /**
     * 获取任务-开发者详细信息
     */
    @PreAuthorize("@ss.hasPermi('scheduling:taskDeveloper:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(taskDeveloperDOService.selectTaskDeveloperDOById(id));
    }

    /**
     * 新增任务-开发者
     */
    @PreAuthorize("@ss.hasPermi('scheduling:taskDeveloper:add')")
    @Log(title = "任务-开发者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskDeveloperDO taskDeveloperDO)
    {
        return toAjax(taskDeveloperDOService.insertTaskDeveloperDO(taskDeveloperDO));
    }

    /**
     * 修改任务-开发者
     */
    @PreAuthorize("@ss.hasPermi('scheduling:taskDeveloper:edit')")
    @Log(title = "任务-开发者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskDeveloperDO taskDeveloperDO)
    {
        return toAjax(taskDeveloperDOService.updateTaskDeveloperDO(taskDeveloperDO));
    }

    /**
     * 删除任务-开发者
     */
    @PreAuthorize("@ss.hasPermi('scheduling:taskDeveloper:remove')")
    @Log(title = "任务-开发者", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(taskDeveloperDOService.deleteTaskDeveloperDOByIds(ids));
    }
}
