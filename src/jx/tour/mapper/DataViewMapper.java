package jx.tour.mapper;

import java.util.List;

import jx.tour.pojo.OrderNumber;
import org.springframework.stereotype.Repository;
@Repository
public interface DataViewMapper {
	//得到各特产的订单数量情况(折线图和导出)
	public List<OrderNumber> getOrderNumber();
	
	/**
	 * 后台管理首页：购票情况导出的方法
	 * @return
	 */
   public List<OrderNumber> getExportTicket();
 
}