<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../js/OtherDescForTermCode.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	Connection con=null;

	try {
		con =  ConnectionManager.getConnection(request);
		JSONObject TermCodeJsonObj		= new JSONObject(); 
		TermCodeJsonObj				= eMR.MRCommonBean.getTermcode(con);
		JSONArray TermCodeJsonArray 		= (JSONArray)TermCodeJsonObj.get("results");
	 %>
		
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
			<form name='OthDescForTermCodeCriteria' id='OthDescForTermCodeCriteria'  method="post">
				<table border="0" cellpadding="0" cellspacing="0" width="50%" align='left'>
				<tr><td>&nbsp;</td>
		</tr>
		<tr>
			<td class="label" width="15%"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
			<td width="15%" class="fields" colspan="2">
				<select name="arch_disp" id="arch_disp" >
					<option value="0"><fmt:message key="eMR.ICD10.label" bundle="${mr_labels}"/></option>
					
				</select>
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		
		<tr>
			<td class="label" width="20%"><fmt:message key="Common.primary.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></td>
			<td width="20%" class="fields" colspan="3" >
					<select name="TermCode" id="TermCode" id='TermCode'>
								<option value="" >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
								<%
									for(int i = 0 ; i < TermCodeJsonArray.size() ; i++) {
										JSONObject termCodeListObj	= (JSONObject)TermCodeJsonArray.get(i);
										String term_code				= (String) termCodeListObj.get("term_code");
											
								%>
										<option value="<%=term_code%>"><%=term_code%></option>
								<%
									}
								%>
							</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		<td class='button' width="5%" align='left' > <INPUT TYPE="button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  onClick='callSearch()' class='BUTTON'>
					</td>

		
	   </tr>
	  
	</table>
				
			</form>

		</body>
	<%
	} catch(Exception e){
		e.printStackTrace();
	}
   finally
    {
  		
		ConnectionManager.returnConnection(con,request);
    }
	%>

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

