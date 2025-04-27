<!DOCTYPE html>
<!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
 
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
//Added for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		//String locale			= (String)session.getAttribute("LOCALE");
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String bean_id	="MedicalItemBean";
	String bean_name	="ePH.MedicalItemBean";
    String trade_id	="";	
   
	int j						=	0;
	String trade_name="";		
	String	manufacturer_id="";	
	String	manufacturer_name="";
	String	select="";			
	String	mode="";			
    String select_chk="";
    String classVal	="";
    String Drug_code_value="";
    String Check_trade_id="";
    boolean dup_found						=	false;   
	MedicalItemBean bean = (MedicalItemBean)getBeanObject(bean_id,bean_name ,request);

	Drug_code_value=request.getParameter("Drug_code_value");
	
	
	ArrayList	tradeList=	new ArrayList();
	ArrayList	CheckDuplicate=	new ArrayList();
	HashMap record=new HashMap();
	HashMap checkMap=new HashMap();
	tradeList=bean.getTradeNamesAll();
	CheckDuplicate=bean.getTradeResult();
  
   mode=request.getParameter("mode");
		
   for(j=0; j<tradeList.size(); j++){
		record	=	(HashMap)tradeList.get(j);
		mode			=	(String) record.get("mode");
   }

	ArrayList	TradeResult=	new ArrayList();
	if(Drug_code_value!=null)
	{
	TradeResult=bean.getResult();
	}
   if(tradeList!=null)
   {
   for(j=0; j<tradeList.size(); j++){
		record	=	(HashMap)tradeList.get(j);
       for(int k=0; k<CheckDuplicate.size(); k++)	{
			checkMap			=	(HashMap) CheckDuplicate.get(k);
			Check_trade_id	=	(String)checkMap.get("trade_id");
		  
         if(Check_trade_id.equals((String)record.get("trade_id"))){
				dup_found	=	true;
			  }
	   }
	     if(!dup_found)
	   {
	    TradeResult.add(record);
	   }
	}
   }
	
    bean.setTradeResult(TradeResult);
	
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugMaster.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/MedicalItem.js"></script>
		<!-- <script LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onKeyDown="lockKey()" topmargin="0" >
	<form name="MedicalItemDetailForm" id="MedicalItemDetailForm">
	<table cellpadding="0" cellspacing="0" width="98%"  border="1">
	<tr>
	<th  width="35%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
	<th  width="35%"><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></th>
	<th  width="35%" ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	</tr>

<%
 if(mode.equals("2")){
	for(j=0; j<TradeResult.size(); j++){
		record	=	(HashMap)TradeResult.get(j);
		trade_id			=	(String) record.get("trade_id");
		trade_name			=	(String) record.get("trade_name");
		manufacturer_id		=	(String) record.get("manufacturer_id");
		manufacturer_name	=	(String) record.get("manufacturer_name");
		select				=	(String) record.get("select");
    	if( select.equals("E"))
			select_chk="checked";
		else
			select_chk="";
	
   		if(j%2 == 0)
			classVal	= "QRYEVEN";
		else
			classVal	= "QRYODD";
%>
	<tr>
	<td width="35%" class="<%=classVal%>" wrap><%=trade_name%></a>
	<input type='hidden' name='trade_id<%=j%>' id='trade_id<%=j%>' value="<%=trade_id%>">
	<input type='hidden' name='trade_name<%=j%>' id='trade_name<%=j%>' value="<%=trade_name%>"></td>
	<td width="35%" class="<%=classVal%>" wrap><%=manufacturer_name%>
	<input type='hidden' name='manufacturer_id<%=j%>' id='manufacturer_id<%=j%>' value="<%=manufacturer_id%>">
	<input type='hidden' name='manufacturer_name<%=j%>' id='manufacturer_name<%=j%>' value="<%=manufacturer_name%>"></td>
	<td width="15%" align="center" class="<%=classVal%>">
	<input type='checkbox'  name='select<%=j%>' id='select<%=j%>'  value="<%=select%>" <%=select_chk%> onClick="sampleValues('<%=j%>')" > </td>
	<input type='hidden' name='select_chk1<%=j%>' id='select_chk1<%=j%>' value="">
	<script>
		parent.updateTradeNames("<%=tradeList.size()%>");
	</script>
<%
   }
 }
else if(mode.equals("1"))
{
for(j=0; j<tradeList.size(); j++){
		record	=	(HashMap)tradeList.get(j);
		trade_id			=	(String) record.get("trade_id");
		trade_name			=	(String) record.get("trade_name");
		manufacturer_id		=	(String) record.get("manufacturer_id");
		manufacturer_name	=	(String) record.get("manufacturer_name");
		select				=	(String) record.get("select");
		if( select.equals("E"))
			select_chk="checked";
		else
			select_chk="";
	
   		if(j%2 == 0)
			classVal	= "QRYEVEN";
		else
			classVal	= "QRYODD";
%>
	<tr>
	<td width="35%" class="<%=classVal%>" wrap><%=trade_name%></a>
	<input type='hidden' name='trade_id<%=j%>' id='trade_id<%=j%>' value="<%=trade_id%>">
	<input type='hidden' name='trade_name<%=j%>' id='trade_name<%=j%>' value="<%=trade_name%>"></td>
	<td width="35%" class="<%=classVal%>" wrap><%=manufacturer_name%>
	<input type='hidden' name='manufacturer_id<%=j%>' id='manufacturer_id<%=j%>' value="<%=manufacturer_id%>">
	<input type='hidden' name='manufacturer_name<%=j%>' id='manufacturer_name<%=j%>' value="<%=manufacturer_name%>"></td>
	<td width="15%" align="center" class="<%=classVal%>">
	<input type='checkbox'  name='select<%=j%>' id='select<%=j%>'  value="<%=select%>" <%=select_chk%> onClick="sampleValues('<%=j%>')" > </td>
	<input type='hidden' name='select_chk1<%=j%>' id='select_chk1<%=j%>' value="">
	<script>
		parent.updateTradeNames("<%=tradeList.size()%>");
	</script>
<%
  } 
}
%>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>" >
</form>
</body>
</html>
<% putObjectInBean(bean_id,bean,request); %>


