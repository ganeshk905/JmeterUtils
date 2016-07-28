package org.automation.jmeter;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.automation.In_JSR223_Java;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shantonu on 7/24/16.
 * just dummy class, will add examples gradually
 */
public class HttpRequestExamples implements In_JSR223_Java{
    public static void main(String[] args) {

    }

    public static void sampleHttp(String url) {

        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet get = new HttpGet(url);
                    HttpResponse response = client.execute(get);
                    HttpEntity entity = response.getEntity();
                    EntityUtils.consume(entity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.shutdown();

    }

    public static void sampleHttpJmeter(String url){
        HTTPSampler sampler = new HTTPSampler();

        //sampler.add
    }

    @Override
    public void writeInJSRElement() {
        
    }
}
