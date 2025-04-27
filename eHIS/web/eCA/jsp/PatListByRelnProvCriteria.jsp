<!DOCTYPE html>
 <%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	// added by Arvind @ 27-11-08 

	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
			 //end
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../js/PatListByRelnProv.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../js/CAMenu.js' language='javascript'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
	<head>
		<%
			String toDate = "";
			String fromDate = "";
			Connection con = null;
			PreparedStatement stmt = null ;
			ResultSet rset = null;
			PreparedStatement pstmt=null;

			PreparedStatement stmtVt = null;
			ResultSet rsVt = null ;

			try
			{
			con = ConnectionManager.getConnection(request);
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");

			String facilityId = (String) session.getValue("facility_id");
						if(facilityId == null) facilityId="";
			toDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			fromDate = com.ehis.util.DateUtils.minusDate(toDate, "DMY", locale, 7, "d");
			
			String establishrelnreqyn = "";

			try
			{
				if (rset!=null) rset.close();
				if (stmt!=null) stmt.close();
				
				String sql = " select establish_reln_req_yn  from ca_encntr_param ";
				stmt = con.prepareStatement(sql);
				rset = stmt.executeQuery();
				if(rset.next())
				{
					establishrelnreqyn = rset.getString("establish_reln_req_yn")==null?"Y":rset.getString("establish_reln_req_yn");
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();

			}
			catch (Exception e)
			{
				//out.println("Exception"+e.toString());//COMMON-ICN-0181
                                   e.printStackTrace();//COMMON-ICN-0181
			}

			
		%>
	</head>
	<body  class='CONTENT'  onLoad='defaultGroupBy();'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='PatCriteriaFrm' id='PatCriteriaFrm'>
			<table id='PatCriteriaTbl' width='100%' border='0' cellpadding='2' cellspacing=0 align='center'>
				 <tr>
					<td class='columnheader' colspan=6  ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
			<%	
						 //String  sql = " select PATIENT_CLASS, SHORT_DESC  from  am_patient_class where patient_class in ('OP','IP','EM','DC') order by 2  ";

							//String  sql = " select PATIENT_CLASS,  SHORT_DESC  from  am_patient_class_lang_vw where patient_class in ('OP','IP','EM','DC') and language_id = ? order by 2 "; 
							String  sql = " select PATIENT_CLASS,  SHORT_DESC  from  am_patient_class_lang_vw where language_id = ? order by 2 "; 

			  				if(rset!=null)rset.close();
							if(pstmt != null)pstmt.close();
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,locale);
							rset = pstmt.executeQuery();
							//if(pstmt != null)pstmt.close();
			%>

					<td class='label' width='25%' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'> 
						<select name='locationType' id='locationType' onchange='locnTypeChange(this);changeLocnCode()'>
						<option value='Z'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<% 
									while (rset.next())
									{	
										out.println("<option value="+rset.getString("PATIENT_CLASS")+">"+rset.getString("SHORT_DESC")+"</option>");
									}	
							 %>
						</select>
					</td>

					<td class='label'  id='locLed' width='25%'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/>	</td>
					<td class ='fields' width='25%'>
					<input type='text' name='relnDesc' id='relnDesc' value='' size='30' maxlength='30'onBlur="getRelnCode(this)"><input type='hidden' id='locVal'  name='relnCode' id='relnCode' value='ALL'><input type='hidden' name='locale' id='locale' value='<%=locale%>'><input type='Button' name='relnCodeButton' id='relnCodeButton' class='button' value='?' onClick='showRelnCodeWindow()'>
										
					</td>
			<%
				String PatIDLen  = "";
				String QIDLen	 = "";
				String QIDLegend = "";

				//String sqlLen ="Select a.PATIENT_ID_LENGTH,a.ALT_ID1_LENGTH, b.short_desc from mp_param a, mp_alternate_id_type b where  a.alt_id1_type = b.alt_id_type" ;


				String sqlLen ="Select a.PATIENT_ID_LENGTH,a.ALT_ID1_LENGTH, MP_GET_DESC.MP_ALTERNATE_ID_type(a.alt_id1_type,?,'2') short_desc from mp_param a";

				PreparedStatement stmtLen = null;
				ResultSet rsetLen = null;
				stmtLen = con.prepareStatement(sqlLen);
				stmtLen.setString(1,locale);
				rsetLen			  = stmtLen.executeQuery();

				while(rsetLen.next())
				{
					PatIDLen   = (rsetLen.getString("PATIENT_ID_LENGTH")==null)?"0":rsetLen.getString("PATIENT_ID_LENGTH");
				    QIDLen	   = (rsetLen.getString("ALT_ID1_LENGTH")==null)?"0":rsetLen.getString("ALT_ID1_LENGTH");
					QIDLegend  = (rsetLen.getString("short_desc")==null)?"0":rsetLen.getString("short_desc");
				}

				if(rsetLen!=null) rsetLen.close();
				if(stmtLen !=null)stmtLen.close();

			%>
			</tr><tr>  
			<td  width='25%' class='label' 	><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>

			<td width='25%' class='fields'> <input type='text' width='16%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>' ><input type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>

			
<!-- 		  <td colspan='7'>
		 	<table border='1'>
			  <tr>
 -->		 <td class='label' width='25%' ><fmt:message key="eCA.RelationshipPeriod.label" bundle="${ca_labels}"/></td>

			 <td class='fields' width='25%'> <input type='textbox' id='fromDt' name='fromDt' id='fromDt' value='<%=fromDate%>' size=10 maxlength=10 onblur='CheckDate(this);ftDateCheck(this,toDt,"<%=toDate%>","DMY","<%=locale%>","from");'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDt')">&nbsp;<input type='textbox' id='toDt' name='toDt' id='toDt' value='<%=toDate%>' size=10 maxlength=10 onblur='CheckDate(this);ftDateCheck(fromDt,this,"<%=toDate%>","DMY","<%=locale%>","to");'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDt')"></input><img src='../../eCommon/images/mandatory.gif'/>
			 </td> </tr>
			 <tr>
				<td class='LABEL' colspan='1' width ='25%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class='fields' width ='25%'><input type='text'  name='pract' id='pract' value=''  onKeyPress='' onBlur='populatePract1(this)' size='20' maxlength='20'><input type='button' name='practSearch' id='practSearch' value='?' class='button' tabIndex="4" onClick="populatePract()"><input type="hidden" name="AttendPract" id="AttendPract" value=''>
				</td>
				<td class='label' width='25%' colspan='1'><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
				<td class='fields' width ='25%' colspan='1'><input type='text'  name='specialty' id='specialty' value=''  onKeyPress='' onBlur='getSpecialty1(this)' size='20' maxlength='20'><input type='button' name='search' id='search' value='?'  class='button' tabIndex="4" onClick="getSpecialty()"><input type="hidden" name="specialty_code" id="specialty_code" value=''></td>
			</tr>
			 <tr>
			 <td class='label' width='25%' ><%=QIDLegend%></td>

			 <td class='fields' width='25%'><input type='text' name='queueId' id='queueId' value=''  size='<%=QIDLen%>' maxlength='<%=QIDLen%>'onKeyPress='return CheckForSpecChars(event)' ></td>

		<td class='label' colspan=2><fmt:message key="Common.Include.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
		<fmt:message key="Common.CheckedOut.label" bundle="${common_labels}"/> <input class = 'fields' type='checkbox' name='checkedOut' id='checkedOut' value='N'  onclick='setCheckedOut(this)'>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.discharged.label" bundle="${common_labels}"/> <input class = 'fields' type='checkbox' name='discharged' id='discharged' value='N'  onclick='setDischarged(this)'>&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.NonEncSpecific.label" bundle="${ca_labels}"/> <input class = 'fields' type='checkbox' name='nonencspec' id='nonencspec' value='N'  onclick='setNonEncSpec(this)'></td>
		</tr>
		
		<tr> 
			<td class=label width='25%'  ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
			<td width='25%'  class='fields'>
					<select name='visitType' id='visitType' onchange='visitTypeChange(this.value)' disabled > 
					<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
					<%

						String visit_qry = " select VISIT_TYPE_CODE, SHORT_DESC,VISIT_TYPE_IND from OP_VISIT_TYPE where FACILITY_ID = ? order by 2 " ;

						stmtVt = con.prepareStatement(visit_qry);
		
						stmtVt.setString(1,facilityId);
						
						rsVt = stmtVt.executeQuery();
						while(rsVt.next())
						{

							out.println("<option value="+rsVt.getString("VISIT_TYPE_CODE")+">"+rsVt.getString("SHORT_DESC")+"</option>");

						}

						if(rsVt!=null) rsVt.close();
						if(stmtVt!=null) stmtVt.close();
					
					%>

					</select>
			</td>
			<td class='label' >&nbsp;</td>
			<td class='label'   id='sortord' >
				<fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/>
				<select name='sortOrder' id='sortOrder'>
						<option value='v'><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></option>
						<option value='p'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></option>
				</select>
			</td>

		</tr>

		
		<tr> 
		<td  class='label' width='25%'>
			&nbsp;&nbsp;
		</td>
		<td class='label' colspan='2' width='50%'><b><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/><input class = 'fields' type='checkbox' name='groupByEpisode' id='groupByEpisode' value='Y' checked onclick='checkboxChk(this)'></input>
		<fmt:message key="Common.relationship.label" bundle="${common_labels}"/>			<input type='checkbox' name='groupByReln' id='groupByReln' value='Y' checked onclick='checkboxChk(this)'></input>
		</td>
		<!--<td class='label'   id='sortord' >
			<fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/>
			<select name='sortOrder' id='sortOrder'>
					<option value='v'><fmt:message key="Common.VisitAdmDate.label" bundle="${common_labels}"/></option>
					<option value='p'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></option>
			</select>
		</td>-->
		</tr>
		<tr>
					<td id='asOn' class='DATA'   width='20%' nowrap>&nbsp;</td>
					<td id='asOn1' class='DATA'  width='20%' nowrap>&nbsp;</td>
					<td id='asOn2' class='DATA'  width='20%' nowrap>&nbsp;</td>

					<td  align='right' width='20%' >
						<input type='button' class='button' name='search' id='search' id='searchID' onclick="javascript:searchClick();disBtn(this)" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'>&nbsp;<input type='button' class='button' name='clear' id='clear' onclick="javascript:clearClick()"value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'>
					</td>

					</tr>
						
			</table>

			<!-- added by arvind @ 27-11-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->

						<!-- added by ankur for saving the following values when sorting is done from fixed title bar -->
			<input type="hidden" name="order_by" id="order_by" value="">
			<input type="hidden" name="re_order" id="re_order" value="">
			<input type="hidden" name="anchor_id" id="anchor_id" value="">
			<input type="hidden" name="locn_type" id="locn_type" value="">
			<input type='hidden' name='url' id='url' value=''> 
			<input type='hidden' value='<%=facilityId%>' name='facilityid' ></input>
		<!------------------------>
		</form>
		<script language="javaScript">
		
				var relnreqyn = '<%=establishrelnreqyn%>';
				//top.content.workAreaFrame.colorRefframe.location.href = '../jsp/CAPatColorReference.jsp?reln_req_yn='+relnreqyn
				//top.content.workAreaFrame.PatResultFr.location.href = '../jsp/PatListByRelnProvResultMain.jsp?locationType=Z&relationshipCode=ALL&groupByReln=Y&groupByEpisode=Y&reln_req_yn='+relnreqyn

		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</body>
</html>
		<!-- Changes for Prevoius Next Functionality -->

		<input type="hidden" name="mode" id="mode" value="search">
		<input type="hidden" name="locn_type" id="locn_type" value="">

			<!-- end of change-->


		<%
			} 
			catch ( Exception e) 
			{
			//out.println("Exception "+e.toString());//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
			}
			finally 
			{
				if(rset!=null)rset.close();
				if(pstmt != null)pstmt.close();				
				if(con!=null)ConnectionManager.returnConnection(con,request);	
			}
		%>

