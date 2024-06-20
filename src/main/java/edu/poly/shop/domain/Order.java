package edu.poly.shop.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "[Orders]")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@Temporal(TemporalType.DATE)
	private  Date orderDate;
	@Column(columnDefinition = "nvarchar(255)")
	private String description;
	@Column(nullable = false)
	private OrderStatus orderStatus;
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;
	public void preCreate() {
		orderDate = new Date();
	}
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;
}
