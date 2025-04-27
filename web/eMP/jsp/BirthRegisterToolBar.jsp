<!DOCTYPE html>
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

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<Script>
		function resetform() {
		   var register_button_yn = "";
		   var soundex = "";
		   var func_act = "";
		   if (parent.frames[1].document.forms[0].register_button_yn)
				register_button_yn = parent.frames[1].document.forms[0].register_button_yn.value;
		   if (parent.frames[1].document.forms[0].soundex_dflt)
		   {
				soundex = parent.frames[1].document.forms[0].soundex_dflt.value;
				if (soundex==null) soundex="";
			}
		   if (parent.frames[1].document.forms[0].func_act)
				func_act = parent.frames[1].document.forms[0].func_act.value;	

		   if (parent.frames[1].document.forms[0].soundex_dflt)
		   {
			   parent.frames[1].document.forms[0].reset();
			   parent.frames[1].document.forms[0].Mode.disabled = true;
			   parent.frames[1].document.forms[0].Patient_Id.focus();
		   }
		   else
				parent.frames[1].location.href = '../../eMP/jsp/ViewBirthRegisterCriteria.jsp?function_id='+parent.frames[1].document.forms[0].function_id.value;

			if (parent.frames[1].document.forms[0].apply_oth_name)											parent.frames[1].formatFlds(parent.frames[1].document.forms[0].apply_oth_name);

		   if (parent.frames[1].document.forms[0].newborn_suffix)
			   parent.frames[1].document.forms[0].newborn_suffix.disabled=true;
		   if (parent.frames[1].document.forms[0].soundex_dflt)
			   parent.frames[2].location.href = "../../eMP/jsp/SearchToolbar.jsp?register_button_yn="+register_button_yn+"&func_act="+func_act+"";
			else
				parent.frames[2].location.href = "../../eMP/jsp/ViewBirthSearchToolbar.jsp";

		   parent.frames[3].location.href = '../../eCommon/html/blank.html';
		   if (parent.frames[1].document.forms[0].Soundex)
		   {
			   parent.frames[1].document.forms[0].Soundex.value = soundex;
			   parent.frames[1].tab_click('search_tab');
			}
			if (parent.frames[1].document.forms[0].searchby)
			{
				var soundexval = "";
				if (parent.frames[1].document.forms[0].Soundex)
					soundexval = parent.frames[1].document.forms[0].Soundex.value
				if (parent.frames[1].document.forms[0].soundex_val)
					soundexval = parent.frames[1].document.forms[0].soundex_val.value
				
				if (soundexval=='')
				{
					parent.frames[1].document.forms[0].searchby.disabled=false;
					parent.frames[1].document.forms[0].searchby.value = "S";
				}
				else
				{
					parent.frames[1].document.forms[0].searchby.value = "";
					parent.frames[1].document.forms[0].searchby.disabled=true;
				}
			}
				
		}
	</Script>
</head>
<body class="COMMON_TOOLBAR" onKeyDown='lockKey()' leftmargin=0 topmargin=0>
	<table border=0 cellpadding=0 cellspacing=0 width="100%">
		<tr>
			<td class="COMMON_TOOLBAR" width="50%">
					<input type='button' onclick="resetform()" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class='BUTTON'></input>
					<input type='button' onclick="parent.close();" value='<fmt:message key="Common.menu.label" bundle="${common_labels}"/>' class='BUTTON'></input>
			</td>
			<td class="COMMON_TOOLBAR" align="right" width="50%">
			</td>
		</tr>
	</table>
</body>
</html>

