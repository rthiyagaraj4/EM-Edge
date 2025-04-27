<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOH.* ,eOH.Common.*" %>
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
	<script language="JavaScript" src="../js/ResultEntry.js"></script>
	<!-- <script language="JavaScript" src="../js/ResultReporting.js"></script> --><!--added by Kavitha.K-->

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
	/* Mandatory checks start */
	String mode	= "1";//request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	Properties properties			= (Properties) session.getValue( "jdbc" ); 
	String bean_id		 = "Oh_ResultEntry" ;
	String bean_name	 = "eOH.ResultEntryBean";
	String colval		 = request.getParameter("colval");
	String colval1		 = request.getParameter("task_type");
	String orderId		 = request.getParameter("orderId");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String resp_id		 = (String)session.getValue("responsibility_id");
	String requestFrom	 = request.getParameter("requestFrom");
	String report_srl_no = request.getParameter("report_srl_no");
	String patient_id	 = request.getParameter("patient_id");
	String patient_class	 = request.getParameter("patient_class");
	String encounter_id	 = request.getParameter("encounter_id");
	String relationship_id = request.getParameter("relationship_id");
	String order_category = request.getParameter("order_category");
	StringBuffer headerdetails_1= new StringBuffer();
	StringBuffer headerdetails_2= new StringBuffer();
	//StringBuffer heading= new StringBuffer();
	String sex = request.getParameter("sex");
	String order_type = request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
//	String sex = request.getParameter("sex");
	String parent_order_id	=request.getParameter("parent_order_id")==null?"":request.getParameter("parent_order_id");

	String facility_id = (String)session.getValue("facility_id");
	
/* Mandatory checks end */

/* Initialize Function specific start */
	ResultEntryBean bean = (ResultEntryBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode( mode ) ;
	String bill_yn=bean.checkForNull((String)bean.getBillInterfaceYn(),"N");

	String view_bean_id = "Oh_ViewOrder" ;
	String view_bean_name = "eOH.ViewOrder";
	ViewOrder view_bean = (ViewOrder)getBeanObject( view_bean_id,view_bean_name,request ) ; 


	//String common_bean_id 			= "@accessrightbean"+patient_id+encounter_id;
	//String common_bean_name 		= "eOR.Common.AccessRightBean";
	//AccessRightBean common_bean 	= (AccessRightBean)getBeanObject( common_bean_id, common_bean_name,  request) ;
/* Initialize Function specific end */

	//out.println(bean.getReportSrlNo(orderId));
	if(requestFrom==null)	requestFrom="";
	if(report_srl_no==null)	report_srl_no="";
	if(relationship_id==null) relationship_id = "";
	if (order_category==null) order_category = "";

	String[] resportsrlno = bean.getReportSrlNo(orderId);
	String order_id = (String)bean.getParentOrderId(orderId);
	String order_set_id = (String)bean.getOrderSetId(orderId);
	
//	out.println("<script>alert('=can_order_type="+request.getParameter("can_order_type")+"=')</script>");
	if(order_id == null)  order_id="";
	//out.println(resportsrlno[0]+", "+resportsrlno[1]);
	int reportSrlNo = Integer.parseInt(resportsrlno[0]);

	if(resportsrlno[1].equals("3"))	reportSrlNo++;

	boolean canChangePractId = true;
	String reportSrlNo_url = request.getParameter("report_srl_no");
	if(requestFrom.trim().equalsIgnoreCase("FE"))
	{
		if(reportSrlNo == 2)
		{
			reportSrlNo_url = "1";
			reportSrlNo = 1;
			canChangePractId = false;
		}
	}
	if(reportSrlNo_url==null)
	{
		reportSrlNo_url = Integer.toString(reportSrlNo);
	}


	String[] headerDetails = new String[6];
	
	headerDetails = bean.getHeaderLineDetails(orderId, reportSrlNo_url);
		
	String[] arr_pract_idfrom_db = bean.getHeaderLinePractId(orderId,reportSrlNo_url);
	String[] arr_pract_id_name_from_db = null;
	String pract_idfrom_db = arr_pract_idfrom_db[0];
	String pract_namefrom_db = arr_pract_idfrom_db[1];
	if (pract_idfrom_db == null) pract_idfrom_db = "";
	if (pract_namefrom_db == null) pract_namefrom_db = "";
	if(pract_idfrom_db.equals("") && pract_namefrom_db.equals(""))
	{
		pract_idfrom_db		= (String) session.getValue( "login_user" );
		// Here using this id and query from the database 
		if(pract_idfrom_db!=null && !pract_idfrom_db.equals(""))
		{
			arr_pract_id_name_from_db = bean.getUser(pract_idfrom_db);
			pract_idfrom_db = arr_pract_id_name_from_db[0];
			pract_namefrom_db = arr_pract_id_name_from_db[1];
			if (pract_idfrom_db == null) pract_idfrom_db = "";
			if (pract_namefrom_db == null) pract_namefrom_db = "";
		}
	}	
	if(reportSrlNo > 1)	canChangePractId = false;

	String allergy_display_yn 		= bean.getMenu("ALLERGY_LST",resp_id,relationship_id, properties);
 	String active_display_yn 		= bean.getMenu("PROBLEM_LST",resp_id,relationship_id, properties);
		
	int format_count				= bean.getFormatCount(orderId, "HEADER") ; //Pass the order_id and the line no is null

	// From the View Order get the clinical comments if it is there
	//String max_action_seq_num	= bean.checkForNull(view_bean.getMaxCount(orderId),"");
	String max_action_seq_num	= bean.checkForNull(view_bean.getMaxCount(orderId),"");
	
%>  
<form name='result_entry_report' id='result_entry_report'>
<table cellpadding=3 cellspacing=0 border=0 width="100%" height="100%" align=center> 
	<tr>
		<td class='data' width='15%' nowrap><fmt:message key="eOR.ResultStatus.label" bundle="${or_labels}"/></td>
		<td class='fields' width='32%' nowrap>
			<%--<Script>alert('orderId=<%=orderId%>,reportSrlNo_url=<%=reportSrlNo_url%>,headerDetails[0]=<%=headerDetails[0]%>')</Script>--%>
		
			<%if(headerDetails[0].equalsIgnoreCase("In Progress"))
				headerdetails_1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Partial"))
				headerdetails_1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Partial.label","or_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Complete"))
				headerdetails_1.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels"));
				
				if(headerDetails[0].equalsIgnoreCase("Normal"))
				headerdetails_2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Normal Low"))
				headerdetails_2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalLow.label","or_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Critical Low"))
				headerdetails_2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalLow.label","or_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Normal High"))
				headerdetails_2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NormalHigh.label","or_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Critical High"))
				headerdetails_2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalHigh.label","or_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Abnormal"))
				headerdetails_2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Critically Abnormal"))
				headerdetails_2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CriticallyAbnormal.label","common_labels"));
				else if (headerDetails[0].equalsIgnoreCase("Not Applicable"))
				headerdetails_2.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels"));
%>
			<input type='text' name='result_status' id='result_status' value='<%=headerdetails_1%>' size='11' readonly>
			<input type=hidden name='result_status_from_db' id='result_status_from_db' value='<%=headerDetails[1]%>'>
			<input type=hidden name='rslt_status' id='rslt_status' value='<%=headerDetails[1]%>'>
			<input type='text' name='srv_status' id='srv_status' size='14' value='<%=headerdetails_2%>' readonly>
			<input type=hidden name='rslt_type' id='rslt_type' value='<%=headerDetails[3]%>'>
 </td>
		<td class='label' width='23%'><!-- Reporting Practitioner --></td>
		<td class='fields' width='30%'><!--ADDED NEW LOOK UP  --><input type='hidden' name='practitioner_desc' id='practitioner_desc' onBlur='' value='<%=pract_namefrom_db%>' size=14 maxlength=40 onFocus=''<%if(!canChangePractId){%>  readonly<%}%> ><%if(canChangePractId){%><!-- <input type='button' name='practitioner_button' id='practitioner_button' class='button'   value='?' onClick='show_practitioner_window(document.getElementById("practitioner_desc"),"Y")'> 
		&nbsp;<img src="../../eCommon/images/mandatory.gif"> --><%}%></td>
		<input type='hidden' name='practitioner' id='practitioner' value='<%=pract_idfrom_db%>' size=30 maxlength=40 >
		<!--OLD LOOK UP -->
		<!-- <input type='text' name='practitioner' id='practitioner' size='14' value='<%=pract_idfrom_db%>' readonly><%if(canChangePractId){%><input type='button' name='practitioner_button' id='practitioner_button' class='button' value='?' onClick='show_practitioner_window()'>&nbsp;<%}%><img src="../../eCommon/images/mandatory.gif"> -->
		</td>
		<%
		if(!(order_category.equalsIgnoreCase("PH")||order_category.equalsIgnoreCase("OH"))&&bill_yn.equalsIgnoreCase("Y"))
		{
		%>
			<td class='label' nowrap><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/><a class="gridLink" href="javascript:callBilling('0','<%=orderId%>','<%=patient_id%>','<%=facility_id%>','<%=encounter_id%>','<%=patient_class%>','<%=order_category%>','<%=colval%>','<%=colval1%>','<%=sex%>','<%=order_set_id%>')" title='Charge Details'> <!--<fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/>--><FONT SIZE="2" ><fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/></FONT></a></td>
		<%}else{%>
				<td class='label' width="40%" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<%}%>
		<td class="label"></td>
		</tr>
	<tr>
		<td class='labelleft' colspan='3' nowrap>
			<input type='hidden' name='order_status' id='order_status' value='C'>
<%		if((allergy_display_yn.equals("X")) && !(order_category.equals("PH")))  out.println("&nbsp;");
      	else if ( order_category.equals("PH"))
		{ 
			if(!order_id.equals("")) {
%>		
		<a class="gridLink" href='#' onClick="callMenuFunctions('Result','<%=colval%>','<%=order_id%>','','','<%=patient_id%>','','','','LB')"><fmt:message key="eOR.LabResults.label" bundle="${or_labels}"/></a>
		
<%			}else{
				out.println("&nbsp;");}
		}
		else
		{
%>			<a class="gridLink" href="#" onclick='callAllergies("<%=patient_id%>")'><fmt:message key="Common.Allergies.label" bundle="${common_labels}"/></a>
<%		}  
		if((active_display_yn.equals("X"))  && !(order_category.equals("PH")))  out.println("&nbsp;");
		else if ( order_category.equals("PH") )
		{
			if(!order_id.equals("")) {
%>
			<a class="gridLink" href="#" onclick="callMenuFunctions('View','<%=colval%>','<%=parent_order_id%>','')"><fmt:message key="eOR.DrugDetails.label" bundle="${or_labels}"/></a>
			
<%			}else{
				out.println("&nbsp;");}
		}
		else {%>			
		<a class="gridLink" href="#" onclick='callActive("<%=patient_id%>","<%=encounter_id%>")'><fmt:message key="Common.ActiveProblems.label" bundle="${common_labels}"/></a>
<%		}  %>
 	
<%     if ( order_category.equals("PH") ) { %>
		<a class="gridLink" href="#" onclick='callDrugProfile("<%=patient_id%>")'><fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></a>
<%	
	String catalog_desc = bean.getCatalogDesc(orderId); 
		if(catalog_desc!=null ){
			if(order_type.equals("TDM") || order_type.equals("")){
			%>
				<a class="gridLink" href="#" onclick="viewReasonforRequest('<%=orderId%>')"><%=catalog_desc%></a>
		<%	}else if(order_type.equals("PDC")){
			%>
				 <a class="gridLink" href="#" onclick="callMenuFunctions('View','<%=colval%>','<%=orderId%>','')"><%=catalog_desc%></a>
		<%	}
		}
		%>
		<a class="gridLink" href="#" onClick="callPatientHistory('<%=patient_id%>')"><fmt:message key="eOR.PatientHistory.label" bundle="${or_labels}"/>
		</a> 	
		<%
		} %>		 
  
		</td>
		<td colspan='2' class='labelleft' nowrap><span id='id_authorise'>
<%		String auth_reqd_yn_db = "N";
			//String decideAuth = bean.getAuthorization(practitioner_id, resp_id, orderId);
			
		String decideAuth = bean.getAuthorization1(practitioner_id, resp_id, orderId, order_category);
		//out.println("<script>alert('practitioner_id="+practitioner_id+",resp_id="+resp_id+",orderId="+orderId+",order_category="+order_category+",decideAuth="+decideAuth+"')</script>");
		
		if(!headerDetails[1].equals("3") || requestFrom.trim().equalsIgnoreCase("RA"))
		{
			if(decideAuth.equals("3") && headerDetails[5].equalsIgnoreCase("N"))
			{
				auth_reqd_yn_db = "Y";
			%>
				<img src='../images/Authorization.gif'><a class="gridLink" href="#" onclick='authoriseLinkClicked()'><fmt:message key="eOR.PresslinktoAuthorize.label" bundle="${or_labels}"/></a>
			<%
			}else if(decideAuth.equals("3"))
			{
				auth_reqd_yn_db = "Y";
			%>
				<img src='../images/Authorized.gif'><B><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></B>
				<input type=hidden name='hidden_auth_reqd_yn' id='hidden_auth_reqd_yn' value='Y'><!-- <a href="#" onclick='authoriseLinkClicked()'>Press link to Authorize&nbsp;</a> -->
			<%
			}else if(decideAuth.equals("2"))
			{
				auth_reqd_yn_db = "Y";
				%>
				<font size=1><img src='../images/Authorization.gif'><fmt:message key="eOR.AuthorizationRequired.label" bundle="${or_labels}"/></font>
			
			<%
			}else if(decideAuth.equals("1"))
			{
			%>
			<font size=1></font>
			<%
			}
		}else
		{
		%>
			<font size=1></font>
		<%
		}
		%></span>
		 
		<%
			if(!max_action_seq_num.equals("") && !max_action_seq_num.equals("0")){ %>
		<a class="gridLink" href="#" onclick='viewHeaderComments("<%=orderId%>")'><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></a> 
		<% } %>
	 
<%	
	if(format_count!=0){ %>
			<a class='gridLink' href='javascript:viewOrderFormat("<%=orderId%>")' title='Order Format'>
				<img src='../../eOR/images/Flex_blue.gif' align='center'></img>
			</a>
<%		}	%>
 		<input type=hidden name='auth_reqd_yn' id='auth_reqd_yn' value='N'>
		<input type=hidden name='auth_reqd_yn_db' id='auth_reqd_yn_db' value='<%=auth_reqd_yn_db%>'>
		<input type=hidden name='requestFrom' id='requestFrom' value='<%=requestFrom%>'>
		</td>
		<td class="label"></td>
		</tr>


	</tr>
</table>
<!--  <input type="hidden" name="prac_sql" id="prac_sql" value="<%//=OrRepository.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRAC_LOOKUP")%>"> -->
 <input type="hidden" name="prac_sql" id="prac_sql" value="<%=OHRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP")%>">
 <input type="hidden" name="prac_sql2" id="prac_sql2" value="<%=OHRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2")%>">
 <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
 <input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
 <input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
//putObjectInBean( view_bean_id,view_bean,request ) ; 
//putObjectInBean( common_bean_id,common_bean , request ) ;
%>

