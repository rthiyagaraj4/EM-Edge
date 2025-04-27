<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.EncSummCompRecBean summRecCompBean = (eCA.EncSummCompRecBean)getObjectFromBean("summRecCompBean","eCA.EncSummCompRecBean",session);	
	
	String groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
	String groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");	
	String groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");	
	
	String comp_flag = request.getParameter("comp_flag") == null ? "" : request.getParameter("comp_flag");
	String comp_type = request.getParameter("comp_type") == null ? "" : request.getParameter("comp_type");	
	String comp_id = request.getParameter("comp_id") == null ? "" : request.getParameter("comp_id");
	String comp_desc = request.getParameter("comp_desc") == null ? "" : request.getParameter("comp_desc");
	
	String comp_temp = request.getParameter("comp_temp") == null ? "" : request.getParameter("comp_temp");
	String comp_col_count = request.getParameter("comp_col_count") == null ? "" : request.getParameter("comp_col_count");
	//String comp_column = request.getParameter("comp_column") == null ? "" : request.getParameter("comp_column");
	String comp_column = "";
	
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
	String searchGroupType = request.getParameter("searchGroupType") == null ? "" : request.getParameter("searchGroupType");
	String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
	String flag = request.getParameter("flag") == null ? "" : request.getParameter("flag");
	String gFlag = request.getParameter("gFlag") == null ? "" : request.getParameter("gFlag");	
	
	String seq_num = request.getParameter("seq_num") == null ? "" : request.getParameter("seq_num");
	
	String noOfRows = request.getParameter("noOfRows") == null ? "" : request.getParameter("noOfRows");
	
	String index = request.getParameter("index") == null ? "0" : request.getParameter("index");	
	
	String selected_flag = request.getParameter("selected_flag") == null ? "0" : request.getParameter("selected_flag");	
	
	int numberOfRecs = 0;
	int tempNum = 0;
	
	String beanCompKey = "";
	
	if (comp_temp.equals(""))
		comp_temp = "@";
	
	if (comp_col_count.equals(""))
		comp_col_count = "@";
	
	if (comp_column.equals(""))
		comp_column = "@";
	
	beanCompKey = comp_flag + "~" + comp_type + "~" + comp_id;
	
	int indexof = summRecCompBean.getIndexOfElement(beanCompKey);	
	
	ArrayList indexList = new ArrayList();		
	
	if(called_from.equals("addComp"))
	{			
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!summRecCompBean.chkContainsKey(beanCompKey))
		{
			summRecCompBean.addRecords(beanCompKey,comp_flag + "~" + numberOfRecs + "~" + comp_type+"~" + comp_id + "~" + comp_desc + "~" +comp_temp+ "~" + comp_col_count + "~" +comp_column+"~" +selected_flag);
			summRecCompBean.addToList(tempNum,beanCompKey);
		}		
		putObjectInBean("summRecCompBean",summRecCompBean,session);
	}
	else if(called_from.equals("removeComp"))	{
		if(indexof !=-1){
			summRecCompBean.removeRec(beanCompKey);
			summRecCompBean.removeElement(indexof);
			putObjectInBean("summRecCompBean",summRecCompBean,session);
		}
	}	
	else if(called_from.equals("modComp"))	{
		if(indexof !=-1){
			summRecCompBean.addRecords(beanCompKey,comp_flag + "~" + numberOfRecs + "~" + comp_type+"~" + comp_id + "~" + comp_desc + "~" +comp_temp+ "~" + comp_col_count + "~" +comp_column+"~" +selected_flag);
			putObjectInBean("summRecCompBean",summRecCompBean,session);
		}
	}
	else if(called_from.equals("modCompAll"))	{	
		if(indexof !=-1){			
			summRecCompBean.addRecords(beanCompKey,comp_flag + "~" + numberOfRecs + "~" + comp_type+"~" + comp_id + "~" + comp_desc + "~" +comp_temp+ "~" + comp_col_count + "~" +comp_column+"~" +selected_flag);
			putObjectInBean("summRecCompBean",summRecCompBean,session);
		}
	}	
	else if(called_from.equals("resetBean"))	{		
		indexList = summRecCompBean.retrieveArrayList();		
		if(indexList.size() > 0 ){
			summRecCompBean.clearBean();
			putObjectInBean("summRecCompBean",summRecCompBean,session);
		}
	}	
	else if(called_from.equals("deleteComp"))	{
		if(!noOfRows.equals(""))
		{
			tempNum = Integer.parseInt(noOfRows);
			numberOfRecs = Integer.parseInt(noOfRows) + 1;
		}
		if(!summRecCompBean.chkContainsKey(beanCompKey))
		{
			summRecCompBean.addRecords(beanCompKey,comp_flag + "~" + numberOfRecs + "~" + comp_type+"~" + comp_id + "~" +selected_flag);
			summRecCompBean.addToList(tempNum,beanCompKey);
		}			
		putObjectInBean("summRecCompBean",summRecCompBean,session);	
	}	
	
%>
<html>
	<head>
		<script language='javascript' src='../../eCA/js/EncSummGroupComp.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
	<%

	if(called_from.equals("addComp"))
	{	
	%>
		<script>			
			parent.selectedCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddedCompList.jsp?mode=<%=mode%>&groupFlag=<%=groupFlag%>&groupType=<%=groupType%>&groupCode=<%=groupCode%>&flag_for_list=false";			
		</script>
	<%
	}
	else if(called_from.equals("removeComp"))
	{		
	%>
		<script>
			parent.selectedCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddedCompList.jsp?mode=<%=mode%>&groupFlag=<%=groupFlag%>&groupType=<%=groupType%>&groupCode=<%=groupCode%>&flag_for_list=false";						
		</script>				
	
	<%
	}
	else if(called_from.equals("modComp"))
	{		
	%>
		<script>
			parent.selectedCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddedCompList.jsp?mode=<%=mode%>&groupFlag=<%=groupFlag%>&groupType=<%=groupType%>&groupCode=<%=groupCode%>&flag_for_list=false";						
		</script>				
	
	<%
	}
	else if(called_from.equals("modCompAll"))
	{		
	%>
		<script>
			parent.selectedCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddedCompList.jsp?mode=<%=mode%>&groupFlag=<%=groupFlag%>&groupType=<%=groupType%>&groupCode=<%=groupCode%>&flag_for_list=false";						
		</script>				
	
	<%
	}
	else if(called_from.equals("sectionsPage"))
	{
		//out.println("<script>alert("sectionsPage");</script>");
	%>
		<script>
			parent.selectedCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddedCompList.jsp?mode=<%=mode%>&groupFlag=<%=groupFlag%>&groupType=<%=groupType%>&groupCode=<%=groupCode%>&flag_for_list=false";
			var searchText='<%=searchText%>';			
			if(searchText==""){
				parent.addCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddCompList.jsp?mode=<%=mode%>&groupFlag=<%=groupFlag%>&groupType=<%=groupType%>&groupCode=<%=groupCode%>&gFlag=<%=gFlag%>&searchText=encodeURIComponent(<%=searchText%>)&searchGroupType=<%=searchGroupType%>&flag=<%=flag%>";	
			}
			else{
				parent.addCompFrame.location.reload();
			}
		</script>	
	<%
	}	
	else if(called_from.equals("removeSearch"))
	{
		//out.println("<script>alert("removeSearch");</script>");
	%>
		<script>
			parent.selectedCompFrame.location.href = "../../eCA/jsp/EncSummGroupCompAddedCompList.jsp?mode=<%=mode%>&groupFlag=<%=groupFlag%>&groupType=<%=groupType%>&groupCode=<%=groupCode%>&flag_for_list=false";					
		</script>
	<%
	}	
	%>
	<form name='remRecForm' id='remRecForm'></form>
	</body>
</html>


