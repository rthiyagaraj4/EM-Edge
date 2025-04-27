<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History  			    Name				R.Name			R.date				Description		
--------------------------------------------------------------------------------------------------------------

20/11/2018		ML-MMOH-SCF-1108		Kamalakannan 		Ramesh G			20/11/2018			ML-MMOH-SCF-1108
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- JSP Page specific attributes end --%>

<!--this is for futher simulteanous user -->
<%@ page isThreadSafe="false"%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/OrderCatalog.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		int returnval = 0;
		HashMap editorInstrn = new HashMap();
		List syncPrDr = new ArrayList();
		String bean_id		=	"Or_OrderCatalog" ;
		OrderCatalogBean bean = null;
		bean = (OrderCatalogBean)getBeanObject( bean_id.trim(),"eOR.OrderCatalogBean",request) ;
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action")==null?"":request.getParameter("action");
		ArrayList recordAgesexTemp = new ArrayList();
try
	{
		if("IMDetails".equals(action)){			
			String sex = request.getParameter("sex")==null?"":request.getParameter("sex");
			String minAgeInDays = CommonBean.checkForNull(request.getParameter("minAgeInDays"),"0");
			String minAgeInMths = CommonBean.checkForNull(request.getParameter("minAgeInMths"),"0");
			String minAgeInYrs = CommonBean.checkForNull(request.getParameter("minAgeInYrs"),"0");
			String maxAgeInDays = CommonBean.checkForNull(request.getParameter("maxAgeInDays"),"0");
			String maxAgeInMths = CommonBean.checkForNull(request.getParameter("maxAgeInMths"),"0");
			String maxAgeInYrs = CommonBean.checkForNull(request.getParameter("maxAgeInYrs"),"0");
			String index = request.getParameter("index")==null?"":request.getParameter("index");
			String l_instrnContentSync = request.getParameter("instrnContentSync")==null?"":request.getParameter("instrnContentSync");
			Hashtable currRecTemp = new Hashtable();
			currRecTemp.put("sex_spec_ind", sex);
			currRecTemp.put("min_age_in_days", minAgeInDays);
			currRecTemp.put("min_age_in_mths", minAgeInMths);
			currRecTemp.put("min_age_in_yrs", minAgeInYrs);
			currRecTemp.put("max_age_in_days", maxAgeInDays);
			currRecTemp.put("max_age_in_mths", maxAgeInMths);
			currRecTemp.put("max_age_in_yrs", maxAgeInYrs);
			currRecTemp.put("pat_preps_or_instrns_free_fmt_im", request.getParameter(l_instrnContentSync)==null?"":request.getParameter(l_instrnContentSync));
			int  arrayListLength = bean.getInstructionsRecStrTemp1Size();
				if("".equals(index)){//condition for insert
					if(arrayListLength!=0){
						recordAgesexTemp = (ArrayList)((HashMap)bean.getInstructionsRecStrClob()).get("pat_preps_or_instrns_free_fmt_im");
						boolean flag = bean.chkRangeOverLapTemp(recordAgesexTemp, currRecTemp, recordAgesexTemp.size());
							if(flag){
								HashMap tabToMap = new HashMap();
								tabToMap.putAll(currRecTemp);
								recordAgesexTemp.add(tabToMap);
								returnval = bean.setInstructionsRecStrClob("pat_preps_or_instrns_free_fmt_im",recordAgesexTemp);
							}else{
								returnval = 0;
							}
						
					}else{
						HashMap tabToMap = new HashMap();
						tabToMap.putAll(currRecTemp);
						recordAgesexTemp.add(tabToMap);
						returnval = bean.setInstructionsRecStrClob("pat_preps_or_instrns_free_fmt_im",recordAgesexTemp);
					}
				}else{//condition for modification
					recordAgesexTemp = (ArrayList)((HashMap)bean.getInstructionsRecStrClob()).get("pat_preps_or_instrns_free_fmt_im");
					HashMap tabToMap = new HashMap();
					tabToMap.putAll(currRecTemp);	
					recordAgesexTemp.set(Integer.parseInt(index),tabToMap);
					returnval = 1;
				}
		}else{
			String l_instrnContentSync = request.getParameter("instrnContentSync")==null?"":request.getParameter("instrnContentSync");
			HashMap d = new HashMap();
			editorInstrn =(HashMap)bean.getInstructionsRecStrClob();
			editorInstrn.put("clobContent",request.getParameter(l_instrnContentSync));
			returnval = bean.setInstructionsRecStrClob(l_instrnContentSync,editorInstrn);
		}
	}
catch(Exception e){
		System.out.println("Exp in OrderCatalogsync.jsp"+e.getMessage());
		e.printStackTrace();
	}

	if(returnval == 1)
	{
	%>	
		<script>
		top.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num=';
		</script>
	<%
	}
	else{%>
		<script>
			top.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num=';
		</script>
	<%}
	%>
	<%
	putObjectInBean(bean_id,bean,request);
	%>
</body>
</html>

