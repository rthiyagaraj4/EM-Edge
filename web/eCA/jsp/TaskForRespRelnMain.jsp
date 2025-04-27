<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<TITLE> <fmt:message key="eCA.TaskforRespMainFrame.label" bundle="${ca_labels}"/>  </TITLE>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
	<iframe SRC="../../eCA/jsp/TaskForRespRelnHdr.jsp" name="frameTaskForRespRelnHdr" id="frameTaskForRespRelnHdr" scrolling='no' noresize  style='height:8vh;width:98vw; border:0px;'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" name="frameTaskForRespRelnDtl" id="frameTaskForRespRelnDtl"  scrolling='no' noresize  style='height:15vh;width:98vw; border:0px;'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" name="frameTaskForRespRelnResult" id="frameTaskForRespRelnResult"  scrolling='no' noresize  style='height:71vh;width:98vw; border:0px;'></iframe>
</HTML>

