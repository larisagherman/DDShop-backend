package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.OrderDTORequest;
import dd.projects.ddshop.dto.OrderDTOResponse;
import dd.projects.ddshop.entity.Order;
import dd.projects.ddshop.mapper.AddressMapper;
import dd.projects.ddshop.mapper.OrderMapper;
import dd.projects.ddshop.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final AddressMapper addressMapper;
    public void createOrder(OrderDTORequest orderDTORequest) {
        Order newOrder = orderMapper.dtoRequestToEntity(orderDTORequest);
        orderRepository.save(newOrder);
    }

    public List<OrderDTOResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.entityListToDtoResponseList(orders);
    }

    public void updateOrder(Integer id, OrderDTORequest orderDTORequest) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingOrder.setOrderDate(orderDTORequest.getOrderDate());
//        existingOrder.setDeliveryAddress(addressMapper.dtoRequestToEntity(orderDTORequest.getDeliveryAddress()));
//        existingOrder.setInvoiceAddress(addressMapper.dtoRequestToEntity(orderDTORequest.getInvoiceAddress()));
        existingOrder.setPaymentType(orderDTORequest.getPaymentType());
        existingOrder.setTotalPrice(orderDTORequest.getTotalPrice());
        orderRepository.save(existingOrder);
    }
    @Transactional

    public void deleteOrder(Integer id) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(existingOrder);
    }
}
