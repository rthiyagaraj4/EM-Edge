<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap"contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
%>
<html>
<head>
	<title><fmt:message key="eCA.EventTypeParameter.label" bundle="${ca_labels}"/></title>
	<%
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/EventTypeParam.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='event_type_param_frm' id='event_type_param_frm' method=post target="messageFrame">
<%
		try{
			
			StringBuffer sblQry = new StringBuffer();
			sblQry.append(" SELECT module_id, event_type, event_type_desc, build_cr_yn,BUILD_CR_FOR_DIRECT_REGN_YN  ");
			sblQry.append(" FROM cr_event_type_param  ");
			sblQry.append(" WHERE module_id IN ");
			sblQry.append("(SELECT module_id from sm_module WHERE install_yn = 'Y') ");

			conlCon = ConnectionManager.getConnection(request);
			pstmt = conlCon.prepareStatement(sblQry.toString());
			rslRst = pstmt.executeQuery();

%>
	<br><br>
<!-- 	<table cellpadding=3 cellspacing=0 border=1 width='100%' align='center'> -->
	<table class='grid' width='100%' align='center'> 

	<tr>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.ModuleId.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.BuildClinicalRepository.label" bundle="${ca_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.BuildClinicalRepositoryForDirectRegn.label" bundle="${ca_labels}"/></td>
	</tr>
	<%
	    //int ilRow = 0;

		String slModule_id			= "";
		String slEvent_type			= "";
		String slEvent_type_desc	= "";
		String slBuild_cr_yn		= "";
		//String slClassValue = "";
		String slClassValue = "gridData";
		String slBUILD_CR_FOR_DIRECT_REGN_YN="";
		String strDirRgnCheck = "Y";
		String strEvntBuildRep = "Y";

		int count=0;

		while(rslRst.next())
		{
			slModule_id			= rslRst.getString("module_id");
			slEvent_type		= rslRst.getString("event_type");
			slEvent_type_desc	= rslRst.getString("event_type_desc");
			slBuild_cr_yn		= rslRst.getString("build_cr_yn");

			slBUILD_CR_FOR_DIRECT_REGN_YN=rslRst.getString("BUILD_CR_FOR_DIRECT_REGN_YN");

			if(slBuild_cr_yn != null && slBuild_cr_yn.equals("Y"))
					strEvntBuildRep ="checked";
			else
					strEvntBuildRep ="";

			if(slBUILD_CR_FOR_DIRECT_REGN_YN != null && slBUILD_CR_FOR_DIRECT_REGN_YN.equals("Y"))
				strDirRgnCheck ="checked";
			else
				strDirRgnCheck ="";
			
           /* if(ilRow % 2 == 0)
                slClassValue = "QRYEVEN";
            else
                slClassValue = "QRYODD";*/

			%>
				<tr>
					<td class = '<%= slClassValue %>' align='center'> <%= slModule_id %></td>
					<td class = '<%= slClassValue %>'> <%= slEvent_type_desc %></td>
					<td class = '<%= slClassValue %>' align=center>
						<input type=checkbox name='event_type<%= count %>' id='event_type<%= count %>' value= '<%= slEvent_type %>' 
						 <%=strEvntBuildRep%>>
						<input type='hidden' name='module_id<%= count %>' id='module_id<%= count %>' value="<%= slModule_id %>">				
					</td>

					<td class = '<%= slClassValue %>' align=center>
						<input type=checkbox name='direct_regn<%= count %>' id='direct_regn<%= count %>'  value= '<%= slEvent_type %>'	<%=strDirRgnCheck%>>
					</td>			
				<%
					//ilRow = ilRow + 1;
					count=count+1;
				%>
				</tr>
			<%
		}
	%>
	</table>
	<input type=hidden name='count' id='count' value='<%= count %>'>
</form>
</body>
<%
		}
	catch(Exception e)
	{
			//out.println("Exception here -- in addEventTypeParam.jsp : "+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if (conlCon != null) ConnectionManager.returnConnection(conlCon,request);

		}
%>
</html>


