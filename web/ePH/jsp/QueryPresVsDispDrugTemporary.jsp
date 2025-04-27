<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	String code = request.getParameter( "code" ) ;
	String type=request.getParameter( "type" ) ;

	

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	ArrayList dispLocn=bean.getDispLocn(type,code);

	
	if (dispLocn.size()==0) 
	{
		out.println("addData(\"\",\"  ---Select---   \",document.FormQueryPresVsDispDrug.Disp_Locn);");
		out.println("FormQueryPresVsDispDrug.Disp_Locn.disabled=true;") ;	
		return;
	}
	out.println("FormQueryPresVsDispDrug.Disp_Locn.disabled=false;") ;	
	out.println("clearData('FormQueryPresVsDispDrug.Disp_Locn');") ;
	out.println("addData('','     ---Select---     ','FormQueryPresVsDispDrug.Disp_Locn');");


	for (int i=0; i<dispLocn.size(); i+=2) {
		out.println("addData('"+ dispLocn.get(i) + "', '" + dispLocn.get(i+1) +"', 'document.FormQueryPresVsDispDrug.Disp_Locn');") ;
	}

putObjectInBean(bean_id,bean,request);
	
%>

