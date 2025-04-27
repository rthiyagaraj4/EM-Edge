<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------
Date       		Edit History      Name           Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------
07/11/2014		IN052210		Ramesh G		07/11/2014		Akbar S			System display inconsistency while viewing a graph from Charting and Clinical Event History 
																				Refer to attached screen shots.																
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String chkBox = request.getParameter("ChkdBoxes") == null ? "" : request.getParameter("ChkdBoxes");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String desc = request.getParameter("desc") == null ? "" : request.getParameter("desc");
	String code = request.getParameter("code") == null ? "" : request.getParameter("code");
	String uom = request.getParameter("uom") == null ? "" : request.getParameter("uom");
	String grpDetails = request.getParameter("grpDetails") == null ? "" : request.getParameter("grpDetails");
	String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
	String concTdObjValues = request.getParameter("concTdObjValues") == null ? "" : request.getParameter("concTdObjValues");
	eCA.ChartRecordingAddGroupBean chartingBean = null;
	try{	
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
		if(calledFrom.equals("RecMat"))
		{
			String noOfChkdBoxes = request.getParameter("noOfChkdBoxes") == null ? "" : request.getParameter("noOfChkdBoxes");
			int Chked = Integer.parseInt(noOfChkdBoxes);
			if(Chked == 1 && chkBox.equals("true"))
				chartingBean.clearBean();
		}
		if(chkBox.equals("true")){
			if(uom.equals("#$")) uom="%";
			desc = java.net.URLDecoder.decode(desc);
			//IN052210 Start.
			//String valueForMap = desc+ "~" + "Group 1" + "~" + "YorN" + "~" + concTdObjValues + "~" + uom;
			String valueForMap = desc + "~" + "YorN" + "~" + concTdObjValues + "~" + uom+ " ~" + "Group 1";
			//IN052210 End.
			chartingBean.addRecords(code,valueForMap);
			putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);
			out.println("Success");
		
		}else if(chkBox.equals("false")){
			chartingBean.removeRecord(code);		
			putObjectInBean("chartingBean"+patient_id+encounter_id,chartingBean,session);
			out.println("Success");
		}
	}catch(Exception e){
		System.out.println("Error ChartRecordingRemoveAddToGrpIntermediate.jsp---->"+e);
		out.println("fail");
	}	
	
	
%>
