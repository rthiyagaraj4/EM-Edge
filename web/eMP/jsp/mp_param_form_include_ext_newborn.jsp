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
	Boolean isAllow_External_Newborn = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALLOW_EXTERNAL_NEWBORN");
	
	//Boolean isAllow_External_Newborn = true;
	
	String allow_ext_nb_regn_within_days = checkForNull(request.getParameter("allow_ext_nb_regn_within_days"));
		
if(isAllow_External_Newborn){%>
       
	   <td class='label' nowrap ><fmt:message key="eMP.AllowExternalNewBorn.label" bundle="${mp_labels}"/></td>
	   <td  class='fields' colspan ='3' nowrap ><input type='text' name='allow_ext_nb_regn_within_days' id='allow_ext_nb_regn_within_days' value='<%=allow_ext_nb_regn_within_days%>' maxlength=3 size = 3 onkeypress="return allowValidNumber(this,event,2, 0);" onBlur='CheckNum(this);checkDecimal(this);' onfocus='tabs_alignment(3)'>&nbsp;<fmt:message key="eMP.DaysofBirth.label" bundle="${mp_labels}"/></td>
	   
	   <% }%>

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

