<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> -->
<jsp:useBean id="associateDiagBeannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="RecordDiagnosisBeannew" class="eCA.RecordDiagnosis" scope="session"/>

<%

/*webbeans.eCommon.RecordSet associateDiagBean = (webbeans.eCommon.RecordSet)getObjectFromBean("associateDiagBean","webbeans.eCommon.RecordSet",session); 
	

	eCA.RecordDiagnosis RecordDiagnosisBean = (eCA.RecordDiagnosis)getObjectFromBean("RecordDiagnosisBean","eCA.RecordDiagnosis",session); */
%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- Added by Arvind @ 07-12-08 -->

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
		String diag_desc = "";
		//String diag_exists ="";
		String complaint_id = "";
		//String diag_code = "";
		//String diag_codedesc = "";
		String alpha = "";

		int start = 0,end = 0,chkCounter = 0,addno = 0;
		//int start1 = 0,end1 = 0;

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
		String to = request.getParameter( "to");
		//String mode = request.getParameter( "mode")==null?"":request.getParameter( "mode" ) ;
		//out.println("mode is :"+mode);
		//String add = request.getParameter( "add")==null?"":request.getParameter( "add" ) ;
		int maxRecord =0;

		if ( from == null )
			start = 1;
		else
			start = Integer.parseInt(from);
		if ( to == null )
	  		end = 13 ;
		else
			end = Integer.parseInt( to ) ;
	
	     //start1       =   start;
	     //end1         =  end;

	     int i=0;

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
		maxRecord = rs1.getInt(1);

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}

	if(rs1!=null) rs1.close();	 
	if(stmt1!=null) stmt1.close();
	
//if(from==null){


		//sql.append( "SELECT A.DIAG_SRL_NO, A.SHORT_DESC DIAG_DESC, A.DIAG_CODE DIAG_CODE, NVL ((SELECT 1 FROM CA_CHIEF_COMPLAINT_DIAG WHERE DIAG_SRL_NO=A.DIAG_SRL_NO AND COMPLAINT_ID=?),'0') DIAG_EXISTS FROM MR_ICD_CODE A WHERE A.DIAG_CODE_SCHEME=(SELECT DIAG_CODE_SCHEME FROM mr_parameter)");

		//sql.append( "select a.TERM_SET_ID, b.TERM_CODE,b.short_DESC FROM  MR_TERM_SET a,MR_TERM_CODE b,CA_CHIEF_COMP_TERM_CODE c WHERE c.complaint_id=? and b.term_set_id=c.term_set_id and c.term_code=b.term_code and a.EFF_STATUS='E' and a.term_set_id=b.term_set_id ");


		sql.append("SELECT a.TERM_SET_ID term_set_id ,b.TERM_CODE term_code,b.short_DESC term_desc,a.term_set_desc term_set_desc  FROM  MR_TERM_SET a,MR_TERM_CODE b WHERE a.EFF_STATUS='E' and a.term_set_id=b.term_set_id and a.term_set_id=?  ");
		 
		 
		if(!alpha.equals(""))
		{
			sql.append(" AND UPPER (b.short_DESC) LIKE UPPER('"+alpha+"')");
			sql.append(" ORDER BY 2 ");
		}
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1,term_set_id);
	
		rs = stmt.executeQuery();
		//associateDiagBeannew.clearAll();
	
		/*while(rs.next())
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

			//associateDiagBeannew.putObject(term_set_id1);
			//associateDiagBeannew.putObject(diag_codedesc);
			//out.println(associateDiagBeannew.putObject(term_set_id1));
			//out.println(associateDiagBeannew.putObject(diag_codedesc));
			//out.println("term_set_id1"+term_set_id1+"<br>");
			//out.println("diag_codedesc"+diag_codedesc);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();*/

		
	
//}
%>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="ChiefComplaintDiagDetailsfrm" id="ChiefComplaintDiagDetailsfrm"  method="post" action="../../eCA/jsp/ChiefComplaintDiagDetails.jsp" >
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr> <td class='white' width='88%'></td> 
	<td  align='right' width='12%' nowrap>

<%
		if ( !(start <= 1)) {
	%>
		<a class='gridLink' href='javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
		if ( !((start+14) > maxRecord )){
	%>
		<a class='gridLink'  href='javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)' text-decoration='none'>&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
	%>

</td></tr>
</table>

<table class='grid'  border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADERCENTER' width='10%' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> 

<%	
if ( start != 1 )
{
	for( int j=1; j<start; i++,j++ )
	   {
		 rs.next() ;
	   }
}
String classValue ="gridData";
String chkAttribute ="";		
String chkval = "";
String icd_code1 = "";
String icd_desc1 = "";
String icd_termdesc = "";
String icd_termid = "";
//String term_set_desc = "";

ArrayList record = RecordDiagnosisBeannew.getAllRecord(); 
//out.println("<script>alert('sizein second"+record.size()+"')</script>");


//if(end1>maxRecord)		//if it exceeds the maxrecord
	//end1=maxRecord;
	//int j=0;
	
 while(rs!=null && rs.next() && i<=end)
{
		
	//diag_srl_no = (String)associateDiagBeannew.getObject(j);
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
			
	diag_desc = diag_desc1+"~"+term_code+"~"+term_set_id1+"~"+term_set_desc1;

	//	j=j+1;
	//diag_desc = (String)associateDiagBeannew.getObject(j);
	
	String desc="";
	String desc1="";
	String desc2="";
	String termdesc2="";
	
	StringTokenizer st1 = new StringTokenizer(diag_desc,"~");
	while(st1.hasMoreTokens())
	{
			icd_desc1    = st1.nextToken();
			icd_code1    = st1.nextToken();
			icd_termid   = st1.nextToken();
			icd_termdesc   = st1.nextToken();
	}	

	if(!(icd_termid==null && icd_code1==null && icd_desc1==null)){

	String recordval = "",key = "";;
	for(int k=0;k<record.size();k++)
	{
		recordval =(String)record.get(k);

		StringTokenizer st = new StringTokenizer(recordval,"~");
		while(st.hasMoreTokens())
		{
			key = st.nextToken();
			desc = st.nextToken();
			desc1 = st.nextToken();
			desc2 = st.nextToken();
			termdesc2 = st.nextToken();

			if(icd_code1.equals(key)){
				chkAttribute="checked";
				k=record.size();	
				}
			else
				chkAttribute="";
		}
	}	
			chkval = icd_termid+"~"+icd_desc1+"~"+icd_code1+"~"+icd_termdesc;
			if ( i % 2 == 0 )
            classValue = "gridData" ;
            else
            classValue = "gridData" ;
			/*sql_desc="SELECT TERM_SET_desc term_set_desc FROM  MR_TERM_SET where term_set_id=?";
		 
		stmt_desc = con.prepareStatement(sql_desc);
		stmt_desc.setString(1,icd_termid);
			
		rs_desc = stmt_desc.executeQuery();
			
		while(rs_desc.next())
		{
			term_set_desc = rs_desc.getString("term_set_desc");
			
		}
		if(rs_desc!=null) rs_desc.close();
		if(stmt_desc!=null) stmt_desc.close();*/
						
			out.println("<tr><td class='" + classValue + "'>"+icd_termdesc+"</td>");
			out.println("<td class='" + classValue + "'>"+icd_code1+"</td>");
			out.println("<td class='" + classValue + "'>"+icd_desc1+"</td>");
			out.println("<td class='"+classValue+"' ><input type='checkbox'  "+chkAttribute +"  name='diag_exists"+chkCounter+"' id='diag_exists"+chkCounter+"'  value='"+chkval+"' onClick='CheckVal(this)'>");
			out.println("<input type='hidden'  name='chk_value"+chkCounter+"' id='chk_value"+chkCounter+"'  value='"+icd_code1+"' >");
			out.println("</td></tr>"); 
			chkCounter++;
i++;
}
}
if(rs!=null) rs.close();
if(stmt!=null)stmt.close();		 
//out.println("term_set_id1"+term_set_id1+"<br>");
//out.println("diag_desc"+diag_desc+"<br>");

//}


%>

</table>

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



