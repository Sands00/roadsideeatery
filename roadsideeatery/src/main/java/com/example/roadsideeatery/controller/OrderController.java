// OrderController.java
package com.example.roadsideeatery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.roadsideeatery.model.Order;
import com.example.roadsideeatery.repository.OrderRepository;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public String showOrderForm(Model model) {
        return "order";  // Make sure you have an order.html Thymeleaf template
    }

    @PostMapping
    public String placeOrder(@RequestParam("items") List<String> items,
                             @RequestParam("quantity") int quantity,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("address") String address,
                             Model model) {
        Order order = new Order();
        order.setItems(items);
        order.setQuantity(quantity);
        order.setName(name);
        order.setEmail(email);
        order.setAddress(address);

        orderRepository.save(order);

        model.addAttribute("order", order);
        return "orderConfirmation.html";  // Make sure you have an order-confirmation.html Thymeleaf template
    }
}
