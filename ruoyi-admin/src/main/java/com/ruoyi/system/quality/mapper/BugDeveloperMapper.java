package com.ruoyi.system.quality.mapper;

import java.util.List;
import com.ruoyi.system.quality.domain.BugDeveloper;

/**
 * bug开发人员Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
public interface BugDeveloperMapper 
{
    /**
     * 查询bug开发人员
     * 
     * @param id bug开发人员主键
     * @return bug开发人员
     */
    public BugDeveloper selectBugDeveloperById(Long id);

    /**
     * 查询bug开发人员列表
     * 
     * @param bugDeveloper bug开发人员
     * @return bug开发人员集合
     */
    public List<BugDeveloper> selectBugDeveloperList(BugDeveloper bugDeveloper);

    /**
     * 新增bug开发人员
     * 
     * @param bugDeveloper bug开发人员
     * @return 结果
     */
    public int insertBugDeveloper(BugDeveloper bugDeveloper);

    /**
     * 修改bug开发人员
     * 
     * @param bugDeveloper bug开发人员
     * @return 结果
     */
    public int updateBugDeveloper(BugDeveloper bugDeveloper);

    /**
     * 删除bug开发人员
     * 
     * @param id bug开发人员主键
     * @return 结果
     */
    public int deleteBugDeveloperById(Long id);

    /**
     * 批量删除bug开发人员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBugDeveloperByIds(Long[] ids);
}
