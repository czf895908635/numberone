package com.example.myapplication_nihao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication_nihao.R;
import com.example.myapplication_nihao.bean.student;

import java.util.List;

/**
 * Created by 齐天大圣 on 2017/12/18.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<student.InfoListBean> infoList;
    public static final int ONE_ITEM = 1;
    public static final int TWO_ITEM = 2;

    public RecyclerAdapter(Context context, List<student.InfoListBean> infoList) {
        this.context = context;
        this.infoList = infoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflat = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder;
        if(ONE_ITEM==viewType){
            View inflate = inflat.inflate(R.layout.adapterone,parent,false);
            holder = new Holder(inflate);
            inflate.setOnClickListener(this);

        }else {
            View inflate = inflat.inflate(R.layout.adaptertwo,parent,false);
            holder=new HolderOne(inflate);
            inflate.setOnClickListener(this);
        }

        return holder;


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        student.InfoListBean infoListBean = infoList.get(position);
        if(holder instanceof Holder){
            Glide.with(context).load(infoListBean.getImg()+"").into(((Holder) holder).imageView);
            ((Holder) holder).textView.setText(infoListBean.getGoods_name()+"");
            ((Holder) holder).textViewone.setText(infoListBean.getIntegral()+"");
            holder.itemView.setTag(position);

        }else if(holder instanceof HolderOne){
            Glide.with(context).load(infoListBean.getImg()).into(((HolderOne) holder).imageView);
            ((HolderOne) holder).textView.setText(infoListBean.getGoods_name()+"");
            ((HolderOne) holder).textViewone.setText(infoListBean.getIntegral()+"");
            holder.itemView.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(Integer.parseInt(infoList.get(position).getType())==1){
           return ONE_ITEM;
        }else {
            return TWO_ITEM;
        }

    }
    public void notify(List<student.InfoListBean> infoList){
        this.infoList=infoList;
        notifyDataSetChanged();
    }
    public interface onClick{
        void setItem(View v,int possiton);

    }
    private onClick item =null;

    @Override
    public void onClick(View view) {
        if(item!=null){
            item.setItem(view,(int)view.getTag());

        }
    }
    public void setListener(onClick item){
        this.item=item;
    }

    class Holder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textViewone;
        public Holder(View itemView) {
            super(itemView);

            imageView= (ImageView) itemView.findViewById(R.id.imageview);
            textView= (TextView) itemView.findViewById(R.id.textview);
            textViewone= (TextView) itemView.findViewById(R.id.textviewone);
        }


    }

    class HolderOne extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textViewone;
        public HolderOne(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageview);
            textView= (TextView) itemView.findViewById(R.id.textview);
            textViewone= (TextView) itemView.findViewById(R.id.textviewone);
        }
    }
}
