<!DOCTYPE html>
<%
/*	
--------------------------------------------------------------------------------------------------------------
 Date       	Edit History	Name       Rev.Date   	Rev.By    		Description
 --------------------------------------------------------------------------------------------------------------
 ?				?				?			?			?				?
 28/06/2020		IN072777		Ramesh G	01/07/2020	Ramesh Goli		AAKH-CRF-0097.2
 ---------------------------------------------------------------------------------------------------------------
 */
%>
<%@page import="java.sql.*,java.util.*, eCA.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	
	String selectedValues = (String) hash.get("selectedValues");
	String patientId= (String) hash.get("patientId");
	String functionId =(String) hash.get("functionId");
	
	String bean_id="CAVitalSignBean"+patientId;
    String bean_name="eCA.CAVitalSignBean";
	Map selectedMap =new TreeMap();
	CAVitalSignBean bean	= (CAVitalSignBean)getObjectFromBean( bean_id, bean_name , session); 
	//IN072777 Start.
	if("APPLCHARTS".equals(functionId)){
		ArrayList<String[]> chartDetails = new ArrayList<String[]>();
		String selDiscMsr =(String) hash.get("disMsrId");
		chartDetails=bean.getAppChartDetails(selDiscMsr);
		StringBuffer sb = new StringBuffer();
		for(int j=0;j<chartDetails.size();j++){
			String[] chartIdVal = chartDetails.get(j);
			String checkedVal = "";
			if("Y".equals(chartIdVal[2]))
				checkedVal="Checked";				
				sb.append("<input type='checkbox' id='ChartID"+j+"'  Value='"+chartIdVal[0]+"' "+checkedVal+"/>"+chartIdVal[1]+"<br>");				
		}
		sb.append("<input type='hidden' id='totChartCount'  name='totChartCount' id='totChartCount' Value='"+chartDetails.size()+"' />");
		out.print(sb.toString());
								
	}else{
	//IN072777 End.
		if("SELECTALL".equals(functionId)){
			
			bean.clearMap();
			selectedMap = bean.getSelectedRecords();		
			String[] selectedValuesArray = selectedValues.split(",");
			for(int i=0;i<selectedValuesArray.length;i++){
				String[] selectKeyVal = (selectedValuesArray[i]).split("~");
				selectedMap.put(selectKeyVal[0],Double.parseDouble(selectKeyVal[1]));
			}
			bean.setSelectedRecords(selectedMap);
		}else if("ADDMAP".equals(functionId)){	
			selectedMap = bean.getSelectedRecords();
			String[] selectKeyVal = (selectedValues).split("~");
			selectedMap.put(selectKeyVal[0],Double.parseDouble(selectKeyVal[1]));
			bean.setSelectedRecords(selectedMap);
		}else if("DELETEMAP".equals(functionId)){	
			selectedMap = bean.getSelectedRecords();
			String[] selectKeyVal = (selectedValues).split("~");
			selectedMap.remove(selectKeyVal[0]);
			bean.setSelectedRecords(selectedMap);
		}
		selectedMap = bean.getSelectedRecords();
		out.print(selectedMap.size());
	}	//IN072777
	putObjectInBean(bean_id,bean,session);
%>


