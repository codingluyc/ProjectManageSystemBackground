package com.ruoyi.system.quality.mapper;

import java.util.List;

import com.ruoyi.system.quality.domain.Bug;

/**
 * bugMapper接口
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
public interface BugMapper
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
     * 删除bug
     * 
     * @param id bug主键
     * @return 结果
     */
    public int deleteBugById(Long id);

    /**
     * 批量删除bug
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBugByIds(Long[] ids);
}
