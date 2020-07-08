package org.whystudio.alumfound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.whystudio.alumfound.entity.Donationinfo;
import org.whystudio.alumfound.service.IFileService;
import org.whystudio.alumfound.util.BeanUtils;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlumfoundApplicationTests {

	Logger logger = LoggerFactory.getLogger(AlumfoundApplicationTests.class);
	@Autowired
	IFileService fileService;

	@Test
	public void contextLoads() {
		logger.warn("heihei:::{}",fileService.count());
	}

	@Test
	public void beanMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("is_lady", 0);
		System.out.println("-----------------------------------------");
		System.out.println(BeanUtils.mapToBean(map, Donationinfo.class).toString());
	}

}
