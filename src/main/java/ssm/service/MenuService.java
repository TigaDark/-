package ssm.service;

import ssm.domain.Menu;

import java.util.List;

public interface MenuService {
     /**
      * 根据rid权限id 查询其拥有的菜单
      * @param rid
      * @return
      * @throws Exception
      */
     List<Menu> findMenusByrid(int rid)throws Exception;
}
