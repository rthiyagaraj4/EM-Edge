<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String ph_module_yn = request.getParameter("ph_module_yn");
	try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String foodItem = request.getParameter("food_Item")==null?"":request.getParameter( "food_Item" ).trim().toUpperCase();
	String ingredients =request.getParameter("ingredient_Code")==null?"":request.getParameter( "ingredient_Code" ).trim().toUpperCase();
	String uom =request.getParameter("uom_Code")==null?"":request.getParameter( "uom_Code").trim().toUpperCase();

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(foodItem == null || foodItem.equals("")) ){
	        sql = sql + " where upper(food_item_code ) like upper('"+foodItem +"%')";
			cnt++;
        }

	   if ( !(ingredients == null || ingredients.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(ingredient_code) like '"+ingredients+"%'";
			else{
				sql=sql+" where upper(ingredient_code) like '"+ingredients+"%'";
				cnt=1;
			}

        }


	if ( !(uom == null || uom.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(ingredient_uom) like '"+uom+"%'";
		else{
			sql=sql+" where upper(ingredient_uom) like '"+uom +"%'";
			cnt =1;
		}
    }


    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql=sql+" order by ";
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql=sql+ord[i];
        else
            sql=sql+ord[i]+",";
        }
    }

    } //end of where clause IF
    else
            sql = whereClause;



    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

Connection conn  		= ConnectionManager.getConnection(request);
PreparedStatement stmt  = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;
	try{
		String strsql="select count(*) as total from ds_food_item_ingredients "+sql;
		String strsql1="select ds_get_desc.ds_food_item(food_item_code,?,2)  food_item_code,ds_get_desc.ds_ingredient(ingredient_code,?,2) ingredient_code,ingredient_qty from ds_food_item_ingredients "+sql; // Modified Against PMG2017-COMN-CRF-0012 [IN:066074]US2		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		// Added below Against PMG2017-COMN-CRF-0012 [IN:066074]US2	
		stmt1.setString(1,locale);
		stmt1.setString(2,locale);
		rset = stmt1.executeQuery();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/RecipeQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/RecipeQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.FoodItem.Label" bundle="${ot_labels}"/> <!-- PMG2017-COMN-CRF-0012 [IN:066074] -->
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.Ingredients.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.BaseQty.Label" bundle="${ot_labels}"/>
</td>
<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
		String classValue= " ";
      while ( rset.next() && i<=end  )
		{
		if ( i % 2 == 0 )
			classValue = "gridData" ;  
		else
        classValue = "gridData" ;  
    out.println("<tr>");

    foodItem = checkForNull(rset.getString(1));
    ingredients = checkForNull(rset.getString(2));
    uom = checkForNull(rset.getString(3));

    out.println("<td class='" + classValue+"' nowrap>"+foodItem+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+ingredients+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+uom+"</td>");
	i++;
} %>
</td></tr>
</table>
</center>
<br><center>
<%
if(stmt!=null)	stmt.close();
if(stmt1!=null)	stmt1.close();
if(rs!=null)	rs.close();
if(rset!=null)  rset.close();
ConnectionManager.returnConnection(conn,request);
}catch(Exception e){
	e.printStackTrace();
}
%>
</center>
</form>
</BODY>
</HTML>

