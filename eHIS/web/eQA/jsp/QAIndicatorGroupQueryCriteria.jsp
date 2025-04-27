<!DOCTYPE html>
<!--/*
				Developed by		   :		Rajesh Kanna.S
				Developed on	 	   :	 	2/2/2005 
													*/-->

<%@ page import ="java.sql.*,java.util.*" %>

<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
try 
{
	con = (Connection) session.getValue( "connection" );
} 
catch (Exception e) {}
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
firstItem.add("Text");  		 
firstItem.add("Group Code");	  
firstItem.add("qind_group_id");	
firstItem.add("4");	
firstItem.add("4");	
finAr.add(firstItem);
ArrayList secondItem=new ArrayList();
secondItem.add("Text");  
secondItem.add("Group Description");  
secondItem.add("qind_group_desc");   
secondItem.add("40");	
secondItem.add("40");	
finAr.add(secondItem); 
ArrayList thirdItem=new ArrayList();
thirdItem.add("List");  
thirdItem.add("Nature");  
thirdItem.add("eff_status");   
thirdItem.add("B,Both,E,Enabled,D,Disabled");
thirdItem.add("2");
finAr.add(thirdItem); 
String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];
orderByCols[0] = "Group Code";
orderByCols[1] = " Group Description";
orderByColVals[0] = "qind_group_id";
orderByColVals[1] = "qind_group_desc";
strbuff = qrypg.getQueryPage(con,finAr,"Indicator Group","../../eQA/jsp/QAIndicatorGroupQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());

firstItem.clear();
secondItem.clear();
thirdItem.clear();
finAr.clear();
%>
