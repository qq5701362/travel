package jx.tour.service;

import jx.tour.pojo.Synopsis;

public interface SynopsisService {

    
    
    
    
    //后台service
    /**
     * 添加
     * @param synopsis
     * @return
     */
    public void add(Synopsis synopsis);
    
    /**
     * 
     * @param synopsis
     * @return
     */
    public void updateById(Synopsis synopsis);
}
