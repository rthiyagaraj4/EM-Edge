<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<Script language='javascript' src='../../eMR/js/OtherDescForTermCode.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;


	try {
		con						=  ConnectionManager.getConnection(request);
		String termSet = "ICD10"; // added by mujafar for ML-MMOH-CRF-1281 US-3
		String TermCode		= checkForNull(request.getParameter("TermCode"));
		String mode="";
		String loginFacilityId		=	(String)session.getAttribute("facility_id");
		JSONObject DescriptionJsonObj		= new JSONObject(); 
		DescriptionJsonObj				= eMR.MRCommonBean.getTermCodeDescription(con,termSet,TermCode); // modified by mujafar for ML-MMOH-CRF-1281 US-3
		JSONArray DescriptionJsonArray 		= (JSONArray)DescriptionJsonObj.get("results");
		
		JSONObject termCodeCountObj = new JSONObject(); // modified by mujafar for ML-MMOH-CRF-1281 US-3
		Integer termCodeCount =0; // added by mujafar for ML-MMOH-CRF-1281 US-3
		termCodeCountObj	= (JSONObject)DescriptionJsonArray.get(0);
		termCodeCount = (Integer)termCodeCountObj.get("termCodeCount");
		
		if(termCodeCount == 1)
			mode="update";
			
	 %>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="TermDescResultForm" id="TermDescResultForm" method="post" action='' >
	
			
	<table cellspacing='0' cellpadding='0'  width='40%' border='0'  align='center'>

	<tr>
		<td class='PANELTOOLBAR' colspan='4' align='center'><fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.TerminologyDescription.label" bundle="${mr_labels}"/>s</td>
	</tr>

	<%
	JSONObject temCodeDescListObj = new JSONObject();
	if(DescriptionJsonArray.size() > 0)
	temCodeDescListObj	= (JSONObject)DescriptionJsonArray.get(0);
	//out.println("temCodeDescListObj::"+temCodeDescListObj);
	String descriptions= "";
	for(int i=1;i<=10;i++)
		{
		descriptions = checkForNull((String)temCodeDescListObj.get("description"+i));
	%>
	<tr>
	<td class=label width="10%" ><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp<%=i%>&nbsp:</td>
	<td class=fields width="15%"><input type='text' name='description<%=i%>' id='description<%=i%>' id='description<%=i%>' value="<%=descriptions%>" onBlur="makeValidString(this);"  size='40' maxlength='100'  ></td>
	</tr>
	<%
		}
	%>
	
	</table>
				
			
			
			<input type='hidden' name='term_code' id='term_code' value="<%=TermCode%>" >
			<input type='hidden' name='mode' id='mode' value="<%=mode%>" >
	


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

