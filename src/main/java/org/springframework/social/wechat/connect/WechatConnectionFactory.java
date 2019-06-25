package org.springframework.social.wechat.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.wechat.UrlConstants;
import org.springframework.social.wechat.api.Wechat;

/**
 * spring-social-wechat
 * 
 * @author Larry
 */
public class WechatConnectionFactory extends OAuth2ConnectionFactory<Wechat> {

	public WechatConnectionFactory(String appId, String appSecret) {
		this(appId, appSecret, null);
	}

	public WechatConnectionFactory(String appId, String appSecret, ApiAdapter<Wechat> apiAdapter) {
		super("wechat", new WechatServiceProvider<Wechat>(appId, appSecret, UrlConstants.QRCONNECT_API_URL),
				apiAdapter);
	}

	@Override
	protected String extractProviderUserId(AccessGrant accessGrant) {
		return ((WechatAccessGrant) accessGrant).getOpenid();
	}

}
