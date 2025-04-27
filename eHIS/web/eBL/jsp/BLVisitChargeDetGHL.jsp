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


	String customer_id="";
	String calling_module_id="";
	String call_after_reg="";

	String hosp_serv_panel_ind="";
	String hosp_serv_panel_code="";
	String hosp_serv_panel_qty="";
	String hosp_serv_chrg_amt="";

	String med_serv_panel_ind="";
	String med_serv_panel_code="";
	String med_serv_panel_qty="";
	String med_serv_chrg_amt="";

	String addl_serv_panel_ind="";
	String addl_serv_panel_code="";
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

	String charge_net_amt="";
	String patientPayble="";
	String encounterId="";
	String ae_bed_calYN="";
	
	String orderCatalogCodeStr = "", orderCtlgDtls = "", orderCtlgTotal = "";//Added V190403-Aravindh/GHL-CRF-0525

	ae_bed_calYN=request.getParameter("ae_bed_calYN");
	if (ae_bed_calYN == null || ae_bed_calYN.equals("null") || ae_bed_calYN.equals("")) ae_bed_calYN = "N";

	patientPayble=request.getParameter("patientPayble");
	if (patientPayble == null || patientPayble.equals("null") || patientPayble.equals("")) patientPayble = "";

	encounterId=request.getParameter("encounterId");
	if (encounterId == null || encounterId.equals("null")) patientPayble = "";

	charge_net_amt=request.getParameter("charge_net_amt");
	if (charge_net_amt == null || charge_net_amt.equals("null") || charge_net_amt.equals("")) charge_net_amt = "";
	
	
	call_after_reg=request.getParameter("call_after_reg");
	if ( call_after_reg == null ) call_after_reg = "";

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
	
	orderCatalogCodeStr = request.getParameter("orderCatalogCode");//Added V190403-Aravindh/GHL-CRF-0525
	if (orderCatalogCodeStr == null) orderCatalogCodeStr="";//Added V190403-Aravindh/GHL-CRF-0525
	
	orderCtlgDtls = request.getParameter("strOrderCtlgDtls");//Added V190403-Aravindh/GHL-CRF-0525
	if (orderCtlgDtls == null) orderCtlgDtls="";//Added V190403-Aravindh/GHL-CRF-0525
	
	orderCtlgTotal = request.getParameter("strOrderCtlgTotal");//Added V190403-Aravindh/GHL-CRF-0525
	if (orderCtlgTotal == null) orderCtlgTotal="";//Added V190403-Aravindh/GHL-CRF-0525

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

			var charge_net_amt=document.forms[0].charge_net_amt.value;
			var patientPayble=document.forms[0].patientPayble.value;
			var ae_bed_calYN=document.forms[0].ae_bed_calYN.value;

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
			
			if(charge_net_amt != "" && ae_bed_calYN == "Y")
			{
				document.getElementById("chrNetAmt").innerText=charge_net_amt;
				document.getElementById("patientbedpay").innerText=patientPayble;
			}

			if(exempt_date!="")
			{
				document.getElementById("exemptdate").innerText=document.forms[0].exempt_date.value;
			}
			else if(bill_gen!="")
			{
				document.getElementById("billgen").innerText=document.forms[0].bill_gen.value;
			}
			
			var strOrderCtlgDtls = document.forms[0].strOrderCtlgDtls.value;
			var strOrderCtlgTotal = document.forms[0].strOrderCtlgTotal.value;
			if(strOrderCtlgDtls != "") {
				var strOrderCtlgDtlsSplit = strOrderCtlgDtls.split("|");
				for(var i = 0; i < strOrderCtlgDtlsSplit.length; i++) {
					var orderCtlgDtlsSplit = strOrderCtlgDtlsSplit[i].split("~");
					document.getElementById(orderCtlgDtlsSplit[0]+"_net").innerText = orderCtlgDtlsSplit[1];
					document.getElementById(orderCtlgDtlsSplit[0]+"_pat").innerText = orderCtlgDtlsSplit[3];
				}
			}
			
			var totalNetAmt = 0, totalPatAmt = 0;
			
			if(strOrderCtlgTotal != "") {
				var strOrderCtlgTotalSplit = strOrderCtlgTotal.split("~");
				totalNetAmt = strOrderCtlgTotalSplit[0];
				totalPatAmt = strOrderCtlgTotalSplit[2];
				
				if(hospvisitchargeYN == "Y")
				{
					if(isNaN(document.forms[0].str_hosp_chrg_amt.value) != false || isNaN(document.forms[0].str_hosp_chrg_amt.value) != "false") {
						totalNetAmt = +totalNetAmt + +document.forms[0].str_hosp_chrg_amt.value;
					}
					if(isNaN(document.forms[0].str_hosp_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_hosp_chrg_pat_amt.value) != "false") {
						totalPatAmt = +totalPatAmt + +document.forms[0].str_hosp_chrg_pat_amt.value;
					}
				}
				
				if(medvisitchargeYN == "Y")
				{
					if(isNaN(document.forms[0].str_med_chrg_amt.value) != false || isNaN(document.forms[0].str_med_chrg_amt.value) != "false") {
						totalNetAmt = +totalNetAmt + +document.forms[0].str_med_chrg_amt.value;
					}
					if(isNaN(document.forms[0].str_med_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_med_chrg_pat_amt.value) != "false") {
						totalPatAmt = +totalPatAmt + +document.forms[0].str_med_chrg_pat_amt.value;
					}
				}
				
				if(addlvisitchargeYN == "Y")
				{
					if(isNaN(document.forms[0].str_addl_chrg_amt.value) != false || isNaN(document.forms[0].str_addl_chrg_amt.value) != "false") {
						totalNetAmt = +totalNetAmt + +document.forms[0].str_addl_chrg_amt.value;
					}
					if(isNaN(document.forms[0].str_addl_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_addl_chrg_pat_amt.value) != "false") {
						totalPatAmt = +totalPatAmt + +document.forms[0].str_addl_chrg_pat_amt.value;
					}
				}
			} else {
				if(hospvisitchargeYN == "Y")
				{
					if(isNaN(document.forms[0].str_hosp_chrg_amt.value) != false || isNaN(document.forms[0].str_hosp_chrg_amt.value) != "false") {
						totalNetAmt = +totalNetAmt + +document.forms[0].str_hosp_chrg_amt.value;
					}
					if(isNaN(document.forms[0].str_hosp_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_hosp_chrg_pat_amt.value) != "false") {
						totalPatAmt = +totalPatAmt + +document.forms[0].str_hosp_chrg_pat_amt.value;
					}
				}
				
				if(medvisitchargeYN == "Y")
				{
					if(isNaN(document.forms[0].str_med_chrg_amt.value) != false || isNaN(document.forms[0].str_med_chrg_amt.value) != "false") {
						totalNetAmt = +totalNetAmt + +document.forms[0].str_med_chrg_amt.value;
					}
					if(isNaN(document.forms[0].str_med_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_med_chrg_pat_amt.value) != "false") {
						totalPatAmt = +totalPatAmt + +document.forms[0].str_med_chrg_pat_amt.value;
					}
				}
				
				if(addlvisitchargeYN == "Y")
				{
					if(isNaN(document.forms[0].str_addl_chrg_amt.value) != false || isNaN(document.forms[0].str_addl_chrg_amt.value) != "false") {
						totalNetAmt = +totalNetAmt + +document.forms[0].str_addl_chrg_amt.value;
					}
					if(isNaN(document.forms[0].str_addl_chrg_pat_amt.value) != false || isNaN(document.forms[0].str_addl_chrg_pat_amt.value) != "false") {
						totalPatAmt = +totalPatAmt + +document.forms[0].str_addl_chrg_pat_amt.value;
					}
				}
			}
			document.getElementById("total_net").innerText = totalNetAmt;
			document.getElementById("total_pat").innerText = totalPatAmt;
		 }

		 function continuemodifybut(Obj)
		 {
			var call_after_reg=document.forms[0].call_after_reg.value;

			if (Obj == "C")
			 {
				if(call_after_reg=="Y")
				{
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

		 }

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
			var charge_net_amt=document.forms[0].charge_net_amt.value;
			var patientPayble=document.forms[0].patientPayble.value;
			 var url="../../eBL/jsp/BLVisitChargeDetValidationBefore.jsp?patientPayble="+patientPayble+"&charge_net_amt="+charge_net_amt+"&hsptl_chrg=Y&call_after_reg="+call_after_reg+"&episode_type="+episode_type+"&episode_id="+episode_id+"&patient_id="+patient_id+"&visit_id="+visit_id+"&calling_module_id="+calling_module_id+"&hosp_serv_panel_ind="+hosp_serv_panel_ind+"&hosp_serv_panel_code="+hosp_serv_panel_code+"&hosp_serv_panel_qty="+hosp_serv_panel_qty+"&hosp_serv_chrg_amt="+hosp_serv_chrg_amt+"&med_serv_panel_ind="+med_serv_panel_ind+"&med_serv_panel_code="+med_serv_panel_code+"&med_serv_panel_qty="+med_serv_panel_qty+"&med_serv_chrg_amt="+med_serv_chrg_amt+"&addl_serv_panel_ind="+addl_serv_panel_ind+"&addl_serv_panel_code="+addl_serv_panel_code+"&addl_serv_panel_qty="+addl_serv_panel_qty+"&addl_serv_chrg_amt="+addl_serv_chrg_amt+"&str_hosp_chrg_amt="+str_hosp_chrg_amt+"&str_hosp_chrg_pat_amt="+str_hosp_chrg_pat_amt+"&str_med_chrg_amt="+str_med_chrg_amt+"&str_med_chrg_pat_amt="+str_med_chrg_pat_amt+"&str_addl_chrg_amt="+str_addl_chrg_amt+"&str_addl_chrg_pat_amt="+str_addl_chrg_pat_amt+"&clinic_code="+clinic_code+"&hospvisitchargeYN="+hospvisitchargeYN+"&medvisitchargeYN="+medvisitchargeYN+"&addlvisitchargeYN="+addlvisitchargeYN+"&exempt_date="+encodeURIComponent(exempt_date);

			
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body onLoad='showvisitcharge();' onUnload='' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();">
<form name='VisitChargeDet' id='VisitChargeDet' method='post' action=''>		
<table cellpadding='3' cellspacing='0' border='1' align='center' width='100%' height='100%'>	
<!-- Added by muthuN for 32915 on 15-6-2012 -->
<tr>
	<td class = 'COLUMNHEADER'  width="25%" nowrap>Code</td>
	<td class = 'COLUMNHEADER'  width="25%" nowrap>Description</td>
	<td class = 'COLUMNHEADER'  width="25%" nowrap>Net Amount</td>
	<td class = 'COLUMNHEADER'  width="25%" nowrap>Patient Net Payable</td>
</tr>

<% 
	if(hospvisitchargeYN.equals("Y"))
	{
%>
	<tr>
		<td width="25%" align = 'left'>&nbsp;</td>
		<td width="25%" align = 'center' class="label" style='text-align: center;'><a href="#" onClick="hsptl_chrg();"><fmt:message key="eBL.HOSP_CHRG.label" bundle="${bl_labels}"/></a></td>
		<td width="25%" align = 'right' class="label" style='text-align: right;'><div id="hospchrgamt"></div></td>
		<td width="25%" align = 'right' class="label" style='text-align: right;'><div id="hospchrgpatamt"></div></td>
	</tr>
<%
	}
	if(medvisitchargeYN.equals("Y"))
	{
%>
	<tr>
		<td width="25%" align='left'>&nbsp;</td>
		<td width="25%" align='center' class="label" style='text-align: center;'><a href="#" onClick="prof_chrg();"><fmt:message key="eBL.PROF_CHRG.label" bundle="${bl_labels}"/></a></td>
		<td width="25%" align='right' class="label" style='text-align: right;'><div id="profchrgamt"></div></td>
		<td width="25%" align='right' class="label" style='text-align: right;'><div id="profchrgpatamt"></div></td>
	</tr>
<%
	}
	
	if(addlvisitchargeYN.equals("Y"))
	{
%>
	<tr>
		<td width="25%" align='left'>&nbsp;</td>
		<td width="25%" align='center' class="label" style='text-align: center;'><a href="#" onClick="addl_chrg();"><fmt:message key="eBL.ADDL_CHARGE.label" bundle="${bl_labels}"/></a></td>
		<td width="25%" align='right' class="label" style='text-align: right;'><div id="addlchrgamt"></div></td>
		<td width="25%" align='right' class="label" style='text-align: right;'><div id="addlchrgpatamt"></div></td>
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
		<td width="25%" align='left'>&nbsp;</td>
		<td width="25%" align='center' class="label" style='text-align: center;'><fmt:message key="eIP.BedCharge.label" bundle="${ip_labels}"/></a></td>
		<td width="25%" align='right' class="label" style='text-align: right;'><div id="chrNetAmt"></div></td>
		<td width="25%" align='right' class="label" style='text-align: right;'><div id="patientbedpay"></div></td>

	</tr> 
<%
	}
/*** CRF-362 SCRUM related changes ends ****/

	/* Added for GHL-CRF-0525/Starts */
	//orderCatalogCodeStr = "~~TEAF000009~~CDCD000005~~CDCD000004~~";
	orderCatalogCodeStr = orderCatalogCodeStr.replace("~~", "~");
	System.out.println("BLVisitCharge->orderCatalogCodeStr: "+orderCatalogCodeStr);
	if(null != orderCatalogCodeStr && !"".equals(orderCatalogCodeStr)) {
		String[] orderCatalogCodeList = orderCatalogCodeStr.split("\\~");
		
		for(int i = 0; i < orderCatalogCodeList.length; i++) {
			pstmt = con.prepareStatement("SELECT SHORT_DESC FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE = ?");
			pstmt.setString(1, orderCatalogCodeList[i]);
			rs = pstmt.executeQuery();	
			if ( rs.next() && rs != null )
			{
	%>
			<tr>
				<td width="25%" align='center' class="label" style='text-align: center;'><%=orderCatalogCodeList[i] %></td>
				<td width="25%" align='center' nowrap class="label" style='text-align: center;'><%=rs.getString("SHORT_DESC") %></td>
				<td width="25%" align='right' class="label" style='text-align: right;'><div id="<%=orderCatalogCodeList[i]%>_net">&nbsp;</div></td>
				<td width="25%" align='right' class="label" style='text-align: right;'><div id="<%=orderCatalogCodeList[i]%>_pat">&nbsp;</div></td>
			</tr>
	<%	
			}
		}
	}
	%>
	<tr>
		<td width="25%" align='center'>&nbsp;</td>
		<td width="25%" align='right' nowrap class="label" style='text-align: right;'><b>Grant Total</b></td>
		<td width="25%" align='right' class="label" style='text-align: right;'><b id="total_net">&nbsp;</b></td>
		<td width="25%" align='right' class="label" style='text-align: right;'><b id="total_pat">&nbsp;</b></td>
	</tr>
	<%
	/* Added for GHL-CRF-0525/Ends */

	if(!exempt_date.equals(""))
	{
%>
	<tr>
	
		<td width="25%" class="label" colspan='4'><b id="exemptdate"></b></td>

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
		<!-- <td width="25%" align='left'>&nbsp;</td> -->
		<td width="25%" class="label" align='left' colspan = '2'>&nbsp;</td>
		<td width="25%" class="label" align='right'>
			<input type=button class='button' name='continue' id='continue' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" 
				onClick='return continuemodifybut("C");'>
		</td>
		<td width="25%" align='right'>
			<input type=button class='button' name='Revise' id='Revise' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")%>" 
			onClick='return continuemodifybut("M");'>
		</td>
	</tr>
<%
	}
	else
	{
%>
	<tr>		 
		<!-- <td width="25%" align='left'>&nbsp;</td> -->
		<td width="25%" class="label" align='left' colspan = '2'>&nbsp;</td>
		<td width="25%" class="label" align='right'>
			<input type=button class='button' name='continue' id='continue' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Continue.label","common_labels")%>" 
				onClick='return continuemodifybut("C");'>
		</td>
		<td width="25%" align='right'>
			<input type=button class='button' name='Revise' id='Revise' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revise.label","common_labels")%>" 
				onClick='return continuemodifybut("M");'>
		</td>
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
<!-- CRF-362 SCRUM related changes ends -->

<input type="hidden" name="strOrderCtlgDtls" id="strOrderCtlgDtls"	 value="<%=orderCtlgDtls%>"></input><!-- Added V190403-Aravindh/GHL-CRF-0525 -->
<input type="hidden" name="strOrderCtlgTotal" id="strOrderCtlgTotal"	 value="<%=orderCtlgTotal%>"></input><!-- Added V190403-Aravindh/GHL-CRF-0525 -->
	 
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

