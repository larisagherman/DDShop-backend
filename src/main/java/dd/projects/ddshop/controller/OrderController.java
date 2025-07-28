package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.OrderDTORequest;
import dd.projects.ddshop.dto.OrderDTOResponse;
import dd.projects.ddshop.entity.Order;
import dd.projects.ddshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public void createOrder(@RequestBody  OrderDTORequest orderDTORequest) {
        orderService.createOrder(orderDTORequest);
    }
    @GetMapping
    public List<OrderDTOResponse> getOrders() {
        return orderService.getAllOrders();
    }
    @PutMapping("{id}")
    public void updateOrder(@PathVariable Integer id, @RequestBody OrderDTORequest orderDTORequest) {
        orderService.updateOrder(id, orderDTORequest);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Order was deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public List<OrderDTOResponse> getOrdersByUserId(@PathVariable Integer userId) {
        return orderService.getAllOrdersByUserId(userId);
    }
}
