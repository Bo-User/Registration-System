package com.soa.order.views;

import lombok.Data;


/**
 * @ program: demo
 * @ description: rabbitmq传递消息的实体类
 * @ author: ShenBo
 * @ date: 2021-12-07 23:06:48
 */
@Data
public class ScheduleMqVo {
    private Integer Id;
    private Integer addOrSub;
}
