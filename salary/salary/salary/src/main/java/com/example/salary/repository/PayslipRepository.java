package com.example.salary.repository;

import com.example.salary.entity.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PayslipRepository extends JpaRepository<Payslip, Long> {

}
