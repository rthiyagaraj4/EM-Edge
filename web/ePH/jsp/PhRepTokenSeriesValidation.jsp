<%-- saved on 03/11/2005 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8 " %>
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
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	String facility_id			= (String) hash.get( "facility_id" );
	String disp_locn_code		= (String) hash.get( "disp_locn_code" );
	String validate             = request.getParameter("validate") ; 
		
    if(validate.equals("POPULATE_TOKEN_SERIES")){
		ArrayList	TokenSerieslist		=	new ArrayList();
		PhIssueTokenBean beanObj		= (PhIssueTokenBean)getBeanObject(bean_id,bean_name,request);
	beanObj.setLanguageId(locale);
		TokenSerieslist		=	beanObj.getTokenSeriesList(facility_id,disp_locn_code);
		out.println("clearList()");
		
		for(int i=0; i<TokenSerieslist.size(); i+=2) {
		out.println("addList('"+(String)TokenSerieslist.get(i)+"','"+(String)TokenSerieslist.get(i+1)+"');");
		}
		putObjectInBean(bean_id,beanObj,request);
	}else if(validate.equals("POPULATE_TOKEN_SERIES_NO")){          

		ArrayList	TokenSeriesNos		=	new ArrayList();
		String patient_id			    = (String) hash.get( "patient_id" );
	    String token_series_code		= (String) hash.get( "token_series_code" );
		PhIssueTokenBean beanObj		= (PhIssueTokenBean)getBeanObject(bean_id,bean_name,request);
		beanObj.setLanguageId(locale);
		TokenSeriesNos		=	beanObj.getTokenSeriesNos( facility_id, disp_locn_code, token_series_code, patient_id);
		out.println("clearList1()");
		
		for(int i=0; i<TokenSeriesNos.size(); i+=1) {
		out.println("addList1('"+(String)TokenSeriesNos.get(i)+"','"+(String)TokenSeriesNos.get(i)+"');");
		} 
	 putObjectInBean(bean_id,beanObj,request); 
	}
	}catch (Exception e) {
	out.println("alert(\"" + e + "\");") ;
	}

%>
