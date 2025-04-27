<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  >
<%//Connection conn = (Connection) session.getValue( "connection" ) ;
Connection conn =null;
Statement stmt=null;
Statement stmt1=null;
ResultSet rset=null;
ResultSet rs=null;

try{
	   request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	String Log_user= (String) session.getValue("login_user");
	//int Medadmin=0;
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	sql.append(" where (ADHOC_MENU_YN ='N' OR  TRUNC(SYSDATE) BETWEEN Nvl(ADHOC_MENU_EFF_FROM,TRUNC(SYSDATE)) AND NVL(ADHOC_MENU_EFF_TO ,TRUNC(SYSDATE))) AND A.menu_id=B.menu_id(+) and A.resp_group_id=c.resp_group_id(+) ");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	stmt1=conn.createStatement();
	
	String sql_m="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";
	rset=stmt1.executeQuery(sql_m);
	if (rset !=null){
		while (rset.next()){
					//Medadmin=Integer.parseInt(rset.getString(1));
			}
	}
		
	if ( (whereClause == null || whereClause.equals("")) )
	{

	String responsibilityID = request.getParameter("resp_id");
	String responsibilityName=request.getParameter("resp_name");
	String menuID= request.getParameter("menu_id");
	String menuname= request.getParameter("menu_name");
	String resp_group_id= request.getParameter("resp_group_id");
	String role_id= request.getParameter("role_id");
	String effstatus = request.getParameter("eff_status")==null?"D":request.getParameter("eff_status");
	String resp_grp_name = request.getParameter("resp_grp_name");
	String desktop_code = request.getParameter("desktop_code");

	responsibilityID=responsibilityID.toUpperCase();
	menuID=menuID.toUpperCase();

	if ( !(responsibilityID == null || responsibilityID.equals("")) )
		{
		sql.append("and upper(A.resp_id) like upper('"+responsibilityID+"%' )");
		}


	if ( !(responsibilityName == null || responsibilityName.equals("")) )
	{
			sql.append(" and upper(A.resp_name)  like upper('"+responsibilityName+"%')  " );
	}

	if ( !(menuID == null || menuID.equals("")) )
	{
		sql.append(" and upper(B.menu_id) like  upper('"+menuID+"%' )" );
	}

	if ( !(menuname == null || menuname.equals("")) )
	{
		sql.append(" and upper(B.menu_name)  like  upper('"+menuname+"%') ");
	}


	
	if ( !(resp_group_id == null || resp_group_id.equals("")) )
		{
			sql.append(" and upper(A.resp_group_id) like  upper('"+resp_group_id+"%' )" );
		}


	if ( !(role_id == null || role_id.equals("")) )
	{
		sql.append(" and upper(A.ORA_ROLE_ID) like  upper('"+role_id+"%') " );
	}

	if ( !(resp_grp_name == null || resp_grp_name.equals("")) )
	{
		sql.append( " and upper(c.RESP_GROUP_NAME)   like  upper('"+resp_grp_name+"%')  " );
	}

	if ( !(desktop_code == null || desktop_code.equals("")) )
	{
		sql.append( " and upper(a.desktop_code)   like  upper('"+desktop_code+"%')  " );
	}

	if ( !(effstatus == null || effstatus.equals("")) )
	{
	   if ( effstatus.equals("E") )
	     {
				sql.append( " and A.eff_status='E'");
		 }
	   if ( effstatus.equals("D") )
		{
			sql.append( " and A.eff_status='D'");
		}
	  
	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	
	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}


	} //end of where clause IF
	else
	{
	sql.setLength(0);
	sql.append(whereClause);
	}   
        
	int start = 0;
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
		int cnt = 0;
		String endOfRes="1";


	stmt = conn.createStatement();

		String strsql2="select A.resp_id,A.resp_name,A.menu_id,A.RESP_GROUP_ID,A.desktop_code,A.ORA_ROLE_ID,B.menu_name,A.eff_date_from,A.eff_date_to,A.eff_status,c.RESP_GROUP_NAME,a.SYS_DEFINED_YN from sm_resp A,sm_menu_hdr B,sm_resp_grp c "+sql.toString();
		rs = stmt.executeQuery(strsql2);
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
		String classValue = "" ;

		while ( i<=end && rs.next()){
			if(cnt==0){
%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	{%>
	<A HREF='../../eSM/jsp/ResponsibilityQuery.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%}
if (endOfRes.equals("1") )
	{%>
	<A id='nextval' HREF='../../eSM/jsp/ResponsibilityQuery.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>


	<%}%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.ResponsibilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.ResponsibilityName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.MenuID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eSM.MenuName.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="eSM.ResponsibilityGroupID.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="eSM.ResponsibilityGroupName.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Desktop.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}

 if ( i % 2 == 0 )
 	 	classValue = "QRYEVEN" ;
 	 else
 	 	classValue = "QRYODD" ;
 	 

String respid = rs.getString("resp_id");
String respname=rs.getString("resp_name");
String menuid=rs.getString("menu_id");
String desktop_code1=rs.getString("desktop_code");
String menuname=rs.getString("menu_name");
String group_id=rs.getString("RESP_GROUP_ID");
if(group_id == null) group_id="&nbsp;";
String resp_group_id=rs.getString("RESP_GROUP_NAME");
String ora_role_id=rs.getString("ORA_ROLE_ID");
String sys_defined_yn =rs.getString("SYS_DEFINED_YN");

if (menuname==null) menuname="";
if (menuid==null) menuid="";
if (desktop_code1==null) desktop_code1="";
if (resp_group_id==null) resp_group_id="";
if (ora_role_id==null) ora_role_id="";
	%><tr><td nowrap class='<%=classValue %>'>
	<a href='../jsp/Responsibility_Form.jsp?resp_id=<%=respid%>&menuid=<%=java.net.URLEncoder.encode(menuid)%>&menuname=<%=java.net.URLEncoder.encode(menuname)%>&sys_defined_yn=<%=java.net.URLEncoder.encode(sys_defined_yn)%>&desktop_code1=<%=java.net.URLEncoder.encode(desktop_code1)%>' target='f_query_add_mod' >

	<%=respid%></a></td><td nowrap class='<%=classValue%>'>
	<%=respname%>&nbsp;</td><td nowrap class='<%=classValue%>'>
	<%=menuid%>&nbsp;</td><td nowrap class='<%=classValue%>'>
	<%=menuname%>&nbsp;</td><td nowrap class='<%=classValue%>'>
	<%=group_id%>&nbsp;</td><td nowrap class='<%=classValue%>'>
	
	<%=resp_group_id%>&nbsp;</td><td nowrap  class='<%=classValue%>'>
		<%=desktop_code1%>&nbsp;</td><td nowrap class='<%=classValue%>'>
	<%=ora_role_id%>&nbsp;</td><td nowrap class='<%=classValue%>'>
<%
	if ( rs.getDate("eff_date_from") != null )
	{
	 java.sql.Date date = rs.getDate("eff_date_from");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	String dateString = formatter.format(date);
	if( dateString==null) dateString="";
		else dateString = DateUtils.convertDate(dateString,"DMY","en",localeName);
	out.println(dateString);
	dateString = null;
	formatter = null;
	}
	else
	{%>
		&nbsp;
	<%}%>
	</td><td nowrap class='<%=classValue%>'>
	<%

	if ( rs.getDate("eff_date_to") != null )
	{
	java.util.Date date1 = rs.getDate("eff_date_to");
	SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	String dateString = formatter.format(date1);
	if( dateString==null) dateString="";
		else dateString = DateUtils.convertDate(dateString,"DMY","en",localeName);
	 out.println(dateString);
	}
	else
	{%>
		&nbsp;
	<%}%>
</td><td nowrap align='center' class='<%=classValue%>'>
	<%

	if ( rs.getString("eff_status").equals("E") )
	{%>
		<img src='../../eCommon/images/enabled.gif'></img>
	<%}
	else{%>
	<img src='../../eCommon/images/disabled.gif'></img>
	<%}

	
	i++;

	cnt++;
}//endwhile
if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
if(!rs.next()&&cnt!=0){
   endOfRes="0";%>
   <script>
	   document.getElementById("nextval").innerHTML=" ";
   </script>
<% }
	if(rs!=null)rs.close();
	if(rset!=null)	rset.close();
	if(stmt!=null)stmt.close();
	if(stmt1!=null)	stmt1.close();

}catch(Exception e){
		e.toString();
}
	finally   {	
	ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>

</center>
</BODY>
</HTML>

