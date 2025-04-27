
 <%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567							
------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>		
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		session = request.getSession(false);
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String restrictId		= "",value="";
		String restrictDataType	= "";		
		String recHistType		= "";
			String selectall_H= "";
		String selectall_E= "";
		int selectallHcheck=0;
		int selectallEcheck=0;
		String bean_id			= "@CARestrictCEHDataBean";
		String bean_name		= "eCA.CARestrictCEHDataBean";
		ArrayList histRecTypes = new ArrayList();
		ArrayList eventClassTypes = new ArrayList();
		restrictDataType	= request.getParameter("restrictDataType")==null?"H":request.getParameter("restrictDataType");
		recHistType			= request.getParameter("recHistType")==null?"":request.getParameter("recHistType");
		restrictId			= request.getParameter("restrictId");		
		CARestrictCEHDataBean bean	= (CARestrictCEHDataBean)getObjectFromBean( bean_id, bean_name , session) ; 
		HashMap<String,String> restrictData = bean.getRestrictData();		
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src="../../eCommon/js/common.js"></script>
		<script language='javascript' src="../../eCA/js/CARestrictCEHData.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
	</head>
	<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
		<form name="CARestrictCEHDataResultForm" id="CARestrictCEHDataResultForm" action="../../servlet/eCA.CARestrictCEHDataServlet" method="post" target="messageFrame">
			<BR><BR>
			<table cellpadding='3' cellspacing='0' border='0' width='60%' align='center'>		
				<%if("H".equals(restrictDataType)){%>
					<tr align="left">		
						<th class='COLUMNHEADER' width='80%'>
							<fmt:message key="eCA.HistoryRecordTypes.label" bundle="${ca_labels}"/>
						</th>
						<th class='COLUMNHEADER' width='20%'>
							Select All &nbsp;&nbsp; <input type="checkbox" name="totalHCheck" id="totalHCheck" value="<%=selectall_H %>" <%if("Y".equals(selectall_H)){%> Checked <%} %> onclick="checkAll('<%=restrictId%>','H','',this)" />&nbsp;
						</th>
					</tr>
				<%
					histRecTypes = (ArrayList)bean.getHistRecType(locale);
						for(int i=0;i<histRecTypes.size();i++){
						String[] histList  = (String[])histRecTypes.get(i);
						String check=restrictData.get(restrictId+"|"+restrictDataType+"|"+histList[0]+"|*ALL");
						if(check==null)
							check="N";
				%>
					<tr>
						<td class='label' width='80%'><%=histList[1]%></td>
						<td class='gridData' width='20%'>
							<input type="checkbox" name="<%=restrictId+"|"+restrictDataType+"|"+histList[0]+"|*ALL"%>" id="<%=restrictId+"|"+restrictDataType+"|"+histList[0]+"|*ALL"%>" value="<%=check%>"  onclick="checkedObj(this);" <%if("Y".equals(check)){%>Checked<%}else{selectallHcheck++;}%>/>						
						</td>
					</tr>
				<%
					}
				}else if("E".equals(restrictDataType)){%>
					<tr align="left">		
						<td class='COLUMNHEADER' width='80%'>
							<fmt:message key="eCA.EventClassType.label" bundle="${ca_labels}"/>
						</td>
						<td class='COLUMNHEADER' width='20%'>
							Select All &nbsp;&nbsp; <input type="checkbox" name="totalECheck" id="totalECheck" value="<%=selectall_E %>" <%if("Y".equals(selectall_E)){%>Checked<%} %> onclick="checkAll('<%=restrictId%>','E','<%=recHistType%>',this)" />&nbsp;
						</td>
					</tr>
				<%
					eventClassTypes = (ArrayList)bean.getEventClass(recHistType,locale);
					for(int i=0;i<eventClassTypes.size();i++){
					String[] eventClass  = (String[])eventClassTypes.get(i);
					String check=restrictData.get(restrictId+"|"+restrictDataType+"|"+recHistType+"|"+eventClass[0]);
						if(check==null)
							check="N";
				%>
					<tr>
						<td class='label' width='80%'><%=eventClass[1]%></td>
						<td class='gridData' width='20%'>
							<input type="checkbox" name="<%=restrictId+"|"+restrictDataType+"|"+recHistType+"|"+eventClass[0]%>" id="<%=restrictId+"|"+restrictDataType+"|"+recHistType+"|"+eventClass[0]%>" value="<%=check%>"  onclick="checkedObj(this);" <%if("Y".equals(check)){%>Checked<%}else{selectallEcheck++;}%>/>												
						</td>
					</tr>
				<%
					}	
				}%>				
			</table>
			<input type="hidden" name="restrictId" id="restrictId" value="<%=restrictId%>"/>
			<input type="hidden" name="restrictDesc" id="restrictDesc" value=""/>
			<input type="hidden" name="histFunction" id="histFunction" value=""/>
			<input type="hidden"  id="restrictData" name="restrictData" id="restrictData" value="<%=restrictData%>"/>
			<input type="hidden"  id="restrictDataType" name="restrictDataType" id="restrictDataType" value="<%=restrictDataType%>"/>
			<input type="hidden"  id="selectall_H" name="selectall_H" id="selectall_H" value="<%=selectall_H%>"/>
			<input type="hidden"  id="selectall_E" name="selectall_E" id="selectall_E" value="<%=selectall_E%>"/>
			<input type="hidden"  id="count_hash_event" name="count_hash_event" id="count_hash_event" value="<%=eventClassTypes.size()%>"/>
			<input type="hidden"  id="count_hash_hist" name="count_hash_hist" id="count_hash_hist" value="<%=histRecTypes.size()%>"/>
		</form>
		<script>
		if(<%=selectallHcheck%>==0 && document.getElementById("restrictDataType").value=="H" && document.getElementById("count_hash_hist").value!=0)
			document.getElementById("totalHCheck").checked=true;
		 if(<%=selectallEcheck%>==0 && document.getElementById("restrictDataType").value=="E" && document.getElementById("count_hash_event").value!=0)
			document.getElementById("totalECheck").checked=true;
		
		</script>
	</body>
</html>	

