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
<Script language='javascript' src='../../eMP/js/Form60.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	Connection con=null;
	String patientIdLength	= "";

	try {
		con =  ConnectionManager.getConnection(request);
		
		JSONObject encounterTypeJsonObj		= new JSONObject();
		encounterTypeJsonObj				= eMP.MPForm60Bean.getEncounterType(con);
		JSONArray encounterTypeArray 		= (JSONArray)encounterTypeJsonObj.get("results");

		patientIdLength = eCommon.Common.CommonBean.getPatIdLength(con);
		patientIdLength = checkForNull(patientIdLength,"0");
	 %>
		
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
			<form name='form60Criteria' id='form60Criteria'  method="post">
				<table border='0' cellpadding='2' cellspacing='0' width="100%">
					<tr>
						<td class=label width="10%">
							<fmt:message key="Common.patientId.label" bundle="${common_labels}"/> 
						</td>
						<td  class=fields width="15%">
							<input type='text' name='patientId' id='patientId'  id= 'patientId' value="" size='<%=patientIdLength%>' maxlength="<%=patientIdLength%>" onBlur="makeValidString(this);ChangeUpperCase(this);validatePatientId(this);return PanCardAvailCheck(this);" onKeypress='makeValidString(this);return CheckForSpecChars(event);'  >&nbsp;<input type='button' class='button' value='?' name='pat_id' id='pat_id' onClick="showPatientIDLookUp();" > &nbsp;<img src='../images/mandatory.gif'></img>
						</td>
						<td class=label   nowrap width="10%">
							<fmt:message key="Common.encountertype.label" bundle="${common_labels}"/>
						</td>
						<td class=fields width="15%">
							<select name="encounterType" id="encounterType" id='encounterType'>
								<option >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
								<%
									for(int i = 0 ; i < encounterTypeArray.size() ; i++) {
										JSONObject encounterTypListObj	= (JSONObject)encounterTypeArray.get(i);
										String patientClass				= (String) encounterTypListObj.get("patientClass");
										String shortDesc				= (String) encounterTypListObj.get("shortDesc");		
								%>
										<option value="<%=patientClass%>"><%=shortDesc%></option>
								<%
									}
								%>
							</select>
						</td>
						<td class=label width="10%" >
							<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
						</td>
						<td class=fields width="15%">
							<input type='text' name='encounterId' id='encounterId' id='encounterId' value=""  size='12' maxlength='12' onBlur="ChecksplCharsAlphabet(this)" onKeyPress="return NumberCheck(event);"  >
						</td>
					</tr>
					<tr>
						<td COLSPAN="6"> &nbsp;</td>
						</tr>
					<tr>
						<td COLSPAN="5"> &nbsp;</td>
						<td  class='button' > 
						<INPUT TYPE="button" value=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%> "  onClick='callSearch()' class='BUTTON'>
					</td>

					</tr>
				</table>
				<input type='hidden' name='isPanCardAvailableYN' id='isPanCardAvailableYN' value="" />
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

