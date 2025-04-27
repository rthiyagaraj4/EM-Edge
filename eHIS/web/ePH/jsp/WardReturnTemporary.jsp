<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.Common.* " %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id    = request.getParameter( "bean_id" )==null?"": request.getParameter( "bean_id" );
	String bean_name  = request.getParameter( "bean_name" )==null?"": request.getParameter( "bean_name" );
	String identity   = request.getParameter( "identity" )==null?"": request.getParameter( "identity" );
	
	WardReturnBean bean = (WardReturnBean)getBeanObject(bean_id,bean_name,request) ;
	   
	Hashtable hash = ( Hashtable )XMLobj.parseXMLString( request ) ;
    hash = ( Hashtable )hash.get( "SEARCH" ) ;
	
	if(identity.equals("SAVECHANGEDQTY")){ 
		String Qty    = request.getParameter( "qty" )==null?"": request.getParameter( "qty" );
		String count  = request.getParameter( "count" )==null?"": request.getParameter( "count" );
		int qty = Integer.parseInt(Qty);
		int Count = Integer.parseInt(count);
		ArrayList savedArray= bean.getScannedBatchDetails();
		for(int i=0,count_1=1;i<savedArray.size();i+=34)
		{   
	          if(count_1==Count)
	          {
	        	  savedArray.set((i+33), qty);
	        	  bean.setScannedBatchDetails(savedArray);
	        	  break;
	          }
	          count_1++;
		}
		
	}
	putObjectInBean(bean_id,bean,request);
%>
