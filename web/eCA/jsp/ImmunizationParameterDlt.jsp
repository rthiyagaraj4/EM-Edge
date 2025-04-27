<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------
23/02/2023     41650               Twinkle Shah    	                                        MMS-JU-CRF-0015.1
18/05/2023	   41653		       Twinkle Shah	    18/05/2023	    M.f.mohamed Ali         MMS-JU-CRF-0015.3
-------------------------------------------------------------------------------------------------------------- 

*/
%>
<%@ page import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	  request.setCharacterEncoding("UTF-8");
	  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;
	  String vacc_categ_id = "";
	  String vacc_link_days = "";
	  String vacc_categ_desc = "";
	  String disable_vacc_categ_id = "";
	  String auto_sch_immun_yn="Y"; //41650
	  String to_auto_sch_immun_yn_checked="";//41650
	  String disp_vacc_sort_yn="N";      //41653
	  String disp_vacc_sort_yn_checked="";   //41653
	  try{	  
			con = ConnectionManager.getConnection();
			//pstmt = con.prepareStatement("SELECT VACC_CATEG_ID,CA_GET_DESC.CA_IM_VAC_CATEG(VACC_CATEG_ID,?,'2') VACC_CATEG_DESC, VACC_LINK_DAYS FROM CA_IM_PARAM"); //41650
			//pstmt = con.prepareStatement("SELECT VACC_CATEG_ID,CA_GET_DESC.CA_IM_VAC_CATEG(VACC_CATEG_ID,?,'2') VACC_CATEG_DESC, VACC_LINK_DAYS ,AUTO_SCH_IMMUN_YN FROM CA_IM_PARAM"); // 41653
			pstmt = con.prepareStatement("SELECT VACC_CATEG_ID,CA_GET_DESC.CA_IM_VAC_CATEG(VACC_CATEG_ID,?,'2') VACC_CATEG_DESC, VACC_LINK_DAYS ,AUTO_SCH_IMMUN_YN,DISP_VACC_SORT_YN FROM CA_IM_PARAM"); // 41653

			pstmt.setString(1,locale);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next())
			{
				vacc_categ_id = rs.getString("VACC_CATEG_ID")==null?"":rs.getString("VACC_CATEG_ID");
				vacc_link_days = rs.getString("VACC_LINK_DAYS")==null?"":rs.getString("VACC_LINK_DAYS");
				vacc_categ_desc = rs.getString("VACC_CATEG_DESC")==null?"":rs.getString("VACC_CATEG_DESC");
				auto_sch_immun_yn = rs.getString("AUTO_SCH_IMMUN_YN")==null?"":rs.getString("AUTO_SCH_IMMUN_YN"); //41650
				disp_vacc_sort_yn = rs.getString("DISP_VACC_SORT_YN")==null?"":rs.getString("DISP_VACC_SORT_YN"); //41653
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			pstmt = con.prepareStatement("SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR WHERE VACC_CATEG_ID = ? ");
			pstmt.setString(1,vacc_categ_id);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next())
			{
				disable_vacc_categ_id = "disabled";				
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	  }catch(Exception e){
			e.printStackTrace();
	  }finally{		   
			if(con!=null)ConnectionManager.returnConnection(con);
	  }
	  
	// start. 41650
     	if("Y".equals(auto_sch_immun_yn))
		{
     		to_auto_sch_immun_yn_checked="checked";
		}
		else
		{
			to_auto_sch_immun_yn_checked="unchecked";
		}
	
  // end. 41650
 
//start. 41653
	if("Y".equals(disp_vacc_sort_yn))
	{
		disp_vacc_sort_yn_checked="checked";
	}
	else
	{
		disp_vacc_sort_yn_checked="unchecked";
	}

// end. 41653
		
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCA/js/ImmunizationParameter.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<form name="imPramForm1" id="imPramForm1" action='../../servlet/eCA.CAConsultationServlet' method='post'>
		<br>
		<br>
		<br>
		<table cellpadding='2' cellspacing='2'  name='immunizationParameter' id='immunizationParameter'  style='height:10%;width:75vw' align='center'>			
			<tr>	
				  <td class="Label"><fmt:message  key="eCA.VaccineCatagoryForRXVaccines.label" bundle="${ca_labels}"/></td>
				  <td class='fields' colspan="0"><input type='hidden' name='vacc_categ_id' id='vacc_categ_id' value='<%=vacc_categ_id%>'><input type="text" name='vacc_categ_desc' id='vacc_categ_desc' onblur='callFunctionButton(this, "<%=locale%>")' value="<%=vacc_categ_desc%>" onChange='Clearhidden()' <%=disable_vacc_categ_id%>/><input type="button" value="?"  onclick='getAdhocCateg("<%=locale%>")' <%=disable_vacc_categ_id%>><img src="../../eCommon/images/mandatory.gif"></td>  
			</tr>
			<tr>
				  <td class="Label"><fmt:message  key="eCA.NoDaysVaccinesSchedule.label" bundle="${ca_labels}"/></td>
				  <td class='fields' colspan="2"><input type="text" name="vacc_link_days" id="vacc_link_days"  onKeyPress='return  allowNumeric();' maxLength="3" size="4" value="<%=vacc_link_days%>" />&nbsp;<fmt:message  key="Common.days.label" bundle="${common_labels}"/><img src="../../eCommon/images/mandatory.gif"></td>  
			</tr>
			<!--start. 41650 -->
       <tr>
	   <td class="Label"><fmt:message key="eCA.ToAutoPopSchedImmunFunction.label" bundle="${ca_labels}"/></td>
	   <td colspan="2" class='fields'><input type="checkbox" name="toAuto_Pop_Sch_Immun" id="toAuto_Pop_Sch_Immun" value = '<%=auto_sch_immun_yn%>' <%=to_auto_sch_immun_yn_checked%> onclick="toAutoPopSchedManageImmun(this)"></td>
       </tr> 
       
       	<!--end. 41650 --> 
       	<!-- Start 41653-->
       <tr>
	   <td class="Label" ><fmt:message key="eCA.DisplayVaccineSchedulesSorted.label" bundle="${ca_labels}"/></td>
	   <td colspan="2" class='fields'><input type="checkbox" name="dispVaccineSchedulesSorted" id="dispVaccineSchedulesSorted" value = '<%=disp_vacc_sort_yn%>' <%=disp_vacc_sort_yn_checked%> onclick="toDisplayVaccineSchedulesSorted(this)"></td>
       </tr> 
       
       	<!--end. 41653 -->  
		</table>
			<input type=hidden name="auto_sch_immun_yn" id="auto_sch_immun_yn" value="<%=auto_sch_immun_yn%>"> <!-- 41650 -->
			<input type=hidden name="disp_vacc_sort_yn" id="disp_vacc_sort_yn" value="<%=disp_vacc_sort_yn%>"> <!-- 41653 -->
	</form>
</body>
</html>

