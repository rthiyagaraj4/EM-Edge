<!DOCTYPE html>

<%--
	FileName	: AnatomicalSiteQueryResult.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY  class='CONTENT' onKeyDown = 'lockKey()' onLoad='ClearMsg()' onMouseDown='CodeArrest()'>
<%
	request.setCharacterEncoding("UTF-8");

	String whereClause		= request.getParameter("whereclause");
	//String sql ;
	StringBuffer sbQuery = new StringBuffer();
	String from 			= request.getParameter("from") ;
	String to 				= request.getParameter("to") ;
	if ( (whereClause == null || whereClause.equals("")) )
	{
	//	 sql						= "";
		 String anatomical_site_code= request.getParameter("anatomical_site_code");
		 String short_desc			= request.getParameter("short_desc");
		 String long_desc			= request.getParameter("long_desc");
		 String applicable_to_iss_yn= request.getParameter("applicable_to_iss_yn");
		 String oral_cavity_yn		= request.getParameter("oral_cavity_yn");
		 String enabled				= request.getParameter("eff_status");
		 int andCheck 				= 0;
		 // Changing to Upper case and checking
		 anatomical_site_code		= anatomical_site_code.toUpperCase();
	
	 if ( !(anatomical_site_code== null || anatomical_site_code.equals("")) )
	 {
	  sbQuery.append(" where ANATOMICAL_SITE_CODE like '"+anatomical_site_code+"%'");	
	 // sql		= " where ANATOMICAL_SITE_CODE like '"+anatomical_site_code+"%'";
	  andCheck 	= 1;
	 }
	 //out.println(sql);		
	if ( !(long_desc == null || long_desc.equals("")) )
	 {
	    if ( andCheck == 1 )
	    {
				sbQuery.append(" and ");
	         // sql 	= sql + " and ";
			sbQuery.append(	" upper(LONG_DESC) like upper('"+long_desc+"%')" );
	     	//  sql 	= sql + " upper(LONG_DESC) like upper('"+long_desc+"%')" ;
	    }
	    else
	    {
			sbQuery.setLength(0);
			sbQuery.append(	" where upper(LONG_DESC) like upper('"+long_desc+"%')");
		//	 sql 	= " where upper(LONG_DESC) like upper('"+long_desc+"%')" ;
			 andCheck 	= 1;
	    }
	 }

	 if ( !(short_desc == null || short_desc.equals("")) )
	 {
	    if ( andCheck == 1 )
	    {
			sbQuery.append(	" and ");
	         // sql 	= sql + " and ";
				sbQuery.append(	" upper(SHORT_DESC) like upper('"+short_desc+"%')" );
	     	 // sql 	= sql + " upper(SHORT_DESC) like upper('"+short_desc+"%')" ;
	    }
	    else
	    {
			sbQuery.append(	"where upper(SHORT_DESC) like upper('"+short_desc+"%')");
			// sql 	= " where upper(SHORT_DESC) like upper('"+short_desc+"%')" ;
			 andCheck 	= 1;
	    }
	 }
  if ( !(applicable_to_iss_yn == null || applicable_to_iss_yn.equals("")) )
	     {
   	        if ( applicable_to_iss_yn.equals("Y") )
            {
				if ( andCheck == 0 ) 
				 {
					sbQuery.setLength(0);
					sbQuery.append(" where APPLICABLE_TO_ISS_YN='Y'");
					//sql = " where APPLICABLE_TO_ISS_YN='Y'";
					andCheck = 1;
				}
				else
					sbQuery.append(" and APPLICABLE_TO_ISS_YN='Y'");
					// sql = sql + " and APPLICABLE_TO_ISS_YN='Y'";
			}
   			if ( applicable_to_iss_yn.equals("N") )
			{
			  if ( andCheck == 0 ) 
			   {
				   sbQuery.setLength(0);
					sbQuery.append(" where  APPLICABLE_TO_ISS_YN='N'");
					//sql = " where  APPLICABLE_TO_ISS_YN='N'";
					andCheck = 1; 
				}
	          else
					sbQuery.append("and APPLICABLE_TO_ISS_YN='N'");
				 // sql = sql + " and APPLICABLE_TO_ISS_YN='N'";
	       }
   		}
		if ( !(oral_cavity_yn == null || oral_cavity_yn.equals("")) )
	     {
   	        if ( oral_cavity_yn.equals("Y") )
            {
				if ( andCheck == 0 ) 
				 {
					sbQuery.setLength(0);
					sbQuery.append(" where oral_cavity_yn='Y'");
					andCheck = 1;
				}
				else
					sbQuery.append(" and oral_cavity_yn='Y'");
			}
   			if ( oral_cavity_yn.equals("N") )
			{
			  if ( andCheck == 0 ) 
			   {
				   sbQuery.setLength(0);
					sbQuery.append(" where  oral_cavity_yn='N'");
					andCheck = 1; 
				}
	          else
					sbQuery.append("and oral_cavity_yn='N'");
	       }
   		}
	  if ( !(enabled == null || enabled.equals("")) )
	     {
   	        if ( enabled.equals("E") )
            {
				if ( andCheck == 0 ) 
				 {
					 sbQuery.setLength(0);
					sbQuery.append(" where EFF_STATUS='E'");
					//sql = " where EFF_STATUS='E'";
					andCheck = 1;
				}
				else
					sbQuery.append(" and EFF_STATUS='E'");
					// sql = sql + " and EFF_STATUS='E'";
			}
   			if ( enabled.equals("D") )
			{
			  if ( andCheck == 0 ) 
			   {
					sbQuery.setLength(0);
					sbQuery.append(" where  EFF_STATUS='D'");
					//sql = " where  EFF_STATUS='D'";
					andCheck = 1; 
				}
	          else
				sbQuery.append(" and EFF_STATUS='D'");
				//  sql = sql + " and EFF_STATUS='D'";
	       }
   			if ( enabled.equals("B") )
   			{
   	   		} 
	    }
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");
		//sql	= sql+" order by ";

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
			//sql = whereClause;
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
		 con =  ConnectionManager.getConnection(request);
		Statement stmt=null;
		ResultSet rs=null;
		int maxRecord = 0;

	try
	{
    
	  stmt = con.createStatement();
	 
	  String strsql2="select * from AM_ANATOMICAL_SITE "+sbQuery.toString();

 	  rs = stmt.executeQuery(strsql2);

	  if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }

	while ( i<=end && rs!=null && rs.next() )
 {
	if(maxRecord==0)
	 {

%>
<!-- Added/Modified By Nanda 10/21/2002 -->
<!-- <script>
	if (parseInt('<%=maxRecord%>')== 0)
	{
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		history.go(-1);
		//parent.frames[1]. location.href ="../../eAM/jsp/AnatomicalSiteQueryCriteria.jsp" ;
	}
</script> -->

<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/AnatomicalSiteQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

 // if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/AnatomicalSiteQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>"); 
	
%>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width='5%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th width='49%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th width='31%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th width='5%' nowrap><fmt:message key="eAM.ApplicabletoISS.label" bundle="${am_labels}"/></th>
<th width='5%' nowrap><fmt:message key="eMR.OralCavity.label" bundle="${mr_labels}"/></th>
<th width='5%' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<% }
	
 String classValue = "" ;

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String anatomical_site_code_disp = rs.getString("ANATOMICAL_SITE_CODE");
	
	out.println("<a href='../../eAM/jsp/addModifyAnatomicalSite.jsp?anatomical_site_code="+anatomical_site_code_disp+"' target='f_query_add_mod' >");
	out.println(anatomical_site_code_disp+"</a></td><td class='" + classValue + "'>");
	String long_desc_disp= rs.getString("LONG_DESC");
	out.println(long_desc_disp+"</td><td class='" + classValue + "'>");
	String short_desc_disp = rs.getString("SHORT_DESC");
	out.println(short_desc_disp+"</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("APPLICABLE_TO_ISS_YN").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
	out.println("</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("oral_cavity_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
	out.println("</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("EFF_STATUS").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
	i++;
	maxRecord++;
 }//endwhile 
 %>
</td></tr>
</table>
<br><center>
</center>
<%

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
	 
		 if(rs!=null)	rs.close();
		 if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
		//e.toString();
		//out.println("Exception for query :"+e.toString());
		e.printStackTrace();
     }
	finally   
	{
		
		 ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

