<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eRS.SkillForPosition.label" bundle="${rs_labels}"/></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/SkillForPosition.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<iframe name='f_query_add_mod_hdr' id='f_query_add_mod_hdr' src='../../eRS/jsp/SkillForPositionAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize style='height:5vh;width:100vw'></iframe>
<iframe name= "f_query_add_mod_select" id="f_query_add_mod_select" src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:29vh;width:100vw'></iframe>
<iframe name="f_query_add_mod_listhdr" id="f_query_add_mod_listhdr" src='../../eCommon/html/blank.html'frameborder=0 scrolling="auto" noresize style='height:6vh;width:100vw'></iframe>
<iframe name="f_query_add_mod_list" id="f_query_add_mod_list" src='../../eCommon/html/blank.html'frameborder=0 scrolling="auto" noresize style='height:60vh;width:100vw'></iframe>

</html>

