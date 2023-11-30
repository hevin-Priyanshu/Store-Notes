package com.demo.storenotesusingjava;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final Context context;
    private final List<ModelClass> list;

    public MyAdapter(Context context, List<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String itemName = list.get(position).getName();
        String itemNotes = list.get(position).getNotes();

        holder.textViewName.setText(itemName);
        holder.textViewNotes.setText(itemNotes);


        holder.deleteBtn.setOnClickListener(view -> {
            int itemPosition = holder.getAdapterPosition();
            int recyclerViewPosition = RecyclerView.NO_POSITION;
            int listSize = list.size();
            Log.d("check -> itemPosition", String.valueOf(itemPosition));
            Log.d("check -> recyclerView", String.valueOf(recyclerViewPosition));
            Log.d("check -> listSize", String.valueOf(listSize));

            if (itemPosition != recyclerViewPosition && itemPosition < listSize) {
                // ONLY FOR TO SHOW TOAST MASSAGE
                list.remove(itemPosition);
                notifyItemRemoved(itemPosition);
                Context context = holder.itemView.getContext();
                Toast.makeText(context, "Item deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewNotes;
        Button deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewNotes = itemView.findViewById(R.id.textViewNotes);
            deleteBtn = itemView.findViewById(R.id.delete_btn);
        }
    }
}
