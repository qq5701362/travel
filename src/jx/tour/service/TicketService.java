package jx.tour.service;

import java.util.List;


import jx.tour.pojo.Ticket;
 

public interface TicketService {  
  
  /**
   * 得到景区订单列表
   * @return
   */
  public List<Ticket> getAllOrder();
  
  /**
   * 前端获取三娘湾的方法
   * @return
   */
  public void insert(Ticket ticket);
  
  /**
   * 通过id删除
   * @param id
   */
  public void deleteById(int id);
}
