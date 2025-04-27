<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../js/rowcolor.js' language='javascript'></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>


</head>
<script>
function closewindow(Diagcode)
  {
	window.parent.parent.parent.returnValue=Diagcode;
	window.parent.parent.parent.close();
  }
async function showLongDescription(a)
{
	var dialogHeight= "20vh" ;
    var dialogWidth = "23vw" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	await window.showModalDialog("../../eMR/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
}
</script>


<body onKeyDown='lockKey()'>
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
PreparedStatement stmt_1=null;
ResultSet rs_1=null;
PreparedStatement stmt_cnt=null;
ResultSet rs_cnt=null;

StringBuffer sql= new StringBuffer();
String term_code = "";
String long_desc = "";
String short_desc = "";
String notifiable = "";
String sensitive = "";
String sensitive_disp = "";
String notifiable_disp = "";
String age_spec_ind_val = "";
String age_spec_ind = "";
String gender_spec_ind = "";

	
   String searchby=(request.getParameter("Search_By")==null)?"":request.getParameter("Search_By");
    String searchcriteria=(request.getParameter("Search_Criteria")==null)?"":request.getParameter("Search_Criteria");
    String searchtext=(request.getParameter("Search_Text")==null)?"":request.getParameter("Search_Text");
	
	String sensitive_yn =(request.getParameter("sensitive_yn")==null)?"":request.getParameter("sensitive_yn");
	
	String notifiable_yn =(request.getParameter("notifiable_yn")==null)?"":request.getParameter("notifiable_yn");
	
	String sensitivity_appl_yn =(request.getParameter("sensitivity_appl_yn")==null)?"":request.getParameter("sensitivity_appl_yn");
	if(sensitivity_appl_yn.equals("N"))
		sensitive_disp = "display:none";

	String notification_appl_yn =(request.getParameter("notification_appl_yn")==null)?"":request.getParameter("notification_appl_yn");
	if(notification_appl_yn.equals("N"))
		notifiable_disp = "display:none";

	String age_group_appl_yn =(request.getParameter("age_group_appl_yn")==null)?"":request.getParameter("age_group_appl_yn");

	String age =(request.getParameter("Age")==null)?"":request.getParameter("Age");
	String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");	
	String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	String term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");
	String code_indicator =(request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");

	term_set_id = term_set_id.trim();
 	searchtext = searchtext.toUpperCase();

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
	if(age_group_appl_yn.equals("Y"))
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


if(searchtext.equals("") || searchtext!=null)
{
	if(searchby.equals("D")) 
		sql.append(" upper(short_desc)  like ");
	else 
		sql.append(" term_code  like ");

	if(searchcriteria.equals("S"))  
		sql.append("'"+searchtext+"%'");
	else if(searchcriteria.equals("E"))
		sql.append("'%"+searchtext+"'");
	else if(searchcriteria.equals("C"))
		sql.append("'%"+searchtext+"%'");

}

/*	if(sex.equals("F"))
		sql.append(" GENDER_SPEC_IND = 'F' ");
	else if(sex.equals("M"))
		sql.append(" GENDER_SPEC_IND = 'M' ");*/

	if(sensitive_yn.equals("Y")) 
		sql.append(" and SENSITIVE_YN = 'Y' ");
	else if (sensitive_yn.equals("N")) 
		sql.append(" and NVL(SENSITIVE_YN,'N') ='N' ");

	if(notifiable_yn.equals("Y"))  
		sql.append(" and NOTIFIABLE_YN = 'Y'");
	else if (notifiable_yn.equals("N"))  
		sql.append(" and nvl(NOTIFIABLE_YN,'N') ='N'");
	
	/*if(age_group_appl_yn.equals("Y"))
	{
		sql.append(" and AGE_SPEC_IND = ?");
	}*/

	if(!code_indicator.equals(""))
	{
		sql.append(" and  code_indicator = ?");
	}
	else
			sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");		

	
	sql.append(" ORDER BY TERM_CODE ");


	StringBuffer sql_count = new StringBuffer("select count(*) from  MR_D_"+term_set_id+"_VW where ");

	stmt_cnt = conn.prepareStatement(sql_count.toString()+sql.toString());
	if(!code_indicator.equals(""))
		stmt_cnt.setString(1,code_indicator);

	rs_cnt = stmt_cnt.executeQuery();
	
	while(rs_cnt.next()){
		 maxRecord = rs_cnt.getInt(1);
	}

	if(rs_cnt!=null) 
		rs_cnt.close();
	if(stmt_cnt!=null)
		stmt_cnt.close();

	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}
	else
	{
		StringBuffer searchCL_sql = new StringBuffer("select TERM_CODE,LONG_DESC,SHORT_DESC,decode(CODE_INDICATOR,'A','*','D','Dagger(+)','C','Consequence(C)','E','External Cause Indicator(E)')CODE_INDICATOR,decode(SENSITIVE_YN,'Y','Yes','N','No')SENSITIVE_YN,decode(NOTIFIABLE_YN,'Y','Yes','N','No')NOTIFIABLE_YN,AGE_SPEC_IND,GENDER_SPEC_IND from  MR_D_"+term_set_id+"_VW where ");
		
		
		stmt = conn.prepareStatement(searchCL_sql.toString()+sql.toString());
		if(!code_indicator.equals(""))
		{
			stmt.setString(1,code_indicator);
		}
		rs = stmt.executeQuery();
	//}
//out.println("<script>alert('page 1')</script>");

%>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eMR/jsp/TermCodeSearchCLResult.jsp?&from="+(start-14)+"&to="+(end-14)+"&term_set_id="+term_set_id+"&Age="+age+"&Sex="+sex+"&Dob="+dob+"&sensitive_yn="+sensitive_yn+"&notifiable_yn="+notifiable_yn+"&sensitivity_appl_yn="+sensitivity_appl_yn+"&notification_appl_yn="+notification_appl_yn+"&age_group_appl_yn="+age_group_appl_yn+"&Search_Text="+searchtext+"&Search_Criteria="+searchcriteria+"&Search_By="+searchby+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eMR/jsp/TermCodeSearchCLResult.jsp?&from="+(start+14)+"&to="+(end+14)+"&term_set_id="+term_set_id+"&Age="+age+"&Sex="+sex+"&Dob="+dob+"&sensitive_yn="+sensitive_yn+"&notifiable_yn="+notifiable_yn+"&sensitivity_appl_yn="+sensitivity_appl_yn+"&notification_appl_yn="+notification_appl_yn+"&age_group_appl_yn="+age_group_appl_yn+"&Search_Text="+searchtext+"&Search_Criteria="+searchcriteria+"&Search_By="+searchby+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table width='100%' border='1' cellspacing='0' cellpadding='2' id='tb1'>
<tr>
<th align='center'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></th>
<%if(notification_appl_yn.equals("Y") || notification_appl_yn.equals("")){%>
	<th align='center'><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></th>
<%}%>
<%if(sensitivity_appl_yn.equals("Y") || sensitivity_appl_yn.equals("")){%>
	<th align='center'><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></th>
<%}%>
</tr>

<%

  if ( start != 1 ){
     for( int j=1; j<start; i++,j++ ){
      rs.next() ;
	 }
  }
	String rowclass="";

	while (rs.next() && i<=end) 
	{
		if (i%2==0)
			 rowclass="QRYEVEN";
		else
			 rowclass="QRYODD";

		term_code = rs.getString("TERM_CODE");
		long_desc = rs.getString("LONG_DESC");
		short_desc = rs.getString("SHORT_DESC");
		code_indicator = rs.getString("CODE_INDICATOR")==null?"":rs.getString("CODE_INDICATOR");

		notifiable = rs.getString("NOTIFIABLE_YN")==null?"":rs.getString("NOTIFIABLE_YN");
		sensitive = rs.getString("SENSITIVE_YN")==null?"":rs.getString("SENSITIVE_YN");
		age_spec_ind = rs.getString("AGE_SPEC_IND")==null?"":rs.getString("AGE_SPEC_IND");
		gender_spec_ind = rs.getString("GENDER_SPEC_IND")==null?"":rs.getString("GENDER_SPEC_IND");

	out.println("<tr style='background-color:;' >");
		
	if(age_group_appl_yn.equals("Y") ){
			if ((age_spec_ind.equals(age_spec_ind_val)|| dob.equals("")||age_spec_ind.equals("")) &&        (gender_spec_ind.equals(sex) || gender_spec_ind.equals("")|| sex.equals("")))
			{
				out.println("<td class='"+rowclass+"'><a href=javascript:closewindow('"+term_code+"')>" + term_code + "</a></td>");
			}
	else{
		out.println("<td title='This Diagnosis Code is not applicable for this patient...' class='"+rowclass+"'>" + term_code + "</td>");
		}
	}
	else
		out.println("<td class='"+rowclass+"'><a href=javascript:closewindow('"+term_code+"')>" + term_code + "</a></td>");

		out.println("<td class="+rowclass+">");
		out.println(short_desc+"</td>");
		if(!short_desc.equals(long_desc))
		   out.println("<td class='"+rowclass+"' align='center'><a href=javascript:showLongDescription('" + java.net.URLEncoder.encode(long_desc) + "') ><b>!</b></a></td>");
		else
		   out.println("<td class="+rowclass+">&nbsp;</td>");
		out.println("<td class="+rowclass+">");
		out.println(code_indicator+"&nbsp;</td>");
		out.println("<td class="+rowclass+" style='"+notifiable_disp+"'>"+notifiable+"&nbsp;</td>");
	    out.println("<td class="+rowclass+" style='"+sensitive_disp+"'>"+sensitive+"&nbsp;</td>");
	
		out.println("</tr>");
		i++;
	}
	}
	   if (rs!=null) rs.close();
	   if (stmt!=null) stmt.close();

}
catch  (Exception e) {
	 //out.println("Exception "+e.toString());
	 e.printStackTrace();
}
finally{
	  
	   if(conn!=null)
		   ConnectionManager.returnConnection(conn,request);
}
%>
</table>
</body>
<SCRIPT LANGUAGE="JavaScript">
if(parent.searchframe != null)
	parent.searchframe.document.TermCodeSearchCLCriteriaForm.Search.disabled = false;
</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>
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

