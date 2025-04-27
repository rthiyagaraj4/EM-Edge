<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>

<html>
<title>
<%String order_catalog_desc=request.getParameter("order_catalog_desc")==null?"":request.getParameter("order_catalog_desc");
%>
<fmt:message key="eOR.ConsentRequiredfor.label" bundle="${or_labels}"/>- <%=order_catalog_desc%>
</title>
<style>
TD.QRYEVEN1{
    BACKGROUND-COLOR: #F0F0F2;  
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;

       }

TD.QRYODD1{
    BACKGROUND-COLOR: #E2E3F0;  
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;
	
    }
</style>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
 	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
try{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		//out.println("<script>alert('"+requet.getQueryString()+"')</script>");
	String order_catalog_code = request.getParameter("order_catalog_code");
	order_catalog_code = (order_catalog_code == null) ? "":order_catalog_code;
	//String order_catalog_desc = request.getParameter("order_catalog_desc");
	//order_catalog_desc = (order_catalog_desc == null) ? "":order_catalog_desc;
	String order_category = request.getParameter("order_category");
	order_category = (order_category == null) ? "":order_category;
	String index = request.getParameter("index");
	index = (index == null) ? "":index;

	String function_from = request.getParameter("function_from");	
	function_from = (function_from == null) ? "":function_from;
	String order_id = request.getParameter("order_id");
	order_id = (order_id == null) ? "":order_id;
	String order_line_num = request.getParameter("order_line_num");
	order_line_num = (order_line_num == null) ? "1":order_line_num;
	String buttn_label = request.getParameter("buttn_label");
	buttn_label = (buttn_label == null) ? "":buttn_label;
	String consent_form_id = request.getParameter("consent_form_id");
	consent_form_id = (consent_form_id == null) ? "":consent_form_id;
	
	HashMap bean_consentDtl = null;
	
	if(buttn_label.equals("Orders")){
		OrderEntryBean beanObj		= (OrderEntryBean)getBeanObject( request.getParameter("bean_id"),request.getParameter("bean_name"), request ) ;
		beanObj.setLanguageId(localeName);
		bean_consentDtl = beanObj.getConsentFormDtl(index+order_catalog_code+order_category);
		//out.println("<script>alert('bean_consentDtl="+bean_consentDtl.size()+"');</script>");
	}

	//out.println("<script>alert('function_from="+function_from+"');</script>");
	//out.println("<script>alert('ord_typ_code="+ord_typ_code+"');</script>");
	//out.println("<script>alert('order_line_num="+request.getParameter("order_line_num")+"');</script>");
	ArrayList multiConsentList = new ArrayList();
	String[] multiConsentValues = null;
	String[] multiConsentDtls = null;
	String consent_req_bef_order = "";//added for SRR20056-SCF-2009  Id:  3736 05/06/2008
	String consent_req_bef_regn = ""; //added for SRR20056-SCF-2009  Id:  3736 05/06/2008


	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";

	ConsentOrders bean		= (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	//Properties properties			= (Properties) session.getValue( "jdbc" );
	//String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	/*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/
	String multiConsentLine[] = new String[4];
	multiConsentLine=bean.MultiListConsentsLine(order_id,order_line_num);
	/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/
	multiConsentDtls		= bean.MultiListDtls(order_catalog_code,practitioner_id);
	multiConsentList		= bean.MultiListConsentsdtl(order_catalog_code,order_id,order_line_num, practitioner_id);

	if(multiConsentList==null || multiConsentList.size()==0)
	{
		
		multiConsentList		= bean.MultiListConsents(order_catalog_code,order_id,order_line_num, practitioner_id);
		consent_req_bef_order = (String) multiConsentDtls[1];
		consent_req_bef_regn = (String) multiConsentDtls[2];
	}else{//added for SRR20056-SCF-2009  Id:  3736  05/06/2008
	
		consent_req_bef_order = (String) multiConsentLine[2];//added for SRR20056-SCF-2009  Id:  3736  05/06/2008
		consent_req_bef_regn = (String) multiConsentLine[3];//added for SRR20056-SCF-2009  Id:  3736  05/06/2008
	}//added for SRR20056-SCF-2009  Id:  3736  05/06/2008
	

	//}

//	out.println("<script>alert('@@@"+multiConsentDtls[0].size+"')</script>");
%>
<form method="post" name="multiple_consent_form" id="multiple_consent_form">
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center class="grid">
	<!-- Fixed List Case -->
<%
	String consent_before_ord_release = "0"; 
	String consent_before_ord_regis = "0";
	String consent_header="";
	String disp_count = "0";
	String slClassValue = "";
	String consent_req_bo= "";
	String consent_req_br= "";
	String consent_stage="";
	int num_consent_bo=0;
	int num_consent_br=0;
	int temp_count=0;
	int total_recs = 0;
	boolean header_disp = true;
	boolean consentflag = false;
	if(multiConsentDtls != null){	
	//if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2])) > 1 ) )){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
	if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1 ) || ( (Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn)) > 1 ) )){
	 %>
		<!-- <tr>
			<td  class='label' align='left' colspan='3' > <B>Required Consent Form</B> </td>
			
		</tr> -->
		<%
		for(int i=0;i<multiConsentList.size();i++)
		{
			slClassValue="gridData";
			
			multiConsentValues = (String[])multiConsentList.get(i);
			consent_before_ord_release = multiConsentValues[7];
			consent_before_ord_regis  = multiConsentValues[8];
			if(multiConsentValues[6].equals("F"))
			{
				//if(i == 0)
				//{
					
					//if(consent_before_ord_release.equals("0"))
					if(multiConsentValues[3].equalsIgnoreCase("R"))
					{
						consent_header= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BeforeOrderRegistration.label","or_labels")+":" ;
						disp_count = multiConsentValues[8];
					}else if(multiConsentValues[3].equalsIgnoreCase("A"))
					{
						disp_count = multiConsentValues[7];
						consent_header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BeforeOrderRelease.label","or_labels")+":" ;
					}
				//}
				if(!(multiConsentValues[3]).equals(consent_stage))
				{
					header_disp=true;
					consent_stage=multiConsentValues[3];
				}
				else
				{
					header_disp=false;
				}
				if(header_disp)
				{
				%>	
					 <tr>
						<td  class='CAHIGHERLEVELCOLOR' align='left' colspan='3'><B><%=consent_header%> <%=disp_count%></B></td>
					</tr> 
			<%		//header_disp = false;
				 }
				 if(multiConsentValues[3].equals("A"))
				{
					if(Integer.parseInt(consent_before_ord_release)!=num_consent_bo)
					{
						num_consent_bo++;
						temp_count++;
						consentflag = true;
					}
				}
				else if(multiConsentValues[3].equals("R"))
				{
					if(Integer.parseInt(consent_before_ord_regis)!=num_consent_br)
					{
						num_consent_br++;
						temp_count++;
						consentflag = true;
					}
				}
				if(consentflag)
				{
					%>
						<tr>
							<td class='<%=slClassValue%>' style='border-right:0px' width='30% '>&nbsp;</td>
							<td class='<%=slClassValue%>' colspan='2' align="left" width='70% ' style='border-left:0px'><!-- Consent Label --><B><font COLOR="<%=multiConsentValues[10].equals("Y")?"#CC3300;":""%>"><%=temp_count%>. <%=multiConsentValues[2]%></font></B></td>
						</tr>
					<% 
						consentflag = false;
				}
				%>
				<input type='hidden' value="Y" name="consent_chk<%=i%>" id="consent_chk<%=i%>">
				<input type='hidden' value="<%=multiConsentValues[1]%>" name="consent_form_id<%=i%>">
				<input type='hidden' value="<%=multiConsentValues[3]%>" name="consent_stage<%=i%>">
			<%	//temp_count++; 
				//if(temp_count == Integer.parseInt(consent_before_ord_release)){
					//header_disp = true;
					//consent_header = //com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BeforeOrderRegistration.label","or_labels")+":" ;
					//disp_count = multiConsentValues[8];
				//}
			}
			if(multiConsentDtls[0].equals("V")){%> 
				<!-- Variable List Case -->
				<!-- Multiple Consent Required Case --><!-- Associated List Exists -->
				<%if(i==0){
			/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**start**/
				//	consent_req_bo = multiConsentDtls[1];
				//	consent_req_br = multiConsentDtls[2];
					consent_req_bo = consent_req_bef_order;
					consent_req_br = consent_req_bef_regn;	
			/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**end**/
					%>
				<!-- <tr>
					<td class='CAHIGHERLEVELCOLOR' style='border-right:0px' colspan=''><B>Required Count :</B></td>
					<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' align='center' colspan=''><B>Before Order Release&nbsp;<label id='before_release'><%=multiConsentDtls[1]%></label></B></td>
					<td class='CAHIGHERLEVELCOLOR' style='border-left:0px' align='left' colspan=''><B>Before Order Registration&nbsp;<label id='before_regist'><%=multiConsentDtls[2]%></label></B></td>

					
				</tr>	
				<tr>
					<th>Select</th>
					<th>Consent Form</th>
					<th>Stage</th>
				</tr> -->
				<%}
				if(bean_consentDtl !=null && bean_consentDtl.size() >0){
					if(((String)bean_consentDtl.get("consent_chk"+i)).equals("Y")){
						multiConsentValues[9]	= (String)bean_consentDtl.get("consent_chk"+i);
						multiConsentValues[1]	= (String)bean_consentDtl.get("consent_form_id"+i);
						multiConsentValues[3]	= (String)bean_consentDtl.get("consent_stage"+i);
						
					}
					multiConsentValues[4]		= "N";
				}
								
				%>
				<tr>
					<td class='<%=slClassValue%>' align='center' width='20%'><input type="checkbox" name="consent_chk<%=i%>" id="consent_chk<%=i%>" <%=((multiConsentValues[4].equals("Y") && buttn_label.equals("Orders"))|| multiConsentValues[9].equals("Y") || multiConsentValues[10].equals("Y"))? "checked":""%> <%=(multiConsentValues[10].equals("Y")? "disabled":"")%> onclick='consentEntered("<%=i%>",this,"<%=consent_form_id%>")'></td>

					<td class='<%=slClassValue%>' width='40%' style="cursor:<%=(multiConsentValues[10].equals("Y")?"hand":(multiConsentValues[9].equals("Y")? "crosshair":"default"))%>" title='<%=(multiConsentValues[10].equals("Y")?"Recorded Consent":(multiConsentValues[9].equals("Y")? "Confirmed Consent":"Consent to Be Confirmed"))%>'><B><label style='<%=(multiConsentValues[10].equals("Y")?"COLOR:#CC3300;":(multiConsentValues[9].equals("Y")? "COLOR:#009933":""))%>' class='<%=(multiConsentValues[9].equals("Y")? "":"label")%>' ><%=multiConsentValues[2]%></label></B></td>
					
					<td class='<%=slClassValue%>' align='center' width='40%'><select name='consent_stage<%=i%>' id='consent_stage<%=i%>' <%=(multiConsentValues[10].equals("Y")? "disabled":"")%>>
						<option value='A' <%=(multiConsentValues[3].equals("A")? "selected":"")%>  style='<%=(multiConsentValues[10].equals("Y")?"background-color:#CC3300;color:#FFFFFF":((multiConsentValues[9].equals("Y") && multiConsentValues[3].equals("A"))? "background-color:#009933;color:#FFFFFF":""))%>' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
						<option value='R' <%=(multiConsentValues[3].equals("R")? "selected":"")%> style='<%=(multiConsentValues[10].equals("Y")?"background-color:#CC3300;color:#FFFFFF":((multiConsentValues[9].equals("Y") && multiConsentValues[3].equals("R"))? "background-color:#009933;color:#FFFFFF":""))%>'><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
						</select></td>
						<input type='hidden' value="<%=multiConsentValues[1]%>" name="consent_form_id<%=i%>">
						<input type='hidden' value="<%=multiConsentValues[3]%>" name="consent_form_stage<%=i%>">
						<input type='hidden' value="<%=multiConsentValues[9]%>" name="form_confirmed<%=i%>">
						
						<input type='hidden' value="<%=multiConsentValues[4]%>" name="form_dflt_chk<%=i%>">
				</tr>
			<%} total_recs++;
		}
		if(multiConsentDtls[0].equals("V")){
			out.println("<script>defaultChk("+total_recs+")</script>");
		}
		%>
	
				
	<%}else if( multiConsentDtls[0].equals("V") && ((Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1) || (Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn) > 1) ) ){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
	%>
		<!-- Associated List not Exists  -->
			<!-- <tr>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px' colspan=''><B>Required Count :</B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' align='center' colspan='' nowrap><B>Before Order Release&nbsp;<label id='before_release'><%=multiConsentDtls[1]%></label></B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-left:0px' align='center' colspan=''><B>Before Order Registration&nbsp;<label id='before_regist'><%=multiConsentDtls[2]%></label></B></td>
							
			</tr>	 -->
			<% 
				/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008***start*/
				//consent_req_bo = multiConsentDtls[1];
			   //consent_req_br = multiConsentDtls[2];
			   consent_req_bo = consent_req_bef_order;
			   consent_req_br = consent_req_bef_regn;
				
			//int count= Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]);
			/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**end**/
			int count= Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn);
			int i =0,tmp_count=0;
			String consent_stg = "";

			String form_id = "",form_label = "", consent_recd="";
			
			multiConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,order_id,order_line_num, practitioner_id);
			ArrayList arraylistseq = new ArrayList();
			HashMap hashmap = new HashMap();int tmp_cnt=0;
			while(i < count){
				/*if(i % 2 == 0){
					slClassValue = "QRYEVEN1";
				}else{
					slClassValue = "QRYODD1";
				}*/
				slClassValue="gridData";
				if(i == 0){
					//if(multiConsentDtls[1].equals("0")){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
					if(consent_req_bef_order.equals("0")){
						consent_header= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ConsentFormforBeforeOrderRegistration.label","or_labels");
						consent_stg = "R";
					}else{
						consent_header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ConsentFormforBeforeOrderRelease.label","or_labels");
						consent_stg = "A";
					}
					
				}
				
				if(i < multiConsentList.size()){
					
					multiConsentValues = (String[])multiConsentList.get(i);
					if(consent_stg.equals(multiConsentValues[3])){
						form_id			= multiConsentValues[1];
						form_label		= multiConsentValues[2];
						//consent_stg		= multiConsentValues[3];
						consent_recd	= multiConsentValues[10];
					}else{
						hashmap.put("form_id" , multiConsentValues[1]);
						hashmap.put("form_label" , multiConsentValues[2]);
						hashmap.put("consent_recd" , multiConsentValues[10]);
						arraylistseq.add(hashmap);
						tmp_cnt++;

						form_id			= "" ;
						form_label		= "" ;
						consent_recd	= "" ;

					}
				}else{
					if(tmp_cnt>0 ){
						form_id = (String)((HashMap)arraylistseq.get(--tmp_cnt)).get("form_id");
						form_label = (String)((HashMap)arraylistseq.get(tmp_cnt)).get("form_label");
						consent_recd =(String)((HashMap)arraylistseq.get(tmp_cnt)).get("consent_recd");

					}else{
						form_id			= "" ;
						form_label		= "" ;
						consent_recd	= "" ;
					}
				}

				if(bean_consentDtl !=null && bean_consentDtl.size() >0){
					if( bean_consentDtl.containsKey("consent_chk"+i) && ( ((String)bean_consentDtl.get("consent_chk"+i)).equals("Y") ) ){
						
						form_id	= (String)bean_consentDtl.get("consent_form_id"+i);
						form_label	= (String)bean_consentDtl.get("consent_form_desc"+i);
					}
				}
				
				if(header_disp){
					header_disp = false;
				%>
			<tr style='border-top:0px;border-bottom:0px'>
				<td class='label'colspan="3"><B><%=consent_header%></B></td>
			</tr>
				<%}%>
			<tr style='border-top:0px;border-bottom:0px'>
				
				<!-- <td class='<%=slClassValue%>' align='right'><B><%//=++tmp_count%></B>&nbsp;</td>	 -->	
				<td id='assign_consent<%=i%>' class='<%=slClassValue%>' colspan='3' style='border-top:0px;border-bottom:0px' align='center'><B><%=++tmp_count%>&nbsp;.&nbsp;</B><input type="text" name="consent_form_desc<%=i%>" id="consent_form_desc<%=i%>" value="<%=form_label%>" onclick='consentEntered(<%=i%>,this,"<%=consent_form_id%>")' onBlur="showConsent(consent_form_desc<%=i%>,consent_form_id<%=i%>);clearID('<%=i%>')" <%=consent_recd.equals("Y")?"disabled" :""%>>&nbsp;<input class="button" type="button" name="consent_id_lookup<%=i%>" id="consent_id_lookup<%=i%>"  value="?" onClick="showConsent(consent_form_desc<%=i%>,consent_form_id<%=i%>)" <%=consent_recd.equals("Y")?"disabled" :""%>>
				<input type="hidden" name="consent_form_id<%=i%>" id="consent_form_id<%=i%>" value="<%=form_id%>" >&nbsp;</td>
				<input type="hidden" name="consent_stage<%=i%>" id="consent_stage<%=i%>" value="<%=consent_stg%>" >
				<input type="hidden" name="consent_text<%=i%>" id="consent_text<%=i%>" value="<%=form_label%>" >
			</tr>
			
<%			i++;
			//if(i == Integer.parseInt(multiConsentDtls[1])){//changed for SRR20056-SCF-2009  Id:  3736  05/06/2008
			if(i == Integer.parseInt(consent_req_bef_order)){
				header_disp = true;
				tmp_count = 0;
				consent_header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ConsentFormforBeforeOrderRegistration.label","or_labels");
				consent_stg = "R";
				
			}
		}total_recs = i;
	}
	else
	{
		/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**start**/							//consent_req_bo = multiConsentDtls[1];
		//consent_req_br = multiConsentDtls[2];
		consent_req_bo = consent_req_bef_order;
		consent_req_br = consent_req_bef_regn;
		/******changed for SRR20056-SCF-2009  Id:  3736  05/06/2008**end**/		%>
		<!-- end -->
		<!-- Single Consent Required Case -->
		<input type="hidden" value='<%=multiConsentDtls[4].equals("Release")?"A":( multiConsentDtls[4].equals("Registration")?"R":"")%>' name="consent_stage0">
		<!-- <tr>
			<td class='CAHIGHERLEVELCOLOR' colspan='3'><B>Consent Form for Before Order <%=multiConsentDtls[4]%></B></td>
		</tr> -->
		<tr>
			<td class='label' colspan='3'>&nbsp;</td>
		</tr>
		<tr>
		<td class='label'  colspan='3' id='assign_consent0'><B><fmt:message key="Common.ConsentForm.label" bundle="${common_labels}"/> :</B>
		<%
		if(multiConsentDtls[0].equals("F"))
		{
			if(!multiConsentDtls[5].equals("")&&!multiConsentDtls[5].equals(""))
			{
			%> 
			<B><%=multiConsentDtls[5]%></B></td>
			<input type="hidden" value='Y' name="consent_chk0" id="consent_chk0">
			<input type='hidden' value="<%=multiConsentDtls[3]%>" name="consent_form_id0">
			<input type='hidden' value="<%=multiConsentDtls[4]%>" name="consent_stage0">
		</tr>
		<%
			}
			else 
			{
				if(multiConsentList.size()==1)
				{
						multiConsentValues = (String[])multiConsentList.get(0);
				%> 
					<B><%=multiConsentValues[2]%></B></td>
					<input type="hidden" value='Y' name="consent_chk0" id="consent_chk0">
					<input type='hidden' value="<%=multiConsentValues[1]%>" name="consent_form_id0">
					<input type='hidden' value="<%=multiConsentValues[3]%>" name="consent_stage0">
				</tr>
				<%
				}
			}
		}
		if(multiConsentDtls[0].equals("V"))
		{
		
			String form_id = "",form_label = "";
		%> 
		<!-- Associated List Exists -->
		
		<%if(multiConsentList.size() > 0){
			if(bean_consentDtl !=null && bean_consentDtl.size() >0){
				if( bean_consentDtl.containsKey("consent_chk0") && ( ((String)bean_consentDtl.get("consent_chk0")).equals("Y") ) ){
					form_id	= (String)bean_consentDtl.get("consent_form_id0");
				}
			}
			
			%><select name='consent_form_id0' id='consent_form_id0' onchange='consentEntered(0,this,"<%=consent_form_id%>")'>
			<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<%		for(int i=0;i<multiConsentList.size();i++){
				multiConsentValues = (String[])multiConsentList.get(i);
				if( !form_id.equals("") && form_id.equals(multiConsentValues[1])){
					multiConsentValues[9] = "Y";
					multiConsentValues[4] = "N";
				}
				if(multiConsentValues[9].equals("Y"))
					multiConsentValues[4] = "N";
		%>
			<option value='<%=multiConsentValues[1]%>' style="<%=(multiConsentValues[9].equals("Y")? "background-color:#009933;color:#FFFFFF":"")%>" <%=((multiConsentValues[4].equals("Y") || multiConsentValues[9].equals("Y"))? "selected":"")%>><%=multiConsentValues[2]%></option>
			
			<%}%>
		</select>
				
		<script>
			defaultSelect('0');
		</script>

		<%}else{
				
				multiConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,order_id,order_line_num, practitioner_id);
				if(multiConsentList.size() >0){
					for(int i=0;i<multiConsentList.size();i++){
						multiConsentValues = (String[])multiConsentList.get(i);
						form_id = multiConsentValues[1];
						form_label = multiConsentValues[2];
					}
				}
				if(bean_consentDtl !=null && bean_consentDtl.size() >0){
					if( bean_consentDtl.containsKey("consent_chk0") && ( ((String)bean_consentDtl.get("consent_chk0")).equals("Y") ) ){
						form_id	= (String)bean_consentDtl.get("consent_form_id0");
						form_label	= (String)bean_consentDtl.get("consent_form_desc0");
					}
				}
				%>
			<!-- Associated List Not Exists -->
			<input type="text" name="consent_form_desc0" id="consent_form_desc0" value="<%=form_label%>" onclick='consentEntered(0,this,"<%=consent_form_id%>")' onBlur="showConsent(consent_form_desc0,consent_form_id0);clearID('0')">&nbsp;<input class="button" type="button" name="consent_id_lookup" id="consent_id_lookup"  value="?" onClick="showConsent(consent_form_desc0,consent_form_id0)">
			<input type="hidden" name="consent_form_id0" id="consent_form_id0" value="<%=form_id%>" >
			<input type="hidden" name="consent_text0" id="consent_text0" value="<%=form_label%>" >

			<%}%>
		</td>
		
	</tr>	<%}%>
	<tr>
		<td class='label' colspan='3'>&nbsp;</td>
	</tr>
	<% total_recs++; // here it will be always 1 in this loop since its a single consent
		}%>
	
	<!-- <tr style='border-top:0px;border-bottom:0px'>
		
		<td class='label' align='right' colspan='3'>
			<% if(!multiConsentDtls[0].equals("F")){
			
			%>
			<input class="button" type="button" name="record" id="record" value="<%=buttn_label.equals("Consent")?"Apply":"OK"%>" onClick="<%=buttn_label.equals("Consent")?"RecordValues()":"StoreValues()"%>">&nbsp;<input class="button" type="reset" name="clear" id="clear"  value="Clear" onClick="document.forms[0].reset();"><%}%>&nbsp;<input class="button" type="button" name="cancel" id="cancel"  value="<%=multiConsentDtls[0].equals("F")?"Close":"Cancel"%>" onClick="window.close()"></td>
	</tr> -->
		<script>
				parent.multi_btn.location.href = "../../eOR/jsp/AssociateMultipleConsentButtons.jsp?&buttn_label="+"<%=buttn_label%>"+"&consent_form_list="+"<%=multiConsentDtls[0]%>"
		</script>
	<% 
	}else{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA')); window.close()</script>");
		
	}//end 
	%>	
</table>

<input type='hidden' name="num_of_consent_req_bo" id="num_of_consent_req_bo" value="<%=consent_req_bo%>">
<input type='hidden' name="num_of_consent_req_br" id="num_of_consent_req_br" value="<%=consent_req_br%>">
<input type="hidden" name="consent_form_id_sql" id="consent_form_id_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT_MULTI_NON_IND")%>" >
<Input type='hidden'name='function_from' value='MULTI_CONSENT'>
<Input type='hidden' name='order_category' id='order_category' value='<%=order_category%>'>
<Input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
<Input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
<Input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<Input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
<Input type='hidden' name='total_recs' id='total_recs' value='<%=total_recs%>'>
<Input type='hidden' name='ord_catalog_code' id='ord_catalog_code' value='<%=order_catalog_code%>'>
<Input type='hidden' name='index' id='index' value='<%=index%>'>
<Input type='hidden' name='mode' id='mode' value='1'>

<Input type='hidden' name='beanOr_id' id='beanOr_id' value='<%=request.getParameter("bean_id")%>'>
<Input type='hidden' name='beanOr_name' id='beanOr_name' value='<%=request.getParameter("bean_name")%>'>


<Input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>

</form>
</body>

</html>
	
<%
	putObjectInBean(bean_id,bean,request);

}catch(Exception e){
	out.println(e.toString());
	//out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
}
	
	
%>

