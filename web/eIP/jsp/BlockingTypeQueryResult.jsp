<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' OnMouseDown='CodeArrest()' onKeyDown='lockKey()';>");
	String whereClause				= request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from						= request.getParameter( "from" ) ;
	String to						= request.getParameter( "to" ) ;
	String  blocking_type_code		="";
	String  blocking_type_desc		="";
	String  blocking_period			="";
	String  blocking_period_type    ="";
	String  blocking_period_type1   ="";

	String override				="";
	String eff_status			="";
	String blocking_type_longdesc="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*	Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		blocking_type_code	=request.getParameter("blocking_type_code");
		blocking_type_desc  =request.getParameter("blocking_type_desc");

		override			=request.getParameter("override");
		eff_status			=request.getParameter("eff_status");
		
		blocking_type_code=blocking_type_code.toUpperCase();

		int andCheck						 = 0;

		if(blocking_type_code!=null && !blocking_type_code.equals(""))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" where upper(blocking_type_code) like upper('"+blocking_type_code+"%')");
			andCheck = 1;
		}

		if(blocking_type_desc!=null && !blocking_type_desc.equals(""))
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(long_desc) like  upper('"+blocking_type_desc+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(long_desc) like upper('"+blocking_type_desc+"%')" );
				andCheck = 1;
			}
		}

		if ( override.equals("Y") )
		{
			if ( andCheck == 0 )
			{
				sql.append(" where override_yn='Y'");
				andCheck = 1;
			}
			else
				sql.append(" and override_yn='Y'");
		}
		else 
		{
			if ( override.equals("N") )
			{
				if ( andCheck == 0 )
				{
					sql.append(" where override_yn='N'");
					andCheck = 1;
				}
				else
					sql.append(" and override_yn='N' ");
			}
		}

		if ( eff_status.equals("E") )
		{
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where eff_status='E'");
				andCheck = 1;
			}
			else
				sql.append(" and eff_status='E'");
		}
	   if ( eff_status.equals("D") )
	   {
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where  eff_status='D'");
				andCheck = 1;
			}
			else
			sql.append(" and eff_status='D'");
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
	}
	else
	{
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

	Connection con = null;
	Statement stmt=null;
	//ResultSet rset=null;
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{
		con = ConnectionManager.getConnection(request); 
		stmt=con.createStatement();
		/*StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from ip_blocking_type "+sql.toString());
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");

if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}else{*/
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select blocking_type_code,long_desc,short_desc,DFLT_MIN_BLOCK_PERIOD,DFLT_BLOCK_UNITS,override_yn,eff_status from ip_blocking_type "+sql.toString());
		stmt.setFetchSize(5);
		rs = stmt.executeQuery(strsql2.toString());
		if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;
		while ( i<=end && rs.next())
			{
				if (maxRecord==0)
					{
		%>

		<P>
		<table align='right'>
			<tr>
				
					<%
					if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='../jsp/BlockingTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/BlockingTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					%>
				
			</tr>
		</table>
		</P>
		<br>
		<br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.BlockingPeriod.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="Common.override.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
				<%
					}
				/*if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;
				*/	
						String classValue = "" ;

				//while ( rs.next() && i<=end )
				//{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

							blocking_type_code			= rs.getString("blocking_type_code");
							blocking_type_desc			= rs.getString("short_desc");
							blocking_type_longdesc		= rs.getString("long_desc");
							blocking_period				= rs.getString("DFLT_MIN_BLOCK_PERIOD");
							blocking_period_type		= rs.getString("DFLT_BLOCK_UNITS");

if(blocking_period==null || blocking_period.equals(""))
{	
	blocking_period			= "";
	blocking_period_type	= "";
}
if(blocking_period_type==null || blocking_period_type.equals(""))
{	
	blocking_period_type	= "";
}
else
{	
	if(blocking_period_type.equalsIgnoreCase("H"))
	{
		blocking_period_type1="Hours";
	}
	else 
	if(blocking_period_type.equalsIgnoreCase("D"))
	{
		blocking_period_type1="Days";
	}
}

	override					= rs.getString("override_yn");
	eff_status					= rs.getString("eff_status");
	out.println("<tr>");
	out.println("<td class='" + classValue + "'><a  href='../jsp/addModifyBlockingType.jsp?block_type_code="+blocking_type_code+"' target='f_query_add_mod' >");
	out.println(blocking_type_code+"</a></td>");
	out.print("<td class='" + classValue + "'>"+blocking_type_longdesc+"</td>");
	out.print("<td class='" + classValue + "'>"+blocking_type_desc+"</td>");


if(!(blocking_period==null) && !(blocking_period.equals("")))
{
out.print("<td class='" + classValue + "'>"+blocking_period+" "+blocking_period_type1+"</td>");
}
else
{
out.print("<td class='" + classValue + "'>&nbsp;</td>");
}

		out.print("<td class='" + classValue + "' align='center'>");
		if(override.equals("Y"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
		out.print("</td>");

		out.print("<td class='" + classValue + "' align='center'>");
		if(eff_status.equals("E"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
		out.print("</td>");
		out.print("</tr>");
		i++;
		maxRecord++;
			}//endwhile
//}
		if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
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
			}
			catch(Exception e)
			{
				//out.print(e.toString());
				e.printStackTrace();
			}
			finally   
			{
					if(rs!=null) 		rs.close();
					//if(rset!=null)		rset.close();
					if(stmt!=null) 	stmt.close();
					ConnectionManager.returnConnection(con,request); 
			}
			%>

</td></tr>
</table>
</BODY>
</HTML>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

