<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
		//System.out.println("function_id frame:"+params);
%>
<HTML>
<HEAD>
</HEAD>
<%
		//System.out.println("-----------PkgEnqChargeBasedMain.jsp----------");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//System.out.println("params:"+params);
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/PkgEnq.js'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
		<iframe name='ChargeBasedDtl' id='ChargeBasedDtl'	src='PkgEnqChargeBased.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:50vh;width:100vw'></iframe>
		<iframe name='ChargeBasedExCln' id='ChargeBasedExCln'	src='../../eCommon/html/blank.html'  frameborder=0 noresize scrolling='no' style='height:50ch;width:100vw'></iframe>
</HTML>

