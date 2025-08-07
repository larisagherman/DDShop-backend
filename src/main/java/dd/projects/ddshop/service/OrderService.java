package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.OrderDTORequest;
import dd.projects.ddshop.dto.OrderDTOResponse;
import dd.projects.ddshop.entity.Cart;
import dd.projects.ddshop.entity.Order;
import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.mapper.AddressMapper;
import dd.projects.ddshop.mapper.OrderMapper;
import dd.projects.ddshop.repository.CartRepository;
import dd.projects.ddshop.repository.OrderRepository;
import dd.projects.ddshop.repository.UserRepository;
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
    private final EmailService emailService;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    @Transactional
    public void createOrder(OrderDTORequest orderDTORequest) {
        User user = userRepository.findById(orderDTORequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findById(orderDTORequest.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Create new order with current cart
        Order newOrder = orderMapper.dtoRequestToEntity(orderDTORequest);
        newOrder.setUserId(user);
        newOrder.setCartId(cart);
        orderRepository.save(newOrder);

        // Disable the old cart
        cart.setActive(false);
        System.out.println(cart.isActive()+" "+cart.getId());
        cartRepository.save(cart);



        emailService.sendOrderConfirmationEmail(newOrder);
    }


    public List<OrderDTOResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.entityListToDtoResponseList(orders);
    }

    public void updateOrder(Integer id, OrderDTORequest orderDTORequest) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("No order found with id: " + id));
        existingOrder.setOrderDate(orderDTORequest.getOrderDate());
        existingOrder.setDeliveryAddress(addressMapper.dtoRequestToEntity(orderDTORequest.getDeliveryAddress()));
        existingOrder.setInvoiceAddress(addressMapper.dtoRequestToEntity(orderDTORequest.getInvoiceAddress()));
        existingOrder.setPaymentType(orderDTORequest.getPaymentType());
        existingOrder.setTotalPrice(orderDTORequest.getTotalPrice());
        orderRepository.save(existingOrder);
    }
    @Transactional
    public void deleteOrder(Integer id) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(existingOrder);
    }

    public List<OrderDTOResponse> getAllOrdersByUserId(Integer userId) {
        List<Order> orders = orderRepository.findAllByUserId_Id(userId);
        return orderMapper.entityListToDtoResponseList(orders);
    }
}
