<!DOCTYPE html>
<%@ page contentType="application/x-java-jnlp-file" %>
<%
String codeBaseUrl = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/eXH/js";
String pluginPort=request.getParameter("PluginPort");
String pluginTransType=request.getParameter("PluginTransactionType");
String jarPath=request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/web/WEB-INF/lib/EM-CC-plugin.jar";
System.out.println("CreditcardInterfaceJNLP:::coded base url..."+codeBaseUrl);
System.out.println("CreditcardInterfaceJNLP:::pluginPort..."+pluginPort);
System.out.println("CreditcardInterfaceJNLP:::jarPath..."+jarPath);
%>
 <?xml version="1.0" encoding="utf-8"?>
 <jnlp spec="1.0+" codebase="<%=codeBaseUrl %>" href="CreditcardInterface.jnlp">
	<information>
		<title>Creditcard Interface Testing</title>
		<vendor>Enterprise Manager</vendor>
		<description>EM External Application Communication</description>
	</information>
	<security>
		<all-permissions />
	</security>
	<resources>
		<j2se version="1.4+" />
		<jar href="../../eXH/CreditcardPlugin/EM-CC-plugin.jar" main="true" />
		<jar href="../../eXH/CreditcardPlugin/jssc.jar"/>
	</resources>
	<application-desc main-class="com.csc.eminterface.cc.Listener" >
	<argument><%=pluginPort %></argument>
	<argument><%=pluginTransType %></argument>
	</application-desc>
</jnlp>




