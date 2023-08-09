package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import Activity.BuyButton;
import Activity.MainActivity;
import Dto.EventDto;
import ViewHolder.CardViewHolder;
import Models.Event;
import com.example.mydemoapp.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<EventDto> eventList;
    //
    private Context context;

    /*public EventAdapter(List<EventDto> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }*/

    public EventAdapter(List<EventDto> eventList) {
        this.eventList = eventList;
    }

    public EventAdapter(List<EventDto> events, MainActivity context) {
       this.eventList=events;
       this.context=context;

    }

    public void setFilteredList(List<EventDto> filteredList){
        this.eventList = filteredList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        EventDto event = eventList.get(position);
        holder.textTitle.setText(event.getEventName());
        holder.textDescription.setText(event.getEventDescription());
        holder.textVenue.setText(event.getVenue());
        //holder.imageView.setImageResource(event.getImageResourceId());


        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuyPage();
            }
        });
    }
    private void openBuyPage() {
        Intent intent = new Intent(context, BuyButton.class);
        context.startActivity(intent);
    }



    @Override
    public int getItemCount() {
        return eventList.size();
    }


}
