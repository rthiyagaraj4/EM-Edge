<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script language='javascript' src='../../eMP/js/PatientSeriesGroupForUser.js'></Script> 
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='query_criteria' id='query_criteria' 	src='../../eMP/jsp/PatientSeriesGroupForUserCriteria.jsp' frameborder=0 scrolling='no' noresize  style='height:18vh;width:99vw'></iframe>
<iframe name='result_frame' id='result_frame'		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize   style='height:75vh;width:99vw'></iframe>
</html>



