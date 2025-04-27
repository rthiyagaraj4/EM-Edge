<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
Connection con=null;
ResultSet rset = null;
PreparedStatement pstmt=null;

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
try
{
	 con = ConnectionManager.getConnection(request);
	 java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	 String facility_id =session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
	 String locale = (String) p.getProperty("LOCALE");
	 String fnName = request.getParameter("function_id");	 	 
	String beanObj = request.getParameter("beanObj") == null ? "" :request.getParameter("beanObj");

//	out.println("<script>alert('From Criteria page --"+request.getQueryString()+"');</script>");

	
	eCA.PatientBannerGroupLine pmrBeanObj = null;
		pmrBeanObj = (eCA.PatientBannerGroupLine)getObjectFromBean(beanObj,"eCA.PatientBannerGroupLine",session);
		pmrBeanObj.clearBean();
     	 
	
%>
<html>
<head>
<% 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// added by Archana @ 10-12-08 
			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
			 {
					imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
			 }
		 //end
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>

<script language='javascript' src='../js/CAPatMedReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">

<form name="PatMedReportSearch_form" id="PatMedReportSearch_form">
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class='label' width='20%'><fmt:message key="eCA.PatMediReport.label" bundle="${ca_labels}"/> </td>
	 <td class='fields' width='30%'> <input type="Text" name="txtPatMedReport" id="txtPatMedReport" value = "" size="25" OnKeyPress='return CheckForSpeChar(event)' Onblur='getData(this)'><input type="hidden" name ="NoteTypeID" value=""><input type='button' class='button' name='buttonCategory' id='buttonCategory' value='?' OnClick='populateReportsLookup()'><img src='../../eCommon/images/mandatory.gif'></img></td>		
<%
	

//if(fnName.equals("Encounter Details")) 
if(fnName.equals("CAMS_ENC_DTL_FOR_PMR")) {%>
<td class ='label' width ='25%'></td><td class ='label' width ='25%'></td>
</tr><tr>
<!--<td class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>

	<td class='fields'> <select name='facility_id' id='facility_id'>
	<option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
	<%
	try
	{
		String facility_query = "select substr(facility_name,1,16) facility_name, facility_id from sm_facility_param_VW where language_id = ?  order by facility_name";
		String fac_code = "";
		String fac_desc = "";
		//String selected= "";
		pstmt = con.prepareStatement(facility_query);
		pstmt.setString(1,locale);
	    rset = pstmt.executeQuery();	
		while (rset!=null && rset.next())
		{
			fac_code = rset.getString("facility_id") == null ? "" : rset.getString("facility_id");
			fac_desc = rset.getString("facility_name") == null ? "" : rset.getString("facility_name");
			if(fac_code.equalsIgnoreCase(facility_id))
			{
				out.println("<option selected value="+fac_code+">"+fac_desc+"</option>");
			}
			else
			{
				out.println("<option value="+fac_code+">"+fac_desc+"</option>");
			}
		}
	
		if(rset!=null)  rset.close(); 
		if(pstmt!=null)  pstmt.close();
	}//try 
	catch(Exception eg)
	{
	   //out.println("Exception in ="+eg.toString());//COMMON-ICN-0181
	   eg.printStackTrace();//COMMON-ICN-0181
	}
 
    %>
	</select>
    </td> -->
<td align='right' colspan=4><input type='button' class='BUTTON' name='searchId' id='searchId' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='submitPage();'></td>
</tr>
</table>
<%}
//else if(fnName.equals("Speciality")){
else if(fnName.equals("CAMS_SPLTY_FOR_PMR")){ %>
<td class ='label' width ='25%'></td><td class ='label' width ='25%'></td></tr> </table>

<table border=0 cellspacing=0 cellpadding='5' width='100%' align='center'>
				<tr>
					<td  class='label' width='20%'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/> </td><td class='fields' width='30%' ><input type='radio' name='radSearch' id='radSearch' value='D' checked><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/><input type='radio' name='radSearch' id='radSearch' value='C'><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  class='fields' width='25%'>&nbsp;<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' >
						<select name="search_criteria" id="search_criteria">
							<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class='label' width='20%'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td><td class='fields' width='30%' >&nbsp;<input type="text" name="search_text" id="search_text" size='30' maxlength='8' value=""></td>
					<td  colspan='2' align='right'><input type='button' class='button' onclick="populateFormVals()" value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>"></td>					
				</tr>
</table>


<%}else if (fnName.equals("CAMS_PRACT_FOR_PMR")){ //Practitioner
%>
<td class ='label' width ='25%'></td><td class ='label' width ='25%'></td></tr> </table>
<table border=0 cellspacing=0 cellpadding='5' width='100%' align='center'>
				<tr>
					<td  class='label' width='20%'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td><td class='fields' width='30%'><input type='radio' name='radSearch' id='radSearch' value='D' checked><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>&nbsp;<input type='radio' name='radSearch' id='radSearch' value='C'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;</td>
					<td  class='label' width='25%'>&nbsp;<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'>
						<select name="search_criteria" id="search_criteria">
							<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
							<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class='label' width='20%'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td><td class='fields' width='30%'>&nbsp;<input type="text" name="search_text" id="search_text" size='30' maxlength='8' value=""></td>
					<td  colspan='2' align='right'><input type='button' class='button' onclick="populateFormVals()" value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>"></td>					
				</tr>
</table>
<% }%>
<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>

<input type='hidden' name='fnName' id='fnName' value='<%=fnName%>'>
<%
	
}
catch(Exception e){
	//out.println("Exception in CAPatMedReportSearchCriteria.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
       if (con !=null) ConnectionManager.returnConnection(con,request);
	}
%>

</form>
</body>
</html>

