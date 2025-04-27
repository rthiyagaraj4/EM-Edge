<%@ page contentType="text/html;charset=UTF-8"%> 
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
%>
<script language="JavaScript">
    showInNewWindow() ;

    function showInNewWindow() {
       /* var width = 400 ;
        var height = 250 ;
        var left = (window.screen.availWidth-width)/2 ;
        var top  = (window.screen.availHeight-height)/2 ;

        var myBars = 'directories=no,location=no,menubar=no,status=no' ;
        var myOptions = 'width=' + width +', height=' + height +', resizable=no,scrollbars=no' ;
        var myFeatures = myBars + ', ' + myOptions ;
        var ecisWindow = open( 'change_responsibility_form.jsp', 'eHISMain2', myFeatures ) ;
		ecisWindow.moveTo( left, top ) ;*/
        var width = "400" ;
        var height = "250" ;
        var left = (window.screen.availWidth-width)/2 ;
        var top  = (window.screen.availHeight-height)/2 ;

        var myBars = 'directories=no,location=no,menubar=no,status=no' ;
        var myOptions = 'width=' + 600 +'px, height=' + 700 +'px, resizable=no,scrollbars=no' ;
        var myFeatures = myBars + ', ' + myOptions ;
        var ecisWindow = open( 'change_responsibility_form.jsp', 'eHISMain2', myFeatures ) ;
		ecisWindow.moveTo(100,100) ;
        
    }
</script>


