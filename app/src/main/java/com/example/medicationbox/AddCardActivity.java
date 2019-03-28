package com.example.medicationbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class AddCardActivity extends AppCompatActivity {
    private Button confirm;
    private EditText inputNumber, inputCardholder, inputExpiry, inputCsv;

    protected void onCreate(Bundle savedInstanceState, final User usr) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcard);

        confirm = (Button) findViewById(R.id.confirm);
        inputNumber = findViewById(R.id.number);
        inputCardholder = findViewById(R.id.cardholder);
        inputExpiry = findViewById(R.id.expiry);
        inputCsv = findViewById(R.id.csv);

        confirm.setOnClickListener(new View.OnClickListener() {
            String number = inputNumber.getEditableText().toString().trim();
            String cardholder = inputCardholder.getEditableText().toString().trim();
            String expiry = inputExpiry.getEditableText().toString().trim();
            String csv = inputCsv.getEditableText().toString().trim();

            public void onClick(View view) {
                int i;
                for(i = 0; usr.pmt[i] != null; i++);
                try {
                    usr.pmt[i] = new Card(Integer.parseInt(number), cardholder, new SimpleDateFormat("MM,yy").parse(expiry), Integer.parseInt(csv));
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error parsing expiry date.", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(), "Payment successfully added.", Toast.LENGTH_LONG).show();
            }
        });
    }
}