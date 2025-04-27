<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- TerminologyCodeForCaseTypeDetail.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Suchilagna panigrahi
*	Created On		:	24 Jan 2005

--%>
<%-- JSP Page specific attributes start --%>
<html>
<%@page import="eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" %>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="TermCodeForCaseType" class="webbeans.eCommon.RecordSet" scope="session"/>

<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 18/10/2005.
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script> 
<script language="JavaScript" src="../../eCP/js/TerminologyCodeForCaseType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<% 
  	
	Connection con=null;
	String classValue="";
	String term_set_id="";
	String checked="";
	String type="";
	String case_type_code="";
	String nature_appl_yn="";
	String case_type_nature="";
	String sql_associated="";
	String term_code="" , short_desc="" , mandatory_yn="" , potential_yn="" , actual_yn="", select_val="";
	String wellness_yn="";
	String search_criteria="" ,search_text="", selected="";
	String[] fields=null;
	Statement stmt_Associated=null;
	PreparedStatement stmt_nature	= null;
	PreparedStatement stmt_case_type	= null;
	//Statement stmt_nature=null;
	//Statement stmt_case_type=null;


	String sql_nature="";
	String sql_case_type="";

	String from = request.getParameter("from");
	String to = request.getParameter("to") ;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=0;

	String chkAttribute="" ,disabled="";
	String dbaction="";
	String  req_start   =   "", req_end     =   "" ;
	String  checkedOnes =   "";

	String alphalink ="";
	String temp_code="";
	String mand ="";
	String nature="";
	String code="";

	
	ResultSet rset_Associated=null ;
	ResultSet rset_nature=null ;
	ResultSet rset_case_type=null ;

	try{
	con = ConnectionManager.getConnection(request);

		term_set_id=request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
		case_type_code=request.getParameter("case_type_code")==null ? "":request.getParameter("case_type_code");
		type=request.getParameter("type")== null?"":request.getParameter("type");
		short_desc=request.getParameter("short_desc")== null?"":request.getParameter("short_desc");
		search_criteria=request.getParameter("search_criteria")== null?"":request.getParameter("search_criteria");
	 if(search_criteria.equals("S"))
				 search_text = short_desc +"%";
     else if(search_criteria.equals("E"))
             	 search_text ="%"+short_desc;
   	 else if(search_criteria.equals("C"))
   		   		 search_text = "%"+short_desc+"%";
   	 else
                 search_text = "%";

	// sql_nature="Select nature_appl_yn from mr_term_set where term_set_id='"+term_set_id+"'";
	sql_nature="Select nature_appl_yn from mr_term_set where term_set_id=?";
	stmt_nature=con.prepareStatement( sql_nature);
	stmt_nature.setString(1,term_set_id);
	//stmt_nature=con.createStatement();
			rset_nature = stmt_nature.executeQuery();
			if(rset_nature !=null)
			{
				 while(rset_nature.next())
				 {
					  nature_appl_yn= rset_nature.getString("nature_appl_yn")==null ? "":rset_nature.getString("nature_appl_yn");
				  }
			}
 //sql_case_type="Select case_type_nature from cp_case_type where case_type_code = '"+case_type_code+"'";
 sql_case_type="Select case_type_nature from cp_case_type where case_type_code = ?";
 stmt_case_type=con.prepareStatement( sql_case_type);
 	stmt_case_type.setString(1,case_type_code);

//stmt_case_type=con.createStatement();
			rset_case_type = stmt_case_type.executeQuery();
			if(rset_case_type !=null)
			{
				 while(rset_case_type.next())
				 {
					  case_type_nature= rset_case_type.getString("case_type_nature")==null ? "":rset_case_type.getString("case_type_nature");
				  }
			}
			

	
        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 7; }   else {  end = Integer.parseInt( to ) ; }
        
               
        req_start       =   request.getParameter("start")==null ?"0" : request.getParameter("start");
        req_end         =   request.getParameter("end")==null ? "0" : request.getParameter("end");
		
 alphalink = request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
//out.println("alphalink "+alphalink);
if(alphalink.equals("*"))
		{
			alphalink="_";
		}
%>
</head>
<body  onKeyDown="lockKey()" onLoad="FocusFirstElement();" ;onKeyDown = 'lockKey()';  OnMouseDown="CodeArrest()">
<form name='form_Terminologydetail' id='form_Terminologydetail' action="../../eCP/jsp/TerminologyCodeForCaseTypeDetail.jsp" method='post' >
	
<%	
	ArrayList TabList		= null;
	ArrayList sessionList			=  (ArrayList)TermCodeForCaseType.getRecordSetHandle();

if(sessionList.size()>0)
{
	//TabList=(ArrayList)TermCodeForCaseType.getObject(0);
}

		if(from != null && to != null){
			//int j=0;
			for(int j=(Integer.parseInt(req_start)); j<=(Integer.parseInt(req_end)); j++){
				 if(request.getParameter("chk"+(j)) != null){
					 checkedOnes = request.getParameter("chk"+(j));

					int index=-1;
					if(TermCodeForCaseType != null){
						for(int k=0;k<TermCodeForCaseType.getSize();k++){
							TabList=new ArrayList();
							TabList=(ArrayList)TermCodeForCaseType.getObject(k);
							 temp_code=(String)TabList.get(0);
							if(temp_code.equals(checkedOnes)){
								index=k;
								break;
							}
						}
						if(index != -1)
							TermCodeForCaseType.removeObject(index);
					}
					//if(!TabList.contains(checkedOnes)){
						TabList=new ArrayList();
						TabList.add(checkedOnes);
						 mand = request.getParameter("mandatory_yn"+j)==null?"N":request.getParameter("mandatory_yn"+j);
						TabList.add(mand);
						 nature = request.getParameter("nature"+j)==null?"":request.getParameter("nature"+j);
				//out.println(req_start+" - "+req_end+mand+nature+" test b"+request.getParameter("chk"+(i)));
						char nat=' ';
						if(!nature.equals(""))
							nat=nature.charAt(0);
						switch(nat){
							case 'A':
								TabList.add("Y");
								TabList.add("N");
								TabList.add("N");
								break;
							case 'P':
								TabList.add("N");
								TabList.add("Y");
								TabList.add("N");
								break;
							case 'B':
								TabList.add("Y");
								TabList.add("Y");
								TabList.add("N");
								break;
							case 'W':
								TabList.add("N");
								TabList.add("N");
								TabList.add("Y");
								break;
							default:
								TabList.add("Y");
								TabList.add("Y");
								TabList.add("N");
								break;
						}
						select_val=request.getParameter("nature"+j)==null?"":request.getParameter("nature"+j);
						TabList.add(select_val);
						//out.println("prev "+TabList);
						TermCodeForCaseType.putObject(TabList);
					//}
				}
			}
		}

		if(alphalink.equals("Associated"))
		{
			if(type.equals("PR"))
			{
			 sql_associated="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_p_"+term_set_id+"_vw b WHERE a.case_type_code = '"+case_type_code+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code ORDER BY 3";
			}
			else
			{
			sql_associated="SELECT a.term_set_id, a.term_code term_code, b.short_desc short_desc,a.actual_yn actual_yn,a.potential_yn potential_yn,a.wellness_yn wellness_yn,a.mandatory_yn mandatory_yn,'U' db_action FROM cp_term_code_for_case_type a, mr_d_"+term_set_id+"_vw b WHERE a.case_type_code = '"+case_type_code+"' and  b.term_set_id = a.term_set_id AND b.term_code = a.term_code ORDER BY 3";
			}
		}
		else
		{
			if(type.equals("PR"))
			{
			 sql_associated="select term_set_id, term_code, short_desc, actual_yn, potential_yn, wellness_yn, 'N' mandatory_yn,'I' db_action from mr_p_"+term_set_id+"_vw where term_set_id = '"+term_set_id+"' and ((('"+nature_appl_yn+"' = 'Y' and ('"+case_type_nature+"' = 'I' and (actual_yn = 'Y' or potential_yn = 'Y')) or ('"+case_type_nature+"' = 'W' and (wellness_yn = 'Y'))))) and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(short_desc,1,1)) = upper('"+alphalink+"') and upper(short_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and substr(short_desc,1,1) not between 'A' and 'Z' and upper(short_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(short_desc) like upper('"+alphalink+"' || '"+search_text+"'))) and (term_set_id, term_code) not in (select term_set_id,term_code from cp_term_code_for_case_type where case_type_code = '"+case_type_code+"') union all select a.term_set_id, a.term_code, b.short_desc , b.actual_yn, b.potential_yn, b.wellness_yn,a.mandatory_yn,'U' db_action from cp_term_code_for_case_type a, mr_p_"+term_set_id+"_vw b where a.case_type_code = '"+case_type_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code  and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(short_desc,1,1)) = upper('"+alphalink+"') and upper(short_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and substr(short_desc,1,1) not between 'A' and 'Z' and upper(short_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(short_desc) like upper('"+alphalink+"' || '"+search_text+"'))) order by 3 "; 
			}
			else
			{
				sql_associated="select term_set_id, term_code, short_desc, actual_yn, potential_yn, wellness_yn, 'N' mandatory_yn,'I' db_action from mr_d_"+term_set_id+"_vw where term_set_id = '"+term_set_id+"' and ((('"+nature_appl_yn+"' = 'Y' and ('"+case_type_nature+"' = 'I' and (actual_yn = 'Y' or potential_yn = 'Y')) or ('"+case_type_nature+"' = 'W' and (wellness_yn = 'Y'))))) and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(short_desc,1,1)) = upper('"+alphalink+"') and upper(short_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and substr(short_desc,1,1) not between 'A' and 'Z' and upper(short_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(short_desc) like upper('"+alphalink+"' || '"+search_text+"'))) and (term_set_id, term_code) not in (select term_set_id,term_code from cp_term_code_for_case_type where case_type_code = '"+case_type_code+"') union all select a.term_set_id, a.term_code, b.short_desc , b.actual_yn, b.potential_yn, b.wellness_yn,a.mandatory_yn,'U' db_action from cp_term_code_for_case_type a, mr_d_"+term_set_id+"_vw b where a.case_type_code = '"+case_type_code+"' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and (('"+alphalink+"' is not null and '"+alphalink+"' between 'A' and 'Z' and upper(substr(short_desc,1,1)) = upper('"+alphalink+"') and upper(short_desc) like upper('"+search_text+"'))or ('"+alphalink+"' is not null and '"+alphalink+"' not between 'A' and 'Z' and substr(short_desc,1,1) not between 'A' and 'Z' and upper(short_desc) like upper('"+search_text+"')) or ('"+alphalink+"' is null and upper(short_desc) like upper('"+alphalink+"' || '"+search_text+"'))) order by 3 "; 
			}
		}
		//out.println(sql_associated);
		stmt_Associated=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rset_Associated=stmt_Associated.executeQuery(sql_associated);
	rset_Associated.last();
	maxRecord = rset_Associated.getRow();
	rset_Associated.beforeFirst();
	if(maxRecord > 0){	
%>

		<script>
			parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?';
		</script>
	<table width='97%'>
	<tr>
	<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    if ( !(start <= 1)) {
	%>
	   <a href='javascript:submitPrevNext(<%=(start-7)%>,<%=(end-7)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
	
	<%
	    }
	    if ( !((start+7) > maxRecord )){
	%>
	    <a href='javascript:submitPrevNext(<%=(start+7)%>,<%=(end+7)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<%
	    }
	%>
	</td>
	</tr>
	 <table>

<table border='1' cellpadding='0' cellspacing='0' align='center'  width='98%' >
			<th width='13%'><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></th>
			<th width='30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<th width='7%'><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th> 
			<th width='10%'><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
			<th width='7%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><BR><INPUT type="checkbox" name="chkAll" id="chkAll"  <%=checked%> onclick="selectAll(this);"></th>

<%if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rset_Associated.next() ;
	}
}
//out.println("start "+start+ " i->"+i+" - "+end);
while(rset_Associated.next() && i< end){

			term_code = rset_Associated.getString("term_code");
			short_desc=rset_Associated.getString("short_desc");
			actual_yn=rset_Associated.getString("actual_yn");
			potential_yn=rset_Associated.getString("potential_yn");
			wellness_yn=rset_Associated.getString("wellness_yn");
			dbaction=rset_Associated.getString("db_action");
			mandatory_yn=rset_Associated.getString("mandatory_yn");
//out.println("QUERY "+term_code+" act-> "+actual_yn+" pot-> "+potential_yn+" wel-> "+wellness_yn+" nature ->" +nature_appl_yn+" case -> "+case_type_nature);
	if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
			disabled="";
				
			if(dbaction.equals("U")){
				if(alphalink.equals("Associated")){
						disabled="";
						
				}
				else
					disabled="Disabled";
			}
			int index=-1;
			for(int j=0; j<TermCodeForCaseType.getSize();j++){
				ArrayList temp_list = (ArrayList)TermCodeForCaseType.getObject(j);
				 code=(String)temp_list.get(0);
				if(code.equals(term_code)){
					index=j;
					break;
				}
			}
			if(index!=-1){
				chkAttribute="checked";
				TabList = (ArrayList)TermCodeForCaseType.getObject(index);
				mandatory_yn=(String)TabList.get(1);
				actual_yn=(String)TabList.get(2);
				potential_yn=(String)TabList.get(3);
				wellness_yn=(String)TabList.get(4);
				select_val=(String)TabList.get(5)==null?"":(String)TabList.get(5);
				//TermCodeForCaseType.removeObject(index);
//out.println("BEAN code "+term_code+"na ->"+nature_appl_yn+"CTN "+case_type_nature+actual_yn+ "->"+potential_yn+" ->"+wellness_yn+"->"+select_val);
		}
			else{
				TabList=null;
				chkAttribute="";
				select_val="";
			}
			
%>
	<tr>
				<td class='<%=classValue%>'><%=term_code%></td>
				<td class='<%=classValue%>' align="left"><%=short_desc%></td>
			<%if(mandatory_yn.equals("Y")){%>
				<td align="center" class='<%=classValue%>'><input type='checkbox'  name='mandatory_yn<%=i%>' id='mandatory_yn<%=i%>' value='<%=mandatory_yn%>' <%=disabled%> <%=chkAttribute%> onclick='checkValue(this);'></td>
			<%}else{%>
				<td align="center" class='<%=classValue%>'><input type='checkbox'  name='mandatory_yn<%=i%>' id='mandatory_yn<%=i%>' value='<%=mandatory_yn%>' onclick='checkValue(this);'></td>
			<%}%>
				<%if(nature_appl_yn.equals("Y")){
					if(case_type_nature.equals("W")){
						if(wellness_yn.equals("Y")){
					%>
				<td align="center" class='<%=classValue%>'>
					<select name='nature<%=i%>' id='nature<%=i%>' <%=disabled%>>
						<option value='W' selected><fmt:message key="Common.Wellness.label" bundle="${common_labels}"/></option>
						</select></td>
				<%}else{%>
				<td align="center" class='<%=classValue%>' >
					<select name='nature<%=i%>' id='nature<%=i%>'disabled>
						<option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						</select></td>
					<%}
					}else{
				if(actual_yn.equals("Y")||(!select_val.equals(""))){
		%>
					<td align="center" class='<%=classValue%>'>
					<select name='nature<%=i%>' id='nature<%=i%>' <%=disabled%>>
		<%			if(potential_yn.equals("Y")||(!select_val.equals(""))){%>
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<% if(select_val.equals("P"))
					selected ="selected";
				else
					selected = "";
			%>
						<option value='P' <%=selected%>><fmt:message key="Common.Potential.label" bundle="${common_labels}"/></option>
		<% if(select_val.equals("A"))
					selected ="selected";
				else
					selected = "";
			%>
						<option value='A' <%=selected%>><fmt:message key="Common.Actual.label" bundle="${common_labels}"/></option>

		<% if(select_val.equals("B"))
					selected ="selected";
				else
					selected = "";
			%>
						<option value='B' <%=selected%>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
							<%}else{%>
							<option value='A' selected><fmt:message key="Common.Actual.label" bundle="${common_labels}"/></option>
							<%}
						}else{
							if(potential_yn.equals("Y")){%>
							<td align="center" class='<%=classValue%>'>
							<select name='nature<%=i%>' id='nature<%=i%>' <%=disabled%>>
							<option value='P' selected><fmt:message key="Common.Potential.label" bundle="${common_labels}"/></option>
							</select></td>
								<%}
						}
					}
				}else{%>
					<td align="center" class='<%=classValue%>'>
					<select name='nature<%=i%>' id='nature<%=i%>' disabled>
						<option value='' selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<option value='W'><fmt:message key="Common.Wellness.label" bundle="${common_labels}"/></option>
						<option value='A'><fmt:message key="Common.Actual.label" bundle="${common_labels}"/></option></select></td>
					<%}%>
				<td align='center' class='<%=classValue%>'><input type='checkbox' name='chk<%=i%>' id='chk<%=i%>'  value='<%=term_code%>' <%=chkAttribute%> <%=disabled%> onclick="setchkAll(this);"> </td>
			</tr>

	<%
		i++;
	chkAttribute="";
/*	if(TabList.size()>0)
		flag=1;*/
	
		}
			
%>	
	<input type=hidden name=from value='<%=start%>'>
	<input type=hidden name=to value='<%=end%>'>
	<input type=hidden name='start' id='start' value='<%=start%>'>
	<input type=hidden name='end' id='end' value='<%=end%>'>
	<input type='hidden' name='term_code' id='term_code' value="<%=term_code%>" >
	<input type='hidden' name='function_name' id='function_name' value=''>
	<input type='hidden' name='maxRecords' id='maxRecords' value='<%=maxRecord%>'>
	<input type='hidden' name="case_type_code" id="case_type_code" value='<%=case_type_code%>'>
	<input type='hidden' name="term_set_id" id="term_set_id" value='<%=term_set_id%>'>
	<input type='hidden' name="actual_yn" id="actual_yn" value='<%=actual_yn%>'>
	<input type='hidden' name="potential_yn" id="potential_yn" value='<%=potential_yn%>'>
	<input type='hidden' name="wellness_yn" id="wellness_yn" value='<%=wellness_yn%>'>
	<input type='hidden' name="type" id="type" value='<%=type%>'>
	<input type='hidden' name="alphalink" id="alphalink" value='<%=alphalink%>'>

	</table>
	<script>
		checkselectAll();
	</script> 
<%	
		//out.println("term_set_id  ->"+term_set_id+ "alphalink"+alphalink);
	}
	else{%>
		<script>
			var message=getMessage("NO_RECORD_FOUND","Common");
			parent.f_query_detail.location.href='../../eCommon/html/blank.html';
			parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
		</script>
	<%}
	}catch(Exception e){

		System.err.println(e.toString());
		e.printStackTrace();}
				finally { 
	if(rset_Associated!=null) rset_Associated.close();
	if(rset_case_type!=null) rset_case_type.close();
	if(rset_nature!=null) rset_nature.close();
	if(stmt_Associated!=null) stmt_Associated.close();
	if(stmt_case_type!=null) stmt_case_type.close();
	if(stmt_nature!=null) stmt_nature.close();

		ConnectionManager.returnConnection(con,request);
		session.setAttribute("TermCodeForCaseType", TermCodeForCaseType);
	}	
	%>
	
	</form>
  </body>
</html>

