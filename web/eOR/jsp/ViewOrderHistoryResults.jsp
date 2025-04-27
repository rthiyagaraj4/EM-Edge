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
------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------
22/12/2016	IN062669	Vijayakumar K									ML-MMOH-CRF-0728 [IN:062669]
28/06/2018	IN065341     Prakash C		29/06/2018	Ramesh G	MMS-DM-CRF-0115
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="viewHistory" id="viewHistory">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode				= "1";//request.getParameter( "mode" ) ;
	//String function_id		= request.getParameter( "function_id" ) ;
	String bean_id			= "Or_ViewOrder" ;
	String bean_name		= "eOR.Or_ViewOrder";
 
	//ViewOrder bean		= (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	ViewOrder bean			= (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 	bean.setMode( mode ) ;

	String orderId				= bean.checkForNull(request.getParameter("orderId"));	
	String order_catalog_code	= request.getParameter("order_catalog_code");//IN061961
	String order_cat			= bean.checkForNull(request.getParameter("order_cat"));//IN061961
	String order_category			= bean.checkForNull(request.getParameter("order_category"));//IN061961
	//String order_cat_desc		= bean.checkForNull(request.getParameter("order_cat_desc"));
	String order_line_num		= bean.checkForNull(request.getParameter("order_line_num"));
	String field_mnemonic		= bean.checkForNull(request.getParameter("field_mnemonic"));
	//IN065341 starts
	String called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb		= request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	//String clob_data = request.getParameter("clob_data")==null?"":request.getParameter("clob_data");commented for checkstyle

	boolean isviewLineDtls = bean.isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
	String view_by		= bean.checkForNull(request.getParameter("view_by"));//IN061961
	if(!bean.checkForNull(request.getParameter("ind_order_line_num")).equals("")&&isviewLineDtls)//IN061961
	order_line_num		= bean.checkForNull(request.getParameter("ind_order_line_num"));//IN061961
	//IN065341 ends
	//ArrayList orderDetails		= bean.getViewDetails(orderId, order_line_num, field_mnemonic,RepDb,view_by,order_cat);//commented for IN061961
	ArrayList orderDetails		= bean.getViewDetails(orderId, order_line_num, field_mnemonic,RepDb,view_by,order_category);//IN061961
  	String[] view_details		= null;
	String[] old_new_field_value= null;
 	String old_field_value		= "";
	String new_field_value		= "", old_field_mnemonic = "";
	String user_name			= "", field_value_txt	 ="";
	String class_value			= ""; 

	String order_category_desc	= "";
	String old_order_category_desc	= "";
	String field_mnemonic_desc	= "";
	String accssion_num = request.getParameter("accssion_num")==null?"":request.getParameter("accssion_num");
	String facility_id="";
	if(called_from.equals("CDR")){
		facility_id		=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");;	
	}else{
		 facility_id		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");	
	}
	String l_instrn_type = "";
	String l_order_line_num = "";
	String l_action_seq_num = "";	
%>
	<table cellpadding=3 cellspacing=0 border="1" width="100%" align=center class="grid">
	<tr>
		<th class='columnheader' width="21%"><fmt:message key="Common.Old.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width="21%"><fmt:message key="Common.New.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width="16%"><fmt:message key="eOR.ActionDateTime.label" bundle="${or_labels}"/></th>
		<th class='columnheader' width="36%"><fmt:message key="Common.user.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width="6%"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
	</tr>	
<%
  		if(orderDetails.size() == 0){			
%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
				parent.window.close();
			</script>
<%		} else { 
				for(int i=0;i<orderDetails.size();i++){
					/*if(i % 2 == 0){
						class_value		= "QRYEVEN";
					}else{
						class_value		= "QRYODD";
					}*/
					class_value="gridData";
 					view_details		= (String[])orderDetails.get(i);
					old_field_value		= ""; new_field_value = "";
					field_mnemonic		= bean.checkForNull(view_details[4]);
					//user_name			= bean.getUserName(view_details[1]);
					user_name			= view_details[23];
					field_value_txt		= view_details[7];

					//old_new_field_value = bean.getFieldValue(field_mnemonic, orderId, view_details);
					old_new_field_value = bean.getFieldValue(orderId, view_details);
  					if(old_new_field_value!=null) {
						old_field_value = old_new_field_value[0];
						new_field_value	= old_new_field_value[1];
 					}
					order_category_desc = bean.checkForNull(view_details[24]);
					field_mnemonic_desc = bean.checkForNull(view_details[8]);
					l_instrn_type = bean.checkForNull(view_details[25]);
					l_order_line_num = bean.checkForNull(view_details[26]);
					l_action_seq_num = bean.checkForNull(view_details[0]);

			if(!order_category_desc.equals(old_order_category_desc))
			{
%>
				<tr>
					<td class="CAFLOWSHEETLEVEL1" nowrap colspan="5"><b><%=bean.checkForNull(view_details[24])%></b></td></tr>
 				</tr>
<%
			}
			if(!field_mnemonic.equals(old_field_mnemonic)) {		
%>
			   
				<tr>
					<td class="CAFLOWSHEETLEVEL2" nowrap colspan="5"><b>
						<%
					
							if(field_mnemonic_desc.equals("ORDER_LINE_STATUS"))
							{
							%>
							<fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("QTY_VALUE"))
							{
							%>
							<fmt:message key="Common.Qty.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("QTY_UNIT"))
							{
							%>
							<fmt:message key="Common.QtyUnit.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("ROUTE_CODE"))
							{
							%>
							<fmt:message key="Common.Route.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("FREQ_CODE"))
							{
							%>
							<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("DURN_VALUE"))
							{
							%>
							<fmt:message key="Common.duration.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("DURN_TYPE"))
							{
							%>
							<fmt:message key="Common.DurationType.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("ITEM_NARRATION"))
							{
							%>
							<fmt:message key="eOR.ItemNarration.label" bundle="${or_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("START_DATE_TIME"))
							{
								//Date d= new Date(old_field_value)
								
								
								old_field_value=com.ehis.util.DateUtils.convertDate(old_field_value,"DMYHMS","en",localeName);
								new_field_value=com.ehis.util.DateUtils.convertDate(new_field_value,"DMYHMS","en",localeName);
							%>
							<fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("END_DATE_TIME"))
							{
								old_field_value=com.ehis.util.DateUtils.convertDate(old_field_value,"DMYHMS","en",localeName);
								new_field_value=com.ehis.util.DateUtils.convertDate(new_field_value,"DMYHMS","en",localeName);
							%>
							<fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("ORDER_CATALOG_CODE"))
							{
							%>
							<fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("IV_PREP_YN"))
							{
							%>
							<fmt:message key="eOR.IVPrep.label" bundle="${or_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("NUM_OF_REFILLS"))
							{
							%>
							<fmt:message key="eOR.NoOfRefills.label" bundle="${or_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("PERFORM_DEPTLOC_CODE"))
							{
							%>
							<fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("SPECIMEN_DTLS"))
							{
							%>
							<fmt:message key="Common.SpecimenDetails.label" bundle="${common_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("RESULT_REVIEW"))
							{
							%>
							<fmt:message key="eCA.ReviewResults.label" bundle="${ca_labels}"/>
							<%
							}
							else if(field_mnemonic_desc.equals("CONSENT_DTLS"))
							{
							%>
							<fmt:message key="Common.ConsentDetails.label" bundle="${common_labels}"/>
							<%
							}
							/*IN062669 starts*/
							else if(field_mnemonic_desc.equals("RESULT_VIEW"))
							{
							%>
							<fmt:message key="eOR.ResultsViewed.label" bundle="${or_labels}"/>
							<%
							}
							/*IN062669 ends */
							%>
						</b>
						<!--<b><bean.checkForNull(view_details[8])></b>-->
					</td>
				</tr>
 				</tr>
<%				} %>
				<tr>
					<%
					if(field_mnemonic_desc.equals("QTY_VALUE"))
					{
						if(old_field_value!=null && !old_field_value.equals("") && Float.parseFloat(old_field_value) <1)
							old_field_value = Float.parseFloat(old_field_value) +"" ;
						if(new_field_value!=null && !new_field_value.equals("") && Float.parseFloat(new_field_value) <1)
							new_field_value = Float.parseFloat(new_field_value) +"" ;
					}					
					%> 
					<%
					if("ITEM_NARRATION".equals(field_mnemonic_desc) && "E".equals(l_instrn_type))
					{
					%>
					<td class="<%=class_value%>" ><b><font size="1"><a href ='#' onclick ='showDetails("<%=orderId%>","<%=l_order_line_num%>","<%=l_action_seq_num%>","OLD_DTL")'><fmt:message key="eOR.Detail.label" bundle="${or_labels}"/></a></font></b></td>
					<td class="<%=class_value%>" ><b><font size="1" color="green"><a href ='#' onclick ='showDetails("<%=orderId%>","<%=l_order_line_num%>","<%=l_action_seq_num%>","NEW_DTL")'><fmt:message key="eOR.Detail.label" bundle="${or_labels}"/></a></font></b></td>						
					<%}
					else
					{
					%>
					<td class="<%=class_value%>" ><b><font size="1"><%=(old_field_value==""?"&nbsp":old_field_value)%></font></b></td>
					<td class="<%=class_value%>" ><b><font size="1" color="green"><%=(new_field_value==""?"&nbsp":new_field_value)%></font></b></td>
					<%
					}
					
					%>
					<td class="<%=class_value%>" nowrap><b><font size="1" color="green"><%=(view_details[2]==""?"&nbsp":com.ehis.util.DateUtils.convertDate(view_details[2],"DMYHM","en",localeName))%></font></b></td>
					<td class="<%=class_value%>" ><b><font size="1" color="green"><%=(user_name==""?"&nbsp":user_name)%></font></b></td>
					<td class="<%=class_value%>"  align="center" nowrap>
						<%if(field_value_txt!=null && !field_value_txt.equals("")){ %>
							<!--<a class='gridLink'  href='javascript:viewRemarks("<%=orderId%>","<%=view_details[0]%>","<%=order_line_num%>")'>R</a>--IN065341 -->
							<a class='gridLink'  href='javascript:viewRemarks("<%=orderId%>","<%=view_details[0]%>","<%=order_line_num%>","<%=RepDb%>")'>R</a>
<%						} else { out.println("&nbsp");} %>
					</td>
				</tr>
				<tr>
					<td colspan="5"></td></tr>
				</tr>
<% 			
				old_field_mnemonic	 = field_mnemonic;
				old_order_category_desc = order_category_desc;
			} // End of for
 		} // End of else 	 
		/* Added By Arvind for CRF 804 @ 5/12/2010 */

		//ArrayList<Map<String,String>> clinicalNotesHistory = bean.getClinicalNotesHistory(accssion_num,facility_id,localeName);
		ArrayList<Map<String,String>> clinicalNotesHistory = bean.getClinicalNotesHistory(accssion_num,facility_id,localeName,RepDb);//IN065341
		if(clinicalNotesHistory!=null && clinicalNotesHistory.size()>0){
			%>
		<tr>
		<td class="CAFLOWSHEETLEVEL1" nowrap colspan="5"><b><fmt:message key="eCA.ClinicalNotes.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="eOR.ResultStatus.label" bundle="${or_labels}"/></td>
		</tr>
		<%
			String action_desc=""; 
			/*Set<String> clinicalNotesKey=clinicalNotesHistory.keySet();*/
			for(int records=0;records<clinicalNotesHistory.size();records++){
				Map<String,String> historyRecords=clinicalNotesHistory.get(records);
				
				/*if(historyRecords.get("ACTION_TYPE").equals("ER")){
				action_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels");
				}
			else if(historyRecords.get("ACTION_TYPE").equals("FS")|| historyRecords.get("ACTION_TYPE").equals("SP") || historyRecords.get("ACTION_TYPE").equals("SS")){
				action_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels");	
			}			
			else if(historyRecords.get("ACTION_TYPE").equals("PR"))
				action_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Recorded.label","ca_labels");
			else if(historyRecords.get("ACTION_TYPE").equals("RV"))
				action_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
				*/
				//out.println("<script>alert('"+historyRecords.get("ACTION_TYPE")+"')</script>");

		if(historyRecords.get("ACTION_DESC").equals("CO"))
			{
				if(historyRecords.get("ACTION_TYPE").equals("TR"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
				else if(historyRecords.get("ACTION_TYPE").equals("PR"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Recorded.label","ca_labels");
				else if(historyRecords.get("ACTION_TYPE").equals("RV"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
				else if(historyRecords.get("ACTION_TYPE").equals("SN"))
				{
					if(historyRecords.get("PRIVILEGE_TYPE").equals("1"))
						action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels") + " - " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
					if(historyRecords.get("PRIVILEGE_TYPE").equals("2"))
						action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels") + " - " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.forwardedForAuth.label","ca_labels");
					else
						action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Signed.label","ca_labels");
				}
				else if(historyRecords.get("ACTION_TYPE").equals("ER"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels");
				else if(historyRecords.get("ACTION_TYPE").equals("RS"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
				else if(historyRecords.get("ACTION_TYPE").equals("FS"))					
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+" "+ historyRecords.get("SPL_DESC")+" - "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reviewed.label","common_labels");
				else if(historyRecords.get("ACTION_TYPE").equals("SP"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+"-"+ historyRecords.get("REQUESTED_BY_PRACT") ;

				else if(historyRecords.get("ACTION_TYPE").equals("SS"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+" "+ historyRecords.get("SPL_DESC");

          	
			}
			else if(historyRecords.get("ACTION_DESC").equals("RQ"))
			{
				if(historyRecords.get("ACTION_TYPE").equals("RV"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingReview.label","ca_labels");
				else if(historyRecords.get("ACTION_TYPE").equals("SN"))
				{
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingSign.label","ca_labels");
				}
				else if(historyRecords.get("ACTION_TYPE").equals("RS"))
					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Response.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.received.label","common_labels");

				else if(historyRecords.get("ACTION_TYPE").equals("FS"))
					//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
					//action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ForwardTo.label","ca_labels")+" "+ specialtyDesc;

					action_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AwaitingReview.label","ca_labels")+" "+ historyRecords.get("SPL_DESC");
								
			}
				%>				
		<tr>	
		<td class="<%=class_value%>" ><b><font size="1"><%=new_field_value%></font></b></td>
		
		<td class="<%=class_value%>" ><b><font size="1" color="green"><%=action_desc%></font></b></td>
		<td class="<%=class_value%>" nowrap><b><font size="1" color="green"><%=historyRecords.get("S_ACTION_DATE_TIME")%></font></b></td>
		<td class="<%=class_value%>" ><b><font size="1" color="green"><%=historyRecords.get("CLINICIAN_NAME")%></font></b></td>
		
	</tr>
	<%	}
	}
%>
	 </table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
%>

