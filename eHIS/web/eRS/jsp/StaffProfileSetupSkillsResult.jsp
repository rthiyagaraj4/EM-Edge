<!DOCTYPE html>
<%--
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetupCriteria.jsp
*	Purpose 		:	
*	Modified By		:	Suresh.S
*	Modified On		:	22 Nov 2004.
* --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


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
<body>
<%
	
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null; 

	String role_type	= request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id= request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String funcValue = request.getParameter("funcValue")==null?"":request.getParameter("funcValue");

	String Sql			="";
	String slClassValue	="";
	ArrayList SkillDetails		= new ArrayList() ;
	String[] record				= null;

	try{
		 Con = ConnectionManager.getConnection(request);

		//Sql="SELECT a.skill_code code,b.skill_desc description,a.proficiency_level proficiency FROM   RS_STAFF_SKILLSET a,rs_skill b WHERE a.role_type = (?) AND a.staff_id = (?) AND b.skill_code = a.skill_code ORDER BY b.skill_desc";
		Sql="SELECT a.skill_code code,b.skill_desc description,a.proficiency_level proficiency FROM   RS_STAFF_SKILLSET a,rs_skill_lang_vw b WHERE a.role_type = (?) AND a.staff_id = (?) AND b.skill_code = a.skill_code and b.language_id like ? ORDER BY b.skill_desc";
		
		pstmt=Con.prepareStatement(Sql);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);

		rslRst = pstmt.executeQuery();
			
		while(rslRst.next()&&(rslRst!=null)){
			
			record = new String[3];		
			record[0] = rslRst.getString( "code");
			record[1] = rslRst.getString( "description");
			record[2] = rslRst.getString( "proficiency");
			SkillDetails.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(rslRst != null)
			rslRst.close();
%>
<form name='formStaffProfileSetupSkillsResult' id='formStaffProfileSetupSkillsResult'>
<table cellpadding=0 cellspacing=0 border=1 width="100%" id='detailTab'>
<%
		for( int i=0 ; i< SkillDetails.size() ; i++ ) {
			if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}else{
				slClassValue = "QRYODD";
			}
			String[] record1 = (String[])SkillDetails.get(i);
			
			String code			=record1[0];
			String skill_desc	=record1[1];
			String prof_level	=record1[2];
%>
			<tr>
				 <td  Align='left' class ='<%=slClassValue%>' width='69%'><A  id='skill<%=i%>' HREF="javascript:skill_edit('<%=i%>','<%=role_type%>','<%=staff_id%>','<%=funcValue%>','<%=code%>','<%=skill_desc%>','<%=prof_level%>')"><%=skill_desc%></A>
				 <input type="hidden" name="skill_code<%=i%>" id="skill_code<%=i%>" value="<%=code%>" ></td>  

				 <td  Align='CENTER' class ='<%=slClassValue%>' width='29%'><%=prof_level%></td>  
			</tr>
<%
		 }
%>
		</table>		
<%
	}catch(Exception e){
			out.println("Exception in try of StaffProfileSetUpSkillsResult.jsp : "+e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			ConnectionManager.returnConnection(Con,request);
		}
%>
</form>
</body>
</html>

