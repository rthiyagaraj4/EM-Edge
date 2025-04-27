<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../js/rowcolor.js' language='javascript'></SCRIPT>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  onScroll='scrollTitle()' onKeyDown='lockKey()'>
<%


request.setCharacterEncoding("UTF-8");
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
%>
<script>

//added by arvind krishnan on 25-07-04
async function showLongDescription(a)
{
	var dialogHeight= "20vh" ;
    var dialogWidth = "23vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
}
//ends
function closew(Dcode)
{
	window.parent.parent.returnValue=Dcode;
	window.parent.parent.close();
}
		function scrollTitle(){
          var y = parent.codedesc.document.body.scrollTop;

          if(y == 0){
			parent.codedesc.document.getElementById("divDataTitle").style.position = 'static';
			//parent.parent.PhysicainNoteResult.document.getElementById("divDataTitle").style.posTop  = 0;
          }else{
			parent.codedesc.document.getElementById("divDataTitle").style.position = 'relative';
			parent.codedesc.document.getElementById("divDataTitle").style.posTop  = y-2;
          }

        }
		function alignWidth(){
			var totalRows =  parent.codedesc.document.getElementById("dataTable").rows.length;
			
	        var counter = totalRows-1;
            var temp = parent.codedesc.document.getElementById("dataTitleTable").rows(0).cells.length;
            for(var i=0;i<temp;i++) {
				parent.codedesc.document.getElementById("dataTitleTable").rows(0).cells(i).width=parent.codedesc.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
				
            }
        }
</script>


<%
	StringBuffer sql= new StringBuffer();
	String Diag_code = (request.getParameter("p_diag_code")==null)?"":request.getParameter("p_diag_code");


    String searchby=(request.getParameter("Search_By")==null)?"":request.getParameter("Search_By");
    String searchcriteria=(request.getParameter("Search_Criteria")==null)?"":request.getParameter("Search_Criteria");
    String searchtext=(request.getParameter("Search_Text")==null)?"":request.getParameter("Search_Text");
	String cause_indicator=(request.getParameter("cause_indicator")==null)?"":request.getParameter("cause_indicator");
	String sensitive_yn =(request.getParameter("sensitive_yn")==null)?"":request.getParameter("sensitive_yn");
	String notifiable_yn =(request.getParameter("notifiable_yn")==null)?"":request.getParameter("notifiable_yn");



	String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");	
	String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	p_code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");
	
	int i=0;
	searchtext = searchtext.toUpperCase();

	if  (searchby.equals("D"))  sql.append(" and  upper(short_desc)  like ");
	else sql.append(" and diag_code  like ");

	if  (searchcriteria.equals("S"))  sql.append("'"+searchtext+"%'");
	else if  (searchcriteria.equals("E")) sql.append("'%"+searchtext+"'");
	else if  (searchcriteria.equals("C"))  sql.append("'%"+searchtext+"%'");

	if(sensitive_yn.equals("Y")) sql.append(" and  SENSITIVE_YN = 'Y' ");
	else if (sensitive_yn.equals("N")) sql.append(" and NVL(SENSITIVE_YN,'N') ='N' ");

	if(notifiable_yn.equals("Y"))  sql.append(" and notifiable_yn = 'Y'");
	else if (notifiable_yn.equals("N"))  sql.append(" and nvl(notifiable_yn,'N') ='N'");
	   
	sql.append(" ORDER BY DIAG_CODE ");
     

	Connection conn = null; 
	PreparedStatement stmt  = null;
	ResultSet rs=null;
	PreparedStatement stmt_1  = null;
	ResultSet rs_1=null;


try
{
	conn = ConnectionManager.getConnection(request);
	if(!(sex.equals("") || dob.equals("")))
	{
		String sql_age_spec_ind = " select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ";
		stmt_1 = conn.prepareStatement(sql_age_spec_ind);
		stmt_1.setString(1,dob);
		stmt_1.setString(2,dob);
		stmt_1.setString(3,dob);
		rs_1 = stmt_1.executeQuery();
		while(rs_1.next())
			age_spec_ind_val = rs_1.getString(1);		
	}		

	if(rs_1!= null) rs_1.close();
	if(stmt_1!= null) stmt_1.close();
	StringBuffer strsql2 = new StringBuffer("SELECT  DIAG_CODE  || nvl2(cause_indicator,'/' || cause_indicator,null) diag_code,  SHORT_DESC, decode(sensitive_yn,'Y','Yes','No') sensitive, long_desc, decode(notifiable_yn,'Y','Yes','No') notifiable, code_indicator ,gender_spec_ind, age_spec_ind  FROM  MR_ICD_CODE   WHERE  DIAG_CODE_SCHEME =? AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|'))  ");
	if(!(sex.equals("") || dob.equals("")))
	{
		if(p_code_indicator.equals(""))
			strsql2.append(" and (code_indicator in ('C','D') or code_indicator is null ) ");
		/*else if(p_code_indicator.equals("C"))
			strsql2.append(" and code_indicator = 'E' ");
		else if(p_code_indicator.equals("D"))
			strsql2.append("and code_indicator = 'A' ");
		*/
		else
			strsql2.append(" and code_indicator = '"+p_code_indicator+"'");
	}
	else
		{
		if(p_code_indicator.equals(""))
			strsql2.append(" and (code_indicator in ('C','D') or code_indicator is null ) ");
		else
			strsql2.append(" and code_indicator = '"+p_code_indicator+"'");
		}
	if(Diag_code.equals("2"))
		strsql2.append(" AND RECORD_TYPE='D'");
	
	strsql2.append(sql.toString());
	stmt = conn.prepareStatement(strsql2.toString());
	stmt.setString(1,Diag_code);	
	stmt.setString(2,cause_indicator);	
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
<table border='1' width='100%' id='dataTable' cellpadding='0' cellspacing='0' align='center' style="border-bottom:#ffffff">
<%

	String rowclass = "" ;

	while(rs.next())
	{
		if (i%2==0) 
			rowclass = "QRYEVEN" ;
		else	 
			rowclass = "QRYODD" ;

		code = rs.getString("DIAG_CODE")==null?"":rs.getString("DIAG_CODE");
		desc=rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
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
		if ((age_spec_ind.equals(age_spec_ind_val)|| dob.equals("")||age_spec_ind.equals("")) &&        (gender_spec_ind.equals(sex) || gender_spec_ind.equals("")|| sex.equals("")))
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
	

/*
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();		
	*/
}
catch(Exception e)
{

	//out.println("Exception is  "+e.toString());
	e.printStackTrace();
}
finally	
{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();		
	ConnectionManager.returnConnection(conn,request);
}%>
<TR style='visibility:hidden'>
<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
<th ><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>
</tr>
</table>
</div>
</form>
</BODY>
</HTML>
<script>
	alignWidth();
	parent.code_label.document.radio.Search.disabled=false;
</script>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

