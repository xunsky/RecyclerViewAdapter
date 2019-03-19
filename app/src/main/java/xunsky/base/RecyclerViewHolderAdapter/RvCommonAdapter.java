package xunsky.base.RecyclerViewHolderAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junx on 2017/11/14.
 */

public abstract class RvCommonAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    //构造器
    private Context mContext;
    public List<T> mDatas;
    protected LayoutInflater mLayoutInflater;
    public RvCommonAdapter(Context context, List<T> datas) {
        mContext = context;
        mDatas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }
    //通用操作
    @Override
    public int getItemCount() {
        return mDatas!=null?mDatas.size():0;
    }
    @Override
    public  VH onCreateViewHolder(ViewGroup parent, int viewType){
        View view=inflateItemView(mLayoutInflater,parent,viewType);
        return createViewHolder(view,viewType);
    }
    public abstract View inflateItemView(LayoutInflater layoutInflater, ViewGroup parent, int viewType);
    public abstract VH createViewHolder(View itemView,int viewType);

    @Override
    public void onBindViewHolder(VH holder, final int position){
        T data=position<mDatas.size()?mDatas.get(position):null;
        if (data==null)return;
        if (mListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.OnItemClick(v,position);
                }
            });
        }
        bindDatas(holder,data,position);
    }
    protected abstract void bindDatas(VH holder, T data, int position);

    //datas相关
    public List<T> getDatas(){
        return mDatas;
    }
    public void setDatas(List<T> datas){
        mDatas=datas;
        notifyDataSetChanged();
    }
    public void addData(T data){
        mDatas.add(data);
        notifyDataSetChanged();
    }
    public void addData(T data,int position){
        mDatas.add(position,data);
        notifyDataSetChanged();
    }
    public void addAllDatas(ArrayList<T> datas){
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    //点击事件
    public interface OnItemClickListener{
        public void OnItemClick(View item, int position);
    }
    OnItemClickListener mListener;
    public void setItemClickListener(OnItemClickListener onItemClickListener){
        mListener=onItemClickListener;
    }
}
