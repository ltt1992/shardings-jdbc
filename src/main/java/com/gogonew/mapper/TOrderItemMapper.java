package com.gogonew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gogonew.model.TOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TOrderItemMapper extends BaseMapper<TOrderItem> {
}
