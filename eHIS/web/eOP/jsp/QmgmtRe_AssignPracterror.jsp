<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<!--<script src='../../ca/js/VitalSigns.js' language='javascript'></SCRIPT-->
<script>
function onsuccess()
{
    window.parent.close();

}
</script>
<BODY CLASS="MESSAGE" onKeyDown = 'lockKey();'>

<p align="left">
<%
    String error=request.getParameter( "err_num" );

    if ( error != null ) {
        //out.print(error);
        %>

        <script>
        var r='<%=error%>';
        if (r != "" && r != null)
        {
            r = r.substring(0,r.length-4);
            alert(r);
            //parent.window.close()
			/ Set the return value if necessary
    let dialogBody = parent.parent.document.getElementById('dialog-body');
    if (dialogBody && dialogBody.contentWindow) {
        dialogBody.contentWindow.returnValue = "";
    }

    // Retrieve dialog tags
    const dialogTags = parent.parent.document.querySelectorAll("#dialog_tag");

    // Close each dialog tag if they exist
    dialogTags.forEach(dialogTag => {
        if (typeof dialogTag.close === 'function') {
            dialogTag.close();
        }
    });
        }
        </script>
        <%
        String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
        //out.println( "<script language='JavaScript'>parent.tools.document.write ('"+error+"') </script>" ) ;
        if ( error_value.equals( "1" ) )
            out.println( "<script language='JavaScript'>onsuccess();</script>" ) ;
    }

%>
</p>
</BODY>

