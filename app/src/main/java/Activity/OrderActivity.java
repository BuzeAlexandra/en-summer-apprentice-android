package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Models.Order;
import Adapter.OrderAdapter;
import com.example.mydemoapp.R;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Order> orderList;
    private OrderAdapter orderAdapter;
    private Button backBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_orders);


        recyclerView = findViewById(R.id.viewAllOrders);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderList = new ArrayList<>();

        orderList.add(new Order("Electric Castle", 2, 300, R.drawable.electric_castle));
        orderList.add(new Order("Untold", 2, 2100, R.drawable.untold2));
        orderList.add(new Order("Meci de Fotbal", 2, 400, R.drawable.fotbal4));
        orderList.add(new Order("Wine Festival", 3, 5000, R.drawable.vinuri));
        System.out.println(orderList);
        orderAdapter = new OrderAdapter(orderList);
        recyclerView.setAdapter(orderAdapter);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}