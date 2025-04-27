<!DOCTYPE html>
<!-- New file PlaceOrderRightsQueryResult.jsp created against ML-MMOH-CRF-0677  -->
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String facility_id=(String) session.getAttribute("facility_id");
    String appl_user_id = request.getParameter("appl_user_id")==null?"":request.getParameter( "appl_user_id" );
	String appl_user_name =request.getParameter("appl_user_name")==null?"":request.getParameter( "appl_user_name" );
    String edit_meals_yn =request.getParameter("edit_meals_yn")==null?"":request.getParameter( "edit_meals_yn" );
    String nutrient_supplement_yn = request.getParameter("nutrient_supplement_yn")==null?"":request.getParameter( "nutrient_supplement_yn");
	String food_dislike_yn = request.getParameter("food_dislike_yn")==null?"":request.getParameter( "food_dislike_yn");
	String special_food_order_yn = request.getParameter("special_food_order_yn")==null?"":request.getParameter( "special_food_order_yn");
		
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(appl_user_id == null || appl_user_id.equals("")) ){
	        sql = sql + " and upper(a.appl_user_id ) like upper('"+appl_user_id +"%')";
			cnt++;
        }

        if ( !(appl_user_name == null || appl_user_name.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(b.appl_user_name) like upper('"+appl_user_name+"%')";
			else{
				sql=sql+" and upper(b.appl_user_name) like upper('"+appl_user_name+"%')";
				cnt=1;
		}

    }	
	if ( !(edit_meals_yn == null || edit_meals_yn.equals("")) ){
		
        if( edit_meals_yn.equals("N") ){

			if(cnt>0)
			   sql = sql+" and nvl(a.edit_meals_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.edit_meals_yn,'N')='N' ";
				cnt=1;
			}
		}
	}

		if ( edit_meals_yn.equals("Y") ){
             
            if(cnt>0)
			   sql = sql+" and a.edit_meals_yn='Y'";
			else
				sql=sql+ "and  a.edit_meals_yn='Y'";
         }

         if ( edit_meals_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }

	if ( !(nutrient_supplement_yn == null || nutrient_supplement_yn.equals("")) ){
         if( nutrient_supplement_yn.equals("N") ){

			if(cnt>0)
			   sql = sql+" and nvl(a.nutrient_supplement_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.nutrient_supplement_yn,'N')='N' ";
				cnt=1;
			}
         }
	}

		 if ( nutrient_supplement_yn.equals("Y") ){

            if(cnt>0)
			   sql = sql+" and a.nutrient_supplement_yn='Y'";
			else
				sql=sql+ "and a.nutrient_supplement_yn='Y'";
         }

         if ( nutrient_supplement_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }

	 if ( !(food_dislike_yn == null || food_dislike_yn.equals("")) ){
         if( food_dislike_yn.equals("N") ){

			if(cnt>0)
			   sql = sql+" and nvl(a.food_dislike_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.food_dislike_yn,'N')='N' ";
				cnt=1;
			}
         }
	}
		 if ( food_dislike_yn.equals("Y") ){

            if(cnt>0)
			   sql = sql+" and a.food_dislike_yn='Y'";
			else
				sql=sql+ "and  a.food_dislike_yn='Y'";
         }

        
		 if ( food_dislike_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
         
	if ( !(special_food_order_yn == null || special_food_order_yn.equals("")) ){
			 
         if( special_food_order_yn.equals("N") ){
               
			if(cnt>0)
			   sql = sql+" and nvl(a.special_food_order_yn,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.special_food_order_yn,'N')='N' ";
				cnt=1;
			}
         }
	}

		 if ( special_food_order_yn.equals("Y") ){
          
            if(cnt>0)
			   sql = sql+" and a.special_food_order_yn='Y'";
			else
				sql=sql+ "and  a.special_food_order_yn='Y'";
         }

         if ( special_food_order_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
	
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
		
		String strsql="SELECT a.appl_user_id, b.appl_user_name,NVL (a.edit_meals_yn, 'N') edit_meals_yn,NVL (a.nutrient_supplement_yn, 'N') nutrient_supplement_yn,NVL (a.food_dislike_yn, 'N') food_dislike_yn,NVL (a.special_food_order_yn, 'N') special_food_order_yn FROM ds_place_diet_order_rights a, sm_appl_user b WHERE a.operating_facility_id = ? AND a.appl_user_id = b.appl_user_id "+sql;

		String strsql1="SELECT a.appl_user_id, b.appl_user_name,NVL (a.edit_meals_yn, 'N') edit_meals_yn,NVL (a.nutrient_supplement_yn, 'N') nutrient_supplement_yn,NVL (a.food_dislike_yn, 'N') food_dislike_yn,NVL (a.special_food_order_yn, 'N') special_food_order_yn FROM ds_place_diet_order_rights a, sm_appl_user b WHERE a.operating_facility_id = ? AND a.appl_user_id = b.appl_user_id "+sql;
		
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,facility_id);
		rs = stmt.executeQuery();
        	int total=0;
		while(rs.next())
		{
			total++;
		}
		maxRecord = total;
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,facility_id);
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
    out.println("<A HREF='../../eDS/jsp/PlaceOrderRightsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
    
if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/PlaceOrderRightsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3 align='center'>
<td class='COLUMNHEADERCENTER' nowrap>User ID</td> 
<td class='COLUMNHEADERCENTER' nowrap>
	<fmt:message key="Common.name.label" bundle="${common_labels}"/>
</td>
<td class='COLUMNHEADERCENTER' nowrap>
	<fmt:message key="eDS.EditMeals.Label" bundle="${ds_labels}"/>
</td>
<td class='COLUMNHEADERCENTER' nowrap>
	<fmt:message key="eDS.NutrientSupplement.Label" bundle="${ds_labels}"/>
</td>
<td class='COLUMNHEADERCENTER' nowrap>
	<fmt:message key="eDS.FoodDislike.Label" bundle="${ds_labels}"/>
</td>
<td class='COLUMNHEADERCENTER' nowrap>
	<fmt:message key="eDS.SpecialFoodOrder.Label" bundle="${ds_labels}"/>
</td>

<%
   if ( start != 1 )
   {
   }
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String classValue= " ";
      while ( rset.next() && i<=end  )
	  {
		if ( i % 2 == 0 )
            classValue = "gridData" ; 
        else
            classValue = "gridData" ;
    out.println("<tr><td align=='left' class='" + classValue + "'>");

    appl_user_id = rset.getString(1);
	
    appl_user_name=rset.getString(2);
	
    edit_meals_yn=rset.getString(3);
	
    nutrient_supplement_yn=rset.getString(4);
	
    food_dislike_yn=rset.getString(5);
	
    special_food_order_yn=rset.getString(6);
	
	String mode="modify";
	out.println("<a href='../../eDS/jsp/PlaceOrderRightsAddModify.jsp?mode="+mode+"&appl_user_id="+ appl_user_id+"&appl_user_name="+appl_user_name+"' target='f_query_add_mod' >");
    out.println(appl_user_id+"</a></td>");
    out.println("<td class='" + classValue+"'>"+appl_user_name+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("edit_meals_yn").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");
		out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("nutrient_supplement_yn").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");
		out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("food_dislike_yn").equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");
		out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("special_food_order_yn").equals("Y") )
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
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

