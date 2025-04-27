<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<!--the page itself refreshes every 30 minutes-->
<META HTTP-EQUIV="REFRESH" content="1800; URL='InstantMessengerChatTreeRefresh.jsp'">
<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
<script src='../../eCA/js/InstantMessengerChat.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="timer()">
</body>
</html>

