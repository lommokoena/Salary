package com.example.salary.controller;

import com.example.salary.entity.Payslip;
import com.example.salary.service.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payslips")
public class PayslipController {

  @Autowired
  private PayslipService payslipService;

  @GetMapping
  public List<Payslip> getAllPayslips() {
    return payslipService.getAllPayslips();
  }

  @GetMapping("/{id}")
  public Payslip getPayslipById(@PathVariable Long id) {
    return payslipService.getPayslipById(id);
  }

  @PostMapping
  public Payslip createPayslip(@RequestBody Payslip payslip) {
    return payslipService.savePayslip(payslip);
  }

  @PutMapping("/{id}")
  public Payslip updatePayslip(@PathVariable Long id, @RequestBody Payslip payslip) {
    Payslip existingPayslip = payslipService.getPayslipById(id);
    if (existingPayslip != null) {
      existingPayslip.setGrossPay(payslip.getGrossPay());
      existingPayslip.setDeductions(payslip.getDeductions());
      return payslipService.savePayslip(existingPayslip);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void deletePayslip(@PathVariable Long id) {
    payslipService.deletePayslip(id);
  }
}
