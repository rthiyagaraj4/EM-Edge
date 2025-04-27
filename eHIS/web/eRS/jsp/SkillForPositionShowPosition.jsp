<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ page import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*, eCommon.Common.*,eRS.*"%>
<%-- Mandatory declarations end --%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../js/SkillForPosition.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String mode	   = request.getParameter( "mode" )==null?"":request.getParameter( "mode" );
	String skill_code			= request.getParameter("skill_code")==null?"":request.getParameter("skill_code");
	String skill_desc	 =request.getParameter("skill_desc")==null?"":request.getParameter("skill_desc");
	String staff_type	 =request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String role_type	 =request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String position_code="";
	String position_desc="";
	String role_type_desc="";
	String staff_type_desc="";
	String mandatory_yn="";
	String db_action="";
	ArrayList PositionData = new ArrayList();
	String[] record				= null;
	String slClassValue="";
	String skill_pos="";
	Connection con 	      = null;
	PreparedStatement pstmt	      = null;
	ResultSet rs		      = null;
	int totalRecords=0;
	staff_type=staff_type.equals("")?"%":staff_type;
	role_type=role_type.equals("")?"%":role_type;

	try{
		con = ConnectionManager.getConnection(request);

		skill_pos="SELECT A.SKILL_CODE SKILL_CODE, A.POSITION_CODE POSITION_CODE, B.POSITION_DESC 		POSITION_DESC, B.ROLE_TYPE ROLE_TYPE, DECODE(B.ROLE_TYPE,'P','Practitioner','O','Other Staff') ROLE_TYPE_DESC, B.STAFF_TYPE STAFF_TYPE, STAFF_TYPE_DESC, A.MANDATORY_YN MANDATORY_YN, 'U' DB_ACTION, A.EFF_STATUS ENABLED FROM RS_SKILL_FOR_POSITION A, AM_POSITION_VW B WHERE A.SKILL_CODE=? AND A.POSITION_CODE = B.POSITION_CODE AND UPPER(B.ROLE_TYPE) LIKE UPPER(?) AND UPPER(B.STAFF_TYPE) LIKE UPPER (?) UNION ALL SELECT ? SKILL_CODE, POSITION_CODE, POSITION_DESC, ROLE_TYPE, DECODE(ROLE_TYPE,'P','Practitioner','O','Other Staff') OLE_TYPE_DESC,	STAFF_TYPE, STAFF_TYPE_DESC, 'N' MANDATORY_YN, 'I' DB_ACTION, 'E' ENABLED FROM AM_POSITION_VW WHERE EFF_STATUS = 'E' AND POSITION_CODE NOT IN  (SELECT POSITION_CODE FROM RS_SKILL_FOR_POSITION  WHERE SKILL_CODE =?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) AND UPPER(STAFF_TYPE)LIKE (?) ORDER BY ROLE_TYPE_DESC, STAFF_TYPE_DESC,POSITION_DESC";
		
		pstmt = con.prepareStatement(skill_pos);
		pstmt.setString(1,skill_code);
		pstmt.setString(2,role_type);
		pstmt.setString(3,staff_type);
		pstmt.setString(4,skill_code);
		pstmt.setString(5,skill_code);
		pstmt.setString(6,role_type);
		pstmt.setString(7,staff_type);
		rs = pstmt.executeQuery() ;

		while (rs != null && rs.next()) {
			record = new String[14];
	
			record[0] = rs.getString( "skill_code");
			record[1] = rs.getString( "position_code");
			record[2] = rs.getString( "position_desc");
			record[3] = rs.getString( "role_type");
			record[4] = rs.getString( "role_type_desc");
			record[5] = rs.getString( "staff_type");
			record[6] = rs.getString( "staff_type_desc");
			record[7] = rs.getString( "mandatory_yn");
			record[8] = rs.getString( "db_action");
			record[9] = rs.getString( "enabled");

			PositionData.add(record) ;
		}
		totalRecords=PositionData.size();
		
		if( totalRecords== 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA')); location.href='../../eCommon/html/blank.html' </script>");
		}
%>
<body>
	<form name="form_positionList" id="form_positionList" action='../../servlet/eRS.SkillForPositionServlet' method='POST' target='messageFrame'>
		<table border='1' cellpadding='0' cellspacing='0' align='center' width="100%" >
<%
		String role_desc="";
		String staff_desc="";
		for( int i=0 ; i<totalRecords ; i++ ) {
		if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}
		String[] record1 = (String[])PositionData.get(i);
		skill_code=record1[0];
		position_code=record1[1];
		position_desc=record1[2];
		role_type=record1[3];
		role_type_desc=record1[4];
		staff_type=record1[5];
		staff_type_desc=record1[6];
		mandatory_yn=record1[7];
		db_action=record1[8];
		String dbcheck="";
		String mandatory_ck="";
		String enable=record1[9]==null?"":record1[9];

		if((db_action.equalsIgnoreCase("U"))&&(enable.equalsIgnoreCase("E")))
			dbcheck="checked";
		else
			dbcheck="";

		if(mandatory_yn.equalsIgnoreCase("Y"))
			mandatory_ck="checked";
		else
			mandatory_ck="";
		if(role_type_desc.equals(role_desc))
			role_desc="";
		else 
			role_desc=role_type_desc;
	
			staff_desc=staff_type_desc;
%>
		<tr>
			 <td  Align='left' class ='<%=slClassValue%>' width='15%'><font size=2><%=role_desc%>
			<input type="hidden" name="role_type<%=i%>" id="role_type<%=i%>" value="<%=role_type%>" >
			<input type="hidden" name="role_type_desc<%=i%>" id="role_type_desc<%=i%>" value="<%=role_type_desc%>" > </td>	
			 <td  Align='left' class ='<%=slClassValue%>' width='30%'><font size=2><%=staff_desc%>
			<input type="hidden" name="staff_type<%=i%>" id="staff_type<%=i%>" value="<%=staff_type%>" >
			<input type="hidden" name="staff_type_desc<%=i%>" id="staff_type_desc<%=i%>" value="<%=staff_type_desc%>" ></td>
			 <td  Align='left' class ='<%=slClassValue%>' width='35%'><font size=2><%=position_desc%>
			<input type="hidden" name="position_code<%=i%>" id="position_code<%=i%>" value="<%=position_code%>" >
			<input type="hidden" name="position_desc<%=i%>" id="position_desc<%=i%>" value="<%=position_desc%>" >  </td>
			<td  Align='center' class ='<%=slClassValue%>' width='10%'><font size=2>
			<input type=checkbox name='mandatory_yn<%=i%>' id='mandatory_yn<%=i%>'   value="<%=mandatory_yn%>" onclick='oncheck(this)' <%=mandatory_ck%>>
			<input type="hidden" name="db_action<%=i%>" id="db_action<%=i%>" value="<%=db_action%>" ></td>
			<td class ='<%=slClassValue%>' align='center' width='15%'>
			<input type=checkbox name="select<%=i%>" id="select<%=i%>"value="" onclick='oncheck(this)' <%=dbcheck%>>   </td>
		</tr>
<%
			role_desc=role_type_desc;
			staff_desc=staff_type_desc;
	
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
<input type="hidden" name="skill_code" id="skill_code" value="<%=skill_code%>" >
<input type="hidden" name="skill_desc" id="skill_desc" value="<%=skill_desc%>" >
<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords%>" >
<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
<input type="hidden" name="formName" id="formName" value="form_positionList">
</form>
</body>
</html>

