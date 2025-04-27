<!DOCTYPE html>
<%
//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*"
%>
<%@page  import="java.util.HashMap,java.util.ArrayList, eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>

<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %><html>
<head>
    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/VerifyCheckList.js"></script>
	<!-- <script src="../../eOT/js/OTMessages.js" language="javascript"></script>
    <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

	<style>
	TD.HDR{
	FONT-SIZE: 8pt ;
	COLOR:white;
	BORDER-STYLE: solid;
	height:9;
	BACKGROUND-COLOR:black;
	BORDER-BOTTOM: #CC9966 1px solid;
    BORDER-LEFT: #CC9966 1px solid;
    BORDER-RIGHT: #CC9966 1px solid;
    BORDER-TOP: #CC9966 1px solid;
	}
	</style>

</head>

<body  onKeyDown="lockKey()" >
	<form name="VerifyCheckListHeaderForm" id="VerifyCheckListHeaderForm" >
		<table cellpadding="3" cellspacing="1" width="102%" align="center" border="2">
		<%
			String no_of_verifications = request.getParameter("no_of_verifications");
			int remarks_width	= 5;
			int list_width		= 7;			
			int desc_width		= 0; 
			if(no_of_verifications.equals("4")){
				list_width		= 7;
				desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-50;
			}else if(no_of_verifications.equals("3"))
				desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-59;
			else if(no_of_verifications.equals("2"))
				desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-59;
			else if(no_of_verifications.equals("1"))
				desc_width = 100-(remarks_width+((Integer.parseInt(no_of_verifications)*list_width)))-57;

			String bean_id			 = "@VerifyCheckListBean";
			String bean_name		 = "eOT.VerifyCheckListBean";
			VerifyCheckListBean bean = (VerifyCheckListBean)mh.getBeanObject(bean_id,request,bean_name);

			// for the title headers
			//All Headers moved to VerifyCheckList.jsp for Amazon Changes.
			ArrayList roles_arr		 = new ArrayList();
			String role_id_1 = CommonBean.checkForNull(request.getParameter("role_id_1"));
			String role_id_2 = CommonBean.checkForNull(request.getParameter("role_id_2"));
			String role_id_3 = CommonBean.checkForNull(request.getParameter("role_id_3"));
			String role_id_4 = CommonBean.checkForNull(request.getParameter("role_id_4"));

			if(role_id_1!=null && !role_id_1.equals("null"))
				roles_arr.add(role_id_1);
			if(role_id_2!=null && !role_id_2.equals("null"))
				roles_arr.add(role_id_2);
			if(role_id_3!=null && !role_id_3.equals("null"))
				roles_arr.add(role_id_3);
			if(role_id_4!=null && !role_id_4.equals("null"))
				roles_arr.add(role_id_4);

		
			HashMap roles_desc = new HashMap();
			if(roles_arr.size()>0)
				roles_desc = bean.getRoleDesc(roles_arr);

			int size=roles_desc.size();
		%>

			<!-- <tr>
				<td class='columnHeaderCenter'  wrap width="<%=desc_width+"%"%>" nowrap><fmt:message key="eOT.ChecklistItem.Label" bundle="${ot_labels}"/></td> 
				<%
					if(size>0){
				%>
					<td class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap><%=(String)roles_desc.get(role_id_1)%></td> 
				<%
					}
					if(size>1){
				%>
					<td class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap><%=(String)roles_desc.get(role_id_2)%></td> 
				<%
					}
					if(size>2){
				%>
					<td class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap><%=(String)roles_desc.get(role_id_3)%></td> 
				<%
					}
					if(size>3){
				%>
					<td class='columnHeaderCenter' width="<%=list_width+"%"%>" nowrap><%=(String)roles_desc.get(role_id_4)%></td> 
				<%
					}
				%>
				<td class='columnHeaderCenter'  width="<%=remarks_width+"%"%>" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			</tr> -->
		</table>
		</form>
</body>
</html>

