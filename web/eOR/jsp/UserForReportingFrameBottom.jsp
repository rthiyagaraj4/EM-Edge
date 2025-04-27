<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
<HEAD>
    <TITLE></TITLE>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
 	<script language="JavaScript" src="../../eOR/js/UserForReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%

	String finalString = request.getParameter("finalString");
	String order_category = request.getParameter("order_category");
	String responsibility = request.getParameter("responsibility");
	String practitioner_id = request.getParameter("practitioner_id");
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");

	finalString = (finalString == null) ? "" : finalString;
	order_category = (order_category == null) ? "" : order_category;
	responsibility = (responsibility == null) ? "" : responsibility;
	practitioner_id = (practitioner_id == null) ? "" : practitioner_id;
	bean_id = (bean_id == null)? "" : bean_id;
	bean_name = (bean_name == null) ? "" : bean_name;

	UserForReporting bean = (UserForReporting)getBeanObject( bean_id,bean_name, request) ;

	ArrayList PerformingFacility = new ArrayList();

%>

<body onload='FocusFirstElement();'> <%-- onunload="javascript:closeWindow()"--%>
<form name="list_dtl" id="list_dtl"  >
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<TR><TD class='label' ><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></TD><TD align='left'><Select name='performing_facility' id='performing_facility' onChange='populatePerformingLocns(this);'><Option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
		<%
			try{

				String[] record = null;

                PerformingFacility = bean.getPerformingFacility();
				for(int pln=0; pln<PerformingFacility.size(); pln++){
					record = (String [])PerformingFacility.get(pln);
				%>
				<option value="<%=record[0]%>" ><%=record[1]%></Option>
				<%
				}
			}catch(Exception e){
				//out.println("<script>alert('here1 : "+e+"')</script>");//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181

			}
		%>
	</Select>
	<%
		String[] record = null;
		for (int pln=0; pln<PerformingFacility.size(); pln++) {
			record = (String [])PerformingFacility.get(pln);
		%>
		<Input type='hidden' name='facility_name<%=record[0]%>' id='facility_name<%=record[0]%>' value='<%=record[1]%>'>
		<%}PerformingFacility=null;
	%>
	</TD>
	<TD class='label' ><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></TD><TD ><Select name='performing_locn' id='performing_locn' ><Option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option></Select></TD></TR>
	<TR><TD colspan='4' id='locn_names'>&nbsp;</TD></TR>
	<tr>
	<td colspan='4' class='button' align="right">
	<input type=hidden name="finalString" id="finalString" value="">
	<input type='hidden' name='order_category' id='order_category' value='<%=order_category%>'>
	<input type='hidden' name='dontChk' id='dontChk' value=''>
	<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
	<input type='hidden' name= 'bean_name' value='<%=bean_name%>'>
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	<input type=button class="button" name="select" id="select" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>" onClick="chkMandatory();">  <%-- onClick="chkMandatory();"--%> 
	<input type=button class="button" name="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="takeValues();">    <%--onClick="takeValues();"--%>
	<input type=button  class="button" name="clear" id="clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="removeValues();"><%-- onClick="removeValues();"--%>
	<input type=button class="button" name="close" id="close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="closeWindow()"> <%--onClick="closeWindow()"--%>  
	</td>
</tr>
</Form>
</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

