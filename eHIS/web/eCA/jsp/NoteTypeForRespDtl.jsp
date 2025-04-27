<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.NoteTypeForResponosibilityDetails.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// added by Arvind @  08-12-08 

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 //end

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../js/NoteTypeForResp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

	String label_desc ="" ;
	String group_by = request.getParameter("group_by");
	if(group_by == null || group_by.equals(""))group_by="";

	if(group_by.equals("RS"))
	{
		label_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");
	}else if(group_by.equals("PR"))
	{
		label_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}
	else if(group_by.equals("SP"))
	{
		label_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	}
	else if(group_by.equals("NT"))
	{
		label_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	}
	else
	{
		label_desc = "";
	}
%>
<body class='CONTENT' onLoad="" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='formNoteTypeRespDtl' id='formNoteTypeRespDtl'>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
		<td class='label' width='25%'><%=label_desc%></td>
		<td class='fields' ><input type='text'  name ='grp_by_name' id ='grp_by_name' <%if(group_by.equals("NT")) {%> onkeypress="return CheckForSpeChar(event)"<%}%>><input type='hidden' name='grp_by_code' id='grp_by_code' value=''><input type ='button' class='button' name='resp_search' id='resp_search' value='?' onclick='callRespLookup(grp_by_name,grp_by_code)'><img src="../../eCommon/images/mandatory.gif"></img></td>

	 <td align=right style='padding-right: 14px;' ><input type='button' class='button' name='search' id='search'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick = "return fetchResults();"></td>
	</tr> 
</table>
<!-- added by arvind @ 08-12-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->
<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">

<input type="hidden" name="from" id="from" value="">
<input type="hidden" name="to" id="to" value="">
<input type="hidden" name="row_count" id="row_count" value="">
<input type="hidden" name="optionValStr" id="optionValStr" value="">
</form>
</body>
</html>

