<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
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
	String Attendent_Label_Name = request.getParameter("Attendent_Label_Name");//ML-MMOH-CRF-0406
	
try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String dietType = request.getParameter("diet_Type")==null?"":request.getParameter( "diet_Type" ).trim().toUpperCase();
	String mealClass =request.getParameter("meal_Class")==null?"":request.getParameter( "meal_Class" ).trim().toUpperCase();
	String mealCategory =request.getParameter("meal_Category")==null?"":request.getParameter( "meal_Category" ).trim().toUpperCase();
	String meal_category_code="";//ML-ML-MMOH-CRF-0406
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(dietType == null || dietType.equals("")) ){
	        sql = sql + " where upper(default_diet_type) like upper('"+dietType +"%')";
			cnt++;
        }

        if ( !(mealClass == null || mealClass.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(default_meal_class) like '"+mealClass+"%'";
			else{
				sql=sql+" where upper(default_meal_class) like '"+mealClass+"%'";
				cnt=1;
			}

        }
	   if ( !(mealCategory == null || mealCategory.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(meal_category_code) like '"+mealCategory+"%'";
			else{
				sql=sql+" where upper(meal_category_code) like '"+mealCategory+"%'";
				cnt=1;
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
		String strsql="select count(*) as total from DS_MEAL_CATEGORY "+sql;
		String strsql1="select description,ds_get_desc.ds_diet_type(default_diet_type, ? , 2 ) default_diet_type, ds_get_desc.ds_meal_class (default_meal_class, ? , 2 ) default_meal_class, meal_category_code from DS_MEAL_CATEGORY "+sql; //Modified Against PMG2017-COMN-CRF-0012 [IN066074]
		//ML-MMOH-CRF-0406
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		//Added Against below PMG2017-COMN-CRF-0012 [IN066074]
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
    out.println("<A HREF='../../eDS/jsp/MealCategoryQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "&Attendent_Label_Name="+Attendent_Label_Name+"'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");//ML-MMOH-CRF-406

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MealCategoryQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"&Attendent_Label_Name="+Attendent_Label_Name+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");//ML-MMOH-CRF-406
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
	<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
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

	mealCategory = checkForNull(rset.getString(1));
    dietType= checkForNull(rset.getString(2)); 
    mealClass= checkForNull(rset.getString(3));
    meal_category_code= checkForNull(rset.getString(4));//ML-ML-MMOH-CRF-0406
  	
	String mode="modify";
	out.println("<a href='../../eDS/jsp/MealCategoryAddModify.jsp?mode="+mode+"&mealCategory="+ mealCategory+"&Attendent_Label_Name="+Attendent_Label_Name+"&meal_category_code="+meal_category_code+"' target='f_query_add_mod' >");//ML-ML-MMOH-CRF-0406
    out.println(mealCategory+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+dietType+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+mealClass+"</td>");
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

