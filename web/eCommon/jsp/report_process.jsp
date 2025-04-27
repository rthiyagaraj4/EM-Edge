<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %><head>
  <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

    <script src="../../eCommon/js/common.js"></script>
    <script language="JavaScript">
		var outputWindow;
        function onFormLoad() {
            window.document.title = 'eHIS' ;
        }

        function openReport( reportURL ) {
            if ( reportURL != null ) {
                var closeWindow = report_process_form.closeWindow.value ;
                var myBars      = 'directories=no,location=no,menubar=no,status=no' ;
                var myOptions   = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
                var myFeatures  = myBars + ', ' + myOptions ;

                if ( closeWindow == "true" ) {
                    var index = reportURL.indexOf( "&closeWindow=true" ) ;
                    reportURL = reportURL.substring( 0, index ) ;
                }

// By sbchand start on 29th June 2002
//              var outputWindow    = open( reportURL, '_blank', myFeatures ) ;
                outputWindow    = open( reportURL, '_self', myFeatures ) ;
// By sbchand end on 29th June 2002

                outputWindow.title= "Medicom Report Viewer" ;
                outputWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
                outputWindow.moveTo( 0,0 ) ;
                outputWindow.focus() ;

                if ( closeWindow == "true" ) { 
					setTimeout('callclose()',3000);
					//outputWindow.close() ;
                    //window.close() ;
                }
            }
        }
function callclose()
{
	outputWindow.close() ;
    window.close() ;

}
    </script>
</head>

<body onLoad="onFormLoad();" OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
		request.setCharacterEncoding("UTF-8");	
    String params       = request.getQueryString() ;
   //39764 - START
    if(params.contains("*"))
    	params = params.replaceAll("\\*","");
   //39764 - END
    String closeWindow  = request.getParameter( "closeWindow" ) ;
    String des_spreadsheetYN  = request.getParameter( "desformat" ) ;

	if ( closeWindow == null ) closeWindow = "false" ;

    if ( closeWindow.equalsIgnoreCase( "true" ) ) {
        out.println( "<script language='JavaScript'>alert(getMessage('REPORT_SUBMIT_SERVER','Common') ) ;</script>" ) ;
    } else {
        out.println( "<table align='center'>" ) ;
        out.println( "<tr height=500>" ) ;
        out.println( "<td align='center'>" ) ;

        out.println( "Processing Report.  Please Wait...<br><br>" ) ;
		out.println( "<input type='button' align='center' name='Cancel' id='Cancel' onClick='window.close()' class='button' value='Cancel'>" ) ;

        //out.println( "<img src='../images/BBcancel.gif' alt='Cancel' onClick='window.close()'>" ) ;

        out.println( "</td>" ) ;
        out.println( "</tr>" ) ;
        out.println( "</table>" ) ;
    }
%>
<form name="report_process_form" id="report_process_form">
<input type="hidden" name="closeWindow" id="closeWindow" value="<%= closeWindow %>">
</form>
<%
    if ( params != null ) {
        out.println( "<script language=\"JavaScript\">openReport(\"" + params + "\")</script>" ) ;
        out.println( "<script language=\"JavaScript\">onFormLoad();</script>" ) ;
    }
%>

</body>

