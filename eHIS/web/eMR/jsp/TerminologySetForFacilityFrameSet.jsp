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
<script src='../../eCommon/js/common.js' language='javascript'></script>		
<script language="JavaScript" src="../../eMR/js/TerminologySetForFacility.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<iframe name='f_query_header' id='f_query_header' 	src='../../eMR/jsp/TerminologySetForFacilityHeader.jsp' frameborder=0 noresize style='height:30%;width:100vw'></iframe>
	 
 <iframe name='Dummy' id='Dummy' src='../../eMR/jsp/TerminologySetForFacilityDynamicValues.jsp' frameborder=0 scrolling='no' noresize style='height:70%;width:100vw'></iframe>
 <iframe name='f_query_detail' id='f_query_detail' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>


</head>
</html>

