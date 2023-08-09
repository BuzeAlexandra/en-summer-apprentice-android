package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ViewHolder.CardViewHolderOrders;
import Models.Order;
import com.example.mydemoapp.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<CardViewHolderOrders> {

    private List<Order> orderList;

    public OrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public CardViewHolderOrders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card, parent, false);
        return new CardViewHolderOrders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolderOrders holder, int position) {
        Order order = orderList.get(position);
        holder.TextOrder.setText(order.getEventName());
        //holder.textNumberOfTickets.setText(order.getNumberOfTickets());
        //holder.textTotalPrice.setText(order.getTotalprice());
        holder.textNumberOfTickets.setText(String.valueOf(order.getNumberOfTickets()));
        holder.textTotalPrice.setText(String.valueOf(order.getTotalprice()));
        holder.orderImage.setImageResource(order.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
