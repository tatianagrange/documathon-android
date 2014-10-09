package com.tgrange.android.documathon.fragments;

import java.util.ArrayList;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tgrange.android.documathon.ActivityMain;
import com.tgrange.android.documathon.R;
import com.tgrange.android.documathon.model.Project;
import com.tgrange.android.documathon.webservice.WebServiceCall;
import com.tgrange.android.documathon.webservice.WebServiceDefine;
import com.tgrange.android.documathon.webservice.WebServiceEvent;
import com.tgrange.android.documathon.webservice.WebServiceException;
import com.tgrange.android.documathon.webservice.WebServiceParse;

public class FragmentList extends Fragment implements WebServiceEvent{
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";
	private ListView listView;

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static FragmentList newInstance(int sectionNumber) {
		FragmentList fragment = new FragmentList();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public FragmentList() {
		WebServiceCall wsc = new WebServiceCall(WebServiceDefine.getAllProjects(),this);
		wsc.execute();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_list,
				container, false);
		 // Get ListView object from xml
        listView = (ListView) rootView.findViewById(R.id.list);
        
        // Defined Array values to show in ListView
        String[] values = new String[] {};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
          android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter); 
        
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((ActivityMain) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}

	@Override
	public void onResult(JSONObject obj, String url) {
		try {
			WebServiceParse wsp = new WebServiceParse(obj);
			if(url.equals(WebServiceDefine.getAllProjects())){
				ArrayList<Project> projects = wsp.getAllProjects();
				String[] values = new String[projects.size()];
				for(int i = 0 ; i < projects.size() ; i++){
					values[i] = projects.get(i).getName();
				}
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
				          android.R.layout.simple_list_item_1, android.R.id.text1, values);
				
				listView.setAdapter(adapter); 
			}
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}
}