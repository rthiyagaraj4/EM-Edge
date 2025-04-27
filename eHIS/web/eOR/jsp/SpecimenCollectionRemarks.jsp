<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*,eOR.* ,webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!--<title>Collection Date And Time</title>-->
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
 	<script language="JavaScript" src="../../eOR/js/SpecimenOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="specimenRemarks" id="specimenRemarks">
<%
	String login_user = (String)session.getAttribute("login_user");
	if (login_user == null) {
	   login_user = "";
	}
	//out.println("<script>alert('"+login_user+"')</script>");
	
    String specimen_remarks		= request.getParameter("specimen_remarks");
	String collected_by			= request.getParameter("collected_by");
	String option_from			= request.getParameter("option_from");
    String bean_id				= request.getParameter("bean_id");
	String bean_name			= request.getParameter("bean_name");
	String calledFrom			= request.getParameter("calledFrom");
	String collection_list		= request.getParameter("collection_list");
	String loc_type				= request.getParameter("loc_type");
	String location				= request.getParameter("location");
	String called_from				= request.getParameter("called_from");
	//String templocale           = localeName;

	if(specimen_remarks==null) specimen_remarks 	= "";
	if(collected_by == null) collected_by 			= "";
	if(option_from == null) option_from 			= "";
	if (bean_id==null)	bean_id 					= "";
	if (bean_name==null) bean_name 					= "";
	if (calledFrom == null) calledFrom				= "";
	if (collection_list == null) collection_list	= "N";
	if (loc_type == null) loc_type					= "";
	if (location == null) location					= "";
	if (called_from == null) called_from					= "";
	
	collected_by=(collected_by.equals("")) ? login_user : collected_by;
	//String collectedByReadOnly="readonly";
	String collectedByReadOnly="DISABLED";  //ML-MMOH-SCF-2378
	if("".equals(collected_by))
		collectedByReadOnly="";
	
%>

	<table cellpadding=2 cellspacing=0 border='0' width='100%' align=center>
		<tr><td class=label width='47%'><%=(option_from.equals("DISPATCH"))?" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispatchedBy.label","common_labels")+"":" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CollectedBy.label","common_labels")+""%></td><td class='fields' width='50%'><input name='collected_by' id='collected_by' type='text' size='15' maxlength='15' value='<%=collected_by%>' <%=collectedByReadOnly%> >
		<img src="../../eCommon/images/mandatory.gif" align=center/></td></tr><!-- ML-MMOH-SCF-2378 -->
		<tr>
			<td class='label' width='47%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='fields' width='50%'><TEXTAREA name="specimen_remarks" id="specimen_remarks" ROWS="3" COLS="21" onkeyPress='checkMaxLimit(this,255)'  onBlur="return makeValidString(this);"><%=specimen_remarks%></TEXTAREA></td>   <%--<img src="../../eCommon/images/mandatory.gif" align=center/>--%>
		</tr>
		<%if((option_from.equals("DISPATCH")) && (calledFrom.equals("ALL"))) {%>
		<tr><TD id="location_id"  class=label nowrap><fmt:message key="eOR.DispatchLocation.label" bundle="${or_labels}"/></TD><!--width='10%' -->
		<TD id='print_location_type' colspan="2" nowrap class=fields><input type='checkbox' name='print_loc_chk' id='print_loc_chk' value='<%=collection_list%>' onClick='selectDispatchLoc(this)' <%=(collection_list.equals("Y"))?"checked":""%>>
		<%if (collection_list.equals("Y") && (calledFrom.equals("ALL"))) {%>
		<Select name='loctype' id='loctype' onChange='populatePrintLocation(this,"DISPATCH")'>     <!--onChange='populatePrintLocation(this)'-->
    			<Option value="" <%=(loc_type.equals(""))?"selected":""%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</Option>
    			<Option value='C' <%=(loc_type.equals("C"))?"selected":""%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></Option>
    			<Option value='N' <%=(loc_type.equals("N"))?"selected":""%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></Option>
    		</Select>
    		<input type="text" value='' name="print_loc_desc" id="print_loc_desc" onblur='populatePrintLoaction1(print_loc_desc,print_loc);'><input type=button name="PrintSearch" id="PrintSearch" value='?'  class=button tabIndex="4" onClick="populatePrintLoaction(print_loc_desc,print_loc);" disabled><img src="../../eCommon/images/mandatory.gif" align=center style='visibility:hidden' id='imgmand'><input type="hidden" name="print_loc" id="print_loc" value="">
			<img src="../../eCommon/images/mandatory.gif" align=center/>
		<%}else {%>
		<input type='hidden' name='loctype' id='loctype' value=''><input type='hidden' name='print_loc' id='print_loc' value=''>
		<%}%>
		</TD></tr>
		<%} else {%>
		<input type='hidden' name='print_loc_chk' id='print_loc_chk' value='N'>
		<input type='hidden' name='loctype' id='loctype' value=''>
		<input type='hidden' name='print_loc' id='print_loc' value=''>

		<%}%>
		<tr><td class=label></td><td class=label></td>  </tr>
	</table>
	<input type='hidden' name='bean_id' id='bean_id' value=<%=bean_id%>>
	<input type='hidden' name='bean_name' id='bean_name' value=<%=bean_name%>>
	<input type='hidden' name='called_from' id='called_from' value=<%=called_from%>>
	<input type="hidden" name="language" id="language" value="<%=localeName%>">
	<input type="hidden" name="clinic_sql" id="clinic_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_C")%>">
	<input type="hidden" name="nursing_sql" id="nursing_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_REGISTER_ORDER_SELECT_LOCN_N")%>">
	<%if (collection_list.equals("Y") && (calledFrom.equals("ALL"))) {%>
	<Script>populatePrintLocation(document.getElementById("loctype"),"DISPATCH");
	document.getElementById("print_loc").value = '<%=location%>'
	</Script>
	<%}%>
</FORM>
<!--<table cellpadding=0 cellspacing=0 border='0' width='98%'>
	<tr><td align=right colspan=3><input type=button class=button name="ok" id="ok" Value="Ok" onclick="closeDate();"></td></tr>
	</Table>-->
</body>
</html>

