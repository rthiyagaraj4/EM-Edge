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
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>

	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String p_user_name= (String) session.getValue( "login_user" ) ;
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	 <script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>  
	<script language="javascript" src="../../ePH/js/PendingMedicationOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	// Added for MOHE-CRF-0074 - END
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean			= (PHReportsBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String myLoginFacilityId = bean.getLoginFacilityId ();
	String  patient_dtl="";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	ArrayList alPatientDetails = null;
	if(patient_id!= null && !patient_id.equals(""))
		alPatientDetails = bean.getPatientDetails(patient_id);
	if(alPatientDetails !=null && alPatientDetails.size()>0){
		patient_dtl			=""+alPatientDetails.get(0)+"/"+alPatientDetails.get(1)+"/"+alPatientDetails.get(2);
	}
	String order_facility_id="",order_facility_name=""; //Added for MOHE-CRF-0074
	 String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	 ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >						
		<form name="formPendingOrderCriteria" id="formPendingOrderCriteria"  >
			<table cellpadding="0" cellspacing="0" width="94%" align="center" border="0">
				  <tr> <td class="label" colspan="4">&nbsp;</td></tr>	
				  <tr>	
				
					<td  class="label" width="7%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td width='12%'>&nbsp;<input type="text" name="patient_id" id="patient_id" maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" size="20" onChange="Duplicatecheck();getPatientDtl(this,'<%=bean.getPatientIDLength()%>');"  value='<%=patient_id%>'><input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPendingOrderCriteria.patient_id)"><img src="../../eCommon/images/mandatory.gif" align="center"></td><!-- Duplicatecheck() added for ML-BRU-SCF-0621[IN036565]-->
					<td  class="label" width="8%" ><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
					<td width='14%'>
						<SELECT name="order_facility" id="order_facility">
							<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%				 if(region_check){ // MOHE-CRF-0074-Start
				   for (int i=0;i<region_code_check.size();i+=2){
						order_facility_id=(String)region_code_check.get(i);
						order_facility_name=(String)region_code_check.get(i+1);
%>
						<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<% 
					}
				}else{ //Added for MOHE-CRF-0074-End
							ArrayList order_facilities = (ArrayList) bean.getOrderingFacilities(p_user_name,locale);
							if(order_facilities.size()!=0){
								for(int i=0; i<order_facilities.size();i++){	
%>
									<OPTION VALUE="<%=(String)order_facilities.get(i++)%>" ><%=(String)order_facilities.get(i)%></OPTION>
<%
								}
							}
				} //Added for MOHE-CRF-0074
%>
						  </SELECT></td>
					<td class="label" width='9%' ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td width='13%'><input type="text" name="disp_location" id="disp_location"  size="20" onfocus="callDispLocSearch(this)"><input type="button" class="button" value="?" name="disp_loc_search" id="disp_loc_search" onClick="callDispLocSearch(disp_location)"></td>
<!--					<td width='15%'>&nbsp; 
						  <SELECT name="disp_location" id="disp_location">
							  <OPTION VALUE="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</OPTION>
							  <%	ArrayList displocn=(ArrayList)bean.getAllDispLocn();
									if(displocn.size()!= 0 ){
										for(int i=0;i<displocn.size();i+=2){ %>
											<OPTION VALUE="<%=(String)displocn.get(i)%>"><%=(String)displocn.get(i+1)%></OPTION>
										<%}
									}%>
						 </SELECT>
					</td>						-->
			</tr>
			<br>
			<tr>
				<td colspan="5"   class="label" nowrap> <fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/>:&nbsp;&nbsp; <label id='patientDetails'><b><%=patient_dtl%></b></label>
				</td>
				<td align="right">&nbsp;&nbsp;<input type="button" class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="loadorders()" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
		</table>	
		<input type="hidden" name="SQL_PH_DISP_LOCN_LANG_VW_SELECT" id="SQL_PH_DISP_LOCN_LANG_VW_SELECT" value="SELECT A.DISP_LOCN_CODE code,SHORT_DESC description FROM PH_disp_locn_lang_vw A WHERE  A.FACILITY_ID LIKE ? AND upper(DISP_LOCN_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND A.DISP_LOCN_TYPE='P' and a.language_id=">
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		<% putObjectInBean(bean_id,bean,request); %>
	</form>
</body>
<%} // Added for MOHE-CRF-0074 - start
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->
</html>

