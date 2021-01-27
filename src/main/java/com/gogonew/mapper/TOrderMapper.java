package com.gogonew.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gogonew.model.TOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TOrderMapper extends BaseMapper<TOrder> {

    List<String> selectOrderAndItemByOrderId(Long orderId);
}
