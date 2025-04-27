<!DOCTYPE html>
<HTML>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body, html {
            margin: 0;
            height: 100%;
            display: flex;
            flex-direction: column;
        }

        .row {
            flex-shrink: 0;
        }

        .row-24 {
            height: 24%;
        }

        .row-5 {
            height: 7%;
        }

        .row-39 {
            height: 39%;
           /*  display: flex; */
        }

        .row-31 {
            height: 31%;
        }

        .iframe-container {
            width: 100%;
            height: 100%;
        }

        .subframe {
            flex: 1;
        }

        .subframe-60 {
            width: 60%;
        }

        .subframe-remainder {
            width: 40%;
        }
    </style>
</head>
<%

	String url = "../../ePH/jsp/WardReturnAddModify.jsp" ;
	String params = request.getQueryString() ;
	String source = url +"?"+ params ;


%>
<body>
    <div class="row row-24" id="DIV1">
        <iframe src="<%=source%>" name="wardretmedicationqueryframe" class="iframe-container" scrolling="no" frameborder="0" style="width:100vw;"></iframe>
    </div>
    <div class="row row-5" id="DIV2">
        <iframe src="" name="wardretmedicationplineframe" class="iframe-container" scrolling="no" frameborder="0" style="width:100vw;"></iframe>
    </div>
    <div class="row row-39" id="DIV3">
        <iframe src="../../eCommon/html/blank.html" name="wardretmedicationdrugframe" class="iframe-container subframe subframe-60" scrolling="auto" frameborder="0" style="width:41vw;"></iframe>
        <iframe src="../../eCommon/html/blank.html" name="wardretmedicationremarksframe" class="iframe-container subframe subframe-remainder" scrolling="no" frameborder="0" style="width:58vw;"></iframe>
    </div>
    <div class="row row-31" id="DIV4">
        <iframe src="../../eCommon/html/blank.html" name="wardretmedicationactionframe" class="iframe-container" scrolling="auto" frameborder="0" style="width:100vw;"></iframe>
    </div>
    <div class="row" style="flex-grow: 1;" id="DIV5">
        <iframe src="../../eCommon/html/blank.html" name="wardretmedicationbuttonframe" class="iframe-container" scrolling="no" frameborder="0" style="width:100vw;"></iframe>
    </div>
</body>
<%-- <FRAMESET  ROWS="24%,5%,39%,31%,*" FRAMESPACING="0" frameborder="1" id="mainframeset">
	
	
	<FRAME NAME="wardretmedicationqueryframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%=source%>">
	<FRAME NAME="wardretmedicationplineframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="">
			<FRAMESET cols="60%,*" FRAMESPACING="0" frameborder="0" id="subframeset">
				<FRAME NAME="wardretmedicationdrugframe" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html">
				<FRAME NAME="wardretmedicationremarksframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE 	SRC="../../eCommon/html/blank.html">
			</FRAMESET>
	<FRAME NAME="wardretmedicationactionframe" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html">
	<FRAME NAME="wardretmedicationbuttonframe" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html">
</FRAMESET> --%>

</HTML>
