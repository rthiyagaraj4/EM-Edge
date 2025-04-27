	<%@ page import="eXH.*,webbeans.eCommon.ConnectionManager, eXH.*" %>

	<%
		System.out.println(" ::: MyHixResult :::");

		boolean isDebugYN = false; 

		isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		System.out.println("MyHixResult isDebugYN--> "+isDebugYN);

		//String dataElements=request.getParameter("dataElements"); // Added by Sethu for MyHix changes required.

		String dataElements="";		

		//String data_details=checkForNull(request.getParameter("details")); // Commented by Sethu.
		StringBuffer htmlData = new StringBuffer(); // Variables added by Sethu.
		String data_details="";

		String action=checkForNull(request.getParameter("action"));
		String facilityid=checkForNull(request.getParameter("facilityid"));
		String pat_id=checkForNull(request.getParameter("pat_id"));
		String encounter_id=checkForNull(request.getParameter("encounter_id"));

		String my_hix_pat_id=java.net.URLDecoder.decode(request.getParameter("my_hix_pat_id"), "UTF-8");
		my_hix_pat_id=my_hix_pat_id.replaceAll("&", "&amp;");

		//String my_hix_pat_id=checkForNull(request.getParameter("my_hix_pat_id"));
		if (isDebugYN)
			System.out.println(" ::: MyHixResult ::: my_hix_pat_id ::: "+my_hix_pat_id);
		
		//System.out.println(" ::: MyHixResult ::: my_hix_pat_id After replace ::: "+my_hix_pat_id);
		String final_from_date=checkForNull(request.getParameter("final_from_date"));
		String final_to_date=checkForNull(request.getParameter("final_to_date"));
		String logged_user=checkForNull(request.getParameter("logged_user"));
		
		if (isDebugYN)
			System.out.println(" ::: MyHixResult ::: Logged User ::: "+logged_user);

		dataElements = "<REQ_ID>"+action+"$!^<FACILITY_ID>"+facilityid+"$!^<PATIENT_ID>"+pat_id+"$!^<ENCOUNTER_ID>"+encounter_id+"$!^<MYHIX_PAT_ID>"+my_hix_pat_id+"$!^<FROM_DATE>"+final_from_date+"$!^<TO_DATE>"+final_to_date+"$!^<MYHIX_DOC_ID> $!^<REQ_TYPE>QRYREQUEST$!^<LOGGED_USER>"+logged_user+"$!^";

		if (isDebugYN)
			System.out.println(" ::: MyHixResult ::: dataElements 123 ::: "+dataElements);

		InvokeMyHixRequest myHixRequest = new InvokeMyHixRequest(); 
		htmlData = myHixRequest.processRequest(dataElements); 

		data_details = htmlData.toString();
		
		if (isDebugYN)
			System.out.println(" ::: MyHixResult ::: data_details ::: "+data_details);
	
		if (!(data_details.equals("")))
		{
		
			out.println(data_details);
			out.println("<input type='hidden' name=action id=action value='"+action+"'>");
			out.println("<input type='hidden' name=facilityid id=facilityid value='"+facilityid+"'>");
			out.println("<input type='hidden' name=pat_id id=pat_id value='"+pat_id+"'>");
			out.println("<input type='hidden' name=encounter_id id=encounter_id value='"+encounter_id+"'>");
			out.println("<input type='hidden' size='80' name=my_hix_pat_id id=my_hix_pat_id value='"+my_hix_pat_id+"'>");
			out.println("<input type='hidden' name=final_from_date id=final_from_date value='"+final_from_date+"'>");
			out.println("<input type='hidden' name=final_to_date id=final_to_date value='"+final_to_date+"'>");
			out.println("<input type='hidden' name=logged_User id=logged_User value='"+logged_user+"'>");
			%>
			<script language='javascript' src='../../eMP/js/MyHixSearch.js'></script>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
			<script src='../../eCommon/js/dchk.js' language='javascript'> </script>
			<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
			<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
			<script src='../../eXH/js/ExternalApplication.js' language='javascript'></script>
			<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
			<Script src='../../eCommon/js/CommonCalendar.js' language="JavaScript"></Script>
			<%
		}else{%>
				<script src="../../eCommon/js/common.js" language='javascript'></script>
				<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				</script>
		<%}
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
	%>
	

