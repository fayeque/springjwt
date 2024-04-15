package com.javatechie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.entity.UserRequest;

public interface UserRequestRepository extends JpaRepository<UserRequest, Integer>{

}
