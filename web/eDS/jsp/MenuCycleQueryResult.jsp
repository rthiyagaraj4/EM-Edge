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
	String dietType = request.getParameter("diet_Type")==null?"":request.getParameter( "diet_Type" ).trim().toUpperCase();
	String mealClass =request.getParameter("meal_Class")==null?"":request.getParameter( "meal_Class" ).trim().toUpperCase();
	String menuSchdCycle =request.getParameter("menu_Schd_Cycle")==null?"":request.getParameter( "menu_Schd_Cycle");
	String dayNo = request.getParameter("day_No")==null?"":request.getParameter( "day_No");
	String enabled = request.getParameter("enable")==null?"":request.getParameter( "enable");
	// Added Below Against PMG2017-COMN-CRF-0012 [IN066074]US2
	String dietTypeDesc = "";
	String mealClassDesc = "";

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(dietType == null || dietType.equals("")) ){
	        sql = sql + " where upper(diet_type ) like upper('"+dietType +"%')";
			cnt++;
        }

	   if ( !(mealClass == null || mealClass.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(meal_class) like '"+mealClass+"%'";
			else{
				sql=sql+" where upper(meal_class) like '"+mealClass+"%'";
				cnt=1;
			}

        }


	if ( !(dayNo == null || dayNo.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(meal_plan_ref_day_no) like '"+dayNo+"%'";
		else{
			sql=sql+" where upper(meal_plan_ref_day_no) like '"+dayNo +"%'";
			cnt =1;
		}
    }

	if ( !(menuSchdCycle == null || menuSchdCycle.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(menu_sched_cycle_days) like '"+menuSchdCycle+"%'";
		else{
			sql=sql+" where upper(menu_sched_cycle_days) like '"+menuSchdCycle +"%'";
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

		String strsql="select count(*) as total from DS_DIET_MENU_SCHED_CYCLE "+sql;
		String strsql1="select diet_type,meal_class,meal_plan_ref_day_no,menu_sched_cycle_days,"+					"eff_status, ds_get_desc.ds_diet_type(diet_type,?,2) diet_type_desc,"+ "ds_get_desc.ds_meal_class(meal_class,?,2)  meal_class_desc from DS_DIET_MENU_SCHED_CYCLE "+sql; // Modified Against PMG2017-COMN-CRF-0012 [IN066074]US2		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		// Added Below Against PMG2017-COMN-CRF-0012 [IN066074]US2
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
    out.println("<A HREF='../../eDS/jsp/MenuCycleQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MenuCycleQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
	<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.MenuSchedCycle.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.RefDayNo.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
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
			
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

    dietType = checkForNull(rset.getString(1));
    mealClass = checkForNull(rset.getString(2));
    dayNo= checkForNull(rset.getString(3));
    menuSchdCycle = checkForNull(rset.getString(4));
    enabled = checkForNull(rset.getString(5));
    // Added Below Against PMG2017-COMN-CRF-0012 [IN066074]US2
    dietTypeDesc = checkForNull(rset.getString(6));
    mealClassDesc = checkForNull(rset.getString(7));

	String mode="modify";

	out.println("<a href='../../eDS/jsp/MenuCycleAddModify.jsp?mode="+mode+"&dietType="+
	dietType+"&mealClass="+mealClass+"' target='f_query_add_mod' >");

    out.println(dietTypeDesc+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+mealClassDesc+"</td>");
    //out.println("<td class='" + classValue+"' nowrap>"+dayNo+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+menuSchdCycle+"</td>");
    //out.println("<td class='" + classValue+"' nowrap>"+menuSchdCycle+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+dayNo+"</td>");
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

