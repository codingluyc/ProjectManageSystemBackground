package com.ruoyi.system.scheduling.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.scheduling.dto.TeamsMembersDTO;
import com.ruoyi.system.scheduling.vo.TeamMemberVO;
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
import com.ruoyi.system.scheduling.domain.ProjectTeam;
import com.ruoyi.system.scheduling.service.IProjectTeamService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目团队Controller
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@RestController
@RequestMapping("/scheduling/team")
public class ProjectTeamController extends BaseController
{
    @Autowired
    private IProjectTeamService projectTeamService;

    /**
     * 查询项目团队列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:team:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjectTeam projectTeam)
    {
        startPage();
        List<ProjectTeam> list = projectTeamService.selectProjectTeamList(projectTeam);
        return getDataTable(list);
    }

    /**
     * 查询项目团队列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:team:list')")
    @GetMapping("/userNotInProject")
    public TableDataInfo userNotInProject(Long projectId)
    {
        startPage();
        List<TeamMemberVO> list = projectTeamService.userNotInProject(projectId);
        return getDataTable(list);
    }

    /**
     * 导出项目团队列表
     */
    @PreAuthorize("@ss.hasPermi('scheduling:team:export')")
    @Log(title = "项目团队", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProjectTeam projectTeam)
    {
        List<ProjectTeam> list = projectTeamService.selectProjectTeamList(projectTeam);
        ExcelUtil<ProjectTeam> util = new ExcelUtil<ProjectTeam>(ProjectTeam.class);
        util.exportExcel(response, list, "项目团队数据");
    }

    /**
     * 获取项目团队详细信息
     */
    @PreAuthorize("@ss.hasPermi('scheduling:team:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(projectTeamService.selectProjectTeamById(id));
    }

    /**
     * 新增项目团队
     */
    @PreAuthorize("@ss.hasPermi('scheduling:team:add')")
    @Log(title = "项目团队", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjectTeam projectTeam)
    {
        return toAjax(projectTeamService.insertProjectTeam(projectTeam));
    }

    /**
     * 新增项目团队
     */
    @PreAuthorize("@ss.hasPermi('scheduling:team:add')")
    @Log(title = "项目团队", businessType = BusinessType.INSERT)
    @PostMapping(value = "/addTeams")
    public AjaxResult addTeams(@RequestBody TeamsMembersDTO dto)
    {
        return toAjax(projectTeamService.insertProjectTeams(dto));
    }

    /**
     * 修改项目团队
     */
    @PreAuthorize("@ss.hasPermi('scheduling:team:edit')")
    @Log(title = "项目团队", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjectTeam projectTeam)
    {
        return toAjax(projectTeamService.updateProjectTeam(projectTeam));
    }

    /**
     * 删除项目团队
     */
    @PreAuthorize("@ss.hasPermi('scheduling:team:remove')")
    @Log(title = "项目团队", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(projectTeamService.deleteProjectTeamByIds(ids));
    }
}
