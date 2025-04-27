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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
08/05/2013		IN042115		Nijitha			CRF-Bru-HIMS-CRF-282-33207/01  CA>Orders>Existing Orders>Performing location is not displayed for the re-routed prescription 
												changed and more appealing. Keeping the display of information more clearand visible.   								 
23/10/2013		IN044520		Karthi			Clinical comments is displayed by deleting previous entered data while amend Order at Clinical comments.
08/01/2014	  	IN044757		 	Vijayakumar K	Clinical comments displayed as hyper link at result-Completed stage, even though clinical
												comments  not recorded while placing the order.
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order
2/9/2014	IN050777		Nijitha S										In Existing order  "View  Pharmacy order"Performing facility displayed as "null" when re-routed to external Facility
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 	
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.* " %>
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
 	<script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
try
{
	//String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
	String ord_cat_code = request.getParameter("val1")==null?"":request.getParameter("val1");
	String ord_typ_code = request.getParameter("ord_typ_code");
	ord_typ_code = (ord_typ_code == null) ? "":ord_typ_code;
	String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");	
	String viewBy	  = request.getParameter("viewBy");
	viewBy			  = (viewBy == null) ? "nothing":viewBy;
	String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");//IN061961
	String order_catalog_code = request.getParameter("catalog_code")==null?"":request.getParameter("catalog_code");//IN061961
	String view_by = request.getParameter("view_by")==null?"":request.getParameter("view_by");//IN061961
	//function_from = (function_from == null) ? "":function_from;
	//String[] allValues = new String[39];//IN042115
	//String[] allValues = new String[40];//IN042115
	String[] allValues = new String[41];//IN043143

	String perform_loc_desc = "";
	String location="";
	String patient_details="";

	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	// ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	String  orderFormatAuditTrailYN= bean.getOrderFormatAuditTrailYN();  //IN049419
	bean.setLanguageId(localeName);

	String view_bean_id = "Or_ViewOrder" ;
	String view_bean_name = "eOR.ViewOrder";
	//ViewOrder view_bean = (ViewOrder)mh.getBeanObject( view_bean_id, request,  view_bean_name ) ; 
	ViewOrder view_bean		= (ViewOrder)getBeanObject( view_bean_id, view_bean_name, request ) ;
	view_bean.setLanguageId(localeName);

	Properties properties			= (Properties) session.getValue( "jdbc" );
	//String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");//Commented for checkstyle IN061961	

	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 	//bean.clear() ;
	//bean.setMode( mode ) ;

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
			//perform_loc_desc = bean.checkForNull(bean.getPerformLocnDesc(properties, allValues[18].trim(),allValues[15].trim(),facility_id),"");//IN042115
		   perform_loc_desc = bean.checkForNull(bean.getPerformLocnDesc(properties, allValues[18].trim(),allValues[15].trim(),allValues[39]),"");//IN042115
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
<form name='view_order_top' id='view_order_top' target='messageFrame' ><!-- IN043143 -->
<table cellpadding=5 cellspacing=5 border=0 width="100%" height='100%' align=center>
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
		<%if (allValues[9]==null) allValues[9]="";%><!--IN050777-->
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
			<td  class='label'><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></td>
			<td class='data'> <a class="gridLink"  href="javascript:viewOrderFormat('<%=orderId%>')"><B><%=allValues[10]%></B></a> </td>
			<td  class='label'>
<% 
			if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0"))
			{	// added for IN044520 - Start --commented for IN044757 starts
				/*String comments =  view_bean.getComments(orderId,allValues[29]);
				comments = comments.trim();
				if(!comments.equals("")) {*/
%>
					<a class="gridLink" href="javascript:viewHeaderComments1('<%=orderId%>','<%=allValues[29]%>')"><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a>
<%
				/*}
				else 
				{ 
					out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"");
				}*/
				// IN044520 - End IN044757 end
			} 
			else 
			{ 
				out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ClinicalComments.label","common_labels")+"");
			} 
%>
			</td>
			<td>
<%
			if(allValues[16]!=null) 
			{ 
%>
				<a class="gridLink" href="javascript:viewInstructionMode('<%=allValues[16]%>')"><fmt:message key="eOR.InstructionMode.label" bundle="${or_labels}"/></a>
<%  
			}
%>		
			</td>
		</tr>
<% 
		if(ca_pract_name!=null && !ca_pract_name.equals("")) 
		{ 
%>
			<tr>
				<td  class='label'><fmt:message key="eOR.OrderPlacedBy.label" bundle="${or_labels}"/></td>
				<td class='data'><b><%=ca_pract_name%></b> </td>
				<% if(allValues[15].equals("LB")){ //7632 %>
				<TD class='label'><fmt:message key="eOR.SpecimenNo.label" bundle="${or_labels}"/></TD>
			<td class='data'><B><%=(allValues[41]== null)? "" :allValues[41]%></B></td>
			<%}else{%>
			<td colspan=2></td>
			<%}%>
			</tr>
<% 
		} 

		if (((perform_loc_desc != null) && (!perform_loc_desc.equals(""))) || (!allValues[20].equals(""))) 
		{
%>
		<tr>
<%
		//int flag = 0;
			if ((perform_loc_desc != null) && (!perform_loc_desc.equals(""))) 
			{
				//flag = 1;
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
		</table>
		<Input type='hidden'name='ordering_facility_id' id='ordering_facility_id' value='<%=allValues[13]%>'>		 
		<Input type='hidden' name='function_from' id='function_from' value='<%=function_from%>'>
		<Input type='hidden'name='iv_prep_yn' id='iv_prep_yn' value='<%=(allValues[14] == null)?"":allValues[14]%>'>
		<Input type='hidden' name='order_category' id='order_category' value='<%=allValues[15]%>'>
		<Input type='hidden' name='ord_typ_code' id='ord_typ_code' value='<%=ord_typ_code%>'>
		<Input type='hidden' name='ord_cat_code' id='ord_cat_code' value='<%=ord_cat_code%>'>
		<Input type='hidden' name='orderId' id='orderId' value='<%=orderId%>'>
		<Input type='hidden' name='order_date_time' id='order_date_time' value='<%=allValues[12]%>'>
		<Input type='hidden' name='order_status' id='order_status' value='<%=allValues[40]%>'><!-- IN043143 -->
		<Input type='hidden' name='orderFormatAuditTrailYN' id='orderFormatAuditTrailYN' value='<%=orderFormatAuditTrailYN%>'> <!--  IN049419 -->
		<Input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'><!--IN061961 -->
		<Input type='hidden' name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'><!--IN061961 -->
		<Input type='hidden' name='view_by' id='view_by' value='<%=view_by%>'><!--IN061961 -->
</form>	<!-- IN043143 -->
</body>
<script>
	var function_from 	= document.getElementById("function_from").value;

	if (function_from 	== "View") 
	{
		var qrystring 	=  "&ord_facility_id="+document.getElementById("ordering_facility_id").value+"&iv_prep_yn="+document.getElementById("iv_prep_yn").value;
		qrystring		+= "&ord_cat="+document.getElementById("order_category").value;
		qrystring		+= "&ord_cat_code="+document.getElementById("ord_cat_code").value;
		qrystring		+= "&order_line_num="+document.getElementById("order_line_num").value;//IN061961
		qrystring		+= "&order_catalog_code="+document.getElementById("order_catalog_code").value;//IN061961
		qrystring		+= "&view_by="+document.getElementById("view_by").value;//IN061961
		parent.ViewOrderDtl.location.href="ViewOrderDetail.jsp?<%=request.getQueryString()%>"+qrystring;
	} 
	else if (function_from == "Complete") 
	{
		var qrystring 	=  "&ord_facility_id="+document.getElementById("ordering_facility_id").value+"&iv_prep_yn="+document.getElementById("iv_prep_yn").value;
		qrystring		+= "&ord_cat="+document.getElementById("order_category").value+"&order_date_time="+document.getElementById("order_date_time").value;
		parent.CompleteOrderDtl.location.href="CompleteOrderDetail.jsp?<%=request.getQueryString()%>"+qrystring;
		 
	} 
	else if (function_from == "Replace") 
	{
		
		var qrystring 	=  "&ord_facility_id="+document.getElementById("ordering_facility_id").value+"&iv_prep_yn="+document.getElementById("iv_prep_yn").value;
		qrystring		+= "&ord_cat="+document.getElementById("order_category").value+"&orderId="+document.getElementById("orderId").value;
		parent.CompleteOrderDtl.location.href="ReplaceAddOrderableDetail.jsp?<%=request.getQueryString()%>"+qrystring;
	}
	else if (function_from == "ChargeType")
	{
	
		var qrystring 	=  "&ord_facility_id="+document.getElementById("ordering_facility_id").value+"&iv_prep_yn="+document.getElementById("iv_prep_yn").value;
		qrystring		+= "&ord_cat="+document.getElementById("order_category").value+"&orderId="+document.getElementById("orderId").value;
		parent.CompleteOrderDtl.location.href="ChangeChargeTypeDetail.jsp?<%=request.getQueryString()%>"+qrystring;
	}
	else if (function_from == "Cancel")
	{
		var qrystring 	=  "&ord_facility_id="+document.getElementById("ordering_facility_id").value+"&iv_prep_yn="+document.getElementById("iv_prep_yn").value;
		qrystring		+= "&ord_cat="+document.getElementById("order_category").value+"&ord_typ_code="+document.getElementById("ord_typ_code").value;
		parent.CancelOrderDtl.location.href="CancelOrderDetail.jsp?<%=request.getQueryString()%>"+qrystring;
	}
</script>
<%
	if(viewBy.equals("line"))
	{
%>
		<script>
			parent.multi_detail.location.href = "../../eOR/jsp/ExistingOrderMultipleConsentForms.jsp?<%=request.getQueryString()%>";
		</script>
<%
	}
	else if(viewBy.equals("header"))
	{
%>
		<script>
			parent.multi_detail.location.href = "../../eOR/jsp/ExistingOrderMultipleConsentHdrForms.jsp?<%=request.getQueryString()%>";
		</script>
<%
	}
%>
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

