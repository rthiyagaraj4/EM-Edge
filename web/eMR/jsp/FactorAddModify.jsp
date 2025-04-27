<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Created By		:	Hema Malini B
*	Created On		:	27th Dec 2004
-->
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*"%>

<!-- JSP Page specific attributes end -->

<!--Mandatory declarations start-->
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale						= checkForNull((String)session.getAttribute("LOCALE"));

%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="javascript" src="../js/Factor.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
  request.setCharacterEncoding("UTF-8");
  request= new XSSRequestWrapper(request);
  response.addHeader("X-XSS-Protection", "1; mode=block");
  response.addHeader("X-Content-Type-Options", "nosniff");
  String mode=request.getParameter("mode");
  String code=request.getParameter("factor_code"); 
%>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement()">
<form name="factor_form" id="factor_form" action="../../servlet/eMR.FactorServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR>
      	<BR><BR><BR>
 <table border="0" cellpadding="5" cellspacing="0" width="auto" align='center'>
<% 
if(mode.equals("1"))
{
  %>
  

  <tr>
      <td  class="label" width="50%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  class='fields' width='50%' >
      <input type="text" name="factor_code" id="factor_code" size="10" maxlength="10" onBlur='ChangeUpperCase(this);' onKeyPress="return CheckForSpecChars(event)"> <img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>

    

    <tr>
      <td class="label" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td  class='fields'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

     

    <tr>
      <td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td class='fields' ><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)'><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

   
  <tr>
  <td  class="label" ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
  <td  class="fields" >
	    <select name="factor_type" id="factor_type" >
    	  <option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
	      <option value="C"><fmt:message key="eMR.DefiningCharacteristics.label" bundle="${mr_labels}"/></option>
    	  <option value="L"><fmt:message key="eMR.RelatedFactor.label" bundle="${mr_labels}"/></option>
	  	  <option value="R"><fmt:message key="eMR.RelatedandRiskFactor.label" bundle="${mr_labels}"/></option>
	  	  <option value="K"><fmt:message key="eMR.RiskFactor.label" bundle="${mr_labels}"/></option>
	  
	  	
	  </select><img src='../../eCommon/images/mandatory.gif'></img>

  </td>
  

	<tr>
	<td  class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td  class='fields' ><input type="checkbox" name="eff_status" id="eff_status" value="E" checked></td>
    </tr>

   
  </table>

  <% }else if(mode.equals("2")){

 Connection con=null;
 PreparedStatement stmt=null;
 ResultSet rs=null;

  try
 {
	 con = ConnectionManager.getConnection(request);
	 code=request.getParameter("factor_code")==null ? "":request.getParameter("factor_code");
	 String query="select short_desc,long_desc,related_factor_yn,risk_factor_yn,defn_characteristic_yn,eff_status from mr_factor_lang_vw where factor_code=? and language_id='"+locale+"'";
	 stmt=con.prepareStatement(query); 
	 stmt.setString(1,code);
	 rs=stmt.executeQuery();
	 rs.next();

	String long_desc  = rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	String short_desc  = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	String related_factor = rs.getString("related_factor_yn")==null?"N":rs.getString("related_factor_yn");
	String risk_factor = rs.getString("risk_factor_yn")==null ? "N":rs.getString("risk_factor_yn");
	String defn_char = rs.getString("defn_characteristic_yn")==null?"N":rs.getString("defn_characteristic_yn");
	String eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");
	String factor_type="";

  if(defn_char.equals("Y"))
	factor_type = "C";
  else
  {
	if(related_factor.equals("Y"))
	{
		if (risk_factor.equals("Y"))
			factor_type = "R";
		else
			factor_type = "L";
	}		
	else
		factor_type = "K";
  }
String status="";
String readOnly="";
String disable="";
String select1="";
String select2="";
String select3="";
String select4="";

if(factor_type.equals("L"))
	select1="selected";
else
	select1="";
if(factor_type.equals("K"))
	select2="selected";
else
	select2="";
			
if(factor_type.equals("R"))
	select3="selected";
else
	select3="";

if(factor_type.equals("C"))
	select4="selected";
else
	select4="";

if(eff_status.equals("E"))
{
	status="checked";
	disable="";
	readOnly="";
}
else if(eff_status.equals("D")) 
{
	status="";
	disable="disabled";
	readOnly="readonly";
}
   %>
  <table border="0" cellpadding="5" cellspacing="0" width="auto" align='center'>
  
  <tr>
      <td  class="label" width="50%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  class='fields' width='50%' >
      <input type="text" name="factor_code" id="factor_code" size="10" maxlength="10" onBlur="ChangeUpperCase(this);" onKeyPress="return CheckForSpecChars(event)" readonly value="<%=code%>"><img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>

	 
	  <tr>
      <td  class="label" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td  class='fields' ><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" onBlur='makeValidString(this)' style='{ font-size: ;}' value="<%=long_desc%>" <%=readOnly%> ><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

     

    <tr>
      <td  class="label" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td class='fields' ><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" onBlur='makeValidString(this)' value="<%=short_desc%>" <%=readOnly%>><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

   
  <tr>
  <td  class="label" ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
  <td  class="fields" >
 <select name="factor_type" id="factor_type" <%=disable%> onChange="onChangeType(this)" >
    	  <option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
   		  <option value="C" <%=select4%> ><fmt:message key="eMR.DefiningCharacteristics.label" bundle="${mr_labels}"/></option>  
		  <option value="L" <%=select1%> ><fmt:message key="eMR.RelatedFactor.label" bundle="${mr_labels}"/></option>
    	  <option value="R" <%=select3%> ><fmt:message key="eMR.RelatedandRiskFactor.label" bundle="${mr_labels}"/></option>
	  	  <option value="K" <%=select2%> ><fmt:message key="eMR.RiskFactor.label" bundle="${mr_labels}"/></option>
	 
	  </select><img src='../../eCommon/images/mandatory.gif'></img>  
  </td>
  

	<tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td  class='fields'><input type="checkbox" name="eff_status" id="eff_status" onclick="oneffStatusCheck()"  value="<%=eff_status%>" <%=status%>></td>
    </tr>

      
  </table>
     <input type="hidden" name="factor_type1" id="factor_type1" value="<%=factor_type%>" >
   <% 
    }catch(Exception e)
  {
	//out.println(e.toString());
	e.printStackTrace();
  }
  finally {
	  if (rs != null)   rs.close();
	  if (stmt != null) stmt.close();
	  ConnectionManager.returnConnection(con,request);
	}
  }%>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</form>

</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

