package com.ruoyi.system.scheduling.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.scheduling.vo.ProjectVO;
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
import com.ruoyi.system.scheduling.domain.ProjectDO;
import com.ruoyi.system.scheduling.service.IProjectDOService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目Controller
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@RestController
@RequestMapping("/scheduling/project")
public class ProjectDOController extends BaseController
{
    @Autowired
    private IProjectDOService projectDOService;

    /**
     * 查询项目列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjectDO projectDO)
    {
        startPage();
        List<ProjectDO> list = projectDOService.selectProjectDOList(projectDO);
        return getDataTable(list);
    }

    /**
     * 查询项目列表
     */
    @GetMapping("/allProject")
    public AjaxResult allProject(ProjectDO projectDO)
    {
        List<ProjectDO> list = projectDOService.selectProjectDOList(projectDO);
        List<ProjectVO> allProject = list.stream().map(s->ProjectVO.fromProject(s)).collect(Collectors.toList());
        return AjaxResult.success(allProject);
    }

    /**
     * 导出项目列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:project:export')")
    @Log(title = "项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProjectDO projectDO)
    {
        List<ProjectDO> list = projectDOService.selectProjectDOList(projectDO);
        ExcelUtil<ProjectDO> util = new ExcelUtil<ProjectDO>(ProjectDO.class);
        util.exportExcel(response, list, "项目数据");
    }

    /**
     * 获取项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('scheduling:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(projectDOService.selectProjectDOById(id));
    }

    /**
     * 新增项目
     */
    @PreAuthorize("@ss.hasPermi('scheduling:project:add')")
    @Log(title = "项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjectDO projectDO)
    {
        return toAjax(projectDOService.insertProjectDO(projectDO));
    }

    /**
     * 修改项目
     */
    @PreAuthorize("@ss.hasPermi('scheduling:project:edit')")
    @Log(title = "项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjectDO projectDO)
    {
        return toAjax(projectDOService.updateProjectDO(projectDO));
    }

    /**
     * 删除项目
     */
    @PreAuthorize("@ss.hasPermi('scheduling:project:remove')")
    @Log(title = "项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(projectDOService.deleteProjectDOByIds(ids));
    }
}
