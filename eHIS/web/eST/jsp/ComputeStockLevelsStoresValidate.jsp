<!--<!DOCTYPE html>-->
 <%@page import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
		
	ComputeStockLevelsStoresBean bean = (ComputeStockLevelsStoresBean)getBeanObject( "ComputeStockLevelsStoresBean", "eST.ComputeStockLevelsStoresBean", request ) ;  
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
	String validate			=		request.getParameter("validate")==null?"":request.getParameter( "validate" );
    hash = (Hashtable) hash.get ("SEARCH");

/*	Hashtable hash			=		 new Hashtable();
	String c1				=		request.getParameter( "consumption_period" )==null?"":request.getParameter( "consumption_period" );
	String c2				=		request.getParameter( "fm_item_class_code" )==null?"":request.getParameter( "fm_item_class_code" );
	String c3				=		request.getParameter( "to_item_class_code" )==null?"":request.getParameter( "to_item_class_code" );
	String c4				=		request.getParameter( "fm_item_code" )==null?"":request.getParameter( "fm_item_code" );
	String c5				=		request.getParameter( "to_item_code" )==null?"":request.getParameter( "to_item_code" );
	String c6				=		request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" );
	String c7				=		request.getParameter( "buffer_percentage" )==null?"":request.getParameter( "buffer_percentage" );
	String p_stk_issue		=		request.getParameter( "p_stk_issue" )==null?"":request.getParameter( "p_stk_issue" );
	String validate			=		request.getParameter("validate")==null?"":request.getParameter( "validate" );
	 Hashtable hash1		=		(Hashtable) XMLobj.parseXMLString(request);

	hash.put("consumption_period", c1) ;
	hash.put("fm_item_class_code", c2) ;
	hash.put( "to_item_class_code",c3) ;
	hash.put("fm_item_code",c4 ) ;
	hash.put( "to_item_code",c5) ;
	hash.put("store_code", c6) ;
	hash.put("buffer_percentage", c7) ;
	hash.put("p_stk_issue",p_stk_issue) ;*/
	
	if (validate.equals("FETCH_ITEM")) {
		bean.loadData(hash);
	}
	else if (validate.equals("UPDATE_DETAILS")) {
		   bean.updateData(hash);
	}
%>
<%
	putObjectInBean("ComputeStockLevelsStoresBean",bean,request);
%>
