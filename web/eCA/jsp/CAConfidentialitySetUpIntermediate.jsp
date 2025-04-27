<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
10/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
--------------------------------------------------------------------------------------------------------
*/

%>

<%@page import="java.sql.*,java.util.*, eCA.*,eOR.Common.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	try{
		Hashtable hashObj 			= (Hashtable)XMLobj.parseXMLString(request);
 		hashObj 					= (Hashtable)hashObj.get("SEARCH");
		String l_bean_id 			= (String)hashObj.get("bean_id");
		String l_bean_name 			= (String)hashObj.get("bean_name");
		String l_action 			= (String)hashObj.get("p_action") == null?"":(String)hashObj.get("p_action");
		String l_hist_type 			= (String)hashObj.get("p_hist_type") == null?"":(String)hashObj.get("p_hist_type");
		String l_event_type			= (String)hashObj.get("p_event_type")== null?"": (String)hashObj.get("p_event_type");	
		String l_confdnt_id			= (String)hashObj.get("p_confdnt_id")== null?"": (String)hashObj.get("p_confdnt_id");	
		/*
		*	Pagination Data
		*/
		
		String  ctnChkBox			= (String)hashObj.get("p_ctnChkBox") == null?"":(String)hashObj.get("p_ctnChkBox");
		String 	confidntType		= (String)hashObj.get("p_confidnt_type") == null?"":(String)hashObj.get("p_confidnt_type");
		String	result_data_code	= (String)hashObj.get("p_result_data_code") == null?"":(String)hashObj.get("p_result_data_code");
		String	view_list_data		= (String)hashObj.get("p_view_list_data") == null?"":(String)hashObj.get("p_view_list_data");
		String	view_by_data		= (String)hashObj.get("p_view_by_data") == null?"":(String)hashObj.get("p_view_by_data");
		String	based_on_data		= (String)hashObj.get("p_based_on_data") == null?"":(String)hashObj.get("p_based_on_data");
		String  l_search_code		= (String)hashObj.get("p_search_code") == null?"":(String)hashObj.get("p_search_code");
		String 	l_header_filter_based_on	= (String)hashObj.get("p_header_filter_based_on") == null?"":(String)hashObj.get("p_header_filter_based_on");
		int selectedRecords = 0;
		ArrayList l_event_codes =  null;
		HashMap l_set_page_data = null;
		HashMap confdntHashMap = null;
		ArrayList l_condnt_key_list = null;
		CAConfidentialitySetUpBean beanObj = (CAConfidentialitySetUpBean)getBeanObject(l_bean_id, l_bean_name, request);
		confdntHashMap = beanObj.getConfidentialityMapData();
		l_condnt_key_list = beanObj.getKeyConfidentDataArrayList();
		/*if(l_action.equals("LOAD_EVENT_DATA")){
			l_event_codes = beanObj.getEventCodes(l_hist_type, l_event_type, locale); 
			out.println( "clearEventCodes();");
			for( int i=0 ; i< l_event_codes.size() ; i++ ) 
			{
				String[] l_record_details = (String[])l_event_codes.get(i); 
				out.println( "addEventCodes(\"" + l_record_details[0] + "\",\"" + l_record_details[1] + "\") ; " ) ;
			}
		}*/
		//else if(l_action.equals("LOAD_CONT_SYS_CODE")) {
		if(l_action.equals("LOAD_CONT_SYS_CODE")) {
			l_event_codes = beanObj.getContSysCode(l_hist_type);
			out.println( "clearContSysCodes();");
			for( int i=0 ; i< l_event_codes.size() ; i++ ) 
			{
				String[] l_record_details = (String[])l_event_codes.get(i); 
				out.println( "addContSysCodes(\"" + l_record_details[0] + "\",\"" + l_record_details[1] + "\") ; " ) ;
			}
		}
		else if(l_action.equals("SET_EVENT_DATA")){
			l_set_page_data = beanObj.setPaginateData(ctnChkBox, confidntType, result_data_code, view_list_data, view_by_data, based_on_data);
			selectedRecords = l_set_page_data.size();
			beanObj.setConfidentialityMapData(l_set_page_data);
			selectedRecords = l_condnt_key_list.size();
			out.println("selectedRecordCounts(\"" + selectedRecords + "\");");
		} 
		else if(l_action.equals("LOAD_EXIST_PRIVILEGE_DATA")){
			l_set_page_data = beanObj.loadStoredEventData(l_hist_type, l_event_type, l_confdnt_id, l_search_code, view_list_data, view_by_data, based_on_data, l_header_filter_based_on);
			
			if(l_set_page_data != null)
			{
				//selectedRecords = l_set_page_data.size();
				beanObj.setConfidentialityMapData(l_set_page_data);
				HashMap getMapConfidentKey = beanObj.getConfidentialityMapData();
				l_condnt_key_list = new ArrayList();
 				Iterator itr = l_set_page_data.keySet().iterator();
				String key_confdnt_id = "";
				
				while(itr.hasNext())
				{
					key_confdnt_id = itr.next().toString();
					l_condnt_key_list.add(key_confdnt_id);
				}
				selectedRecords = l_condnt_key_list.size();
				beanObj.setKeyConfidentDataArrayList(l_condnt_key_list);
			}
			out.println("selectedRecordCounts(\"" + selectedRecords + "\" );");
		}
		else if(l_action.equals("EMPTY_MAP_DATA")){
			selectedRecords= 0 ;
			if(confdntHashMap != null){
				confdntHashMap.clear();
			}

			if(l_condnt_key_list != null)
			{
				if(l_condnt_key_list.size() > 0)
				{
					l_condnt_key_list.clear();
				}
			}
			out.println("selectedRecordCounts(\"" + selectedRecords + "\" );");
		}
	}
	catch(Exception ex){
		ex.printStackTrace();
		System.out.println(" 69. CAConfidentialitySetUpIntermediate.jsp = Message => " + ex.getMessage());
		
	}

%>
