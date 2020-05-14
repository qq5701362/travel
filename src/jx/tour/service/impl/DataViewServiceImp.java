package jx.tour.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jx.tour.mapper.DataViewMapper;
import jx.tour.pojo.OrderNumber;
import jx.tour.service.DataViewService;

@Service
public class DataViewServiceImp implements DataViewService {
@Autowired
private DataViewMapper dataViewMapper;
	@Override
	public List<OrderNumber> getoOrderNumber() {
		 List<OrderNumber> list = dataViewMapper.getOrderNumber();
		return list;
	}
	@Override
	public List<OrderNumber> getExportTicket() {
		List<OrderNumber> list = dataViewMapper.getExportTicket();
		return list;
	}

}
