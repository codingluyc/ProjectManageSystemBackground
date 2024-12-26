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
import com.ruoyi.system.quality.domain.Bug;
import com.ruoyi.system.quality.service.IBugService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * bugController
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@RestController
@RequestMapping("/bugManage/bugs")
public class BugController extends BaseController
{
    @Autowired
    private IBugService bugsService;

    /**
     * 查询bug列表
     */
    @PreAuthorize("@ss.hasPermi('bugManage:bugs:list')")
    @GetMapping("/list")
    public TableDataInfo list(Bug bug)
    {
        startPage();
        List<Bug> list = bugsService.selectBugList(bug);
        return getDataTable(list);
    }

    /**
     * 导出bug列表
     */
    @PreAuthorize("@ss.hasPermi('bugManage:bugs:export')")
    @Log(title = "bug", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Bug bug)
    {
        List<Bug> list = bugsService.selectBugList(bug);
        ExcelUtil<Bug> util = new ExcelUtil<Bug>(Bug.class);
        util.exportExcel(response, list, "bug数据");
    }

    /**
     * 获取bug详细信息
     */
    @PreAuthorize("@ss.hasPermi('bugManage:bugs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bugsService.selectBugById(id));
    }

    /**
     * 新增bug
     */
    @PreAuthorize("@ss.hasPermi('bugManage:bugs:add')")
    @Log(title = "bug", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Bug bug)
    {
        return toAjax(bugsService.insertBug(bug));
    }

    /**
     * 修改bug
     */
    @PreAuthorize("@ss.hasPermi('bugManage:bugs:edit')")
    @Log(title = "bug", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Bug bug)
    {
        return toAjax(bugsService.updateBug(bug));
    }

    /**
     * 删除bug
     */
    @PreAuthorize("@ss.hasPermi('bugManage:bugs:remove')")
    @Log(title = "bug", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bugsService.deleteBugByIds(ids));
    }
}
