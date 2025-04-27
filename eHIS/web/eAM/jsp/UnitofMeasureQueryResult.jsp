<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>	
<!-- AM Master Unit of Measure Query Result-->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML>
<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()'; OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
    request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try
	{
		conn = ConnectionManager.getConnection(request);
		

		String whereClause = request.getParameter("whereclause");
		StringBuffer sbQuery = new StringBuffer();
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
	
		stmt = conn.createStatement();
  
		if((whereClause == null || whereClause.equals("")))
		{
			String code = request.getParameter("Code");
			String shortdesc=request.getParameter("long_desc");
			String enabled = request.getParameter("eff_status");
			//String externalUom= request.getParameter("DRUG_DATABASE_UOM_CODE");
			int andCheck = 0;

			if(!(code == null || code.equals("")))
			{
				code= code.toUpperCase();
				sbQuery.append("where  upper(UOM_CODE) like upper('"+code+"%')");
				andCheck = 1;
			}
			if(!(shortdesc == null || shortdesc.equals("")))
			{
				if(andCheck == 1)
				{
					sbQuery.append(	" and ");				
					sbQuery.append( "upper(long_desc) like  upper('"+shortdesc+"%')" );
				}
			else
			{
				sbQuery.setLength(0);
				sbQuery.append("where upper(long_desc) like upper('"+shortdesc+"%')");
				andCheck = 1;
			}
		}
		if(!(enabled == null || enabled.equals("")))
		{
			if(enabled.equals("E"))
	        {
				if(andCheck == 0) 
				{
					sbQuery.setLength(0);
					sbQuery.append("where eff_status='E'");
					andCheck = 1; 
				}
				else
				{
					sbQuery.append(" and eff_status='E'");
				}
			}
			if(enabled.equals("D"))
			{
				if(andCheck == 0) 
				{
						sbQuery.setLength(0);
					sbQuery.append(" where  eff_status='D'");
					andCheck = 1; 
				}
				else
				{
						sbQuery.append(" and eff_status='D'");
				}
			}
			if(enabled.equals("B"))
	   		{
	   		
			}
		}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if(!(ord == null || ord .equals("")))
		{	
				sbQuery.append(" order by ");
			for(int i=0;i < ord.length;i++)
		 	{
	 			if(i == ord.length - 1)
					sbQuery.append(ord[i]);
				else
					sbQuery.append(ord[i]+",");
			}
		}
	} //end of where clause IF
	else
	{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);	

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

	
	int maxRecord = 0;

	String strsql2="select * from AM_UOM "+sbQuery.toString();
	if(rs!=null)rs.close();
	rs = stmt.executeQuery(strsql2);

	if(start != 1)
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}

	while( i<=end && rs.next() )
	{
	if(maxRecord==0)
		{

%>

<p>
<table align='right'>
<tr>
<td>
<%
	if(!(start <= 1))
		out.println("<A id='prev' HREF='../jsp/UnitofMeasureQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	//if(!( (start+14) > maxRecord ))
		out.println("<A id='next' HREF='../jsp/UnitofMeasureQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.uom.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.external.label" bundle="${common_labels}"/> <fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>


<% }
 		
		String externalUom		=(rs.getString("DRUG_DATABASE_UOM_CODE")==null)?"":rs.getString("DRUG_DATABASE_UOM_CODE");

	  String classValue = "" ;
        if(i % 2 == 0)
		  classValue = "QRYEVEN" ;
		else
		  classValue = "QRYODD" ;
		out.println("<tr><td class='" + classValue + "'>");
		String code = rs.getString("UOM_CODE");
		out.println("<a href='../jsp/addModifyUnitofMeasure.jsp?Code="+ code + "' target='f_query_add_mod' >");
		out.println(code+"</a></td><td class='" + classValue + "'>");
		out.println(rs.getString("long_desc") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(rs.getString("short_desc") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(externalUom);
		out.println("&nbsp;");
		//out.println(rs.getString("DRUG_DATABASE_UOM_CODE") );
		out.println("</td><td class='" + classValue + "' align='center'>");
		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
		{
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		}
		i++;
		maxRecord++;
	}// end of while  
	
	if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}
%>

</td></tr>
</table>

<%
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	
}//end of try
catch(Exception e) {out.println("main try"+e);}
finally
{

	ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>

