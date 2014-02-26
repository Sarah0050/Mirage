package net.littlekang1.disusedpublicproperty;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapMarkerActivity extends FragmentActivity {

	static final LatLng Central = new LatLng(23.974548, 120.982064);

	private GoogleMap map;
	private Location location;
	private String address;
	List<Marker> marker;

	class Data {
		public Data(String id, double lat, double lnt, String title) {
			super();
			this.id = id;
			this.lat = (double) lat;
			this.lnt = (double) lnt;
			this.title = title;
		}

		public String id;
		public double lat;
		public double lnt;
		public String title;
	}

	Data[] data = {
			new Data("Mirage02", 23.660622, 120.153777, "雲林縣四湖鄉三條崙海水浴場"),
			new Data("Mirage04", 22.733282, 120.444805, "高雄市大樹鄉鳳荔文化館"),
			new Data("Mirage05", 22.574528, 120.297135, "高雄市旗津中興公有市場二樓"),
			new Data("Mirage09", 24.384118, 120.586235, "台中縣大安濱海渡假中心"),
			new Data("Mirage10", 24.075149, 120.632946, "台中縣烏日焚化爐"),
			new Data("Mirage11", 24.426442, 120.636596, "台中縣大甲鎮銅安里與福德里農產品運銷中心"),
			new Data("Mirage12", 24.997008, 121.57715, "台北市兒童育樂中心文山園區"),
			new Data("Mirage13", 25.139146, 121.488186, "台北市北投區中央製片廠(中國電影製片廠)"),
			new Data("Mirage15", 25.001072, 121.565262, "台北市萬芳超級市場二樓"),
			new Data("Mirage16", 22.749608, 121.153339, "台東市立游泳池"),
			new Data("Mirage18", 22.794699, 121.191532, "台東縣富岡漁港候船室二樓"),

			new Data("Mirage20", 22.734133, 121.129951, "台東縣焚化爐"),
			new Data("Mirage33", 22.991444, 120.20506, "台南市舊警察局"),
			new Data("Mirage36", 23.233775, 120.096252, "台南縣將軍漁港觀光漁市漁貨直銷中心"),
			new Data("Mirage38", 23.038725, 120.307521, "台南縣新化鎮廣停二地下停車場"),
			new Data("Mirage41", 24.665816, 121.653818, "宜蘭縣三星鄉第二公墓納骨塔"),
			new Data("Mirage43", 24.85937, 121.823406, "宜蘭縣頭城鎮第五公墓火化場"),
			new Data("Mirage46", 23.966764, 121.592127, "花蓮縣吉安仁里(停四)停車場"),
			new Data("Mirage48", 23.974234, 121.606804, "花蓮市忠孝立體停車場"),
			new Data("Mirage52", 23.972627, 121.608628, "花蓮市洄瀾之心陽光電城"),
			new Data("Mirage63", 24.498181, 118.402714, "金門文化園區"),

			new Data("Mirage73", 22.704978, 120.49004, "屏東九如航空站"),
			new Data("Mirage77", 21.945036, 120.742983, "屏東縣後壁湖遊客中心"),
			new Data("Mirage79", 22.051914, 120.734146, "屏東縣恆春航空站(五里亭機場)"),
			new Data("Mirage93", 25.114591, 121.24344, "桃園縣大園濱海遊憩區服務中心"),
			new Data("Mirage100", 25.154278, 121.771513, "基隆原住民會館 "),
			new Data("Mirage104", 23.567626, 120.304688, "雲林縣北港第一公有零售市場"),
			new Data("Mirage112", 25.081246, 121.659057, "新北市汐止區文化中心"),
			new Data("Mirage114", 24.797176, 120.972043, "新竹市公有竹蓮零售市場三樓"),
			new Data("Mirage115", 24.788955, 121.183723, "新竹縣產業交流中心迎風館(原關西農民活動中心)"),
			new Data("Mirage118", 24.806584, 121.045279, "新竹生物醫學園區"),

			new Data("Mirage128", 23.470155, 120.294882, "嘉義縣故宮南院願景館"),
			new Data("Mirage134", 24.063628, 120.435902, "彰化縣鹿港鎮生態性休閒公園"),
			new Data("Mirage144", 23.577794, 119.572081, "澎湖縣馬公市光榮社區活動中心"),

			new Data("Mirage154", 22.568247, 120.313229, "高雄市前鎮觀光魚市 "),
			new Data("Mirage155", 22.537333, 120.371443, "高雄市政府勞工局訓練就業中心小港館舍"), };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_marker);

		initMap();

		// Move the camera instantly to NKUT with a zoom of 16.
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(Central, 6));
	}

	// 初始化地圖
	private void initMap() {
		// 檢查GoogleMap物件是否存在
		if (map == null) {
			// 從SupportMapFragment取得GoogleMap物件
			map = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			if (map != null) {
				setUpMap();
			}
		}
	}

	// 完成地圖相關設定
	private void setUpMap() {
		map.setMyLocationEnabled(true);

		wisata();
	}

	public void wisata() {

		if (map == null) {
			Log.d(null, "Map Fragment Not Found or no Map in it!!");
			return;
		}
		marker = new ArrayList<Marker>();

		for (int i = 0; i < data.length; i++) {
			LatLng location = new LatLng(data[i].lat, data[i].lnt);
			final Marker m = map.addMarker(new MarkerOptions()
					.position(location).title(data[i].title)
					.icon(BitmapDescriptorFactory.defaultMarker()));

			marker.add(m);
			// Let the user see indoor maps where available.

		}
		map.setOnMarkerClickListener(markerListener);
	}

	private OnMarkerClickListener markerListener = new OnMarkerClickListener() {

		@Override
		public boolean onMarkerClick(Marker m) {
			for (int i = 0; i < marker.size(); i++) {
				int count = i;
				if (m.equals(marker.get(i))) {
					Intent intent = new Intent();
					intent.setClass(MapMarkerActivity.this,
							PicInfoActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("key", data[count].id);
					intent.putExtras(bundle);
					startActivity(intent);
				}
			}
			return false;
		}
	};

	protected boolean checkPlayServices() {
		int resultCode = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(this);
		if (resultCode != ConnectionResult.SUCCESS) {
			if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
				GooglePlayServicesUtil.getErrorDialog(resultCode, this, 0)
						.show();
			} else {
				Log.i("", "This device is not supported.");
				finish();
			}
			return false;
		}
		return true;
	}

	// 執行與地圖有關的方法前應該先呼叫此方法以檢查GoogleMap物件是否存在
	private boolean isMapReady() {
		if (map == null) {
			Toast.makeText(this, " 地圖沒準備好", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map_marker, menu);
		return true;
	}

}
