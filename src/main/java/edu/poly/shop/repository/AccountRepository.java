package edu.poly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.poly.shop.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	 @Query("SELECT a FROM Account a WHERE (a.username = :usernameOrEmail OR a.email = :usernameOrEmail) AND a.password = :password")
	    Account findByUsernameOrEmailAndPassword(@Param("usernameOrEmail") String usernameOrEmail,
	                                             @Param("password") String password);
	 @Query("SELECT a FROM Account a WHERE (a.username = :usernameOrEmail OR a.email = :usernameOrEmail) AND a.username = :username")
	    Account findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail,
	                                             @Param("username") String username);
}
