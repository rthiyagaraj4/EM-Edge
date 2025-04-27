<!DOCTYPE html>

<%--
	FileName	: DiscretePanelAddtoPanelElement.jsp
	Version	    : 3	
	Created On	: 5-5-2005
	Created By	: Jupitora 
--%>

<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eAM/js/DiscretePanel.js'></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String mode="";
	String id="";
	String desc="";
	String mandatory="";
	String clearvalue="";
	String mand_status="";
	String disp_status="";
	String flag="";
	String deleteflag="";
	String del_dis="";
	String value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AddNewPanelElement.label","am_labels");
	String serailno="";
	request.setCharacterEncoding("UTF-8");
	serailno=(request.getParameter("srno")==null)?"":request.getParameter("srno");
	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	id=(request.getParameter("ID")==null)?"":request.getParameter("ID");
	desc=(request.getParameter("Desc")==null)?"":request.getParameter("Desc");
	mandatory=(request.getParameter("mandatory")==null)?"":request.getParameter("mandatory");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");
	deleteflag=(request.getParameter("deleteflag")==null)?"":request.getParameter("deleteflag");

	
	    if(deleteflag.equals("delete"))
		{
			del_dis="";
		}
		else
		{
			del_dis="disabled";
		}

		if(mandatory.equals("Y"))
		{
			mand_status = "checked";
		}
		else
		{
			if(flag.equals("frompanel"))
			mand_status = "";
		}

		if(flag.equals("frompanel"))
		{
			
			 disp_status ="disabled";
			 value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
			 title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ModifyExisitingPanelElement.label","am_labels");
			 
			 }
		else
		{
			value=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
			title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AddNewPanelElement.label","am_labels");
		}
		

%>
<form name='DiscrPanelAddElement_form' id='DiscrPanelAddElement_form'  >

<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'>

<tr><td class='CAGROUP 'align=center><b><font size='2' ><%=title%></b></td></tr> </table>

<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
<td  align='right' class='label'> <fmt:message key="eAM.DiscreteID.label" bundle="${am_labels}"/></td>
<td align='left'>&nbsp;&nbsp;<input type="text" name="panel_id" id="panel_id" size="10" maxlength="10" value="<%=id%>" <%=disp_status%> onBlur="if(this.value !='')getPanelId(panel_id)"><input type='button' name='id' id='id' value='?' <%=disp_status%> class='button' onClick='getPanelId(panel_id)' ></td>
	</tr>
	
<!-- <tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr> -->
	<tr>
	<td   align='right' class='label' > <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='desc' id='desc' value="<%=desc%>" readonly size="15" maxlength="20"  ></td>
	</tr>
<!-- 	
	<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr> -->
<tr >
	<td  align='right' class='label'> <fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td>
	<td  align='left'>&nbsp;<input type='checkbox'  name='mandatory' id='mandatory' <%=mand_status%> value="N" onClick='checkForMode(this)'></td>
	
</tr>


	<tr >
	<td>&nbsp;</td>
	<td >&nbsp;&nbsp;
	<input type='button' name='add' id='add' value='<%=value%>' class='button' onClick='addPanel() '>
	<input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick=' clearFields()' >
	<input type='button' name='del' id='del' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class='button' onClick=' deleteRecord()' <%=del_dis%>>
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

<%
/*if(mode.equals("insert")&& !flag.equals("frompanel"))
{
	associateDiagBean.clearAll();
}*/

%>

