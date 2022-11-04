package com.dmb.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "orderNumber")
    private Integer orderNumber;
    //private Date orderDate;
    //private Date requiredDate;
    //private Date shippedDate;
    private String status;
    @Type(type = "text")
    private String comments;
    private Integer customerNumber;




}
