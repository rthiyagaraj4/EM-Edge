<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML>

 <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT></head><BODY  OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >
<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue	 
/* request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); */
//MMS-ME-SCF-0096 vulnerability Issue
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer("") ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.setLength(0);
		sql.append(" Where AM_SPECIALITY.vital_signs_battery_id = AM_DISCR_MSR.discr_msr_id (+) ");
		String cd = request.getParameter("speciality_code");	if(cd==null) cd = "";
		String longdesc = request.getParameter("long_desc");	if(longdesc==null) longdesc = "";
		String enabled = request.getParameter("eff_status");	if(enabled==null) enabled = "";
		String vitalsigns = request.getParameter("vital_signs_battery_id");	if(vitalsigns==null) vitalsigns = "";
		
		if ( !(cd == null || cd.equals("")) )
		{
			sql.append(" and upper(AM_SPECIALITY.speciality_code) like upper('"+cd+"%')");
		}

		if ( !(longdesc == null || longdesc.equals("")) )
		{
			sql.append(" and upper(AM_SPECIALITY.long_desc)  like  upper('"+longdesc+"%') " );
		}

		if ( !(vitalsigns == null || vitalsigns.equals("")) )
		{
			sql.append(" and upper(AM_SPECIALITY.vital_signs_battery_id)  like  upper('"+vitalsigns+"%') ") ;
		}

		if ( !(enabled == null || enabled.equals("")) )
		{
			if ( enabled.equals("E") )
			{
				sql.append(" and AM_SPECIALITY.eff_status='E'");
			}

			if ( enabled.equals("D") )
			{
				sql.append(" and AM_SPECIALITY.eff_status='D'");
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
	else
	{
		sql.setLength(0);
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

boolean isMRSpecialtyApp	= false;//Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454
try
{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement(); 
isMRSpecialtyApp = eCommon.Common.CommonBean.isSiteSpecific(conn, "MR", "MR_SPECIALTY_DEF_APPL_YN");//Added By Dharma on Dec 6th 2019 against ML-MMOH-CRF-1454

String strsql2="Select AM_SPECIALITY.speciality_code speciality_code, AM_SPECIALITY.long_desc sp_long_desc, AM_SPECIALITY.short_desc sp_short_desc, AM_SPECIALITY.eff_status sp_eff_status, AM_DISCR_MSR.short_desc msr_short_desc,AM_SPECIALITY.MR_APPL_YN MR_APPL_YN from AM_SPECIALITY, AM_DISCR_MSR "+sql;

rs = stmt.executeQuery(strsql2);

if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}

while ( i<=end  && rs.next() )
{
	if(maxRecord==0)
	{

%>

<p>
<table align='right'>
<tr>

<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/querySpeciality.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/querySpeciality.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>

</tr>
</table>
</p>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.VitalSignsBattery.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%if(isMRSpecialtyApp){ %>
<th class='columnheader'><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/></th>
<%} %>
<% }
 	
		String classValue = "" ;
	  
        if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  
	String vsigns = rs.getString("msr_short_desc"); 
		if(vsigns == null || vsigns.equals("null")) vsigns = "&nbsp;";
	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("speciality_code");
	out.println("<a href='../../eAM/jsp/addModifySpeciality.jsp?speciality_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("sp_long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("sp_short_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(vsigns);
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("sp_eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td><td align='center' class='" + classValue + "'>");
	
	if(isMRSpecialtyApp){
		if ( rs.getString("MR_APPL_YN").equals("Y") && rs.getString("sp_eff_status").equals("E"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	}
	i++;
	maxRecord++;

  }//endwhile

   if(maxRecord == 0)
		{ %>
			 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<% }

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

}// end of try
catch(Exception e)
{
		e.toString();
}
	finally 
	{
	try
	{
		if(stmt!=null) 	stmt.close();
		if(rs!=null) 	rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(conn,request);

}
%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

