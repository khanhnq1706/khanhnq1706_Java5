package edu.poly.shop.domain;

import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	@SuppressWarnings("deprecation")
	@Column(columnDefinition = "nvarchar(100)")
	@NotEmpty(message = "Name mustbe entered !")
	@Length(max = 50, min = 5, message = "Length is between 5 and 50")
	private String name;
	@OneToMany(mappedBy = "category")
	List<Product> products;
}
