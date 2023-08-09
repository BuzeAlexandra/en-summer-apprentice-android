package Dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OrderDto {
    public int OrderId;

    public int UserId;

    public int TicketCategoryId;

    @SerializedName("activity")
    public Date OrderedAt;

    public int NumberOfTickets;
    public int TotalPrice;

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getTicketCategoryId() {
        return TicketCategoryId;
    }

    public void setTicketCategoryId(int ticketCategoryId) {
        TicketCategoryId = ticketCategoryId;
    }

    public Date getOrderedAt() {
        return OrderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        OrderedAt = orderedAt;
    }

    public int getNumberOfTickets() {
        return NumberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        NumberOfTickets = numberOfTickets;
    }

    public OrderDto(Date orderedAt, int numberOfTickets, int totalPrice) {
        OrderedAt = orderedAt;
        NumberOfTickets = numberOfTickets;
        TotalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }




}
