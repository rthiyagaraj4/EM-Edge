<!DOCTYPE html>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eXI.MonitorItemsBean " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>											  
<%
	request.setCharacterEncoding("UTF-8");	
	
	String domainID = request.getParameter("domainID") == null?"":request.getParameter("domainID");	
	System.out.println("domainID "+domainID);
	
	ArrayList tableList = (ArrayList)MonitorItemsBean.getDlftTables(domainID);
	//out.println("tableMap :: "+tableMap.size());
/*	dcrBeanObj.clearElementList();
	String mode = request.getParameter("mode")==null ? "": request.getParameter("mode");
	String callFrom = request.getParameter("callFrom")==null ? "": request.getParameter("callFrom");
	String retVal = "";
	List<String> beanTblList = null;
	if(mode.equals("A"))
		beanTblList = dcrBeanObj.getTableByIncdRefNo(incRefNo,false);
*/
														    
%>
<link rel='StyleSheet' href='../../eCA/html/DCRStyle.css' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCA/js/DCRTree.js' language='javascript'></script>	
<script language="javascript" src="../../eXH/js/SchemaBrowser.js" ></script>
</head>
<body onKeyDown="lockKey()" onMouseDown="CodeArrest()">
	<form name='DCRTblSearch' id='DCRTblSearch'>
		<table align='center'class='grid' width='100%'>
			<tr>
				<td class='columnheader'>Table Name</td>
				<td class='columnheader'>Select</td>
			</tr>					
			<tr>
				<td colspan="2">&nbsp;</td>				
			</tr>	
			<%				
				try
				{
					int listSize = tableList.size();					
					for(int i = 0; i < listSize; i++)
					{%>
						<tr>
							<td colspan="2"><A HREF="#" onClick="window.returnValue='<%= tableList.get(i) %>';window.close()"><%= tableList.get(i) %></A></td>
						</tr>
					<%}
				}
				catch(Exception e)
				{
					System.out.println("Exception in SchemaBrowserTableSearch: "+e);
					e.printStackTrace(System.err);
				}															    
			%>
			</tr>			
		</table>
	</form>
</body>

