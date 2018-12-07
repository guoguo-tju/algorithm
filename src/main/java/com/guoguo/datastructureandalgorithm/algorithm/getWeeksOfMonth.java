package com.guoguo.datastructureandalgorithm.algorithm;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: algorithm
 * @description: 获取每个月的每个星期的起始日期和结束日期
 * 参考: https://segmentfault.com/q/1010000016207823
 * @author: Karl Guo
 * @create: 2018-12-06 16:40
 **/
public class getWeeksOfMonth {


    public static void main(String[] args) {

        Map<Integer, WeekData> weeks = weeks(YearMonth.parse("2018-11"));

        for (Integer integer : weeks.keySet()) {
            System.out.println("第" + integer + "周");
            System.out.println("value :" + weeks.get(integer));
        }

    }


    /**
     * 按照周进行分类得到类似一个map的结果Map<Integer, WeekData>（其中key就是第几周）
     *
     * @param yearMonth
     * @return
     */
    private static Map<Integer, WeekData> weeks(YearMonth yearMonth) {
        LocalDate start = LocalDate.now().with(yearMonth).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate end = LocalDate.now().with(yearMonth).with(TemporalAdjusters.lastDayOfMonth());

        Map<Integer, WeekData> map = Stream.iterate(start, localDate -> localDate.plusDays(1l))
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                // 此处国外以周日为每周第一天
                .collect(Collectors.groupingBy(localDate -> localDate.get(WeekFields.of(DayOfWeek.SUNDAY, 1).weekOfMonth()),
                        Collectors.collectingAndThen(Collectors.toList(), WeekData::new)));
        return map;
    }


    /**
     * 定义一个静态内部类WeekData封装返回结果
     */
    static class WeekData {
        // 一周的开始时间
        private LocalDate start;
        // 一周的结束时间
        private LocalDate end;

        public WeekData(List<LocalDate> localDates) {
            this.start = localDates.get(0);
            this.end = localDates.get(localDates.size() - 1);
        }

        @Override
        public String toString() {
            return "开始时间：" + this.start + "，结束时间：" + this.end;
        }
    }


}
