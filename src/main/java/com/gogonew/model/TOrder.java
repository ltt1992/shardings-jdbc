package com.gogonew.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("t_order")
@Data
public class TOrder {
    @TableId(value = "order_id")
    private Long orderId;
    @TableField(value = "order_no")
    private String orderNo;
    @TableField(value = "create_name")
    private String createName;
    @TableField(value = "price")
    private BigDecimal price;
}
