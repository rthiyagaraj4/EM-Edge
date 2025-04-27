
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="BuildLibraryTermCode" class="webbeans.eCommon.RecordSet" scope="session"/> 
<jsp:useBean id="BuildLibrary" class="webbeans.eCommon.RecordSet" scope="session"/>


<%
request.setCharacterEncoding("UTF-8");
//This file is saved on 18/10/2005.
Connection con						=		null;
PreparedStatement pstmt				=		null;
ResultSet rs						=		null;
String validate						=		request.getParameter("validate");
HashMap TermCodeData				=		new HashMap();
ArrayList TabList					=		null;
ArrayList TermCode					=		null;


ArrayList sessionList1				=		(ArrayList)BuildLibrary.getRecordSetHandle();
if(sessionList1.size()>0)
{
	TermCode=(ArrayList)BuildLibrary.getObject(0);
}

ArrayList sessionList				=		(ArrayList)BuildLibraryTermCode.getRecordSetHandle();
if(sessionList.size()>0)
{
	TermCodeData=(HashMap)BuildLibraryTermCode.getObject(0);
}

if(validate.equals("LEVEL")){
	String termSetId	=	request.getParameter("termSetid");
	String sqlData		=	"Select nature_appl_yn, proc_spec_yn, diag_spec_yn,DEFN_LEVELS,LEVEL_1_DESC,LEVEL_2_DESC,LEVEL_3_DESC,LEVEL_4_DESC,LEVEL_5_DESC,LEVEL_6_DESC,LEVEL_7_DESC,LEVEL_8_DESC,LEVEL_9_DESC,LEVEL_10_DESC from mr_term_set where term_set_id = ?";
	String levelData		=		"";
	try{
		con						=		ConnectionManager.getConnection(request);
		pstmt					=		con.prepareStatement(sqlData);
		pstmt.setString(1,termSetId);
		rs							=		pstmt.executeQuery();
		while (rs != null && rs.next()) {
			levelData			=		rs.getString("nature_appl_yn")+"||";
			levelData			=		levelData+rs.getString("proc_spec_yn")+"||";
			levelData			=		levelData+rs.getString("diag_spec_yn")+"||";
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
	}catch(Exception e){
		//out.print(e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}finally{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
    	  ConnectionManager.returnConnection(con,request);
	}
		out.println( "assignLevels(\"" + levelData + "\");") ;	

}else if(validate.equals("CODEUPDATE")){

	String code			=		request.getParameter("code");
	String flag				=		request.getParameter("flag");
	String desc				=		request.getParameter("desc");
	String termSet		=		request.getParameter("termSet");
	String tableName	=request.getParameter("tableName");
	//System.err.println("tableName"+tableName);

	String tempTermSet	=	"";
	String tempTermCode	=	"";
	
	boolean found		=	false;

	for(int j=0;j<TermCode.size();j=j+7){
			 tempTermSet	= (String)TermCode.get(j);
			 tempTermCode	= (String)TermCode.get(j+1);

			if(tempTermSet.equals(termSet) && tempTermCode.equals(code)){
				int index=TermCode.indexOf(code);
				if(flag.equals("1")){
					TermCode.set(index+2,"Y");
				} else {
					TermCode.set(index+2,"N");
				}
				found	=	true;
				break;
			}
	}
	
	if(!found) {			
			TermCode.add(termSet);
			TermCode.add(code);
			ArrayList Goal=new ArrayList();
			TermCode.add(Goal);
			TermCode.add("Y");
			TermCode.add("I");	
			TermCode.add(desc);
			TermCode.add(tableName);
						
	}


	if(TermCodeData.containsKey(termSet))
	{
		TabList=(ArrayList)TermCodeData.get(termSet);
	}else
	{
		TabList=new ArrayList();
	}
	
	if(TabList.contains(code)){
		int index=TabList.indexOf(code);
		if(flag.equals("1"))
			TabList.set(index+2,"Y");
		else
			TabList.set(index+2,"N");
		
	}else{
		TabList.add(code);
		TabList.add(desc);
		TabList.add("Y");
		TabList.add("I");

	}
	
	
	TermCodeData.put(termSet,TabList);
	
	

	}
BuildLibraryTermCode.setObject(0,TermCodeData);
//BuildLibrary.setObject(0,TermCode);

%>
