<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="eOR.SceduleFreqeuncyInterface" %>

<html>
<head>
	<title><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//String bean_id	= "OrScheduleFreq" ;
	//String bean_name= "eOR.ScheduleFrequencyCompBean";
	ArrayList dateList = null;
	ArrayList dayList = null;

	String bean_id_P			= request.getParameter("bean_id");
	String bean_name_P			= request.getParameter("bean_name");
	String repeat			= request.getParameter("repeat");
	HashMap schdMap = null;
	
	//OrderEntryBean beanEntry				= (OrderEntryBean)getBeanObject( "orderentrybean", "eOR.OrderEntryBean", request ) ;

	Object beanCaller			 =  getBeanObject(bean_id_P,bean_name_P,request);
	SceduleFreqeuncyInterface rec= (SceduleFreqeuncyInterface)beanCaller ;

	HashMap str = rec.getScheduleDates();	
	System.out.println("ViewScheduleDates str     :    "+str);
	System.out.println("ViewScheduleDates repeat     :    **"+repeat+"**");
	
	if(str != null){		
		System.out.println("str    :   "+str);
		schdMap = (HashMap) str.get(Integer.parseInt(repeat));
		System.out.println("schdMap    :   "+schdMap);
	}
	System.out.println("ViewScheduleDates   schdMap     :    "+schdMap);
	if(schdMap != null)
	{
		dateList = (ArrayList)schdMap.get("DATES");
		dayList = (ArrayList)schdMap.get("DAYS");
	}

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
 
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="scheduleDates" id="scheduleDates">
<div id = 'dateList' >
<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" class="grid">
	<%
		int k = 0;
		if(dateList != null && dateList.size() > 0){
			for(int i = 0;i<dateList.size();i++)
			{
				if(k==0){ %>
					<tr>		
				<%}%>
					<td class="gridData" >
							<%=(String)dateList.get(i)%> <br/>
							<font weight='bold' color='#990000'><Strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(String)dayList.get(i)%></Strong></font>
					</td>		
					
	<%	
			if(k == 3) {
				k=0;
		%>
				</tr>
<%		}else
				k++;
			}		
		}
	%>	
</table>
</div>
<table width="100%">
	<tr>
		<td align="right">
				<input type="button" name="close" id="close" value="Close" onclick="parent.document.getElementById('dialog_tag').close();">
		</td>			
	</tr>
</table>
</body>
</html>





