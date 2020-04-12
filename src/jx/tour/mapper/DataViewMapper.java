package jx.tour.mapper;

import java.util.List;

import jx.tour.pojo.OrderNumber;
import org.springframework.stereotype.Repository;
@Repository
public interface DataViewMapper {
	//得到各个地方的订单数量情况
	public List<OrderNumber> getOrderNumber();
	 
 
}