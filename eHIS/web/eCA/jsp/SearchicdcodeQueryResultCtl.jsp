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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../js/rowcolor.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../js/PatProblem.js' language='javascript'></SCRIPT>
<script src='../js/PatProblemSearch.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<% 

Connection conn = null; 
PreparedStatement stmt=null;
ResultSet rs=null;
PreparedStatement stmt_1=null;
ResultSet rs_1=null;

String code="";

String p_code_indicator = "";

String age_spec_ind_val = "";

String disablePrev="";
String disableNext="";
String no_data = "";


int indxKey = 0;

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
	
	
 //  int i=0;
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

				if(rs_1!=null)
					rs_1.close();
				if(stmt_1!=null)
					stmt_1.close();
			}

			StringBuffer strsql2= new StringBuffer();

			strsql2.append("select diag_code  from (select diag_code,rank() over( order by diag_code) order_rank ,max(diag_code) over ( order by diag_code desc) last_rank from mr_icd_code where "); 
			
			strsql2.append(" DIAG_CODE_SCHEME =? AND NVL(CAUSE_INDICATOR, '|') =NVL(?, NVL(CAUSE_INDICATOR,'|'))  ");

			if(!(sex.equals("") || dob.equals(""))){
				if(p_code_indicator.equals(""))
					strsql2.append(" and (code_indicator in ('C','D') or code_indicator is null ) ");
			   else
				strsql2.append(" and code_indicator = '"+p_code_indicator+"'");
			}
		else{
			if(p_code_indicator.equals(""))
				strsql2.append(" and (code_indicator in ('C','D') or code_indicator is null ) ");
			else
				strsql2.append(" and code_indicator = '"+p_code_indicator+"'");
		}
		if(Diag_code.equals("2"))
			strsql2.append(" AND RECORD_TYPE='D'");

		strsql2.append(sql.toString());
		strsql2.append(" ) where  mod(order_rank,25)=1  or diag_code=last_rank order by order_rank");
	
		stmt = conn.prepareStatement(strsql2.toString());
		stmt.setString(1,Diag_code);	
		stmt.setString(2,cause_indicator);	
		rs = stmt.executeQuery();
		
		indxKey = 0;
		while(rs.next())
		{
			code = rs.getString("diag_code")==null?"":rs.getString("diag_code");
				%>
					<script>
						codeArr["<%=indxKey%>"] = "<%=code%>";
					</script>
				<%

				indxKey++;
		}
	
		if(indxKey == 0)
		{ 
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				out.println("<script>parent.frames[0].document.forms[0].Search.disabled = false</script>");
				out.println("<script>parent.frames[2].href='../../eCommon/html/blank.html' </script>");
		}

	if(indxKey == 0)
		no_data = "No_Data_Found!";

	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}
	finally
	{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
	}

%>
<form name = "SearchicdcodeQueryResultCtlForm" >
<table border=0 cellpadding=0 cellspacing=0 width="100%" align='center' id='tablePrevNext' style='display'>
	<tr>
		<td  width='85%' align='right' CLASS =LABEL><fmt:message key="Common.DisplayResult.label" bundle="${common_labels}"/></td>
		<td align='right' width='5%'><input type='button' id='prev' name='prev' id='prev' value='<' <%=disablePrev%> class='button' onclick='loadPrevNext(this)' align='right'></td>
		<td  align ='center' class = 'QRYEVEN'>
				<input type ='label' class="LABEL" name = 'label_cap' size='15' value=<%=no_data%>> 
		</td>
		<td align='left' width='5%'><input type='button' id='next' name='next' id='next' value='>' <%=disableNext%> class='button' onclick='loadPrevNext(this)' ></td>
	</tr>
</table>
<input type= "hidden" name= "CurIndex" value="0">
<input type= "hidden" name= "totalIndex" value=<%=indxKey%> - 1>
<input type= "hidden" name= "queryString" value=<%=request.getQueryString()%>>
<input type= "hidden" name= "age_spec_ind_val" value=<%=age_spec_ind_val%>>
<script>
document.forms[0].prev.disabled = true;
if("<%=indxKey%>" <= 2){
	document.forms[0].next.disabled = true;
}
if("<%=indxKey%>" > 0 )
	loadDefaultPage();
</script>
</form>
</body>
</html>

