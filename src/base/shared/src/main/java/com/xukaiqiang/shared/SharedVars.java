package com.xukaiqiang.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.xukaiqiang.shared.protocol.OutputMessage;

@Component
public class SharedVars {

	/**
	 * 顶层包名
	 */
	public static final String ROOT_PACKAGE = "com.xukaiqiang";

	/**
	 * 无效ID值
	 */
	public static final String INVALID_IDSTRING = "-1";

	/**
	 * 校验请求参数id（数字）
	 * 
	 * @param id
	 * @return
	 */
	public static boolean validateID(Long id) {
		if (id == null) {
			return false;
		}

		return Long.parseLong(INVALID_IDSTRING) != id;
	}

	/**
	 * 校验请求参数id（对象）
	 * 
	 * @param id
	 * @return
	 */
	public static boolean validateID(Object id) {
		if (ObjectUtils.isEmpty(id)) {
			return false;
		}
		return true;
	}

	public static <RESPONSE extends OutputMessage> String getSystemName(Class<RESPONSE> responseClass) {
		return responseClass.getName().replaceAll(".*\\.(\\w+)\\.api\\..*", "$1");
	}

	@Value("${server.message:http://127.0.0.1:8080}")
	public String messageServer;

	@Value("${fs.root:/var/zkbc/fs}")
	public String fileSystemRoot;

	@Value("${page.defaultPageSize:20}")
	public int defaultPageSize;

	@Value("${page.maxPageSize:100}")
	public int maxPageSize;

	@Value("${page.displayPages:10}")
	public int displayPages;

	@Value("${remote.http.server.url:http://localhost:8080}")
	public String httpServerUrl;

	@Value("${remote.thrift.server.host:localhost}")
	public String thriftServerHost;

	@Value("${remote.thrift.server.port:9090}")
	public int thriftServerPort;

	@Value("${remote.thrift.server.workerThreads:5}")
	public int thriftWorkerThreads;

	@Value("${remote.thrift.server.selectorThreads:2}")
	public int selectorThreads;

	@Value("${freemarker.loaderPath:classpath:/freemarker}")
	public String freemarkerLoaderPath;

	@Value("${freemarker.defaultEncoding:UTF-8}")
	public String freemarkerDefaultEncoding;

	@Value("${mail.defaultEncoding:UTF-8}")
	public String mailDefaultEncoding;

	@Value("${mail.smtp.host}")
	public String mailSmtpHost;

	@Value("${mail.smtp.username}")
	public String mailSmtpUsername;

	@Value("${mail.smtp.password}")
	public String mailSmtpPassword;

	@Value("${mail.smtp.auth}")
	public String mailSmtpAuth;
	/**
	 * 邮件是否使用ssl
	 */
	@Value("${mail.smtp.starttls.enable}")
	public String mailSmtpStarttlsEnable;
	/**
	 * 登录失败锁定时间（秒）
	 */
	@Value("${shared.loginfail.expires:3600}")
	public int expiresForLoginfail;
	/**
	 * 登录失败几次显示图形验证码
	 */
	@Value("${shared.loginfail.max.captcha:3}")
	public int captchaForLoginfailMax;
	/** 
	 * messageSource 默认编码格式
	 */
	@Value("${shared.message.default.encoding:UTF-8}")
	public String defaultEncoding;
	/** 
	 * messageSource 消息配置文件
	 */
	@Value("${shared.message.basenames:classpath:messages}")
	public String basenames;
	/**
	 * 节点ID
	 */
	@Value("${shared.wordker.id:0}")
	public long wordkerId;
	/**
	 * 数据中心ID
	 */
	@Value("${shared.dataCenter.id:0}")
	public long dataCenterId;

	public String findByName(String name, String defaultValue) {
		if (resolver == null) {
			resolver = new PropertySourcesPropertyResolver(configurer.getAppliedPropertySources());
		}
		return resolver.getProperty(name, defaultValue);
	}

	private PropertySourcesPropertyResolver resolver;

	@Autowired
	private PropertySourcesPlaceholderConfigurer configurer;
}
