<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ; 
try
{
	con				= ConnectionManager.getConnection(request);
	ArrayList finAr 	= new ArrayList();


String priorityzoneCode   = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.PriorityZoneCode.label","ae_labels");
String priorityzoneDesc  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.PriorityZoneDesc.label","ae_labels");

ArrayList firstItem = new ArrayList();

firstItem.add("Text");   		//Type of item
firstItem.add(priorityzoneCode);		//label
firstItem.add("priority_zone");		//name of field
firstItem.add("1");				// SIZE
firstItem.add("1");			    //LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem	= new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.PriorityZoneColorDesc.label","ae_labels"));  // label
secondItem.add(" priority_zone_desc");   //name of field
secondItem.add("20");	// SIZE
secondItem.add("20");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList fourthItem	= new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.PriorityZoneTabDesc.label","ae_labels"));  // label
fourthItem.add("priority_zone_tab_desc");   //name of field
fourthItem.add("20");	// SIZE
fourthItem.add("20");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr


String orderByCols[] 	= new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] 		 = priorityzoneCode;
orderByCols[1]		 = priorityzoneDesc;

orderByColVals[0] 	 = "priority_zone";
orderByColVals[1] 	 = "priority_zone_desc";

strbuff 		= qrypg.getQueryPage(con,finAr,"Find Site" ,"../jsp/PriorityZoneQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(fourthItem!=null)fourthItem.clear();
	
}catch (Exception e)  {e.printStackTrace();}
finally
	{
		 ConnectionManager.returnConnection(con,request);
	}
%>
