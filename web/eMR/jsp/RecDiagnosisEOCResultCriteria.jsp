<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%@ include file="RecDiagnosisGetValidation.jsp"%>
<html>
 <head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>

<script src='../js/RecDiagnosisEOC.js' language='javascript'></script>

<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	Connection con      = null;
	Statement stmt		= null;
	ResultSet rset		= null;
	String term_set_id = "";
	String queryStr	="";

	try{
		con = ConnectionManager.getConnection(request);
		
		term_set_id = checkForNull(request.getParameter("term_set_id"));
		queryStr = request.getQueryString();
		
%>
	<body onKeyDown='lockKey()'>
		<form name='EOCCriteriaform' id='EOCCriteriaform' >
		<br>	
		<table border=0 align='center' cellspacing=0 cellpadding=0 width='100%'>
		<th colspan='10' align='left' style='COLOR: black;BACKGROUND-COLOR: #ffc5b5;'><font='verdana' size='2' align='top'><fmt:message key="eMR.ExistingEpisodeofCare.label" bundle="${mr_labels}"/></font></th></th>
			<tr>
			<td class='label' align='right' width='15%'><fmt:message key="eMR.DiagnosisSet.label" bundle="${mr_labels}"/>&nbsp;</td>
			<td>
			<select name="code_set" id="code_set" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
				stmt = con.createStatement();
				rset = stmt.executeQuery("select term_set_id,priority_appl_yn||'='||nature_appl_yn||'='||severity_appl_yn||'='||onset_type_appl_yn||'='||factors_appl_yn||'='||notification_appl_yn term_set_id1,term_set_desc from mr_term_set where Eff_status='E' and diag_spec_yn='Y' order by term_set_desc");
				while(rset.next())
				{
					String desc = rset.getString("term_set_desc");
					String code = rset.getString("term_set_id");
					
					String code1 = rset.getString("term_set_id1");
					String sel = "";
						
					if(term_set_id.equals(code))
					{
						out.print("<option value='"+code+"' id='"+code1+"' selected >"+desc+"</option>");
					}
					else
					{
						out.print("<option value='"+code+"'"+sel+" id='"+code1+"'>"+desc+"</option>");
					}
				}
				if(rset	!= null)   rset.close();
				if(stmt  != null)   stmt.close();		
			%>
			</select><!-- <img align='center' src='../../eCommon/images/mandatory.gif'> -->
		</td>
		
		<td class='label' align='left' ><fmt:message key="eMR.OnsetDateFrom.label" bundle="${mr_labels}"/>&nbsp;<input type='textbox' name='onsetdate_from' id='onsetdate_from' value='' size='8' id='date1'>&nbsp;<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date1')"></input>
		</td>
		
		<td class='label' align='left' >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='textbox' name='onsetdate_to' id='onsetdate_to' value='' size='8' id='date2'>&nbsp;<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date2')"></input>
		</td>
		
		<td class='button'><input type='button' class='button' name='reset' id='reset' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>'  Onclick='EOCReset()'></input></td>
		<td class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' Onclick='Showresulttab(this)'></input></td>

	</table>

<input type='hidden' name='Qrystr' id='Qrystr' value='<%=queryStr%>' ></input>
</form>
<%
}
catch(Exception ex)
{
		//out.println("Exception at try block "+ex.toString());
		ex.printStackTrace();
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>
	</body>
</html>

