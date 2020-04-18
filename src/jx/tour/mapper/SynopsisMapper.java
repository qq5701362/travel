package jx.tour.mapper;

import jx.tour.pojo.Synopsis;

public interface SynopsisMapper {
	
	/**
	 * 添加
	 * @param synopsis
	 * @return
	 */
	int add(Synopsis synopsis);
	
	/**
	 * 
	 * @param synopsis
	 * @return
	 */
	int updateById(Synopsis synopsis);
	
	
	

}
