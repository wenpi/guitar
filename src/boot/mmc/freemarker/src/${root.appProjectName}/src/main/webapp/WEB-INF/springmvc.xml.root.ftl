<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:context="http://www.springframework.org/schema/context"
  xmlns:mvc="http://www.springframework.org/schema/mvc"
  xsi:schemaLocation="
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">

  <context:component-scan base-package="${root.corpJavaPackageName}" use-default-filters="false">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    <context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
  </context:component-scan>

  <mvc:annotation-driven>
    <mvc:message-converters register-defaults="true">
      <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter" />
      <bean class="org.springframework.http.converter.ByteArrayHttpMessageConverter" />
      <bean class="org.springframework.http.converter.StringHttpMessageConverter">
          <constructor-arg value="UTF-8" />
      </bean>
      </mvc:message-converters>
  </mvc:annotation-driven>

  <mvc:interceptors>
    <bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor" />
  </mvc:interceptors>

  <mvc:default-servlet-handler/>

  <bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver">
    <property name="defaultLocale" value="${r'${locale.default}'}" />
  </bean>

  <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <property name="maxUploadSize" value="100000000" />
  </bean>

  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/views/jsp/pages/"/>
    <property name="suffix" value=".jsp"/>
  </bean>

  <bean class="org.springframework.web.servlet.view.XmlViewResolver">
    <property name="order" value="1"/>
    <property name="location" value="/WEB-INF/views.xml"/>
  </bean>

  <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
    <property name="exceptionMappings">
      <props>
        <prop key="java.lang.Throwable">500</prop>
      </props>
    </property>
  </bean>

  <beans profile="production">
    <context:property-placeholder ignore-unresolvable="true" ignore-resource-not-found="true" file-encoding="UTF-8"
      location="classpath:application.properties" />
  </beans>

  <beans profile="development">
    <context:property-placeholder ignore-unresolvable="true" ignore-resource-not-found="true" file-encoding="UTF-8"
      location="classpath:application.properties,
                classpath:application.development.properties" />
  </beans>

  <beans profile="test">
    <context:property-placeholder ignore-unresolvable="true" ignore-resource-not-found="true" file-encoding="UTF-8"
      location="classpath:application.properties,
                classpath:application.test.properties" />
  </beans>

</beans>
