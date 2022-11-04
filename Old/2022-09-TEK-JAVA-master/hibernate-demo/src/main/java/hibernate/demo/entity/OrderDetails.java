package hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orderdetails")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderNumber;
	
	@Column(name = "productCode")
	private String productCode;
	
	@Column(name = "quantityOrdered")
	private Integer quantityOrdered;
	
	@Column(name = "priceEach", columnDefinition="decimal", precision=10, scale=2)
	private Double priceEach;
	
	@Column(name = "orderLineNumber", columnDefinition="smallint")
	private Integer orderLineNumber; 
	
}
