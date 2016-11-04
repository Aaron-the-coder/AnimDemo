package com.itheima.comprehensivedemohm92.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.comprehensivedemohm92.PagerSlidingTab;
import com.itheima.comprehensivedemohm92.R;
import com.itheima.comprehensivedemohm92.adapter.ViewPagerListAdapter;

/**
 * Created by ccy on 2016/10/10.
 */
//抽取的时候遵循
	//1,相同的放在父类
	//2,不同的由子类实现
public abstract class BaseViewPagerListFragment extends Fragment{
	protected ViewPager vp;
	private ViewPagerListAdapter adapter;
	private PagerSlidingTab pts;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_viewpager_list_base,container,false);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		vp = (ViewPager) view.findViewById(R.id.vp);
		pts = (PagerSlidingTab) view.findViewById(R.id.pts);
		//在fragment内处理子Fragment时,用getChildFragmentManager()
		adapter = new ViewPagerListAdapter(getChildFragmentManager());


		//TODO 加入适配器数据
		addFragmentToAdapter(adapter);



		vp.setAdapter(adapter);
		pts.setViewPager(vp);
	}
	public abstract  void addFragmentToAdapter(ViewPagerListAdapter adapter);
}
