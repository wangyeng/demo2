/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * DefinedSettings 自定义设置
 *
 * @Description 自定义配置文件Properties对应的Key对象
 */
@Component
public class DefinedSettings {
    /**
     * login
     */
    @Value("${dd.login.url:''}")
    private String loginUrl;
    @Value("${dd.loginout.url:''}")
    private String loginOutUrl;
    @Value("${dd.login.success.url:''}")
    private String loginSuccessUrl;
    @Value("${dd.login.unauth.url:''}")
    private String unauthorizedUrl;
    /**
     * common
     */
    @Value("${dd.conf.security.key:''}")
    private String securityKey;
    @Value("${dd.user.defaultpassword:''}")
    private String userDefaultPassword;
    @Value("${dd.filesave.type}")
    private String fileSaveType = FinalConfig.FILE_TYPE_DEFALULT;
    @Value("${dd.filesave.root:''}")
    private String fileSaveRoot;
    @Value("${dd.filesave.ftp.host:'127.0.0.1'}")
    private String ftpHost;
    @Value("${dd.filesave.ftp.username:''}")
    private String ftpLoginUserName;
    @Value("${dd.filesave.ftp.password:''}")
    private String ftpLoginPassword;
    @Value("${spring.messages.basename:''}")
    private String baseName;
    /**
     * Kaptcha
     */
    @Value("${dd.kaptcha.border:'no'}")
    private String kaptchaBorder;
    @Value("${dd.kaptcha.border.color:''}")
    private String kaptchaBorderColor;
    @Value("${dd.kaptcha.border.thickness:''}")
    private String kaptchaBorderThickness;
    @Value("${dd.kaptcha.producer.impl:''}")
    private String kaptchaProducerImpl;
    @Value("${dd.kaptcha.textproducer.impl:''}")
    private String kaptchaTextProducerImpl;
    @Value("${dd.kaptcha.textproducer.char.string:''}")
    private String kaptchaTextProducerCharString;
    @Value("${dd.kaptcha.textproducer.char.length:''}")
    private String kaptchaTextProducerCharLength;
    @Value("${dd.kaptcha.textproducer.font.names:''}")
    private String kaptchaTextProducerFontNames;
    @Value("${dd.kaptcha.textproducer.font.size:'14'}")
    private String kaptchaTextProducerFontSize;
    @Value("${dd.kaptcha.textproducer.font.color:'blue'}")
    private String kaptchaTextProducerFontColor;
    @Value("${dd.kaptcha.textproducer.char.space:''}")
    private String kaptchaTextProducerCharSpace;
    @Value("${dd.kaptcha.noise.impl:''}")
    private String kaptchaNoiseImpl;
    @Value("${dd.kaptcha.noise.color:''}")
    private String kaptchaNoiseColor;
    @Value("${dd.kaptcha.obscurificator.impl:''}")
    private String kaptchaObscurificatorImpl;
    @Value("${dd.kaptcha.word.impl:''}")
    private String kaptchaWordImpl;
    @Value("${dd.kaptcha.background.impl:''}")
    private String kaptchaBackgroundImpl;
    @Value("${dd.kaptcha.background.clear.from:''}")
    private String kaptchaBackgroundClearFrom;
    @Value("${dd.kaptcha.background.clear.to:''}")
    private String kaptchaBackgroundClearTo;
    @Value("${dd.kaptcha.image.width:''}")
    private String kaptchaImageWidth;
    @Value("${dd.kaptcha.image.height:''}")
    private String kaptchaImageHeight;
    @Value("${dd.kaptcha.session.key:''}")
    private String kaptchaSessionKey;
    @Value("${dd.kaptcha.session.date:''}")
    private String kaptchaSessionDate;

    /**
     * Shiro
     */
    @Value("#{'${dd.shiro.filterChainDefinitions.anon}'.split(',')}")
    private List<String> filterChainDefinitionsAnon = new ArrayList<>();
    @Value("#{'${dd.shiro.filterChainDefinitions.authc}'.split(',')}")
    private List<String> filterChainDefinitionsAuthc = new ArrayList<>();
    @Value("#{'${dd.interceptors.security.excludes}'.split(',')}")
    private List<String> interceptorsSecurityExcludes = new ArrayList<>();
    @Value("#{'${dd.interceptors.security.includes}'.split(',')}")
    private List<String> interceptorsSecurityIncludes = new ArrayList<>();
    @Value("#{'${dd.interceptors.session.excludes}'.split(',')}")
    private List<String> interceptorsSessionExcludes = new ArrayList<>();
    @Value("#{'${dd.interceptors.session.includes}'.split(',')}")
    private List<String> interceptorsSessionIncludes = new ArrayList<>();
    /**
     * Redis
     */
    @Value("${dd.redis.host:'127.0.0.1'}")
    private String redisHost;
    @Value("${dd.redis.port:'6379'}")
    private String redisPort;
    @Value("${dd.redis.timeout:'60000'}")
    private String redisTimeOut;
    @Value("${dd.redis.password:''}")
    private String redisPassword;
    @Value("${dd.redis.shiro.database:'0'}")
    private String redisShiroDatabase;
    @Value("${dd.redis.shiro.expire:'600'}")
    private String redisShiroExpire;
    @Value("${dd.redis.pool.maxIdle:'100'}")
    private String redisPoolMaxIdle;
    @Value("${dd.redis.pool.minIdle:'3'}")
    private String redisPoolMinIdle;

    /**
     * CAS
     */
    @Value("${dd.cas.enable:false}")
    private Boolean casEnable = false;
    @Value("${dd.cas.login:''}")
    private String casLoginUrl;
    @Value("${dd.cas.prefix:''}")
    private String casPrefixUrl;
    @Value("${dd.cas.callback:''}")
    private String casCallbackUrl;

    private LinkedHashMap<String, String> filterChainDefinitionMap;

    public String getSecurityKey() {
        return securityKey;
    }

    public String getUserDefaultPassword() {
        return userDefaultPassword;
    }

    public String getFileSaveType() {
        return fileSaveType;
    }

    public String getFileSaveRoot() {
        return fileSaveRoot;
    }

    public String getFtpHost() {
        return ftpHost;
    }

    public String getFtpLoginUserName() {
        return ftpLoginUserName;
    }

    public String getFtpLoginPassword() {
        return ftpLoginPassword;
    }

    public List<String> getFilterChainDefinitionsAnon() {
        return filterChainDefinitionsAnon;
    }

    public List<String> getFilterChainDefinitionsAuthc() {
        return filterChainDefinitionsAuthc;
    }

    public List<String> getInterceptorsSecurityExcludes() {
        return interceptorsSecurityExcludes;
    }

    public List<String> getInterceptorsSecurityIncludes() {
        return interceptorsSecurityIncludes;
    }

    public List<String> getInterceptorsSessionExcludes() {
        return interceptorsSessionExcludes;
    }

    public List<String> getInterceptorsSessionIncludes() {
        return interceptorsSessionIncludes;
    }

    public String getRedisHost() {
        return redisHost;
    }

    public String getRedisPort() {
        return redisPort;
    }

    public String getRedisTimeOut() {
        return redisTimeOut;
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public String getRedisShiroDatabase() {
        return redisShiroDatabase;
    }

    public String getRedisShiroExpire() {
        return redisShiroExpire;
    }

    public String getRedisPoolMaxIdle() {
        return redisPoolMaxIdle;
    }

    public String getRedisPoolMinIdle() {
        return redisPoolMinIdle;
    }

    public String getBaseName() {
        return baseName;
    }

    public String getCasLoginUrl() {
        return casLoginUrl;
    }

    public String getCasPrefixUrl() {
        return casPrefixUrl;
    }

    public String getCasCallbackUrl() {
        return casCallbackUrl;
    }

    public Boolean getCasEnable() {
        return casEnable;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getLoginOutUrl() {
        return loginOutUrl;
    }

    public String getLoginSuccessUrl() {
        return loginSuccessUrl;
    }

    public String getUnauthorizedUrl() {
        return unauthorizedUrl;
    }

    public String getKaptchaBorder() {
        return kaptchaBorder;
    }

    public String getKaptchaBorderColor() {
        return kaptchaBorderColor;
    }

    public String getKaptchaBorderThickness() {
        return kaptchaBorderThickness;
    }

    public String getKaptchaProducerImpl() {
        return kaptchaProducerImpl;
    }

    public String getKaptchaTextProducerImpl() {
        return kaptchaTextProducerImpl;
    }

    public String getKaptchaTextProducerCharString() {
        return kaptchaTextProducerCharString;
    }

    public String getKaptchaTextProducerCharLength() {
        return kaptchaTextProducerCharLength;
    }

    public String getKaptchaTextProducerFontNames() {
        return kaptchaTextProducerFontNames;
    }

    public String getKaptchaTextProducerFontSize() {
        return kaptchaTextProducerFontSize;
    }

    public String getKaptchaTextProducerFontColor() {
        return kaptchaTextProducerFontColor;
    }

    public String getKaptchaTextProducerCharSpace() {
        return kaptchaTextProducerCharSpace;
    }

    public String getKaptchaNoiseImpl() {
        return kaptchaNoiseImpl;
    }

    public String getKaptchaNoiseColor() {
        return kaptchaNoiseColor;
    }

    public String getKaptchaObscurificatorImpl() {
        return kaptchaObscurificatorImpl;
    }

    public String getKaptchaWordImpl() {
        return kaptchaWordImpl;
    }

    public String getKaptchaBackgroundImpl() {
        return kaptchaBackgroundImpl;
    }

    public String getKaptchaBackgroundClearFrom() {
        return kaptchaBackgroundClearFrom;
    }

    public String getKaptchaBackgroundClearTo() {
        return kaptchaBackgroundClearTo;
    }

    public String getKaptchaImageWidth() {
        return kaptchaImageWidth;
    }

    public String getKaptchaImageHeight() {
        return kaptchaImageHeight;
    }

    public String getKaptchaSessionKey() {
        return kaptchaSessionKey;
    }

    public String getKaptchaSessionDate() {
        return kaptchaSessionDate;
    }

    /**
     * 组装Shiro Filter
     *
     * @return
     */
    public LinkedHashMap<String, String> getFilterChainDefinitionMap() {
        filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionsAnon.forEach(tempString -> filterChainDefinitionMap.put(tempString, "anon"));
        filterChainDefinitionsAuthc.forEach(tempString -> filterChainDefinitionMap.put(tempString, "authc"));
        return filterChainDefinitionMap;
    }
}
