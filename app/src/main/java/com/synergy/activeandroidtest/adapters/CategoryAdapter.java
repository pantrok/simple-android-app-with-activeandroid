package com.synergy.activeandroidtest.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.synergy.activeandroidtest.R;
import com.synergy.activeandroidtest.data.Category;
import com.synergy.activeandroidtest.ui.ListItemCategoryActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 8/05/15.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Activity mListActivity;
    private List<Category> mCategories;

    public CategoryAdapter(Activity activity) {
        mListActivity = activity;
        mCategories = new Select().from(Category.class).execute();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_item,viewGroup,false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.bindCategory(mCategories.get(i));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mCategoryLabel;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            mCategoryLabel = (TextView) itemView.findViewById(R.id.categoryLabel);
            itemView.setOnClickListener(this);
        }

        public void bindCategory(Category category) {
            mCategoryLabel.setText(category.getName());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mListActivity, ListItemCategoryActivity.class);
            Category category = mCategories.get(getPosition());
            intent.putExtra("id_category",category.getId());
            mListActivity.startActivity(intent);
        }
    }

}
