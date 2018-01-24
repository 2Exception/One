package com.komoriwu.one.all.detail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.listener.OnItemTagsClickListener;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.ImageLoader;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-19.
 */


public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagsViewHolder> {
    private Context mContext;
    private List<DataBean.TagsBean> mItemList;
    private OnItemTagsClickListener mOnItemTagsClickListener;

    public TagsAdapter(Context mContext,OnItemTagsClickListener mOnItemTagsClickListener) {
        this.mContext = mContext;
        this.mOnItemTagsClickListener=mOnItemTagsClickListener;
    }

    public void setRvData(List<DataBean.TagsBean> mItemList) {
        this.mItemList = mItemList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return Constants.ALL_VIEW_TAPE;
    }

    @Override
    public TagsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tags_card, parent,
                false);
        return new TagsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TagsViewHolder holder, int position) {
        DataBean.TagsBean tagsBean = mItemList.get(position);
        ImageLoader.displayImage(mContext, tagsBean.getBgPicture(), holder.ivCard,
                false);
        holder.tvTitle.setText(String.format(mContext.getString(R.string.tags), tagsBean.getName()));
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class TagsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_card)
        ImageView ivCard;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;

        public TagsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnItemTagsClickListener.onItemClick(mItemList.get(getAdapterPosition()).getId());
        }
    }
}
