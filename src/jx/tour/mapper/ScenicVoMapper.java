package jx.tour.mapper;

import java.util.List;
import jx.tour.pojo.Scenic;
import jx.tour.pojo.ScenicExample;
import jx.tour.pojo.ScenicVo;
import jx.tour.pojo.ScenicWithBLOBs;
import org.apache.ibatis.annotations.Param;

//后台查询景点的相关信息
import org.springframework.stereotype.Repository;
@Repository
public interface ScenicVoMapper {
	
	//查询景点的所有信息
    public List<ScenicVo> getAllScenic();
    
    /**
     * 前端的方法
     * @return
     */
    public ScenicVo getOne();
    
    /**
     * 得到三娘湾简介
     * @return
     */
    public List<ScenicVo> getAllSyn();
    //更新景点的状态（下架）
    public void downScenic(int scenicid);
   //更新景点的状态（上架）
    public void upScenic(int scenicid);
    //查询批量下架的景点信息
    public List<ScenicVo> selectScenics(int ids[]);
    
    
}