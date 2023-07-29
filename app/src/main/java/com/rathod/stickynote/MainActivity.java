package com.rathod.stickynote;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    StickyNote note = new StickyNote();
    @Override
    protected void
    onCreate(android.os.Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        mEditText = findViewById(R.id.editText);
        mEditText.setText(note.getStick(this));
    }


    public void updateWidget() {

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.widget_layout);
        ComponentName thisWidget = new ComponentName(this, AppWidget.class);
        remoteViews.setTextViewText(R.id.appwidget_text, mEditText.getText().toString());
        appWidgetManager.updateAppWidget(thisWidget, remoteViews);
    }
    public void saveButton(android.view.View v) {
        note.setStick(mEditText.getText().toString(), this);
        updateWidget();
        Toast.makeText(this, "Updated Successfully!!", Toast.LENGTH_SHORT).show();
    }
}