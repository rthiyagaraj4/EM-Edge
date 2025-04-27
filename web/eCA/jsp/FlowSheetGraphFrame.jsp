<!DOCTYPE html>
<%@page import="java.sql.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<title>Graph</title>
<script src='../../eCA/js/FlowSheet.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<FRAMESET id='frmset' ROWS="*,*,*,*" framespacing=0 frameborder=1 onLoad="splitArray();"> 
	<FRAME SRC="../../eCommon/html/blank.html" NAME="chart_frame0" scrolling=auto>
	<FRAME SRC="../../eCommon/html/blank.html" NAME="chart_frame1" scrolling=auto>
	<FRAME SRC="../../eCommon/html/blank.html" NAME="chart_frame2" scrolling=auto>
	<FRAME SRC="../../eCommon/html/blank.html" NAME="dummy_frame" scrolling=no>
</FRAMESET>
</HTML>


