package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.UsersDao;
import ssm.domain.Role;
import ssm.domain.Pojo.SelectInfo;
import ssm.domain.Users;
import ssm.service.UsersService;

import java.text.ParseException;
import java.util.List;


@Service("userService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;


    @Override
    public Users findByName(String username) throws Exception {
        return usersDao.findByName(username);
    }

    @Override
    public Users findByNameandRoleId(String username, int i) {
        return usersDao.findByNameandRoleId(username,i);
    }

    @Override
    public List<Users> findSaleByInfo(SelectInfo selectInfo) {
        //分页//销售员RID=4
        PageHelper.startPage(selectInfo.getPagenum(),selectInfo.getPagesize());
        return usersDao.findSaleByInfo(4);
    }

    @Override
    public Users findByuserNameandRoleId(String username, int i) {
        return usersDao.findByuserNameandRoleId(username,i);
    }

    @Override
    public void addsalers(Users users) throws ParseException {
        //设置 rid为4 同时默认密码为123456
        Role role=new Role();
        role.setId(4);
        users.setRole(role);
        users.setPassword("123456");
        System.out.println(users);
        usersDao.addsalers(users);
    }

    @Override
    public void editsaler(Users users) {
        usersDao.editsaler(users);
    }
}
