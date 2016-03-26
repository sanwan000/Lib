package com.hyj.lib.http;

import java.util.Map;

/**
 * http模块接口定义
 * 
 * @author Xiaoxin
 */
public abstract class HttpApi {
	/**
	 * 数据编码格式
	 */
	protected static final String CHARSET = "UTF-8";
	/**
	 * <pre>
	 *  用于向Cookie中填写sessionid的值,不同环境值不一样
	 *  若用PHP写的网页则SESSION = "PHPSESSID"
	 * </pre>
	 */
	protected static final String SESSION = "PHPSESSID";
	/**
	 * 用于保存会话产生的sessionID
	 */
	protected static String sessionId = null;

	/**
	 * get方式提交数据
	 * 
	 * @param strUrl
	 * @return
	 */
	public abstract String getUrlContext(String strUrl);

	/**
	 * get方式提交数据
	 * 
	 * @param strUrl
	 *            请求地址
	 * @param mapParams
	 *            地址后面所带参数
	 * @return
	 */
	public String getUrlContext(String strUrl, Map<String, String> mapParams) {
		StringBuilder sb = new StringBuilder();
		if (!mapParams.isEmpty()) {
			sb.append("?");
			for (Map.Entry<String, String> entry : mapParams.entrySet()) {
				sb.append(entry.getKey());
				sb.append("=");
				sb.append(entry.getValue());
				sb.append("&");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return getUrlContext(strUrl + sb);
	}

	/**
	 * post方式提交数据
	 * 
	 * @param strUrl
	 *            地址
	 * @param params
	 *            map参数
	 * @return
	 */
	public abstract String postUrlContext(String strUrl,
			Map<String, String> params);
}
