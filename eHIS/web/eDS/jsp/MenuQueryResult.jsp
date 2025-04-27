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
    String menu = request.getParameter("menu")==null?"":request.getParameter( "menu" ).trim().toUpperCase();
	String longDesc =request.getParameter("long_Desc")==null?"":request.getParameter( "long_Desc" ).trim().toUpperCase();
	String shortDesc =request.getParameter("short_Desc")==null?"":request.getParameter( "short_Desc").trim().toUpperCase();
	String dietType = request.getParameter("diet_Type")==null?"":request.getParameter( "diet_Type" ).trim().toUpperCase();
	String mealType =request.getParameter("meal_Type")==null?"":request.getParameter( "meal_Type" ).trim().toUpperCase();
	String mealClass =request.getParameter("meal_Class")==null?"":request.getParameter( "meal_Class").trim().toUpperCase();
	String enabled = request.getParameter("enable")==null?"":request.getParameter( "enable");
	/* Added Against Start ML-MOH-CRF-1006-US5 */
	String patientClass = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	//System.err.println("35,patientClass===="+patientClass);
	String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	String emergency =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
	String inpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
	String Outpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
	String Staff =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Staff.label","common_labels");
	String patClass="";
	/* Added Against End ML-MOH-CRF-1006-US5 */
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(menu == null || menu.equals("")) ){
	        sql = sql + " where upper(menu_code ) like upper('"+menu +"%')";
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
			sql=sql+" where upper(short_desc) like '"+shortDesc +"%'";
			cnt =1;
		}
    }
	
	/* Added Against Start ML-MOH-CRF-1006-US5 */
	if ( !(patientClass == null || patientClass.equals("") || patientClass.equalsIgnoreCase("all")) ){
		if(cnt>0)
			sql = sql + " and patient_class = '"+patientClass+"'";
		else{
			sql=sql+" where patient_class = '"+patientClass+"'";
			cnt =1;
		}
    }	
	   /* Added Against End ML-MOH-CRF-1006-US5 */

	if ( !(dietType == null || dietType.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(diet_type) like '"+dietType+"%'";
		else{
			sql=sql+" where upper(diet_type) like '"+dietType +"%'";
			cnt =1;
		}
    }

	if ( !(mealType == null || mealType.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(meal_type) like '"+mealType+"%'";
		else{
			sql=sql+" where upper(meal_type) like '"+mealType +"%'";
			cnt =1;
		}
    }

	if ( !(mealClass == null || mealClass.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(meal_class) like '"+mealClass+"%'";
		else{
			sql=sql+" where upper(meal_class) like '"+mealClass +"%'";
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
		String strsql="select count(*) as total from ds_menu "+sql;
		String strsql1="select menu_code,long_desc,short_desc,ds_get_desc.ds_diet_type (diet_type, ?, 2) diet_type,ds_get_desc.ds_meal_type (meal_type, ?, 2) meal_type, ds_get_desc.ds_meal_class (meal_class,?,2) meal_class,eff_status,patient_class from ds_menu "+sql;
		//(patient_class) Modified Against ML-MOH-CRF-1006-US5 and PMG2017-COMN-CRF-0012 [IN066074]	
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		// Added Against Start PMG2017-COMN-CRF-0012 [IN066074]	
		stmt1.setString(1,locale);
		stmt1.setString(2,locale);
		stmt1.setString(3,locale);
		// Added Against End PMG2017-COMN-CRF-0012 [IN066074]	
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
    out.println("<A HREF='../../eDS/jsp/MenuQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MenuQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
	<fmt:message key="eOT.Menu.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
</td>
<!-- Added Against Start ML-MOH-CRF-1006-US5 -->
<td class="COLUMNHEADERCENTER" nowrap>
<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
</td>
<!-- Added Against End ML-MOH-CRF-1006-US5 -->
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
</td>
<td class="COLUMNHEADERCENTER" nowrap>
	<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
</td>
<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String classValue= " ";
      while ( rset.next() && i<=end  )
		{
		if ( i % 2 == 0 )
            classValue = "gridData" ;  // changed by yadav
        else
            classValue = "gridData" ;  // changed by yadav
       
	   out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

    menu = checkForNull(rset.getString(1));
    longDesc = checkForNull(rset.getString(2));
    shortDesc = checkForNull(rset.getString(3));
    dietType = checkForNull(rset.getString(4));
    mealType = checkForNull(rset.getString(5));
   	mealClass =checkForNull(rset.getString(6));
    enabled = checkForNull(rset.getString(7));
	/* Added Against Start ML-MOH-CRF-1006-US5 */
    patientClass = checkForNull(rset.getString(8));
	
	if(patientClass.equalsIgnoreCase("EM"))
		patClass = emergency;	
	else if(patientClass.equalsIgnoreCase("IP"))
		patClass = inpatient;	
	else if(patientClass.equalsIgnoreCase("OP"))
		patClass = Outpatient;	
	else if(patientClass.equalsIgnoreCase("ST"))
		patClass = Staff;
	else 
		patClass = all;		
	/* Added Against End ML-MOH-CRF-1006-US5 */
    String mode="modify";
    out.println("<a href='../../eDS/jsp/MenuAddModify.jsp?mode="+mode+"&menu="+ menu+"' target='f_query_add_mod' >");
    out.println(menu+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+longDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+shortDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+patClass+"</td>"); //Added Against Start ML-MOH-CRF-1006-US5
    out.println("<td class='" + classValue+"' nowrap>"+dietType+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+mealClass+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+mealType+"</td>");
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

