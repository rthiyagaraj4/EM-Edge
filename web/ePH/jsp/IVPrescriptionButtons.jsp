<!DOCTYPE html>
<% 
 /*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
2/12/2020			6041			Shazana       					NMC-JD-CRF-0063
--------------------------------------------------------------------------------------------------------------
*/
%>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*, eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<%
    Connection con			= null;//added for ml-mmoh-crf-1223
	PreparedStatement pstmt = null; // NMC-JD-CRF-0197
	ResultSet resultSet     = null; // NMC-JD-CRF-0197
	try{
	String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String location_type		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String priority				= request.getParameter("priority")==null?"":request.getParameter("priority");
	String	bl_install_yn		= request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String	order_id		= request.getParameter("order_id")==null?"":request.getParameter("order_id");//NMC-JD-CRF-0063 
	String act_pat_class = request.getParameter("act_pat_class")==null?"":request.getParameter("act_pat_class");//NMC-JD-CRF-0063 
	String  disp_locn_code=request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");
	String	bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	iv_prep_yn = iv_prep_yn.trim();

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";

	String or_mode			= request.getParameter("or_mode")==null?"":request.getParameter("or_mode");
	String mode				= request.getParameter("mode")==null?"":request.getParameter("mode");
	String time_flag		= "";
	String iv_with_additives		= "";
	String iv_without_additives		= "";
	String iv_intermittent		= "";
	String preview_rx_yn=request.getParameter("preview_rx_yn")==null?"":request.getParameter("preview_rx_yn"); //added for ML-MMOH-CRF-0341 [IN:057179]
	PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;//Added NMC-JD-CRF-0063 start
		
	if(preview_rx_yn.equals("")){
		//PrescriptionBean_1 beanPres = (PrescriptionBean_1)getBeanObject( "@PrescriptionBean_1"+patient_id+encounter_id,"ePH.PrescriptionBean_1",request) ;
		preview_rx_yn=beanPres.getPreviewRxYN();
	}

	String previewManDisp = "none", previewReleaseDisp="inline";
	if(preview_rx_yn.equals("Y")){
		previewManDisp = "inline"; 
		previewReleaseDisp = "none";
	}
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name, request);
	con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-1223
	boolean default_comp_fluid_falg = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DEFAULT_COMP_FLUID_INF_OVER");// Added for ML-MMOH-CRF-1223
	boolean op_take_home_med_flag = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "OP_TAKE_HOME_MEDICATION");//added for NMC-JD-CRF-0063
	boolean  site_alw_disp_loc_drug_search_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_DISP_LOC_DRUG_SEARCH");//added for NMC-JD-CRF-0197
	String patient_class = bean.getPatientClass();
	String locale = bean.getLanguageId();
		System.out.println("patient_class: "+patient_class);  //added for NMC-JD-CRF-0063
	if(patient_class!=null){
		if(patient_class.equals("EM")|| patient_class.equals("OP")){
			if(op_take_home_med_flag){
				bean.setTakeHomeMedicationOp("Y");
			}else{
				bean.setTakeHomeMedicationOp("N");
			}
		}
	}//END
			if(beanPres.getOpDischMedInd()==null){
				bean.setOpDischMedInd("N");
			}
			else if(beanPres.getOpDischMedInd()!=null){
				bean.setOpDischMedInd(beanPres.getOpDischMedInd());
			}
			//END
			if(op_take_home_med_flag){//ADDED FOR NMC-JD-CRF-0063 [TFS:12491]
				if(beanPres.getPatient_class_tkHome()!=null && beanPres.getPatient_class_tkHome().equals("IP")){
					bean.setTakeHomeMedicationOp("N");  
				}
			}
	
	
	ArrayList ivLegends = bean.getIvLegends();
	if(ivLegends != null && ivLegends.size()>1){
		iv_with_additives		= (String)ivLegends.get(0);
		iv_without_additives	= (String)ivLegends.get(1);
		iv_intermittent			= (String)ivLegends.get(2);
	}

	String title_display = "";

	if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4") ){
	    bean.setIVType("IVPB");
		title_display = iv_intermittent;
	}
	else if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") ){
	    bean.setIVType("IVD");
		title_display = iv_with_additives;
	}
    else if( iv_prep_yn.equals("5")  ){
	    bean.setIVType("IVWA");
		title_display = iv_without_additives;
	}
	System.out.println("getOrderDispenseLocation - IVPrescriptionButtons.jsp"); //ADDED FOR NMC-JD-CRF-0063 START
	System.out.println("getTakeHomeMedicationOp:  "+bean.getTakeHomeMedicationOp());
	System.out.println("getOpDischMedInd:  "+bean.getOpDischMedInd());//END
	if(op_take_home_med_flag && act_pat_class.equals("OP")){//added for NMC-JD-CRF-0063  
		if(order_id!=null && !order_id.equals("") && beanPres.getCalledFrom().equals("AMEND_ORDER")){    
			ArrayList amendDetails = (ArrayList) bean.getAmendDetails(order_id);   
			if(amendDetails.size()>0){
				bean.setOpDischMedInd((String)amendDetails.get(0));   
					bean.setTakeHomeMedicationOp("Y"); 
		} 
	}
}
	
	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added empty parameter for Bru-HIMS-CRF-347 [IN:037862] -- Begin ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
	String dflt_disp_locn	= "";
	if(ord_disp_location != null & ord_disp_location.size()>0){ 
		dflt_disp_locn		=	(String)ord_disp_location.get(2) ==null?"":(String)ord_disp_location.get(2);	
		if(!site_alw_disp_loc_drug_search_appl){
		bean.setDisp_locn_code((String)ord_disp_location.get(0)); //Added For NMC-JD-CRF-0046
		bean.setDisplocn((String)ord_disp_location.get(0));  //Added For NMC-JD-CRF-0046
		}
		time_flag			=	bean.ChkWorkingHours((String)ord_disp_location.get(0));
	} 
	String order_type_flag  =	bean.getOrder_type_flag();
	/*Added for NMC-JD-CRF-0197 start*/
			String drug_search_bean_id	="@DrugSearchBean"+patient_id+encounter_id; //Modified for TFS-16341
			String drug_search_bean_name			= "ePH.DrugSearchBean";
			DrugSearchBean drug_bean				= (DrugSearchBean)getBeanObject( drug_search_bean_id, drug_search_bean_name , request);
			drug_bean.setLanguageId(locale);
			if(site_alw_disp_loc_drug_search_appl) //added for NMC-JD-CRF-0197 
					{
						if(!disp_locn_code.equals("")){
							bean.setDisp_locn_code(disp_locn_code);
							bean.setDisplocn(disp_locn_code);
						} 
					
		                pstmt = con.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT27") );
						pstmt.setString(1,bean.getDisp_locn_code());
						pstmt.setString(2,bean.getLoginFacilityId());
						pstmt.setString(3,bean.getLanguageId());			
						resultSet = pstmt.executeQuery() ;											
						if(resultSet!=null && resultSet.next()){					
							dflt_disp_locn = resultSet.getString("SHORT_DESC");				
						}

						bean.closeStatement(pstmt);
						bean.closeResultSet(resultSet);						
					}
			
	/*Added for NMC-JD-CRF-0197 end*/
	
%>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<%
		if(bean.getIVType().equals("IVPB")){
%>
			<SCRIPT LANGUAGE="javascript" SRC="../js/IVPiggyBack.js"></SCRIPT>
<%
		}
		else if(bean.getIVType().equals("IVD")) { 
%>
			<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
<%
		} 
		else {	
%>
			<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescription.js"></SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%	
		}	
%>	
	</HEAD>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
	<FORM name="formIVPrescriptionButtons" id="formIVPrescriptionButtons">
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
			<TR>
			<%   //  For IV-Fluids - Dispense Location value will be hidden here and moved - for Bru-HIMS-CRF-347 [IN:037862]
			if(!bean.getIVType().equals("IVWA")) {
			%>
				<TD align="left" class="label" >&nbsp;&nbsp;<fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>
				<b><label class="label" id="dflt_disp_locn_lbl" name="dflt_disp_locn_lbl" >&nbsp;<%=dflt_disp_locn%> <label></b>
				</TD>
			<%
			}
			%>
				<TD align="right" > 
<%	
				if(or_mode==null){	
					or_mode="";
				}
	
				or_mode					= bean.getOrMode();
				HashMap MFRRecs			= new HashMap();
				MFRRecs					= bean.getMFRRecs();
				String reset_disabled	= "";

				if(mode.equals("amend") && MFRRecs!=null && MFRRecs.size()>0){
					reset_disabled		= "disabled";
				}

				ArrayList drugList		= bean.getDrugDetails();
/* //Commented for FDB Tuning - start - can be removed the code if not required
				ArrayList exProd		= new ArrayList();
				ArrayList drugDesc		= new ArrayList();
				for(int i=0;i<drugList.size();i++) {
					HashMap drugDetails = (HashMap)drugList.get(i);
					if (drugDetails.size() != 0) {
						String extprod	= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");

						if (!extprod.equals("")) {
							drugDesc.add((String)drugDetails.get("SHORT_DESC"));
							exProd.add(extprod);
						}
					}
				}
				if (drugDesc.size()>=2) {
					String beanid1		= "@ExternalProductLinkBean"+patient_id+encounter_id ;
					String beanname1	= "ePH.ExternalProductLinkBean";
					ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject( beanid1, beanname1 , request) ;

					//Store Drug ids
					if(exProd.size() > 0){
						beanex.storeDrugIds(patient_id, "", exProd, drugDesc);
					}
					//Store interactions
					HashMap drug_Details =	new HashMap();
					if (!drug_Details.isEmpty()) { */
%>
					<!--	<IMG SRC="../images/DrugInteractions.gif" onMouseOver="changeCursor(this)" onClick="viewInteraction('<%/*= patient_id */%>', '', '<%/*= encounter_id*/ %>');" HEIGHT="20"> -->
<%
			/*		}
					putObjectInBean(beanid1,beanex,request);
				}*/ //Commented for FDB Tuning - end
 
				if(bean.getIVType().equals("IVD")){
					if(!mode.equals("amend")){
						if(drugList.size()>0 && bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
							<INPUT TYPE="button" CLASS="button" name="ChargeDetails" id="ChargeDetails" VALUE='<fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>' onClick="displayChargeDetails('<%=iv_prep_yn%>','<%=default_comp_fluid_falg%>')"> <!-- default_comp_fluid_falg added for ML-MMOH-CRF-1223 -->
<%
						}
					}
					else{
						if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
							<INPUT TYPE="button" CLASS="button" name="ChargeDetails" id="ChargeDetails" VALUE='<fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>' onClick="displayChargeDetails('<%=iv_prep_yn%>','<%=default_comp_fluid_falg%>')"> <!-- default_comp_fluid_falg added for ML-MMOH-CRF-1223 -->
<%
						}
					}
				}
				else{
						
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
		
%> 
						<INPUT TYPE="button" CLASS="button" name="ChargeDetails" id="ChargeDetails" VALUE='<fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>' onClick="displayChargeDetails('<%=iv_prep_yn%>')">
<%
					}
				}	
%> 
				<INPUT TYPE="button" CLASS="button" name="PREVIEW" id="PREVIEW" VALUE='<fmt:message key="ePH.PreviewRx.label" bundle="${ph_labels}"/>' onClick="previewRX('<%=title_display%>','<%=default_comp_fluid_falg%>')" style='display:<%=previewReleaseDisp%>'><!--style //added for ML-MMOH-CRF-0341 [IN:057179] default_comp_fluid_falg added for ML-MMOH-CRF-1223 -->
				<INPUT TYPE="button" CLASS="button" name="RELEASE" id="RELEASE" VALUE='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' onClick="releaseRX('<%=default_comp_fluid_falg%>')" style='display:<%=previewReleaseDisp%>'><!--style //added for ML-MMOH-CRF-0341 [IN:057179]  default_comp_fluid_falg added for ML-MMOH-CRF-1223-->
				<INPUT TYPE="button" CLASS="button" name="PREVIEW" id="PREVIEW" VALUE='Preview & Release RX' onClick="previewRX('<%=title_display%>','<%=default_comp_fluid_falg%>')" style='display:<%=previewManDisp%>'><!--button //added for ML-MMOH-CRF-0341 [IN:057179]  default_comp_fluid_falg added for ML-MMOH-CRF-1223-->
				<INPUT TYPE="button" CLASS="button" name="CLEAR" id="CLEAR" VALUE='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="callClearAll(1)" <%=reset_disabled%>>
				</TD>
			</TR>
		</TABLE>
		<input type='hidden' name='iv_prep_yn' id='iv_prep_yn' value='<%=iv_prep_yn%>'>
<%
		if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
%>
		    <input type='hidden' name='time_flag' id='time_flag' value='<%=time_flag%>'>
<%
		}
		else{
%>
			<input type='hidden' name='time_flag' id='time_flag' value=''>
<%
		}
%>
	</FORM>
	</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
}catch(Exception e){
		e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-1223 - start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-crf-1223 end
%>

