<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*, eCommon.Common.*,eRS.*" %>
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
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/RSCommon.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<script src="../js/SkillForPosition.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String mode	   = request.getParameter( "mode" )==null?"":request.getParameter( "mode" );
	String position_code		=request.getParameter("position_code")==null?"":request.getParameter( "position_code" );
	ArrayList SkillData = new ArrayList();
	String slClassValue="";
	String skill_pos="";
	String[] record				= null;
	Connection con 	      = null;
	PreparedStatement pstmt	      = null;
	ResultSet rs		      = null;
	int totalRecords=0;

	try{     
		con = ConnectionManager.getConnection(request);

		//skill_pos="select a.position_code , a.skill_code skill_code, b.skill_desc skill_desc, a.mandatory_yn mandatory_yn,  'U' db_action, a.eff_status enabled from rs_skill_for_position a, rs_skill b, am_position_vw c where a.position_code =? and a.position_code = c.position_code and a.skill_code = b.skill_code union all select ? position_code, skill_code, skill_desc, 'N' mandatory_yn, 'I' db_action, 'E' enabled from rs_skill where eff_status = 'E' and skill_code not in ( select skill_code from rs_skill_for_position where position_code = ?) order by skill_desc";
		
		skill_pos="select a.position_code , a.skill_code skill_code, b.skill_desc skill_desc, a.mandatory_yn mandatory_yn,  'U' db_action, a.eff_status enabled from rs_skill_for_position a, rs_skill_lang_vw b, am_position_lang_vw c where a.position_code =? and a.position_code = c.position_code and a.skill_code = b.skill_code and b.language_id = ? and c.language_id = b.language_id union all select ? position_code, skill_code, skill_desc, 'N' mandatory_yn, 'I' db_action, 'E' enabled from rs_skill_lang_vw where eff_status = 'E' and skill_code not in ( select skill_code from rs_skill_for_position where position_code = ?) and language_id = ? order by skill_desc";

		pstmt = con.prepareStatement(skill_pos);
		pstmt.setString(1,position_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,position_code);
		pstmt.setString(4,position_code);
		pstmt.setString(5,locale);
		rs = pstmt.executeQuery() ;
		while (rs != null && rs.next()) {

			record = new String[6];
			record[0] = rs.getString( "position_code");
			record[1] = rs.getString( "skill_code");
			record[2] = rs.getString( "skill_desc");
			record[3] = rs.getString( "mandatory_yn");
			record[4] = rs.getString( "db_action");
			record[5] = rs.getString( "enabled");
			SkillData.add(record) ;
		}
   	 totalRecords=SkillData.size();

		if(totalRecords == 0){
			%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}
%>
	<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name="form_skillList" id="form_skillList" action='../../servlet/eRS.SkillForPositionServlet' method='POST' target='messageFrame'>
	<table border='1' cellpadding='0' cellspacing='0' align='center' width="100%">
<%
		for( int i=0 ; i<totalRecords ; i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}
			String[] record1 = (String[])SkillData.get(i);
			String skill_code=record1[1];
			String skill_desc=record1[2];
			String mandatory_yn=record1[3];
			String db_action=record1[4];
			
			String dbcheck="";
			String mandatory_ck="";
			String enable=record1[5]==null?"":record1[5];
			if((db_action.equalsIgnoreCase("U"))&&(enable.equals("E")))
				dbcheck="checked";
			else
				dbcheck="";

			if(mandatory_yn.equalsIgnoreCase("Y"))
				mandatory_ck="checked";
			else
				mandatory_ck="";
	%>
			 <tr>
				 <td  Align='left' class ='<%=slClassValue%>'  width='30%'><font size=2><%=skill_desc%>
				<input type="hidden" name="skill_code<%=i%>" id="skill_code<%=i%>" value="<%=skill_code%>" >
				<input type="hidden" name="skill_desc<%=i%>" id="skill_desc<%=i%>" value="<%=skill_desc%>" > </td> 
				<td  Align='left' class ='<%=slClassValue%>'  width='30%'><font size=2>
				<input type=checkbox name='mandatory_yn<%=i%>' id='mandatory_yn<%=i%>'   value="<%=mandatory_yn%>" onclick='return oncheck(this);' <%=mandatory_ck%>>
				<input type="hidden" name="db_action<%=i%>" id="db_action<%=i%>" value="<%=db_action%>" ></td>
				<td class ='<%=slClassValue%>' align='center'  width='10%'>
				<input type=checkbox name="select<%=i%>" id="select<%=i%>"value="" onclick='return oncheck(this);' <%=dbcheck%>>   </td>
			</tr>
<%
		}
%>
		</table>
<%

	 }catch(Exception e){
		e.printStackTrace() ;
		throw e ;
	}
finally{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
	ConnectionManager.returnConnection(con,request);
  }
%>
 <input type="hidden" name="position_code" id="position_code" value="<%=position_code%>" >
<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords%>" >
<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
<input type="hidden" name="formName" id="formName" value="form_skillList">
</form> 
</body>
</html>

