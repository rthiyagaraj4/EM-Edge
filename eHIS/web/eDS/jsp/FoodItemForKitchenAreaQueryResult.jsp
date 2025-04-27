<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% 
String locale = (String)session.getAttribute("LOCALE");
String facility_Id = (String)session.getAttribute("facility_id");
%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<head>
	<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			
             // Checkstyle Violation commented by Munisekhar
			//String style="";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
String ph_module_yn = request.getParameter("ph_module_yn");
PreparedStatement stmt = null;
ResultSet rs = null;
Connection conn = null;
conn = ConnectionManager.getConnection(request);

try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = checkForNull(request.getParameter( "from" ));
    String to = checkForNull(request.getParameter( "to" ));
    String sql = " ";
    String strsql = "select c.SHORT_DESC, d.SHORT_DESC,b.SHORT_DESC from DS_KITCHEN_AREA_ITEMS a, DS_ITEMS b,DS_KITCHENS c, DS_KITCHEN_AREA d where a.OPERATING_FACILITY_ID=c.OPERATING_FACILITY_ID and a.KITCHEN_CODE=c.KITCHEN_CODE and a.OPERATING_FACILITY_ID=d.OPERATING_FACILITY_ID and a.KITCHEN_CODE=d.KITCHEN_CODE and a.KITCHEN_AREA_CODE=d.KITCHEN_AREA_CODE and ((a.FOOD_ITEM_CODE=b.FOOD_ITEM_CODE )and(a.OPERATING_FACILITY_ID like '"+facility_Id+"' ) and(b.LANGUAGE_ID like '"+locale+"'))";
    String kitchen =request.getParameter("kitchen")==null?"":request.getParameter( "kitchen" ).trim().toUpperCase();
    String kitchenArea =request.getParameter("kitchenArea")==null?"":request.getParameter( "kitchenArea" ).trim().toUpperCase();
    String foodItem =request.getParameter("foodItem")==null?"":request.getParameter( "foodItem" ).trim().toUpperCase();
	int start = (from.equals(""))?1:Integer.parseInt(from);
	int end = (to.equals(""))?14:Integer.parseInt(to);
    //IN::41190 - start
    if ( (whereClause == null || whereClause.equals("")) )
    {
    	int cnt=0;
    	if ( !(kitchen == null || kitchen.equals("")) ){
	        sql = sql + " and upper(a.kitchen_code) like upper('"+kitchen+"%')";
			cnt++;
        }
    	
    	if ( !(kitchenArea == null || kitchenArea.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.kitchen_Area_code) like '"+kitchenArea+"%'";
			else{
				sql=sql+" and upper(a.kitchen_Area_code) like '"+kitchenArea+"%'";
				cnt=1;
			}

        }
    	if ( !(foodItem == null || foodItem.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(b.food_Item_code) like '"+foodItem+"%'";
			else{
				sql=sql+" and upper(b.food_Item_code) like '"+foodItem+"%'";
				cnt=1;
			}

        }
   } //end of where clause IF
        else
         sql = whereClause;
    //IN::41190 - End
    

    int maxRecord = 0;
    String classValue= "";
    String kitchen1 = "";
    String kitchen_Area = "";
    String food_Item = "";
    strsql = strsql+sql;
    try{
		stmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery();
		//getting maximum record
    	rs.last();	maxRecord = rs.getRow();
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
		rs.beforeFirst();
	}catch(Exception e){
		out.println("Exception "+e);
	}
    
    %>
 <form name='QueryResult' id='QueryResult'>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/FoodItemForKitchenAreaQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/FoodItemForKitchenAreaQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
<!--
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>-->
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
</td>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.KitchenArea.Label" bundle="${ot_labels}"/>
</td>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}"/>
</td>	


<%
if ( start!= 1 ) rs.absolute(start-1);
int i=start;
while(rs != null && rs.next() && i<=end){
		if ( i % 2 == 0 )
			classValue = "QRYODD" ;
		else
			classValue = "QRYEVEN" ;
		
		
		kitchen1 = rs.getString(1);
		kitchen_Area = rs.getString(2);
		food_Item = rs.getString(3);
%>
	<tr>
		<td class='<%=classValue%>' width='12%' nowrap><%=kitchen1%></td>
		<td class='<%=classValue%>' width='12%' nowrap><%=kitchen_Area%></td>
		<td class='<%=classValue%>' width='12%' nowrap><%=food_Item%></td>
	</tr>	
<%
i++;
	}
}

catch(Exception e){
	out.println("Exception "+e);
}
finally{
	if(stmt!=null)	stmt.close();
	if(rs!=null)	rs.close();
	if(conn != null){
		ConnectionManager.returnConnection(conn,request);
	}
}

%>
</table>
</form>
</BODY>
</head>



