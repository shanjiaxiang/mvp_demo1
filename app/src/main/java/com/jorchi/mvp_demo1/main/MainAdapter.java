package com.jorchi.mvp_demo1.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jorchi.mvp_demo1.R;

import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private List<String> items;
    private OnItemClickListener listener;

    interface OnItemClickListener {
        void onItemClicked(int position);
    }

    public MainAdapter(List<String> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_main_item, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        final String item = items.get(position);
        holder.textView.setText(item);
        holder.textView.setOnClickListener(v -> {
            listener.onItemClicked(position);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MainHolder(TextView itemView) {
            super(itemView);
            this.textView = itemView;
        }
    }
}
