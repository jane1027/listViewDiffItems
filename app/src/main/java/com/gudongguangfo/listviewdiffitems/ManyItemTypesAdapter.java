package com.gudongguangfo.listviewdiffitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sw on 2016/12/8.
 */
public class ManyItemTypesAdapter extends BaseAdapter{
    private static final int TYPE_PHOTO = 0;
    private static final int TYPE_COMPANY = 1;
    private String[] mcontactName;
    private int[] mphotoId;
    private Context mContext;
    public ManyItemTypesAdapter(Context context,String[] contactName,int[] photoId) {
        mcontactName=contactName;
        mContext=context;
        mphotoId=photoId;
    }

    @Override
    public int getCount() {

        return mcontactName.length*2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2==0) {
            return TYPE_PHOTO;
        } else {
            return TYPE_COMPANY;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TitleViewHolder titleHolder;
        ComViewHolder comHolder;
        switch (getItemViewType(position)) {
            case TYPE_PHOTO:
                if (convertView == null) {
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.choose_com_list_item_photo, null);
                    titleHolder = new TitleViewHolder();
                    titleHolder.mImageView = (ImageView) convertView.findViewById(R.id.image);
                    convertView.setTag(titleHolder);
                } else {
                    titleHolder = (TitleViewHolder) convertView.getTag();
                }

                    titleHolder.mImageView.setImageResource(mphotoId[(position/2)]);
                break;
            case TYPE_COMPANY:
                if (convertView == null) {
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.choose_com_list_item_title, null);
                    comHolder = new ComViewHolder();
                    comHolder.com = (TextView) convertView.findViewById(R.id.tittle);

                    convertView.setTag(comHolder);
                } else {
                    comHolder = (ComViewHolder) convertView.getTag();
                }
                comHolder.com.setText(mcontactName[((position-1)/2)]);

                break;
        }
        return convertView;
    }

    class TitleViewHolder {
       ImageView   mImageView;
    }

    class ComViewHolder {
        TextView com;

    }
}
