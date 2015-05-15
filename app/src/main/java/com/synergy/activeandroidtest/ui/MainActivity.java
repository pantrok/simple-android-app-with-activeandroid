package com.synergy.activeandroidtest.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.synergy.activeandroidtest.R;
import com.synergy.activeandroidtest.adapters.CategoryAdapter;
import com.synergy.activeandroidtest.beans.User;
import com.synergy.activeandroidtest.services.PartsService;
import com.synergy.activeandroidtest.utils.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private final String TAG = this.getClass().getSimpleName();
    private RecyclerView mRecyclerView;
    private CategoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter = new CategoryAdapter(MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        PartsService service = new PartsService();
        service.loadUserData(1, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                Log.i("TAG", "" + user);
                try {
                    com.synergy.activeandroidtest.data.User userModel = ReflectionUtils.copy(
                            com.synergy.activeandroidtest.data.User.class, user);
                    Log.i("TAG","User model -> " + userModel);
                } catch (InstantiationException e){
                    Log.e("TAG",e.getMessage());
                } catch (IllegalAccessException e) {
                    Log.e("TAG",e.getMessage());
                } catch (InvocationTargetException e) {
                    Log.e("TAG",e.getMessage());
                }
                Toast.makeText(MainActivity.this,"User loaded",Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this,"User not loaded",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_category) {
            startActivity(new Intent(MainActivity.this, AddCategoryActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
