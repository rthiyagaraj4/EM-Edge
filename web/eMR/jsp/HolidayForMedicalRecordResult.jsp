<jsp:useBean id="holidaydatevalue" scope="session" class="webbeans.eCommon.RecordSet" /> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,eMR.*,eFM.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Properties p=(java.util.Properties) session.getValue("jdbc");
%>

<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script>
<script language="javascript" src="../../eMR/js/HolidayForMedicalRecord.js"></script>	
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

<script>

window.onload=function(){ 
	if(document.getElementById("dataTable")!=null)	{		
		fxheaderInit('dataTable',350);
	}
}

function checkAll(){
	var len=document.HolidayForMRD_Result.nochkbox.value;
	if(document.HolidayForMRD_Result.selected_chk.checked){	 	
		for(var k=0; k<len; k++){ 
		 eval('document.HolidayForMRD_Result.selected_'+k).checked=true;	
		 eval('document.HolidayForMRD_Result.selected_'+k).value="Y";	 
		}
	}else{  
		for(var k=0; k<len; k++){ 
		  eval('document.HolidayForMRD_Result.selected_'+k).checked=false;
		  eval('document.HolidayForMRD_Result.selected_'+k).value="N";         
		} 
	}
	document.HolidayForMRD_Result.nochkbox.value=len;
}

function checkSinglechk(){
	var singchklen=document.HolidayForMRD_Result.nochkbox.value;

	for(var m=0; m<singchklen; m++){ 
		if(eval('document.HolidayForMRD_Result.selected_'+m).checked){  
			if( eval('document.HolidayForMRD_Result.holiday_reasion_'+m).value==""){        
				var error=getMessage("REASON_FOR_FMHOLIDAY","FM");
				alert(error);
				eval('document.HolidayForMRD_Result.selected_'+m).checked=false;	
				eval('document.HolidayForMRD_Result.selected_'+m).value="N";
			}else{	    
				 eval('document.HolidayForMRD_Result.selected_'+m).checked=true;	
				 eval('document.HolidayForMRD_Result.selected_'+m).value="Y";
			}
		}else{ 
			eval('document.HolidayForMRD_Result.selected_'+m).checked=false;
			eval('document.HolidayForMRD_Result.selected_'+m).value="N";
		} 
	}	
}

</script>

</head>

<body  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()'>
<form name="HolidayForMRD_Result" id="HolidayForMRD_Result" action="../../servlet/eMR.HolidayForMedicalRecordServlet" method="post" target="messageFrame">
	 <%
	 Connection con = null;
	 String holidaydate="";
	 int totChk=0;
	 String holiday_date=request.getParameter("holiday_date")==null?"":request.getParameter("holiday_date");
	 String holiday_end=request.getParameter("holiday_end")==null?"":request.getParameter("holiday_end");
	 String operation=request.getParameter("operation")==null?"":request.getParameter("operation");
	 String facilityId = (String) session.getValue( "facility_id" ) ;

	 try{ 
		con = ConnectionManager.getConnection(request);
		ArrayList List=(ArrayList)MRCommonBean.getHolidayForMedicalRecord(con,holiday_date,holiday_end,facilityId); 

		if(0<List.size()){
		%>

		<table border='1' cellpadding='0' cellspacing='0' id="dataTable" width="100%" >
		<tr>
			<td  class='columnheader' align="left" height="30" width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td  class='columnheader' align="left" height="30" width='30%'><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></td>
			<td  class='columnheader' align="left" height="30" width='10%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
		</tr>	

		<%for(int i=0; i<List.size(); i++){
		  FMCurrentEncounterDetailsBean holidayList=(FMCurrentEncounterDetailsBean)List.get(i);
		  holidaydate=checkForNull(holidayList.getHolidaydate()); 
		%>
		<tr>
			<td class="QRYODD"  width='20%'><%=holidaydate%></td>
			<td class="QRYODD"  width='30%'><input type="text" name="holiday_reasion_<%=totChk%>" onBlur="makeValidString(this);reasonCheck(this,<%=totChk%>);chkChar(this);" onKeyPress='return SpeCharRestriction(event)' size="30" maxlength="30" ></td>
			<td class="QRYODD"  width='10%'><input type='checkbox' name='selected_<%=totChk%>'  onclick ='checkSinglechk()'>
			<input type="hidden" name="holidaydate_<%=totChk%>" value='<%=holidaydate%>'>
			</td>
		</tr>
		<%totChk++;
		}%>

		</table>

		<%}

		if(List.size() == 0){%>	
			<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));	
			</script>			
		<% 
		}

	}catch(Exception e){
		e.printStackTrace();
	}finally
	{
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("holidaydatevalue", holidaydatevalue);
	}
	%>

	<input type="hidden" name="holiday_date" id="holiday_date" value="<%=holiday_date%>">
	<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>">
	<input type="hidden" name="nochkbox" id="nochkbox" value="<%=totChk%>">
	<input type="hidden" name="operation" id="operation" value="<%=operation%>">

</form>
</body>

</html>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>	

