package com.labmedicine.labmedicalapi.repositories;

import com.labmedicine.labmedicalapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
}
