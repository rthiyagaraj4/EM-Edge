<!DOCTYPE html>
<!-- Latest Modified Date : 9/17/2005 9:58 AM -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection, java.sql.ResultSet, java.sql.Statement, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con				= null;
	java.sql.Statement stmt		= null;
	java.sql.PreparedStatement pstmt = null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
    Boolean enteredByAppl = false;	// Added by shagar for ML-MMOH-CRF-1328
	con = ConnectionManager.getConnection(request);
	enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY"); // Added by shagar for ML-MMOH-CRF-1328
	String pat_name_as_multipart_yn = "";
	String names_in_oth_lang_yn		= "";
	String sql						= "";

	String patient		= request.getParameter("patient_id");
    String function_id	= request.getParameter("function_id") ;
	if(patient == null || patient.equals("null")) patient = "";
    if(function_id == null) function_id = "";

	String language_direction="";
	int count=0;
    
	try
	{

			/*---Starts----Following Code is to Check the Module with Billing Interface */
		String bl_install_yn=(String)session.getValue("mp_bl_oper_yn");    
		/*---Ends----Added on: 19-Jan-2002 by Prakash.S */

		stmt	= con.createStatement();
		sql	= "SELECT  patient_id_length,pat_name_as_multipart_yn, names_in_oth_lang_yn,(select count(*)  from sm_language where language_direction='R' and eff_status='E') total FROM mp_param";
		rs		= stmt.executeQuery(sql);
		rs.next();
		pat_name_as_multipart_yn = rs.getString(2);
		names_in_oth_lang_yn = rs.getString(3);
		count = rs.getInt("total");
		if(pstmt != null) pstmt.close();
		if(rs1 != null) rs1.close();	

		if ( count==1 ) {
			 language_direction = "R" ;
		}else{
			 language_direction = "L" ;
		}

	
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
		<Script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
		<Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
		
		
		<script language='javascript'>
			var currentTab = new String();
			currentTab = "demogrp_tab";
			var previousTab = new String();
			previousTab = "demogrp_tab"; 		
			
		
		async function capturePhoto() 
		{
		    var	url     = "../../eCommon/jsp/photo_capture.jsp?file="+document.getElementById("patient_id").value+'.jpg' ;
			//var dialogHeight    = "19" ;
		    //var dialogWidth = "23" ;
				var dialogHeight= "400px" ; //added by vijayan
				///var dialogTop = "10px" ;
				var dialogWidth	= "700px" ;
		    var arguments   = "" ;
		    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;";
		    var reportURL   = await window.showModalDialog( url, arguments, features ) ;
		}
		
		async function getFinDtl(qryStr)
		{
		    var retVal;
/*		    var dialogHeight= "24";
			var	dialogWidth = "49";
		    var dialogTop = "160";
			*/
			
			/*
			var dialogHeight= "41";
			var dialogWidth = "65";
			var dialogTop	= "85";
			*/
			
			var dialogTop   = "10px";
		    var dialogHeight= "400px" ;
		    var dialogWidth = "700px" ;

		    var center = "1";                                                         
		    var status="no";
		    var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		    var arguments   = "" ;
   
		    var url = "../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?"+qryStr;
		    retVal = await window.showModalDialog(url,arguments,features);
		
			if(retVal == null) retVal = "";
		
			return retVal;
        }
		
		function chkOnSub()
		{

			var pat_ser_code = "";
			if(parent.frames[1].document.getElementById("pat_ser_grp_code")) {
				pat_ser_code = parent.frames[1].document.getElementById("pat_ser_grp_code").value;			
			}
			//alert('pat_ser_code'+pat_ser_code);

			if(pat_ser_code == "") {
				var err = getMessage("CAN_NOT_BE_BLANK",'COMMON');
				err = err.replace('$',getLabel('eMP.PatientSeries.label','MP'));
				alert(err);
				return;
			}

			/*
			if(pat_ser_code == "") {
				alert("Patient Series can not be blank");
				return;
			} 
			*/	

			var package_flag	= "N";
		    var ins_auth_flag	= "N";
		    var upd_pat_flag	= "N";
		    var patient_id		= "<%=patient%>";
			if(parent.frames[1].document.forms[0].mother_patient_id)
			{
			var mother_patient_id=parent.frames[1].document.forms[0].mother_patient_id.value;

			if(mother_patient_id != '') patient_id = mother_patient_id;
			}
	
			var show_hide_blng_class	= "SHOW";
		    var billing_group			= parent.frames[1].document.forms[0].billing_group;
			
		    var billing_mode			= parent.frames[1].document.forms[0].billing_mode;

			var bl_data_from_repos_yn = "N";
			var data_source_id = parent.frames[1].document.forms[0].change_data_source;
		
			if(data_source_id.value != '' && billing_group.value != '')
			{
				bl_data_from_repos_yn = "Y";
			}
		
			if(billing_group.value != '') billing_mode.value = "Modify";
			
			var operation = parent.frames[1].document.forms[0].bl_operation.value;
			
			if(billing_mode.value=="Modify") operation="Update";
			
			if(operation=='Insert')
			{
				operation='';
				billing_mode.value = '';
			}
		
		
			var calling_module_id	   = "MP";
			var calling_function_id	   = "CHG_PAT_DTLS";
			//var calling_function_id	   = parent.frames[1].document.forms[0].function_id.value;

			//alert('calling_function_id-->'+calling_function_id);

			//end of Addition
		
			var episode="";
			var record="";
			
			var qryStr = "operation="+operation+"&upd_pat_flag="+upd_pat_flag+"&patient_id="+patient_id+"&show_hide_blng_class="+show_hide_blng_class+"&billing_mode="+billing_mode.value;
			
					
			qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
			qryStr += "&bl_data_from_repos_yn="+bl_data_from_repos_yn+"&data_source_id="+data_source_id.value;
			
			/* Start of modifications for billing enhancement on 8th Jan 04 --------------- */
						
				
			/*End of modifications for billing enhancement on 8th Jan 04 --------------- */
		
			var nationality_yn = "N";
			parent.frames[1].document.forms[0].dflt_nat_id_chk_val.value = parent.frames[1].document.forms[0].nationality_code.value;
			
			if(parent.frames[1].document.forms[0].nationality_code.value == 	parent.frames[1].document.forms[0].dflt_nationality_code.value)
			{
				nationality_yn = "Y";
			}
			else 
			{
				nationality_yn = "N";
			}
		
			qryStr+="&nationality_yn="+nationality_yn;
			qryStr+="&patient_class=XT&pat_ser_code="+pat_ser_code;
		   var returnArray = new Array();
	  
			returnArray = getFinDtl(qryStr);

			//tab_click(previousTab);

			parent.patient_main.invokeTab('demogrp_tab');

			if(returnArray.length>0)
			{
				billing_group.value         = returnArray[0];
				/*billing_class.value         = returnArray[1];
				employer_code.value         = returnArray[2];    
				cash_set_type1.value        = returnArray[3];
				cash_insmt_ref1.value       = returnArray[4];
				cash_insmt_date1.value      = returnArray[5];
				cash_insmt_rmks1.value      = returnArray[6];
				cust_1.value                = returnArray[7];
				credit_doc_ref1.value       = returnArray[8];
				credit_doc_date1.value      = returnArray[9];
				cust_2.value                = returnArray[10];
				credit_doc_ref2.value       = returnArray[11];
				credit_doc_date2.value      = returnArray[12];
				cust_3.value                = returnArray[13];
				policy_type.value           = returnArray[14];
				policy_no.value             = returnArray[15];
				policy_expiry_date.value    = returnArray[16];
				non_insur_blng_grp.value    = returnArray[17];
				cash_set_type2.value        = returnArray[18];
				cash_insmt_ref2.value       = returnArray[19];
				cash_insmt_date2.value      = returnArray[20];
				cash_insmt_rmks2.value      = returnArray[21];
				cust_4.value                = returnArray[22];
				credit_doc_ref3.value       = returnArray[23];
				credit_doc_date3.value      = returnArray[24];
				setlmt_ind.value            = returnArray[25];
				upd_fin_dtls.value          = returnArray[26];
				credit_auth_ref.value       = returnArray[27];
				credit_auth_date.value      = returnArray[28];
				app_days.value              = returnArray[29];
				app_amount.value            = returnArray[30];
				annual_income.value			= returnArray[31];
				family_asset.value			= returnArray[32];
				no_of_dependants.value		= returnArray[33];
				resp_for_payment.value		= returnArray[34];
				credit_doc_reqd_yn1.value	= returnArray[35];
				credit_doc_reqd_yn2.value	= returnArray[36];
				eff_frm_date.value          = returnArray[37];
				remarks.value               = returnArray[38];*/

				/* Start of modifications for billing enhancement on 8th Jan 04 ---------------
				cred_start_dt1.value = returnArray[40];
				cred_start_dt2.value = returnArray[41];
				cred_start_dt3.value = returnArray[42];
		
				parent.frames[1].document.forms[0].gl_holder_name.value = returnArray[43];
				parent.frames[1].document.forms[0].gl_holder_reln.value = returnArray[44]; */

				/*End of modifications for billing enhancement on 8th Jan 04 --------------- */

				billing_mode.value          = "Modify"
				parent.frames[1].document.forms[0].bl_success.value = "Y";
			} else {
				parent.frames[1].document.forms[0].bl_success.value = "N";
				return false;
			}			
		}
		/*function chkOnSub()
		{
			var package_flag	= "N";
		    var ins_auth_flag	= "N";
		    var upd_pat_flag	= "N";
		    var patient_id		= "<%=patient%>";
			var mother_patient_id=parent.frames[1].document.forms[0].mother_patient_id.value;

			if(mother_patient_id != '') patient_id = mother_patient_id;
	
			var show_hide_blng_class	= "SHOW";
		    var billing_group			= parent.frames[1].document.forms[0].billing_group;
			var	billing_class			= parent.frames[1].document.forms[0].billing_class;
		    var employer_code			= parent.frames[1].document.forms[0].employer_code;
		    var cash_set_type1			= parent.frames[1].document.forms[0].cash_set_type1;
		    var cash_insmt_ref1			= parent.frames[1].document.forms[0].cash_insmt_ref1;
		    var cash_insmt_date1		= parent.frames[1].document.forms[0].cash_insmt_date1;
		    var cash_insmt_rmks1		= parent.frames[1].document.forms[0].cash_insmt_rmks1;
		    var cust_1					= parent.frames[1].document.forms[0].cust_1;
		    var credit_doc_ref1			= parent.frames[1].document.forms[0].credit_doc_ref1;
		    var credit_doc_date1		= parent.frames[1].document.forms[0].credit_doc_date1;
		    var cust_2					= parent.frames[1].document.forms[0].cust_2;
		    var credit_doc_ref2			= parent.frames[1].document.forms[0].credit_doc_ref2;
		    var credit_doc_date2		= parent.frames[1].document.forms[0].credit_doc_date2;
		    var cust_3					= parent.frames[1].document.forms[0].cust_3;
		    var policy_type				= parent.frames[1].document.forms[0].policy_type;
		    var policy_no				= parent.frames[1].document.forms[0].policy_no;
		    var policy_expiry_date		= parent.frames[1].document.forms[0].policy_expiry_date;
		    var non_insur_blng_grp		= parent.frames[1].document.forms[0].non_insur_blng_grp;
		    var cash_set_type2			= parent.frames[1].document.forms[0].cash_set_type2;
		    var cash_insmt_ref2			= parent.frames[1].document.forms[0].cash_insmt_ref2;
		    var cash_insmt_date2		= parent.frames[1].document.forms[0].cash_insmt_date2;
		    var cash_insmt_rmks2		= parent.frames[1].document.forms[0].cash_insmt_rmks2;
		    var cust_4					= parent.frames[1].document.forms[0].cust_4;
		    var credit_doc_ref3			= parent.frames[1].document.forms[0].credit_doc_ref3;
		    var credit_doc_date3		= parent.frames[1].document.forms[0].credit_doc_date3;
		    var setlmt_ind				= parent.frames[1].document.forms[0].setlmt_ind;
		    var upd_fin_dtls			= parent.frames[1].document.forms[0].upd_fin_dtls;
		    var credit_auth_ref			= parent.frames[1].document.forms[0].credit_auth_ref;
		    var credit_auth_date		= parent.frames[1].document.forms[0].credit_auth_date;
		    var app_days				= parent.frames[1].document.forms[0].app_days;
		    var app_amount				= parent.frames[1].document.forms[0].app_amount;
		    var eff_frm_date			= parent.frames[1].document.forms[0].eff_frm_date;
		    var remarks					= parent.frames[1].document.forms[0].remarks;
		    var billing_mode			= parent.frames[1].document.forms[0].billing_mode;

			// Start of modifications for billing enhancement on 8th Jan 04 ---------------  
		
			var cred_start_dt1   = '';
			var cred_start_dt2   = ''; 
			var cred_start_dt3   = ''; 

			if(parent.frames[1].document.forms[0].cred_start_dt1)
			{
				cred_start_dt1    = parent.frames[1].document.forms[0].cred_start_dt1;
			}
			if(cred_start_dt1.value=='')
			{
				if(parent.frames[1].document.forms[0].cred_start_date)
				{
				cred_start_dt1	  = parent.frames[1].document.forms[0].cred_start_date;
				}
			}
			if(parent.frames[1].document.forms[0].cred_start_dt2)
			{
				cred_start_dt2    = parent.frames[1].document.forms[0].cred_start_dt2;
			}
			if(parent.frames[1].document.forms[0].cred_start_dt3)
			{
				cred_start_dt3    = parent.frames[1].document.forms[0].cred_start_dt3;
			}

			// end of modifications for billing enhancement on 8th Jan 04--------------- 

			var bl_data_from_repos_yn = "N";
			var data_source_id = parent.frames[1].document.forms[0].change_data_source;
		
			if(data_source_id.value != '' && billing_group.value != '')
			{
				bl_data_from_repos_yn = "Y";
			}
		
			if(billing_group.value != '') billing_mode.value = "Modify";
			
			var operation = parent.frames[1].document.forms[0].bl_operation.value;
			
			if(billing_mode.value=="Modify") operation="Update";
			
			if(operation=='Insert')
			{
				operation='';
				billing_mode.value = '';
			}
		
			parent.frames[1].document.forms[0].bl_success.value = "N";
		
			//Added for Billing Enhancements
			var health_card_expired_yn = parent.frames[1].document.forms[0].health_card_expired_yn;
			var annual_income          = parent.frames[1].document.forms[0].annual_income;
			var family_asset           = parent.frames[1].document.forms[0].family_asset;
			var no_of_dependants       = parent.frames[1].document.forms[0].no_of_dependants;
			var resp_for_payment       = parent.frames[1].document.forms[0].resp_for_payment;
			var credit_doc_reqd_yn1    = parent.frames[1].document.forms[0].credit_doc_reqd_yn1;
			var credit_doc_reqd_yn2    = parent.frames[1].document.forms[0].credit_doc_reqd_yn2;
			var calling_module_id	   = "MP";
			var calling_function_id	   = "CHG_PAT_DTLS";

			//end of Addition
		
			var episode="";
			var record="";
			
			var qryStr = "operation="+operation+"&package_flag="+package_flag+"&ins_auth_flag="+ins_auth_flag+"&upd_pat_flag="+upd_pat_flag+"&patient_id="+patient_id+"&show_hide_blng_class="+show_hide_blng_class+"&billing_mode="+billing_mode.value+"&billing_group="+billing_group.value+"&billing_class="+billing_class.value+"&employer_code="+employer_code.value+"&cash_set_type1="+cash_set_type1.value+"&cash_insmt_ref1="+cash_insmt_ref1.value+"&cash_insmt_date1="+cash_insmt_date1.value;
			qryStr += "&cash_insmt_rmks1="+cash_insmt_rmks1.value+"&cust_1="+cust_1.value+"&credit_doc_ref1="+credit_doc_ref1.value+"&credit_doc_date1="+credit_doc_date1.value+"&cust_2="+cust_2.value;
			qryStr += "&credit_doc_ref2="+credit_doc_ref2.value+"&credit_doc_date2="+credit_doc_date2.value+"&cust_3="+cust_3.value+"&policy_type="+escape(policy_type.value);
			qryStr += "&policy_no="+policy_no.value+"&policy_expiry_date="+policy_expiry_date.value+"&non_insur_blng_grp="+non_insur_blng_grp.value+"&cash_set_type2="+cash_set_type2.value;
			qryStr += "&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id;
			qryStr += "&cash_insmt_ref2="+cash_insmt_ref2.value+"&cash_insmt_date2="+cash_insmt_date2.value+"&cash_insmt_rmks2="+cash_insmt_rmks2.value+"&cust_4="+cust_4.value+"&credit_doc_ref3="+credit_doc_ref3.value+"&credit_doc_date3="+credit_doc_date3.value+"&setlmt_ind="+setlmt_ind.value+"&credit_auth_ref="+credit_auth_ref.value+"&credit_auth_date="+credit_auth_date.value+"&app_days="+app_days.value+"&app_amount="+app_amount.value+"&annual_income="+annual_income.value+"&family_asset="+family_asset.value+"&no_of_dependants="+no_of_dependants.value+"&resp_for_payment="+resp_for_payment.value+"&credit_doc_reqd_yn1="+credit_doc_reqd_yn1.value+"&credit_doc_reqd_yn2="+credit_doc_reqd_yn2.value+"&bl_data_from_repos_yn="+bl_data_from_repos_yn+"&data_source_id="+data_source_id.value+"&eff_frm_date="+eff_frm_date.value+"&remarks="+remarks.value+"&episode="+episode+"&record="+record;
			
			// Start of modifications for billing enhancement on 8th Jan 04 --------------- 
			
			if(cred_start_dt1.value != null)
				qryStr+="&credit_doc_start_date1="+cred_start_dt1.value;
			if(cred_start_dt2.value != null)
				qryStr+="&credit_doc_start_date2="+cred_start_dt2.value;
			if(cred_start_dt3.value != null)
				qryStr+="&credit_doc_start_date3="+cred_start_dt3.value;
			
			qryStr+="&gl_holder_name="+parent.frames[1].document.forms[0].gl_holder_name.value;
			qryStr+="&pat_reln_with_gl_holder="+parent.frames[1].document.forms[0].gl_holder_reln.value;
		
			//End of modifications for billing enhancement on 8th Jan 04 --------------- 
		
			var nationality_yn = "N";
			parent.frames[1].document.forms[0].dflt_nat_id_chk_val.value = parent.frames[1].document.forms[0].nationality_code.value;
			
			if(parent.frames[1].document.forms[0].nationality_code.value == 	parent.frames[1].document.forms[0].dflt_nationality_code.value)
			{
				nationality_yn = "Y";
			}
			else 
			{
				nationality_yn = "N";
			}
		
			qryStr+="&nationality_yn="+nationality_yn;
			qryStr+="&patient_class='XT'";
		   var returnArray = new Array();
	  
			returnArray = getFinDtl(qryStr);

			tab_click(previousTab);
			if(returnArray.length>0)
			{
				billing_group.value         = returnArray[0];
				billing_class.value         = returnArray[1];
				employer_code.value         = returnArray[2];    
				cash_set_type1.value        = returnArray[3];
				cash_insmt_ref1.value       = returnArray[4];
				cash_insmt_date1.value      = returnArray[5];
				cash_insmt_rmks1.value      = returnArray[6];
				cust_1.value                = returnArray[7];
				credit_doc_ref1.value       = returnArray[8];
				credit_doc_date1.value      = returnArray[9];
				cust_2.value                = returnArray[10];
				credit_doc_ref2.value       = returnArray[11];
				credit_doc_date2.value      = returnArray[12];
				cust_3.value                = returnArray[13];
				policy_type.value           = returnArray[14];
				policy_no.value             = returnArray[15];
				policy_expiry_date.value    = returnArray[16];
				non_insur_blng_grp.value    = returnArray[17];
				cash_set_type2.value        = returnArray[18];
				cash_insmt_ref2.value       = returnArray[19];
				cash_insmt_date2.value      = returnArray[20];
				cash_insmt_rmks2.value      = returnArray[21];
				cust_4.value                = returnArray[22];
				credit_doc_ref3.value       = returnArray[23];
				credit_doc_date3.value      = returnArray[24];
				setlmt_ind.value            = returnArray[25];
				upd_fin_dtls.value          = returnArray[26];
				credit_auth_ref.value       = returnArray[27];
				credit_auth_date.value      = returnArray[28];
				app_days.value              = returnArray[29];
				app_amount.value            = returnArray[30];
				annual_income.value			= returnArray[31];
				family_asset.value			= returnArray[32];
				no_of_dependants.value		= returnArray[33];
				resp_for_payment.value		= returnArray[34];
				credit_doc_reqd_yn1.value	= returnArray[35];
				credit_doc_reqd_yn2.value	= returnArray[36];
				eff_frm_date.value          = returnArray[37];
				remarks.value               = returnArray[38];

				// Start of modifications for billing enhancement on 8th Jan 04 --------------- 
				cred_start_dt1.value = returnArray[40];
				cred_start_dt2.value = returnArray[41];
				cred_start_dt3.value = returnArray[42];
		
				parent.frames[1].document.forms[0].gl_holder_name.value = returnArray[43];
				parent.frames[1].document.forms[0].gl_holder_reln.value = returnArray[44];

				//End of modifications for billing enhancement on 8th Jan 04 --------------- 

				billing_mode.value          = "Modify"
				parent.frames[1].document.forms[0].bl_success.value = "Y";
			}
			else return false;
		}*/
	</script>


</head>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload="">
	<table cellspacing='0' cellpadding='0' border=0 width='100%'>
		<tr>
			<td width='100%'>
			<table name='patient_table' id='patient_table' width='100%' border='0'>
			    <tr>
			        <td class='label' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
					<%
		            out.println("<td><input name='patient_id' id='patient_id' size=18  maxlength='"+ rs.getString(1) +"' disabled value=\""+request.getParameter("patient_id")+"\"><img src='../../eCommon/images/mandatory.gif'></img></td>");
					%><td><input name='patient_name' id='patient_name' size='55' maxlength='60' disabled></td>
				    <%
						if(names_in_oth_lang_yn.equals("Y"))						
				        {
						    out.println( "<td><input name='patient_name_loc_lang' id='patient_name_loc_lang' size='55' maxlength='60' disabled");
							
							if(language_direction.equals("R"))
							{
							out.println("dir='RTL'" ) ;
							}
							
							out.println(" ></td>" ) ;
							out.println("<input type='hidden' name='patient_name_loc_lang_long' id='patient_name_loc_lang_long' value='' > ");						
		                }
						else
						{
							if(pat_name_as_multipart_yn.equals("N"))
							out.println("<script>document.getElementById('patient_name').size='60';</script>");
						}
					%>
				</tr>
			</table>
			</td>
		</tr>
	</table>
    <table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Demographic details">
				<a onclick="invokeTab('demogrp_tab')" class="tabClicked" id="demogrp_tab" >
					<span class="tabSpanclicked" id="demogrp_tabspan"><fmt:message key="eMP.demographicdetails.label" bundle="${mp_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Contact Mode and Address details">
				<a onclick="invokeTab('cmodeaddr_tab')" class="tabA" id="cmodeaddr_tab" >
					<span class="tabAspan" id="cmodeaddr_tabspan"><fmt:message key="eMP.ContactAddresses.label" bundle="${mp_labels}"/></span>
				</a>
			</li>
			
			<li class="tablistitem" title="Related Contact details">
				<a onclick="invokeTab('rlcnts_tab')" class="tabA" id="rlcnts_tab" >
					<span class="tabAspan" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title="Patient Documents and Other details">
				<a onclick="invokeTab('pat_docs_tab')" class="tabA" id="pat_docs_tab" >
					<span class="tabAspan" id="pat_docs_tabspan"><fmt:message key="Common.documents.label" bundle="${common_labels}"/> & <fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>	

		    <%if(function_id.equals ("NEWBORN_REG"))
			{%>
				<li class="tablistitem" title="Parent details">
				<a onclick="invokeTab('parent_dtls')" class="tabA" id="parent_dtls" >
					<span class="tabAspan" id="parent_dtlsspan"><fmt:message key="eMP.parentdetails.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<%}%>
            <%if(enteredByAppl){ // Added by shagar for ML-MMOH-CRF-1328 %>
			<li class="tablistitem" title="Entered By">
				<a onclick="invokeTab('add_mod_dtl')" class="tabA" id="add_mod_dtl" >
					<span class="tabAspan" id="add_mod_dtlspan"><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/></span>
				</a>
			</li>
            <%}else {%>
			<li class="tablistitem" title="Who Done It">
				<a onclick="invokeTab('add_mod_dtl')" class="tabA" id="add_mod_dtl" >
					<span class="tabAspan" id="add_mod_dtlspan"><fmt:message key="Common.whodoneit.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<%}%>

			<%if(bl_install_yn.equals("Y")){%>
					<li class="tablistitem" title="Financial details">
				<a onclick="invokeTab('findtl_tab')" class="tabA" id="findtl_tab" >
					<span class="tabAspan" id="findtl_tabspan"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
		<%}%>	
		</ul>
	<!-- The below line is required to change the select state of Demograph tab initially selected -->
	<script>prevTabObj='demogrp_tab'</script>

	</td></tr></table>
	<input type='hidden' name='language_direction' id='language_direction' value='<%=language_direction%>'>
	<%
	if(rs != null) rs.close(); 
	if(stmt != null) stmt.close(); 
}
catch(Exception e)
{
    //out.println("Exception in main Catch"+e.getMessage());
	e.printStackTrace();
}
finally
{
    ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

