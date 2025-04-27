<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// added by Arvind @  08-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/SitesForVaccine.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
		<form name='site_vaccine_form' id='site_vaccine_form'>
			<br>
			<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center"> 
			  <tr>
				<td width='15%' class="label" ><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/></td>
				<td  class="fields" width='55%' >
					<input type='text' name='siteDesc' id='siteDesc' size='40' maxlength='40' OnKeyPress='return CheckForSpeChar(event)' OnBlur ='getSiteCode(this)' OnChange='resetValues();setValue()'><input type='button' class='button' name='buttonSite' id='buttonSite' value='?' OnClick='resetValues();getSiteCode(this)'><img src="../../eCommon/images/mandatory.gif">
					
				</td>
				<td >
					<input type='button' class='button' name='buttonDetails' id='buttonDetails' value='<fmt:message key="eCA.Showdetail.label" bundle="${ca_labels}"/>' OnClick='setTimeout("searchSitesForVaccine()",1000)'>
				</td>
			 </tr>
			 </table>
			 <!-- added by arvind @ 08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->
			 <input type='hidden' name='siteCode' id='siteCode' value=''>
			 <input type='hidden' name='flag' id='flag' value='true'>			
			<input type='hidden' name='finalString' id='finalString' value=''>
			<input type='hidden' name='remove_value' id='remove_value' value=''>			
		</form>
	</body>
</html>

