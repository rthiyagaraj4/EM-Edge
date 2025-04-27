<!DOCTYPE html>
<!--    Function Name VisitRegistration
    Created by M.Sathis Kumar on 13/12/2000 -->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!--Above line added for this CRF HSA-CRF-0289-->
<html>
    <head>
        <meta http-equiv="Expires" content="0">
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale =((String)session.getAttribute("LOCALE"));
request.setCharacterEncoding("UTF-8");

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
<script>
function makeRequest(Obj) {  
            //var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH alt_id_name=\""+Obj.name+"\" alt_id_value=\""+Obj.value+"\" process_id='31'/></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")			
			var url = "../../eMP/jsp/ServerValidationXML.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText) ;				
			eval(responseText)
			 
			if(1<parseInt(document.forms[0].isAlternateIdCount.value)){ 
			var objval="";
			if(Obj.name=="alt_id1_no")objval="search1";
            if(Obj.name=="alt_id2_no")objval="search2";
            if(Obj.name=="alt_id3_no")objval="search3";
            if(Obj.name=="alt_id4_no")objval="search4";
			getPatientID(objval);
			}
				
}
 
/*
* Returns a function that waits for the state change in XMLHttpRequest
*/

 async  function getPatientID(objval)
        {   
		   // var pat_id=PatientSearch();
		   //Above line commented for this CRF HSA-CRF-0289
		    var isAlternateId=document.forms[0].isAlternateId.value;   
			var alternatSearch=objval.name;    
			if(typeof alternatSearch==="undefined"){alternatSearch=objval;}				
			
    		var alternate_id_no="";
			if(alternatSearch=="search1")alternate_id_no=document.forms[0].alt_id1_no.value; 
			if(alternatSearch=="search2")alternate_id_no=document.forms[0].alt_id2_no.value; 
			if(alternatSearch=="search3")alternate_id_no=document.forms[0].alt_id3_no.value; 
			if(alternatSearch=="search4")alternate_id_no=document.forms[0].alt_id4_no.value; 
			var pat_id=await PatientSearch('','','','','','','','','','','','',alternatSearch,isAlternateId,alternate_id_no);
			 
            if( pat_id != null )
            {
                document.getElementById('patient_id').value = pat_id 
                check_patient_id();
            }
			if(typeof pat_id==="undefined"){ 
			           document.forms[0].patient_id.value=''; 
					   document.getElementById('patient_name').innerText=''; 
					   document.getElementById('years').innerText=''; 
					   document.getElementById('months').innerText=''; 
					   document.getElementById('days').innerText=''; 
					   document.getElementById('sex').innerText=''; 
					   document.getElementById('date_of_birth').innerText=''; 
					   document.getElementById('date_of_birth_greg').innerText=''; 
					   document.getElementById('nationality').innerText=''; 					    
					   document.forms[0].alt_id1_no.value=''; 
					   if(document.getElementById('nat_id_prompt_no'))document.getElementById('nat_id_prompt_no').innerText=''; 
					 if(isAlternateId=="true"){					    
					    document.getElementById('alt_id2_no').value='';					     
					    document.getElementById('alt_id3_no').value='';					   
					    document.getElementById('alt_id4_no').value='';                       
					    document.getElementById('oth_alt_id_no').innerHTML='';                       
					    document.getElementById('oth_alt_id').innerHTML=getLabel('eMP.OtherAltNo.label','MP'); 		   
					  }else{					 
					   document.getElementById('alt_id2_no').innerHTML=''; 					   
					   document.getElementById('alt_id3_no').innerHTML='';					   
					   document.getElementById('alt_id4_no').innerHTML=''; 					  
					   document.getElementById('oth_alt_id').innerHTML='';					   
					   document.getElementById('oth_alt_id_no').innerHTML=''; 
					  }

			
						
			}	
		}
		function check_patient_id(obj){
		
			var fields = new Array (document.forms[0].patient_id);
        	var names = new Array (getLabel('Common.patientId.label','common'));	
			var error_jsp="";
			var messageFrame="";
			if(SpecialCharCheck(fields,names,messageFrame,"A",error_jsp))
		    {
				  var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dummypromptpatient1' id='dummypromptpatient1' method='post' action='../../eMP/jsp/PatReferralValidation.jsp' target='prompt_patidf2'><input type='hidden' name='list_name' id='list_name' value='check_patient_id'><input type='hidden' name='prompt_patient_id' id='prompt_patient_id' value='"+document.forms[0].patient_id.value+"'><input type='hidden' name='q_clinic_code' id='q_clinic_code' value='"+document.forms[0].q_clinic_code.value+"'><input type='hidden' name='q_appt_ref_no' id='q_appt_ref_no' value='"+document.forms[0].q_appt_ref_no.value+"'><input type='hidden' name='q_booking_ref_no' id='q_booking_ref_no' value='"+document.forms[0].q_booking_ref_no.value+"'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+document.forms[0].p_referral_id.value+"'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+document.forms[0].p_referral_id.value+"'><input type='hidden' name='func_act' id='func_act' value='"+document.forms[0].func_act.value+"'><input type='hidden' name='calledFrom' id='calledFrom' value='"+document.forms[0].calledFrom.value+"'><input type='hidden' name='Unregpatbkgyn' id='Unregpatbkgyn' value='"+document.forms[0].Unregpatbkgyn.value+"'><input type='hidden' name='fromVR' id='fromVR' value='"+document.forms[0].fromVR.value+"'><input type='hidden' name='q_booking_type' id='q_booking_type' value='"+document.forms[0].q_booking_type.value+"'>";

					if(obj !=null){ //Added for this CRF HSA-CRF-0289
					
					  if(obj.name == 'alt_id1_no')
						{
						  HTMLVal= HTMLVal + "<input type = 'hidden' name='alt_id1_no' id='alt_id1_no' value='"+obj.value+"'><input type='hidden' name='alt_id_type' id='alt_id_type' value='"+document.forms[0].alt_id_type.value+"'>" ;
						}
					  if(obj.name == 'alt_id2_no')
						{
						  HTMLVal= HTMLVal + "<input type = 'hidden' name='alt_id2_no' id='alt_id2_no' value='"+obj.value+"'><input type='hidden' name='alt_id2_type' id='alt_id2_type' value='"+document.forms[0].alt_id2_type.value+"'>" ;
						}
					  if(obj.name == 'alt_id3_no')
						{
						  HTMLVal= HTMLVal + "<input type = 'hidden' name='alt_id3_no' id='alt_id3_no' value='"+obj.value+"'><input type='hidden' name='alt_id3_type' id='alt_id3_type' value='"+document.forms[0].alt_id3_type.value+"'>" ;
						}
					  if(obj.name == 'alt_id4_no')
						{
						  HTMLVal= HTMLVal + "<input type = 'hidden' name='alt_id4_no' id='alt_id4_no' value='"+obj.value+"'><input type='hidden' name='alt_id4_type' id='alt_id4_type' value='"+document.forms[0].alt_id4_type.value+"'>" ;
						}
						
				     } //End HSA-CRF-0289 		
					 HTMLVal = HTMLVal+"</form></body></html>";
					 parent.frames[1].document.write(HTMLVal);
					 parent.frames[1].document.dummypromptpatient1.submit();
				}
		}

	async function ButtonClick(flag)
    {
	  var q_clinic_code=document.forms[0].q_clinic_code.value;
	  var q_appt_ref_no=document.forms[0].q_appt_ref_no.value;
      var function_id = document.forms[0].function_id.value;
	  var q_from_funct=document.forms[0].q_from_funct.value;
	  var q_booking_ref_no= document.forms[0].q_booking_ref_no.value;
	  var p_referral_id=document.forms[0].p_referral_id.value;
	  var func_act= document.forms[0].func_act.value;
	  var q_booking_type= document.forms[0].q_booking_type.value;
	  var fromVR= document.forms[0].fromVR.value;
     
	  if (flag=="O")
      {
	 	if((document.forms[0].patient_id.value != "") )
		{
		
				var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dummypromptpatient2' id='dummypromptpatient2' method='post' action='../../eMP/jsp/PatReferralValidation.jsp'><input type='hidden' name='list_name' id='list_name' value='ok'><input type='hidden' name='prompt_patient_id' id='prompt_patient_id' value='"+document.forms[0].patient_id.value+"'><input type='hidden' name='q_clinic_code' id='q_clinic_code' value='"+q_clinic_code+"'><input type='hidden' name='q_appt_ref_no' id='q_appt_ref_no' value='"+q_appt_ref_no+"'><input type='hidden' name='q_from_funct' id='q_from_funct' value='"+q_from_funct+"'><input type='hidden' name='q_booking_ref_no' id='q_booking_ref_no' value='"+q_booking_ref_no+"'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+p_referral_id+"'><input type='hidden' name='func_act' id='func_act' value='"+func_act+"'><input type='hidden' name='fromVR' id='fromVR' value='"+fromVR+"'><input type='hidden' name='q_booking_type' id='q_booking_type' value='"+q_booking_type+"'><input type='hidden' name='from_PatIDF1' id='from_PatIDF1' value='true'><input type='hidden' name='function_id' id='function_id' value='"+function_id+"' >";

			   HTMLVal = HTMLVal+"</form></body></html>";
			 //parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		       parent.frames[1].document.write(HTMLVal);
			   if(parent.frames[1].document.dummypromptpatient2)
			   parent.frames[1].document.dummypromptpatient2.submit();
			}else{
				if((parent.frames[0].document.forms[0].alt_id1_no.value == "") && (parent.frames[0].document.forms[0].patient_id.disabled !=  true))
				{
					var error = getMessage('CAN_NOT_BE_BLANK','Common');
					error = error.replace('$','Patient ID');
					alert(error);
					if(parent.frames[0].document.forms[0].patient_id.disabled != true){
					parent.frames[0].document.forms[0].patient_id.focus();
				}
			}
		}
	}
	else if (flag=="R")
     {
		   var patient_id_regd = await show_patient_registration();
		  
			 if(patient_id_regd != null)
                {
					var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dummypromptpatient3' id='dummypromptpatient3' method='post' action='../../eMP/jsp/PatReferralValidation.jsp'><input type='hidden' name='list_name' id='list_name' value='register'><input type='hidden' name='prompt_patient_id' id='prompt_patient_id' value='"+patient_id_regd+"'><input type='hidden' name='q_clinic_code' id='q_clinic_code' value='"+q_clinic_code+"'><input type='hidden' name='q_appt_ref_no' id='q_appt_ref_no' value='"+q_appt_ref_no+"'><input type='hidden' name='p_referral_id' id='p_referral_id' value='"+p_referral_id+"'><input type='hidden' name='func_act' id='func_act' value='"+func_act+"'><input type='hidden' name='fromchk' id='fromchk' value='N'><input type='hidden' name='q_booking_type' id='q_booking_type' value='"+q_booking_type+"'><input type='hidden' name='from_PatIDF1' id='from_PatIDF1' value='false'><input type='hidden' name='function_id' id='function_id' value='"+function_id+"'>";
					HTMLVal = HTMLVal+"</form></body></html>";
					parent.frames[1].document.write(HTMLVal);
					parent.frames[1].document.dummypromptpatient3.submit();
				}
         }
         else
              {
					var Unregpatbkgyn = document.forms[0].Unregpatbkgyn.value;
					var calledFrom = document.forms[0].calledFrom.value;
					if(calledFrom == 'Booking')
					{
						if(Unregpatbkgyn == "Y")
							parent.window.returnValue=p_referral_id;
					}
					else
						parent.window.returnValue="C";
					
					parent.window.close();
                }
  }
   
async function show_patient_registration()
   {
	  var q_appt_ref_no=document.forms[0].q_appt_ref_no.value;
      var q_booking_ref_no= document.forms[0].q_booking_ref_no.value;
	  var p_referral_id= document.forms[0].p_referral_id.value;
	  var func_act= document.forms[0].func_act.value;
	  var q_booking_type= document.forms[0].q_booking_type.value;
	   var retVal =  new String();
	   var dialogTop= "72";
	   var dialogHeight= "90vh" ;
	   var dialogWidth = "80vw" ;
	   /*Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601 Start*/
	   var isAlternateAddressAppl = document.forms[0].isAlternateAddressAppl.value;
	   var isAddressLengthIncAppl = document.forms[0].isAddressLengthIncAppl.value;
	   if(isAlternateAddressAppl == "true" || isAddressLengthIncAppl == "true")
			dialogWidth = "80vw" ;
	   /*End*/
	   var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	   var arguments = "" ;
	  // alert('q_booking_type:'+q_booking_type)
	   retVal = await top.window.showModalDialog("../../eMP/jsp/PatientRegistrationMain.jsp?module_id=MP&function_id=PAT_REG&function_name=Register%20Patient&function_type=F&access=NYNNN&home_required_yn=N&appt_ref_no="+q_appt_ref_no+"&booking_ref_no="+q_booking_ref_no+"&p_referral_id="+p_referral_id+"&func_act="+func_act+"&q_booking_type="+q_booking_type+"&title="+encodeURIComponent(getLabel('eMP.RegisterPatient.label','MP')),arguments,features);
		if( retVal != null )
		{			
		   retVal = 'Y'+retVal;
		   parent.window.returnValue=retVal;
		   parent.window.close();				  
		 } 
 }  
 
 function closing()
{		
		var Unregpatbkgyn = document.forms[0].Unregpatbkgyn.value;
		var calledFrom = document.forms[0].calledFrom.value;
		var p_referral_id= parent.frames[0].document.forms[0].p_referral_id.value;
		if(calledFrom == 'Booking')
		{
			if(Unregpatbkgyn == "Y")
				parent.window.returnValue=p_referral_id;
		}
		if (parent.window.returnValue == null)
		{	
			parent.window.returnValue='C';
		}
		parent.window.close();
}
//below lines added by Venkatesh.S (4008) on 28-April-2012 againist RUT-CRF-0060 [IN029598]
function moveOnMax1(field)
{
if(field.value.length>=field.maxLength && field !=null && field.id=='barcode')
{
document.getElementById("ok").click();

}
}
//end  RUT-CRF-0060 [IN029598]
</script>

        <%
			request.setCharacterEncoding("UTF-8");

            String gen_file_yn      = request.getParameter("gen_file_yn");
			if(gen_file_yn==null) gen_file_yn="";
            String q_clinic_code    = request.getParameter("q_clinic_code");
			if(q_clinic_code==null) q_clinic_code="";
            String q_appt_ref_no    = request.getParameter("q_appt_ref_no");
			if(q_appt_ref_no==null) q_appt_ref_no="";
			
            String q_from_funct     = request.getParameter("q_from_funct")==null?"":request.getParameter("q_from_funct"); 
            String q_booking_ref_no = request.getParameter("q_booking_ref_no")==null?"":request.getParameter("q_booking_ref_no");
			String q_booking_type = request.getParameter("q_booking_type")==null?"":request.getParameter("q_booking_type");
 
            String p_referral_id    = request.getParameter("p_referral_id")==null?"":request.getParameter("p_referral_id"); 
			
            String func_act         = request.getParameter("func_act")==null?"":request.getParameter("func_act"); 
			String calledFrom         = request.getParameter("calledFrom");
			if(calledFrom==null) calledFrom =""; 
			
			String Unregpatbkgyn         = request.getParameter("Unregpatbkgyn");
			if(Unregpatbkgyn==null) Unregpatbkgyn ="N"; 
		
            String fromVR = request.getParameter("fromVR")==null?"":request.getParameter("fromVR");
            String facility_id       = (String) session.getValue("facility_id");
			if(facility_id==null) facility_id="";
            String oper_stn_id     = request.getParameter("oper_stn_id");
			if(oper_stn_id==null) oper_stn_id="";

			String function_id=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");
			
            String user_id         = (String) session.getValue("login_user");
			if(user_id==null) user_id="";
            if(fromVR == null)  fromVR= "" ;
			StringBuffer sql =new StringBuffer();

			Statement stmt = null ;
			ResultSet rset = null ;
			ResultSet rs=null;
			Connection con = null ;
			String locn_type = "";
			String register_pat_yn = "" ;
			//added code for PMG2014-HSA-CRF-0001 [IN:050020]
			String alt_id1_type_desc="";
			String alt_id2_type_desc="";
			String alt_id3_type_desc="";
			String alt_id4_type_desc="";
			String alt_id1_type="";
			String alt_id2_type="";
			String alt_id3_type="";
			String alt_id4_type="";
			String customer_id="";
			String patient_id_length="";
			String alt_id1_length="";
			String accept_oth_alt_id_yn="";
			String accept_national_id_no_yn="";
			String nat_id_prompt="";
			
			//Below line Added for HSA-CRF-0298
			String alt_id2_length="",alt_id3_length="",alt_id4_length="";
			boolean isAlternateId=false;
			PreparedStatement pstmt=null;
			
			boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601
			boolean isAddressLengthIncAppl = false;//Added by Thamizh selvi on 13th Feb 2018 against ML-MMOH-CRF-0860.2

            if (q_booking_ref_no.equals(""))
			{
				/* Added on 23/04/2003 by Mallikarjuna Reddy for disabling or enabling the Register Patient Button */
				if (p_referral_id.equals(""))
				{
					sql.append("select clinic_type from op_clinic where facility_id='"+facility_id+"' and clinic_code='"+ q_clinic_code +"'");

				}
				else
				{
					sql.append("select to_locn_type, to_locn_code from pr_referral_register where referral_id = '"+p_referral_id+"'");
				}
				/* End of the Addition on 23/04/2003 by Mallikarjuna Reddy for disabling or enabling the Register Patient Button */
			}
            else{
				sql.append("select b.locn_type,a.nursing_unit_code  from ip_booking_list a, ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id='"+facility_id+"' and a.bkg_lst_ref_no='"+ q_booking_ref_no +"'");
			}
 
            try
            {
            con = ConnectionManager.getConnection(request);
			isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601
			isAddressLengthIncAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");//Added by Thamizh selvi on 13th Feb 2018 against ML-MMOH-CRF-0860.2
			isAlternateId = CommonBean.isSiteSpecific(con,"MP","ALTERNATE_ID_LOOKUP");//Added for this CRF HSA-CRF-0298
            stmt = con.createStatement() ;
			
            rset = stmt.executeQuery(sql.toString());

			sql.setLength(0);
			
			if(!calledFrom.equals("Booking"))
			{
            if (q_booking_ref_no.equals("")){
				/* Added on 23/04/2003 by Mallikarjuna Reddy for disabling or enabling the Register Patient Button */
	            if (p_referral_id.equals(""))
				{
					if(rset.next()) locn_type = rset.getString(1) ;

					if(rset != null) rset.close();

					if (!q_appt_ref_no.equals(""))
					{
						sql.append(" select NVL(register_pat_yn, 'N') from am_os_user_locn_access_Vw where facility_id = '"+facility_id+"' and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
						sql.append("and appl_user_id = '"+user_id+"'  and locn_type = '"+locn_type+"' and locn_code = '"+q_clinic_code+"' ");  
					}
					else
					{
						sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_os_user_locn_access_Vw  where facility_id = '"+facility_id+"'  and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
						sql.append(" and appl_user_id = '"+user_id+"'");  
					}
				}
				else
				{
					String nursing_unit_code="";
					String nursing_unit_type="";
					if(rset!=null && rset.next())
						{
						nursing_unit_type = rset.getString(1) ;
						
						nursing_unit_code = rset.getString(2) ;
						
						if (nursing_unit_type==null) nursing_unit_type="";
						if (nursing_unit_code==null) nursing_unit_code="";
					    }

					if(rset != null) rset.close();
					
					if (calledFrom.equals("IP"))
					{
						if (!nursing_unit_code.equals("")){
								
								sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_os_user_locn_access_Vw  where facility_id = '"+facility_id+"' and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
								sql.append(" and appl_user_id = '"+user_id+"'  and locn_type = '"+nursing_unit_type+"' and locn_code = '"+nursing_unit_code+"' ");
								
							}
						else{
								sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_oper_stn  where facility_id = '"+facility_id+"' and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )" ); 
							}
					}
					else
					{
						sql.append(" select NVL(register_pat_yn, 'N') from am_os_user_locn_access_Vw  where facility_id = '"+facility_id+"'  and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
						sql.append(" and appl_user_id = '"+user_id+"' ");
							
					}
				}

		        rset = stmt.executeQuery(sql.toString());
			    if(rset.next()) register_pat_yn = (rset.getString(1).equals("Y") ? "" : "disabled" ) ;

				if(rset != null) rset.close();
				/* End of the Addition on 23/04/2003 by Mallikarjuna Reddy for disabling or enabling the Register Patient Button */
			}
			else{
                String nursing_unit_code="";
				String nursing_unit_type="";
				if(rset!=null && rset.next()){
					nursing_unit_type = rset.getString(1) ;
					
					nursing_unit_code = rset.getString(2) ;
					
				}

				if(rset != null) rset.close();

				if (!nursing_unit_code.equals("")){
						sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_os_user_locn_access_Vw  where facility_id = '"+facility_id+"'  and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )  ");
						sql.append(" and appl_user_id = '"+user_id+"' and locn_type = '"+nursing_unit_type+"' and locn_code = '"+nursing_unit_code+"' ");
					}
				else{
						sql.append(" select NVL(register_pat_in_admn_yn, 'N') from am_oper_stn  where facility_id = '"+facility_id+"' and oper_stn_id = ( select oper_stn_id from am_user_for_oper_stn where facility_id='"+facility_id+"' and appl_user_id='"+user_id+"' and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate)) )");

				}      

		        rset = stmt.executeQuery(sql.toString());
			    if(rset.next()) register_pat_yn = (rset.getString(1).equals("Y") ? "" : "disabled" ) ;
				
				if(rset != null) rset.close();
			}
			
			}
			sql.setLength(0);
    %>
	</head>
    <body onUnload='closing();' onLoad='FocusFirstElement();' class='content' topmargin='0' bottommargin='0' onKeyDown ='lockKey()'>
        <form name='propmtpatientid' id='propmtpatientid' method='post'>
		<input type='hidden' name='isAlternateId' id='isAlternateId' value='<%=isAlternateId%>'>	
        <br>
			<table width='97%' cellpadding="2" cellspacing="0" align="center" >
                <%//added code for PMG2014-HSA-CRF-0001 [IN:050020]
                    rs = stmt.executeQuery("select alt_id1_reqd_yn,alt_id1_type,alt_id2_type,alt_id3_type,alt_id4_type,alt_id2_length,alt_id3_length,alt_id4_length,accept_oth_alt_id_yn,accept_national_id_no_yn,alt_id1_length,nat_id_prompt,mp_get_desc.mp_alternate_id_type (alt_id1_type,'en','1')alt_id1_type_desc,mp_get_desc.mp_alternate_id_type (alt_id2_type,'en','1')alt_id2_type_desc,mp_get_desc.mp_alternate_id_type (alt_id3_type,'en','1')alt_id3_type_desc,mp_get_desc.mp_alternate_id_type (alt_id4_type,'en','1')alt_id4_type_desc,patient_id_length,b.customer_id from mp_param, SM_SITE_PARAM b") ;
                    
                if(rs != null)
					{   
                    if(rs.next()) {
                   
                   alt_id1_type_desc=rs.getString("alt_id1_type_desc")==null?"":rs.getString("alt_id1_type_desc");
                   alt_id2_type_desc=rs.getString("alt_id2_type_desc")==null?"":rs.getString("alt_id2_type_desc");
                   alt_id3_type_desc=rs.getString("alt_id3_type_desc")==null?"":rs.getString("alt_id3_type_desc");
                   alt_id4_type_desc=rs.getString("alt_id4_type_desc")==null?"":rs.getString("alt_id4_type_desc");
                   nat_id_prompt=rs.getString("nat_id_prompt")==null?"":rs.getString("nat_id_prompt");
				   customer_id=rs.getString("customer_id")==null?"":rs.getString("customer_id");
				   alt_id1_type=rs.getString("alt_id1_type")==null?"":rs.getString("alt_id1_type");
				   patient_id_length=rs.getString("patient_id_length")==null?"":rs.getString("patient_id_length");
				   alt_id1_length=rs.getString("alt_id1_length")==null?"":rs.getString("alt_id1_length");
				   accept_oth_alt_id_yn=rs.getString("accept_oth_alt_id_yn")==null?"N":rs.getString("accept_oth_alt_id_yn");
				   accept_national_id_no_yn=rs.getString("accept_national_id_no_yn")==null?"N":rs.getString("accept_national_id_no_yn");				  
				   //Added for this CRF HSA-CRF-0298
				   alt_id2_type=rs.getString("alt_id2_type")==null?"":rs.getString("alt_id2_type");
				   alt_id3_type=rs.getString("alt_id3_type")==null?"":rs.getString("alt_id3_type");
				   alt_id4_type=rs.getString("alt_id4_type")==null?"":rs.getString("alt_id4_type");
				   alt_id2_length=rs.getString("alt_id2_length")==null?"":rs.getString("alt_id2_length");
				   alt_id3_length=rs.getString("alt_id3_length")==null?"":rs.getString("alt_id3_length");
				   alt_id4_length=rs.getString("alt_id4_length")==null?"":rs.getString("alt_id4_length");				   
				   //End this CRF HSA-CRF-0298
				  
                    }
					}
                    %>
                    <tr>
                        <td class='label' width='20%' nowrap>
                            <fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
							<!--Below line was added by venkatesh.S (4008) on 10-Oct-2012 aginst  ML-BRU-SCF-0336 [IN:034501]-->
							<%if(customer_id.equals("RTN")){%>
                        <td width='30%'  colspan='3' nowrap class='fields'>
                            <!--below lines modified by Venkatesh.S (4008) on 28-April-2012 againist RUT-CRF-0060 [IN029598] -->
                             <input type="text" id='barcode' name="patient_id" id="patient_id" size='<%=patient_id_length%>' maxlength='<%=patient_id_length%>'  onblur='ChangeUpperCase(this);' onChange="if(check_patient_id()){document.forms[0].alt_id1_no.disabled=true;document.forms[0].search1.disabled=true;}"  onKeyPress="return CheckForSpecChars(event)" onkeyup="moveOnMax1(this);"> <!--Rameez Added 'onKeyPress' for ML-BRU-SCF-0483 [IN35430] on 28-09-2012-->
							 <!--end  RUT-CRF-0060 [IN029598] -->
							 
							 <input type='button' class='button' value='?' name='search' id='search' onClick="getPatientID(this)" >
							 <img src='../../eCommon/images/mandatory.gif'></img>
					   </td>
                        <%}else{%>
						 <td width='30%'  colspan='3' nowrap class='fields'>
                            <input type="text" name="patient_id" id="patient_id" size='<%=patient_id_length%>' maxlength='<%=patient_id_length%>'  onblur='ChangeUpperCase(this);' onChange="ChangeUpperCase(this);if(check_patient_id()){document.forms[0].alt_id1_no.disabled=true;document.forms[0].search1.disabled=true;}" onKeyPress="return CheckForSpecChars(event)" ><!--Rameez Added 'onKeyPress' for ML-BRU-SCF-0483 [IN35430] on 28-09-2012--><input type='button' class='button' value='?' name='search' id='search' onClick="getPatientID(this)" ><img src='../../eCommon/images/mandatory.gif'></img>
					   </td>
						<%}%>
						<!--end SCF ML-BRU-SCF-0336 [IN:034501] -->
                        <%--
							if(rs.getString("alt_id1_type")!=null)
                            {
							   pstmt=con.prepareStatement("select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE='"+rs.getString("alt_id1_type")+"' and language_id = '"+locale+"'"); 
							   rset=pstmt.executeQuery();
							   if(rset != null)
								{
								   if(rset.next())
									{
									  alt_id_type_desc=rset.getString(1);
									  if(alt_id_type_desc == null) alt_id_type_desc="";
									}
								}
							  if(rset != null) rset.close();
							  if(pstmt != null) pstmt.close();}
                        --%><% 
                        if(alt_id1_type_desc !="")
                            {
							%>
                                <td  class='label' width='20%' nowrap><%=alt_id1_type_desc%></td>
                                <td width='35%' colspan='2' class='fields'>
                                    <input type="text" name="alt_id1_no" id="alt_id1_no" size='<%=alt_id1_length%>' maxlength='<%=alt_id1_length%>' onChange="if(document.forms[0].isAlternateId&&document.forms[0].isAlternateId.value=='true'){makeRequest(this);if(parseInt(document.forms[0].isAlternateIdCount.value)<2){if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}}else {if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}" onblur=''><input type='button' class='button' value='?' name='search1' id='search1' onClick="getPatientID(this)" >&nbsp;&nbsp;
                                 </td>
                        <%}%>
                    </tr>
                    </table>
                     <!--added code for PMG2014-HSA-CRF-0001 [IN:050020]  -->
					 <!--Below line added for this CRF HSA-CRF-0298 -->
                    <table width='97%' cellpadding="2" cellspacing="0" align="center" height='25%'>
                   <tr>
                    <%if(alt_id2_type_desc!="" && !isAlternateId) {%>                           
                               <td class='LABEL'  width='20%' ><%=alt_id2_type_desc%> </td>
					           <td width='30%' colspan=3 name='alt_id2_no' id='alt_id2_no'  class='data'> </td>                                
                        <%}else if(alt_id2_type_desc!="" && isAlternateId) {%>                           
                               <td class='LABEL'  width='20%' ><%=alt_id2_type_desc%> </td>
					           <td width='30%' colspan='2' class='fields'>
							    <input type="text" name='alt_id2_no' id='alt_id2_no' size='<%=alt_id2_length%>' maxlength='<%=alt_id2_length%>'onChange="makeRequest(this);if(parseInt(document.forms[0].isAlternateIdCount.value)<2){if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}" onblur=''><input type='button' class='button' value='?' name='search2' id='search2' onClick="getPatientID(this)" >&nbsp;&nbsp; </td>
                        <%}else {  %>
						  <td class='LABEL'  width='20%' >&nbsp;</td>
						  <td class='data' width='30%'  colspan=3 colspan=3> &nbsp;</td>
			              <% } 
						if(alt_id3_type_desc !="" && !isAlternateId){%>                            
                                <td  class='label' width='20%' nowrap><%=alt_id3_type_desc%></td>
                                <td width='35%' colspan=2 name='alt_id3_no' id='alt_id3_no'class='data'></td>
                        <%}else if(alt_id3_type_desc!="" && isAlternateId) {%>                           
                               <td class='LABEL'  width='20%' ><%=alt_id3_type_desc%> </td>
					           <td width='30%' colspan='2' class='fields'>  
							   <input type="text" name='alt_id3_no' id='alt_id3_no' size='<%=alt_id3_length%>' maxlength='<%=alt_id3_length%>' onChange="makeRequest(this);if(parseInt(document.forms[0].isAlternateIdCount.value)<2){if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}" onblur=''><input type='button' class='button' value='?' name='search3' id='search3' onClick="getPatientID(this)" >&nbsp;&nbsp; </td>
                        <%}else {  %>
						  <td class='LABEL'  width='20%' >&nbsp;</td>
						  <td class='data' colspan=2  width='30%' colspan=3> &nbsp;</td>
			              <% } %>
                    </tr>
                     <tr>
                     <% if(alt_id4_type_desc !=""&& !isAlternateId){%>                            
                                <td  class='label' width='20%' nowrap><%=alt_id4_type_desc%></td>
                                <td width='30%' colspan=3 name='alt_id4_no' id='alt_id4_no'  class='data'></td>
                        <%}else if(alt_id4_type_desc!="" && isAlternateId) {%>                           
                               <td class='LABEL'  width='20%' ><%=alt_id4_type_desc%> </td>
					           <td width='30%' colspan='2' class='fields'>  
							   <input type="text" name='alt_id4_no' id='alt_id4_no' size='<%=alt_id4_length%>' maxlength='<%=alt_id4_length%>' onChange="makeRequest(this);if(parseInt(document.forms[0].isAlternateIdCount.value)<2){if(check_patient_id(this)){document.forms[0].patient_id.disabled=true;document.forms[0].search.disabled=true;}}" onblur=''><input type='button' class='button' value='?' name='search4' id='search4' onClick="getPatientID(this)" >&nbsp;&nbsp; </td>
                        <%}else {%>
						  <td class='LABEL'  width='20%' >&nbsp;</td>
						  <td class='data' colspan=3  width='30%' colspan=3> &nbsp;</td>
			              <%} //End this CRF HSA-CRF-0298 
						  if(!isAlternateId){
						  if(accept_national_id_no_yn.equals("Y")){
						    if(nat_id_prompt !=""){%>
                        
                        <td  class='label' width='20%' nowrap><%=nat_id_prompt%></td>
                        <td width='35%' colspan=2 name='nat_id_prompt_no' id='nat_id_prompt_no' class='data'></td>
                          <%}}else {  %>
						  <td class='LABEL'  width='20%' >&nbsp;</td>
						  <td class='data' colspan=2  width='30%' colspan=3> &nbsp;</td>
			              <% }} 
						   if(isAlternateId){
						   if(accept_oth_alt_id_yn.equals("Y")){%> 						   
						    <td  class='label' width='20%' name='oth_alt_id' id='oth_alt_id'  nowrap><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></td>
                            <td width='30%' colspan=2  name='oth_alt_id_no' id='oth_alt_id_no' class='data'></td>
                      <%}else {  %>
						  <td class='LABEL'  width='20%' >&nbsp;</td>
						  <td class='data' colspan=2  width='30%' colspan=3> &nbsp;</td>
			              <% }}%>
						 
                     </tr>
                     <tr>
                     <%if(!isAlternateId){
					 if(accept_oth_alt_id_yn.equals("Y")){%>
                     <td  class='label' width='20%' name='oth_alt_id' id='oth_alt_id'  nowrap></td>
                     <td width='30%' colspan=3 name='oth_alt_id_no' id='oth_alt_id_no' class='data'></td>
                      <%}else {  %>
						  <td class='LABEL'  width='20%' >&nbsp;</td>
						  <td class='data' colspan=2  width='30%' colspan=3> &nbsp;</td>
			              <% }}%>
						 
                    </tr>
					</table>
                    <!-- end code for PMG2014-HSA-CRF-0001 [IN:050020] -->
					  <table width='97%' cellpadding="2" cellspacing="0" align="center" height='40%'>
					  <tr>
					  <%if(isAlternateId){ 
						 if(accept_national_id_no_yn.equals("Y")){
						    if(nat_id_prompt !=""){%>                        
                        <td  class='label' width='20%' nowrap><%=nat_id_prompt%></td>
                        <td width='35%' colspan=6 name='nat_id_prompt_no' id='nat_id_prompt_no' class='data'></td>
                          <%}}else {  %>
						  <td class='LABEL'  width='20%' >&nbsp;</td>
						  <td class='data' colspan=6  width='30%' colspan=3> &nbsp;</td>
			              <% } 
						 }%>
						 </tr>
					<tr>
                        <td class='label' width='20%' nowrap>
                            <fmt:message key="Common.name.label" bundle="${common_labels}"/>
                        </td>
                        <td width='30%' colspan=6 name='patient_name' id='patient_name' class='data'>
                        </td>
                    </tr>
					
			      <tr>
                        <td class='label' width='20%' >
                            <fmt:message key="Common.age.label" bundle="${common_labels}"/>
                        </td>
                        <td width='30%' id='years' class='data'>
                        </td>
                        <td class='label' width='2%' nowrap><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
                        <td width='10%'  id='months' class='data' align='center'>
                        </td>
                        <td class='label' width='3%' nowrap><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
                        <td width='10%'  id='days' class='data' align='center'>
                        </td>
                        <td class='label' width='15%' nowrap><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
                    </tr>
                <!--*** Changed on 18 May 2001 the sex and DOB labels were interchanged *** --> 
                  <tr>
                        <td class='label' width='20%' nowrap>
                            <fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>
                        </td>
                        <td width='30%' colspan='6'  id='date_of_birth_greg' class='data'></td>
						<input type='hidden' name='date_of_birth' id='date_of_birth' value=''>
                    </tr>
                 
                    <tr>
                        <td class='label' width='20%' nowrap>
                            <fmt:message key="Common.gender.label" bundle="${common_labels}"/>
                        </td>
                        <td width='30%' colspan='6'  id='sex' class='data'>
                    </td>
                    </tr>
                    <tr>
                        <td class='label' width='20%' nowrap>
                            <fmt:message key="Common.nationality.label" bundle="${common_labels}"/>
                        </td>
						<td width='30%' colspan='6' id='nationality' class='data'></td>
                    </tr>
                </table>
                <br>
                <table cellpadding="0" cellspacing="0"  width='97%' align='center' height='5%'>
                    <tr>
                        <td  align='center'><input type="button" name="ok" id="ok" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick="ButtonClick('O');" class="button" ><input type="button" name="cancel" id="cancel"      value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick="ButtonClick('C');" class="button"><input type="button" name="register" id="register"   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RegisterPatient.label","mp_labels")%>'   onClick="ButtonClick('R');" class="button" <%=register_pat_yn%>>
                        </td>
                    </tr>
                </table>
			
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
            <input type="hidden" name="valid_patient_id" id="valid_patient_id" value="">
			<input type="hidden" name="Unregpatbkgyn" id="Unregpatbkgyn" value="<%=Unregpatbkgyn%>">
		    <input type='hidden' name='q_clinic_code' id='q_clinic_code' value='<%=q_clinic_code%>'>
			<input type='hidden' name='q_appt_ref_no' id='q_appt_ref_no' value='<%=q_appt_ref_no%>'>
			<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
		    <input type='hidden' name='calledFrom' id='calledFrom' value='<%=calledFrom%>'>
			<input type='hidden' name='q_from_funct' id='q_from_funct' value='<%=q_from_funct%>'>
			<input type='hidden' name='q_booking_ref_no' id='q_booking_ref_no' value='<%=q_booking_ref_no%>'>
			<input type='hidden' name='p_referral_id' id='p_referral_id' value='<%=p_referral_id%>'>
			<input type='hidden' name='func_act' id='func_act' value='<%=func_act%>'>
			<input type='hidden' name='fromVR' id='fromVR' value='<%=fromVR%>'>
			<input type='hidden' name='q_booking_type' id='q_booking_type' value='<%=q_booking_type%>'>
			<input type='hidden' name='alt_id_type' id='alt_id_type' value='<%=alt_id1_type%>'>
			<!--Added for this CRF HSA-CRF-0289 -->
			<input type='hidden' name='alt_id2_type' id='alt_id2_type' value='<%=alt_id2_type%>'>
			<input type='hidden' name='alt_id3_type' id='alt_id3_type' value='<%=alt_id3_type%>'>
			<input type='hidden' name='alt_id4_type' id='alt_id4_type' value='<%=alt_id4_type%>'>
					
			<input type='hidden' name='isAlternateIdCount' id='isAlternateIdCount' value=''> 
			<input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value="<%=isAlternateAddressAppl%>"><!--Added by Thamizh selvi on 12th Feb 2018 against ML-MMOH-CRF-0601-->
			<input type='hidden' name='isAddressLengthIncAppl' id='isAddressLengthIncAppl' value="<%=isAddressLengthIncAppl%>"><!--Added by Thamizh selvi on 13th Feb 2018 against ML-MMOH-CRF-0860.2-->
        </form>
    </body>
    <%
        }
        catch(Exception e){out.println(e);}
        finally
        {
			try{
			if(rs!=null)rs.close();
			if(rset != null)    rset.close() ;
            if(stmt != null)    stmt.close() ;
			}catch(Exception e){}
            
			if(con!=null) ConnectionManager.returnConnection(con,request);
        }
    %>
</html>

