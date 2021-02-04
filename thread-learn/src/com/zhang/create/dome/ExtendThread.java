package com.zhang.create.dome;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * ClassName ExtendThread
 * Description TODO 类描述：练习 Thread，实现多线程同步下载图片
 *
 * @author ZhangRenjie
 * Date  2021/2/3 11:16
 */
public class ExtendThread extends Thread {

    // 网络图片地址
    private String url;
    // 保存的文件名
    private String name;

    public ExtendThread(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载文件 - " + name);
    }

    public static void main(String[] args) {
        ExtendThread t1 = new ExtendThread("https://kuangstudy.com/assert/course/c1/01.jpg", "01.jpg");
        ExtendThread t2 = new ExtendThread("https://kuangstudy.com/assert/course/c1/02.jpg", "02.jpg");
        ExtendThread t3 = new ExtendThread("https://kuangstudy.com/assert/course/c1/03.jpg", "03.jpg");

        // 同时开启线程，等待 cpu 调用，下载顺序不一定
        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}