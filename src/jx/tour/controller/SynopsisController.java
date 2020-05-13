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
import jx.tour.pojo.UserorderVo;
import jx.tour.service.BackScenicService;
import jx.tour.service.SynopsisService;
import jx.tour.service.TicketService;
import jx.tour.service.UploadFileService;
import jx.tour.utils.OrderFactory;
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
    
    
    
    
    //---------以下是三娘湾购票相关的-----
    
    //立即预订按钮跳转到立即预订界面
    @RequestMapping("/payWeb")
    public String ticket(Model model,HttpSession session)throws Exception {
        if(session.getAttribute("user")!=null) {
            
            //查询三娘湾简介详细信息
            ScenicVo scenicVo = backScenicService.getOne();
            
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
       
        double cost = oneTicket.getCost();//单价
        int num = oneTicket.getQty_item_1();//数量
        double total = cost * num; //总价
        
        Ticket ticket = new Ticket();
        //订单号：用时间来作为订单号
        ticket.setTid(OrderFactory.getOrderIdByTime());
        ticket.setUserid(user.getUserid());
        ticket.setUsername(user.getUsername());
        ticket.setScenicname(oneTicket.getScenicname());
        ticket.setCost(cost);
        ticket.setQty_item_1(oneTicket.getQty_item_1());
        ticket.setTotal(total);
        ticket.setTime(new Date());
        ticket.setPic(oneTicket.getPic());
        
        //向数据库添加购票记录
        ticketService.insert(ticket);
        
        //通过userid去查询所有购票记录，显示出来
        UserorderVo order = new UserorderVo();
        order.setUserid(user.getUserid());
        List<Ticket> list = ticketService.getAllOrderByUserId(order);
        model.addAttribute("ticketList", list);
        
        
        return "ticket_order";
    }
    
    /**
     * 
     * @param model 模型
     * @param session 
     * @param oneTicket  点击购买时传过来
     * @return
     * @throws Exception
     */
    //查询当前登陆用户的购票记录
    @RequestMapping("/ticketHistory")
    public String ticketHistory(Model model,UserorderVo order)throws Exception {
        
        List<Ticket> list = ticketService.getAllOrderByUserId(order);
        model.addAttribute("ticketList", list);
        return "ticket_order";
    }
    
    
    //通过id删除购票记录
    @RequestMapping("/delete")
    public String deleteById(Model model,HttpSession session,int id)throws Exception {
        
        //执行删除操作
        ticketService.deleteById(id);
        
        //拿到当前登陆的用户id，查当前用户的所有购票记录
        UserorderVo order = new UserorderVo();
        User user = (User) session.getAttribute("user");
        order.setUserid(user.getUserid());
        List<Ticket> list = ticketService.getAllOrderByUserId(order);
        model.addAttribute("ticketList", list);
        return "ticket_order";
    }
    
    

}
