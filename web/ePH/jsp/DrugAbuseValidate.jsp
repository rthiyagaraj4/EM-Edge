 <%--This file is saved on 07/11/2005 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.* " contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	try {
			Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
			hash						= (Hashtable)hash.get( "SEARCH" ) ;
			String bean_id				= "DrugAbuseBean" ;
			String bean_name			= "ePH.DrugAbuseBean";
			String validate = request.getParameter( "validate" ) ;
			DrugAbuseBean bean = (DrugAbuseBean)getBeanObject( bean_id,bean_name,request);
			if(validate.equals("getPatientDetails")){
				String patient_id=(String)hash.get("patient_id" ) ;
				ArrayList patientdetails = bean.getPatientDetails(patient_id);
				if(patientdetails.size()!=0){
						String p_name=(String)patientdetails.get(0);
						p_name=p_name.replaceAll(" ","%20");
						p_name = java.net.URLEncoder.encode(p_name,"UTF-8");
						p_name=p_name.replaceAll("%2520","%20");
						//String p_age  = (String)patientdetails.get(1);
						//String p_sex  = (String)patientdetails.get(2);
						//out.println("dispPatientDtails(\""+p_name+"\",'"+p_age+"','"+p_sex+"');") ;
						out.println("dispPatientDtails(\""+p_name+"\");") ;
						}
				else
					 out.println("alertInvalidPat();") ;
			}
			putObjectInBean(bean_id,bean,request); 
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
