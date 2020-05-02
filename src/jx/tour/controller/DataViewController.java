package jx.tour.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jx.tour.pojo.OrderNumber;
import jx.tour.service.DataViewService;
import jx.tour.utils.ExcelUtils;

@Controller
@RequestMapping("/view")
public class DataViewController {
    @Autowired
    private DataViewService dataViewService;
//    
//    @Autowired
//    private ExcelUtils excelUtil;

    // 得到各个地方的特产商城下单数量（形成折线图一）
    @RequestMapping("/getOrderNumber")
    @ResponseBody
    public Map<String, Object> getOrderNumber(Model model) {
        System.err.println("-------------------------------------");
        List<OrderNumber> list = dataViewService.getoOrderNumber();

        List<String> name = new ArrayList<String>();
        List<Integer> value1 = new ArrayList<Integer>();
        List<Double> value2= new ArrayList<Double>();

        // 单独挑出两种数据的集合放入map
        for (OrderNumber echartsDataBallBean : list) {
            name.add(echartsDataBallBean.getName());// 对应xAxis data
            value1.add(echartsDataBallBean.getValue1());// 对应yAxis data
            value2.add(echartsDataBallBean.getValue2());// 对应yAxis data
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("value1", value1);
        map.put("value2", value2);
        return map;
    }
    
    
    /**
     * 导出报表
     *
     * @return
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<OrderNumber> list = dataViewService.getoOrderNumber();
 
        //excel标题
        String[] title = {"特产名称", "下单数量","销售额"};
 
        //excel文件名
        String fileName = "特产销量表" + System.currentTimeMillis() + ".xls";
 
        //sheet名
        String sheetName = "特产销量表";
 
        String [][] content = new String[list.size()][5];
 
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            OrderNumber obj = list.get(i);
            content[i][0] = obj.getName();
            content[i][1] = Integer.toString(obj.getValue1());
            
            content[i][2] = Double.toString(obj.getValue2());

        }
 
        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtils.getHSSFWorkbook(sheetName, title, content, null);
 
        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 发送响应流方法
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

}
