<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	
	String bean_id				=	"autoclavingBean";
	String bean_name			=	"eSS.AutoclavingBean";

	//String checked_yn			=	request.getParameter("checked_yn")==null?"false":request.getParameter("checked_yn");
	//String tray_no				=	request.getParameter("tray_no")==null?"":request.getParameter("tray_no");
	String function_id			=	request.getParameter("function_id")==null?"":request.getParameter("function_id");
	//ArrayList alAutoclavingList =	 new ArrayList();
	int count					=	0;
	//HashMap hmAutoclavingRecord =	new HashMap();
	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
	hash						=		(Hashtable)hash.get( "SEARCH" ) ;
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
		
	AutoclavingBean bean = (AutoclavingBean) getBeanObject(bean_id, bean_name , request ) ;  



 try
   {
	   if(function_id.equals("autoclaving_detail")){
	
		int start				=		Integer.parseInt(request.getParameter("start"));
		int end					=		Integer.parseInt(request.getParameter("end"));
		int totalRecords		=		Integer.parseInt(request.getParameter("totalRecords"));
		String select_all			=		request.getParameter("select_all");
		
		bean.updateSelectedTrays(hash, start, end,totalRecords);
		count=bean.getSelectedTrays(hash, start, end,totalRecords);
		bean.setSelect_All(select_all);
	}


		out.println("refreshMessageFrame();");
   }catch(Exception e){

       out.println("checkRecord();");
       out.println("deletePreviousRecord();");
	   System.err.println(e);
	}

	putObjectInBean(bean_id,bean,request);

%>
