package jx.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jx.tour.pojo.ScenicVo;
import jx.tour.pojo.Synopsis;
import jx.tour.service.BackScenicService;
import jx.tour.service.SynopsisService;
import jx.tour.service.UploadFileService;
import jx.tour.utils.PageUtils;

@Controller
@RequestMapping("/synopsis")
public class SynopsisController {
    
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
        return "";
    }

}
