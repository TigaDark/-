package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.domain.*;
import ssm.service.MenuService;
import ssm.service.UsersService;
import ssm.util.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private MenuService menuService;

    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public @ResponseBody Response Login(@RequestBody loginForm user) throws Exception {
        //获取用户身份 查询信息 返回其信息 暂时未验证密码账号
        //应该要把其角色查出来！！！
        Users users=usersService.findByName(user.getUsername());
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("user",users);
        response.put("token","12313312");
        response.success("登录成功",200);
        return response;
    }

    /**
     * 获取对应角色菜单
     * @param rid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/usermenus",method = RequestMethod.POST)
    public @ResponseBody Response userMenus(@RequestParam(required = true,name = "rid") int rid) throws Exception {
        //根据用户角色id 查询出对应的菜单
        List<Menu> userMenus= menuService.findMenusByrid(rid);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("menu",userMenus);
        response.success("获取菜单成功",200);
        return response;
    }

    /**
     * 用户信息表单的校验
     * @param username
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkUser")
    public @ResponseBody Response checkUser(@RequestParam(required = true,name = "username") String username) throws Exception {
        //根据用户姓名查询出销售员 roleid=4
        Users user = usersService.findByNameandRoleId(username,4);

        Response response=new Response();
        response.put("user",user);
        // null -不存在 否则有这个销售员
        if (user==null)
            response.success("该销售员不存在",201);
        else
            response.success("销售员存在可用",200);
        return response;
    }

    @RequestMapping("/checkUsername")
    public @ResponseBody Response checkUsername(@RequestParam(required = true,name = "username") String username) throws Exception {
        //根据用户姓名查询出销售员 roleid=4
        Users user = usersService.findByuserNameandRoleId(username,4);

        Response response=new Response();
        // null -不存在可用  否则有这个销售员账户则不可用
        if (user!=null)
            response.success("该销售员已存在",201);
        else
            response.success("销售员存在可用",200);
        return response;
    }


    /**
     * 获取所有销售人员
     * @param selectInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/getSaleList")
    public @ResponseBody Response Login(@RequestBody SelectInfo selectInfo) throws Exception {
        //根据查询信息及 页码 页数 查询出所有销售员
        //分页需要当前页数 和每页的大小 故应传入这几个值
        List<Users> saleList=usersService.findSaleByInfo(selectInfo);
        PageInfo pageInfo= new PageInfo(saleList);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("saleList",pageInfo);
        response.success("获取成功",200);
        return response;
    }

    @RequestMapping("/addsalers")
    public @ResponseBody Response addsalers(@RequestBody Users users) throws Exception {
        //设置 rid为4 同时默认密码为123456
        usersService.addsalers(users);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("添加成功",200);
        return response;
    }

    @RequestMapping("/editsaler")
    public @ResponseBody Response editsaler(@RequestBody Users users) throws Exception {
        usersService.editsaler(users);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.success("修改成功",200);
        return response;
    }
}
