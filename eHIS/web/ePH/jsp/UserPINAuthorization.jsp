<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*, webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		
		String locale				= (String)session.getAttribute("LOCALE");
		String appl_user_name		= (String)session.getAttribute("appl_user_name");
		String login_user			= (String)session.getAttribute("login_user");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String call_from = request.getParameter("call_from");
		String Witness 			= request.getParameter("Witness")==null?"":request.getParameter("Witness"); 	// Added for AAKH-CRF-0023[IN:038259]
		String patient_id		= request.getParameter("patient_id");	// Added for AAKH-CRF-0023[IN:038259]
		String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	// Added for AAKH-CRF-0023[IN:038259]
%>
		<script language="javascript">
			function setFocus1(){
				document.frmUserPINAuthorization.user_pin.focus();
				if('<%=call_from%>'=='MAR' && '<%=Witness%>'=='Y')		// Added for AAKH-CRF-0023[IN:038259]
					document.frmUserPINAuthorization.user_name.focus();	// Added for AAKH-CRF-0023[IN:038259]
				return true;
			}
		</script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedicationAllStages.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.PinAuth.label" bundle="${ph_labels}"/></title>
	</HEAD>
<%
	try{
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String bean_id = "DispMedicationAllStages.java" ;
		String bean_name = "ePH.DispMedicationAllStages";
		DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request ) ;
		String bean_id1 = "MedicationAdministrationFTBean.java" ;
		String bean_name1 = "ePH.MedicationAdministrationFTBean";
		MedicationAdministrationFTBean bean1 = (MedicationAdministrationFTBean)getBeanObject( bean_id1, bean_name1, request ) ;
		String disp_locn_code = request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");
		String disp_category	= request.getParameter("disp_category")==null?"IP":request.getParameter("disp_category");
		String login_facility_id = (String)session.getValue( "facility_id" );
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String sqlForMARUsers="select  appl_user_id code,appl_user_name description from sm_appl_user_lang_vw a where eff_status='E' AND a.language_id ='"+locale+"' and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and (pin_no is not null or pin_no <> '') and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?)  ORDER BY 2";

		String sqlForDispensingUsers="SELECT a.appl_user_id code, a.appl_user_name description FROM sm_appl_user_lang_vw a, ph_disp_rights b WHERE b.facility_id = '"+login_facility_id+"' AND b.disp_locn_code = '"+disp_locn_code+"' AND a.language_id ='"+locale+"' and a.eff_status = 'E' and A.APPL_USER_ID = B.APPL_USER_ID AND ( (a.eff_date_from IS NULL AND a.eff_date_to IS NULL) OR (TRUNC (a.eff_date_from) <= TRUNC (SYSDATE) AND a.eff_date_to IS NULL ) OR (TRUNC (a.eff_date_to) >= TRUNC (SYSDATE) AND a.eff_date_from IS NULL ) OR ( TRUNC (SYSDATE) BETWEEN TRUNC (a.eff_date_from)   AND TRUNC (a.eff_date_to) AND a.eff_date_from IS NOT NULL AND a.eff_date_to IS NOT NULL ) ) and (pin_no is not null or pin_no <> '') AND UPPER (a.appl_user_id) LIKE UPPER (?) AND UPPER (a.appl_user_name) LIKE UPPER (?) ";
    
		String user_label="";
		String bundle="PH";
		if(call_from.equals("A")){
			user_label="ePH.AllocatedBy.label";
			sqlForDispensingUsers +=" and B.ALLOCATE_YN='Y' ORDER BY 2";
		}
		else if(call_from.equals("V")){
			user_label="Common.VerifiedBy.label";
			bundle	="Common";
			sqlForDispensingUsers +=" and B.VERIFY_YN='Y' ORDER BY 2";
			if(disp_category.equals("IP")  || disp_category.equals("I") )
				sqlForDispensingUsers +=" and B.IP_VERIFY_YN='Y' ORDER BY 2";
			else
				sqlForDispensingUsers +=" and B.VERIFY_YN='Y' ORDER BY 2";
		}
		else if(call_from.equals("F") ||  call_from.equals("IPFA")){
			user_label="ePH.FilledBy.label";
			if(disp_category.equals("IP") || disp_category.equals("I") || call_from.equals("IPFA"))
				sqlForDispensingUsers +=" and B.IP_ALLOCATE_YN='Y' ORDER BY 2";
			else
				sqlForDispensingUsers +=" and B.FILL_YN='Y' ORDER BY 2";
		}
		else if(call_from.equals("D")){
			user_label="ePH.DeliveredBy.label";
			sqlForDispensingUsers +=" and B.DELIVER_YN='Y' ORDER BY 2";
			if(disp_category.equals("IP")  || disp_category.equals("I") )
				sqlForDispensingUsers +=" and B.IP_DELIVER_YN='Y' ORDER BY 2";
			else
				sqlForDispensingUsers +=" and B.DELIVER_YN='Y' ORDER BY 2";
		}
		else if(call_from.equals("AS") || call_from.equals("DD")){
			user_label="ePH.DispensedBy.label";
			if(disp_category.equals("OP") || disp_category.equals("O") )
				sqlForDispensingUsers +=" and B.ALLOCATE_YN='Y' and B.DELIVER_YN='Y' ORDER BY 2";
			else if(disp_category.equals("IP")  || disp_category.equals("I") )
				sqlForDispensingUsers +=" and B.IP_ALLOCATE_YN='Y' and B.IP_DELIVER_YN='Y' ORDER BY 2";
			if(call_from.equals("DD") ){
				sqlForDispensingUsers ="SELECT  appl_user_id code, appl_user_name description FROM sm_appl_user_lang_vw a, am_practitioner b WHERE A.APPL_USER_ID = B.PRACTITIONER_ID and  (pin_no is not null or pin_no <> '') AND a.language_id ='"+locale+"' and  b.pract_type IN ('NS', 'MD', 'DN', 'PH') AND UPPER (appl_user_id) LIKE UPPER (?) AND UPPER (appl_user_name) LIKE UPPER (?) ORDER BY 2";
				//sqlForDispensingUsers =" SELECT a.appl_user_id code, a.appl_user_name description FROM sm_appl_user a, ph_disp_rights b , ph_disp_locn c WHERE b.facility_id = '"+login_facility_id+"' AND b.disp_locn_code = '"+disp_locn_code+"'  AND a.language_id = '"+locale+"' and a.eff_status = 'E' and A.APPL_USER_ID = B.APPL_USER_ID AND ( (a.eff_date_from IS NULL AND a.eff_date_to IS NULL) OR (TRUNC (a.eff_date_from) <= TRUNC (SYSDATE) AND a.eff_date_to IS NULL ) OR (TRUNC (a.eff_date_to) >= TRUNC (SYSDATE) AND a.eff_date_from IS NULL ) OR ( TRUNC (SYSDATE) BETWEEN TRUNC (a.eff_date_from)   AND TRUNC (a.eff_date_to) AND a.eff_date_from IS NOT NULL AND a.eff_date_to IS NOT NULL ) ) AND UPPER (a.appl_user_id) LIKE UPPER (?) AND UPPER (a.appl_user_name) LIKE UPPER (?) and B.DISP_LOCN_CODE = C.DISP_LOCN_CODE and C.DIRECT_DISP_ALLOWED_YN ='Y' ORDER BY 2";
			}
		}
		else if(call_from.equals("MAR")){
			user_label="Common.AdministeredBy.label";
			bundle	="Common";
			if(Witness.equals("Y")){	// Added for AAKH-CRF-0023[IN:038259] start
				user_label="ePH.WitnessedBy.label";
				bundle	="PH";
				appl_user_name = "";
				sqlForMARUsers="select  appl_user_id code,appl_user_name description from sm_appl_user_lang_vw a where eff_status='E' AND a.language_id ='"+locale+"' and a.appl_user_id != '"+login_user+"' and ( (trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and (pin_no is not null or pin_no <> '') and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?)  ORDER BY 2";
			}							// Added for AAKH-CRF-0023[IN:038259] end
		}
%>
		<body  onload="setFocus1()" >  
			<form name="frmUserPINAuthorization" id="frmUserPINAuthorization" >
				<table cellpadding="0" cellspacing="0" width="100%" left="5%" align="left" border="0" >
					<tr style="height:40px">
						<td class="white" colspan="2">&nbsp;</td>
					</tr>
					<tr style="height:40px">
						<td  class='Label'><label id='user_id1' width='25%'>
						<%=MessageManager.getLabel(locale,user_label,bundle)%>
						</label></td>
						<td> <input type=text  name='user_name' id='user_name'  value='<%=appl_user_name%>' size='30' maxlength='30' onChange="GetLookupBlur(user_name,'<%=call_from%>')"><!--onblur changed to onChange for  RUT-SCF-0351 [IN:044986]-->
							<input type='button' class='button' name='user_lookup' id='user_lookup' value='?' onClick="GetLookup(user_name,'<%=call_from%>')">		
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						</td>
					</tr>
					<tr>
						<td  class="label" width='25%'><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
						<td><input type="password" name="user_pin" id="user_pin" size="30" maxlength="64" value="" autocomplete="off"><img src="../../eCommon/images/mandatory.gif" align="center"></img>  <!--41741 autocomplete="off"-->
						</td>
					</tr>
					<tr style="height:45px">
						<td  colspan="2" align="right" >
						<input type="button" class="button" name='btnOk' id='btnOk' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="validateUserAuthPIN('<%=call_from%>')">&nbsp;&nbsp;&nbsp;
						<input type="button" class="button" name='btnCancel' id='btnCancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="window.returnValue='C';window.close();">
						</td>
					</tr>
				</table>
				<input type='hidden' name="user_id" id="user_id" value="<%=login_user%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="locale" id="locale" value="<%=locale%>">
				<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
				<input type="hidden" name="disp_category" id="disp_category" value="<%=disp_category%>">
				<input type="hidden" name="login_facility_id" id="login_facility_id" value="<%=login_facility_id%>">
				<input type="hidden" name="login_at_ws_no" id="login_at_ws_no" value="<%=login_at_ws_no%>">
				<input type="hidden" name="sqlForMARUsers" id="sqlForMARUsers" value="<%=sqlForMARUsers%>">
				<input type="hidden" name="sqlForDispensingUsers" id="sqlForDispensingUsers" value="<%=sqlForDispensingUsers%>">
				<input type="hidden" name="witness" id="witness" value="<%=Witness%>">	<!--  Added for AAKH-CRF-0023[IN:038259] -->
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">	<!--  Added for AAKH-CRF-0023[IN:038259] -->
				<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">	<!--  Added for AAKH-CRF-0023[IN:038259] -->
			</form>
		</body>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id1,bean1,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

