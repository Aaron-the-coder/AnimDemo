package com.itheima.comprehensivedemohm92.net;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.util.Map;

/**
 * Created by ccy on 2016/10/10.
 */
public class ApiHttpClient {
	//可插拔式网络框架
	public static AsyncHttpClient client;

	//	public static HttpUtils utils;
	public static void get(Context context, String url, Map<String, String> requestParams, final OnHandlerListener listener) {
		if (client == null) {
			client = new AsyncHttpClient();
		}
		RequestParams params = new RequestParams();
		for (Map.Entry<String, String> entry : requestParams.entrySet()) {
			params.add(entry.getKey(), entry.getValue());
		}
		client.get(context, url, params,new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int i, Header[] headers, byte[] bytes) {
				listener.onSuccess(bytes);
			}

			@Override
			public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

			}
		});
	}

	public interface OnHandlerListener {
		void onSuccess(byte[] buffer);
	}
}
