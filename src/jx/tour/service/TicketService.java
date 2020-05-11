package jx.tour.service;

import java.util.List;


import jx.tour.pojo.Ticket;
import jx.tour.pojo.UserorderVo;
 

public interface TicketService {  
  
  /**
   * 得到景区订单列表
   * @return
   */
  public List<Ticket> getAllOrder();
  
  /**
   * 通过userid获取到登陆用户的购票记录
   * @return
   */
  public List<Ticket> getAllOrderByUserId(UserorderVo order);
  
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
