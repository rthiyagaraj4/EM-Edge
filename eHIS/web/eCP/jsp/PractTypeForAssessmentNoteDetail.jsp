<!DOCTYPE html>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="PractTypeForAssessmentNote" class="webbeans.eCommon.RecordSet" scope="session"/> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../js/PractTypeForAssessmentNote.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	 //This file is saved on 18/10/2005.
		String req_start   =   "";
		String req_end     =   "";	
        String checkedOnes         =   "";
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

		if (from == null)
			start = 0 ;
		else
			start = Integer.parseInt(from);
		if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
		req_start=(request.getParameter("start")==null)?"0":request.getParameter("start");
		req_end=(request.getParameter("end")==null)?"0":request.getParameter("end");

		String effStatus="";
		PreparedStatement pstmt3 = null;
		ResultSet rstlRs3 = null;

		effStatus=request.getParameter("effStatus");
		if(effStatus == null) 
			effStatus="";
		PreparedStatement pstmt=null;
		ResultSet rs=null ;

		Connection con = null;
		try{
			
			con = ConnectionManager.getConnection(request);			
			String assess_note_id=request.getParameter("assess_note_id");
			String pract_type = "";
			String pract_type_desc = "";
			String flagSelect = request.getParameter("fromSearch");

			if(flagSelect !=null){

				PractTypeForAssessmentNote.clearAll();
				String sqlinsVals="select pract_type from cp_assess_note_pract_type where assess_note_id= ? ";
				pstmt3=con.prepareStatement(sqlinsVals);
				pstmt3.setString(1,assess_note_id);
					 rstlRs3 = pstmt3.executeQuery();
					if(rstlRs3 !=null){
						while(rstlRs3.next()){
							PractTypeForAssessmentNote.putObject(rstlRs3.getString(1));
						 }
					}	
	        	}
	        

			if(from != null && to != null){
				int j=0;
				for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++){
					 if(request.getParameter("select"+(i)) != null){
						 checkedOnes = request.getParameter("select"+(i));
						 if(!(PractTypeForAssessmentNote.containsObject(checkedOnes)))
							 PractTypeForAssessmentNote.putObject(checkedOnes);
						 j++;
				}
			}
     
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			
	//String sql="select  pract_type, desc_userdef pract_type_desc, 'I' db_action from am_pract_type where pract_type not in(select pract_type from cp_assess_note_pract_type where assess_note_id = ?) union all select a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action from cp_assess_note_pract_type a, am_pract_type b where a.assess_note_id = ? and b.pract_type = a. pract_type order by 2";
	String sql="SELECT  pract_type, desc_userdef pract_type_desc, 'I' db_action FROM am_pract_type_LANG_VW WHERE pract_type NOT IN(SELECT pract_type FROM cp_assess_note_pract_type WHERE assess_note_id = ?) AND LANGUAGE_ID = ? UNION ALL SELECT a.pract_type pract_type, b.desc_userdef pract_type_desc, 'U' db_action FROM cp_assess_note_pract_type a, am_pract_type_LANG_VW b WHERE a.assess_note_id = ? AND b.pract_type = a. pract_type AND B.LANGUAGE_ID = ? ORDER BY 2";
			
try{
	pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt.setString(1,assess_note_id);
	pstmt.setString(2,locale);
	pstmt.setString(3,assess_note_id);
	pstmt.setString(4,locale);
	rs=pstmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
	  }catch(Exception e){
		 // out.println(e);//COMMON-ICN-0181
		  e.printStackTrace();//COMMON-ICN-0181
		  }

%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' class='CONTENT' >
<form name='formPractitionerResult' id='formPractitionerResult' action='../../eCP/jsp/PractTypeForAssessmentNoteDetail.jsp' method='post' >

<table  width=90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='assess_note_id' id='assess_note_id' value='<%=assess_note_id%>'>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='allValues' id='allValues' value=''>



<%
    if ( !(start <= 1)) {
%>
    <a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( !((start+12) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
		<tr>
			<th width='60%'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
			<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='selectall' id='selectall' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
		</tr>
		<%	 
		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}
			while(rs.next() && i<=end){ 
			pract_type=rs.getString("pract_type")==null?"":rs.getString("pract_type");
			pract_type_desc=rs.getString("pract_type_desc")==null?"":rs.getString("pract_type_desc");

			if(PractTypeForAssessmentNote.containsObject(pract_type))  
				chkAttribute = "CHECKED";
			else
				chkAttribute="";

			int recordIndex = PractTypeForAssessmentNote.indexOfObject(pract_type);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    PractTypeForAssessmentNote.removeObject(recordIndex);
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>'><%=pract_type_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='select<%=i%>'  value='<%=pract_type%>'></td>
			</tr>
			<%
			i++;
			}		
			
			
			 }
			  catch(Exception e){
				 // out.print(e);//COMMON-ICN-0181
                                   e.printStackTrace();//COMMON-ICN-0181
				  }
			  finally
			  {
				  // Added on 25/07/2003 for closing ResultSet & Statements which are not closed Properly.
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(pstmt != null){ pstmt.close(); }
				   		    if(pstmt3 != null){ pstmt3.close(); }
					    
// End of Addition on 25/07/2003 for closing ResultSet & Statements which are not closed properly.
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("PractTypeForAssessmentNote", PractTypeForAssessmentNote);

			  }%>

</table>
</form>
</body>
</html>

