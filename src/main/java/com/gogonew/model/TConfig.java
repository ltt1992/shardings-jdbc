package com.gogonew.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("t_config")
@Data
public class TConfig {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "remark")
    private String remark;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "last_modify_time")
    private Date lastModifyTime;
}
