package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ModuleDeveloperDOMapper;
import com.ruoyi.system.domain.ModuleDeveloperDO;
import com.ruoyi.system.service.IModuleDeveloperDOService;

/**
 * 模块开发者Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Service
public class ModuleDeveloperDOServiceImpl implements IModuleDeveloperDOService 
{
    @Autowired
    private ModuleDeveloperDOMapper moduleDeveloperDOMapper;

    /**
     * 查询模块开发者
     * 
     * @param id 模块开发者主键
     * @return 模块开发者
     */
    @Override
    public ModuleDeveloperDO selectModuleDeveloperDOById(Long id)
    {
        return moduleDeveloperDOMapper.selectModuleDeveloperDOById(id);
    }

    /**
     * 查询模块开发者列表
     * 
     * @param moduleDeveloperDO 模块开发者
     * @return 模块开发者
     */
    @Override
    public List<ModuleDeveloperDO> selectModuleDeveloperDOList(ModuleDeveloperDO moduleDeveloperDO)
    {
        return moduleDeveloperDOMapper.selectModuleDeveloperDOList(moduleDeveloperDO);
    }

    /**
     * 新增模块开发者
     * 
     * @param moduleDeveloperDO 模块开发者
     * @return 结果
     */
    @Override
    public int insertModuleDeveloperDO(ModuleDeveloperDO moduleDeveloperDO)
    {
        moduleDeveloperDO.setCreateTime(DateUtils.getNowDate());
        return moduleDeveloperDOMapper.insertModuleDeveloperDO(moduleDeveloperDO);
    }

    /**
     * 修改模块开发者
     * 
     * @param moduleDeveloperDO 模块开发者
     * @return 结果
     */
    @Override
    public int updateModuleDeveloperDO(ModuleDeveloperDO moduleDeveloperDO)
    {
        moduleDeveloperDO.setUpdateTime(DateUtils.getNowDate());
        return moduleDeveloperDOMapper.updateModuleDeveloperDO(moduleDeveloperDO);
    }

    /**
     * 批量删除模块开发者
     * 
     * @param ids 需要删除的模块开发者主键
     * @return 结果
     */
    @Override
    public int deleteModuleDeveloperDOByIds(Long[] ids)
    {
        return moduleDeveloperDOMapper.deleteModuleDeveloperDOByIds(ids);
    }

    /**
     * 删除模块开发者信息
     * 
     * @param id 模块开发者主键
     * @return 结果
     */
    @Override
    public int deleteModuleDeveloperDOById(Long id)
    {
        return moduleDeveloperDOMapper.deleteModuleDeveloperDOById(id);
    }
}
