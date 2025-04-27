<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
05/12/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible. 
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
28/10/2022      37744         SREENADH M      01/11/2022       Ramesh G        ML-MMOH-CRF-1654							
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String title = request.getParameter("title");//IN035950

%> 
	<style>
		textarea {
		  	resize: none;
		}
	</style>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../js/DateValidation.js' language='javascript'></SCRIPT> 
<script src="../../eCommon/js/dchk.js" language="javascript"></script>
<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>


function timeCalculate(obj)
{
}



</script>
<title><%=title %></title><!--IN035950-->
</head>

<%
	String facility_id=(String) session.getValue("facility_id");
	String encounter_id = request.getParameter("encounter_id");
	String relationship_id = request.getParameter("relationship_id");
	String patient_id = request.getParameter("patient_id");
	String resp_id	=	(String)session.getValue("responsibility_id");
	String complaint_desc = "";
	String complaint_text = "";
	String onset_datetime = "";
	String complaint_id = "";
	String remarks = "";
	String mode = "";
	String disable = "";
	PreparedStatement pstmt =null;
	ResultSet rs =null ;
	String error_apply="";
	String ERR_EXIST ="";
	String error_yn="";
	String open_in_modal="";
	String clear="";
	//String complaint_details="";


	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String Dob = (request.getParameter("Dob")==null?"":request.getParameter("Dob"));
//	String qrystr = request.getQueryString();
	
	String spltCode = (request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"));
	Dob = com.ehis.util.DateUtils.formatDate(Dob,"DMY","DMYHM",locale);
	//Dob = com.ehis.util.DateUtils.convertDate(Dob,"DMYHM","en",locale);
	open_in_modal = request.getParameter("open_in_modal")==null?"":request.getParameter("open_in_modal");
	clear = request.getParameter("clear")==null?"":request.getParameter("clear");
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]

	Connection con          = null; 
	try
	{
		con = ConnectionManager.getConnection(request);
		onset_datetime = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		
		String appl_string = "SELECT GET_TASK_APPLICABILITY('MARK_CHIEF_CMP_ERR',NULL,?,?,?,?,?) error_apply, nvl((SELECT 'Y' FROM CA_ENCNTR_CC_ERRLOG WHERE FACILITY_ID=? and   ENCOUNTER_ID=? AND ROWNUM=1),'N') ERR_EXIST   FROM DUAL";
		pstmt= con.prepareStatement(appl_string);
						
		pstmt.setString(1,resp_id);
		pstmt.setString(2,relationship_id);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,encounter_id);
		pstmt.setString(5,patient_id);
		pstmt.setString(6,facility_id);
		pstmt.setString(7,encounter_id);

		rs = pstmt.executeQuery();

		while(rs.next())
		{
		 
		 error_apply =rs.getString("error_apply")==null?"":rs.getString("error_apply");
		 ERR_EXIST =rs.getString("ERR_EXIST")==null?"":rs.getString("ERR_EXIST");
		 
		}

		
		if(pstmt!=null)
			pstmt.close();
		if(rs !=null)
			rs.close();
		
		if(mode.equals("modify"))
		{
			disable = "Disabled";
			//complaint_desc =  request.getParameter("complaint_desc")==null?"":request.getParameter("complaint_desc");
			complaint_text =  request.getParameter("complaint_text")==null?"":request.getParameter("complaint_text");
            /*added by Archana on 3/10/2010 at 3:07 PM for IN019870
			    If complaint_text contain double quotes then it will be replaced with the string(&quot;).
		     */
			complaint_text = complaint_text.replaceAll("\"", "&quot;");
			onset_datetime =  request.getParameter("onset_datetime")==null?"":request.getParameter("onset_datetime");
			onset_datetime =  com.ehis.util.DateUtils.convertDate(onset_datetime,"DMYHM","en",locale);
			complaint_id =  request.getParameter("complaint_id")==null?"":request.getParameter("complaint_id");	
			//remarks =  request.getParameter("remarks")==null?"":request.getParameter("remarks");
			open_in_modal = request.getParameter("open_in_modal")==null?"":request.getParameter("open_in_modal");	
			//out.println("complaint_text"+complaint_text);
			
			String comp_desc = "select complaint_desc,remarks from ca_encntr_chief_complaint  where FACILITY_ID =? and ENCOUNTER_ID =? and  complaint_id=? ";
			
			pstmt= con.prepareStatement(comp_desc);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,complaint_id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{

		 
				 complaint_desc =rs.getString("complaint_desc")==null?"":rs.getString("complaint_desc");
				 remarks =rs.getString("remarks")==null?"":rs.getString("remarks");
				
			}
		
		if(pstmt!=null)
			pstmt.close();
		if(rs !=null)
			rs.close();

			//complaint_details =  request.getParameter("complaint_details")==null?"":request.getParameter("complaint_details");
		}
		else{
			mode = "insert";
		}
		if(mode.equals("modify")&&error_apply.equals("A"))
		{
			open_in_modal = request.getParameter("open_in_modal")==null?"":request.getParameter("open_in_modal");
			p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
		}


	%>
<body onKeyDown='lockKey()'>
	<form name='RecPatChiefComplaintAddModifyForm' id='RecPatChiefComplaintAddModifyForm' action="../../servlet/eCA.RecPatChiefComplaintServlet" method='post' target='messageFrame' >
	<table border=0 cellpadding='1' cellspacing=0 width='75%' align=center >
	<td class='COLUMNHEADER' colspan='2' ><fmt:message key="eCA.AddComplaint.label" bundle="${ca_labels}"/></td>
	<tr>
	<% 
		if(open_in_modal.equals("Y")&& clear.equals("clear")){
			disable="";
			onset_datetime = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			//onset_datetime =  request.getParameter("date")==null?"":request.getParameter("date");
			//onset_datetime =  com.ehis.util.DateUtils.convertDate(onset_datetime,"DMYHM","en",locale);
			}
		%>
		<td class=label ><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/>	</td>
		<td class='fields'><input type='text' name='complaint_desc' id='complaint_desc' size='50' maxlength='50'   OnKeyPress='return CheckForSpecialCharacter(this)' OnBlur ='getViewCode(this)' OnChange='resetValues();setValue()' value="<%=complaint_text%>"  <%if(mode.equals("modify")){  %> readonly <%}%> <%=disable%>></input><input type='hidden' name='complaint_id' id='complaint_id' value='<%=complaint_id%>'></input><input type='button' name='ComplaintSrch' id='ComplaintSrch' value='?'  OnClick='resetValues();getViewCode(this);' class='button' <%=disable%>></input><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<!--  37744 STARTS  -->
	<%
		String compRemakSQL = "SELECT CHIEF_COMPLAINT_MAND_YN,CHIEF_REMARKS_MAND_YN from CA_PARAM";
		pstmt= con.prepareStatement(compRemakSQL);
		rs = pstmt.executeQuery();
		String chComplaintMandYN = "";
		String chRemarksMandYN = "";
		while(rs.next()){
			chComplaintMandYN = rs.getString("CHIEF_COMPLAINT_MAND_YN")==null?"N":(String)rs.getString("CHIEF_COMPLAINT_MAND_YN");
			chRemarksMandYN = rs.getString("CHIEF_REMARKS_MAND_YN")==null?"N":(String)rs.getString("CHIEF_REMARKS_MAND_YN"); 
		}
		
		if(pstmt!=null)
			pstmt.close();
		if(rs !=null)
			rs.close();
		
	%>
	<input type='hidden' name='chComplaintMandYN' id='chComplaintMandYN' value='<%=chComplaintMandYN%>'>
	<input type='hidden' name='chRemarksMandYN' id='chRemarksMandYN' value='<%=chRemarksMandYN%>'>
	<!--  37744 ENDS  -->
	<tr>
		<td class=label ><fmt:message key="eCA.ComplaintDetails.label" bundle="${ca_labels}"/></td>
		<!--<td class='fields'><textarea name='complaint_details' value='' rows='5' cols='70' onBlur="makeValidString(this)"><%=complaint_desc%></textarea><img src='../../eCommon/images/mandatory.gif'></td>-->
	    <!-- 37744 STARTS -->
		<td class='fields'><textarea name='complaint_details' value='' rows='5' cols='70' onBlur="makeValidString(this)"><%=complaint_desc%></textarea><%if(chComplaintMandYN.equals("Y")){ %> <img src='../../eCommon/images/mandatory.gif'><%}%> </td>
	    <!--37744 ENDS -->
	</tr>

	<tr>
		<td class=label   ><fmt:message key="Common.OnsetDateTime.label" bundle="${common_labels}"/> </td>		
			<td class='fields'>	<input type='text' name='onset_date' id='onset_date' value='<%=onset_datetime%>' size='15' maxlength='16' onblur='checkForCurrentDate(this,"DMYHM","<%=locale%>","<%=Dob%>");timeCalculate(this);' <%if(mode.equals("modify")){  %> readonly <%}%>><input type='image' src="../../eCommon/images/CommonCalendar.gif"  id ='imgCalendar' onclick="return showCalendarValidate('onset_date');" <%=disable%> ><img align='center'  src='../../eCommon/images/mandatory.gif'> 
			<input type='hidden' name='ServerDate' id='ServerDate' value='<%=onset_datetime%>'>
			</td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<%-- <textarea name='remarks' rows='2' cols='70' maxlength=100 onkeyPress = 'checkMaxLimit(this,100)' onBlur = 'return  ismaxlength(this)' ><%=remarks%></textarea></td> --%>
		<!-- 37744 STARTS-->
	    <textarea name='remarks' rows='2' cols='70' maxlength=100 onkeyPress = 'checkMaxLimit(this,100)' onBlur = 'return  ismaxlength(this)' ><%=remarks%> </textarea><%if(chRemarksMandYN.equals("Y")){ %><img src='../../eCommon/images/mandatory.gif'><%}%> </textarea></td>
		<!-- 37744 ENDS-->
	</tr>
	<% if(mode.equals("modify")&&error_apply.equals("A")){%>
	<tr>
	<td class='label' width='25%'> <fmt:message key="eCA.MarkasError.label" bundle="${ca_labels}"/></td>
	<td class='fields' width='25%'> <input type='checkbox' value='Y' name='error_yn' id='error_yn' onClick='show_rem(this)'></td> 
	</tr>
	<tr id="sh_rem" style="display:none">
	<td class='label' width ='25%'><fmt:message key="Common.ErrorRemarks.label" bundle="${common_labels}"/> </td>
	<td class='fields' width='25%'><textarea name='err_remarks' id='err_remarks' value='' rows='2' cols='70' maxlength=100 onkeyPress = 'checkMaxLimit(this,100)' onBlur = 'return  ismaxlength(this)'></textarea><img src='../../eCommon/images/mandatory.gif'> </td>
	</tr>
	<%}%>
	<tr align ='right'>
		
		<% if(ERR_EXIST.equals("Y")) {%>
		<td width='25%' align='left'><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorList.label","ca_labels")%>' name='Error_List' class='button' onclick='show_errList()'></input></td> 
		<%}
		 else {%>
		<td width='25%'>&nbsp;</td> <%}%>
		<td width ='50%'><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name='recordButton' id='recordButton' class='button' onclick='apply()' ></input>
		<input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' name='clearButton' id='clearButton' class='button' onclick='Clearpage()'></input>
		<!-- Below cancel button is commented by Archana Dhal on 11/12/2010 related to incident no IN024588 -->
		<!-- <input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' name='cancelButton' class='button' onclick='cancel_page()'></input> --></td>
	</tr>
	</table>
	<input type='hidden' name='text5' id='text5' value=''>
	<input type='hidden' name='text6' id='text6' value=''>
	<input type='hidden' name='text7' id='text7' value=''>
	<input type='hidden' name='text8' id='text8' value=''>
	<input type='hidden' name='text9' id='text9' value=''>
	<input type='hidden' name='onset_datetime' id='onset_datetime'	value='<%=onset_datetime%>'>
	<input type='hidden' name='facility_id' id='facility_id'		value="<%=facility_id%>"></input>
	<input type='hidden' name='encounter_id' id='encounter_id'	value="<%=encounter_id%>"></input>
	<input type='hidden' name='mode' id='mode'			value='<%=mode%>'></input>
	<input type='hidden' name='flag' id='flag' value='true'>
	<input type='hidden' name='viewCode' id='viewCode' value=''>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<!-- <input type='hidden' name='error_yn' id='error_yn'		value='<%=error_yn%>'></input> -->
	<input type='hidden' name='spltCode' id='spltCode' value='<%=spltCode%>'></input>
	<input type='hidden' name='open_in_modal' id='open_in_modal' value='<%=open_in_modal%>'></input>
	<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from_widget%>'></input> <!-- //CHL-CRF [IN035950] -->

	
	</form>
</body>
</html>
<%
	}
	catch(Exception e)
	{
	//	out.println("Exception @ RecPatChiefComplaintAddModify "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>


