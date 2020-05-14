package jx.tour.service;

import java.util.List;

import jx.tour.pojo.OrderNumber;

public interface DataViewService {
	/**
	 * 后台管理首页：特产折线图和导出的方法
	 * @return
	 */
    public List<OrderNumber> getoOrderNumber();
   
    /**
	 * 后台管理首页：购票情况导出的方法
	 * @return
	 */
   public List<OrderNumber> getExportTicket();
}
