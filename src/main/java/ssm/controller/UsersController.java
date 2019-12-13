package ssm.controller;

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

    @RequestMapping("/login")
    public @ResponseBody Response Login(@RequestBody loginForm user) throws Exception {
        //获取用户身份 查询信息 返回其信息 暂时未验证密码账号
        //应该要把其角色查出来！！！
        Users users=usersService.findByName(user.getUsername());
        Role role = new Role();
        role.setId(2);
        role.setRoelname("销售管理员");
        users.setRole(role);
        Map<String,Object> data=new HashMap<>();
        Response response=new Response();
        response.put("user",users);
        response.put("token","12313312");
        response.success("登录成功",200);
        return response;
    }

//    @RequestMapping("/findAll")
//    public @ResponseBody ReponseBody findAll(){
//        //获取用户身份 查询信息 返回其信息
//        //
//        return new ReponseBody(1,"123");
//
//    }

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

}
