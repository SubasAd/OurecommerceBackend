package com.subas.ourecommerce.users;

import com.subas.ourecommerce.users.Users.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Long> {

    public MyUser getUserByUsername(String username);

}
