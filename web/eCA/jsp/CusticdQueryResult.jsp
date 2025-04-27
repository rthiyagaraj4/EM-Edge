<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../js/rowcolor.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../js/PatProblem.js' language='javascript'></SCRIPT>

</head>
<% 
      
		String Diag_code="";
		String age_spec_ind_val = "";
		String gender_spec_ind = "";
		String age_spec_ind = "";

/*String qrystring=request.getQueryString();
out.println(qrystring);
Enumeration enum = request.getParameterNames();
while(enum.hasMoreElements())
{
	String param_name = (String)enum.nextElement();
	
}*/%>

<script>
function closew(Diagcode)
  {
	window.parent.parent.parent.returnValue=Diagcode;
	//alert(Diagcode);
	window.parent.parent.parent.close();
  }
/*function showLongDescription(a)
{
	var dialogHeight= "20" ;
    var dialogWidth = "23" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	window.showModalDialog("../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
}*/

</script>


<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>

<%

 Connection conn=null;
PreparedStatement stmt=null;
ResultSet rset=null;
PreparedStatement stmt_1=null;
ResultSet rs_1=null;


String Diag_desc="";
String diagcode=request.getParameter("p_diag_code")==null?"":request.getParameter("p_diag_code");
String diagdesc=request.getParameter("p_diag_scheme_desc")==null?"":request.getParameter("p_diag_scheme_desc");
String authorize=request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn");
String DiagGcode=request.getParameter("Diag_code")==null?"":request.getParameter("Diag_code");
String cause_indicator=request.getParameter("cause_indicator")==null?"":request.getParameter("cause_indicator");
//String search_by = (request.getParameter("Search_By")==null?"":request.getParameter("Search_By"));
String search_by = request.getParameter("Search_By")==null?"":request.getParameter("Search_By");
String notifiable_yn = (request.getParameter("opt_notifiable")==null?"":request.getParameter("opt_notifiable"));
String search_criteria = (request.getParameter("Search_Criteria")==null?"":request.getParameter("Search_Criteria"));
String sensitive_yn = (request.getParameter("sensitive_yn")==null?"":request.getParameter("sensitive_yn"));
String search_text = (request.getParameter("Search_Text")==null?"":request.getParameter("Search_Text"));


String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
String p_code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");


//out.println("<script>alert('" + called_from + "')</script>");
//out.println("<script>alert('" + dob + "')</script>");


String long_description="";
String searchcondition="";
String notifiable_value="";
String sensitive_value="";



search_text = search_text.toUpperCase();
if(cause_indicator==null)
	cause_indicator="";
	searchcondition="";
//
if (!(search_by ==null || search_by.equals("")))
{
	/*if  (search_criteria.equals("M"))
	{
		if  ( !search_text.equals(""))
		{
				if(search_by.equals("D"))
					searchcondition = searchcondition+ " and contains(diag_desc,'"+search_text+"')>0 ";
				else	
					searchcondition = searchcondition + " and diag_code  like '"+search_text+"%'";
		}
	}
    
	else*/
	{
		if(search_by.equals("D"))
				   searchcondition = searchcondition+ " and  upper(diag_desc)  like ";

		else
			searchcondition = searchcondition + " and diag_code  like ";

		if  (search_criteria.equals("S"))

		searchcondition= searchcondition+"'"+search_text+"%'";

		else if  (search_criteria.equals("E"))

		searchcondition= searchcondition+"'%"+search_text+"'";

		else if  (search_criteria.equals("C"))
		 {
		searchcondition= searchcondition+ "'%"+search_text+"%'";
		}
	}
	if(sensitive_yn.equals("Y"))
	   searchcondition = searchcondition + " and  SENSITIVE_YN = 'Y' ";
	else if(sensitive_yn.equals("N"))
       searchcondition = searchcondition + " and nvl(SENSITIVE_YN, 'N') = 'N'";
	if (notifiable_yn.equals("Y"))
	   searchcondition = searchcondition + " and notifiable_yn = 'Y'";
	else if(notifiable_yn.equals("N"))
	    searchcondition = searchcondition + " and nvl(notifiable_yn, 'N') = 'N'";
}

//
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

	int start = 0 ;
    int end = 0 ;
    int i=1;
	int maxRecord=0;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

try
{
	conn = ConnectionManager.getConnection(request);
	if(!(sex.equals("") || dob.equals("")))
	{
		String sql_age_spec_ind = "select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER";
		stmt_1 = conn.prepareStatement(sql_age_spec_ind);
		stmt_1.setString(1,dob);
		stmt_1.setString(2,dob);
		stmt_1.setString(3,dob);
		rs_1 = stmt_1.executeQuery();
		if(rs_1.next())
			age_spec_ind_val = rs_1.getString(1);
	}
	if(rs_1 != null) rs_1.close();
	if(stmt_1 != null )stmt_1.close();
	StringBuffer sql1 = new StringBuffer("select count(*) from mr_diag_group_dtl_vw where diag_group_code=? AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|')) ");
	if(p_code_indicator.equals(""))
		sql1.append( "and ( code_indicator in ('C','D') OR code_indicator IS NULL ) ");
	/*else if(p_code_indicator.equals("C"))
		sql1.append("and code_indicator in ('E') ");
	else if(p_code_indicator.equals("D"))
		sql1.append("and code_indicator in ('A') ");
	*/
	else
	sql1.append(" and code_indicator = '"+p_code_indicator+"'");

	if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals("")))
			sql1.append(" and ( gender_spec_ind = ? OR nvl(age_spec_ind,'O')='O') ");
	sql1.append(searchcondition);	

	StringBuffer sql = new StringBuffer("select diag_code || nvl2(cause_indicator,'/' || cause_indicator,null) diag_code , diag_desc, diag_long_desc, nvl(notifiable_yn,' ') notifiable_yn, nvl(sensitive_yn,' ')  sensitive_yn ,code_indicator, age_spec_ind, gender_spec_ind from mr_diag_group_dtl_vw  where diag_group_code=?  AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|')) ");
	
	if(p_code_indicator.equals(""))
		sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");
	/*
	else if(p_code_indicator.equals("C"))
		sql.append("and code_indicator = 'E' ");
	else if(p_code_indicator.equals("D"))
		sql.append("and code_indicator = 'A' ");
	*/
	else
			sql.append(" and code_indicator = '"+p_code_indicator+"'");

	if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals("")))
		sql.append(" and ( gender_spec_ind = ? OR gender_spec_ind IS NULL OR gender_spec_ind='O' ) ");
	sql.append(searchcondition);	
   
	if(diagcode.equals("2"))
		sql.append(" AND RECORD_TYPE='D' ");

	sql.append("  order by diag_code");


    stmt=conn.prepareStatement(sql1.toString());
	stmt.setString(1,DiagGcode);
	//stmt.setString(2,authorize);
	stmt.setString(2,cause_indicator);
	/*stmt.setString(3,dob);
	stmt.setString(4,dob);
	stmt.setString(5,dob);*/
	if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals("")))
	{
		stmt.setString(3,sex);
	}
	rset=stmt.executeQuery();
    
	while(rset.next()){

		 maxRecord = rset.getInt(1);
	
	}
		if(maxRecord == 0 && !(sex.equals("") || dob.equals("")))
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
	
	if(rset != null) rset.close();
	if(stmt != null )stmt.close();

	stmt=conn.prepareStatement(sql.toString());
	stmt.setString(1,DiagGcode);
	stmt.setString(2,cause_indicator);		
	
	if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals("")))
	{
		stmt.setString(3,sex);
	}
	rset=stmt.executeQuery();
%>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/CusticdQueryResult.jsp?code_indicator="+p_code_indicator+"&from="+(start-14)+"&to="+(end-14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&Diag_code="+DiagGcode+"&cause_indicator="+cause_indicator+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eCA/jsp/CusticdQueryResult.jsp?code_indicator="+p_code_indicator+"&from="+(start+14)+"&to="+(end+14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&Diag_code="+DiagGcode+"&cause_indicator=	"+cause_indicator+"'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table width='100%' border='1' cellspacing='0' cellpadding='2' id='tb1'>
<th align='center'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>
<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String rowclass="";

	while (rset.next()&& i<=end ) 
	{
		if (i%2==0)
			 rowclass="QRYEVEN";
		else
			 rowclass="QRYODD";

		Diag_code=rset.getString("diag_code");
		Diag_desc=rset.getString("diag_desc");
		long_description = rset.getString("diag_long_desc");
	    long_description = java.net.URLEncoder.encode(long_description);
		notifiable_value = rset.getString("notifiable_yn");
		sensitive_value = rset.getString("sensitive_yn").trim();
		p_code_indicator = rset.getString("code_indicator")==null?"":rset.getString("code_indicator");
		gender_spec_ind = rset.getString("gender_spec_ind")==null?"":rset.getString("gender_spec_ind");
		age_spec_ind = rset.getString("age_spec_ind")==null?"":rset.getString("age_spec_ind");
		
		p_code_indicator = (p_code_indicator.equals("D")?"Dagger(+)":(p_code_indicator.equals("C")?"Consequence(C)":(p_code_indicator.equals("E")?"External Cause Indicator(E)":(p_code_indicator.equals("A")?"*":"&nbsp;"))));

		out.println("<tr style='background-color:;' >");

		if ((age_spec_ind.equals(age_spec_ind_val)|| dob.equals("")||age_spec_ind.equals("")||age_spec_ind.equals("O")||age_spec_ind.equals("M")||age_spec_ind.equals("C")) &&        (gender_spec_ind.equals(sex) || gender_spec_ind.equals("")|| sex.equals("")))
			out.println("<td class='"+rowclass+"'><a href=javascript:closew('"+Diag_code+"')>" + Diag_code + "</a></td>");
		else
			out.println("<td title='This Diagnosis Code is not applicable for this patient...' class='"+rowclass+"'>" + Diag_code + "</td>");

		  out.println("<td  class='"+rowclass+"'>");
		  out.println(Diag_desc+"</td>");
		  if (!Diag_desc.equals(long_description))
			 out.println("<td class='"+rowclass+"' align=center><a href= javascript:showLongDescription(\"" + long_description + "\"); ><b>!</b></a></td>");
		  else
			  out.println("<td class="+rowclass+">&nbsp;</td>");
		  out.println("<td class='"+rowclass+"'>");
	/*	  if(notifiable_value.equals("Y"))
			  out.println("Yes");
		  else 
			  out.println("No");*/
//		out.println(notifiable_value);
	 out.println(notifiable_value.equals("Y")?"Yes":"No"+"</td>");
		  out.println("<td class='"+rowclass+"'>");
		  out.println(sensitive_value.equals("Y")?"Yes":(sensitive_value.equals("N")?"No":"&nbsp;")+"</td>");
		  out.println("<td class='"+rowclass+"' align = center>");
		  out.println(p_code_indicator+"</td>");

		  out.println("</tr>");
		i++;
	}
	if(rset != null) rset.close();
	if(stmt != null )stmt.close();

 }catch  (Exception e) {
	// out.println("Result Page"+e.toString());//COMMON-ICN-0181
	 e.printStackTrace();
 } finally {
	   
	   if(conn!=null)ConnectionManager.returnConnection(conn,request);
 }

%>
</table>
</body>
<SCRIPT LANGUAGE="JavaScript">
if(parent.searchframe != null)
	parent.searchframe.document.radio.Search.disabled = false;
</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>

