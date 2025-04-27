<!DOCTYPE html>
<!--
	Developed by 	:	Smita Unnikrishnan
	Created on 	:	12/05/2004
	Module		:	Out Patient Management
	Function	:	This file is used for displaying the criteria for the search of the patients tobe arrived at the specific clinic and also the patients who have departed from thet specific clinic.
-->
    <%@ page import="java.sql.*, java.util.*, java.text.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html; charset=UTF-8" %>
	 <%	request.setCharacterEncoding("UTF-8");	%>
	 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	 <%
	
	
	  PreparedStatement pstmt =null;
	  ResultSet rs=null;
	  Connection conn = null;
	  String locntype="";
	  String locntypedesc="";
	  String locntypeind="";
	  
	  String patientclass="";
	  String patientclassdesc="";
	  String Pageval=request.getParameter("Pageval");
	  if(Pageval == null) Pageval="A";
	  String Patient_Id_Length = "";

	  String currdate="";
	  String currdate_display = "";
	  String fac_id=(String)session.getAttribute("facility_id");
	  String locale=(String)session.getAttribute("LOCALE"); 
	  
	 %>

<html>
 <head>			 
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eOP/js/ArrivedDeparted.js"></script>
		<Script src="../../eMP/js/PatientRegistration.js" language="JavaScript"></Script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

var Larray=new Array();
var selindex=0;
var i=1;

</script>
</head>
<body OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'>
	 <form name='ArrivedDepartedCriteria_form' id='ArrivedDepartedCriteria_form' >
<%
try{
conn=ConnectionManager.getConnection(request);
%>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' >
	<tr>
	<td class='label' width='20%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td width='40%' class='fields'>

	<%
	String ot_yn="N";
	String rd_yn="N";
	pstmt=conn.prepareStatement("select module_id,nvl(install_yn,'N') install_yn from sm_module where module_id in ( 'OT','RD')");

	

		rs=pstmt.executeQuery();
		if(rs != null)
		{
			while(rs.next())
			{
				if(rs.getString("module_id").equals("OT")){
					if(rs.getString("install_yn").equals("Y")){
						ot_yn="Y";
					}

				}else if(rs.getString("module_id").equals("RD")){
					if(rs.getString("install_yn").equals("Y")){
						rd_yn="Y";
					}
				}
			
			}
		}


		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
	%>
	<select name="location_type" id="location_type" onChange="clearlist(this);">
	<option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;
		<%

		pstmt=conn.prepareStatement("select locn_type,short_desc,care_locn_type_ind from am_care_locn_type_lang_vw where language_id='"+locale+"' and SYS_USER_DEF_IND='S' and locn_type not in ('B','H','D') order by 2");

	

		rs=pstmt.executeQuery();
		if(rs != null)
		{
			while(rs.next())
			{
				locntype=rs.getString(1);
				locntypedesc=rs.getString(2);
				locntypeind=rs.getString(3);
				if(locntype.equals("O") && ot_yn.equals("Y")){
					%><option value='<%=locntype%>' ><%=locntypedesc%><%
				}else if(locntype.equals("W") && rd_yn.equals("Y")){
					%><option value='<%=locntype%>' ><%=locntypedesc%><%
				}else if(locntype.equals("C") || locntype.equals("Y") || locntype.equals("N") || locntype.equals("E") || locntype.equals("R")){
					%><option value='<%=locntype%>' ><%=locntypedesc%><%
				}
				if((locntype.equals("O") && ot_yn.equals("Y"))||(locntype.equals("W") && rd_yn.equals("Y"))||(locntype.equals("C") || locntype.equals("Y") || locntype.equals("N") || locntype.equals("E") || locntype.equals("R"))){ %>
				<script>
					Larray[i]='<%=locntypeind%>';
					i++;
				</script>
				<%
				}
			}
		}

		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
%>
</select>&nbsp;/&nbsp;

	<!--	
		<select name="location_code" id="location_code" >
		<option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;</select>
	-->
	<INPUT TYPE="text" name="loc_code" id="loc_code"  onBlur="onBlurgetLoc('<%=fac_id%>','<%=locale%>','Criteria',document.forms[0].loc_code);"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=fac_id%>','<%=locale%>','Criteria',document.forms[0].loc_code);" ><img align='center' src='../../eCommon/images/mandatory.gif'></img>
	<input type="hidden" name="location_code" id="location_code">
			</td>
			
			<%
				pstmt=conn.prepareStatement("select patient_id_length ,to_char(sysdate,'dd/mm/yyyy') today from mp_param");
				rs=pstmt.executeQuery();
				if(rs.next())
	              {
				Patient_Id_Length=rs.getString("patient_id_length");
                currdate=rs.getString("today");    
				  }
				if(pstmt != null) pstmt.close();

				if(rs != null) rs.close();

				currdate_display = DateUtils.convertDate(currdate,"DMY","en",locale);

				%>
					<td class='label' width='20%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td width='20%' class='fields'>
						<input type='text' name='patient_id' id='patient_id' value='' size='15' maxlength='<%=Patient_Id_Length%>' onkeypress='makeValidString(this);CheckForSpecChars(event);' ><input type='button' class='button' value='?' name='PatientSearch' id='PatientSearch' onClick="getPatID()" >
					</td>
				</tr>
				<tr>
				<td class='label'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<select name="patient_class" id="patient_class" >
					<option value=''>&nbsp;&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;&nbsp;
				<%
				//pstmt=conn.prepareStatement("select patient_class,short_desc from am_patient_class ");
				pstmt=conn.prepareStatement("select patient_class,short_desc from am_patient_class_lang_vw where language_id='"+locale+"'");				
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						patientclass=rs.getString(1);
						patientclassdesc=rs.getString(2);
						%>
							<option value='<%=patientclass%>' ><%=patientclassdesc%>
						<%
					}
				}
						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
			%>
			</select>&nbsp;/&nbsp;
				
		<input type='text' name='encounter_id' id='encounter_id' value='' maxlength=12 size=12>
			</td>
				<td class='label' ><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
					
					<td class='fields'>
		<input type='text' name='encounter_date' id='encounter_date' value='<%=currdate_display%>'    size=15 maxlength=15 onBlur="if(validDateObj(this,'DMY',localeName))chkWithSysDt(this);" ><img id='img1' src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].encounter_date.focus();return showCalendar('encounter_date');"style="cursor='hand'"></img></td>
				</tr>
				<tr>			
					<td class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<select name="order_by" id="order_by" >
							<option value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----
							<option value='T'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/>
							<option value='D' selected><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/> 
						</select>
					</td>		
				
				<%
				if(Pageval.equals("A"))
					{
						%>
							<td class='label'><fmt:message key="Common.AllEncounters.label" bundle="${common_labels}"/></td>
							<td class='fields'>
							<input type="checkbox" name="all_encounters" id="all_encounters" value="" >			</td>
					<%}else{%>
					 <td class='label' colspan='2'>&nbsp;</td>					 
					<%}%>
				</tr>
				<tr>
					<td colspan='3'>&nbsp;</td>
					<td class='fields'>
					<input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick ="javascript:showresult(this,'<%=Pageval%>')" name='srch_code'><input type='button' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='clearData("<%=Pageval%>",this)' name='clear'>										
				</td>
			</tr>
					
			</table>
				
			<%
	}catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					 if(conn != null )
						 ConnectionManager.returnConnection(conn,request);
				}

								%>
</form>
</body>
</html>
	

