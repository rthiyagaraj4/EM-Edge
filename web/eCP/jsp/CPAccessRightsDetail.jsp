<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Hema Malini B
*	Created On		:	24 Jan 2005

-->
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<script language="JavaScript" src="../../eCP/js/common.js"></script>
<%
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../js/CpMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
  <script src="../js/CPAccessRights.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 <jsp:useBean id="CPAccessRights" class="webbeans.eCommon.RecordSet" scope="session"/> 

</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String facility_id = (String)session.getAttribute("facility_id");
		ArrayList recordArray=new ArrayList();	
		ArrayList resultArray=new ArrayList();

		String chk_practitioner_id="";
		String chk_assess="";
		String chk_generate="";
		String chk_finalize="";
		String chk_revise="";
		String chk_evaluate="";
		String select_yn="Y";
		//String db_action="U";
		String chk_select="";
		String chk_action="";

		String chk_pract="";
		String chk_ass="";
		String chk_gen="";
		String chk_fin="";
		String chk_rev="";
		String chk_eval="";

		String pract_type_desc="";
		String practitioner_name="";

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
		if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
       
		String req_start=(request.getParameter("start")==null)?"1":request.getParameter("start");
		String req_end=(request.getParameter("end")==null)?"0":request.getParameter("end");

		String pract_type1=(request.getParameter("practitioner_type")==null)?"":request.getParameter("practitioner_type");

		String practitioner_name1=(request.getParameter("practitioner_name")==null)?"":request.getParameter("practitioner_name");

		String practitioner_id1=(request.getParameter("practitioner_id") == null)?"":request.getParameter("practitioner_id");


		Connection con = null;
		PreparedStatement pstmt_initial = null;
		ResultSet rs_initial = null;

		PreparedStatement pstmt=null;
		ResultSet rs=null ;

		try{
			
		con = ConnectionManager.getConnection(request);			
		String flagSelect = request.getParameter("fromSearch");

		if(flagSelect !=null){
			
			CPAccessRights.clearAll();
			String sql_initial="select a.pract_type, b.desc_userdef pract_type_desc,a.practitioner_id, a.practitioner_name pract_name,'N' assess_yn,'N' generate_cp_yn,'N' finalize_cp_yn, 'N' revise_cp_yn, 'N' evaluate_cp_yn,	'I' db_action from 	am_practitioner a, am_pract_type b, am_pract_for_facility c where	a.pract_type = nvl(?,a.pract_type) and	a.practitioner_id = nvl(?,a.practitioner_id) and (? is null or 	  (? is not null and a.practitioner_name like decode('C','S',?||'%','C','%'||?||'%','E','%'||?) )	)and a.practitioner_id not in (select practitioner_id from cp_access_rights where facility_id = ?) and a.eff_status = 'E' and    b.pract_type = a.pract_type and	c.facility_id = ? and c.practitioner_id = a.practitioner_id and c.eff_status = 'E' union all select	b.pract_type, c.desc_userdef pract_type_desc, a.practitioner_id, b.practitioner_name pract_name, a.assess_yn, a.generate_cp_yn, a.finalize_cp_yn, a.revise_cp_yn, a.evaluate_cp_yn, 'U' db_action from 	cp_access_rights a, am_practitioner b, am_pract_type c where a.facility_id = ? and	b.practitioner_id = a.practitioner_id and	b.pract_type = nvl(?,b.pract_type) and	a.practitioner_id = nvl(?,a.practitioner_id) and (? is null or (? is not null and b.practitioner_name like decode('C','S',?||'%','C','%'||?||'%', 'E','%'||? ))) and	b.eff_status = 'E' and c.pract_type = b.pract_type order by pract_type_desc, pract_name"; 


			pstmt_initial=con.prepareStatement(sql_initial);
			pstmt_initial.setString(1,pract_type1);
			pstmt_initial.setString(2,practitioner_id1);
			pstmt_initial.setString(3,practitioner_name1);
			pstmt_initial.setString(4,practitioner_name1);
			pstmt_initial.setString(5,practitioner_name1);
			pstmt_initial.setString(6,practitioner_name1);
			pstmt_initial.setString(7,practitioner_name1);
			pstmt_initial.setString(8,facility_id);
			pstmt_initial.setString(9,facility_id);
			pstmt_initial.setString(10,facility_id);
			pstmt_initial.setString(11,pract_type1);
			pstmt_initial.setString(12,practitioner_id1);
			pstmt_initial.setString(13,practitioner_name1);
			pstmt_initial.setString(14,practitioner_name1);
			pstmt_initial.setString(15,practitioner_name1);
			pstmt_initial.setString(16,practitioner_name1);
			pstmt_initial.setString(17,practitioner_name1);

			rs_initial = pstmt_initial.executeQuery();

			if(rs_initial !=null){
				while(rs_initial.next()){
						
				recordArray=new ArrayList();
				
				recordArray.add(rs_initial.getString("practitioner_id"));
				recordArray.add(rs_initial.getString("assess_yn"));
				recordArray.add(rs_initial.getString("generate_cp_yn"));
				recordArray.add(rs_initial.getString("finalize_cp_yn"));
				recordArray.add(rs_initial.getString("revise_cp_yn"));
				recordArray.add(rs_initial.getString("evaluate_cp_yn"));
				recordArray.add(rs_initial.getString("db_action"));

				if(rs_initial.getString("db_action").equals("U"))
						select_yn="Y";
				else if(rs_initial.getString("db_action").equals("I"))
					   select_yn="N";
						
		 		recordArray.add(7,select_yn);
				CPAccessRights.putObject(recordArray);
		
    			 }
			  }	
	        }
			if(from != null && to != null){
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<(Integer.parseInt(req_end)); i++){
				
			    if(request.getParameter("practitioner_id"+(i)) != null)
				{
					chk_practitioner_id	="";
					chk_assess			="";
					chk_generate        ="";
					chk_finalize		="";
					chk_revise			="";
					chk_evaluate		="";
				    chk_select          ="";
					chk_action          ="";

				 chk_practitioner_id = request.getParameter("practitioner_id"+(i));
	
				
				 if((request.getParameter("assess"+(i)))!=null)
					 chk_assess="Y";
				 else
					 chk_assess="N";
				 if((request.getParameter("generate"+(i)))!=null)
					 chk_generate="Y";
				 else
					  chk_generate="N";
	
				 if((request.getParameter("finalize"+(i)))!=null)
					   chk_finalize="Y";
				 else
					   chk_finalize="N";
				 if((request.getParameter("revise"+(i)))!=null)
					   chk_revise="Y";
				 else
					   chk_revise="N";
				 if((request.getParameter("evaluate"+(i)))!=null)
					   chk_evaluate="Y";
				else
					   chk_evaluate="N";

				 chk_action = request.getParameter("action"+(i));
				

				 if((request.getParameter("select"+(i)))!=null)
					 chk_select="Y";
				 else
					 chk_select="N";
			
		
					    resultArray=new ArrayList();
						resultArray.add(chk_practitioner_id);
						resultArray.add(chk_assess);
						resultArray.add(chk_generate);
						resultArray.add(chk_finalize);
						resultArray.add(chk_revise);
						resultArray.add(chk_evaluate);
						resultArray.add(chk_action);
						resultArray.add(chk_select);
						CPAccessRights.setObject(i,resultArray);
					
						 
				  }
				   }
     
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
     
			String classValue="";


	String sql="select a.pract_type, b.desc_userdef pract_type_desc,a.practitioner_id, a.practitioner_name pract_name,'N' assess_yn,'N' generate_cp_yn,'N' finalize_cp_yn, 'N' revise_cp_yn, 'N' evaluate_cp_yn,	'I' db_action from 	am_practitioner a, am_pract_type b, am_pract_for_facility c where	a.pract_type = nvl(?,a.pract_type) and	a.practitioner_id = nvl(?,a.practitioner_id) and (? is null or (? is not null and a.practitioner_name like decode('C',	'S',?||'%','C','%'||?||'%','E','%'||?) ))and a.practitioner_id not in (select practitioner_id from cp_access_rights where facility_id = ?) and a.eff_status = 'E' and        b.pract_type = a.pract_type and	c.facility_id = ? and c.practitioner_id = a.practitioner_id and c.eff_status = 'E' union all select	b.pract_type, c.desc_userdef pract_type_desc, a.practitioner_id, b.practitioner_name pract_name, a.assess_yn, a.generate_cp_yn, a.finalize_cp_yn, a.revise_cp_yn, a.evaluate_cp_yn, 'U' db_action from 	cp_access_rights a, am_practitioner b, am_pract_type c where a.facility_id = ? and	b.practitioner_id = a.practitioner_id and	b.pract_type = nvl(?,b.pract_type) and	a.practitioner_id = nvl(?,a.practitioner_id) and (? is null or   (? is not null and b.practitioner_name like decode('C','S',?||'%',	'C','%'||?||'%', 'E','%'||?))) and	b.eff_status = 'E' and c.pract_type = b.pract_type order by pract_type_desc, pract_name";


try{
	pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			pstmt.setString(1,pract_type1);
			pstmt.setString(2,practitioner_id1);
			pstmt.setString(3,practitioner_name1);
			pstmt.setString(4,practitioner_name1);
			pstmt.setString(5,practitioner_name1);
			pstmt.setString(6,practitioner_name1);
			pstmt.setString(7,practitioner_name1);
			pstmt.setString(8,facility_id);
			pstmt.setString(9,facility_id);
			pstmt.setString(10,facility_id);
			pstmt.setString(11,pract_type1);
			pstmt.setString(12,practitioner_id1);
			pstmt.setString(13,practitioner_name1);
			pstmt.setString(14,practitioner_name1);
			pstmt.setString(15,practitioner_name1);
			pstmt.setString(16,practitioner_name1);
			pstmt.setString(17,practitioner_name1);

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
<form name='detail_form' id='detail_form' action='../../eCP/jsp/CPAccessRightsDetail.jsp' method='post' >

<table  width='95%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>

<input type=hidden name='recordArray' id='recordArray' value='<%=recordArray%>'>

<input type='hidden' name='practitioner_type' id='practitioner_type' value='<%=pract_type1%>'>
<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practitioner_id1%>'>
<input type='hidden' name='practitioner_name' id='practitioner_name' value='<%=practitioner_name1%>'>


<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='allValues' id='allValues' value=''>


<%
    if ( !(start <= 1)) {
%>
    <a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'>Previous</a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( !((start+10) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'>Next</a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='95%' align='center'>
			
		<th width='15%'><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
		<!--<th width='15%' size='5'>Practitioner ID</th>-->
		<th width='20%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th width='10%' size='5'>Assess</th>
		<th width='10%' size='5'>Generate</th>
		<th width='10%' size='5'>Finalize</th>
		<th width='10%' size='5'><fmt:message key="Common.revise.label" bundle="${common_labels}"/></th>
		<th width='10%' size='5'>Evaluate</th>
		<th width='10%' size='5'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><br><input type='checkbox' name='selectall' id='selectall' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>
		<%	 

		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}
			while((rs.next()) && (i<=end)){ 

					recordArray=new ArrayList();
					 chk_pract="";
					 chk_ass="";
					 chk_gen="";
					 chk_fin="";
					 chk_rev="";
					 chk_eval="";
   				
			recordArray.add(rs.getString("practitioner_id"));
			recordArray.add(rs.getString("assess_yn"));
			recordArray.add(rs.getString("generate_cp_yn"));
			recordArray.add(rs.getString("finalize_cp_yn"));
			recordArray.add(rs.getString("revise_cp_yn"));
			recordArray.add(rs.getString("evaluate_cp_yn"));
			recordArray.add(rs.getString("db_action"));

			if(rs.getString("db_action").equals("U"))
						select_yn="Y";
				else if(rs.getString("db_action").equals("I"))
					   select_yn="N";
						
		 	recordArray.add(7,select_yn);

			pract_type_desc=rs.getString("pract_type_desc");
			practitioner_name=rs.getString("pract_name");
									
			 for(int k=0;k<CPAccessRights.getSize();k++)
			 {
				resultArray=(ArrayList)CPAccessRights.getObject(k);
					 								
				if(((String)recordArray.get(0)).equals((String)resultArray.get(0)))
					 {
						 if(resultArray.get(1).equals("Y"))
							 chk_ass="checked";
						 else
							 chk_ass="";

						 if(resultArray.get(2).equals("Y"))
						 	 chk_gen="checked";
						 else
							 chk_gen="";

						 if(resultArray.get(3).equals("Y"))
							 chk_fin="checked";
						 else
							 chk_fin="";

						 if(resultArray.get(4).equals("Y"))
						
							 chk_rev="checked";
						 else
							 chk_rev="";

						 if(resultArray.get(5).equals("Y"))
							 chk_eval="checked";
						 else
							 chk_eval="";

						 if(!resultArray.get(5).equals("Y"))
							 //db_action="checked";
						 //else
							 chk_eval="";

						 if(resultArray.get(7).equals("Y"))
							 chk_pract="checked";
						 else
							 chk_pract="";
						 break;
					 }
				 else
				 {
					 chk_pract="";
					 chk_ass="";
					 chk_gen="";
					 chk_fin="";
					 chk_rev="";
					 chk_eval="";
				 }
			 } //end for
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				%>
			<tr>
				<td class='<%=classValue%>' ><font size='1'><%=pract_type_desc%><font size='1'></td>
				<td class='<%=classValue%>'><font size='1'><%=practitioner_name%><font size='1'></td>
				<input type=hidden name='practitioner_id<%=(i-1)%>' id='practitioner_id<%=(i-1)%>' value='<%=recordArray.get(0)%>'>

				<td align='center' class='<%=classValue%>'><input type='checkbox' name='assess<%=(i-1)%>' id='assess<%=(i-1)%>'  value='<%=recordArray.get(1)%>' <%=chk_ass%> > 

				<td align='center' class='<%=classValue%>'><input type='checkbox' name='generate<%=(i-1)%>' id='generate<%=(i-1)%>'  value='<%=recordArray.get(2)%>' <%=chk_gen%> > 

				<td align='center' class='<%=classValue%>'><input type='checkbox' name='finalize<%=(i-1)%>' id='finalize<%=(i-1)%>'  value='<%=recordArray.get(3)%>' <%=chk_fin%> >

				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chk_rev%> name='revise<%=(i-1)%>'  value='<%=recordArray.get(4)%>' >

				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chk_eval%> name='evaluate<%=(i-1)%>'  value='<%=recordArray.get(5)%>' >
		
				<input type=hidden name='action<%=(i-1)%>' id='action<%=(i-1)%>' value='<%=recordArray.get(6)%>'>

			
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chk_pract%> name='select<%=(i-1)%>'  value='<%=recordArray.get(7)%>'> </td>
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
				  if(rs != null){ rs.close(); }
				  if(rs_initial != null){ rs_initial.close(); }
				  if(pstmt != null){ pstmt.close(); }
				  if(pstmt_initial != null){ pstmt_initial.close(); }
					    
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("CPAccessRights", CPAccessRights);

			  }%>
</table>
</form>
</body>
</html>

