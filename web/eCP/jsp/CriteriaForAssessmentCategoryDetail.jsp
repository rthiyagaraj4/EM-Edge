<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>

<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!--<script language="JavaScript" src="../../eCP/js/common.js"></script>-->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/CriteriaForAssessmentCategory.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<jsp:useBean id="CriteriaForAssessmentCategory" class="webbeans.eCommon.RecordSet" scope="session"/> 
<script>
  function selectAll(Obj,start,end){
	 var assess_note_id = document.forms[0].assess_note_id.value;
	 var assess_catg_code = document.forms[0].assess_catg_code.value;
	if(Obj.checked){

		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=true;
			}
		
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='CriteriaForAssessmentCategoryDynamicValues.jsp?'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
	else{
		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=false;
			}
	
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='CriteriaForAssessmentCategoryDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
}

 function chkForSelectAll(start,end){
	if(parent.frames[2].document.forms[0].E.value == 'selectAll'){
		document.forms[0].selectall.checked=true;
		selectAll(document.forms[0].selectall,start,end)
	}
}

function submitPrevNext(from, to){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}
function assaignValue( obj){
	if(obj.checked == true)
		obj.value ='Y';
	else 
		obj.value='N';
}
</script>
</head>
<%
		ArrayList recordArray=new ArrayList();	
		ArrayList resultArray=new ArrayList();

		String chk_sec_hdg_code="";
		String chk_child_sec_hdg_code="";
		String chk_comp_id="";
		String chk_srl_no="";
		String chk_comp_type="";
		String select_yn="Y";
		String chk_select="";
		String chk_action="";
		String chk_comp="";

  	    String from = request.getParameter("from");
        String to = request.getParameter("to");

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

		String assess_note_id=request.getParameter("assess_note_id")==null?"":request.getParameter("assess_note_id");
		String assess_catg_code=request.getParameter("assess_catg_code")==null?"":request.getParameter("assess_catg_code");
  		String sec_hdg_desc="";
		String child_sec_hdg_desc="";
		String long_desc="";

		Connection con = null;
		PreparedStatement pstmt_initial = null;
		ResultSet rs_initial = null;

		PreparedStatement pstmt=null;
		ResultSet rs=null ;

		try{
			
		con = ConnectionManager.getConnection(request);			
		String flagSelect = request.getParameter("fromSearch");

		if(flagSelect !=null){
			
		CriteriaForAssessmentCategory.clearAll();
/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by 
P.Anuradha on 03/08/2005 requested by Sheelvant*/

		String sql_initial="select  a.sec_hdg_code, a.sec_hdg_desc, a.child_sec_hdg_code, a.child_sec_hdg_desc, b.comp_id, b.srl_no, d.long_desc, d.result_type comp_type,'I' db_action from  ca_note_section_view a, ca_section_template b, am_discr_msr d where a.note_type = ? and (b.sec_hdg_code = a.sec_hdg_code or b.sec_hdg_code = a.child_sec_hdg_code) and d.discr_msr_id = b.comp_id and (b.comp_id,b.srl_no) not in (select comp_id,comp_srl_no from cp_assess_crit where assess_note_id = ? and assess_catg_code=?) and d.result_type in ('L','C','N','I') union all select a.sec_hdg_code, d.sec_hdg_desc, decode(a.child_sec_hdg_code,a.sec_hdg_code,null,a.child_sec_hdg_code) child_sec_hdg_code, decode(a.child_sec_hdg_code,a.sec_hdg_code,null,g.sec_hdg_desc) child_sec_hdg_desc, a.comp_id, a.comp_srl_no srl_no, f.long_desc, f.result_type comp_type, 'U' db_action from cp_assess_crit a, ca_section_hdg d, cp_assess_catg e, am_discr_msr f, ca_section_hdg g where a.assess_note_id =? and a.assess_catg_code=? and d.sec_hdg_code = a.sec_hdg_code and g.sec_hdg_code = a.child_sec_hdg_code and e.assess_catg_code = a.assess_catg_code and f.discr_msr_id = a.comp_id order by 2,4,7"; 

			pstmt_initial=con.prepareStatement(sql_initial);
			pstmt_initial.setString(1,assess_note_id);
			pstmt_initial.setString(2,assess_note_id);
			pstmt_initial.setString(3,assess_catg_code);
			pstmt_initial.setString(4,assess_note_id);
			pstmt_initial.setString(5,assess_catg_code);
			rs_initial = pstmt_initial.executeQuery();
				

			if(rs_initial !=null)
			{
				while(rs_initial.next())
				{
				recordArray=new ArrayList();
				recordArray.add(rs_initial.getString("sec_hdg_code"));
				recordArray.add(rs_initial.getString("child_sec_hdg_code")==null?"":rs_initial.getString("child_sec_hdg_code"));
				recordArray.add(rs_initial.getString("comp_id"));
				recordArray.add(rs_initial.getString("srl_no"));
				recordArray.add(rs_initial.getString("comp_type"));
				recordArray.add(rs_initial.getString("db_action"));

				if(rs_initial.getString("db_action").equals("U"))
						select_yn="Y";
				else if(rs_initial.getString("db_action").equals("I"))
					   select_yn="N";
						
		 		recordArray.add(select_yn);		 		
				CriteriaForAssessmentCategory.putObject(recordArray);
    			 }
			  }	
	        }

			if(from != null && to != null){
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<(Integer.parseInt(req_end)); i++){
				 
				 chk_sec_hdg_code = request.getParameter("sec_hdg_code"+(i))==null?"":request.getParameter("sec_hdg_code"+(i));
				 chk_child_sec_hdg_code=request.getParameter("child_sec_hdg_code"+(i))==null?"":request.getParameter("child_sec_hdg_code"+(i));
				 chk_comp_id=request.getParameter("comp_id"+(i))==null?"":request.getParameter("comp_id"+(i));
				 chk_srl_no=request.getParameter("srl_no"+(i))==null?"":request.getParameter("srl_no"+(i));
				 chk_comp_type=request.getParameter("comp_type"+(i))==null?"":request.getParameter("comp_type"+(i));
	
				 chk_action = request.getParameter("action"+(i))==null?"":request.getParameter("action"+(i));
				 chk_select = request.getParameter("select"+(i))==null?"":request.getParameter("select"+(i));
				 if((request.getParameter("select"+(i)))!=null)
					 chk_select="Y";
				 else
					 chk_select="N";
					    resultArray=new ArrayList();
						resultArray.add(chk_sec_hdg_code);
						resultArray.add(chk_child_sec_hdg_code);
						resultArray.add(chk_comp_id);
						resultArray.add(chk_srl_no);
						resultArray.add(chk_comp_type);
						resultArray.add(chk_action);
						resultArray.add(chk_select);
						CriteriaForAssessmentCategory.setObject(i,resultArray);   					    					
				  }
				  
	             out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
        i = 1 ;
    String classValue="";
/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by 
P.Anuradha on 03/08/2005 requested by Sheelvant*/
	String sql="select  a.sec_hdg_code, a.sec_hdg_desc, a.child_sec_hdg_code, a.child_sec_hdg_desc, b.comp_id, b.srl_no, d.long_desc, d.result_type comp_type,'I' db_action from  ca_note_section_view a, ca_section_template b,am_discr_msr d where a.note_type = ? and (b.sec_hdg_code = a.sec_hdg_code or b.sec_hdg_code = a.child_sec_hdg_code) and d.discr_msr_id = b.comp_id and (b.comp_id,b.srl_no) not in (select comp_id,comp_srl_no from cp_assess_crit where assess_note_id = ? and assess_catg_code=?) and d.result_type in ('L','C','N','I') union all select a.sec_hdg_code, d.sec_hdg_desc, decode(a.child_sec_hdg_code,a.sec_hdg_code,null,a.child_sec_hdg_code) child_sec_hdg_code, decode(a.child_sec_hdg_code,a.sec_hdg_code,null,g.sec_hdg_desc) child_sec_hdg_desc, a.comp_id, a.comp_srl_no srl_no, f.long_desc, f.result_type comp_type, 'U' db_action from cp_assess_crit a, ca_section_hdg d, cp_assess_catg e, am_discr_msr f, ca_section_hdg g where a.assess_note_id =? and a.assess_catg_code=? and d.sec_hdg_code = a.sec_hdg_code and g.sec_hdg_code = a.child_sec_hdg_code and e.assess_catg_code = a.assess_catg_code and f.discr_msr_id = a.comp_id order by 2,4,7";

   try{
    pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
  	pstmt.setString(1,assess_note_id);
	pstmt.setString(2,assess_note_id);
	pstmt.setString(3,assess_catg_code);
	pstmt.setString(4,assess_note_id);
	pstmt.setString(5,assess_catg_code);
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
<form name='detail_form' id='detail_form' action='../../eCP/jsp/CriteriaForAssessmentCategoryDetail.jsp' method='post' >

<table  width='95%' border=0 align='center'>
<tr>
<td align='right' class='NONURGENT'>

<input type=hidden name='recordArray' id='recordArray' value='<%=recordArray%>'>

<input type=hidden name='assess_note_id' id='assess_note_id' value='<%=assess_note_id%>'>
<input type=hidden name='assess_catg_code' id='assess_catg_code' value='<%=assess_catg_code%>'>

<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<input type='hidden' name='allValues' id='allValues' value=''>


<%
    if ( !(start <= 1)) {
%>
    <a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='prev'>

<%
    }
    if ( !((start+10) >= maxRecord )){
%>
    <a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
    <input type=hidden name='whichPage' id='whichPage' value='next'>
<%
    }
%>
</td>
</tr>
</table>
		<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
			
		<th width='30%'><fmt:message key="Common.Section.label" bundle="${common_labels}"/></th>
			<th width='30%'><fmt:message key="eCP.SubSection.label" bundle="${cp_labels}"/></th>
			<th width='30%'><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></th>
			<th width='30%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <br><input type='checkbox' name='selectall' id='selectall' onClick='selectAll(this,<%=start%>,<%=end%>)'></th>

		
		<%	 

		if (start != 0){
			for(int j=1; j<=start; i++,j++){
				rs.next() ;
			}
		}

			String temp="";
			while((rs.next()) && (i<=end)){ 

			 recordArray=new ArrayList();
			 chk_comp="";
   				
			recordArray.add(rs.getString("sec_hdg_code"));
			recordArray.add(rs.getString("child_sec_hdg_code"));
			recordArray.add(rs.getString("comp_id"));
			recordArray.add(rs.getString("srl_no"));
			recordArray.add(rs.getString("comp_type"));
			recordArray.add(rs.getString("db_action"));

			if(rs.getString("db_action").equals("U"))
						select_yn="Y";
				else if(rs.getString("db_action").equals("I"))
					   select_yn="N";
						
		 	recordArray.add(select_yn);
            
			sec_hdg_desc=rs.getString("sec_hdg_desc");
			child_sec_hdg_desc=rs.getString("child_sec_hdg_desc");
			long_desc=rs.getString("long_desc");
			 for(int k=0;k<CriteriaForAssessmentCategory.getSize();k++)
			 {
				resultArray=(ArrayList)CriteriaForAssessmentCategory.getObject(k);
						 								
				if(((String)recordArray.get(2)).equals((String)resultArray.get(2)))
					 {
					  	 if(resultArray.get(6).equals("Y"))
							 chk_comp="checked";
						 else
							 chk_comp="";
					break;
					 }
				 else
				 {
					 chk_comp="";
				 }
			 } 
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";

				if(sec_hdg_desc.equals(temp))
					temp="&nbsp;";
				else
					temp=sec_hdg_desc;

				if(child_sec_hdg_desc==null)
				child_sec_hdg_desc="&nbsp;";
%>
			<tr>
				<td class='<%=classValue%>'><%=temp%></td>
				<td class='<%=classValue%>'><%=child_sec_hdg_desc%></td>
				<td class='<%=classValue%>'><%=long_desc%></td>
				<input type=hidden name='sec_hdg_code<%=(i-1)%>' id='sec_hdg_code<%=(i-1)%>' value='<%=recordArray.get(0)%>'>
				<input type=hidden name='child_sec_hdg_code<%=(i-1)%>' id='child_sec_hdg_code<%=(i-1)%>' value='<%=recordArray.get(1)%>'>
				<input type=hidden name='comp_id<%=(i-1)%>' id='comp_id<%=(i-1)%>' value='<%=recordArray.get(2)%>'>
				<input type=hidden name='srl_no<%=(i-1)%>' id='srl_no<%=(i-1)%>' value='<%=recordArray.get(3)%>'>
				<input type=hidden name='comp_type<%=(i-1)%>' id='comp_type<%=(i-1)%>' value='<%=recordArray.get(4)%>'>
				<input type=hidden name='action<%=(i-1)%>' id='action<%=(i-1)%>' value='<%=recordArray.get(5)%>'>
				<td align='center' class='<%=classValue%>'><input type='checkbox' <%=chk_comp%> name='select<%=(i-1)%>'  value='<%=recordArray.get(6)%>' onclick="assaignValue(this)"> </td>
			</tr>
			<%
					temp=sec_hdg_desc;
			i++;
			}		
		 }
			  catch(Exception e)
			  {
				  out.print(e);
			  }
			  finally
			  {
				  if(rs != null){ rs.close(); }
				  if(rs_initial != null){ rs_initial.close(); }
				  if(pstmt != null){ pstmt.close(); }
				  if(pstmt_initial != null){ pstmt_initial.close(); }
					    
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("CriteriaForAssessmentCategory", CriteriaForAssessmentCategory);
			  }
%>
</table>
</form>
</body>
</html>


