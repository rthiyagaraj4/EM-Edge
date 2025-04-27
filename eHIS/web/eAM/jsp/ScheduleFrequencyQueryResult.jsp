<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>


<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>

<BODY class='CONTENT'  onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>
 <%
 request.setCharacterEncoding("UTF-8");	
    
	String from		=request.getParameter("from") ;
    String to		=request.getParameter("to") ;
	String sql		= "";

	String freq_code	= (request.getParameter("freq_code")==null)?"%":(request.getParameter("freq_code")+"%");
	String freq_desc	= (request.getParameter("freq_desc")==null)?"%":(request.getParameter("freq_desc")+"%");
	String facility_id	= (request.getParameter("facility_id")==null)?"%":(request.getParameter("facility_id")+"%");
	String facility_name=
	(request.getParameter("facility_name")==null)?"%":(request.getParameter("facility_name")+"%");
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

	Connection conn  =  ConnectionManager.getConnection(request);

	Statement stmt = null;
	
	ResultSet rs=null;
	int maxRecord = 0;

	try
	{
		String whereclause = request.getParameter("whereclause");

		if(whereclause == null )
		{
			sql="SELECT distinct a.freq_code, b.freq_desc, a.admin_facility_id, facility_name FROM AM_FREQUENCY_ADMIN_DAY_TIME a, AM_FREQUENCY b, sm_facility_param c WHERE b.freq_code  = a.freq_code AND a.freq_code LIKE UPPER('"+freq_code+"') AND upper(b.freq_desc) LIKE UPPER('"+freq_desc+ "' ) and c.facility_id = a.admin_facility_id AND a.admin_facility_id LIKE UPPER('"+facility_id+"') AND upper(c.facility_name) LIKE  UPPER('"+facility_name+"')";

			if ((facility_id.equalsIgnoreCase("*A%") || facility_id.equalsIgnoreCase("*%"))|| (facility_id.equals("%") && !facility_name.equals("%")))
				sql =sql+ " UNION SELECT a.freq_code,freq_desc,admin_facility_id,'All' facility_name FROM  AM_FREQUENCY_ADMIN_DAY_TIME a,AM_FREQUENCY b WHERE a.freq_code  =b.freq_code AND a.freq_code LIKE UPPER( '"+freq_code+"') AND upper(b.freq_desc) LIKE  UPPER('"+freq_desc+"') AND a.admin_facility_id ='*A'";
			else if (facility_id.equals("%") && facility_name.equals("%"))
				sql =sql+ " UNION SELECT a.freq_code,freq_desc,admin_facility_id,'All' facility_name FROM  AM_FREQUENCY_ADMIN_DAY_TIME a,AM_FREQUENCY b WHERE a.freq_code  =b.freq_code AND a.freq_code LIKE UPPER( '"+freq_code+"') AND upper(b.freq_desc) LIKE  UPPER('"+freq_desc+"') AND a.admin_facility_id ='*A'";

				sql = "select freq_code, freq_desc, admin_facility_id, facility_name from ("+sql+") A where admin_facility_id LIKE UPPER('"+facility_id+"') AND upper(facility_name) LIKE  UPPER('"+facility_name+"')";

			String ord[] = request.getParameterValues("orderbycolumns");

				if ( !(ord == null || ord .equals("")) )
				{
					sql=sql+" order by ";
					for ( int m=0;m < ord.length;m++ )
					{
						if( m == ord.length - 1 )
						sql=sql+ord[m];
						else
						sql=sql+ord[m]+",";
					}
				}
		}
		else
		{
			sql = whereclause ;
		}


		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);

		

		if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
			  rs.next() ;

		while ( i<=end && rs.next())
		{
			if(maxRecord==0)
			{

%>
		<P>
		<table align='right'>
		<tr>
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ScheduleFrequencyQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//	if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ScheduleFrequencyQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
		</tr>
		</table>
		<br><br>
		</p>

		<table border="1" width="100%" cellspacing='0' cellpadding='0' >
		<th class='columnheader' width='20%' ><fmt:message key="Common.FrequencyCode.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='40%'><fmt:message key="Common.FrequencyDescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='10%'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th class='columnheader' width='30%'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>

<% }
	 
		String classValue= " ";
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			out.println("<tr><td align=='left' class='" + classValue + "'>");

			String freq_code_P		=(rs.getString(1)==null)?"":rs.getString(1);
			String freq_desc_P		=(rs.getString(2)==null)?"":rs.getString(2);
			String facility_id_P	=(rs.getString(3)==null)?"":rs.getString(3);
			String facility_name_P  =(rs.getString(4)==null)?"":rs.getString(4);
	
			out.println("<a href='../../eAM/jsp/ScheduleFrequencyAddModify.jsp?mode=2&freq_code="+ URLEncoder.encode(freq_code_P)  + "&freq_desc="+ URLEncoder.encode(freq_desc_P)  +  "&facility_id="+ URLEncoder.encode(facility_id_P)+ "&facility_name="+ URLEncoder.encode(facility_name_P)  + "' >");

			out.println(freq_code_P + "</a></td><td class='" + classValue + "'>");
			out.println(freq_desc_P);
			out.println("</td><td class='" + classValue + "'>");
			out.println(facility_id_P);
			out.println("</td><td class='" + classValue + "' align='left'>");
			out.println(facility_name_P);
			out.println("</td>");
			i++;
			maxRecord++;
		}//end of while 

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
		</center>
		<br><center>
<%
	}
	catch(Exception e )
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}	
%>
</center>
</BODY>
</HTML>

