package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import Connection.ApiService;
import Dto.EventDto;
import Adapter.EventAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.mydemoapp.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<EventDto> eventList;
    private EventAdapter eventAdapter;
    private SearchView searchView;
    private Button btnAllOrders;
    private Button btnBuy;

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAllOrders = findViewById(R.id.buttonOrders);

        btnAllOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               openAllOrdersActivity();
            }
        });






        searchView =findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });


       // recyclerView = findViewById(R.id.viewAllEvents);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //eventList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:7298/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);


        //eventList.add(new Event("Electric Castle", "Festival",R.drawable.electric_castle ,"Bontida"));
        //eventList.add(new Event("Untold", "Festival",R.drawable.untold2, "Cluj-Napoca"));
        //eventList.add(new Event("Meci de Fotbal","Fotbal", R.drawable.fotbal4,"Cluj-Napoca"));
        //eventList.add(new Event("Wine Festival","Festival de vinuri", R.drawable.vinuri,"Cluj-Napoca"));
        //eventAdapter = new EventAdapter(eventList);
        //recyclerView.setAdapter(eventAdapter);
        //eventAdapter = new EventAdapter(eventList, this);
        //recyclerView.setAdapter(eventAdapter);

        recyclerView = findViewById(R.id.viewAllEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventList = new ArrayList<>();
        eventAdapter = new EventAdapter(eventList, this);
        recyclerView.setAdapter(eventAdapter);

        Call<List<EventDto>> call = apiService.getAllEvents();
        call.enqueue(new Callback<List<EventDto>>() {
            @Override
            public void onResponse(Call<List<EventDto>> call, Response<List<EventDto>> response) {
                if (response.isSuccessful()) {
                    List<EventDto> eventDtoList = response.body();
                    List<EventDto> events = convertToEventDtos(eventDtoList);
                    eventAdapter = new EventAdapter(events, MainActivity.this);
                    recyclerView.setAdapter(eventAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get events", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<EventDto>> call, Throwable t) {

                Log.e("NetworkError", "Failed to fetch events", t);
                Toast.makeText(MainActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private List<EventDto> convertToEventDtos(List<EventDto> eventList) {
        List<EventDto> eventDtos = new ArrayList<>();
        for (EventDto event : eventList) {
            EventDto eventDto = new EventDto(
                    event.getEventName(),
                    event.getEventDescription(),
                    event.getVenue()
            );
            eventDtos.add(eventDto);
        }
        return eventDtos;
    }
    public void  openBuyPage(){
        Intent intent = new Intent(this,BuyButton.class);
        startActivity(intent);
}
    public void openAllOrdersActivity(){
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        startActivity(intent);
    }
    private void filterList(String newText){
        List<EventDto> filteredList = new ArrayList<>();
        for(EventDto event : eventList){
            if(event.getEventName().toLowerCase().contains(newText.toLowerCase()));
            {
                filteredList.add(event);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else{
            eventAdapter.setFilteredList(filteredList);
        }
    }


}



