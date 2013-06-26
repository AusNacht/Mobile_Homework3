package edu.fsu.cs.alathrop.homework3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	
	public String newUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		newUrl = "www.ign.com";
		
		FragmentManager manager1 = getFragmentManager();
		FragmentTransaction trans1 = manager1.beginTransaction();
		UrlListFragment fragment1 = new UrlListFragment();
		trans1.add(R.id.urllist, fragment1, "url_fragment");
		fragment1.user_Url = "www.ign.com";
		fragment1.setUrl(newUrl);
		trans1.commit();
		
		FragmentManager manager2 = getFragmentManager();
		FragmentTransaction trans2 = manager2.beginTransaction();		
		MyWebFragment fragment2 = new MyWebFragment();
		trans2.add(R.id.webfragment, fragment2, "web_fragment");
		trans2.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
