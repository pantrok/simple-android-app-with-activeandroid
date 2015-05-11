package com.synergy.activeandroidtest.ui;

import android.content.Intent;
import android.provider.BaseColumns;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.activeandroid.query.Select;
import com.activeandroid.util.SQLiteUtils;
import com.google.gson.GsonBuilder;
import com.synergy.activeandroidtest.R;
import com.synergy.activeandroidtest.adapters.ItemAdapter;
import com.synergy.activeandroidtest.data.Category;

public class ListItemCategoryActivity extends ActionBarActivity {

    private ItemAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_category);

        Long categoryId = getIntent().getLongExtra("id_category", 0);
        Log.i("TAG", "Category id " + categoryId);
        category = SQLiteUtils.rawQuerySingle(Category.class,
                "SELECT * FROM Categories WHERE Id = ?",
                new String[]{String.valueOf(categoryId)});
        Log.i("TAG",""+category);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter = new ItemAdapter(ListItemCategoryActivity.this,category);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_item_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_item) {
            Intent intent = new Intent(ListItemCategoryActivity.this, AddItemActivity.class);
            intent.putExtra("id_category",category.getId());
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
