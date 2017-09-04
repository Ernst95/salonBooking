package com.salonbooking;

import com.google.gson.Gson;
import com.salonbooking.domain.*;
import com.salonbooking.factories.*;
import com.salonbooking.services.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping(path = "/addReceipt/{id}")
    public @ResponseBody String addReceipt(@PathVariable String id)
    {

        Date date = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Receipt receipt = ReceiptFactory.buildReceipt(id, date);
        receiptService.save(receipt);
        return new Gson().toJson(receipt);
    }

    @GetMapping(path = "readReceipt/{id}")
    public @ResponseBody String readReceipt(@PathVariable String id)
    {
        Receipt receipt = receiptService.findById(id);
        return new Gson().toJson(receipt);
    }

    @GetMapping(path = "/updateReceipt/{id}")
    public @ResponseBody String updateReceipt(@PathVariable String id)
    {
        Receipt receipt = receiptService.findById(id);
        Date date = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        if(receipt == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Receipt receiptInsert = ReceiptFactory.buildReceipt(id, date);
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

    @GetMapping(path = "/addReservation/{id}/{date}/{time}")
    public @ResponseBody String addReservation(@PathVariable String id, @PathVariable String date, @PathVariable String time)
    {
        Reservation reservation = ReservationFactory.buildReservation(id, date, time);
        reservationService.save(reservation);
        return new Gson().toJson(reservation);
    }

    @GetMapping(path = "readReservation/{id}")
    public @ResponseBody String readReservation(@PathVariable String id)
    {
        Reservation reservation = reservationService.findById(id);
        return new Gson().toJson(reservation);
    }

    @GetMapping(path = "/updateReservation/{id}/{date}/{time}")
    public @ResponseBody String updateReservation(@PathVariable String id, @PathVariable String date, @PathVariable String time)
    {
        Reservation reservation = reservationService.findById(id);

        if(reservation == null)
        {
            return new Gson().toJson("Record does not exist");
        }

        Reservation reservationInsert = ReservationFactory.buildReservation(id, date, time);
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
