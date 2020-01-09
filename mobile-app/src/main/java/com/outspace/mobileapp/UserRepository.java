package com.outspace.mobileapp;

import com.outspace.mobileapp.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* We simply create User Repository and then we make extend it from Crudrepository */

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {    //class, id

}
