<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eMR/js/RecodePrivilegeSetup.js"></script>



<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()'  onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	

	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.append("");
	String cd = checkForNull(request.getParameter("stage_no"));
	String longdesc = checkForNull(request.getParameter("stage_desc"));
	String specific_ind = checkForNull(request.getParameter("spec_ind"));



	int andCheck = 0;

	cd=cd.toUpperCase();

	if ( !(cd == null || cd.equals("")) )
			{
			sql.append("where upper(STAGE_NO) like upper('"+cd+"%') ");
			andCheck = 1;
			}

		if ( !(longdesc == null || longdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql.append( " and ");
					sql.append( " upper(STAGE_DESC)  like  upper('"+longdesc+"%') " );
				}
				else
				{
					sql.append("where upper(STAGE_DESC)  like upper('"+longdesc+"%') " );
					andCheck = 1;
				}
			}


		if ( !(specific_ind == null || specific_ind.equals("")) )
		{
			if ( andCheck == 1 )
				{	sql.append( " and ");
					sql.append( " upper(SPECIFIC_IND)  like  upper('"+specific_ind+"%') " );
				}
				else
				{
					sql.append("where upper(SPECIFIC_IND)  like upper('"+specific_ind+"%') " );
					andCheck = 1;
				}
		   
	}

	
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
	//ResultSet rset=null;
	ResultSet rs=null;
	int maxRecord = 0;

try{
		conn=ConnectionManager.getConnection(request);
		stmt = conn.createStatement();

		String strsql2="SELECT * FROM MR_RECODE_PRIVI_SETUP "+sql.toString();

		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
			  rs.next() ;

			  }

		while (  i<=end && rs.next() )
		{
			if (maxRecord==0)
			{
		%>

				
				<table align='right'>
				<tr>
				<td>
<!--
				<%
					
				if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/RecodePrivilegeSetupqueryResult?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

				//if ( !( (start+14) > maxRecord ) )
				else
					out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/RecodePrivilegeSetupqueryResult?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
				%>
				-->
</td>
				</tr>
				</table>
				<br><br>
				

				<table border="1" width="90%" cellspacing='0' cellpadding='0'>
				<th><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Stage.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td></th>
				<th><fmt:message key="eOT.SpecificIndicator.Label" bundle="${ot_labels}"/></th>				<%
								}
					/*if ( start != 1 )
					 for( int j=1; j<start; i++,j++ ){
					  rs.next() ;

					  }*/
				String classValue = "" ;
				//while ( rs.next() && i<=end )
				//{
				if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
						classValue = "QRYODD" ;

				out.println("<tr><td class='" + classValue + "'>");
				String code = rs.getString("stage_no");
				String specific_ind = rs.getString("SPECIFIC_IND");
				String mode="update_db";
				

				out.println("<a href='../../eMR/jsp/RecodePrivilegeSetupCreateFrames.jsp?&update_mode_yn="+mode+"&stage_code="+code+"&specific_ind="+specific_ind+" target='f_query_add_mod' >");
				out.println(code+"</a></td><td class='" + classValue + "'>");
				out.println( rs.getString("STAGE_DESC") );
				out.println("</td><td class='" + classValue + "'>");
				out.println(specific_ind );

				//out.println("</td><td align='center' class='" + classValue + "'>");
				
				

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

				
				%>

					</center>
					</BODY>
					</HTML>
<%

}catch(Exception e){
		out.println("Exception @ try "+e.toString());
		e.printStackTrace();
}
	finally   {
		try{
	if(stmt!=null)
	stmt.close();
	if(rs!=null)
	rs.close();
	//if(rset!=null)
	//rset.close();
		}
		catch(Exception e){
			out.println("Exception @ BloodGroupqueryResult.jsp "+e.toString());
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

