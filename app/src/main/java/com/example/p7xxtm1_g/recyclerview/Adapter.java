package com.example.p7xxtm1_g.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewholder> {
    private Context context;
    private List<Integer> list =new ArrayList<>();

    public Adapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }
    public  void setList(List<Integer> list){
        this.list=list;
    }
    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);

        return new MyViewholder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        holder.img.setImageResource(list.get(position));

    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewholder extends RecyclerView.ViewHolder{

        private final ImageView img;

        public MyViewholder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
