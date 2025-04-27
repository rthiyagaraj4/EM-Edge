<!DOCTYPE html>
 
 <% 
 /*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
2/12/2020			6041			Shazana       										NMC-JD-CRF-0063
--------------------------------------------------------------------------------------------------------------
*/
%>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
		String facility_id					= (String)session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);
		String	bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String	bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
		String patient_class	= request.getParameter("patient_class");//added for NMC-JD-CRF-0063		
		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");	
		String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name, request);
		bean.setLanguageId(locale);
		PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;//Added NMC-JD-CRF-0063 
		String location_type		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String location_code		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String priority				= request.getParameter("priority")==null?"":request.getParameter("priority");
		String dflt_disp_locn	= "";
		String iv_prep_yn		= "6";
		String preview_rx_yn=request.getParameter("preview_rx_yn")==null?"":request.getParameter("preview_rx_yn"); //added for ML-MMOH-CRF-0341 [IN:057179]
		String previewManDisp = "none", previewReleaseDisp="inline";
			if(preview_rx_yn.equals("Y")){
				previewManDisp = "inline";
				previewReleaseDisp = "none";
			}
		bean.setTakeHomeMedication(take_home_medication);
		//Added for NMC-JD-CRF-0063
		 Connection con			= null;
				try{
		con				= ConnectionManager.getConnection(request);
		boolean op_take_home_med_flag = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "OP_TAKE_HOME_MEDICATION");
		
		if(patient_class!=null){
			if(patient_class.equals("EM")|| patient_class.equals("OP")){
				if(op_take_home_med_flag){
					bean.setTakeHomeMedicationOp("Y");
				}else{
					bean.setTakeHomeMedicationOp("N");
				}
			}
		}
		//System.out.println("beanPres.getOpDischMedInd(): "+beanPres.getOpDischMedInd());
		if(beanPres.getOpDischMedInd()==null){
			bean.setOpDischMedInd("N");
		}
		if(beanPres.getOpDischMedInd()!=null){
			//System.out.println("beanPres.getOpDischMedInd(): "+beanPres.getOpDischMedInd());
			bean.setOpDischMedInd(beanPres.getOpDischMedInd());
		}//END
		ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);//added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]

		ArrayList param_values_MaxDurn = new ArrayList();
		param_values_MaxDurn = bean.getParamMaxDurnDet();
		String max_durn_for_ip_pres = "";
		String chk_for_ip_max_durn_action = "";
		String max_durn_for_op_pres = "";
		String chk_for_op_max_durn_action = "";
		String max_durn_for_dm_pres = "";
		String chk_for_dm_max_durn_action = "";
		if(param_values_MaxDurn.size()>0){
			max_durn_for_ip_pres = (String)param_values_MaxDurn.get(0);
			chk_for_ip_max_durn_action = (String)param_values_MaxDurn.get(1);
			max_durn_for_op_pres = (String)param_values_MaxDurn.get(2);
			chk_for_op_max_durn_action = (String)param_values_MaxDurn.get(3);
			max_durn_for_dm_pres = (String)param_values_MaxDurn.get(4);
			chk_for_dm_max_durn_action = (String)param_values_MaxDurn.get(5);
		}
		if(ord_disp_location != null & ord_disp_location.size()>0){ 
			dflt_disp_locn	= (String)ord_disp_location.get(2)==null?"":(String)ord_disp_location.get(2);
		}
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PrescriptionComp.js"></SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<FORM name="formIVPrescriptionButtons" id="formIVPrescriptionButtons">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<tr align="center">
					<TD colspan='2' align="center" >
						<table  border="1" width="100%">
							<tr>
<%
							   if(drug_db_interface_yn.equals("Y")){
%>
									<td NOWRAP width="15" class="SHIFTTOTAL"><img src='../../ePH/images/exceed1.gif' ></img></td>
									<td NOWRAP  style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.ExternalDataBaseChecks.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;</td>
<%
								}
%>
								<td NOWRAP width="15" class="ALLERGY"><img src='../../ePH/images/exceed1.gif' ></img></td><td NOWRAP  style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td  NOWRAP width="15" class="DOSELIMIT"  border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td><td  NOWRAP  style="font-size:7pt" class="label" border="0" bordercolor="label" ><fmt:message key="ePH.BeyondDoseLimit.label" bundle="${ph_labels}"/></td><td  NOWRAP width="15" class="CURRENTRX"
								border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td><td  NOWRAP style="font-size:7pt" class="label" border="0" bordercolor="label"><fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/></td> 
							</tr>
							<!-- <tr height="8"><td colspan="12"></td></tr> -->
						</table>
					</TD>
				</tr>
				<TR align="right" >
					<TD width="20%" align="left" class="label" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>:<b><label class="label" id="dflt_disp_locn_lbl" name="dflt_disp_locn_lbl" >&nbsp;<%=dflt_disp_locn%><label></b>
					</TD>
					<TD>
<%
						if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
							<INPUT TYPE="button" CLASS="button" name="ChargeDetails" id="ChargeDetails" VALUE='<fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>' onClick="displayChargeDetails('<%=iv_prep_yn%>')">
<%
						}
%>						

						<INPUT TYPE="button" CLASS="button" name="PREVIEW" id="PREVIEW" VALUE='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/>' onClick="previewCompRX()" style='display:<%=previewReleaseDisp%>'><!-- // style previewReleaseDisp added for ML-MMOH-CRF-0341 [IN:057179] -->
						<INPUT TYPE="button" CLASS="button" name="RELEASE" id="RELEASE" VALUE='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' onClick="releaseRX()" style='display:<%=previewReleaseDisp%>'>
						<INPUT TYPE="button" CLASS="button" name="PREVIEW" id="PREVIEW" VALUE='Preview & Release RX' onClick="previewCompRX()" style='display:<%=previewManDisp%>'><!-- // style button added for ML-MMOH-CRF-0341 [IN:057179] -->
					
						<INPUT TYPE="button" CLASS="button" name="CLEAR" id="CLEAR" VALUE='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="callClearAll(1)">
					</TD>
				</TR>

			</TABLE>
			<input type='hidden' name='iv_prep_yn' id='iv_prep_yn' value='<%=iv_prep_yn%>'>
			<input type='hidden' name='MAX_DURN_FOR_IP_PRES' id='MAX_DURN_FOR_IP_PRES' value='<%=max_durn_for_ip_pres%>'>
			<input type='hidden' name='CHK_FOR_IP_MAX_DURN_ACTION' id='CHK_FOR_IP_MAX_DURN_ACTION' value='<%=chk_for_ip_max_durn_action%>'>
			<input type='hidden' name='MAX_DURN_FOR_OP_PRES' id='MAX_DURN_FOR_OP_PRES' value='<%=max_durn_for_op_pres%>'>
			<input type='hidden' name='CHK_FOR_OP_MAX_DURN_ACTION' id='CHK_FOR_OP_MAX_DURN_ACTION' value='<%=chk_for_op_max_durn_action%>'>
			<input type='hidden' name='MAX_DURN_FOR_DM_PRES' id='MAX_DURN_FOR_DM_PRES' value='<%=max_durn_for_dm_pres%>'>
			<input type='hidden' name='CHK_FOR_DM_MAX_DURN_ACTION' id='CHK_FOR_DM_MAX_DURN_ACTION' value='<%=chk_for_dm_max_durn_action%>'>
			<%-- <input type='hidden' name='dflt_disp_locn_lbl' id='dflt_disp_locn_lbl' value='<%=dflt_disp_locn%>'><!-- commented for NMC-JD-CRF-0063 --> --%>
		
			
		</FORM>
		<%}//added for NMC-JD-CRF-0063
				catch(Exception ex){
		ex.getMessage();
	}
	finally{
		if(con != null)
		ConnectionManager.returnConnection(con,request);
	}%>
	</BODY>
</HTML>

