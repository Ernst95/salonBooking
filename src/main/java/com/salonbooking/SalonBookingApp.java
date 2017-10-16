package com.salonbooking;

import com.google.gson.Gson;
import com.salonbooking.domain.*;
import com.salonbooking.factories.*;
import com.salonbooking.services.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Ernst on 2017/09/03.
 */
@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping(path = "/salonBooking")
public class SalonBookingApp {

    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private ReceiptServiceImpl receiptService;

    @Autowired
    private ReservationServiceImpl reservationService;

    @Autowired
    private StyleServiceImpl styleService;

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

    @GetMapping(path = "/addCustomer/{id}/{name}/{surname}/{age}/{gender}/{cellNumber}/{email}/{empId}")
    public @ResponseBody String addCustomer(@PathVariable String id, @PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String gender, @PathVariable String cellNumber, @PathVariable String email, @PathVariable String empId)
    {
        Employee emp = new Employee.Builder()
                .id(empId)
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .password("")
                .build();

        Customer customer = CustomerFactory.buildCustomer(id, name, surname, age, gender, cellNumber, email, emp);
        customerService.save(customer);
        return new Gson().toJson(customer);
    }

    @GetMapping(path = "readCustomer/{id}")
    public @ResponseBody String readCustomer(@PathVariable String id)
    {
        Customer customer = customerService.findById(id);
        return new Gson().toJson(customer);
    }

    @GetMapping(path = "readCustomerByAge/{age}")
    public @ResponseBody String readCustomerAll(@PathVariable int age)
    {
        List<Customer> customer = customerService.getCustomer(age);
        return new Gson().toJson(customer);
    }

    @GetMapping(path = "/updateCustomer/{id}/{name}/{surname}/{age}/{gender}/{cellNumber}/{email}/{empId}")
    public @ResponseBody String updateCustomer(@PathVariable String id, @PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String gender, @PathVariable String cellNumber, @PathVariable String email, @PathVariable String empId)
    {
        Customer customer = customerService.findById(id);

        if(customer == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Employee emp = new Employee.Builder()
                .id(empId)
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .password("")
                .build();

        Customer customerInsert = CustomerFactory.buildCustomer(id, name, surname, age, gender, cellNumber, email,  emp);
        customerService.update(customerInsert);
        return new Gson().toJson(customerInsert);
    }

    @GetMapping(path = "/deleteCustomer/{id}")
    public @ResponseBody void deleteCustomer(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Record does not exist");
        } else {
            customerService.delete(customer);
            System.out.println("Record deleted");
        }
    }

    @GetMapping(path = "/addEmployee/{id}/{name}/{surname}/{age}/{gender}/{cellNumber}/{email}/{password}")
    public @ResponseBody String addEmployee(@PathVariable String id, @PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String gender, @PathVariable String cellNumber, @PathVariable String email, @PathVariable String password)
    {
        Employee employee = EmployeeFactory.buildEmployee(id, name, surname, age, gender, cellNumber, email, password);
        employeeService.save(employee);
        return new Gson().toJson(employee);
    }

    @GetMapping(path = "readEmployee/{id}")
    public @ResponseBody String readEmployee(@PathVariable String id)
    {
        Employee employee = employeeService.findById(id);
        return new Gson().toJson(employee);
    }

    @GetMapping(path = "/updateEmployee/{id}/{name}/{surname}/{age}/{gender}/{cellNumber}/{email}/{password}")
    public @ResponseBody String updateEmployee(@PathVariable String id, @PathVariable String name, @PathVariable String surname, @PathVariable int age, @PathVariable String gender, @PathVariable String cellNumber, @PathVariable String email, @PathVariable String password)
    {
        Employee employee = employeeService.findById(id);

        if(employee == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Employee employeeInsert = EmployeeFactory.buildEmployee(id, name, surname, age, gender, cellNumber, email, password);
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

    @GetMapping(path = "/addReceipt/{id}/{resId}")
    public @ResponseBody String addReceipt(@PathVariable String id, @PathVariable String resId)
    {
        Employee emp = new Employee.Builder()
                .id("")
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .password("")
                .build();

        Customer cust = new Customer.Builder()
                .id("")
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .emp(emp)
                .build();

        Style style = new Style.Builder()
                .id("")
                .name("")
                .price(0)
                .hairLength(0)
                .build();

        Reservation reservation = new Reservation.Builder()
                .id(resId)
                .date("")
                .time("")
                .style(style)
                .cust(cust)
                .emp(emp)
                .build();

        Date date = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Receipt receipt = ReceiptFactory.buildReceipt(id, date, reservation);
        receiptService.save(receipt);
        return new Gson().toJson(receipt);
    }

    @GetMapping(path = "readReceipt/{id}")
    public @ResponseBody String readReceipt(@PathVariable String id)
    {
        Receipt receipt = receiptService.findById(id);
        return new Gson().toJson(receipt);
    }

    @GetMapping(path = "/updateReceipt/{id}/{resId}")
    public @ResponseBody String updateReceipt(@PathVariable String id, @PathVariable String resId)
    {
        Receipt receipt = receiptService.findById(id);
        Date date = new Date();

        if(receipt == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Employee emp = new Employee.Builder()
                .id("")
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .password("")
                .build();

        Customer cust = new Customer.Builder()
                .id("")
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .emp(emp)
                .build();

        Style style = new Style.Builder()
                .id("")
                .name("")
                .price(0)
                .hairLength(0)
                .build();

        Reservation reservation = new Reservation.Builder()
                .id(resId)
                .date("")
                .time("")
                .style(style)
                .cust(cust)
                .emp(emp)
                .build();

        Receipt receiptInsert = ReceiptFactory.buildReceipt(id, date, reservation);
        receiptService.update(receiptInsert);
        return new Gson().toJson(receiptInsert);
    }

    @GetMapping(path = "deleteReceipt/{id}")
    public @ResponseBody void deleteReceipt(@PathVariable String id) {
        Receipt receipt = receiptService.findById(id);
        if (receipt == null) {
            System.out.println("Record does not exist");
        } else {
            receiptService.delete(receipt);
            System.out.println("Record deleted");
        }
    }

    @GetMapping(path = "/addReservation/{id}/{date}/{time}/{styleId}/{custId}/{empId}")
    public @ResponseBody String addReservation(@PathVariable String id, @PathVariable String date, @PathVariable String time, @PathVariable String styleId, @PathVariable String custId, @PathVariable String empId)
    {
        Employee emp = new Employee.Builder()
                .id(empId)
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .password("")
                .build();

        Customer cust = new Customer.Builder()
                .id(custId)
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .emp(emp)
                .build();

        Style style = new Style.Builder()
                .id(styleId)
                .name("")
                .price(0)
                .hairLength(0)
                .build();

        Reservation reservation = ReservationFactory.buildReservation(id, date, time, style, cust, emp);
        reservationService.save(reservation);
        return new Gson().toJson(reservation);
    }

    @GetMapping(path = "readReservation/{id}")
    public @ResponseBody String readReservation(@PathVariable String id)
    {
        Reservation reservation = reservationService.findById(id);
        return new Gson().toJson(reservation);
    }

    @GetMapping(path = "/updateReservation/{id}/{date}/{time}/{styleId}/{custId}/{empId}")
    public @ResponseBody String updateReservation(@PathVariable String id, @PathVariable String date, @PathVariable String time, @PathVariable String styleId, @PathVariable String custId, @PathVariable String empId)
    {
        Reservation reservation = reservationService.findById(id);

        if(reservation == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Employee emp = new Employee.Builder()
                .id(empId)
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .password("")
                .build();

        Customer cust = new Customer.Builder()
                .id(custId)
                .name("")
                .surname("")
                .age(0)
                .gender("")
                .cellNumber("")
                .email("")
                .emp(emp)
                .build();

        Style style = new Style.Builder()
                .id(styleId)
                .name("")
                .price(0)
                .hairLength(0)
                .build();

        Reservation reservationInsert = ReservationFactory.buildReservation(id, date, time, style, cust, emp);
        reservationService.update(reservationInsert);
        return new Gson().toJson(reservationInsert);
    }

    @GetMapping(path = "deleteReservation/{id}")
    public @ResponseBody void deleteReservation(@PathVariable String id) {
        Reservation reservation = reservationService.findById(id);
        if (reservation == null) {
            System.out.println("Record does not exist");
        } else {
            reservationService.delete(reservation);
            System.out.println("Record deleted");
        }
    }

    @GetMapping(path = "/addStyle/{id}/{name}/{price}/{hairLength}")
    public @ResponseBody String addStyle(@PathVariable String id, @PathVariable String name, @PathVariable Double price, @PathVariable int hairLength)
    {
        Style style = StyleFactory.buildStyle(id, name, price, hairLength);
        styleService.save(style);
        return new Gson().toJson(style);
    }

    @GetMapping(path = "readStyle/{id}")
    public @ResponseBody String readStyle(@PathVariable String id)
    {
        Style style = styleService.findById(id);
        return new Gson().toJson(style);
    }

    @GetMapping(path = "/updateStyle/{id}/{name}/{price}/{hairLength}")
    public @ResponseBody String updateStyle(@PathVariable String id, @PathVariable String name, @PathVariable Double price, @PathVariable int hairLength)
    {
        Style style = styleService.findById(id);

        if(style == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Style styleInsert = StyleFactory.buildStyle(id, name, price, hairLength);
        styleService.update(styleInsert);
        return new Gson().toJson(styleInsert);
    }

    @GetMapping(path = "deleteStyle/{id}")
    public @ResponseBody void deleteStyle(@PathVariable String id) {
        Style style = styleService.findById(id);
        if (style == null) {
            System.out.println("Record does not exist");
        } else {
            styleService.delete(style);
            System.out.println("Record deleted");
        }
    }
}
