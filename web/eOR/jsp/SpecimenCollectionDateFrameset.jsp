<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
25/09/2013	  IN043695		Chowminya G	    While Record Collection - Interval Tests are not displaying as 5.x Version
-------------------------------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*,eCommon.XSSRequestWrapper "%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
  <head>
	<title><fmt:message key="eOR.CollectionDetails.label" bundle="${or_labels}"/></title>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
  <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  	String bean_id				= request.getParameter("bean_id");
	if (bean_id==null)	bean_id = "";
//System.out.println("in frameset"+request.getQueryString());
	String bean_name			= request.getParameter("bean_name");
	if (bean_name==null) bean_name = "";

	String order_id				= request.getParameter("order_id");
	if(order_id==null) order_id = "";
	String labchk=request.getParameter("labvalues");//added on 7/16/2007 for lb_module by uma 
	if(labchk==null)labchk="";
	/*Added by Uma on 1/21/2010 for IN018402*/
	String order_type_code		= request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
	/* Ends Here*/
	//out.println("<script>alert('here="+labchk+"')</script>");


	SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(localeName);

	//String lb_module = bean.getLbInstall("RL");

	boolean flag = false;

  		//if(lb_module.equals("Y")) {changed on 7/16/2007 for lb_module installed chk
		if(labchk.equalsIgnoreCase("IBARL"))//added on 7/16/2007 for lb_module by uma
		{
			String interval_test_yn = bean.getIntervalTestYn(order_id);
			if (interval_test_yn == null) interval_test_yn = "";
			if (interval_test_yn.equalsIgnoreCase("Y")) {
				flag = true;
			}else
				flag =false;
		}
		/*Added by Uma on 1/21/2010 for IN018402*/
		String neonate_spec_yn = bean.getNeonateSpecimenYN(order_id,order_type_code);
		if (neonate_spec_yn == null) neonate_spec_yn = "";
		if (neonate_spec_yn.equalsIgnoreCase("Y") && !flag) {
			flag = true;
		}/*else
			flag =false;*///IN043695
		/*Ends Here*/
  %>
	<iframe src="../../eOR/jsp/SpecimenCollectionDate.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="<%=(flag)?"auto":"no"%>" name="SpecimenCollectionDate" NORESIZE style="height:42vh;width:99vw"></iframe>
    		<iframe src="../../eOR/jsp/SpecimenCollectionRemarks.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no" name="SpecimenCollectionRemarks" NORESIZE style="height:40vh;width:99vw"></iframe>
       		<iframe src="../../eOR/jsp/SpecimenCollectionDateButton.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no" name="SpecimenCollectionDateButton" id="SpecimenCollectionDateButton" NORESIZE style="height:18vh;width:99vw"></iframe>
    
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

