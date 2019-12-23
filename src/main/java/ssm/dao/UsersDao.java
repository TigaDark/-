package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Users;

import java.util.List;

public interface UsersDao {

    Users findByName(String username) throws Exception;

    Users findById(int id)throws Exception;

    Users findByNameandRoleId(@Param(value = "name")String name, @Param(value = "roleid")int roleid);

    List<Users> findSaleByInfo(int i);

    Users findByuserNameandRoleId(@Param(value = "name")String name, @Param(value = "roleid")int roleid);

    void addsalers(Users users);

    void editsaler(Users users);

    int findByRealName(String username);
}
