<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%String locale = (String)session.getAttribute("LOCALE");
  String facility_id = (String)session.getAttribute("facility_id");%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eDS/js/MealCensus.js'></script>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<title><fmt:message key="eOT.Item.Label" bundle="${ot_labels}"/></title>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%  //Checkstyle Violation commented by Munisekhar
	//String ph_module_yn = request.getParameter("ph_module_yn");
    //String from = request.getParameter( "from" ) ;
    // String to = request.getParameter( "to" ) ;
    //String sql = " ";
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String mealType = request.getParameter("meal_type");
	String encounterId =request.getParameter("encounter_id");
	String servingDate =request.getParameter("serving_Date");
	String convrtServingDate	=  com.ehis.util.DateUtils.convertDate(servingDate,"DMY", locale, "en"); 
	String itemSL = "";
	String itemDesc = "";
	String foodDesc= "";
	String servindDate = "";
	String itemQty = "";
	String servUom = "";
	Connection conn=null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	int index=0; // Added Against PMG2017-COMN-CRF-0012 [IN066074]
	try{
		String strsql = "select mealplandtl.item_Sl,itemType.short_Desc itemtype_desc,food.short_Desc food_desc,"+
						"to_char(mealplandtl.serving_Date,'DD/MM/YYYY HH24:MI:SS') as serving_Date,mealplandtl.item_Qty,am_get_desc.am_uom(food.serving_uom_code,?,2) serving_Uom_Code "+
						"from Ds_Epsd_Meal_Plan_Dtl mealplandtl,Ds_Items food,Ds_Item_Type_Lang_Vw itemType "+
						"where mealplandtl.item_Code = food.food_Item_Code and mealplandtl.item_Type = itemType.item_Type "+
						"and mealplandtl.OPERATING_FACILITY_ID = ? and mealplandtl.encounter_Id = ? "+
						"and mealplandtl.Meal_Type =? and food.language_Id=? and itemType.language_Id = ? and to_char(mealplandtl.serving_Date,'dd/mm/yyyy') like ? order by mealplandtl.item_Sl ";
						// Modified Against PMG2017-COMN-CRF-0012 [IN066074]

		conn = ConnectionManager.getConnection(request);
		stmt = conn.prepareStatement(strsql);
		/* Added Against Start PMG2017-COMN-CRF-0012 [IN066074] */
		stmt.setString(++index,locale);
		stmt.setString(++index,facility_id);
		stmt.setString(++index,encounterId);
		stmt.setString(++index,mealType);
		stmt.setString(++index,locale);
		stmt.setString(++index,locale);
		stmt.setString(++index,convrtServingDate);
		/* Added Against End PMG2017-COMN-CRF-0012 [IN066074] */
		rs = stmt.executeQuery();
%>
<form name='QueryResult' id='QueryResult'>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
<br/>
<br/>
<table width="100%" border=1 cellpading='0' cellspacing='0'>
	<tr>
		<th>
			<fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/>
		</th>
		<th>
			<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}"/>
		</th>
		<th>
			<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}"/>
		</th>
		<th>
			<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
		</th>
		<th>
			<fmt:message key="eOT.ServingQty.Label" bundle="${ot_labels}"/>
		</th>
		<th>
			<fmt:message key="eOT.Uom.Label" bundle="${ot_labels}"/>
		</th>
	</tr>

<%
	int i=0;
	String classValue= " ";
    while ( rs.next() )
	{
    if ( i % 2 == 0 )
        classValue = "QRYEVEN" ;  
    else
        classValue = "QRYODD" ;  
    out.println("<tr>");
    itemSL = rs.getString("item_Sl");
    itemDesc =rs.getString("itemtype_desc");
    foodDesc= rs.getString("food_desc");
    servindDate = com.ehis.util.DateUtils.convertDate(rs.getString("serving_Date"),"DMYHMS", "en", locale);
    itemQty = rs.getString("item_Qty");
    servUom = rs.getString("serving_Uom_Code");
    
    if(itemSL == null) itemSL="&nbsp;";
    if(itemDesc == null) itemDesc="&nbsp;";
    if(foodDesc == null) foodDesc="&nbsp;";
    if(servindDate == null) servindDate="&nbsp;";
    if(itemQty == null) itemQty="&nbsp;";
    if(servUom == null) servUom="&nbsp;";
    
	out.println("<td class='" + classValue+"' nowrap>"+itemSL+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+itemDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+foodDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+servindDate+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+itemQty+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+servUom+"</td>");
	out.println("</tr>");
	i++;
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
</table>
<br/>
<table width="100%"  cellpading='0' cellspacing='0'>
<tr>
<td width="90%">
</td>
<td width="10%">
<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="javascript:window.close();">
</td>
</tr>
</table>
</form>
</BODY>
</HTML>

