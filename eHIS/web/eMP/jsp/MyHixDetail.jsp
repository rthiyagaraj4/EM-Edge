<!DOCTYPE html>
<%@ page import="eXH.*,webbeans.eCommon.ConnectionManager, eXH.*" %>
<!-- Changes made for ML-MMOH-CRF-1130.3 -->
<Script>
	function recordReplyNote()
	{                                           
		var patient_id=document.getElementById('patient_id').value;                                             
		var dialogHeight= "500" ;
		var dialogWidth = "500" ;
		var status = "no";
		var arguments   = "" ;
		var features       = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes;  status:" + status;                                                     
		window.showModalDialog("../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=REPLY_NOTES&option_id=REPLY_NOTES&patient_id="+patient_id+"",arguments,features);
	}
</Script>

<%
		String dataElements=request.getParameter("dataElements"); // Added by Sethu for MyHix changes required.
		dataElements = java.net.URLDecoder.decode(dataElements, "UTF-8");
		//String data_details=checkForNull(request.getParameter("details")); // Commented by Sethu.
		StringBuffer htmlData = new StringBuffer(); // Variables added by Sethu.
		String data_details="";	
		
		//Changes made for ML-MMOH-CRF-1130.3
		
		String l_field_separator= "$!^";

		String l_request_id = "", l_patient_id = "", l_facility_id = "", l_ecounter_id = "";

		String refStr = "REFREQQ";

		int refStrPos = 0;

		System.out.println(" ::: MyHixDetail ::: ");
		
		boolean isDebugYN = false; 

		isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		System.out.println("MyHixDetail isDebugYN--> "+isDebugYN);
	
		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Data Elements ::: "+dataElements);

		l_request_id = FetchFieldValue(dataElements, "<REQ_ID>", null, l_field_separator, "MyHixDisplay");

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Request ID ::: "+l_request_id);
		
		l_patient_id = FetchFieldValue(dataElements, "<PATIENT_ID>", null, l_field_separator, "MyHixDisplay");

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Patient ID ::: "+l_patient_id);

		l_facility_id = FetchFieldValue(dataElements, "<FACILITY_ID>", null, l_field_separator, "MyHixDisplay");

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Facility ID ::: "+l_facility_id);

		l_ecounter_id = FetchFieldValue(dataElements, "<ENCOUNTER_ID>", null, l_field_separator, "MyHixDisplay");

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Encounter ID ::: "+l_ecounter_id);
		
		//Changes made for ML-MMOH-CRF-1130.3

		InvokeMyHixRequest myHixRequest = new InvokeMyHixRequest(); 
		htmlData = myHixRequest.processRequest(dataElements);		
		
		data_details = htmlData.toString();
		
		//Changes made for ML-MMOH-CRF-1130.3

		refStrPos = dataElements.indexOf( refStr );

		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: Position ::: "+refStrPos);

		////Changes made for ML-MMOH-CRF-1130.3
		if (!(data_details.equals("")) && (refStrPos>0))
		{
			data_details = data_details + "\n"+ "<input type=\"button\" name=\"Print\" id=\"Print\"  value=\"Print\" onClick=\"window.print()\">" + "\t" + "<input type=\"button\" name=\"Reply Note\" id=\"Reply Note\"  value=\"Reply\" onClick=\"recordReplyNote()\">";
		}
		else if (!(data_details.equals("")))
		{
			data_details = data_details + "\n"+ "<input type=\"button\" name=\"Print\"  id=\"Print\" value=\"Print\" onClick=\"window.print()\">";
		}
		
		if (isDebugYN)
			System.out.println(" ::: MyHixDisplay ::: data_details ::: "+data_details);
	
		if (!(data_details.equals("")))
		{		
			out.println(data_details);			
		}
		
		//Changes made for ML-MMOH-CRF-1130.3

		if (!(data_details.equals("")))
		{
		
			out.println("<input type='hidden' name=action id=action value='"+l_request_id+"'>");
			out.println("<input type='hidden' name=facilityid id=facilityid value='"+l_facility_id+"'>");
			out.println("<input type='hidden' name=patient_id id=patient_id value='"+l_patient_id+"'>");
			out.println("<input type='hidden' name=encounter_id id=encounter_id value='"+l_ecounter_id+"'>");	
		}
%>

<%!	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	?	""	:	inputString;
		}
		
		public static String checkForNull(String inputString, String defaultValue)
		{
			return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}
		//Changes made for ML-MMOH-CRF-1130.3

		public String FetchFieldValue(String message, String identifier, String standardCode, String fieldSep, String procID){

			String l_app_msg = "", l_app_key = "", l_field_value = "";

			boolean isDebugYN = false; 

			isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			l_app_msg = " ::: Inside FieldValueFetchMethod ::: ";
			if (isDebugYN) System.out.println(l_app_msg);	

			l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
			if (isDebugYN) System.out.println(l_app_msg);	
			
			l_app_msg = " ::: Deriving Field Value..."+identifier;
			if (isDebugYN) System.out.println(l_app_msg);	

			try
			{
				if(standardCode != null && !(standardCode.length()>0))
				{

				}
				else
				{
					if (message.indexOf(identifier) >= 0 )
					{
						if (message.indexOf(fieldSep) >= 0)
						{
							l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
							if (l_field_value.indexOf(fieldSep) >= 0)
							{						
								l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
							}
						}
					}
				}
			}
			catch (Exception e)
			{
				l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
			}		

			l_app_msg = " ::: l_field_value ::: "+l_field_value;
			if (isDebugYN) System.out.println(l_app_msg);

			return l_field_value;
		}
%>

