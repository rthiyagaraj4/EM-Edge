<!DOCTYPE html>
<%
/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
17/09/2013     		1   		Sethuraman      Created
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCA.*, webbeans.eCommon.RecordSet,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
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
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../js/EncSummConfig.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%
	String groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
	String groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");		
	String summaryCode = request.getParameter("summaryCode") == null ? "" : request.getParameter("summaryCode");		
	
	int gFlag = Integer.parseInt(request.getParameter("groupFlag"));	
	
	String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");	
	String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String flag = request.getParameter("flag") == null ? "1" : request.getParameter("flag");
	String flagTemp = request.getParameter("flagTemp") == null ? "1" : request.getParameter("flagTemp");
				
	String startString =  request.getParameter("start") == null ? "0" : request.getParameter("start");
	String endString =  request.getParameter("end") == null ? "5" : request.getParameter("end");
	String loadFirst =  request.getParameter("loadFirst") == null ? "" : request.getParameter("loadFirst");
	String tempRowIds =  request.getParameter("tempRowIds") == null ? "" : request.getParameter("tempRowIds");	
	int countForNext = request.getParameter("countForNext") == null ? 1 : Integer.parseInt(request.getParameter("countForNext"));
	
	String hiddenFieldRemoveRow = request.getParameter("hiddenFieldRemoveRow") == null ? "" : request.getParameter("hiddenFieldRemoveRow");
	
	int start = Integer.parseInt(startString);
	int end = Integer.parseInt(endString);

	int tempSeq = 0;
	int count = 0;
	int tempCount = 0;
	
	List<EncSummConfigGroupBean> oSummGroupList = null;
	EncSummConfigGroupBean sConfigGroupBean = null;
	EncSummConfigGroupBean sConfigGroupBeanList = null;
	
	EncSummGroup summGrpDetails = new EncSummGroup();	
	
	int nGroupListSize = 0;

	int cnt = 0;
	
	String rowID = "";
	
	if(tempRowIds.indexOf("^") != -1)
	{
		for(int y=0;y<tempRowIds.length();y++)
			tempRowIds = tempRowIds.replace('^','+');
	}
	
	if(!tempRowIds.equals("")){
		tempRowIds = tempRowIds.substring(0,tempRowIds.length()-1);				
	}			
	
%>
<body  class='CONTENT 'OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
	<form name='GroupAddForm' id='GroupAddForm' method="post">
	<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>	
		<tr>
			<td class='white' width='95%'></td> 
			<td  align='right' width='5%' nowrap>
				<a class='gridLink' style='visibility:hidden' id='prevRecs' href="javascript:prevNextRecs('prev')">
					<fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;
				<a class='gridLink' id='nextRecs' href="javascript:prevNextRecs('next')">
					<fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		</tr>
	</table>
	<table cellpadding='3' cellspacing='0' border='1' id='dataTitleTable' width='100%' align='center' >
		<tr>
		<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='50%'><fmt:message key="eCA.groupdesc.label" bundle="${ca_labels}"/></td>
		<td class='COLUMNHEADERCENTER'width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
	</table>
	<table class='grid' cellpadding='3' cellspacing='0' border='1'  width='100%' align='center' >	
	<%
		String group_code = "", group_type = "";
		String group_desc = "", valid = "";		
		int index = 0;
		String tblrow_id="", groupTypeId = "";
		String chkSelBox = "";
		try
			{	
				oSummGroupList = new ArrayList<EncSummConfigGroupBean>();
				sConfigGroupBean = new EncSummConfigGroupBean();
				
				sConfigGroupBean.setRequest(request);
				sConfigGroupBean.setiGroupFlag(gFlag);
				sConfigGroupBean.setsGroupType(groupType);				
				sConfigGroupBean.setsRowId(tempRowIds);
				sConfigGroupBean.setsSearchText(searchText);
				sConfigGroupBean.setsSummaryCode(summaryCode);
				
				oSummGroupList = summGrpDetails.getSummaryConfigAddGroups(sConfigGroupBean);				
				
				nGroupListSize = oSummGroupList.size();	
				
				for (int i=0;i<nGroupListSize;i++){
					index++;
					sConfigGroupBean = oSummGroupList.get(i);
					group_code = sConfigGroupBean.getsGroupCode();
					group_desc = sConfigGroupBean.getsGroupDesc();							
					rowID = sConfigGroupBean.getsRowId();	
					valid = sConfigGroupBean.getsValid();
					
					if (valid.equalsIgnoreCase("Y") && !(hiddenFieldRemoveRow.equals(group_code)))
					{
						chkSelBox = " checked ";						
					}
					else
						chkSelBox = "";				
					
					tblrow_id ="tblrow_id"+index;
					groupTypeId = "groupTypeId"+index;					
					
					if(loadFirst.equals("Yes"))
					{
					%>
						<script>
							parent.parent.rowIDCompForEncSummConfigGroup[<%=cnt%>] = '<%=rowID%>';
						</script>
					<%
					}
					if(cnt < 5)
					{						
						%>
						<tr  id='<%=tblrow_id%>'>
							<td width='0' style="display:none"><%=group_code%></td>
						 	<td class='gridData'  width='25%' align='left'><%= group_code%></td><!-- TD TO DISPLAY GROUP CODE -->
							<td class='gridData'  width='50%' align='left'><%= group_desc%></td>    <!-- TD TO DISPLAY DESCRIPTION -->
							<td class='gridData'  width='25%' align='center'>
								<input type='checkbox' name='select_yn<%=index%>' id='select_yn<%=index%>' value='Y' onClick="stringConCatenate(<%=index%>,<%=tblrow_id%>)" <%=chkSelBox%>>
					   		</td> <!-- CHECKBOX TO DISPLAY WHICH ALL ENTRIES HAVE NON -ZERO SEQUENCE NUMBER -->
					   		<td width='0' style="display:none"><%=groupType%></td>
						</tr>	
						<%
					}
		
					cnt++;					
				}
				count = cnt;
				if(loadFirst.equals("Yes"))
				{
					tempCount = cnt;
				}
				else
				{
					tempCount = request.getParameter("totalCount") == null ? 0 : Integer.parseInt(request.getParameter("totalCount"));
				}
					
				if(cnt == 0)
				{
					%>
					<script>
						document.getElementById("nextRecs").style.visibility = 'hidden';
						document.getElementById("prevRecs").style.visibility = 'hidden';
					</script>
					<%
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}							
			}
			catch(Exception e)
			{
				out.println("Exception in try of EncSummConfigGroupAddList.jsp"+e.toString());
				e.printStackTrace();
			}
		%>	
		<input type='hidden' name='sequence' id='sequence' value='<%=index%>'>
		<input type='hidden' name='from' id='from' value='<%=start%>'>
		<input type='hidden' name='to' id='to' value='<%=end%>'>
		<input type='hidden' name='searchText' id='searchText' value='<%=searchText%>'>		
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		<input type='hidden' name='flag' id='flag' value='<%=flag%>'>
		<input type='hidden' name='groupFlag' id='groupFlag' value='<%=groupFlag%>'>
		<input type='hidden' name='groupType' id='groupType' value='<%=groupType%>'>		
		<input type='hidden' name='gFlag' id='gFlag' value='<%=gFlag%>'>
		<input type='hidden' name='totalCount' id='totalCount' value='<%=tempCount%>'>
		<input type='hidden' name='countForNext' id='countForNext' value='<%=countForNext%>'>
		<input type ="hidden" name ="hiddenFieldRemoveRow" value="<%=hiddenFieldRemoveRow%>">
		<input type ="hidden" name ="summaryCode" value="<%=summaryCode%>">

		</table>	
	</form>
	<script>
		//alert(parent.parent.rowIDArraySubSecMain);
		if(<%=start%> == 0)
			document.getElementById("prevRecs").style.visibility = 'hidden';
		else
			document.getElementById("prevRecs").style.visibility = 'visible';
		
		if(<%=cnt%> < 5)
			document.getElementById("nextRecs").style.visibility = 'hidden';
		else
			document.getElementById("nextRecs").style.visibility = 'visible';
	</script>

</body>
</html>

