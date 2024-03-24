package com.mertkoroglu.project487;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomRecyclerViewItemHolder> {
    private Context context;
    private ArrayList<Course> recyclerItemValues;
    Intent intent;

    public CustomRecyclerViewAdapter(Context context, ArrayList<Course> recyclerItemValues) {
        this.context = context;
        this.recyclerItemValues = recyclerItemValues;
    }

    @NonNull
    @Override
    public CustomRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflator.inflate(R.layout.recycler_item, viewGroup, false);
        CustomRecyclerViewItemHolder mViewHolder = new CustomRecyclerViewItemHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerViewItemHolder myRecyclerViewItemHolder, int i) {
        final Course curentItem = recyclerItemValues.get(i);

        myRecyclerViewItemHolder.tv.setText(curentItem.getCourseName());
        myRecyclerViewItemHolder.img.setImageResource(curentItem.getImgId());

        myRecyclerViewItemHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, StartActivity.class);
                intent.putExtra("Course", curentItem);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recyclerItemValues.size();
    }

    class CustomRecyclerViewItemHolder extends  RecyclerView.ViewHolder{
        TextView tv;
        ImageView img;
        LinearLayout parentLayout;
        public CustomRecyclerViewItemHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvItem_course);
            img = itemView.findViewById(R.id.imgItem_course);
            parentLayout = itemView.findViewById(R.id.lyItem_course);
        }
    }
}
