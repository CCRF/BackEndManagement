package cn.edu.guet.backendmanagement.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
    private BigInteger id;

//    @DateTimeFormat(pattern="yyy-MM-dd HH:mm:ss")
    //解决入参时时间格式的调整
    private String startTime;

    private String list;

    private BigDecimal amount;

    private Integer orderStatus;
    //订单状态，0表示订单进行中，-1表示订单失败，1表示订单成功并结束

    private String message;

    private BigInteger customerId;

    public BigInteger getCustomerId() {
        return customerId;
    }

    public Order setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
        return this;
    }

    public BigInteger getId() {
        return id;
    }

    public Order setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public Order setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getList() {
        return list;
    }

    public Order setList(String list) {
        this.list = list;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Order setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Order setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(startTime, order.startTime) &&
                Objects.equals(list, order.list) &&
                Objects.equals(amount, order.amount) &&
                Objects.equals(orderStatus, order.orderStatus) &&
                Objects.equals(message, order.message) &&
                Objects.equals(customerId, order.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, list, amount, orderStatus, message, customerId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", list='" + list + '\'' +
                ", amount=" + amount +
                ", orderStatus=" + orderStatus +
                ", message='" + message + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
