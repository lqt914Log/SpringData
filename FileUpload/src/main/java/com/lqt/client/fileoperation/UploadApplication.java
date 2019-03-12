package com.lqt.client.fileoperation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * file 上传
 *
 * @author lqt77
 * @create 2019-03-06-14:21
 */
@SpringBootApplication
@EnableEurekaClient
public class UploadApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(UploadApplication.class, args);
    }
//    @Bean
//    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
//            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
//                //-1 means unlimited
//                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
//            }
//        });
//        return tomcat;
//    }
}
