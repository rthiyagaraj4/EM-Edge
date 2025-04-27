<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="associateDiagBeannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="RecordDiagnosisBeannew" class="eCA.RecordDiagnosis" scope="session"/>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/ChiefComplaintDiag.js'></script>

</head>
<%	
	Connection con = null;
	PreparedStatement stmt = null;
    ResultSet rs = null;
	//PreparedStatement stmt_desc = null;
   // ResultSet rs_desc = null;
	PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
	try
	{	StringBuffer sql =new StringBuffer();
		//String sql_desc ="";
		//String diag_srl_no = "";
//		String diag_desc = "";
		//String diag_exists ="";
		String complaint_id = "";
		//String diag_code = "";
		String diag_codedesc = "";
		String alpha = "";

		int start = 0,end = 0,chkCounter = 0,addno = 0;

		String start_end = "";
		//String chkAttribute1="",strExistingSrlNos="";
		String term_code = "";
		String term_set_id = "";
		String term_set_descc= "";
		String diag_desc1 = "";
		String term_set_id1 = "";
		String term_set_desc1 = "";
		


		con	= ConnectionManager.getConnection();
		complaint_id = request.getParameter("complaint_id");
		alpha = request.getParameter("alpha")==null?"":request.getParameter("alpha");
		term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
		term_set_descc= request.getParameter("term_set_descc")==null?"":request.getParameter("term_set_descc");
		String id = request.getParameter("id")==null?"":request.getParameter("id");
		String searchWith = request.getParameter("searchWith")==null ? "" : request.getParameter("searchWith");
		
		start_end = request.getParameter("start_end")==null?"":request.getParameter("start_end");
		String from = request.getParameter( "from");
/*		String to = request.getParameter( "to");
		String mode = request.getParameter( "mode")==null?"":request.getParameter( "mode" ) ;
		//out.println("mode is :"+mode);
	String add = request.getParameter( "add")==null?"":request.getParameter( "add" ) ;
	
	int i=0;*/

		//PreparedStatement pstmtExisting = null;
		//ResultSet rsExisting = null;
		
		
		StringBuffer countsql = new StringBuffer();
		countsql.append("SELECT count(*) total FROM  MR_TERM_SET a,MR_TERM_CODE b WHERE a.EFF_STATUS='E' and a.term_set_id=b.term_set_id and a.term_set_id=? ");

		if(alpha==null || alpha.equals(""))
		{
				alpha = "%";
		}
		else if(searchWith.equals("S")){
			alpha = alpha.toUpperCase()+"%";
		}else if(searchWith .equals( "E")){
			alpha = "%"+alpha.toUpperCase();
		}else if(searchWith.equals( "C")){
			alpha = "%"+alpha.toUpperCase() +"%";
		}
		
		
		//String alpha1 = toUpperCase(alpha);
		if(!alpha.equals(""))
		{
			countsql.append(" AND UPPER (b.short_DESC) LIKE UPPER('"+alpha+"')");
		}
		//countsql.append(" ORDER BY 2 ");
		
		stmt1 = con.prepareStatement(countsql.toString());
		stmt1.setString(1,term_set_id);
		rs1 = stmt1.executeQuery();

		rs1.next();
		int maxRecord = rs1.getInt(1);

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}

	if(rs1!=null) rs1.close();	 
	if(stmt1!=null) stmt1.close();
	
if(from==null){


		
		sql.append("SELECT a.TERM_SET_ID term_set_id ,b.TERM_CODE term_code,b.short_DESC term_desc,a.term_set_desc term_set_desc  FROM  MR_TERM_SET a,MR_TERM_CODE b WHERE a.EFF_STATUS='E' and a.term_set_id=b.term_set_id and a.term_set_id=?  ");
		 
		 
		if(!alpha.equals(""))
		{
			sql.append(" AND UPPER (b.short_DESC) LIKE UPPER('"+alpha+"')");
			sql.append(" ORDER BY 2 ");
		}
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1,term_set_id);
	
		rs = stmt.executeQuery();
		associateDiagBeannew.clearAll();
	
		while(rs.next())
		{
			term_set_id1 = rs.getString("term_set_id");
			term_code = rs.getString("term_code");
			diag_desc1 = rs.getString("term_desc");
			term_set_desc1 = rs.getString("term_set_desc");

			
				if(term_set_id1 == null)
				term_set_id1 ="";  
			
			
			if(diag_desc1 == null)
				diag_desc1 ="";
			
			if(term_code == null)
				term_code ="";
			if(term_set_desc1 == null)
				term_set_desc1 ="";
			
			diag_codedesc = diag_desc1+"~"+term_code+"~"+term_set_id1+"~"+term_set_desc1;

			associateDiagBeannew.putObject(term_set_id1);
			associateDiagBeannew.putObject(diag_codedesc);
			//out.println(associateDiagBeannew.putObject(term_set_id1));
			//out.println(associateDiagBeannew.putObject(diag_codedesc));
			//out.println("term_set_id1"+term_set_id1+"<br>");
			//out.println("diag_codedesc"+diag_codedesc);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		
	
}

%>

<input type='hidden' name=complaint_id value='<%=complaint_id%>'></input>
<input type='hidden' name=alpha value='<%=alpha%>'></input>
<input type='hidden' name=term_set_id value='<%=term_set_id%>'></input>
<input type='hidden' name=from value='<%=start%>'></input>
<input type='hidden' name=to value='<%=end%>'></input>
<input type='hidden' name=start_end value='<%=addno%>'></input>
<input type='hidden' name=id value='<%=id%>'></input>
<input type='hidden' name=count value='<%=chkCounter%>'></input>
</form>
</body>

<%	
	}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
			finally
			{	
					if(stmt1!=null) stmt1.close();
					if(rs1!=null) rs1.close();
					if(con!=null)ConnectionManager.returnConnection(con,request);
			}	
%>

</html>



