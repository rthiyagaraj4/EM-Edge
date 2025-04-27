<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	if ( whereClause == null ) whereClause = "" ;

	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;
	if ( from == null ) from = "1" ;

	String to = request.getParameter( "to" ) ;
	if ( to == null ) to = "14" ;
	/*Added by lakshmanan for security issue ID 174116192 on 28-08-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174116192 on 28-08-2023 end */
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String reportid = request.getParameter("report_id");
	String reportdesc=request.getParameter("report_desc");
	String pseriescode = request.getParameter("pat_ser_grp_code");
	String pshortdesc = request.getParameter("short_desc");

	if ( reportid == null ) reportid = "" ;
	if ( reportdesc == null ) reportdesc = "" ;
	if ( pseriescode == null ) pseriescode = "" ;
	if ( pshortdesc == null ) pshortdesc = "" ;

	reportid=reportid.toUpperCase();
	pseriescode=pseriescode.toUpperCase();
	reportdesc=reportdesc.toUpperCase();
	pshortdesc=pshortdesc.toUpperCase();

	int andCheck = 0;
	if ( !(reportid == null || reportid.equals("")) )
		{
			sql.append(" where report_id like ? ");
			psthashmap.put(++psthmcount,reportid+"%");
			//sql.append(reportid);
			//sql.append("%'");
			andCheck = 1;
		}

	if ( !(reportdesc == null || reportdesc.equals("")) )
		{
		if ( andCheck == 1 )
				{
					sql.append( " and ");
					sql.append( " upper(report_desc) like ? ");
					psthashmap.put(++psthmcount,reportdesc+"%");
					//sql.append(reportdesc);
					//sql.append("%'");
				}
				else
				{
					sql.append(" where upper(report_desc) like ? ");
					psthashmap.put(++psthmcount,reportdesc+"%");
					//sql.append(reportdesc);
					//sql.append("%'");
					andCheck = 1;
				}

		}

	if ( !(pseriescode == null || pseriescode.equals("")) )
		{
			if(andCheck==1)
				{
					sql.append( " and ");
					sql.append(" pat_ser_grp_code like ? ");
					psthashmap.put(++psthmcount,pseriescode+"%");
					//sql.append(pseriescode);
					//sql.append("%'");
				}
			else{
				sql.append(" where pat_ser_grp_code like ? ");
				psthashmap.put(++psthmcount,pseriescode+"%");
				//sql.append(pseriescode);
				//sql.append("%'");
				andCheck = 1;
			}
		}

	if ( !(pshortdesc == null || pshortdesc.equals("")) )
		{
			if(andCheck==1)
				{
						sql.append( " and ");
						sql.append( "upper(short_desc) like ? ");
						psthashmap.put(++psthmcount,pshortdesc+"%");
						//sql.append(pshortdesc);
						//sql.append("%'");
				}
			else{
						sql.append(" where upper(short_desc) like ? ");
						psthashmap.put(++psthmcount,pshortdesc+"%");
						//sql.append(pshortdesc);
						//sql.append("%'");
						andCheck = 1;
			}
		}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{

			sql.append(" order by ");



			for ( int i=0;i < ord.length;i++ )
		 	{
			 	if ( i == ord.length - 1 ){
				sql.append(ord[i]);

				}
				else
				{
				sql.append(ord[i]);
				sql.append(",");

				}
			}

		}
	} //end of where clause IF
	else
	{
		sql.setLength(0);
		sql.append(whereClause);
	}
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

Connection conn = null;
//PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
//ResultSet rs=null;
ResultSet rset=null;
/*int maxRecord = 0;
try{
	
	String strSQL="select count(*) as total from MP_ONLINE_REPORTS_VW "+sql.toString();
	pstmt = conn.prepareStatement(strSQL);
	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
}catch(Exception e){out.println(e.toString());}
finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
}
if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");*/
try{
	conn = ConnectionManager.getConnection(request);
	String strSQL1="select report_id,report_desc,pat_ser_grp_code,short_desc from MP_ONLINE_REPORTS_VW "+sql.toString();
	pstmt1 = conn.prepareStatement(strSQL1);
	int pstcount=1;
	while ( pstcount<=psthashmap.size()) {
		pstmt1.setString(pstcount,(String) psthashmap.get(pstcount));
		pstcount++;
	}
	psthashmap.clear();
	psthmcount=0;
	rset = pstmt1.executeQuery();
%>


<%
 	if ( start != 1 )
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
		    String classValue = "" ;
	int cnt=0;
while ( i<=end && rset.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>
		<%

		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../jsp/MpInternalReqRepRuleQuery.jsp?from="+(start-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"&to="+(end-14)+"&text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../jsp/MpInternalReqRepRuleQuery.jsp?from="+(start+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"&to="+(end+14)+"&text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>

	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
				else
			classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");

	String rid = rset.getString(1);
	String rdesc = rset.getString(2);
	String pcode = rset.getString(3);
	String pdesc = rset.getString(4);
	out.println("<a href='../jsp/addMpInternalReqRepRule.jsp?report_id="+ rid +"&pat_ser_grp_code="+ pcode +"' target='f_query_add_mod' >");
	out.println(rid+"</a></td><td class='" + classValue + "'>");

	out.println(rdesc+"<!-- </a> --></td><td class='" + classValue + "'>");
	out.println(pcode+"<!-- </a> --></td><td class='" + classValue + "'>");
	out.println(pdesc+"<!-- </a> --></td>");
	i++;
	cnt++;

}
	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rset.next()) ) { 
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
if(rset!=null)rset.close();
if(pstmt1!=null)pstmt1.close();
}
finally
	{
	 if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>

</tr>
</table>
<br><center>
<%


%>

</center>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

