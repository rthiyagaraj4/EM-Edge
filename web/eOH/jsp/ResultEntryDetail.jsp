<!DOCTYPE html>
<%-- JSP Page specific attributes start --%> 
<%@page contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*,eOH.* ,eOH.Common.*" %>
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
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css'/>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../js/ResultEntry.js"></script>

 	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCA/js/CAOpenExternalApplication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onScroll="processScroll()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload='checkOnBodyLoad()'>
<form name=result_entry_dtl>

<%
	
	/* Mandatory checks start */
	String disab="";
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Oh_ResultEntry" ;
	String bean_name = "eOH.ResultEntryBean";
	//String task_type=request.getParameter("task_type");
	String orderId = request.getParameter("orderId");
	String order_line_num = request.getParameter("order_line_num");
	if (order_line_num == null) 
	order_line_num = "";
	
	String order_type_code = "";
	String patient_class = "";
	String requestFrom = request.getParameter("requestFrom");	
	String reportSrlNo = request.getParameter("report_srl_no");
	String child_order_index = request.getParameter("child_order_index");
	String child_reporting_date = request.getParameter("child_reporting_date");
	String patient_id = request.getParameter("patient_id");	
	String pat_class = request.getParameter("patient_class");
	String encounter_id = request.getParameter("encounter_id");
	String order_category=request.getParameter("order_category");	
	String from=request.getParameter("from");
	if (from == null) 
	from = "";
	//String resultReportingURL = request.getQueryString();
	// String freqExplApplies = request.getParameter("freqExplApplies");
	//String pract_idfrom_db=request.getParameter("pract_idfrom_db");
	String parent_order_id=request.getParameter("parent_order_id")==null?"":request.getParameter("parent_order_id");
	String current_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName);
	String func_type	= request.getParameter("func_type");
	if (func_type == null) func_type = "";
	int total_auth_imgs = 0;

	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id,bean_name ,request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	//bean.setFunc_type(func_type);	
	//bean.setRequestResponse(request,response);

	if(child_order_index==null)
	{
		child_order_index =    request.getParameter("TLchild_order_index")==null?"":request.getParameter("TLchild_order_index");    
		child_reporting_date = request.getParameter("TLchild_reporting_date")==null?current_date:request.getParameter("TLchild_reporting_date"); 
		child_order_index="";
	}
	if(child_reporting_date==null || child_reporting_date.equals(null) || child_reporting_date.equals("")){
		child_reporting_date=current_date;
	}

	if(requestFrom==null)	requestFrom="";
	if(reportSrlNo==null)
	{
		String[] resportsrlno = bean.getReportSrlNo(orderId);
		reportSrlNo = resportsrlno[0];
		if(resportsrlno[1].equals("3") && !requestFrom.trim().equalsIgnoreCase("FE"))
		{
			int temp = Integer.parseInt(reportSrlNo);
			temp++;
			reportSrlNo = Integer.toString(temp);
	
		}
	}

	allValues = bean.getSearchDetails(orderId, reportSrlNo);
	bean.CultureTestRecordSync(orderId, reportSrlNo);
	String slClassValue = "";
	String proc_link_applicable				= "";
	String reporting_date					= "";
	String proc_link_resulting_option       = "";
//	String chart_result_type		= "";
//	String chart_result_type_desc	= "";
//	String procedure_code			= "";
	//Gives the result status
	String[] headerDetails = new String[5];
	headerDetails = bean.getHeaderLineDetails(orderId, reportSrlNo);
	String readonly = "";	// for making the elements readonly if reports result_status is 3 (completed)
	String disabled = "";	// for making the elements readonly if reports result_status is 3 (completed)
//	String readonly2 = "";	// for making result_status and type readonly if the request comes from Report Authorization.
	String disabled2 = "";	// for making result_status and type readonly if the request comes from Report Authorization.

	if(requestFrom.trim().equalsIgnoreCase("RA"))
	{	// Since the request is comming from Report Authorization so only this rule will apply and no other readonly rule will apply.
//		readonly2 = "readonly";
		disabled2 = "disabled";
	}
	else if(headerDetails[1].equals("3"))
	{	// Reports result status is completed so make all the elements readonly
		readonly = "readonly";
		disabled = "disabled";
	}
	if(requestFrom.trim().equalsIgnoreCase("RA"))
		mode = "2";
	else
		mode = bean.returnMode(orderId,reportSrlNo);
%>
<div id="divHeadSep" style="position: absolute;">
<table cellpadding=3 cellspacing=0 border=1 width="100%" height="" id="tableresult" class="grid">
<tr id="heading">
		<td class=columnheader width='' nowrap><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Result.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.LowValue.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.HighValue.label" bundle="${common_labels}"/></td>
		<td class=columnheadercenter width='' nowrap colspan="2"><fmt:message key="Common.EventStatus.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
</tr>
<%
	boolean showedGroup = false;
	int groupItem = 0;
	String strPanels = null;
	String order_set_bill_yn="";
	String order_set_id="";
	String default_value = "";
    int flag[] = new int[allValues.size()];
	
	for(int i=0; i<allValues.size(); i++){
		String[] record = new String[36];
		record = (String [])allValues.get(i);
		
		if(!(order_line_num.equals("")) && from.equals("OHResultEntry"))
		{
			if(record[33].equals(order_line_num))
				disab = "";
			else
				disab = "disabled";
		}
		String msr_id = "";
		msr_id = record[3];
		
		slClassValue="gridData";
		String readonly1 = "";	// for making the elements readonly if elements result_status is 3 (completed)
		String disabled1 = "";	// for making the elements readonly if elements result_status is 3 (completed)
		if(record[0] == null) record[0] = "";
		if(record[1] == null) record[1] = "";
		if(record[2] == null) record[2] = "";
		if(record[3] == null) record[3] = "";
		if(record[4] == null) record[4] = "";
		if(record[5] == null) record[5] = "20";
		if(record[6] == null) record[6] = "";
		if(record[7] == null) record[7] = "";
		if(record[8] == null) record[8] = "";
		if(record[9] == null) record[9] = "";
		if(record[10] == null) record[10] = "";
		if(record[14] != null) order_type_code = record[14];
		if(record[15] == null) record[15] = "";
		if(record[16] == null) record[16] = "";
		if(record[17] == null) record[17] = "";
		if(record[18] == null) record[18] = "1";
		if(record[19] == null) record[19] = "";
		if(record[20] == null) record[20] = "";
		if(record[21] == null) record[21] = "";
		if(record[22] == null) record[22] = "";
		if(record[23] == null) record[23] = "";
		if(record[24] == null) record[24] = "";
		if(record[25] == null) record[25] = "";
		if(record[26] == null) record[26] = "";
		reporting_date = record[26];
		if(record[27] == null) record[27] = "";
		if(record[28] == null) record[28] = "";
		if(record[29] == null) record[29] = "";
		if(record[30] == null) record[30] = "";
		if(record[31] == null) record[31] = "";
		if(record[32] == null) record[32] = "N";
		if(record[33] == null) record[33] = "";
		if(record[34] == null) record[34] = "";
		if(record[35] == null) record[35] = "";
		order_set_id=(String)record[35];
		order_set_bill_yn=(String)bean.getOrderSetDetails(record[35]);
		if((!record[22].equals("")) && (!record[22].equals("X")) && (!record[22].equals("P")) && (!record[22].equals("C"))) 
		{
			proc_link_applicable		= record[22];
		}
		if((!record[23].equals("")) && (!record[23].equals("O")))
		{
			proc_link_resulting_option	= record[23];
		}
		if(proc_link_applicable==null) proc_link_applicable="";
		if(proc_link_resulting_option==null) proc_link_resulting_option="";

//		String [] chartRecord		= bean.getProcedureCode(orderId,record[12].trim());
//		chart_result_type			= bean.checkForNull(chartRecord[0],"");
//		chart_result_type_desc		= bean.checkForNull(chartRecord[1],"");
//		procedure_code				= bean.checkForNull(chartRecord[2],"");

		if(record[18].equals("3") && !requestFrom.trim().equalsIgnoreCase("RA"))
		{
			readonly1 = "readonly";
			disabled1 = "disabled";
		}%>
        <%--<Script>alert('record[18]=<%=record[18]%>,headerDetails[1]=<%=headerDetails[1]%>,requestFrom.trim()=<%=requestFrom.trim()%>,record[19]=<%=record[19]%>,record[4]=<%=record[4]%>')</Script>--%>
		
		<%
		
		String temp_img=bean.getValueForImg(((String)session.getValue("facility_id")),orderId,record[13].trim());
		String histrectype=""; 
		if (order_category.equals("TR"))
			histrectype="TRET";
		else if(order_category.equals("NC"))
			histrectype="NCIN";
		else if(order_category.equals("PC"))
			histrectype="PTCR";
		else if(order_category.equals("RX"))
			histrectype="RXIN";
		else if(order_category.equals("RD"))
			histrectype="RDIN";
		else if(order_category.equals("LB"))
			histrectype="LBIN";
	
		if(record[0].equals("Z")) {//i:e it is Panel
			groupItem++; //No of Child items for that panel

		showedGroup = false;
		if (strPanels == null) {
        	strPanels = record[1];
        } else {
        	java.util.StringTokenizer stoken = new StringTokenizer(strPanels,",");
        	while (stoken.hasMoreTokens()) {
        		if ((stoken.nextToken()).equals(record[1])) {
        			showedGroup = true;
        			break;
        		}
        	}
        	strPanels = strPanels + "," + record[1];
        }

		//Show the Group Record
		if(!showedGroup){
	 			showedGroup=true;
	 			flag[i] = 1;
		%>

		<!-- To Show the  Group Record for the Panel  Records-->
		
		<tr>
			<!-- Event -->
			<td width='' nowrap class='<%=slClassValue%>'><font size=1><%=record[2]%>
				<%if(record[11].equalsIgnoreCase("Y")){
					if(record[32].equalsIgnoreCase("N")){
				%>		<img src="../images/Authorization.gif" id='id_auth_img_<%=total_auth_imgs%>'>
				<%		total_auth_imgs++;
					}else if(record[32].equalsIgnoreCase("Y")){%>
						<img src="../images/Authorized.gif" id='id_auth_img_<%=total_auth_imgs%>'>
				<%  }
				}
				if (!temp_img.equals("null") && disab.equals("")){%>

					<a class='gridLink' href='#' onClick="getFile('<%=histrectype%>','OR','<%=record[28]%>','<%=record[3]%>','<%=temp_img%>','<%=patient_id%>','<%=record[29]%>','<%=record[8]%>')"><img src="../../eCA/images/<%=temp_img%>.gif" width='16' height='16' border=0 alt='<%=temp_img%>'></a>
					
					<%}%>
			</font>
			</td>

			<!-- Result -->
			<td width='' nowrap class='<%=slClassValue%>'><font size=1>&nbsp;</font></td>

			 <!-- Unit -->
			<td width='' nowrap class='<%=slClassValue%>'><font size=1>&nbsp;</font></td>

			<!-- Low Value -->
			<td width='' nowrap class='<%=slClassValue%>' ><font size=1>&nbsp;</font></td>

			<!-- High Value -->
			<td width='' nowrap class='<%=slClassValue%>' ><font size=1>&nbsp;</font></td>

			<!-- Event  Status -->
			<td width='' nowrap class='<%=slClassValue%>'>
				<select name='result_status<%=i%>' id='result_status<%=i%>' onchange='checkStatusChange()' <%=disabled%> <%=disabled1%> <%=disabled2%> <%=disab%>>
				<%if(record[18].trim().equals("1"))
					out.println("<option value='1' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels")+" </option>");
					else out.println("<option value='1'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels")+"</option>");
				  if(record[18].trim().equals("2"))
					out.println("<option value='2' selected >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
					else out.println("<option value='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
				  if(record[18].trim().equals("3"))
					out.println("<option value='3' selected style='background-color:#008000'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")+"</option>");
					else out.println("<option value='3' style='background-color:#008000'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")+"</option>");
				%>
				</select>
					
			</td>

			<td width='' nowrap class='<%=slClassValue%>'><font size=1 >&nbsp;</font></td>

			<td width='' nowrap class='<%=slClassValue%>'><font size=1>&nbsp;</font></td>

		</tr>
	<%}//End Show the Group Record for the  Panel%>

		<!-- Show the Events Desc under the  panels(Z) -->
			<tr>
			<!-- Events -->
				 <td width='' nowrap class="<%=slClassValue%>"><font size=1><%=record[8].trim().equals("")?"&nbsp;":record[8].trim()%></font></td>

	<%}else{
			showedGroup=false;
			groupItem=0;
			//msr_id = record[1];
		%>

		<!-- Show the Events Desc under the  panels (Not Z) -->
			<tr>
			<!-- Event -->
			<td width='' nowrap class="<%=slClassValue%>" rowspan='2'><font size=1><%=record[2].equals("")?"&nbsp;":record[2]%>
			<%if(record[11].equalsIgnoreCase("Y")){
				if(record[32].equalsIgnoreCase("N")){	
			%>		<img src="../images/Authorization.gif" id='id_auth_img_<%=total_auth_imgs%>'>
				<input type='hidden' name='hidden_auth_reqd_yn<%=i%>' id='hidden_auth_reqd_yn<%=i%>' value='N'>
			<%
					total_auth_imgs++;
				}else if(record[32].equalsIgnoreCase("Y")){%>
					<img src="../images/Authorized.gif" id='id_auth_img_<%=total_auth_imgs%>'>
					<input type='hidden' name='hidden_auth_reqd_yn<%=i%>' id='hidden_auth_reqd_yn<%=i%>' value='Y'>
			<% }
			}
			if (!temp_img.equals("null") && disab.equals("")){%>

					<a class='gridLink' href='#' onClick="getFile('<%=histrectype%>','OR','<%=record[28]%>','<%=record[3]%>','<%=temp_img%>','<%=patient_id%>','<%=record[29]%>','<%=record[8]%>')"><img src="../../eCA/images/<%=temp_img%>.gif" width='16' height='16' border=0 alt='<%=temp_img%>'></a>
					
			<%}%>
			</font></td>
		<%}%>


		<!-- Record Showing Different <td> both for panel(z ant not Z)
		except Record for Group where Panel is Z-->


		<!-- Result Type("Numeric,List..etc") -->
		<td width='' nowrap class="<%=slClassValue%>"><font size=1>
				<input type='hidden' name='rslt_type_<%=i%>' id='rslt_type_<%=i%>' value='<%=record[4]%>'>
			<%

				//Numeric
				if(record[4].equals("N") || record[4].trim().equalsIgnoreCase("I")){

					int maxlength = 1;
					if(record[5]==null || record[5].trim().equals(""))
						record[5] = "20";
					if(record[7].equals("") || record[7].equals("0")) {
						maxlength = Integer.parseInt(record[5]);
						record[7] = "0";
					} else {
						maxlength = Integer.parseInt(record[5]) + 1;
										
					}
					
					//out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[15].trim()+"' onKeyPress='return OrAllowDecimalNumber()' size='5' class='NUMBER' onblur='checkNumericResult("+i+")' maxlength='"+maxlength+"' "+readonly+" "+readonly1+">");
					//out.println("<script>alert('record[5]="+record[5]+",record[7]="+record[7]+"')</script>");
					//out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[15].trim()+"' onKeyPress=\"return allowValidNumber(this,window.event,"+record[5]+","+record[7]+")\" size='5' class='NUMBER' onblur='checkNumericResult("+i+")' maxlength='"+maxlength+"' "+readonly+" "+readonly1+">");
					if((record[4].trim().equalsIgnoreCase("I"))||(record[4].trim().equalsIgnoreCase("N")))
					{
						String[] dft_value = new String[6];
						dft_value = bean.getNumericResultTypeDetails(msr_id);
						default_value = bean.checkForNull(dft_value[5]);
					}
					if(record[4].trim().equalsIgnoreCase("I"))
					{
						record[15] = bean.checkForNull(record[15]);			
						if(record[15].equals("")){record[15]=default_value;}
						out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[15].trim()+"' onKeyPress=\"return checkValid(this,window.event,"+record[5]+","+record[7]+")\" size='5' class='NUMBER' onblur='checkNumericResult("+i+");setPractitionerID("+i+");' maxlength='"+maxlength+"' "+readonly+" "+readonly1+" "+disab+">");
					}else if(record[4].trim().equalsIgnoreCase("N"))
					{
						record[15] = bean.checkForNull(record[15]);
						if(record[15].equals("")){record[15]=default_value;}
						out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[15].trim()+"' onKeyPress=\"return checkValid(this,window.event,"+record[5]+","+record[7]+")\" size='5' class='NUMBER' onblur='checkNumericResult("+i+");setPractitionerID("+i+");' maxlength='"+maxlength+"' "+readonly+" "+readonly1+" "+disab+">");
					}

				}else if(record[4].equals("L")){//List
					boolean notselected = true;
					ArrayList listItems = bean.getListResultTypeDetails(record[3]);
					out.println("<select name='result_"+i+"' id='result_"+i+"' onchange='onListChange("+i+");setPractitionerID("+i+");' "+disabled+" "+disabled1+" "+disab+">");
					out.println("<option>-- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --</option>");
					if(listItems!=null)
					for(int k=0; k<listItems.size(); k++)
					{
						String[] listValues = new String[4];
						listValues = (String[])listItems.get(k);
						if(record[16].trim().equalsIgnoreCase(listValues[0].trim()))
						{
							out.println("<option value='"+listValues[0]+"' selected>"+listValues[0]+"</option>");
							notselected = false;
						}
						else if(listValues[1]!=null && listValues[1].equalsIgnoreCase("Y") && notselected)
							out.println("<option value='"+listValues[0]+"' selected>"+listValues[0]+"</option>");
						else
							out.println("<option value='"+listValues[0]+"'>"+listValues[0]+"</option>");
					}
					out.println("</select>");

				}else if(record[4].equals("T")){ //Time
					out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[16]+"' onKeyPress=\"enterCheck()\" onblur=\"checkTime(this,' "+i+" ');setPractitionerID(' "+i+" ');\" ' size='5' maxlength='5' "+readonly+" "+readonly1+" "+disab+">");

				}else if(record[4].equals("F") && disab.equals("")) {//Hyper Link
		
					//out.println("<script>alert('"+(!(chart_result_type.equals("D") || chart_result_type.equals("P")))+","+record[4]+"')</script>");
					//if (!(chart_result_type.equals("D") || chart_result_type.equals("P") || chart_result_type.equals(""))) {
					//	out.println("<a href=\"javascript:viewCultureTest('"+record[10]+"','"+record[3]+"','"+record[8]+"','"+i+"', '"+readonly+" "+readonly1+"','"+orderId+"','"+reportSrlNo+"','"+chart_result_type+"','"+chart_result_type_desc+"')\">"+chart_result_type_desc+"</a>");
					//} else {
						//out.println("<script>alert('in')</script>");
						out.println("<a class='gridLink' href=\"javascript:viewResultTemplate('"+record[10]+"','"+record[3]+"','"+record[8]+"','"+i+"', '"+readonly+" "+readonly1+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Result.label","common_labels")+"</a>");
						
				
					//}
					out.println("<input type='hidden' name='result_"+i+"' id='result_"+i+"' value='"+record[17]+"'>");

				/*} else if(record[4].equals("K")) {//result_type --> K --> Template
  						out.println("<a href=\"javascript:viewTemplate('"+record[10]+"','"+record[3]+"','"+record[8]+"','"+i+"', '"+readonly+" "+readonly1+"','"+orderId+"','"+reportSrlNo+"','"+record[4]+"')\">Result</a>");
						out.println("<input type='hidden' name='result_"+i+"' id='result_"+i+"' value='"+record[17]+"'>");
				*/
				 
				}else if(record[4].equals("Q") && disab.equals("")) {//result_type --> Q --> Matrix Hyper Link
						out.println("<a class='gridLink' href=\"javascript:viewCultureTest('"+record[3]+"','"+record[3]+"','"+record[8]+"','"+i+"', '"+readonly+" "+readonly1+"','"+orderId+"','"+reportSrlNo+"','"+record[3]+"')\">"+record[8]+"</a>");
						out.println("<input type='hidden' name='result_"+i+"' id='result_"+i+"' value='"+record[17]+"'>");
				
				}else if(record[4].equals("C")) {//Check Box
					if(record[16].equalsIgnoreCase("Y"))
						out.println("<input type='checkbox' name='result_"+i+"' id='result_"+i+"' value='Y' checked onchange=\"javascript:onCheckBoxResultChange('"+i+"');setPractitionerID('"+i+"');\" "+disabled+" "+disabled1+" "+disab+">");
					else out.println("<input type='checkbox' name='result_"+i+"' id='result_"+i+"' value='Y' onclick=\"javascript:onCheckBoxResultChange('"+i+"');setPractitionerID('"+i+"');\""+disabled+" "+disabled1+" "+disab+">");

				}else if(record[4].equals("E")){//Text Date-time
					out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[16]+"' onKeyPress=\"enterCheck()\" onblur=\"checkreDateTime(this,'"+i+"');setPractitionerID('"+i+"');\" size='9' maxlength='16' "+readonly+" "+readonly1+" "+disab+">");

				}else if(record[4].equals("D")){ //Text Date
					out.println("<input type='text' name='result_"+i+"' id='result_"+i+"' value='"+record[16]+"' onKeyPress=\"enterCheck()\" onblur=\"checkDate(this,'"+i+"');setPractitionerID('"+i+"');\" size='9' maxlength='10' "+readonly+" "+readonly1+" "+disab+">");
				}else if(record[4].equals("X") && disab.equals("")) {//result_type --> X --> Clinical Notes Hyper Link
						out.println("<a class='gridLink' id='note_hyper"+i+"' href=\"javascript:callClinicalNotes('"+record[3]+"','"+patient_id+"','"+pat_class+"','"+encounter_id+"','"+orderId+"','"+i+"','"+record[27]+"','"+response.encodeURL("../../eCA/jsp/RecClinicalNotesModal.jsp")+"')\">"+record[8]+"</a>");
						
				}else if(record[4].equals("*")) 
				{//result_type --> * --> Charting Hyper Link
					
  						out.println("<a class='gridLink' id='chart_hyper"+i+"' href=\"javascript:callCharting('"+record[3]+"','"+patient_id+"','"+pat_class+"','"+encounter_id+"','"+orderId+"','"+i+"','"+record[27]+"','"+record[33]+"','"+record[34]+"','"+response.encodeURL("../../eCA/jsp/ChartRecording.jsp")+"')\">"+record[8]+"</a>");
				}

			if(record[9].equalsIgnoreCase("Y")){%>
				<img src="../../eCommon/images/mandatory.gif">
				<input type='hidden' name='mandatory_<%=i%>' id='mandatory_<%=i%>' value='Y'>
			<%}else{%>
				<input type='hidden' name='mandatory_<%=i%>' id='mandatory_<%=i%>' value='N'>
			<%}%>
			</font>
		</td>

		 <!-- If result type is Numeric Paint others <tds> Columns Acc.-->
		 <%if(record[4].trim().equalsIgnoreCase("N") || record[4].trim().equalsIgnoreCase("I")){
				String[] record1 = new String[6];
				record1 = bean.getNumericResultTypeDetails(msr_id);

				for(int j=0; j<record1.length; j++)
					if(record1[j]== null) record1[j]="";
					double max_val	= 0;
					double min_val	= 0;
					if (!record1[2].equals("")) max_val	= Double.parseDouble(record1[2]);
					if (!record1[1].equals("")) min_val	= Double.parseDouble(record1[1]);
					%>


			<td width='' nowrap class="<%=slClassValue%>"><font size=1><%=eHISFormatter.chkReturn(record1[0].trim(),"",
			 "&nbsp;",record1[0].trim())%></font></td>

			<td width='' nowrap class="<%=slClassValue%>"><font size=1>

			<%//if(record1[1].trim().equals("0") && record1[2].trim().equals("0"))
				if((max_val == 0.0) && (min_val == 0.0))
				out.print("&nbsp;");
			  else out.print(record1[1].trim());
			%>
			</font></td>

			<td width='' nowrap class="<%=slClassValue%>"><font size=1>
			<%//if(record1[1].trim().equals("0") && record1[2].trim().equals("0"))
				if((max_val == 0.0) && (min_val == 0.0))
				out.print("&nbsp;");
			  else out.print(record1[2].trim());
			%>
			 </font>
			</td>


			<td width='' nowrap class="<%=slClassValue%>">
				<input type='hidden' name='result_num_uom_<%=i%>' id='result_num_uom_<%=i%>' value='<%=record1[0].trim()%>'>
				<input type='hidden' name='num_crit_low_points_<%=i%>' id='num_crit_low_points_<%=i%>' value='<%=record1[1].trim()%>'>
				<input type='hidden' name='num_crit_high_points_<%=i%>' id='num_crit_high_points_<%=i%>' value='<%=record1[2].trim()%>'>
				<input type='hidden' name='num_crit_low_<%=i%>' id='num_crit_low_<%=i%>' value='<%=record1[3].trim()%>'>
				<input type='hidden' name='num_crit_high_<%=i%>' id='num_crit_high_<%=i%>' value='<%=record1[4].trim()%>'>

			<%}else{%>
			 <!-- If result type is Not Numeric Paint other Columns Acc.-->
			<td width='' nowrap class="<%=slClassValue%>"><font size=1>&nbsp;</font></td>
			<td width='' nowrap class="<%=slClassValue%>"><font size=1>&nbsp;</font></td>
			<td width='' nowrap class="<%=slClassValue%>"><font size=1>&nbsp;</font></td>
			<td width='' nowrap class="<%=slClassValue%>">
			<%}%>


			<%--<Script>alert('groupItem=<%=groupItem%>')</Script>--%>
				
			<%if(!showedGroup)//Records other than Panel equal to Z
			{
			%>
 				 <%--<Script>alert('1i=<%=i%>')</Script>--%>
				 <select name='result_status<%=i%>' id='result_status<%=i%>' onchange='checkStatusChange();setPractitionerID(<%=i%>);updateindex(<%=record[33]%>,this)' <%=disabled%> <%=disabled1%> <%=disabled2%> <%=disab%>>
				<%if(record[18].trim().equals("1"))
					out.println("<option value='1' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels")+"</option>");
				  else 
					  out.println("<option value='1'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels")+"</option>");
				  
				  if(record[18].trim().equals("2") && !record[27].equals("")){
					out.println("<option value='2' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
					out.println("<script>document.result_entry_dtl.result_status"+i+".disabled = true;</script>");
				  }else if(record[18].trim().equals("2")) 
					  out.println("<option value='2' selected >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
				  else out.println("<option value='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels")+"</option>");
				  
				  if(record[18].trim().equals("3"))
					out.println("<option value='3' selected style='background-color:#008000'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")+"</option>");
					else out.println("<option value='3' style='background-color:#008000'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")+"</option>");
				%>
				</select>

			<%}else if (flag[i] != 1) {//if(groupItem!=1)%>
					<input type='hidden' name='result_status<%=i%>' id='result_status<%=i%>' value='1'>
				
				
			<%}else{%>
				
			<%}%>
			<input type='hidden' name='forOT<%=record[33]%>' id='forOT<%=record[33]%>' value='<%=record[18]%>'>
			</td>

			<!-- Event Status-->
			<td width='' nowrap class="<%=slClassValue%>">
				<%
			 if(record[4].equals("N") || record[4].trim().equalsIgnoreCase("I")){
					
					out.println("<select disabled onChange='checkSrvStatusChange()' name=srv_stat_"+i+" "+disabled+" "+disabled1+" "+disab+">");
					out.println("<option value='' selected></option>");
					if(record[19].trim().equalsIgnoreCase("N"))
							out.println("<option value='N' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
					else	out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
					if(record[19].trim().equalsIgnoreCase("L"))
							out.println("<option value='L' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalLow.label","or_labels")+"</option>");
					else	out.println("<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalLow.label","or_labels")+"</option>");
					if(record[19].trim().equalsIgnoreCase("K"))
							out.println("<option value='K' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalLow.label","or_labels")+"</option>");
					else	out.println("<option value='K'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalLow.label","or_labels")+"</option>");
					if(record[19].trim().equalsIgnoreCase("H"))
							out.println("<option value='H' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalHigh.label","or_labels")+"</option>");
					else	out.println("<option value='H'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalHigh.label","or_labels")+"</option>");
					if(record[19].trim().equalsIgnoreCase("I"))
							out.println("<option value='I' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalHigh.label","or_labels")+"</option>");
					else	out.println("<option value='I'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalHigh.label","or_labels")+"</option>");
					if(record[19].trim().equalsIgnoreCase("A"))
							out.println("<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
					else	out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
					out.println("</select>");

			}else if(record[4].equals("L")){
					disabled = "";
					//disabled1 = "";
					out.println("<select  onChange='checkSrvStatusChange()' name=srv_stat_"+i+" "+disabled+" "+disabled1+" "+disab+">");
					if(record[19].trim().equalsIgnoreCase("N"))
							out.println("<option value='N' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
					else	out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
					if(record[19].trim().equalsIgnoreCase("A"))
							out.println("<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
					else	out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
					if(record[19].trim().equalsIgnoreCase("C"))
							out.println("<option value='C' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CriticallyAbnormal.label","common_labels")+"</option>");
					else	out.println("<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CriticallyAbnormal.label","common_labels")+"</option>");
					out.println("</select>");
			}else{
					disabled = "";
					//disabled1 = "";
					out.println("<select  onChange='checkSrvStatusChange()' name=srv_stat_"+i+" "+disabled+" "+disabled1+" "+disab+">");
					out.println("<option value=''>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels")+"</option>"); // selected
					if(record[19].trim().equalsIgnoreCase("N"))
							out.println("<option value='N'  selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
					else	out.println("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+"</option>");
					if(record[19].trim().equalsIgnoreCase("A"))
							out.println("<option value='A'  selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
					else	out.println("<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</option>");
					out.println("</select>");
			}%>
			</td>


			<!-- Cmts td -->
			<td width='' nowrap class="<%=slClassValue%>">
				<%String readonlyFlag = readonly+" "+readonly1;%>
				<font size=1>
				<%if(disab.equals("")){%>
				<a class='gridLink' href="javascript:viewOrderFormatLineCmts('<%=i%>', '<%=readonlyFlag%>')"><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></a>
				<%} else {%>
				<fmt:message key="Common.Comments.label" bundle="${common_labels}"/>
				<%}%>
				</font>
				<%String strResultComments 	= "";
					if (record[20] != null && !record[20].equals("")) {
						strResultComments	= record[20].replace('\"','\n');
					}%>
				<%--<input type='hidden' name='result_comments_<%=i%>' id='result_comments_<%=i%>' value='<%=record[20].trim()%>'>--%>
				<input type='hidden' name='result_comments_<%=i%>' id='result_comments_<%=i%>' value='<%=strResultComments%>'>
				<input type='hidden' name='num_digits_max_<%=i%>' id='num_digits_max_<%=i%>' value='<%=record[5].trim()%>'>
				<input type='hidden' name='num_digits_min_<%=i%>' id='num_digits_min_<%=i%>' value='<%=record[6].trim()%>'>
				<input type='hidden' name='num_digits_dec_<%=i%>' id='num_digits_dec_<%=i%>' value='<%=record[7].trim()%>'>
				<input type='hidden' name='auth_reqd_<%=i%>' id='auth_reqd_<%=i%>' value='N'>	<!-- hidden variable to be set when link clicked. -->
				<input type='hidden' name='auth_reqd_db_<%=i%>' id='auth_reqd_db_<%=i%>' value='<%=record[11].trim()%>'>
				<input type='hidden' name='line_srl_num_<%=i%>' id='line_srl_num_<%=i%>' value='<%=record[12].trim()%>'>
				<input type='hidden' name='parent_srl_no_<%=i%>' id='parent_srl_no_<%=i%>' value='<%=record[13].trim()%>'>
				<input type='hidden' name='msr_panel_id_<%=i%>' id='msr_panel_id_<%=i%>' value='<%=record[1].trim()%>'>
				<input type='hidden' name='msr_id_<%=i%>' id='msr_id_<%=i%>' value='<%=record[3].trim()%>'>
				<input type='hidden' name='order_catalog_code_<%=i%>' id='order_catalog_code_<%=i%>' value='<%=record[21].trim()%>'>

				<input type='hidden' name='proc_link_applicable<%=i%>' id='proc_link_applicable<%=i%>' value='<%=record[22]%>'>
				<input type='hidden' name='proc_link_resulting_option<%=i%>' id='proc_link_resulting_option<%=i%>' value='<%=record[23]%>'>
				<input type='hidden' name='procedure_code_scheme<%=i%>' id='procedure_code_scheme<%=i%>' value='1'>
				<input type='hidden' name='term_set_id<%=i%>' id='term_set_id<%=i%>' value='<%=record[24]%>'>
				<input type='hidden' name='term_code<%=i%>' id='term_code<%=i%>' value='<%=record[25]%>'>
				<Input type='hidden' name='accession_num<%=i%>' id='accession_num<%=i%>' value='<%=record[27]%>'>
				<Input type='hidden' name='resulted_yn<%=i%>' id='resulted_yn<%=i%>' value='<%=(!record[30].equals(""))?"Y":"N"%>'>
			
				
			</td>
		</tr>
				
			<tr>
					<td width='' class="<%=slClassValue%>" wrap colspan='8'>
					  <label class='label'><fmt:message key="eOR.ReportingPractitioner.label" bundle="${or_labels}"/></label><input type='text' name='practitioner_desc<%=i%>' id='practitioner_desc<%=i%>' onBlur='clearpractID("<%=i%>");' value='<%=record[31]%>' size=26 maxlength=40 onFocus='' <%if(record[18].trim().equals("3")){%>  readOnly<%}%> <%=disab%>>
					<%if(!record[18].trim().equals("3")){%><input type='button' name='practitioner_button<%=i%>' id='practitioner_button<%=i%>' class='button' value='?' onClick='show_practitioner_window(practitioner_desc<%=i%>,"Y","<%=i%>")' <%=disab%>>
					<%}%>
				<input type="hidden" name="practitioner_id<%=i%>" id="practitioner_id<%=i%>" value="<%=record[30]%>">
				</td> 
					</tr>
<%
}
%>
<input type=hidden name='child_order_index' id='child_order_index' value='<%=child_order_index%>'>
<input type=hidden name='child_reporting_date' id='child_reporting_date' value='<%=child_reporting_date%>'>
<input type=hidden name='order_id' id='order_id' value='<%=orderId%>'>
<input type=hidden name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
<input type=hidden name='order_type_code' id='order_type_code' value='<%=order_type_code%>'>
<input type=hidden name='report_srl_no' id='report_srl_no' value='<%=reportSrlNo%>'>
<input type=hidden name='total_recs' id='total_recs' value='<%=allValues.size()%>'>
<input type=hidden name='total_auth_imgs' id='total_auth_imgs' value='<%=total_auth_imgs%>'>
<input type=hidden name='patient_class' id='patient_class' value='<%=patient_class%>'>
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">

 <input type="hidden" name="reporting_date" id="reporting_date" value="<%=reporting_date%>">
 <input type="hidden" name="proc_link_applicable_result" id="proc_link_applicable_result" value="<%=proc_link_applicable%>">
 <input type="hidden" name="proc_link_resulting_option_result" id="proc_link_resulting_option_result" value="<%=proc_link_resulting_option%>">
 <input type="hidden" name="chk_val" id="chk_val" value="">
 <input type="hidden" name="proc_scheme_code" id="proc_scheme_code" value="">

<Input type='hidden' name='requestFrom' id='requestFrom' value='<%=requestFrom%>'>

<input type=hidden name='rpt_pract_id' id='rpt_pract_id' value=''>	<!-- report form data -->
<input type=hidden name='rpt_authreq_yn' id='rpt_authreq_yn' value=''>	<!-- report form data -->
<input type=hidden name='rpt_authreq_yn_db' id='rpt_authreq_yn_db' value=''>	<!-- report form data -->
<input type=hidden name='rpt_result_status' id='rpt_result_status' value=''>	<!-- report form data -->
<input type=hidden name='rpt_result_type' id='rpt_result_type' value=''>	<!-- report form data -->
<input type=hidden name='rpt_Order_Status' id='rpt_Order_Status' value=''>	<!-- report form data -->
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=(String)session.getValue("ca_practitioner_id")%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=(String)session.getValue("facility_id")%>">
<input type=hidden name='mode' id='mode' value='<%=mode%>'>	<!-- data required for bean -->
<input type=hidden name='function_id' id='function_id' value='<%=function_id%>'>	<!-- data required for bean -->
<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>		<!-- data required for bean -->
<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>		<!-- data required for bean -->
<input type=hidden name='parent_order_id' id='parent_order_id' value='<%=parent_order_id%>'>	<!-- parent_order_id used only in the case refered from Task List it's value is setted from the js -->
<Input type='hidden' name='order_set_id' id='order_set_id' value='<%=order_set_id%>'>
<Input type='hidden' name='order_set_bill_yn' id='order_set_bill_yn' value='<%=order_set_bill_yn%>'>
</table>
</div>
<%
	if(allValues.size() == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html'</script>");
		
	}else{ 
		//out.println("<script>checkOnBodyLoad()</script>");
	}
%>
	
<script>
	/*if(parent.ResultEntryHeader.document.getElementById("tableheader")==null)
	{
		setTimeout("alignHeading();",300);
	}
	else 
		alignHeading();*/
</script>

</form>
</body>
<script>
checkStatusChange();
//alignWidth();
</script>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

