package com.ijse.bookStore.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookStore.entity.OrderDetail;
import com.ijse.bookStore.service.BookService;
import com.ijse.bookStore.service.OrderDetailService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    BookService bookService;

    @GetMapping("/admin/orderdetail")
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.getAllOrderDetails());
    }

    @GetMapping("/orderdetail/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id) {
        try {
            OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
            return ResponseEntity.status(HttpStatus.OK).body(orderDetail);
        } catch (NoSuchElementException e)

        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e)

        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/orderdetail")
    public ResponseEntity<OrderDetail> saveOrderDetail(@RequestBody OrderDetail orderDetail) {
        try {
            OrderDetail newOrderDetail = orderDetailService.createOrderDetail(orderDetail);
            bookService.updateBookQoh(orderDetail.getBook().getId(), orderDetail.getQuantity());
            return ResponseEntity.status(HttpStatus.OK).body(newOrderDetail);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/orderdetail/{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {
        try {
            OrderDetail updatedOrderDetail = orderDetailService.updateOrderDetail(id, orderDetail);
            return ResponseEntity.status(HttpStatus.OK).body(updatedOrderDetail);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/orderdetail/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        try {

            orderDetailService.deleteOrderDetail(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
