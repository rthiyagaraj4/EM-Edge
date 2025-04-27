<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCA/js/PatHighRisk.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function showLongDesc(longdesc)
{
	
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	//var a = document.forms[0].LongDescription.value;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
	window.showModalDialog("../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc="+longdesc,"",features);
}
</script>
</HEAD>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<form name="form1" id="form1">
<%
String convals  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
Connection con = null;

try
{
	
	PreparedStatement stmt = null;
	ResultSet rs= null;
	String diag_code	= 	request.getParameter("diag_code");
	con  = ConnectionManager.getConnection(request);
	String query = "select a.DAG_DIAG_CODE, a.ASTK_DIAG_CODE, b.SHORT_DESC,b.LONG_DESC  from  mr_icd_code_dtl a, mr_icd_code b where a.ASTK_DIAG_CODE = b.DIAG_CODE and a.DAG_DIAG_CODE = ?  and b.DIAG_CODE_SCHEME = (select diag_code_scheme from mr_parameter)";

	stmt = con.prepareStatement(query);
	stmt.setString(1, diag_code);
	rs = stmt.executeQuery();
%>
	<table border='1' width='100%' cellspacing='0' cellpadding='3' align='center'>
	<td class='columnHeadercenter'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='columnHeadercenter' ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
	<td class='columnHeadercenter' >&nbsp;</td>
    <td class='columnHeadercenter'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<%	
	String classval ="";
	int i= 0;
	int flag = 0;
	while(rs.next())
	{
		flag = 1;
		String astk_diag_code = rs.getString("ASTK_DIAG_CODE");
		String short_desc = rs.getString("SHORT_DESC");
		String long_desc = rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC");
		String checked = "";
		if(i%2 == 0)
				classval = "QRYODD";
			else
				classval = "QRYEVEN";
		StringTokenizer str1 = new StringTokenizer(convals, "|");
		if(!convals.equals(""))
		{
			String code = "";
			while(str1.hasMoreTokens())
			{
				String splitvals = str1.nextToken();
				StringTokenizer str2 = new StringTokenizer(splitvals,"~");
				while(str2.hasMoreTokens())
				{
					code = str2.nextToken();
					if(code.equals(astk_diag_code))
						checked = "Checked";
				}
			}
		}%>	
		<tr>
			<td  class="<%=classval%>"><%= astk_diag_code%></td>
			<td  class="<%=classval%>"><%= short_desc%></td><td  class="<%=classval%>"><input class="button" type="button" value="!" name = "exclamation" onclick = "javascript:showLongDesc('<%=java.net.URLEncoder.encode(long_desc)%>')"></td>
			<td class="<%=classval%>"><input type="checkbox" id="<%=astk_diag_code+"~"+short_desc%> "  name="<%=astk_diag_code+"~"+short_desc%> " Onclick="Checkdiagcode(this)" <%=checked%> ><td>
		</tr>
		<%i++;
	}
	if(flag == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
		out.println("window.close();</script>");
	}
	out.println("</table>");
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
}
catch(Exception e)
{
	//out.println("Exception in AddDaggerCodeAddModify.jsp " + e.toString());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
<input type="hidden" name="convals" id="convals" value="<%=java.net.URLEncoder.encode((String)convals)%>"></input>
<input type="hidden" name="convals1" id="convals1" value="<%=java.net.URLEncoder.encode((String)convals)%>"></input>
</form>
</BODY>
</HTML>

