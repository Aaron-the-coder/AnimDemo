package com.itheima.comprehensivedemohm92.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccy on 2016/10/10.
 */
public class ViewPagerListAdapter extends FragmentPagerAdapter{
	private List<Fragment> fragments;
	private List<String> titles;

	public ViewPagerListAdapter(FragmentManager fm) {
		super(fm);
		fragments=new ArrayList<>();
		titles=new ArrayList<>();
	}

	public void setData(List<Fragment> fragments){
		this.fragments=fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles.get(position);
	}

	public void addData(Context context, FragmentInfo info, String title) {
		Class<? extends Fragment> fragmentClazz = info.getFragmentClazz();
		Fragment fragment = Fragment.instantiate(context, fragmentClazz.getName(), info.getArgs());
		fragments.add(fragment);
		titles.add(title);
	}

	public void addData(Fragment fragment,String title,Bundle bundle){
		fragments.add(fragment);
		titles.add(title);
	}

	public static class FragmentInfo{
		private Class<? extends Fragment> fragmentClazz;
		private Bundle args;

		public FragmentInfo(Class<? extends Fragment> fragmentClazz, Bundle args) {
			this.fragmentClazz = fragmentClazz;
			this.args = args;
		}

		public Class<? extends Fragment> getFragmentClazz() {
			return fragmentClazz;
		}

		public void setFragmentClazz(Class<? extends Fragment> fragmentClazz) {
			this.fragmentClazz = fragmentClazz;
		}

		public Bundle getArgs() {
			return args;
		}

		public void setArgs(Bundle args) {
			this.args = args;
		}
	}


}
