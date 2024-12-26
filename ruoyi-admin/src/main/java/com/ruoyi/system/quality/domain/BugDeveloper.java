package com.ruoyi.system.quality.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * bug开发人员对象 bug_developer
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
public class BugDeveloper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** bug id */
    @Excel(name = "bug id")
    private Long bugId;

    /** 开发人员id */
    @Excel(name = "开发人员id")
    private Long developerId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBugId(Long bugId) 
    {
        this.bugId = bugId;
    }

    public Long getBugId() 
    {
        return bugId;
    }
    public void setDeveloperId(Long developerId) 
    {
        this.developerId = developerId;
    }

    public Long getDeveloperId() 
    {
        return developerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("bugId", getBugId())
            .append("developerId", getDeveloperId())
            .toString();
    }
}
