<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%

	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown='lockKey()';>");

	//String facilityId = (String) session.getValue( "facility_id" ) ;
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	
	if ((whereClause == null || whereClause.equals("")))
	{
		if(sql.length() > 0) sql.delete(0,sql.length());

		String currency_code = checkForNull(request.getParameter("currency_code"));
		/*String currency_name = checkForNull(request.getParameter("currency_name"));
		/String decimal_name = checkForNull(request.getParameter("decimal_name"));
		String conversion_rate = checkForNull(request.getParameter("conversion_rate"));		
		String conversion_operator = checkForNull(request.getParameter("conversion_operator"));
		String no_decimal = request.getParameter("no_decimal");*/
		String long_desc  = checkForNull(request.getParameter("long_desc"));
		String short_desc = checkForNull(request.getParameter("short_desc"));	
		
		//if(!(currency_code == null || currency_code.equals("")) ||  !(currency_name == null || currency_name.equals("")) || !(decimal_name == null || decimal_name.equals("")) || !(conversion_rate == null || conversion_rate.equals("")) ||  !(conversion_operator == null || conversion_operator.equals("")) ||  !(no_decimal == null || no_decimal.equals("")) ||  !(long_desc == null || long_desc.equals("")) || !(short_desc == null || short_desc.equals("")))
		if(!(currency_code == null || currency_code.equals("")) ||  !(long_desc == null || long_desc.equals("")) || !(short_desc == null || short_desc.equals("")))
			sql.append(" where 1=1 ");	

		if ( !(currency_code == null || currency_code.equals("")) )
		sql.append(" and upper(currency_code) like upper('"+currency_code+"%')");

		/*if ( !(currency_name == null || currency_name.equals("")) )
		sql.append(" and upper(currency_name_integer) like upper('"+currency_name+"%')");

		if ( !(decimal_name == null || decimal_name.equals("")) )
		sql.append(" and upper(currency_name_decimal) like upper('"+decimal_name+"%')");

		if ( !(conversion_rate == null || conversion_rate.equals("")) )
		sql.append(" and upper(conversion_rate) like upper('"+conversion_rate+"%')");

		if ( !(conversion_operator == null || conversion_operator.equals("")) )
		sql.append(" and upper(conversion_operator) like upper('"+conversion_operator+"%')");

		if ( !(no_decimal == null || no_decimal.equals("")) )
		sql.append(" and upper(num_of_decimal) like upper('"+no_decimal+"%')");
		*/

		if ( !(long_desc == null || long_desc.equals("")) )
		sql.append(" and upper(long_desc) like upper('"+long_desc+"%')");


		if ( !(short_desc == null || short_desc.equals("")) )
		sql.append(" and upper(short_desc) like upper('"+short_desc+"%')");

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
		sql.append(whereClause);

		// To display 14 records in a page

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
			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();

			StringBuffer strsql2 = new StringBuffer();
			strsql2.append("select * from SY_FOREIGN_CURRENCY  " + sql.toString());
			
			rs = stmt.executeQuery(strsql2.toString());

				if ( start != 1 )
					for( int j=1; j<start; i++,j++ ){
					rs.next() ;
					}

			while (  i<=end && rs.next())
			{
				if (maxRecord==0)
				{
				%>
				<P>
					<table align='right'>
						<tr>
							<%
								if ( !(start <= 1) )
									out.println("<td align ='right' id='prev'><A HREF='ForeignCurrQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
							
									out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='ForeignCurrQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
							%>
						</tr>
					</table>
				</P>
				<br>
				<br>

				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th><fmt:message key="eSM.CurrencyCode.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.CurrencyName.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.DecimalName.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.ConversionRate.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.ConversionOperator.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.NumberofDecimals.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>				
	<%		}
	

			String classValue = "" ;

			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			
			out.println("<tr><td nowrap class='" + classValue + "'>");		
			out.println("<a href=\"../../eSM/jsp/addModifyForeignCurrency.jsp?operation=modify&currency_code="+rs.getString("CURRENCY_CODE")+"\" target='f_query_add_mod' >");
			out.println(checkForNull(rs.getString("CURRENCY_CODE"))+"</a></td><td  nowrap class='" + classValue + "'>");
			out.println(checkForNull(rs.getString("CURRENCY_NAME_INTEGER"))+"</td><td  nowrap class='" + classValue + "'>");
			out.println(checkForNull(rs.getString("CURRENCY_NAME_DECIMAL"))+"</td><td  nowrap class='" + classValue + "'>");
			out.println(checkForNull(rs.getString("CONVERSION_RATE"))+"</td><td  nowrap class='" + classValue + "'>");
			out.println(checkForNull(rs.getString("CONVERSION_OPERATOR"))+"</td><td  nowrap class='" + classValue + "'>");
			out.println(checkForNull(rs.getString("NUM_OF_DECIMAL"))+"</td><td  nowrap class='" + classValue + "'>");
			out.println(checkForNull(rs.getString("LONG_DESC"))+"</td><td  nowrap class='" + classValue + "'>");
			out.println(checkForNull(rs.getString("SHORT_DESC"))+"</td></tr>");
			
			i++;
			maxRecord++;
			}//endwhile

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		else
			{%>
			</table>
			<%
			}


		boolean flag = false;
		if ( maxRecord < 14 || (!rs.next()) )
			{
				%>
					<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
					</script>
				<% flag = true;
			}
			else
			{%>
					<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='visible';
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<%
			}	
		}catch(Exception e)
		{
			out.println(e.toString());
		}
		finally   
		{
			if(stmt!=null) 	stmt.close();
			if(rs!=null) 		rs.close();
			ConnectionManager.returnConnection(conn,request);
		}
%>			
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>
	</BODY>
</HTML>

