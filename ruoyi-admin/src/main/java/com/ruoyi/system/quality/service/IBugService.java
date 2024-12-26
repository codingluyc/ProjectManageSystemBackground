package com.ruoyi.system.quality.service;

import java.util.List;

import com.ruoyi.system.quality.domain.Bug;

/**
 * Bugervice接口
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
public interface IBugService
{
    /**
     * 查询bug
     * 
     * @param id bug主键
     * @return bug
     */
    public Bug selectBugById(Long id);

    /**
     * 查询bug列表
     * 
     * @param bug bug
     * @return bug集合
     */
    public List<Bug> selectBugList(Bug bug);

    /**
     * 新增bug
     * 
     * @param bug bug
     * @return 结果
     */
    public int insertBug(Bug bug);

    /**
     * 修改bug
     * 
     * @param bug bug
     * @return 结果
     */
    public int updateBug(Bug bug);

    /**
     * 批量删除bug
     * 
     * @param ids 需要删除的bug主键集合
     * @return 结果
     */
    public int deleteBugByIds(Long[] ids);

    /**
     * 删除bug信息
     * 
     * @param id bug主键
     * @return 结果
     */
    public int deleteBugById(Long id);
}
