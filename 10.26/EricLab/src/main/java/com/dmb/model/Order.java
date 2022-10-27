package com.dmb.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
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


    public Order() {
    }

    public Order(Date orderDate, Date requiredDate, Date shippedDate, String status, String comments, Integer customerNumber) {
//        this.orderDate = orderDate;
//        this.requiredDate = requiredDate;
//        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;


    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

//    public Date getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(Date orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public Date getRequiredDate() {
//        return requiredDate;
//    }
//
//    public void setRequiredDate(Date requiredDate) {
//        this.requiredDate = requiredDate;
//    }
//
//    public Date getShippedDate() {
//        return shippedDate;
//    }
//
//    public void setShippedDate(Date shippedDate) {
//        this.shippedDate = shippedDate;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}
