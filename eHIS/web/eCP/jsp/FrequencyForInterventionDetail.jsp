<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Anuradha.P
*	Created On		:	24 March 2005

--%>
<html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="FrequencyForIntervention" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
//This file is saved on 01/12/2005.
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCP/js/FrequencyForIntervention.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String  req_start   =   "", req_end     =   "";
	String  checkedOnes         =   "";
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;

	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;

	if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }

	req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
	req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus="";
	PreparedStatement stmt3 = null;
	ResultSet rstlRs3 = null;

	effStatus=request.getParameter("effStatus");

	if(effStatus == null) effStatus="";
		PreparedStatement stmt=null;
		ResultSet rs=null ;

	Connection con = null;
	try
	{
			
	con = ConnectionManager.getConnection(request);
    String frequency_code="";

    frequency_code=request.getParameter("frequency_code");
    String flagSelect = request.getParameter("fromSearch");

	if(flagSelect !=null)
	{
	    FrequencyForIntervention.clearAll();

		String sqlinsVals= "select intervention_code from ca_intervention_freq where freq_code=? ";

    	stmt3=con.prepareStatement(sqlinsVals);
		stmt3.setString(1,frequency_code);
		rstlRs3 = stmt3.executeQuery();
		if(rstlRs3 !=null)
		{
			 while(rstlRs3.next())
			 {
				FrequencyForIntervention.putObject(rstlRs3.getString(1));
			 }
		}
	}

   if(from != null && to != null)
   {
	 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
	 {
		 if(request.getParameter("chk"+(i)) != null)
		 {
			 checkedOnes = request.getParameter("chk"+(i));
			 if(!(FrequencyForIntervention.containsObject(checkedOnes)))
			 FrequencyForIntervention.putObject(checkedOnes);
			 k++;
	     }
    }

		out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
		out.println("<input type=hidden name='totChecked' id='totChecked' value='"+k+"'>");
   }
        i = 1 ;
     
	String classValue="";
	String chkAttribute="";

//	String sql  = "SELECT intervention_code, short_desc intervention_desc,'I' db_action FROM ca_intervention WHERE intervention_code NOT IN (SELECT intervention_code FROM ca_intervention_freq WHERE freq_code = ?  ) AND eff_status = 'E' UNION ALL SELECT a.intervention_code intervention_code, b.short_desc intervention_desc,'U' db_action FROM ca_intervention_freq a, ca_intervention b WHERE a.freq_code = ? AND b.intervention_code  = a.intervention_code ORDER BY 2";
	String sql  = "SELECT intervention_code, short_desc intervention_desc,'I' db_action FROM ca_intervention_lang_Vw WHERE intervention_code NOT IN (SELECT intervention_code FROM ca_intervention_freq WHERE freq_code = ?  ) AND eff_status = 'E' and language_id = ? UNION ALL SELECT a.intervention_code intervention_code, b.short_desc intervention_desc,'U' db_action FROM ca_intervention_freq a, ca_intervention_lang_vw b WHERE a.freq_code = ? AND b.intervention_code  = a.intervention_code and b.language_id = ? ORDER BY 2";

	try
	{
	stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stmt.setString(1,frequency_code);
	stmt.setString(2,locale);
	stmt.setString(3,frequency_code);
	stmt.setString(4,locale);
	rs=stmt.executeQuery();
	rs.last();
	maxRecord = rs.getRow();
	rs.beforeFirst();
    }
	catch(Exception e)
	{
		out.println(e);
	}
%>
<body  OnMouseDown="CodeArrest();" onLoad='chkForSelectAll(<%=start%>,<%=end%>)' onKeyDown="lockKey()" class='CONTENT' >
<form name='facility_form_result' id='facility_form_result' action='../../eCP/jsp/FrequencyForInterventionDetail.jsp' method='post' >
<table  width='90%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>
<input type=hidden name='frequency_code' id='frequency_code' value='<%=frequency_code%>'>
<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='function_name' id='function_name' value='insert'>
<input type='hidden' name='allValues' id='allValues' value=''>
<%
    if ( !(start <= 1)) {
%>
<a href='javascript:submitPrevNext(<%=(start-12)%>,<%=(end-12)%>)' text-decoration='none'>Previous</a>
<input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
    }
    if ( !((start+12) >= maxRecord )){
%>
<a href='javascript:submitPrevNext(<%=(start+12)%>,<%=(end+12)%>)' text-decoration='none'>Next</a>
<input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
<th width='60%'><fmt:message key="eCP.Intervention.label" bundle="${cp_labels}"/></th>
<th width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
<%	 
	String intervention_code="";
    String intervention_desc="";
		if (start != 0)
		{
		    for(int j=1; j<=start; i++,j++)
			{
					rs.next() ;
			}
		}

		while(rs.next() && i<=end)
		{ 
		
		intervention_code=rs.getString("intervention_code");
		intervention_desc=rs.getString("intervention_desc");
	
		if(FrequencyForIntervention.containsObject(intervention_code)) 
		{
			chkAttribute = "CHECKED";
		}
		else
		{
		chkAttribute="";
		}

		int recordIndex = FrequencyForIntervention.indexOfObject(intervention_code);
		if(recordIndex!=-1)
		if(chkAttribute.equals("CHECKED")) FrequencyForIntervention.removeObject(recordIndex);


		if( i%2 == 0)  classValue="QRYEVEN";
		else
		classValue="QRYODD";
	%>
			<tr>
				<td class='<%=classValue%>'><%=intervention_desc%></td>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=intervention_code%>'> </td>
			</tr>
			<%
			i++;
			}		
		 }
			  catch(Exception e){
				 //out.print(e);//COMMON-ICN-0181
				  e.printStackTrace();//COMMON-ICN-0181
				  }
			  finally
			  {
				if(rs != null){ rs.close(); }
				if(rstlRs3 != null){ rstlRs3.close(); }
				if(stmt != null){ stmt.close(); }
				if(stmt3 != null){ stmt3.close(); }
					    
				if(con != null)
					ConnectionManager.returnConnection(con,request);
				
				session.setAttribute("FrequencyForIntervention", FrequencyForIntervention);
			  }
	%>

</table>
</form>
</body>
</html>








