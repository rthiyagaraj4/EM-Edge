<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* , webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanObj" scope="page" class="eOR.PatOrderByPrivRelQueryBean"/>

<%--Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<!--  	<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
  	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../js/PatOrderByLocn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="populateLocationOnChange(document.PatOrderByLocnSearch.location_type);FillOrderType(document.PatOrderByLocnSearch.order_category);" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   		= request.getParameter( "mode" ) ;
	//String function_id 	= request.getParameter( "function_id" ) ;
	String bean_id 	 	= "Or_PatOrderByLocnBean" ;
	String bean_name 	= "eOR.PatOrderByLocnBean";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null) practitioner_id = "";


/* Mandatory checks end */

	/* Initialize Function specific start */
	//PatOrderByLocnBean bean = (PatOrderByLocnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 PatOrderByLocnBean bean = (PatOrderByLocnBean)getBeanObject( bean_id, bean_name, request ) ;
	/* Initialize Function specific end */
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;
	Properties properties		= (Properties) session.getValue( "jdbc" );  

	int patient_id_length = bean.getPatientIdLength();
	String curr_sys_date 	= "";
	String curr_week_date  	= "";
	String last_week_date  	= "";

	ArrayList sysdate 		= (ArrayList)bean.getSysDateTime();
		for(int i=0;i<sysdate.size();i++){
			last_week_date 		=  (String)sysdate.get(0);
			curr_week_date 		=  (String)sysdate.get(1);
			curr_sys_date 		=  (String)sysdate.get(2);
		}
		ArrayList OrderCategory = bean.getOrderCategory();
		ArrayList PracType		=	beanObj.getPractitionerID(properties);



	%>




	<form name="PatOrderByLocnSearch" id="PatOrderByLocnSearch">
		<table cellpadding=0 cellspacing=0   width="100%" align=center>
			<tr>
				<td class="label" align=right >Period</td>
				<td class="label" align=left >
					<input type="text" name="period_from" id="period_from"  size="16" maxlength="16" value="<%=curr_week_date%>">
				</td>
				<td class="label" align=right >To</td>
				<td class="label" align=left >
					<input type="text" name="period_to" id="period_to"  size="16" maxlength="16" value="<%=last_week_date%>">
				</td>
				<td class="label" align="right" >Status</td>
				<td class="label" align="left">
					<select name="status" id="status" >
						<option value="Z">-----All----</option>
						<option value="A">Active</option>
						<option value="C">Completed</option>
						<option value="D">Discontinued/Cancelled</option>
						<option value="P">Pending For Authorization</option>
						<option value="O">Outstanding</option>
						<option value="H">Suspended</option>
					</select>
				</td>
				<td class="label"></td>
			</tr>
			<tr>
				<td class="label" align=right >Order Category</td>
				<td class="label" align=left >
					<select name="order_category" id="order_category"   onChange="FillOrderType(this);">
						<option value="">----All----</option>
					<%      if(OrderCategory!=null && OrderCategory.size()>0){
							String[] order_cat = null;
								for(int i=0;i<OrderCategory.size();i++){
									order_cat = (String[])OrderCategory.get(i);
					%>
									<option value="<%=order_cat[0]%>" ><%=order_cat[1]%></option>
					<%	   }
						}
					%>
					</select>
				</td>
				<td class="label"align=right >Order Type</td>
				<td class="label" align=left>
					<select name="order_type" id="order_type" >
						<option value="">----All----</option>
					</select>
				</td>
				<td class="label" align="right" >Ordering Practitioner</td>
				<td class="label" align="left" >
					 <select name="ordering_pract" id="ordering_pract">
						<option value="">----All----</option>
					<%      if(PracType!=null && PracType.size()>0){
							String[] record = null;
								for(int i=0;i<PracType.size();i++){
									record = (String[])PracType.get(i);
					%>			<option value="<%=record[0]%>" ><%=record[1]%></option>
					<%  	}
						}	%>
				</select>
				</td>
				<td class="label"></td>
			</tr>
			<tr>
				<td class="label" align=right >Location Type</td>
				<td class="label" align=left>
				<select name="location_type" id="location_type" onChange="populateLocationOnChange(this);">
					<option value="">----All----</option>
					<option value="C">Clinic</option>
					<option value="N">Nursing Unit</option>
				</select>
				<td class="label" align=right >Location From</td>
				<td class=label align="left">
					<select name="locn" id="locn">
						<option value="">All</option>
					</select>
				</td>
				<td class=label align="right"  >To</td>
				<td class="label" align="left">
					<select name="locn1" id="locn1">
						<option value="">All</option>
					</select>
				</td>
				<td class="label"></td>
			</tr>
			<tr>
				<td class="label" align=right >Patient ID</td>
				<td class="label" align="left" >
					<input type="text" name="patient_id" id="patient_id" value="" onKeyPress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this)" size="20" maxlength="<%=patient_id_length%>">
					<input align="right" type="button" name=search value="?"  class="button" onClick="callPatientSearch()">
				</td>
				<td class="label" align=right >Encounter ID</td>
				<td class="label" align="left" >
					<input type="text" name="encounter_id" id="encounter_id" value="" onKeyPress="return CheckForSpecChars(event)" size="12" maxlength="12">
				</td>
				<td class=label align="right">Order ID</td>
				<td class=label align="left" >
					<input name="order_id" id="order_id" type="text" size="15" maxlength="15" onKeyPress="return CheckForSpecChars(event)"></td>
				<td class="label"></td>
			</tr>
			<tr>
				<td class="label" align=right >Order Catalog</td>
				<td class="label" align=left>
					<input type="text"  name="order_catalog" id="order_catalog" value="" onKeyPress="return CheckForSpecChars(event)" maxlength="20" size="20">
				</td>
				<td class="label" align=right >Search Criteria</td>
				<td class="label" align=left>
					<select name="search_crt" id="search_crt">
						<option value="C">Contain</option>
						<option value="S">Starts With</option>
						<option value="E">Ends With</option>
					</select>
				</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td class="label" align=right >Group By</td>
				<td class="label" align=left>
					<input type="radio" name="group_by" id="group_by" value="ORC">Order Category
				</td>
				<td class="label" align=left >
					<input type="radio" name="group_by" id="group_by" value="ORT">Order Type
				</td>
				<td class="label" align=left>
					<input type="radio" name="group_by" id="group_by" value="CAT">Order Catalog
				</td>
				<td class="label" align=left>
					<input type="radio" name="group_by" id="group_by" value="LOC" CHECKED>Location
				</td>
				<td align=left ><input type=button class=button name="search" id="search" value="Search" onClick="populateValues()"><input type=button name='clear' id='clear' class=button value="Clear" onClick="clearValues()">
				<td></td>
			</tr>
		</table>
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">
		<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">
	</form>
</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);

%>

