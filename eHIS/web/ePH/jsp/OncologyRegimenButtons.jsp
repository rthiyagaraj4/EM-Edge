<!DOCTYPE html>
<% 
 /*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date			Rev.Name					Description
--------------------------------------------------------------------------------------------------------------
14/12/2020			6041			Shazana       	14/12/2020				Manickavasagam J		NMC-JD-CRF-0063
--------------------------------------------------------------------------------------------------------------
*/
%>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/OncologyRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
<%
	Connection con			= null;//added for NMC-JD-CRF-0063
	try{
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name		= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	String disable_yn  		= request.getParameter("disable_yn");
	

//out.println("@@@12===Order_Date=in valiate="+bean.getOrderDate());
	if(disable_yn==null || disable_yn.equals("")) 
		disable_yn = "Y";
	String chrgeDtlsdisabledButton	= "DISABLED";
	
	String amend_yn			= "";
	String disable_flag     ="Y";
	ArrayList drugList		= bean.getDrugDetails();
	for(int i=0;i<drugList.size();i++) {
			HashMap drugDetails = (HashMap)drugList.get(i);
			if (drugDetails!=null && drugDetails.size() > 0){
				 amend_yn	= (String)drugDetails.get("AMEND_YN")==null?"":(String)drugDetails.get("AMEND_YN");
				 if(amend_yn.equals("N"))
				 {
					 disable_flag="Y";
					 break;
				 }else{
                     disable_flag="N";
				 }
            }

      }   
	  boolean check_flag=false;
	  if(drugList.size()==0){
		  check_flag=true;

	  }
	 if(disable_flag.equals("Y")) {
         chrgeDtlsdisabledButton		= "DISABLED";
	 } else {
		 chrgeDtlsdisabledButton		= "";
	 }


//	String disable_yn  		= request.getParameter("disable_yn");
	String order_type_flag  = request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String disabledButton	= "";
	String amendDisabled	= "";


	if((order_type_flag!=null && order_type_flag.equals("Existing"))||disable_yn.equals("Y")) 
		amendDisabled = "disabled";


	if(disable_yn.equals("N"))  
		disabledButton = "";
	else 
		disabledButton		= "DISABLED";
	String dflt_disp_locn  = "";
	String	bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String	bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	String iv_prep_yn		= "9";
   String alert_practitioner_yn="";
   con				= ConnectionManager.getConnection(request);//added for NMC-JD-CRF-0063 start
   boolean op_take_home_med_flag = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "OP_TAKE_HOME_MEDICATION");
   PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;
   String patient_class = bean.getPatientClass();
	System.out.println("patient_Class: "+patient_class);  
	if(patient_class!=null){
		if(patient_class.equals("EM")|| patient_class.equals("OP")){
			if(op_take_home_med_flag){
				bean.setTakeHomeMedicationOp("Y");
			}else{
				bean.setTakeHomeMedicationOp("N");
			} 
		}
	}
	if(beanPres.getOpDischMedInd()==null){
		bean.setOpDischMedInd("N");
	}
	else if(beanPres.getOpDischMedInd()!=null){
		bean.setOpDischMedInd(beanPres.getOpDischMedInd());
	}
	if(beanPres.getPatient_class_tkHome().equals("IP")){
		bean.setTakeHomeMedicationOp("N");  
	} //end
%>
	<!-- <body> -->
	<body onMouseDown="" onKeyDown=""> 
		<form name="OncologyRegimenPrescriptionButtons" id="OncologyRegimenPrescriptionButtons">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			<tr>
				<td align="left" class="label" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>
				<b><label class="label" id="dflt_disp_locn_lbl" name="dflt_disp_locn_lbl" >&nbsp;<%=dflt_disp_locn%><label></b>
				</td>
				<td align="center">
<%
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
						<INPUT TYPE="button" CLASS="button" name="ChargeDetails" id="ChargeDetails" VALUE='<fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>' onClick="displayChargeDetails('<%=iv_prep_yn%>')"  <%=chrgeDtlsdisabledButton%> >

<%
					}
%>
					<input type="button" class="button" name="CONFIRM" id="CONFIRM" value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>' onClick="callAmend()" <%=disabledButton%>>    
					<input type="button" class="button" name="CANCEL" id="CANCEL" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="callCancel()" <%=amendDisabled%>>
				</td>

				<td align="right" >   
					<input type="button" CLASS="button" name="RESET" id="RESET" VALUE= '<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetscreens()">
					<input type="button" CLASS="button" name="CLEAR" id="CLEAR" VALUE= '<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="callClearAll(1)" <%=amendDisabled%>>&nbsp;&nbsp;			
				</td>
			</tr>
			</table>
			<input type='hidden' name='iv_prep_yn' id='iv_prep_yn' value='<%=iv_prep_yn%>'>
			<input type="hidden" name="time_flag" id="time_flag"	value=''>
			<%if(!order_type_flag.equals("Existing")){  
			   HashMap record1=bean.ChkAdMixture();
			    alert_practitioner_yn=(String)record1.get("ALERT_PRACTITIONER_YN");
			}%>
			<input type="hidden" name="alert_practitioner_yn" id="alert_practitioner_yn"	value="<%=alert_practitioner_yn%>">
		</form>
		<%if(!order_type_flag.equals("Existing")){ 			  
			if(check_flag){
		%>
			 <script> 
			          
					 setTimeout("checkadmixture();",1500);	
			</script>
			 <%}
		}%>
	</body>
</html>
<% } //added for NMC-JD-CRF-0063
	catch(Exception e){
		e.printStackTrace();
}
	finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
%>

