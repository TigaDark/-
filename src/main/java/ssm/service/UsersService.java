package ssm.service;


import ssm.domain.Users;

public interface UsersService {

    /**
     * 根据名字查询用户信息
     * @param username
     * @return
     * @throws Exception
     */
    Users findByName(String username) throws Exception;
}
