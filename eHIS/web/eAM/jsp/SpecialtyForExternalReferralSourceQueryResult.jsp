<!DOCTYPE html>
<%--
	FileName	: SpecialtyForExternalReferralSourceQueryResult.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()'  class='CONTENT' onKeyDown = 'lockKey()'>
<form name='query_form_result' id='query_form_result'>
<%
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");

	String from = request.getParameter( "from" ) ;
	StringBuffer sbQuery = new StringBuffer();


	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{

		String referral_code = request.getParameter("referral_code");
		if(referral_code==null) referral_code = "";
		

		String referral_short_desc = request.getParameter("referral_short_desc");
		if(referral_short_desc==null) referral_short_desc = "";
		
		String specialty_code = request.getParameter("specialty_code");
		if(specialty_code==null) specialty_code = "";
		

		String specialty_short_desc = request.getParameter("specialty_short_desc");
		if(specialty_short_desc==null) specialty_short_desc = "";
		

		


		int andCheck = 0;


		if ( !(referral_code == null || referral_code.equals("")) )
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(referral_code)  like upper('"+referral_code+"%') ");
		   andCheck = 1;
		   	
		}
		if ( !(referral_short_desc == null || referral_short_desc.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	
					sbQuery.append(" and ");
					sbQuery.append("referral_short_desc like  '"+referral_short_desc+"%'");
				   }
				   else
				   {
					   sbQuery.setLength(0);
					sbQuery.append("where upper(referral_short_desc) like upper('"+referral_short_desc+"%')") ;
					andCheck = 1;
				   }
		}

		if ( !(specialty_code == null || specialty_code.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   sbQuery.append(" and " );	
					sbQuery.append("upper(specialty_code) like  upper('"+specialty_code+"%')");
				   }
				   else
				   {
					   sbQuery.setLength(0);
					 sbQuery.append("where upper(specialty_code) like upper('"+specialty_code+"%')");
					andCheck = 1;
				   }
		}

		if ( !(specialty_short_desc == null || specialty_short_desc.equals("")) )
		{
		   if ( andCheck == 1 )
		   {
			  sbQuery.append(" and ");  	
			sbQuery.append(" upper(specialty_short_desc)  like  upper('"+specialty_short_desc+"%')");
		   }
		   else
		   {
			   sbQuery.setLength(0);
			sbQuery.append("where upper(specialty_short_desc)  like upper('"+specialty_short_desc+"%') ");
			andCheck = 1;
		   }
		}
	
	
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
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

Statement stmt=null;
ResultSet rs=null;
Connection conn=null;
int maxRecord = 0;
try{
conn = ConnectionManager.getConnection(request);


stmt = conn.createStatement();


String strsql2="select * from AM_REFERRAL_FOR_SPECIALTY_vw "+sbQuery.toString();

if(rs!=null)rs.close();
rs = stmt.executeQuery(strsql2);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
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
<td>
<%
if ( !(start <= 1) )
	out.println("<A id='prev' HREF='../../eAM/jsp/SpecialtyForExternalReferralSourceQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<A id='next' HREF='../../eAM/jsp/SpecialtyForExternalReferralSourceQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="eAM.ExternalReferralSource.label" bundle="${am_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.ExternalReferralSource.label" bundle="${am_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>


<% }
 	
	  String classValue = "" ;
	  
       if ( i % 2 == 0 )
       	  	classValue = "QRYEVEN" ;
       	  else
       	  	classValue = "QRYODD" ;
       	  


	out.println("<tr><td class='" + classValue + "'>");
	String referral_code = rs.getString("referral_code");
	String referral_short_desc = rs.getString("referral_short_desc");
	String specialty_code = rs.getString("specialty_code");
	String specialty_short_desc = rs.getString("specialty_short_desc");

	out.println(referral_code+"</a></td><td class='" + classValue + "'>");
	
	out.println(referral_short_desc+"</td><td class='" + classValue + "'>");
	
	out.println(specialty_code+"</td><td class='" + classValue + "'>");

	out.println(specialty_short_desc+"</td class='" + classValue + "'><td align='center' class='" + classValue + "'>");

	
	i++;
	maxRecord++;

  }//endwhile

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
}//end of try

catch(Exception e){
		out.print(e.toString());
}
	finally   {
	
	
//	if(rset!=null) 	rset.close();

	ConnectionManager.returnConnection(conn,request);

	}
%>

</td></tr>
</table>
<br>
</form>
</BODY>
</HTML>

