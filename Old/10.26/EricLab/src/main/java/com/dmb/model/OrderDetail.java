package com.dmb.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "orderdetails")
public class OrderDetail implements Serializable {

    @Id
    private Integer orderNumber;
//    @ManyToOne
//    private Order order;
    private String productCode;
    private int quantityOrdered;

//    @Type(type = "big_decimal")
    @Column(name = "priceEach", columnDefinition = "decimal", precision = 10, scale = 2)
    private Double priceEach;

    @Column(name = "orderLineNumber", columnDefinition = "smallint")
    private Short orderLineNumber;


}
