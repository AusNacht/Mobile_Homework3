package edu.fsu.cs.alathrop.homework3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	public String newUrl;
	public String selectedUrl;

	public urlReceiver receiver;

	public FragmentManager manager1;
	public FragmentTransaction trans1;
	public UrlListFragment fragment1;
	public FragmentManager manager2;
	public FragmentTransaction trans2;
	public MyWebFragment fragment2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.receiver = new urlReceiver();

		this.manager1 = this.getFragmentManager();
		this.trans1 = this.manager1.beginTransaction();
		this.fragment1 = new UrlListFragment();
		this.trans1.add(R.id.urllist, this.fragment1, "url_fragment");
		this.trans1.commit();

		this.manager2 = this.getFragmentManager();
		this.trans2 = this.manager2.beginTransaction();
		this.fragment2 = new MyWebFragment();
		this.trans2.add(R.id.webfragment, this.fragment2, "web_fragment");
		this.trans2.commit();

		Intent intent = this.getIntent();

		Bundle bundle = intent.getExtras();

		IntentFilter filter = new IntentFilter(Intent.ACTION_MAIN);
		this.registerReceiver(this.receiver, filter);

		if (bundle != null) {
			this.newUrl = bundle.getString("newUrl");
			this.newUrl = this.urlConverter(newUrl);
			Log.i("Main", "Before Change URL List");
			//this.changeUrl(this.newUrl);
			Log.i("Main", "Before Change Webpage");
			//this.changeWebpage(this.newUrl);
			Toast.makeText(this, this.newUrl, Toast.LENGTH_SHORT).show();
		}
		
		Log.i("Main", "After bundle");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		this.getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public String urlConverter(String oldUrl) {
		if (oldUrl.startsWith("http://"))
			return oldUrl;
		else if (oldUrl.startsWith("https://"))
			return oldUrl;
		else
			return "http://" + oldUrl;
	}

	public void changeWebpage(String url) {
		this.selectedUrl = url;

		this.fragment2.navigate(selectedUrl);
	}

	public void changeUrl(String url) {
		this.fragment1.setUrl(url);

		this.fragment1.getListView().invalidateViews();
	}

	@Override
	public void onPause() {
		super.onPause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("onDestroy", "before unReg");
		
		if (this.receiver != null)
			this.unregisterReceiver(this.receiver);
		
		Log.i("onDestroy", "after unReg");
	}

}
