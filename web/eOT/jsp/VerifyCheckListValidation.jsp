<!DOCTYPE html>
<%
//"java.sql.*, java.util.*, java.io.*, eOT.Common.*, eOT.*"
%>
<%@page   import="java.util.Hashtable,eOT.*"  %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<% request.setCharacterEncoding("UTF-8"); 

	try {
		String func_mode	= request.getParameter("func_mode");
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id		= "@VerifyCheckListBean";
		String bean_name	= "eOT.VerifyCheckListBean";
		VerifyCheckListBean bean= (VerifyCheckListBean)mh.getBeanObject( bean_id, request, bean_name );

		if(func_mode!= null && func_mode.equals("validateUserPIN")){
			String user_id		= (String) hash.get("user_id");
			String pin_no		= (String) hash.get("pin_no");
			String valid_user	= bean.validateUserPIN(user_id,pin_no);
			out.println(valid_user);
		}else if(func_mode!= null && func_mode.equals("clearBean")){
			bean.clear();
		}			
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
