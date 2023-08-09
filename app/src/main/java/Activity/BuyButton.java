package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mydemoapp.R;

public class BuyButton extends AppCompatActivity {
    private TextView ticketCountTextView;
    private Button increaseButton;
    private Button decreaseButton;
    private Button btnBack;
    private Button cancelBtn;
    private int ticketCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_button);
        cancelBtn = findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ticketCountTextView = findViewById(R.id.noOfTickets);
        increaseButton = findViewById(R.id.increase);
        decreaseButton = findViewById(R.id.decrease);

        updateTicketCount();

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketCount++;
                updateTicketCount();
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ticketCount > 1) {
                    ticketCount--;
                    updateTicketCount();
                }
            }
        });
        btnBack= findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Button buyOrderButton = findViewById(R.id.buyOrder);
        buyOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuyPage();
            }
        });

    }
    private void updateTicketCount() {
        ticketCountTextView.setText(String.valueOf(ticketCount));
    }
    private void showPaymentSuccessfulDialog() {

        Dialog paymentDialog = new Dialog(this);
        paymentDialog.setContentView(R.layout.dialog_payment_successful);


        Button btnDismiss = paymentDialog.findViewById(R.id.btnDismiss);
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paymentDialog.dismiss();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(BuyButton.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            }
        });


        paymentDialog.show();
    }

    public void openBuyPage() {

        showPaymentSuccessfulDialog();

    }
}