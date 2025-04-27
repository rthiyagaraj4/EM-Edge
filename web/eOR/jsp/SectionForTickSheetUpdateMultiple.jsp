<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %> 
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="Javascript" src="../../eOR/js/SectionForTickSheet.js"></script>

	
 </head>
<%
	
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_SectionForTickSheet" ;
	String bean_name = "eOR.SectionForTickSheet";
	//String disabled = "" ;
//
	/* Initialize Function specific start */
	SectionForTickSheet bean =
	(SectionForTickSheet)getBeanObject( bean_id,bean_name, request );
	bean.clear() ;
	bean.setMode(mode) ;

	String order_category="";
	String tick_sheet_id= "";
	String eff_status = "";
	String section_code ="";
	String section_desc = "";
	String seq_no	= "";
	String order_category_short_desc="";
	String tick_sheet_desc="";
   ArrayList selectData=new ArrayList();



	order_category= request.getParameter("order_category");
	 tick_sheet_id= request.getParameter("tick_sheet_id");
	section_code = request.getParameter("section_code");
	order_category_short_desc=request.getParameter("order_category_short_desc");
	tick_sheet_desc=request.getParameter("tick_sheet_desc");
	seq_no	= request.getParameter("seq_no");

	if (seq_no == null) seq_no = "";

	selectData.add((String)order_category);
	selectData.add((String)tick_sheet_id);
	selectData.add((String)section_code);

	String[] loadDataVal=(String[])bean.loadData(selectData);

	section_desc=(String)loadDataVal[0];
	eff_status= (String)loadDataVal[1];
	if(loadDataVal[2] == null) 
		seq_no = "";
	else 
		seq_no		=(String)loadDataVal[2];

		loadDataVal=null;

%>
<%--<script>alert('<%=seq_no%>')</script>--%>
 <iframe name='f_query_add_mod_header' id='f_query_add_mod_header' src="../../eOR/jsp/SectionForTickSheetAddModifyHeader.jsp?order_category=<%=order_category%>&tick_sheet_id=<%=tick_sheet_id%>&section_code=<%=section_code%>&section_desc=<%=section_desc%>&eff_status=<%=eff_status %>&tick_sheet_desc=<%=tick_sheet_desc%>&order_category_short_desc=<%=order_category_short_desc%>&mode=2&seq_no=<%=seq_no%>"  frameborder=0 style='height:0vh;width:100vw'></iframe>
 <iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail'  src="../../eOR/jsp/SectionForTickSheetUpdate.jsp?order_category=<%=order_category%>&tick_sheet_id=<%=tick_sheet_id%>&section_code=<%=section_code%>&section_desc=<%=section_desc%>&eff_status=<%=eff_status %>&tick_sheet_desc=<%=tick_sheet_desc%>&order_category_short_desc=<%=order_category_short_desc%>&mode=2&seq_no=<%=seq_no%>" frameborder=0 style='height:86vh;width:100vw'></iframe>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

