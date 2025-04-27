<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head><BODY  class='CONTENT' onLoad='ClearMsg()'  onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>
<%
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String pracid = request.getParameter("pract_id")==null ?"":request.getParameter("pract_id");
	String pracname=request.getParameter("pract_name")==null ?"":request.getParameter("pract_name");
	String enabled1 = request.getParameter("nature")==null ?"":request.getParameter("nature");
	String speciality_desc=request.getParameter("splty_desc")==null ?"":request.getParameter("splty_desc");
	String speciality_code=request.getParameter("splty_code")==null ?"":request.getParameter("splty_code").toUpperCase();

	if ( (whereClause == null || whereClause.equals("")) )
	{

	if ( !(pracid == null || pracid.equals("")) )
	{
		sbQuery.append(" and upper(am_ext_pract_for_referral.practitioner_id) like upper('"+pracid+"%') ");
	}

	if ( !(pracname == null || pracname.equals("")) )
	{
		sbQuery.append("and upper(am_ext_practitioner.practitioner_name)  like upper('"+pracname+"%') ") ;
	}

	if ( !(enabled1 == null || enabled1.equals("")) )
	{
	   if ( enabled1.equals("E") )
	        {
			sbQuery.append("and am_ext_pract_for_referral.eff_status='E' ");
		}
	   if ( enabled1.equals("D") )
		{
			sbQuery.append("and am_ext_pract_for_referral.eff_status='D' ");
		}
	  }

	if ( !(speciality_code == null || speciality_code.equals("")) )
	{
		sbQuery.append("and am_ext_pract_for_referral.REFERRAL_CODE like '"+speciality_code+"%'") ;
	}
	  
	  	if ( !(speciality_desc == null || speciality_desc.equals("")) )
	  	{
				sbQuery.append(" and upper(am_referral.LONG_DESC)  like upper('"+speciality_desc+"%') ");
	  	}
	  
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append("order by ");
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
		else
			sbQuery.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else{
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

Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();



			String sql1="SELECT am_ext_pract_for_referral.PRACTITIONER_ID, am_ext_practitioner.practitioner_name, am_ext_pract_for_referral.REFERRAL_CODE, am_referral.LONG_DESC,am_ext_pract_for_referral.EFF_STATUS FROM  am_ext_pract_for_referral ,am_referral, am_ext_practitioner WHERE am_ext_pract_for_referral.PRACTITIONER_ID = am_ext_practitioner.PRACTITIONER_ID and am_ext_pract_for_referral.REFERRAL_CODE = am_referral.REFERRAL_CODE ";

			sql1+=sbQuery.toString();
		
			rs = stmt.executeQuery(sql1);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
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
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryPractForExternalReferral.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryPractForExternalReferral.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>

</tr>
</table>
</p>
<br><br>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.referral.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.referral.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<% }

	String classValue = "" ;


        if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	
	out.println(rs.getString("REFERRAL_CODE")+"</td>");

	out.println("<td class='" + classValue + "'>");

	out.println(rs.getString("LONG_DESC")+"</td><td align='left' class='" + classValue + "'>");
	out.println(rs.getString("practitioner_id")+"</td><td align='left' class='" + classValue + "'>");
	out.println(rs.getString("practitioner_name")+"</td>");

	out.println("<td align='center' class='" + classValue + "'>");
	if ( rs.getString("EFF_STATUS").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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

	if(rs!=null)	rs.close();
	if(stmt!=null) 	stmt.close();
  	
  }//end of try
  catch(Exception e){out.print(e);}
  finally
  {
  	
  	ConnectionManager.returnConnection(conn,request);
  }
%>

</td></tr>
</table>

</BODY>
</HTML>

