package com.teknevia.teknevia_task.repository;

import com.teknevia.teknevia_task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{

}
