package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模块开发者对象 module_developer
 * 
 * @author ruoyi
 * @date 2024-12-12
 */
@Data
public class ModuleDeveloperDO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 模块id */
    @Excel(name = "模块id")
    private Long moduleId;
    @Excel(name = "项目id")
    private Long projectId;

    @Excel(name = "模块名称")
    private String moduleName;
    @Excel(name = "项目名称")
    private String projectName;

    /** 1前端 2后端 */
    @Excel(name = "1前端 2后端")
    private String devType;

    /** 开发人员 */
    @Excel(name = "开发人员")
    private String userId;
    @Excel(name = "开发人员名称")
    private String developerName;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("moduleId", getModuleId())
            .append("devType", getDevType())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
