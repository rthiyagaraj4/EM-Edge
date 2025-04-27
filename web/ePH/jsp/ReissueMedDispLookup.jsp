<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*,java.net.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
   <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
    <script language="JavaScript" src="../js/PhMessages.js"></script>
    <script language="JavaScript" src="../js/ReissueMed.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

 <%
    String bean_id		= "ReissueMedBean" ;
    String bean_name	= "ePH.ReissueMedBean";
	String disp_locn = request.getParameter("disp_locn");
	HashMap initvalues	= new HashMap();
    /* Initialize Function specific start */
	ReissueMedBean bean = (ReissueMedBean)getBeanObject( bean_id,bean_name,request) ;
    bean.clear() ;
//to populate data into dispense location and patient class
	initvalues = bean.getInitData(disp_locn);
	int i=0;
	ArrayList dispNo = new ArrayList();
	//ArrayList patClass = new ArrayList();
	dispNo = (ArrayList)initvalues.get("DISP");
	//patClass = (ArrayList)initvalues.get("PATIENT");
	String patientid = request.getParameter("PatientId");
	String disp_locn_desc = request.getParameter("disp_locn_desc");
	disp_locn_desc = URLDecoder.decode(disp_locn_desc);
	%>

<!-- <body topmargin=0 leftmargin=0 bottommargin=0 > -->
<body topmargin=0 leftmargin=0 bottommargin=0 onMouseDown="" onKeyDown="lockKey()">
<form name="FormReissueMedDispLookup" id="FormReissueMedDispLookup" >
	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
	<tr>	
		<td align="right" class="label" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td align="left" class="label">&nbsp;&nbsp;<SELECT id=Disp_Location 
      name=Disp_Location> <OPTION selected>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</OPTION>
	  <%
	  for (i=0; i<dispNo.size(); i+=2){
	  
	  %>
		  <OPTION VALUE='<%= (String)dispNo.get(i+1) %>'>
	  <%=(String)dispNo.get(i) %>
		  </OPTION>
	  <%}%>
	  </SELECT>&nbsp; 
				</td>
				<td align="right" class="label" ><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></td><td align="left" >&nbsp;&nbsp;<INPUT maxLength=10 size=10 
      name=Disp_Date>&nbsp<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('Disp_Date');document.FormReissueMedDispLookup.Disp_Date.focus();return false;" > 
	  </td>
		</tr>
		<tr>	
				<td align="right" class="label" > <fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td><td align="left" colspan='3'>&nbsp;&nbsp;<INPUT 
      maxLength=20 name=Drug_Name><INPUT class=button onclick=drugsearch(document.FormReissueMedDispLookup) type=button value=? name=Drug_Name_Button>
	     <INPUT type="hidden" name="Drug_Code" id="Drug_Code">
				</td>
		</tr>
		<tr>	
				<td align="right" class="label" >Order&nbsp;ID</td>
				<td align="left" >&nbsp;&nbsp;<input name="Order_Id" id="Order_Id" maxlength=15 size=15>
				</td>
				<td align="right" class="label" ><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
				<td align="left" >&nbsp;&nbsp;<input name="Order_Date" id="Order_Date" maxlength=10 size=10 
     >&nbsp<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('Order_Date');document.FormReissueMedDispLookup.Order_Date.focus();return false;" > </td>
		</tr>
		<tr>	
				<td align="right" class="label" ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
				<td align="left" >&nbsp;&nbsp;<SELECT id=Patient_Class 
      name=Patient_Class> 
	  <OPTION selected value="" >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</OPTION>
	  <OPTION value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></OPTION>
	  <OPTION value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></OPTION>
	 
	  </SELECT> 
    			</td>
				<td align="right" class="label" >Ordering Location</td>
				<td align="left" >&nbsp;&nbsp;<input name="Order_Location" id="Order_Location" maxlength=20 
     ><INPUT TYPE="button" name="OrderLocn_Button" id="OrderLocn_Button" VALUE="?" CLASS="button"  onClick="OrderSearch(document.FormReissueMedDispLookup)" ></td>
	 <input type=hidden name="Order_Code" id="Order_Code" >
		</tr>
		<tr>
				<td align="right" class="label" colspan=4>
				<input type="button" class="button" name="Search" id="Search" value="Search" onclick="callResultPageDisp(document.FormReissueMedDispLookup)">
				<input type="button" class="button" name="Cancel" id="Cancel" value="Clear" onclick="cancel(document.FormReissueMedDispLookup)"></td>
		</tr>
   </table>
   <INPUT TYPE="hidden" name="SQL_PH_REISSUE_MEDICATION_SELECT7" id="SQL_PH_REISSUE_MEDICATION_SELECT7" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REISSUE_MEDICATION_SELECT7" ) %>">
   <INPUT TYPE="hidden" name="SQL_PH_REISSUE_MEDICATION_SELECT8" id="SQL_PH_REISSUE_MEDICATION_SELECT8" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REISSUE_MEDICATION_SELECT8" ) %>">

<input type="hidden" name = "bean_id" value="<%=bean_id%>">
<input type="hidden" name = "bean_name" value="<%=bean_name%>">
<input type="hidden" name=Patient_Id value=<%=patientid%>>
 </form>
 <% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

