package com.salonbooking;

import com.google.gson.Gson;
import com.salonbooking.domain.Admin;
import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import com.salonbooking.factories.AdminFactory;
import com.salonbooking.factories.CustomerFactory;
import com.salonbooking.factories.EmployeeFactory;
import com.salonbooking.services.Impl.AdminServiceImpl;
import com.salonbooking.services.Impl.CustomerServiceImpl;
import com.salonbooking.services.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Ernst on 2017/09/03.
 */

@Controller
@RequestMapping(path = "/salonBooking")
public class SalonBookingApp {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping(path = "/addAdmin/{adminId}/{adminName}/{adminPassword}")
    public @ResponseBody String addAdmin(@PathVariable String adminId, @PathVariable String adminName, @PathVariable String adminPassword)
    {
        Admin admin = AdminFactory.buildAdmin(adminId, adminName, adminPassword);
        adminService.save(admin);
        return new Gson().toJson(admin);
    }

    @GetMapping(path = "readAdmin/{adminId}")
    public @ResponseBody String readAdmin(@PathVariable String adminId)
    {
        Admin admin = adminService.findById(adminId);
        return new Gson().toJson(admin);
    }

    @GetMapping(path = "/updateAdmin/{adminId}/{adminName}/{adminPassword}")
    public @ResponseBody String updateAdmin(@PathVariable String adminId, @PathVariable String adminName, @PathVariable String adminPassword)
    {
        Admin admin = adminService.findById(adminId);

        if(admin == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Admin adminInsert = AdminFactory.buildAdmin(adminId, adminName, adminPassword);
        adminService.update(adminInsert);
        return new Gson().toJson(adminInsert);
    }

    @GetMapping(path = "deleteAdmin/{adminId}")
    public @ResponseBody void deleteAdmin(@PathVariable String adminId) {
        Admin admin = adminService.findById(adminId);
        if (admin == null) {
            System.out.println("Record does not exist");
        } else {
            adminService.delete(admin);
            System.out.println("Record deleted");
        }
    }

    @GetMapping(path = "/addCustomer/{id}/{name}/{surname}/{age}/{gender}/{cellNumber}/{email}")
    public @ResponseBody String addCustomer(@PathVariable String id, @PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String gender, @PathVariable String cellNumber, @PathVariable String email)
    {
        Customer customer = CustomerFactory.buildCustomer(id, name, surname, age, gender, cellNumber, email);
        customerService.save(customer);
        return new Gson().toJson(customer);
    }

    @GetMapping(path = "readCustomer/{id}")
    public @ResponseBody String readCustomer(@PathVariable String id)
    {
        Customer customer = customerService.findById(id);
        return new Gson().toJson(customer);
    }

    @GetMapping(path = "/updateCustomer/{id}/{name}/{surname}/{age}/{gender}/{cellNumber}/{email}")
    public @ResponseBody String updateCustomer(@PathVariable String id, @PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String gender, @PathVariable String cellNumber, @PathVariable String email)
    {
        Customer customer = customerService.findById(id);

        if(customer == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Customer customerInsert = CustomerFactory.buildCustomer(id, name, surname, age, gender, cellNumber, email);
        customerService.update(customerInsert);
        return new Gson().toJson(customerInsert);
    }

    @GetMapping(path = "deleteCustomer/{id}")
    public @ResponseBody void deleteCustomer(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Record does not exist");
        } else {
            customerService.delete(customer);
            System.out.println("Record deleted");
        }
    }

    @GetMapping(path = "/addEmployee/{id}/{name}/{surname}/{age}/{gender}/{cellNumber}/{email}/{password}/{custList}")
    public @ResponseBody String addEmployee(@PathVariable String id, @PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String gender, @PathVariable String cellNumber, @PathVariable String email, @PathVariable String password, @PathVariable List<Customer> custList)
    {
        Employee employee = EmployeeFactory.buildEmployee(id, name, surname, age, gender, cellNumber, email, password, custList);
        employeeService.save(employee);
        return new Gson().toJson(employee);
    }

    @GetMapping(path = "readEmployee/{id}")
    public @ResponseBody String readEmployee(@PathVariable String id)
    {
        Employee employee = employeeService.findById(id);
        return new Gson().toJson(employee);
    }

    @GetMapping(path = "/updateEmployee/{id}/{name}/{surname}/{age}/{gender}/{cellNumber}/{email}/{custList}")
    public @ResponseBody String updateEmployee(@PathVariable String id, @PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String gender, @PathVariable String cellNumber, @PathVariable String email, @PathVariable String password, @PathVariable List<Customer> custList)
    {
        Employee employee = employeeService.findById(id);

        if(employee == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Employee employeeInsert = EmployeeFactory.buildEmployee(id, name, surname, age, gender, cellNumber, email, password, custList);
        employeeService.update(employeeInsert);
        return new Gson().toJson(employeeInsert);
    }

    @GetMapping(path = "deleteEmployee/{id}")
    public @ResponseBody void deleteEmployee(@PathVariable String id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            System.out.println("Record does not exist");
        } else {
            employeeService.delete(employee);
            System.out.println("Record deleted");
        }
    }
}
