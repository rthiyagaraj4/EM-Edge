<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
20/09/2013    IN039096.1       Chowminya G    Services not getting listed though more than one quantity defined in the package during successive encounters	
19/10/2017	IN065324		Dinesh T		To display the price in OR screen and the billing status in Manage Specimen screen
18/11/2020    8090	    Nijitha S	       SH-ICN-0002 
---------------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eOR.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/FutureOrder.js"></script>
	<!-- <script language="JavaScript" src="../js/OrCommonFunction.js"></script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<STYLE TYPE="text/css">
       	A:link
       	 {
       	     COLOR: blue;
       	 }
     	A:visited
     	 {
             COLOR: blue ;
         }
        A:active
         {
             COLOR: red;
         }
    </STYLE>
</head>
<body  onscroll='moveFrame()'   onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//int i1=0;
	String temp="";
	//String temp1="";
	//String temp2="";
	String mode	   = "1" ;

	ArrayList Default				= null;
	String[] recordDefault			= null;
	String qty_value				= "";
	String bean_id = "Or_FutureOrder" ;
	String bean_name = "eOR.FutureOrder";
	String bean_id1 = "Or_ExistingOrder" ;
	String bean_name1 = "eOR.ExistingOrder";
	String passdate="";
	String p_encounter_id=request.getParameter("p_encounter_id");
	String p_patient_class=request.getParameter("p_patient_class");
	String p_episode_id=request.getParameter("p_episode_id");
	String p_episode_visit_num=request.getParameter("p_episode_visit_num");
	String p_source_type=request.getParameter("p_source_type");
	String p_source_code=request.getParameter("p_source_code");
	String p_patient_id=request.getParameter("p_patient_id");
		
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String keybill="";
	String resp_id = (String)session.getValue("responsibility_id");
	String pract_reln_id = (String)request.getParameter("relationship_id");
	if(resp_id== null)resp_id = "";
	if(pract_reln_id== null) pract_reln_id= "";
	if(p_encounter_id== null) p_encounter_id= "";
	if(p_patient_class== null) p_patient_class= "";
	if(p_episode_id== null) p_episode_id= "";
	if(p_episode_visit_num== null) p_episode_visit_num= "";

	String security_level = "";
	security_level = (String)session.getValue("security_level");
	if(security_level == null)
		security_level  = "1"; // needs to be replaced with session values
	
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String called_from		= request.getParameter("called_from");
	String orderId		= request.getParameter("orderId");
	String order_line_num		= request.getParameter("order_line_num");
	String total_query_records  = "0";

	HashMap bill_dtls				= null;
	HashMap setBills_dtls			= null;
	String[] billing_details 		= null;
	ArrayList BillChargeInfo		= null;
	
	if(p_source_type == null || p_source_type.equals("null")) p_source_type =""; else p_source_type = p_source_type.trim();
	if(p_source_code == null || p_source_code.equals("null")) p_source_code =""; else p_source_code = p_source_code.trim();
	if(called_from == null || called_from.equals("null")) called_from =""; else called_from = called_from.trim();
	if(orderId == null || orderId.equals("null")) orderId =""; else orderId = orderId.trim();
	if(p_patient_id == null || p_patient_id.equals("null")) p_patient_id =""; else p_patient_id = p_patient_id.trim();
	if(order_line_num == null || order_line_num.equals("null")) order_line_num =""; else order_line_num = order_line_num.trim();
	
	//if(p_encounter_id.length()>8)
	//{
		//p_encounter_id=p_encounter_id.substring(0,p_encounter_id.length()-4);
	//}
	
	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(total_recs== null) total_recs="" ;
	if(period_from== null) period_from="" ; else period_from = period_from.trim();
	if(period_to== null) period_to="" ; else period_to = period_to.trim();
	
	String bean_id2 = "@orderentrybean"+p_patient_id+p_encounter_id;
	String bean_name2 = "eOR.OrderEntryBean";
	FutureOrder bean = (FutureOrder)getBeanObject( bean_id, bean_name, request  ) ;
	ExistingOrder bean1 = (ExistingOrder)getBeanObject( bean_id1, bean_name1, request   ) ;
	bean.setLanguageId(localeName);
	bean1.setLanguageId(localeName);
	OrderEntryBean bean2				= (OrderEntryBean)getBeanObject( bean_id2, bean_name2, request ) ;
	bean2.setLanguageId(localeName);
	OrderEntryBillingQueryBean bean_qryobj				= (OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;
	bean.setOrderEntryBillBean(bean_qryobj);

	eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
	
	String slClassValue = "";
	String billing_interface_yn		= bean2.getBillingInterfaceYn();
	String billing_call_yn			= "N";
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
	int start = Integer.parseInt(from);
 	int end   = Integer.parseInt(to);
	//int no_of_records = 0;
	
 
 	//bean.clear() ;
	bean.setMode( mode ) ;
	ArrayList FutureDetail = new ArrayList();

	FutureDetail = bean.getFutureOrderDetails( facility_id,start,end,p_patient_id,called_from,orderId,p_encounter_id) ;
	boolean show_bill_dtls = false;//IN065324
	bean.setSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	boolean is_bt_view_bill_dtls = bean.isSiteSpecific("BT_VIEW_BILL_DTLS");//IN065324
	
%>
<form name='future_order_dtl' id='future_order_dtl'  action="../../eOR/jsp/FutureOrderBottomRightDtl.jsp" method="post">
<table cellpadding=3 cellspacing=0 border=1 width="100%" align="" id="tableresult" class="grid">
		<%
		String tmp_ord_cat = "";
		String tmp_urgency = "";
 		String cont_order_ind = "";
		String ord_appr_by_user_id = "";
		String ord_appr_reqd_yn = "";
		String order_category = "";
		String ord_consent_reqd_yn = "";
		String ord_consent_by_id = "";
		String encounter_dtls="";
		String location="";
				
		String privilege_yn			= "N"; String chkdisabled= "";//,unbilled_yn="";
		String billing_package_ref = "";//IN039096.1
		int i = 0;
		TreeMap FutureOrder = (TreeMap)bean.getFutureOrder();
	
		for( int k=0 ; k< FutureDetail.size() ; k++ ) 
		{
			String billinginterface="";
			String servicepanel="";
			String incl_action="";
			String incl_action_reason="";
			String servicepanelcode="";
			String finbill="";
			String displaytooltip="";
			int numbering=0;
		
			/*if(i1% 2 == 0)
			{
					slClassValue = "QRYEVEN";
			}else{
					slClassValue = "QRYODD";
			}*/
			slClassValue="gridData";	
			String[] future_record = (String[])FutureDetail.get(k);
			
			if(k==0)
			{
				//if(future_record[33] != null) //IN039096.1 index 32 to 33//8090
				if(future_record[35] != null) //IN039096.1 index 33 to 35//8090
					total_query_records = bean.checkForNull((String)future_record[35],"0"); //IN039096.1 index 32 to 33//8090
			
					
				%>
					<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from" value= "<%=start%>" /> 
					<jsp:param name ="to" value= "<%=end%>" />	
					<jsp:param name ="total_size" value= "<%=total_query_records%>" />   
					<jsp:param name ="check_box_name" value= "chk" />					 
					<jsp:param name ="form_name" value= "future_order_dtl" />  
					</jsp:include>				
				<%
						
			}
				
			if(bean.checkForNull(future_record[11],"").equalsIgnoreCase("C"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(bean.checkForNull(future_record[11],"").equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}else if(bean.checkForNull(future_record[11],"").equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}

			encounter_dtls=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+bean.checkForNull(future_record[7],"")+","+location+"/"+bean.checkForNull(future_record[31],"");

			if(!(temp.equals(encounter_dtls)))
			{
				out.println("<tr><td class=OAGREEN colspan=6>"+encounter_dtls+"</td>");
				temp=encounter_dtls;
			}
			order_category           = (String)bean.checkForNull(future_record[0],"");
			cont_order_ind           = (String)bean.checkForNull(future_record[20],"");
			ord_appr_by_user_id = (String)bean.checkForNull(future_record[22],"");
			ord_appr_reqd_yn      = (String)bean.checkForNull(future_record[21],"");
			ord_consent_reqd_yn = (String)bean.checkForNull(future_record[23],"");
			ord_consent_by_id     = (String)bean.checkForNull(future_record[24],"");
			privilege_yn                = (String)bean.checkForNull(future_record[25],"");
			//unbilled_yn                = (String)bean.checkForNull(future_record[32],"");
			billing_package_ref          = (String)bean.checkForNull(future_record[32],"");//IN039096.1
			 
			 
			 
			 Default = bean.getPlaceOrderDefault(bean.checkForNull(future_record[27],""),p_patient_class);
			 for(int j=0;j<Default.size();j++)
			{
				recordDefault	 = ((String[])Default.get(j));
				if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
 				if(recordDefault!=null)
				{
					qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
					if(qty_value.equals("0"))
					{ 
						qty_value = "1";
					}
				}
				else
				{
					qty_value	 = "1"; 
				}
			}
			
			chkdisabled  = "";
			if(((FutureDetail.size())==1)&&(from.equals("1")))
			{
				chkdisabled = "checked disabled";
			}
			else if(future_record[5].equalsIgnoreCase(order_line_num))
			{
				chkdisabled = "checked";
			}
			
			
	
				//the following 2 if conditions are used to display in "group BY"
				//format of order category or urgency
			if(!(tmp_ord_cat.equals(bean.checkForNull(future_record[1],""))) && (!(order_by.equals(" ") ||(order_by.equals("P")))))
			{
				out.println("<tr><td class=columnheader colspan=6>"+bean.checkForNull(future_record[1],"")+"</td>");
				tmp_ord_cat = bean.checkForNull(future_record[1],"");
					
			}
			if(!(tmp_urgency.equals(bean.checkForNull(future_record[2],""))) && (!(order_by.equals(" ") ||(order_by.equals("O")))))
			{
				out.println("<tr><td class=columnheader colspan=6 >"+bean.checkForNull(future_record[2],"")+"</td>");
				tmp_urgency = bean.checkForNull(future_record[2],"");
					
			}
		%>

			<tr><%
				String check_box = "";
				//if(!(temp1.equals((String)bean.checkForNull(future_record[25],""))))
			//	{
				//	i1++;
				if(FutureOrder.containsKey(future_record[25]+future_record[5]))
				{
					 check_box = "checked";
				}
				else
				{
					check_box  = "";
				}
				%>
					<td  width='150' id='status<%=i%>' class='<%=slClassValue%>'><input type=checkbox name='chk<%=i%>' id='chk<%=i%>' <%=chkdisabled%> <%=check_box%> onclick='selectedRow()'></td>
					<%
					//temp1=(String)bean.checkForNull(future_record[25],"");
					//temp2=slClassValue;
				//}else
				//{
					//slClassValue=temp2;
				%>
					<!-- <td class='<%=slClassValue%>' width='150'></td> -->
				<%
				//}
				%>

				
				<td width='' class='<%=slClassValue%>'><font size=1><%=future_record[25]%></font></td>
				

				<%
					

				if (future_record[8] == null || future_record[8] == "null") future_record[8]="";
				passdate=com.ehis.util.DateUtils.convertDate(future_record[8],"DMYHM","en",localeName);
				%>
				<td width='' class='<%=slClassValue%>'><font size=1><%=com.ehis.util.DateUtils.convertDate(future_record[8],"DMYHM","en",localeName)%></td> <!--  date of ordered AT -->
				<td width='' class='<%=slClassValue%>'><font size=1><%=future_record[1]%></td>
				<td width='' class='<%=slClassValue%>' ><font size=1>

				<a class='gridLink' href='#'  onClick="callMenuFunctions('View','<%=future_record[1]%>','<%=future_record[25]%>','<%=future_record[18]%>','<%=p_patient_id%>','<%=p_encounter_id%>','<%=p_patient_class%>')" >
				<%=future_record[9]%>
	
				</a></td><!--  data of ordered Catalogs -->
			
				</tr>
				<%
				//IN065324, starts
				if(is_bt_view_bill_dtls && "BT".equals(future_record[29].trim()) && ("OP".equals(p_patient_class) || "EM".equals(p_patient_class)) || !"BT".equals(future_record[29].trim()))
				{
					show_bill_dtls = true;
				}
				//IN065324, ends

				//if(future_record[26].equals("Y")&&billing_interface_yn.equals("Y")&&!future_record[29].equals("BT"))//IN065324
				if(future_record[26].equals("Y")&&billing_interface_yn.equals("Y") && show_bill_dtls)//IN065324
				{
				%>
					<tr><td class="<%=slClassValue%>" width='' >
	 				<td  id="billing12<%=i%>" class="<%=slClassValue%>" align="left" style="border-right-width:0" colspan=3>
					<%					
					
					//if(billing_interface_yn.equals("Y") && future_record[26].equals("Y")&& !future_record[29].equals("BT"))//IN065324
					if(billing_interface_yn.equals("Y") && future_record[26].equals("Y") && show_bill_dtls)//IN065324
					{
						
						billinginterface="interface";
						billing_call_yn		= "Y";
						//8090 Starts
						//BillChargeInfo		= orderEntryBillBean.getBillChargeDetails(future_record[28],future_record[27],future_record[30], localeName,"", "",p_patient_id,p_encounter_id,p_patient_class,future_record[16]) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
						if("Y".equals(future_record[33])){
							BillChargeInfo		= orderEntryBillBean.getBillChargeDetailsfpp(future_record[28],future_record[27],future_record[30], localeName,"", "",p_patient_id,p_encounter_id,p_patient_class,future_record[16],future_record[33],future_record[34]) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
						}
						else
						{
							BillChargeInfo		= orderEntryBillBean.getBillChargeDetails(future_record[28],future_record[27],future_record[30], localeName,"", "",p_patient_id,p_encounter_id,p_patient_class,future_record[16]) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
						}//8090 Ends
						if(BillChargeInfo!=null)
						{
							for( int kb=0 ; kb< BillChargeInfo.size() ; kb++ ) 
							{
								billing_details 	= (String[])BillChargeInfo.get(kb);
							
								setBills_dtls		= new HashMap();
		
								setBills_dtls.put("charged_yn"       , billing_details[1]);
								setBills_dtls.put("total_payable"    , billing_details[2]);
								setBills_dtls.put("patient_payable"  , billing_details[3]);
								setBills_dtls.put("quantity"         , qty_value);
								setBills_dtls.put("incl_excl_action" , billing_details[4]);
								setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
								setBills_dtls.put("preapp_yn"        , billing_details[5]);
								setBills_dtls.put("patient_paid_amt" , billing_details[6]);
								setBills_dtls.put("bl_panel_str"     , billing_details[0]);
								setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
								setBills_dtls.put("serv_panel_code"  , billing_details[11]);
								setBills_dtls.put("p_episode_type"	 , billing_details[13]);
								setBills_dtls.put("p_episode_id"	 , billing_details[14]);
								setBills_dtls.put("p_visit_id"		 , billing_details[15]);
								setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
								setBills_dtls.put("error_text"		 , billing_details[9]);
								setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
								setBills_dtls.put("rate"		 ,"");
								setBills_dtls.put("fpp_yn"		 , future_record[33]);//8090
								setBills_dtls.put("fpp_category"		 , future_record[34]);//8090
								servicepanel=bean.checkForNull(billing_details[10],"");
								servicepanelcode=bean.checkForNull(billing_details[11],"");
								incl_action=bean.checkForNull(billing_details[16],"");
																
								orderEntryBillBean.setOrderBillDtls(p_patient_id+p_encounter_id+future_record[27], setBills_dtls); 
								if(!billing_details[9].equals(""))
								{
									numbering=1;finbill="Billing";
								%>

									<script>
									alert("405");	
									alert("<%=billing_details[9]%>");
										selectedrecorddisable("<%=i%>");
										//displaycolor("<%=i%>");
										//window.close();
									</script>

								<% displaytooltip=billing_details[9];
								} 								
								if(servicepanel.equals("")&&servicepanelcode.equals(""))
								{
									numbering=1;
						
								%>

									<script>
										var msg=getMessage("BILLING_SERVICE_NOT_DEFINED","OR");
										msg=msg.replace('{1}',"<%=future_record[27]%>");
										alert(msg);
										selectedrecorddisable("<%=i%>");
										//displaycolor("<%=i%>");
										//window.close();
									</script>
								<% 						                
									displaytooltip=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
									displaytooltip=displaytooltip.replace("{1}",future_record[27]);
								}
							}
						}
						bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(p_patient_id+p_encounter_id+future_record[27]);
			
						keybill=p_patient_id+p_encounter_id+future_record[27];	
						incl_action_reason=bean.checkForNull((String)bill_dtls.get("incl_excl_action_reason"),"");
					
						%>
						<table cellpadding=0 cellspacing=0 border=1 width='100%' align='center' style='border-width:0'>
						<tr >
						<td colspan="" width='10%'  class="<%=slClassValue%>" style='border-width: 0;'><font class='label' size="1"><B><fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
						<td colspan="" width='20%'  class="<%=slClassValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
						<td colspan=""  width='20%' class="<%=slClassValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/></B></font></td>
						<%
						if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						%>
							<td colspan="" width='25%'  class="<%=slClassValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="Common.Included.label" bundle="${common_labels}"/></B></font></td>
							<td colspan="" width='25%'  class="<%=slClassValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><B><fmt:message key="eOR.ApprovalReqd.label" bundle="${or_labels}"/></B></font></td>
						<%
						}
						%>
						</tr>
						<tr>
						<td colspan="" class="<%=slClassValue%>"  style='border-width: 0;text-align: right;'  nowrap><font class='fields' size="1"><span id='bill_now_<%=i%>' style='visibility:hidden'><fmt:message key="eOR.BillLater.labe" bundle="${or_labels}"/><input type="checkbox" name='bill_now_check<%=i%>' id='bill_now_check<%=i%>'value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>" onclick="changeBillNow(this,'<%=i%>')" ></span></font></td>
						<td colspan=""  class="<%=slClassValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='actual_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span></font></td>
						<td colspan=""  class="<%=slClassValue%>" style='border-width: 0;text-align: right;'><font class='label' size="1"><span id='payable_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span></font></td>
						<%
						if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						%>
							<td colspan="" class="<%=slClassValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='included_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")%></span></font></td>
							<td colspan="" class="<%=slClassValue%>" style='border-width: 0;text-align: center;'><font class='label' size="1"><span id='approved_<%=i%>'><%=bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")%></span></font></td> 
						<%
						}
						%>
						</tr>
						
						<input type="hidden" name="bill_now<%=i%>" id="bill_now<%=i%>" value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>">
						<input type="hidden" name="bill_now_check_Df<%=i%>" id="bill_now_check_Df<%=i%>" value="<%=bean.checkForNull((String)bill_dtls.get("Future_order_yn"),"")%>">
						<input type="hidden" name="future_date<%=i%>" id="future_date<%=i%>"  value="<%=billing_details[18]%>" >
						</table>
                    <%
					} 
					else
					{ 
									
						billing_call_yn = "N";
						out.println("&nbsp;");
					}
				
					%>					
					</td>
				
					<td class="<%=slClassValue%>" id="order<%=i%>" style="border-left-width:0;text-align: center;" ><font size="1">
					<%
					//if(billing_interface_yn.equals("Y") && future_record[26].equals("Y")&& !future_record[29].equals("BT"))//IN065324
					if(billing_interface_yn.equals("Y") && future_record[26].equals("Y") && show_bill_dtls)//IN065324
					{
						billing_call_yn		= "Y";
					%>
						<a class='gridLink'  href="javascript:callReviseBilling('<%=i%>','NEW_ORDER','<%=p_patient_id%>','<%=p_encounter_id%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("serv_panel_code"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_type"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_episode_id"),"")%>','<%=bean.checkForNull((String)bill_dtls.get("p_visit_id"),"")%>','','','<%=future_record[16]%>','<%=keybill%>')" title='Charge Details'> <fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/> <!--View / Edit	 -->
						</a>

					<%
					} 
					else
					{
						billing_call_yn = "N"; 
					}
					%>

					</font></td>
				<%
				}
				else
				{
					billing_call_yn = "N";
				}
			   %>
				<input type="hidden" name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=bean.checkForNull(future_record[13],"")%>">
				<input type="hidden" name='order_category<%=i%>' id='order_category<%=i%>' value="<%=order_category%>">
				<input type="hidden" name='ord_status<%=i%>' id='ord_status<%=i%>' value="<%=bean.checkForNull(future_record[14],"")%>">
				<input type="hidden" name='ord_consent_yn<%=i%>' id='ord_consent_yn<%=i%>' value="<%=bean.checkForNull(future_record[15],"")%>">
				<input type="hidden" name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=bean.checkForNull(future_record[25],"")%>">
				<input type="hidden" name="patient_class<%=i%>" id="patient_class<%=i%>" value="<%=bean.checkForNull(future_record[4],"")%>">
				<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>" value="<%=bean.checkForNull(future_record[6],"")%>">
				<input type="hidden" name="priority<%=i%>" id="priority<%=i%>" value="<%=bean.checkForNull(future_record[10],"")%>">
			    <!-- <input type="hidden" name="location_type<%=i%>" id="location_type<%=i%>" value="<%=future_record[18]%>"> -->
				<input type="hidden" name="date_of_birth<%=i%>" id="date_of_birth<%=i%>" value="<%=bean.checkForNull(future_record[17],"")%>">
				<input type="hidden" name="sex<%=i%>" id="sex<%=i%>" value="<%=bean.checkForNull(future_record[18],"")%>">
				<input type="hidden" name="age<%=i%>" id="age<%=i%>" value="<%=bean.checkForNull(future_record[19],"")%>"> 
				<input type="hidden" name="ord_catalog<%=i%>" id="ord_catalog<%=i%>" value="<%=bean.checkForNull(future_record[9],"")%>">
				<input type="hidden" name="cont_order_ind<%=i%>" id="cont_order_ind<%=i%>" value="<%=cont_order_ind%>">
				<input type="hidden" name="ord_appr_by_user_id<%=i%>" id="ord_appr_by_user_id<%=i%>" value="<%=ord_appr_by_user_id%>">
				<input type="hidden" name="ord_appr_reqd_yn<%=i%>" id="ord_appr_reqd_yn<%=i%>" value="<%=ord_appr_reqd_yn%>">
				<input type="hidden" name="ord_consent_by_id<%=i%>" id="ord_consent_by_id<%=i%>" value="<%=ord_consent_by_id%>">
				<input type="hidden" name="ord_consent_reqd_yn<%=i%>" id="ord_consent_reqd_yn<%=i%>" value="<%=ord_consent_reqd_yn%>">
				<input type="hidden" name="start_date_time<%=i%>" id="start_date_time<%=i%>" value="<%=bean.checkForNull(future_record[30],"")%>">
				<input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>" value="<%=bean.checkForNull(future_record[27],"")%>">
				<input type="hidden" name="catalog_desc<%=i%>" id="catalog_desc<%=i%>" value="<%=bean.checkForNull(future_record[9],"")%>">
				<input type="hidden" name="quantity<%=i%>" id="quantity<%=i%>" value="<%=bean.checkForNull(future_record[28],"")%>">
				<input type="hidden" name="ord_pract_id<%=i%>" id="ord_pract_id<%=i%>" value="<%=bean.checkForNull(future_record[16],"")%>">
				<input type="hidden" name="billing_call_yn<%=i%>" id="billing_call_yn<%=i%>" value="<%=billing_call_yn%>">
				<input type="hidden" name="servicepanelind<%=i%>" id="servicepanelind<%=i%>" value="<%=servicepanel%>">
				<input type="hidden" name="incl_excl_action<%=i%>" id="incl_excl_action<%=i%>" value="<%=incl_action%>">
				<input type="hidden" name="bill_yn<%=i%>" id="bill_yn<%=i%>" value="<%=bean.checkForNull(future_record[26],"")%>">
				<input type="hidden" name="contr_mod_id<%=i%>" id="contr_mod_id<%=i%>" value="<%=bean.checkForNull(future_record[29],"")%>">
				<input type="hidden" name="order_line_num<%=i%>" id="order_line_num<%=i%>" value="<%=bean.checkForNull(future_record[5],"")%>">
				<input type="hidden" name="incl_excl_action_reason<%=i%>" id="incl_excl_action_reason<%=i%>" value="<%=incl_action_reason%>">
				<input type="hidden" name="servicepanelcode<%=i%>" id="servicepanelcode<%=i%>" value="<%=servicepanelcode%>">
				<input type="hidden" name="bill_dtls<%=bean.checkForNull(future_record[25],"")%><%=bean.checkForNull(future_record[5],"")%>" id="bill_dtls<%=bean.checkForNull(future_record[25],"")%><%=bean.checkForNull(future_record[5],"")%>" value="<%=bill_dtls%>">
				<input type="hidden" name="billing_package_ref<%=i%>" id="billing_package_ref<%=i%>" value="<%=bean.checkForNull(future_record[32],"")%>"><!-- IN039096.1 -->
				</tr>
			
		<%
			i++;
			}
			if((FutureDetail.size())==0)
			{
		%>
				<script>
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
						history.go(-1);
				</script>
		<%
			}
		%>

		<tr style='visibility:hidden'>
		<td class='columnheader' width='150'><input type=checkbox name='select_all' id='select_all' onClick='clickAll()'><fmt:message key="eOR.Linktocurrentencounter.label" bundle="${or_labels}"/></td>
		<td class="columnheader" width=''><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width=''><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
		<td class="columnheader" width=''><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class="columnheader" width=''><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></td>
		</tr>
	
</table>
<!-- Next, Prev --> 
<input type="hidden" name="from" id="from" value="<%=from%>" >
<input type="hidden" name="to" id="to" value="<%=to%>" >
<!-- Next, Prev Till here--> 
<%--<input type=hidden name='total_recs' id='total_recs' value='<%//=FutureDetail.size()%>'>--%>
<input type=hidden name='total_recs' id='total_recs' value='<%=i%>'>
<input type="hidden" name="p_source_type" id="p_source_type" value="<%=p_source_type%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<input type="hidden" name="security_level" id="security_level" value="<%=security_level%>">
<input type="hidden" name="relationship_id" id="relationship_id" value="<%=pract_reln_id%>">


<input type="hidden" name="p_source_code" id="p_source_code" value="<%=p_source_code%>">
<input type="hidden" name="priority" id="priority" value="<%=priority%>">
<input type="hidden" name="ord_cat" id="ord_cat" value="<%=ord_cat%>">
<input type="hidden" name="order_by" id="order_by" value="<%=order_by%>">
<input type="hidden" name="ord_cat_desc" id="ord_cat_desc" value="<%=ord_cat_desc%>">

<input type="hidden" name="p_patient_id" id="p_patient_id" value="<%=p_patient_id%>">
<input type="hidden" name="p_episode_id" id="p_episode_id" value="<%=p_episode_id%>">
<input type="hidden" name="p_encounter_id" id="p_encounter_id" value="<%=p_encounter_id%>">
<input type="hidden" name="p_episode_visit_num" id="p_episode_visit_num" value="<%=p_episode_visit_num%>">
<input type="hidden" name="p_patient_class" id="p_patient_class" value="<%=p_patient_class%>">

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="bean_id2" id="bean_id2" value="<%=bean_id2%>">
<input type="hidden" name="bean_name2" id="bean_name2" value="<%=bean_name2%>">

<input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
  
<input type="hidden" name="help_function_id" id="help_function_id" value="FUTURE_ORDERS">
<input type="hidden" name="querystring" id="querystring" value="<%=request.getQueryString()%>">
<input type="hidden" name="recordedSize" id="recordedSize" value="<%=FutureOrder.size()%>">
<script>
	if(parent.frames[1].document.getElementById('tableheader')==null)
	{
		setTimeout("alignHeading();",300);
	}
	else 
		alignHeading();
</script>
<div id='descLink' style='position:absolute; visibility:hidden;overflow:overflow' ></div>
</form>
</body>
<script>
setTimeout("selectHeader();",100);
function selectHeader()
{
	if((<%=FutureDetail.size()%>==1)&&(<%=from%>=="1"))
	{
		if(parent.future_order_btn.future_order_btn)
		{
			parent.future_order_btn.future_order_btn.FutureOrderConfirm.value=getLabel("Common.confirm.label","common");
			parent.future_order_btn.future_order_btn.FutureOrderConfirm.name="Confirm";
			selectedRow();
			parent.future_order_hdr.document.future_order_hdg.select_all.checked = true;
			parent.future_order_hdr.document.future_order_hdg.select_all.disabled = true;

		}
	}
}
</script>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

