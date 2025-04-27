<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
18/11/2015    	IN057467		 	Ramesh G		      								Query template data should also allow date field to be included for query.	
------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  eCA.PatientBannerGroupLine queryTemplateBean = null;

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/QueryNoteTemplate.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="queryTemplateDetForm" id="queryTemplateDetForm"  method ='post' target='messageFrame' action='../../servlet/eCA.QueryNoteTemplateServlet'>
	<BR><BR>

	<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String note_type ="";

	 note_type= request.getParameter("note_type")==null?"" : request.getParameter("note_type");

	String sec_hdg_code ="";
	String sec_hdg_desc ="";
	String comp_id ="";
	String comp_desc ="";
	String srl_no ="";
	String prompt_id ="";
	String result_type ="";
	String pre_sec_hdg_code ="";
	String bean_key ="";
//	String count = "0";
	String lower_limit			 =	"";	
	String upper_limit			 =	"";
	String key_val				=	"";
	String chk_val				=	"";

	StringBuffer query_string	 =	new StringBuffer();
	int		rowCnt					=	0,		maxRecordsDisp		=	15;
	int		startIndex				=	0,		endIndex			=	0;
	int		i						=	0;
	int		totalRecordCount		=	0;
	int chCount = 0;
	boolean flag = true;
	bean_key			=	(request.getParameter("bean_key")==null)	?	""	:	request.getParameter("bean_key");

	query_string.append("note_type=");		query_string.append(note_type);
	
	lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
	upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");

		startIndex		=	Integer.parseInt(lower_limit);
		endIndex		=	Integer.parseInt(upper_limit);

	queryTemplateBean = (eCA.PatientBannerGroupLine)getObjectFromBean("queryTemplateBean"+bean_key,"eCA.PatientBannerGroupLine",session);
	
	//String comp_det =" select a.CHILD_SEC_HDG_CODE SEC_HDG_CODE,a.CHILD_SEC_HDG_DESC SEC_HDG_DESC ,b.COMP_ID comp_id,c.LABEL_DESC comp_desc,c.srl_no, c.prompt_id, D.RESULT_TYPE from CA_NOTE_SECTION_VIEW a , ca_section_template b , CA_TEMPLATE_LABEL C ,  AM_DISCR_MSR D where a.NOTE_TYPE=? and a.CHILD_SEC_HDG_CODE=b.sec_hdg_code and b.INCLUDE_FOR_ANAL_YN='Y'  and b.PROMPT_ID=c.LABEL_ID AND D.DISCR_MSR_ID=B.COMP_ID order by 2,4 ";
	//IN057467 Start.
	//String comp_det =" select nvl( a.CHILD_SEC_HDG_CODE,a.SEC_HDG_CODE ) SEC_HDG_CODE ,nvl(a.CHILD_SEC_HDG_DESC,a.SEC_HDG_DESC ) SEC_HDG_DESC ,b.COMP_ID comp_id,c.LABEL_DESC comp_desc,b.srl_no, b.prompt_id, D.RESULT_TYPE from CA_NOTE_SECTION_VIEW a , ca_section_template b , CA_TEMPLATE_LABEL C ,  AM_DISCR_MSR D where a.NOTE_TYPE= ?  and nvl(a.CHILD_SEC_HDG_CODE,a.SEC_HDG_CODE) =b.sec_hdg_code  and b.INCLUDE_FOR_ANAL_YN='Y' and b.PROMPT_ID=c.LABEL_ID AND D.DISCR_MSR_ID=B.COMP_ID and D.RESULT_TYPE in  ('C','N', 'A', 'I','L') order by 2,4 ";
	String comp_det =" select nvl( a.CHILD_SEC_HDG_CODE,a.SEC_HDG_CODE ) SEC_HDG_CODE ,/*nvl(a.CHILD_SEC_HDG_DESC,a.SEC_HDG_DESC ) SEC_HDG_DESC ,*/ case when a.CHILD_SEC_HDG_CODE is not null then (a.CHILD_SEC_HDG_DESC||' - '||a.SEC_HDG_DESC) when a.CHILD_SEC_HDG_CODE is null then a.SEC_HDG_DESC end SEC_HDG_DESC ,b.COMP_ID comp_id,c.LABEL_DESC comp_desc,b.srl_no, b.prompt_id, D.RESULT_TYPE from CA_NOTE_SECTION_VIEW a , ca_section_template b , CA_TEMPLATE_LABEL C ,  AM_DISCR_MSR D where a.NOTE_TYPE= ?  and nvl(a.CHILD_SEC_HDG_CODE,a.SEC_HDG_CODE) =b.sec_hdg_code  and b.INCLUDE_FOR_ANAL_YN='Y' and b.PROMPT_ID=c.LABEL_ID AND D.DISCR_MSR_ID=B.COMP_ID and D.RESULT_TYPE in  ('C','N', 'A', 'I','L','D','E','F') order by 2,4 ";
	//IN057467 End.
	try
	{ 

		con = ConnectionManager.getConnection(request);
		ps = con.prepareStatement(comp_det,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ps.setString(1,note_type);
		rs = ps.executeQuery();
	
		rs.last();
		totalRecordCount	=	rs.getRow();
		rs.beforeFirst();

			if( totalRecordCount>maxRecordsDisp)
			{

	%>
			<table  class='grid' WIDTH='100%' align='center'  >
			<tr>
				<td CLASS='gridData' >&nbsp;</td>
	<%
			if(startIndex>maxRecordsDisp)
			{
	%>
				<td class='gridData'  width='8%'><a class='gridLink' href="javascript:submitPrevNext('<%=(startIndex-maxRecordsDisp)%>','<%=(endIndex-maxRecordsDisp)%>','<%=query_string.toString()%>')" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
	<%
			}
			if(totalRecordCount>endIndex)
			{
	%>
				<td class='gridData' align='center' width='8%'><a class='gridLink' href="javascript:submitPrevNext('<%=(startIndex+maxRecordsDisp)%>','<%=(endIndex+maxRecordsDisp)%>','<%=query_string.toString()%>')" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
	<%
			}
	%>
			</tr></table>
	<%
			}
	%>
	
	<table class='grid'  width="100%" align="center" name="resultTable" id="resultTable" id="dataTitleTable">
			<tr align="left">
				<th class='columnHeadercenter' width='30%'><fmt:message key="eCA.ComponentID.label" bundle="${ca_labels}"/></th>
				<th class='columnHeadercenter' width='50%'><fmt:message key="Common.Component.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
				<th class='columnHeadercenter' width='20%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;<fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;<input type='checkbox' id= 'selAll' onclick='selectCompInPage(this)'>)</th>
			</tr>
<%
	if(startIndex>1)
			rs.absolute((startIndex-1));
	
	while(rs.next())
		{
			flag = false ;
			rowCnt++;
			sec_hdg_code = rs.getString("SEC_HDG_CODE")==null?"":rs.getString("SEC_HDG_CODE");
			sec_hdg_desc = rs.getString("SEC_HDG_DESC")==null?"":rs.getString("SEC_HDG_DESC");
			comp_id = rs.getString("comp_id")==null?"":rs.getString("comp_id");
			comp_desc = rs.getString("comp_desc")==null?"":rs.getString("comp_desc");
			srl_no = rs.getString("srl_no")==null?"":rs.getString("srl_no");
			prompt_id = rs.getString("prompt_id")==null?"":rs.getString("prompt_id");
			result_type = rs.getString("RESULT_TYPE")==null?"":rs.getString("RESULT_TYPE");

			key_val = sec_hdg_code+"~"+comp_id+"~"+srl_no+"~"+prompt_id+"~"+result_type;
		
			if(queryTemplateBean.returnList1().contains(key_val))
			{
				chk_val = "checked";
				chCount++;
			}
			else
			{
				chk_val="";
			}
		
		if(!pre_sec_hdg_code.equals(sec_hdg_code))
			{
		
		%>

			<tr>
				<td colspan='3' class='CAGROUP' >&nbsp;<%=sec_hdg_desc%>&nbsp;
				</td>
			</tr>
			<%
			}
			%>
			<tr >
			<td class='gridData' width='30%' ><%=comp_id%></td>
			<td class='gridData' width='50%' ><%=comp_desc%></td>
			<td class='gridData' width='20%' ><input type='checkbox' name='selRow<%=rowCnt%>' id='selRow<%=rowCnt%>' value='<%=key_val%>' onClick="remFromList(this);" <%=chk_val%> ></td>
			
			
			
			</tr>
		<%	
			i++;
			
		pre_sec_hdg_code = sec_hdg_code;
		
		if(rowCnt>=maxRecordsDisp) break;
		
		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
			
			//out.println("Exception caught in QueryNoteTemplatedetails.jsp" + e);//COMMON-ICN-0181
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		%>
		<input type='hidden' name='startIndex' id='startIndex' value="<%=startIndex%>">
		<input type='hidden' name='endIndex' id='endIndex' value="<%=endIndex%>">
		<input type='hidden' name='count' id='count' value="<%=i%>">
		<input type='hidden' name='bean_key' id='bean_key' value="<%=bean_key%>">

		<input type='hidden' name='query_id' id='query_id' value="">
		<input type='hidden' name='query_desc' id='query_desc' value="">
		<input type='hidden' name='note_type' id='note_type' value="">
		<input type='hidden' name='eff_status' id='eff_status' value="">
		<input type='hidden' name='mode' id='mode' value="">
		
		</form>
		<%if(!flag)
		{
		%>

		<%
			if(chCount==i)
			{
		%>
				<script>document.forms[0].selAll.checked=true;</script>
		<%
			}
			if(chCount>0)
			{
		%>
				<script>
					global_count = '<%=chCount%>';
				</script>
		<%
			}
		}
	
	%>



  </body>
</html>

