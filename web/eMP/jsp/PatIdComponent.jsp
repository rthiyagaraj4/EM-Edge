<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,webbeans.eCommon.*, java.util.*" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<head>		
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
		<Script src="../../eMP/js/natAltIdComponent.js" language="JavaScript"></Script>
<%
	String strBodyFrame =  request.getParameter("bodyFrame");
	String strSubmitFrame = request.getParameter("submitFrame");
	
	String strAlertReqdYn = request.getParameter("alert_reqd_yn");
	String strNameDrvnLogic = request.getParameter("name_dervn_logic");
	String strPatNameAsMultiPart = request.getParameter("pat_name_as_multipart_yn");
	//added by gomathi to populate the alternate id values on 25/03/04
	String AltId1Type = request.getParameter("AltId1Type");
    String AltId2Type = request.getParameter("AltId2Type");
	String AltId3Type = request.getParameter("AltId3Type");
	String AltId4Type = request.getParameter("AltId4Type");
	String AcceptOtherAltId = request.getParameter("AcceptOtherAltId");
	String defaultncode = request.getParameter("defaultncode");
	String defaultndesc = request.getParameter("defaultndesc");
	String op_call = request.getParameter("op_call");
	
	if(op_call == null) op_call="";
	if(op_call.equals("reg_pat")||op_call.equals("ae_reg_pat"))
	  strBodyFrame = "parent.parent.frames[1].frames[0]";
	
%>

	<script>
	
	function  enableNatId()
		{ 
			varBodyFrame = '<%=strBodyFrame%>';
			

				if(eval(varBodyFrame+document.getElementById("patient_name")) != null)
				{
					//eval(varBodyFrame+document.getElementById("patient_name")).disabled = false
				}
				if(eval(varBodyFrame+document.getElementById("name_prefix")) != null)
				{
					eval(varBodyFrame+document.getElementById("name_prefix")).disabled = false
				}
				if(eval(varBodyFrame+document.getElementById("first_name")) != null)
				{
					eval(varBodyFrame+document.getElementById("first_name")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("second_name")) != null)
				{
					eval(varBodyFrame+document.getElementById("second_name")).disabled = false
				}
				if(eval(varBodyFrame+document.getElementById("third_name")) != null)
				{
					eval(varBodyFrame+document.getElementById("third_name")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("family_name")) != null)
				{
					eval(varBodyFrame+document.getElementById("family_name")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("name_suffix")) != null)
				{
					eval(varBodyFrame+document.getElementById("name_suffix")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("sex")) != null)
				{
					eval(varBodyFrame+document.getElementById("sex")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("date_of_birth")) != null)
				{
					eval(varBodyFrame+document.getElementById("date_of_birth")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("b_age")) != null)
				{
					eval(varBodyFrame+document.getElementById("b_age")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("b_months")) != null)
				{
					eval(varBodyFrame+document.getElementById("b_months")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("b_days")) != null)
				{
					eval(varBodyFrame+document.getElementById("b_days")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("dob")) != null)
				{
					eval(varBodyFrame+document.getElementById("dob")).disabled = false;
				}
				
				//if(eval(varBodyFrame+document.getElementById("nationality_desc")) != null)
				//{
					//eval(varBodyFrame+document.getElementById("nationality_desc")).disabled = false
				//}
				if(eval(varBodyFrame+document.getElementById("citizen_yn")[0]) != null)
				{
					eval(varBodyFrame+document.getElementById("citizen_yn")[0]).disabled = false;		
				}
				if(eval(varBodyFrame+document.getElementById("citizen_yn")[1]) != null)
				{
					eval(varBodyFrame+document.getElementById("citizen_yn")[1]).disabled = false;					
				}
				if(eval(varBodyFrame+document.getElementById("legal_yn")[0]) != null)
				{
					eval(varBodyFrame+document.getElementById("legal_yn")[0]).disabled = false;		
				}
				if(eval(varBodyFrame+document.getElementById("legal_yn")[1]) != null)
				{
					eval(varBodyFrame+document.getElementById("legal_yn")[1]).disabled = false;					
				}
				if(eval(varBodyFrame+document.getElementById("national_id_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("national_id_no")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("alt_id1_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("alt_id1_no")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("alt_id2_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("alt_id2_no")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("alt_id3_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("alt_id3_no")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("alt_id4_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("alt_id4_no")).disabled = false;					
				}
				if(eval(varBodyFrame+document.getElementById("other_alt_type")) != null)
				{
					eval(varBodyFrame+document.getElementById("other_alt_type")).disabled = false;
				}
			return true;

		}
		function checkPatient(Obj){ 
			var op_call = "<%=op_call%>";
			if(!(Obj.value=="")){
				validatePatient(Obj);
				if(op_call == "ae_reg_pat"){
					eval(varBodyFrame+document.getElementById("patient_id")).readOnly=true;
				}
				 
			}else{
				if(op_call == "OA"){
					clear_fun_all('FromOA');
					clearAll();
				}
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 22/03/2013
				//Start
				else 	if(op_call == "IP_BOOKING"){
					IPOrder_Clear();
					clearAll(); //this line added by senthil
				}
				//End
				else{
					clearAll();
				}
			}
		}
		function checkforOA()
		{ 
			var op_call = "<%=op_call%>";
			if(op_call == "OA")
				clear_recur();
		}
		/* commented for edge changes,same function created with some changes
		function clearAll()
		{  

			
			varBodyFrame = '<%=strBodyFrame%>'
			
				if(eval(varBodyFrame+".document.getElementById('sec_sel')") != null)
					eval(varBodyFrame+".document.getElementById('sec_sel')").value="";
				
				if(eval(varBodyFrame+document.getElementById("patient_name")) != null)
				{
					//eval(varBodyFrame+document.getElementById("patient_name")).disabled = false
					eval(varBodyFrame+document.getElementById("patient_name")).value = "";
				}
				
				eval(varBodyFrame+document.getElementById("patient_name1")).innerHTML="";
				eval(varBodyFrame+document.getElementById("patient_name_local_lang1")).innerHTML="";

				if(eval(varBodyFrame+document.getElementById("name_prefix")) != null)
				{
					eval(varBodyFrame+document.getElementById("name_prefix")).disabled = false
					eval(varBodyFrame+document.getElementById("name_prefix")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("first_name")) != null)
				{
					eval(varBodyFrame+document.getElementById("first_name")).disabled = false;
					eval(varBodyFrame+document.getElementById("first_name")).value = "";
					if(eval(varBodyFrame+document.getElementById("bf")))
					eval(varBodyFrame+document.getElementById("bf")).disabled = false;
					
				}
				if(eval(varBodyFrame+document.getElementById("second_name")) != null)
				{
					eval(varBodyFrame+document.getElementById("second_name")).disabled = false
					eval(varBodyFrame+document.getElementById("second_name")).value= "";
					if(eval(varBodyFrame+document.getElementById("bs")))
					eval(varBodyFrame+document.getElementById("bs")).disabled = false;
					
				}
				if(eval(varBodyFrame+document.getElementById("third_name")) != null)
				{
					eval(varBodyFrame+document.getElementById("third_name")).disabled = false;
					eval(varBodyFrame+document.getElementById("third_name")).value= "";
					if(eval(varBodyFrame+document.getElementById("bt")))
					eval(varBodyFrame+document.getElementById("bt")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("family_name")) != null)
				{
					eval(varBodyFrame+document.getElementById("family_name")).disabled = false;
					eval(varBodyFrame+document.getElementById("family_name")).value = "";
					if(eval(varBodyFrame+document.getElementById("bfam")))
					eval(varBodyFrame+document.getElementById("bfam")).disabled = false;
					
				}
				if(eval(varBodyFrame+document.getElementById("name_suffix")) != null)
				{
					eval(varBodyFrame+document.getElementById("name_suffix")).disabled = false;
					eval(varBodyFrame+document.getElementById("name_suffix")).value = "";
				}

					// added for local lang names
				if(eval(varBodyFrame).document.getElementById("first_name_oth_lang") != null)
				{
				eval(varBodyFrame).document.getElementById("first_name_oth_lang").disabled = false;
				eval(varBodyFrame).document.getElementById("first_name_oth_lang").value = "";
				if(eval(varBodyFrame+document.getElementById("bfo")))
				eval(varBodyFrame+document.getElementById("bfo")).disabled = false;
					
				}
				if(eval(varBodyFrame).document.getElementById("second_name_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("second_name_oth_lang").disabled = false
					eval(varBodyFrame).document.getElementById("second_name_oth_lang").value= "";
					if(eval(varBodyFrame+document.getElementById("bso")))
					eval(varBodyFrame+document.getElementById("bso")).disabled = false;
					
				}
				if(eval(varBodyFrame).document.getElementById("third_name_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("third_name_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("third_name_oth_lang").value= "";
					if(eval(varBodyFrame+document.getElementById("bto")))
					eval(varBodyFrame+document.getElementById("bto")).disabled = false;
				}
				if(eval(varBodyFrame).document.getElementById("family_name_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("family_name_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("family_name_oth_lang").value = "";
					if(eval(varBodyFrame+document.getElementById("bfamo")))
					eval(varBodyFrame+document.getElementById("bfamo")).disabled = false;
					
				}
				if(eval(varBodyFrame).document.getElementById("name_prefix_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").value = "";
				}
				
				if(eval(varBodyFrame).document.getElementById("name_suffix_oth_lang") != null)
				{
					eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").disabled = false;
					eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").value = "";
				}




				if(eval(varBodyFrame+document.getElementById("sex")) != null)
				{
					eval(varBodyFrame+document.getElementById("sex")).disabled = false;
					eval(varBodyFrame+document.getElementById("sex")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("date_of_birth")) != null)
				{
					eval(varBodyFrame+document.getElementById("date_of_birth")).disabled = false;
					eval(varBodyFrame+document.getElementById("date_of_birth")).value= "";
				}
				if(eval(varBodyFrame+document.getElementById("b_age")) != null)
				{
					eval(varBodyFrame+document.getElementById("b_age")).disabled = false;
					eval(varBodyFrame+document.getElementById("b_age")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("b_months")) != null)
				{
					eval(varBodyFrame+document.getElementById("b_months")).disabled = false;
					eval(varBodyFrame+document.getElementById("b_months")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("b_days")) != null)
				{
					eval(varBodyFrame+document.getElementById("b_days")).disabled = false;
					eval(varBodyFrame+document.getElementById("b_days")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("dob")) != null)
				{
					eval(varBodyFrame+document.getElementById("dob")).disabled = false;
					eval(varBodyFrame+document.getElementById("dob")).value = "";
				}
				
				if(eval(varBodyFrame+document.getElementById("birth_place")) != null)
				{
					eval(varBodyFrame+document.getElementById("birth_place")).disabled = false;
					eval(varBodyFrame+document.getElementById("birth_place")).value = "";
					eval(varBodyFrame+document.getElementById("Birth_place_code")).value = "";
					eval(varBodyFrame+document.getElementById("b_birth")).disabled = false;
				}
				if(eval(varBodyFrame+document.getElementById("place_of_birth")) != null)
				{
					eval(varBodyFrame+document.getElementById("place_of_birth")).disabled = false;
					eval(varBodyFrame+document.getElementById("place_of_birth")).value = "";
					
				}
				if(eval(varBodyFrame+document.getElementById("nationality_desc")))
				{
					
					eval(varBodyFrame+document.getElementById("nationality_desc")).disabled = false;
					eval(varBodyFrame+document.getElementById("nationality_id")).disabled = false;
					//Commented on 30.10.2004 for Malaysian Requiremnts
					//eval(varBodyFrame+document.getElementById("nationality_desc")).value = '<%=defaultndesc%>';
					//eval(varBodyFrame+document.getElementById("nationality_code1")).value = '<%=defaultncode%>';
					//Comments Ends
					
					
				}

				if(eval(varBodyFrame+document.getElementById("race_desc")) != null)
				{
					
					var def_cd=eval(varBodyFrame+document.getElementById("default_race_code")).value;
					var def_race_desc = eval(varBodyFrame+document.getElementById("default_race_desc")).value;
					var sel_cd=eval(varBodyFrame+document.getElementById("race_code")).value;

					
					if(def_cd==''){
						//eval(varBodyFrame+document.getElementById("race_code")).disabled = false
						eval(varBodyFrame+document.getElementById("race_desc")).disabled = false
						eval(varBodyFrame+document.getElementById("race_desc_id")).disabled = false
						//eval(varBodyFrame+document.getElementById("race_code")).options[0].selected = true
						eval(varBodyFrame+document.getElementById("race_code")).value = "";
						eval(varBodyFrame+document.getElementById("race_desc")).value = "";
						
						eval(varBodyFrame+document.getElementById("ethnic_group")).disabled = false;
						eval(varBodyFrame+".loadEthnicSubGroup()");
					}else{		
						if(def_cd==sel_cd){
							//eval(varBodyFrame+document.getElementById("race_code")).disabled = false
							eval(varBodyFrame+document.getElementById("race_desc")).disabled = false
							eval(varBodyFrame+document.getElementById("race_desc_id")).disabled = false

							eval(varBodyFrame+document.getElementById("race_code")).value = def_cd;
							eval(varBodyFrame+document.getElementById("race_desc")).value = def_race_desc;
							
							eval(varBodyFrame+document.getElementById("ethnic_group")).disabled = false;
							eval(varBodyFrame+".loadEthnicSubGroup()");
						}else{
							//eval(varBodyFrame+document.getElementById("race_code")).disabled = false
							eval(varBodyFrame+document.getElementById("race_desc")).disabled = false
							eval(varBodyFrame+document.getElementById("race_desc_id")).disabled = false
							//eval(varBodyFrame+document.getElementById("race_code")).options[0].selected = true
							eval(varBodyFrame+document.getElementById("race_code")).value = "";
							eval(varBodyFrame+document.getElementById("race_desc")).value = "";
							
							eval(varBodyFrame+document.getElementById("ethnic_group")).disabled = false;
							eval(varBodyFrame+".loadEthnicSubGroup()");
						}
						
					}
						
				}

				if(eval(varBodyFrame+document.getElementById("citizen_yn"))!=null)
				{
				if(eval(varBodyFrame+document.getElementById("citizen_yn[0]")) != null)
				{
					eval(varBodyFrame+document.getElementById("citizen_yn[0]")).disabled = false;
					eval(varBodyFrame+document.getElementById("citizen_yn[0]")).checked = true;						
				}
				if(eval(varBodyFrame+document.getElementById("citizen_yn[1]")) != null)
				{
					
					eval(varBodyFrame+document.getElementById("citizen_yn[1]")).disabled = false;
						
				}
				if(eval(varBodyFrame+document.getElementById("legal_yn[0]")) != null)
				{
			//		eval(varBodyFrame+document.getElementById("legal_yn[0]")).disabled = false;	eval(varBodyFrame+document.getElementById("legal_yn[0]")).checked = true;	
				}
				if(eval(varBodyFrame+document.getElementById("legal_yn[1]")) != null)
				{
					
		//			eval(varBodyFrame+document.getElementById("legal_yn[1]")).disabled = false;					
				}
				}
				if(eval(varBodyFrame+document.getElementById("national_id_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("national_id_no")).disabled = false;
					eval(varBodyFrame+document.getElementById("national_id_no")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("alt_id1_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("alt_id1_no")).disabled = false;
					eval(varBodyFrame+document.getElementById("alt_id1_no")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("alt_id2_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("alt_id2_no")).disabled = false;
					eval(varBodyFrame+document.getElementById("alt_id2_no")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("alt_id3_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("alt_id3_no")).disabled = false;
					eval(varBodyFrame+document.getElementById("alt_id3_no")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("alt_id4_no")) != null)
				{
					eval(varBodyFrame+document.getElementById("alt_id4_no")).disabled = false;
					eval(varBodyFrame+document.getElementById("alt_id4_no")).value = "";
				}
				if(eval(varBodyFrame+document.getElementById("other_alt_type")) != null)
				{
					eval(varBodyFrame+document.getElementById("other_alt_type")).disabled = false;
					eval(varBodyFrame+document.getElementById("other_alt_type")).value = "";
					eval(varBodyFrame+document.getElementById("other_alt_Id")).disabled = false;
					eval(varBodyFrame+document.getElementById("other_alt_Id")).value = "";
				}


				if(eval(varBodyFrame+document.getElementById("alt_id1_exp_date")))
				{
					if(eval(varBodyFrame+document.getElementById("alt_id1_no")).value!="")
					{
					eval(varBodyFrame+document.getElementById("alt_id1_exp_date")).disabled = false;
					eval(varBodyFrame+document.getElementById("alt_id1_exp_date")).value = "";
					eval(varBodyFrame+document.getElementById("alt_id_exp_dt1")).disabled = false;
					}
					else
					{
					eval(varBodyFrame+document.getElementById("alt_id1_exp_date")).disabled = true;
					eval(varBodyFrame+document.getElementById("alt_id1_exp_date")).value = "";
					eval(varBodyFrame+document.getElementById("alt_id_exp_dt1")).disabled = true;
					}
					
				}

				if(eval(varBodyFrame+document.getElementById("alt_id2_exp_date")))
				{
					
				if(eval(varBodyFrame+document.getElementById("alt_id2_no")).value!="")
					{
					eval(varBodyFrame+document.getElementById("alt_id2_exp_date")).disabled = false;
					eval(varBodyFrame+document.getElementById("alt_id2_exp_date")).value = "";
					eval(varBodyFrame+document.getElementById("alt_id_exp_dt2")).disabled = false;
					}
					else
					{
					eval(varBodyFrame+document.getElementById("alt_id2_exp_date")).disabled = true;
					eval(varBodyFrame+document.getElementById("alt_id2_exp_date")).value = "";
					eval(varBodyFrame+document.getElementById("alt_id_exp_dt2")).disabled = true;
					}
					
				}

				if(eval(varBodyFrame+document.getElementById("alt_id3_exp_date")))
				{

					if(eval(varBodyFrame+document.getElementById("alt_id3_no")).value!="")	
					{
					eval(varBodyFrame+document.getElementById("alt_id3_exp_date")).disabled = false;
					eval(varBodyFrame+document.getElementById("alt_id3_exp_date")).value = "";
					eval(varBodyFrame+document.getElementById("alt_id_exp_dt3")).disabled = false;
					}
					else
					{
						eval(varBodyFrame+document.getElementById("alt_id3_exp_date")).disabled = true;
					eval(varBodyFrame+document.getElementById("alt_id3_exp_date")).value = "";
					eval(varBodyFrame+document.getElementById("alt_id_exp_dt3")).disabled = true;
					}
				
				}


				if(eval(varBodyFrame+document.getElementById("alt_id4_exp_date")))
				{
					
				if(eval(varBodyFrame+document.getElementById("alt_id4_no")).value!="")
					{
					eval(varBodyFrame+document.getElementById("alt_id4_exp_date")).disabled = false;
					eval(varBodyFrame+document.getElementById("alt_id4_exp_date")).value = "";
					eval(varBodyFrame+document.getElementById("alt_id_exp_dt4")).disabled = false;
					}
					else
					{
						eval(varBodyFrame+document.getElementById("alt_id4_exp_date")).disabled = true;
					eval(varBodyFrame+document.getElementById("alt_id4_exp_date")).value = "";
					eval(varBodyFrame+document.getElementById("alt_id_exp_dt4")).disabled = true;
					}
					
				}


			document.forms[0].addr1_type.value					= "";  
			document.forms[0].addr_line1.value						= "";
			document.forms[0].addr_line2.value						= "";
			document.forms[0].addr_line3.value						= "";
			document.forms[0].addr_line4.value						= "";
			document.forms[0].res_town_code.value			    = "";
			document.forms[0].res_area_code.value				= "";
			document.forms[0].postal_code.value					= "";
			document.forms[0].region_code.value					= "";
			document.forms[0].country_code.value				= "";
			document.forms[0].contact1_name.value				= "";
			document.forms[0].invalid1_yn.value				    = "";
			document.forms[0].addr2_type.value					= "";
			document.forms[0].mail_addr_line1.value				= "";
			document.forms[0].mail_addr_line2.value			= "";
			document.forms[0].mail_addr_line3.value			= "";
			document.forms[0].mail_addr_line4.value			= "";
			document.forms[0].mail_res_town_code.value	= "";
			document.forms[0].mail_res_area_code.value	= "";
			document.forms[0].mail_postal_code.value	    = "";

			document.forms[0].mail_region_code.value		= "";
			document.forms[0].mail_country_code.value		= "";

			document.forms[0].contact2_name.value		=  "";
			document.forms[0].invalid2_yn.value		=  "";

			document.forms[0].contact1_no.value		=  "";
			document.forms[0].contact2_no.value		=  "";
			document.forms[0].email.value		=  "";
			document.forms[0].mail_country_desc.value		=  "";
			document.forms[0].country_desc.value		=  "";

			//Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start
			document.forms[0].alt_addr_line1.value		= "";
			document.forms[0].alt_addr_line2.value		= "";
			document.forms[0].alt_addr_line3.value		= "";
			document.forms[0].alt_addr_line4.value		= "";
			document.forms[0].alt_town_code.value		= "";
			document.forms[0].alt_town_desc.value		= "";
			document.forms[0].alt_area_code.value		= "";
			document.forms[0].alt_area_desc.value		= "";
			document.forms[0].alt_postal_code.value		= "";
			document.forms[0].alt_postal_desc.value		= "";
			document.forms[0].alt_region_code.value		= "";
			document.forms[0].alt_region_desc.value		= "";
			document.forms[0].alt_country_code.value	= "";
			document.forms[0].alt_country_desc.value	= "";
			

			if(eval(varBodyFrame+document.getElementById("OpenBooking"))){
				eval(varBodyFrame+document.getElementById("OpenBooking")).innerHTML="";
			}
		}
		*/
		
		function clearAll()
		{  

			
			varBodyFrame = '<%=strBodyFrame%>';
			
				if(eval(varBodyFrame+".document.getElementById('sec_sel')") != null)
					eval(varBodyFrame+".document.getElementById('sec_sel')").value="";
				
				if(eval(varBodyFrame+".document.getElementById('patient_name')") != null)
				{
					//eval(varBodyFrame+".document.getElementById('patient_name')").disabled = false
					eval(varBodyFrame+".document.getElementById('patient_name')").value = "";
				}
				
				eval(varBodyFrame+".document.getElementById('patient_name1')").innerHTML="";
				eval(varBodyFrame+".document.getElementById('patient_name_local_lang1')").innerHTML="";

				if(eval(varBodyFrame+".document.getElementById('name_prefix')") != null)
				{
					eval(varBodyFrame+".document.getElementById('name_prefix')").disabled = false
					eval(varBodyFrame+".document.getElementById('name_prefix')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('first_name')") != null)
				{
					eval(varBodyFrame+".document.getElementById('first_name')").disabled = false;
					eval(varBodyFrame+".document.getElementById('first_name')").value = "";
					if(eval(varBodyFrame+".document.getElementById('bf')"))
					eval(varBodyFrame+".document.getElementById('bf')").disabled = false;
					
				}
				if(eval(varBodyFrame+".document.getElementById('second_name')") != null)
				{
					eval(varBodyFrame+".document.getElementById('second_name')").disabled = false
					eval(varBodyFrame+".document.getElementById('second_name')").value= "";
					if(eval(varBodyFrame+".document.getElementById('bs')"))
					eval(varBodyFrame+".document.getElementById('bs')").disabled = false;
					
				}
				if(eval(varBodyFrame+".document.getElementById('third_name')") != null)
				{
					eval(varBodyFrame+".document.getElementById('third_name')").disabled = false;
					eval(varBodyFrame+".document.getElementById('third_name')").value= "";
					if(eval(varBodyFrame+".document.getElementById('bt')"))
					eval(varBodyFrame+".document.getElementById('bt')").disabled = false;
				}
				if(eval(varBodyFrame+".document.getElementById('family_name')") != null)
				{
					eval(varBodyFrame+".document.getElementById('family_name')").disabled = false;
					eval(varBodyFrame+".document.getElementById('family_name')").value = "";
					if(eval(varBodyFrame+".document.getElementById('bfam')"))
					eval(varBodyFrame+".document.getElementById('bfam')").disabled = false;
					
				}
				if(eval(varBodyFrame+".document.getElementById('name_suffix')") != null)
				{
					eval(varBodyFrame+".document.getElementById('name_suffix')").disabled = false;
					eval(varBodyFrame+".document.getElementById('name_suffix')").value = "";
				}

					// added for local lang names
				if(eval(varBodyFrame).document.getElementById('first_name_oth_lang') != null)
				{
				eval(varBodyFrame).document.getElementById('first_name_oth_lang').disabled = false;
				eval(varBodyFrame).document.getElementById('first_name_oth_lang').value = "";
				if(eval(varBodyFrame+".document.getElementById('bfo')"))
				eval(varBodyFrame+".document.getElementById('bfo')").disabled = false;
					
				}
				if(eval(varBodyFrame).document.getElementById('second_name_oth_lang') != null)
				{
					eval(varBodyFrame).document.getElementById('second_name_oth_lang').disabled = false
					eval(varBodyFrame).document.getElementById('second_name_oth_lang').value= "";
					if(eval(varBodyFrame+".document.getElementById('bso')"))
					eval(varBodyFrame+".document.getElementById('bso')").disabled = false;
					
				}
				if(eval(varBodyFrame).document.getElementById('third_name_oth_lang') != null)
				{
					eval(varBodyFrame).document.getElementById('third_name_oth_lang').disabled = false;
					eval(varBodyFrame).document.getElementById('third_name_oth_lang').value= "";
					if(eval(varBodyFrame+".document.getElementById('bto')"))
					eval(varBodyFrame+".document.getElementById('bto')").disabled = false;
				}
				if(eval(varBodyFrame).document.getElementById('family_name_oth_lang') != null)
				{
					eval(varBodyFrame).document.getElementById('family_name_oth_lang').disabled = false;
					eval(varBodyFrame).document.getElementById('family_name_oth_lang').value = "";
					if(eval(varBodyFrame+".document.getElementById('bfamo')"))
					eval(varBodyFrame+".document.getElementById('bfamo')").disabled = false;
					
				}
				if(eval(varBodyFrame).document.getElementById('name_prefix_oth_lang') != null)
				{
					eval(varBodyFrame).document.getElementById('name_prefix_oth_lang').disabled = false;
					eval(varBodyFrame).document.getElementById('name_prefix_oth_lang').value = "";
				}
				
				if(eval(varBodyFrame).document.getElementById('name_suffix_oth_lang') != null)
				{
					eval(varBodyFrame).document.getElementById('name_suffix_oth_lang').disabled = false;
					eval(varBodyFrame).document.getElementById('name_suffix_oth_lang').value = "";
				}




				if(eval(varBodyFrame+".document.getElementById('sex')") != null)
				{
					eval(varBodyFrame+".document.getElementById('sex')").disabled = false;
					eval(varBodyFrame+".document.getElementById('sex')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('date_of_birth')") != null)
				{
					eval(varBodyFrame+".document.getElementById('date_of_birth')").disabled = false;
					eval(varBodyFrame+".document.getElementById('date_of_birth')").value= "";
				}
				if(eval(varBodyFrame+".document.getElementById('b_age')") != null)
				{
					eval(varBodyFrame+".document.getElementById('b_age')").disabled = false;
					eval(varBodyFrame+".document.getElementById('b_age')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('b_months')") != null)
				{
					eval(varBodyFrame+".document.getElementById('b_months')").disabled = false;
					eval(varBodyFrame+".document.getElementById('b_months')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('b_days')") != null)
				{
					eval(varBodyFrame+".document.getElementById('b_days')").disabled = false;
					eval(varBodyFrame+".document.getElementById('b_days')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('dob')") != null)
				{
					eval(varBodyFrame+".document.getElementById('dob')").disabled = false;
					eval(varBodyFrame+".document.getElementById('dob')").value = "";
				}
				
				if(eval(varBodyFrame+".document.getElementById('birth_place')") != null)
				{
					eval(varBodyFrame+".document.getElementById('birth_place')").disabled = false;
					eval(varBodyFrame+".document.getElementById('birth_place')").value = "";
					eval(varBodyFrame+".document.getElementById('Birth_place_code')").value = "";
					eval(varBodyFrame+".document.getElementById('b_birth')").disabled = false;
				}
				if(eval(varBodyFrame+".document.getElementById('place_of_birth')") != null)
				{
					eval(varBodyFrame+".document.getElementById('place_of_birth')").disabled = false;
					eval(varBodyFrame+".document.getElementById('place_of_birth')").value = "";
					
				}
				if(eval(varBodyFrame+".document.getElementById('nationality_desc')"))
				{
					
					eval(varBodyFrame+".document.getElementById('nationality_desc')").disabled = false;
					eval(varBodyFrame+".document.getElementById('nationality_id')").disabled = false;
					//Commented on 30.10.2004 for Malaysian Requiremnts
					//eval(varBodyFrame+".document.getElementById('nationality_desc')").value = '<%=defaultndesc%>';
					//eval(varBodyFrame+".document.getElementById('nationality_code1')").value = '<%=defaultncode%>';
					//Comments Ends
					
					
				}

				if(eval(varBodyFrame+".document.getElementById('race_desc')") != null)
				{
					
					var def_cd=eval(varBodyFrame+".document.getElementById('default_race_code')").value;
					var def_race_desc = eval(varBodyFrame+".document.getElementById('default_race_desc')").value;
					var sel_cd=eval(varBodyFrame+".document.getElementById('race_code')").value;

					
					if(def_cd==''){
						//eval(varBodyFrame+".document.getElementById('race_code')").disabled = false
						eval(varBodyFrame+".document.getElementById('race_desc')").disabled = false
						eval(varBodyFrame+".document.getElementById('race_desc_id')").disabled = false
						//eval(varBodyFrame+".document.getElementById('race_code")).options[0].selected = true
						eval(varBodyFrame+".document.getElementById('race_code')").value = "";
						eval(varBodyFrame+".document.getElementById('race_desc')").value = "";
						
						eval(varBodyFrame+".document.getElementById('ethnic_group')").disabled = false;
						eval(varBodyFrame+".loadEthnicSubGroup()");
					}else{		
						if(def_cd==sel_cd){
							//eval(varBodyFrame+".document.getElementById('race_code')").disabled = false
							eval(varBodyFrame+".document.getElementById('race_desc')").disabled = false
							eval(varBodyFrame+".document.getElementById('race_desc_id')").disabled = false

							eval(varBodyFrame+".document.getElementById('race_code')").value = def_cd;
							eval(varBodyFrame+".document.getElementById('race_desc')").value = def_race_desc;
							
							eval(varBodyFrame+".document.getElementById('ethnic_group')").disabled = false;
							eval(varBodyFrame+".loadEthnicSubGroup()");
						}else{
							//eval(varBodyFrame+".document.getElementById('race_code')").disabled = false
							eval(varBodyFrame+".document.getElementById('race_desc')").disabled = false
							eval(varBodyFrame+".document.getElementById('race_desc_id')").disabled = false
							//eval(varBodyFrame+".document.getElementById('race_code')").options[0].selected = true
							eval(varBodyFrame+".document.getElementById('race_code')").value = "";
							eval(varBodyFrame+".document.getElementById('race_desc')").value = "";
							
							eval(varBodyFrame+".document.getElementById('ethnic_group')").disabled = false;
							eval(varBodyFrame+".loadEthnicSubGroup()");
						}
						
					}
						
				}

				if(eval(varBodyFrame+".document.getElementById('citizen_yn')")!=null)
				{
				if(eval(varBodyFrame+".document.getElementById('citizen_yn')") != null)
				{
					eval(varBodyFrame+".document.getElementById('citizen_yn')").disabled = false;
					eval(varBodyFrame+".document.getElementById('citizen_yn')").checked = true;						
				}
				if(eval(varBodyFrame+".document.getElementById('citizen_yn')") != null)
				{
					
					eval(varBodyFrame+".document.getElementById('citizen_yn')").disabled = false;
						
				}
				if(eval(varBodyFrame+".document.getElementById('legal_yn')") != null)
				{
			//		eval(varBodyFrame+".document.getElementById('legal_yn')").disabled = false;	eval(varBodyFrame+".document.getElementById('legal_yn')).checked = true;	
				}
				if(eval(varBodyFrame+".document.getElementById('legal_yn')") != null)
				{
					
		//			eval(varBodyFrame+".document.getElementById('legal_yn')").disabled = false;					
				}
				}
				if(eval(varBodyFrame+".document.getElementById('national_id_no')") != null)
				{
					eval(varBodyFrame+".document.getElementById('national_id_no')").disabled = false;
					eval(varBodyFrame+".document.getElementById('national_id_no')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('alt_id1_no')") != null)
				{
					eval(varBodyFrame+".document.getElementById('alt_id1_no')").disabled = false;
					eval(varBodyFrame+".document.getElementById('alt_id1_no')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('alt_id2_no')") != null)
				{
					eval(varBodyFrame+".document.getElementById('alt_id2_no')").disabled = false;
					eval(varBodyFrame+".document.getElementById('alt_id2_no')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('alt_id3_no')") != null)
				{
					eval(varBodyFrame+".document.getElementById('alt_id3_no')").disabled = false;
					eval(varBodyFrame+".document.getElementById('alt_id3_no')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('alt_id4_no')") != null)
				{
					eval(varBodyFrame+".document.getElementById('alt_id4_no')").disabled = false;
					eval(varBodyFrame+".document.getElementById('alt_id4_no')").value = "";
				}
				if(eval(varBodyFrame+".document.getElementById('other_alt_type')") != null)
				{
					eval(varBodyFrame+".document.getElementById('other_alt_type')").disabled = false;
					eval(varBodyFrame+".document.getElementById('other_alt_type')").value = "";
					eval(varBodyFrame+".document.getElementById('other_alt_Id')").disabled = false;
					eval(varBodyFrame+".document.getElementById('other_alt_Id')").value = "";
				}

				if(eval(varBodyFrame+".document.getElementById('alt_id1_exp_date')"))
				{
					if(eval(varBodyFrame+".document.getElementById('alt_id1_no')").value!="")
					{
					eval(varBodyFrame+".document.getElementById('alt_id1_exp_date')").disabled = false;
					eval(varBodyFrame+".document.getElementById('alt_id1_exp_date')").value = "";
					eval(varBodyFrame+".document.getElementById('alt_id_exp_dt1')").disabled = false;
					}
					else
					{
					eval(varBodyFrame+".document.getElementById('alt_id1_exp_date')").disabled = true;
					eval(varBodyFrame+".document.getElementById('alt_id1_exp_date')").value = "";
					eval(varBodyFrame+".document.getElementById('alt_id_exp_dt1')").disabled = true;
					}
					
				}

				if(eval(varBodyFrame+".document.getElementById('alt_id2_exp_date')"))
				{					
					if(eval(varBodyFrame+".document.getElementById('alt_id2_no')").value!="")
					{
						eval(varBodyFrame+".document.getElementById('alt_id2_exp_date')").disabled = false;
						eval(varBodyFrame+".document.getElementById('alt_id2_exp_date')").value = "";
						eval(varBodyFrame+".document.getElementById('alt_id_exp_dt2')").disabled = false;
					}
					else
					{
						eval(varBodyFrame+".document.getElementById('alt_id2_exp_date')").disabled = true;
						eval(varBodyFrame+".document.getElementById('alt_id2_exp_date')").value = "";
						eval(varBodyFrame+".document.getElementById('alt_id_exp_dt2')").disabled = true;
					}					
				}

				if(eval(varBodyFrame+".document.getElementById('alt_id3_exp_date')"))
				{

					if(eval(varBodyFrame+".document.getElementById('alt_id3_no')").value!="")	
					{
					eval(varBodyFrame+".document.getElementById('alt_id3_exp_date')").disabled = false;
					eval(varBodyFrame+".document.getElementById('alt_id3_exp_date')").value = "";
					eval(varBodyFrame+".document.getElementById('alt_id_exp_dt3')").disabled = false;
					}
					else
					{
						eval(varBodyFrame+".document.getElementById('alt_id3_exp_date')").disabled = true;
					eval(varBodyFrame+".document.getElementById('alt_id3_exp_date')").value = "";
					eval(varBodyFrame+".document.getElementById('alt_id_exp_dt3')").disabled = true;
					}
				
				}


				if(eval(varBodyFrame+".document.getElementById('alt_id4_exp_date')"))
				{
					
				if(eval(varBodyFrame+".document.getElementById('alt_id4_no')").value!="")
					{
					eval(varBodyFrame+".document.getElementById('alt_id4_exp_date')").disabled = false;
					eval(varBodyFrame+".document.getElementById('alt_id4_exp_date')").value = "";
					eval(varBodyFrame+".document.getElementById('alt_id_exp_dt4')").disabled = false;
					}
					else
					{
						eval(varBodyFrame+".document.getElementById('alt_id4_exp_date')").disabled = true;
					eval(varBodyFrame+".document.getElementById('alt_id4_exp_date')").value = "";
					eval(varBodyFrame+".document.getElementById('alt_id_exp_dt4')").disabled = true;
					}
					
				}


			document.forms[0].addr1_type.value					= "";  
			document.forms[0].addr_line1.value						= "";
			document.forms[0].addr_line2.value						= "";
			document.forms[0].addr_line3.value						= "";
			document.forms[0].addr_line4.value						= "";
			document.forms[0].res_town_code.value			    = "";
			document.forms[0].res_area_code.value				= "";
			document.forms[0].postal_code.value					= "";
			document.forms[0].region_code.value					= "";
			document.forms[0].country_code.value				= "";
			document.forms[0].contact1_name.value				= "";
			document.forms[0].invalid1_yn.value				    = "";
			document.forms[0].addr2_type.value					= "";
			document.forms[0].mail_addr_line1.value				= "";
			document.forms[0].mail_addr_line2.value			= "";
			document.forms[0].mail_addr_line3.value			= "";
			document.forms[0].mail_addr_line4.value			= "";
			document.forms[0].mail_res_town_code.value	= "";
			document.forms[0].mail_res_area_code.value	= "";
			document.forms[0].mail_postal_code.value	    = "";

			document.forms[0].mail_region_code.value		= "";
			document.forms[0].mail_country_code.value		= "";

			document.forms[0].contact2_name.value		=  "";
			document.forms[0].invalid2_yn.value		=  "";

			document.forms[0].contact1_no.value		=  "";
			document.forms[0].contact2_no.value		=  "";
			document.forms[0].email.value		=  "";
			document.forms[0].mail_country_desc.value		=  "";
			document.forms[0].country_desc.value		=  "";

			/*Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			document.forms[0].alt_addr_line1.value		= "";
			document.forms[0].alt_addr_line2.value		= "";
			document.forms[0].alt_addr_line3.value		= "";
			document.forms[0].alt_addr_line4.value		= "";
			document.forms[0].alt_town_code.value		= "";
			document.forms[0].alt_town_desc.value		= "";
			document.forms[0].alt_area_code.value		= "";
			document.forms[0].alt_area_desc.value		= "";
			document.forms[0].alt_postal_code.value		= "";
			document.forms[0].alt_postal_desc.value		= "";
			document.forms[0].alt_region_code.value		= "";
			document.forms[0].alt_region_desc.value		= "";
			document.forms[0].alt_country_code.value	= "";
			document.forms[0].alt_country_desc.value	= "";
			/*End*/

			if(eval(varBodyFrame+".document.getElementById('OpenBooking')")){
				eval(varBodyFrame+".document.getElementById('OpenBooking')").innerHTML="";
			}
		}
		async function patSearch() 
		{	
//				var patid=PatientSearch('','','','','','','Y','','','OTHER');
				var patid=await PatientSearch('','','','','','','','N','','OTHER');
				if( patid ==null)patid="";

				if (patid != "")document.forms[0].patient_id.value=patid;
				
				if(patid != "" && patid !=null)
				{ 
					eval(varBodyFrame+".document.getElementById('patient_id')").value = patid;	
					validatePatient(eval(varBodyFrame+".document.getElementById('patient_id')"));
					
				}
				else
				{
					if(document.forms[0].patient_id.value=="")
					{
					clearAll();
					}
				}
		}

		function validatePatient(obj) {		
			
			varSubmitFrame = '<%=strSubmitFrame%>';
			
			varBodyFrame = '<%=strBodyFrame%>';
			varAlertYn = '<%=strAlertReqdYn%>';
			varDervnlogic = '<%=strNameDrvnLogic%>';
			varpartname = '<%=strPatNameAsMultiPart%>';
			var vAltId1Type = '<%=AltId1Type%>';
			var vAltId2Type = '<%=AltId2Type%>';
			var vAltId3Type = '<%=AltId3Type%>';
			var vAltId4Type = '<%=AltId4Type%>';
			var vAcceptOtherAltId = '<%=AcceptOtherAltId%>';
			if(eval(varBodyFrame+".document.getElementById('sec_sel')") != null)
					eval(varBodyFrame+".document.getElementById('sec_sel')").value="";

			var op_call = '<%=op_call%>';
			if(op_call=="reg_pat"||op_call=="ae_reg_pat")
				varSubmitFrame = "parent.parent.frames[2]";
			if(obj.value != '')	{
				document.forms[0].change_address.value ="N";
				var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatIdValidations.jsp'><input type='hidden' name='process_id' id='process_id' value='4'><input type='hidden' name='pat_id' id='pat_id' value='" +obj.value + "'><input type='hidden' name='bodyFrame' id='bodyFrame' value='"+varBodyFrame+"'><input type='hidden' name='submitFrame' id='submitFrame' value='"+varSubmitFrame+"'><input type='hidden' name='name_dervn_logic' id='name_dervn_logic' value='"+varDervnlogic+"'><input type='hidden' name='alert_reqd_yn' id='alert_reqd_yn' value='"+varAlertYn+"'><input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='"+varpartname+"'><input type='hidden' name='AltId1Type' id='AltId1Type' value='"+vAltId1Type+"'><input type='hidden' name='AltId2Type' id='AltId2Type' value='"+vAltId2Type+"'><input type='hidden' name='AltId3Type' id='AltId3Type' value='"+vAltId3Type+"'><input type='hidden' name='AltId4Type' id='AltId4Type' value='"+vAltId4Type+"'><input type='hidden' name='AcceptOtherAltId' id='AcceptOtherAltId' value='"+vAcceptOtherAltId+"'><input type='hidden' name='op_call' id='op_call' value='"+op_call+"'></form></BODY></HTML>";
			
//			eval(varSubmitFrame).document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				eval(varSubmitFrame).document.write(HTMLVal);	
						
				if(eval(varSubmitFrame).document.form1!=null)
				{
					eval(varSubmitFrame).document.form1.submit();							
				}
				if(op_call != "reg_pat" && op_call != "ae_reg_pat")
				localValidations(obj.value);

			}else{
				document.forms[0].change_address.value ="Y";
				if(document.getElementById('past_visits'))
				document.forms[0].past_visits.disabled=true;
				if(document.getElementById('last_visits'))
				document.forms[0].last_visits.disabled=true;
				if(document.getElementById('other_id1'))
					document.getElementById('other_id1').style.visibility='hidden';
				
				clearAll();	
				
				
			}
			
		}
	</script>
</head>

<%
	String strPatIdSize = request.getParameter("patidsize");
	if(strPatIdSize == null || strPatIdSize=="")
	{
		strPatIdSize = "0";
	}
%> 
<input type='hidden' name='alert_reqd_yn' id='alert_reqd_yn' value='<%=strAlertReqdYn%>'>
<input type='hidden' name='name_dervn_logic' id='name_dervn_logic' value="<%=strNameDrvnLogic%>">
<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='<%=strPatNameAsMultiPart%>'>
   <!-- <table cellpadding=0 cellspacing=0 border=0 width="100%" tabindex=-1>
	<tr>
	<td align='right' class='label' width='1.6%' nowrap>Patient ID</td>
	<td nowrap width='1.8%' align='left'>
	&nbsp;&nbsp;<input type= 'text' name='patient_id' id='patient_id' value="" size='<%=strPatIdSize%>'  maxlength='<%=strPatIdSize%>'  onchange='ChangeUpperCase(this);checkPatient(this)' onKeyPress='return CheckForSpecChars(event)' ><input type='button' name='search' id='search' value='?'  class="BUTTON" onClick='patSearch()' tabIndex="-1" >	
	</td>
	<td align='right' class='label' width="1%" nowrap>&nbsp;Name&nbsp;</td>
	<td  width="5.4%">&nbsp;<input type='text' name='patient_name' id='patient_name'  maxlength='60' size='60' readonly></td>
	<td align='left' width='1%'>&nbsp;&nbsp;<input type='button' class='button' name='contact_details' id='contact_details' value='Contact Details'  onclick='Modal_Contact_Details(this);' id = '' style='width:100px'>
	</td>
</tr>
</table> -->

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

