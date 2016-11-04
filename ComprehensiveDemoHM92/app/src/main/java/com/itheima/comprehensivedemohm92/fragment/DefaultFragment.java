package com.itheima.comprehensivedemohm92.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.itheima.comprehensivedemohm92.R;
import com.itheima.comprehensivedemohm92.net.ApiHttpClient;
import com.itheima.comprehensivedemohm92.net.OSChinaApi;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by ccy on 2016/10/9.
 */
public class DefaultFragment extends Fragment{

	private int index;

	//onCreateView中不要写过多的代码逻辑,只适合写一些视图逻辑
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_default,container,false);
		return view;
	}
	@InjectView(R.id.tv)
	TextView tv;
	//onViewCreated这个方法是在onCreateView执行后执行,onCreateView的返回值,是这个方法的参数1
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.inject(this,view);
		Bundle arguments = getArguments();
		String a = arguments.getString("a");
		Toast.makeText(getActivity(),"a:"+a,Toast.LENGTH_SHORT).show();
		//通过网络访问Tomcat服务器,将xml数据解析到javabean中
		//第一种方式
//		AsyncHttpClient client=new AsyncHttpClient();
//		client.get(getActivity(), "http://192.168.67.88:8080/oschina/list/news/page0.xml", new AsyncHttpResponseHandler() {
//			//参数3:获取的结果
//			@Override
//			public void onSuccess(int i, org.apache.http.Header[] headers, byte[] bytes) {
////				String result=new String(bytes,0,bytes.length);
//				NewsList newsList = XmlUtils.toBean(NewsList.class, bytes);
//				Log.i("test","newsList:"+newsList);
////				tv.setText(result);
//			}
//
//			@Override
//			public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {
//
//			}
//		});

		//第二种方式
//		Map<String,String> params=new HashMap<String,String>();
//		int index=0;
//		params.put("pageIndex",""+ index);
//		params.put("catalog","1");
//		params.put("pageSize","20");
//		ApiHttpClient.get(getActivity(), "url",new HashMap<String,String>(), new ApiHttpClient.OnHandlerListener() {
//			@Override
//			public void onSuccess(byte[] buffer) {
//
//			}
//		});


		//第三种方式


		OSChinaApi.getNewsList(getActivity(),index,new ApiHttpClient.OnHandlerListener() {
			@Override
			public void onSuccess(byte[] buffer) {
				//显示到ListView上
			}
		});
		index++;
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
