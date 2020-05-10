package jx.tour.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jx.tour.pojo.Order;
import jx.tour.pojo.ScenicVo;
import jx.tour.pojo.Synopsis;
import jx.tour.pojo.Ticket;
import jx.tour.pojo.User;
import jx.tour.service.BackScenicService;
import jx.tour.service.SynopsisService;
import jx.tour.service.TicketService;
import jx.tour.service.UploadFileService;
import jx.tour.utils.PageUtils;

@Controller
@RequestMapping("/synopsis")
public class SynopsisController {
    
    /**
     * 景区门票订购
     */
    @Autowired
    private TicketService ticketService;
    
    /**
     * 三娘湾简介service
     */
    @Autowired
    private SynopsisService synopsisService;
    
    /**
     * 三娘湾简介service(也是景区service)
     */
    @Autowired
    private BackScenicService backScenicService;
    
    /**
     * 上传图片
     */
    @Autowired
    private UploadFileService uploadFileService;
    
    @Autowired
    private PageUtils pageUtils;
    
  
    /**
     * 其实只查到一条记录
     * @param page
     * @param model
     * @return
     */
      @RequestMapping("/requestAllSyn")
      public String selectSyn(@RequestParam(required = false,defaultValue = "1",value = "page")Integer page,Model model){
          
          PageHelper.startPage(page,5);
          List<ScenicVo> list = backScenicService.getAllSyn();
          for(ScenicVo vo: list) {
              System.out.println(vo.getScenicid());
          }
          //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
          PageInfo<ScenicVo> pageInfo = new PageInfo<>(list,5);  
          pageUtils.setTotal(pageInfo.getTotal());
          pageUtils.setPageNum(pageInfo.getPages());
          pageUtils.setCurrentPageNum(page);
          pageUtils.setBackPageNum(pageInfo.getPrePage());
          pageUtils.setNextPageNum(pageInfo.getNextPage());
        
         
          //pageINfo封装了分页的详细信息，也可以指定连续显示的页数    
          model.addAttribute("pageInfo",pageInfo);  
          model.addAttribute("pageUtils", pageUtils);
          return "admin/synopsis";
      }
    
    //增加三娘湾简介信息
    @RequestMapping("/add")
    public String add(@RequestParam(value = "file")MultipartFile[] file,Synopsis syn,Model model) throws Exception {
        //调用插入图片的方法  
        List<String> savePath = uploadFileService.uploadFile(file); 
        for(int i=0;i<savePath.size();i++){
            if(i==0){
                syn.setPic1(savePath.get(i));
            }
            if(i==1){
                syn.setPic2(savePath.get(i));
            }
            if(i==2){
                syn.setPic3(savePath.get(i));
            }
        }
        synopsisService.add(syn);
        
        //跳转到查询
        return "";
    }
    
    
    /**
     * 其实只查到一条记录(三娘湾简介前端)
     * @param page
     * @param model
     * @return
     */
      @RequestMapping("/getOne")
      public String selectOneSyn(@RequestParam(required = false,defaultValue = "1",value = "page")Integer page,Model model){
          
//          PageHelper.startPage(page,1);
//          List<ScenicVo> list = backScenicService.getAllSyn();
          ScenicVo scenicVo = backScenicService.getOne();
          model.addAttribute("scenicVo", scenicVo);
/*          List<ScenicComment> scenicComment = scenicService.getScenicComment(scenic_id);
          model.addAttribute("scenicComment", scenicComment);
          List<Specialty> specialties = areaService.getSomeSpecialty(scenicnum);
          model.addAttribute("someSpecialtyList", specialties);
          List<Hotel> hotels =  areaService.getSomHotels(scenicnum);
          model.addAttribute("someHotelList", hotels);*/
          
          //前端的三娘湾简介
          return "webSynopsis";
      }
    
    
    
    //修改三娘湾简介信息
    @RequestMapping("/edit")
    public String edit(Model model,@RequestParam("file") MultipartFile[] file,Synopsis syn) throws Exception {
        //调用插入图片的方法  
        List<String> savePath = uploadFileService.uploadFile(file); 
        for(int i=0;i<savePath.size();i++){
            if(i==0){
                syn.setPic1(savePath.get(i));
            }
            if(i==1){
                syn.setPic2(savePath.get(i));
            }
            if(i==2){
                syn.setPic3(savePath.get(i));
            }
        }
        synopsisService.updateById(syn);
        
        //跳转到查询
        return "redirect:/synopsis/requestAllSyn"; 
    }
    
    //立即预订按钮跳转到立即预订界面
    @RequestMapping("/payWeb")
    public String ticket(Model model,HttpSession session)throws Exception {
        if(session.getAttribute("user")!=null) {
            
            //需要通过id查询到相应的数据 TODO
            ScenicVo scenicVo = backScenicService.getOne();
            // specialty  
            model.addAttribute("ticket", scenicVo);
            
            //跳转至购票页面
            return "webTicket";
        } else {
            //没有登陆先去登陆页面登陆
            return "redirect:/check/toLogin";
        }
            
    }
    
    /**
     * 
     * @param model 模型
     * @param session 
     * @param oneTicket  点击购买时传过来
     * @return
     * @throws Exception
     */
    //购票操作
    @RequestMapping("/ticketPay")
    public String ticketPay(Model model,HttpSession session,Ticket oneTicket)throws Exception {
        User user = (User) session.getAttribute("user");
        System.out.println(1122333);
        double cost = oneTicket.getCost();//单价
        int num = oneTicket.getQty_item_1();//数量
        double total = cost * num; //总价
        
        Ticket ticket = new Ticket();
        ticket.setUserid(user.getUserid());
        ticket.setUsername(user.getUsername());
        ticket.setScenicname(oneTicket.getScenicname());
        ticket.setCost(cost);
        ticket.setQty_item_1(oneTicket.getQty_item_1());
        ticket.setTotal(total);
        ticket.setTime(new Date());
        ticketService.insert(ticket);
        
        return null;
    }

}
