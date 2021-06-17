package com.example.dogslunch;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogslunch.RoomData.Words;
import com.example.dogslunch.RoomData.WordsDatabase;
import com.example.dogslunch.RoomData.WordsListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DetailActivity extends Activity {
    private WordsListAdapter wordsListAdapter;
    static WordsDatabase db;

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

        initRecyclerView();
        loadWordsList();

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.dogslunch.DetailActivity.this, AddWordsActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.RecV);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        db = WordsDatabase.getDbInstance(getApplicationContext());
        List<Words> wordsList = db.wordsDao().getAllWords();
        wordsListAdapter = new WordsListAdapter(wordsList);
        recyclerView.setAdapter(wordsListAdapter);
    }
    private void loadWordsList(){
        WordsDatabase db = WordsDatabase.getDbInstance(this.getApplicationContext());
        List<Words> wordsList = db.wordsDao().getAllWords();
        wordsListAdapter.setUserList(wordsList);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            loadWordsList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadWordsList();
    }
}



