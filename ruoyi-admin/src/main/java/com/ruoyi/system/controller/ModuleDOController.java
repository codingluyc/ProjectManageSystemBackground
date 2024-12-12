package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.ModuleDO;
import com.ruoyi.system.service.IModuleDOService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模块Controller
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@RestController
@RequestMapping("/systemManage/module")
public class ModuleDOController extends BaseController
{
    @Autowired
    private IModuleDOService moduleDOService;

    /**
     * 查询模块列表
     */
    @PreAuthorize("@ss.hasPermi('systemManage:module:list')")
    @GetMapping("/list")
    public TableDataInfo list(ModuleDO moduleDO)
    {
        startPage();
        List<ModuleDO> list = moduleDOService.selectModuleDOList(moduleDO);
        return getDataTable(list);
    }

    /**
     * 导出模块列表
     */
    @PreAuthorize("@ss.hasPermi('systemManage:module:export')")
    @Log(title = "模块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ModuleDO moduleDO)
    {
        List<ModuleDO> list = moduleDOService.selectModuleDOList(moduleDO);
        ExcelUtil<ModuleDO> util = new ExcelUtil<ModuleDO>(ModuleDO.class);
        util.exportExcel(response, list, "模块数据");
    }

    /**
     * 获取模块详细信息
     */
    @PreAuthorize("@ss.hasPermi('systemManage:module:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(moduleDOService.selectModuleDOById(id));
    }

    /**
     * 新增模块
     */
    @PreAuthorize("@ss.hasPermi('systemManage:module:add')")
    @Log(title = "模块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ModuleDO moduleDO)
    {
        return toAjax(moduleDOService.insertModuleDO(moduleDO));
    }

    /**
     * 修改模块
     */
    @PreAuthorize("@ss.hasPermi('systemManage:module:edit')")
    @Log(title = "模块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ModuleDO moduleDO)
    {
        return toAjax(moduleDOService.updateModuleDO(moduleDO));
    }

    /**
     * 删除模块
     */
    @PreAuthorize("@ss.hasPermi('systemManage:module:remove')")
    @Log(title = "模块", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(moduleDOService.deleteModuleDOByIds(ids));
    }
}
