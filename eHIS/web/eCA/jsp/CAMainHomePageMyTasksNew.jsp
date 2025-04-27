<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='styleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<TITLE></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>
<BODY  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<script language=javascript src='../../eCA/js/CAMainMyTasks.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<!--<script language=javascript>

document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
<form>
<!--<table border='0' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
<tr><td  colspan='5' class='COMMONTOOLBARFUNCTION' style='border:0'><b><fmt:message key="eCA.ResultsforReview.label" bundle="${ca_labels}"/></b></td></tr>
</table>-->
<table cellspacing='0' cellpadding=3  border=1 width=100% align='left'>
<%

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;	
	PreparedStatement pstmtComp = null;
	ResultSet rsComp = null;
	String classValue = "WHITEROW";
	int i = 0;

	try
	{
		con = ConnectionManager.getConnection(request);
		String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String) session.getValue("practitioner_type");
		String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" : (String)request.getParameter("practitioner_id");
		String Clin_id=(String)session.getValue("ca_practitioner_id");
		String resp_id = (String)session.getValue("responsibility_id");
		String ViewConfFlag = "X";
		String s1="";
		int count_abn = 0;
		int count_norm = 0;
		int count_crt = 0;
		int total = 0;
		String comp_id = "";
		String comp_desc = "";
		String group_desc = "";

		s1="Select GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,null) from dual";
		pstmtComp = con.prepareStatement(s1);
		pstmtComp.setString(1,resp_id);
		rsComp = pstmtComp.executeQuery();
		if (rsComp.next())
			ViewConfFlag=rsComp.getString(1);	

		if(rsComp != null)		rsComp.close();
		if(pstmtComp != null)	pstmtComp.close();

		String sql="select sum(case when A.normalcy_ind in (c.HIGH_STR,c.LOW_STR,c.ABN_STR) then 1 else 0 end) Abnormal_count ,sum(case when A.normalcy_ind in (c.CRIT_STR,c.CRIT_HIGH_STR,c.CRIT_LOW_STR) then 1 else 0 end) critical_count,   count(*) tot_cnt from  ca_result_review_pend_log a, CR_CLIN_EVENT_PARAM c where A.pract_id =? and CREATE_DATE_TIME between trunc(sysdate)-7 and trunc(sysdate)+.99999 and exists (select 1 from cr_encounter_detail where HIST_REC_TYPE  =a.HIST_REC_TYPE and CONTR_SYS_ID=a.CONTR_SYS_ID and ACCESSION_NUM=a.ACCESSION_NUM and CONTR_SYS_EVENT_CODE=a.EVENT_CODE and nvl(status,'#') != 'S' ";
		if ( ViewConfFlag.equals("X"))
			sql= sql+" and nvl(PROTECTION_IND,'#')!='Z' ";  	 
		sql= sql+" )  ";
			
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,Clin_id);
		rset=pstmt.executeQuery();

		if(rset.next())
		{
			count_abn = rset.getInt(1);
			count_crt = rset.getInt(2);
			total = rset.getInt(3);
			count_norm = total - (count_abn + count_crt);
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();

		sql = "select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = 'RESLT_REVW' ";
		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		if(rset.next())
			group_desc = rset.getString(1);
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();

		s1="SELECT COMP_ID, (select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = A.COMP_ID) COMP_DESC FROM ca_personalized_home_page A where PRACT_TYPE =? AND PRACTITIONER_ID = ?  and COMP_ID in('RSLT_RV_AL','RSLT_RV_AN','RSLT_RV_CR','RSLT_RV_NR') ";

		pstmtComp = con.prepareStatement(s1);
		pstmtComp.setString(1,pract_type);
		pstmtComp.setString(2,practitioner_id);
		
		rsComp = pstmtComp.executeQuery();
		
		while(rsComp.next())
		{
			i = i+1;
			if(i == 1)
			{
	%>
			<TR>
				<TD class='<%=classValue%>' nowrap>
					<b><%=group_desc%></b>
				</TD>
			</TR>
	<% 
				i++;
			}
			comp_id = rsComp.getString("COMP_ID");
			comp_desc = rsComp.getString("COMP_DESC");
			if(comp_id.equals("RSLT_RV_AL"))
			{
	%>
				<tr><td class='<%=classValue%>' nowrap>&nbsp;&nbsp;&nbsp;
	<% 
				if (total != 0)
				{
	%>
					<a  href='javascript:reviewWindow();'><%=comp_desc%>(<%=total%>)</a>
	<% 
				}
				else
				{ 
	%>
					<%=comp_desc%>(0)		
	<% 
				}
	%>
				</td></tr>
	<%
			}
			else if(comp_id.equals("RSLT_RV_AN"))
			{
	%>
				<tr><td class='<%=classValue%>' nowrap>&nbsp;&nbsp;&nbsp;
	<% 
				if (count_abn != 0)
				{
	%>
					<a  href="javascript:reviewWindow('<%=comp_desc%>');"><%=comp_desc%>(<%=count_abn%>)</a>				
	<% 
				}
				else
				{ 
	%>
					<%=comp_desc%>(0)			
	<% 
				}
	%>
				</td></tr>
	<%
			}
			else if(comp_id.equals("RSLT_RV_CR"))
			{
	%>
				<tr><td class='<%=classValue%>' nowrap>&nbsp;&nbsp;&nbsp;
	<% 
				if (count_crt != 0)
				{
	%>
					<a class='gridLink' href="javascript:reviewWindow('<%=comp_desc%>');"><%=comp_desc%>(<%=count_crt%>)</a>				
	<% 
				}
				else
				{ 
	%>
					<%=comp_desc%>(0)			
	<% 
				}
	%>
				</td></tr>
	<%
			}
			else if(comp_id.equals("RSLT_RV_NR"))
			{
	%>
				<tr><td class='<%=classValue%>' nowrap>&nbsp;&nbsp;&nbsp;
	<% 
				if (count_norm != 0)
				{
	%>
					<a class='gridLink' href="javascript:reviewWindow('<%=comp_desc%>');"><%=comp_desc%>(<%=count_norm%>)</a>				
	<% 
				}
				else
				{ 
	%>
					<%=comp_desc%>(0)			
	<% 
				}
	%>
				</td></tr>
	<%
			}
		}
		for(int j=i+1;j<=6;j++)
		{
			//if ( j % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		%>
			<tr>
				<td class='<%=classValue%>' >&nbsp;</td>
			</tr>
		<%
		}
		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in CAMainHomePageMyTasksNew.jsp: "+e.toString());//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
%>
</table>
<input type='hidden' name="queryString" id="queryString" value="<%=request.getQueryString()%>"></input>
</form>
</body>
</html>

