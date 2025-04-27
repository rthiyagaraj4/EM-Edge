<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eBL.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<script src='../../eCommon/js/common.js' language='javascript'></script>

<% 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute(
		"PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css";
%>

<html><head> <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><body class='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>

  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script> 
  <script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
  
  <script language='javascript' src="../../eBL/js/BLMedRepOutStdAmt.js"></script>
  <Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	function get_message_text(message,moduleid,prompt) 
	{
		var message_text;
		message_text = getMessage(message,moduleid);
	    return message_text;
	}
</script>

</head>
<form name='mr_validations_form' id='mr_validations_form'  method='post' target='messageFrame'>	

<%
        Connection con               = null;

   	    PreparedStatement pstmtEncounter		 = null;
        ResultSet rsetEncounter               = null ;

		//String patientId			 = "";
		String patient_id			 = checkForNull(request.getParameter("patient_id"));		
		String encounter_id			 = checkForNull(request.getParameter("encounter_id"));		
		String facility_id			 = (String)session.getValue("facility_id");
		String prompt                ="";

		String patient_class			 = checkForNull(request.getParameter("patient_class"));	
		String conVal					= checkForNull(request.getParameter("conVal"));	
		//added on 31-07-08 for SCR 4964
		String called_from			 = checkForNull(request.getParameter("called_from"));
		String query_String          = checkForNull(request.getParameter("query_String"));
		String condition			 = checkForNull(request.getParameter("condition"));
		String oper_stn			     = checkForNull(request.getParameter("oper_stn"));
		String call_function		 = checkForNull(request.getParameter("call_function"));
			

try{
                
		con                  = ConnectionManager.getConnection(request);

		Boolean isOutstAmtChkApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","OUTSTAMT_CHECK_MED_REPORT_REQ");//Added by Thamizh selvi on 8th Feb 2017 against ML-MMOH-CRF-0777

		webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
		patdata.setFacility_id(facility_id);
		String patientIdStatus = patdata.CheckStatus(con,patient_id);
		prompt = patient_id;

	     if(!patient_id.equals(""))
		  {
			  if (!patientIdStatus.equals("INVALID_PATIENT") && !(patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0))
			  {
			  if(conVal.equals("Y"))
				{
					if(!patient_id.equals("") || !encounter_id.equals(""))
					{
						
						//added on 31-07-08 for SCR 4964
						if(called_from.equals("MEDICAL_REPORT_REQUEST")) 
						{	
							/*Added by Thamizh selvi on 7th Feb 2017 against ML-MMOH-CRF-0777 Start*/
							if(isOutstAmtChkApplicable){
						
								%><script>var pat_id = '<%=patient_id%>';
								var retAuth1 = checkOutstdAmtExists(pat_id,"MR"); 
								</script><%
									out.println("<html><script>if(retAuth1=='Y'){top.content.resultFrame.location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?"+query_String+"&"+condition+"&oper_stn_id="+oper_stn+"&show_bed_yn=Y&fromSelect=fromSelect'}else{top.content.resultFrame.location.href='../../eCommon/html/blank.html';top.content.criteriaFrame.document.forms[0].PatientId.value='';}</script></html>");

							}/*End*/
							else{
									out.println("<html><script>top.content.resultFrame.location.href= '../../eMR/jsp/MedRecRequestFrames.jsp?"+query_String+"&"+condition+"&oper_stn_id="+oper_stn+"&show_bed_yn=Y&fromSelect=fromSelect'</script></html>");
							}
								
							
						}
						else
						{
							out.println("<html><script>top.content.patientLine.location.href='../../eCommon/jsp/pline.jsp?EncounterId="+encounter_id+"&Facility_Id="+facility_id+"&Patient_ID="+patient_id+"';top.content.workAreaFrame.location.href='../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=MEDICAL_CERTFICATE&title=Medical Certificate&patient_id="+patient_id+"&encounter_id="+encounter_id+"&open_in_normal_yn=Y&episode_type=&visit_adm_date=&patient_class="+patient_class+"';</script></html>");
						}
						
					}
				
				}
			  }
			else if ( patientIdStatus.equals("INVALID_PATIENT"))
			{
			//added on 31-07-08 for SCR 4964
				
				if(call_function.equals("MEDICAL_REPORT_REQUEST"))
				{
					
					out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));top.content.resultFrame.location.href='../../eCommon/html/blank.html';top.content.criteriaFrame.document.forms[0].PatientId.value='';</script></html>");
				}//
				else if(call_function.equals("RECORD_DIAGNOSIS"))
				{
					
					out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));parent.frames[2].location.href='../../eCommon/html/blank.html';parent.frames[1].document.forms[0].PatientId.value='';</script></html>");
					
				}else if(call_function.equals("Medical_Certificate"))
				{
					
					out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));parent.frames[2].location.href='../../eCommon/html/blank.html';parent.frames[1].document.forms[0].patient_id.value='';</script></html>");
					
				}
			else
				{
					//out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));top.content.patientLine.location.href='../../eCommon/html/blank.html';top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';top.content.searchFrame.document.forms[0].patient_id.focus();top.content.searchFrame.document.forms[0].patient_id.value='';</script></html>");
					out.println("<html><script>alert(get_message_text('INVALID_PATIENT','MP','"+prompt+"'));parent.frames[2].location.href='../../eCommon/html/blank.html';parent.frames[1].document.forms[0].PatientId.value='';</script></html>");
				}

         	}
			else if(patientIdStatus.indexOf("PATIENT_MERGED_VALID")>=0)
		    {
				StringTokenizer token=new StringTokenizer(patientIdStatus,"$");
				String valid_patient_id = token.nextToken();
				valid_patient_id = token.nextToken();
			%>	
			<script>
				var error= getMessage( "PATIENT_MERGED_VALID" ,'MP');
				error = error.replace('#',"<%=valid_patient_id%>");				
				alert(error);
				
				//Below conditions added by Dharma on 20th Feb 2018 against for ML-MMOH-SCF-0919 [IN:066388]
				var call_function	= "<%=call_function%>";
				if(call_function=='VIEW_ENCOUNTER_DTLS' ||call_function== 'UPDATE_FILE_DETAILS' || call_function=='MARK_MLC_OSCC' || call_function=='DIAG_RECODE' || call_function=='MR_REC_PAT_VAL' || call_function=='RECORD_DIAGNOSIS' || call_function=='PROCEDURE_RECORDING' || call_function=='TRANSMIT_NOTIFY_REP' || call_function=='QUERY_MARK_MLC_OSCC' || call_function=='QUERY_MARK_MLC_OSCC' || call_function=='QUERY_MATERNAL_REPORT' || call_function=='MR_VIEW_DTH_REG' || call_function=='CONF_TRANSMIT_NOTIFY_REP'){
					parent.frames[1].document.forms[0].PatientId.value="<%=valid_patient_id%>";
				}else if(call_function== 'MEDICAL_REPORT_REQUEST' || call_function=='MR_INTERNAL_REPORTS_REPRINT'){
					parent.frames[2].document.forms[0].PatientId.value="<%=valid_patient_id%>";
				}else{
					top.content.searchFrame.document.forms[0].patient_id.value="<%=valid_patient_id%>";
				}
	
			</script>

<%		
			out.println("<html><script>if(top.content.patientLine)top.content.patientLine.location.href='../../eCommon/jsp/pline.jsp?EncounterId="+encounter_id+"&Facility_Id="+facility_id+"&Patient_ID="+valid_patient_id+"';if(top.content.workAreaFrame)top.content.workAreaFrame.location.href='../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=MEDICAL_CERTFICATE&title=Medical Certificate&patient_id="+valid_patient_id+"&encounter_id="+encounter_id+"&open_in_normal_yn=Y&episode_type=&visit_adm_date=&patient_class="+patient_class+"';</script></html>");
			}
		 
		  
		 }
		  if(!encounter_id.equals(""))
		  {
				 try 			

				  {	
				   StringBuffer sqlPr = new StringBuffer();
				   int countRecEnc =0;
				   sqlPr.append("select count(*) from pr_encounter where ");
				   sqlPr.append("facility_id= ?  and patient_id = ? and encounter_id =? ");
				   pstmtEncounter = con.prepareStatement(sqlPr.toString());
				   pstmtEncounter.setString(1,facility_id );
				   pstmtEncounter.setString(2,patient_id );
				   pstmtEncounter.setString(3,encounter_id );

				   rsetEncounter = pstmtEncounter.executeQuery();
					  while(rsetEncounter!=null && rsetEncounter.next())
							 {
							  countRecEnc=rsetEncounter.getInt(1);
							 }
					  if(rsetEncounter!=null) rsetEncounter.close();
					  if(pstmtEncounter!=null) pstmtEncounter.close();
					  if((sqlPr != null) && (sqlPr.length() > 0))
					  {
						sqlPr.delete(0,sqlPr.length());
					  }
					  if (countRecEnc==0)
					  {
						  out.println("<html><script>alert(get_message_text('INVALID_ENCOUNTER_ID','IP','"+encounter_id+"'));top.content.patientLine.location.href='../../eCommon/html/blank.html';top.content.workAreaFrame.location.href='../../eCommon/html/blank.html';top.content.searchFrame.document.forms[0].encounter_id.focus();top.content.searchFrame.document.forms[0].encounter_id.value='';</script></html>");
					  }
					}catch(Exception e) {/* out.println("Exception in Encounter="+e); */ e.printStackTrace();}		  
				}
				
				



		  %>
			<input type = 'hidden' name = 'patientIdStatus' value = '<%=patientIdStatus%>'>
	 </form>
	 </body>
<%	    }
		 catch(Exception e)
		{
			//out.print(e.toString());
			e.printStackTrace();
		 }
		finally
		{
			 ConnectionManager.returnConnection(con,request);
		}
%>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>

</html>

