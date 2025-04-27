<!DOCTYPE html>
 <!--
Developed by	: P.Sudhakaran.
Module/Function : Drug Item Link Validation
-->
<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String bean_id		= "DrugItemLink" ;
    String bean_name	= "ePH.DrugItemLinkBean";
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	DrugItemLinkBean bean = (DrugItemLinkBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.getResult();
	int start=Integer.parseInt((String)hash.get("START"));
	int end=Integer.parseInt((String)hash.get("END"));

	for( int i=start;i<end;i++ ){
		if( hash.containsKey( "ITEM_CODE"+i ) ){
			bean.modifyResult( ((String)hash.get("ITEM_CODE"+i)),((String)hash.get("LINK_YN"+i)),((String)hash.get("HEAD_LINK_YN"+i)) );
		}
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>

