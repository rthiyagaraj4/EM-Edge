<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%><%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>



<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String facility_id=request.getParameter("facility_id");
String operationRoom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String block_slots_by_speciality =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.BlockSlotsBySpeciality.Label","ot_labels");
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String querycriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(operationRoom);     // label
firstItem.add("oper_room_code");   //name of field
firstItem.add("6"); // SIZE
firstItem.add("6"); // LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");           //Type of item
secondItem.add(description);     // label
secondItem.add("description");   //name of field
secondItem.add("15"); // SIZE
secondItem.add("15"); // LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr



String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = operationRoom;
	orderByCols[1] = description;
	

	orderByColVals[0] = "oper_room_code";
	orderByColVals[1] = "description";
//strbuff = qrypg.getQueryPage( con,finAr,"Block Slots By Speciality ","../../eOT/jsp/BlockSlotsBySpecialityQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");	

strbuff = qrypg.getQueryPage( con,finAr,block_slots_by_speciality,"../../eOT/jsp/BlockSlotsBySpecialityQueryResult.jsp",sortorder,querycriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

