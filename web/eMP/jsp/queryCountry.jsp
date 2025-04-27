<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");

	StringBuffer sbQuery = new StringBuffer();

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
//	sql = "";
	String cd = request.getParameter("country_code");
	cd=cd.toUpperCase();
	String longname=request.getParameter("long_name");
	longname = longname.toUpperCase();
	String longdesc = request.getParameter("long_desc");
	longdesc = longdesc.toUpperCase();
	String enabled = request.getParameter("nature");

	//Query Modified by Himanshu Saxena added "TELEPHONE_CODE" for ML-MMOH-CRF-1930 on 19-04-2023
	String telephone_country_code = request.getParameter("telephone_country_code");
	if(!(telephone_country_code == null || telephone_country_code.equals("")))
	{
	telephone_country_code = telephone_country_code.toUpperCase();
	}
	
	
	int andCheck = 0;


	if ( !(cd == null || cd.equals("")) )
		{
		sbQuery.append("where country_code like '");
		sbQuery.append(cd);
		sbQuery.append("%'");
//		sql = "where country_code like '"+cd+"%'";
		andCheck = 1;
		}
	if ( !(longname == null || longname.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(long_name) like  '");
			sbQuery.append(longname);
			sbQuery.append("%'" );
//			sql = sql + " and ";
//			sql = sql + "upper(long_name) like  '"+longname+"%'" ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(long_name) like '");
			sbQuery.append(longname);
			sbQuery.append("%'" );
//			sql = "where upper(long_name) like '"+longname+"%'" ;
			andCheck = 1;
		}
	}

	if ( !(longdesc == null || longdesc.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sbQuery.append(" and ");
				sbQuery.append("upper(long_desc) like  '");
				sbQuery.append(longdesc);
				sbQuery.append("%'" );
//				sql = sql + " and ";
//				sql = sql + "upper(long_desc) like  '"+longdesc+"%'" ;
			}
			else
			{
				sbQuery.setLength(0);
				sbQuery.append("where upper(long_desc) like '");
				sbQuery.append(longdesc);
				sbQuery.append("%'");
//				sql = "where upper(long_desc) like '"+longdesc+"%'" ;
				andCheck = 1;
			}
	}


	if ( !(enabled == null || enabled.equals("")) )
	{
		//Added by Sabarinathan S on 2/17/2005
		if(!enabled.equals("B")){
			if(andCheck == 0){
				sbQuery.setLength(0);
				sbQuery.append("where  ");
			}else
				sbQuery.append(" and ");
			sbQuery.append("eff_status='"+enabled+"'");
		}else if(enabled.equals("B")){
			if(andCheck == 1)	
				sbQuery.append(" and (eff_status='E' or eff_status='D')");
			else{
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E' or eff_status='D'");				
			}
		}
	}
	//Query Modified by Himanshu Saxena added "TELEPHONE_CODE" for ML-MMOH-CRF-1930 on 19-04-2023
	if(!(telephone_country_code == null || telephone_country_code.equals("")))
	{
		
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(TELEPHONE_CODE) like  '");
			sbQuery.append(telephone_country_code);
			sbQuery.append("%'" );
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(TELEPHONE_CODE) like '");
			sbQuery.append(telephone_country_code);
			sbQuery.append("%'");
//			sql = "where upper(long_desc) like '"+longdesc+"%'" ;
			andCheck = 1;
		}
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
			sbQuery.append(" order by ");
//			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
//					sql=sql+ord[i];
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
//					sql=sql+ord[i]+",";
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//		sql = whereClause;
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
PreparedStatement pstmt=null;
ResultSet rs = null ;
//int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);

	Boolean isTelephone_code  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 19-04-2023 -->
	
	//out.println("select count(*) as total from mp_country "+sql);
	/*pstmt = conn.prepareStatement("select count(*) as total from mp_country "+sbQuery.toString());
	rs = pstmt.executeQuery();
	if (rs.next())
	{
		maxRecord = rs.getInt("total");
	}
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

	pstmt = conn.prepareStatement("select country_code, long_desc, short_desc, long_name, short_name, eff_Status,TELEPHONE_CODE from mp_country "+sbQuery.toString());
	rs = pstmt.executeQuery();

%>


<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue = "" ;
	  int cnt=0;
while ( i<=end  && rs.next())
{
	if(cnt==0)
	{%>
		<p>
		<table  align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><a href='../../eMP/jsp/queryCountry.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<a href='../../eMP/jsp/queryCountry.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
		<br><br>
		</p>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longname.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Citizenship.label" bundle="${common_labels}"/></th>
		<!--th >Effective From</th>
		<th >Effective To</th-->
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		
		<%if(isTelephone_code){ %>
		<th><fmt:message key="eMP.telephonecode.label" bundle="${common_labels}"/></th>
		<% } %>
		
		
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("country_code");
	// if ( rs.getString("eff_status").equals("E") )
	out.println("<a href='../../eMP/jsp/CountryModify.jsp?country_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_name") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_name") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("long_desc") );
	out.println("</td><td class='" + classValue
		+ "' align='center'>");

	/*if ( rs.getDate("eff_date_from") != null )
	{
	 java.util.Date date = rs.getDate("eff_date_from");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 String dateString = formatter.format(date);
	 out.println(dateString);
	 dateString = null;
	 formatter = null;
	}
	else
	{
		out.println("&nbsp;");
	}
	out.println("</td><td class='" + classValue + "'>");

	if ( rs.getDate("eff_date_to") != null )
	{
	 java.util.Date date1 = rs.getDate("eff_date_to");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 String dateString = formatter.format(date1);
	 out.println(dateString);
	}
	else
	{
		out.println("&nbsp;");
	}
	out.println("</td><td align='center' class='" + classValue + "'>");
*/
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

	if(isTelephone_code){
		String TELEPHONE_CODE=rs.getString("TELEPHONE_CODE");
		if(TELEPHONE_CODE==null)
		{
			//TELEPHONE_CODE="&nbsp;";
			out.println("</td><td class='" + classValue + "'>");
			out.println("&nbsp;");
		}else{
		out.println("</td><td class='" + classValue + "'>");
		out.println(TELEPHONE_CODE);
		}
		}
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}



%>

</td></tr>
</table>
<br><center>
<%

	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) { 
	// out.println(e.toString());
	e.printStackTrace();
}finally{
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

