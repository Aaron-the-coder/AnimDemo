package com.itheima.comprehensivedemohm92.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.itheima.comprehensivedemohm92.R;
import com.itheima.comprehensivedemohm92.adapter.ViewPagerListAdapter;
import com.itheima.comprehensivedemohm92.fragment.base.BaseViewPagerListFragment;

/**
 * Created by ccy on 2016/10/10.
 */
public class ComprehensiveFragment extends BaseViewPagerListFragment{

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);



	}

	@Override
	public void addFragmentToAdapter(ViewPagerListAdapter adapter) {
//		List<Fragment> fragments=new ArrayList<Fragment>();
//		fragments.add(new DefaultFragment());
//		fragments.add(new DefaultFragment());
//		fragments.add(new DefaultFragment());
//		fragments.add(new DefaultFragment());
//		adapter.setData(fragments);
		Bundle bundle=new Bundle();
		bundle.putString("url","url1");
		//配置文件
		String[] zx = getResources().getStringArray(R.array.zx);
		adapter.addData(getActivity(),new ViewPagerListAdapter.FragmentInfo(DefaultFragment1.class,bundle),zx[0]);
		adapter.addData(getActivity(),new ViewPagerListAdapter.FragmentInfo(DefaultFragment.class,bundle),zx[1]);
		adapter.addData(getActivity(),new ViewPagerListAdapter.FragmentInfo(DefaultFragment.class,bundle),zx[2]);
		adapter.addData(getActivity(),new ViewPagerListAdapter.FragmentInfo(DefaultFragment.class,bundle),zx[3]);

	}
}
