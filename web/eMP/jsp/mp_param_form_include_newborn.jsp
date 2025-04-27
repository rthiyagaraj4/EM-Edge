<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*,eXH.InterfaceUtil,eCommon.XSSRequestWrapper"  %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../js/mp_param.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<% 
	Connection con=null ;
try
	{
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    con = ConnectionManager.getConnection(request);
	Boolean isMPMandatoryFieldsNewborn = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_MANDATORY_FIELDS_NEWBORN");
	String mandate_first_newborn_yn = checkForNull( request.getParameter( "mandate_first_newborn_yn") );
	String mandate_first_newborn_ip_yn = checkForNull( request.getParameter( "mandate_first_newborn_ip_yn") );
	String mandate_first_newborn_ae_yn = checkForNull( request.getParameter( "mandate_first_newborn_ae_yn") );
	String mandate_second_newborn_yn = checkForNull( request.getParameter( "mandate_second_newborn_yn") );
	String mandate_second_newborn_ip_yn = checkForNull( request.getParameter( "mandate_second_newborn_ip_yn") );
	String mandate_second_newborn_ae_yn = checkForNull( request.getParameter( "mandate_second_newborn_ae_yn") );
	String mandate_third_newborn_yn = checkForNull( request.getParameter( "mandate_third_newborn_yn") );
	String mandate_third_newborn_ip_yn = checkForNull( request.getParameter( "mandate_third_newborn_ip_yn") );
	String mandate_third_newborn_ae_yn = checkForNull( request.getParameter( "mandate_third_newborn_ae_yn") );
	String mand_antenatal_newborn_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_yn") );
	String mand_antenatal_newborn_ip_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_ip_yn") );
	String mand_antenatal_newborn_ae_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_ae_yn") );
	//Added by Jeyachitra against ML-MMOH-CRF-1759.1-US001 
	String mand_parity_newborn_yn = checkForNull(request.getParameter("mand_parity_newborn_yn"));
	String mand_parity_newborn_ip_yn = checkForNull(request.getParameter("mand_parity_newborn_ip_yn"));
	String mand_parity_newborn_ae_yn = checkForNull(request.getParameter("mand_parity_newborn_ae_yn"));
	String invoke_menstrual_history_yn = checkForNull(request.getParameter("invoke_menstrual_history_yn"));
	//ML-MMOH-CRF-1759.1-US001 ends
	String mandate_first_newborn_chked = "";
	String mandate_first_newborn_ip_chked = "";
	String mandate_first_newborn_ae_chked = "";
	String mandate_second_newborn_chked = "";
	String mandate_second_newborn_ip_chked = "";
	String mandate_second_newborn_ae_chked = "";
	String mandate_third_newborn_chked = "";
	String mandate_third_newborn_ip_chked = "";
	String mandate_third_newborn_ae_chked = "";
	String mand_antenatal_newborn_chked = "";
	String mand_antenatal_newborn_ip_chked = "";
	String mand_antenatal_newborn_ae_chked = "";
	String mand_parity_newborn_chked = "";
	String mand_parity_newborn_ip_chked = "";
	String mand_parity_newborn_ae_chked = "";
	String invoke_menstrual_history_chkd = "";
	if (mandate_first_newborn_yn.equals("Y")) mandate_first_newborn_chked = "checked";
		if (mandate_first_newborn_ip_yn.equals("Y")) mandate_first_newborn_ip_chked = "checked";
		if (mandate_first_newborn_ae_yn.equals("Y")) mandate_first_newborn_ae_chked = "checked";
		if (mandate_second_newborn_yn.equals("Y")) mandate_second_newborn_chked = "checked";
		if (mandate_second_newborn_ip_yn.equals("Y")) mandate_second_newborn_ip_chked = "checked";
		if (mandate_second_newborn_ae_yn.equals("Y")) mandate_second_newborn_ae_chked = "checked";
		if (mandate_third_newborn_yn.equals("Y")) mandate_third_newborn_chked = "checked";
		if (mandate_third_newborn_ip_yn.equals("Y")) mandate_third_newborn_ip_chked = "checked";
		if (mandate_third_newborn_ae_yn.equals("Y")) mandate_third_newborn_ae_chked = "checked";
		if (mand_antenatal_newborn_yn.equals("Y")) mand_antenatal_newborn_chked = "checked";
		if (mand_antenatal_newborn_ip_yn.equals("Y")) mand_antenatal_newborn_ip_chked = "checked";
		if (mand_antenatal_newborn_ae_yn.equals("Y")) mand_antenatal_newborn_ae_chked = "checked";
		//Added by Jeyachitra against ML-MMOH-CRF-1759.1-US001
		if(mand_parity_newborn_ae_yn.equals("Y")) mand_parity_newborn_ae_chked="checked";
		if(mand_parity_newborn_yn.equals("Y")) mand_parity_newborn_chked="checked";
		if(mand_parity_newborn_ip_yn.equals("Y")) mand_parity_newborn_ip_chked="checked";
		if(invoke_menstrual_history_yn.equals("Y")) invoke_menstrual_history_chkd="checked";
		//ML-MMOH-CRF-1759.1-US001 ends
%>
       <table border= '0' cellpadding='0' cellspacing='0' width='100%'>
	   <tr><td colspan=1>
	   <td class='label' style='text-align: center;' nowrap ><fmt:message key="eMP.RegNewbornForIP.label" bundle="${mp_labels}"/></td>
	   <td class='label' style='text-align: center;' nowrap ><fmt:message key="Common.Register.label" bundle="${common_labels}"/> <fmt:message key="eMP.Newbornn.label" bundle="${mp_labels}"/></td>
	   <td class='label' style='text-align: center;' nowrap ><fmt:message key="eAE.RegisterNewBornForAE.label" bundle="${ae_labels}"/></td>
	   </tr>
	   <%if(isMPMandatoryFieldsNewborn){ %>
	   <tr>
	   <td class='label'  nowrap ><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/> <fmt:message key="eMP.Complicationsin1stStage.label" bundle="${mp_labels}"/> </td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_first_newborn_ip_yn' id='mandate_first_newborn_ip_yn' value='Y' <%=mandate_first_newborn_ip_chked%>></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_first_newborn_yn' id='mandate_first_newborn_yn' value='Y' <%=mandate_first_newborn_chked%>></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_first_newborn_ae_yn' id='mandate_first_newborn_ae_yn' value='Y' <%=mandate_first_newborn_ae_chked%>></td>
	   </tr>
	   <tr><td class='label'  nowrap ><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/> <fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/> </td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_second_newborn_ip_yn' id='mandate_second_newborn_ip_yn' value='Y' <%=mandate_second_newborn_ip_chked%>></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_second_newborn_yn' id='mandate_second_newborn_yn' value='Y' <%=mandate_second_newborn_chked%>></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_second_newborn_ae_yn' id='mandate_second_newborn_ae_yn' value='Y' <%=mandate_second_newborn_ae_chked%>></td>
	   </tr>
	   <tr><td class='label'  nowrap ><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/> <fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/> </td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_third_newborn_ip_yn' id='mandate_third_newborn_ip_yn' value='Y' <%=mandate_third_newborn_ip_chked%>></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_third_newborn_yn' id='mandate_third_newborn_yn' value='Y' <%=mandate_third_newborn_chked%>></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mandate_third_newborn_ae_yn' id='mandate_third_newborn_ae_yn' value='Y' <%=mandate_third_newborn_ae_chked%>></td>
	   </tr>
	   <tr><td class='label'  nowrap ><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/> <fmt:message key="eMP.AnteNatalCare.label" bundle="${mp_labels}"/> <fmt:message key="eMP.given.label" bundle="${mp_labels}"/> <fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mand_antenatal_newborn_ip_yn' id='mand_antenatal_newborn_ip_yn' value='Y' <%=mand_antenatal_newborn_ip_chked%>></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mand_antenatal_newborn_yn' id='mand_antenatal_newborn_yn' value='Y' <%=mand_antenatal_newborn_chked%>></td>
	   <td class='fields' style='text-align: center;'><input type='checkbox' name='mand_antenatal_newborn_ae_yn' id='mand_antenatal_newborn_ae_yn' value='Y' <%=mand_antenatal_newborn_ae_chked%>></td>
	   </tr>
	   <% }%>
	    <tr>
	   	<td class="label" nowrap><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMP.Parity.label" bundle="${mp_labels}"/> </td> 
	   	<td class="fields" style='text-align: center;'><input type="checkbox" name="mand_parity_newborn_ip_yn" id="mand_parity_newborn_ip_yn" value='Y' <%=mand_parity_newborn_ip_chked %> disabled></td>
	   	<td class="fields" style='text-align: center;'><input type="checkbox" name="mand_parity_newborn_yn" id="mand_parity_newborn_yn" value='Y' <%=mand_parity_newborn_chked %>></td>
	   	<td class="fields" style='text-align: center;'><input type="checkbox" name="mand_parity_newborn_ae_yn" id="mand_parity_newborn_ae_yn" value='Y' <%=mand_parity_newborn_ae_chked %>></td>
	   </tr>
	   <tr>
	   	<td class="label" nowrap>
	   	<fmt:message key="eMP.InvokeMenstrualHistory.label" bundle="${mp_labels}"/>
	   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   	<input name="invoke_menstrual_history_yn" id="invoke_menstrual_history_yn" type="checkbox" value='Y' <%= invoke_menstrual_history_chkd %>/></td>
	   </tr>
	   </table>
	   

	<%}
	catch( Exception ce ) {ce.printStackTrace();}
    finally
    {
        
        if(con != null) ConnectionManager.returnConnection(con,request);
    }
%>
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

