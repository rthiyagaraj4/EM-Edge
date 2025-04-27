 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
		
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String facility_id  		= (String)session.getValue("facility_id");
	String pat_class			= (String) hash.get( "pat_class" );
	String location				= (String) hash.get( "LOCATION" );
	String priority				= (String) hash.get( "PRIORITY" );
	String form					= (String) hash.get( "FORM" );	
	String mar_defaulting		= (String) hash.get( "MAR_DEFAULTING" );
	String targetField		= (String) hash.get( "fieldToLoad" );
	BuildMARRules bean	= (BuildMARRules) getBeanObject( bean_id,bean_name, request ) ;
	bean.setFacilityId(facility_id);
	bean.setLanguageId(locale);
	bean.setApp_Pat_Class(pat_class);
	bean.setLocation(location);
	bean.setPriority(priority);
	bean.setForm(form);
	
	HashMap result = new HashMap();
	ArrayList codeValues=  new ArrayList();
	ArrayList descValues=  new ArrayList();
	
	if(targetField.equals("LOCATION")){
	
		result=bean.loadLocationValues(facility_id,pat_class,locale);
	
		codeValues= (ArrayList) result.get("LOCATION_CODE");
		descValues= (ArrayList) result.get("LOCATION_DESC");
		for(int i=0; i<codeValues.size(); i++){
			out.println("addLocation('"+codeValues.get(i)+"','"+descValues.get(i)+"')");
		}
	}
	else if(targetField.equals("FORM")){	
		result=bean.loadFormValues(locale);
		codeValues= (ArrayList) result.get("FORM_CODE");
		descValues= (ArrayList) result.get("FORM_DESC");
		for(int i=0; i<codeValues.size() ; i++){
			out.println("addForms('"+codeValues.get(i)+"','"+descValues.get(i)+"')");
		}	
	}
	
	putObjectInBean(bean_id,bean,request);
%>
