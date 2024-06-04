package com.example.salary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payslip")
public class Payslip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payslipId;

  @Column(name = "grossPay")
    private double grossPay;

  @Column(name = "netPay")
    private double netPay;

  @Column(name = "deductions")
    private double deductions;

  @Column(name = "pay_period", unique = false)
  private String payPeriod;

  public void setDeductions(double deductions) {
    this.deductions = deductions;
    calculateNetSalary();
  }

  public void setGrossPay(double grossPay) {
    this.grossPay = grossPay;
    calculateNetSalary();
  }
  public void setSalary(Salary salary) {
        this.salary = salary;
        updateGrossPayFromSalary();
    }
    public void updateGrossPayFromSalary() {
        if (this.salary != null) {
            this.grossPay = this.salary.getAmount();
            calculateNetSalary();
        }
    }
    public void calculateNetSalary(){
    this.netPay = this.grossPay - this.deductions;
 }

//  @OneToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "salary_id ", referencedColumnName = "id")
//  private Salary salary;

}
