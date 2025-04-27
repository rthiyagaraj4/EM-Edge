<!DOCTYPE html>
	<!-- *****AM Master - Trade Name Query Result **** -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page  contentType="text/html;charset=UTF-8"%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML>
<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><BODY  class='CONTENT' onLoad='ClearMsg()'; OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
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
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		String tradeid = request.getParameter("tradeid");
		String longname=request.getParameter("long_name");
		String enabled = request.getParameter("eff_status");
		String shortname = request.getParameter("Manufacturer_name");
		String manufacturerid = request.getParameter("Manufacturer_id");
		String drug = request.getParameter("drug_yn");
		stmt = conn.createStatement();
  
		if((whereClause == null || whereClause.equals("")))
		{
		//	sql="";
			
			int andCheck = 0;
			
			if(!(tradeid == null || tradeid.equals("")))
			{
				tradeid= tradeid.toUpperCase();
				sbQuery.append(" and upper(A.TRADE_ID) like upper('"+tradeid+"%')");
				//sql = " and upper(A.TRADE_ID) like upper('"+tradeid+"%')";
				andCheck = 1;
			}
			if(!(longname == null || longname.equals("")))
			{
				if(andCheck == 1)
				{
					sbQuery.append(" and ");
					//sql = sql + " and ";
					sbQuery.append("upper(A.LONG_NAME) like  upper('"+longname+"%')");
					//sql = sql + "upper(A.LONG_NAME) like  upper('"+longname+"%')" ;
				}
				else
				{
					sbQuery.setLength(0);
					sbQuery.append(" and upper(A.LONG_NAME) like upper('"+longname+"%')");
					//sql = " and upper(A.LONG_NAME) like upper('"+longname+"%')" ;
					andCheck = 1;
				}
			}
			if(!(shortname == null || shortname.equals("")))
			{
				if(andCheck == 1)
				{
					sbQuery.append( " and ");
				//	sql = sql + " and ";
					sbQuery.append(	"upper(b.SHORT_NAME) like  upper('"+shortname+"%')");
					//sql = sql + "upper(A.SHORT_NAME) like  upper('"+shortname+"%')" ;
				}
				else
				{
					sbQuery.setLength(0);
					sbQuery.append(" and upper(b.SHORT_NAME) like upper('"+shortname+"%')");
					//sql = " and upper(A.SHORT_NAME) like upper('"+shortname+"%')" ;
					andCheck = 1;
				}
			}
			if(!(manufacturerid == null || manufacturerid.equals("")))
			{
				if(andCheck == 1)
				{
					sbQuery.append( " and ");
					//sql = sql + " and ";
					sbQuery.append("upper(A.MANUFACTURER_ID) like  upper('"+manufacturerid+"%')") ;
					//sql = sql + "upper(A.MANUFACTURER_ID) like  upper('"+manufacturerid+"%')" ;
				}
				else
				{
					sbQuery.setLength(0);
					sbQuery.append("and upper(A.MANUFACTURER_ID) like upper('"+manufacturerid+"%')" );
					//sql = " and upper(A.MANUFACTURER_ID) like upper('"+manufacturerid+"%')" ;
					andCheck = 1;
				}
			}
			if (!(drug == null || drug.equals("")))
			{
				if(drug.equals("Y"))
				{
					if(andCheck == 0) 
					{
							sbQuery.setLength(0);
							sbQuery.append(" and A.DRUG_YN='Y'");
						//sql = " and A.DRUG_YN='Y'";
						andCheck = 1; 
					}
					else
					{
						sbQuery.append("and A.DRUG_YN='Y'");
						//sql = sql + " and A.DRUG_YN='Y'";
					}
				}
				if(drug.equals("N"))
				{
					if(andCheck == 0) 
					{
						sbQuery.setLength(0);
						sbQuery.append("  and A.DRUG_YN='N'");
					//	sql = "  and A.DRUG_YN='N'";
						andCheck = 1; 
					}
					else
					{
						sbQuery.append("and A.DRUG_YN='N'");
						//sql = sql + " and A.DRUG_YN='N'";
					}
				}
			}
			if (!(enabled == null || enabled.equals("")))
			{
				if(enabled.equals("E"))
				{
					if(andCheck == 0) 
					{
						sbQuery.setLength(0);
						sbQuery.append("and A.eff_status='E'");
						//sql = " and A.eff_status='E'";
						andCheck = 1; 
					}
					else
					{
						sbQuery.append( " and A.eff_status='E'");
					//	sql = sql + " and A.eff_status='E'";
					}
				}
				if(enabled.equals("D"))
				{
					if(andCheck == 0) 
					{
						sbQuery.setLength(0);
						sbQuery.append( " and A.eff_status='D'");
						//sql = "  and A.eff_status='D'";
						andCheck = 1; 
					}
					else
					{
						sbQuery.append(" and A.eff_status='D'");
						//sql = sql + " and A.eff_status='D'";
					}
				}
			}
			//appending order by clause
			String ord[] = request.getParameterValues("orderbycolumns");

			if(!(ord == null || ord .equals("")))
			{
				sbQuery.append("order by "); 	
				//sql=sql+" order by ";
				for ( int i=0;i < ord.length;i++ )
	 			{
	 				if ( i == ord.length - 1 )
						sbQuery.append(ord[i]);
						//sql=sql+ord[i];
					else
						sbQuery.append(ord[i]+",");
					//sql=sql+ord[i]+",";
				}
				
			}
		} //end of where clause IF
		else
		{
			sbQuery.setLength(0);
			sbQuery.append(whereClause);
//			sql = whereClause;
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
	String strsql2="select A.TRADE_ID TRADE_ID,A.LONG_NAME TRADE_LONG_NAME,A.SHORT_NAME TRADE_SHORT_NAME,B.SHORT_NAME MANUFACTURER_NAME,A.EFF_STATUS EFF_STATUS,A.DRUG_YN DRUG,A.MANUFACTURER_ID,B.MANUFACTURER_ID from AM_TRADE_NAME A,AM_MANUFACTURER B WHERE A.MANUFACTURER_ID=B.MANUFACTURER_ID ";
	if (!sbQuery.toString().equals(""))
		strsql2 += sbQuery.toString();
	if(rs!=null)rs.close();
//out.println("strsql2 "+strsql2);
		rs = stmt.executeQuery(strsql2);

	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	 {
		rs.next() ;
	  }

	  while ( i<=end && rs.next())
	{
		  if(maxRecord==0)
		{

%>

<p>
<table align='right'>
<tr>
<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../jsp/TradeNameQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//	if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/TradeNameQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>

</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longname.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortname.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.ManufacturerID.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<% }
 	
	  String classValue = "" ;

        if ( i % 2 == 0 )
		  classValue = "QRYEVEN" ;
		else
		  classValue = "QRYODD" ;

		out.println("<tr><td  class='" + classValue + "' nowrap>");
		tradeid = rs.getString("TRADE_ID");
		out.println("<a href='../jsp/addModifyTradeName.jsp?tradeid="+ tradeid + "' target='f_query_add_mod' >");
		out.println(tradeid+"</a></td><td  class='" + classValue + "' nowrap>");
		out.println(rs.getString("TRADE_LONG_NAME") );
		out.println("</td><td class='" + classValue + "' nowrap>");
		out.println(rs.getString("TRADE_SHORT_NAME") );
		out.println("</td><td  class='" + classValue + "' nowrap>");
		out.println(rs.getString("MANUFACTURER_ID") );
		out.println("</td><td  class='" + classValue + "' align='left' nowrap>");
		out.println(rs.getString("MANUFACTURER_NAME") );
		out.println("</td><td  class='" + classValue + "' align='center' nowrap>");
		if ( rs.getString("DRUG").equals("Y") )
		{
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		}
		else
		{
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		}
		out.println("</td><td  class='" + classValue + "' align='center' nowrap>");
		if ( rs.getString("EFF_STATUS").equals("E") )
		{
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		}
		else
		{
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		}
		i++;
		maxRecord++;
	}//end od while  
	
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
%>

</td></tr>
</table>

<%
	if (rs != null)		rs.close();
	if (stmt != null)   stmt.close();

}catch(Exception e) {out.println("main try"+e);}
finally
{
	
	ConnectionManager.returnConnection(conn,request);
}
%>
</center>
</BODY>
</HTML>

