package ssm.dao;

import ssm.domain.Users;

public interface UsersDao {

    Users findByName(String username) throws Exception;

    Users findById(int id)throws Exception;
}
