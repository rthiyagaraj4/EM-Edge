<!DOCTYPE html>
<!-- This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release -->
<%@page
import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,eDS.Common.JSONObject"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<jsp:setProperty name="DSCommonBeanObj" property="Locale" value='<%=session.getAttribute("LOCALE").toString()%>'/>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>

<%
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id	= (String)session.getAttribute("facility_id");
	String params = request.getQueryString() ;
	request.setCharacterEncoding("UTF-8");
%>

<html>
<head>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String imgUrl = "";
	if (sStyle.equals("IeStyle.css")) {
		imgUrl = "../../eCommon/images/searchBoxBG.jpg";
	}
%>

<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eDS/js/DSProcessSupplementary.js"></script>
<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
<script type="text/javascript" src="../../eDS/js/jquery-latest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>

<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String ward_code="";
	String ward_description="";
	String strCode = "";
	String strDesc = "";
	String sql = "";
	String SystemDate_display="";
	String servingDate="";

try{
		con = ConnectionManager.getConnection(request);
		stmt = con.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		rs = stmt.executeQuery();
		while(rs.next()){
			servingDate = rs.getString("CURRENT_DATE");
		}
		SystemDate_display = DateUtils.convertDate(servingDate,"DMY" ,"en",localeName);
	}catch(Exception e)
		{
			out.println("exp"+e);
			e.printStackTrace();
			System.err.println("Exception in DSProcessSupplementaryOrderHeader=="+e);
		}
	finally{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
%>

<form name="SupplBasedHeaderForm" id="SupplBasedHeaderForm" action="/DSProcessSupplemenataryAction" method="post">
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="80%">
	<tr>
	 <td colspan="1" align="right" class="label">
			<fmt:message key="Common.date.label" bundle="${common_labels}" />
		</td>
		<td>
			<input type="text" name="date_SupplBased" id="date_SupplBased" size="10" maxlength="10" value="<%=SystemDate_display%>"  onblur="isValidDate(this);" >
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('date_SupplBased');">
			<img src='../../eCommon/images/mandatory.gif' align='center'>
		</td>
        </td>
		<td colspan="1" class="label" width="10%">
			<fmt:message key="Common.patientId.label" bundle="${common_labels}" />
		</td>
		<td>
		    <!--61224  - ICN -->
			<input type="text" name="patient_id" id="patient_id" id="patient_id"  maxlength="10" onKeypress='return restrictSpecialChars(event);' onBlur="makeValidString(this);ChangeUpperCase(this);">
			<input type="button" id="patientLookUp" class="BUTTON" value="?" onclick="callPatientSearch()" />
		</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
	    <tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr>
		<td  colspan="1" class='label' align="left">
			<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
		<td>
			<select name="kitchen" id="kitchen"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
	         <% 
	             ArrayList<JSONObject> ProcesskeyValueList = new ArrayList<JSONObject>();

				 ProcesskeyValueList=DSCommonBeanObj.getKitchen();
				 Iterator<JSONObject> itr=ProcesskeyValueList.iterator();

				 JSONObject childobject=new JSONObject();

				while(itr.hasNext()){
					childobject=itr.next();

			 %>
			    <option value=<%=childobject.get("KITCHEN_CODE") %>><%= childobject.get("SHORT_DESC")%></option>
			 <%	
				}
			 %>		
			 </select>
			 </td>
	   </td>
		
	   <td colspan="1" class="label">
			<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}" />
	   </td>
	   <td>
		<select name="nursingUnit" id="nursingUnit">
			<option value=''>
			<fmt:message key="Common.Select.label" bundle="${common_labels}" />
			</option>
	         <% 
	             ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
						
						keyValueList=DSCommonBeanObj.getNursingUnit();
						
						System.err.println("keyValueList in jsp--->"+keyValueList);
						
                        itr=keyValueList.iterator();
						while(itr.hasNext()){
							childobject=itr.next();
	         %>
			 <option value=<%=childobject.get("nursing_Unit_Code") %>><%= childobject.get("Short_Desc")%></option>
			 <%	
				}
			 %>		
			 </select>
		</td>
	 <tr></tr>
	 <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
	 <tr>
	 <td class="label"><fmt:message key="eDS.SupplementaryOrderFor.Label" bundle="${ds_labels}"/></td>
		<td>
		<select name="supplementaryfor" id="supplementaryfor" id="supplementaryfor" onChange="">
		<option value="">Both</option>							
		<option value="P">Patient</option>							
		<option value="A">Attendant</option>							
		</select>
	    </td>
	    </td>
		<td align="right" colspan="3">
		<input type="button" value="Search" property="Select" onclick="getDetails()" class="BUTTON"/>
		</td>
		</tr>
		</tr>		  
		</table>
		<input type='hidden' name='params' id='params' value='<%=params%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	</form>
</body>
</html>

