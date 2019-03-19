package xunsky.base.RecyclerViewHolderAdapter;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xunsky.base.RecyclerViewHolderAdapter.RvCommonAdapter;
import xunsky.base.RecyclerViewHolderAdapter.RvCommonHolder;


/**
 * Created by junx on 2017/11/14.
 */

public abstract class RvAdapter<T> extends RvCommonAdapter<T, RvCommonHolder> {

    @LayoutRes
    int mLayoutResId;
    public RvAdapter(Context context, List<T> datas, @LayoutRes int layoutResId) {
        super(context, datas);
        mLayoutResId=layoutResId;
    }

    @Override
    public View inflateItemView(LayoutInflater layoutInflater, ViewGroup parent, int viewType){
        return layoutInflater.inflate(mLayoutResId, parent, false);
    }

    @Override
    public RvCommonHolder createViewHolder(View itemView, int viewType) {
        return new RvCommonHolder(itemView);
    }

    @Override
    public abstract void bindDatas(RvCommonHolder holder, T data, int position);
}
