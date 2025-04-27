<!DOCTYPE html>
  <!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ -->
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.text.*, java.lang.*, java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.* ,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- <Modified for MOHE-CRF-0074 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
        request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
 		request= new XSSRequestWrapper(request); 
 		response.addHeader("X-XSS-Protection", "1; mode=block"); 
 		response.addHeader("X-Content-Type-Options", "nosniff"); 
 		//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
	  	String login_user	=	(String)session.getValue("login_user");
		String facility_id   = (String)session.getValue( "facility_id" );

	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../js/WardReturn.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 END-->
 </head>

<body onMouseDown="" onKeyDown="lockKey()" >
<%
	Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	  boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK"); 
	// Added for MOHE-CRF-0074 - END
	String dispLocn="";
	String password="";
	String cutoff="";

    String QueryMode	= CommonBean.checkForNull(request.getParameter("QueryMode"));
	//out.println("QueryMode----->"+QueryMode);
  
	String mode			= request.getParameter("mode");
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
	String bean_id		= "WardReturnBean"+login_at_ws_no;
    String bean_name	= "ePH.WardReturnBean";
  	String order_facility_id=""; 
    String order_facility_name="";
	String trade_flag="";

	WardReturnBean bean = (WardReturnBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	bean.getScannedBatchDetails().clear(); // Added for GHL-CRF-0413.8
	bean.getscannedDetails().clear();  // Added for GHL-CRF-0413.8

	 dispLocn=request.getParameter("dispLocn");
	 password=request.getParameter("password");
	 cutoff=bean.getCutOff();

	StringTokenizer cutoffTmp = new StringTokenizer(cutoff, " ");
	String onlyDate=cutoffTmp.nextToken();
	
	ArrayList fromStoredispLocn=new ArrayList();
	fromStoredispLocn=bean.getDispLocn("O",locale);
	ArrayList OrderingFacility=bean.getOrderingFacilityId(login_user);
	// ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start
	ArrayList from_and_to_date=bean.getFrom_and_To_date();//added for performance tuning start
	String todate=(String)from_and_to_date.get(0);
	String fromdate=(String)from_and_to_date.get(1);//added for performance tuning end	
	String sys_date				  = "";
	sys_date					  = com.ehis.util.DateUtils.getCurrentDate("DMY","en");
	
	// ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 end

	// Added for AMS-SCF-0190 IN038440- start
	trade_flag=bean.getEffectiveFlag();
	if(trade_flag!=null && trade_flag.equals("Y")){
		bean.setTradeName_Flag(trade_flag);
	} 	// Added for AMS-SCF-0190 IN038440- end
	
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(login_user,region_code); //Added for MOHE-CRF-0074
	%>
<form name="FormWardReturnQueryCriteria" id="FormWardReturnQueryCriteria" >
 <table cellpadding=1 cellspacing=0 width="100%"  align="center" border="0" >
    <%if(!QueryMode.equals("2")){%>
		<tr>
		 <td class="label" width='20%'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
		  <td class="label" width='30%'><select name="OrderingFacility" id="OrderingFacility" onChange="">
			   <%
			 //MOHE-CRF-0074-Start 
				if(region_check){
				for (int i=0;i<region_code_check.size();i+=2){
					order_facility_id=(String)region_code_check.get(i);
					order_facility_name=(String)region_code_check.get(i+1);
					if(facility_id.equals(order_facility_id))	{
%>
					<option value='<%=order_facility_id%>' selected><%=order_facility_name%></option>
<%
					}
					else{
%>
					<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%
						}
					}
				}else{  //MOHE-CRF-0074-End
				for (int i=0;i<OrderingFacility.size();i+=2){
					order_facility_id=(String)OrderingFacility.get(i);
					order_facility_name=(String)OrderingFacility.get(i+1);
					 if(facility_id.equals(order_facility_id))	{
			%>
				<option value='<%=order_facility_id%>'selected><%=order_facility_name%></option>
				
			<%}else{%>
				  <option value='<%=order_facility_id%>'><%=order_facility_name%></option>
			   <%}
			}
		} //Added for MOHE-CRF-0074
			%></SELECT></td>
			<!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start -->
			<td class='label' width="20%"><fmt:message key="ePH.ReturnRequest.label" bundle="${ph_labels}"/></td>
			<td align="left" class="label"  name="wardReturnYN" ><input type="checkbox" name="wardReturn_YN" id="wardReturn_YN" value="N" onclick="SelectwardReturnChk(this)"></td>
			<!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 end -->
		</tr>
	<%}%>
	<tr>	
		  <td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		  <td class='label' ><input type="text" name="Patient_Id" id="Patient_Id" size="20" 
			maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()"><INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.FormWardReturnQueryCriteria.Patient_Id)" >
			&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start -->
				<td align="left" class="label" id="fromdate_label" style="display: none"><fmt:message key="ePH.ReturnRequested.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"id="fromdate_value" style="display: none"  ><input type=text  name="Ward_Date_From" id="Ward_Date_From" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');"value="<%=fromdate%>"> <!--validateDate(this) changed to CheckDateLeap(this,'DMY','<%=locale%>') for SRR-SRR20056-SCF-9374 [IN 56956] -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar2" onclick="return showCalendar('Ward_Date_From');">
					&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
					</td>
					<td align="left"class="label" id="todate_label" style="display: none" ><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
					<input type=text  name="ward_Date_To" id="ward_Date_To" size=8 maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');" value="<%=todate%>">&nbsp;<!--validateDate(this) changed to CheckDateLeap(this,'DMY','<%=locale%>') for SRR-SRR20056-SCF-9374 [IN 56956] -->
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar3"  onclick="return showCalendar('ward_Date_To');">
					&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
					</td>
					
			<!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start -->		
		
	</tr>
	<tr>
	    <td class="label" ><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
		<td class="label" ><input type="text" name="Drug_Name" id="Drug_Name" size="20" maxlength="20"><INPUT TYPE="button" name="Drug_Name_Button" id="Drug_Name_Button" VALUE="?" CLASS="button"  onClick="drugsearch(document.FormWardReturnQueryCriteria)"></td>
		<!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start -->
		<td class="label" width='20%'><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
		<td class='label' width='*'><input type="text" name="Dispense_No" id="Dispense_No" size="15"  maxlength="15" ></td>
	<!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 end-->
	
		</td>
		<%if(QueryMode.equals("2")){%>
		<td class="label" ><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></td>
		<td class="label"><input type="text" name="disp_locn" id="disp_locn" size="20" onKeyPress="uppercase()" onBlur="clearDispLocn(this);"><INPUT TYPE="button" name="drug_lookup" id="drug_lookup" VALUE="?" CLASS="button"  onClick="searchDispLocn(disp_locn)" ><input type="hidden" name="disp_code" id="disp_code">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
		
		<%}%>
	</tr>
	<tr>
		<td class="label" colspan="4">&nbsp;&nbsp;</td>
	</tr>
	<tr>
<%
			if(!QueryMode.equals("2")){
%>
				 <td  class="label" ><fmt:message key="Common.CutOffDate.label" bundle="${common_labels}"/></td>
				 <td   class="label" ><b><%=com.ehis.util.DateUtils.convertDate(onlyDate,"DMY","en",locale)%></b></td>
<%
			}
			else{
%>
			<td class="label" colspan="2">&nbsp;&nbsp;</td>
<%
			}
%>        <td class="label" >&nbsp;&nbsp;</td><!-- ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016  -->
			<td class="label" >&nbsp;&nbsp;</td>
		  <td  class="button" ><input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onclick="callResultPage('<%=QueryMode%>')" >&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
</table>
<input type="hidden" name="Order_Id" id="Order_Id" value=""> 
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">

<input type="hidden" name="Drug_Code" id="Drug_Code" value="">
<input type="hidden" name="CutOff" id="CutOff" value="<%=cutoff%>">
<input type="hidden" name="dispLocn" id="dispLocn" value=<%=dispLocn%> >
<input type="hidden" name="FormStore" id="FormStore" value="" >
<input type="hidden" name="QueryMode" id="QueryMode" value="<%=QueryMode%>" >
<input type="hidden" name="password" id="password" value="<%=password%>" >
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>" >
<input type="hidden" name="locale" id="locale" value="<%=locale%>" >
<INPUT TYPE="hidden" name="systemdate" id="systemdate" VALUE="<%=sys_date%>">
<% putObjectInBean(bean_id,bean,request); } catch(Exception e){e.printStackTrace();}
finally{  //Added for MOHE-CRF-0074
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}%> <!-- Added for MOHE-CRF-0074 -->
 </form>
 <script>
 
	//document.FormWardReturnQueryCriteria.OrderingFacility.focus();
	</script>
</body>
</html>

