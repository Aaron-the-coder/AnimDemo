package com.itheima.comprehensivedemohm92;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.itheima.comprehensivedemohm92.fragment.ComprehensiveFragment;
import com.itheima.comprehensivedemohm92.fragment.TweetsFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
//	@InjectView(R.id.tv)
//	TextView tv;
	@InjectView(R.id.dl)
	DrawerLayout dl;
	private ActionBarDrawerToggle mToggle;

	@InjectView(R.id.fth)
	FragmentTabHost fth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getFragmentManager();
//		getSupportFragmentManager().beginTransaction().add(R.id.ll_container,new DefaultFragment()).commit();
		//1,注入
		ButterKnife.inject(this);
//		tv.setText("修改了");
		init();
	}
	//	@OnClick({R.id.bt1, R.id.bt2})
//	public void click(View view) {
//		switch (view.getId()) {
//			case R.id.bt1:
//				Toast.makeText(MainActivity.this, "点击了bt1", Toast.LENGTH_SHORT).show();
//
//				break;
//			case R.id.bt2:
//				Toast.makeText(MainActivity.this, "点击了bt2", Toast.LENGTH_SHORT).show();
//
//				break;
//		}
//	}


	private void init() {
		initActionBar();
		initTabHost();
	}

	private void initTabHost() {
		//1,关联FragmentTabHost切换Fragment的容器布局
		fth.setup(this,getSupportFragmentManager(),R.id.fl_container);
		//2,创建底部导航的块
		TabHost.TabSpec tabSpec = fth.newTabSpec("zh");
//		tabSpec.setIndicator("综合");
		View view = View.inflate(this, R.layout.tab_indicator, null);
		TextView tab_title= (TextView) view.findViewById(R.id.tab_title);
		//获取drawable为drawable设置大小
		Drawable drawable=getResources().getDrawable(R.drawable.tab_icon_news);
		drawable.setBounds(0,0,60,60);
		//为TextView设置DrawableTop
		tab_title.setCompoundDrawables(null,drawable,null,null);
		tabSpec.setIndicator(view);
		//向FragmentTabHost添加Tab还有被Tab关联的Fragment
		fth.addTab(tabSpec, ComprehensiveFragment.class,null);

		tabSpec = fth.newTabSpec("dt");
//		tabSpec.setIndicator("动弹");
		view = View.inflate(this, R.layout.tab_indicator, null);
		tab_title= (TextView) view.findViewById(R.id.tab_title);
		//获取drawable为drawable设置大小
		drawable=getResources().getDrawable(R.drawable.tab_icon_tweet);
		drawable.setBounds(0,0,60,60);
		tab_title.setCompoundDrawables(null,drawable,null,null);
		tabSpec.setIndicator(view);
		tab_title.setText("动弹");
		//向FragmentTabHost添加Tab还有被Tab关联的Fragment
		fth.addTab(tabSpec, TweetsFragment.class,null);

		fth.getTabWidget().setDividerDrawable(null);
	}

	private void initActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		mToggle = new ActionBarDrawerToggle(this,dl, R.string.open,R.string.close);
		mToggle.syncState();
		dl.addDrawerListener(mToggle);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		dl.removeDrawerListener(mToggle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main,menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(mToggle.onOptionsItemSelected(item)){
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
