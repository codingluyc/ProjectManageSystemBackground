package com.ruoyi.system.scheduling.mapper;

import java.util.List;
import com.ruoyi.system.scheduling.domain.ModuleDeveloperDO;

/**
 * 模块开发者Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
public interface ModuleDeveloperDOMapper 
{
    /**
     * 查询模块开发者
     * 
     * @param id 模块开发者主键
     * @return 模块开发者
     */
    public ModuleDeveloperDO selectModuleDeveloperDOById(Long id);

    /**
     * 查询模块开发者列表
     * 
     * @param moduleDeveloperDO 模块开发者
     * @return 模块开发者集合
     */
    public List<ModuleDeveloperDO> selectModuleDeveloperDOList(ModuleDeveloperDO moduleDeveloperDO);

    /**
     * 新增模块开发者
     * 
     * @param moduleDeveloperDO 模块开发者
     * @return 结果
     */
    public int insertModuleDeveloperDO(ModuleDeveloperDO moduleDeveloperDO);

    /**
     * 修改模块开发者
     * 
     * @param moduleDeveloperDO 模块开发者
     * @return 结果
     */
    public int updateModuleDeveloperDO(ModuleDeveloperDO moduleDeveloperDO);

    /**
     * 删除模块开发者
     * 
     * @param id 模块开发者主键
     * @return 结果
     */
    public int deleteModuleDeveloperDOById(Long id);

    /**
     * 批量删除模块开发者
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteModuleDeveloperDOByIds(Long[] ids);
}
