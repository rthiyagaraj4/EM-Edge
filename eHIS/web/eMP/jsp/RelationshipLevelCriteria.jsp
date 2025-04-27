<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String linked_style="visibility:hidden";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eMP/js/RelationshipLevel.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body  onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name='reln_crtra_form' id='reln_crtra_form' method='post' target='messageFrame'>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr>
				<td colspan='4' width='100%' class='label'>&nbsp;</td>
			</tr>
        	<tr>                 
				  <td class="label" width="25%" ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
                  <td class='fields' width="25%" ><INPUT TYPE="text" name="relationship_desc" id="relationship_desc" value="" onblur='onblurgetRelation(relationship_code,relationship_desc);'><input type='button' name='relationship_btn' id='relationship_btn' value='?' class='button' onClick='getRelation(relationship_code,relationship_desc);'><img align='center' src='../../eCommon/images/mandatory.gif'></img>
				  <input type='hidden' name='relationship_code' id='relationship_code' value=''>
				  </td>	
				  <td class='label' id='relnlabel'>&nbsp;</td>
				  <td class='fields' id='relntext'>&nbsp;</td>				 			  	
		    </tr>
			<tr>
				<td colspan='4' width='100%' class='label'>&nbsp;</td>
			</tr>
</table>
</form>
</body>
</html>

