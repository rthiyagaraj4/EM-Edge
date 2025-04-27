<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
        String params			= request.getQueryString() ;
			
		String bean_id			= "@ConsumableOrderBean";
	    String bean_name		= "ePH.ConsumableOrderBean";
		ConsumableOrderBean con_bean  = (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request);

		
		String disp_stage       = request.getParameter("disp_stage");
		String patient_id       = request.getParameter("patient_id");
		String encounter_id     = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String bl_patient_class = request.getParameter("bl_patient_class");		
		String disp_locn_code   = request.getParameter("disp_locn_code");
		String store_name       = request.getParameter("store_desc");    
		String bl_install_yn    = request.getParameter("billing_interface_yn");
		String sEnable          = request.getParameter("enable")==null?"true":request.getParameter("enable");
	    String	disp_bean_id	=	"DispMedicationAllStages" ;
		String	disp_bean_name	=	"ePH.DispMedicationAllStages";
		DispMedicationAllStages bean  = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name, request);

		String bean_id1   = "DispMedicationBean" ;
	    String bean_name1 = "ePH.DispMedicationBean";
	    DispMedicationBean bean_1 = (DispMedicationBean)getBeanObject( bean_id1, bean_name1, request ) ;

	
		con_bean.setStoreCode(disp_locn_code);	
		con_bean.setStoreDesc(store_name);
		con_bean.setPatientId(patient_id.trim());
		con_bean.setEncounterId(encounter_id.trim());
		con_bean.setActPatientClass(bl_patient_class.trim());

		ArrayList param_vals    = (ArrayList)bean.getParameterValues();
        String but_disabled="";
		//if(disp_stage.equals("D")){
			// but_disabled="disabled";

		//}
		 if((((disp_stage.equals("F") && (bean_1.getFillingStatus().equals("A")  ))|| (disp_stage.equals("A") && (bean_1.getFillingStatus().equals("B")  )))&&(bean_1.getDispLocnCatg().equals("O")) )|| disp_stage.equals("D") ){
		       but_disabled="disabled";
		 }

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/ConsumableOrder.js"></script>
		<script language="JavaScript" src="../js/DispensingConsumables.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="frm_disp_consumableItemcriteria" id="frm_disp_consumableItemcriteria">
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr> <td colspan='3'>&nbsp;</td>
				</tr>
				<tr>
					<td  width="15%" class='label'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
					<td class="label"  width="50%"><input type='text' name='txt_item_desc' id='txt_item_desc' size='50' maxlength='180' value=''onblur="ConsumableitemSearch();" <%=but_disabled%>>
					<input type="button" name="btn_item_search" id="btn_item_search" value="?" class="button" <%=but_disabled%> onClick="ConsumableitemSearch();" ><img  src="../../eCommon/images/mandatory.gif">
					<input type='hidden' name='hdn_item_code' id='hdn_item_code' value=''>
					</td>	
					<td class="label"  width="35%">&nbsp;</td> 
				</tr>						
				<tr> <td colspan='3'>&nbsp;</td>
				</tr>
			</table>
		
			<input type='hidden' name='bean_id' id='bean_id'           value='<%=bean_id%>'>
			<input type='hidden' name='bean_name' id='bean_name'         value='<%=bean_name%>'>			
			<input type='hidden' name='hdn_patient_id' id='hdn_patient_id'    value='<%=patient_id%>'>
			<input type='hidden' name='hdn_patient_class' id='hdn_patient_class' value='<%=bl_patient_class%>'>
			<input type='hidden' name='hdn_encounter_id' id='hdn_encounter_id'  value='<%=encounter_id%>'>
			<input type='hidden' name='hdn_bl_install_yn' id='hdn_bl_install_yn' value='<%=bl_install_yn%>'>
			<input type='hidden' name='hdn_bl_disp_charge_dtl_in_drug_lkp_yn' id='hdn_bl_disp_charge_dtl_in_drug_lkp_yn'  value='<%=(String)param_vals.get(0)%>'>
			<input type='hidden' name='hdn_bl_disp_price_type_in_drug_lkp' id='hdn_bl_disp_price_type_in_drug_lkp'     value='<%=(String)param_vals.get(1)%>'>
			<input type='hidden' name='params' id='params'     value='<%=params%>'>
			<input type='hidden' name='store_name' id='store_name' value='<%=store_name%>'>
			<input type='hidden' name='disp_locn_code' id='disp_locn_code' value='<%=disp_locn_code%>'>

			
		</form>
        <SCRIPT>
           parent.Disp_cons_item_result.document.location.href="../../ePH/jsp/DispensingConsumablesItemsDetails.jsp?"+'<%=params%>';
		</SCRIPT>

	</body>
</html> 



<%
	//putObjectInBean(bean_id,bean,request);
%>

