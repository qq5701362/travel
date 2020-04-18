package jx.tour.pojo;

/**]
 * 三娘湾简介
 * @author wanggk
 *
 */
public class Synopsis {
    private Integer id;

    /**
     * 三娘湾名称
     */
    private String name;

    /**
     * 城市编号：1101：钦州
     */
    private Integer scenicnum;

    /**
     * 三娘湾地址
     */
    private String scenicaddress;

    /**
     * 图片1
     */
    private String pic1;

    /**
     * 标题
     */
    private String title1;

    /**
     * 图片2
     */
    private String pic2;

    /**
     * 图片3
     */
    private String pic3;
    
    /**
     * 视频地址
     */
    private Double video;
    
    /**
     * 景点描述
     */
    private String describle;

    /**
     * 价格
     */
    private Double cost;
    
    
    /**
     * 开放时间
     */
    private String time;

    /**
     * 客服电话
     */
    private String tel;

    

    public Double getVideo() {
        return video;
    }

    public void setVideo(Double video) {
        this.video = video;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScenicnum() {
        return scenicnum;
    }

    public void setScenicnum(Integer scenicnum) {
        this.scenicnum = scenicnum;
    }

    public String getScenicaddress() {
        return scenicaddress;
    }

    public void setScenicaddress(String scenicaddress) {
        this.scenicaddress = scenicaddress;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    
}