<% 
/*
-------------------------------------------------------------------------------------------------------------------------------
	Date		Edit History	   Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
05/11/2024	    70709         Gunasekar R          06/11/2024   Ashwini Ragupathi    ML-MMOH-CRF-1759
---------------------------------------------------------------------------------------------------------------------------------
*/   
%>
<%@ page import ="eCA.CAMenstrualHistDtlTransBean,java.sql.*,webbeans.eCommon.*, java.text.* ,eOR.Common.*,eCA.CAOpenChartServlet, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String legendstyle		= "padding-left:0px;padding-right:0px";

java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p1.getProperty("LOCALE");
String facilityId = (String) session.getValue("facility_id");
String validateSes= request.getParameter("validateSes")==null?"":request.getParameter("validateSes");
if(!validateSes.equals("Y")){
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../js/CAMenu.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../js/MenstrualHistPatList.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/CACommon.js'></script>	
    <script language='javascript' src='../../eCommon/js/common.js'></script>
    <script>
function scrollTitle()
{
	  var y = document.body.scrollTop;

	  if(y == 0){
		document.getElementById('divDataTitle').style.position = 'static';
		document.getElementById('divDataTitle').style.posTop  = 0;
	  }else{
		document.getElementById('divDataTitle').style.position = 'relative';
		document.getElementById('divDataTitle').style.posTop  = y-2;
	  }
	}
	function alignWidth(){	
		var totalRows =  document.getElementById('dataTable').rows.length;		
		var counter = totalRows-1;
		//alert(document.getElementById('dataTitleTable').rows.length);
		var temp = document.getElementById('dataTitleTable').rows(0).cells.length;
		for(var i=0;i<temp;i++) 
		{
			document.getElementById('dataTitleTable').rows(0).cells(i).width = document.getElementById('dataTable').rows(counter).cells(i).offsetWidth-8;
		}
	}


</script>
    <head>
    </head>	
	<style>
		.gridDataSelectNew
		{
			background-color: #CDE5FF;
			font-family: Verdana;
			font-size: 8pt;
			color: #000000;
			font-weight:normal;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;	
			border-bottom:0px;
			border-top:0px;
			border-left:0px;
			border-right:0px;
		} 
		body{
		overflow-x: hidden;
		}
	</style>
<body onScroll='scrollTitle()' onKeyDown="lockKey()" >
<form name='PatCriteriaFrm' id='PatCriteriaFrm' action='../../eCA/jsp/OpenChartWrapper.jsp' method = 'post' target='messageFrame'>
<%
	String bean_id = "@CAMenstrualHistDtlTransBean" ;
	String bean_name = "eCA.CAMenstrualHistDtlTransBean";

	CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean) getBeanObject( bean_id, bean_name ,  request) ;
     
	boolean searched			  =		(request.getParameter("searched") == null) ?false:true;
	String locationType = request.getParameter("locationType")==null?"":request.getParameter("locationType");
	String locationDesc = request.getParameter("locationDesc")==null?"":request.getParameter("locationDesc");
	String locationCode = request.getParameter("locationCode")==null?"":request.getParameter("locationCode");
	String patientIdParam = request.getParameter("patientId")==null?"":request.getParameter("patientId");
	String pract = request.getParameter("pract")==null?"":request.getParameter("pract");
	String pract_code = request.getParameter("pract_code")==null?"":request.getParameter("pract_code");
	String specialty = request.getParameter("specialty")==null?"":request.getParameter("specialty");
	String specialtyCode = request.getParameter("specialtyCode")==null?"":request.getParameter("specialtyCode");
	String pFromDate = request.getParameter("fromDate")==null?"":request.getParameter("fromDate");
	String pToDate = request.getParameter("toDate")==null?"":request.getParameter("toDate");
	String encounterSt = request.getParameter("encounterSt")==null?"":request.getParameter("encounterSt");
	String menstHisEvent = request.getParameter("menstHisEvent")==null?"":request.getParameter("menstHisEvent");
	String orderBy = request.getParameter("orderBy")==null?"VD":request.getParameter("orderBy");
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	String anchorID	= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
	String leftScrolling= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");

	String sNo = "";
	String patientId = "";
	String patientName = "";
	String patientClass = "";
	String age = "";
	String sex = "";
	String locationShortDesc = "";
	String specialtyShortDesc = "";
	String attendPractitionerId = "";
	String practName = "";
	String practitionerName = "";
	String visitAdmDateTime = "";
	String dischargeDateTime = "";
	String deceasedYn = "";
	String episodeId = "";
	String patClassKey = "";
	String encounterId = "";
		
	HashMap sqlMap = new HashMap();
	HashMap funcMap = new HashMap();

	HashMap allParam = new HashMap();
	HashMap resultParam = new HashMap();

	allParam.put("facilityId", facilityId);
	allParam.put("locale", locale);
	allParam.put("locationType", locationType);
	allParam.put("locationDesc", locationDesc);
	allParam.put("locationCode", locationCode);
	allParam.put("patientId", patientIdParam);
	allParam.put("pract", pract);
	allParam.put("reOrder", reOrder);
	allParam.put("specialty", specialty);
	allParam.put("specialtyCode", specialtyCode);
	allParam.put("pFromDate", pFromDate);
	allParam.put("pToDate", pToDate);
	allParam.put("encounterSt", encounterSt);
	allParam.put("menstHisEvent", menstHisEvent);
	allParam.put("orderBy", orderBy);
	allParam.put("reOrder", reOrder);
	allParam.put("pract_code", pract_code);


	ArrayList result=new ArrayList();

	result = bean.menstHistPatListResult(allParam);

%>
<div id='divDataTitle' style='postion:relative' >			
<center>	
<table width='100%' id='dataTitleTable' cellpadding='2' cellspacing='1' align='center' class='grid' style="border-bottom: none;" >
<tr >
				<td class='columnheadercenter' width='2%'></td>
				<td class='columnheadercenter' width='2%' ><fmt:message key="eCA.Sno.label" bundle="${ca_labels}"/></td>
				<td class='columnheadercenter' width='8%'><a id='a1' href="javascript:callForOrderByLoc('PID');" onclick='changeColor(this);' style="color:white" ><fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/></a></td>
				<td class='columnheadercenter'  width='7%'><a id='a2' href="javascript:callForOrderByLoc('ENI');" onclick='changeColor(this);' style="color:white" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></a></td>
				<td class='columnheadercenter'  width='14%'><a id='a3' href="javascript:callForOrderByLoc('PN');" onclick='changeColor(this);' style="color:white" ><fmt:message key="eCA.PatientName.label" bundle="${ca_labels}"/></a></td>
				<td class='columnheadercenter'  width='7%'><a id='a4' href="javascript:callForOrderByLoc('AGE');" onclick='changeColor(this);' style="color:white" ><fmt:message key="eCA.Age.label" bundle="${ca_labels}"/></a></td>
				<td class='columnheadercenter'  width='3%'><a id='a5' href="javascript:callForOrderByLoc('SEX');" onclick='changeColor(this);' style="color:white" ><fmt:message key="eCA.Sex.label" bundle="${ca_labels}"/></a></td>
				<td class='columnheadercenter'  width='6%' nowrap><a id='a6' href="javascript:callForOrderByLoc('PC');" onclick='changeColor(this);' style="color:white" ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></a></td>
				<td class='columnheadercenter'  width='10%' ><a id='a7' href="javascript:callForOrderByLoc('LC');" onclick='changeColor(this);' style="color:white" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></a></td>
				<td class='columnheadercenter'  width='10%' ><a id='a8' href="javascript:callForOrderByLoc('SP');" onclick='changeColor(this);' style="color:white" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></a></td>
				<td class='columnheadercenter'  width='10%' nowrap><a id='a9' href="javascript:callForOrderByLoc('AP');" onclick='changeColor(this);' style="color:white"  ><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></a></td>
				<td class='columnheadercenter'  width='10%' nowrap><a id='a10' href="javascript:callForOrderByLoc('VD');" onclick='changeColor(this);' style="color:pink" ><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/>/<fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></a></td>
				<td class='columnheadercenter'  width='11%' nowrap><a id='a11' href="javascript:callForOrderByLoc('CD');" onclick='changeColor(this);' style="color:white" ><fmt:message key="Common.CheckoutDate.label" bundle="${common_labels}"/>/<fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></a></td>
			</tr>
			</table>
</div>
<table  width='100%' id='dataTable' class='grid' style="border-top: none;">	
			<%
			int k=1;
			if(result.size()>0)
			{
				for(int i=0; i<result.size(); i++, k++) {
					 
					 String[] record = new String[14];
					 record = (String[]) result.get(i);
					 
					 patientId = (String) record[0];
					 patientName = (String) record[1];
					 patientClass = (String) record[2];
					 age = (String) record[3];
					 sex = (String) record[4];
					 locationShortDesc = (String) record[5];
					 specialtyShortDesc = (String) record[6];
					 attendPractitionerId = (String) record[7];
					 practName = (String) record[8];
					 visitAdmDateTime = (String) record[9];
					 dischargeDateTime = (String) record[10];
					 deceasedYn = (String) record[11];
					 episodeId = (String) record[12];
					 patClassKey = (String) record[13];
					 encounterId = (String) record[14];
					 
					 String className = "gridData";
					 if(!dischargeDateTime.equals(""))
						 className = "DISCHARGED";
					 
				         if(deceasedYn.equals("Y"))
						 className = "CADECEASED";
						 
				%>
					<tr class='bordered-row'>
						<td class=<%=className%> width='2%'></td>
				<%
    out.println("<td id='rta" + i + "' class='gridData' width='2%' nowrap>" + k + "</td>");
    out.println("<td id='rtb" + i + "' class='gridData' width='8%' nowrap>" + patientId + "</td>");
    out.println("<td id='rtc" + i + "' class='gridData' width='7%' nowrap>" + encounterId + "</td>");
    out.println("<td id='rtd" + i + "' class='gridData' width='14%' nowrap><a class='gridLink' id='Namehref+"+i+"' href=\"javascript:patClick('" + i + "');patClick_('" + i + "');\" name='patName'>"+ patientName + "</font></a></td>");
    out.println("<td id='rte" + i + "' class='gridData' width='7%' nowrap>" + age + "</td>");
    out.println("<td id='rtf" + i + "' class='gridData' width='3%' nowrap>" + sex + "</td>");
    out.println("<td id='rtg" + i + "' class='gridData' width=6%' nowrap>" + patientClass + "</td>");
    out.println("<td id='rth" + i + "' class='gridData' width='10%' nowrap>" + locationShortDesc + "</td>");
    out.println("<td id='rti" + i + "' class='gridData' width='10%' nowrap>" + specialtyShortDesc + "</td>");
    out.println("<td id='rtj" + i + "' class='gridData' width='10%' nowrap>" + practName + "</td>");
    out.println("<td id='rtk" + i + "' class='gridData' width='10%' nowrap>" + visitAdmDateTime + "</td>");

    if(dischargeDateTime!="")
    	out.println("<td id='rtl" + i + "' class='gridData' width='11%'  nowrap>" + dischargeDateTime + "</td></tr>");
     else
    	out.println("<td id='rtl" + i + "' class='gridData' width='11%' style='padding-left: 90px;' nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");

						out.println("<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript'>");
		out.println("patIdArr["+i+"]='"+patientId+"';");
		out.println("episodeIdArr["+i+"]='"+encounterId+"';");
		out.println("patient_class["+i+"]='"+patClassKey+"';");
		out.println("</script>"); %>
			
			<%
			}
			}
			else{
				%>
				<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				</script>
				<%
				}
%>
</table>
<%String url = request.getQueryString(); 
url = url.replaceAll("&orderBy=.*", "");
%>

		<input type="hidden" name="function_id" id="function_id" value='<%=request.getParameter("function_id")%>'>
		<input type="hidden" name="patient_id" id="patient_id" value="">
		<input type="hidden" name="patient_class" id="patient_class" value="">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="url" id="url" value="<%=url%>">
	</form>
	</center>
		<%if(!anchorID.equals("")){%>
		<script>
			if('<%=anchorID%>'!='')
			{
				
			 	<%for(int i=1;i<=11;i++){%>
                    if('a'+'<%=i%>'!='<%=anchorID%>')
            document.getElementById('a' + <%=i%>).style.color = 'white';
 <%}%> 
				if('<%=reOrder%>'=='1')
				{
					document.getElementById('dataTitleTable').all.<%=anchorID%>.style.color='pink';
				}
				else if('<%=reOrder%>'=='2')
					document.getElementById('dataTitleTable').all.<%=anchorID%>.style.color='yellow';
			}
		</script>
		<%}%>
    </body>	
</html>
<%}else{
	session.setAttribute("menstHisPatListflag", "Y");
}%>	
<script>alignWidth();</script>

