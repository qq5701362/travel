package jx.tour.mapper;

import jx.tour.pojo.Ticket;

public interface TicketMapper {
	
	/**
	 * 添加
	 * @param synopsis
	 * @return
	 */
	int add(Ticket ticket);
	
	/**
	 * 删除
	 * @param synopsis
	 * @return
	 */
	int deleteById(Ticket ticket);
	
	
	

}
