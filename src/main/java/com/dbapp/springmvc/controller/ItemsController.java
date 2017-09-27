package com.dbapp.springmvc.controller;

import com.dbapp.springmvc.exception.CustomException;
import com.dbapp.springmvc.pojo.Items;
import com.dbapp.springmvc.pojo.ItemsCustom;
import com.dbapp.springmvc.pojo.ItemsQueryVo;
import com.dbapp.springmvc.service.ItemsService;
import com.dbapp.springmvc.validation.ValidGroup1;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**===================================
 * controller 方法返回String
 * 1.逻辑视图名，其中真正的视图名 = 视图解析器中前缀+逻辑视图名+后缀
 * 2.redirect 重定向 特点：浏览器地址栏中的url会变化，修改提交的request数据无法传达重定向页面，
 * 因为重定向后新建request（request无法共享）
 * 3.forward 转发 特点：浏览器地址栏中的url不变，修改提交的request数据共享
 * ====================================
 * springmvc中，接收页面提交的数据是通过方法的形参来接收，而不是在controller
 *类中定义成员变量接收，
 *参数绑定默认支持的类型
 * 1.HttpServletRequest request
 * 2.HttpServletResponse response
 * 3.HttpSession session
 * 4.Model model(接口)/ModelMap modelMaps(实现)(作用：把模型数据填充到request域)
 * 直接在controller方法形参上定义上面类型对象，就可以使用这些对象
 * 在参数绑定过程中如果遇到上面类型，直接进行绑定
 * 1>通过@RequestParam对简单类型的参数进行绑定
 * 如果不使用@RequestParam，限制request传入的参数名称和controller方法的形参名称一致，方可以绑定成功
 * 如果使用@RequestParam，不限制request传入的参数名称和controller方法的形参名称一致
 * 2>pojo绑定
 * 页面中的input的name属性值跟controller形参中的pojo属性名称一致，将页面中的数据绑定到pojo
 */
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问的url是根路径+子路径
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    /*复杂的包装对象参数的绑定 begin*/
    @RequestMapping("/queryItemsList")
    //包装pojo的参数绑定，input中name="itemsCustom.itemName"
    public ModelAndView queryItemsList(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {
        //测试request共享
        //System.out.println("==================="+request.getParameter("id"));
        List<Items> itemsList = itemsService.queryItemsList(itemsQueryVo);
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相对于request的setAttribute 在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList",itemsList);
        //定义视图
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }
    /*复杂的包装对象参数的绑定 end*/

    //限制http请求的方式
    /*@RequestMapping(value = "/editItems",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView editItems() throws Exception {
        Items items = itemsService.getItemsById(1);
        ItemsCustom itemsCustom = new ItemsCustom();
        //将items属性的值拷贝到itemsCustom属性中
        BeanUtils.copyProperties(items,itemsCustom);
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相对于request的setAttribute 在jsp页面中通过itemsList取数据
        modelAndView.addObject("items",items);
        //定义视图
        modelAndView.setViewName("items/editItems");
        return modelAndView;
    }*/


    @RequestMapping(value = "/editItems",method = {RequestMethod.POST,RequestMethod.GET})
    //@RequestParam里面指定request传入的参数名称和形参进行绑定
    //通过required = true指定参数必须传入
    //通过defaultValue可以设置默认值，如果id参数没有传入，将默认值进行绑定
    public String editItems(Model model,@RequestParam(value = "id",required = true) Integer item_id) throws Exception {
        Items items = itemsService.getItemsById(item_id);
        ItemsCustom itemsCustom = new ItemsCustom();
        //将items属性的值拷贝到itemsCustom属性中
        if(items!=null){
            BeanUtils.copyProperties(items,itemsCustom);
        }
        //通过形参中的model将model数据返回到页面
        //判断商品信息是否为空，根据id没有查到商品，提示该商品信息不存在
        if(items == null){
            throw new CustomException("修改商品信息不存在!");
        }
        model.addAttribute("items",items);
        return "items/editItems";
    }

    @RequestMapping(value = "/saveEdit",method = {RequestMethod.POST})
    //post 乱码问题  在web.xml中添加post乱码filter
    //在需要校验的pojo前面添加@Validated，在需要校验的pojo后面添加BindingResult bindingResult接收校验出错信息
    //注意：@Validated和BindingResult bindingResult是配对出现的，并且形参顺序是固定的(一前一后)
    //@Validated(value = {ValidGroup1.class})指定使用ValidGroup1分组校验
    //@ModelAttribute("items")可以指定pojo回显到页面在request中的key
    public String saveEdit(Model model,
                           @ModelAttribute("itemsCustom")  @Validated(value = {ValidGroup1.class})Items items,
                           BindingResult bindingResult,
                           MultipartFile itemsPic//接收商品图片
    ) throws Exception {
        //获取校验错误信息
        if(bindingResult.hasErrors()){
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for(ObjectError objectError:allErrors){
                System.out.println("校验出错提示信息:"+objectError.getDefaultMessage());
            }
            //将错误信息传入到页面
            model.addAttribute("allErrors",allErrors);
            //出错重新到商品修改界面
            return "items/editItems";
        }

        //存储图片的物理路径 本机测试用
        String pic_path = "F:\\local\\upload\\imgs\\";
        //得到图片的原始名称
        String originalFilename = itemsPic.getOriginalFilename();
        //上传图片
        if(itemsPic!=null && originalFilename!=null && originalFilename.length()>0){
            //新的图片名称
            String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
            //图片上传的位置
            File file_in = new File(pic_path);
            if(!file_in.exists()){
                file_in.mkdirs();
            }
            //新的图片
            File newFile = new File(pic_path+newFileName);
            //将内存中的数据写入磁盘
            itemsPic.transferTo(newFile);
            //将新的图片名称写到items中
            items.setPic(newFileName);
        }

        itemsService.updateItems(items);
        //同一个controller不需要加跟路径
        //redirect 重定向
        //return "redirect:queryItemsList";
        //forward 转发
        return "forward:queryItemsList";
    }

    /**
     * 返回json
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getJson")
    public void getJson(HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("{\"name\":\"dbapp\"}");
    }

    /*数组参数绑定 begin*/
    @RequestMapping("deleteItems")
    //数组的绑定 形参ids与input name="ids"
    public String deleteItems(Integer[] ids)throws Exception {
        System.out.println("===================ids:"+ids);
        return "forward:queryItemsList";
    }
    /*数组参数绑定 end*/

    /*List参数绑定 begin*/
    @RequestMapping("/editItemsQuery")
    public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {
        List<Items> itemsList = itemsService.queryItemsList(itemsQueryVo);
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相对于request的setAttribute 在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList",itemsList);
        //定义视图
        modelAndView.setViewName("items/editItemsQuery");
        return modelAndView;
    }
    //批量修改
    @RequestMapping("/batchEditItems")
    //通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中的itemsList属性中
    public String batchEditItems(ItemsQueryVo itemsQueryVo) throws Exception{
        return "forward:queryItemsList";
    }
    /*List参数绑定 end*/
    /*Map参数绑定 begin*/
    @RequestMapping("/addItems")
    public ModelAndView addItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //定义视图
        modelAndView.setViewName("items/addItems");
        return modelAndView;
    }

    @RequestMapping("/saveAdd")
    //通过ItemsQueryVo提交的Map商品信息
    public String saveAdd(ItemsQueryVo itemsQueryVo) throws Exception{
        return "forward:queryItemsList";
    }
    /*Map参数绑定 end*/

    //商品分类
    //itemtypes表示最终将方法的返回值放在request中的key
    @ModelAttribute("itemtypes")
    public Map<String,String> getItemTypes(){
        Map<String,String> itemtypes = new HashMap<String,String>();
        itemtypes.put("101","数码");
        itemtypes.put("102","母婴");
        return itemtypes;
    }

    //查询商品信息，输出json
    @RequestMapping(value = "/itemsView/{id}")
    @ResponseBody
    //@RequestMapping(value = "/itemsView/{XXX}")与@PathVariable("XXX")
    //或者@RequestMapping(value = "/itemsView/{XXX}")与@PathVariable Integer XXX
    public Items itemsView(@PathVariable("id") Integer idss) throws Exception{
        System.out.println("=============idss===========:"+idss);
        Items items = itemsService.getItemsById(idss);
        return items;
    }
}
