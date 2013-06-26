package edu.fsu.cs.alathrop.homework3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebFragment extends Fragment {

	WebView webs;
	public String website;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state)
	{
		website = getString(R.string.cs_url);
		
		webs = new WebView(getActivity());
		webs.setWebViewClient(new MyWebViewClient());
		webs.loadUrl(website);
		

		return webs;
	}
	
	private class MyWebViewClient extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url){
			//Taken from http://javatechig.com/android/android-webview-example/
			view.loadUrl(url);
			return true;
		}
	}
	
}
