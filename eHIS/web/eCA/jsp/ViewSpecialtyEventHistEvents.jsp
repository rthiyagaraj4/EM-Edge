<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "0" : request.getParameter("encounter_id");
	eCA.ChartRecordingAddGroupBean chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);		
	chartingBean.clearBean();
%>

<html>
<title><fmt:message key="eCA.ViewSpecialtyEventHistory.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 	
	<style>
A:active{
	color:white;
}
A:visited{
	color:white;
}
A:link {
	COLOR:white;
}

</style>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCA/js/ViewSpecialtyEventHist.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
//alert("<%=request.getQueryString()%>");
</script>
<BODY   class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='flowSheetEventsForm' id='flowSheetEventsForm'>
<div id='divUnitTitle' style='postion:relative'>
			<table width='100%' id='unitTitleTable' class='grid' align='center' >
				<TR><TH><fmt:message key="Common.Event.label" bundle="${common_labels}"/></TH><TH><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></TH><TH><!-- <input type='image' src='../../eCA/images/graph.gif' title='Click on the image to view the Graph' onClick='openGraph()'></input> --><a href="javascript:;" onClick='openWinForGrouping()'><img title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ClickHereToViewTheGraph.label","ca_labels")%>' src='../../eCA/images/graph.gif'></img></a></TH></TR>
			</TABLE>
		</div>
<table class='grid' width='100%' id='unitTable' align='center'>
<%
String disc_desc="";
String result_num_uom="";
String disc_id="";
String event_code="";
String result_type="";
String classValue="";
int ckavail=0;
LinkedHashMap temp_hashmap			= new LinkedHashMap();
String to_date=request.getParameter("to_date") == null ? "" : request.getParameter("to_date");
String from_date=request.getParameter("from_date") == null ? "" : request.getParameter("from_date");


if(encounter_id.equals("")) encounter_id = "0";
String fac_id = (String) session.getAttribute("facility_id");
String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
String Sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");

String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement("SELECT DISTINCT A.discr_msr_id discr_msr_id,B.short_desc short_desc,A.result_num_uom uom,A.EVENT_CODE event_code,A.RESULT_TYPE result_type   FROM CA_SPLTY_DISCR_MSR A,  AM_DISCR_MSR B WHERE patient_id="+"'"+patient_id+"'"+" AND module_id="+"'"+module_id+"'"+" AND cycle_no="+cycle_no+" AND A.Discr_msr_id=B.Discr_msr_id AND A.trans_date>=TO_DATE("+"'"+from_date+"'"+",'dd/mm/yyyy HH24:MI') AND A.trans_date<=TO_DATE("+"'"+to_date+"'"+",'dd/mm/yyyy HH24:MI') ORDER BY 1");

		pstmt = con.prepareStatement("SELECT DISTINCT A.discr_msr_id discr_msr_id,B.short_desc short_desc,A.result_num_uom uom,A.EVENT_CODE event_code,A.RESULT_TYPE result_type   FROM CA_SPLTY_DISCR_MSR A,  AM_DISCR_MSR B WHERE A.patient_id=? AND A.module_id=? AND A.cycle_no=? and A.TASK_CODE=? AND A.Discr_msr_id=B.Discr_msr_id AND A.trans_date  between TO_DATE(?,'dd/mm/yyyy HH24:MI:ss') and TO_DATE(?,'dd/mm/yyyy HH24:MI:ss') ORDER BY 1");

		try
		{

			pstmt.setString(1,patient_id);
			pstmt.setString(2,module_id);
			pstmt.setString(3,cycle_no);
			pstmt.setString(4,"MCT002");
			pstmt.setString(5,from_date);
			pstmt.setString(6,to_date);

			rs = pstmt.executeQuery();
			while (rs.next())
			{
				disc_id = rs.getString(1);
				disc_desc = rs.getString(2);
				result_num_uom= rs.getString(3);
				event_code= rs.getString(4);
				result_type= rs.getString(5);
				if(temp_hashmap.containsKey(disc_id))
				disc_id=disc_id+" ";
				temp_hashmap.put(disc_id,disc_desc+"!!"+result_num_uom+"!!"+event_code+"!!"+result_type);
			}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//COMMON-ICN-0181
			 ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}%>
	
	<%
	Set s;
	Iterator it;
	s = temp_hashmap.entrySet();
	it = s.iterator();
	int i=0;
	int tempGrafSeq = 0;
	while (it.hasNext()){
	String temp_value=it.next().toString();
	String[] hashValues=temp_value.split("=");
	disc_id=hashValues[0];

	String[] Values=hashValues[1].split("!!");
	if(i % 2 == 0){
			classValue = "gridDataChart";
		}else{
			classValue = "gridDataChart";
		}
	if(Values[1].equals("null"))
	Values[1]=" ";
	disc_desc=Values[0];
	result_num_uom=Values[1];
	event_code=Values[2];
	result_type=Values[3];
	out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
	out.println("<TD class='"+classValue+"'>&nbsp;"+disc_desc+"</TD>");
	out.println("<TD class='"+classValue+"'>"+result_num_uom+"&nbsp;<input type='hidden' name='result_type"+tempGrafSeq+"' id='result_type"+tempGrafSeq+"' value='"+result_type+"'></TD>");
	if(result_type.equals("N") || result_type.equals("I"))
	{
		if(result_num_uom.equals("") || result_num_uom == null) result_num_uom = " ";
		out.println("<TD  class='"+classValue+"' align=center><input type='checkbox' id='chkGraphID"+tempGrafSeq+"' name='chkGraph"+tempGrafSeq+"' id='chkGraph"+tempGrafSeq+"' value='"+event_code+"' onClick='constructValsForGraph("+tempGrafSeq+",this);limitTheGraphs(this)'></input><input type='hidden' name='UOM"+tempGrafSeq+"' id='UOM"+tempGrafSeq+"' value='"+result_num_uom+"'><input type='hidden' name='desc"+tempGrafSeq+"' id='desc"+tempGrafSeq+"' value='"+disc_desc+"'><input type='hidden' name='disc_id"+tempGrafSeq+"' id='disc_id"+tempGrafSeq+"' value='"+disc_id+"'></TD>");
		ckavail++;
		}
		else
		{
		out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
		}
	out.println("</TR>");
	i++;
	tempGrafSeq++;
				
	}
%>
<!-- <TR style='visibility:hidden'><td class='WHITE' ><fmt:message key="Common.Event.label" bundle="${common_labels}"/></TH><TH class='WHITE' ><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></TH><TH class='WHITE'><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/></TH> </TR> -->
<TR style='visibility:hidden' height:5%;><TH><fmt:message key="Common.Event.label" bundle="${common_labels}"/></TH><TH><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></TH><TH><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/></TH> </TR>

</Table>
	<%	if(i != 0)
					{
					%>
					<script>
			//setTimeout("alignUnitsAndTitle()",100);							
			parent.dataFrame.location.href="../../eCA/jsp/ViewSpecialtyEventHistEventDetails.jsp?to_date=<%=to_date%>&from_date=<%=from_date%>&patient_id=<%=patient_id%>&module_id=<%=module_id%>&cycle_no=<%=cycle_no%>";
			alignUnitsAndTitle();
					</script>
				<%
					}
					else
					{
				%>
					<script>
						parent.dataFrame.location.href="../../eCommon/html/blank.html";
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.";
					</script>
				<%}%>
<input type=hidden name="sentFromGraph" id="sentFromGraph" value=''>
<input type=hidden name="flagGraph" id="flagGraph" value='N'>
<input type=hidden name='rowsForGraph' id='rowsForGraph' value='<%=i%>'>
<input type=hidden name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type=hidden name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type=hidden name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type=hidden name="facility_id" id="facility_id" value="<%=fac_id%>">
<input type=hidden name="location_code" id="location_code" value="<%=location_code%>">
<input type=hidden name="Sex" id="Sex" value="<%=Sex%>">
<input type=hidden name="splChartType" id="splChartType" value=''>
<input type=hidden name="noOfChkdBoxes" id="noOfChkdBoxes" value='0'>
<input type=hidden name="noOfGroups" id="noOfGroups" value=''>

</form>
</body>
</html>

