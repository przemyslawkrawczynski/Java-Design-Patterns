package com.design.patterns.adapter.company.newhrsystem.oldhrsystem;

import java.math.BigDecimal;
import java.util.List;

public class CompanySalaryProcessor implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        BigDecimal sum = new BigDecimal(0);
        for(Employee employee: employees) {
            System.out.println(employee);
            sum = sum.add(employee.getBaseSalary());
        }
        return sum;
    }
}
