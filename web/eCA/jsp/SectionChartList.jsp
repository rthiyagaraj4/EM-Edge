<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String operation = request.getParameter("operation") == null ? "" : request.getParameter("operation");
String tempfinalString = "";
String flag_for_list = request.getParameter("flag_for_list") == null ? "false" : request.getParameter("flag_for_list");
String tempRowCount = request.getParameter("rowCount") == null ? "0" : request.getParameter("rowCount");
int tempIntRowCount = Integer.parseInt(tempRowCount);
String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");

int i=0;
%>
	<!-- Added by Arvind @ 08-12-08 -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/SectionChart.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body   OnMouseDown="CodeArrest()" onKeyDown="lockKey()" OnScroll="scrollTitle()" >
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	eCA.SectionChartBean bean = (eCA.SectionChartBean)getObjectFromBean("bean","eCA.SectionChartBean",session);
%>
	
	<form name="sectionChartResultForm" id="sectionChartResultForm">
<div id='divDataTitle' style='postion:relative'>
	 <table   border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center'>	
			<tr><th class='columnheader' colspan='3' width='20%' align='left'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/><fmt:message key="Common.Section.label" bundle="${common_labels}"/></th></tr>
			<tr align='left'><th class='columnheadercenter' width='10%'><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='50%'><fmt:message key="Common.SectionDescription.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='15%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th></tr>	
	</table>
 </div>
 <%
	 Connection con			= null;
	StringTokenizer tokenizeTilde = null;
	StringTokenizer tokenizePipe = null;
	String finalString = "";
	String classValue = "";
	String description = "";
	String searchText = request.getParameter("chartDesc");	
	String seq_num = "";
	String sectionCode = "";
	String flagY = "";
	//String discreteMeasureid = "";
	String chartId = request.getParameter("chartId") == null ? "" :  request.getParameter("chartId");
	String subString = "";
	int slno = 1;
	int rowCount= 0;
	//String operation = request.getParameter("operation") == null ? "" : request.getParameter("operation");

	try
	{
		con = ConnectionManager.getConnection(request);
		if(searchText==null || searchText.equals("")||searchText.equals("%"))
				searchText = "%";
		else
			searchText = searchText.toUpperCase() +"%";
 %>
<table  class='grid' align='center' width="100%"  >
<%
		if(!operation.equals("split"))
		{		
			
			ArrayList retArray1 = bean.getQueryForChart(chartId,searchText,con);
			if(retArray1 != null)
			{
				if(chartId.equals(""))
					{
					%>
					<script>
						getChartCodeOnClick(parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartDesc);
					</script>
					<%
					}
				else
					{
					ArrayList arrayDesc = (ArrayList)retArray1.get(0);
					bean.setConcatenatedString("");
					ArrayList  discreteMeasureId  = (ArrayList)retArray1.get(2);
					ArrayList orderSeqNo = (ArrayList)retArray1.get(1);
					ArrayList flag = (ArrayList)retArray1.get(3);
					bean.setLength(arrayDesc.size());
					for(i = 0;i<arrayDesc.size();i++)
						{
							if(((String)flag.get(rowCount)).equals("Y"))
								{
									classValue ="gridData";// (rowCount % 2 ==0) ? "gridData" : "gridData";
									%>					
									<tr id ="trRowId<%=rowCount%>">
									<td width='20%'class='<%=classValue%>'  style='display:none'> <input type='hidden' name='seq_num<%=rowCount%>' id='seq_num<%=rowCount%>' value='<%=(String)orderSeqNo.get(rowCount)%>'>				
									</td>
									<td  class='gridNumericData' width='10%' align='right'> <a class='gridLink'  href="javascript:changeSeq('<%=rowCount%>','<%=(String)orderSeqNo.get(rowCount)%>')"><%=(String)orderSeqNo.get(rowCount)%> </a></td>
									<td width='50%'
									class='<%=classValue%>'><%=(String)arrayDesc.get(rowCount)%></td>	
									<td width='15%'  class='<%=classValue%>'>
									<input type='checkbox' name='selectYN<%=rowCount%>' id='selectYN<%=rowCount%>' value='<%=(String)flag.get(rowCount)%>' OnClick ='removeRow(<%=rowCount%>)' <%out.println("checked");%>>
									</td>
									</tr>		
									<input type ='hidden' name='sectionCode<%=rowCount%>' id='sectionCode<%=rowCount%>' value="<%=(String)discreteMeasureId.get(rowCount)%>">
									<%	
									rowCount++;					
									slno++;
								}
						}
								%>
								<tr style='display:none' id='extraRow'><td  id='extraTD'><a class='gridLink'  href="javaScript:changeSeq('<%=rowCount%>','<%=slno%>')"><%=slno%>
								</a></td><td></td><td ></td></tr>
								<% 	
					}
			}
		}
	else
		{			
		ArrayList orderSeqNo = new ArrayList();
		ArrayList arrayDesc = new ArrayList();
		ArrayList  discreteMeasureId  = new ArrayList();
		ArrayList flag = new ArrayList();
		ArrayList orderSeqNoList = new ArrayList();
		ArrayList arrayDescList = new ArrayList();
		ArrayList  discreteMeasureIdList  = new ArrayList();
		ArrayList flagList = new ArrayList();
		ArrayList indexList = new ArrayList();
		int positionOne = Integer.parseInt(firstPosition);
		positionOne = positionOne - 1;
		int positionTwo = Integer.parseInt(secondPosition);	
		positionTwo = positionTwo - 1;
		int totalRows = tempIntRowCount;
		String flag1 = "";
		String desc = "";
		String ordSeq = "";
		String discrt = "";
		if(!flag_for_list.equals("false"))
			{
			if(totalRows < positionTwo)
			positionTwo = positionTwo -1;
			else
			positionTwo = positionTwo;
			finalString = request.getParameter("finalString") == null? "" :request.getParameter("finalString");
			tokenizeTilde = new StringTokenizer(finalString,"~");
			if(!finalString.equals(""))
				{
				while(tokenizeTilde.hasMoreTokens())
					 {
						subString = tokenizeTilde.nextToken();
						tokenizePipe =  new StringTokenizer(subString,"||");
						description =tokenizePipe.nextToken();
						sectionCode = tokenizePipe.nextToken();
						seq_num = tokenizePipe.nextToken();
						flagY = tokenizePipe.nextToken();
						
						arrayDescList.add(description);
						discreteMeasureIdList.add(sectionCode);
						orderSeqNoList.add(seq_num);
						flagList.add(flagY);
					 }
						indexList.add(0,arrayDescList);
						indexList.add(1,orderSeqNoList);
						indexList.add(2,discreteMeasureIdList);
						indexList.add(3,flagList);
						bean.setArrayList(indexList);
						putObjectInBean("bean",bean,session);	
				}
				ArrayList list = bean.retrieveArrayList();
				arrayDesc = (ArrayList)list.get(0);
				orderSeqNo = (ArrayList)list.get(1);
				discreteMeasureId = (ArrayList)list.get(2);
				flag = (ArrayList)list.get(3);
				int j;
				for(j=0;j<orderSeqNo.size();j++)
					{	
						ordSeq= (String)orderSeqNo.get(j);
						desc= (String)arrayDesc.get(j);
						discrt= (String)discreteMeasureId.get(j);
						flag1= (String)flag.get(j);
						if(positionOne == j)
							{	
							arrayDesc.add(positionTwo,desc);
							discreteMeasureId.add(positionTwo,discrt);
							flag.add(positionTwo,flag1);
							if(positionTwo > positionOne)
								{
									j = orderSeqNo.size();
									
								}
							if(positionTwo > positionOne)
								{
									arrayDesc.remove(positionOne);
									discreteMeasureId.remove(positionOne);
									flag.remove(positionOne);
								}
						   else
								{
									arrayDesc.remove(positionOne + 1);
									discreteMeasureId.remove(positionOne + 1);
									flag.remove(positionOne + 1);
								}	
							}
					}
					list.add(0,arrayDesc);
					list.add(1,orderSeqNo);
					list.add(2,discreteMeasureId);
					list.add(3,flag);
					bean.setArrayList(list);
					putObjectInBean("bean",bean,session);	
					tempfinalString  = (String)bean.setFinalString(list);
			}
					
			String tempValue = request.getParameter("tempValue") == null ? "" : request.getParameter("tempValue");
				if(tempValue.equals("temp"))
					{
						finalString = request.getParameter("finalString") == null? "" :request.getParameter("finalString");
					}
				else
					{
								
						finalString = tempfinalString;
					}
				bean.setConcatenatedString(finalString);
				bean.setLength(0);
				tokenizeTilde = new StringTokenizer(finalString,"~");
				classValue = "gridData";
				while(tokenizeTilde.hasMoreTokens())
				 {
					//classValue = ((rowCount%2)==0 )? "QRYEVEN" : "QRYODD";
					subString = tokenizeTilde.nextToken();
					tokenizePipe =  new StringTokenizer(subString,"||");
					description =tokenizePipe.nextToken();
					sectionCode = tokenizePipe.nextToken();
					seq_num = tokenizePipe.nextToken();
					if(seq_num.equalsIgnoreCase("null"))
					{
						seq_num="";
					}

	%>
			<tr id ='trRowId<%=rowCount%>'>
				  <td width='20%' class='<%=classValue%>'  style='display:none'> <input type='hidden' name='seq_num<%=rowCount%>' id='seq_num<%=rowCount%>' value='<%=seq_num%>'>				
				  </td>
				  
				  <td class='gridNumericData'  width='10%'  align='right'> <a class='gridLink'  href="javascript:changeSeq('<%=rowCount%>','<%=seq_num%>')"> <%=seq_num%> </a></td>
				  <td width='50%' class='<%=classValue%>'><%=description%></td>
				  <td width='15%'   class='<%=classValue%>'>
				  <input type='checkbox' name='selectYN<%=rowCount%>' id='selectYN<%=rowCount%>' value='Y' OnClick ='removeRow(<%=rowCount%>)' <%out.println("checked");%>>
				  </td>
			</tr>							
			<input type ='hidden' name='sectionCode<%=rowCount%>' id='sectionCode<%=rowCount%>' value='<%=sectionCode%>'>
			<%			rowCount++;		
				}
	%>
			<tr style='display:none' id='extraRow'>
				<td ><a class='gridLink'  href="javaScript:changeSeq('<%=rowCount%>','<%=rowCount+1%>')"><%=rowCount+1%></a></td>
			</tr>
	<%
		}
	%>
</table>

	<input type ='hidden' name='finalString' id='finalString' value='<%=finalString%>'>     
	<input type ='hidden' name='array_length' id='array_length' value='<%=rowCount%>'> 
	<input type ='hidden' name='chartId' id='chartId' value=''> 
	<input type ='hidden' name='operation' id='operation' value=''> 
	<input type ='hidden' name='remove_value' id='remove_value' value=''> 
	<input type='hidden' name='firstPos' id='firstPos' value=''>
	<input type='hidden' name='secPos' id='secPos' value=''>
	<%
	putObjectInBean("bean",bean,session);	


	}
	catch(Exception ee)
	{
		//out.println("Exception in SectionChartList Block: "+ ee.toString());//common-icn-0181
		ee.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
%>	
</form>
</body>
</html>

