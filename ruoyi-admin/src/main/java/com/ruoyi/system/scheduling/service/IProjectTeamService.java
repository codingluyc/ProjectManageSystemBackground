package com.ruoyi.system.scheduling.service;

import java.util.List;
import com.ruoyi.system.scheduling.domain.ProjectTeam;
import com.ruoyi.system.scheduling.dto.TeamsMembersDTO;
import com.ruoyi.system.scheduling.vo.TeamMemberVO;

/**
 * 项目团队Service接口
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
public interface IProjectTeamService 
{
    /**
     * 查询项目团队
     * 
     * @param id 项目团队主键
     * @return 项目团队
     */
    public ProjectTeam selectProjectTeamById(Long id);

    /**
     * 查询项目团队列表
     * 
     * @param projectTeam 项目团队
     * @return 项目团队集合
     */
    public List<ProjectTeam> selectProjectTeamList(ProjectTeam projectTeam);

    /**
     * 新增项目团队
     * 
     * @param projectTeam 项目团队
     * @return 结果
     */
    public int insertProjectTeam(ProjectTeam projectTeam);

    /**
     * 修改项目团队
     * 
     * @param projectTeam 项目团队
     * @return 结果
     */
    public int updateProjectTeam(ProjectTeam projectTeam);

    /**
     * 批量删除项目团队
     * 
     * @param ids 需要删除的项目团队主键集合
     * @return 结果
     */
    public int deleteProjectTeamByIds(Long[] ids);

    /**
     * 删除项目团队信息
     * 
     * @param id 项目团队主键
     * @return 结果
     */
    public int deleteProjectTeamById(Long id);

    /**
     * 查询不在项目中的成员
     * @param projectId
     * @return
     */
    List<TeamMemberVO> userNotInProject(Long projectId);

    /**
     * 批量插入项目团队成员
     * @param dto
     * @return
     */
    int insertProjectTeams(TeamsMembersDTO dto);
}
