<!DOCTYPE html>
<!--Created by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*, java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");

	String whereClause = request.getParameter("whereclause");
	String sql ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	// added by mujafar for ML-MMOH-CRF-0762 start	
	boolean classification_appl_yn=false;
	
	Connection conn =null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

try{
	conn=ConnectionManager.getConnection(request);
	classification_appl_yn	=  eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","CLASSIFICATION_APPL_YN");
	
	// added by mujafar for ML-MMOH-CRF-0762 end
	
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql="";
	String cd = request.getParameter("requestor_type_code");
	String longdesc = request.getParameter("long_desc");
	String enabled = request.getParameter("nature");
	String class_indicator = checkForNull(request.getParameter("class_indicator"));  // added by mujafar for ML-MMOH-CRF-0762 

	int andCheck = 0;

	cd=cd.toUpperCase();

	if ( !(cd == null || cd.equals("")) )
			{
			sql = "where upper(requestor_type_code)  like  upper('"+cd+"%') ";
			andCheck = 1;
			}

	if ( !(longdesc == null || longdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql = sql + " and ";
					sql = sql + " upper(long_desc)  like  upper('"+longdesc+"%') " ;
				}
				else
				{
					sql = " where upper(long_desc)  like  upper('"+longdesc+"%') " ;
					andCheck = 1;
				}
			}
			
			
	if(classification_appl_yn) // added by mujafar for ML-MMOH-CRF-0762 start
	{
			if ( !(class_indicator == null || class_indicator.equals("")) )
			{
				if ( andCheck == 0 )
				{
							sql = " where CLASSIFICATION_IND='"+class_indicator+"' ";
							andCheck = 1;
				}
				else
				{
					sql = sql + " and CLASSIFICATION_IND='"+class_indicator+"' ";
					
				}
			}

	} // added by mujafar for ML-MMOH-CRF-0762 end		
	

	if ( !(enabled == null || enabled.equals("")) )
			{
			   if ( enabled.equals("E") )
				{
				if ( andCheck == 0 )
					sql = " where eff_status='E'";
				else
					sql = sql + " and eff_status='E'";
				}
			   if ( enabled.equals("D") )
				{
				if ( andCheck == 0 )
					sql = "  where  eff_status='D'";
				else
					sql = sql + " and eff_status='D'";
				}
			}

	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
			{
				sql=sql+" order by ";

				for ( int i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					sql=sql+ord[i];
				else
					sql=sql+ord[i]+",";
				}
			}
	}
	else {
		sql = whereClause;
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

	
	
	
	stmt = conn.createStatement();

	String strsql2="select * from MR_REQUESTOR_TYPE "+sql;
	rs = stmt.executeQuery(strsql2);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	 while ( i<=end && rs.next() )
		{
			if (maxRecord==0)
			{
%>
			<P>
			<table align='right'>
			<tr>
			<%
			if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/RequestorTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

				out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/RequestorTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
			%>
			</tr>
			</table>
			<br><br>
			</P>

			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th><fmt:message key="eMR.RequestorType.label" bundle="${mr_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<%if(classification_appl_yn){%><th><fmt:message key="Common.Classification.label" bundle="${common_labels}"/></th><%}%>
			<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th> 
			
<%
			}
 	
		String classValue="";

		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;
		out.println("<tr><td  class='" + classValue + "'>");
		String code = rs.getString("requestor_type_code");

		out.println("<a href='../../eMR/jsp/RequestorTypeAddModify.jsp?requestor_type_code="+ code+"&mode=modify'>");
		out.println(code+"</a></td><td  class='" + classValue + "'>");
		out.println( rs.getString("long_desc") );
		out.println("</td><td  class='" + classValue + "'>");
		out.println(rs.getString("short_desc") );
		// added by mujafar for ML-MMOH-CRF-0762 start
		out.println("</td>");
		if(classification_appl_yn)
		{
		out.println("<td  class='" + classValue + "'>");
		String temp_val=checkForNull(rs.getString("CLASSIFICATION_IND"));
		if(temp_val.equals(""))
		{out.println("&nbsp;"); }
		else
		{ // modified by mujafar for ML-MMOH-CRF-0762
			if(temp_val.equals("O"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels"));
			else
			if(temp_val.equals("P"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels"));
			else
			if(temp_val.equals("N"))
			out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nextofkin.label","common_labels"));
		}
		out.println("</td>");
		}
		
		out.println("<td align='center'  class='" + classValue + "'>");
		// added by mujafar for ML-MMOH-CRF-0762 end
		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		maxRecord++;
		}
%>
		</td></tr>
		</table>
		<br><center>
<%
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	if ( maxRecord < 14 || (!rs.next()) )
	{
	%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
		</script>
	<% 
	}
	else
	{
	%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%
	}
%>

</center>
</BODY>
</HTML>
<%
}catch(Exception e){
		e.toString();
}
finally{
	if(stmt!=null)
	stmt.close();
	if(rs!=null)
	rs.close();
	ConnectionManager.returnConnection(conn,request);
	}	
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

