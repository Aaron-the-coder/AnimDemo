package com.itheima.comprehensivedemohm92.fragment.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.itheima.comprehensivedemohm92.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccy on 2016/10/10.
 */
public abstract class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

	private ListView lv;
	protected SwipeRefreshLayout srl;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_default1, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		lv = (ListView) view.findViewById(R.id.lv);
		srl = (SwipeRefreshLayout) view.findViewById(R.id.srl);
		srl.setColorSchemeColors(Color.RED,Color.GREEN,Color.YELLOW);
		List<String> datas = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			datas.add("条目" + i);
		}
		lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas));
		srl.setOnRefreshListener(this);
	}

}
