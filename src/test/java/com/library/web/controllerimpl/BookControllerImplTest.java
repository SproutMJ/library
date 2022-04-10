package com.library.web.controllerimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerImplTest {
    @Autowired
    BookControllerImpl controller;

    @Mock
    private HttpServletRequest mockHttpRequest = Mockito.mock(HttpServletRequest.class);

    @Mock
    private Model mockModel = Mockito.mock(Model.class);

    @Test
    public void searchTest(){
        controller.search(mockHttpRequest, mockModel);
    }
}
