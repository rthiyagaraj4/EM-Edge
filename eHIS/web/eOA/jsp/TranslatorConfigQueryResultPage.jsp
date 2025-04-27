<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >
<%
	request.setCharacterEncoding("UTF-8");
	String facilityid=(String)session.getValue("facility_id");
	String whereClause = request.getParameter("whereclause");	
	String locale=(String)session.getAttribute("LOCALE");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if ( (whereClause == null || whereClause.equals("")) )
	{	
		String language_id = request.getParameter("language_id");
		String language_desc = request.getParameter("language_desc");
		String from_date = request.getParameter("eff_date_from");
		String to_date = request.getParameter("eff_date_to");	
		String enabled = request.getParameter("eff_status");
		int andCheck = 0;
		
		if ( !(language_id == null || language_id.equals("")) )
		{			
			 sbQuery.append(" and upper(language_id) like upper('"+language_id+"%')");			
		}
		if ( !(language_desc == null || language_desc.equals("")) )
		{			
			 sbQuery.append(" and upper(b.long_name) like upper('"+language_desc+"%')");			
		}

		if(!(from_date == null || from_date.equals("")) &&  !(to_date == null || to_date.equals("")))		
		{					
				sbQuery.append(" and (eff_date_from between to_date('"+from_date+"','dd/mm/yyyy') and to_date('"+to_date+"','dd/mm/yyyy') and eff_date_to between to_date('"+from_date+"','dd/mm/yyyy') and to_date('"+to_date+"','dd/mm/yyyy'))" );				
		}
		else if ( !(from_date == null || from_date.equals("")) )
		{		
				sbQuery.append(" and eff_date_from >= to_date('"+from_date+"' ,'dd/mm/yyyy') ");		
			
		}
		else if ( !(to_date == null || to_date.equals("")) )
		{
			
				sbQuery.append(" and eff_date_to <= to_date('"+to_date+"' ,'dd/mm/yyyy') ");			
		}
		
		if ( !(enabled == null || enabled.equals("")) )
		{
			 if( enabled.equals("E") )
			 {			
				sbQuery.append(" and eff_status='E'");						 
			 }
			 if ( enabled.equals("D") )
			 {			
				sbQuery.append(" and  eff_status='D'");				
			 }	     
		}
		
		String ord[] = request.getParameterValues("orderbycolumns");


		if ( !(ord == null || ord .equals("")) )
		{
			sbQuery.append(" order by ");		
			for ( int i=0;i < ord.length;i++ )
			{
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);					
				}
				else{
					sbQuery.append(ord[i]+",");						
				}
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

Connection conn = null;
conn = ConnectionManager.getConnection(request);
Statement stmt = null;
int maxRecord = 0;
ResultSet rs = null;
try{

stmt = conn.createStatement();

String sql="select facility_id, language_id,mp_get_desc.mp_language(a.language_id,'"+localeName+"', 1) language_desc,srl_no, to_char(eff_date_from, 'dd/mm/yyyy') eff_date_from1, to_char(eff_date_to, 'dd/mm/yyyy') eff_date_to1, no_of_translator, multiply_factor, a.eff_status from oa_translator_configuration a,mp_language b where facility_id='"+facilityid+"' and a.LANGUAGE_ID =b.LANG_ID "+sbQuery.toString();

rs = stmt.executeQuery(sql);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

	while ( i<=end && rs.next() )
{
		if(maxRecord==0)
	{
%>
<P>
<table align='right'>
<tr >
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eOA/jsp/TranslatorConfigQueryResultPage.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/TranslatorConfigQueryResultPage.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
<br></br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.Language.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Language.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eOA.NoofTranslators.label" bundle="${oa_labels}"/></th>
<th><fmt:message key="eOA.NoofPatperTranslator.label" bundle="${oa_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<% }
String classValue = "" ;

	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'align='center'>");	
	String facility_id = rs.getString("facility_id");
	String language_id = rs.getString("language_id");
	String language_desc_temp = 	rs.getString("language_desc");
	String srl_no = rs.getString("srl_no");
    String eff_date_from = rs.getString("eff_date_from1"); 
    String eff_date_to = rs.getString("eff_date_to1"); 
    String no_of_translator = rs.getString("no_of_translator"); 
    String multiply_factor = rs.getString("multiply_factor"); 
    String eff_status = rs.getString("eff_status"); 
	out.println("<a href='../../eOA/jsp/TranslatorConfig.jsp?language_id="+ language_id +"&srl_no="+srl_no+"' target='f_query_add_mod' >");
    out.println(language_id+"</a></td><td class='" + classValue + "' align='center'>");
	out.println(language_desc_temp);	
	out.println("</td><td class='" + classValue + "' align='center'>");
	out.println(eff_date_from);	
	out.println("</td><td class='" + classValue + "' align='center'>");
	out.println(eff_date_to);
	out.println("</td><td class='" + classValue + "' align='center'>");
	out.println(no_of_translator);
	out.println("</td><td class='" + classValue + "' align='center'>");
	out.println(multiply_factor);
	out.println("</td><td class='" + classValue + "' align='center'>");
	if (eff_status.equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
	}//end of while 
		sbQuery.setLength(0);

if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
		if (rs != null)   rs.close();
	     if (stmt != null) stmt.close();

}	catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}

	finally {
		 
	   ConnectionManager.returnConnection(conn,request);
	}

%>
</td></tr>
</table>
</BODY>
</HTML>

