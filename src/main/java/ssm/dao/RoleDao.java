package ssm.dao;

import ssm.domain.Permission;
import ssm.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Permission> findPermissionById(int rid) throws Exception;

    Role findRoleByuserid(int id) throws Exception;
}
