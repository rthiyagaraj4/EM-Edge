<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupSkillsRecord.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	23 Nov 2004.
* --%>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="javascript" src="../js/RSCommonFunction.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;

	String role_type	= request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_type	= request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String staff_id		= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String db_action	= request.getParameter("db_action")==null?"":request.getParameter("db_action");
	String index		= request.getParameter("index")==null?"":request.getParameter("index");
	String skillCode	= request.getParameter("code")==null?"": request.getParameter("code");
	String skill_desc	= request.getParameter("desc")==null?"":request.getParameter("desc");
	String level		= request.getParameter("level")==null?"":request.getParameter("level");
	String funcValue	= request.getParameter("funcValue")==null?"":request.getParameter("funcValue");
	String select		="";
	String readonly	="";
	String disabled	="";

	String Sql			="";
	String expl_txt		="";

	role_type = role_type.trim();
	staff_id = staff_id.trim();
	db_action = db_action.trim();
	index = index.trim();
	skillCode = skillCode.trim();
	skill_desc = skill_desc.trim();
	level = level.trim();
	funcValue = funcValue.trim();

	try{
		if(db_action.equalsIgnoreCase("U")){
			   Con = ConnectionManager.getConnection(request);

			//Sql="SELECT skill_expl_text FROM rs_skill WHERE skill_code = (?)";
			Sql="SELECT skill_expl_text FROM rs_skill_lang_vw WHERE skill_code = (?) and language_id = ?";
			pstmt=Con.prepareStatement(Sql);
			pstmt.setString(1,skillCode);
			pstmt.setString(2,locale);
			rslRst = pstmt.executeQuery();
				
			while(rslRst.next()){
				expl_txt= rslRst.getString( "skill_expl_text");
			}
			if(pstmt!= null)
				pstmt.close();
			if(rslRst != null)
				rslRst.close();
		}
		if(expl_txt == null)
			expl_txt =" "; 
		else 
			expl_txt = expl_txt.trim();

		if(db_action.equalsIgnoreCase("I")){
			readonly="";
			disabled="";
			skill_desc="";
			skillCode="";
			level="0";
		}else{
			readonly="readOnly";
			disabled="disabled";
		}
%>
<body  onload='onLoadValidate()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='form_profileSetupRecord' id='form_profileSetupRecord' action='../../servlet/eRS.StaffProfileSetupServlet' method='POST'
target='frameError'> 
	<table cellpadding=0 cellspacing=0 border='0' width="100%" height="100%" align="center">
	<tr>
		<td width=""  align=right class="label"><fmt:message key="eRS.Skill.label" bundle="${rs_labels}"/>&nbsp;</td>
		<td>&nbsp;&nbsp;<input type=text name="skill_text" id="skill_text" value="<%=skill_desc%>" size="25" <%=readonly%> onblur='skillLookup("T",skill_text);'><input class='button' type=button name="skill_lookup_button" id="skill_lookup_button" value="?"  onClick='skillLookup("B",skill_text);' <%=disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif">
		<input type='hidden' name='skillID' id='skillID' value='<%=skillCode%>'></td>
	
		<td width=""  align=right class="label"><fmt:message key="eRS.ProficiencyLevel.label" bundle="${rs_labels}"/>&nbsp;</td>
		<td>&nbsp;<SELECT name="prof_level" id="prof_level" onChange=''>
				<option value="">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;</option>
<% 
					int plevel=Integer.parseInt(level);
					for(int i=1;i<10;i++){
						if(plevel == i) 
							select="selected";
						else
							select="";
%>
						<option value="<%=i%>" <%=select%>>&nbsp;&nbsp;<%=i%>&nbsp;&nbsp;</option>
<% 
					}
%>
			</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>
	<tr>
		<td colspan='3'>&nbsp</td>
		<td valign='bottom' align='right'><input class='button' type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'onclick='clearSkill();'>&nbsp;<input class='button' type=button name="record" id="record" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'onClick='recordSkill()'>&nbsp;<input class='button' type=button name="delete_btn" id="delete_btn" value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>'onClick='deleteSkill()' style="visibility:hidden"></td>
	</tr>
</table>
<%
	}catch(Exception e){
		out.println("Exception in try of StaffProfileSetUpSkillRecord.jsp : "+e);
	}finally {
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		ConnectionManager.returnConnection(Con,request);
	}
%>
<input type='hidden' name='db_action' id='db_action' value='<%=db_action%>'>
<input type='hidden' name='level' id='level' value='<%=level%>'>
<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
<input type='hidden' name='staff_id' id='staff_id' value='<%=staff_id%>'>
<input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
<input type='hidden' name='funcVal' id='funcVal' value='<%=funcValue%>'>
<input type='hidden' name='task' id='task' value=''>
<input type="hidden" name="locale" id="locale" value='<%=locale%>'>
</form>
</body>
</html> 

