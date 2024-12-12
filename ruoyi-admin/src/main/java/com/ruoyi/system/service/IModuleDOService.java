package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ModuleDO;

/**
 * 模块Service接口
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
public interface IModuleDOService 
{
    /**
     * 查询模块
     * 
     * @param id 模块主键
     * @return 模块
     */
    public ModuleDO selectModuleDOById(Long id);

    /**
     * 查询模块列表
     * 
     * @param moduleDO 模块
     * @return 模块集合
     */
    public List<ModuleDO> selectModuleDOList(ModuleDO moduleDO);

    /**
     * 新增模块
     * 
     * @param moduleDO 模块
     * @return 结果
     */
    public int insertModuleDO(ModuleDO moduleDO);

    /**
     * 修改模块
     * 
     * @param moduleDO 模块
     * @return 结果
     */
    public int updateModuleDO(ModuleDO moduleDO);

    /**
     * 批量删除模块
     * 
     * @param ids 需要删除的模块主键集合
     * @return 结果
     */
    public int deleteModuleDOByIds(Long[] ids);

    /**
     * 删除模块信息
     * 
     * @param id 模块主键
     * @return 结果
     */
    public int deleteModuleDOById(Long id);
}
