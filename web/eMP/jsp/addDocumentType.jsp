<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");%>
<html>

<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eMP/js/DocumentType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- Added by Sangeetha on 24/apr/17 for KDAH-CRF-0347 -->
<!-- Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 -->
<script>
function setValue()
{
	if ( document_type_form.addr_id.checked == true)
	{
	  document_type_form.supp_doc_type.value="A";
	}
	  
	if ( document_type_form.iden_id.checked == true)
	{
	  document_type_form.supp_doc_type.value="I";
	}
 
}
</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('doc_type')" >
<%
//Added by Sangeetha on  19/apr/17 for KDAH-CRF-0347
Connection conn = null;
try{
	conn = ConnectionManager.getConnection(request);
	Boolean isSuppDocFieldAvail	= eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","GENERATE_FORM_60"); 
%>
<form name="document_type_form" id="document_type_form" action="../../servlet/eMP.DocumentTypeServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
  <table border="0" cellpadding="3" cellspacing="0" width="75%" align='center'>

  <tr>
  	<td width='40%'>&nbsp;</td>
  	<td width='60%' colspan='2'>&nbsp;</td>
  </tr>

    <tr>
      <td width="40%" class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="doc_type" id="doc_type" size="2" maxlength="2" onBlur="ChangeUpperCase(this);" onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img>
      </td>
    </tr>
    <tr>
      <td width="40%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>
   <tr>
      <td width="40%" class="label" nowrap ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)' ><img src='../images/mandatory.gif'></img></td>
    </tr>

    <!--tr>
      <td width="40%" class="label">Effective From</td>
      <td width="13%" >&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_from1" id="eff_date_from1" size="10"   maxlength="10"><!--/td-->
      <!--td width="47%" class="label">&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;--><input type="hidden" name="eff_date_to1" id="eff_date_to1" size="10"  maxlength="10"><!--/td-->
    <!--/tr-->

	  <!--tr>
	  	<td width='40%'>&nbsp;</td>
	  	<td width='60%' colspan='2'>&nbsp;</td>
	  </tr-->
	
	<!-- START Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347-->
	<% if(isSuppDocFieldAvail){ %>
	<tr>
		<td width="40%" class="label"><fmt:message key="eMP.SuppDocType.label" bundle="${mp_labels}"/></td>
		<td width="60%" colspan="2" class='fields'>
		<fmt:message key="eMP.AddrProof.label" bundle="${mp_labels}"/>
		<input type='checkbox' name='supp_doc_type_add' id='supp_doc_type_add' id='addr_id' value = 'Y' > &nbsp&nbsp&nbsp
		
		<fmt:message key="eMP.IDProof.label" bundle="${mp_labels}"/>
		<input type='checkbox' name='supp_doc_type_iden' id='supp_doc_type_iden' id='iden_id' value = 'Y' >
		</td>
	</tr>

	<tr>
      <td width="40%" class="label"><fmt:message key="eMP.SuppDocDesc.label" bundle="${mp_labels}"/></td>
      <td width="60%" colspan="2" class='fields'><TextArea name="supp_doc_desc" rows="2" cols="45" onKeyPress='checkMaxLimit(this,60);' onblur='callCheckMaxLen(this,60)'></TextArea><img src='../images/mandatory.gif'></img></td>
    </tr>
	<!-- END Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347-->
	<% } %>
	<tr>
		<td width="40%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    	<td width="60%" colspan="2" class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td>
    </tr>


	  <tr>
	  	<td width='40%'>&nbsp;</td>
	  	<td width='60%' colspan='2'>&nbsp;</td>
	  </tr>

  </table>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from">
<input type="hidden" name="eff_date_to" id="eff_date_to">
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='isdocTypeSelected' id='isdocTypeSelected' value=''>
<!-- Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 -->
<input type='hidden' name='isSuppDocFieldAvail' id='isSuppDocFieldAvail' value="<%=isSuppDocFieldAvail%>"> 
</form>
<%
}catch(Exception e) { 
	out.println(e.toString());
	e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

