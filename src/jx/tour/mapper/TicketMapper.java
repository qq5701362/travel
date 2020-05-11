package jx.tour.mapper;

import java.util.List;

import jx.tour.pojo.Ticket;
import jx.tour.pojo.UserorderVo;

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
    int deleteById(int id);
    
    
    /**
     * 通过userid获取到登陆用户的购票记录
     * @return
     */
    public List<Ticket> getAllOrderByUserId(UserorderVo order);

}
