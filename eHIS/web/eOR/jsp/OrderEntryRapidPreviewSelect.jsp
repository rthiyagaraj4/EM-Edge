<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	    request.setCharacterEncoding("UTF-8");

	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String func_mode 				= request.getParameter( "func_mode" ) ;
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	//String key					= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
   	//java.util.HashMap previousValues = (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);

	String order_category			=  bean.checkForNull(request.getParameter("order_category"),"");
	//String lb_instal_yn				=  bean.checkForNull(request.getParameter("lb_instal_yn"),"");changed on 7/9/2007 for lb_instal_yn by uma
	String order_type_code				=  bean.checkForNull(request.getParameter("order_type_code"),"");				// For Peforming Dept Loc
	String rd_instal_yn				=  bean.checkForNull(request.getParameter("rd_instal_yn"),"");				// For Peforming Dept Loc
	String order_catalog_code		=  bean.checkForNull(request.getParameter("order_catalog_code"),"");		// For Peforming Dept Loc
	String performing_facility_id	=  bean.checkForNull(request.getParameter("performing_facility_id"),"");	// For Peforming Dept Loc
	String classValue				= "";
	String[] records				= null;	
	int		i						= 0;
%>
  <head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryRapidPreview.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </head>
   <body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
   <form name="selectForm" id="selectForm">
	<table border="1" cellpadding=3 cellspacing=0  width="100%" id="titleTab" class="grid">
	<tr>
		<td class="gridData">
			<a class="gridLink" href="#" onClick='javascript:return retCodeDescription("",this)' >
				----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
			</a>
		</td>
	</tr>
<%
		if(func_mode!=null && func_mode.equals("FREQUENCY"))	{
			ArrayList PlaceOrderFrequency = bean.getPlaceOrderFrequency(order_catalog_code,"","","","","");
			for(i=0; i<PlaceOrderFrequency.size(); i++)
			{
				records			 = (String[]) PlaceOrderFrequency.get(i);
				classValue="gridData";
				%>
				<tr>	
					<td class="<%=classValue%>">
						<a class="gridLink" href="#" onClick='javascript:return 	retCodeDescription("<%=records[0]%>",this)' >
						<%=records[1]%>
						</a>
					</td>
				</tr>
<%			} // End of for
		} else if(func_mode!=null && func_mode.equals("PERFORMING_DEPT_LOC"))	{
			//ArrayList DeptLocationCode = bean.getPerformingDeptLocation(performing_facility_id,order_catalog_code,order_category,lb_instal_yn,rd_instal_yn);changed on 7/9/2007 for lb_instal_yn logic by uma
			ArrayList DeptLocationCode = bean.getPerformingDeptLocation(performing_facility_id,order_catalog_code,order_category,order_type_code,rd_instal_yn);
			for(i=0; i<DeptLocationCode.size(); i++)
			{
				 records	= (String[]) DeptLocationCode.get(i);
   				classValue="gridData";
%>
				<tr>
					<td class="<%=classValue%>">
						<a class="gridLink" href="#" onClick='javascript:return retCodeDescription("<%=records[0]%>",this)' >
							<%=records[1]%>
						</a>
					</td>
				</tr>
<%			} // End of for
		} // end of else
		if(i == 0){			%>
		  	<script type="text/javascript">
		  	window.setTimeout(function() {
		  	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));window.close();},100);</script>
<%		 }	%>
	</table>
	</form>
	</body>
 </html>

<%
	// no need to set it back persistence
	// putObjectInBean(bean_id,bean,request);
%>

