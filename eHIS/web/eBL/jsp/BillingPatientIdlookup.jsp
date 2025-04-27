<!DOCTYPE html>
<%@ page    import="java.sql.*,java.util.*,webbeans.eCommon.*, eBL.Common.*,eBL.resources.*,  eCommon.Common.*,eBL.BillingPrevilageCardPatientBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- <%@ page    import ="eBL.BLChargePatientDAO" %> --%>


<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0    
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
String applyMode														=	new String();
String locale															=	"";
String facilityId														=	"";
String hiddenPatientId													=	"";
String patientDetails													=	"";
String mode																=	"";
String isUserCanAcess													=	"";
String sStyle 															=	"";
String authorized 														=	"";
String bean_id															=	"";
String bean_name														=	"";
String modPatientId														=	"";
String value															=	"";
String disableMode														=	"DISABLED";
String called_from														=	"";
String buttonDisable													=	"";
String lookUpDisable													=	"";

try
{
	sStyle 																=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																=  	(String)session.getAttribute("LOCALE");
	facilityId															=  	(String) session.getValue( "facility_id" ) ;
	mode																=	checkForNull(request.getParameter("mode"));
	modPatientId														=	checkForNull(request.getParameter("modPatientId"));
	authorized 															=	checkForNull(request.getParameter("authorized"),"N");
	called_from															=	checkForNull(request.getParameter("called_from"));
	if(called_from.equalsIgnoreCase("PAS"))
	{	
		buttonDisable = "DISABLED";
		value= modPatientId;
		lookUpDisable="DISABLED";
	}
	else
	{
		buttonDisable = "";
	}
	if(mode.equalsIgnoreCase("modify"))
	{
		
		session.setAttribute("maintainMode", mode);
		session.setAttribute("authorized", authorized);
		session.setAttribute("maintainModePatientId", modPatientId);
		value= modPatientId;
		disableMode ="READONLY";
	}
	else
	{
		session.setAttribute("maintainMode", "insert");
		session.setAttribute("authorized", "N");
		session.setAttribute("maintainModePatientId", modPatientId);
	}
	System.out.println("maintainModePatientId::::::: "+modPatientId);
	System.out.println("mode:::: "+mode);

%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
    <!--<script language="javascript" src="../../eCommon/js/common.js"></script> -->
        <script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>		

        
        <script language ="javaScript"    src ='../../eCommon/js/CommonLookup.js'></Script>	
		<script language="javascript"     src="../../eCommon/js/ValidateControl.js"></script> 
		<script language='javascript'     src='../../eCommon/js/FieldFormatMethods.js'></script>
		
	 	<script language="javascript" src="../../eBL/js/BLPatientEncounters.js"></script> 	
		
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../js/BillingMainatainPrevilageCard.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		
		
	  <link rel="stylesheet" type="text/css" href="../../eBL/html/ui.dropdownchecklist.css" />
         <link rel="stylesheet" type="text/css" href="../../eBL/html/main.css" />
    

      
  
	
</head>
<BODY  onKeyDown= "lockKey();" onMouseDown="CodeArrest();"  onSelect="codeArrestThruSelect();" >
 <FORM method='post' name="patientIdLookup" id="patientIdLookup"  id="patientIdLookup"  >
<TABLE border='0' cellpadding='3' cellspacing='0'>
	<tr>
		<td class="label" width="10%"><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></td>	
		<td class="fields" width="20%"><INPUT TYPE="TEXT"  name="patient_id0" id="patient_id0" id="patient_id0" SIZE="17" maxlength='12' value='<%=value%>'  onKeyPress='changeToUpper()' onBlur="primaryPatValidation(this);" >
		<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup('0','primary')" <%=lookUpDisable%> tabindex='2'><img src='../../eCommon/images/mandatory.gif'> </td>
		<td class="fields" width="20%" colspan='4'>	
		<input type='button' class='button' name='modify' id='modify'	   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>' <%=buttonDisable%>  onClick='authUser("");'>
		</td>
		<%
			if(mode.equalsIgnoreCase("modify")||called_from.equalsIgnoreCase("PAS"))
			{
		%>
		<script>
		ShowPatientdetails('<%=modPatientId%>',"modify");
		</script>
		<%
			}
		%>
	</tr>  
</TABLE>

   		<input type='hidden' name='locale' id='locale' 				 id='locale'  			value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId'	 	     id='facilityId'  		value="<%=facilityId%>" >
		<input type='hidden' name='mode' id='mode' 				 id='mode' 				value="<%=mode%>" >
		<%-- <input type='hidden' name='authorized' id='authorized'			 id='authorized'  		value="<%=authorized%>" /> 
		<input type='hidden' name='isUserCanAcess' id='isUserCanAcess'		 id='isUserCanAcess' 	value="<%=isUserCanAcess%>" /> --%>
		<input type='hidden' name='hiddenPatientId' id='hiddenPatientId' 	 id='hiddenPatientId'	value="<%=hiddenPatientId%>">
</FORM>		
</body>
<%
/* putObjectInBean(bean_id, billingPrevilageCardPatientBean, request); */
}
catch(Exception e)
{
	System.out.println("Exception in BillingPatientIdlookup.jsp::"+e);
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
</html>

