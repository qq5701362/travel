package jx.tour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jx.tour.mapper.TicketMapper;
import jx.tour.pojo.Ticket;
import jx.tour.pojo.UserorderVo;
import jx.tour.service.TicketService;


@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketMapper ticketMapper;
	
	@Override
	public List<Ticket> getAllOrder() {
		

		return null;
	}

	@Override
	public void insert(Ticket ticket) {

		ticketMapper.add(ticket);
	}

	@Override
	public void deleteById(int id) {

		ticketMapper.deleteById(id);
	}

	@Override
	public List<Ticket> getAllOrderByUserId(UserorderVo order) {
		List<Ticket> list = ticketMapper.getAllOrderByUserId(order);
		return list;
	}

}
