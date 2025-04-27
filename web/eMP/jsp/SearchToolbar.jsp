<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>

<%
	request.setCharacterEncoding("UTF-8");
	String register_button_yn = request.getParameter("register_button_yn");
	//Maheshwaran K added for MMS-DM-CRF-0208.1 - suspend_inactive_pat_yn
	String suspend_inactive_pat_yn = request.getParameter("suspend_inactive_pat_yn");
    String func_act = request.getParameter("func_act");	
	func_act = (func_act == null)?"":func_act;
	String dr_function_id = request.getParameter("dr_function_id");
	String disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResultPage.label","common_labels");

%>
<html>
    <head>
        <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        
        <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>       
        <Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
        <Script language='javascript' src='../../eMP/js/PatientSearch.js'></Script>
        <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
        <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        <script>
        function defaultSetting()
        {
                document.getElementById('disprec').style.visibility='hidden' ;
                document.getElementById('display').style.visibility='hidden' ;
                search_toolbar.next.style.visibility = 'hidden';
                search_toolbar.prev.style.visibility = 'hidden';
        }

        </script>
    </head>
    <body class='content' onLoad="defaultSetting()" topmargin='0' onKeyDown = 'lockKey()'>
    <form name="search_toolbar" id="search_toolbar">
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr><td>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tr>

        <td ID='display' class="label" width="15%" nowrap><b>&nbsp;<%=disp%></b></td>
        <td class='label'><input type="button" name="prev" id="prev" class="BUTTON" value='<' onClick="parent.Pat_Search_Criteria_Frame.displayNextSet('prev')" disabled ></td>
        <td ID='disprec' align="left" class="label" width="15%"></td>
        <td class='label'><input type="button" name="next" id="next" class="BUTTON" value='>' onClick="parent.Pat_Search_Criteria_Frame.displayNextSet('next')" disabled ></td>
        <td width="78%" class='BUTTON' valign='top' align="right">

		<%if(register_button_yn.equals("Y") && func_act.equals("AEreg")){%>
			
			 <input type='button' name='register' id='register' class='BUTTON' value='<fmt:message key="Common.Normal.label" bundle="${common_labels}"/> <fmt:message key="Common.Registration.label" bundle="${common_labels}"/>' onClick="parent.Pat_Search_Criteria_Frame.callRegVisitModal()" disabled><input type='button' name='register1' id='register1' class='BUTTON' value='<fmt:message key="eMP.EmerRegn.label" bundle="${mp_labels}"/>' onClick="parent.Pat_Search_Criteria_Frame.passValuesforEmer()" disabled>
		<%}else{%>
			<%if(register_button_yn.equals("Y") && (func_act.equals("Visitreg")||(func_act.equals("DuplicateRegistration"))||(func_act.equals("AdmitPatient"))||(func_act.equals("ProcdReg")))){%>
				<input type='button' name='register' id='register' class='BUTTON' value='<fmt:message key="eMP.RegisterPatient.label" bundle="${mp_labels}"/>' onClick="parent.Pat_Search_Criteria_Frame.callRegVisitModal()" disabled>
			<%} else if(register_button_yn.equals("Y")) {%>
				<input type='button' name='register' id='register' class='BUTTON' value='<fmt:message key="eMP.RegisterPatient.label" bundle="${mp_labels}"/>' onClick="parent.Pat_Search_Criteria_Frame.passValues('<%=func_act%>')" disabled>
			<%} else if(register_button_yn.equals("R")) {%>
			   	<input type='button' name='register' id='register' class='BUTTON' value='<fmt:message key="eMP.EmerRegn.label" bundle="${mp_labels}"/>' onClick="parent.Pat_Search_Criteria_Frame.passValuesforEmer()" disabled>
			<%}%>
		<%}%>
		<input type='button' class='BUTTON' name='Search' id='Search' title= 'Search' align='right' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="parent.Pat_Search_Criteria_Frame.searchForRslt();"></a></td>
		
		
		
		
    </tr>
    </table>
    </td></tr></table>
	<input type='hidden' name='func_act' id='func_act' value='<%=func_act%>'>
	<input type='hidden' name='dr_function_id' id='dr_function_id' value='<%=dr_function_id%>'>
	<!--Maheshwaran K added for MMS-DM-CRF-0208.1 - suspend_inactive_pat_yn-->
	<input type='hidden' name='suspend_inactive_pat_yn' id='suspend_inactive_pat_yn' value='<%=suspend_inactive_pat_yn%>'>
	<input type="hidden" name="register_button_yn" id="register_button_yn" value="<%=register_button_yn%>"/>
	<input type="hidden" name="toolbar_func_act" id="toolbar_func_act" value="<%=func_act%>"/>
	<input type="hidden" name="toolbar_dr_function_id" id="toolbar_dr_function_id" value="<%=dr_function_id%>"/>
    </form>
    </body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

