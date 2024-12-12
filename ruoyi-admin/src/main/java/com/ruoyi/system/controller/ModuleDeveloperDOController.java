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
import com.ruoyi.system.domain.ModuleDeveloperDO;
import com.ruoyi.system.service.IModuleDeveloperDOService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模块开发者Controller
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@RestController
@RequestMapping("/systemManage/moduleDeveloper")
public class ModuleDeveloperDOController extends BaseController
{
    @Autowired
    private IModuleDeveloperDOService moduleDeveloperDOService;

    /**
     * 查询模块开发者列表
     */
    @PreAuthorize("@ss.hasPermi('systemManage:moduleDeveloper:list')")
    @GetMapping("/list")
    public TableDataInfo list(ModuleDeveloperDO moduleDeveloperDO)
    {
        startPage();
        List<ModuleDeveloperDO> list = moduleDeveloperDOService.selectModuleDeveloperDOList(moduleDeveloperDO);
        return getDataTable(list);
    }

    /**
     * 导出模块开发者列表
     */
    @PreAuthorize("@ss.hasPermi('systemManage:moduleDeveloper:export')")
    @Log(title = "模块开发者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ModuleDeveloperDO moduleDeveloperDO)
    {
        List<ModuleDeveloperDO> list = moduleDeveloperDOService.selectModuleDeveloperDOList(moduleDeveloperDO);
        ExcelUtil<ModuleDeveloperDO> util = new ExcelUtil<ModuleDeveloperDO>(ModuleDeveloperDO.class);
        util.exportExcel(response, list, "模块开发者数据");
    }

    /**
     * 获取模块开发者详细信息
     */
    @PreAuthorize("@ss.hasPermi('systemManage:moduleDeveloper:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(moduleDeveloperDOService.selectModuleDeveloperDOById(id));
    }

    /**
     * 新增模块开发者
     */
    @PreAuthorize("@ss.hasPermi('systemManage:moduleDeveloper:add')")
    @Log(title = "模块开发者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ModuleDeveloperDO moduleDeveloperDO)
    {
        return toAjax(moduleDeveloperDOService.insertModuleDeveloperDO(moduleDeveloperDO));
    }

    /**
     * 修改模块开发者
     */
    @PreAuthorize("@ss.hasPermi('systemManage:moduleDeveloper:edit')")
    @Log(title = "模块开发者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ModuleDeveloperDO moduleDeveloperDO)
    {
        return toAjax(moduleDeveloperDOService.updateModuleDeveloperDO(moduleDeveloperDO));
    }

    /**
     * 删除模块开发者
     */
    @PreAuthorize("@ss.hasPermi('systemManage:moduleDeveloper:remove')")
    @Log(title = "模块开发者", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(moduleDeveloperDOService.deleteModuleDeveloperDOByIds(ids));
    }
}
