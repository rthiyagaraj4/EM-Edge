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
<%@page import="java.util.*, webbeans.eCommon.ConnectionManager,eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>

	<SCRIPT LANGUAGE="javascript" SRC="../js/PatientOrders.js"></SCRIPT>   
	<SCRIPT language="javascript">
	


</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</HEAD>

<BODY  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<FORM name="frmPatientOrders" id="frmPatientOrders" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
	<%
	 ArrayList Category_Data = new ArrayList();
	 ArrayList print_order		= new ArrayList();
	//ArrayList print_order1		= new ArrayList();
	String bean_id		= "patient_report" ;
	String bean_name	= "eOR.PatientOrdersReportBean";

	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//PatientOrdersReportBean bean = 	(PatientOrdersReportBean)mh.getBeanObject( bean_id, request,bean_name );  
	PatientOrdersReportBean bean = (PatientOrdersReportBean)getBeanObject( bean_id, bean_name, request ) ;

	String facility_id = (String)session.getValue("facility_id");
	
	/* Initialize Function specific end */
	int patient_id_length = bean.getPatientIdLength();
%>
	<br><br><br><br><br><br><br><br>

	<TABLE WIDTH="67%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TR>
			<TD COLSPAN="2">&nbsp</TD>
			<td></td>
		</TR>	
		<TR>
			<TD ALIGN="right" width="32%"  CLASS="label">Patient ID &nbsp</TD>
			<TD ALIGN="left" >
				<input type=text name="p_patient_id" id="p_patient_id" maxlength="<%= patient_id_length %>"
				value='' nowrap onKeyPress='return lockSpecialCharacters(this)' onBlur='ChangeUpperCase(this)'> <input type=button class="button" value="?" onclick="javascript:callPatientSearch()">
				<img src="../../eCommon/images/mandatory.gif"></img>
			</TD>
			<td></td>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp</TD>
			<td></td>
		</TR>
		<TR>
			<TD ALIGN="right"  width="32%"  CLASS="label">Encounter ID &nbsp</TD>
			<TD ALIGN="left" >
				<input type=text name="p_encounter_id" id="p_encounter_id" maxlength=12 size="12" onKeyPress='return lockSpecialCharacters(this)'> <!-- <input type=button class="button" value="?" onclick="javascript:callEncounterSearch(this)"> -->
			</TD>
			<td></td>
		</TR>
	<TR>
			<TD COLSPAN="2">&nbsp</TD>
			<td></td>
		</TR>
	
	<TR>
			<TD ALIGN="right"  width="32%"  CLASS="label">Order Category &nbsp</TD>
			<TD ALIGN="left" >
				<select size="1" name="p_order_category" id="p_order_category" onchange="populateOrderTypes(this);">
				<option value="">All</option>
				 <%
			try{
				Category_Data = bean.getAllOrderCategory();

				for(int i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);

		%>
				<option value=<%=record[0]%>><%=record[1]%>
		<%
				}
			}catch(Exception e){
				//out.println(e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		%> 
				</select>
			</TD>
			<td></td>
		<TR>
			<TD COLSPAN="2">&nbsp</TD>
			<td></td>
		</TR>

		</TR>
	<!-- <tr>
	<TD ALIGN="right" WIDTH="1200" CLASS="label">From </TD>
	<TR>
			<TD COLSPAN="2">&nbsp</TD>
		</TR>
	</tr> -->
	<tr>
					<td   CLASS="label"></td> 
					<td  ALIGN="left" CLASS="label">From</td>
					<td  ALIGN="left" width="32%"  CLASS="label">To</td>
	</tr>
	<TR>
			<TD ALIGN="right" width="32%"  CLASS="label">Order Type &nbsp</TD>
			<TD ALIGN="left" >
				<select size="1" name="p_order_type_from" id="p_order_type_from">
				<option value="">All</option>
				
				<%
				
		String ord_cat = "";
		
		print_order=bean.getOrderTypeData(ord_cat);
		for(int i=0 ; i<print_order.size() ; i++){
		String[] record = (String []) print_order.get(i);
	%>
	
	 <option value=<%=record[0]%> ><%=record[1]%> </option>
	<%}
	%>
				</select>
			 </td>
			<td ALIGN="left" >
				<select size="1" name="p_order_type_to" id="p_order_type_to">
				<option value="">All</option>
			  <%
				//print_order=bean.getPrintOrders();
		/*String ord_cat1 = "";
		print_order1=bean.getOrderTypeData1(ord_cat1);*/
		for(int i=0 ; i<print_order.size() ; i++){
		String[] record = (String []) print_order.get(i);
	%>
	 <option value=<%=record[0]%> ><%=record[1]%> </option>
	<%}
	%> 
				</select>
			</TD>
			<td></td>
			 <TR>
			<TD COLSPAN="2">&nbsp</TD>
			<td></td>
		</TR>
		</TR>
	<TR>
			<TD ALIGN="right" width="32%"  CLASS="label">Period &nbsp</TD>
			<TD ALIGN="left" >
				<input type=text name="p_period_from" id="p_period_from" size="10"onkeypress='return Valid_DT(event)' maxlength=10 onblur='datefun(this);' >&nbsp;</td><TD ALIGN="left" ><input type=text name="p_period_to" id="p_period_to" size="10" maxlength=10 onkeypress='return Valid_DT(event)' onblur='datefun(this);	var retval= doDateCheck(parent.searchResultFrame.document.frmPatientOrders.p_period_from,parent.searchResultFrame.document.frmPatientOrders.p_period_to,parent.messageFrame);if(retval==true){parent.messageFrame.location.href="../../eCommon/jsp/error.jsp"};'> 
			</TD>
			<td></td>
		</TR>	
		<TR>
			<TD COLSPAN="2">&nbsp</TD>
			<td></td>
		</TR>
	<input type="hidden" name="p_module_id" id="p_module_id" value="OR">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id" value="ORRPATOR">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=localeName%>">
	</FORM>
</BODY>
</HTML>

<%
	putObjectInBean(bean_id,bean,request);

%>

