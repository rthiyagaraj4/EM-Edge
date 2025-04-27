<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eBL.*,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");		
	
	double d_tot_amt=0;
//	double d_serv_amt=0;
	double d_pat_payable=0;
//	double d_min_chr_amt=0;
	double d_patient_paid=0;
	double serv_qty=1;
	String facility_id = "";
	String login_user = "";
	String str_excl_incl_ind="",str_preappr_yn="",str_error_code="";
	String str_sys_message_id="", str_error_text="";//str_rate_chr_ind="",str_override_yn=""
	//String str_blng_serv_desc=""
	String str_charge_based_yn="",str_excl_incl_act="", str_act_reason_code="";

	String panel_str="";
	String service_date="";
	String charged_YN="";
	String pat_billed_YN="";
	String key="";
	String key_line_no="";

	Connection con = null;
	//PreparedStatement pstmt = null ;
	ResultSet rs = null;
	Statement stmt=null;
	request.setCharacterEncoding("UTF-8");
	con	=	ConnectionManager.getConnection(request);
	String locale	= (String)session.getAttribute("LOCALE");
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");		
		session.removeAttribute("hosp_panel_str");
		session.removeAttribute("prof_panel_str");
		session.removeAttribute("prof_panel_str_YN");
		session.removeAttribute("hosp_panel_str_YN");
		session.removeAttribute("upd_hosp_chrg_amt");
		session.removeAttribute("upd_hosp_chrg_pat_amt");
		session.removeAttribute("upd_med_chrg_amt");
		session.removeAttribute("upd_med_chrg_pat_amt");
		session.removeAttribute("hosp_dtls");
		session.removeAttribute("prof_dtls");
		session.removeAttribute("fin_dtls_to_chrg_dtls");
		session.removeAttribute("hosp_panel");
		session.removeAttribute("prof_panel");

		String patient_id="SD00000726";
		String episode_type="O";
		long episode_id=10002435;
		int visit_id=1;	
		long encounter_id=0;

		String service_panel_code="HD1";
		String service_panel_ind="L"; //S
		
		String pract_staff_ind="P";
		String pract_staff_id="ALLEN";

		String order_catalog_code="00BN0ZX";
		String module_id="OP";
		String charge_based_amt="";
		String excl_incl_action_ind="";
		String action_reason_code="";
		
		String acc_flag=(String)session.getAttribute("acc_flag");
		if(acc_flag==null) acc_flag="";
//		System.out.println("acc_flag" +acc_flag);

		String strBlnggrpId="";                                      
		String strCustCode="";                                       
		String strPolicyTypeCode="";                                 
		String strPolicyPriority="";                                 
		String strPolicyNumber="";                                   
		String strPolicyStartDate="";                                
		String strPolicyExpiryDate="";                               
		String strCreditAuthRef="";                                  
		String strCreditAuthDate="";                                 
		String strEffectiveFrom="";                                  
		String strEffectiveTo="";                                    
		String strApprovedAmt="";                                    
		String strApprovedDays="";                                   
		String strNonInsBlnggrpId="";                                
		String strNonInsCustCode=""; 
		String strExclInclActionInd="";
		String strActionReasonCode="";
		String strNull="";

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					service_date = rs.getString(1);
				}
			}
			stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception in Sys Date :"+e);
		}
		if(module_id.equals("OP") || module_id.equals("AE"))
		{
		if(acc_flag.equals("true"))
		{
//			System.out.println("in s");
			/*HashMap bl_data=(HashMap)session.getAttribute("serv_panel_str");
			panel_str=(String)bl_data.get("serv_panel_str1");
			System.out.println("panel_str panel_str " +panel_str);
			accept_chk=(String)bl_data.get("accept_chk");
			System.out.println("accept_chk session" +accept_chk);*/
		}
		else
		{
			try
			{
				
				if(episode_id==0 || visit_id==0)
				{
					CallableStatement call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
				    call.setString(1,facility_id);//facility_id                         
					call.setString(2,module_id);	//module_id                           
					call.setString(3,episode_type);//Episode_type                       
					call.setString(4,patient_id);//patient_id                           
					call.setLong(5,episode_id);//strEpisodeId                         
					call.setInt(6,visit_id);                                         
					call.setLong(7,encounter_id);                                         
					call.setString(8,""); 
					call.setString(9,service_date);//service_date                         
					call.setString(10,service_panel_ind);//service_panel_ind             
					call.setString(11,service_panel_code);//service_panel_code           
					call.setDouble(12,serv_qty);//service_qty                                    
					call.setString(13,pract_staff_ind);//pract_staff_ind           
					call.setString(14,pract_staff_id);//pract_staff_id                 
					call.setString(39,locale);//locale                                    
					call.setString(15,strBlnggrpId);                                      
					call.setString(16,strCustCode);                                       
					call.setString(17,strPolicyTypeCode);                                 
					call.setString(18,strPolicyPriority);                                 
					call.setString(19,strPolicyNumber);                                   
					call.setString(20,strPolicyStartDate);                                
					call.setString(21,strPolicyExpiryDate);                               
					call.setString(22,strCreditAuthRef);                                  
					call.setString(23,strCreditAuthDate);                                 
					call.setString(24,strEffectiveFrom);                                  
					call.setString(25,strEffectiveTo);                                    
					call.setString(26,strApprovedAmt);                                    
					call.setString(27,strApprovedDays);                                   
					call.setString(28,strNonInsBlnggrpId);                                
					call.setString(29,strNonInsCustCode);           
					call.registerOutParameter(30,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(31,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(32,java.sql.Types.DOUBLE);                  
					call.registerOutParameter(33,java.sql.Types.DOUBLE);                  
					call.registerOutParameter(34,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(35,java.sql.Types.VARCHAR);                 
					//call.registerOutParameter(36,java.sql.Types.VARCHAR);                 
					//call.registerOutParameter(37,java.sql.Types.DOUBLE); 
					call.setString(36,strExclInclActionInd);
					call.setString(37,strActionReasonCode);
					call.registerOutParameter(38,java.sql.Types.VARCHAR);	              
					call.registerOutParameter(40,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(41,java.sql.Types.VARCHAR);                 
					call.registerOutParameter(42,java.sql.Types.VARCHAR);                 
					call.execute();	

					panel_str=call.getString(30);	
					if(panel_str==null || panel_str.equals("")) panel_str="";		
//					System.out.println("p_str frame  " + panel_str);	
					
					str_charge_based_yn=call.getString(31);
					if(str_charge_based_yn==null || str_charge_based_yn.equals("")) str_charge_based_yn="";		
					
					d_tot_amt=call.getDouble(32);
					d_pat_payable=call.getDouble(33);	

					str_excl_incl_ind=call.getString(34);	
					if(str_excl_incl_ind==null || str_excl_incl_ind.equals("")) str_excl_incl_ind="";		
					
					str_preappr_yn=call.getString(35);
					if(str_preappr_yn==null || str_preappr_yn.equals("")) str_preappr_yn="";		
					
					str_excl_incl_act=call.getString(36);	
					if(str_excl_incl_act==null || str_excl_incl_act.equals("")) str_excl_incl_act="";		
					
					str_act_reason_code=call.getString(37);
					if(str_act_reason_code==null || str_act_reason_code.equals("")) str_act_reason_code="";		
					
					d_patient_paid=call.getDouble(38);	

					str_error_code=call.getString(40);
					if(str_error_code==null || str_error_code.equals("")) str_error_code="";		
					
					str_sys_message_id=call.getString(41);
					if(str_sys_message_id==null || str_sys_message_id.equals("")) str_sys_message_id="";		
					
					str_error_text=call.getString(42);
					if(str_error_text==null || str_error_text.equals("")) str_error_text="";		
					
					call.close();
				}
				else
				{
//					System.out.println("222");
					CallableStatement call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
					call.setString(1,facility_id);//facility_id
					call.setString(2,module_id);	//module_id	
					call.setString(3,strNull); //key
					call.setString(4,strNull); //key_line_no
					call.setString(5,episode_type);//episode_type
					call.setString(6,patient_id);
					call.setLong(7,episode_id);
					call.setInt(8,visit_id);//visit_id
					call.setLong(9,encounter_id);
					call.setString(10,"");					
					call.setString(11,service_date);
					call.setString(12,strNull);//item_code
					call.setString(13,service_panel_ind);//service_panel_ind
					call.setString(14,service_panel_code);//service_panel_code
					call.setDouble(15,serv_qty);//serv_qty
					call.setString(16,charge_based_amt);//charge_based_amt
					call.setString(17,pract_staff_ind);//pract_staff_ind
					call.setString(18,pract_staff_id);//pract_staff_id	
					call.setString(25,excl_incl_action_ind);//excl_incl_action_ind
					call.setString(26,action_reason_code);//action_reason_code
					call.setString(30,locale);//locale
					call.registerOutParameter(19,java.sql.Types.VARCHAR);
					call.registerOutParameter(20,java.sql.Types.VARCHAR);					call.registerOutParameter(21,java.sql.Types.DOUBLE);
					call.registerOutParameter(22,java.sql.Types.DOUBLE);
					call.registerOutParameter(23,java.sql.Types.VARCHAR);
					call.registerOutParameter(24,java.sql.Types.VARCHAR);
									
					call.registerOutParameter(27,java.sql.Types.DOUBLE);
					call.registerOutParameter(28,java.sql.Types.VARCHAR);	
					call.registerOutParameter(29,java.sql.Types.VARCHAR);	
					call.registerOutParameter(31,java.sql.Types.VARCHAR);
					call.registerOutParameter(32,java.sql.Types.VARCHAR);
					call.registerOutParameter(33,java.sql.Types.VARCHAR);
					call.execute();		
					
					panel_str=call.getString(19);	
					if(panel_str==null || panel_str.equals("")) panel_str="";		
//					System.out.println("p_str frame  " + panel_str);	

					str_charge_based_yn=call.getString(20);
					if(str_charge_based_yn==null || str_charge_based_yn.equals("")) str_charge_based_yn="";	
					
					d_tot_amt=call.getDouble(21);

					d_pat_payable=call.getDouble(22);	

					str_excl_incl_ind=call.getString(23);	
					if(str_excl_incl_ind==null || str_excl_incl_ind.equals("")) str_excl_incl_ind="";		

					str_preappr_yn=call.getString(24);
					if(str_preappr_yn==null || str_preappr_yn.equals("")) str_preappr_yn="";	
					
//					str_excl_incl_act=call.getString(25);	
//					if(str_excl_incl_act==null || str_excl_incl_act.equals("")) str_excl_incl_act="";		

//					str_act_reason_code=call.getString(26);
//					if(str_act_reason_code==null || str_act_reason_code.equals("")) str_act_reason_code="";	
					
					d_patient_paid=call.getDouble(27);	

					charged_YN=call.getString(28);	
					if(charged_YN==null) charged_YN="";
					
					pat_billed_YN=call.getString(29);	
					if(pat_billed_YN==null) pat_billed_YN="";

					str_error_code=call.getString(31);
					if(str_error_code==null || str_error_code.equals("")) str_error_code="";	
					
					str_sys_message_id=call.getString(32);
					if(str_sys_message_id==null || str_sys_message_id.equals("")) str_sys_message_id="";	
					
					str_error_text=call.getString(33);
					if(str_error_text==null || str_error_text.equals("")) str_error_text="";	
					
					call.close();
				}
			}	
			catch(Exception exp1)
			{			
				System.out.println("error"+exp1);
			}

//			System.out.println("panel_str panel_str 1 " +panel_str);
			HashMap pString = new HashMap();
			pString.put("panel_str",panel_str); 
			session.setAttribute("BlChargeRecord",(HashMap)pString);
//			System.out.println((HashMap)pString);
		}
	}
%>
<html>
<head>
<script>
function changeToUpper()
{
	if( (window.event.keyCode >= 97) && (window.event.keyCode <= 122) )	
		return (window.event.keyCode -= 32);
	else
		return true;

}
async function funQry()
{
	var retVal = new Array();
	var episode_type = document.forms[0].episode_type.value;
	var patient_id = document.forms[0].patient_id.value;	
	var visit_id=document.forms[0].visit_id.value;	
	var episode_id=document.forms[0].episode_id.value;	
	var service_panel_code=document.forms[0].service_panel_code.value;	
	var service_panel_ind=document.forms[0].service_panel_ind.value;	 
	var service_date=document.forms[0].service_date.value;	
	var pract_staff_ind=document.forms[0].pract_staff_ind.value;	
	var pract_staff_id=document.forms[0].pract_staff_id.value;	
	var order_catalog_code=document.forms[0].order_catalog_code.value;	
	var module_id=document.forms[0].module_id.value;	
	var encounter_id=document.forms[0].encounter_id.value;	
	var key=document.forms[0].key.value;
	var key_line_no=document.forms[0].key_line_no.value;
	var order_id="";
	var order_line_no="";
	//service_date=convertDate(formObj.dt_from.value,'DMYHM',locale,"en"); 
	
	var dialogTop = "100";
	var dialogHeight = "30" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var title=getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL");
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	//var include_label=encodeURIComponent(getLabel("Common.Include.label","common"));
	//var exclude_label=encodeURIComponent(getLabel("Common.Exclude.label","common"));
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no;	

	retVal= await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
//	alert("retVal from main"+retVal)
	//parent.window.returnValue=returnArray;	
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal!=null)
	{
		if(arr[0]=="Y")
		{
			//alert("Updated Successfully");
			parent.frames[1].location.href="../../eBL/jsp/BLChargeDtlMenuFrame.jsp";
		}
		else
		{
			//alert("Updation Failed");
		}
	}
	else
	{
			//alert("Updation Failed");
	}
}

async function funQry1()
{
	var retVal;
	var dialogHeight= "10";
	var dialogWidth	= "40";
	var dialogTop = "210";
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	
	var clinic_code="CL34";
	var visit_type_code="V1";
	var patient_id=document.forms[0].patient_id.value;
	var episode_type="O";
	var episode_id=document.forms[0].episode_id.value;
	var visit_id=document.forms[0].visit_id.value;
	var encounter_id="";
	var facility_id="HS";
	var calling_module_id="OP";
	var calling_function_id="CHECKOUT_VISIT";//VISIT_REGISTRATION
	var logged_user_id="KUILA";
	var practitioner_id="SR";
	var practitioner_type_ind="P";

	var url = "../../eBL/jsp/BLVisitChargeDetCloseConsultFrame.jsp?call_after_reg=Y&start_valid=Y&clinic_code="+clinic_code+"&visit_type_code="+visit_type_code+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&calling_module_id="+calling_module_id+"&calling_function_id="+calling_function_id+"&logged_user_id="+logged_user_id+"&practitioner_id="+practitioner_id+"&practitioner_type_ind="+practitioner_type_ind;	

	retVal =await window.showModalDialog(url,arguments,features);

	if(retVal=="1")
	{
		//alert("Visit Charge Success");
	}
	else
	{
		//alert("Visit Charge Failed");
	}
}



function funBLStmt()
{
	//alert("inside bill stlmt"); 
	var retVal = new Array();
	//var billdoctype="HSBLOP";
	//var billdocnum="5000054";
	var billdoctype=document.forms[0].billdoctypecode.value;
	//alert("billdoctype :" +billdoctype);
	var billdocnum=document.forms[0].billdocnum.value;
	//alert("billdocnum :" +billdocnum);
	var blnggrp="PT";
	var center='1';
	var dialogTop = "100";
	var dialogHeight = "40" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
	//var title=getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL");
	var title="";
	title=encodeURIComponent(title);	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";	
	

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+billdoctype+"&"+"billdocnum="+billdocnum+"&"+"blnggrp="+blnggrp;
//alert("param "+ param);
	retVal=window.showModalDialog("../../eBL/jsp/BLBillSlmtMain.jsp?"+param,arguments,features);
	//alert("retVal from main"+retVal)
	}


function funPharmacyBLStmt()
{	
	var retVal = new Array();	
	var billdoctype=document.forms[0].billdoctypecode.value;	
	var billdocnum=document.forms[0].billdocnum.value;	
	var blnggrp="PT";	
	var center='1';
	var dialogTop = "100";
	var dialogHeight = "40" ;
	var dialogWidth = "70" ;
	var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;	
	var arguments = "" ;
	var column_sizes = escape("");               
	var column_descriptions ="";		

	var param = "column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"billdoctypecode="+billdoctype+"&"+"billdocnum="+billdocnum+"&"+"blnggrp="+blnggrp+"&"+"module_id=PH"+"&"+"function_id=";

	//alert("param "+ param);
	retVal=window.showModalDialog("../../eBL/jsp/BLStoreBillSlmtMain.jsp?"+param,arguments,features);
}
	function funBLBillInterim()
	{
		var center='1';
		var dialogTop = "100";
		var dialogHeight = "30" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title="Interim Bill Generation";
		title=encodeURIComponent(title);	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions;
		retVal=window.showModalDialog("../../eBL/jsp/BLBillInterimFrame.jsp?"+param,arguments,features);
	}

function funViewEncounterDet()
	{
	//alert("inside funViewEncounterDet1");
	var episode_type = document.forms[0].episode_type.value;
	var patient_id = document.forms[0].patient_id.value;	
	var visit_id=document.forms[0].visit_id.value;	
	var episode_id=document.forms[0].episode_id.value;	
	var encounterid=document.forms[0].encounterid.value;	

		var center='1';
		var dialogTop = "100";
		var dialogHeight = "30" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title="";
		title=encodeURIComponent(title);	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"visit_id="+visit_id+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounterid;
		retVal=window.showModalDialog("../../eBL/jsp/BLViewEncounterBillDetMain.jsp?"+param,arguments,features);
	}


function funViewPatEncounterDtls()
	{
	//alert("inside funViewPatEncounterDtls2 ");
	var episode_type = document.forms[0].episode_type.value;
	var patient_id = document.forms[0].patient_id.value;	
	var visit_id=document.forms[0].visit_id.value;	
	var episode_id=document.forms[0].episode_id.value;	
	var encounterid=document.forms[0].encounterid.value;	

		var center='1';
		var dialogTop = "100";
		var dialogHeight = "30" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title="";
		title=encodeURIComponent(title);	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"visit_id="+visit_id+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounterid;
		retVal=window.showModalDialog("../../eBL/jsp/BLPatientEncounters.jsp?"+param,arguments,features);
	}
function funPrevEncounters()
	{
		var episode_type = document.forms[0].episode_type.value;
		var patient_id = document.forms[0].patient_id.value;	
		var center='1';
		var dialogTop = "100";
		var dialogHeight = "30" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title=getLabel("eBL.PRV_ENCOUNTER_FIN_DETAILS.label","BL");
		title=encodeURIComponent(title);	
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&patient_id="+patient_id+"&episode_type="+episode_type+"&title="+title;
		retVal=window.showModalDialog("../../eBL/jsp/BLPreviousEncounterMain.jsp?"+param,arguments,features);
	}
	function callOracleForm()
		{
		var center='1';
		var dialogTop = "100";
		var dialogHeight = "30" ;
		var dialogWidth = "70" ;
		var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
		var title=""
		var arguments = "" ;
		var column_sizes = escape("");               
		var column_descriptions ="";	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions;
		retVal=window.showModalDialog("../../eBL/jsp/CreditCardInterfaceTestFrame.jsp?"+param,arguments,features);

		}

	function roundNumber() {
	var numberField = document.forms[0].numberfield; // Field where the number appears
	var rnum = numberField.value;
	var rlength = 0; // The number of decimal places to round to
	if (rnum > 8191 && rnum < 10485) {
		rnum = rnum-5000;
		var newnumber = Math.round(rnum*Math.pow(10,rlength))/Math.pow(10,rlength);
		newnumber = newnumber+5000;
	} else {
		var newnumber = Math.round(rnum*Math.pow(10,rlength))/Math.pow(10,rlength);
	}
	numberField.value = newnumber;
}

</script>
<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script> 
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form  method='post'>

	
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<tr>
		<td class='COLUMNHEADER'><fmt:message key="eBL.FIN_DTLS_QRY.label" bundle="${bl_labels}"/>		
		</tr>
	</table>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>	
		<tr>
		<td width='25%'  class='label'><b><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></b></td>
		<td  width='25%' class='fields'>
		   <select name='episode_type' id='episode_type' onchange=''>
		   <option value=''>-------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option>
		   <option value='E'>Emergency</option>
		   <option value='O'>OutPatient</option>
		   <option value='I'>Inpatient</option>
		   <option value='D'>Daycare</option>
		   <option value='R'>External</option>
		   </select><img src='../../eCommon/images/mandatory.gif'></td>
		   <td width='25%'   class='label'><b><fmt:message key="Common.patientId.label"  		 		 bundle="${common_labels}"/></b></td>
		 <td  width='25%'  class="fields"><input type='text' name='patient_id' id='patient_id' size='20' maxlength='30' value='' onKeyPress='changeToUpper()'><img src='../../eCommon/images/mandatory.gif'></td>	
		</tr>
	<tr>
		<td width='25%' class='label'><b><fmt:message key="Common.episodeid.label"	bundle="${common_labels}"/></b></td>
		<td width='25%' class="fields"><input type='text' name='episode_id' id='episode_id' size='8' maxlength='30'style='text-align:right'  value='' onKeyPress='return(ChkNumberInput(this,event,2))' onBlur=''></td>
		<td width='25%' class='label'> <b><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></b> </td>
		<td width='25%' class="fields"><input type='text' name='visit_id' id='visit_id' size='4' maxlength='30' style='text-align:right'  value=''  onKeyPress='return(ChkNumberInput(this,event,2))' onBlur=''></td>
	</tr>

	<tr>
		<td width='25%' class='label'><b>bill type code</b></td>
		<td width='25%' class="fields"><input type='text' name='billdoctypecode' id='billdoctypecode' size='8' maxlength='30'style='text-align:right'  value='HSBLOP' ></td>
		<td width='25%' class='label'> <b>bill doc number</b> </td>
		<td width='25%' class="fields"><input type='text' name='billdocnum' id='billdocnum' size='4' maxlength='30' style='text-align:right'  value='' ></td>
		<tr>
		<td width='25%' class='label'> <b>encounterid</b> </td>
		<td width='25%' class="fields"><input type='text' name='encounterid' id='encounterid' size='4' maxlength='30' style='text-align:right'  value='' ></td>
		<td><input type='button' class='button' onclick='funViewEncounterDet()' value="ViewEncounterBillDet" ></td>
		<td><input type='button' class='button' onclick='funViewPatEncounterDtls()' value="ViewPatEncounterDtls" ></td>
		</tr>
	</tr>	
	<tr>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width="25%"  class="label" ><input type='button' class='button' onclick='funQry()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.query.label","common_labels")%>" >
		<input type='button' class='button' onclick='funQry()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>" ></td>
	</tr>

	<tr>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'><input type='button' class='button' onclick='funPrevEncounters()' value="BLPrevEnctr" ></td>
		<td width='25%'><input type='button' class='button' onclick='funQry1()' value="Click" >
						<input type='button' class='button' onclick='funBLStmt()' value="BillStmt" >
						<input type='button' class='button' onclick='funBLBillInterim()' value="BLBillInterim" ></td>
						<input type='button' class='button' onclick='funPharmacyBLStmt()' value="PharmacyBill" ></td>
						<input type='button' class='button' onclick='callOracleForm()' value="CallForm" ></td>


						
						
	</tr>	
	<tr>
		
	</tr>

	</table>
		<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
		<input type= hidden name="pract_staff_id" id="pract_staff_id"  value='<%=pract_staff_id%>'>
		<input type= hidden name="pract_staff_ind" id="pract_staff_ind"  value='<%=pract_staff_ind%>'>
		<input type= hidden name="service_panel_ind" id="service_panel_ind"  value='<%=service_panel_ind%>'>
		<input type= hidden name="service_panel_code" id="service_panel_code"  value='<%=service_panel_code%>'>
		<input type= hidden name="service_date" id="service_date"  value='<%=service_date%>'>
		<input type= hidden name="order_catalog_code" id="order_catalog_code"  value='<%=order_catalog_code%>'>
		<input type= hidden name="encounter_id" id="encounter_id"  value='<%=encounter_id%>'>
		<input type= hidden name="acct_seq_no" id="acct_seq_no"  value=''>
		<input type= hidden name="module_id" id="module_id"  value='<%=module_id%>'>
		<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
		<input type= hidden name="key" id="key"  value='<%=key%>'>
		<input type= hidden name="key_line_no" id="key_line_no"  value='<%=key_line_no%>'>

		<!--<input type="text" name="numberfield" id="numberfield">
		<input type="button" value="Round" onClick="roundNumber();">-->

</form>
</body>

<%
	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}
	finally
	{
		rs.close();
		ConnectionManager.returnConnection(con, request);				
   }
%>
</html>

