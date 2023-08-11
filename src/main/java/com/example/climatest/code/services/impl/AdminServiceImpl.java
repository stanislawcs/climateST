package com.example.climatest.code.services.impl;

import com.example.climatest.code.models.Employee;
import com.example.climatest.code.models.system.roles.UserRoles;
import com.example.climatest.code.repositories.EmployeeRepository;
import com.example.climatest.code.security.details.Details;
import com.example.climatest.code.security.services.DetailsService;
import com.example.climatest.code.services.AdminService;
import com.example.climatest.code.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final EmployeeService employeeService;
    private final DetailsService detailsService;
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void save(int id) {
        Employee employee = employeeService.getOne(id);
        employee.setRole(UserRoles.ROLE_ADMIN);
        UserDetails userDetails = detailsService.loadUserByUsername(employeeService.getOne(id).getUsername());
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
        employeeRepository.save(employee);
    }
}
