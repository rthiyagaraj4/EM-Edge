<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- 
-----------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Description
-----------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
28/10/2011    	IN029395      	Chowminya G     IncNo:IN029395-<system default preferred surgery date issue> 
04/11/2011    	IN029518         Akbar			IncNo:IN29518-Increased max length from 1 to 3 for the prompt
												"Period to Modify Completed-Results"
03/01/2012	  	IN028417		Menaka V		The registered lab samples can be discontinued from CA-OR even though
												the discontinuation reasons are not defined for lab module.
01/12/2013		IN038787		Ramesh G		Bru-HIMS-CRF-358	
-----------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
-----------------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Karthi L	  ?			  ?		An Audit Trail for Additional Information Amendment of Order
06/10/2015		IN055737		Karthi L	  ?			  ?		IN055737 HSA-CRF-0250.1 - Dispatch Slip
21/10/2015		IN057196		Ramesh G	  ?			  ?		Recording Of Consent Form
07/07/2016		IN059086		Karthi L	  ?			  ?		ML-MMOH-CRF-0493 [IN059086]
26/11/2016		IN062319		Karthi L	  ?			  ?		ML-MMOH-CRF-0508.1 [IN062319] 
22/11/2017		IN061890		Kamalakannan G	29/11/2017		Ramesh G	ML-MMOH-CRF-0542 [IN061890]					
05/12/2017		IN065925		Kamalakannan G  	05/12/2017      Ramesh G		PMG2017-GHL-CRF-0006 [IN065925]
18/04/2018      IN064980        RamyaMaddena   18/04/2018       Ramesh G 		  ML-MMOH-CRF-956[IN064980]	
28/05/2018  IN066548        Kamalakannan   28/05/2018       Ramesh G 	    ML-MMOH-CRF-1076[IN066548]	
08/10/2018	  IN063719		Kamalakannan 	08/10/2018	Ramesh G		GHL-CRF-0419
25/01/2019    IN068673    DineshT           25/01/2019    Ramesh G      ML-MMOH-CRF-1263
15/08/2020		IN071361	Nijitha S	15/08/2020	Ramesh G	AAKH-CRF-0116
28/02/2022      IN27705         Suji Keerthi.G  28/02/2022  Ramesh G   SKR-CRF-0052     
-----------------------------------------------------------------------------------------------------------------------
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %> <!--  commented for IN061890-->
<%@page  import="java.util.*, eOR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!--added for IN061890-->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>

<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/OrParameter.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!--     -->
<body onLoad="loadEnableDisable()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	

	
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;	
	String bean_id = "Or_or_parameter" ;
	String bean_name = "eOR.OrParameterBean";
	//String[] allValues = new String[13];
//	String[] allValues = new String[19]; - commented for IN049419
	//String[] allValues = new String[22];//IN049419 -  // ML-MMOH-CRF-0508.1 [IN062319] 
//	String[] allValues = new String[26];  // ML-MMOH-CRF-0508.1 [IN062319] 
//	String[] allValues = new String[27];  //IN061890// commented for IN065925
	//String[] allValues = new String[28];//IN065925
	//String[] allValues = new String[29];//IN064980//commented for IN063719
	//String[] allValues = new String[30];//IN063719 //Commented for IN27705
	String[] allValues = new String[32]; //IN27705
	String ord_category		= "";
	String ord_type			= "";	
	String pin_by_ord_type	= "";
	String co_sign_rule		= "";
	String order_hrs		= "";
	String order_future_hrs_ahead="";
	String results_hrs		= "";
	String update_order		= "";
	/* Added By kishore kumar N, For the CRF 640*/
	String lnkFutureOrCrrEcntYn = "";
	String ReasonCodeHoldDisYN = "";//IN028417
	/* Ends here.*/
	/* Added By Uma, For the CRF 641*/
	String lnkOrderAuthorisationYn = "";
	String lnkOrderingYn = "";
	/* Ends here.*/
	
	/* Added By Uma, For the CRF 804*/
	String by24_hrs		= "";
	String completed_result		= "";
	String restrictCompNoteYn = "";
	String result						  = "";
	String group_title				  = "";
	/* Ends here.*/


	String surgery_ahead_days = "";//--[IN029395]--
	String ord_displayVerticalYN = "";//[IN038787]
	//IN049419 - Start
	String amendAuditReqdYN = "";
	String amendReasonYN = ""; 
	String amendReasonMandatYN = "";
	//IN049419 - End
	String allow_specimen_barcode_search_yn = ""; //IN055737 HSA-CRF-0250.1 
	String recConsetWithOrderYN	=""; //IN057196
	String auth_ord_priv_rule_only_yn = "N"; //ML-MMOH-CRF-0493 [IN059086]
	String ord_formt_multi_list_mand_yn = "N";  // ML-MMOH-CRF-0508.1 [IN062319] 	
	String ord_repl_thro_termset_yn = "N"; //IN061890	
	String can_option_inactive_ord_yn = "N";//IN065925
	String Dis_Select_All_Option_yn   = "N"; //IN064980
	String restrictAE_Encounters_yn = "N"; //IN063719
	String def_order_status = "",def_order_check_all="",def_order_check_act=""; //IN27705
	

/* Mandatory checks end */
	String l_pend_auth_include_sec_splty = "N";//IN068673
	/* Initialize Function specific start */
	/*IN061890 starts*/
	String pract_type_time_based_yn = "N";//IN071361
	boolean isSiteSpecific  = false;
	boolean isDfltOrderSts  = false; //IN27705
	Connection con = null;
	try{
	con = ConnectionManager.getConnection();
	//isSiteSpecific = true;
	isSiteSpecific = CommonBean.isSiteSpecific(con, "OR","ORD_REPL_THRO_TERMSET");
	isDfltOrderSts = CommonBean.isSiteSpecific(con, "OR","DEFAULT_ORDER_STATUS"); //IN27705
	}
	 catch(Exception e) {
        System.out.println("error:"+e.getMessage());
		e.printStackTrace();
    }
	finally {
		if(con != null)
			con.close();
	}
	/*IN061890 ends*/
	OrParameterBean bean = (OrParameterBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	int recordExists = bean.checkForMode();
	if(recordExists == 0){
		mode = "1";
	}

			if(mode.equals("2")){
									allValues  = bean.getValues();
									ord_category							= allValues[0];
									ord_type									= allValues[1];									
									pin_by_ord_type					= allValues[2];
									co_sign_rule							= allValues[3];
									order_hrs								= allValues[4];
									order_future_hrs_ahead		= allValues[5];
									results_hrs								= allValues[6];
									update_order						= allValues[7];
									lnkFutureOrCrrEcntYn						= allValues[10]==null?"":allValues[10];
									lnkOrderingYn						= allValues[11]==null?"N":allValues[11];
									lnkOrderAuthorisationYn						= allValues[12]==null?"N":allValues[12];
									/*Added by Arvind on 4/19/2010 for CRF 804*/
									restrictCompNoteYn						= allValues[13]==null?"N":allValues[13];			
									completed_result						= allValues[14]==null?"":allValues[14];
									by24_hrs								= allValues[15]==null?"N":allValues[15];
									ReasonCodeHoldDisYN	= allValues[16]==null?"N":allValues[16];//IN028417
									surgery_ahead_days						= allValues[17]==null?"":allValues[17]; //--[IN029395]--//IN028417
									ord_displayVerticalYN					= allValues[18]==null?"N":allValues[18];
									/*Ends Here*/
									amendReasonYN						=	allValues[19]==null?"N":allValues[19]; //IN049419
									amendReasonMandatYN					=	allValues[20]==null?"N":allValues[20]; //IN049419
									amendAuditReqdYN					=	allValues[21]==null?"N":allValues[21]; //IN049419
									allow_specimen_barcode_search_yn	=	allValues[22]==null?"N":allValues[22]; //IN055737 HSA-CRF-0250.1
									recConsetWithOrderYN				=	allValues[23]==null?"N":allValues[23]; //IN057196
									auth_ord_priv_rule_only_yn			= 	allValues[24]==null?"N":allValues[24]; //ML-MMOH-CRF-0493 [IN059086]
									ord_formt_multi_list_mand_yn		= 	allValues[25]==null?"N":allValues[25];  // ML-MMOH-CRF-0508.1 [IN062319] 
									ord_repl_thro_termset_yn			=	allValues[26]==null?"N":allValues[26];	//IN061890
									can_option_inactive_ord_yn			=   allValues[27]==null?"N":allValues[27];  //IN065925
									Dis_Select_All_Option_yn            =   allValues[28]==null?"N":allValues[28];  //IN064980
									restrictAE_Encounters_yn			=	allValues[29]==null?"N":allValues[29];  //IN063719
									l_pend_auth_include_sec_splty = allValues[30]==null?"N":allValues[30];//IN068673
									pract_type_time_based_yn 	=	allValues[31]==null?"N":allValues[31];//IN071361
									def_order_status = allValues[32]==null?"ACT":allValues[32]; //IN27705
									
									if(order_hrs == null)order_hrs = "";
									if(results_hrs == null)results_hrs = "";
									if(update_order == null)update_order = "";
									if(order_future_hrs_ahead==null)order_future_hrs_ahead="";
									if(pin_by_ord_type==null)pin_by_ord_type="";														
			}
	//IN27705 Start
	 if(def_order_status.equals("ALL"))
		 def_order_check_all ="checked";
	 else 
		 def_order_check_act ="checked";
    //IN27705 End
	ArrayList update_orders = new ArrayList();
	/* Initialize Function specific end */
	bean.setMode( mode ) ;
%>
<form name="or_parameter" id="or_parameter" target="messageFrame">
<table cellpadding=3 cellspacing=0 width="100%" border=0 align=center>
<tr>
	<td class='columnheader' colspan=2><fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td width='50%' class="label" ><fmt:message key="eOR.PreselectOrderCategory.label" bundle="${or_labels}"/> </td>
	<td class='fields'><INPUT TYPE="checkbox" name="ord_category" id="ord_category"   onClick="enableDisable()" <%if(ord_category.equals("Y")){out.println(" checked ");}%>  ></td>
</tr>
<tr>
	<td class="label" ><fmt:message key="eOR.OrderTypebyClass.label" bundle="${or_labels}"/></td>
	<td class='fields'><INPUT TYPE="checkbox" name="ord_type" id="ord_type"  <%if(ord_type.equals("Y")){out.println(" checked ");}%>  ></td>
</tr>
<!-- [IN038787] Start. -->
<tr>
	<td class="label" ><fmt:message key="eOR.OrderSearchResultDisplayinVerticalOrder.label" bundle="${or_labels}"/></td>
	<td class='fields'><INPUT TYPE="checkbox" name="ord_displayVerticalYN" id="ord_displayVerticalYN"  <%if(ord_displayVerticalYN.equals("Y")){out.println(" checked ");}%>  ></td>
</tr>
<!-- [IN038787] End.  -->
<!-- [IN057196] Start. -->
<tr>
	<td class="label" ><fmt:message key="eOR.recordConsentFormWithOrder.label" bundle="${or_labels}"/></td>
	<td class='fields'><INPUT TYPE="checkbox" name="recConsetWithOrderYN" id="recConsetWithOrderYN"  value="<%=recConsetWithOrderYN %>" <%if(recConsetWithOrderYN.equals("Y")){out.println(" checked ");}%>  ></td>
</tr>

<!-- IN063719 start-->
<tr>
	<td class="label" ><fmt:message key="eOR.RestrictAEEncounters.label" bundle="${or_labels}"/></td>
	<td class='fields'><INPUT TYPE="checkbox" name="restrictAE_Encounters_yn" id="restrictAE_Encounters_yn"  value="<%=restrictAE_Encounters_yn %>" <%if(restrictAE_Encounters_yn.equals("Y")){out.println(" checked ");}%> onclick='enablerestrictAE_Encounters(this)' ></td>
</tr>
<!-- IN063719 end-->

<!-- IN071361 start-->
<tr>
	<td class="label" ><fmt:message key="eOR.PractTypeTimeBasedRule.label" bundle="${or_labels}"/></td>
	<td class='fields'><INPUT TYPE="checkbox" name="time_based_rule_yn" id="time_based_rule_yn"  value="<%=pract_type_time_based_yn %>" <%if(pract_type_time_based_yn.equals("Y")){out.println(" checked ");}%> onclick='enableTimeBasedRule(this)' ></td>
</tr>
<!-- IN071361 end-->


<!-- [IN057196] End.  -->
<!-- Added on 3rd Feb Start's by Prakash.S-->
<INPUT TYPE="hidden" name="pin_by_ord_type" id="pin_by_ord_type" value="N">
<!-- Ends-->
<tr>
	<td class='columnheader' colspan=2 ><fmt:message key="eOR.TimePeriodforOrdersResults.label" bundle="${or_labels}"/></td>
</tr>
<tr>
					<td  class="label"  width='55%'><fmt:message key="eOR.MaxPeriodtoBackDateOrders.label" bundle="${or_labels}"/></td>
					<td class="fields" width='45%'>
					<input type=text  name="order_hrs" id="order_hrs" size=3 maxlength=6 value="<%=order_hrs%>" class='NUMBER' onKeyPress="return OrAllowNumber()" onBlur='return OrCheckNumber(this)'> <fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>
</tr>
<tr>
			 		<td  class="label" width='55%'><fmt:message key="eOR.MaxPeriodtoFutureDateOrders.label" bundle="${or_labels}"/>
					</td>
					<td class="fields" width='45%' >
					<input type=text name="order_future_hrs_ahead" id="order_future_hrs_ahead" size=3 maxlength=6 value="<%=order_future_hrs_ahead%>" 
					onKeyPress="return OrAllowNumber()" onBlur='return OrCheckNumber(this)'  class='NUMBER' >
					<fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>
</tr>
<tr>
					<td class="label" width='55%'><fmt:message key="eOR.MaxPeriodtoBackDateResults.label" bundle="${or_labels}"/></td>
					<td class="fields" width='45%'>
								<input type=text name="results_hrs" id="results_hrs" size=3 maxlength=6 value="<%=results_hrs%>" onKeyPress="return OrAllowNumber()" onBlur='return OrCheckNumber(this)'  class='NUMBER' >
								<fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>
</tr>
<!--
		Added By Arvind for CRF 804 
-->
<!-- Akbar /Increased max length from 1 to 3 for the belw prompt --->
<tr>
	<td class="label" width='55%'><fmt:message key="eOR.MaxPeriodtoModifyCompletedResults.label" bundle="${or_labels}"/></td>
	<td class="fields" width='45%'>
				<input type=text name="completed_result" id="completed_result" size=3 maxlength=3 value="<%=completed_result%>" onKeyPress="return OrAllowNumber()" onBlur='return OrCheckNumber(this)'  class='NUMBER' >
				<fmt:message key="Common.days.label" bundle="${common_labels}"/><input type="checkbox" width='45%' name="by24_hrs" id="by24_hrs" size=3  value="<%=by24_hrs%>"  <%if(by24_hrs.equals("Y")){out.println(" checked ");}%> ><fmt:message key="eOR.By24Hrs.label" bundle="${or_labels}"/> </td>
				
</tr>
<!--End-->
<!--IN27705 Start-->
<%if(isDfltOrderSts){%>
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.OneDayContOrder.label" bundle="${or_labels}"/></td>
</tr>
<tr>
			<td class='label'><fmt:message key="eOR.DefaultOrderStatus.label" bundle="${or_labels}"/></td>						
			<td class='fields'>
				<input type='radio' id='deforderstatus_all' name='def_order_status' id='def_order_status' value='ALL' <%=def_order_status%> <%=def_order_check_all%>><fmt:message key="Common.all.label" bundle="${common_labels}" />
				<input type='radio' id='deforderstatus_active' name='def_order_status' id='def_order_status' value='ACT' <%=def_order_status%>  <%=def_order_check_act%>><fmt:message key="Common.active.label" bundle="${common_labels}"/>
		    </td>
</tr>
<%}%>
<!--IN27705 End-->
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.UpdateOrders.label" bundle="${or_labels}"/></td>
</tr>
<tr>
		 	<td  class="label" width='55%'><fmt:message key="eOR.DefaultValueInProcess.label" bundle="${or_labels}"/></td>
			<td class='fields' width='45%'>
			<SELECT name="update_order" id="update_order">
			<option value = ""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- 
			<%
				try{
					update_orders = (ArrayList)bean.getUpdateOrders();
								for(int i=0; i<update_orders.size(); i++){
											String[] record = (String [])update_orders.get(i);
			%>
					<option value="<%=record[0]%>" <%if(update_order.equals(record[0])){out.println(" selected ");}%>  ><%=record[1]%>
					</option>
			<%	
					}
				}catch(Exception e){
					out.println(e);
				}
			%>
			</SELECT>
			</td>
			
</tr>
<!--  IN049419 - Start -->
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.auditforamendorders.label" bundle="${or_labels}"/><td class='fields'><input type='checkbox' name='amendauditreqdyn' id='amendauditreqdyn' value='<%=amendAuditReqdYN%>' <%if(amendAuditReqdYN.equals("Y")){%> checked<%}%> onclick = 'enableAudiReqd();'></td> 
</tr>
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.amendreasonreqd.label" bundle="${or_labels}"/><td class='fields'><input type='checkbox' name='amendreasonyn' id='amendreasonyn' value='<%=amendReasonYN%>' <%if(amendReasonYN.equals("Y")){%> checked<%}%> onclick = 'enableAmendReason();'></td> 
</tr>
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.amendreasonmand.label" bundle="${or_labels}"/><td class='fields'><input type='checkbox' name='amendreasonmandateyn' id='amendreasonmandateyn' value='<%=amendReasonMandatYN%>' <%if(amendReasonMandatYN.equals("Y")){%> checked<%}%>></td>
</tr>
<!--  IN049419 - End -->
<!-- 

Added by Kishore kumar N, for the CRF-640-OR

in this table for each td width (for label 55% and field 45%) added.

-->
<tr>
	<td class='columnheader' colspan=2 width='55%'><fmt:message key="eOR.FutureOrder.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.LinkFutureOrderToCurrentEncounter.label" bundle="${or_labels}"/></td><td class='fields'><input type='checkbox' name='lnkFutureOrderYn' id='lnkFutureOrderYn' value='N' <%if(lnkFutureOrCrrEcntYn.equals("Y")){%> checked<%}%>></td>
</tr>

<!-- ends here. -->

<!-- 

Added by Uma, for the CRF-641-OR

in this table for each td width (for label 55% and field 45%) added.

-->
 <tr>
	<td class='columnheader' colspan=2 width='55%'><fmt:message key="eOR.ControlByPrivilegeGroupSetup.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.Ordering.label" bundle="${or_labels}"/></td><td class='fields'><input type='checkbox' name='lnkOrderingYn' id='lnkOrderingYn' value='N' onclick='validateOrdering(this)' <%if(lnkOrderingYn.equals("Y")){%> checked disabled<%}%>></td>
</tr>
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.OrderAuthorisation.label" bundle="${or_labels}"/></td><td class='fields'><input type='checkbox' name='lnkOrderAuthorisationYn' id='lnkOrderAuthorisationYn' value='N' onclick='validateOrderAuthorisation(this)' <%if(lnkOrderAuthorisationYn.equals("Y")){%> checked disabled<%}%>></td>
</tr>
<!--  ML-MMOH-CRF-0493 [IN059086] - Start  -->
<tr>
<!--	<td class="label" width='45%'><fmt:message key="eOR.ApplyOrdPrivRuleOnly.label" bundle="${or_labels}"/></td><td class='fields'><input type='checkbox' name='auth_ord_priv_rule_only_yn' id='auth_ord_priv_rule_only_yn' value='N' onclick='enableAuthPrivRule(this)' <% if(lnkOrderAuthorisationYn.equals("Y"))%> enabled <% else %> disabled <%if(auth_ord_priv_rule_only_yn.equals("Y")){%> checked <%}%>></td>-->
<td class="label" width='45%'><fmt:message key="eOR.ApplyOrdPrivRuleOnly.label" bundle="${or_labels}"/></td><td class='fields'><input type='checkbox' name='auth_ord_priv_rule_only_yn' id='auth_ord_priv_rule_only_yn' value='N' onclick='enableAuthPrivRule(this);enableDisSelectOptn();' <% if(lnkOrderAuthorisationYn.equals("Y"))%> enabled <% else %> disabled <%if(auth_ord_priv_rule_only_yn.equals("Y")){%> checked <%}%>></td>
</tr>
<!--  ML-MMOH-CRF-0493 [IN059086] IN005128 - End  -->
<!-- ends here. -->
<!-- Added by Uma, for the CRF-804-OR IN016226-->
<!-- [IN064980]  - Start  -->
<tr>
<td class="label" width='45%'><fmt:message key="eOR.DisSelectAllOptn.label" bundle="${or_labels}"/></td><td class='fields'><input type='checkbox' name='DIS_SELECT_ALL_OPTION_YN' id='DIS_SELECT_ALL_OPTION_YN' value='N' onclick='enableDisSelectOptn();'<% if(auth_ord_priv_rule_only_yn.equals("Y"))%> enabled <% else %> disabled  <%if(Dis_Select_All_Option_yn.equals("Y")){%>checked <%}%>></td>
</tr>  
<!--[IN064980]  - ends  -->
<!--IN068673, starts-->
<tr>
<td class="label" ><fmt:message key="eOR.SecSpecialitiesForMySpecialty.label" bundle="${or_labels}"/></td>
	<td class="fields"  width="45%"><INPUT TYPE="checkbox" name="pendAuthIncludeSecSpltyYn" id="pendAuthIncludeSecSpltyYn" value ="<%=l_pend_auth_include_sec_splty%>" <%if(l_pend_auth_include_sec_splty.equals("Y")){%> checked<%}%> onclick='pendAuthIncludeSecSplty(this)' ></td>
</tr>
<!--IN068673, ends-->
<tr>
	<td class='columnheader' colspan=2 width='55%'><fmt:message key="eOR.OrderClinicalNoteResultType.label" bundle="${or_labels}"/></td>
</tr>
<%
	group_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RestrictAutoCompleteForClinicalNote.label","or_labels");
	result = '"'+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultComplete.label","or_labels")+'"';
	group_title = group_title.replace("$",result);
%>
<tr>
	<td class="label" width='45%'><%=group_title%></td><td class='fields'><input type='checkbox' name='restrictCompNoteYn' id='restrictCompNoteYn' value='N'  <%if(restrictCompNoteYn.equals("Y")){%> checked<%}%>></td>
</tr>
<!-- [IN029395] Start-->
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.OTPreferredSurgery.label" bundle="${or_labels}"/></td>
</tr>

<tr>
	<td  class="label"><fmt:message key="eOR.OTPreferredDate.label" bundle="${or_labels}"/></td>
	<td  class="fields"><input type=text name='surgery_ahead_days' id='surgery_ahead_days' size=3 maxlength=3 value="<%=surgery_ahead_days%>"  onKeyPress="return OrAllowNumber()" onBlur='return OrCheckNumber(this)'  class='NUMBER' ><fmt:message key="Common.days.label" bundle="${common_labels}"/></td> 
</tr>
<!-- [IN029395] End -->

<!-- ends here. -->
<!--IN028417 Starts-->
<tr>
	<td class='columnheader' colspan=2 width='55%'><fmt:message key="eOR.Hold.label" bundle="${or_labels}"/>/<fmt:message key="eOR.Discontinue.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.Hold/Discontinue.label" bundle="${or_labels}"/></td><td class='fields'><input type='checkbox' name='reasoncodeyn' id='reasoncodeyn' value='<%=ReasonCodeHoldDisYN%>' <%if(ReasonCodeHoldDisYN.equals("Y")){%> checked<%}%>></td> 
</tr>

<!-- IN028417 Ends-->
<!--   IN055737 HSA-CRF-0250.1  - Start -->
<tr>
	<td class='columnheader' colspan=2 width='55%'><fmt:message key="eOR.SpecimenOrder.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.dispslipbarcodesearch.label" bundle="${or_labels}"/></td>
	<td  class="fields"><INPUT TYPE="checkbox" name="allow_specimen_barcode_search_yn" id="allow_specimen_barcode_search_yn" value = '<%=allow_specimen_barcode_search_yn %>'  <%if(allow_specimen_barcode_search_yn.equals("Y")){%> checked<%}%> onclick='enableBarCodeSearch(this)'></td>
</tr>
<!-- IN055737 HSA-CRF-0250.1 - End  -->
<!--  ML-MMOH-CRF-0508.1 [IN062319] Start  -->
<tr>
	<td class='columnheader' colspan=2 ><fmt:message key="eOR.OrderEntryFormat.label" bundle="${or_labels}"/></td>
</tr>
<tr>
	<td class="label" width='45%'><fmt:message key="eOR.ordmultselnonmandat.label" bundle="${or_labels}"/></td>
	<td  class="fields"><INPUT TYPE="checkbox" name="ord_formt_multi_list_mand_yn" id="ord_formt_multi_list_mand_yn" value = '<%=ord_formt_multi_list_mand_yn %>'  <%if(ord_formt_multi_list_mand_yn.equals("Y")){%> checked<%}%> onclick='enableMultiChkNonMandate(this)'></td>
</tr>
<!--  ML-MMOH-CRF-0508.1 [IN062319] End  -->
<!-- IN061890 starts -->
 <%if(isSiteSpecific) { %>
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.ReplaceableOrderable.label" bundle="${or_labels}"/></td><!--IN066548-->
</tr>
<tr>
<td class="label" ><fmt:message key="eOR.ReplaceThroughTermSetAndCategory.label" bundle="${or_labels}"/></td><!--IN066548-->
	<td class="fields"  width="45%"><INPUT TYPE="checkbox" name="ord_repl_thro_termset_yn" id="ord_repl_thro_termset_yn" value ="<%=ord_repl_thro_termset_yn%>" <%if(ord_repl_thro_termset_yn.equals("Y")){%> checked<%}%> onclick='enableOrdReplThroTermset(this)' ></td>
			
</tr><%}%>
<!-- IN061890 end--> 
<!-- IN065925 starts -->
 
<tr>
	<td class='columnheader' colspan=2><fmt:message key="eOR.CancelOption.label" bundle="${or_labels}"/></td>
</tr>
<tr>
<td class="label" ><fmt:message key="eOR.Applicableto.label" bundle="${or_labels}"/>&nbsp<fmt:message key="eOR.InActiveOrders.label" bundle="${or_labels}"/></td>
	<td class="fields"  width="45%"><INPUT TYPE="checkbox" name="can_option_inactive_ord_yn" id="can_option_inactive_ord_yn" value ="<%=can_option_inactive_ord_yn%>" <%if(can_option_inactive_ord_yn.equals("Y")){%> checked<%}%> onclick='enableCanOptionInactiveOrd(this)' ></td>
			
</tr>
<!-- IN065925 end--> 

<input type="hidden" name="fing_prn_auth_order" id="fing_prn_auth_order"  value="N">
<input type="hidden" name="fing_prn_auth_result" id="fing_prn_auth_result"  value="N">
</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="lnkFutureOrCrrEcntYn" id="lnkFutureOrCrrEcntYn" value="">
<input type="hidden" name="ReasonCodeHoldDisYN" id="ReasonCodeHoldDisYN" value="<%=ReasonCodeHoldDisYN%>">

</form>
</body>

</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

