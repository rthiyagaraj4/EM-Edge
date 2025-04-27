<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	%>
<html>
 <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

Connection			con		= null;
PreparedStatement	pstmt	= null;
PreparedStatement	pstmt1	= null;
ResultSet			rs		= null;
ResultSet			rs1		= null;

con = ConnectionManager.getConnection(request);

String vac_sch_ref ="";
//String vacc_categ_id ="";
//String patient_id ="";
String vaccine_id ="";
//String vaccine_id1 ="";
String dose_no ="";
String vac_srl_no ="";
String mode ="";
String disbl ="";
String Vacc_desc ="";
String reaction_date1 ="";
String reaction_code1 ="";
String reaction_remarks1 ="";
String reaction_treatment1 ="";
String disbl_butt ="";
String mode_new ="";
String CurrentDate ="";
String status ="";
String dis_butt ="";
String vaccine_desc ="";

CurrentDate	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);


vac_sch_ref = request.getParameter("vac_sch_ref")==null?"":request.getParameter("vac_sch_ref");
vaccine_id = request.getParameter("vaccine_id")==null?"":request.getParameter("vaccine_id");
dose_no = request.getParameter("dose_no")==null?"":request.getParameter("dose_no");
vac_srl_no = request.getParameter("vac_srl_no")==null?"":request.getParameter("vac_srl_no");
mode = request.getParameter("mode")==null?"":request.getParameter("mode");
mode_new = request.getParameter("mode_new1")==null?"":request.getParameter("mode_new1");
status = request.getParameter("status")==null?"":request.getParameter("status");
vaccine_desc = request.getParameter("vaccine_desc")==null?"":request.getParameter("vaccine_desc");


if(status.equals("E"))
{
  dis_butt="disabled";
  disbl ="readOnly";
  disbl_butt ="disabled";
}
else
{
	dis_butt="";

}

String query_string = request.getQueryString();



%>


<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../js/ScheduleForVacination.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <head>
<Script>
function record_AllergyDet()
{
        var mode =parent.parent.parent.parent.frames[0].document.getElementById("mode").value;
	//	alert("mode..."+mode);
		var fields = new Array (parent.AllergyAddModify.document.getElementById("reaction_Date"),parent.AllergyAddModify.document.getElementById("reaction_code"));

		var names = new Array (getLabel("Common.ReactionDate.label","COMMON"),getLabel("Common.Reaction.label","COMMON"));

		if(checkFields( fields, names,parent.parent.parent.parent.messageFrame))
		{

			parent.AllergyAddModify.document.forms[0].submit();

		}

}
</script>


  </head>
  <body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
   <form name='adminDetailform' id='adminDetailform' method='post' target='messageFrame' action='../../servlet/eCA.ScheduleVaccinAdminServlet'>
   <%
   try {

	   if (mode_new.equals("view"))
		{
			disbl ="readOnly";
			disbl_butt ="disabled";
	   
		String Allergy_det_qry="select CA_GET_DESC.CA_IM_VACCINE (A.VACCINE_ID,? ,2) Vacc_desc,to_char(REACTION_DATE,'DD/MM/YYYY HH:MI') REACTION_DATE,REACTION_CODE,REACTION_REMARKS , REACTION_TREATMENT from CA_IM_PAT_VAC_REACTION A where a.VAC_SCH_REF =? and A.VACCINE_ID =? and a.DOSE_NO =? and A.VAC_SRL_NO=? ";
		

		pstmt1=con.prepareStatement(Allergy_det_qry);
		pstmt1.setString(1,locale);
		pstmt1.setString(2,vac_sch_ref);
		pstmt1.setString(3,vaccine_id);
		
		pstmt1.setString(4,dose_no);
		
		pstmt1.setString(5,vac_srl_no);
	
		rs1 = pstmt1.executeQuery();
		

		while(rs1.next())
		{
			
			Vacc_desc =rs1.getString("Vacc_desc")==null?"":rs1.getString("Vacc_desc");
			
			reaction_date1 =rs1.getString("REACTION_DATE")==null?"":rs1.getString("REACTION_DATE");
			
			reaction_code1 =rs1.getString("REACTION_CODE")==null?"":rs1.getString("REACTION_CODE");
			
			reaction_remarks1 =rs1.getString("REACTION_REMARKS")==null?"":rs1.getString("REACTION_REMARKS");
			
			reaction_treatment1 =rs1.getString("REACTION_TREATMENT")==null?"":rs1.getString("REACTION_TREATMENT");
			

		}

		if(rs1 != null) rs1.close();
		if(pstmt1 != null) pstmt1.close();
	
	}// end if
	String reaction_query ="select REACTION_CODE,SHORT_DESC from  am_reaction_lang_vw where EFF_STATUS='E' AND ADVERSE_REACTION_YN ='Y' and language_id=? ORDER BY 2 ";
		//con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(reaction_query);
		pstmt.setString(1,locale);	
%>
<table cellpadding='0' cellspacing='0' border='0' width='100%' style="height:60vh" align='center'>
	<tr>
		<td class='label' width='25%'><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input id='vname' type='text' name='vaccine_name1' id='vaccine_name1' value='<%if(mode_new.equals("all_rec")){%><%=vaccine_desc%><%}else if(mode_new.equals("view")){%> <%=Vacc_desc%> <%}%>' readOnly >   </td>
		<td class='label' width='25%' colspan="2"><input type='hidden' name='dose_no' id='dose_no' value='<%=dose_no%>'></td>		
	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='reaction_Date' id='reaction_Date' value='<%if(mode_new.equals("all_rec")){%><%=CurrentDate%><%}else if(mode_new.equals("view")){%><%=reaction_date1%><%}%>' size=14 maxlength=16 onBlur='CheckDateTime(this,"ReactionDate");' <%=disbl%> ><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" <%=dis_butt%> onclick="return showCalendarValidate('reaction_Date');" ><img src='../../eCommon/images/mandatory.gif'></td>
		
		<td class='label' width='25%'><fmt:message key="Common.Reaction.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
		<select name='reaction_code' id='reaction_code' <%=disbl_butt%>>
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%		
				rs= pstmt.executeQuery();
				while(rs.next()){ %>
					<option value='<%=rs.getString("REACTION_CODE")%>'  <% if ((rs.getString("REACTION_CODE")).equals(reaction_code1)){ out.println("selected"); }%>><%=rs.getString("SHORT_DESC")%></option>
			<%	}			
			%>	
		</select><img src='../../eCommon/images/mandatory.gif'>		
		</td>
	</tr>
	<tr>
	<td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='3'><textarea name='allergy_remark' value="" rows=4 cols=70 value='' onBlur="SPCheckMaxLen('Remarks Text',this,500,'')" onkeyPress='return checkMaxLimit(this,500)' <%=disbl%>><%=reaction_remarks1%></textarea></td>
	</tr>
	<tr>
	<td class='label' width='25%'><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='3'><textarea name='allergy_treat' value="" rows=4 cols=70 value='' onBlur="SPCheckMaxLen('Treatment Text',this,500,'')" onkeyPress='return checkMaxLimit(this,500)' <%=dis_butt%>><%=reaction_treatment1%></textarea></td>
	</tr>
	<tr>
		<td class='label' colspan='2'>&nbsp;</td>
		<td class='fields' width='25%' align='right'><input type='button' class='button' name='record' id='record' id = 'record' onclick="record_AllergyDet();" <%=dis_butt%>	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' ></input>
						<input type='button' class='button' name='clear' id='clear' onclick="clearAlergyFields();" <%=dis_butt%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input></td>
	</tr>


    </table>

   <%   
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
   }catch(Exception e){
		
		e.printStackTrace();
	}finally{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
		
	%>
	<input type=hidden value='<%=locale%>' name='locale'>
	<input type=hidden value='' name='Dob' id='Dob'>
	<input type='hidden' value='<%=mode_new%>' name='mode'>
	<input type='hidden' value='<%=vaccine_id%>' name='vaccine_id'>
	<input type='hidden' value='<%=vac_sch_ref%>' name='vac_sch_ref'>
	<input type='hidden' value='<%=vac_srl_no%>' name='vac_srl_no'>
	<input type='hidden' value='<%=query_string%>' name='query_string'>
	
	</form>

 </body>
</html>

