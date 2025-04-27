<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.net.URLDecoder" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
    <head>
<%
			request.setCharacterEncoding("UTF-8");	
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <style>
        A:active { 
            COLOR: white; 
        }

    </style>
    
    <script>
        var temparr = new Array();
        var count = 0;
        var prev=0;
        var prevcol='MENUSUBLEVELCOLOR';
        var sec_hdg_cd=new Array();
        var logic_seq_no=new Array();

        function goHomePage(){
                parent.location.href='../../eCommon/jsp/dmenu.jsp';
        }
        
        function chcol(ro)
        {
                document.getElementById("t").rows(prev).cells(0).className=prevcol;
                prevcol=ro.cells(0).className;
                ro.cells(0).className="MENUSELECTEDCOLOR";
                prev=ro.rowIndex;
        }

        function callJSPs(val)
        {
            if(val == 'EventTypeParam')
                parent.frames[1].location.href = '../../eCA/jsp/EventTypeParam.jsp?module_id=CA&function_id=EVENT_TYPE_PARAM&function_name=Event Type Parameter&function_type=F&access=NYNNN';
		}

    </script>

    </head>

     <body style="background-color:dimgray;"   OnMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
    <form name="CAAdminMenu_form" id="CAAdminMenu_form">
    <table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>        

        <tr onclick='chcol(this)'>
            <td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('EventTypeParam')"><fmt:message key="eCA.EventTypeParameter.label" bundle="${ca_labels}"/></td>
        </tr>
		<tr><td class="BLANK_ROW">&nbsp;</td></tr>
		<tr>
            <td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
        </tr>

    </table>

    </body>
    </form>
</html>

