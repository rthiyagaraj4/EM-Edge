<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>  
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale				= (String)session.getAttribute("LOCALE");
		String appl_user_name		= (String)session.getAttribute("appl_user_name");
		String login_user			= (String)session.getAttribute("login_user");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String call_from = request.getParameter("call_from");
		%>
		<script language="javascript">
			function setFocus1(){
				document.frmUserPINAuthorization.user_pin.focus();
				if('<%=call_from%>'=='MAR')		// Added for AAKH-CRF-0023[IN:038259]
					document.frmUserPINAuthorization.user_pin.focus();	// Added for AAKH-CRF-0023[IN:038259]
				return true;
			}
		</script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/MedicationAdministration.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.CancelMarAdminstration.label" bundle="${ph_labels}"/></title>
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
		String drugName = request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
		String admin_by_name=request.getParameter("admin_by_name")==null?"":request.getParameter("admin_by_name");
		String login_facility_id = (String)session.getValue( "facility_id" );
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		ArrayList  reasonCodeValues=(ArrayList)bean1.cancelAdminReasonCodeValues();
		String username=bean1.getUsername(admin_by_name);
		String drug_code = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
		String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		String order_line_num = request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
		String iv_prep_yn = request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		System.out.println("iv_prep_yn"+iv_prep_yn);
		String sch_date_time  = request.getParameter("sch_date_time")==null?"":request.getParameter("sch_date_time");
		String dosage_seq = request.getParameter("dosage_seq")==null?"":request.getParameter("dosage_seq");
		String administered_qty = request.getParameter("administered_qty")==null?"":request.getParameter("administered_qty");
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String admin_date_time = request.getParameter("admin_date_time")==null?"":request.getParameter("admin_date_time");
		String strength_per_value_pres_uom=request.getParameter("strength_per_value_pres_uom")==null?"1":request.getParameter("strength_per_value_pres_uom");
		
%>
		<body  onload="setFocus1()" >  
			<form name="frmUserPINAuthorization" id="frmUserPINAuthorization" >
				<table cellpadding="0" cellspacing="0" width="100%"   border="0" >
					<tr style="height:40px">
						<td  class='Label'><label  >Drug Name</label></td>
						<td  class='Label'>&nbsp;&nbsp;<label id='drug_name' ><b><%=drugName%></b></label></td><!-- removed decode for IN73000 as already handled in js-->
					</tr>
					<tr style="height:40px">
						<td  class='Label'><label id='' >
						
						Administered By
						</label></td>
						<td>&nbsp;&nbsp;<input type=text  name='user_name' id='user_name'  value='<%=username%>' size='30' maxlength='30' disabled >
							
						</td>
					</tr>
					<tr style="height:40px">
						<td  class='Label'><label id='user_id1' >
						Cancel Med. Administered By
						</label></td>
						<td>&nbsp;&nbsp;<input type=text  name='cancel_user_name' id='cancel_user_name'  value='<%=appl_user_name%>' size='30' maxlength='30' disabled>
							
						</td>
					</tr>
					<tr style="height:40px">
					<td class='Label'><label >Cancel Med.Admin Reason</label></td>
					<td class='Label' >&nbsp;<select name="reason_code" id="reason_code" style='width:177px;'><option value="" width="100px">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
<%
								for(int i=0;i<reasonCodeValues.size();i+=2){
%>
									<option value="<%=(String) reasonCodeValues.get(i)%>" style='width:10px;overflow: hidden'><%=(String) reasonCodeValues.get(i+1)%></option>
<%
								}
%>
								</select><img   src="../../eCommon/images/mandatory.gif" ></img></td>
					</tr>
					<tr style="height:40px">
						<td  class='Label' ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
						<td>&nbsp;&nbsp;<input type="password" name="user_pin" id="user_pin" size="30" maxlength="64" value=""  autocomplete="off"><img src="../../eCommon/images/mandatory.gif" align="center"  ></img>  <!--41741 autocomplete="off"-->
						</td>
					</tr>
					<tr style="height:45px">
						<td  colspan="2" align="right" >
						<input type="button" class="button" name='btnOk' id='btnOk' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="validateUserRightsAuthPIN('<%=call_from%>')">&nbsp;&nbsp;&nbsp;
						<input type="button" class="button" name='btnCancel' id='btnCancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="window.returnValue='C';window.close();">
						</td>
					</tr>
				</table>
				<input type='hidden' name="user_id" id="user_id" value="<%=login_user%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="locale" id="locale" value="<%=locale%>">
				
				<input type="hidden" name="login_facility_id" id="login_facility_id" value="<%=login_facility_id%>">
				<input type="hidden" name="login_at_ws_no" id="login_at_ws_no" value="<%=login_at_ws_no%>">
				<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
				<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
				<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
				<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
				<input type="hidden" name="sch_date_time" id="sch_date_time" value="<%=sch_date_time%>">
				<input type="hidden" name="dosage_seq" id="dosage_seq" value="<%=dosage_seq%>">
				<input type="hidden" name="administered_qty" id="administered_qty" value="<%=administered_qty%>">
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
				<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
				<input type="hidden" name="admin_date_time" id="admin_date_time" value="<%=admin_date_time%>">
				<input type="hidden" name="admin_by_name" id="admin_by_name" value="<%=admin_by_name%>">
				<input type="hidden" name="strength_per_value_pres_uom" id="strength_per_value_pres_uom" value="<%=strength_per_value_pres_uom%>">
				
				
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

