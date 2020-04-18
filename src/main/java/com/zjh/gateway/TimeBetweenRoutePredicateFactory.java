package com.zjh.gateway;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhaojh
 * @version 1.0
 * @createDate 2020/2/27 17:53
 * @description
 */
@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeBetweenConfig> {

    public TimeBetweenRoutePredicateFactory() {
        super(TimeBetweenConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TimeBetweenConfig config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();
        return exchange -> {
            LocalTime now = LocalTime.now();
            System.out.println(now);
            return now.isAfter(start) && now.isBefore(end);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("start", "end");
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(formatter.format(LocalTime.now()));
        System.out.println(ZonedDateTime.now());
    }
}
