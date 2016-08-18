package com.example.collapsingtoolbarlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fenghui on 7/29/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener=mOnItemClickListener;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ViewHolder(View arg0){
            super(arg0);
        }
        TextView title;
        TextView content;
    }
    private LayoutInflater mInflater;
    private List<String> mData;
    private List<String> nData;

    public MyAdapter(Context context, List<String> mData,List<String> nData){
        this.mData=mData;
        this.nData=nData;
        mInflater=LayoutInflater.from(context);
    }
    @Override
    public int getItemCount(){
        return mData.size();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewgroup,int position){
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.cardview,viewgroup,false);
        ViewHolder holder = new ViewHolder(view);
        holder.title=(TextView)view.findViewById(R.id.title);
        holder.content=(TextView)view.findViewById(R.id.content);
        return holder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position){
        holder.title.setText(mData.get(position));
        holder.content.setText(nData.get(position));
        if(mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    mOnItemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }
    }

}
