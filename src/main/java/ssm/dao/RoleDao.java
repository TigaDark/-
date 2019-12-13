package ssm.dao;

import ssm.domain.Permission;

import java.util.List;

public interface RoleDao {
    List<Permission> findPermissionById(int rid) throws Exception;
}
