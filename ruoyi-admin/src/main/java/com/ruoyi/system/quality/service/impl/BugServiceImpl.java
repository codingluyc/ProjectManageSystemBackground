package com.ruoyi.system.quality.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.quality.domain.Bug;
import com.ruoyi.system.quality.service.IBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.quality.mapper.BugMapper;


/**
 * Bugervice业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@Service
public class BugServiceImpl implements IBugService
{
    @Autowired
    private BugMapper bugMapper;

    /**
     * 查询bug
     * 
     * @param id bug主键
     * @return bug
     */
    @Override
    public Bug selectBugById(Long id)
    {
        return bugMapper.selectBugById(id);
    }

    /**
     * 查询bug列表
     * 
     * @param bug bug
     * @return bug
     */
    @Override
    public List<Bug> selectBugList(Bug bug)
    {
        return bugMapper.selectBugList(bug);
    }

    /**
     * 新增bug
     * 
     * @param bug bug
     * @return 结果
     */
    @Override
    public int insertBug(Bug bug)
    {
        bug.setCreateTime(DateUtils.getNowDate());
        return bugMapper.insertBug(bug);
    }

    /**
     * 修改bug
     * 
     * @param bug bug
     * @return 结果
     */
    @Override
    public int updateBug(Bug bug)
    {
        bug.setUpdateTime(DateUtils.getNowDate());
        return bugMapper.updateBug(bug);
    }

    /**
     * 批量删除bug
     * 
     * @param ids 需要删除的bug主键
     * @return 结果
     */
    @Override
    public int deleteBugByIds(Long[] ids)
    {
        return bugMapper.deleteBugByIds(ids);
    }

    /**
     * 删除bug信息
     * 
     * @param id bug主键
     * @return 结果
     */
    @Override
    public int deleteBugById(Long id)
    {
        return bugMapper.deleteBugById(id);
    }
}
