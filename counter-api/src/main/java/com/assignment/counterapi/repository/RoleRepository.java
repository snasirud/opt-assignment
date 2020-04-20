package com.assignment.counterapi.repository;

import com.assignment.counterapi.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
