<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,java.text.*" %>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javaScript"></script>
<script src="../js/RSCommon.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var chkBothCriteria = false ;
var fromCalledPage = false ;
</script>
</head>
<body >

<form name="CriteriaForm" id="CriteriaForm"  >
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr width="100">
        <td>&nbsp;&nbsp;</td>
        <td colspan=2  class="label">Search By
        <input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick="storeVal(this)">Description
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this)">Code&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search Criteria
        <select name="search_criteria" id="search_criteria">
        <option value="S">Starts With
        <option value="E">Ends With
        <option value="C">Contains
        </select>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label" colspan=2  >Search Text
        <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
        <td align="right"><input type="button" align="left" name="Search" id="Search" value="Search" onClick="RSvaltext(search_text); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value="Reset" onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<BR>
<BR>
<input type='hidden' name='title' id='title' value='<%=request.getParameter( "title" )%>'>
</form>
</body>
<script>
    initializeText();
</script>
</html>

