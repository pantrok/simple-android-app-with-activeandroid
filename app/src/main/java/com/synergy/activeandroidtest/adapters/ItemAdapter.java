package com.synergy.activeandroidtest.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.synergy.activeandroidtest.R;
import com.synergy.activeandroidtest.data.Category;
import com.synergy.activeandroidtest.data.Item;

import java.util.List;

/**
 * Created by daniel on 8/05/15.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Activity mListActivity;
    private List<Item> mItems;

    public ItemAdapter(Activity activity, Category category) {
        mListActivity = activity;
        mItems = new Select().from(Item.class).where("Category = ?", category.getId()).execute();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item,viewGroup,false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.bindCategory(mItems.get(i));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView mItemLabel;

        public ItemViewHolder(View itemView) {
            super(itemView);

            mItemLabel = (TextView) itemView.findViewById(R.id.itemLabel);
        }

        public void bindCategory(Item item) {
            mItemLabel.setText(item.getName());
        }

    }

}
