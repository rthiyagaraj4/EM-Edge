<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.ShiftForWorkplace.label" bundle="${rs_labels}"/> </title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/ShiftForWorkplace.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<iframe name='f_query_add_mod_hdr' id='f_query_add_mod_hdr' src='../../eRS/jsp/ShiftForWorkplaceAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize style='height:5vh;width:100vw'></iframe>
<iframe name= "f_query_add_mod_select" id="f_query_add_mod_select"  src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:47vh;width:100vw'></iframe>
<iframe name="f_query_add_mod_list" id="f_query_add_mod_list" src='../../eCommon/html/blank.html'frameborder=0 scrolling="auto" noresize style='height:48vh;width:100vw'></iframe>

</html>

