package edu.poly.shop.model;
import java.util.Date;



import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
		private Long productId;

		private Integer quantity;

		private String name;

		private Double unitPrice;

		private Double discount;

		private String imageUrl;
		private MultipartFile imageFile;
		private String description;

		private Date enteredDate ;

		private short productStatus;
		

}
