<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer("") ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{

	String cd = request.getParameter("pat_ser_grp_code");
	cd = cd.toUpperCase();
	String siteorfacility = request.getParameter("site_or_facility_id");
	siteorfacility = siteorfacility.toUpperCase();
	String patserdesc = request.getParameter("pat_ser_grp_desc");
	patserdesc = patserdesc.toUpperCase();

	int andCheck = 0;


	if ( !(cd == null || cd.equals("")) )
		{
		sql.append("where pat_ser_grp_code like '");
		sql.append(cd);
		sql.append("%'");
		andCheck = 1;
		}


	//if ( !(siteorfacility == null || siteorfacility.equals("")) )
	//	{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("nvl(site_or_facility_id,'*') like  '");
				sql.append(siteorfacility);
				sql.append("%'");
			}
			else
			{
				sql.append("where nvl(site_or_facility_id,'*') like '");
				sql.append(siteorfacility);
				sql.append("%'") ;
				andCheck = 1;
			}
	//}
	if ( !(patserdesc == null || patserdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append(" and ");
					sql.append("upper(pat_ser_grp_desc) like  '");
					sql.append(patserdesc);
					sql.append("%'") ;
				}
				else
				{
					sql.append("where upper(pat_ser_grp_desc) like '");
					sql.append(patserdesc);
					sql.append("%'");
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
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
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
	  	end = 8 ;
	else
		end = Integer.parseInt( to ) ;

//Connection conn = (Connection) session.getValue( "connection" ) ;
Connection conn = null;
try
{
conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
	/*int maxRecord = 0;
try{
	pstmt = conn.prepareStatement("select count(*) as total from mp_pat_ser_facility_vw "+sql.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");

}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}
if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
*/


try{
	pstmt = conn.prepareStatement("select * from (select SITE_OR_FACILITY, SITE_OR_FACILITY_ID, SITE_OR_FACILITY_NAME, RECORD_SRL_NO, PAT_SER_GRP_CODE,PAT_SER_GRP_DESC, START_SRL_NO, MAX_SRL_NO, USED_STATUS, MR_SECTION_CODE, MR_SECTION_DESC,SEPARATE_FILE_NO_YN, CREATE_FILE_AT_REGN_YN from mp_pat_ser_facility_vw UNION select null SITE_OR_FACILITY, null SITE_OR_FACILITY_ID, null SITE_OR_FACILITY_NAME, null RECORD_SRL_NO,a.PAT_SER_GRP_CODE,b.short_desc PAT_SER_GRP_DESC,null START_SRL_NO, null MAX_SRL_NO, 'N' USED_STATUS,NULL MR_SECTION_CODE, NULL MR_SECTION_DESC,null SEPARATE_FILE_NO_YN, null CREATE_FILE_AT_REGN_YN from MR_SEC_FOR_PAT_SER_GRP A, mp_pat_ser_grp b where a.PAT_SER_GRP_CODE=b.pat_ser_grp_code and b.PID_USE_ALT_ID1_OR_SYS_GEN='A') "+sql.toString());

	
	rs = pstmt.executeQuery();

%>

<!-- <th>Create MRN at Regn</th> -->

<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue="";
	  int cnt=0;
while ( i<=end  && rs.next() )
{
	if(cnt==0)
	{%>
		
		<P>
		<table align='right'>
		<tr>
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../jsp/queryPatientNumberDetail.jsp?from="+(start-8)+"&to="+(end-8)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
%>
		<td align ='right' id='next' style='visibility:hidden'>
<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../jsp/queryPatientNumberDetail.jsp?from="+(start+8)+"&to="+(end+8)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</p>


		<table border="1" align="centre" width="99%" cellspacing='0' cellpadding='0' >
		<th><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.SiteFacilityID.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="eMP.SiteFacilityName.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="Common.StartSerialNo.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.maxserialno.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.UsedStatus.label" bundle="${mp_labels}"/></th>
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr><td width='8%' class='" + classValue + "'>");
	String code = rs.getString("pat_ser_grp_code");
	String facility=(rs.getString("site_or_facility_id")==null?"":rs.getString("site_or_facility_id"));
	String patserdesc = rs.getString("pat_ser_grp_desc");
	String record_srl_no = rs.getString("record_srl_no");

	// if ( rs.getString("eff_status").equals("E") )
	out.println("<a href='../jsp/PatientNumberDetailModify.jsp?pat_ser_grp_code="+ code + "&site_or_facility_id="+facility+"&record_srl_no="+record_srl_no+ "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td width = '18%' class='" + classValue + "'>");
	//out.println("<a href='../jsp/PatientNumberDetailModify.jsp?pat_ser_grp_code="+ code + "&site_or_facility_id="+facility+ "&record_srl_no="+record_srl_no+"' target='f_query_add_mod' >");
	out.println(patserdesc+"</td><td  width='8%' class='" + classValue + "'>");

	//out.println("<a href='../jsp/PatientNumberDetailModify.jsp?pat_ser_grp_code="+ code + "&site_or_facility_id="+facility+ "&record_srl_no="+record_srl_no+ "' target='f_query_add_mod' >");
	if(rs.getString("site_or_facility_id") ==null || rs.getString("site_or_facility_id").equals("null") || rs.getString("site_or_facility_id").equals(""))
	out.println("&nbsp;");
	else
	out.println( rs.getString("site_or_facility_id") );
	out.println("</td><td width='20%' class='" + classValue + "'>");
	//out.println("<a href='../jsp/PatientNumberDetailModify.jsp?pat_ser_grp_code="+ code + "&site_or_facility_id="+facility+ "&record_srl_no="+record_srl_no+ "' target='f_query_add_mod' >");
	if(rs.getString("site_or_facility_name") ==null || rs.getString("site_or_facility_name").equals("null") || rs.getString("site_or_facility_name").equals(""))
	out.println("&nbsp;");
	else
	out.println( rs.getString("site_or_facility_name") );
	out.println("</td><td class='" + classValue + "'>");
	if(rs.getString("start_srl_no") ==null || rs.getString("start_srl_no").equals("null") || rs.getString("start_srl_no").equals(""))
	out.println("&nbsp;");
	else
	out.println(rs.getString("start_srl_no") );
	out.println("</td><td class='" + classValue + "'>");
	if(rs.getString("max_srl_no") ==null || rs.getString("max_srl_no").equals("null") || rs.getString("max_srl_no").equals(""))
	out.println("&nbsp;");
	else
	out.println(rs.getString("max_srl_no") );
	out.println("</td><td class='" + classValue + "'>");	
	if(rs.getString("mr_section_desc") ==null || rs.getString("mr_section_desc").equals("null") || rs.getString("mr_section_desc").equals(""))
		out.println("&nbsp;");
	else
		out.println(rs.getString("mr_section_desc") );
	out.println("</td>");
	
	out.println("<td class='" + classValue + "'>");
	
		
	 if ( rs.getString("used_status").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else if ( rs.getString("used_status").equals("N"))
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");
				
	i++;
	cnt++;
}   
if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 8 || (!rs.next()) ) {
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%}
		%>
</td></tr>
</table>
<br><center>
<%
/*if ( !(start <= 1) )
	out.println("<A HREF='/eCIS/mp/jsp/queryPatientNumberDetail.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='/eCIS/common/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='/eCIS/mp/jsp/queryPatientNumberDetail.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='/eCIS/common/images/next.gif' alt='Next' border='0'></A>");*/
//rs.close();
	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174056467 on 22-08-2023
		}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
	} 
}catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174056468 on 22-08-2023
	}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

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

