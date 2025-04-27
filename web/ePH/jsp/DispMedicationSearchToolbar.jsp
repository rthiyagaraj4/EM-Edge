<!DOCTYPE html>
<!-- 

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
14/11/2023						Sushant Tambe          created
15/11/2023     MMS-DM-CRF-0228  Sushant Tambe    

-->

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8");
	
%>
<html>
    <head>
        
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
        <script src="../../ePH/js/DispMedication.js"></script>
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        <script>
        function defaultSetting()
        {
                document.getElementById("disprec").style.visibility='hidden' ;
                document.getElementById("next").style.visibility = 'hidden';
                document.getElementById("prev").style.visibility = 'hidden';
                document.getElementById("first").style.visibility = 'hidden';
                document.getElementById("last").style.visibility = 'hidden';
        }
        </script>
    </head>
    <body class='content' onLoad="defaultSetting()" topmargin='0' onKeyDown = 'lockKey()'>
    <form name="disp_Medication_search_toolbar" id="disp_Medication_search_toolbar">
    <table border="0" cellpadding="0" cellspacing="0" width="20%" style="float:right;">
       <tr>
        <td class='label' id="first" name="first" onClick="displayFirstLastSet('first')" style="cursor:pointer;color:blue;text-decoration:underline;" value="First" disabled>First&nbsp&nbsp</td>
        <td class='button'><input type="button" name="prev" id="prev" class="BUTTON" value="<" onClick="displayNextSet('prev')" disabled></td>
        <td id='disprec' class="label"></td>
        <td class='button'><input type="button" name="next" id="next" class="BUTTON" value=">" onClick="displayNextSet('next')" disabled>&nbsp&nbsp</td>
        <td class='label' id="last" name="last" onClick="displayFirstLastSet('last')" style="cursor:pointer;color:blue;text-decoration:underline;"  value="Last" disabled >Last</td>
        <input type="hidden" name="defaultwindow" id="defaultwindow" id="defaultwindow" value=''>
    </tr> 
    </table>
    
    <!-- Hidden -->
    </form>
    </body>
</html>

