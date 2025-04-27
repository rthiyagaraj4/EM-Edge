 <%-- saved on 03/11/2005 --%>

<%@page  contentType="text/html;charset=UTF-8" import="ePH.Common.*, ePH.CytoInciReportingBean" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>


<%

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
	

try 
{
	
	String func_mode			= request.getParameter("func_mode");
    Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get("bean_id");
	String bean_name			= (String) hash.get( "bean_name" );
	String mode					= (String) hash.get("mode");
	if(bean_id==null)bean_id="";
	if(bean_name==null)bean_name="";

CytoInciReportingBean bean = (CytoInciReportingBean)getBeanObject( bean_id, bean_name , request) ;
bean.setLanguageId(locale);
	if(mode==null) mode="";
  if(func_mode != null && func_mode.equals("getPrint")){
		
		String p_language_id =(String) hash.get( "p_language_id" );
		String facility_id = bean.getLoggedInFacility();
		String Seq_No	= bean.getSeqNo();
		String report_id				= "PHCYTOINCIREPO";
	
		
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		ecis.utils.OnlineReport report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
			report1.addParameter("p_facility_id", facility_id);
			report1.addParameter("p_module_id", "PH");
			report1.addParameter("p_report_id",report_id);
			report1.addParameter("p_incident_no",Seq_No);
			report1.addParameter("p_user_name" ,(String)session.getValue( "login_user" ));
			report1.addParameter("p_language_id",p_language_id);
			onlineReports.add(report1);
			//String ReportOutput = onlineReports.execute(request,response);
	
		
	}else if(func_mode != null && func_mode.equals("getSysdate")){
				String called_from		= (String) hash.get( "called_from" );
				String date=bean.getSysdate();
				out.println("setDate1(\""+date+"\",\""+called_from+"\")");
			}
 putObjectInBean(bean_id,bean,request);
}catch (Exception e) {
	out.println("alert(\"Exception in PhCytoInciReportingValidate" + e + "\");") ;

	e.printStackTrace();
}
%>
