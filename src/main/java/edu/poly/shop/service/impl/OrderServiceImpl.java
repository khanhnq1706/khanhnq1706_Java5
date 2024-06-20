package edu.poly.shop.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.CartItem;
import edu.poly.shop.domain.Order;
import edu.poly.shop.domain.OrderDetail;
import edu.poly.shop.domain.OrderStatus;
import edu.poly.shop.domain.Product;
import edu.poly.shop.repository.OrderDetailRepository;
import edu.poly.shop.repository.OrderRepository;
import edu.poly.shop.service.OrderService;
import edu.poly.shop.service.ShoppingCartService;
@Service
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
ProductServiceImpl productServiceImpl;
OrderDetailRepository detailRepository1;
ShoppingCartService shoppingCartService; // Giả sử bạn đã inject ShoppingCartService

public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository detailRepository, ShoppingCartService shoppingCartService) {
    this.orderRepository = orderRepository;
    this.detailRepository1 = detailRepository;
    this.shoppingCartService = shoppingCartService;
}

// Phương thức để chuyển đổi giỏ hàng thành đơn hàng
public Order createOrderFromCart(Account account) {
    // Tạo một đơn hàng mới
    Order newOrder = new Order();
    newOrder.setOrderDate(new Date());
    newOrder.setDescription("Mô tả đơn hàng");
    newOrder.setOrderStatus(OrderStatus.Pending); // Giả sử OrderStatus là enum
    newOrder.setAccount(account); // Đặt thông tin người dùng cho đơn hàng

    // Chuyển đổi từ CartItem sang OrderDetail và thêm vào đơn hàng
    for (CartItem cartItem : shoppingCartService.getItems()) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(cartItem.getQuantity());
        orderDetail.setUnitPrice(cartItem.getUnitPrice());
        // Lấy thông tin sản phẩm từ cơ sở dữ liệu
        Optional<Product> productOptional = productServiceImpl.findById(cartItem.getProductId());
        try {
        	if (productOptional.isPresent()) {
                Product product = productOptional.get(); // Lấy đối tượng Product nếu có
                orderDetail.setProduct(product); // Gán sản phẩm cho OrderDetail
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        // Thêm vào danh sách chi tiết đơn hàng của đơn hàng mới
        newOrder.getOrderDetails().add(orderDetail);
    }

    // Lưu đơn hàng vào cơ sở dữ liệu
    orderRepository.save(newOrder);

    // Xóa giỏ hàng sau khi đã tạo đơn hàng
    shoppingCartService.clear();

    return newOrder; // Trả về đối tượng đơn hàng mới được tạo
}
}
