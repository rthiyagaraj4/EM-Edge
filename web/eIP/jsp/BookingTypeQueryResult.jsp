<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onKeyDown='lockKey()' OnMouseDown='CodeArrest()'>");
	String whereClause						= checkForNull(request.getParameter("whereclause"));
	StringBuffer sql						= new StringBuffer();						
	String from								= request.getParameter( "from" ) ;		
	String to								= request.getParameter( "to" ) ;
	String booking_type_code				= "";
	String booking_type_long_desc			= "";
	String booking_type_short_desc			= "";
	String indicator				        = "";
	String indicator_desc					= "";
	String eff_status						= "";
	String function_id = request.getParameter("function_id");



	if ( (whereClause == null || whereClause.equals("")) )
	{
		booking_type_code					= checkForNull(request.getParameter("booking_type_code").trim());
		booking_type_long_desc				= checkForNull(request.getParameter("booking_type_desc").trim());
		indicator							= checkForNull(request.getParameter("indicator").trim());
		eff_status			                = checkForNull(request.getParameter("eff_status").trim());

		booking_type_code					= booking_type_code.toUpperCase();

		int andCheck						= 0;

		if(booking_type_code!=null && !booking_type_code.equals(""))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" where upper(booking_type_code) like upper('"+booking_type_code+"%')");
			andCheck						= 1;
		}

		if(booking_type_long_desc!=null && !booking_type_long_desc.equals(""))
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(long_desc) like  upper('"+booking_type_long_desc+"')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(long_desc) like upper('"+booking_type_long_desc+"%')" );
				andCheck					= 1;
			}
		}

		if (!indicator.equals("") && !indicator.equals("A"))
		{
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where booking_type_ind='"+indicator+"'");
				andCheck					= 1;
			}
			else
				sql.append(" and booking_type_ind='"+indicator+"' ");
		}

		if ( eff_status.equals("E") )
		{
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where eff_status='E'");
				andCheck					= 1;
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
				andCheck					= 1;
			}
			else
			sql.append(" and eff_status='D'");
		}
		String ord[]						= request.getParameterValues("orderbycolumns");
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
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(whereClause);
	}
	int start								= 0 ;			
	int end									= 0 ;
	int i									= 1;

	if ( from == null )
		start								= 1 ;
	else
		start								= Integer.parseInt( from ) ;

	if ( to == null )
	  	end									= 14 ;
	else
		end									= Integer.parseInt( to ) ;

	Connection con							= null;
	Statement stmt							= null;
	ResultSet rs							= null;
	int maxRecord							= 0;
	try
	{	con									= ConnectionManager.getConnection(request); 
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from ip_booking_type  "+sql.toString());
		stmt								= con.createStatement();
		rs									= stmt.executeQuery(strsql2.toString());
		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ )
				rs.next() ;

		while (  i<=end && rs.next() )
			{
				if (maxRecord==0)
					{

%>
	<p>
		<table align='right'>
			<tr>
				<%
				if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../jsp/BookingTypeQueryResult.jsp?function_id="+function_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

				out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/BookingTypeQueryResult.jsp?function_id="+function_id+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
				%>
			</tr>
		</table>
	</p>
	<br>
	<br>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>				
				<th><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eIP.BookingType.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.booking.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
			</tr>
			<%
				}		
				String classValue = "" ;

				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				booking_type_code			= rs.getString("booking_type_code");
				booking_type_short_desc		= rs.getString("short_desc");
				booking_type_long_desc		= rs.getString("long_desc");
				indicator					= rs.getString("booking_type_ind");
				if(indicator==null) indicator="&nbsp";
					
				if(indicator.equals("I"))
					indicator_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.IntraHospitalBooking.label","ip_labels");
				else if(indicator.equals("E"))
					indicator_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExternalHospitalBooking.label","ip_labels");
				else if(indicator.equals("N"))
					indicator_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.New.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels");
				
				eff_status						= rs.getString("eff_status");

				out.println("<tr>");
				out.println("<td class='" + classValue + "'><a  href='../jsp/addModifyBookingType.jsp?function_id="+function_id+"&booking_type_code="+booking_type_code+"&indicator="+indicator+"' target='f_query_add_mod' >");
				out.println(booking_type_code+"</a></td>");
				out.print("<td class='" + classValue + "'>"+booking_type_long_desc+"</td>");
				out.print("<td class='" + classValue + "'>"+booking_type_short_desc+"</td>");
				out.print("<td class='" +classValue + "'>"+indicator_desc+"</td>");
				out.print("<td align='center' class='" + classValue + "'>");
					if(eff_status.equals("E"))
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
				out.print("</td></tr>");
				i++;
				maxRecord++;
			}
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
				out.print(e.toString());
				e.printStackTrace();
			}
			finally   
			{
					if(rs!=null) 		rs.close();
					if(stmt!=null) 	stmt.close();
					ConnectionManager.returnConnection(con,request); 
			}
			%>
			</td></tr>
		</table>
	</body>
</html>
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

