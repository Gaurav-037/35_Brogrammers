package com.example.easyed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {
    Context context;
    String []bankNames;
    int [] images;

    public recyclerAdapter(Context context, String[] bankNames, int[] images){
        this.context= context;
        this.bankNames= bankNames;
        this.images= images;
    }

    @NonNull
    @Override
    public recyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row,parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.ViewHolder holder, int position) {
        holder.rowImage.setImageResource(images[position]);
        holder.rowName.setText(bankNames[position]);
    }

    @Override
    public int getItemCount() {

        return bankNames.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowName;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName=itemView.findViewById(R.id.textView9);
            rowImage= itemView.findViewById(R.id.imageView);
        }
    }
    public interface onClickList{
        void onCLick(int pos);
    }
}
