package com.example.fabrickcontroller.repository;


import com.example.fabrickcontroller.domain.TransactionDomain;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public interface TransactionRepository extends JpaRepository<TransactionDomain, String> {

}
