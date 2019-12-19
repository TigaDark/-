package ssm.service;


import ssm.domain.SelectInfo;
import ssm.domain.Users;

import java.text.ParseException;
import java.util.List;

public interface UsersService {

    /**
     * 根据名字查询用户信息
     * @param username
     * @return
     * @throws Exception
     */
    Users findByName(String username) throws Exception;

    Users findByNameandRoleId(String username, int i);

    List<Users> findSaleByInfo(SelectInfo selectInfo);

    Users findByuserNameandRoleId(String username, int i);

    void addsalers(Users users) throws ParseException;

    void editsaler(Users users);
}
