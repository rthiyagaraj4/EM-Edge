<!DOCTYPE html>
<%
/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Chowminya												SKR-CRF-0036
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
	String function_from= request.getParameter("function_from") == null ? "" : request.getParameter("function_from");
	String modifyYN= request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");

	String textReadOnly = "";
	String imageDisabled = "";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String chartRef= request.getParameter("chartRef")==null?"":request.getParameter("chartRef");
	String chtId = request.getParameter("Chart_Id")==null?"":request.getParameter("Chart_Id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
	String facility_id = session.getValue("facility_id")==null ? "" : (String)session.getValue("facility_id");
	String sysdate = "";
	String encounterId = request.getParameter("encounter_id")==null ? "0" : request.getParameter("encounter_id");
	String module_id = request.getParameter("module_id")==null ? "" : request.getParameter("module_id");

	String practitioner_id = session.getValue("ca_practitioner_id")==null ? "" : (String)session.getValue("ca_practitioner_id");
	
	String admDtChk = "";
	if(!adm_date.equals(""))
		admDtChk = "Y";
	else
		admDtChk = "N";

	if(encounterId.equals("")) encounterId = "0";

	String fromDateForExt = "";
	String toDateForExt = "";
	String displayMandatory = " style = display:none";

	if(encounterId.equals("0"))
		displayMandatory = " style = display";
	else
		displayMandatory = " style = display:none";

%>
<html>
<head>
	<%
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String imgUrl="";
		if(sStyle.equals("IeStyle.css")){
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		 }
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/ViewChartRecording.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" OnLoad='defaultValue()'>
<form name ="ChartLayoutCriteriaForm"  >
	<table border="0" cellpadding="3" cellspacing="0"  width="100%"  >
		<tr>
			<td colspan='2'  width='100%'>
				<table border="0" cellpadding="3" cellspacing="0" id='tbId' width="100%" valign='bottom'>
					<tr>
						<td width='10%' class='label' ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/></td>
						<td width='20%' class='fields'  nowrap >
							<select name='chart_id' id='chart_id' onchange='loadChart(this);'>							
								<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option><%
									Connection con = null;
									PreparedStatement pstmt =null;
									ResultSet rs= null;
									String systime ="";
									String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
									String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
									String Sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
									String pract_type =(String) session.getValue("practitioner_type")==null ? "" : (String) session.getValue("practitioner_type");
									String facilityId = (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
									String respId = (String)	session.getValue("responsibility_id")==null ? "" :(String)	session.getValue("responsibility_id") ;
									//String relnId = (String)session.getValue("relationship_id")==null ? "" :(String)	session.getValue("relationship_id") ;
									String relnId = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id") ;
									String sqlAuth = "";
									String errorAuth = "";
									String chart_Default="";
									try{
										con = ConnectionManager.getConnection(request);											
										pstmt = con.prepareStatement("SELECT DISTINCT CC.CHART_ID,CC.SHORT_DESC FROM CA_VIEW_CHART_CONFIG CVCC , CA_CHART CC WHERE CC.CHART_ID=CVCC.CHART_ID   ORDER BY 2");
										rs = pstmt.executeQuery();										
										String chartId = "";
										String chartDesc = "";										
										while(rs.next()){											
											chartId = rs.getString(1);
											chartDesc = rs.getString(2);											
											%>
											<option value="<%=chartId%>" <%=chart_Default%> ><%=chartDesc%> </option>
											<%
										
										}

										if (pstmt!=null) pstmt.close();
										if( rs!=null) rs.close();

										
									}catch(Exception e){
										//out.println(e.toString());//COMMON-ICN-0181
										e.printStackTrace();//COMMON-ICN-0181
									}finally{
										if(con!=null)
											ConnectionManager.returnConnection(con,request);
									}
%>
							</select>
							<img align=center src='../../eCommon/images/mandatory.gif'></img>
						</td>						
						<td class=label colspan="2" width='17%' nowrap>
							<INPUT TYPE="checkbox" name="def_Chart_Check" id="def_Chart_Check" onClick="setDefaultChart(this)">&nbsp;Default Chart
						</td>
						
						<td  class='label' width='7%' nowrap>
							<fmt:message key="Common.Period.label" bundle="${common_labels}"/>
						</td>
						<td width='25%' class='fields' nowrap >
							<input type='textbox' id='fromDate' name='fromDate' id='fromDate' value='<%=fromDateForExt%>' size='14' maxlength='16' onblur="ValidateDateTimeOfPeriod(this,toDate)"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDate')"></img>-<input type='textbox' id='toDate' name='toDate' id='toDate' value='<%=toDateForExt%>' size='14' maxlength='16' onblur="ValidateDateTimeOfPeriod(fromDate,this)"><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDate')"></img><img SRC="../../eCommon/images/mandatory.gif"></img>
						</td>
						
						<td width='21%' align='right' nowrap >							
							<input type='button' name='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class=button onclick="SearchChart('jsp')">
							<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class=button onclick="resetCriteria();">
							&nbsp;&nbsp;
						</td>
					
						
					</tr>
					
				</table>
			</td>
		</tr>
	</table>
<%if(!imgUrl.equals("")){ %>
	<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}
sysdate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
String def_chart_id = "";
	try{
		con = ConnectionManager.getConnection(request);											
		pstmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = '"+practitioner_id+"'");
		rs = pstmt.executeQuery();			
		if(rs.next()){											
			def_chart_id = rs.getString(1);	
		}
		if (pstmt!=null) pstmt.close();
		if( rs!=null) rs.close();		
	}catch(Exception e){
		//out.println(e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
<input type=hidden name='locale' id='locale' value='<%=locale%>'>
<input type=hidden name='adm_date' id='adm_date' value='<%=adm_date%>'>
<input type=hidden name='practitioner_id' id='practitioner_id' value='<%=practitioner_id%>'>
<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type=hidden name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounterId%>'>

<input type=hidden name='p_called_from' id='p_called_from' value='<%=p_called_from%>'> <!--   IN037701 -->
<input type=hidden name='derChartId' id='derChartId' value ='<%=def_chart_id %>'/>
<script>
var fDate = document.forms[0].fromDate.value;
var tDate = document.forms[0].toDate.value;

if(fDate=="")
	document.forms[0].toDate.value = '<%=sysdate %>';
if (tDate=="")
	document.forms[0].fromDate.value=minusDate('<%=sysdate %>',"DMY",'<%=locale%>','4',"d");

</script>

<script>
var def_chart_id = document.forms[0].derChartId.value;
if(def_chart_id!=""){
	document.forms[0].chart_id.value=trimString(def_chart_id);
	document.forms[0].def_Chart_Check.checked = true ;
	SearchChart('jsp');
}else{
	document.forms[0].chart_id.value=trimString(def_chart_id);
	document.forms[0].def_Chart_Check.checked = false ;
}
</script>
</form>
</body>
</html>

