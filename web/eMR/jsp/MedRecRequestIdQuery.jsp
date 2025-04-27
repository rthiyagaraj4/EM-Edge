<!DOCTYPE html>
<!--Created by Ashwini on 07-Jul-2017 for ML-MMOH-CRF-0702-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	    <script src="../js/MedRecRequestId.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%
		Connection con = null;
		String facility_id	= checkForNull((String)session.getValue("facility_id"));

		try
		{
			con	= ConnectionManager.getConnection(request);	

			request.setCharacterEncoding("UTF-8");
			
			String class_val				= "QRYEVENSMALL";		
			String req_year = "";
			String start_no = "";
			String max_no = "";
			String next_no = "";
			int currentPageNo 	= 1;
				
			if(request.getParameter("currentPageNo") != null)
				currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
		%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			
		<form name = 'MedRecRequestIdQueryForm'  target="messageFrame">

			<%
					JSONObject json 	= new JSONObject();
					JSONArray reqIdJsonArr = new JSONArray();
					json  = eMR.MRCommonBean.getRequestId(con,facility_id,currentPageNo);	

					int curPageNo		= 0;
					curPageNo		= (Integer) json.get("currentPageNo");
					
					int noOfRecords		= 0;
					noOfRecords		= (Integer) json.get("noOfRecords");
				
					int noOfPages		= 0;
					noOfPages		= (Integer) json.get("noOfPages");
				
					int prevPageNo	= curPageNo - 1;		
					int nextPageNo	= curPageNo + 1;

			if(noOfRecords == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
			else{
			%>

			<table align='right'>
				<tr>
					<% if ( curPageNo > 1 ){ 
					%>
						<td align ='right' id='prev'><A HREF="../../eMR/jsp/MedRecRequestIdQuery.jsp?facility_id=<%=facility_id%>&currentPageNo=<%=prevPageNo%>" text-decoration='none' onclick="fnSetvalue('P');" ><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
					<%}
					if ( curPageNo >=1 && curPageNo != noOfPages ){
						%>
						<td align ='right' id='next'><A HREF="../../eMR/jsp/MedRecRequestIdQuery.jsp?facility_id=<%=facility_id%>&currentPageNo=<%=nextPageNo%>"  text-decoration='none' onclick="fnSetvalue('N');"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
					<%}%>
				</tr>
			</table>
			<br></br>
			<table cellspacing='0' cellpadding='0' align='center' width='98%' border='1' style='margin-left:5px;'>
				<tr>
					<td>		
						<tr>
							<td width='25%' height="20" class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.year.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='25%' height="20" class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.StartSerialNo.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='25%' height="20" class="columnheadercenter"  style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.maxserialno.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='25%' height="20" class="columnheadercenter"  style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.nextsrlno.label" bundle="${common_labels}"/>&nbsp;</td>
						</tr>		
					<%
						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";
				
										
						reqIdJsonArr = (JSONArray)json.get("reqIdArray");
						for(int i = 0 ; i < reqIdJsonArr.size() ; i++) 
						{
						JSONObject reqIdObj	= (JSONObject)reqIdJsonArr.get(i);
						req_year			= (String) reqIdObj.get("req_year");
						start_no			= (String) reqIdObj.get("start_no");
						max_no				= (String) reqIdObj.get("max_no");	
						next_no				= (String) reqIdObj.get("next_no");
					%>
						<tr>
							<td width='25%' nowrap class='<%=class_val%>'><%=req_year%></td>
							<td width='25%' nowrap class='<%=class_val%>'><%=start_no%></td>
							<td width='25%' nowrap class='<%=class_val%>'><%=max_no%></td>
							<td width='25%' nowrap class='<%=class_val%>'><%=next_no%></td>
						</tr>
						<%}%>
					</td>
				</tr>

				<input type='hidden' name='isPrevClicked' id='isPrevClicked' value = ""></input>
				<input type='hidden' name='isNextClicked' id='isNextClicked' value = ""></input>
			</table>
			<%
			}
			%>	
	</form>
</body>
		<%
				
		}catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}	
		%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
	}
%>

