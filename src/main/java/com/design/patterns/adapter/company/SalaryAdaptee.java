package com.design.patterns.adapter.company;

import com.design.patterns.adapter.company.newhrsystem.oldhrsystem.CompanySalaryProcessor;
import com.design.patterns.adapter.company.newhrsystem.oldhrsystem.Employee;
import com.design.patterns.adapter.company.newhrsystem.oldhrsystem.SalaryProcessor;

import java.math.BigDecimal;
import java.util.List;

public class SalaryAdaptee implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        CompanySalaryProcessor theProcessor = new CompanySalaryProcessor();
        return theProcessor.calculateSalaries(employees);
    }
}
