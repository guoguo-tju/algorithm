package com.guoguo.datastructureandalgorithm.algorithm.sort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 * codeMan活动试题
 *
 * @author guozh
 * @create 2019-10-13 18:52
 *
 * 考题：
 * 10G带时间戳的N条kv结构乱序文件存在重复数据，在一台2C4G服务器上去重并保留最新时间戳数据有序输出文件
 * 说明：
 * 1、按照时间戳升序排列
 * 2、时间戳相同，按值的字母序升序排列
 *
 * 案例输入：KV（毫秒时间戳+文本值0-50变长字符串，仅包含字母和数字）
 * 1570593273486,03Ad2k33
 * 1570593273487,03Ad233d988dfd
 * 1570593273488,03Ad2k34
 * 1570593273488,03Ad233d988dfd
 * 1570593273489,03Ad2k33
 * 1570593273487,03Ad233d988dfd
 * 1570593273486,03Ad2k34
 * 1570593273492,03Ad233d988dfd
 * 1570593273493,03Ad2k33
 * 1570593273494,03Ad233d988dfd
 * 1570593273494,03Ad234d988dfd
 *
 * 案例输出：
 * 1570593273488,03Ad2k34
 * 1570593273493,03Ad2k33
 * 1570593273494,03Ad233d988dfd
 * 1570593273494,03Ad234d988dfd
 *
 */
public class CodeManTest {



    private static final ExecutorService threadPool = Executors.newCachedThreadPool();









}