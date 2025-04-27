<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>

<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

 	<script language="JavaScript" src="../js/ImageHotSpotLink.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="FocusFirstElement()">

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_image_hotspot_link" ;
	String bean_name = "eOR.ImageHotSpotLinkBean";
	String readOnly = "";
	//out.println("<script>alert('mode==="+mode+"==')</script>");
/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ImageHotSpotLinkBean bean = (ImageHotSpotLinkBean)getBeanObject( bean_id,  bean_name , request) ;  
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));


	ArrayList update_orders = new ArrayList();
	/* Initialize Function specific end */
	bean.setMode( mode ) ;

	String image_desc = "";
	String hot_spot_desc = "";
	String image_link = "";
	String image_id		=	"";
	String hot_spot_id	=	"";


	String allValues[]  = new String[3];
	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {

		 image_id			= request.getParameter("image_id");
		 hot_spot_id		= request.getParameter("hot_spot_id");
		 image_link			= request.getParameter("image_link");

//out.println(image_id);
//out.println(" ------- "+hot_spot_id);
//out.println(" ------- "+image_link);

		allValues = (String[])bean.getValues(image_id, hot_spot_id, image_link);
		image_desc = allValues[0];
		hot_spot_desc = allValues[1];
		
//out.println("<BR>"+image_desc);
//out.println(" ------- "+hot_spot_desc);
		//image_desc = image_id;
	//	hot_spot_desc = hot_spot_id;
		//image_link = allValues[2];
		readOnly = " readOnly ";
	}
%>
<form name="image_hot_spot" id="image_hot_spot" target="messageFrame">
<table cellpadding=3 cellspacing=0 width="100%" border=0 align=center>
<tr>
	<td class="label" width='40%'><fmt:message key="Common.Image.label" bundle="${common_labels}"/></td>
	<td class="fields">
	<%	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {
		out.println("<input type=text name='image_disp' id='image_disp' value=\""+image_desc+"\" readonly width=50>");
		out.println("<input type=hidden name='image' id='image' value="+image_id+" readonly width=30>");
		}else{
	%>
		<SELECT name="image" id="image" onChange='populateHotSpots(this)'>
		<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			update_orders = (ArrayList)bean.getImageNames();
			for(int i=0; i<update_orders.size(); i++){
				String[] record = (String [])update_orders.get(i);
		%>
			<option value="<%=record[0]%>"><%=record[1]%></option>
		<%	
			}
		%>
		</SELECT>
	<%}%>
		<img src="../../eCommon/images/mandatory.gif" align=center>

</td>
</tr>
<tr>
	<td class="label"><fmt:message key="eOR.HotSpot.label" bundle="${or_labels}"/></td>
	<td class="fields">
	<%	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {
		out.println("<input type=text name='hot_spot_disp' id='hot_spot_disp' value=\""+hot_spot_desc+"\" readonly>");
		out.println("<input type=hidden name='hot_spot' id='hot_spot' value="+hot_spot_id+" readonly>");
		}else{
	%>
				<SELECT name="hot_spot" id="hot_spot" >
					<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				</SELECT>
	<%}%><img src="../../eCommon/images/mandatory.gif" align=center>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="eOR.ImageLink.label" bundle="${or_labels}"/></td>
	<td class="fields" >
				<INPUT TYPE="text" name="image_link" id="image_link" size=15 maxlength=15 value="<%=image_link%>" <%=readOnly%>  onBlur = "return makeValidString(this)"><img src="../../eCommon/images/mandatory.gif" align=center></td>
</tr>


</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

</form>
</body>

</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>

<!-- INSERT INTO or_image_hotspot_link ( image_id, hotspot_id, image_link_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES ( '<Image ID>', '<Hot spot id>', '<Image link id>',  + 7 fields);  -

select distinct 'X' from or_ordeR_Catalog where image_link_id = ''

->

