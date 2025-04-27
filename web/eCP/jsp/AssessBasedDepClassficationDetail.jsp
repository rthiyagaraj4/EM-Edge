<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- AssessBasedDepClassificatopnDetails.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Suchilagna panigrahi
*	Created On		:	12 Jan 2004

--%>
<%-- JSP Page specific attributes start --%>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="AssessBasedDepClassification" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="AssessBasedDepMin" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
 //This file is saved on 21/12/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="JavaScript" src="../../eCP/js/AssessBasedDepClassification.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% 
  	
	Connection con=null;
	PreparedStatement pstmt3=null;
	ResultSet rset3=null ;
	PreparedStatement pstmt=null;
	ResultSet rset=null ;
	ResultSet rset1=null ;

	
	String Prev="previous";
	String Nxt="next";

	try{
	con = ConnectionManager.getConnection(request);
	
		
	String classValue="";
	String assess_note_id=request.getParameter("assess_note_id");
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
        if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
        
        String chkAttribute="",min="" ;
        
        String  req_start   =   "", req_end     =   "";
        String  checkedOnes         =   "",checkedMin="";
        String minScore="" , dependency_desc="" , dependency_level="" , dependency_code="";
		String flagSelect = request.getParameter("fromSearch");

		if(flagSelect !=null)
		{
			AssessBasedDepClassification.clearAll();
			AssessBasedDepMin.clearAll();
			String rePopulate="select dependency_code,min_score from CP_TRGD_DEP_CLSFN_AT_ASSMT where assess_note_id= ? order by 2,1";

			pstmt3=con.prepareStatement(rePopulate);
			pstmt3.setString(1,assess_note_id);
			 rset3 = pstmt3.executeQuery();

			if(rset3 !=null)
			{
				 while(rset3.next())
				 {
					AssessBasedDepClassification.putObject(rset3.getString("dependency_code"));
					min = rset3.getString("min_score");
					if(min == null) min="";
				    	AssessBasedDepMin.putObject(min);
				   }
			}
			
		}
			

        req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
        req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

        if(from != null && to != null)
        {                

                int j=0;
                for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                {
                    if(request.getParameter("chk"+(i)) != null && request.getParameter("minScore"+(i)) != null)
					{                   
                        checkedOnes = request.getParameter("chk"+(i));						
                        checkedMin=request.getParameter("minScore"+(i));
                        if(checkedMin == null) checkedMin="";                        
                        if(!AssessBasedDepClassification.containsObject(checkedOnes)) { 
                            AssessBasedDepClassification.putObject(checkedOnes);
                            AssessBasedDepMin.putObject(checkedMin);
                            }
                        j++;
 
					}
                  
                }
            out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
            out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
        }
        i = 1 ;
  
%>
</head>

<%
//	String sqlUser="SELECT  dependency_code,short_desc dependency_desc,dependency_level,TO_NUMBER(NULL) min_score,'I' db_action FROM cp_dependency WHERE dependency_code NOT IN (SELECT dependency_code FROM CP_TRGD_DEP_CLSFN_AT_ASSMT WHERE assess_note_id = ?) AND eff_status = 'E' UNION ALL SELECT  a.dependency_code,b.short_desc dependency_desc,b.dependency_level, a.min_score, 'U' db_action FROM CP_TRGD_DEP_CLSFN_AT_ASSMT a,cp_dependency b WHERE assess_note_id = ? AND b.dependency_code = a.dependency_code ORDER BY 3,2"; 
	String sqlUser="SELECT  dependency_code,short_desc dependency_desc,dependency_level,TO_NUMBER(NULL) min_score,'I' db_action FROM cp_dependency_lang_vw WHERE dependency_code NOT IN (SELECT dependency_code FROM CP_TRGD_DEP_CLSFN_AT_ASSMT WHERE assess_note_id = ?) AND eff_status = 'E' AND LANGUAGE_ID = ?  UNION ALL SELECT  a.dependency_code,b.short_desc dependency_desc,b.dependency_level, a.min_score, 'U' db_action FROM CP_TRGD_DEP_CLSFN_AT_ASSMT a,cp_dependency_LANG_VW b WHERE assess_note_id = ? AND b.dependency_code = a.dependency_code  AND B.LANGUAGE_ID = ?   ORDER BY 3,2"; 

	pstmt=con.prepareStatement(sqlUser,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

	pstmt.setString(1,assess_note_id);
	pstmt.setString(2,locale);
	pstmt.setString(3,assess_note_id);
	pstmt.setString(4,locale);
	rset=pstmt.executeQuery();

	rset.last();
	maxRecord = rset.getRow();
	rset.beforeFirst();	
%>	<body  onKeyDown="lockKey()" onLoad="FocusFirstElement();" ;onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<form name='form_AssessBaseddetail' id='form_AssessBaseddetail' action='../../eCP/jsp/AssessBasedDepClassficationDetail.jsp' method='post' >
	<table width='95%'>
	<tr>
	<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    if ( !(start <= 1)) {
	%>
	    <a href="javascript:submitPrevNext('<%=Prev%>',<%=start%>,<%=end%>)" text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/>
</a>
	
	<%
	    }
	    if ( !((start+10) > maxRecord )){
	%>
	    <a href="javascript:submitPrevNext('<%=Nxt%>',<%=start%>,<%=end%>)" text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/>
</a>
	<%
	    }
	%>
	</td>
	</tr>
	</table>

<table border='1' cellpadding='0' cellspacing='0' align='center'  width='90%' >
			<th width='30%'><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></th>
			<th width='10%'><fmt:message key="Common.Level.label" bundle="${common_labels}"/></th>
			<th width='15%'><fmt:message key="eCP.MinScore.label" bundle="${cp_labels}"/><img  src='../../eCommon/images/mandatory.gif'align='center'></img></th> 
			<th width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<%	if(rset!=null)
	{
		if ( start != 0 )
		{
		 for( int j=1; j<start; i++,j++ ){
		  rset.next() ;
		  }
		}

		 
		 while(rset.next() && i<=end )
		 {
			
			dependency_code = rset.getString("dependency_code");
			dependency_desc=rset.getString("dependency_desc");
			dependency_level=rset.getString("dependency_level");
			minScore=rset.getString("min_score");
			if(AssessBasedDepClassification.containsObject(dependency_code)) chkAttribute = "CHECKED";
			else
			chkAttribute="";
			
			int recordIndex = AssessBasedDepClassification.indexOfObject(dependency_code);
			if(recordIndex!=-1 )
			{
			if(chkAttribute.equals("CHECKED")) 
				{ 
				minScore = (String)AssessBasedDepMin.getObject(recordIndex);
				AssessBasedDepClassification.removeObject(recordIndex);
				AssessBasedDepMin.removeObject(recordIndex);
			 
				}
				
			}
				else
				{
				minScore="";
				}
	
			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
			
		%>	<tr>
				<td class='<%=classValue%>'><%=dependency_desc%></td>
				<td class='<%=classValue%>' align="right"><%=dependency_level%></td>

				<td align="center" class='<%=classValue%>'><input type='text'  name='minScore<%=i%>' id='minScore<%=i%>' size='3' maxlength='3' onblur='CheckMin(this);' onkeypress="return allowPositiveNumber()"  value=<%=minScore%>></td>

				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=dependency_code%>' onclick='clearScore(this,minScore<%=i%>);'> </td>
			</tr>
	<%		i++;
				
		}
		
	}
%>	
	</table>
		<input type=hidden name=from value='<%=start%>'>
		<input type=hidden name=to value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type='hidden' name='assess_note_id' id='assess_note_id' value="<%=assess_note_id%>" >
		<input type='hidden' name='function_name' id='function_name' value=''>
		<input type='hidden' name='dependency_code' id='dependency_code' value='<%=dependency_code%>' >
		<input type='hidden' name="maxRecord" id="maxRecord" value="<%=maxRecord%>">

		<%	}catch(Exception e){
		//	out.println(e);//COMMON-ICN-0181
            e.printStackTrace();//COMMON-ICN-0181
			}
				finally { 
	if(rset1!=null) rset1.close();
	if(rset3!=null) rset3.close();
	if(rset!=null) rset.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt3!=null) pstmt3.close();
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("AssessBasedDepClassification", AssessBasedDepClassification);
		session.setAttribute("AssessBasedDepMin", AssessBasedDepMin);
	}	
	%>
	</form>
	</body>
</html>

