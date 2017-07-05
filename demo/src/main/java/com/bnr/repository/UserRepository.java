package com.bnr.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.bnr.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

  /**
   * This method will find an User instance in the database by its email.
   * Note that this method is not implemented and its working code will be
   * automagically generated from its signature by Spring Data JPA.
   */
  public List<User> findByEmail(String email);

}
