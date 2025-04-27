<!DOCTYPE html>
<%--
	FileName	:StatGrpNationDetailQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 23-2-2005 , 10-3-2008
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;


try {
	con = ConnectionManager.getConnection(request);//(Connection) session.getValue( "connection" );


ArrayList finAr = new ArrayList();

ArrayList zeroItem = new ArrayList();
	zeroItem.add("List");  		 //Type of item
	zeroItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels"));	  // label
	zeroItem.add("STAT_GRP_CAT");	//name of field
	//zeroItem.add("A,All,N,Nationality,S,Service,P,Specialty");	// SIZE
	zeroItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"");	// SIZE
	//LENGTH
finAr.add(zeroItem);//add to ArrayList obj finAr

ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.StatisticsGroupID.label","am_labels"));	  // label
	firstItem.add("stat_grp_id");	//name of field
	firstItem.add("10");	// SIZE
	firstItem.add("10");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StatisticsGroup.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
	secondItem.add("stat_grp_desc");   //name of field
	secondItem.add("20");	// SIZE
	secondItem.add("20");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr


String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.StatisticsGroupID.label","am_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StatisticsGroup.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "a.stat_grp_id";
orderByColVals[1] = "stat_grp_desc";

//strbuff = qrypg.getQueryPage(con,finAr,"Statics Group Detail","../../eAM/jsp/StatGrpNationDetailQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

strbuff = qrypg.getQueryPage(con,finAr,"Statics Group Detail","../../eAM/jsp/StatGrpNationDetailQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());


zeroItem.clear();
firstItem.clear();
secondItem.clear();
finAr.clear();

} catch (Exception e) {}
finally
{

	ConnectionManager.returnConnection(con,request);
}
%>
