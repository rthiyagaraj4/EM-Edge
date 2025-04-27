<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<style>
        body, html {
            margin: 0;
            padding: 0;
            overflow: hidden; /* Prevent main scrolling */
            height: 100%;
        }
</style>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>


<script language="JavaScript" src="../../eMR/js/TerminologySetforSpecialty.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<iframe name='f_query_header' id='f_query_header' 	src='../../eMR/jsp/TerminologySetForSpecialtyHeader.jsp' frameborder=0 noresize style='height:15%;width:100vw'></iframe>
<iframe name='Dummy' id='Dummy' src='../../eMR/jsp/TerminologySetForSpecialtyDynamicValues.jsp' frameborder=0 scrolling='no' noresize style='height:85%;width:100vw'></iframe>
<iframe name='f_query_detail' id='f_query_detail' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>


</head>
</html>

