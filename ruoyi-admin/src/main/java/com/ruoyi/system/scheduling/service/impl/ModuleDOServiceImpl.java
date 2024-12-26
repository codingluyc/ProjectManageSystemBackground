package com.ruoyi.system.scheduling.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.scheduling.mapper.ModuleDOMapper;
import com.ruoyi.system.scheduling.domain.ModuleDO;
import com.ruoyi.system.scheduling.service.IModuleDOService;

/**
 * 模块Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Service
public class ModuleDOServiceImpl implements IModuleDOService 
{
    @Autowired
    private ModuleDOMapper moduleDOMapper;

    /**
     * 查询模块
     * 
     * @param id 模块主键
     * @return 模块
     */
    @Override
    public ModuleDO selectModuleDOById(Long id)
    {
        return moduleDOMapper.selectModuleDOById(id);
    }

    /**
     * 查询模块列表
     * 
     * @param moduleDO 模块
     * @return 模块
     */
    @Override
    public List<ModuleDO> selectModuleDOList(ModuleDO moduleDO)
    {
        return moduleDOMapper.selectModuleDOList(moduleDO);
    }

    /**
     * 新增模块
     * 
     * @param moduleDO 模块
     * @return 结果
     */
    @Override
    public int insertModuleDO(ModuleDO moduleDO)
    {
        moduleDO.setCreateTime(DateUtils.getNowDate());
        return moduleDOMapper.insertModuleDO(moduleDO);
    }

    /**
     * 修改模块
     * 
     * @param moduleDO 模块
     * @return 结果
     */
    @Override
    public int updateModuleDO(ModuleDO moduleDO)
    {
        moduleDO.setUpdateTime(DateUtils.getNowDate());
        return moduleDOMapper.updateModuleDO(moduleDO);
    }

    /**
     * 批量删除模块
     * 
     * @param ids 需要删除的模块主键
     * @return 结果
     */
    @Override
    public int deleteModuleDOByIds(Long[] ids)
    {
        return moduleDOMapper.deleteModuleDOByIds(ids);
    }

    /**
     * 删除模块信息
     * 
     * @param id 模块主键
     * @return 结果
     */
    @Override
    public int deleteModuleDOById(Long id)
    {
        return moduleDOMapper.deleteModuleDOById(id);
    }
}
