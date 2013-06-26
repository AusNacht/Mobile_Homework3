package edu.fsu.cs.alathrop.homework3;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class UrlListFragment extends ListFragment {

	public String [] URLS = new String[] {
		"http://mobile.cs.fsu.edu/android", 
		"http://www.google.com", 
		"http://www.lifehacker.com",
		""};
	
	public String user_Url;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, URLS);
		setListAdapter(adapter);
		URLS[3] = user_Url;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
			Toast.makeText(getActivity().getApplicationContext(), URLS[position], Toast.LENGTH_SHORT).show();
	
		
	}
	
	public void setUrl(String newUrl)
	{
		user_Url = newUrl;
		
	}
	
	/*
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state)
	{

		return inflater.inflate(R.layout.activity_url_list_fragment, container, false);
	}
	*/

}
