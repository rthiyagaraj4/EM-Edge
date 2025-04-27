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

		<script language="JavaScript" src ="../../eCA/js/SectionChart.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
		<form name='sectionChartHeaderForm' id='sectionChartHeaderForm'>
		<br>
			<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center"> 
			  <tr>
				<td width='35%' class="label" ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
				<td  class="fields" width='35%' >
					<input type='text' name='chartDesc' id='chartDesc' size='20' maxlength='20' OnBlur ='getChartCode(this)' OnChange='resetValues();setValue()'><input type='button' class='button' name='buttonChart' id='buttonChart' value='?' OnClick='resetValues();getChartCode(this)'><img src="../../eCommon/images/mandatory.gif">
					
				</td>
				<td >
					<input type='button' class='button' name='buttonSearch' id='buttonSearch' value='<fmt:message key="eCA.Showdetail.label" bundle="${ca_labels}"/>' OnClick='setTimeout("searchChartSection()",1000)'>
				</td>
			 </tr>
			 </table>
			 <!-- added by arvind @ 08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->
			<input type='hidden' name='chartCode' id='chartCode' value=''>
			<input type='hidden' name='finalString' id='finalString' value=''>
			<input type='hidden' name='remove_value' id='remove_value' value=''>
			<input type='hidden' name='flag' id='flag' value='true'>
		</form>
	</body>
</html>

