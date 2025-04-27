
<%
/*
--------------------------------------------------------------------------------------------------------
Date			 Edit History      Name		Rev.Date	Rev.Name       Description
--------------------------------------------------------------------------------------------------------
?				100					?												created
8/1/2014	  LICN_1			Karthi			8/1/2014	Dinesh T			MMS Internal Issue.
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="TermCodeEvalMeasure" class="webbeans.eCommon.RecordSet" scope="session"/>

<%
 request.setCharacterEncoding("UTF-8");
Connection con						=		null;
PreparedStatement pstmt				=		null;
ResultSet rs						=		null;
String validate						=		request.getParameter("validate");
String termSet="";
String termCode="";
String id="";
String Desc="";
String score="";
String seq_no="";
int index=0;
int selectedRecords = 0; //  LICN_1 
ArrayList Tablist = null;
ArrayList sessionList				=		(ArrayList)TermCodeEvalMeasure.getRecordSetHandle();
if(sessionList.size()>0){
	Tablist=(ArrayList)TermCodeEvalMeasure.getObject(0);
}
//System.err.println("Tablist in validate "+Tablist);

try{
	if(validate.equals("LEVEL")){
		String termSetId	=	request.getParameter("termSetid");
		String sqlData		=	"Select nature_appl_yn, proc_spec_yn, diag_spec_yn from mr_term_set where term_set_id = ?";
		String levelData		=		"";
		con						=		ConnectionManager.getConnection(request);
		pstmt					=		con.prepareStatement(sqlData);
		pstmt.setString(1,termSetId);
		rs							=		pstmt.executeQuery();
		while (rs != null && rs.next()) {
			levelData			=		rs.getString("nature_appl_yn")+"||";
			levelData			=		levelData+rs.getString("diag_spec_yn")+"||";
			levelData			=		levelData+rs.getString("proc_spec_yn")+"||";
			}
		rs.close();
		pstmt.close();
			out.println( "assignLevels(\"" + levelData + "\");") ;	
	}
	else if(validate.equals("INSERTVALUE"))
	{
		 termSet=request.getParameter("termSet");
		 termCode=request.getParameter("termCode");
		 id=request.getParameter("id");
		 Desc=request.getParameter("Desc");
		 score=request.getParameter("score");
		 seq_no=request.getParameter("seq_no");
		 index=0;
		//System.err.println("id in validate "+id);
		if(Tablist.contains(id)){
			index=Tablist.indexOf(id);
			Tablist.set(index,id);
			Tablist.set(index+1,Desc);
			Tablist.set(index+2,score);
			Tablist.set(index+3,seq_no);
		}else{
			Tablist.add(id);
			Tablist.add(Desc);
			Tablist.add(score);
			Tablist.add(seq_no);
			Tablist.add("I");  //flag to specify the action
		}
		//System.err.println("Tablist in validate "+Tablist);
	}
	else if(validate.equals("DELETEVALUE"))
	{
		termSet=request.getParameter("termSet");
		termCode=request.getParameter("termCode");
		id=request.getParameter("id");
		//System.err.println("id in validate "+id);
		Desc=request.getParameter("Desc");
		score=request.getParameter("score");
		seq_no=request.getParameter("seq_no");
		index=0;
		String flag="";
		if(Tablist.contains(id))
		{
			index=Tablist.indexOf(id);
			flag=(String)Tablist.get(index+4);
			if(flag.equals("U"))
			{
				Tablist.set(index+4,"D");
			}
			else
			{
				Tablist.remove(index+4);
				Tablist.remove(index+3);
				Tablist.remove(index+2);
				Tablist.remove(index+1);
				Tablist.remove(index);
			}

		}
	}
	else if(validate.equals("COUNTRECORD")) { // added for LICN_1 - START
		
		if(Tablist != null) {
				if(!Tablist.isEmpty()) {
					if(Tablist.contains("I") || Tablist.contains("U")) {
						selectedRecords = Tablist.size();  //  LICN_1 
						out.println("selectedRecordCounts(\"" + selectedRecords + "\" );");
					}
					else {
						selectedRecords = 0;  //  LICN_1 
						out.println("selectedRecordCounts(\"" + selectedRecords + "\" );");
					}
				}
			}
		} // END
}catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
        e.printStackTrace();//COMMON-ICN-0181
}finally{
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close(); }
			ConnectionManager.returnConnection(con,request);
}
%>
