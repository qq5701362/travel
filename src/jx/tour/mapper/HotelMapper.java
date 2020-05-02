package jx.tour.mapper;

import java.util.List;
import jx.tour.pojo.Hotel;
import jx.tour.pojo.HotelExample;
import jx.tour.pojo.HotelWithBLOBs;
import jx.tour.pojo.Search;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface HotelMapper {
    int countByExample(HotelExample example);

    int deleteByExample(HotelExample example);

    int deleteByPrimaryKey(Integer hid);

    int insert(HotelWithBLOBs record);

    int insertSelective(HotelWithBLOBs record);

    List<HotelWithBLOBs> selectByExampleWithBLOBs(HotelExample example);

    List<Hotel> selectByExample(HotelExample example);
    
    //通过酒店名字查找酒店的信息
    List<Hotel> getSomeHotelsByName(Search search);

    HotelWithBLOBs selectByPrimaryKey(Integer hid);

    int updateByExampleSelective(@Param("record") HotelWithBLOBs record, @Param("example") HotelExample example);

    int updateByExampleWithBLOBs(@Param("record") HotelWithBLOBs record, @Param("example") HotelExample example);

    int updateByExample(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByPrimaryKeySelective(HotelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HotelWithBLOBs record);

    int updateByPrimaryKey(Hotel record);
}