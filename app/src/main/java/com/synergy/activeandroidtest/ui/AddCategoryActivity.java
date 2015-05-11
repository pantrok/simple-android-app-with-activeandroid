package com.synergy.activeandroidtest.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.synergy.activeandroidtest.R;
import com.synergy.activeandroidtest.data.Category;

public class AddCategoryActivity extends ActionBarActivity {

    private EditText mCategoryText;
    private Button mCategoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        mCategoryText = (EditText) findViewById(R.id.categoryText);
        mCategoryButton = (Button) findViewById(R.id.addCategoryButton);
        mCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category category = new Category(mCategoryText.getText().toString());
                category.save();
                Toast.makeText(AddCategoryActivity.this, "Categoria guardada", Toast.LENGTH_LONG).show();
                AddCategoryActivity.this.finish();
            }
        });
    }
}
