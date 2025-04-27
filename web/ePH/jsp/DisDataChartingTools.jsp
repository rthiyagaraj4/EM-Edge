<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
			
			String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../ePH/js/DisDataCharting.js' language='javascript'></SCRIPT>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

	<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<%
			String qs = request.getQueryString();

			String facilityid = (String) session.getValue("facility_id");
			String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
			String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String resp_id = (String)session.getValue("responsibility_id");
			String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
			String mode = request.getParameter("mode")==null?"":request.getParameter("mode");

    %>
			<form name="F" id="F">
			    <table cellpadding=3 cellspacing=0 width="100%">
			    <tr>
			       <td align=right>
						<input type='button' name='record' id='record' onclick="apply('<%=module_id%>','<%=mode%>');" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>"  class='button'>
						<input type='button' name='reset' id='reset' onclick="resetForm('<%=module_id%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  class='button'>
				        <input type='button' name='cancel' id='cancel' onclick="cancelform('<%=module_id%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button'>
					</td>
				</tr>
			    </table>

				<input type='hidden' name='query_string' id='query_string' value='<%=qs%>'>
			 	 <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
			 	 <input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
				 
		</form>
	</body>
</html>

