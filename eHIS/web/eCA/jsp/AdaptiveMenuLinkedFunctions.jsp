<!DOCTYPE html>

<%--
	FileName	: AdaptiveMenuLinkedFunctionsOrder.jsp
	Version	    : 1.0	
	Created On	: 29-06-2009
	Created By	: Arvind Singh Pal
	Purpose     : for CRF-0544-IP

	--%>


<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="adaptivemenuBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/AdaptiveMenu.js'></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String mode="";
	String id="";
	String desc="";
	//String mandatory="";
	String clearvalue="";
//	String mand_status="";
	String disp_status="";
	String flag="";
	String value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LinkNewFunc.label","ca_labels");
	String serailno="";
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	serailno=(request.getParameter("srno")==null)?"":request.getParameter("srno");
	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	id=(request.getParameter("ID")==null)?"":request.getParameter("ID");
	desc=(request.getParameter("Desc")==null)?"":request.getParameter("Desc");
	//mandatory=(request.getParameter("mandatory")==null)?"":request.getParameter("mandatory");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");

		
		if(flag.equals("frompanel"))
		{			
			 disp_status ="disabled";
			 value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
			 title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ModifyLinkedFunc.label","ca_labels");
			 
			 }
		else
		{			
			value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LinkNewFunc.label","ca_labels");
		}
		

%>
<form name='linkFunction_form' id='linkFunction_form'  >

<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'>

<tr><td class='CAGROUP 'align=center><b><font size='2' ><%=title%></b></td></tr> </table>

<table border='0' cellpadding='0' cellspacing='2' width='99%' align='center'>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>


<td  align='left' class='label'> <fmt:message key="eCA.FunctionRef.label" bundle="${ca_labels}"/></td>
<td align='left'>&nbsp;&nbsp;<input type="text" name="panel_id" id="panel_id"  value="<%=id%>" <%=disp_status%> onBlur="getLinkedFunction1(this)" ><input type='button' name='id' id='id' value='?' <%=disp_status%> class='button' onClick='getLinkedFunction(panel_id)' ><img src="../../eCommon/images/mandatory.gif" ></td>

	</tr>

	<tr>
	<td   align='left' class='label' > <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='desc' id='desc' value="<%=desc%>" readonly size="20" maxlength="20"  ></td>
	</tr>

	<tr><td></td></tr>
	<tr></tr>
	<tr >
	<td>&nbsp;</td>
	<td >&nbsp;&nbsp;
	<input type='button' name='add' id='add' value='<%=value%>' class='button' onClick='addPanel() '>
	<input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick=' clearFields()' >	
	<br>
	<br>
	<br>
	<br>
	<br>
	
	</td>
	</tr>
		

<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>

</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>' >
<input type='hidden' name='code' id='code' value='frompanel' >
<input type='hidden' name='disp_flag' id='disp_flag' value='<%=flag%>' >
<input type='hidden' name='clearvalue' id='clearvalue' value='<%=clearvalue%>' >
<input type='hidden' name='delval' id='delval' value='<%=serailno%>' >


</form>
</body>
</html>


