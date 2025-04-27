<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@ page import = "eXH.XHUtil" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<HTML>
<HEAD>

<TITLE>Invoke External Application</TITLE>

<SCRIPT TYPE="text/javascript" SRC="../../eXH/js/ExternalApplication.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style type="text/css">
#mydiv {
    position:fixed;
    top: 40%;
    left: 50%;
    margin-top: -3em; /*set to a negative number 1/2 of your height*/
    margin-left: -9em; /*set to a negative number 1/2 of your width*/
}
</style>
<BODY onLoad="invokeExternalApp('${param.exePath}', '${param.exeParams}')">
<FORM ID="invokeExternalApp" name="invokeExternalApp" id="invokeExternalApp" METHOD="post">
<c:set var="reqParams" value="<%= XHUtil.getRequestParams(request) %>" />

</FORM>
</BODY>
</HTML>

