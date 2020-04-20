package com.assignment.counterapi;

import com.assignment.counterapi.controller.CounterApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CounterApiController.class)
public class CounterApiControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CounterApiController counterApiController;

	@Test
	public void searchTextApiTest() throws Exception {

	}

	@Test
	public void searchTopApiTest() throws Exception {

	}
}
