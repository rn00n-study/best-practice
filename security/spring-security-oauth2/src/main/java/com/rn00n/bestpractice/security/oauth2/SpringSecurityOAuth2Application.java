package com.rn00n.bestpractice.security.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SpringSecurityOAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOAuth2Application.class, args);
    }

    @PostConstruct
    public void onPostConstruct() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

}
