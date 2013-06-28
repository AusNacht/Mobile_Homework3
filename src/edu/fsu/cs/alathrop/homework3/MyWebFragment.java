package edu.fsu.cs.alathrop.homework3;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebFragment extends Fragment {

	public WebView webs;
	public String website;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle state) {
		this.website = getString(R.string.cs_url);

		if(webs != null){
			webs.destroy();
		}
		
		this.webs = new WebView(this.getActivity());
		this.webs.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url){
				return false;
			}
		});
		this.webs.loadUrl(this.website);

		return this.webs;
	}

	private class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// Taken from http://javatechig.com/android/android-webview-example/
			view.loadUrl(url);
			return true;
		}
	}

	public void navigate(String newUrl) {
		
		Log.i("Web Frag", "Before If");
		if (!newUrl.isEmpty()){
			Log.i("Web Frag", "Before load");
			/*
			this.webs.setWebViewClient(new WebViewClient(){
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url){
					return false;
				}
			});
			*/
			this.webs.loadUrl(newUrl);
			Log.i("Web Frag", "after load");
		}
	}
	
}
//