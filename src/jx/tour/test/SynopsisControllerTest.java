package jx.tour.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jx.tour.controller.SynopsisController;
import jx.tour.mapper.SynopsisMapper;
import jx.tour.pojo.Synopsis;

public class SynopsisControllerTest {
	
	@Test
	public void testAdd() throws Exception{
		
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		
		//从spring容器中获得Mapper的代理对象
		SynopsisMapper mapper = applicationContext.getBean(SynopsisMapper.class);
		
		Synopsis synopsis = new Synopsis();
		synopsis.setCost(212.2);
		synopsis.setDescrible("wosfhishf");
		mapper.add(synopsis);
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		
		//从spring容器中获得Mapper的代理对象
		SynopsisMapper mapper = applicationContext.getBean(SynopsisMapper.class);
		
		Synopsis synopsis = new Synopsis();
		synopsis.setId(4);
		synopsis.setCost(212.333);
		synopsis.setDescrible("254");
		mapper.updateById(synopsis);
		
	}

}
