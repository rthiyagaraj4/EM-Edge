<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
16/02/2021   6030		 SIVABAGYAM M	RAMESH G      	16/02/2021			ML-MMOH-CRF-1542
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	
	eCA.ChartRecordingAddGroupBean chartingBean = null; //(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	if(flowsheetGraph.equals("Y"))
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}
	else
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}



%>
<html>
	<head>
		<%
			
			String chkBox = request.getParameter("ChkdBoxes") == null ? "" : request.getParameter("ChkdBoxes");
			String desc = request.getParameter("desc") == null ? "" : request.getParameter("desc");
			String code = request.getParameter("code") == null ? "" : request.getParameter("code");
			String uom = request.getParameter("uom") == null ? "" : request.getParameter("uom");
			String concTdObjValues = request.getParameter("concTdObjValues") == null ? "" : request.getParameter("concTdObjValues");
			String grpDetails = request.getParameter("grpDetails") == null ? "" : request.getParameter("grpDetails");
			String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
			//6030 STARTS
			HashMap records=new HashMap();
			records=chartingBean.getRecords();
			desc = java.net.URLDecoder.decode(desc);
			String mapdesc="",yorn="",contobjvalues="",tempuom="",groups="";
		String values="",valueForMap="";
		boolean sitespecific=false;
		sitespecific=chartingBean.isSiteSpecific("VIEWGRAPH_FOR_PANEL");
		sitespecific=true;
			//IN052210 Start.
			//String valueForMap = desc+ "~" + "Group 1" + "~" + "YorN" + "~" + concTdObjValues + "~" + uom;
			if(sitespecific){
			if(records.containsKey(code)){
				values=(String)records.get(code);
				StringTokenizer strToken1=new StringTokenizer(values,"~");
				while(strToken1.hasMoreTokens())
				{
					mapdesc=strToken1.nextToken();
					yorn=strToken1.nextToken();
					contobjvalues=strToken1.nextToken();
					tempuom=strToken1.nextToken();
					groups=strToken1.nextToken();
					concTdObjValues=concTdObjValues+contobjvalues+">";
				}
			} 
			}
			//6030 ENDS
				  valueForMap = desc + "~" + "YorN" + "~" + concTdObjValues + "~" + uom + " ~" + "Group 1";
			//IN052210 End.
			if(calledFrom.equals("RecMat"))
			{
				String noOfChkdBoxes = request.getParameter("noOfChkdBoxes") == null ? "" : request.getParameter("noOfChkdBoxes");
				int Chked = Integer.parseInt(noOfChkdBoxes);
				if(Chked == 1 && chkBox.equals("true"))
					chartingBean.clearBean();
			}
			
			chartingBean.addRecords(code,valueForMap);
			if(flowsheetGraph.equals("Y"))
				putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
			else
				putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);
		%>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script>
			if('<%=chkBox%>' == "true")
			{
				if('<%=calledFrom%>' != 'RecMat' && parent.ChartRecordingDetailFrame != null)
					parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.grpDetails.value = '<%=grpDetails%>';
			}
			
			/*if('<%=chkBox%>' == "true" && parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value > 1)
			{
				var noOfChkdBoxes = parent.ChartRecordingDetailFrame.document.ChartLayoutDetailForm.noOfChkdBoxes.value;
				var dialogTop		=	"80" ;
				var dialogHeight= "25" ;
				var dialogWidth = "40" ;
				var status			=	"no";
				var arguments		=	"" ;
				var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
				var action_url		=	'../../eCA/jsp/ChartRecordingGroupsFrame.jsp?desc=<%=desc%>&noOfChkdBoxes='+noOfChkdBoxes;
				var retVal=window.showModalDialog(action_url,arguments,features);		
				parent.window.returnValue=retVal
			}	*/		
		</script>
	</head>
	<%
		if(chkBox.equals("false"))
		{
			chartingBean.removeRecord(code);
			if(flowsheetGraph.equals("Y"))
				putObjectInBean("flowsheetBean"+patient_id+encounter_id,chartingBean,session);
			else
				putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);
		}
	%>
	<body onKeyDown="lockKey()">
		<form name='chartRecAddToGrpFrom' id='chartRecAddToGrpFrom'>			
		</form>
	</body>
</html>

