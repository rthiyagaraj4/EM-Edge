<!DOCTYPE html>
<!--
*	Copyright © iSoft Solutions (P) Ltd.
*	Created By		:	S.V.Narayana 
		Modified by :Anjaneya R M

*	Created On		:	18 aug 2008
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
String locale=(String)session.getAttribute("LOCALE");
	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql = new StringBuffer();
	String cd = request.getParameter("DIAG_CLASS_CODE");
	String longdesc = request.getParameter("LONG_DESC");
	String type = request.getParameter("DIAG_CLASS_TYPE");
	String enabled = request.getParameter("nature");
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
	/*Start*/	
	String default_status=request.getParameter("Default");
	/*End*/

	int andCheck = 0;
	if ( !(cd == null || cd.equals("")) )
			{
			sql.append(" and a.diag_class_code like upper ('"+cd+"%') ");
			andCheck = 1;
			}
			longdesc=longdesc.toUpperCase();
if ( !(longdesc == null || longdesc.equals("")) )
			{
				
					sql.append(" and UPPER(a.long_desc) like upper('"+longdesc+"%') ");
					andCheck = 1;
				
			}

			type=type.toUpperCase();

if ( !(type == null || type.equals("")) )
			{
				if ( andCheck == 1 )
				{	
					sql.append(" and UPPER(a.DIAG_CLASS_TYPE) like upper('"+type+"%') ");
				}
				else
				{
			
					sql.append(" and UPPER (a.DIAG_CLASS_TYPE) like upper ('"+type+"%') ");
					andCheck = 1;
				}
			}
		/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
		/*Start*/	
		if(!(default_status==null || default_status.equals("")))
			{
			if ( default_status.equals("Y"))
		        {
				if ( andCheck == 0 )
					{
					sql = new StringBuffer();
					sql.append("and c.default_status='Y'");
					}
			else
					sql.append(" and c.default_status='Y'");
				}
		   if(default_status.equals("N"))
				{
				if( andCheck == 0 )
					{
					sql = new StringBuffer();
					sql.append(" and  c.default_status='N'");
					}
				else
				sql.append(" and c.default_status='N'");
				}
			if(default_status.equals("B"))
				{
				if( andCheck == 0 )
					{
					sql = new StringBuffer();
					sql.append(" and  c.default_status in ('Y','N')");
					}
				else
				sql.append(" and c.default_status in ('Y','N')");
				}
			}
		/*End*/	
		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 ){
				sql = new StringBuffer();
				sql.append("and a.eff_status='E'");
			}
			else
				sql.append(" and a.eff_status='E'");
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 ){
					sql = new StringBuffer();
					sql.append(" and  a.eff_status='D'");
			}
			else
				sql.append(" and a.eff_status='D'");
		}
	}
	//sql.append("and a.diag_class_code like'"+cd+"%'");
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else{
			sql.append(ord[i]);
			sql.append(",");
		}
		}
	}
	} //end of where clause IF
	else {
		sql = new StringBuffer();
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
	Connection conn =null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

try{
	conn=ConnectionManager.getConnection(request);
	StringBuffer strsql2= new StringBuffer();
	/*Default Column was added in the query by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
	strsql2.append("select distinct a.diag_class_code ,a.long_desc ,a.short_desc ,term_set_id,a.diag_class_type,b.description diag_class_type_desc ,c.default_status,a.eff_status  from mr_diag_class a ,mr_diag_class_type_lang_vw b,mr_diag_class_dtl c where a.diag_class_type=b.diag_class_type and a.DIAG_CLASS_CODE = c.DIAG_CLASS_CODE and b.language_id = '"+locale+"'");
	//strsql2.append("select a.diag_class_code ,a.long_desc ,a.short_desc ,a.diag_class_type,b.description diag_class_type_desc ,a.eff_status  from mr_diag_class a ,mr_diag_class_type_lang_vw b where a.diag_class_type=b.diag_class_type and b.language_id = '"+locale+"'");
	strsql2.append(sql.toString());
	stmt = conn.createStatement();
	rs = stmt.executeQuery(strsql2.toString());

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
		out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/DiagnosisClassificationResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/DiagnosisClassificationResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	</tr>
	
	</table>
	<br><br>
	</P>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td>
	<tr>
	<th nowrap rowspan='2' width="10%"><fmt:message key="eMR.DiagnosisClassification.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th rowspan='2' nowrap width="30%"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th rowspan='2' nowrap width="30%"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th rowspan='2' nowrap width="20%"><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></th>
	<th rowspan='2'width="25%" nowrap><fmt:message key="eMR.DiagnosisClassification.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
	<!--Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012-->
	<!--Start-->
	<th rowspan='2'width="25%" nowrap><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
	<!--End-->
	<th rowspan='2'width="25%" nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
<td>
<%
		}
 	/*if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }*/
	  String classValue="";
	  String term_set_id="";
//while ( rs.next() && i<=end )
//{
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;
	out.println("<tr><td  class='" + classValue + "'>");
	String diagCode = rs.getString("diag_class_code");
	String longDec = rs.getString("long_desc");
	String diagClassType = rs.getString("diag_class_type_desc");
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
	/*Start*/
	String default_status = rs.getString("default_status");
	/*End*/
	String effStat = rs.getString("eff_status");
	String shortDec=rs.getString("short_desc");
	term_set_id=rs.getString("term_set_id")==null?"":rs.getString("term_set_id");
	 if(term_set_id.equals(""))term_set_id="&nbsp;";

	//out.println("<a href='../../eMR/jsp/AddModifyDiagnosisClassification.jsp?mode=modify&long_desc="+longDec+"&short_desc="+shortDec+"&diag_class_type="+diagClassType+"&diag_class_code="+diagCode+"&target='f_query_add_mod' >");
	out.println("<a href='../../eMR/jsp/AddModifyDiagnosisClassification.jsp?mode=modify&diag_class_type="+diagClassType+"&diag_class_code="+diagCode+"&target='f_query_add_mod' >");

	out.println(diagCode+"</a></td><td  class='" + classValue + "'>");
	//out.println( rs.getString("long_desc") );
	request.setAttribute("longDec",longDec); %>
	<c:out value="${longDec}" escapeXml="true"/><%
	out.println("</td><td  class='" + classValue + "'>");
	//out.println( rs.getString("short_desc") );
	request.setAttribute("shortDec",shortDec); %>
	<c:out value="${shortDec}" escapeXml="true"/><%
	out.println("</td><td  class='" + classValue + "'>");
	out.println(term_set_id+"</td><td  class='" + classValue + "'>");
	//out.println(rs.getString("diag_class_type_desc") );
	out.println(diagClassType+"</td><td align='center'  class='" + classValue + "'>");
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
	/*Start*/
	if ( default_status.equals("Y") )
	out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
	out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td><td align='center'  class='" + classValue + "'>");
	/*End*/
	if ( effStat.equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;

	}//endwhile
%>

</td>
</tr>
</table>
<br><center>
</center>
</BODY>
</HTML>
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
	{%>
		<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
		</script>
	<%
	}

	if(rs!=null)
		rs.close();
	if(stmt!=null)
		stmt.close();

}
catch(Exception e){
		//out.println("Exception "+e.toString());
		e.printStackTrace();
}
finally{

	
			ConnectionManager.returnConnection(conn,request);
}
	
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

