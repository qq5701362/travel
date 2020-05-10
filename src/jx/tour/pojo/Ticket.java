package jx.tour.pojo;

import java.util.Date;

/**]
 * 景区购票订单表
 * @author wanggk
 *
 */
public class Ticket {
    private Integer id;
    
    /**
     * 购票人id
     */
    private Integer userid;
    
    /**
     * 购票人昵称或者名字
     */
    private String username;

    /**
     * 景区名称
     */
    private String scenicname;
    
    /**
     * 购票价格
     */
    private Double cost;

    /**
     * 购票数量，如：4张
     */
    private Integer qty_item_1;

    /**
     * 总价
     */
    private double total;
    
   
    /**
     * 购买时间
     */
    private Date time;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserid() {
        return userid;
    }


    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getScenicname() {
        return scenicname;
    }


    public void setScenicname(String scenicname) {
        this.scenicname = scenicname;
    }


    public Double getCost() {
        return cost;
    }


    public void setCost(Double cost) {
        this.cost = cost;
    }


    public Integer getQty_item_1() {
		return qty_item_1;
	}


	public void setQty_item_1(Integer qty_item_1) {
		this.qty_item_1 = qty_item_1;
	}

    public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Date getTime() {
        return time;
    }


    public void setTime(Date time) {
        this.time = time;
    }

   
}