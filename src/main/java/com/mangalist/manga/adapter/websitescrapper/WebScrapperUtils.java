package com.mangalist.manga.adapter.websitescrapper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

/**
 * Contains helper methods for web scrapping with jsoup.
 *
 * @author Artur Talik
 */
@Component
public class WebScrapperUtils {

    public Connection createJsoupConnection(String url) {
        return Jsoup.connect(url)
                .referrer("https://www.google.com/")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "en-US,en;q=0.9,pl;q=0.8")
                .header("Referer", "http://www.google.com/")
                .header("Sec-Ch-Ua", "\"Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99\"")
                .header("Sec-Ch-Ua-Mobile", "?0")
                .header("Sec-Ch-Ua-Platform", "\"Windows\"")
                .header("Sec-Fetch-Dest", "document")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-Site", "cross-site")
                .header("Sec-Fetch-User", "?1")
                .header("Upgrade-Insecure-Requests", "1")
                .header("X-Amzn-Trace-Id", "Root=1-635423b0-2abf474d1771e62e1f1a9bce")
                .userAgent("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
    }

    public void randomSleep(long minValue, long maxValue) {
        if (maxValue < minValue) {
            throw new IllegalArgumentException("Max value cannot be smaller than min value!");
        }
        long delta = maxValue - minValue;
        try {
            long sleepTime = (long) (Math.random() * delta);
            sleepTime += minValue;
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
