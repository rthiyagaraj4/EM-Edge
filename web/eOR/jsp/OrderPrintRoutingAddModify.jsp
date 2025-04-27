
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- OrderPrintRoutingAddModify.jsp -->
<!-- 
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created 
22/04/2014    IN042962		 Chowminya      						CRF:Print Order Sheet From Existing Orders	
-----------------------------------------------------------------------
-->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,eOR.*,eCommon.XSSRequestWrapper "%> 
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<!---->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/OrderPrintRouting.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	
   String facility_id = request.getParameter( "facility_id" ) ;
	//out.println("<script>alert('facility_id from request="+facility_id+"');</script>");
   if(facility_id == null){
		facility_id = (String)session.getValue("facility_id") ;
		//out.println("<script>alert('facility_id from session="+facility_id+"');</script>");
	}

//	String readOnly = "" ;
	String disabled="";
//	String checked="";


	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//out.println("<script>alert('mode="+mode+"@@@@@')</script>");
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_or_print_routing" ;
	String bean_name = "eOR.OrderPrintRoutingBean";
	boolean status = false;
	boolean status_select = false;
if(mode.equals("1"))
{
status = true;
}

	String operating_facility_id = facility_id;
	String order_type_code		 =(String)request.getParameter("order_type_code")  ;

	String patient_class1		 =(String)request.getParameter("patient_class") ;

	String short_desc1			 =(String)request.getParameter("short_desc")  ;

//		String order_category1    =(String)request.getParameter("order_category");
//        out.println("patient_class1"+patient_class1+"short_desc1"+short_desc1+"order_category1"+order_category1);

/*	String PRINT_CONSENT_YN			="N";
	String CONSENT_ROUTINE_QUEUE_1		=""	;
	String CONSENT_ROUTINE_QUEUE_2		=""	;
	String CONSENT_ROUTINE_QUEUE_DFLT	=""	;
	String CONSENT_URG_STAT_QUEUE_1	=""	;
	String CONSENT_URG_STAT_QUEUE_2	="";
	String CONSENT_URG_STAT_QUEUE_DFLT	="";
*/
	String PRINT_ORD_AT_DEST_YN		="N";
	String ORD_DEST_ROUTINE_QUEUE_1	=""	;
	String ORD_DEST_ROUTINE_QUEUE_2	="";
	String ORD_DEST_ROUTINE_QUEUE_DFLT	="";
	String ORD_DEST_STAT_QUEUE_1		="";
	String ORD_DEST_STAT_QUEUE_2		="";
	String ORD_DEST_STAT_QUEUE_DFLT	="";
	String PRINT_ORD_AT_SRC_YN			="N";
	String PRINT_RES_AT_DEPT_YN		="N";
	String RES_DEPT_ROUTINE_QUEUE_1	=""	;
	String RES_DEPT_ROUTINE_QUEUE_2	="";
	String RES_DEPT_ROUTINE_QUEUE_DFLT	="";
	String RES_DEPT_STAT_QUEUE_1		="";
	String RES_DEPT_STAT_QUEUE_2		="";
	String RES_DEPT_STAT_QUEUE_DFLT	="";
//	String PRINT_RES_PATLOC_YN			="";
	String PRINT_RES_AT_OTHLOC			="";
	String OTHLOC_QUEUE_NAME			="";
	String PRINT_RES_FOR_DISCH_PAT		="";
	String DISCH_PAT_QUEUE_NAME		="";
	String ORDER_TYPE_INSTRUCTIONS		="";
	String PERFORMING_DEPTLOC_CODE		="";
/*	String PRINT_CONS_AT_SRC_YN   ="N";
	String PRINT_REFU_AT_SRC_YN="N";
	String PRINT_REFU_AT_DEST_YN="N";
	String REFUSAL_DEST_ROUTINE_QUEUE_1="";
	String REFUSAL_DEST_ROUTINE_QUEUE_2="";
	String REFUSAL_DEST_ROUT_QUEUE_DFLT="";
	String REFUSAL_DEST_STAT_QUEUE_1="";
	String REFUSAL_DEST_STAT_QUEUE_2="";
	String REFUSAL_DEST_STAT_QUEUE_DFLT="";
*/
//	String PRINT_RES_FOR_DISCH_PAT_LOCN="";
	String OTHLOC_PAT_ROUTINE_QUEUE_1="";
	String OTHLOC_PAT_ROUTINE_QUEUE_2  = "";
	String OTHLOC_PAT_ROUTINE_QUEUE_DFLT  = "";
	String OTHLOC_PAT_STAT_QUEUE_1    = "";
	String OTHLOC_PAT_STAT_QUEUE_2   = "";
	String OTHLOC_PAT_STAT_QUEUE_DFLT = "";
	String print_option = "";//IN042962
	//added by Kavitha.K
/*	String PRINT_REFERRAL_AT_DEST_YN="N";
	String REFERRAL_DEST_ROUTINE_QUEUE_1="";
	String REFERRAL_DEST_ROUTINE_QUEUE_2="";
	String REFERRAL_DEST_ROUT_QUEUE_DFLT="";
	String PRINT_REFERRAL_AT_SRC_YN="N";
	String REFERRAL_DEST_STAT_QUEUE_1="";
	String REFERRAL_DEST_STAT_QUEUE_2="";
	String REFERRAL_DEST_STAT_QUEUE_DFLT="";
*/




	//OrderPrintRoutingBean bean = (OrderPrintRoutingBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 OrderPrintRoutingBean bean = (OrderPrintRoutingBean)getBeanObject( bean_id, bean_name, request ) ;
	 bean.setLanguageId(localeName);
	bean.clear() ;

	ArrayList allValue=new ArrayList();

/********MOdify**********************************************************/
if(!mode.equals("1"))	{

//	 readOnly="readOnly";

	 try{
		 allValue=(ArrayList)bean.getUpdateRecord(order_type_code.trim(),patient_class1.trim(),operating_facility_id.trim());
	 }catch(Exception  e){
		// out.println(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	 }
//System.out.println("###in OrderPrintRoutingAddModify.jsp, allValue.size()="+allValue.size());
//System.out.println("###in OrderPrintRoutingAddModify.jsp, allValue(15)="+(String)allValue.get(15));
	 if(!allValue.isEmpty()){


/*	 PRINT_CONSENT_YN					= (String)allValue.get(0)==null?"N":((String)allValue.get(0)).trim();
	 CONSENT_ROUTINE_QUEUE_1			=(String)allValue.get(1)==null?"":((String)allValue.get(1)).trim();
	 CONSENT_ROUTINE_QUEUE_2			=(String)allValue.get(2)==null?"":((String)allValue.get(2)).trim();
	 CONSENT_ROUTINE_QUEUE_DFLT			=(String)allValue.get(3)==null?"":((String)allValue.get(3)).trim();
	 CONSENT_URG_STAT_QUEUE_1			=(String)allValue.get(4)==null?"":((String)allValue.get(4)).trim();
	 CONSENT_URG_STAT_QUEUE_2			=(String)allValue.get(5)==null?"":((String)allValue.get(5)).trim();
	 CONSENT_URG_STAT_QUEUE_DFLT		=(String)allValue.get(6)==null?"":((String)allValue.get(6)).trim();
*/

	 PRINT_ORD_AT_DEST_YN	            =(String)allValue.get(7)==null?"N":((String)allValue.get(7)).trim();
     ORD_DEST_ROUTINE_QUEUE_1			=(String)allValue.get(8)==null?"":((String)allValue.get(8)).trim();
	 ORD_DEST_ROUTINE_QUEUE_2			=(String)allValue.get(9)==null?"":((String)allValue.get(9)).trim();
	 ORD_DEST_ROUTINE_QUEUE_DFLT		=(String)allValue.get(10)==null?"":((String)allValue.get(10)).trim();
	 ORD_DEST_STAT_QUEUE_1				=(String)allValue.get(11)==null?"":((String)allValue.get(11)).trim();
  	 ORD_DEST_STAT_QUEUE_2				=(String)allValue.get(12)==null?"":((String)allValue.get(12)).trim();
	 ORD_DEST_STAT_QUEUE_DFLT			=(String)allValue.get(13)==null?"":((String)allValue.get(13)).trim();
	 PRINT_ORD_AT_SRC_YN				=(String)allValue.get(14)==null?"N":((String)allValue.get(14)).trim();
 	 PRINT_RES_AT_DEPT_YN				=(String)allValue.get(15)==null?"N":((String)allValue.get(15)).trim();
	 RES_DEPT_ROUTINE_QUEUE_1			=(String)allValue.get(16)==null?"":((String)allValue.get(16)).trim();
	 RES_DEPT_ROUTINE_QUEUE_2			=(String)allValue.get(17)==null?"":((String)allValue.get(17)).trim();
	 RES_DEPT_ROUTINE_QUEUE_DFLT		=(String)allValue.get(18)==null?"":((String)allValue.get(18)).trim();
	 RES_DEPT_STAT_QUEUE_1				=(String)allValue.get(19)==null?"":((String)allValue.get(19)).trim();
	 RES_DEPT_STAT_QUEUE_2				=(String)allValue.get(20)==null?"":((String)allValue.get(20)).trim();
	 RES_DEPT_STAT_QUEUE_DFLT			=(String)allValue.get(21)==null?"":((String)allValue.get(21)).trim();
	// PRINT_RES_PATLOC_YN				=(String)allValue.get(22)==null?"":((String)allValue.get(22)).trim();
	 PRINT_RES_AT_OTHLOC				=(String)allValue.get(23)==null?"":((String)allValue.get(23)).trim();
	 OTHLOC_QUEUE_NAME					=(String)allValue.get(24)==null?"":((String)allValue.get(24)).trim();
	 PRINT_RES_FOR_DISCH_PAT			=(String)allValue.get(25)==null?"":((String)allValue.get(25)).trim();
	 DISCH_PAT_QUEUE_NAME				=(String)allValue.get(26)==null?"":((String)allValue.get(26)).trim();
	 ORDER_TYPE_INSTRUCTIONS			=(String)allValue.get(27)==null?"":((String)allValue.get(27)).trim();
	 PERFORMING_DEPTLOC_CODE			=(String)allValue.get(28)==null?"":((String)allValue.get(28)).trim();
/*	 PRINT_CONS_AT_SRC_YN   	=(String)allValue.get(29)==null?"":((String)allValue.get(29)).trim();
	 PRINT_REFU_AT_SRC_YN  =(String)allValue.get(30)==null?"":((String)allValue.get(30)).trim();
     PRINT_REFU_AT_DEST_YN       =(String)allValue.get(31)==null?"":((String)allValue.get(31)).trim();
	 REFUSAL_DEST_ROUTINE_QUEUE_1=(String)allValue.get(32)==null?"":((String)allValue.get(32)).trim();
	 REFUSAL_DEST_ROUTINE_QUEUE_2=(String)allValue.get(33)==null?"":((String)allValue.get(33)).trim();
	 REFUSAL_DEST_ROUT_QUEUE_DFLT=(String)allValue.get(34)==null?"":((String)allValue.get(34)).trim();
	 REFUSAL_DEST_STAT_QUEUE_1=(String)allValue.get(35)==null?"":((String)allValue.get(35)).trim();
	 REFUSAL_DEST_STAT_QUEUE_2=(String)allValue.get(36)==null?"":((String)allValue.get(36)).trim();
	 REFUSAL_DEST_STAT_QUEUE_DFLT=(String)allValue.get(37)==null?"":((String)allValue.get(37)).trim();
*/
//	 PRINT_RES_FOR_DISCH_PAT_LOCN=(String)allValue.get(38)==null?"":((String)allValue.get(38)).trim();
	OTHLOC_PAT_ROUTINE_QUEUE_1  =(String)allValue.get(39)==null?"":((String)allValue.get(39)).trim();
	OTHLOC_PAT_ROUTINE_QUEUE_2  =(String)allValue.get(40)==null?"":((String)allValue.get(40)).trim();
	OTHLOC_PAT_ROUTINE_QUEUE_DFLT  =(String)allValue.get(41)==null?"":((String)allValue.get(41)).trim();
	OTHLOC_PAT_STAT_QUEUE_1  =(String)allValue.get(42)==null?"":((String)allValue.get(42)).trim();
	OTHLOC_PAT_STAT_QUEUE_2  =(String)allValue.get(43)==null?"":((String)allValue.get(43)).trim();
	OTHLOC_PAT_STAT_QUEUE_DFLT  =(String)allValue.get(44)==null?"":((String)allValue.get(44)).trim();
	print_option  =(String)allValue.get(53)==null?"":((String)allValue.get(53)).trim();//IN042962

	//added by Kavitha.K
/*	PRINT_REFERRAL_AT_SRC_YN  =(String)allValue.get(45)==null?"":((String)allValue.get(45)).trim();
     PRINT_REFERRAL_AT_DEST_YN       =(String)allValue.get(46)==null?"N":((String)allValue.get(46)).trim();
	REFERRAL_DEST_ROUTINE_QUEUE_1=(String)allValue.get(47)==null?"":((String)allValue.get(47)).trim();
	REFERRAL_DEST_ROUTINE_QUEUE_2=(String)allValue.get(48)==null?"":((String)allValue.get(48)).trim();
	REFERRAL_DEST_ROUT_QUEUE_DFLT=(String)allValue.get(49)==null?"":((String)allValue.get(49)).trim();
	 REFERRAL_DEST_STAT_QUEUE_1=(String)allValue.get(50)==null?"":((String)allValue.get(50)).trim();
	 REFERRAL_DEST_STAT_QUEUE_2=(String)allValue.get(51)==null?"":((String)allValue.get(51)).trim();
	 REFERRAL_DEST_STAT_QUEUE_DFLT=(String)allValue.get(52)==null?"":((String)allValue.get(52)).trim();
*/	 	 	 
 }
}
/**************************************************************************/
	ArrayList print_order		= new ArrayList();
	ArrayList patient_class		= new ArrayList();
	////////
    ArrayList Category_Data = new ArrayList();
	OTHLOC_PAT_ROUTINE_QUEUE_DFLT = bean.getprint_report_dept_loc_radio();

    /////////////
%>


<form name="or_print_routing" id="or_print_routing"  target="messageFrame">
<table cellpadding=3  cellspacing=0 width="100%" align=center border=0>
<%if(mode.equals("1")){%>
<tr>
<td class='label' width='20%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
<td>		<SELECT name="order_category" id="order_category" onChange='populateOrderTypes(this)'>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
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
				//out.println(e);//COMMON-ICN-0181
                                e.printStackTrace();//COMMON-ICN-0181
			}
		%>
			</SELECT></td>
<%}%>

	<td class=label width='20%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<!-- insert mode -->
	<%if(mode.equals("1")){%>
	<td><select name='order_type_code' id='order_type_code' onChange="populateOrderTypes(this);">
	<option value=''>
	--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<%
		//print_order=bean.getPrintOrders();
		String ord_cat = "";
		print_order=bean.getOrderTypeData(ord_cat);
		for(int i=0 ; i<print_order.size() ; i++){
		String[] record = (String []) print_order.get(i);
	%>
        <option value=<%=record[0]%> ><%=record[1]%> </option>
	<%}
	%> </select><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
	<!-- modify mode -->
	<%}else{%><td>
	 <select name='order_type_code' id='order_type_code' onChange="populateOrderTypes(this);" disabled>
	 <option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	  <%
		 print_order=bean.getPrintOrders();
						 for(int i=0 ; i<print_order.size() ; i++){
							String[] record = (String []) print_order.get(i);
						%>
					        <option <% if((order_type_code.trim()).equals((String)record[0]))out.println("selected");%> value=<%=record[0]%> ><%=record[1]%> </option>
							<%
							}
							%>
				</select><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
				<td></td>
				<td></td>
							<%} %>


</tr>
<tr>
	<td class=label width='20%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	<%
						patient_class=bean.getPrintClass();
							if(mode.equals("1")){%>
			<td>		<select name='patient_class' id='patient_class'>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%

						for(int i=0;i<patient_class.size();i++){
							String[] record = (String []) patient_class.get(i);
					%>
				     <option value=<%=record[1]%>  >   <%=record[0] %>     </option>
					<%}	%>
				</select><img src="../../eCommon/images/mandatory.gif" align=center></img></td><%}else{
					%><td>
					<select name='patient_class' id='patient_class' disabled>
								<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%
									for(int i=0;i<patient_class.size();i++){
										String[] record = (String []) patient_class.get(i);
					%>
							<option   <% if((patient_class1.trim()).equals((String)record[1])) out.println("selected");%> value=<%=record[1]%>  >   <%=record[0] %>     </option>
					<%}	%>
				</select><img src="../../eCommon/images/mandatory.gif" align=center></img></td><%}%>



		<!-- <input name=instruction type=button class=button onClick='callOrderType("<%=ORDER_TYPE_INSTRUCTIONS%>");' value="Instructions"> -->
						<input type="hidden" name="order_type_instruction" id="order_type_instruction" value="<%=ORDER_TYPE_INSTRUCTIONS%>">
						

	<td class=label><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td>
		<!-- insert mode -->
		<%if(mode.equals("1")){%><td>
		<select name='performing_location_code' id='performing_location_code'>
		<option value=''>
		--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		</select></td>
		<!-- modify mode -->
		<%}else{%><td>
			<select name='performing_location_code' id='performing_location_code' disabled>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%ArrayList PerformingLocation = bean.getPerformingLocn(order_type_code.trim(),facility_id);
			for(int i=0;i<PerformingLocation.size();i++){
				String[] record = (String []) PerformingLocation.get(i);
			%>
				<option   <% if((PERFORMING_DEPTLOC_CODE.trim()).equals((String)record[1])) out.println("selected");%> value=<%=record[1]%>  >   <%=record[0] %>     </option>
			<%}%>
			</select>
		<%} %>
	</td>
</tr>
<%-- 
	<tr><td class=columnheader colspan='5' ><fmt:message key="eOR.ConsentForms.label" bundle="${or_labels}"/></td></tr>

<!--Print Consent Form  -->

%>


<tr>
	<td colspan='3'>
</table>
		<table cellpadding=3 cellspacing=0  align=center width="100%" border="1">
		<tr><td></td></tr>
		<tr>
		<td  class="label" nowrap align=right>Print at Destination
			<%
/*			String          print_consent_form1_value=PRINT_CONSENT_YN;
		//	String			consent_rout_loc_1_value="";
		//	String			consent_rout_loc_2_value="";
		//	String			consent_rout_loc_dflt_value="";
			String 			consent_urg_loc_1_value="";
			String 			consent_urg_loc_2_value="";
			String 			consent_urg_loc_dflt_value="";
			String           print_cons_at_src_yn=PRINT_CONS_AT_SRC_YN;

			if(mode.equals("1")||((!mode.equals("1")) && PRINT_CONSENT_YN.equals("N"))){
			disabled="disabled";
			//checked="";
			print_consent_form1_value="N";
			}else if(!mode.equals("1") && PRINT_CONSENT_YN.equals("Y")){
					print_consent_form1_value="Y";
				//	consent_rout_loc_1_value=CONSENT_ROUTINE_QUEUE_1;
				//	consent_rout_loc_2_value=CONSENT_ROUTINE_QUEUE_2;
				//	consent_rout_loc_dflt_value=CONSENT_ROUTINE_QUEUE_DFLT;
					consent_urg_loc_1_value=CONSENT_URG_STAT_QUEUE_1;
					consent_urg_loc_2_value=CONSENT_URG_STAT_QUEUE_2;
					consent_urg_loc_dflt_value=CONSENT_URG_STAT_QUEUE_DFLT;
				//	checked="checked";
					disabled="";
			}
			String print_cons_at_src_yn_value=PRINT_CONS_AT_SRC_YN.trim();
			if(print_cons_at_src_yn_value.equals("Y"))
				{
						print_cons_at_src_yn="Y";
				}else
				{
						print_cons_at_src_yn="N";
				}
*/
			%>

	<%
/*			    if(mode.equals("1")){
				PRINT_CONSENT_YN=(String)bean.getPrintConsYn();
				print_consent_form1_value=PRINT_CONSENT_YN;
				}
*/
 %>			<INPUT TYPE="checkbox" name="print_consent_form" id="print_consent_form"   onClick="setPriority1(this)"
			<%/*if(print_consent_form1_value.equals("Y"))out.println("checked");*/%>
			value="<%=//print_consent_form1_value%>"
 <%
/*			PRINT_CONSENT_YN=(String)bean.getPrintConsYn();

			if(((PRINT_CONSENT_YN.trim()).equals("N")))
			out.println("disabled");
*/
%>
			>
			
			<input type='hidden' name="print_consent_form_order" id="print_consent_form_order" value="<%=print_consent_form1_value%>">
			</td><td>
			</td>

		<td>
		
			<table cellpadding=3 cellspacing=0 width="100%" align=center >
			<tr>
			<td class=columnheadercenter><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class=columnheadercenter><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class=columnheadercenter><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/></td>
			<td class=columnheadercenter colspan="25%"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>

			</tr>

			
			<tr>
			<td class=label><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>

			<td>
			<input type=text name='consent_rout_loc1' id='consent_rout_loc1'  size='20' maxlength='6'
						<%
						/*if((PRINT_CONSENT_YN.equals("N")&&(CONSENT_ROUTINE_QUEUE_1.trim()).equals("")||(CONSENT_ROUTINE_QUEUE_DFLT.trim()).equals(""))&&(!mode.equals("1"))){out.println("disabled");  }
						*/%>   				value="<%=//CONSENT_ROUTINE_QUEUE_1%>" onblur="setLocationThis1(this);"
						<%
						/*if(((PRINT_CONSENT_YN.trim()).equals("N"))&&mode.equals("1"))out.println("disabled");
						*/%>
			>
			</td>

			<td>
			<input type=text name='consent_rout_loc2' id='consent_rout_loc2' size='20' maxlength='6'
								<%/*if((PRINT_CONSENT_YN.equals("N")&&(CONSENT_ROUTINE_QUEUE_2.trim()).equals("")||(CONSENT_ROUTINE_QUEUE_DFLT.trim()).equals(""))&&(!mode.equals("1"))){out.println("disabled");  }*/%> 	value="<%=//CONSENT_ROUTINE_QUEUE_2%>" onblur="setLocationThis2(this);"
							<%/*if(((PRINT_CONSENT_YN.trim()).equals("N"))&&mode.equals("1"))out.println("disabled");*/%>>
			</td>
			<td class=label>
			<input type=radio name='consent_rout_loc_radio' id='consent_rout_loc_radio' onclick="setLocationDefaultFirst(this);"
					<%//if((CONSENT_ROUTINE_QUEUE_DFLT.trim()).equals("1")) out.println("checked");%>
				<%//if(!((CONSENT_ROUTINE_QUEUE_DFLT.trim()).equals("1")||!((CONSENT_ROUTINE_QUEUE_1.trim()).equals(""))) ) out.println("disabled");%>
				>
			<fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/>
			</td>
			<td class=label>
			<input type=radio name='consent_rout_loc_radio' id='consent_rout_loc_radio'  onclick="setLocationDefaultFirst(this);"
			<%//if((CONSENT_ROUTINE_QUEUE_DFLT.trim()).equals("2")) out.println("checked");%>
			<%//if(!((CONSENT_ROUTINE_QUEUE_DFLT.trim()).equals("2")||!((CONSENT_ROUTINE_QUEUE_2.trim()).equals(""))) ) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden name="consent_routing_queue_dflt" id="consent_routing_queue_dflt" value="<%=//CONSENT_ROUTINE_QUEUE_DFLT%>">
			
			</td>

			</tr>
			<tr>
			<td></td>
			</tr>
			<tr>
			<td class=label><fmt:message key="eOR.UrgStat.label" bundle="${or_labels}"/></td>
			<td>
			<input type=text name='consent_urg_loc1' id='consent_urg_loc1'  size='20' maxlength='6' <%//if((PRINT_CONSENT_YN.equals("N")||CONSENT_URG_STAT_QUEUE_1.equals("")||CONSENT_URG_STAT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%> value="<%=//consent_urg_loc_1_value%>"  onblur="setLocationThis3(this);"
			<%//if(((PRINT_CONSENT_YN.trim()).equals("N"))&&mode.equals("1"))out.println("disabled");%>

			>
		
			</td>
			<td>
			<input type=text name='consent_urg_loc2' id='consent_urg_loc2'  size='20' maxlength='6' <%//if((PRINT_CONSENT_YN.equals("N")||CONSENT_URG_STAT_QUEUE_2.equals("")||CONSENT_URG_STAT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%> value="<%=//consent_urg_loc_2_value%>" onblur="setLocationThis4(this);"
		<%//if(((PRINT_CONSENT_YN.trim()).equals("N"))&&mode.equals("1"))out.println("disabled");%>

			>
			</td>
			<td class=label>
			<input type=radio name='consent_urg_loc_radio' id='consent_urg_loc_radio' onclick="setLocationDefaultFirst(this);"
			<%//if((consent_urg_loc_dflt_value.trim()).equals("1")) out.println("checked");%>
			<%/*if(print_consent_form1_value.equals("N")) out.println("disabled");*/%>
			<%//if(!((consent_urg_loc_dflt_value.trim()).equals("1")||!((consent_urg_loc_1_value.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/>
			</td>
			<td class=label>
			<input type=radio name='consent_urg_loc_radio' id='consent_urg_loc_radio'  onclick="setLocationDefaultFirst(this);"
			<%//if((consent_urg_loc_dflt_value.trim()).equals("2")) out.println("checked");%>
			<%/*if(print_consent_form1_value.equals("N")) out.println("disabled");*/%>
			<%//if(!((consent_urg_loc_dflt_value.trim()).equals("2")||!((consent_urg_loc_2_value.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>


			<input type=hidden name="consent_urg_stat_queue_dflt" id="consent_urg_stat_queue_dflt" value="<%=//consent_urg_loc_dflt_value%>">
			</td>
			</tr>
			</table>
			</td>
			</tr>
			
			<tr>
 <%
		 /*  if(mode.equals("1")){
			  	print_cons_at_src_yn=(String)bean.getPrintAtConsentSrc();
			}
		*/
 %>
			<td  class=label><fmt:message key="eOR.PrintatSource.label" bundle="${or_labels}"/>
			<input type=checkbox name='printatconsentsource' id='printatconsentsource' value='<%=//print_cons_at_src_yn%>'  onClick="setConsentSource(this);"	 																<%//if((print_cons_at_src_yn.trim()).equals("Y")) out.println("checked");%>


			<%
//				 PRINT_CONS_AT_SRC_YN=(String)bean.getPrintAtConsentSrc();	//if((PRINT_CONS_AT_SRC_YN.trim()).equals("N"))out.println("disabled");%>
			>
		<input type=hidden name='printatconsentsource1' id='printatconsentsource1' value="<%=//print_cons_at_src_yn%>" >

			</td><td>


			</td>
			<td></td>
			</tr>
	</table>

 
		<td colspan='3'>


 


		<table cellpadding=3 cellspacing=0  align=center width='100%' >
	

  <tr><td class=columnheader colspan='5' ><fmt:message key="eOR.RefusalForms.label" bundle="${or_labels}"/></td></tr>
		<tr><td></td></tr>
		<%
		//	checked="";
	/*		disabled="";
			String			print_refusal_at_dest_yn=PRINT_REFU_AT_DEST_YN       ;
			String         refusal_dest_routine_queue_1=REFUSAL_DEST_ROUTINE_QUEUE_1   ;
			String			refusal_dest_routine_queue_2=REFUSAL_DEST_ROUTINE_QUEUE_2   ;
			String			refusal_dest_rout_queue_dflt=REFUSAL_DEST_ROUT_QUEUE_DFLT   ;
			String			refusal_dest_stat_queue_1=REFUSAL_DEST_STAT_QUEUE_1      ;
			String 			refusal_dest_stat_queue_2=REFUSAL_DEST_STAT_QUEUE_2      ;
			String 			refusal_dest_stat_queue_dflt=REFUSAL_DEST_STAT_QUEUE_DFLT   ;
			String			print_refu_at_src_yn=PRINT_REFU_AT_SRC_YN;

			if(mode.equals("1")||((!mode.equals("1")) && (PRINT_REFU_AT_DEST_YN.equals("N")))){
			disabled="disabled";
		//	checked="";
			print_refusal_at_dest_yn="N";


			}else if((!mode.equals("1")) && PRINT_REFU_AT_DEST_YN       .equals("Y")){
			          print_refusal_at_dest_yn="Y";

						refusal_dest_routine_queue_1=REFUSAL_DEST_ROUTINE_QUEUE_1   ;
						refusal_dest_routine_queue_2=REFUSAL_DEST_ROUTINE_QUEUE_2   ;
						refusal_dest_rout_queue_dflt=REFUSAL_DEST_ROUT_QUEUE_DFLT   ;
			 			refusal_dest_stat_queue_1=REFUSAL_DEST_STAT_QUEUE_1      ;
			 			refusal_dest_stat_queue_2=REFUSAL_DEST_STAT_QUEUE_2      ;
			 			refusal_dest_stat_queue_dflt=REFUSAL_DEST_STAT_QUEUE_DFLT   ;
						disabled="";
					//	checked="checked";
			}

		String print_refu_at_src_yn_value=PRINT_REFU_AT_SRC_YN.trim();

		if(print_refu_at_src_yn_value.equals("Y"))
				{
						print_refu_at_src_yn="Y";

				}else
				{
						print_refu_at_src_yn="N";
				}
		*/
		%>
		<tr>
		<%

		/*			 if(mode.equals("1") ){
					 	PRINT_REFU_AT_DEST_YN=(String)bean.getPrintAtRefusalDest();
						print_refusal_at_dest_yn=PRINT_REFU_AT_DEST_YN;
					}
		*/
 %>

		 	<td  class="label" nowrap><fmt:message key="eOR.PrintatDestination.label" bundle="${or_labels}"/><INPUT TYPE="checkbox" name="print_at_refu_dest" id="print_at_refu_dest" 	onClick="setPriorityrefusal2(this);" <%//if(PRINT_REFU_AT_DEST_YN       .equals("Y"))out.println("checked");%> value="<%=//print_refusal_at_dest_yn%>"

					<%
		/*			PRINT_REFU_AT_DEST_YN=(String)bean.getPrintAtRefusalDest();
					if((PRINT_REFU_AT_DEST_YN.trim()).equals("N"))out.println("disabled");	
		*/
					%>
						>

			</td><td>

			</td>
				<INPUT TYPE="hidden" name="print_at_refu_dest1" id="print_at_refu_dest1"  value="<%=print_refusal_at_dest_yn%>">
			<td>
			<table cellpadding=3 cellspacing=0 width="100%" align=center >
			<tr>
			<td class=columnheadercenter><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class=columnheadercenter><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class=columnheadercenter><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/></td>
			<td class=columnheadercenter colspan="25%"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>

			</tr>

			

			<tr>
			<td class=label><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<input type=text name='print_rout_ref_loc1' id='print_rout_ref_loc1'  size='20' maxlength='6'

		<%//if((PRINT_REFU_AT_DEST_YN       .equals("N")||REFUSAL_DEST_ROUTINE_QUEUE_1   .equals("")||REFUSAL_DEST_ROUT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=//refusal_dest_routine_queue_1%>" onblur="setrefusalLocationThis5(this);"
		<%//if((PRINT_REFU_AT_DEST_YN       .trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>
			></td>

			<td  class='fields'>
			<input type=text name='print_rout_ref_loc2' id='print_rout_ref_loc2'  size='20' maxlength='6'
			<%//if((PRINT_REFU_AT_DEST_YN       .equals("N")||REFUSAL_DEST_ROUTINE_QUEUE_2 .equals("")||REFUSAL_DEST_ROUT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=//refusal_dest_routine_queue_2%>" onblur="setrefusalLocationThis6(this);"
		<%//if((PRINT_REFU_AT_DEST_YN       .trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>
			></td>

			<td class='fields'>
			<input type=radio name='print_rout_ref_loc_radio' id='print_rout_ref_loc_radio' onclick="setrefusalLocationDefaultSecond(this);"
			<%//if((REFUSAL_DEST_ROUT_QUEUE_DFLT.trim()).equals("1")) out.println("checked");%>

			<%//if(!((REFUSAL_DEST_ROUT_QUEUE_DFLT.trim()).equals("1")||!((refusal_dest_routine_queue_1.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=radio name='print_rout_ref_loc_radio' id='print_rout_ref_loc_radio' 	onclick="setrefusalLocationDefaultSecond(this);"
			<%//if((REFUSAL_DEST_ROUT_QUEUE_DFLT.trim()).equals("2")) out.println("checked");%>

			<%//if(!((REFUSAL_DEST_ROUT_QUEUE_DFLT.trim()).equals("2")||!((refusal_dest_routine_queue_2.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden name="refusal_dest_rout_queue_dflt" id="refusal_dest_rout_queue_dflt" value="<%=//refusal_dest_stat_queue_dflt%>">
			</td>
			</tr>
			
			<tr>
			<td class=label><fmt:message key="eOR.UrgStat.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=text name='print_urg_ref_loc1' id='print_urg_ref_loc1'  size='20' maxlength='6'
		<%//if((PRINT_REFU_AT_DEST_YN       .equals("N")||REFUSAL_DEST_STAT_QUEUE_1 .equals("")||REFUSAL_DEST_STAT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%> value="<%=refusal_dest_stat_queue_1%>"  onblur="setrefusalLocationThis7(this);"
		<%//if((PRINT_REFU_AT_DEST_YN       .trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>
			></td>
			<td class='fields'>
			<input type=text name='print_urg_ref_loc2' id='print_urg_ref_loc2'  size='20' maxlength='6'
			<%//if((PRINT_REFU_AT_DEST_YN       .equals("N")||REFUSAL_DEST_STAT_QUEUE_2.equals("")||REFUSAL_DEST_STAT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=refusal_dest_stat_queue_2%>"  onblur="setrefusalLocationThis8(this);"
			<%//if((PRINT_REFU_AT_DEST_YN       .trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>

			></td>
			<td class='fields'>
			<input type=radio name='print_urg_loc_ref_radio' id='print_urg_loc_ref_radio' onclick="setrefusalLocationDefaultSecond(this);"
			<%//if((refusal_dest_rout_queue_dflt.trim()).equals("1")) out.println("checked");%>
			<%//if(!((refusal_dest_stat_queue_dflt.trim().equals("1"))||!((refusal_dest_stat_queue_1.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=radio name='print_urg_loc_ref_radio' id='print_urg_loc_ref_radio' onclick="setrefusalLocationDefaultSecond(this);"
			<%//if((refusal_dest_rout_queue_dflt.trim()).equals("2")) out.println("checked");%>
			<%//if(!((refusal_dest_stat_queue_dflt.trim().equals("2"))||(!(refusal_dest_stat_queue_2.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden name="refusal_dest_stat_queue_dflt" id="refusal_dest_stat_queue_dflt" value="<%=//refusal_dest_stat_queue_dflt%>">
			</td>
			</tr>
			</table>
		</td>
			</tr>
				
			<tr>
<%
		  /* if(mode.equals("1")){
			  	print_refu_at_src_yn=(String)bean.getPrintAtRefusalSrc();
			}
			*/
 %>
			<td  class=label nowrap><fmt:message key="eOR.PrintatSource.label" bundle="${or_labels}"/><input type=checkbox name='printatrefusalsource' id='printatrefusalsource' value='<%=//print_refu_at_src_yn%>'  onClick="setRefusalSource(this);"	 																<%//if((print_refu_at_src_yn.trim()).equals("Y")) out.println("checked");%>


			<%
		//		String src_print_refu_at_src_yn=(String)bean.getPrintAtRefusalSrc();
	//			out.println("<script>alert('"+print_refu_at_src_yn+"');</script>");
//if(src_print_refu_at_src_yn.equals("N"))out.println("disabled");%>
			>
			<input type=hidden name='printatrefusalsource1' id='printatrefusalsource1' value="<%=//print_refu_at_src_yn%>" >

			</td><td>


			</td>
			<td></td>
			</tr>
	</table>

	<!--added by Kavitha.K 9.11.2004 -->

	<td colspan='3'>


		<table cellpadding=3 cellspacing=0  align=center width='100%' >
  <tr><td class=columnheader colspan='5' ><fmt:message key="eOR.RefusalForms.label" bundle="${or_labels}"/></td></tr>
		<tr><td></td></tr>
		<%
		//	checked="";
/*			disabled="";
			String			print_referral_at_dest_yn=PRINT_REFERRAL_AT_DEST_YN       ;
			String         referral_dest_routine_queue_1=REFERRAL_DEST_ROUTINE_QUEUE_1   ;
			String			referral_dest_routine_queue_2=REFERRAL_DEST_ROUTINE_QUEUE_2   ;
			String			referral_dest_rout_queue_dflt=REFERRAL_DEST_ROUT_QUEUE_DFLT   ;
			String			referral_dest_stat_queue_1=REFERRAL_DEST_STAT_QUEUE_1      ;
			String 			referral_dest_stat_queue_2=REFERRAL_DEST_STAT_QUEUE_2      ;
			String 			referral_dest_stat_queue_dflt=REFERRAL_DEST_STAT_QUEUE_DFLT   ;
			String			print_referral_at_src_yn=PRINT_REFERRAL_AT_SRC_YN;

			if(mode.equals("1")||((!mode.equals("1")) && (PRINT_REFERRAL_AT_DEST_YN.equals("N")))){
			disabled="disabled";
		//	checked="";
			print_referral_at_dest_yn="N";


			}else if((!mode.equals("1")) && PRINT_REFERRAL_AT_DEST_YN.equals("Y")){
			          print_referral_at_dest_yn="Y";

						referral_dest_routine_queue_1=REFERRAL_DEST_ROUTINE_QUEUE_1   ;
						referral_dest_routine_queue_2=REFERRAL_DEST_ROUTINE_QUEUE_2   ;
						referral_dest_rout_queue_dflt=REFERRAL_DEST_ROUT_QUEUE_DFLT   ;
			 			referral_dest_stat_queue_1=REFERRAL_DEST_STAT_QUEUE_1      ;
			 			referral_dest_stat_queue_2=REFERRAL_DEST_STAT_QUEUE_2      ;
			 			referral_dest_stat_queue_dflt=REFERRAL_DEST_STAT_QUEUE_DFLT   ;
						disabled="";
					//	checked="checked";
			}

		String print_referral_at_src_yn_value=PRINT_REFERRAL_AT_SRC_YN.trim();

		if(print_referral_at_src_yn_value.equals("Y"))
				{
						print_referral_at_src_yn="Y";

				}else
				{
						print_referral_at_src_yn="N";
				}
*/
		%>
		<tr>
		<%

		/*			 if(mode.equals("1") ){
					 	PRINT_REFERRAL_AT_DEST_YN=(String)bean.getPrintAtReferralDest();
						print_referral_at_dest_yn=PRINT_REFERRAL_AT_DEST_YN;
					}
		*/
 %>

		 	<td  class="label" nowrap><fmt:message key="eOR.PrintatDestination.label" bundle="${or_labels}"/>
						<INPUT TYPE="checkbox" name="print_at_referral_dest" id="print_at_referral_dest" 	onClick="setPriorityreferral2(this);" <%//if(PRINT_REFERRAL_AT_DEST_YN       .equals("Y"))out.println("checked");%> value="<%=//print_referral_at_dest_yn%>"

					<%
			/*		PRINT_REFERRAL_AT_DEST_YN       =(String)bean.getPrintAtReferralDest();
					if((PRINT_REFERRAL_AT_DEST_YN.trim()).equals("N"))out.println("disabled");
			*/		%>

						>

			</td><td>

			</td>
				<INPUT TYPE="hidden" name="print_at_referral_dest1" id="print_at_referral_dest1"  value="<%=//print_referral_at_dest_yn%>">
			<td>
			<table cellpadding=3 cellspacing=0 width="100%" align=center >
			<tr>
			<td class=columnheadercenter><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class=columnheadercenter><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class=columnheadercenter><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/></td>
			<td class=columnheadercenter colspan="25%"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>

			</tr>

			

			<tr>
			<td class=label><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<input type=text name='print_rout_referral_loc1' id='print_rout_referral_loc1'  size='20' maxlength='6'

		<%//if((PRINT_REFERRAL_AT_DEST_YN.equals("N")||REFERRAL_DEST_ROUTINE_QUEUE_1   .equals("")||REFERRAL_DEST_ROUT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=//referral_dest_routine_queue_1%>" onblur="setreferralLocationThis5(this);"
		<%//if((PRINT_REFERRAL_AT_DEST_YN       .trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>
			></td>

			<td class='fields'>
			<input type=text name='print_rout_referral_loc2' id='print_rout_referral_loc2'  size='20' maxlength='6'
			<%//if((PRINT_REFERRAL_AT_DEST_YN.equals("N")||REFERRAL_DEST_ROUTINE_QUEUE_2 .equals("")||REFERRAL_DEST_ROUT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=//referral_dest_routine_queue_2%>" onblur="setreferralLocationThis6(this);"
		<%//if((PRINT_REFERRAL_AT_DEST_YN       .trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>
			></td>

			<td class='fields'>
			<input type=radio name='print_rout_referral_loc_radio' id='print_rout_referral_loc_radio' onclick="setreferralLocationDefaultSecond(this);"
			<%//if((REFERRAL_DEST_ROUT_QUEUE_DFLT.trim()).equals("1")) out.println("checked");%>

			<%//if(!((REFERRAL_DEST_ROUT_QUEUE_DFLT.trim()).equals("1")||!((referral_dest_routine_queue_1.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=radio name='print_rout_referral_loc_radio' id='print_rout_referral_loc_radio' 	onclick="setreferralLocationDefaultSecond(this);"
			<%//if((REFERRAL_DEST_ROUT_QUEUE_DFLT.trim()).equals("2")) out.println("checked");%>

			<%//if(!((REFERRAL_DEST_ROUT_QUEUE_DFLT.trim()).equals("2")||!((referral_dest_routine_queue_2.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden name="referral_dest_rout_queue_dflt" id="referral_dest_rout_queue_dflt" value="<%=//referral_dest_stat_queue_dflt%>">
			</td>
			</tr>
			<tr><td></td></tr>
			<tr>
			<td class=label><fmt:message key="eOR.UrgStat.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=text name='print_urg_referral_loc1' id='print_urg_referral_loc1'  size='20' maxlength='6'
		<%//if((PRINT_REFERRAL_AT_DEST_YN       .equals("N")||REFERRAL_DEST_STAT_QUEUE_1 .equals("")||REFERRAL_DEST_STAT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%> value="<%=//referral_dest_stat_queue_1%>"  onblur="setreferralLocationThis7(this);"
		<%//if((PRINT_REFERRAL_AT_DEST_YN       .trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>
			></td>
			<td class='fields'>
			<input type=text name='print_urg_referral_loc2' id='print_urg_referral_loc2'  size='20' maxlength='6'
			<%//if((PRINT_REFERRAL_AT_DEST_YN       .equals("N")||REFERRAL_DEST_STAT_QUEUE_2.equals("")||REFERRAL_DEST_STAT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=//referral_dest_stat_queue_2%>"  onblur="setreferralLocationThis8(this);"
			<%//if((PRINT_REFERRAL_AT_DEST_YN       .trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>

			></td>
			<td class='fields'>
			<input type=radio name='print_urg_loc_referral_radio' id='print_urg_loc_referral_radio' onclick="setreferralLocationDefaultSecond(this);"
			<%//if((referral_dest_rout_queue_dflt.trim()).equals("1")) out.println("checked");%>
			<%//if(!((referral_dest_stat_queue_dflt.trim().equals("1"))||!((referral_dest_stat_queue_1.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=radio name='print_urg_loc_referral_radio' id='print_urg_loc_referral_radio' onclick="setreferralLocationDefaultSecond(this);"
			<%//if((referral_dest_rout_queue_dflt.trim()).equals("2")) out.println("checked");%>
			<%//if(!((referral_dest_stat_queue_dflt.trim().equals("2"))||(!(referral_dest_stat_queue_2.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden name="referral_dest_stat_queue_dflt" id="referral_dest_stat_queue_dflt" value="<%=//referral_dest_stat_queue_dflt%>">
			</td>
			</tr>
			</table>
		</td>
			</tr>
				
			<tr>
<%
		/*   if(mode.equals("1")){
			  	print_referral_at_src_yn=(String)bean.getPrintAtReferralSrc();
			}
		*/
 %>
			<td  class=label><fmt:message key="eOR.PrintatSource.label" bundle="${or_labels}"/>
			<input type=checkbox name='printatreferralsource' id='printatreferralsource' value='<%=//print_referral_at_src_yn%>'  onClick="setReferralSource(this);"	 																<%//if((print_referral_at_src_yn.trim()).equals("Y")) out.println("checked");%>


			<%
				//String src_print_referral_at_src_yn=(String)bean.getPrintAtReferralSrc();
	//			out.println("<script>alert('"+print_referral_at_src_yn+"');</script>");
//if(src_print_referral_at_src_yn.equals("N"))out.println("disabled");%>
			>
			<input type=hidden name='printatreferralsource1' id='printatreferralsource1' value="<%=//print_referral_at_src_yn%>" >
			</td>
			</tr>
	</table>

--%>
	

<tr>
	<!-- hidden fields for consent form, refusal form and referral form is not there -->
 	<input type="hidden" name="print_consent_form" id="print_consent_form" value="N">
	<input type="hidden" name="print_consent_form_order" id="print_consent_form_order" value="N">
	<input type="hidden" name="consent_rout_loc1" id="consent_rout_loc1" value="">
	<input type="hidden" name="consent_rout_loc2" id="consent_rout_loc2" value="">
	<input type="hidden" name="consent_routing_queue_dflt" id="consent_routing_queue_dflt" value="">
	<input type="hidden" name="consent_urg_loc1" id="consent_urg_loc1" value="">
	<input type="hidden" name="consent_urg_loc2" id="consent_urg_loc2" value="">
	<input type="hidden" name="consent_urg_stat_queue_dflt" id="consent_urg_stat_queue_dflt" value="">
	<input type="hidden" name="printatconsentsource" id="printatconsentsource" value="N">
	<input type="hidden" name="printatconsentsource1" id="printatconsentsource1" value="N">
	
	<input type="hidden" name="print_at_refu_dest" id="print_at_refu_dest" value="N">
	<input type="hidden" name="print_at_refu_dest1" id="print_at_refu_dest1" value="N">
	<input type="hidden" name="print_rout_ref_loc1" id="print_rout_ref_loc1" value="">
	<input type="hidden" name="print_rout_ref_loc2" id="print_rout_ref_loc2" value="">
	<input type="hidden" name="refusal_dest_rout_queue_dflt" id="refusal_dest_rout_queue_dflt" value="">
	<input type="hidden" name="print_urg_ref_loc1" id="print_urg_ref_loc1" value="">
	<input type="hidden" name="print_urg_ref_loc2" id="print_urg_ref_loc2" value="">
	<input type="hidden" name="refusal_dest_stat_queue_dflt" id="refusal_dest_stat_queue_dflt" value="">

	<input type="hidden" name="printatrefusalsource" id="printatrefusalsource" value="N">
	<input type="hidden" name="printatrefusalsource1" id="printatrefusalsource1" value="N">
	<input type="hidden" name="print_at_referral_dest" id="print_at_referral_dest" value="N">
	<input type="hidden" name="print_at_referral_dest1" id="print_at_referral_dest1" value="N">
	<input type="hidden" name="print_rout_referral_loc1" id="print_rout_referral_loc1" value="">
	<input type="hidden" name="print_rout_referral_loc2" id="print_rout_referral_loc2" value="">

	<input type="hidden" name="referral_dest_rout_queue_dflt" id="referral_dest_rout_queue_dflt" value="">
	<input type="hidden" name="print_urg_referral_loc1" id="print_urg_referral_loc1" value="">
	<input type="hidden" name="print_urg_referral_loc2" id="print_urg_referral_loc2" value="">
	<input type="hidden" name="referral_dest_stat_queue_dflt" id="referral_dest_stat_queue_dflt" value="">
	<input type="hidden" name="printatreferralsource" id="printatreferralsource" value="N">
	<input type="hidden" name="printatreferralsource1" id="printatreferralsource1" value="N">
  
	<!-- if consent is there / refusal is there/ referral is there, then this corresponding hidden fields can be removed -->

	<td colspan='4'>
		<table cellpadding=3 cellspacing=0  align=center width='100%'>
	<td class="columnheader" colspan='3'><fmt:message key="eOR.OrderForm.label" bundle="${or_labels}"/></td>
	<%
		//	checked="";
			disabled="";
			String			print_ord_at_dest_yn=PRINT_ORD_AT_DEST_YN;
			String         ord_dest_routine_queue_1=ORD_DEST_ROUTINE_QUEUE_1;
			String			ord_dest_routine_queue_2=ORD_DEST_ROUTINE_QUEUE_1;
		//	String			ord_dest_routine_queue_dflt=ORD_DEST_ROUTINE_QUEUE_DFLT;
			String			ord_dest_stat_queue_1=ORD_DEST_STAT_QUEUE_1;
			String 			ord_dest_stat_queue_2=ORD_DEST_STAT_QUEUE_2;
			String 			ord_dest_stat_queue_dflt=ORD_DEST_STAT_QUEUE_DFLT;
			String			print_ord_at_src_yn=PRINT_ORD_AT_SRC_YN;


			if(mode.equals("1")||((!mode.equals("1")) && (PRINT_ORD_AT_DEST_YN.equals("N")))){
			disabled="disabled";
		//	checked="";
			print_ord_at_dest_yn="N";


			}else if((!mode.equals("1")) && PRINT_ORD_AT_DEST_YN.equals("Y")){
			          print_ord_at_dest_yn="Y";

						ord_dest_routine_queue_1=ORD_DEST_ROUTINE_QUEUE_1;
						ord_dest_routine_queue_2=ORD_DEST_ROUTINE_QUEUE_2;
					//	ord_dest_routine_queue_dflt=ORD_DEST_ROUTINE_QUEUE_DFLT;
			 			ord_dest_stat_queue_1=ORD_DEST_STAT_QUEUE_1;
			 			ord_dest_stat_queue_2=ORD_DEST_STAT_QUEUE_2;
			 			ord_dest_stat_queue_dflt=ORD_DEST_STAT_QUEUE_DFLT;
						disabled="";
					//	checked="checked";
			}
//			out.println(ORD_DEST_ROUTINE_QUEUE_DFLT);
				String print_ord_at_src_yn_value=PRINT_ORD_AT_SRC_YN.trim();
	//out.println("the value at p at src::"+print_ord_at_src_yn_value+"the value get from the database");

	//	out.println(print_ord_at_src_yn_value.equals("Y"));
		if(print_ord_at_src_yn_value.equals("Y"))
				{
						print_ord_at_src_yn="Y";
			//			out.println("the value at p at src::"+print_ord_at_src_yn_value+"the value get from the database");
				}else
				{
						print_ord_at_src_yn="N";
				}
//	out.println("the value at text at ::"+ord_dest_stat_queue_2+"the value get from the database");

			%>

		<tr>
		<%
	//			 out.println("mode"+(String)bean.getPrintAtDest());


					 if(mode.equals("1") ){
					 	PRINT_ORD_AT_DEST_YN=(String)bean.getPrintAtDest();
						print_ord_at_dest_yn=PRINT_ORD_AT_DEST_YN;
					}
 %>
		 	<td  class="label" nowrap><fmt:message key="eOR.PrintatDestination.label" bundle="${or_labels}"/>
						<INPUT TYPE="checkbox" name="print_at_dest" id="print_at_dest" onClick="setPriority2(this);" <%if(PRINT_ORD_AT_DEST_YN.equals("Y"))out.println("checked");%> value="<%=print_ord_at_dest_yn%>"

					<%
				String dest_PRINT_ORD_AT_DEST_YN=(String)bean.getPrintAtDest();
					if((dest_PRINT_ORD_AT_DEST_YN.trim()).equals("N"))out.println("disabled");%>
			>
			</td>
				<INPUT TYPE="hidden" name="print_at_dest1" id="print_at_dest1"  value="<%=print_ord_at_dest_yn%>">
			<td>
			<table cellpadding=3 cellspacing=0 width="100%" align=center>
			<tr>
			<td class="columnheadercenter"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class="columnheadercenter"><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class="columnheadercenter"><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/></td>
			<td class="columnheadercenter" colspan="25%"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			<td class='label'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<input type=text name='print_rout_loc1' id='print_rout_loc1'  size='20' maxlength='6' <%if((PRINT_ORD_AT_DEST_YN.equals("N")||ORD_DEST_ROUTINE_QUEUE_1.equals("")||ORD_DEST_ROUTINE_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=ord_dest_routine_queue_1%>" onblur="setLocationThis5(this);"
			<%if((PRINT_ORD_AT_DEST_YN.trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>
			></td>
			<td class='fields'>
			<input type=text name='print_rout_loc2' id='print_rout_loc2'  size='20' maxlength='6' <%if((PRINT_ORD_AT_DEST_YN.equals("N")||ORD_DEST_ROUTINE_QUEUE_2.equals("")||ORD_DEST_ROUTINE_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=ord_dest_routine_queue_2%>" onblur="setLocationThis6(this);"
			<%if((PRINT_ORD_AT_DEST_YN.trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>
			></td>
			<td class='fields'>
			<input type=radio name='print_rout_loc_radio' id='print_rout_loc_radio'  onclick="setLocationDefaultSecond(this);"
			<%if((ORD_DEST_ROUTINE_QUEUE_DFLT.trim()).equals("1")) out.println("checked");%>
			<%if(!((ORD_DEST_ROUTINE_QUEUE_DFLT.trim()).equals("1")||!((ord_dest_routine_queue_1.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=radio name='print_rout_loc_radio' id='print_rout_loc_radio'  onclick="setLocationDefaultSecond(this);"
			<%if((ORD_DEST_ROUTINE_QUEUE_DFLT.trim()).equals("2")) out.println("checked");%>
			<%if(!((ORD_DEST_ROUTINE_QUEUE_DFLT.trim()).equals("2")||!((ord_dest_routine_queue_2.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden name="ord_dest_routine_queue_dflt" id="ord_dest_routine_queue_dflt" value="<%=ord_dest_stat_queue_dflt%>"></td>
			</tr>
			<tr>
			<td class=label><fmt:message key="eOR.UrgStat.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=text name='print_urg_loc1' id='print_urg_loc1'  size='20' maxlength='6' <%if((PRINT_ORD_AT_DEST_YN.equals("N")||ORD_DEST_STAT_QUEUE_1.equals("")||ORD_DEST_STAT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%> value="<%=ord_dest_stat_queue_1%>"  onblur="setLocationThis7(this);"
			<%if((PRINT_ORD_AT_DEST_YN.trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>

			></td>
			<td class='fields'>
			<input type=text name='print_urg_loc2' id='print_urg_loc2'  size='20' maxlength='6' <%if((PRINT_ORD_AT_DEST_YN.equals("N")||ORD_DEST_STAT_QUEUE_2.equals("")||ORD_DEST_STAT_QUEUE_DFLT.equals(""))&&(!mode.equals("1"))){ out.println("disabled");}%>value="<%=ord_dest_stat_queue_2%>"  onblur="setLocationThis8(this);"
			<%if((PRINT_ORD_AT_DEST_YN.trim().equals("N"))&&mode.equals("1"))out.println("disabled");%>

			></td>
			<td class='fields'>
			<input type=radio name='print_urg_loc_radio' id='print_urg_loc_radio'  onclick="setLocationDefaultSecond(this);"
			<%if((ord_dest_stat_queue_dflt.trim()).equals("1")) out.println("checked");%>
			<%if(!((ord_dest_stat_queue_dflt.trim().equals("1"))||!((ord_dest_stat_queue_1.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=radio name='print_urg_loc_radio' id='print_urg_loc_radio'  onclick="setLocationDefaultSecond(this);"
			<%if((ord_dest_stat_queue_dflt.trim()).equals("2")) out.println("checked");%>
			<%if(!((ord_dest_stat_queue_dflt.trim().equals("2"))||(!(ord_dest_stat_queue_2.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden name="ord_dest_stat_queue_dflt" id="ord_dest_stat_queue_dflt"  value="<%=ord_dest_stat_queue_dflt%>"></td>
			</tr>
			</table>
		</td>
			</tr>
				
			<tr>
 <%
		   if(mode.equals("1"))
		   {
			  	print_ord_at_src_yn=(String)bean.getPrintAtSrc();
			}
 %>
			<td  class="label"><fmt:message key="eOR.PrintatSource.label" bundle="${or_labels}"/>
			<input type=checkbox name='printatsource' id='printatsource' value='<%=print_ord_at_src_yn%>'  onClick="setSource(this);"	 <%if((print_ord_at_src_yn.trim()).equals("Y")) out.println("checked");%>
			<%
				String dis_print_ord_at_src_yn=(String)bean.getPrintAtSrc();	if((dis_print_ord_at_src_yn.trim()).equals("N"))out.println("disabled");%>
			><input type=hidden name='printatsource1' id='printatsource1' value="<%=print_ord_at_src_yn%>" >
			</td>
			</tr>
			<!-- IN042962 Start-->
			<tr>
			<td  class="label" nowrap width="25%"><fmt:message key="eOR.PrintOption.label" bundle="${or_labels}"/></td>
				<td class="fields">
					<select name='print_option' id='print_option'>
						<option value='S' <% if((print_option.trim()).equals("S")){out.println("selected");}%> > <fmt:message key="eOR.SilentAlert.label" bundle="${or_labels}"/></option>
						<option value='C' <% if((print_option.trim()).equals("C")){out.println("selected");}%> ><fmt:message key="eOR.ConfirmAlert.label" bundle="${or_labels}"/></option>
						<option value='O' <% if((print_option.trim()).equals("O")){out.println("selected");}%> ><fmt:message key="eOR.OfflineAlert.label" bundle="${or_labels}"/></option>
					</select>
				</td>
			</tr>
			<!-- IN042962 End -->		
			</table>


	<table cellpadding=3 cellspacing=0  align=center width='100%' >
	<td class="columnheader" colspan='100%'><fmt:message key="eOR.ResultReports.label" bundle="${or_labels}"/></td>
	<tr>
	<%              // checked="";
                    	disabled="";

			String          print_res_at_dept_yn=PRINT_RES_AT_DEPT_YN;
			String			res_dept_routine_queue_1=RES_DEPT_ROUTINE_QUEUE_1;
			String			res_dept_routine_queue_2=RES_DEPT_ROUTINE_QUEUE_2;
			String			res_dept_routine_queue_dflt=RES_DEPT_ROUTINE_QUEUE_DFLT;
			String 			res_dept_stat_queue_1=RES_DEPT_STAT_QUEUE_1;
			String 			res_dept_stat_queue_2=RES_DEPT_STAT_QUEUE_2;
			String 			res_dept_stat_queue_dflt=RES_DEPT_STAT_QUEUE_DFLT;


			if(mode.equals("1")||((!mode.equals("2")) && print_res_at_dept_yn.equals("N")))
			{
				//out.println("<script>alert('###in OrderPrintRoutingAddModify.jsp, in loop1,mode="+mode+"####');</script>");
				//out.println("<script>alert('###in OrderPrintRoutingAddModify.jsp, in loop1,print_res_at_dept_yn="+print_res_at_dept_yn+"');</script>");

				disabled="disabled";
				//checked="";
				print_res_at_dept_yn="N";

			}
			else if((!mode.equals("1")) && print_res_at_dept_yn.equals("Y"))
			{
				//System.out.println("###in OrderPrintRoutingAddModify.jsp, in loop2");
					print_res_at_dept_yn="Y";
					res_dept_routine_queue_1=RES_DEPT_ROUTINE_QUEUE_1;
					res_dept_routine_queue_2=RES_DEPT_ROUTINE_QUEUE_2;
					res_dept_routine_queue_dflt=RES_DEPT_ROUTINE_QUEUE_DFLT;
					res_dept_stat_queue_1=RES_DEPT_STAT_QUEUE_1;
					res_dept_stat_queue_2=RES_DEPT_STAT_QUEUE_2;
					res_dept_stat_queue_dflt=RES_DEPT_STAT_QUEUE_DFLT;
				//	checked="checked";
					disabled="";
			}
						
				
			if(mode.equals("1"))
			{
//					 out.println("mode"+(String)bean.getPrintAtDept());
					bean.setOperatingFacilityId(facility_id);
					print_res_at_dept_yn=(String)bean.getPrintAtDept();
					//out.println("<script>alert('### print_res_at_dept_yn from bean="+print_res_at_dept_yn+"');</script>");
					//out.println("<script>alert('### facility_id="+facility_id+"');</script>");
			}
		//	out.println("the value of default ::"+res_dept_routine_queue_dflt);
		//	out.println("the value of default ::"+res_dept_stat_queue_dflt);
		%>
	 	<td  class="label" nowrap><fmt:message key="eOR.PrintatDepartment.label" bundle="${or_labels}"/>
		<INPUT TYPE="checkbox" name="print_at_dept_new1" id="print_at_dept_new1" onClick="setPriority3(this);" value="<%=print_res_at_dept_yn%>" <%if((print_res_at_dept_yn.trim()).equals("Y")) out.println("checked");%>
		<%
			String dest_print_res_at_dept_yn=(String)bean.getPrintAtDept();
			if((dest_print_res_at_dept_yn.trim()).equals("N"))out.println("disabled");%>
		>
		</td>
			<INPUT TYPE="hidden" name="print_at_dept_new" id="print_at_dept_new"  value="<%=print_res_at_dept_yn%>">
			<td>

			<table cellpadding=3 cellspacing=0 width="100%" align=center  >
			<tr>
			<td class=columnheadercenter><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class=columnheadercenter><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class=columnheadercenter><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/></td>
			<td class=columnheadercenter colspan="25%"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			<td class=label><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<input type=text name='print_dept_loc1' id='print_dept_loc1'  size='20' maxlength='6' <%if((print_res_at_dept_yn.trim()).equals("N"))out.println("disabled");%>  value="<%=res_dept_routine_queue_1%>"  onblur="setLocationThis9(this);"></td>
			<td class='fields'>
			<input type=text name='print_dept_loc2' id='print_dept_loc2'  size='20' maxlength='6' <%if((print_res_at_dept_yn.trim()).equals("N"))out.println("disabled");%>  value="<%=res_dept_routine_queue_2%>"  onblur="setLocationThis10(this);"></td>
			<td class='fields'>
			<input type=radio name='print_report_dept_loc_radio' id='print_report_dept_loc_radio' onclick="setLocationDefaultThird(this);"
			<%if((res_dept_routine_queue_dflt.trim()).equals("1")) out.println("checked");%>
			<%if(!((res_dept_routine_queue_dflt.trim()).equals("1")||!((res_dept_routine_queue_1.trim()).equals(""))) ) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=radio name='print_report_dept_loc_radio' id='print_report_dept_loc_radio'  onclick="setLocationDefaultThird(this);"  <%=disabled%>
			<%if((res_dept_routine_queue_dflt.trim()).equals("2")) out.println("checked");%>
			<%if(!((res_dept_routine_queue_dflt.trim()).equals("2")||!((res_dept_routine_queue_2.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden  name="res_dept_routing_queue_dflt" id="res_dept_routing_queue_dflt" value="<%=res_dept_routine_queue_dflt%>"></td>
			</tr>
			<tr>
			<td class=label><fmt:message key="eOR.UrgStat.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=text name='print_urg_dept_loc1' id='print_urg_dept_loc1'  size='20' maxlength='6' <%if((print_res_at_dept_yn.trim()).equals("N"))out.println("disabled");%>    value="<%=res_dept_stat_queue_1%>" onblur="setLocationThis11(this);"></td>
			<td class='fields'>
			<input type=text name='print_urg_dept_loc2' id='print_urg_dept_loc2'  size='20' maxlength='6' <%if((print_res_at_dept_yn.trim()).equals("N"))out.println("disabled");%>  value="<%=res_dept_stat_queue_2%>" onblur="setLocationThis12(this);"></td>
			<td class='fields'>
			<input type=radio name='print_report_urg_dept_loc_radio' id='print_report_urg_dept_loc_radio'  onclick="setLocationDefaultThird(this);"
			<%if((res_dept_stat_queue_dflt.trim()).equals("1")) out.println("checked");%>
			<%if(!((res_dept_stat_queue_dflt.trim()).equals("1")||!((res_dept_stat_queue_1.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
			<td class='fields'>
			<input type=radio name='print_report_urg_dept_loc_radio' id='print_report_urg_dept_loc_radio' onclick="setLocationDefaultThird(this);"
			<%if((res_dept_stat_queue_dflt.trim()).equals("2")) out.println("checked");%>
			<%if(!((res_dept_stat_queue_dflt.trim()).equals("2")||!((res_dept_stat_queue_2.trim()).equals("")))) out.println("disabled");%>
			><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
			<input type=hidden name="res_dept_stat_queue_dflt" id="res_dept_stat_queue_dflt" value="<%=res_dept_stat_queue_dflt%>"></td>
			</tr>
			</table>
		</td>
		</tr>
	</table>

<%
			bean.setOperatingFacilityId(facility_id);
			String valid=bean.getLocation();
			String valid1=bean.getLocationForDisPat();
			ArrayList locspec=new ArrayList();
			ArrayList locspec1=new ArrayList();
                    /*if((valid.trim()).equals("S")){
						locspec=(ArrayList)bean.getLocationSpecific();
						}*/
			if(!mode.equals("1"))
			{
				valid=PRINT_RES_AT_OTHLOC.trim();
				valid1=PRINT_RES_FOR_DISCH_PAT.trim();
			}
			if((valid.trim()).equals("S"))
			{
				locspec=(ArrayList)bean.getLocationSpecific(null);
			}
			if ((valid1.trim()).equals("S")) 
			{
				locspec1=(ArrayList)bean.getLocationSpecific(null);
			}
%>

<table cellpadding=3 cellspacing=0 width="100%"  align=center border='0'>
	<tr>
	<td  class="label" nowrap width="25%"><fmt:message key="eOR.PrintatOtherLocation.label" bundle="${or_labels}"/></td>
	<td class="fields"><select name='otherloc' id='otherloc' onchange="fillLocation(this);">
	<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<option value='P' <% if((valid.trim()).equals("P")){out.println("selected"); status_select=true;}%>> <fmt:message key="eOR.PatientLoc.label" bundle="${or_labels}"/></option>
	<option value='S' <% if((valid.trim()).equals("S") )out.println("selected");%>><fmt:message key="eOR.SpecificLoc.label" bundle="${or_labels}"/></option>
	<option value='X' <% if((valid.trim()).equals("X"))out.println("selected");%>><fmt:message key="eOR.DonotPrint.label" bundle="${or_labels}"/></option>
	</select>
	<%

		String[] locationValue=new String[2];
		if(mode.equals("1"))
		{
			locationValue=bean.getDefaultLocation();
			OTHLOC_QUEUE_NAME=(String)locationValue[0];
			DISCH_PAT_QUEUE_NAME=(String)locationValue[1];
		}
	%>
	</td>

	<td id="location_id" class="label">
	<%	//valid = "S" ;
		if(status_select ==true)
		{
			
			%>
			<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.EnterLocation.label","or_labels")%>' Onclick='showwindow()'>
	<!-- 		 String el=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.EnterLocation.label","or_labels");
			out.println("<script>document.getElementById("location_id").innerHTML = \"<input type='button' class='button' value='\"+getLabel('eOR.EnterLocation.label','OR')+\" Onclick='showwindow()'>\"</script>");  -->
		<%
		}
		if((valid.trim()).equals("S"))
		{
		%>
			<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
		<%
		}
		%>
	<%-- </td>
         <td id='location_type' class='fields' nowrap>--%>  <!-- width='19%' -->

    		<% if ((valid.trim()).equals("S")) 
				{
    				String strSelected="";
					for(int i=0; i<locspec.size(); i++)
					{
						String[] record = (String [])locspec.get(i);
						if((OTHLOC_QUEUE_NAME.trim()).equals(record[0]))
						{
							strSelected=record[2];
							locspec=(ArrayList)bean.getLocationSpecific(record[2]);
						}
					}
			%>
    		<Select name='loctype' id='loctype' onChange="fillTypeLocation(this);">
    			<Option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</Option>
    			<Option value='C' <%if (strSelected.equals("C")) {out.println("selected");}%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></Option>
    			<Option value='N' <%if (strSelected.equals("N")) {out.println("selected");}%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></Option>
    		</Select>
    		<%}%>
    	 <%--</td>--%>
        
		<%--<td id="location_val" class='fields'> --%>
		<%if((valid.trim()).equals("S")){%>
		<select name='print_res_at_othloc' id='print_res_at_othloc' >
		<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%
		 for(int i=0;i<locspec.size();i++){
		String[] record=(String[])locspec.get(i);
	%>
		<option value=<%=record[0]%> <%if((OTHLOC_QUEUE_NAME.trim()).equals((String)record[0]))out.println("selected");%>><%=record[1]%></option>

		<%}%>
		</select><img align='center 'src="../../eCommon/images/mandatory.gif"></img>
		<%}%>
		</td>
			</tr>
			<%//boolean  flag = false;
			%>
			<tr>
		 <td class=label nowrap><fmt:message key="eOR.PrintLocationforDischargedPatients.label" bundle="${or_labels}"/></td>
		   <td class='fields'><select name='otherlocdis' id='otherlocdis' onchange="fillLocation(this);">
			<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value='P' <% if((valid1.trim()).equals("P"))
			{
			out.println("selected");
			//flag = true;
			}
			%>><fmt:message key="eOR.PatientLoc.label" bundle="${or_labels}"/></option>
			<option value='S' <% if((valid1.trim()).equals("S"))out.println("selected");%>><fmt:message key="eOR.SpecificLoc.label" bundle="${or_labels}"/></option>
			<option value='X' <% if((valid1.trim()).equals("X"))out.println("selected");%> ><fmt:message key="eOR.DonotPrint.label" bundle="${or_labels}"/></option>
			</select></td>
		<%--<td class='label' id ='td'></td>--%>
			<%-- if(flag == true)
			{
				String text = bean.getdisloc();
				if(status == false)
				{
					out.println("<script>document.getElementById("td").innerHTML=\"<fmt:message key=\"Common.Location.label\" bundle=\"${common_labels}\"/><INPUT type='text'  value='"+text+"' name='disPatLoc' id='disPatLoc' >\";</script>");
				}
				else
				{
					out.println("<script>document.getElementById("td").innerHTML=\"<fmt:message key=\"Common.Location.label\" bundle=\"${common_labels}\"/><INPUT type='text'  value='' name='disPatLoc' id='disPatLoc' >\";</script>");
				}
			}--%>
			
			<td id="deafult_id" class="label" nowrap>
			<%	if((valid1.trim()).equals("S") || (valid1.trim()).equals("P")){%>
			<%--<script>document.getElementById("td").innerHTML=""</script>--%>
			<fmt:message key="Common.Location.label" bundle="${common_labels}"/><%}%>
			<%--</td>
			<td id='default_type' class=fields nowrap>--%>
 		<% if ((valid1.trim()).equals("S")) {
				String strSelected="";
				for(int i=0; i<locspec1.size(); i++){
					String[] record = (String [])locspec1.get(i);
					if((DISCH_PAT_QUEUE_NAME.trim()).equals(record[0])){
						strSelected=record[2];
						locspec1=(ArrayList)bean.getLocationSpecific(record[2]);
					}
				}
			%>
            <Select name='loctype1' id='loctype1' onChange='fillTypeLocation(this);'>
            	<Option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --</Option>
    			<Option value='C' <%if (strSelected.equals("C")) {out.println("selected");}%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></Option>
    			<Option value='N' <%if (strSelected.equals("N")) {out.println("selected");}%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></Option>
    		</Select>
            <%} else if ((valid1.trim()).equals("P")) {
				String text = bean.getdisloc();%>
				<INPUT type='text'  value='<%=(status == false)?text:""%>' name='disPatLoc' >
            <%}%>
            <%--</td>--%>

		<%

			if((valid1.trim()).equals("S")){
			//locspec1=(ArrayList)bean.getLocationSpecificForDisch();
		%>
            
		<%--<td id="default_val" class='fields'>--%>
			<select name='print_des_at_othloc' id='print_des_at_othloc' >
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><%
			for(int i=0;i<locspec1.size();i++){
			String[] record=(String[])locspec1.get(i);
		%>
			<option value=<%=record[0]%> <% if((DISCH_PAT_QUEUE_NAME.trim()).equals((String)record[0]))out.println("selected");%> ><%=record[1]%></option>
		<%}%>
			</select><img src="../../eCommon/images/mandatory.gif" align=center></img>
		<%} else {%>
		<%--<td id="default_val">--%>
			<%}%>
			</td>
		</tr>
	</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value=<%=function_id%>>
<input type="hidden" name="facility_id" id="facility_id" value=<%=facility_id%>>



<input type="hidden" name="print_dept_loc111" id="print_dept_loc111" value="">
<input type="hidden" name="print_dept_loc211" id="print_dept_loc211" value="">
<input type="hidden" name="print_report_dept_loc_radio11" id="print_report_dept_loc_radio11" value="">
<input type="hidden" name="print_urg_dept_loc111" id="print_urg_dept_loc111" value="">
<input type="hidden" name="print_urg_dept_loc211" id="print_urg_dept_loc211" value="">
<input type="hidden" name="print_report_urg_dept_loc_radio11" id="print_report_urg_dept_loc_radio11" value="">
<input type="hidden" name="order" id="order" value="<%=order_type_code%>">
<input type="hidden" name="patient" id="patient" value="<%=patient_class1%>">
<input type="hidden" name="short_desc" id="short_desc" value="<%=short_desc1%>">
<input type="hidden" name="hidden1" id="hidden1" value="<%=OTHLOC_PAT_ROUTINE_QUEUE_1%>">
<input type="hidden" name="hidden2" id="hidden2" value="<%=OTHLOC_PAT_ROUTINE_QUEUE_2%>">
<input type="hidden" name="hidden3" id="hidden3" value="<%=OTHLOC_PAT_ROUTINE_QUEUE_DFLT%>">
<input type="hidden" name="hidden4" id="hidden4" value="<%=OTHLOC_PAT_STAT_QUEUE_1%>">
<input type="hidden" name="hidden5" id="hidden5" value="<%=OTHLOC_PAT_STAT_QUEUE_2%>">
<input type="hidden" name="hidden6" id="hidden6" value="<%=OTHLOC_PAT_STAT_QUEUE_DFLT%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

</form>
</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

