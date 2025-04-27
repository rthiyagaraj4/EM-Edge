<!DOCTYPE html>
<!--Maheshwaran K created this page for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()'  onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String locale		= (String)session.getAttribute("LOCALE");
	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.append("");
	String notify_code = checkForNull(request.getParameter("notify_code"));
	String longdesc = checkForNull(request.getParameter("long_desc"));
	String enabled = request.getParameter("nature");
	int andCheck = 0;
	notify_code=notify_code.toUpperCase();
	if ( !(notify_code == null || notify_code.equals("")) )
			{
			sql.append("where upper(NOTIFICATION_CODE) like upper('"+notify_code+"%') ");
			andCheck = 1;
			}

		if ( !(longdesc == null || longdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append( " and ");
					sql.append( " upper(long_desc)  like  upper('"+longdesc+"%') " );
				}
				else
				{
					sql.append("where upper(long_desc)  like upper('"+longdesc+"%') " );
					andCheck = 1;
				}
			}
		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
				sql.append("where eff_status='E'");
			else
				sql.append( " and eff_status='E'");
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				sql.append(" where  eff_status='D'");
			else
				sql.append(" and eff_status='D'");
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
	else {
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
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

try{
		conn=ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		String strsql2="select NOTIFICATION_CODE,LONG_DESC,SHORT_DESC,(SELECT NOTE_TYPE_DESC FROM CA_NOTE_TYPE_LANG_VW WHERE NOTE_TYPE =DEFAULT_NOTE_TYPE and LANGUAGE_ID = '"+locale+"' AND NOTE_GROUP_ID = '*NOTIFORM' AND EFF_STATUS = 'E' ) DEFAULT_NOTE_TYPE,EMAIL_APPLICABLE,EFF_STATUS from MR_NOTIFICATION_SETUP  "+sql.toString();
		rs = stmt.executeQuery(strsql2);
		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
			  rs.next() ;
			  }
		while (  i<=end && rs.next() )
		{
			if (maxRecord==0)
			{
		%><P>
				<table align='right'>
				<tr>
				<%
				if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/NotifiableSetupResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

				//if ( !( (start+14) > maxRecord ) )
					out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/NotifiableSetupResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
				%>
				</tr>
				</table>
				<br><br>
				</P>
				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.email.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				<%
				}
				String classValue = "" ;
				if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
				else
				classValue = "QRYODD" ;
				out.println("<tr><td class='" + classValue + "'>");
				String code = rs.getString("NOTIFICATION_CODE");
				out.println("<a href='../../eMR/jsp/AddModifyNotifiableSetup.jsp?notify_code="+code+ "' target='f_query_add_mod' >");
				out.println(code+"</a></td><td class='" + classValue + "'>");
				out.println( rs.getString("long_desc") );
				out.println("</td><td class='" + classValue + "'>");
				out.println(rs.getString("short_desc") );
				out.println("</td><td class='" + classValue + "'>");
				out.println(rs.getString("DEFAULT_NOTE_TYPE"));
				out.println("</td><td align='center' class='" + classValue + "'>");
				if ( rs.getString("EMAIL_APPLICABLE").equals("Y") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

				out.println("</td><td align='center' class='" + classValue + "'>");
				if ( rs.getString("eff_status").equals("E") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

				i++;
				maxRecord++;

		}//endwhile
				%>

				</td></tr>
				</table>
				<br><center>
				<%
				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}

				if ( maxRecord < 14 || (!rs.next()) )
				{
					%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
					<% 
				}
				else
					{%>
					<script >
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					<%
					}
				rs.close();
				%></center>
					</BODY>
					</HTML><%
}catch(Exception e){
		//out.println("Exception @ try "+e.toString());
		e.printStackTrace() ;
}
	finally   {
		try{
	if(stmt!=null)
	stmt.close();
	if(rs!=null)
	rs.close();
		}
		catch(Exception e){
			//out.println("Exception @ WorkRelNotifySetupResult.jsp "+e.toString());
			e.printStackTrace() ;
		}
	ConnectionManager.returnConnection(conn,request);
	}
	
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

