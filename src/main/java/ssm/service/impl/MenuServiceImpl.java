package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.RoleDao;
import ssm.domain.Menu;
import ssm.domain.Permission;
import ssm.service.MenuService;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Menu> findMenusByrid(int rid) throws Exception {
        //根据rid获取到权限菜单 然后处理成menu
        //多个父菜单怎么办？ 先处理一级菜单 然后再处理二级菜单
        List<Permission> permissions=roleDao.findPermissionById(rid);
        List<Menu> menus=new ArrayList<>();
        //遍历菜单 寻找一级菜单 先添加到menus里面
        for (Permission permission:permissions){
            //为0 表示父菜单
            if (permission.getParid()==0){
                Menu menu=new Menu();
                menu.setPath(permission.getPath());
                menu.setId(permission.getId());
                menu.setMenuname(permission.getMenuname());
                menus.add(menu);
            }
        }
        //遍历菜单 寻找二级菜单 添加到对应的menu父菜单的children里面
        for (Permission permission:permissions){
            //为0 表示父菜单
            if (permission.getParid()!=0){
                //循环一级菜单 寻找父菜单
                for (Menu menu2:menus){
                    if(permission.getParid()==menu2.getId()){
                        Menu menu=new Menu();
                        menu.setPath(permission.getPath());
                        menu.setId(permission.getId());
                        menu.setMenuname(permission.getMenuname());
                        menu2.getChildren().add(menu);
                    }
                }
            }
        }
        return menus;
    }
}
