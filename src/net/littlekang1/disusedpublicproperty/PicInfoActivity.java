package net.littlekang1.disusedpublicproperty;

import net.littlekang1.imageloader.ImageLoader;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PicInfoActivity extends Activity {

	private GridView gridview;
	TextView te;
	private ImageLoader mImageLoader;
	private String[] picUrls = new String[0];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pic_info);

		te = (TextView) findViewById(R.id.textView1);

		mImageLoader = new ImageLoader(this, 100); // 點開後的圖片品質
		
		// 取的intent中的bundle物件
		Bundle bundle = this.getIntent().getExtras();

		String taipei = bundle.getString("key");

		if (taipei.equals("Mirage02")) {
			te.setText(getResources().getString(R.string.mirage02_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage02_Pics);
		} else if (taipei.equals("Mirage04")) {
			te.setText(getResources().getString(R.string.mirage04_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage04_Pics);
		} else if (taipei.equals("Mirage05")) {
			te.setText(getResources().getString(R.string.mirage05_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage05_Pics);
		} else if (taipei.equals("Mirage09")) {
			te.setText(getResources().getString(R.string.mirage09_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage09_Pics);
		} else if (taipei.equals("Mirage10")) {
			te.setText(getResources().getString(R.string.mirage10_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage10_Pics);
		} else if (taipei.equals("Mirage11")) {
			te.setText(getResources().getString(R.string.mirage11_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage11_Pics);
		} else if (taipei.equals("Mirage12")) {
			te.setText(getResources().getString(R.string.mirage12_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage12_Pics);
		} else if (taipei.equals("Mirage13")) {
			te.setText(getResources().getString(R.string.mirage13_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage13_Pics);
		} else if (taipei.equals("Mirage15")) {
			te.setText(getResources().getString(R.string.mirage15_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage15_Pics);
		} else if (taipei.equals("Mirage16")) {
			te.setText(getResources().getString(R.string.mirage16_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage16_Pics);
		} else if (taipei.equals("Mirage18")) {
			te.setText(getResources().getString(R.string.mirage18_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage18_Pics);
		} else if (taipei.equals("Mirage20")) {
			te.setText(getResources().getString(R.string.mirage20_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage20_Pics);
		} else if (taipei.equals("Mirage33")) {
			te.setText(getResources().getString(R.string.mirage33_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage33_Pics);
		} else if (taipei.equals("Mirage36")) {
			te.setText(getResources().getString(R.string.mirage36_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage36_Pics);
		} else if (taipei.equals("Mirage38")) {
			te.setText(getResources().getString(R.string.mirage38_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage38_Pics);
		} else if (taipei.equals("Mirage41")) {
			te.setText(getResources().getString(R.string.mirage41_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage41_Pics);
		} else if (taipei.equals("Mirage43")) {
			te.setText(getResources().getString(R.string.mirage43_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage43_Pics);
		} else if (taipei.equals("Mirage46")) {
			te.setText(getResources().getString(R.string.mirage46_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage46_Pics);
		} else if (taipei.equals("Mirage48")) {
			te.setText(getResources().getString(R.string.mirage48_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage48_Pics);
		} else if (taipei.equals("Mirage52")) {
			te.setText(getResources().getString(R.string.mirage52_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage52_Pics);
		} else if (taipei.equals("Mirage63")) {
			te.setText(getResources().getString(R.string.mirage63_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage63_Pics);
		} else if (taipei.equals("Mirage73")) {
			te.setText(getResources().getString(R.string.mirage73_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage73_Pics);
		} else if (taipei.equals("Mirage77")) {
			te.setText(getResources().getString(R.string.mirage77_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage77_Pics);
		} else if (taipei.equals("Mirage79")) {
			te.setText(getResources().getString(R.string.mirage79_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage79_Pics);
		} else if (taipei.equals("Mirage93")) {
			te.setText(getResources().getString(R.string.mirage93_string));
			picUrls = this.getResources().getStringArray(R.array.Mirage93_Pics);
		} else if (taipei.equals("Mirage100")) {
			te.setText(getResources().getString(R.string.mirage100_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage100_Pics);
		} else if (taipei.equals("Mirage104")) {
			te.setText(getResources().getString(R.string.mirage104_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage104_Pics);
		} else if (taipei.equals("Mirage112")) {
			te.setText(getResources().getString(R.string.mirage112_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage112_Pics);
		} else if (taipei.equals("Mirage114")) {
			te.setText(getResources().getString(R.string.mirage114_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage114_Pics);
		} else if (taipei.equals("Mirage115")) {
			te.setText(getResources().getString(R.string.mirage115_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage115_Pics);
		} else if (taipei.equals("Mirage118")) {
			te.setText(getResources().getString(R.string.mirage118_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage118_Pics);
		} else if (taipei.equals("Mirage128")) {
			te.setText(getResources().getString(R.string.mirage128_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage128_Pics);
		} else if (taipei.equals("Mirage134")) {
			te.setText(getResources().getString(R.string.mirage134_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage134_Pics);
		} else if (taipei.equals("Mirage144")) {
			te.setText(getResources().getString(R.string.mirage144_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage144_Pics);
		} else if (taipei.equals("Mirage154")) {
			te.setText(getResources().getString(R.string.mirage154_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage154_Pics);
		} else if (taipei.equals("Mirage155")) {
			te.setText(getResources().getString(R.string.mirage155_string));
			picUrls = this.getResources()
					.getStringArray(R.array.Mirage155_Pics);
		}
		gridview = (GridView) findViewById(R.id.gridview);

		gridview.setAdapter(new ImageAdapter(this, picUrls));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(PicInfoActivity.this,
						"選擇了圖 " + (position + 1) + " . ", Toast.LENGTH_SHORT)
						.show();
				createPopupImage(picUrls[position]);
			}
		});
	}

	private void createPopupImage(String picUrl) {
		// TODO Auto-generated method stub
		View popupView = new View(this);
		final PopupWindow popupWindow = new PopupWindow(popupView,
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		// set image
		// Drawable drawable =
		// getResources().getDrawable(R.drawable.ic_launcher);

		Bitmap bm = mImageLoader.getBitmap(picUrl);
		Drawable mDrawable = new BitmapDrawable(bm);

		popupWindow.setBackgroundDrawable(mDrawable);
		popupWindow.setHeight(600);
		popupWindow.setWidth(400);
		popupWindow.setTouchable(true);
		popupWindow.setFocusable(true);
		popupWindow.setTouchInterceptor(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				popupWindow.dismiss();
				return false;
			}

		});

		popupWindow.showAtLocation(
				getWindow().getDecorView().findViewById(android.R.id.content),
				Gravity.CENTER, 0, 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pic_info, menu);
		return true;
	}

}
