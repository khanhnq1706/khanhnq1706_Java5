package edu.poly.shop.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@Column(nullable = false)
	private Integer quantity;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;
	@Column(nullable = false)
	private Double unitPrice;
	@Column(nullable = false)
	private Double discount;
	@Column(length = 100)
	private String imageUrl;
	@Column(columnDefinition = "nvarchar(255) not null")
	private String description;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enteredDate ;
	@Enumerated(EnumType.STRING)
	private ProductStatus productStatus;
	@PrePersist
	public void preCreate() {
		enteredDate = new Date();
	}
	@ManyToOne @JoinColumn(name = "categoryId")
	Category category;
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
	
}
