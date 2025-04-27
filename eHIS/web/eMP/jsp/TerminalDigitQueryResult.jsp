<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
request.setCharacterEncoding("UTF-8");
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><Script Language='JavaScript' src='../../eCommon/js/common.js'></script></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer("");

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	/*Added by lakshmanan for security issue ID 174204638 on 24-08-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174204638 on 24-08-2023 end */
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd = request.getParameter("term_digit_level");
	cd = cd.toUpperCase();
	
	String siteorfacility = request.getParameter("facility_id");
	siteorfacility = siteorfacility.toUpperCase();
	String patserdesc = request.getParameter("mr_section_code");
	patserdesc = patserdesc.toUpperCase();

	String mr_section_desc = request.getParameter("short_name")==null?"":request.getParameter("short_name");	

	int andCheck = 0;


	if ( !(cd == null || cd.equals("")))
		{
		if (!cd.equals("A"))
		{
		sql.append("and a.term_digit_level =?");
		psthashmap.put(++psthmcount,cd);
		//sql.append(cd);
		//sql.append("'");		
		andCheck = 1;
		}
		if(cd.equals("A"))
		{
		 sql.append(" and a.term_digit_level is not null ");
		 andCheck = 1;
		}
		}


	if ( !(siteorfacility == null || siteorfacility.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append("a.facility_id like ?");
				psthashmap.put(++psthmcount,siteorfacility+"%");
				//sql.append(siteorfacility);
				//sql.append("%'");
				
			}
			
	}
	if ( !(patserdesc == null || patserdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append( " and ");
					
					sql.append( "a.mr_section_code like ?");
					psthashmap.put(++psthmcount,patserdesc+"%");
					//sql.append(patserdesc);
					//sql.append("%' ");
					
				}			
	}
	if ( !(mr_section_desc.equals("")) )
	{
				if ( andCheck == 1 )
				{	sql.append(" and ");
					sql.append("c.short_name like upper( ?)");
					psthashmap.put(++psthmcount,mr_section_desc+"%");
					//sql.append(mr_section_desc);
					//sql.append("%' )");
				}			
	}



	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	

	
	if(cd.equals("E")||cd.equals("F")||cd.equals("S")||cd.equals("A"))
	{
	
	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");
		
		for ( int i=0;i < ord.length;i++ )
	 	{
			
	 	if ( i == ord.length - 1 )
			{
			sql.append(ord[i]);
			}
		else
			{
			sql.append(ord[i]);
			sql.append(",");			
			}
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
//Connection conn = (Connection) session.getValue( "connection" ) ;

Connection conn = null;
try
{
conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
	/*int maxRecord = 0;
try{
	
	pstmt = conn.prepareStatement("select count(*) as total from mr_terminal_digit_hdr a, mr_terminal_digit_dtl b , MR_SECTION c WHERE b.term_digit_level (+) = a.term_digit_level AND b.facility_id  (+) = a.facility_id AND b.mr_section_code (+) = a.mr_section_code AND a.mr_section_code = c.mr_section_code(+) "+sql.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");

}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
*/
try{
	
	pstmt = conn.prepareStatement("select a.term_digit_level, a.facility_id, a.mr_section_code, a.NO_OF_TERM_DIGIT,a.NO_OF_TERM_DIGIT_GROUP, c.short_name mr_section_desc from mr_terminal_digit_hdr a, mr_terminal_digit_dtl b, mr_section c where b.term_digit_level (+) = a.term_digit_level and b.facility_id  (+) = a.facility_id and b.mr_section_code (+) = a.mr_section_code and a.mr_section_code = c.mr_section_code(+) "+sql.toString());
	int pstcount=1;
	while ( pstcount<=psthashmap.size()) {
	pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
	pstcount++;
	}
	psthashmap.clear();
	psthmcount=0;
	rs = pstmt.executeQuery();

%>


<!-- <th>Terminal Digit</th>
<th>MR Section</th>
<th>Create MRN at Regn</th> -->

<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue="";
	  int cnt=0;
while (i<=end && rs.next())
{	
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../jsp/TerminalDigitQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
%>
		<td align ='right' id='next' style='visibility:hidden'>
<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../jsp/TerminalDigitQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</p>


		<table border="1" align="centre" width="99%" cellspacing='0' cellpadding='0' >
		<th nowrap><fmt:message key="eMP.TerminalDigitLevel.label" bundle="${mp_labels}"/></th>
		<th nowrap><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.MRSectionCode.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="Common.MRSectionDesc.label" bundle="${common_labels}"/></th>
		<th nowrap><fmt:message key="eMP.TerminalDigitCount.label" bundle="${mp_labels}"/></th>
		<th nowrap><fmt:message key="eMP.GroupCount.label" bundle="${mp_labels}"/></th>
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr><td width='8%' class='" + classValue + "'>");
	String code1="";
	String code = rs.getString("term_digit_level");
	if (code.equals("E")) code1 = "Enterprise";
	if (code.equals("F")) code1 = "Facility";
	if (code.equals("S")) code1 = "MR Section";	
	String facility=rs.getString("facility_id")==null?"":rs.getString("facility_id");
	String mr_section = rs.getString("mr_section_code")==null?"":rs.getString("mr_section_code");
	//String terminal_digit_count = rs.getString("NO_OF_TERM_DIGIT");
	//String group_count = rs.getString("NO_OF_TERM_DIGIT_GROUP");

	
	out.println("<a href='../jsp/addTerminalDigit.jsp?term_digit_level="+ code + "&facility_id="+facility+"&mr_section_code="+mr_section+ "' target='f_query_add_mod' >");
	
	out.println(code1+"</a></td><td width = '18%' class='" + classValue + "'>");
	if(rs.getString("facility_id") ==null || rs.getString("facility_id").equals("null") || rs.getString("facility_id").equals(""))
	out.println("&nbsp;");
	else
	out.println( rs.getString("facility_id") );

	out.println("</td><td width='20%' class='" + classValue + "'>");	
	if(rs.getString("mr_section_code") ==null || rs.getString("mr_section_code").equals("null") || rs.getString("mr_section_code").equals(""))
	out.println("&nbsp;");
	else
	out.println(rs.getString("mr_section_code") );

	out.println("</td><td width='20%' class='" + classValue + "'>");	
	if(rs.getString("mr_section_desc") ==null || rs.getString("mr_section_desc").equals("null") || rs.getString("mr_section_desc").equals(""))
	out.println("&nbsp;");
	else
	out.println(rs.getString("mr_section_desc") );
	out.println("</td><td class='" + classValue + "'>");

	if(rs.getString("NO_OF_TERM_DIGIT") ==null || rs.getString("NO_OF_TERM_DIGIT").equals("null") || rs.getString("NO_OF_TERM_DIGIT").equals(""))
	out.println("&nbsp;");
	else
	out.println(rs.getString("NO_OF_TERM_DIGIT") );
	out.println("</td><td  class='" + classValue + "'>");
	
	if(rs.getString("NO_OF_TERM_DIGIT_GROUP") ==null || rs.getString("NO_OF_TERM_DIGIT_GROUP").equals("null") || rs.getString("NO_OF_TERM_DIGIT_GROUP").equals(""))
		out.println("&nbsp;");
	else
		out.println(rs.getString("NO_OF_TERM_DIGIT_GROUP") );
	out.println("</td>");

	i++;
	cnt++;
}  

	if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
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
	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174194652 on 24-08-2023
		}
	finally
	{
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
	} 
}catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174194653 on 24-08-2023
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

