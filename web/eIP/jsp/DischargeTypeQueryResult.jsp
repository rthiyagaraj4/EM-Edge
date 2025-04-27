<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onKeyDown='lockKey()' OnMouseDown='CodeArrest()'>");
	String whereClause			= request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();						
	//Variable that holds where clause for that's dynamically constructed
	String from	= request.getParameter( "from" ) ;		//Variable that contains the number from which the display of the record starts
	String to	= request.getParameter( "to" ) ;	//Variable that contains the number from which the display of the record ends
	String discharge_type_code		= "";
	String discharge_type_desc		= "";
	String indicator				= "";
	String indicator_desc			= "";
	String maternal_death			= "";
	String eff_status				= "";
	String discharge_type_longdesc	= "";
	String blocking_type_desc="";

	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*	Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		discharge_type_code	= request.getParameter("discharge_type_code");
		discharge_type_desc	= request.getParameter("discharge_type_desc");
		indicator			= request.getParameter("indicator");
		maternal_death		= request.getParameter("MATERNAL_DEATH_YN");
		eff_status			= request.getParameter("eff_status");
		blocking_type_desc	=request.getParameter("BLOKCING_TYPE_SHORT_DESC");
				
		discharge_type_code=discharge_type_code.toUpperCase();
		
		/*Parameter variable definition ends here*/

		int andCheck						= 0;

		if(discharge_type_code!=null && !discharge_type_code.equals(""))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" where upper(discharge_type_code) like upper('"+discharge_type_code+"%')");
			andCheck = 1;
		}
		//check for blocking_type_desc
		if(blocking_type_desc!=null && !blocking_type_desc.equals(""))
		{
			if ( andCheck == 1 )
			{
			sql.append(" and upper(BLOKCING_TYPE_SHORT_DESC) like upper('"+blocking_type_desc+"%')");
			andCheck = 1;
			}
			else
			{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where upper(BLOKCING_TYPE_SHORT_DESC) like upper('"+blocking_type_desc+"%')");
			andCheck = 1;
			}
		}

		if(discharge_type_desc!=null && !discharge_type_desc.equals(""))
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(long_desc) like  upper('"+discharge_type_desc+"')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(long_desc) like upper('"+discharge_type_desc+"%')" );
				andCheck = 1;
			}
		}

		if (!indicator.equals("") && !indicator.equals("A"))
		{
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where indicator='"+indicator+"'");
				andCheck = 1;
			}
			else
				sql.append(" and indicator='"+indicator+"' ");
		}

		if ( maternal_death.equals("Y") )
		{
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where MATERNAL_DEATH_YN='Y'");
				andCheck = 1;
			}
			else
				sql.append(" and MATERNAL_DEATH_YN='Y'");
		}
		else if ( maternal_death.equals("N") )
		{
			if ( andCheck == 0 )
			{
				sql.append(" where MATERNAL_DEATH_YN='N'");
				andCheck = 1;
			}
			else
				sql.append(" and MATERNAL_DEATH_YN='N' ");
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
		if(sql.length() > 0) sql.delete(0,sql.length());
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
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{	con = ConnectionManager.getConnection(request); 
		/*StringBuffer strsql1 = new StringBuffer();
		strsql1.append("select count(*) as total from ip_discharge_type_vw "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");
	if (rs!=null) rs.close();
	if (stmt!=null) stmt.close();
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
	}
	else
	{*/
		StringBuffer strsql2 = new StringBuffer();
		strsql2.append("select * from ip_discharge_type_vw  "+sql.toString());
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2.toString());

		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ )
				rs.next() ;

		while (  i<=end && rs.next() )
			{
				if (maxRecord==0)
					{
		%>

		<P>
		<table align='right'>
			<tr>
				
					<%
					if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='../jsp/DischargeTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					//if ( !( (start+14) > maxRecord ) )
						out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/DischargeTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
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
				<th><fmt:message key="eIP.BlockingType.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="eIP.DischargeTypeIndicator.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="eIP.MaternalDeath.label" bundle="${ip_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
				<%
					}
				/*if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;*/
					
						String classValue = "" ;

				//while ( rs.next() && i<=end )
				//{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;


						discharge_type_code		= rs.getString("discharge_type_code");
						discharge_type_desc		= rs.getString("short_desc");
						discharge_type_longdesc	= rs.getString("long_desc");
						blocking_type_desc			=rs.getString("BLOKCING_TYPE_SHORT_DESC");
						if(blocking_type_desc==null) blocking_type_desc="&nbsp";
						indicator				= rs.getString("indicator");
						if(indicator==null) indicator="&nbsp";
					
						if(indicator.equals("AB"))
							indicator_desc = "Absconded";
						else if(indicator.equals("AO"))
							indicator_desc = "At Own Risk";
						else if(indicator.equals("DS"))
							indicator_desc = "Deceased";
						else if(indicator.equals("ND"))
							indicator_desc = "Discharged/Home";
						else if(indicator.equals("ED"))
							indicator_desc = "Transfer to Other Hospital";

						maternal_death			= rs.getString("MATERNAL_DEATH_YN");
						eff_status				= rs.getString("eff_status");
						
						out.println("<tr>");
						out.println("<td class='" + classValue + "'><a  href='../jsp/addModifyDischargeType.jsp?discharge_type_code="+discharge_type_code+"&mat_death="+maternal_death+"&dead="+indicator+"' target='f_query_add_mod' >");
						out.println(discharge_type_code+"</a></td>");
						out.print("<td class='" + classValue + "'>"+discharge_type_longdesc+"</td>");
						out.print("<td class='" + classValue + "'>"+discharge_type_desc+"</td>");
						out.print("<td class='" + classValue + "'>"+blocking_type_desc+"</td>");

						out.print("<td class='" +classValue + "'>"+indicator_desc+"</td>");


						out.print("<td align='center' class='" + classValue + "'>");
						if(maternal_death.equals("Y"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
						out.print("</td>");

						out.print("<td align='center' class='" + classValue + "'>");
						if(eff_status.equals("E"))
							out.println("<img src='../../eCommon/images/enabled.gif'></img>");
						else
							out.println("<img src ='../../eCommon/images/RRnwd.gif'></img>");
						out.print("</td></tr>");
						i++;
						maxRecord++;

				}//endwhile
			//if (rs!=null) rs.close();
			//if (stmt!=null) stmt.close();
			//}
						
						if(maxRecord == 0)
						{
							out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
						}

						if ( maxRecord < 14 || (!rs.next()) )
						{
							%>
							
								if (document.getElementById('next'))
									document.getElementById('next').style.visibility='hidden';
							</script>
							<% 
						}
						else
							{%>
							<script >
								if (document.getElementById('next'))
									document.getElementById('next').style.visibility='visible';
							</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



							<%
							}
			}
			catch(Exception e)
			{
				out.print(e.toString());
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

