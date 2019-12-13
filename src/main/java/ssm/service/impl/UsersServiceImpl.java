package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.UsersDao;
import ssm.domain.Users;
import ssm.service.UsersService;


@Service("userService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;


    @Override
    public Users findByName(String username) throws Exception {
        return usersDao.findByName(username);
    }
}
