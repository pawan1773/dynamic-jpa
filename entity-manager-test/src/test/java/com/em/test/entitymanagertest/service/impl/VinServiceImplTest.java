package com.em.test.entitymanagertest.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.em.test.entitymanagertest.service.VinService;

@SpringBootTest
public class VinServiceImplTest {

	@Autowired
	private VinService vinServiceImpl;

	@Test()
	public void getVinDetailsTest() {
		Exception exception = assertThrows(Exception.class, () -> vinServiceImpl.getVinDetails());
		assertTrue(exception.getMessage().contains("test ex"));
	}
}
