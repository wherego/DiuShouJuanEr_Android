package com.bili.diushoujuaner.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bili.diushoujuaner.R;
import com.bili.diushoujuaner.adapter.viewholder.ViewHolder;
import com.bili.diushoujuaner.utils.Common;
import com.bili.diushoujuaner.utils.entity.PictureVo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by BiLi on 2016/3/25.
 */
public class ImageAdapter extends CommonAdapter<PictureVo> {

    public ImageAdapter(Context context, List<PictureVo> pictureVoList){
        super(context, pictureVoList, R.layout.item_picture);
    }

    @Override
    public void convert(ViewHolder holder, PictureVo pictureVo, int position) throws Exception {
        if(pictureVo != null){
            Common.displayDraweeView(pictureVo.getPicPath(), (SimpleDraweeView)holder.getView(R.id.ivItemPicture));
        }
    }
}