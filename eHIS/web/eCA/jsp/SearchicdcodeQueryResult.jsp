<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../js/rowcolor.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../js/PatProblem.js' language='javascript'></SCRIPT>
<script src='../js/RecClinicalNotesLinkDiag.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  onScroll='scrollTitleIcd()' class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>

<% 


String code="";
String desc="";
String sensitive = "";
String notifiable = "";
String longDesc="";
String p_code_indicator = "";
String code_indicator="";
String age_spec_ind_val = "";
String gender_spec_ind = "";
String age_spec_ind = "";
String retdata="";
String to_code = "";
String from_code = "";
StringBuffer sql = new StringBuffer();

int i = 0;

Connection conn = null; 
PreparedStatement stmt=null;
ResultSet rs=null;

from_code = request.getParameter("from_code")==null?"":request.getParameter("from_code");
to_code = request.getParameter("to_code")==null?"":request.getParameter("to_code");

String Diag_code = (request.getParameter("p_diag_code")==null)?"":request.getParameter("p_diag_code");
    String searchby=(request.getParameter("Search_By")==null)?"":request.getParameter("Search_By");
    String searchcriteria=(request.getParameter("Search_Criteria")==null)?"":request.getParameter("Search_Criteria");
    String searchtext=(request.getParameter("Search_Text")==null)?"":request.getParameter("Search_Text");
	String cause_indicator=(request.getParameter("cause_indicator")==null)?"":request.getParameter("cause_indicator");
	String sensitive_yn =(request.getParameter("sensitive_yn")==null)?"":request.getParameter("sensitive_yn");
	String notifiable_yn =(request.getParameter("notifiable_yn")==null)?"":request.getParameter("notifiable_yn");
	String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");	
	String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	age_spec_ind_val =(request.getParameter("age_spec_ind_val")==null)?"":request.getParameter("age_spec_ind_val");
	p_code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");

	 searchtext = searchtext.toUpperCase();
 
	if  (searchby.equals("D"))  
		sql.append(" and  upper(short_desc)  like ");
	else 
		sql.append(" and diag_code  like ");

	if  (searchcriteria.equals("S"))  
		sql.append("'"+searchtext+"%'");
	else 	if  (searchcriteria.equals("E")) 
		sql.append("'%"+searchtext+"'");
	else if  (searchcriteria.equals("C"))  
		sql.append("'%"+searchtext+"%'");

	if(sensitive_yn.equals("Y")) 
		sql.append(" and  SENSITIVE_YN = 'Y' ");
	else if (sensitive_yn.equals("N")) 
		sql.append(" and NVL(SENSITIVE_YN,'N') ='N' ");

	if(notifiable_yn.equals("Y"))  
		sql.append(" and notifiable_yn = 'Y'");
	else if (notifiable_yn.equals("N"))  
		sql.append(" and nvl(notifiable_yn,'N') ='N'");



try{
	conn = ConnectionManager.getConnection(request);
	
	StringBuffer strsql2 = new StringBuffer();

	strsql2.append("SELECT  DIAG_CODE  || nvl2(cause_indicator,'/' || cause_indicator,null) diag_code,  SHORT_DESC, decode(sensitive_yn,'Y','Yes','No') sensitive, long_desc, decode(notifiable_yn,'Y','Yes','No') notifiable, code_indicator ,gender_spec_ind, age_spec_ind from mr_icd_code where ");
	
	
	strsql2.append(" DIAG_CODE_SCHEME =? AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|'))  ");

	if(!(sex.equals("") || dob.equals(""))){
		if(p_code_indicator.equals(""))
			strsql2.append(" and (code_indicator in ('C','D') or code_indicator is null ) ");
	   else{
			//strsql2.append(" and code_indicator = '"+p_code_indicator+"'");//common-icn-0180
			strsql2.append(" and code_indicator = ?");//common-icn-0180
	   }
	}
	else{
		if(p_code_indicator.equals(""))
			strsql2.append(" and (code_indicator in ('C','D') or code_indicator is null ) ");
		else{
			//strsql2.append(" and code_indicator = '"+p_code_indicator+"'");//common-icn-0180
			strsql2.append(" and code_indicator = ?");//common-icn-0180
		}
	}
	if(Diag_code.equals("2"))
		strsql2.append(" AND RECORD_TYPE='D'");

		strsql2.append(sql.toString());
		
		strsql2.append(" and diag_code between ? and ?  order by diag_code");
    int pstmtcount = 1;
	stmt = conn.prepareStatement(strsql2.toString());
	
	//common-icn-0180 starts
	/* stmt.setString(1,Diag_code);	
	stmt.setString(2,cause_indicator);	
	stmt.setString(3,from_code);	
	stmt.setString(4,to_code);
	 */

	stmt.setString(pstmtcount++,Diag_code);	
	stmt.setString(pstmtcount++,cause_indicator);	
	if(!(sex.equals("") || dob.equals(""))){
		if(!p_code_indicator.equals("")){
			stmt.setString(pstmtcount++,p_code_indicator);	
		}
	}
	else{
		if(!p_code_indicator.equals("")){
			stmt.setString(pstmtcount++,p_code_indicator);	
		}
	}
	stmt.setString(pstmtcount++,from_code);	
	stmt.setString(pstmtcount++,to_code);	
	//common-icn-0180 ends
	rs = stmt.executeQuery();
	

%>

<form name='query_form' id='query_form'>
<div id='divDataTitle' style='postion:relative'>
<table border='1' width='100%' id='dataTitleTable' cellpadding='0' cellspacing='0' align='center' >
<TR>
<th align='center'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>
</tr>
</table>
</div>
<table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff">
<%

String rowclass = "" ;
while(rs.next())
	{
			if (i%2==0) rowclass = "QRYEVEN" ;
			else	 rowclass = "QRYODD" ;
			
		   code = rs.getString("DIAG_CODE")==null?"":rs.getString("DIAG_CODE");
		   desc=rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
		   
			//if(Diag_code.equals("1"))
			//{
			retdata=code+"/"+desc;
			retdata=java.net.URLEncoder.encode(retdata);
			//}
			//else
			//retdata=code;
		   longDesc = rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC");
		   sensitive = rs.getString("sensitive")==null?"":rs.getString("sensitive");
		   notifiable = rs.getString("notifiable")==null?"":rs.getString("notifiable");
		   code_indicator = rs.getString("code_indicator")==null?"":rs.getString("code_indicator");		   
		   gender_spec_ind = rs.getString("gender_spec_ind")==null?"":rs.getString("gender_spec_ind");		   
		   age_spec_ind = rs.getString("age_spec_ind")==null?"":rs.getString("age_spec_ind");		   
		   code_indicator = (code_indicator.equals("D")?"Dagger(+)":(code_indicator.equals("C")?"Consequence(C)":(code_indicator.equals("E")?"External Cause Indicator(E)":(code_indicator.equals("A")?"*":"&nbsp;"))));
		   longDesc = java.net.URLEncoder.encode(longDesc);
		   if(sensitive==null)
			 sensitive="&nbsp;";
		   if(notifiable==null)
			   notifiable="&nbsp;";
			out.println("<tr style='background-color:;'>");	

			//out.println("<script>alert('age_spec_ind_val----"+age_spec_ind_val+"')</script>");
			//if( age_spec_ind.equals(age_spec_ind_val) || (sex.equals("") || dob.equals("")) || (gender_spec_ind.equals(sex) || gender_spec_ind.equals("")) )
			if ((age_spec_ind.equals(age_spec_ind_val)|| dob.equals("")||age_spec_ind.equals("")||age_spec_ind.equals("O")||age_spec_ind.equals("M")||age_spec_ind.equals("C")) &&        (gender_spec_ind.equals(sex) || gender_spec_ind.equals("")|| sex.equals("")))
				out.println("<td class='"+rowclass+"'><a href=javascript:closew('"+code+"')>" + code + "</a></td>");
			else
				out.println("<td title='This Diagnosis Code is not applicable for this patient...' class='"+rowclass+"'>" + code + "</td>");
			out.println("<td  class='"+rowclass+"'>"+desc+"</td>");
			if(!desc.equals(longDesc))
				out.println("<td class='"+rowclass+"' align='center'><a href=javascript:showLongDescription(\"" + java.net.URLEncoder.encode(longDesc) + "\"); ><b>!</b></a></td>");
			else
				out.println("<td class="+rowclass+">&nbsp;</td>");
			out.println("<td class="+rowclass+">");
			out.println(notifiable+"</td>");
			out.println("<td  class='"+rowclass+"' align='center'>" );
			out.println( sensitive+"</td>" );	
			out.println("<td class='"+rowclass+"' align='center'>");
			out.println(code_indicator + "</td></tr>");

		i++;
  }
  if(i==0)
	{
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
}
catch(Exception e)
{
		//out.println("Exception "+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>
<TR style='visibility:hidden'>
<<th align='center'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>

</tr>
</table>
</div>
</form>
</BODY>
</HTML>
<script>
	alignWidthIcd();
	parent.code_label.document.radio.Search.disabled=false;

</script>

