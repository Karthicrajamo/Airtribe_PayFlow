package com.assessement.upi_payment.repository;

import com.assessement.upi_payment.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUpiId(String upiId);

    @Query("SELECT u FROM Users u where u.balance > :amount")
    List<Users> findUsersBalanceGreaterThan(Double amount);
}
