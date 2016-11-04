package com.itheima.comprehensivedemohm92.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.itheima.comprehensivedemohm92.adapter.ViewPagerListAdapter;
import com.itheima.comprehensivedemohm92.fragment.base.BaseViewPagerListFragment;

/**
 * Created by ccy on 2016/10/10.
 */
public class TweetsFragment extends BaseViewPagerListFragment{


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void addFragmentToAdapter(ViewPagerListAdapter adapter) {
//		adapter.addData(new DefaultFragment(),"动弹");
	}
}
