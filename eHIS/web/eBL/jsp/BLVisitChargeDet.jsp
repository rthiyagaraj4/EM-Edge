<!DOCTYPE html>
<%@  page import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

  <%
	Connection con				= null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 

	try{
		
	request.setCharacterEncoding("UTF-8");	
	con	=	ConnectionManager.getConnection(request);
	HttpSession httpSession = request.getSession(false);


//Unused Var's
/*
	String service_panel_code="";
	String service_panel_ind=""; 
	String service_date="";
	String serv_panel_qty="";
	String pract_staff_ind="";
	String pract_staff_id="";
	String serv_panel_str="";
	String order_catalog_code="";
*/
	//Added by muthuN for 32915 on 15-6-2012	
	String customer_id="";
	//Added by muthuN for 32915 on 15-6-2012
	String calling_module_id="";
	String call_after_reg="";

//Unused Var's
/*	double d_tot_qty=0;double d_serv_amt=0; double d_pat_payable=0;double d_min_chr_amt=0;double d_patient_paid=0;

	String str_excl_incl_ind=""; String str_preappr_yn=""; String str_error_code="";
	String str_sys_message_id=""; String str_error_text="";String str_override_yn="";
	String str_blng_serv_desc=""; String str_rate_chr_ind="";
	String hosp_panel_str="";String prof_panel_str="";
	String str_charge_based_yn="";String str_excl_incl_act="";String str_act_reason_code="";
	String str_error_level=""; double serv_qty=0;
*/
	String hosp_serv_panel_ind="";
	String hosp_serv_panel_code="";
//	String hosp_serv_panel_str="";
	String hosp_serv_panel_qty="";
	String hosp_serv_chrg_amt="";

	String med_serv_panel_ind="";
	String med_serv_panel_code="";
//	String med_serv_panel_str="";
	String med_serv_panel_qty="";
	String med_serv_chrg_amt="";

	String addl_serv_panel_ind="";
	String addl_serv_panel_code="";
//	String med_serv_panel_str="";
	String addl_serv_panel_qty="";
	String addl_serv_chrg_amt="";

	String str_hosp_chrg_amt="";
	String str_hosp_chrg_pat_amt="";
	String str_med_chrg_amt="";
	String str_med_chrg_pat_amt="";
	String str_addl_chrg_amt="";
	String str_addl_chrg_pat_amt="";

	String upd_hosp_chrg_amt="";
	String upd_hosp_chrg_pat_amt="";
	String upd_med_chrg_amt="";
	String upd_med_chrg_pat_amt="";	
	String upd_addl_chrg_amt="";
	String upd_addl_chrg_pat_amt="";

/*** CRF-362 SCRUM related changes starts ****/
	String charge_net_amt="";
	String patientPayble="";
	String encounterId="";
	String ae_bed_calYN="";
	//System.out.println("Entering into BLVisitChargeDet.jsp *** "); //muthu

	//Added by muthuN for 32915 on 15-6-2012
	
	
			Boolean KDAHSite_fin_tab=false;
			String KDAHSite_finTab ="";
			try
			{
				KDAHSite_fin_tab = eCommon.Common.CommonBean.isSiteSpecific(con, "OP","OP_AUTO_APPLY_PRACTO_APPT");	
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			if(KDAHSite_fin_tab){
				KDAHSite_finTab="Y";
			}
			else{
				KDAHSite_finTab="N";
			}
	
	try
		{		
			pstmt = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null )
			{
				customer_id  =  rs.getString(1);
 				//System.out.println("customer_id ChargeDet.jsp ==> "+customer_id);
			}
			}
			catch(Exception e)
			{   e.printStackTrace();
				System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}
//Added by muthuN for 32915 on 15-6-2012

//	String error_level="";
//	String sys_message_id="";
//	String error_text="";
	ae_bed_calYN=request.getParameter("ae_bed_calYN");
	if (ae_bed_calYN == null || ae_bed_calYN.equals("null") || ae_bed_calYN.equals("")) ae_bed_calYN = "N";

	patientPayble=request.getParameter("patientPayble");
	if (patientPayble == null || patientPayble.equals("null") || patientPayble.equals("")) patientPayble = "";

	encounterId=request.getParameter("encounterId");
	if (encounterId == null || encounterId.equals("null")) patientPayble = "";

	charge_net_amt=request.getParameter("charge_net_amt");
	if (charge_net_amt == null || charge_net_amt.equals("null") || charge_net_amt.equals("")) charge_net_amt = "";
	
//	System.err.println("charge_net_amt:"+charge_net_amt);
//	System.err.println("patientPayble:"+patientPayble);
//	System.err.println("encounterId:"+encounterId);
//	System.err.println("ae_bed_calYN:"+ae_bed_calYN);
	
	call_after_reg=request.getParameter("call_after_reg");
	if ( call_after_reg == null ) call_after_reg = "";
/*** CRF-362 SCRUM related changes ends ****/

	String exempt_date=request.getParameter("exempt_date");
	if ( exempt_date == null ) exempt_date = "";

	String hospvisitchargeYN = request.getParameter("hospvisitchargeYN");
	if ( hospvisitchargeYN == null ) hospvisitchargeYN = "N";
	

	String medvisitchargeYN = request.getParameter("medvisitchargeYN");
	if ( medvisitchargeYN == null ) medvisitchargeYN = "N";

	String addlvisitchargeYN = request.getParameter("addlvisitchargeYN");
	if ( addlvisitchargeYN == null ) addlvisitchargeYN = "N";

	String bill_gen=request.getParameter("bill_gen");
	if ( bill_gen == null ) bill_gen = "";

	String facility_id = (String)httpSession.getValue("facility_id");
	if ( facility_id == null ) facility_id = "";
	
	String episode_id=request.getParameter("episode_id");
	if ( episode_id == null || episode_id.equals("")) episode_id = "0";

	String episode_type=request.getParameter("episode_type");
	if ( episode_type == null ) episode_type = "";

	String visit_type_code=request.getParameter("visit_type_code");
	if ( visit_type_code == null ) visit_type_code = "";

	String visit_id=request.getParameter("visit_id");
	if ( visit_id == null || visit_id.equals("")) visit_id = "0";

	String patient_id=request.getParameter("patient_id");
	if ( patient_id == null ) patient_id = "";

	calling_module_id=request.getParameter("calling_module_id");
	if(calling_module_id==null) calling_module_id="";
//System.err.println("calling_module_id det :"+calling_module_id);
	String clinic_code = request.getParameter("clinic_code");
	if(clinic_code==null) clinic_code="";

	hosp_serv_panel_ind = request.getParameter("hosp_serv_panel_ind");
	if(hosp_serv_panel_ind==null) hosp_serv_panel_ind="";

	hosp_serv_panel_code = request.getParameter("hosp_serv_panel_code");
	if(hosp_serv_panel_code==null) hosp_serv_panel_code="";

	hosp_serv_panel_qty = request.getParameter("hosp_serv_panel_qty");
	if(hosp_serv_panel_qty==null) hosp_serv_panel_qty="";

	hosp_serv_chrg_amt = request.getParameter("hosp_serv_chrg_amt");
	if(hosp_serv_chrg_amt==null) hosp_serv_chrg_amt="";

	med_serv_panel_ind = request.getParameter("med_serv_panel_ind");
	if(med_serv_panel_ind==null) med_serv_panel_ind="";

	med_serv_panel_code = request.getParameter("med_serv_panel_code");
	if(med_serv_panel_code==null) med_serv_panel_code="";

	med_serv_panel_qty = request.getParameter("med_serv_panel_qty");
	if(med_serv_panel_qty==null) med_serv_panel_qty="";

	med_serv_chrg_amt = request.getParameter("med_serv_chrg_amt");
	if(med_serv_chrg_amt==null) med_serv_chrg_amt="";

	addl_serv_panel_ind = request.getParameter("addl_serv_panel_ind");
	if(addl_serv_panel_ind==null) addl_serv_panel_ind="";

	addl_serv_panel_code = request.getParameter("addl_serv_panel_code");
	if(addl_serv_panel_code==null) addl_serv_panel_code="";

	addl_serv_panel_qty = request.getParameter("addl_serv_panel_qty");
	if(addl_serv_panel_qty==null) addl_serv_panel_qty="";

	addl_serv_chrg_amt = request.getParameter("addl_serv_chrg_amt");
	if(addl_serv_chrg_amt==null) addl_serv_chrg_amt="";

	str_hosp_chrg_amt = request.getParameter("str_hosp_chrg_amt");
	if(str_hosp_chrg_amt==null) str_hosp_chrg_amt="";

	str_hosp_chrg_pat_amt = request.getParameter("str_hosp_chrg_pat_amt");
	if(str_hosp_chrg_pat_amt==null) str_hosp_chrg_pat_amt="";

	str_med_chrg_amt = request.getParameter("str_med_chrg_amt");
	if(str_med_chrg_amt==null) str_med_chrg_amt="";

	str_med_chrg_pat_amt = request.getParameter("str_med_chrg_pat_amt");
	if(str_med_chrg_pat_amt==null) str_med_chrg_pat_amt="";

	str_addl_chrg_amt = request.getParameter("str_addl_chrg_amt");
	if(str_addl_chrg_amt==null) str_addl_chrg_amt="";

	str_addl_chrg_pat_amt = request.getParameter("str_addl_chrg_pat_amt");
	if(str_addl_chrg_pat_amt==null) str_addl_chrg_pat_amt="";

	upd_hosp_chrg_amt=request.getParameter("upd_hosp_chrg_amt");
	if(upd_hosp_chrg_amt==null) upd_hosp_chrg_amt="";

	if(!upd_hosp_chrg_amt.equals(""))
	{
		str_hosp_chrg_amt=upd_hosp_chrg_amt;
	}

	upd_hosp_chrg_pat_amt=request.getParameter("upd_hosp_chrg_pat_amt");
	if(upd_hosp_chrg_pat_amt==null) upd_hosp_chrg_pat_amt="";
	
	if(!upd_hosp_chrg_pat_amt.equals(""))
	{
		str_hosp_chrg_pat_amt=upd_hosp_chrg_pat_amt;
	}

	upd_med_chrg_amt=request.getParameter("upd_med_chrg_amt");
	if(upd_med_chrg_amt==null) upd_med_chrg_amt="";
	
	if(!upd_med_chrg_amt.equals(""))
	{
		str_med_chrg_amt=upd_med_chrg_amt;
	}

	upd_med_chrg_pat_amt=request.getParameter("upd_med_chrg_pat_amt");
	if(upd_med_chrg_pat_amt==null) upd_med_chrg_pat_amt="";
	
	if(!upd_med_chrg_pat_amt.equals(""))
	{
		str_med_chrg_pat_amt=upd_med_chrg_pat_amt;
	}

	upd_addl_chrg_amt=request.getParameter("upd_addl_chrg_amt");
	if(upd_addl_chrg_amt==null) upd_addl_chrg_amt="";
	
	if(!upd_addl_chrg_amt.equals(""))
	{
		str_addl_chrg_amt=upd_addl_chrg_amt;
	}

	upd_addl_chrg_pat_amt=request.getParameter("upd_addl_chrg_pat_amt");
	if(upd_addl_chrg_pat_amt==null) upd_addl_chrg_pat_amt="";
		
	if(!upd_addl_chrg_pat_amt.equals(""))
	{
		str_addl_chrg_pat_amt=upd_addl_chrg_pat_amt;
	}

	String practo_appt_yn=request.getParameter("practo_appt_yn");
	if(practo_appt_yn==null) practo_appt_yn="N";
	
	
%>

<html>
	<head>
	<script language='javascript'>
		function showvisitcharge()
		{		
			var hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;
			var medvisitchargeYN=document.forms[0].medvisitchargeYN.value;
			var addlvisitchargeYN = document.forms[0].addlvisitchargeYN.value;
			var exempt_date=document.forms[0].exempt_date.value;
			var bill_gen=document.forms[0].bill_gen.value;

/*** CRF-362 SCRUM related changes starts ****/
			var charge_net_amt=document.forms[0].charge_net_amt.value;
			var patientPayble=document.forms[0].patientPayble.value;
			var ae_bed_calYN=document.forms[0].ae_bed_calYN.value;
/*** CRF-362 SCRUM related changes ends ****/

			if(hospvisitchargeYN == "Y")
			{
				document.getElementById("hospchrgamt").innerText=document.forms[0].str_hosp_chrg_amt.value;
				document.getElementById("hospchrgpatamt").innerText=document.forms[0].str_hosp_chrg_pat_amt.value;
			}
			if(medvisitchargeYN == "Y")
			{
				document.getElementById("profchrgamt").innerText=document.forms[0].str_med_chrg_amt.value;
				document.getElementById("profchrgpatamt").innerText=document.forms[0].str_med_chrg_pat_amt.value;
			}
			if(addlvisitchargeYN == "Y")
			{
				document.getElementById("addlchrgamt").innerText=document.forms[0].str_addl_chrg_amt.value;
				document.getElementById("addlchrgpatamt").innerText=document.forms[0].str_addl_chrg_pat_amt.value;
			}
			
/*** CRF-362 SCRUM related changes starts ****/
			if(charge_net_amt != "" && ae_bed_calYN == "Y")
			{
				document.getElementById("chrNetAmt").innerText=charge_net_amt;
				document.getElementById("patientbedpay").innerText=patientPayble;
			}
/*** CRF-362 SCRUM related changes ends ****/

			if(exempt_date!="")
			{
				document.getElementById("exemptdate").innerText=document.forms[0].exempt_date.value;
			}
			else if(bill_gen!="")
			{
				document.getElementById("billgen").innerText=document.forms[0].bill_gen.value;
			}

		 }
		
		function continuemodifybut(Obj)
		 {
			var call_after_reg=document.forms[0].call_after_reg.value;
			
			if (Obj == "C")
			 {
				if(call_after_reg=="Y")
				{
					//window.returnValue=1;
					//parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 1;
					parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue= 1;
 
					document.forms[0].action="../../servlet/eBL.BLFinancialDetailsCloseConsultServlet";
					document.forms[0].submit();
					//parent.parent.document.getElementById('dialog_tag').close();
				}
				else
				{
					//window.returnValue=1;
					//window.close();
					
					/* parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 1;
					parent.parent.document.getElementById('dialog_tag').close(); */
					parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = 1;
					parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
 
				}
			 }
			else
			 {	
				//window.returnValue=2;
				//window.close();		
				/* parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 2;
				parent.parent.document.getElementById('dialog_tag').close(); */
				parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = 2;
				parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();

			}

		 }

		 /* function continuemodifybut(Obj)
		 {
			var call_after_reg=document.forms[0].call_after_reg.value;

			if (Obj == "C")
			 {
				if(call_after_reg=="Y")
				{
//					alert("In VisitChargeDet");
					window.returnValue=1;
					document.forms[0].action="../../servlet/eBL.BLFinancialDetailsCloseConsultServlet";
					document.forms[0].submit();
				}
				else
				{
					
					window.returnValue=1;
					window.close();			
				}
			 }
			else
			 {	
			
				window.returnValue=2;
				window.close();			
			}

		 } */

		 function hsptl_chrg()
		 {
			var episode_type=document.forms[0].episode_type.value;
			var patient_id = document.forms[0].patient_id.value;			
			var visit_id=document.forms[0].visit_id.value;
			var episode_id=document.forms[0].episode_id.value;
			var calling_module_id=document.forms[0].calling_module_id.value;
			var call_after_reg=document.forms[0].call_after_reg.value;

			var hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;
			var hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;
			var hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;
			var hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;

			var med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;
			var med_serv_panel_code=document.forms[0].med_serv_panel_code.value;
			var med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;
			var med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;

			var addl_serv_panel_ind=document.forms[0].addl_serv_panel_ind.value;
			var addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;
//			var med_serv_panel_str=document.forms[0].med_serv_panel_str.value;
			var addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;
			var addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;

			var str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;
			var str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;
			var str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;
			var str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;
			var str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;
			var str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;

			var hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;
			var medvisitchargeYN=document.forms[0].medvisitchargeYN.value;
			var addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;

			var exempt_date = document.forms[0].exempt_date.value;

			var clinic_code=document.forms[0].clinic_code.value;
/*** CRF-362 SCRUM related changes starts ****/
			var charge_net_amt=document.forms[0].charge_net_amt.value;
			var patientPayble=document.forms[0].patientPayble.value;
/*** CRF-362 SCRUM related changes ends ****/
			 var url="../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble="+patientPayble+"&charge_net_amt="+charge_net_amt+"&hsptl_chrg=Y&call_after_reg="+call_after_reg+"&episode_type="+episode_type+"&episode_id="+episode_id+"&patient_id="+patient_id+"&visit_id="+visit_id+"&calling_module_id="+calling_module_id+"&hosp_serv_panel_ind="+hosp_serv_panel_ind+"&hosp_serv_panel_code="+hosp_serv_panel_code+"&hosp_serv_panel_qty="+hosp_serv_panel_qty+"&hosp_serv_chrg_amt="+hosp_serv_chrg_amt+"&med_serv_panel_ind="+med_serv_panel_ind+"&med_serv_panel_code="+med_serv_panel_code+"&med_serv_panel_qty="+med_serv_panel_qty+"&med_serv_chrg_amt="+med_serv_chrg_amt+"&addl_serv_panel_ind="+addl_serv_panel_ind+"&addl_serv_panel_code="+addl_serv_panel_code+"&addl_serv_panel_qty="+addl_serv_panel_qty+"&addl_serv_chrg_amt="+addl_serv_chrg_amt+"&str_hosp_chrg_amt="+str_hosp_chrg_amt+"&str_hosp_chrg_pat_amt="+str_hosp_chrg_pat_amt+"&str_med_chrg_amt="+str_med_chrg_amt+"&str_med_chrg_pat_amt="+str_med_chrg_pat_amt+"&str_addl_chrg_amt="+str_addl_chrg_amt+"&str_addl_chrg_pat_amt="+str_addl_chrg_pat_amt+"&clinic_code="+clinic_code+"&hospvisitchargeYN="+hospvisitchargeYN+"&medvisitchargeYN="+medvisitchargeYN+"&addlvisitchargeYN="+addlvisitchargeYN+"&exempt_date="+encodeURIComponent(exempt_date);

			
//			alert("url:"+url);
			parent.frames[1].location.href=url;
		
		}

		 function prof_chrg()
		 {

			 var episode_type=document.forms[0].episode_type.value;
			var patient_id = document.forms[0].patient_id.value;
			var visit_id=document.forms[0].visit_id.value;
			var episode_id=document.forms[0].episode_id.value;
			var calling_module_id=document.forms[0].calling_module_id.value;
			var call_after_reg=document.forms[0].call_after_reg.value;

			var hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;
			var hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;
//			var hosp_serv_panel_str=document.forms[0].hosp_serv_panel_str.value;
			var hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;
			var hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;

			var med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;
			var med_serv_panel_code=document.forms[0].med_serv_panel_code.value;
//			var med_serv_panel_str=document.forms[0].med_serv_panel_str.value;
			var med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;
			var med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;

			var addl_serv_panel_ind=document.forms[0].addl_serv_panel_ind.value;
			var addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;
//			var med_serv_panel_str=document.forms[0].med_serv_panel_str.value;
			var addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;
			var addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;
			
			var str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;
			var str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;
			var str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;
			var str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;
			var str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;
			var str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;

			var exempt_date = document.forms[0].exempt_date.value;

			var clinic_code=document.forms[0].clinic_code.value;

			var hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;
			var medvisitchargeYN=document.forms[0].medvisitchargeYN.value;
			var addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;

/*** CRF-362 SCRUM related changes starts ****/
			var charge_net_amt=document.forms[0].charge_net_amt.value;
			var patientPayble=document.forms[0].patientPayble.value;
/*** CRF-362 SCRUM related changes ends ****/

			var url="../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble="+patientPayble+"&charge_net_amt="+charge_net_amt+"&prof_chrg=Y&call_after_reg="+call_after_reg+"&episode_type="+episode_type+"&episode_id="+episode_id+"&patient_id="+patient_id+"&visit_id="+visit_id+"&calling_module_id="+calling_module_id+"&hosp_serv_panel_ind="+hosp_serv_panel_ind+"&hosp_serv_panel_code="+hosp_serv_panel_code+"&hosp_serv_panel_qty="+hosp_serv_panel_qty+"&hosp_serv_chrg_amt="+hosp_serv_chrg_amt+"&med_serv_panel_ind="+med_serv_panel_ind+"&med_serv_panel_code="+med_serv_panel_code+"&med_serv_panel_qty="+med_serv_panel_qty+"&med_serv_chrg_amt="+med_serv_chrg_amt+"&addl_serv_panel_ind="+addl_serv_panel_ind+"&addl_serv_panel_code="+addl_serv_panel_code+"&addl_serv_panel_qty="+addl_serv_panel_qty+"&addl_serv_chrg_amt="+addl_serv_chrg_amt+"&str_hosp_chrg_amt="+str_hosp_chrg_amt+"&str_hosp_chrg_pat_amt="+str_hosp_chrg_pat_amt+"&str_med_chrg_amt="+str_med_chrg_amt+"&str_med_chrg_pat_amt="+str_med_chrg_pat_amt+"&str_addl_chrg_amt="+str_addl_chrg_amt+"&str_addl_chrg_pat_amt="+str_addl_chrg_pat_amt+"&clinic_code="+clinic_code+"&hospvisitchargeYN="+hospvisitchargeYN+"&medvisitchargeYN="+medvisitchargeYN+"&addlvisitchargeYN="+addlvisitchargeYN+"&exempt_date="+encodeURIComponent(exempt_date);

//			alert("url:"+url);
			
			parent.frames[1].location.href=url;
		 }

		 function addl_chrg()
		 {

			 var episode_type=document.forms[0].episode_type.value;
			var patient_id = document.forms[0].patient_id.value;
			var visit_id=document.forms[0].visit_id.value;
			var episode_id=document.forms[0].episode_id.value;
			var calling_module_id=document.forms[0].calling_module_id.value;
			var call_after_reg=document.forms[0].call_after_reg.value;

			var hosp_serv_panel_ind=document.forms[0].hosp_serv_panel_ind.value;
			var hosp_serv_panel_code=document.forms[0].hosp_serv_panel_code.value;
//			var hosp_serv_panel_str=document.forms[0].hosp_serv_panel_str.value;
			var hosp_serv_panel_qty=document.forms[0].hosp_serv_panel_qty.value;
			var hosp_serv_chrg_amt=document.forms[0].hosp_serv_chrg_amt.value;

			var med_serv_panel_ind=document.forms[0].med_serv_panel_ind.value;
			var med_serv_panel_code=document.forms[0].med_serv_panel_code.value;
//			var med_serv_panel_str=document.forms[0].med_serv_panel_str.value;
			var med_serv_panel_qty=document.forms[0].med_serv_panel_qty.value;
			var med_serv_chrg_amt=document.forms[0].med_serv_chrg_amt.value;

			var addl_serv_panel_ind=document.forms[0].addl_serv_panel_ind.value;
			var addl_serv_panel_code=document.forms[0].addl_serv_panel_code.value;
//			var med_serv_panel_str=document.forms[0].med_serv_panel_str.value;
			var addl_serv_panel_qty=document.forms[0].addl_serv_panel_qty.value;
			var addl_serv_chrg_amt=document.forms[0].addl_serv_chrg_amt.value;
			
			var str_hosp_chrg_amt=document.forms[0].str_hosp_chrg_amt.value;
			var str_hosp_chrg_pat_amt=document.forms[0].str_hosp_chrg_pat_amt.value;
			var str_med_chrg_amt=document.forms[0].str_med_chrg_amt.value;
			var str_med_chrg_pat_amt=document.forms[0].str_med_chrg_pat_amt.value;
			var str_addl_chrg_amt=document.forms[0].str_addl_chrg_amt.value;
			var str_addl_chrg_pat_amt=document.forms[0].str_addl_chrg_pat_amt.value;

			var exempt_date = document.forms[0].exempt_date.value;

			var clinic_code=document.forms[0].clinic_code.value;

			var hospvisitchargeYN=document.forms[0].hospvisitchargeYN.value;
			var medvisitchargeYN=document.forms[0].medvisitchargeYN.value;
			var addlvisitchargeYN=document.forms[0].addlvisitchargeYN.value;

/*** CRF-362 SCRUM related changes starts ****/
			var charge_net_amt=document.forms[0].charge_net_amt.value;
			var patientPayble=document.forms[0].patientPayble.value;
/*** CRF-362 SCRUM related changes ends ****/

			var url="../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble="+patientPayble+"&charge_net_amt="+charge_net_amt+"&addl_chrg=Y&call_after_reg="+call_after_reg+"&episode_type="+episode_type+"&episode_id="+episode_id+"&patient_id="+patient_id+"&visit_id="+visit_id+"&calling_module_id="+calling_module_id+"&hosp_serv_panel_ind="+hosp_serv_panel_ind+"&hosp_serv_panel_code="+hosp_serv_panel_code+"&hosp_serv_panel_qty="+hosp_serv_panel_qty+"&hosp_serv_chrg_amt="+hosp_serv_chrg_amt+"&med_serv_panel_ind="+med_serv_panel_ind+"&med_serv_panel_code="+med_serv_panel_code+"&med_serv_panel_qty="+med_serv_panel_qty+"&med_serv_chrg_amt="+med_serv_chrg_amt+"&addl_serv_panel_ind="+addl_serv_panel_ind+"&addl_serv_panel_code="+addl_serv_panel_code+"&addl_serv_panel_qty="+addl_serv_panel_qty+"&addl_serv_chrg_amt="+addl_serv_chrg_amt+"&str_hosp_chrg_amt="+str_hosp_chrg_amt+"&str_hosp_chrg_pat_amt="+str_hosp_chrg_pat_amt+"&str_med_chrg_amt="+str_med_chrg_amt+"&str_med_chrg_pat_amt="+str_med_chrg_pat_amt+"&str_addl_chrg_amt="+str_addl_chrg_amt+"&str_addl_chrg_pat_amt="+str_addl_chrg_pat_amt+"&clinic_code="+clinic_code+"&hospvisitchargeYN="+hospvisitchargeYN+"&medvisitchargeYN="+medvisitchargeYN+"&addlvisitchargeYN="+addlvisitchargeYN+"&exempt_date="+encodeURIComponent(exempt_date);

//			alert("url:"+url);
			
			parent.frames[1].location.href=url;
		 }

	</script>

	<title><fmt:message key="eBL.VISIT_CHARGE_DTL.label" bundle="${bl_labels}"/></title>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>			
			<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	</head>
	<script language="javascript">
	
	$(document).ready(function () {
		
		var KDAHSite_fin_det = document.forms[0].KDAHSite_finTab.value;
		var pract_app_yn = document.forms[0].practo_appt_yn.value;
		if(pract_app_yn == "Y"){
		if(KDAHSite_fin_det== "Y"){	
			document.getElementById("continue").click();
			  $("continue").click();  
		}
		}				
		});
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<body onLoad='showvisitcharge();' onUnload='' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();">
<form name='VisitChargeDet' id='VisitChargeDet' method='post' action=''>		
<table cellpadding='10' cellspacing='0' border='0' align='center' width='100%' height='100%'>	
<!-- Added by muthuN for 32915 on 15-6-2012 -->
<%
if(customer_id.equals("MOHBR")){	
	if(hospvisitchargeYN.equals("Y"))
	{
%>
	<tr>
<%
		if(calling_module_id.equals("MP"))
		{
%>
		<td width="25%" class="label" align='right'><a href="#" onClick="hsptl_chrg();"><fmt:message key="eBL.PAT_REG_CHRG.label" bundle="${bl_labels}"/></a></td>
<%
		}
		else
		{
%>
		<td width="25%" class="label" align='right'><a href="#" onClick="hsptl_chrg();"><fmt:message key="eBL.RegistrationFee.Label" bundle="${bl_labels}"/></a></td>
<%
		}
%>
		<td width="25%" class="label" align='left'><b id="hospchrgamt"></b></td>
		<td width="25%" class="label" align='right'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
		<td width="25%" class="label" align='left'><b id="hospchrgpatamt"></b></td>
	</tr>
<%
	}
	if(medvisitchargeYN.equals("Y"))
	{
%>
	<tr>
		<td width="25%" class="label" align='right'><a href="#" onClick="prof_chrg();"><fmt:message key="eBL.ConsultationFee.Label" bundle="${bl_labels}"/></a></td>
		<td width="25%" class="label" align='left'><b id="profchrgamt"></b></td>
		<td width="25%" class="label" align='right'>
		<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
		<td width="25%" class="label" align='left'><b id="profchrgpatamt"></b></td>
	</tr>
<%
	}

}else {
%>
<!-- Added by muthuN for 32915 on 15-6-2012 -->
<% 
	if(hospvisitchargeYN.equals("Y"))
	{
%>
	<tr>
<%
		if(calling_module_id.equals("MP"))
		{
%>
		<td width="25%" class="label" align='right'><a href="#" onClick="hsptl_chrg();"><fmt:message key="eBL.PAT_REG_CHRG.label" bundle="${bl_labels}"/></a></td>
<%
		}
		else
		{
%>
		<td width="25%" class="label" align='right'><a href="#" onClick="hsptl_chrg();"><fmt:message key="eBL.HOSP_CHRG.label" bundle="${bl_labels}"/></a></td>
<%
		}
%>
		<td width="25%" class="label" align='left'><b id="hospchrgamt"></b></td>
		<td width="25%" class="label" align='right'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
		<td width="25%" class="label" align='left'><b id="hospchrgpatamt"></b></td>
	</tr>
<%
	}
	if(medvisitchargeYN.equals("Y"))
	{
%>
	<tr>
		<td width="25%" class="label" align='right'><a href="#" onClick="prof_chrg();"><fmt:message key="eBL.PROF_CHRG.label" bundle="${bl_labels}"/></a></td>
		<td width="25%" class="label" align='left'><b id="profchrgamt"></b></td>
		<td width="25%" class="label" align='right'>
		<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
		<td width="25%" class="label" align='left'><b id="profchrgpatamt"></b></td>
	</tr>
<%
	}
}
	if(addlvisitchargeYN.equals("Y"))
	{
%>
	<tr>
		<td width="25%" class="label" align='right'><a href="#" onClick="addl_chrg();"><fmt:message key="eBL.ADDL_CHARGE.label" bundle="${bl_labels}"/></a></td>
		<td width="25%" class="label" align='left'><b id="addlchrgamt"></b></td>
		<td width="25%" class="label" align='right'>
		<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
		<td width="25%" class="label" align='left'><b id="addlchrgpatamt"></b></td>
	</tr>

<%
			/*
		CRF -362 Displaying the Bill Charges
		this pract_type_ind variable used if user calling from current emergency patient and called visit charges details.we restrict the charges.
		*/
	}

/*** CRF-362 SCRUM related changes starts ****/
	if(!charge_net_amt.equals("") && ae_bed_calYN.equals("Y"))
	{
%>
	<tr>
		<td width="25%" class="label" align='right'><fmt:message key="eIP.BedCharge.label" bundle="${ip_labels}"/></a></td>
		<td width="25%" class="label" align='left'><b id="chrNetAmt"></b></td>
		<td width="25%" class="label" align='right'>
		<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
		<td width="25%" class="label" align='left'><b id="patientbedpay"></b></td>

	</tr> 
<%
	}
/*** CRF-362 SCRUM related changes ends ****/

	if(!exempt_date.equals(""))
	{
%>
	<tr>
	
		<td width="25%" class="label" colspan='4'><b id="exemptdate"></b></td>

	</tr>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
<%
	}
	else if(!bill_gen.equals(""))
	{
%>
	<tr>
	
		<td width="25%" class="label" colspan='4'><b id="billgen"></b></td>

	</tr>
	<tr>
		<td colspan='4'>&nbsp;</td>
	</tr>
<%
	}
%>
	
<%
	if(call_after_reg.equals("Y"))
	{
%>	
	<tr>		 
		<td width="25%" class="label" align='left'>&nbsp;</td>
		<td width="25%" class="label" align='left'>&nbsp;</td>
		<td width="25%" class="label" align='right'><input type=button class='button' name='continue' id='continue' id='continue' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" onClick='return continuemodifybut("C");'></td>
		<td width="25%" align='right'>
		
		<input type=button class='button' name='Revise' id='Revise' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")%>" onClick='return continuemodifybut("M");'>
		</td>
	</tr>
<!--
	<tr> 
	<td width="25%" class="label" align='left' colspan='4'><B><fmt:message key="Common.note.label" bundle="${common_labels}"/>:</B><fmt:message key="eBL.PAT_PAY_SIM_MES_1.label" bundle="${bl_labels}"/>&nbsp;<fmt:message key="eBL.PAT_PAY_SIM_MES_2.label" bundle="${bl_labels}"/></td>
	</tr>
-->
<%
	}
	else
	{
%>
	<tr>		 
		<td width="25%" class="label" align='left'>&nbsp;</td>
		<td width="25%" class="label" align='left'>&nbsp;</td>
		<td width="25%" class="label" align='right'><input type=button class='button' name='continue' id='continue' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" onClick='return continuemodifybut("C");'></td>
		<td width="25%" align='right'>
		
		<input type=button class='button' name='Revise' id='Revise' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")%>" onClick='return continuemodifybut("M");'></td>
	</tr>
<%
	}
%>
	

</table>

<input type="hidden" name="call_after_reg" id="call_after_reg"  value="<%=call_after_reg%>"> </input>

<input type="hidden" name='hospvisitchargeYN' id='hospvisitchargeYN' value='<%=hospvisitchargeYN%>'>
<input type="hidden" name='medvisitchargeYN' id='medvisitchargeYN' value='<%=medvisitchargeYN%>'>
<input type="hidden" name='addlvisitchargeYN' id='addlvisitchargeYN' value='<%=addlvisitchargeYN%>'>
<input type="hidden" name='exempt_date' id='exempt_date' value='<%=exempt_date%>'>
<input type="hidden" name='bill_gen' id='bill_gen' value='<%=bill_gen%>'>

<input type="hidden" name='episode_id' id='episode_id' value='<%=episode_id%>'>	
<input type="hidden" name='episode_type' id='episode_type' value='<%=episode_type%>'>	
<input type="hidden" name='visit_id' id='visit_id' value='<%=visit_id%>'>	
<input type="hidden" name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type="hidden" name='calling_module_id' id='calling_module_id' value='<%=calling_module_id%>'>


<input type="hidden" name="hosp_serv_panel_ind" id="hosp_serv_panel_ind"	 value="<%=hosp_serv_panel_ind%>"></input>	
<input type="hidden" name="hosp_serv_panel_code" id="hosp_serv_panel_code"	 value="<%=hosp_serv_panel_code%>"></input>	
<input type="hidden" name="hosp_serv_panel_qty" id="hosp_serv_panel_qty"	 value="<%=hosp_serv_panel_qty%>"></input>
<input type="hidden" name="hosp_serv_chrg_amt" id="hosp_serv_chrg_amt"	 value="<%=hosp_serv_chrg_amt%>"></input>

<input type="hidden" name="med_serv_panel_ind" id="med_serv_panel_ind"	 value="<%=med_serv_panel_ind%>"></input>	
<input type="hidden" name="med_serv_panel_code" id="med_serv_panel_code"	 value="<%=med_serv_panel_code%>"></input>	
<input type="hidden" name="med_serv_panel_qty" id="med_serv_panel_qty"	 value="<%=med_serv_panel_qty%>"></input>
<input type="hidden" name="med_serv_chrg_amt" id="med_serv_chrg_amt"	 value="<%=med_serv_chrg_amt%>"></input>

<input type="hidden" name="addl_serv_panel_ind" id="addl_serv_panel_ind"	 value="<%=addl_serv_panel_ind%>"></input>	
<input type="hidden" name="addl_serv_panel_code" id="addl_serv_panel_code"	 value="<%=addl_serv_panel_code%>"></input>	
<input type="hidden" name="addl_serv_panel_qty" id="addl_serv_panel_qty"	 value="<%=addl_serv_panel_qty%>"></input>
<input type="hidden" name="addl_serv_chrg_amt" id="addl_serv_chrg_amt"	 value="<%=addl_serv_chrg_amt%>"></input>

<input type="hidden" name="str_hosp_chrg_amt" id="str_hosp_chrg_amt"	 value="<%=str_hosp_chrg_amt%>"></input>
<input type="hidden" name="str_hosp_chrg_pat_amt" id="str_hosp_chrg_pat_amt"	 value="<%=str_hosp_chrg_pat_amt%>"></input>
<input type="hidden" name="str_med_chrg_amt" id="str_med_chrg_amt"	 value="<%=str_med_chrg_amt%>"></input>
<input type="hidden" name="str_med_chrg_pat_amt" id="str_med_chrg_pat_amt"	 value="<%=str_med_chrg_pat_amt%>"></input>		 
<input type="hidden" name="str_addl_chrg_amt" id="str_addl_chrg_amt"	 value="<%=str_addl_chrg_amt%>"></input>
<input type="hidden" name="str_addl_chrg_pat_amt" id="str_addl_chrg_pat_amt"	 value="<%=str_addl_chrg_pat_amt%>"></input>		 

<input type="hidden" name="clinic_code" id="clinic_code"	 value="<%=clinic_code%>"></input>

<!-- CRF-362 SCRUM related changes starts -->
<input type="hidden" name="charge_net_amt" id="charge_net_amt"	 value="<%=charge_net_amt%>"></input>
<input type="hidden" name="encounterId" id="encounterId"	 value="<%=encounterId%>"></input>
<input type="hidden" name="patientPayble" id="patientPayble"	 value="<%=patientPayble%>"></input>
<input type="hidden" name="ae_bed_calYN" id="ae_bed_calYN"	 value="<%=ae_bed_calYN%>"></input>
<input type='hidden' name='KDAHSite_finTab' id='KDAHSite_finTab' id='KDAHSite_finTab' value='<%=KDAHSite_finTab%>'> 
<input type='hidden' name='practo_appt_yn' id='practo_appt_yn' id='practo_appt_yn' value='<%=practo_appt_yn%>'> 

<!-- CRF-362 SCRUM related changes ends -->
	 
</form>
</body>

<%
	}
	catch(Exception e)
	{
		System.out.println("Main Exception:"+e);
	}
	finally
	{ 
		ConnectionManager.returnConnection(con, request);
	}
%>

</html>



