<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>

<HTML>
	<head>
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='JavaScript' src='../../eOT/js/RolesForUser.js'></script>
		<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form name="RolesForsUserDetailForm" id="RolesForsUserDetailForm" target="messageFrame">
<%
	String from = checkForNull(request.getParameter( "from" )) ;
	String to =   checkForNull(request.getParameter( "to" ) ) ;
	String user_id=checkForNull(request.getParameter("user_id"));
	String user_name=checkForNull(request.getParameter("user_name"));
	String totalSelected= checkForNull(request.getParameter("totalSelected"));
	String allowVerify= checkForNull(request.getParameter("allowVerify"));
	String select_value="Y";
	//050524
	//String applicable="";
	//String def="";
	String role_desc="";
	String role_id="";
	String role_type="";
	String sel="";
	int recordCount = 1;
	String allow_verif="";
	String select_checked="";
	String verify_select_checked="";
	String verify_select_value="";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rst=null;
	ResultSet innerRs = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst1=null;
	boolean defChkFlag = true;
	StringBuffer RecsDispBuffer = new StringBuffer();
	//String strsql = "SELECT a.role_id role_id, a.role_desc role_desc, a.role_type role_type, DECODE(b.appl_user_id, ?, b.applicability, NULL) applicability, DECODE(b.appl_user_id, ?, b.is_default, NULL) isdefault FROM ot_roles_lang_vw a,ot_roles_for_users b WHERE role_type IN (SELECT role_type FROM ot_pract_types_for_role_type WHERE pract_type IN (SELECT pract_type FROM sm_appl_user_vw  WHERE appl_user_id = ?))AND a.role_id = b.role_id(+)  AND language_id = '"+locale+"' AND appl_to_ot_slate = 'Y' ORDER BY role_type, role_desc";

	RecsDispBuffer.append("SELECT   a.role_id role_id, a.role_desc role_desc, a.role_type role_type	");
	RecsDispBuffer.append("FROM ot_roles_lang_vw a	");
	RecsDispBuffer.append("WHERE role_type IN (SELECT role_type	");
	RecsDispBuffer.append("FROM ot_pract_types_for_role_type	");
	RecsDispBuffer.append("WHERE pract_type IN (SELECT pract_type	");
	RecsDispBuffer.append("FROM sm_appl_user_vw	");
	RecsDispBuffer.append("WHERE appl_user_id = ?))	");
	RecsDispBuffer.append("AND language_id = ?		");
	RecsDispBuffer.append("AND appl_to_ot_slate = 'Y'	");
	RecsDispBuffer.append("ORDER BY role_type, role_desc	");
	int maxRecord = 0;
	int i=1;
	try
	{
 		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(RecsDispBuffer.toString());
		System.err.println("58:::user_id======="+user_id);
		pstmt.setString(1, user_id);
		pstmt.setString(2, locale);
		rst = pstmt.executeQuery();
		while(rst.next())
			maxRecord++;
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
		pstmt = conn.prepareStatement(RecsDispBuffer.toString());
		pstmt.setString(1, user_id);
		pstmt.setString(2, locale);
		rst = pstmt.executeQuery();
if(rst.isBeforeFirst())
{
%>
<table class='grid' border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
	<tr>
		<th class='columnHeaderCenter' nowrap> <fmt:message key="eOT.Roles.Label" bundle="${ot_labels}"/> </th>
		<th class='columnHeaderCenter' nowrap> <fmt:message key="eOT.RoleType.Label" bundle="${ot_labels}"/> </th>
		<th class='columnHeaderCenter' nowrap> <fmt:message key="eOT.Applicability.Label" bundle="${ot_labels}"/> </th>
		<th class='columnHeaderCenter' nowrap> <fmt:message key="eOT.IsDefault.Label" bundle="${common_labels}"/> </th>
	</tr>
	<%
			RecsDispBuffer.delete(0, RecsDispBuffer.length());
			pstmt = null;
			RecsDispBuffer.append("	SELECT applicability, is_default isdefault	");
			RecsDispBuffer.append("	FROM ot_roles_for_users	");
			RecsDispBuffer.append("	WHERE appl_user_id = ?	");
			RecsDispBuffer.append("	and ROLE_ID = ?	");
			pstmt = conn.prepareStatement(RecsDispBuffer.toString());
			int k=0;
			while(rst.next())
			{
				role_id = rst.getString("role_id");
				role_desc = rst.getString("role_desc");
				role_type = rst.getString("role_type");
				pstmt.setString(1, user_id);
				pstmt.setString(2, role_id);
				innerRs = pstmt.executeQuery();
				//050524
				String applicable="";
				String def="";
				if(innerRs.next())
				{
					applicable = innerRs.getString("applicability");
					def = innerRs.getString("isdefault");
				}
%>
			<tr>
					<input type='hidden' name='role_id_<%=recordCount%>' id='role_id_<%=recordCount%>' id='role_id_<%=recordCount%>' value="<%=role_id%>">
					<td class='gridData' nowrap><%=role_desc%></td>
					<input type='hidden' name='role_desc_<%=recordCount%>' id='role_desc_<%=recordCount%>' id='role_desc_<%=recordCount%>' value='<%=role_desc%>' />
					<!--IN:050706 -->
					<input type='hidden' name='role_type_<%=recordCount%>' id='role_type_<%=recordCount%>' id='role_type_<%=recordCount%>' value='<%=role_type%>' />
					<td class='gridData' name='role_type_<%=recordCount%>' value='<%=role_type%>' nowrap><%=role_type%></td>
					<td class='gridData' size='10'>
						<select name='role_applicable_<%=recordCount%>' id='role_applicable_<%=recordCount%>' id='role_applicable_<%=recordCount%>' onchange='callEnableRadio(this, <%=recordCount%>);'>
	<%
							if(applicable != null && applicable.equals("N"))
							{
	%>
								<option value='A'> Applicable </option>
								<option value='N' selected> NotApplicable </option>
	<%
							}
							else
							{
	%>
								<option value='A' selected> Applicable </option>
								<option value='N'> NotApplicable </option>
	<%
							}
	%>
						</select>
					</td>
					<td class='gridData' nowrap>
	<%
						if(def != null && def.equals("Y"))
						{
							defChkFlag = false;
	%>
							<input type='radio' name='chk_select_<%=recordCount%>' id='chk_select_<%=recordCount%>' id='chk_select_<%=recordCount%>' onClick='chkRadio(this, <%=recordCount%>);' checked value='Y' >
	<%
						}
						else
						{
							if(applicable != null && applicable.equals("N"))
							{
	%>
								<input type='radio' name='chk_select_<%=recordCount%>' id='chk_select_<%=recordCount%>' id='chk_select_<%=recordCount%>' onClick='chkRadio(this, <%=recordCount%>);' disabled unchecked value='N' >
	<%
							}
							else
							{
	%>
								<input type='radio' name='chk_select_<%=recordCount%>' id='chk_select_<%=recordCount%>' id='chk_select_<%=recordCount%>' onClick='chkRadio(this, <%=recordCount%>);'  unchecked value='N' >
	<%
							}
						}
	%>
					</td>
			 </tr>
	<%	
				recordCount++;
				i++;
			}
	%>
	<input type='hidden' name='totalCount' id='totalCount' id='totalCount' value="<%=recordCount%>">
</table>
<%
}
%>
<br>
<%
   }catch(Exception e){
		//out.println("RolesForsUserDetailForm: "+e);
		e.printStackTrace();
	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
	}
%>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>" >
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="execute_flag" id="execute_flag" value="YES" >
<input type="hidden" name="sel" id="sel" value="<%=select_checked%>" >
<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>" >
<input type="hidden" name="user_name" id="user_name" value="<%=user_name%>" >

<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<%//050736
		if(maxRecord == 0)
		{
			out.println("<script>disableApply();</script>");
		}

%>
</form>
</BODY>
</HTML>

