<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%><%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String function_id=request.getParameter("function_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String facility_id=request.getParameter("facility_id");
Connection con=null ;
String operationRoom =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String block_slots_by_speciality =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.BlockSlotsBySpeciality.Label","ot_labels");
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");



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
	orderByColVals[1] = "short_desc";
	

//strbuff = qrypg.getQueryPage( con,finAr,"Block Slots By Speciality ","../../eOT/jsp/BlockSlotsBySpecialityQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

strbuff = qrypg.getQueryPage( con,finAr,block_slots_by_speciality,"../../eOT/jsp/DairyScheduleForSuregonQueryResult.jsp?function_id="+function_id,sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {
	e.printStackTrace();
	//System.err.println("Error Mesg From DairyScheduleForSurgeonQryCriteria.jsp : "+e);
}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<html>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

