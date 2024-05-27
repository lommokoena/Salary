package com.example.salary.service;


import com.example.salary.entity.Payslip;
import com.example.salary.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PayslipService {

  @Autowired
  private PayslipRepository payslipRepository;

  public List<Payslip> getAllPayslips() {
    return payslipRepository.findAll();
  }

  public Payslip getPayslipById(Long id) {
    return payslipRepository.findById(id).orElse(null);
  }

  public Payslip savePayslip(Payslip payslip) {
    return payslipRepository.save(payslip);
  }

  public void deletePayslip(Long id) {
    payslipRepository.deleteById(id);
  }
}
