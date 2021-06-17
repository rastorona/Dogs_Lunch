package com.example.dogslunch;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

    TextView number;
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        number = (TextView) findViewById(R.id.textView3);

        details = (TextView) findViewById(R.id.textView4);

        Intent intent = getIntent();

        String Id_item = intent.getStringExtra("ARG_ITEM_ID");
        number.setText(Id_item);

        String Details = intent.getStringExtra("Detailed");
        details.setText(Details);


    }

}
