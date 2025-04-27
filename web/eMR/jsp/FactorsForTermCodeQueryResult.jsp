<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Created By		:	Vinay
*	Created On		:	11 Feb 05
-->
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));
%>

<head>
<head>
</style>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<script language="JavaScript" src="../js/AssessmentCriteriaScore.js"></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
//String  req_start= "";
//String req_end = "";
String term_set = request.getParameter("term_set")==null?"":request.getParameter("term_set");
String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
String term_code_desc = request.getParameter("term_code_desc")==null?"":request.getParameter("term_code_desc");
String factor_code = request.getParameter("factor_code")==null?"":request.getParameter("factor_code");
String factor_desc = request.getParameter("factor_desc")==null?"":request.getParameter("factor_desc");
term_set = term_set.toUpperCase();
term_code = term_code.toUpperCase();
term_code_desc = term_code_desc.toUpperCase();
factor_code = factor_code.toUpperCase();
factor_desc = factor_desc.toUpperCase();
String whereClause = "and b.term_set_id like '"+term_set+"%'and b.term_code like '"+term_code+"%' and upper(b.short_desc) like '"+term_code_desc+"%' and upper(c.factor_code) like '"+factor_code+"%' and upper(c.short_desc) like '"+factor_desc+"%' ";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
try
{
	con = ConnectionManager.getConnection(request);
	from = request.getParameter("from") ;
	to = request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 20 ; }   else {  end = Integer.parseInt( to ) ; }
	//req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
	//req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
	/*stmt = con.createStatement();
	String sql_cnt = "select count(*) from  mr_factor_for_term_code a,mr_term_code b,mr_factor c where c.factor_code = a.factor_code "+whereClause+" and b.term_set_id = a.term_set_id and b.term_code = a.term_code ";
	rs = stmt.executeQuery(sql_cnt);
	if(rs!=null)
	{
		if(rs.next())
		{
			maxRecord = rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}*/
%>
<script>
function submitPrevNext(from, to,term_set,term_code,term_code_desc,factor_code,factor_desc)
{
	parent.fram_fac_termcode_hdr.location.href="../../eMR/jsp/FactorsForTermCodeQueryResult.jsp?from="+from+"&to="+to+"&term_set="+term_set+"&term_code="+term_code+"&term_code_desc="+term_code_desc+"&factor_code="+factor_code+"&factor_desc="+factor_desc;
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'> 
<form METHOD=POST target='' ACTION="../../eMR/jsp/FactorsForTermCodeQueryResult.jsp" name='factor_resullt_page' id='factor_resullt_page'>

<%

	String sql = "select b.term_set_id term_set_id,b.term_code term_code,b.short_desc  term_code_desc,c.factor_code factor_code,c.short_desc factor_desc from  mr_factor_for_term_code a,mr_term_code b,mr_factor_lang_vw c where c.factor_code = a.factor_code and b.term_set_id = a.term_set_id and b.term_code = a.term_code "+whereClause+" and c.language_id='"+locale+"'  order by factor_desc ";
	
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);

	int i = 1;
	
	if (start!=1 )
	{
			for( int n=1; n<start; i++,n++ )
			{
				rs.next() ;
			}
	}

	while(i<=end && rs.next())
		{
			if (maxRecord==0)
				{
				
%>
				<table align='right' >
				<tr>
				<%
					if ( !(start <= 1))
					{
					%>
					<td align ='right' id='prev'  ><A href='javascript:submitPrevNext("<%=(start-20)%>","<%=(end-20)%>","<%=term_set%>","<%=term_code%>","<%=term_code_desc%>","<%=factor_code%>","<%=factor_desc%>")'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")%>
					</a></td>
					<%}%>
					<td align ='right' id='next' style='visibility:hidden' ><A href='javascript:submitPrevNext("<%=(start+20)%>","<%=(end+20)%>","<%=term_set%>","<%=term_code%>","<%=term_code_desc%>","<%=factor_code%>","<%=factor_desc%>")'><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")%></a>
					</td>

				</tr>
				</table>
				<br><br>
				<TABLE border="1" cellpadding="0" cellspacing="0" width="100%" align='right'>
							<TR>
								<TH><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></TH>
								<TH><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></TH>
								<TH><fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/></TH>
								<TH><fmt:message key="eMR.FactorCode.label" bundle="${mr_labels}"/></TH>
								<TH><fmt:message key="eMR.FactorDescription.label" bundle="${mr_labels}"/></TH>
							</TR>
		
	<%
				}	
	
				String className = "";
				String  term_code_desc_val = "";
				String  factor_desc_val = "";
	
		//while(rs.next() && i<=end )
		//{
				if ( i % 2 == 0 )
					className = "QRYEVEN" ;
				else
					className = "QRYODD" ;
				term_code_desc_val = rs.getString("term_code_desc")==null?"":rs.getString("term_code_desc");
				factor_desc_val = rs.getString("factor_desc")==null?"":rs.getString("factor_desc");
				out.println("<tr >");
				out.println("<td class='"+className+"'>"+rs.getString("term_set_id")+"</td>");
				out.println("<td class='"+className+"'>"+rs.getString("term_code")+"</td>");
				out.println("<td class='"+className+"'>"+term_code_desc_val+"</td>");
				out.println("<td class='"+className+"'>"+rs.getString("factor_code")+"</td>");
				out.println("<td nowrap class='"+className+"'>"+factor_desc_val+"</td>");
				out.println("</tr>");
				i++;
				maxRecord++;
		}
	%>
</TABLE>
<input type=hidden name="from" id="from" value="<%=start%>">
<input type=hidden name="to" id="to" value="<%=end%>">
<input type=hidden name="start" id="start" value="<%=start%>">
<input type=hidden name="end" id="end" value="<%=end%>">
</form>
<%

		if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
				if ( maxRecord < 20 || (!rs.next()) )
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%
				}
}
catch (Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>
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

