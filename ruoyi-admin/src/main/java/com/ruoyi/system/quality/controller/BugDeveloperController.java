package com.ruoyi.system.quality.controller;

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
import com.ruoyi.system.quality.domain.BugDeveloper;
import com.ruoyi.system.quality.service.IBugDeveloperService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * bug开发人员Controller
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@RestController
@RequestMapping("/bugManage/developer")
public class BugDeveloperController extends BaseController
{
    @Autowired
    private IBugDeveloperService bugDeveloperService;

    /**
     * 查询bug开发人员列表
     */
    @PreAuthorize("@ss.hasPermi('bugManage:developer:list')")
    @GetMapping("/list")
    public TableDataInfo list(BugDeveloper bugDeveloper)
    {
        startPage();
        List<BugDeveloper> list = bugDeveloperService.selectBugDeveloperList(bugDeveloper);
        return getDataTable(list);
    }

    /**
     * 导出bug开发人员列表
     */
    @PreAuthorize("@ss.hasPermi('bugManage:developer:export')")
    @Log(title = "bug开发人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BugDeveloper bugDeveloper)
    {
        List<BugDeveloper> list = bugDeveloperService.selectBugDeveloperList(bugDeveloper);
        ExcelUtil<BugDeveloper> util = new ExcelUtil<BugDeveloper>(BugDeveloper.class);
        util.exportExcel(response, list, "bug开发人员数据");
    }

    /**
     * 获取bug开发人员详细信息
     */
    @PreAuthorize("@ss.hasPermi('bugManage:developer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bugDeveloperService.selectBugDeveloperById(id));
    }

    /**
     * 新增bug开发人员
     */
    @PreAuthorize("@ss.hasPermi('bugManage:developer:add')")
    @Log(title = "bug开发人员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BugDeveloper bugDeveloper)
    {
        return toAjax(bugDeveloperService.insertBugDeveloper(bugDeveloper));
    }

    /**
     * 修改bug开发人员
     */
    @PreAuthorize("@ss.hasPermi('bugManage:developer:edit')")
    @Log(title = "bug开发人员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BugDeveloper bugDeveloper)
    {
        return toAjax(bugDeveloperService.updateBugDeveloper(bugDeveloper));
    }

    /**
     * 删除bug开发人员
     */
    @PreAuthorize("@ss.hasPermi('bugManage:developer:remove')")
    @Log(title = "bug开发人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bugDeveloperService.deleteBugDeveloperByIds(ids));
    }
}
