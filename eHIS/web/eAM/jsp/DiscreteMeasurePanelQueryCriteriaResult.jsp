<!DOCTYPE html>
<%--
	FileName	: DiscreteMeasurePanelQueryCriteriaResult.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<BODY class='CONTENT'  onKeyDown = 'lockKey()'>
 <%
	request.setCharacterEncoding("UTF-8");
    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";

	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;

	StringBuffer sql =new StringBuffer(" ");

	String discr_msr_battery_id  = request.getParameter("discr_msr_battery_id");
    String discr_msr_battery_desc = request.getParameter("DISCR_MSR_BATTERY_DESC");
    String discr_msr_id = request.getParameter("DISCR_MSR_ID");
    String discr_msr_desc = request.getParameter("DISCR_MSR_DESC");

	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

	if ( !(discr_msr_battery_id == null || discr_msr_battery_id.equals("")) )
        {	
			sql.append(" where upper(discr_msr_battery_id ) like upper('"+discr_msr_battery_id +"%')");
			cnt++;
        }

        if ( !(discr_msr_battery_desc == null || discr_msr_battery_desc.equals("")) )
        {
			if(cnt>0)
				sql.append(" and discr_msr_battery_desc like '"+discr_msr_battery_desc+"%'");
			else
				sql.append(" where discr_msr_battery_desc like '"+discr_msr_battery_desc+"%'");

        }
		   if ( !(discr_msr_id == null || discr_msr_id.equals("")) )
        {
			if(cnt>0)
				sql.append(" and discr_msr_id like '"+discr_msr_id+"%'");
			else
				sql.append(" where discr_msr_id like '"+discr_msr_id+"%'");
        }


    if ( !(discr_msr_desc == null || discr_msr_desc.equals("")) )
    {
         	if(cnt>0)
			   sql.append(" and discr_msr_desc like '"+discr_msr_desc+"%'");
			else
				sql.append(" where discr_msr_desc like '"+discr_msr_desc+"%'");
	}
  
   } //end of where clause IF
    else
	{
		sql.setLength(0);
        sql.append(whereClause);
	}
	
	sql.append(" order by ORDER_SRL_NO ");

    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 6 ;
    else
        end = Integer.parseInt( to ) ;

Connection conn  =  ConnectionManager.getConnection(request);

Statement stmt = null, stmt1 = null;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;

try
{
stmt = conn.createStatement();
String strsql="select count(*) as total from am_discr_msr_battery_vw"+sql;
String strsql1="select  DISCR_MSR_BATTERY_ID,DISCR_MSR_BATTERY_DESC, DISCR_MSR_ID, DISCR_MSR_DESC,ORDER_SRL_NO,MANDATORY_YN from  am_discr_msr_battery_vw "+sql;


rs = stmt.executeQuery(strsql);
rs.next();
maxRecord = rs.getInt("total");


stmt1=conn.createStatement();
rset = stmt1.executeQuery(strsql1);
%>
<p>
<table align='right'>
<tr>
<td>
<%



if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/DiscreteMeasurePanelQueryCriteriaResult.jsp?from="+(start-6)+"&to="+(end-6)+"&discr_msr_battery_id="+discr_msr_battery_id+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+6) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/DiscreteMeasurePanelQueryCriteriaResult.jsp?from="+(start+6)+"&to="+(end+6)+"&discr_msr_battery_id="+discr_msr_battery_id+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
</p><br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='1'>
<th width='30%'><fmt:message key="eAM.Discrete.label" bundle="${am_labels}"/><BR> <fmt:message key="eAM.MeasureID.label" bundle="${am_labels}"/></th>
<th width='35%'><fmt:message key="eAM.Discrete.label" bundle="${am_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th width='10%'><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/></th>
<th width='25%'><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th>

<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;


    String discr_msr_battery_id1	=(rset.getString(1)==null)?"":rset.getString(1);
	discr_msr_battery_id1 = discr_msr_battery_id1.trim();
  	String discr_msr_id1			=(rset.getString(3)==null)?"":rset.getString(3);
	String discr_msr_desc1			=(rset.getString(4)==null)?"":rset.getString(4);
	String order_srl_no				=(rset.getString(5)==null)?"":rset.getString(5);
	String mandatory_yn				=(rset.getString(6)==null)?"":rset.getString(6);
%>
	<tr>
	<td class=<%=classValue%> ><a href='DiscreteMeasurePanelAddModify.jsp?mode=update&discr_msr_battery_id1=<%=URLEncoder.encode(discr_msr_battery_id1)%>&discr_msr_id1=<%=URLEncoder.encode(discr_msr_id1)%>' target=f_query_add_mod><%=discr_msr_id1%></a></td>
	<td class=<%=classValue%>>   <%=discr_msr_desc1%> 	</td>
	<td class=<%=classValue%> align='right'><%=order_srl_no%></td>
	<td class=<%=classValue%> align='center'>
	<%if(mandatory_yn.equals("Y")){%>
		<img src='../../eCommon/images/enabled.gif'>
	<%}else{%>
		<img src='../../eCommon/images/RRnwd.gif'>
	<%}%>
	</td>
	</tr>

<%
		i++;
} %>

</table>
</center>

<br><center>
<%
}
catch(Exception e)
{
	e.toString();
}
 finally   
 {
	try
	{
	if(rs != null) rs.close();
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	sql.setLength(0);
	ConnectionManager.returnConnection(conn,request);
 }
%>

</center>
</BODY>
</HTML>

