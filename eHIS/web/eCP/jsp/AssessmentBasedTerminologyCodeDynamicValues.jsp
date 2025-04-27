
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="TerminologyCode" class="webbeans.eCommon.RecordSet" scope="session"/> 

<%
request.setCharacterEncoding("UTF-8");
Connection con						=		null;
PreparedStatement pstmt				=		null;
ResultSet rs						=		null;
String validate						=		request.getParameter("validate");
ArrayList TabList					=		null;
ArrayList sessionList				=		(ArrayList)TerminologyCode.getRecordSetHandle();
	 //This file is saved on 18/10/2005.
if(sessionList.size()>0)
{
	TabList=(ArrayList)TerminologyCode.getObject(0);
}else{
	TabList=new ArrayList();
	TerminologyCode.putObject(TabList);
}
try{
if(validate.equals("LEVEL")){

	String termSetId	=	request.getParameter("termSetid");
	String sqlData		=	"Select nature_appl_yn, proc_spec_yn, diag_spec_yn,DEFN_LEVELS,LEVEL_1_DESC,LEVEL_2_DESC,LEVEL_3_DESC,LEVEL_4_DESC,LEVEL_5_DESC,LEVEL_6_DESC,LEVEL_7_DESC,LEVEL_8_DESC,LEVEL_9_DESC,LEVEL_10_DESC from mr_term_set where term_set_id = ?";
	String levelData		=		"";
	con						=		ConnectionManager.getConnection(request);
	pstmt					=		con.prepareStatement(sqlData);
	pstmt.setString(1,termSetId);
	rs							=		pstmt.executeQuery();
	while (rs != null && rs.next()) {
		levelData			=		rs.getString("nature_appl_yn")+"||";
		levelData			=		levelData+rs.getString("diag_spec_yn")+"||";
		levelData			=		levelData+rs.getString("proc_spec_yn")+"||";
		levelData			=		levelData+rs.getString("DEFN_LEVELS")+"||";
		levelData			=		levelData+rs.getString("LEVEL_1_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_2_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_3_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_4_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_5_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_6_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_7_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_8_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_9_DESC")+"||";
		levelData			=		levelData+rs.getString("LEVEL_10_DESC")+"||";
	}
	rs.close();
	pstmt.close();
		out.println( "assignLevels(\"" + levelData + "\");") ;	


}else if(validate.equals("TERMINOLOGYCODE")){

	String code			=		request.getParameter("code");
	String flag				=		request.getParameter("flag");
	//String alphaLink		=		request.getParameter("alphaLink");
		
	if(flag.equals("1")){
		TabList.add(code);
	}else{
		if(TabList.contains(code)){
			TabList.remove(code);	
		}
	}

}else if(validate.equals("SELECTALL")){

	String classificationLevel1				=		request.getParameter("classificationLevel");
	int classificationLevel						=		Integer.parseInt(classificationLevel1);
	String assessmentCategoryCode		=		request.getParameter("assessmentCategoryCode");
	String terminologySetId					=		request.getParameter("terminologySetId");
	String type										=		request.getParameter("type");
	String flag										=		request.getParameter("flag");
	String alphalink								=		request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
	alphalink										=		alphalink.trim();
	String sqlData		="";
	con	=		ConnectionManager.getConnection(request);

	if(alphalink.equals("Associated")){
		sqlData="Select a.term_set_id, a.term_code, b.short_desc, 'U' db_action from      CP_TRGD_TERM_CODE_AT_ASSMT a, mr_term_code b where a.ASSESS_CATG_CODE = ? and  b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' )) and a.term_set_id = ? and b.code_level =? order by 3";

		pstmt	=  con.prepareStatement(sqlData);
		pstmt.setString(1,assessmentCategoryCode);
		pstmt.setString(2,type);
		pstmt.setString(3,type);
		pstmt.setString(4,terminologySetId);
		pstmt.setInt(5,classificationLevel);
	}else{
	 sqlData="select term_set_id, term_code, short_desc, 'I' db_action from mr_term_code where term_set_id = ? and code_level = ? and (( ? = 'PR' and procedure_yn = 'Y' ) or(? = 'DX' and diagnosis_yn = 'Y' )) and ((? is not null and upper(short_desc) like ?) or (? is null and substr(upper(short_desc),1,1) not between 'A' and 'Z')) and (term_set_id, term_code) not in (select term_set_id,term_code from CP_TRGD_TERM_CODE_AT_ASSMT where ASSESS_CATG_CODE = ?) union all select     a.term_set_id, a.term_code, b.short_desc, 'U' db_action from       CP_TRGD_TERM_CODE_AT_ASSMT a, mr_term_code b where a.ASSESS_CATG_CODE = ? and   b.term_set_id = a.term_set_id and b.term_code = a.term_code and (( ? = 'PR' and b.procedure_yn = 'Y' ) or ( ? = 'DX' and b.diagnosis_yn = 'Y' )) and ((? is not null and upper(b.short_desc) like ?) or ( ? is null and substr(b.short_desc,1,1) not between 'A' and 'Z')) and b.code_level = ? order by 3";
	

	
	pstmt	=	con.prepareStatement(sqlData);
	
	
		pstmt.setString(1,terminologySetId);
		pstmt.setInt(2,classificationLevel);
		pstmt.setString(3,type);
		pstmt.setString(4,type);
		pstmt.setString(5,alphalink);
		pstmt.setString(6,alphalink+"%");
		pstmt.setString(7,alphalink);
		pstmt.setString(8,assessmentCategoryCode);
		pstmt.setString(9,assessmentCategoryCode);
		pstmt.setString(10,type);
		pstmt.setString(11,type);
		pstmt.setString(12,alphalink);
		pstmt.setString(13,alphalink+"%");
		pstmt.setString(14,alphalink);
		pstmt.setInt(15,classificationLevel);
	}
	rs	=	pstmt.executeQuery();

	if(rs!=null)
	{
		while(rs.next()){
			String code	= rs.getString("term_code");
		if(flag.equals("1")){
			if(!(TabList.contains(code))){
				TabList.add(code);
			}
		}else
		{
			if(TabList.contains(code)){
				int index	=	TabList.indexOf(code);
				TabList.remove(index);
			}
		}
	}
			
	}
	rs.close();
	pstmt.close();
}
}catch(Exception e){
	out.print(e);
}finally{
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
			ConnectionManager.returnConnection(con,request);
}
%>
