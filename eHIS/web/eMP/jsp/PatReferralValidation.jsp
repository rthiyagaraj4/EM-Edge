<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.io.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
		<%
      String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
      request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	    async function callConfirmBilling()
		{	
			var retVal;
			var dialogHeight= "9" ;
			var dialogWidth	= "22" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
			retVal =await window.showModalDialog("../../eBL/jsp/BLBillingGroupConfirm.jsp",arguments,features);
			return retVal;
		}

		function get_message_text(message,modid,prompt)
		{

			var message_text;
				message_text = getMessage(message,modid);
			return message_text;
			
		}

	</script>
	</head>
	<body class='MESSAGE' onKeyDown = 'lockKey();'>			
	  <form method=post action="">

	<%

		Connection con = null;	
		PreparedStatement pstmt=null;
    	java.sql.Statement stmt1 =null;
		ResultSet rs = null;
		String sql ="";
        boolean isAlternateId=false;//Added for this CRF HSA-CRF-0298		
			
		String loginfacility = (String) session.getValue("facility_id");
		try{
			
			  con = ConnectionManager.getConnection(request);
			  isAlternateId = CommonBean.isSiteSpecific(con,"MP","ALTERNATE_ID_LOOKUP");//Added for this CRF HSA-CRF-0298

			  char alert_yn = 'Y';
              char merged_yn = 'N';
			  String continue_yn = "Y";
			  String valid_patient_id = "";
			  String warning_text = "";
			  String HcExpired = "N";  
			  String prompt_patient_id =request.getParameter("prompt_patient_id");
			  String list_name =request.getParameter("list_name");
			  String p_referral_id  =request.getParameter("p_referral_id");
              if(p_referral_id == null)  p_referral_id = "";

			  String pat_id = request.getParameter("prompt_patient_id");
			  if(pat_id==null)
				  pat_id="";
			  String bl_install_yn=(String)session.getValue("bl_operational");
				if(bl_install_yn == null) bl_install_yn="";
              out.println("<script>");

			// if(request.getParameter("alt_id1_no") != null)	{
			//Above line added and below line added for this CRF HSA-CRF-0298
			 if(request.getParameter("alt_id1_no") != null || request.getParameter("alt_id2_no") != null || request.getParameter("alt_id3_no") != null || request.getParameter("alt_id4_no") != null)	{ 
					 //String alt_id_type=request.getParameter("alt_id_type");
					 //Above line commented and below line for this CRF this CRF HSA-CRF-0298
					  String alt_id_type_desc="",alt_id_type="",patientidQuery="";
					 
 					  String alt_id1_type=request.getParameter("alt_id_type")==null?"":request.getParameter("alt_id_type");
					  String alt_id2_type=request.getParameter("alt_id2_type")==null?"":request.getParameter("alt_id2_type");
					  String alt_id3_type=request.getParameter("alt_id3_type")==null?"":request.getParameter("alt_id3_type");
					  String alt_id4_type=request.getParameter("alt_id4_type")==null?"":request.getParameter("alt_id4_type");
					  if(!alt_id1_type.equals("")){
					     alt_id_type=alt_id1_type;
				      }else if(!alt_id2_type.equals("")){
					     alt_id_type=alt_id2_type;
                      }else if(!alt_id3_type.equals("")){
					     alt_id_type=alt_id3_type;
                      }else if(!alt_id4_type.equals("")){
					     alt_id_type=alt_id4_type;
                      } 
                      String alt_id1_no=request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");	
                      String alt_id2_no=request.getParameter("alt_id2_no")==null?"":request.getParameter("alt_id2_no");
                      String alt_id3_no=request.getParameter("alt_id3_no")==null?"":request.getParameter("alt_id3_no");	
                      String alt_id4_no=request.getParameter("alt_id4_no")==null?"":request.getParameter("alt_id4_no"); 
                      if(!alt_id1_no.equals("")){
					       patientidQuery="select patient_id from mp_patient where alt_id1_no='"+alt_id1_no+"'";
					  }else if(!alt_id2_no.equals("")){
					       patientidQuery="select patient_id from mp_patient where alt_id2_no='"+alt_id2_no+"'";
					  }else if(!alt_id3_no.equals("")){
					       patientidQuery="select patient_id from mp_patient where alt_id3_no='"+alt_id3_no+"'";  
					  }else if(!alt_id4_no.equals("")){
					       patientidQuery="select patient_id from mp_patient where alt_id4_no='"+alt_id4_no+"'";
					  }                      					  
					
					//End this CRF HSA-CRF-0298

					java.sql.Statement stmt2 = con.createStatement() ;
					if(alt_id_type != null || !alt_id_type.equals(""))
					{
					rs=stmt2.executeQuery("select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE='"+alt_id_type+"' and language_id='"+localeName+"'");
					  if(rs != null)
						{
						   if(rs.next())
								{
								  alt_id_type_desc=rs.getString(1);
								  if(alt_id_type_desc == null) alt_id_type_desc="";
								}
						}
					 if(rs != null) rs.close();

					}					  
					//rs = stmt2.executeQuery("select patient_id from mp_patient where alt_id1_no ='"+request.getParameter("alt_id1_no")+"'") ;
					rs = stmt2.executeQuery(patientidQuery);
					if(rs!=null && rs.next()){
						prompt_patient_id = rs.getString(1) ;

					}
					else
					{					
						//if(!request.getParameter("alt_id1_no").equals(""))
						//Above line commented and below line added for this CRF HSA-CRF-0289
						 if(request.getParameter("alt_id1_no") != null || request.getParameter("alt_id2_no") != null || request.getParameter("alt_id3_no") != null || request.getParameter("alt_id4_no") != null)
						  out.println("var val1 = getMessage('INVALID_ALT_ID','MP'); val1 = val1.replace('$','"+alt_id_type_desc+"'); alert(val1);");
						alert_yn='N';
					  prompt_patient_id= "";
					  out.println("parent.frames[0].document.forms[0].patient_id.value='';");
					  out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
					  out.println("parent.frames[0].document.getElementById('years').innerText='';");
					  out.println("parent.frames[0].document.getElementById('months').innerText='';");
					  out.println("parent.frames[0].document.getElementById('days').innerText='';");
					  out.println("parent.frames[0].document.getElementById('sex').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
					  out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
					  out.println("if(parent.frames[0].document.forms[0].alt_id1_no)"); 
					  out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';");
					  //Below line modified For this CRF HSA-CRF-0289
			          if(isAlternateId){
					   out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					   out.println("parent.frames[0].document.getElementById('alt_id2_no').value='';");
					   out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					   out.println("parent.frames[0].document.getElementById('alt_id3_no').value='';");
					   out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					   out.println("parent.frames[0].document.getElementById('alt_id4_no').value='';");	
                       out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					   out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");	
                       out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					   out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"';");						   
					  }else{
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");
					  }
					  //End this CRF  HSA-CRF-0289
					  
					  out.println("if(parent.frames[0].document.getElementById('nat_id_prompt_no'))");
					  out.println("parent.frames[0].document.getElementById('nat_id_prompt_no').innerHTML='';");
					  
						//out.println("cont = 'N'");
					}
                     if(!prompt_patient_id.equals(""))
                          pat_id=prompt_patient_id;

					if(rs != null) rs.close();
					if(stmt2 != null) stmt2.close();
				}
			String pat_status = "";
			  String in_pat_status = "";
			  String alt_status = "";      
			  //String file_status= "";
			  String prompt = "";


		if(!pat_id.equals(""))
			{
              webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
			  patdata.setFacility_id(loginfacility);
			  pat_status = patdata.CheckStatus(con,pat_id);
			  in_pat_status = patdata.CheckInPatient(con,pat_id,loginfacility);
			  alt_status = patdata.CheckAlternateId(con,pat_id,localeName);      
			  //file_status= patdata.CheckFileDetails(con,pat_id,loginfacility);
			}
			else{
			         out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
					  out.println("parent.frames[0].document.getElementById('years').innerText='';");
					  out.println("parent.frames[0].document.getElementById('months').innerText='';");
					  out.println("parent.frames[0].document.getElementById('days').innerText='';");
					  out.println("parent.frames[0].document.getElementById('sex').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
					  out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
					  out.println("if(parent.frames[0].document.forms[0].alt_id1_no)"); 
					  out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';");
					  //Below line modified For this CRF HSA-CRF-0289
			          if(isAlternateId){
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').value='';");	
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");	
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"';");						  
					  }else{
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='';");
					  }
					  //End CRF HSA-CRF-0289					  
					  
					  out.println("if(parent.frames[0].document.getElementById('nat_id_prompt_no'))");
					  out.println("parent.frames[0].document.getElementById('nat_id_prompt_no').innerHTML='';");
					  
			}
			  prompt = request.getParameter("prompt_patient_id");
			
			   if (pat_status.equals("SUSPENDED"))
				  {
					out.println("alert(get_message_text('PAT_SUSPENDED_NOT_ALLOWED','MP','"+prompt+"'));");
					alert_yn = 'N';  continue_yn = "N";
					valid_patient_id="";
				  }
			  else if (pat_status.equals("DECEASED"))
				  {
					out.println("alert(get_message_text('PAT_DECEASED_NOT_ALLOWED','MP','"+prompt+"'));");
					alert_yn = 'N';  continue_yn = "N";
					out.println("parent.frames[0].document.getElementById('patient_id').disabled=false;");
					out.println("parent.frames[0].document.getElementById('patient_id').value='';");
					valid_patient_id="";
					out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
					  out.println("parent.frames[0].document.getElementById('years').innerText='';");
					  out.println("parent.frames[0].document.getElementById('months').innerText='';");
					  out.println("parent.frames[0].document.getElementById('days').innerText='';");
					  out.println("parent.frames[0].document.getElementById('sex').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
					  out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
					   out.println("if(parent.frames[0].document.forms[0].alt_id1_no)"); 
					  out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';");
					  //Below line modified For this CRF HSA-CRF-0289
			          if(isAlternateId){
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').value='';");
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");	
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"';");						  
					  }else{					  
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='';");
					  }
					  //End HSA-CRF-0289
					  
					  out.println("if(parent.frames[0].document.getElementById('nat_id_prompt_no'))");
					  out.println("parent.frames[0].document.getElementById('nat_id_prompt_no').innerHTML='';");
					  
                  }
			else if (pat_status.equals("SECURED"))
				  {
					out.println("alert(get_message_text('SECURED_NOT_ALLOWED','COMMON','"+prompt+"'));");
					alert_yn = 'N';  continue_yn = "N";
					valid_patient_id="";
				 }
			else if (pat_status.equals("INACTIVE"))
				  {
					out.println("alert(get_message_text('PAT_INACTIVE_NOT_ALLOWED','MP','"+prompt+"'));");
					alert_yn = 'N';  continue_yn = "N";
				    out.println("parent.frames[0].document.getElementById('patient_id').disabled=false;");
					out.println("parent.frames[0].document.getElementById('patient_id').value='';");
					out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
					  out.println("parent.frames[0].document.getElementById('years').innerText='';");
					  out.println("parent.frames[0].document.getElementById('months').innerText='';");
					  out.println("parent.frames[0].document.getElementById('days').innerText='';");
					  out.println("parent.frames[0].document.getElementById('sex').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
					  out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
					  out.println("if(parent.frames[0].document.forms[0].alt_id1_no)");
					  out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';");
					  //Below line modified For this CRF HSA-CRF-0289
			          if(isAlternateId){
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");	
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"';");						  
					  }else{					  
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='';");
					  }
					  //End HSA-CRF-0289	
					  out.println("if(parent.frames[0].document.getElementById('nat_id_prompt_no'))");
					  out.println("parent.frames[0].document.getElementById('nat_id_prompt_no').innerHTML='';");
					  
				  }
		    else if (pat_status.equals("INVALID_PATIENT") || alt_status.equals("INVALID_PATIENT"))
		          {
					out.println("alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));");
					alert_yn = 'N';  continue_yn = "N";
			 	    out.println("parent.frames[0].document.getElementById('patient_id').disabled=false;");
					out.println("parent.frames[0].document.getElementById('patient_id').value='';");
			        valid_patient_id="";
					  out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
					  out.println("parent.frames[0].document.getElementById('years').innerText='';");
					  out.println("parent.frames[0].document.getElementById('months').innerText='';");
					  out.println("parent.frames[0].document.getElementById('days').innerText='';");
					  out.println("parent.frames[0].document.getElementById('sex').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
					  out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
					  out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
					  out.println("if(parent.frames[0].document.forms[0].alt_id1_no)");
					  out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';");
					  //Below line modified For this CRF HSA-CRF-0289
			          if(isAlternateId){
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').value='';");
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");	
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"';");						  
					  }else{					  				  
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='';");
					  }
					  //End HSA-CRF-0289
					  
					  out.println("if(parent.frames[0].document.getElementById('nat_id_prompt_no'))");
					  out.println("parent.frames[0].document.getElementById('nat_id_prompt_no').innerHTML='';");
					  
					  
		         } 
		    else if (pat_status.equals("BLACKLISTED_PATIENT"))
			  {
				out.println("alert(get_message_text('BLACKLISTED_PATIENT','MP','"+prompt+"'));");
				alert_yn = 'N';  continue_yn = "N";
				valid_patient_id="";

			  }
		   else if (pat_status.indexOf("PATIENT_MERGED_VALID")>=0 )
			 {
				StringTokenizer token=new StringTokenizer(pat_status,"$");
				valid_patient_id = token.nextToken(); 
				valid_patient_id = token.nextToken();
				//alert_yn = 'N';  
			//	continue_yn = "N";
				alert_yn = 'Y';  
				continue_yn = "Y";
				merged_yn = 'Y';
				out.println("var msg = get_message_text('PATIENT_MERGED_VALID','MP','"+prompt+"')");
				out.println("msg = msg.replace('#','"+valid_patient_id+"');alert(msg);");
				prompt_patient_id=valid_patient_id;	out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
				  out.println("parent.frames[0].document.getElementById('years').innerText='';");
				  out.println("parent.frames[0].document.getElementById('months').innerText='';");
				  out.println("parent.frames[0].document.getElementById('days').innerText='';");
				  out.println("parent.frames[0].document.getElementById('sex').innerText='';");
				  out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
				  out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
				  out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
				 out.println("if(parent.frames[0].document.forms[0].alt_id1_no)");
					  out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';");
					  //Below line modified For this CRF HSA-CRF-0289
			          if(isAlternateId){
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').value='';");
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");	
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"';");					  
					  }else{
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='';");
					  }
					  //End HSA-CRF-0289
					 
					  out.println("if(parent.frames[0].document.getElementById('nat_id_prompt_no'))");
					  out.println("parent.frames[0].document.getElementById('nat_id_prompt_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");
				      out.println("parent.frames[0].document.getElementById('patient_id').value='"+valid_patient_id+"';");
				      out.println("parent.frames[0].document.getElementById('patient_id').focus();");
			 }
		  else if (pat_status != "")
			 {
				warning_text=warning_text+pat_status+ "<br>";
			 }
			if(alert_yn != 'N'){
			if(in_pat_status.equals("CURRENTLY_IN_PATIENT"))
					out.println("alert(get_message_text('CURRENTLY_IN_PATIENT','COMMON'));");
			}
      
	  char alt_stat = alert_yn ;
	  HcExpired = "N";
      if (alt_status.equals("alt_id1_expired")  && alt_stat != 'N')
	  {
			if(bl_install_yn.equals("Y"))
			{
				out.println("var returnVal = callConfirmBilling();  if(returnVal[0] == '1') setValue(); ");
			}
			else
			{
				stmt1 = con.createStatement() ;
				rs = stmt1.executeQuery("select alt_id1_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
				if(rs!=null){
				rs.next();
				out.println("var msg = get_message_text('ALT_ID_EXPIRED_CONFIRM','MP','"+prompt+"')");
				out.println("msg = msg.replace('$','"+rs.getString(1)+"'); var contyn = confirm(msg);  if(!contyn) setValue();");
				}

				if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
			}
			HcExpired = "Y";	
			alt_stat = 'N';
       }
       else if (alt_status.equals("alt_id2_expired") && alt_stat != 'N')
       {
        stmt1 = con.createStatement() ;
        rs = stmt1.executeQuery("select alt_id2_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
        if(rs!=null) {
			rs.next();
        out.println("var msg = get_message_text('ALT_ID_EXPIRED','MP','"+prompt+"')");
        out.println("msg = msg.replace('$','"+rs.getString(1)+"');alert(msg);");
        }
        
        if(rs != null) rs.close();
		if(stmt1 != null) stmt1.close();
        alt_stat = 'N';
      }
      else if (alt_status.equals("alt_id3_expired") && alt_stat != 'N')
      {
        stmt1 = con.createStatement() ;
        rs = stmt1.executeQuery("select alt_id3_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
		if(rs!=null) {
			rs.next();
			out.println("var msg = get_message_text('ALT_ID_EXPIRED','MP','"+prompt+"')");
			out.println("msg = msg.replace('$','"+rs.getString(1)+"');alert(msg);");
		}
		if(rs != null) rs.close();
		if(stmt1 != null) stmt1.close();
		alt_stat = 'N';
      }
      else if (alt_status.equals("alt_id4_expired") && alt_stat != 'N')
      {
        stmt1 = con.createStatement() ;
        rs = stmt1.executeQuery("select alt_id4_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
        if(rs!=null) {
			rs.next();
			out.println("var msg = get_message_text('ALT_ID_EXPIRED','MP','"+prompt+"')");
			out.println("msg = msg.replace('$','"+rs.getString(1)+"');alert(msg);");
	    }
         if(rs != null) rs.close();
		 if(stmt1 != null) stmt1.close();
        alt_stat = 'N';
      }
	  if (alt_stat!='N' && alt_status!="")
		{
			if(alt_status.indexOf("ALT_ID1_IN_GRACE")>=0)
			{
				stmt1 = con.createStatement() ;
				rs = stmt1.executeQuery("select alt_id1_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
			    if(rs!=null) {
					rs.next();
					alt_stat = 'N';
					out.println("var err_age3 = getMessage('ALT_ID_EXP_WITH_GRACE','MP');");
					out.println("err_age3 = err_age3.replace('$','"+rs.getString(1)+"');");
					out.println("alert(err_age3);");	
				}
				if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
			}
			else if (alt_status.indexOf("ALT_ID2_IN_GRACE")>=0 && alt_stat != 'N')
			{
				stmt1 = con.createStatement() ;
				rs = stmt1.executeQuery("select alt_id2_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
				if(rs!=null) {
					rs.next();
					String ald2_type = rs.getString(1);
					out.println("var msg = getMessage('ALT_ID_EXP_WITH_GRACE','MP');");
					out.println("msg = msg.replace('$',\'"+ald2_type+"\');");
					out.println("alert(msg);");
				  }
				if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
				alt_stat = 'N';
			}	
	        else if (alt_status.indexOf("ALT_ID3_IN_GRACE")>=0 && alt_stat != 'N')
	        {
		        stmt1 = con.createStatement() ;
		        rs = stmt1.executeQuery("select alt_id3_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
		          if(rs!=null) {
					rs.next();
					String ald3_type = rs.getString(1);
					out.println("var msg = getMessage('ALT_ID_EXP_WITH_GRACE','MP');");
					out.println("msg = msg.replace('$',\'"+ald3_type+"\');");
					out.println("alert(msg);");
				  }
		        if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
		        alt_stat = 'N';
			}		
	        else if (alt_status.indexOf("ALT_ID4_IN_GRACE")>=0 && alt_stat != 'N')
	        {
		        stmt1 = con.createStatement() ;
		        rs = stmt1.executeQuery("select alt_id4_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
		        
				  if(rs!=null){
					rs.next();
					String ald4_type = rs.getString(1);
					out.println("var msg = getMessage('ALT_ID_EXP_WITH_GRACE','MP');");
					out.println("msg = msg.replace('$',\'"+ald4_type+"\');");
					out.println("alert(msg);");
				  }
				 if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
				alt_stat = 'N';
			}		
		}
  	    String today="Today";
		if (alt_stat != 'N' &&  alt_status!= "")
		{
			if (alt_status.indexOf("ALT_ID1_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				stmt1 = con.createStatement() ;
				rs = stmt1.executeQuery("select alt_id1_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
				  if(rs!=null) 
				rs.next();
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				alt_stat='N';
				out.println("var err_age3 = getMessage('ALT_ID_EXP_WITHIN','MP');");
				out.println("err_age3 = err_age3.replace('$','"+rs.getString(1)+"');");
			 if(days1.equals("0")) {
					out.println("err_age3 = err_age3.replace('within','');");
					out.println("alert(err_age3+\""+today+" \");");			
				}
				else 
					out.println("alert(err_age3+\"  "+days1+"  Days\");");
				if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
			}
			else if (alt_status.indexOf("ALT_ID2_EXP_WITHIN")>=0 && alt_stat != 'N')
			{
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1 = con.createStatement() ;
		        rs = stmt1.executeQuery("select alt_id2_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
		          if(rs!=null)
				rs.next();
				String ald2_type = rs.getString(1);
				out.println("var msg = getMessage('ALT_ID_EXP_WITHIN','MP');");
				out.println("msg = msg.replace('$',\'"+ald2_type+"\');");
				if(days1.equals("0")) {
					out.println("msg = msg.replace('within','');");
					out.println("alert(msg+\" "+today+" \");");	
					}
					else 
					out.println("alert(msg+\"  "+days1+"  Days\");");
		       if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
		        alt_stat = 'N';
			}		
			else if (alt_status.indexOf("ALT_ID3_EXP_WITHIN")>=0 && alt_stat != 'N')
	        {
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1 = con.createStatement() ;
		        rs = stmt1.executeQuery("select alt_id3_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
				  if(rs!=null)
				rs.next();
				String ald3_type = rs.getString(1);
				out.println("var msg = getMessage('ALT_ID_EXP_WITHIN','MP');");
				out.println("msg = msg.replace('$',\'"+ald3_type+"\');");

				if(days1.equals("0")) {
					out.println("msg = msg.replace('within','');");
					out.println("alert(msg+\" "+today+" \");");	
					}
				else 
					out.println("alert(msg+\"  "+days1+"  Days\");");
				if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
		        alt_stat = 'N';
			}		
	        else if (alt_status.indexOf("ALT_ID4_EXP_WITHIN")>=0 && alt_stat != 'N')
	        {
				StringTokenizer token=new StringTokenizer(alt_status,"$");
				String days1 = token.nextToken();
				days1 = token.nextToken();
				stmt1 = con.createStatement() ;
		        rs = stmt1.executeQuery("select alt_id4_type from mp_Param_lang_vw WHERE module_id='MP' AND language_id='"+localeName+"'");
		        if(rs!=null)
					rs.next();
				String ald4_type = rs.getString(1);
				out.println("var msg = getMessage('ALT_ID_EXP_WITHIN','MP');");
				out.println("msg = msg.replace('$',\'"+ald4_type+"\');");
				if(days1.equals("0")) {
						out.println("msg = msg.replace('within','');");
						out.println("alert(msg+\" "+today+" \");");	
					}
					else 
						out.println("alert(msg+\"  "+days1+"  Days\");");
				if(rs != null) rs.close();
				if(stmt1 != null) stmt1.close();
			        alt_stat = 'N';
			}		
		}
               

	String q_appt_ref_no ="";


  if (alert_yn!='N')
    {
     
     out.println("parent.frames[0].document.forms[0].valid_patient_id.value='"+prompt_patient_id+"';");
	 if (list_name.equals("ok") || list_name.equals("register"))
      {
        // Update the record in Oa_Appt  
        q_appt_ref_no= request.getParameter("q_appt_ref_no");

        String q_from_funct = request.getParameter("q_from_funct")==null?"":request.getParameter("q_from_funct"); //added by 
        String q_booking_ref_no = request.getParameter("q_booking_ref_no")==null?"":request.getParameter("q_booking_ref_no"); 
        String q_booking_type = request.getParameter("q_booking_type")==null?"":request.getParameter("q_booking_type"); 
      
	  try{
          

		pstmt = con.prepareStatement("select c.addr1_line1, c.addr1_line2, c.addr1_line3, c.addr1_line4, c.postal1_code, a.patient_id,  decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang,a.patient_name)) patient_name  , a.national_id_no, a.name_prefix, a.alt_id1_no, a.first_name, a.second_name, a.third_name, a.family_name, a.name_suffix, a.sex, to_char(a.date_of_birth,'dd/mm/yyyy') date_of_birth, a.contact1_no, a.contact2_no, a.email_id, a.nationality_code from mp_patient a, mp_pat_addresses c where a.patient_id = c.patient_id(+) and a.patient_id = '"+prompt_patient_id+"' ");
     
        rs=pstmt.executeQuery();
                    
        if( rs != null )
        { 
          if( rs.next() )
          {
		  String name_prefix    =rs.getString("name_prefix");	if(name_prefix==null)  name_prefix="";
          String first_name     =rs.getString("first_name");	if(first_name==null)   first_name="";
          String second_name    =rs.getString("second_name");	if(second_name==null)  second_name="";
		  String third_name     =rs.getString("third_name");	if(third_name==null)   third_name="";
          String family_name    =rs.getString("family_name");	if(family_name==null)  family_name="";
		  String name_suffix    =rs.getString("name_suffix");	if(name_suffix==null)  name_suffix="";
       		  String patient_name   =rs.getString("patient_name");
		  String addr1_line1	=rs.getString("addr1_line1");	if(addr1_line1==null)  addr1_line1="";	
		  String addr1_line2	=rs.getString("addr1_line2");	if(addr1_line2==null)  addr1_line2="";	
		  String addr1_line3	=rs.getString("addr1_line3");	if(addr1_line3==null)  addr1_line3="";	
		  String addr1_line4	=rs.getString("addr1_line4");	if(addr1_line4==null)  addr1_line4="";	
		  String postal1_code	=rs.getString("postal1_code");	if(postal1_code==null) postal1_code="";	
		  String national_id_no	=rs.getString("national_id_no");
											if(national_id_no==null)  national_id_no="";
		 
		  String contact1_no 	=rs.getString("contact1_no");	if(contact1_no==null)  contact1_no="";	
		  String contact2_no	=rs.getString("contact2_no");	if(contact2_no==null)  contact2_no="";	
		  String email_id		=rs.getString("email_id");	if(email_id==null)  email_id="";
		  String nationality_code=rs.getString("nationality_code");	
											if(nationality_code==null)  nationality_code="";	
		  String patnamesql = "";
          if(q_from_funct.equals("IP_ADMISSION")) // condition added by chitra
                patnamesql = " Select decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang,patient_name)) Patient_Name  from ip_booking_list where BKG_LST_REF_NO = '"+q_booking_ref_no+"' and facility_id = '"+loginfacility+"' ";
          else
                patnamesql = "Select  decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang,patient_name)) Patient_Name  from OA_APPT where appt_ref_no = '"+q_appt_ref_no+"' and facility_id = '"+loginfacility+"' ";   
				
			String pname = "";
            pstmt=con.prepareStatement(patnamesql);
            rs=pstmt.executeQuery();
            if(rs!=null && rs.next())
			  {
				 pname = rs.getString(1);
			  } 

		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();

          if (pname!=patient_name)
			  {	

	          out.println("if(confirm(get_message_text('APPT_REC_CHG','MP',''))) { 	document.location.href='../../eMP/jsp/RegistrationUpdate.jsp?prompt_patient_id="+prompt_patient_id+"&q_from_funct="+q_from_funct+"&q_booking_ref_no="+q_booking_ref_no+"&q_appt_ref_no="+q_appt_ref_no+"&p_referral_id="+p_referral_id+"&q_booking_type="+q_booking_type+"'; ");
			  //out.println("parent.window.returnValue='"+prompt_patient_id+"';parent.window.close();");
			  out.println("let dialogBody = parent.parent.document.getElementById('dialog-body'); dialogBody.contentWindow.returnValue = '"+prompt_patient_id+"'; const dialogTag = parent.parent.document.getElementById('dialog_tag');  dialogTag.close();");   
			  out.println("}else{");
			  out.println("parent.frames[0].document.getElementById('patient_id').innerText='';");
			  out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
			  out.println("parent.frames[0].document.getElementById('years').innerText='';");
			  out.println("parent.frames[0].document.getElementById('months').innerText='';");
			  out.println("parent.frames[0].document.getElementById('days').innerText='';");
			  out.println("parent.frames[0].document.getElementById('sex').innerText='';");
			  out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
			  out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
			  out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
			  out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';");
			  //Below line modified For this CRF HSA-CRF-0289
			          if(isAlternateId){
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').value='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').value='';");
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");	
                      out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"';");						  
					  }else{
					  out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id2_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id3_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))");
					  out.println("parent.frames[0].document.getElementById('alt_id4_no').innerHTML='';");
					  out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
					  out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML='';");
					  }
					  out.println("if(parent.frames[0].document.getElementById('nat_id_prompt_no'))");
                      out.println("parent.frames[0].document.getElementById('nat_id_prompt_no').innerHTML='';");	
					  //End HSA-CRF-0289
			  out.println("parent.frames[0].document.forms[0].valid_patient_id.value='';}");
			  }
          }
         }

		 if(rs != null) rs.close();
		 if(pstmt != null) pstmt.close();

       
        }
        catch(Exception e){out.println(e+":here");
		e.printStackTrace();} 
    
      }
      else
      {
        // Retrieve the patient Details from Mp_Patient
        sql = "" ;
       // sql = "select decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang,a.patient_name)) patient_name, sex, substr(calculate_age(date_of_birth,1),3), calculate_age(date_of_birth,2), calculate_age(date_of_birth,3), to_char(date_of_birth,'dd/mm/rrrr'),nvl(alt_id1_no,' ')alt_id1_no, b.long_desc nationality from mp_patient a, mp_country_lang_vw b where PATIENT_ID='"+prompt_patient_id+"' and a.NATIONALITY_CODE = b.COUNTRY_CODE(+) and b.language_id='"+localeName+"'" ;
	   
	  /* Above Query Commented and Below Query Added for [this RUT-CRF-0011]*/
	  //modified code for PMG2014-HSA-CRF-0001 [IN:050020]
	   sql = "select decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang,a.patient_name)) patient_name, sex,  CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),1) YEAR, CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),2) months, CALCULATE_AGE_HOURS(TO_CHAR(date_of_birth,'dd/mm/yyyy hh24:mi:ss'),3) days, to_char(date_of_birth,'dd/mm/rrrr'),nvl(alt_id1_no,' ')alt_id1_no,nvl(alt_id2_no,' ')alt_id2_no,nvl(alt_id3_no,' ')alt_id3_no,nvl(alt_id4_no,' ')alt_id4_no,NATIONAL_ID_NO ,mp_get_desc.mp_alternate_id_type(OTH_ALT_ID_TYPE,'"+localeName+"','1' )OTH_ALT_ID_TYPE,OTH_ALT_ID_NO, b.long_desc nationality from mp_patient a, mp_country_lang_vw b where PATIENT_ID='"+prompt_patient_id+"' and a.NATIONALITY_CODE = b.COUNTRY_CODE(+) and b.language_id='"+localeName+"'" ;	   
        
        pstmt   = con.prepareStatement( sql );
        rs = pstmt.executeQuery() ;
		
        if( rs != null )
        {
          while( rs.next() )
          {
			String nat = rs.getString("nationality");
			String national_id_no = rs.getString("NATIONAL_ID_NO")==null?"":rs.getString("NATIONAL_ID_NO");
			String oth_alt_id =rs.getString("OTH_ALT_ID_TYPE")==null?"":rs.getString("OTH_ALT_ID_TYPE");
			String oth_alt_id_no = rs.getString("OTH_ALT_ID_NO")==null?"":rs.getString("OTH_ALT_ID_NO");
			String sex = rs.getString(2);
			switch(sex.charAt(0))
			{
				case 'M' : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); break;
				case 'F' : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"); break;
				default : sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}
			String DOB = rs.getString(6);
			if (!DOB.equals(""))
			{
				if(!localeName.equals("en"))
				{ 	
					DOB= DateUtils.convertDate(DOB,"DMY","en",localeName);
				}
			}

			if(nat == null || nat.equals("null")) nat = "";
			out.println("parent.frames[0].document.getElementById('patient_name').innerHTML=\"<b>"+rs.getString(1)+"\";");
            out.println("parent.frames[0].document.getElementById('sex').innerHTML='<b>"+sex+"';");
            out.println("parent.frames[0].document.getElementById('years').innerHTML='<b>"+rs.getString(3)+"';");
            out.println("parent.frames[0].document.getElementById('months').innerHTML='<b>"+rs.getString(4)+"';");
            out.println("parent.frames[0].document.getElementById('days').innerHTML='<b>"+rs.getString(5)+"';");
			out.println("parent.frames[0].document.getElementById('date_of_birth').value='"+rs.getString(6)+"';");
			out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerHTML='"+rs.getString(6)+"';");
			out.println("if(parent.frames[0].document.forms[0].alt_id1_no)"); 
			out.println("parent.frames[0].document.forms[0].alt_id1_no.value=\""+rs.getString("alt_id1_no")+"\";"); 
			//Below line modified For this CRF HSA-CRF-0289
			if(isAlternateId){
			out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))"); 
			out.println("parent.frames[0].document.getElementById('alt_id2_no').value=\""+rs.getString("alt_id2_no")+"\";");
            out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))"); 			
			out.println("parent.frames[0].document.getElementById('alt_id3_no').value=\""+rs.getString("alt_id3_no")+"\";"); 
			out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))"); 
			out.println("parent.frames[0].document.getElementById('alt_id4_no').value=\""+rs.getString("alt_id4_no")+"\";");
			out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
			out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML=\""+oth_alt_id_no+"\";"); 
			if(!oth_alt_id.equals("")){
			out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))"); 
			out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML=\""+oth_alt_id+"\";"); 
			}else{
			 out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))");
			 out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"';");			
			}
			
			}else{
			out.println("if(parent.frames[0].document.getElementById('alt_id2_no'))"); 
			out.println("parent.frames[0].document.getElementById('alt_id2_no').innerHTML=\""+rs.getString("alt_id2_no")+"\";");
            out.println("if(parent.frames[0].document.getElementById('alt_id3_no'))"); 			
			out.println("parent.frames[0].document.getElementById('alt_id3_no').innerHTML=\""+rs.getString("alt_id3_no")+"\";"); 
			out.println("if(parent.frames[0].document.getElementById('alt_id4_no'))"); 
			out.println("parent.frames[0].document.getElementById('alt_id4_no').innerHTML=\""+rs.getString("alt_id4_no")+"\";");
			out.println("if(parent.frames[0].document.getElementById('oth_alt_id_no'))");
			out.println("parent.frames[0].document.getElementById('oth_alt_id_no').innerHTML=\""+oth_alt_id_no+"\";"); 
			out.println("if(parent.frames[0].document.getElementById('oth_alt_id'))"); 
			out.println("parent.frames[0].document.getElementById('oth_alt_id').innerHTML=\""+oth_alt_id+"\";"); 
			}//End for this CRF HSA-CRF-0289
            out.println("if(parent.frames[0].document.getElementById('nat_id_prompt_no'))"); 			
			out.println("parent.frames[0].document.getElementById('nat_id_prompt_no').innerHTML=\""+national_id_no+"\";");			
			//end of PMG2014-HSA-CRF-0001 [IN:050020]
			out.println("parent.frames[0].document.getElementById('nationality').innerHTML='<b>"+nat+"';");
            out.println("parent.frames[0].document.forms[0].patient_id.value=\""+prompt_patient_id+"\";");
          }
        }
		if(rs != null)rs.close();
      if(pstmt != null)pstmt.close();
      }
	 }
	 else
		{
		  // update the validate column
		 /*  out.println(" if (parent.frames[0].document.forms[0].valid_patient_id.value==''){");
		  out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
		  out.println("parent.frames[0].document.getElementById('years').innerText='';");
		  out.println("parent.frames[0].document.getElementById('months').innerText='';");
		  out.println("parent.frames[0].document.getElementById('days').innerText='';");
		  out.println("parent.frames[0].document.getElementById('sex').innerText='';");
		  out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
		  out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
		  out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
		  out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';}"); */
		 out.println(" if (parent.frames[0].document.forms[0].valid_patient_id.value==''){");
		 out.println("parent.frames[0].document.getElementById('patient_name').innerText='';");
		 out.println("parent.frames[0].document.getElementById('years').innerText='';");
		 out.println("parent.frames[0].document.getElementById('months').innerText='';");
		 out.println("parent.frames[0].document.getElementById('days').innerText='';");
		 out.println("parent.frames[0].document.getElementById('sex').innerText='';");
		 out.println("parent.frames[0].document.getElementById('date_of_birth').innerText='';");
		 out.println("parent.frames[0].document.getElementById('date_of_birth_greg').innerText='';");
		 out.println("parent.frames[0].document.getElementById('nationality').innerText='';");
		 out.println("parent.frames[0].document.forms[0].alt_id1_no.value='';}");

		}
		out.println("</script>");
	}catch(Exception ee){
		
		ee.printStackTrace();
	}	
	finally
	{
			if(con != null) ConnectionManager.returnConnection(con,request);
	}
	%>
	</form>
	</body>
  </html>

