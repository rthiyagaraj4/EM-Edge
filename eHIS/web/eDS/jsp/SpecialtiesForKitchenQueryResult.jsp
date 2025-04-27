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
	String facility_id = (String) session.getValue("facility_id");
	try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String kitchenCode = request.getParameter("kitchen_Code")==null?"":request.getParameter( "kitchen_Code" ).trim().toUpperCase();
	String specialityCode =request.getParameter("speciality_Code")==null?"":request.getParameter( "speciality_Code" ).trim().toUpperCase();

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(kitchenCode == null || kitchenCode.equals("")) ){
	        sql = sql + " where upper(kitchen_code ) like upper('"+kitchenCode +"%') and operating_facility_id = ?";
			cnt++;
        }

	   if ( !(specialityCode == null || specialityCode.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(speciality_Code) like '"+specialityCode+"%'";
			else{
				sql=sql+" where upper(speciality_code) like '"+specialityCode+"%' and operating_facility_id = ?";
				cnt=1;
			}

        }

	   if(cnt==0){
		   sql = sql + " where operating_facility_id = ?";
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
		String strsql="select count(*) as total from Ds_Speciality_Kitchen_Vw "+sql;
		//String strsql1="select kitchen_code,speciality_code from Ds_Speciality_Kitchen_Vw "+sql;
		String strsql1="select KITCHEN_DESC,SPECIALITY_DESC from Ds_Speciality_Kitchen_Vw "+sql;
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,facility_id);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
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
    out.println("<A HREF='../../eDS/jsp/SpecialtiesForKitchenQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/SpecialtiesForKitchenQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
			<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
		</td>
		<td class="COLUMNHEADERCENTER" nowrap>
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <!-- IN::39899 -->
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
/* 	if(rset.getString(1) == null){
		kitchenCode = "&nbsp;";
	}else{ */
		kitchenCode = checkForNull(rset.getString(1));
	//}
	specialityCode = checkForNull(rset.getString(2));
    out.println("<td class='" + classValue+"' nowrap>"+kitchenCode+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+specialityCode+"</td>");
    out.println("</tr>");
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

