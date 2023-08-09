package ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mydemoapp.R;

public class CardViewHolder extends RecyclerView.ViewHolder {
    public TextView textTitle;
    public TextView textDescription;
    public TextView textVenue;
    public ImageView imageView;
    public Button btnBuy;

    public CardViewHolder(View itemView) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.textTitle);
        textDescription = itemView.findViewById(R.id.textDescription);
        textVenue = itemView.findViewById(R.id.textVenue);
        imageView =  itemView.findViewById(R.id.imageView);
        btnBuy = itemView.findViewById(R.id.btnBuy);

    }
}