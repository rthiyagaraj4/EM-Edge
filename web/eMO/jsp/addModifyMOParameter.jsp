<!DOCTYPE html>

<!-- 
Created On	: 14/6/2004
Module		: Martuary Management(MO)
Function	: MO PARAMETER
Description : In this function Billing Interface checkbox enabled or disbaled depending on the value in the  sm_module (coloum name:install_yn )table
-->
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
  <head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		 <script language='javascript' src='../../eMO/js/MOParameter.js'></script>
		 <script language='javascript' src='../../eCommon/js/common.js'></script>
		 <Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><!-- Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013-->			 
		 <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
		 <!-- Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013 Start -->
		 function FnGetServiceDetails(dept_code){
			 $('#service_code')
			 .find('option')
			 .remove()
			 .end()
	         .append($("<option></option>")
	         .attr("value","")
	         .text("---"+getLabel('Common.defaultSelect.label','Common')+"---"));
			 
			if(dept_code!=""){
				 $.ajax({  
				     url:'../../eMO/jsp/getdetailsMO.jsp',  
				     type:'post',  
				     data:{'action':'get_service_details','dept_code':dept_code},
				     dataType: 'json',
				     success: function(data) {
				    	 var recordlist	= "";
				    	 if(data.rowcnt > 0){
					    	recordlist		= eval(data.recordslist);
					    	$.each(recordlist, function(index,val) {  
					    	     $('#service_code')
					    	         .append($("<option></option>")
					    	         .attr("value",val.service_code)
					    	         .text(val.short_desc)); 
					    	});
				    	 }
				    	 
				     },
				     error: function(jqXHR, textStatus, errorThrown) {
				         alert("incoming Text " + jqXHR.responseText);
				     }
				 });
			}
		 }
		
		 </script>
		 <!-- Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013 End -->
  </head>
 <%	
		 Connection con						= null;
		 java.sql.Statement stmt			= null;
		 ResultSet rset						= null; 
		 PreparedStatement pstmt			= null;
		 String  sql1						= "";
		 String mode						= "";
	     request.setCharacterEncoding("UTF-8");
		 String	facilityId                  = (String) session.getValue( "facility_id" ) ;
		 
		 /*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
		 Boolean isPoliceDtlsMandAppl		= false;
		 Boolean isBIDRegnAppl				= false;
		 Boolean isBodyPartRegnAppl			= false;
		 String police_dtls_mand			= "";
		 String police_dtls_mand_checked	= "";
		 String pat_series_code_bodyPart	= "";
		 String pat_series_code_bid			= "";
		 /*End*/
		 /*added by mujafar for ML-MMOH-CRF-0880 start */
		 Boolean isPMFindingDetailsAppl  = false;
		 String record_pm_find_dtls_yn = "";
		 String record_pm_find_dtls_checked="";
		 /*end*/
	
		 String enable_RFID_checked = "";  // added by mujafar for ML-MMOH-CRF-0996
		 String enable_rfid_yn = "";
	try
    {
		 con							    = ConnectionManager.getConnection(request);
		 //String DIRECT_REGN_YN			    = "";
		 String BL_INTERFACE_YN				= "";
		 String DAYS_TO_PRES_UNKNOWN_BODY	= "";   
		 String CUT_OFF_PRD_LESS_THAN_HRS   = "";
		 String CUT_OFF_PRD_MORE_THAN_HRS	= "";	
    	 String checkBoxAttribute1			= "";
    	 String burialPermitcheckBox		= "";
		 String burial_permit_reqd_yn = "Y";   //Changes introduced for Bru-HIMS-CRF-161 [IN:030280] and KDAH-CRF-0038 [IN:029002] on 13.03.2012 by Suresh M
		 String disabledField				= "";
		 String dept_code					= "";
		 String ORDER_CATALOG_CODE_CL		= "";
		 String ORDER_CATALOG_CODE_ML		= "";
		 String or_install_yn				= "";
		 String ORDER_CATALOG_DESC_CL_PM    = "";
		 String ORDER_CATALOG_DESC_ML_PM    = "";
		 String orderCatCL                  = "";
		 String orderCatML                  = "";
		 String next_burial_permit_no       = "";
		 String queue_refresh_interval      = "";
		 /*Added by santhosh for ML-MMOH-CRF-1947 Start*/
		 Boolean maxSizeBurialPermitAppl = false;
		 maxSizeBurialPermitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MAX_SIZE_BURIAL_PERMIT");
		 String max_size_burial_permit_no       = "";
		 /*End*/
		 
		 /*Added by Santhosh for ML-MMOH-CRF-1948*/
		 String datetime_claim_mand="";
		 Boolean datetimeOfClaimingAppl = false;
		 datetimeOfClaimingAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","DATETIME_OF_CLAIMING");
		 /*End*/
		
		 /*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
		 isBIDRegnAppl			= eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MO_BID_REGN");
		 isBodyPartRegnAppl		= eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MO_EXT_BODY_PART_REGN");
		 isPoliceDtlsMandAppl	= eCommon.Common.CommonBean.isSiteSpecific(con,"MO","MO_POLICE_DTLS_MAND");
		 /*End*/
		 
		 isPMFindingDetailsAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MO","PM_FINDING_DETAILS_ALLOW_YN"); //added by mujafar for ML-MMOH-CRF-0880
		 
		 mode								= "INSERT";
		 String dflt_service_code	    = ""; //Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013	
         //Checking for Billing Option in SM_MODULE
		 stmt=con.createStatement();
		 sql1="select count(*) CNT from sm_module where MODULE_ID='BL' and  INSTALL_YN='Y' ";
		 rset= stmt.executeQuery(sql1);
		 while(rset!=null  && rset.next())
		  {	 
			   if (rset.getInt(1)==0)
					disabledField= "DISABLED";
			   else 
					disabledField = "";  

		   }			
	     if(rset!=null) rset.close();

		 String sql2="select operational_yn from sm_modules_facility where module_id='OR' and facility_id='"+facilityId+"'";
		 rset =stmt.executeQuery(sql2);
		 if(rset != null)
		 {
		    while(rset.next())
			{
				or_install_yn =rset.getString(1);
				if(or_install_yn == null) or_install_yn="N";
			} 
		 }
		 
		 if(rset != null) rset.close();
	     if(stmt!=null) stmt.close();

		
		 StringBuffer sql =new StringBuffer();
		 sql.setLength(0);
		 
		 
		 if(or_install_yn.equals("Y"))
		 {
		 //sql.append("select a.BL_INTERFACE_YN BL_INTERFACE_YN,a.DAYS_TO_PRES_UNKNOWN_BODY DAYS_TO_PRES_UNKNOWN_BODY,a.CUT_OFF_PRD_MORE_THAN_HRS CUT_OFF_PRD_MORE_THAN_HRS,a.CUT_OFF_PRD_LESS_THAN_HRS CUT_OFF_PRD_LESS_THAN_HRS,a.dept_code dept_code,a.ORDER_CATALOG_CODE_CL_PM ORDER_CATALOG_CODE_CL_PM,b.short_desc ORDER_CATALOG_DESC_CL_PM,a.ORDER_CATALOG_CODE_ML_PM ORDER_CATALOG_CODE_ML_PM,c.short_desc ORDER_CATALOG_DESC_ML_PM,NEXT_BURIAL_PERMIT_NO, NVL(QUEUE_REFRESH_INTERVAL,0) QUEUE_REFRESH_INTERVAL,a.burial_permit_reqd_yn, NVL(MAX_SIZE_BURIAL_PERMIT_NO,0) MAX_SIZE_BURIAL_PERMIT_NO, DATETIME_CLAIM_MAND from mo_parameter a, or_order_catalog b, or_order_catalog c where a.ORDER_CATALOG_CODE_CL_PM=b.ORDER_CATALOG_CODE(+) and a.ORDER_CATALOG_CODE_ML_PM=c.ORDER_CATALOG_CODE(+) and a.facility_id=? ");
		// sql.append("select a.BL_INTERFACE_YN BL_INTERFACE_YN,a.DAYS_TO_PRES_UNKNOWN_BODY DAYS_TO_PRES_UNKNOWN_BODY,a.CUT_OFF_PRD_MORE_THAN_HRS CUT_OFF_PRD_MORE_THAN_HRS,a.CUT_OFF_PRD_LESS_THAN_HRS CUT_OFF_PRD_LESS_THAN_HRS,a.dept_code dept_code,NEXT_BURIAL_PERMIT_NO, NVL(QUEUE_REFRESH_INTERVAL,0) QUEUE_REFRESH_INTERVAL,a.burial_permit_reqd_yn,NVL(MAX_SIZE_BURIAL_PERMIT_NO,0) MAX_SIZE_BURIAL_PERMIT_NO, DATETIME_CLAIM_MAND from mo_parameter a where  a.facility_id=? ");
		 //dflt_service_code Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013
		 sql.append("select a.dflt_service_code,a.BL_INTERFACE_YN BL_INTERFACE_YN,a.DAYS_TO_PRES_UNKNOWN_BODY DAYS_TO_PRES_UNKNOWN_BODY,a.CUT_OFF_PRD_MORE_THAN_HRS CUT_OFF_PRD_MORE_THAN_HRS,a.CUT_OFF_PRD_LESS_THAN_HRS CUT_OFF_PRD_LESS_THAN_HRS,a.dept_code dept_code,NEXT_BURIAL_PERMIT_NO, NVL(QUEUE_REFRESH_INTERVAL,0) QUEUE_REFRESH_INTERVAL,a.burial_permit_reqd_yn,police_dtls_reqd_yn,pat_series_for_body_part,pat_series_for_bid,pm_dtls_reqd_yn,enable_rfid_yn, NVL(MAX_SIZE_BURIAL_PERMIT_NO,0) MAX_SIZE_BURIAL_PERMIT_NO, DATETIME_CLAIM_MAND from mo_parameter a where  a.facility_id=? "); // added by mujafar for ML-MMOH-CRF-0996 
		 //modified by mujafar for ML-MMOH-CRF-0880
		 //Modified by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 
		 }else{
			 sql.append("select * from mo_parameter where facility_id=? ");
		 }
			
		 pstmt		      = con.prepareStatement(sql.toString());
		 pstmt.setString(1,facilityId);
		 rset	          = pstmt.executeQuery();
				 		 
		 sql.setLength(0);
		 while(rset!=null && rset.next())
		  {
				//DIRECT_REGN_YN		        = rset.getString("DIRECT_REGN_YN");
                BL_INTERFACE_YN               =rset.getString("BL_INTERFACE_YN");
				//if(DIRECT_REGN_YN!=null && DIRECT_REGN_YN.equalsIgnoreCase("Y"))
				DAYS_TO_PRES_UNKNOWN_BODY	= rset.getString("DAYS_TO_PRES_UNKNOWN_BODY");
				CUT_OFF_PRD_MORE_THAN_HRS	= rset.getString("CUT_OFF_PRD_MORE_THAN_HRS");
				CUT_OFF_PRD_LESS_THAN_HRS	= rset.getString("CUT_OFF_PRD_LESS_THAN_HRS");
				dept_code                   = rset.getString("dept_code");
				//ORDER_CATALOG_CODE_CL		= rset.getString("ORDER_CATALOG_CODE_CL_PM");
				//if(ORDER_CATALOG_CODE_CL == null) ORDER_CATALOG_CODE_CL ="";
				//ORDER_CATALOG_CODE_ML       = rset.getString("ORDER_CATALOG_CODE_ML_PM");
				//if(ORDER_CATALOG_CODE_ML == null) ORDER_CATALOG_CODE_ML =""; 
				burial_permit_reqd_yn =  rset.getString("burial_permit_reqd_yn")==null?"Y":rset.getString("burial_permit_reqd_yn");
				
				/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
				police_dtls_mand			=  rset.getString("police_dtls_reqd_yn");
				pat_series_code_bid			=  rset.getString("pat_series_for_bid")==null?"":rset.getString("pat_series_for_bid");
				pat_series_code_bodyPart	=  rset.getString("pat_series_for_body_part")==null?"":rset.getString("pat_series_for_body_part");
				/*End*/
				
				record_pm_find_dtls_yn     = rset.getString("pm_dtls_reqd_yn"); // added by mujafar for ML-MMOH-CRF-0880
				enable_rfid_yn = rset.getString("enable_rfid_yn"); // added by mujafar for ML-MMOH-CRF-0996

				if(or_install_yn.equals("Y"))
				{
				//ORDER_CATALOG_DESC_CL_PM    = rset.getString("ORDER_CATALOG_DESC_CL_PM");
				//ORDER_CATALOG_DESC_ML_PM    = rset.getString("ORDER_CATALOG_DESC_ML_PM");
				
				//if(ORDER_CATALOG_DESC_CL_PM == null) ORDER_CATALOG_DESC_CL_PM ="";
				//if(ORDER_CATALOG_DESC_ML_PM == null) ORDER_CATALOG_DESC_ML_PM ="";
				}
                next_burial_permit_no       = rset.getString("NEXT_BURIAL_PERMIT_NO");
				if(next_burial_permit_no == null) next_burial_permit_no ="1"; 
				queue_refresh_interval = rset.getString("QUEUE_REFRESH_INTERVAL");
				if(queue_refresh_interval == null) queue_refresh_interval =""; 
			    mode						= "MODIFY";
			    dflt_service_code		= (rset.getString("dflt_service_code")==null || rset.getString("dflt_service_code")=="")?"":rset.getString("dflt_service_code");//Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013
				
				max_size_burial_permit_no = rset.getString("MAX_SIZE_BURIAL_PERMIT_NO");//Added by santhosh for ML-MMOH-CRF-1947
				datetime_claim_mand = rset.getString("DATETIME_CLAIM_MAND");//Added by santhosh for ML-MMOH-CRF-1948

	      }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null) pstmt.close(); 
	  
	  if(BL_INTERFACE_YN.equals("Y"))
		{
		  checkBoxAttribute1="checked";
		}
		else
		{checkBoxAttribute1="";
		}

		if(burial_permit_reqd_yn.equals("Y"))
			 burialPermitcheckBox="checked";
		else
			 burialPermitcheckBox="";
		/*Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start*/
		if(police_dtls_mand.equals("Y"))
			 police_dtls_mand_checked = "checked";
		else
			 police_dtls_mand_checked = "";
		/*End*/
		
		
		
		/*added by mujafar for ML-MMOH-CRF-0880 Start*/
		if(record_pm_find_dtls_yn.equals("Y"))
			 record_pm_find_dtls_checked = "checked";
		else
			 record_pm_find_dtls_checked = "";
		/*End*/
		/*added by mujafar for ML-MMOH-CRF-0996 Start*/
		if(enable_rfid_yn.equals("Y"))
			 enable_RFID_checked = "checked";
		else
			 enable_RFID_checked = "";
		/*End*/
		
		
		

       if(!ORDER_CATALOG_CODE_CL.equals(""))
	   {
		   orderCatCL ="disabled";
	   }
	   else{  orderCatCL =""; }
       if(!ORDER_CATALOG_CODE_ML.equals(""))
	   {
		   orderCatML ="disabled";
	   }else{  orderCatML =""; }
%>
	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="parameter_form" id="parameter_form" action="../../servlet/eMO.MOParameterServlet" method="post" target="messageFrame">
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
	<tr>
		<td>
			<table border="0" cellpadding="4" cellspacing="0" align='center' width='100%'>
				<tr>	    		      
					<td class='label' width='50%'><fmt:message key="eAE.BillingInterface.label" bundle="${ae_labels}"/></td>
					<td class='fields'><input type='checkbox' name='billing_interfaced_yn' id='billing_interfaced_yn' value='<%=BL_INTERFACE_YN%>'<%=checkBoxAttribute1%>  onclick='chkValue(this)'<%=disabledField%>></td> 
				</tr>
				<tr>
					<td class='label' width='50%'><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name='department_code' id='department_code' onchange="FnGetServiceDetails(this.value)"><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						  <%
						  pstmt = con.prepareStatement("select DEPT_CODE,DEPT_SHORT_DESC from AM_FACILITY_DEPT_VW where eff_status='E' and operating_facility_id=? order by 2");
						  pstmt.setString(1,facilityId);
						  rset = pstmt.executeQuery();
						  while(rset.next())
						   {
							 if(dept_code.equals(rset.getString("dept_code")))
							 {
						   %>
						  <option value=<%=rset.getString("dept_code")%> selected><%=rset.getString("dept_short_desc")%></option>
						  <%}else
							{
						   %>
						  <option value=<%=rset.getString("dept_code")%> ><%=rset.getString("dept_short_desc")%></option>
						  <%
							}
						   }
						   %>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td> 			      
				</tr>
				<!-- Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013 Start-->
				
				<tr>
					<td class='label' width='50%'><fmt:message key="Common.Default.label" bundle="${common_labels}"/> <fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name='service_code' id='service_code' id="service_code"><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						  <%
						  System.err.println("dept_code==>"+dept_code);
						  if(rset!=null) rset.close();
					      if(pstmt!=null) pstmt.close();
					      
						  pstmt = con.prepareStatement("select SERVICE_CODE, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+localeName+"',2) short_desc from AM_FACILITY_SERVICE_VW a where eff_status='E' and operating_facility_id=? and dept_code=? order by short_desc");
						  pstmt.setString(1,facilityId);
						  pstmt.setString(2,dept_code);
						  rset = pstmt.executeQuery();
						  while(rset.next())
						   {
							 if(dflt_service_code.equals(rset.getString("SERVICE_CODE")))
							 {
						   %>
						  <option value=<%=rset.getString("SERVICE_CODE")%> selected><%=rset.getString("short_desc")%></option>
						  <%}else
							{
						   %>
						  <option value=<%=rset.getString("SERVICE_CODE")%> ><%=rset.getString("short_desc")%></option>
						  <%
							}
						   }
						   %>
					</select></td> 			      
				</tr>
				
				<!-- Added for Bru-HIMS-CRF-413 by Dharma on 12th Dec 2013 End-->
				
				
				<tr>
					<td class='label'><fmt:message key="eMO.NoOfDaysToPrsrvUnkwnBody.label" bundle="${mo_labels}"/> </td>
					<td class='fields'><input type='text' name='days_to_pres_unknown_body' id='days_to_pres_unknown_body' value='<%=DAYS_TO_PRES_UNKNOWN_BODY%>' maxLength='2' size='2' onKeyPress='return(ChkNumberInput(this,event,0))' onblur='ChkPosNum(this);'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>			
				</tr>
				<!--Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start-->
				<% if(isPoliceDtlsMandAppl){ %>
				<tr>
					<td class='label' width='50%'><fmt:message key="eMO.PoliceDetails.label" bundle="${mo_labels}"/>&nbsp;<fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='checkbox' name='police_dtls_mand_yn' id='police_dtls_mand_yn'  value='Y' <%=police_dtls_mand_checked%> ></td>							
				</tr>
				<% } %>
				<!--End-->
				<!--added by mujafar for ML-MMOH-CRF-0880 -->
				<% if(isPMFindingDetailsAppl){ %>
				<tr>
					<td class='label' width='50%'><fmt:message key="eMO.AllowUserRecordPMFindingDetails.label" bundle="${mo_labels}"/></td>
					<td class='fields'><input type='checkbox' name='record_pm_find_dtls_yn' id='record_pm_find_dtls_yn'  value='Y' <%=record_pm_find_dtls_checked%> ></td>							
				</tr>
				<% } %>
				
				<!--end -->
				
				<!--  added by mujafar for ML-MMOH-CRF-0996 start -->
				<tr> 
					<td class='label' width='50%'><fmt:message key="Common.Enable.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/></td>
					<td class='fields'><input type='checkbox' name='enable_RFID_yn' id='enable_RFID_yn'  value='Y' <%=enable_RFID_checked%> ></td>							
				</tr>
				<!--  end -->
				
				<!--  Added by Santhosh for ML-MMOH-CRF-1948 start -->
				<%if(datetimeOfClaimingAppl){%>
				<tr> 
					<td class='label' width='50%'><fmt:message key="eMO.DateTimeOfClaimingMandatory.label" bundle="${mo_labels}"/></td>
					<td class='fields'><select name='datetime_claim_mand' id='datetime_claim_mand'><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%if(datetime_claim_mand == null || datetime_claim_mand == ""){%>
						<option value='D'><fmt:message key="eMO.DeceasedReg.label" bundle="${mo_labels}"/></option>
						<option value='R'><fmt:message key="eMO.ReleaseDeceasedBodyPart.label" bundle="${mo_labels}"/></option>
					<%}else{
						if(datetime_claim_mand.equals("D")){%>
						<option value='D' selected><fmt:message key="eMO.DeceasedReg.label" bundle="${mo_labels}"/></option>
						<option value='R'><fmt:message key="eMO.ReleaseDeceasedBodyPart.label" bundle="${mo_labels}"/></option>
						<%}else if (datetime_claim_mand.equals("R")){%>
						<option value='R' selected><fmt:message key="eMO.ReleaseDeceasedBodyPart.label" bundle="${mo_labels}"/></option>
						<option value='D'><fmt:message key="eMO.DeceasedReg.label" bundle="${mo_labels}"/></option>
						<%}%>
					<%}%>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>							
				</tr>
				<%}%>
				<!--  END -->
				
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table  border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
				<tr>
					<td class='columnheader' colspan='4'><fmt:message key="eMO.CutoffperiodPatientsfromMPI.label" bundle="${mo_labels}"/></td>
				</tr>		
			</table>
		</td>
	</tr>  	
	<tr>
		<td>
			   <table border="0" cellpadding="4" cellspacing="0" align='center' width='100%'>
					<tr>
						<TD width ='50%' class='label'><fmt:message key="eMO.Morethan.label" bundle="${mo_labels}"/></TD>
						<TD width ='7%' class='fields'><input type=text name="cut_off_prd_more_then_hrs" id="cut_off_prd_more_then_hrs"  size='2' maxlength='2' id="more" value='<%=CUT_OFF_PRD_MORE_THAN_HRS%>' onKeyPress='return(ChkNumberInput(this,event,0))' onblur='ChkPosNum(this);'><img src='../../eCommon/images/mandatory.gif'align='center'></img></td><td class='querydata'><fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<TD width ='50%' class= 'label'><fmt:message key="Common.LessThan.label" bundle="${common_labels}"/></TD>
						<TD width ='7%' class='fields'><input type=text name='cut_off_prd_less_then_hrs' id='cut_off_prd_less_then_hrs' size='2' maxlength='2' id="less" VALUE="<%=CUT_OFF_PRD_LESS_THAN_HRS%>"  onKeyPress='return(ChkNumberInput(this,event,0))' onblur='ChkPosNum(this);'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td><td class='querydata'><fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>             
					</tr>
				</table>
		</td>
	</tr>
		<% 
			//if(or_install_yn.equals("Y"))
			if(false)//Order catalog display is removed
			{%>
					<tr>
						<td>
							<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>	
								<tr>
									<td class='columnheader'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></Td>
								</tr>
							</table>
						<td>
					</tr>
					<tr>
						<td>
							<table border="0" cellpadding="4" cellspacing="0" align='center' width='100%'>								
								<tr>
									  <TD width ='50%' class='label' nowrap><fmt:message key="eMO.ClinicalPostmortem.label" bundle="${mo_labels}"/></TD>
									  <TD class='fields'><input type=text name="order_catalog_txt1" id="order_catalog_txt1" size=23 maxlength=20  value='<%=ORDER_CATALOG_DESC_CL_PM%>' onBlur='callsearch(this,order_catalog_txt1);' <%=orderCatCL%>><input type='button' class=button value='?' name='order_butt' id='order_butt' onClick='OrderLookUp(this,order_catalog_txt1);' <%=orderCatCL%>><img src='../../eCommon/images/mandatory.gif'align='center'></img>
									  <input type='hidden' name='order_catalog_cl' id='order_catalog_cl' value='<%=ORDER_CATALOG_CODE_CL%>'>
									  </TD>		
								</tr>
								<tr>
									  <TD class='label'><fmt:message key="eMO.MedicolegalPostmortem.label" bundle="${mo_labels}"/></TD>
									  <TD class='fields'><input type=text name="order_catalog_txt2" id="order_catalog_txt2" size='23' maxlength=20  value='<%=ORDER_CATALOG_DESC_ML_PM%>'onBlur='callsearch(this,order_catalog_txt2);' <%=orderCatML%>><input type='button' class=button value='?' name='order_butt' id='order_butt' onClick='OrderLookUp(this,order_catalog_txt2);' <%=orderCatML%>><img src='../../eCommon/images/mandatory.gif'align='center'></img>
									  <input type='hidden' name='order_catalog_ml' id='order_catalog_ml' value='<%=ORDER_CATALOG_CODE_ML%>'>
									  </TD>				  
								</tr>
							</table>
						</td>
					</tr>						
		<%}%>
        <tr>
			<td>
				<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
					<tr>
						<td class='columnheader'><fmt:message key="eMO.BurialPermit.label" bundle="${mo_labels}"/></Td>
					</tr>
				</table>
			</td>
		</tr>		
        <tr>
			<td>
				<table border="0" cellpadding="4" cellspacing="0" align='center' width='100%'>
				<!-- Changes introduced for Bru-HIMS-CRF-161 [IN:030280] and KDAH-CRF-0038 [IN:029002] on 13.03.2012 by Suresh M -->
				<tr>
						<td class='label' width='50%'><fmt:message key="eMO.BurialPermitRequiredYesNo.label" bundle="${mo_labels}"/></td>
						<td class='fields'><input type='checkbox' name='burial_permit_reqd_yn' id='burial_permit_reqd_yn'  value= '<%=burial_permit_reqd_yn%>' <%=burialPermitcheckBox%> onclick='chkBurValue(this)'></td>							
				</tr>
				<!--Added by Santhosh for ML-MMOH-CRF-1947-->
				<%if(maxSizeBurialPermitAppl){%>
				<tr>
						<td class='label' width='50%'><fmt:message key="eMO.MaxNumCharAllowedInBurialPermitNumber.label" bundle="${mo_labels}"/></td>
						<td class='fields'><input type='text' name='max_size_burial_permit_no' id='max_size_burial_permit_no' value='<%=max_size_burial_permit_no%>' maxLength='2' size='2' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='ChkPosNum(this);'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>							
				</tr>
				<%}%>
				<!--END-->
					<tr>
						<td class='label' width='50%'><fmt:message key="eMO.NextBurialPermitNo.label" bundle="${mo_labels}"/></td>
						<td class='fields'><input type='text' name='next_burial_permit_no1' id='next_burial_permit_no1' value='<%=next_burial_permit_no%>' maxLength='16' size='16' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='if(ChkPosNum(this)){checkRangeMax(this);}'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>							
					</tr>
					
				</table>
			</td>
		</tr>	
		<tr>
			<td>
				<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
					<tr>
						<td class='columnheader'><fmt:message key="Common.QueueManagement.label" bundle="${common_labels}"/></Td>
					</tr>
				</table>
			</td>
		</tr>	
		<tr>
			<td>
				<table border="0" cellpadding="4" cellspacing="0" align='center' width='100%'>
					<tr>        
						<td class='label' width='50%'><fmt:message key="Common.RefreshInterval.label" bundle="${common_labels}"/></td>
						<td class='fields' width='7%'><input type='text' name='queue_refresh_interval' id='queue_refresh_interval' value='<%=queue_refresh_interval%>' maxLength='4' size='2' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='if(ChkPosNum(this)){checkRangeMax(this);}'><img src='../../eCommon/images/mandatory.gif' align='center'></img><td class='querydata'><fmt:message key="Common.MIN.label" bundle="${common_labels}"/></td>	
					</tr>
				</table>
			</td>
		</tr>
		<!--Added by Thamizh selvi on 24th July 2017 for ML-MMOH-CRF-0689 Start-->
		<% if(isBIDRegnAppl == true || isBodyPartRegnAppl == true ){
			JSONArray bidJsonArr	= new JSONArray();
			bidJsonArr	= eMO.MOCommonBean.getPatSeriesList(con);		
		%>
		<tr>
			<td>
				<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
					<tr>
						<td class='columnheader'><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></Td>
					</tr>
				</table>
			</td>
		</tr>
        <tr>
			<td>
				<table border="0" cellpadding="4" cellspacing="0" align='center' width='100%'>
					<tr>
						<% if(isBIDRegnAppl){ %>
							<td class='label' width='25%'>
								<fmt:message key="Common.external.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.bid.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Registration.label" bundle="${common_labels}"/>
							</td>
							<td class='fields' width='25%'>
								<select name='bid_regn_pat_series' id='bid_regn_pat_series'>
									<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
									<%
											for(int i = 0; i < bidJsonArr.size(); i++){
												JSONObject json				= (JSONObject)bidJsonArr.get(i);
												String parSeriesCode		= (String)json.get("parSeriesCode");
												String patSeriesshortDesc	= (String)json.get("patSeriesshortDesc");
												
												if(pat_series_code_bid.equals(parSeriesCode))
													out.println("<option value="+parSeriesCode+" selected>"+patSeriesshortDesc+"</option>");
												else
													out.println("<option value="+parSeriesCode+">"+patSeriesshortDesc+"</option>");
											}
									 %>
								</select>
							</td> 									
						<% } %>
						<% if(isBodyPartRegnAppl){ %>
							<td class='label' width='25%'>
								<fmt:message key="Common.external.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.BodyPart.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Registration.label" bundle="${common_labels}"/>
							</td>
							<td class='fields' width='25%'>
								<select name='body_part_regn_pat_series' id='body_part_regn_pat_series'>
									<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
									<%
											for(int i = 0; i < bidJsonArr.size(); i++){
												JSONObject json				= (JSONObject)bidJsonArr.get(i);
												String parSeriesCode		= (String)json.get("parSeriesCode");
												String patSeriesshortDesc	= (String)json.get("patSeriesshortDesc");
												if(pat_series_code_bodyPart.equals(parSeriesCode))
													out.println("<option value="+parSeriesCode+" selected>"+patSeriesshortDesc+"</option>");
												else
													out.println("<option value="+parSeriesCode+">"+patSeriesshortDesc+"</option>");
											}
									 %>
								</select>
							</td> 
						<% } %>
					</tr>
				</table>
			</td>
		</tr>
		<% } %>
		<!--End-->
</table>
                  <input type='hidden' name='mode' id='mode' value='<%=mode%>'>	
			      <input type='hidden' name='or_install_yn' id='or_install_yn' value="<%=or_install_yn%>">	
			      <input type='hidden' name='next_burial_permit_no' id='next_burial_permit_no' value="<%=next_burial_permit_no%>">	
				  <input type='hidden' name='datetimeOfClaimingAppl' id='datetimeOfClaimingAppl' value="<%=datetimeOfClaimingAppl%>"><!--Added by Santhosh for ML-MMOH-CRF-1948-->
				  <input type='hidden' name='maxSizeBurialPermitAppl' id='maxSizeBurialPermitAppl' value="<%=maxSizeBurialPermitAppl%>"><!--Added by Santhosh for ML-MMOH-CRF-1947-->
			
				  
     </form>
     </body>
</html>

     <% 
			if(rset!=null) rset.close();
	        if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
	 } 
	 catch(Exception e){ out.println("Main "+e);}
     
	 finally
       { 
			ConnectionManager.returnConnection(con,request);
       }
%>

