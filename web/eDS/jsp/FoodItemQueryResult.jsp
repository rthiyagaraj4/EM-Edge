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
	String longDesc =request.getParameter("long_Desc")==null?"":request.getParameter( "long_Desc" ).trim().toUpperCase();
	String shortDesc =request.getParameter("short_Desc")==null?"":request.getParameter( "short_Desc" ).trim().toUpperCase();
	String itemType =request.getParameter("item_Type")==null?"":request.getParameter( "item_Type" ).trim();
    String servingUom = request.getParameter("serving_Uom")==null?"":request.getParameter( "serving_Uom").trim();
    String preparationUom = request.getParameter("preparation_Uom")==null?"":request.getParameter( "preparation_Uom").trim();
    String baseQty = request.getParameter("base_Qty")==null?"":request.getParameter( "base_Qty").trim();
    String preparationFactor = request.getParameter("preparation_Factor")==null?"":request.getParameter( "preparation_Factor").trim().toUpperCase();
    String enabled = request.getParameter("enable")==null?"":request.getParameter( "enable");
    String calorieContent = request.getParameter("calorie_Content")==null?"":request.getParameter( "calorie_Content").trim().toUpperCase();


    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(foodItem == null || foodItem.equals("")) ){
	        sql = sql + " where upper(food_item_code ) like upper('"+foodItem +"%')";
			cnt++;
        }

        if ( !(longDesc == null || longDesc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(long_desc) like '"+longDesc+"%'";
			else{
				sql=sql+" where upper(long_desc) like '"+longDesc+"%'";
				cnt=1;
			}

        }
	   if ( !(shortDesc == null || shortDesc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(short_desc) like '"+shortDesc+"%'";
			else{
				sql=sql+" where upper(short_desc) like '"+shortDesc+"%'";
				cnt=1;
			}

        }

	if ( !(itemType == null || itemType.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(item_type) like '"+itemType+"%'";
			else{
				sql=sql+" where upper(item_type) like '"+itemType +"%'";
				cnt =1;
			}
        }


	if ( !(servingUom == null || servingUom.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(serving_uom_code) like '"+servingUom+"%'";
		else{
			sql=sql+" where upper(serving_uom_code) like '"+servingUom+"%'";
			cnt=1;
		}

    }

	if ( !(preparationUom == null || preparationUom.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(prep_uom) like '"+preparationUom+"%'";
		else{
			sql=sql+" where upper(prep_uom) like '"+preparationUom +"%'";
			cnt =1;
		}
    }

	if ( !(baseQty == null || baseQty.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(prep_base_qty) like '"+baseQty+"%'";
		else{
			sql=sql+" where upper(prep_base_qty) like '"+baseQty +"%'";
			cnt =1;
		}
    }

	if ( !(preparationFactor == null || preparationFactor.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(prep_factor) like '"+preparationFactor+"%'";
		else{
			sql=sql+" where upper(prep_factor) like '"+preparationFactor +"%'";
			cnt =1;
		}
    }

	if ( !(calorieContent == null || calorieContent.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(calorific_cont_per_uom) like '"+calorieContent+"%'";
		else{
			sql=sql+" where upper(calorific_cont_per_uom) like '"+calorieContent +"%'";
			cnt =1;
		}
    }

	if (!(enabled.equals("B"))){

		if(enabled.equals("E")){
			if(cnt>0)
				   sql = sql+" and nvl(eff_status,'D')='E' ";
				else{
					sql=sql+ " where nvl(eff_status,'D')='E' ";
					cnt=1;
				}
		}
		else if(enabled.equals("D")){
			if(cnt>0)
				   sql = sql+" and nvl(eff_status,'D')='D' ";
				else{
					sql=sql+ " where nvl(eff_status,'D')='D' ";
					cnt=1;
				}
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

Connection conn  =  ConnectionManager.getConnection(request);
PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;
	try{
		String strsql="select count(*) as total from ds_food_item "+sql;
		String strsql1="select food_item_code,long_desc,short_desc,ds_get_desc.ds_item_type(item_type,?,2)item_type,serving_uom_code, "+
				"calorific_cont_per_uom,prep_uom,prep_factor,prep_base_qty,eff_status "+
				"from ds_food_item "+sql; //Modified Against PMG2017-COMN-CRF-0012 [IN066074]
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,locale); //Added Against PMG2017-COMN-CRF-0012 [IN066074]
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
    out.println("<A HREF='../../eDS/jsp/FoodItemQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/FoodItemQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.FoodItemCode.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.ServingUOM.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.PreparationUOM.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.PreparationBaseQty.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.CalorieContentUOM.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.PreparationFactor.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</th>

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
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

    foodItem = checkForNull(rset.getString(1));
    longDesc=checkForNull(rset.getString(2));
    shortDesc= checkForNull(rset.getString(3));
    itemType = checkForNull(rset.getString(4));
    servingUom = checkForNull(rset.getString(5));
    calorieContent = checkForNull(rset.getString(6));
    preparationUom = checkForNull(rset.getString(7));
    preparationFactor = checkForNull(rset.getString(8));
    baseQty = checkForNull(rset.getString(9));
    enabled = checkForNull(rset.getString(10));

	String mode="modify";
	out.println("<a href='../../eDS/jsp/FoodItemAddModify.jsp?mode="+mode+"&foodItem="+ foodItem+"' target='f_query_add_mod' >");
    out.println(foodItem+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+longDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+shortDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+itemType+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+servingUom+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+preparationUom+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+baseQty+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+calorieContent+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+preparationFactor+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( enabled.equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	
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
if(rset!=null) rset.close();
ConnectionManager.returnConnection(conn,request);
}catch(Exception e){
	e.printStackTrace();
}
%>
</center>
</form>
</BODY>
</HTML>

