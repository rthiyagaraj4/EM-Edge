<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
//	String sql ;									// will be deleted once code walkthrough is done

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
//		sql = "";
		String shortname=request.getParameter("short_desc");
		String language_id = request.getParameter("language_id");
		language_id = language_id.toUpperCase();
		String longname = request.getParameter("long_desc");
		if (longname==null) longname="";
		longname = longname.toUpperCase();

		String enabled = request.getParameter("nature");

		int andCheck = 0;

		if ( !(language_id == null || language_id.equals("")) )
		{
			andCheck=1;
			sbQuery.append("  a.LANG_ID like '");
			sbQuery.append(language_id);
			sbQuery.append("%'");
//			sql = "  a.LANGUAGE_ID like '"+language_id+"%'";
		}
		if ( !(longname == null || longname.equals("")) )
		{
			if(andCheck==1){
				sbQuery.append(" and ");
//				sql = sql+ " and ";			
			}
			sbQuery.append("upper(a.long_name) like  '");
			sbQuery.append(longname);
			sbQuery.append("%'" );
//			sql = sql + "upper(a.long_name) like  '"+longname+"%'" ;
			andCheck=1;
		}
		if ( !(shortname == null || shortname.equals("")) )
		{
			if(andCheck==1){
				sbQuery.append(" and ");
//				sql = sql+ " and ";			
			}
			sbQuery.append("upper(a.short_name) like  upper('");
			sbQuery.append(shortname);
			sbQuery.append("%')" );
//			sql = sql + "upper(a.long_name) like  '"+longname+"%'" ;
			andCheck=1;
		}
		
		if ( !(enabled == null || enabled.equals("")) )
		{
			
		   if ( enabled.equals("E"))
		   {
				if(andCheck==1){
					sbQuery.append(" and ");
//					sql = sql+ " and ";
				}
				sbQuery.append(" a.eff_status='E'");
//				sql = sql + " a.eff_status='E'";
				andCheck=1;
		   }
		   if ( enabled.equals("D") )
			{
				if(andCheck==1)	{
					sbQuery.append(" and ");
//					sql = sql+ " and ";
				}
				sbQuery.append(" a.eff_status='D'");
//				sql = sql + " a.eff_status='D'";
				andCheck=1;
			}
		}

		if(andCheck==1)
		{
			sbQuery.insert(0," where ");
//			sql = " where   " + sql;
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
ResultSet rs=null;
//int maxRecord = 0;
String dflt_lang_appl_yn = "N";
//String dflt_lang_desc = "";//checkstyle changes - 35886
try{
	conn = ConnectionManager.getConnection(request);

		/*pstmt = conn.prepareStatement("select count(*) as total from mp_language a    "+sbQuery.toString());
		//out.println("select count(*) as total from mp_language a    "+sql);
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

		pstmt = conn.prepareStatement("SELECT a.lang_id language_id, a.long_name, a.short_name,a.dflt_lang_online_report dflt_lang_online_report, a.eff_status,nvl((SELECT 'Y' FROM sm_site_param a, sm_function_control b WHERE a.customer_id = b.site_id AND module_id = 'MP' AND functionality_id = 'DFLT_PAT_LANG'),'N')dflt_lang_appl_yn, (select short_name from sm_language where language_id = a.dflt_lang_online_report) dflt_lang_desc FROM mp_language a "+sbQuery.toString());
		
		rs = pstmt.executeQuery();

%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  	  String classValue = "" ;
		  int cnt=0;

while (i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/LanguageQueryResults.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/LanguageQueryResults.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>
<%
		 dflt_lang_appl_yn = rs.getString("dflt_lang_appl_yn")==null?"N":rs.getString("dflt_lang_appl_yn");%>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
         <th><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<%if(dflt_lang_appl_yn.equals("Y")){%>
		<th><fmt:message key="eMP.Dfltlangforonlinereport.label" bundle="${mp_labels}"/></th>
		<%}%>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr><td align='left' class='" + classValue + "'>");
	String language_id = rs.getString("language_id");
	// if ( rs.getString("eff_status").equals("E") )
	out.println("<a href='../../eMP/jsp/LanguageModify.jsp?language_id="+ language_id + "&dflt_lang_appl_yn="+dflt_lang_appl_yn+" ' target='f_query_add_mod'>");
	out.println(language_id+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_name") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_name") );
	out.println("</td><td class='" + classValue + "' align='center'>");
	if(dflt_lang_appl_yn.equals("Y")){
		out.println(rs.getString("dflt_lang_desc")==null?"&nbsp;":rs.getString("dflt_lang_desc") );
	out.println("</td><td class='" + classValue + "' align='center'>");
	}

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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



	<%}%>

</td></tr>
</table>
<br><center>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace();
}
finally{
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

