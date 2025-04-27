<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>


	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>

	<script language="javascript" src="../js/RepMonthlyForOrdType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;

	String bean_id = "Or_ORReportsConsolidatedOrderList" ;
	String bean_name = "eOR.ORReportsConsolidatedOrderList";

	//String report = request.getParameter("rep");
	//String disabled = "" ;
	ArrayList Category_Data = new ArrayList();
	ArrayList OrderType_Data = new ArrayList();
	//ArrayList Status_Data = new ArrayList();


	/* Mandatory checks end */

	/* Initialize Function specific start */
	ORReportsConsolidatedOrderList bean = (ORReportsConsolidatedOrderList)getBeanObject( bean_id,  bean_name, request ) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	//int patient_id_length 	= 10;
	//patient_id_length		= bean.getPatientIdLength();

    String p_report_id		= "ORBORCON";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;

%>
<BR><BR><BR><BR><BR><BR>
<form name='RepMonthlyForOrdType' id='RepMonthlyForOrdType' target='messageFrame'  action="../../eCommon/jsp/report_options.jsp">
<table cellpadding='0' cellspacing='0' border='0' width="98%" align='center'>
	<TD colspan='4'>&nbsp;</TD>
	<TR>
		<TD class='label' align='right'>Order Category</TD>
		<TD>&nbsp;<Select name='p_from_category' id='p_from_category' onChange='populateOrderTypes(this)'><Option value=''>&nbsp;&nbsp;&nbsp;--- All ---&nbsp;&nbsp;&nbsp;</Option>
		<%
			try{
				Category_Data = bean.getAllOrderCategory();

				for(int i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);

		%>
				<option value=<%=record[0]%>><%=record[1]%></Option>
		<%
				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                                e.printStackTrace();//COMMON-ICN-0181
			}
		%>
		</Select></TD>
		<TD colspan='2'>&nbsp;</TD>
	</TR>
	<TR><TD colspan='4'>&nbsp;</TD></TR>
	<TR>
		<TD class='label' align='right'>Order Type</TD>
		<TD>&nbsp;<Select name='p_from_order_type' id='p_from_order_type'><Option value='*ALL'>&nbsp;&nbsp;&nbsp;--- All ---&nbsp;&nbsp;&nbsp;</Option>
		<%
			try{
				OrderType_Data = bean.getAllOrderType();

				for(int i=0; i<OrderType_Data.size(); i++){
					String[] record = (String [])OrderType_Data.get(i);

		%>
				<option value=<%=record[0]%>><%=record[1]%></Option>
		<%
				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                               e.printStackTrace();//COMMON-ICN-0181
			}
		%>
		</Select></TD>
		<TD colspan='2'>&nbsp;</TD>
	</TR>
	<TR><TD colspan='4'>&nbsp;</TD></TR>
	<TR>
		<TD class='label' align='right'>Period Type</TD>
		<TD>&nbsp;<Select name='p_from_period_type' id='p_from_period_type' onChange='setDateType(this)'><Option value='D'>Date</Option>
		<Option value='M'>Month</Option>
		<Option value='Y'>Year</Option>
		</Select></TD>
		<TD colspan='2'>&nbsp;</TD>
	</TR>
	<TR><TD colspan='4'>&nbsp;</TD></TR>
	<TR>
		<TD class='label' align='right'>Period Range From</TD>
		<TD id='from_period'>&nbsp;<Input type='text' name='p_from_period_range' id='p_from_period_range'  maxlength='10' size='10' onBlur="CheckDate(this)" onKeyPress='return OrAllowDateFormat()'></TD>
		<TD class='label' align='right'>To</TD>
		<TD id='to_period'>&nbsp;<Input type='text' name='p_to_period_range' id='p_to_period_range'  maxlength='10' size='10' onBlur="CheckDate(this)" onKeyPress='return OrAllowDateFormat()'></TD>
	</TR>
	<TR><TD colspan='4'>&nbsp;</TD></TR>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<input type="hidden" name="p_user_name" id="p_user_name" value="<%=p_user_name%>">
<Input type="hidden" name='p_report_id' id='p_report_id' value="<%=p_report_id%>">
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=localeName%>">
</form>

</body>
</html>


<%
		putObjectInBean(bean_id,bean,request);
 
%>

