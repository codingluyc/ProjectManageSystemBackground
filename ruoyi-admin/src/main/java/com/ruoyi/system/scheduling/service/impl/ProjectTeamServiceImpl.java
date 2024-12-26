package com.ruoyi.system.scheduling.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.scheduling.dto.TeamsMembersDTO;
import com.ruoyi.system.scheduling.vo.TeamMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.scheduling.mapper.ProjectTeamMapper;
import com.ruoyi.system.scheduling.domain.ProjectTeam;
import com.ruoyi.system.scheduling.service.IProjectTeamService;

/**
 * 项目团队Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@Service
public class ProjectTeamServiceImpl implements IProjectTeamService 
{
    @Autowired
    private ProjectTeamMapper projectTeamMapper;

    /**
     * 查询项目团队
     * 
     * @param id 项目团队主键
     * @return 项目团队
     */
    @Override
    public ProjectTeam selectProjectTeamById(Long id)
    {
        return projectTeamMapper.selectProjectTeamById(id);
    }

    /**
     * 查询项目团队列表
     * 
     * @param projectTeam 项目团队
     * @return 项目团队
     */
    @Override
    public List<ProjectTeam> selectProjectTeamList(ProjectTeam projectTeam)
    {
        return projectTeamMapper.selectProjectTeamList(projectTeam);
    }

    /**
     * 新增项目团队
     * 
     * @param projectTeam 项目团队
     * @return 结果
     */
    @Override
    public int insertProjectTeam(ProjectTeam projectTeam)
    {
        projectTeam.setCreateTime(DateUtils.getNowDate());
        return projectTeamMapper.insertProjectTeam(projectTeam);
    }

    /**
     * 修改项目团队
     * 
     * @param projectTeam 项目团队
     * @return 结果
     */
    @Override
    public int updateProjectTeam(ProjectTeam projectTeam)
    {
        projectTeam.setUpdateTime(DateUtils.getNowDate());
        return projectTeamMapper.updateProjectTeam(projectTeam);
    }

    /**
     * 批量删除项目团队
     * 
     * @param ids 需要删除的项目团队主键
     * @return 结果
     */
    @Override
    public int deleteProjectTeamByIds(Long[] ids)
    {
        return projectTeamMapper.deleteProjectTeamByIds(ids);
    }

    /**
     * 删除项目团队信息
     * 
     * @param id 项目团队主键
     * @return 结果
     */
    @Override
    public int deleteProjectTeamById(Long id)
    {
        return projectTeamMapper.deleteProjectTeamById(id);
    }

    @Override
    public List<TeamMemberVO> userNotInProject(Long projectId) {
        return projectTeamMapper.userNotInProject(projectId);
    }

    @Override
    public int insertProjectTeams(TeamsMembersDTO dto) {
        if(dto.getProjectId() == null || dto.getUserIds() == null || dto.getUserIds().size() == 0)
            return 0;

        List<ProjectTeam> list = new ArrayList<>(dto.getUserIds().size());
        for(Long userId : dto.getUserIds()){
            ProjectTeam team = new ProjectTeam();
            team.setProjectId(dto.getProjectId());
            team.setUserId(userId);
            team.setCreateTime(DateUtils.getNowDate());
            list.add(team);
        }
        return projectTeamMapper.insertProjectTeamByBatch(list);
//        return 0;
    }
}
