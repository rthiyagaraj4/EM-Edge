<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String compId=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");
	String srlNo=request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String compType=request.getParameter("comp_type")==null?"":request.getParameter("comp_type");
	String compPrompt=request.getParameter("comp_prompt")==null?"":request.getParameter("comp_prompt");
	compPrompt = java.net.URLDecoder.decode(compPrompt);
	String sectionHdgCode= request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code");	
	String selectedCompIds = request.getParameter("selectedCompIds")==null?"":request.getParameter("selectedCompIds");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	
%>
<html>
<head>
	<%
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function callOnChange(obj)
		{
			var compId = document.forms[0].compId.value;
			var srlNo = document.forms[0].srlNo.value;
			var compType = document.forms[0].compType.value;
			var sectionHdgCode = document.forms[0].sectionHdgCode.value;
			var selectedCompIds = document.forms[0].selectedCompIds.value;
			var itemId = obj.value;
			//var compItemId =  compId+srlNo+itemId;
			var compItemId =  itemId;
			parent.templateLinkingDetailFrame.document.compLinkingForm.submit();
			parent.templateLinkingDetailFrame.location.href= "CASectionTemplateLinkingDetail.jsp?comp_id="+compId+"&srl_no="+srlNo+"&comp_type="+compType+"&section_hdg_code="+sectionHdgCode+"&compItemId="+compItemId+"&selectedCompIds="+selectedCompIds;
		}
		
	</script>
</head>
<body onKeyDown="lockKey()">
<form name=compLinkingHeaderForm >
	<table width='100%' border='0' cellspacing='0' cellpadding='3' >
		<tr>
			<td class="label"><fmt:message key="Common.ComponentID.label" bundle="${common_labels}"/> :<b><%=compId%></b> </td>
			<td class="label"><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/>:
			<%if(compType.equals("C")){%>
				<b><fmt:message key="eCA.CheckBox.label" bundle="${ca_labels}"/></b> </td>
				<td class="label"><fmt:message key="Common.Prompt.label" bundle="${common_labels}"/> : <b><%=compPrompt%></b> </td>
				<td class="label"><fmt:message key="Common.yes.label" bundle="${common_labels}"/><input type=radio name=yesNoBtn value=Y checked onclick="callOnChange(this)"></td>
				<td class="label"><fmt:message key="Common.no.label" bundle="${common_labels}"/><input type=radio name=yesNoBtn value=N onclick="callOnChange(this)"></td>

			<%}else if(compType.equals("L")){%>
				<b> <fmt:message key="Common.List.label" bundle="${common_labels}"/></b> </td>
				<td class="label"><fmt:message key="Common.Prompt.label" bundle="${common_labels}"/>: <b><%=compPrompt%></b> </td>
				<td class="fields">
					<select name = listItems onClick='' onchange="callOnChange(this)">
						<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>

				<%
					try
					{
						con= ConnectionManager.getConnection(request);
						String listItemId = "";
						String listItemText = "";
						String sql = "Select RESULT_VALUE , REF_RNG_DESC  from AM_DISCR_MSR_REF_RNG_LIST where DISCR_MSR_ID = ?  order by REF_RANGE_SEQ ";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1,compId);
						rs=pstmt.executeQuery();
						
						while(rs.next())
						{
							listItemId = rs.getString(1);	
							listItemText = rs.getString(2);							
							%>
								<option value="<%=listItemId%>"><%=listItemText%></option>
							<%
						}

					}
					catch(Exception e)
					{
						//out.println(e);//COMMON-ICN-0181
						 e.printStackTrace();//COMMON-ICN-0181
					}
					finally
					{
						if (rs!=null) rs.close();
						if (pstmt!=null) pstmt.close();
						if(con!=null) ConnectionManager.returnConnection(con,request);

					}
				%>
					</select></td>
			<%}%>
			
		</tr>
	</table>
	<input type=hidden name=compId value="<%=compId%>">
	<input type=hidden name=srlNo value="<%=srlNo%>">
	<input type=hidden name=compType value="<%=compType%>">
	<input type=hidden name=sectionHdgCode value="<%=sectionHdgCode%>">
	<input type=hidden name=selectedCompIds value="<%=selectedCompIds%>">
</form>
</body>
</html>

