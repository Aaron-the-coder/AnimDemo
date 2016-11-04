package com.itheima.comprehensivedemohm92.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.itheima.comprehensivedemohm92.R;
import com.itheima.comprehensivedemohm92.fragment.base.BaseFragment;

import butterknife.InjectView;

/**
 * Created by ccy on 2016/10/9.
 */
public class DefaultFragment1 extends BaseFragment{

	//onCreateView中不要写过多的代码逻辑,只适合写一些视图逻辑

	@InjectView(R.id.tv)
	TextView tv;
	//onViewCreated这个方法是在onCreateView执行后执行,onCreateView的返回值,是这个方法的参数1
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onRefresh() {
		//主线程,可以开启子线程去获取网络数据
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				srl.setRefreshing(false);
			}
		},2000);
	}
}
