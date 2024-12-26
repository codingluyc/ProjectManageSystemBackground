package com.ruoyi.system.quality.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.quality.mapper.BugDeveloperMapper;
import com.ruoyi.system.quality.domain.BugDeveloper;
import com.ruoyi.system.quality.service.IBugDeveloperService;

/**
 * bug开发人员Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@Service
public class BugDeveloperServiceImpl implements IBugDeveloperService 
{
    @Autowired
    private BugDeveloperMapper bugDeveloperMapper;

    /**
     * 查询bug开发人员
     * 
     * @param id bug开发人员主键
     * @return bug开发人员
     */
    @Override
    public BugDeveloper selectBugDeveloperById(Long id)
    {
        return bugDeveloperMapper.selectBugDeveloperById(id);
    }

    /**
     * 查询bug开发人员列表
     * 
     * @param bugDeveloper bug开发人员
     * @return bug开发人员
     */
    @Override
    public List<BugDeveloper> selectBugDeveloperList(BugDeveloper bugDeveloper)
    {
        return bugDeveloperMapper.selectBugDeveloperList(bugDeveloper);
    }

    /**
     * 新增bug开发人员
     * 
     * @param bugDeveloper bug开发人员
     * @return 结果
     */
    @Override
    public int insertBugDeveloper(BugDeveloper bugDeveloper)
    {
        bugDeveloper.setCreateTime(DateUtils.getNowDate());
        return bugDeveloperMapper.insertBugDeveloper(bugDeveloper);
    }

    /**
     * 修改bug开发人员
     * 
     * @param bugDeveloper bug开发人员
     * @return 结果
     */
    @Override
    public int updateBugDeveloper(BugDeveloper bugDeveloper)
    {
        bugDeveloper.setUpdateTime(DateUtils.getNowDate());
        return bugDeveloperMapper.updateBugDeveloper(bugDeveloper);
    }

    /**
     * 批量删除bug开发人员
     * 
     * @param ids 需要删除的bug开发人员主键
     * @return 结果
     */
    @Override
    public int deleteBugDeveloperByIds(Long[] ids)
    {
        return bugDeveloperMapper.deleteBugDeveloperByIds(ids);
    }

    /**
     * 删除bug开发人员信息
     * 
     * @param id bug开发人员主键
     * @return 结果
     */
    @Override
    public int deleteBugDeveloperById(Long id)
    {
        return bugDeveloperMapper.deleteBugDeveloperById(id);
    }
}
