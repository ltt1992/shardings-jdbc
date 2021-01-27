package com.gogonew.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("t_order_item")
@Data
public class TOrderItem {
    @TableId(value = "order_id")
    private Long orderId;
    @TableField(value = "order_no")
    private String orderNo;
    @TableField(value = "item_name")
    private String itemName;
    @TableField(value = "price")
    private BigDecimal price;
}
