package com.davidlacho.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.davidlacho.interactivestory.R;

public class MainActivity extends AppCompatActivity {

  private EditText nameField;
  private Button startButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    nameField = findViewById(R.id.nameEditText);
    startButton = findViewById(R.id.startButton);

    startButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        String name = nameField.getText().toString();
//        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
        startStory(name);
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();
    nameField.setText("");
  }

  private void startStory(String name) {
    Intent intent = new Intent(this, StoryActivity.class);
    Resources resources = getResources();
    intent.putExtra(resources.getString(R.string.key_name), name);
    startActivity(intent);
  }
}
