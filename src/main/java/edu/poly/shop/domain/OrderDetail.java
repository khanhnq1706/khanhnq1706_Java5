package edu.poly.shop.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderDetails1")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailId;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double unitPrice;
	@Column(columnDefinition = "nvarchar(255)")
	private String notes;
	@Column(nullable = false)
	private Float discount;
	@ManyToOne
	@JoinColumn(name = "productId")
	Product product;
	@ManyToOne
	@JoinColumn(name = "orderId")
	Order  order;
}
