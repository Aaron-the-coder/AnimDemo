package com.itheima.comprehensivedemohm92.net;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ccy on 2016/10/10.
 */
public class OSChinaApi {
	//服务器根路径
	public static final String SERVER_URL="http://www.oschina.net/action/api";
	public static final String NEWS_LIST=SERVER_URL+"/news_list";
	public static void getNewsList(Context context,int index, ApiHttpClient.OnHandlerListener listener){
		Map<String,String> params=new HashMap<String,String>();
		params.put("pageIndex",""+ index);
		params.put("catalog","1");
		params.put("pageSize","20");
		ApiHttpClient.get(context, NEWS_LIST,params, listener);
	}
}
