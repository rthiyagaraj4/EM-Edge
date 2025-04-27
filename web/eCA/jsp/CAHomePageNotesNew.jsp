<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='styleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language=javascript src='../../eCA/js/CAMainMyTasks.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</HEAD>
<BODY OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
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
<tr><td  colspan='5' class='COMMONTOOLBARFUNCTION' style='border:0'><b><fmt:message key="Common.notes.label" bundle="${common_labels}"/></b>
</td></tr>
</table> -->

<table cellspacing='0'  cellpadding=3 border=1 width='100%' align='center'> 
<% 
	Connection con = null;
	
	String classValue = "";
	String note_type="",note_count="";
	String cou="0";
	String speCount = "0";
	int totalCount = 0;
    //String applicable_yn="";
	StringBuffer str = new StringBuffer();
	String	respid				= (String)	session.getValue("responsibility_id");
	int i = 0;
	try
	{
		
	PreparedStatement pstmt = null;
	ResultSet rset			=null;
	PreparedStatement pstmtComp = null;
	ResultSet rsComp = null;
		
		con=ConnectionManager.getConnection(request);

		String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String) 
		session.getValue("practitioner_type");
		
		String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" : (String)request.getParameter("practitioner_id");
		
		String fid		=	(String)session.getValue("facility_id");
		String Clin_id	=	(String)session.getValue("ca_practitioner_id");
		String User_id	=	(String)session.getValue("login_user");
		String resp_id=	(String) session.getValue("responsibility_id");
		
		String sqlPstmt="";
		String comp_desc = "";
		String group_desc = "";
		String sql = "";
		
		//sqlPstmt="SELECT COMP_ID, NVL((SELECT 'Y' FROM ca_personalized_home_page WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID=CA_HOME_PAGE_COMP.COMP_ID  AND ROWNUM=1), 'N') applicable_yn FROM CA_HOME_PAGE_COMP where  COMP_ID in ('PEND_SIGN') or GROUP_COMP_ID in('PEND_REVW')";

		sql = "select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = 'PEND_REVW'";
		pstmtComp = con.prepareStatement(sql);
		rsComp = pstmtComp.executeQuery();
		if(rsComp.next())
			group_desc = rsComp.getString(1);
		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();

		sqlPstmt="SELECT COMP_ID, (select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = A.COMP_ID) COMP_DESC FROM ca_personalized_home_page A WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID in ('PEND_SIGN','PEND_RV_SL','PEND_RV_SP','PEND_RV_AL') ";

		pstmtComp = con.prepareStatement(sqlPstmt);

		pstmtComp.setString(1,pract_type);
		pstmtComp.setString(2,practitioner_id);
		
		
		rsComp = pstmtComp.executeQuery();
	
		int k = 0;
		
		while(rsComp.next())
		{
			k = k+1;

			//if ( k % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
			comp_desc = rsComp.getString("COMP_DESC");
			if(rsComp.getString("COMP_ID").equals("PEND_SIGN"))
			{
				sql="select sum(grptot) from (select  count(*)  grptot  from ca_encntr_note_audit_log ii where facility_id= ? and action_type = 'SN' and ACTION_STATUS ='RQ' and action_by_id = ? and exists (select 1 from ca_encntr_note a, ca_note_type_for_resp b where a.FACILITY_ID=ii.facility_id and a.ACCESSION_NUM=ii.ACCESSION_NUM   and b.NOTE_TYPE=a.NOTE_TYPE	  and b.RESP_ID=?)        union all  select   count(*) grptot from ca_encntr_note c , ca_note_type_for_resp b where  c.facility_id= ? and c.event_status='1'   and c.added_by_id = ? and c.CONTR_MOD_ACCESSION_NUM is null and b.NOTE_TYPE=c.NOTE_TYPE  and b.RESP_ID=? )";

					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,fid);
					pstmt.setString(2,Clin_id);
					pstmt.setString(3,respid);
					pstmt.setString(4,fid);
					pstmt.setString(5,User_id);
					pstmt.setString(6,respid);
					rset=pstmt.executeQuery();

					while (rset.next())
					{
						cou=rset.getString(1)==null?"0":rset.getString(1);				
					}

					if(rset!=null)rset.close();
					if(pstmt!=null)pstmt.close();

						%>
						<tr>
					<td class='<%=classValue%>' nowrap>
					<% if (Integer.parseInt(cou)!=0) { %>
							<a class='gridLink'  href='javascript:authorizeNotes();'>
								<%=comp_desc%>(<%=cou%>)</a>
					<% }else{ %>
								<%=comp_desc%>(0)
				<% }
				
					%>
				</td>
			</tr>
			
				<%
		}
				
		else if(rsComp.getString("COMP_ID").equals("PEND_RV_SL") || rsComp.getString("COMP_ID").equals("PEND_RV_SP") || rsComp.getString("COMP_ID").equals("PEND_RV_AL"))
		{
			note_type = "";
			note_count = "";
			str = new StringBuffer();

			//pending reviews
			//classValue = "CAQUERYEVEN";  //CAQUERYODD

			sql="select count(*) grptot from ca_encntr_note_audit_log_view a,ca_note_type_for_resp B where a.action_by_id = ? and a.action_status = 'RQ'  and  a.action_type in ('RV','RS') AND A.NOTE_TYPE = B.NOTE_TYPE AND B.RESP_ID = ? and a.facility_id = ? and a.event_status != '9'" ;

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,Clin_id);
			pstmt.setString(2,respid);
			pstmt.setString(3,(String) session.getValue("facility_id"));
			rset=pstmt.executeQuery();

			while (rset.next())
			{
				cou=rset.getString(1);	
			}

			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
			
			sql = "select count(*) grptot from ca_encntr_note_audit_log_view a,ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id = ? and a.action_by_group_code = (select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id=?)  and a.action_status = 'RQ'  and  a.action_type in ('RV','RS','FS') and b.PRIVILEGE_TYPE in ('3','4') and a.facility_id = ? and a.event_status != '9'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,resp_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,(String) session.getValue("facility_id"));
			rset=pstmt.executeQuery();

			while (rset.next())
			{
				speCount=rset.getString(1);					
			}
			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
			totalCount = Integer.parseInt(cou) + Integer.parseInt(speCount);
			
			if(i == 0)
			{
			
			%>
				
			<TR>
				<TD class='<%=classValue%>' nowrap>
					<b><%=group_desc%></b>
				</TD>
			</TR>
				
			<% 
				i = i+1;
				k = k+1;

				//if(classValue.equals("CAQUERYODD"))
					//classValue = "CAQUERYEVEN";
				//else if(classValue.equals("CAQUERYEVEN"))
					//classValue = "CAQUERYODD";
			}
				if(rsComp.getString("COMP_ID").equals("PEND_RV_SL"))
				{
					//classValue = "CAQUERYODD"; 
			%>
						<tr><td class='<%=classValue%>' nowrap>&nbsp;&nbsp;&nbsp;
			<% 
						if (Integer.parseInt(cou)!=0)
						{
			%>
						<a class='gridLink'  href='javascript:reviewNotes("P");'>
						<%=comp_desc%>(<%=cou%>)</a>
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
				else if(rsComp.getString("COMP_ID").equals("PEND_RV_SP"))
				{
					//classValue = "CAQUERYEVEN"; 
					
			%>
						<tr><td class='<%=classValue%>' nowrap>&nbsp;&nbsp;&nbsp;
			<% 
						if (Integer.parseInt(speCount)!=0)
						{ 
			%>
						<a class='gridLink'  href='javascript:reviewNotes("S");'>
						<%=comp_desc%>(<%=speCount%>)</a>
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
				else if(rsComp.getString("COMP_ID").equals("PEND_RV_AL"))
				{
					//classValue = "CAQUERYODD"; 
					
			%>
						<tr><td class='<%=classValue%>' nowrap>&nbsp;&nbsp;&nbsp;
			<% 
						if (totalCount!=0)
						{ 
			%>
						<a class='gridLink' href='javascript:reviewNotes("A");'>
						<%=comp_desc%>(<%=totalCount%>)
						</a>
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
		}
		for(int j=k+1;j<=6;j++)
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
		//out.println("Exception in CAHomePageNotesNew.jsp "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
<input type='hidden' name="queryString" id="queryString" value="<%=request.getQueryString()%>"></input>
<form>
</BODY>
</HTML>

