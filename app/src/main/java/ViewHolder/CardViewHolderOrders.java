package ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydemoapp.R;

public class CardViewHolderOrders extends RecyclerView.ViewHolder{

    public TextView TextOrder;
    public TextView textNumberOfTickets;
    public TextView textTotalPrice;
    public ImageView orderImage;
    public CardViewHolderOrders(@NonNull View itemView) {
        super(itemView);

        TextOrder = itemView.findViewById(R.id.TextOrder);
        textNumberOfTickets = itemView.findViewById(R.id.textNumberOfTickets);
        textTotalPrice = itemView.findViewById(R.id.textTotalPrice);
        orderImage =  itemView.findViewById(R.id.orderImage);
    }
}
