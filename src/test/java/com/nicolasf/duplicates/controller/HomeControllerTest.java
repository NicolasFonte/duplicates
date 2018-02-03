package com.nicolasf.duplicates.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HomeControllerTest {

    @Test
    public void testRedirectionMainPage() throws Exception {
        HomeController homeController = new HomeController();

        String home = homeController.home();

        assertThat(home).isEqualTo("redirect:swagger-ui.html");
    }

}