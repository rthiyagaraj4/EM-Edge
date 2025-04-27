<!DOCTYPE html>
<jsp:useBean id="holidaydatevalue" scope="session" class="webbeans.eCommon.RecordSet" /> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,eFM.*" %>
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
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
<script language="javascript" src="../../eFM/js/HolidayForMrd.js"></script>	
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

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
	   /*if(document.HolidayForMRD_Result.selected_chk.checked){	  
	   document.HolidayForMRD_Result.selected_chk.checked=false;
	   }*/	   
    }	 
  }	
}
	</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <!--<form name="HolidayForMRD_Result" id="HolidayForMRD_Result" method="post" action="" target='messageFrame'>-->
    <form name="HolidayForMRD_Result" id="HolidayForMRD_Result" action="../../servlet/eFM.FMHolidayServlet" method="post" target="messageFrame">
         <%
		 Connection con = null;
		 String Fslocationcode="",Fslocationdescription="",holidaydate="";
		 int totChk=0;
		 String holiday=request.getParameter("holiday")==null?"":request.getParameter("holiday");
		 String holiday_end=request.getParameter("holiday_end")==null?"":request.getParameter("holiday_end");
		 String mrd_location=request.getParameter("mrd_location")==null?"":request.getParameter("mrd_location");
		 String operation=request.getParameter("operation")==null?"":request.getParameter("operation");
		 String facilityId = (String) session.getValue( "facility_id" ) ;		
		 try{
         con	= ConnectionManager.getConnection(request);
         ArrayList List=(ArrayList)FMCurrentEncounterDetails.getHolodayForMRD(con,holiday,holiday_end,mrd_location,facilityId,p); 
        //Type casting into the ArrayList 
         if(0<List.size()){  
		 %>
       	<!--<table border='1' cellpadding='1' cellspacing='1' align="center" width='60%'>
		<tr id="reqfileheader">	
		<td  class='columnheader' align="left" height="30" width='20%'><fmt:message key="eFM.MrdLocation.label" bundle="${fm_labels}"/> </td>
		<td  class='columnheader' align="left" height="30" width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td  class='columnheader' align="left" height="30" width='30%'><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></td>
		<td  class='columnheader' align="left" height="30" width='10%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
		</tr>	
		</table> 
		<table border='1' cellpadding='0' cellspacing='0' align='center' width='60%' id=Tabledata>-->  
		<table border='1' cellpadding='0' cellspacing='0' id="dataTable" width="100%" >
		<tr>	
		<th  class='columnheader' align="left" height="30" width='20%'><fmt:message key="eFM.MrdLocation.label" bundle="${fm_labels}"/> </td>
		<th  class='columnheader' align="left" height="30" width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<th  class='columnheader' align="left" height="30" width='30%'><fmt:message key="Common.ReasonForHoliday.label" bundle="${common_labels}"/>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></td>
		<th  class='columnheader' align="left" height="30" width='10%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
		</tr>	
		
		<%for(int i=0; i<List.size(); i++){
		  FMCurrentEncounterDetailsBean holidayList=(FMCurrentEncounterDetailsBean)List.get(i);
		   Fslocationcode=checkForNull(holidayList.getFslocationcode()); 
		   Fslocationdescription=checkForNull(holidayList.getFslocationdescription()); 
		   holidaydate=checkForNull(holidayList.getHolidaydate()); 
		
		%>
		<tr>
		
		<td class="QRYODD"  width='20%'>&nbsp;<%=Fslocationdescription%></td><td class="QRYODD"  width='20%'><%=holidaydate%></td>
		<td class="QRYODD"  width='30%'><input type="text" name="holiday_reasion_<%=totChk%>" id="holiday_reasion_<%=totChk%>" onBlur="makeValidString(this);reasonCheck(this,<%=totChk%>)" onKeyPress='return SpeCharRestriction(event)' size="30" maxlength="30" ></td>
		<td class="QRYODD"  width='10%'><input type='checkbox' name='selected_<%=totChk%>' id='selected_<%=totChk%>'  onclick ='checkSinglechk()'>
		<input type="hidden" name="Fslocationcode_<%=totChk%>" id="Fslocationcode_<%=totChk%>" value='<%=Fslocationcode%>'>
		<input type="hidden" name="holidaydate_<%=totChk%>" id="holidaydate_<%=totChk%>" value='<%=holidaydate%>'>
		</td>
		</tr>
		<%totChk++;
		}%>
		
		</table>
	
		<%}
		if(List.size() == 0){%>
		<script>         	 
		 alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));           		 
		// history.go(-1);		
		</script>			
	   <%}
		}catch(Exception e){
		 e.printStackTrace();
		 }finally
	{
		 ConnectionManager.returnConnection(con,request);
		 session.setAttribute("holidaydatevalue", holidaydatevalue);
		

	}
		%>
		<input type="hidden" name="holiday" id="holiday" value="<%=holiday%>">
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

