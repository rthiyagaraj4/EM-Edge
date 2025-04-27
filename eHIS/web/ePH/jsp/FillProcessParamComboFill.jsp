<%-- saved on 03/11/2005 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

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
		String process_id			=	"";

		PhProcessFillBean beanObj		= (PhProcessFillBean)getBeanObject(bean_id, bean_name, request);
		beanObj.setLanguageId(locale);

		String p_fill_proc_ty		= (String) hash.get( "p_fill_proc_ty" );
		String p_fill_proc_dt		= (String) hash.get( "p_fill_proc_dt" );
		
		ArrayList fill_process_id		=	beanObj.loadFillProcessID(p_fill_proc_ty,p_fill_proc_dt);

		for(int i=0; i<fill_process_id.size(); i++)	{
			process_id	=	(String)fill_process_id.get(i);			out.println("addList('"+process_id+"')");
		}
		putObjectInBean(bean_id,beanObj,request);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>
