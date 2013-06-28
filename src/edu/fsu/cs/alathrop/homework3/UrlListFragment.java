package edu.fsu.cs.alathrop.homework3;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UrlListFragment extends ListFragment {

	public String[] URLS = new String[] { "http://mobile.cs.fsu.edu/android",
			"http://www.google.com", "http://www.lifehacker.com", "" };

	public String user_Url;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
				android.R.layout.simple_list_item_1, this.URLS);
		this.setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		((MainActivity) this.getActivity()).changeWebpage(this.URLS[position]);
	}

	public void setUrl(String newUrl) {
		Log.i("Url List", "Before if");
		if (newUrl.isEmpty()){
		}
		else if (newUrl.equalsIgnoreCase(this.URLS[0])) {
		}
		else if (newUrl.equalsIgnoreCase(this.URLS[1])) {
		}
		else if (newUrl.equalsIgnoreCase(this.URLS[2])) {
		}
		else if (newUrl.equalsIgnoreCase(this.URLS[3])) {
		} else {
			Log.i("Url List", "before global variable change");
			this.user_Url = newUrl;
			Log.i("Url List", "after global, before updating array");
			this.URLS[3] = this.user_Url;
			Log.i("Url List", "after updating array");
		}
	}

	/*
	 * @Override public View onCreateView(LayoutInflater inflater, ViewGroup
	 * container, Bundle state) {
	 * 
	 * return inflater.inflate(R.layout.activity_url_list_fragment, container,
	 * false); }
	 */

}
