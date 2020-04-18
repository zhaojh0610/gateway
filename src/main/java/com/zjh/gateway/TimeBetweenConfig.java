package com.zjh.gateway;

import lombok.Data;

import java.time.LocalTime;

/**
 * @author zhaojh
 * @version 1.0
 * @createDate 2020/2/27 17:53
 * @description
 */
@Data
public class TimeBetweenConfig {
    private LocalTime start;
    private LocalTime end;
}
