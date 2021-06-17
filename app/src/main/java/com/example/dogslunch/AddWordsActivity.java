package com.example.dogslunch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dogslunch.RoomData.Words;
import com.example.dogslunch.RoomData.WordsDatabase;

public class AddWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_room);
        EditText word = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewWord(word.getText().toString());
            }
        });
    }

    private void addNewWord(String word) {
        WordsDatabase db = WordsDatabase.getDbInstance(this.getApplicationContext());
        Words words = new Words();
        words.word = word;

        db.wordsDao().insertWords(words);
        finish();
    }

 
}