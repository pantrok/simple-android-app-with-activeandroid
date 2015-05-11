package com.synergy.activeandroidtest.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.util.SQLiteUtils;
import com.synergy.activeandroidtest.R;
import com.synergy.activeandroidtest.data.Category;
import com.synergy.activeandroidtest.data.Item;

public class AddItemActivity extends ActionBarActivity {

    private EditText mItemText;
    private Button mItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Long categoryId = getIntent().getLongExtra("id_category", 0);
        Log.i("TAG", "Category id " + categoryId);
        final Category category = SQLiteUtils.rawQuerySingle(Category.class,
                "SELECT * FROM Categories WHERE Id = ?",
                new String[]{String.valueOf(categoryId)});
        Log.i("TAG", "" + category);

        mItemText = (EditText) findViewById(R.id.itemText);
        mItemButton = (Button) findViewById(R.id.addItemButton);
        mItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item(mItemText.getText().toString(),category);
                item.save();
                Toast.makeText(AddItemActivity.this, "Categoria guardada", Toast.LENGTH_LONG).show();
                AddItemActivity.this.finish();
            }
        });
    }

}
