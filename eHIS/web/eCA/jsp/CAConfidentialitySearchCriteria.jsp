<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
09/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
--------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.text.*, eCA.* ,eOR.Common.*, eOR.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="BatchBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
<head>
<%
	String grp_by_code = "";
	String grp_desc = "";
	String sStyle = "";
	String l_bean_id		= "Ca_confidentialitySetUpBean";
	String l_bean_name		= "eCA.CAConfidentialitySetUpBean";
	String imgUrl="";

	//HashMap confdntHashMap = null;

	CAConfidentialitySetUpBean beanObj = null;	

	try
	{
		sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		if(sStyle.equals("IeStyle.css"))
		{
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		}

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		beanObj = (CAConfidentialitySetUpBean)getBeanObject(l_bean_id, l_bean_name, request);
		//confdntHashMap = beanObj.getConfidentialityMapData();
		
		grp_by_code = request.getParameter("searchCode")==null?"":request.getParameter("searchCode");		

		/*if(confdntHashMap != null){
			confdntHashMap.clear();
		}*/	
		
		if(grp_by_code.equalsIgnoreCase("P")){
			grp_desc = "Practitioner";
		}
		else if(grp_by_code.equalsIgnoreCase("S")){
			grp_desc = "Specialty";	
		}
		else if(grp_by_code.equalsIgnoreCase("R")){
			grp_desc = "Responsibility";
		}
		else if(grp_by_code.equalsIgnoreCase("E")){
			grp_desc = "Event";
		}
%>
		
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
    <script src='../../eCA/js/ConfidentialitySetUpHeader.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
    <Script src='../../eCommon/js/CommonLookup.js' language ='JavaScript'></Script>
    <script src='../../eCommon/js/ValidateControl.js'language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()' onload='chk_spl_char()'>
<form name="CriteriaForm" id="CriteriaForm"  >
<table  border="0" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<th colspan="5" align="left"><%= grp_desc %></th>
	</tr>
	<tr>
        <td>&nbsp;&nbsp;</td> 
		<td class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
        <td class="fields">	
			<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this)"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
			<input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="storeVal(this)" checked><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		</td>
		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td class='fields'>
			<select name="search_criteria" id="search_criteria">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
        </td>       
    </tr> 
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
        <td class="fields">
			<input type="text" onBlur="makeValidString(this);allow_nochars(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
		<td class="label">&nbsp;</td>
        <td align="left" nowrap>
			<input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='callRespLookup(search_text,"<%=grp_by_code%>")' class="button" >
			<input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetQueryForm('<%=grp_by_code%>')" class="button" >
        </td>
    </tr>
</table>
<%
		if(!imgUrl.equals(""))
		{
%>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%
		}
%>
</form>
<%
	}
	catch(Exception e)
	{
		System.err.println("CAConfidentialitySearchCriteria.jsp,86,message=>"+e.getMessage());
		e.printStackTrace();
	}
%>
</body>
</html>

