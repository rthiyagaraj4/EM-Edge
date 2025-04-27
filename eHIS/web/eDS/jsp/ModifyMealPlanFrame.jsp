<!DOCTYPE html>
<%@  page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%-- 
<FRAMESET ROWS="50%,50%">
		<FRAME name='ModifyMealPlanCud' SRC="../../eDS/jsp/ModifyMealPlanCud.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize>
	<FRAMESET COLS="50%,50%">
		<FRAME name='ModifyMealPlanItem' SRC="../../eDS/jsp/ModifyMealPlanItem.jsp" frameborder=0 scrolling='no' noresize>
		<FRAME name='ModifyMealPlanSearch' SRC="../../eDS/jsp/ModifyMealPlanSearch.jsp" frameborder=0 scrolling='no' noresize>
	</FRAMESET>
		<FRAME SRC="../../eCommon/html/blank.html"	  NAME="validation_frame" frameborder=0 noresize scrolling='no'>
	</FRAMESET>
 --%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meal Plan</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            overflow: hidden;
        }
        .container {
            display: flex;
            flex-direction: column;
            height: 100%;
        }
        .row {
            flex: 1;
            display: flex;
        }
        .row > iframe {
            flex: 1;
            border: none;
        }
        .half {
            width: 50%;
        }
        .quarter {
            width: 25%;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row" style="height: 50%;">
            <iframe name="ModifyMealPlanCud" src="../../eDS/jsp/ModifyMealPlanCud.jsp?<%=request.getQueryString()%>" scrolling="no"></iframe>
        </div>
        <div class="row" style="height: 50%;">
            <iframe name="ModifyMealPlanItem" src="../../eDS/jsp/ModifyMealPlanItem.jsp" scrolling="no" class="half"></iframe>
            <iframe name="ModifyMealPlanSearch" src="../../eDS/jsp/ModifyMealPlanSearch.jsp" scrolling="no" class="half"></iframe>
        </div>
    </div>
    <iframe src="../../eCommon/html/blank.html" name="validation_frame" style="display:none;"></iframe>
</body>
</html>
 