package net.littlekang1.disusedpublicproperty;

import java.util.ArrayList;

import net.littlekang1.imageloader.ImageLoader;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ImageLoader mImageLoader;
    private String[] mImagesUrl;
    
    public ImageAdapter(Context c, String[] images) {
        mContext = c;
        mImageLoader = new ImageLoader(mContext, 60);   // 小圖 , 未點開前的品質
        mImagesUrl = images;
    }

    public int getCount() {
        return mImagesUrl.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) { 
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        
        mImageLoader.DisplayImage(mImagesUrl[position], imageView);
//        imageView.setOnClickListener(new View.OnClickListener() {			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
        
//        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.taipei01_01, R.drawable.taipei01_02,
            R.drawable.taipei01_03, R.drawable.taipei01_04,
            R.drawable.taipei01_05, R.drawable.taipei01_06,
            R.drawable.taipei01_07, R.drawable.taipei01_08
    };
}
