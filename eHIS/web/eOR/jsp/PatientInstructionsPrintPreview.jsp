<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%
/*
---------------------------------------------------------------------------------------------------------------
Date			Edit History	Name        Description
---------------------------------------------------------------------------------------------------------------
?				100         	?     		created	 
15/11/2012		IN030472		Ramesh G	Bru-HIMS-CRF-031[Patient instructions to be printed on demand] 		
27/11/2012		IN036353		Ramesh G	Patient Instructions->Print Preview->The Text Format is lost 	
06/11/2012		IN036530		Ramesh G	Patient Instruction Print->System is not displaying the complete text of the Patient Instruction in the Print.	
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date	Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
12/08/2014		IN049419		Karthi L									An Audit Trail for Additional Information Amendment of Order
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 	
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <jsp:useBean id="bean" scope="page" class="eOR.ExistingOrder"/>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>
	<!-- IN036530 Start.-->
	<STYLE>	
	PRE
		{
			font-size: 8pt ;
			Font-Family : Courier New;
			BACKGROUND-COLOR: #E2E3F0;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			WORD-WRAP: break-word;
			overflow-y: hidden;
			overflow-x: hidden;
		}	
	</STYLE>
	<!-- IN036530 End.-->
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
try
{
	
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
	String orderLineNum =  request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
	String ord_cat_code = request.getParameter("val1")==null?"":request.getParameter("val1");
	String ord_typ_code = request.getParameter("ord_typ_code");
	ord_typ_code = (ord_typ_code == null) ? "":ord_typ_code;	
	String viewBy	  = request.getParameter("viewBy");
	viewBy			  = (viewBy == null) ? "nothing":viewBy;
	String l_instrn_type =  request.getParameter("instrn_type")==null?"T":request.getParameter("instrn_type");//IN64543
	
	String[] allValues = new String[39];

	String perform_loc_desc = "";
	String location="";
	String patient_details="";


	bean.setLanguageId(localeName);

	String view_bean_id = "Or_ViewOrder" ;
	String view_bean_name = "eOR.ViewOrder";
	ViewOrder view_bean		= (ViewOrder)getBeanObject( view_bean_id, view_bean_name, request ) ;
	view_bean.setLanguageId(localeName);

	Properties properties			= (Properties) session.getValue( "jdbc" );
	String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");	
	//IN049419 - Start
	String audit_reqd_yn = bean.getOrderFormatAuditTrailYN();
	String max_seq = request.getParameter("max_seq")==null?"0":request.getParameter("max_seq") ;	
	String field_mnemonic = "PATIENT_INSTRNS";
	String curr_sequ_num = request.getParameter("curr_sequ_num")==null?"":request.getParameter("curr_sequ_num");
	String base_max_sequ_num = "0";
	String modified_max_sequ = "";
	int modified_max_sequ_num = 0;
	int curr_mod_sequ_num = 0;
	HashMap orderLineMap = null;
	
	/*if("".equals(curr_sequ_num)) {
		curr_sequ_num = max_seq;
	}*/
	
	String instruction = "";
	
	if(audit_reqd_yn.equalsIgnoreCase("Y")){
		
		base_max_sequ_num = view_bean.getOrderLineInstMaxCount(orderId, orderLineNum, field_mnemonic);
		
		modified_max_sequ_num = Integer.parseInt(base_max_sequ_num);
		modified_max_sequ_num = modified_max_sequ_num + 1;
		modified_max_sequ = Integer.toString(modified_max_sequ_num);
		if(curr_sequ_num.equals("") || modified_max_sequ.equals(curr_sequ_num) ) {
			instruction =bean.getPatientInstruction(orderId,orderLineNum) ;
		} else {
			if(curr_sequ_num != null && curr_sequ_num != ""){
				orderLineMap = view_bean.getOrderLineInstructions(orderId, orderLineNum, curr_sequ_num, field_mnemonic, localeName);	
				if(orderLineMap != null){
					instruction = (String)orderLineMap.get("ORDER_LINE_FIELD_VALUE");
				}
			}
		}	
	} else {
		instruction =bean.getPatientInstruction(orderId,orderLineNum) ;
	}
	//IN049419 - End
	//String instruction =bean.getPatientInstruction(orderId,orderLineNum) ; commented for IN049419
	String catalogName = bean.getOrderCatalogName(orderId,orderLineNum);
	allValues		= bean.viewMainDetails(properties, orderId);
	if(allValues[2] == null  || allValues[2].equals("null") || allValues[2].equals("") )
	{
		allValues[2]="R";
	}
	if(allValues[2].compareTo("R")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");					
	}
	else if(allValues[2].compareTo("U")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
	}
	else if(allValues[2].compareTo("S")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
	}	

	String sex1="";
				
	if (allValues[3].equalsIgnoreCase("M"))
		sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(allValues[3].equalsIgnoreCase("F"))
		sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

	if(allValues[36].equalsIgnoreCase("C"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("N")||allValues[36].equalsIgnoreCase("W"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("R"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("E"))
	{
		location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
	}
	patient_details=allValues[6]+","+sex1+"/"+allValues[34]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+allValues[35];
		

	if (allValues.length > 19) 
	{
	   if (allValues[15] == null) allValues[15] = "";
	   if (allValues[18] == null) allValues[18] = "";
	   if(!allValues[18].equals(""))
		{
			perform_loc_desc = bean.checkForNull(bean.getPerformLocnDesc(properties, allValues[18].trim(),allValues[15].trim(),facility_id),"");
		}
	}

	// From the View Order get the clinical comments if it is there
	//String max_action_seq_num	= bean.checkForNull(view_bean.getMaxCount(orderId),"");
	String max_action_seq_num	= allValues[29];

 	String ca_pract_name		= "";

	if(allValues!=null && orderId!=null) 
	{
		//ca_pract_name		= bean.checkForNull(view_bean.getOrderPractitioner(orderId),"");
		ca_pract_name		= allValues[30];
	}
	if(ca_pract_name==null)	ca_pract_name = "";

%>
<form name="PatientInstructionsPrintPreviewForm" id="PatientInstructionsPrintPreviewForm">
<table cellpadding=2 cellspacing=0 border=0 width="730px" height='100%' >
<tr  height='25%'><td align="left">
<table cellpadding=0 cellspacing=0 border=0 width="730px" height='100%'>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=orderId%></B></td>
		<td  class='label'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[0]%></B></td>		
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/> </td>
		<td class='data'><B><%=allValues[1]%></B></td>
		<td  class='label'><fmt:message key="Common.priority.label" bundle="${common_labels}"/> </td>
		<td class='data'><B><%=allValues[2]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=patient_details%></B></td>
		<td  class='label'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=(allValues[4] == null) ? "" : allValues[4]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderDateTime.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=com.ehis.util.DateUtils.convertDate(allValues[12],"DMYHM","en",localeName)%></B></td> 
		<td  class='label'><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/> </td>
		<td class='data'><B><%=allValues[5]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=location%>/<%=allValues[38]%></B></td>
		<td  class='label'><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<%if (allValues[7]==null) allValues[7]="";%>	
		<td class='data'><B><%=allValues[7]%></B></td>
	</tr>
	<tr>
		<td  class='label'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[8]%></B></td>
		<td  class='label'><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td>
		<td class='data'><B><%=allValues[9]%></B></td>
	</tr>
<%
	if(allValues[10]==null) allValues[10] = "";
					
					/*String	date1="";	 
					String	date="";	
              int temp=allValues[10].indexOf("/");
				
				if(temp!=-1)
				{
				 date=allValues[10].substring(temp-2,temp+8);
				
				//System.err.println("temp"+temp+"date"+date);
				
				 if(date.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
				 {
					     if(date.indexOf(":")!=-1)
						{
						 date1 = com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",localeName);
						} 
						else
						{
							 date1 = com.ehis.util.DateUtils.convertDate(date,"DMY","en",localeName);
						}
				}
                    allValues[10]=allValues[10].replace(date,date1);
				}*/
				
		String	converted_date="";	 
		String	format_date="";
		int date_part=allValues[10].indexOf("/");
		if(date_part!=-1)
		{
			if((date_part+14)<=allValues[10].length()&&(allValues[10].substring(date_part-2,date_part+14).matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}")))
			{
				format_date=allValues[10].substring(date_part-2,date_part+14);
				if(com.ehis.util.DateUtils.validDate(format_date,"DMYHM",localeName))
				{
					 converted_date = com.ehis.util.DateUtils.convertDate(format_date,"DMYHM","en",localeName);
					 allValues[10]=allValues[10].replace(format_date,converted_date);
				} 
			}
			else if((date_part+8)<=allValues[10].length()&&(allValues[10].substring(date_part-2,date_part+8).matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}")))
			{
				format_date=allValues[10].substring(date_part-2,date_part+8);
				if(com.ehis.util.DateUtils.validDate(format_date,"DMY",localeName))
				{
						 converted_date = com.ehis.util.DateUtils.convertDate(format_date,"DMY","en",localeName);
						 allValues[10]=allValues[10].replace(format_date,converted_date);
				} 
			}
		}	            	 

	//else allValues[10] = java.net.URLEncoder.encode(allValues[10],"UTF-8");
%>
		<tr>
			<td class='label'><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></td>
			<td class='data'> <B><%=allValues[10]%></B></td>
			<td class='label'><fmt:message key="eOR.OrderCatalog.label" bundle="${or_labels}"/></td>
			<td class='data'><%=catalogName%> </td>
		</tr>
<% 
		if(ca_pract_name!=null && !ca_pract_name.equals("")) 
		{ 
%>
			<tr>
				<td  class='label'><fmt:message key="eOR.OrderPlacedBy.label" bundle="${or_labels}"/></td>
				<td class='data'><b><%=ca_pract_name%></b> </td>
				<td colspan=2></td>
			</tr>
<% 
		} 

		if (((perform_loc_desc != null) && (!perform_loc_desc.equals(""))) || (!allValues[20].equals(""))) 
		{
%>
		<tr>
<%		
			if ((perform_loc_desc != null) && (!perform_loc_desc.equals(""))) 
			{				
%>
				<td class='label'><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td>
				<td class='data'><B><%=perform_loc_desc%></B></td>
<%
			} 
		
			if (!allValues[20].equals("")) 
			{
%>
				 <td class='label' ><a class='gridLink' href='javascript:viewExternalDetails("<%=bean.getFacilityName(properties, allValues[20])%>","<%=allValues[21]%>","<%=bean.getPractitionerName(properties, allValues[22])%>","<%=allValues[24]%>","<%=allValues[25]%>","<%=allValues[26]%>","<%=bean.getPractitionerName(properties,allValues[27])%>","<%=orderId%>","<%=bean_id%>","<%=bean_name%>")'><fmt:message key="eOR.ExternalDtls.label" bundle="${or_labels}"/></a></td>
<%
			} 
%>
				<td colspan='3'></td>
			</tr>
<%
		}
%>
		<tr>		
			<td colspan='4' class='data'>&nbsp;</td>
		</tr>
		</table>
</td></tr>
<tr  height='75%'><td>
		<table cellpadding=0 cellspacing=0 border=0 width="730px" height='100%' >
		<tr height="5%">		
			<td class='data' valign="top"><B><U>Patient Instructions :</U></B></td>
		</tr>
		<tr height="95%">		
			<td valign="top">
			<%
			if("T".equals(l_instrn_type))//IN64543
			{
			%>
				<PRE style="word-wrap:break-word;width:730px;"><%=instruction%></PRE>
			<%
			}
			else if("E".equals(l_instrn_type))//IN64543, starts			
			{
			%>			
			<%=instruction%>
			<%
			}//IN64543, ends
			%>
			</td>
		</tr>
		</table>
		
		<Input type='hidden'name='ordering_facility_id' value='<%=allValues[13]%>'>	
		<Input type='hidden'name='iv_prep_yn' value='<%=(allValues[14] == null)?"":allValues[14]%>'>
		<Input type='hidden' name='order_category' id='order_category' value='<%=allValues[15]%>'>
		<Input type='hidden' name='ord_typ_code' id='ord_typ_code' value='<%=ord_typ_code%>'>
		<Input type='hidden' name='ord_cat_code' id='ord_cat_code' value='<%=ord_cat_code%>'>
		<Input type='hidden' name='orderId' id='orderId' value='<%=orderId%>'>
		<Input type='hidden' name='order_date_time' id='order_date_time' value='<%=allValues[12]%>'>
		<Input type='hidden' name='encounter_id' id='encounter_id' value='<%=allValues[4]%>'>
		</form>
</body>

</html>

<%
}
catch(Exception e)
{
	e.printStackTrace();
}
	//putObjectInBean(bean_id,bean,request);
	//putObjectInBean(view_bean_id,view_bean,request);
%>

