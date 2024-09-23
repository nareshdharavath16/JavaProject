package com.qualifyde.kamai.userportal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("userportal")
public class UserPortalApplicationTest {

    @Autowired
    private WebTestClient webTestClient;

//    @Test
//    public void shouldRespondWithHelloMessage() {
//        webTestClient.get().uri("/userportal/")
//            .exchange()
//            .expectStatus().isOk()
//            .expectBody(String.class).isEqualTo("Hello");
//    }
}
