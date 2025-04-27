<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../js/MRMaster.js' language='javascript'></script> 	
 </head>
 
<script>
// added by mujafar for ML-MMOH-CRF-704 START
function chkChar(obj)
{
	var numExp = new RegExp("[0-9]");
	if(obj.value !="")
	{
	if (/^[0-9]{1,10}$/.test(obj.value))
	{}
	else{ alert(getMessage('INVALID_NUMBER_FORMAT','COMMON'));
			obj.value="";
			obj.focus();
			return false;
	}
	}
}
// added by mujafar for ML-MMOH-CRF-704 END
</script>
 
 
<body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>


<%
   String High_Risk="";
   String longdesc="";
   String shortdesc="";
   String duration_days=""; // ML-MMOH-CRF-704
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   //String eventFunctionForDate="";
   boolean newHighRisk = false;
   String sql="";
   Connection conn=null;

   //Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
   Boolean isReportTypeAppl = false; 
   String report_type = "";
   String selNormalRep = "";
   String selSpecRep = "";
   String selPMRep = "";
%>
<%
try
{
	conn=ConnectionManager.getConnection(request);
	High_Risk=request.getParameter("APPL_TYPE_CODE");
	boolean holiday_duration_applicable = false;
	holiday_duration_applicable	=  eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","HOLIDAY_DURATION"); // ML-MMOH-CRF-704

	isReportTypeAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","REPORT_TYPE_FOR_APPL_TYPE"); //Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292

	if(High_Risk==null){
		High_Risk="";
		longdesc="";
		shortdesc="";
		duration_days="";
		report_type=""; //Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		newHighRisk=true;
		//eventFunctionForDate="OnBlur='CheckDate(this)'";
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
	//	   Connection conn = (Connection) session.getValue( "connection" );
	       //Statement stmt=null;
		   PreparedStatement stmt=null;
	    	ResultSet rset=null;
     try{

		//stmt = conn.createStatement();
		
		if(holiday_duration_applicable) // ML-MMOH-CRF-704
		sql = "select APPL_TYPE_CODE,long_desc,short_desc,eff_status,holiday_duration,report_type from mr_appl_type where APPL_TYPE_CODE=?";
		else
		sql = "select APPL_TYPE_CODE,long_desc,short_desc,eff_status,report_type from mr_appl_type where APPL_TYPE_CODE=?";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,High_Risk);
		rset = stmt.executeQuery();
		rset.next();
		High_Risk=rset.getString("APPL_TYPE_CODE");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");
		if(holiday_duration_applicable)
		{ 
		duration_days = rset.getString("holiday_duration");
		if(duration_days==null)duration_days="";
		}
		//eventFunctionForDate="OnBlur='CheckDate(this)'";
		
		//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
		report_type = rset.getString("report_type");
		if(report_type == null) report_type = "";
		if(report_type.equals("N")) selNormalRep = "selected";
		else if(report_type.equals("S")) selSpecRep = "selected";
		else if(report_type.equals("P")) selPMRep = "selected";

		effstatus=rset.getString("eff_status");
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
		}else{

			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}

	     }catch(Exception e){
			e.toString();
	     }
	     finally{
	     	if(stmt!=null)
	     	stmt.close();
	     	if(rset!=null)
	     	rset.close();
	     }
		codeTextAttribute="READONLY";
		newHighRisk=false;
		eventFunctionForCase="";
	}

%>

      	<form name='HighRisk_form' id='HighRisk_form' action='../../servlet/eMR.ApplicationTypeServlet' method='post' target='messageFrame'>
      	<div align='left'>
      	<BR><BR><BR><BR><BR><BR><BR><BR><BR><br>
		
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	
      		<tr>
      		    <td  width='50%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
      		    <input type='text' name='high_risk_code' id='high_risk_code' value="<%=High_Risk%>" size='7' maxlength='4' onKeyPress="return CheckForSpecChars(event)"  <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
     		    <td  class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		    <td class='fields'>
		    <input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=shortdesc%>" <%=otherTextAttribute%>  onBlur="makeValidString(this);">
		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			<!-- added for ML-MMOH-CRF-704 start -->
			<%
			if(holiday_duration_applicable)
			{%>
			<tr>
      		    <td  class=label><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <input type='text' name='duration_days' id='duration_days' size='5' maxlength='3' value="<%=duration_days%>" <%=otherTextAttribute%> onBlur='chkChar(this);' onKeyPress='return(ChkNumberInput(this,event,0))'>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
			<%
			}
			%>
			<!-- end -->

			<!--Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292-->
			<%if(isReportTypeAppl){%>		
			<tr>
				<td class=label><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name="report_type" id="report_type">
						<option value='' >-------<fmt:message key="Common.Select.label" bundle="${common_labels}"/>-------</option>
						<option value="N" <%=selNormalRep%> ><fmt:message key="Common.Normal.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
						<option value="S" <%=selSpecRep%> ><fmt:message key="Common.specialist.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
						<option value="P" <%=selPMRep%> ><fmt:message key="Common.Postmortem.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></option>	
					</select>
				</td>
			</tr>
			<%}%>
			<!--End ML-MMOH-CRF-1292-->

      		<tr>
      		     <td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td class='fields'>
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change1()"></td>
      		</tr>
			
      	</table>
      	</div>
    <%  if(newHighRisk){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>
	 	<input type='hidden' name='holiday_duration_applicable' id='holiday_duration_applicable' value='<%= holiday_duration_applicable%>'>

		<!--Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292-->
	 	<input type='hidden' name='isReportTypeAppl' id='isReportTypeAppl' value='<%= isReportTypeAppl%>'>
     	</form>
      	</body>
      	</html>

<%
}catch(Exception e){}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

