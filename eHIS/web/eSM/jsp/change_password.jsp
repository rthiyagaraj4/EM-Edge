<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
        request.setCharacterEncoding("UTF-8");
		String mainyn = request.getParameter("main")==null?"":request.getParameter("main");
%>
<script language="JavaScript">
	showInNewWindow() ;

	function showInNewWindow() {
		var width = 400 ;
		var height = 300 ;
		var left = (window.screen.availWidth-width)/2 ;
		var top  = (window.screen.availHeight-height)/2 ;

		var myBars = 'directories=no,location=no,menubar=no,status=no' ;
		var myOptions = 'width=' + width +', height=' + height +', resizable=no' ;
		var myFeatures = myBars + ', ' + myOptions ;
		var ecisWindow = open( 'change_password_form.jsp?main=<%=mainyn%>', 'eHISMain', myFeatures ) ;
		ecisWindow.focus() ;
		ecisWindow.document.title = "eCIS" ;
		ecisWindow.resizeTo( width, height ) ;
		ecisWindow.moveTo( left, top ) ;
	}
</script>


