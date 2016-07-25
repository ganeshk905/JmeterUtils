package org.automation.jmeter;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shantonu on 7/24/16.
 */
public class Application {
    public static void main(String[] args) {

        System.out.println(buildString());
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

    public static String buildString(){
        String quantity= "5";
        StringBuilder builder = new StringBuilder();
        builder.append("{\"cartLines\":[");
        for(int i=1;i<=500;i++){
            builder.append("{\"productId\":\"${id_"+i+"}\",\"qtyOrdered\":5,\"unitOfMeasure\":\"EA\"}");
            builder.append("{\"productId\":\"${id_"+i+"}\",\"qtyOrdered\":"+quantity+",\"unitOfMeasure\":\"EA\"}");
            if(i!=500){
                builder.append(",");
            }
        }
        builder.append("]}");
        return builder.toString();
    }
}
