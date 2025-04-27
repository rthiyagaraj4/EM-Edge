<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	// added by Arvind @ 27-11-08 
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
			 //end
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
	<script language='javascript' src='../../eCA/js/PatListByMedService.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
	<script  language='javascript'  src='../js/CAMenu.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
	
	<head>
		<%
			String toDate="";
			Connection con =null;
			PreparedStatement stmtLen = null,stmt = null;
			PreparedStatement pstmt=null;
			PreparedStatement stmtVt = null;
			ResultSet rsVt = null ;
			ResultSet rset = null,rsetLen = null;
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");
				con = ConnectionManager.getConnection(request);
				//HttpSession thisSession = request.getSession(false);
								
				String clinicianType=(String)session.getValue("practitioner_type");
				
				String selp = "";
				String seld = "";
				String visitvalue = "S";
				String fromvisitdate = "";
				String fromdischargedate = "";
				String establishrelnreqyn = "";
				String tab_menu_yn ="";
				String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
						if(ca_practitioner_id == null) ca_practitioner_id="";
				//out.println("ca_practitioner_id"+ca_practitioner_id);
				String facilityId = (String) session.getValue("facility_id");
						if(facilityId == null) facilityId="";
				String pract_name = "";
				String pract_query = "";
				if(clinicianType.equals("P")){
					selp = "selected";
					visitvalue = "Z";
				}else seld = "selected";

			try{
				String sql = " select to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') from_visit_date, "+
								" to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') from_discharge_date, "+
								" establish_reln_req_yn, tab_menu_yn "+
								" from ca_encntr_param ";
				stmt = con.prepareStatement(sql);
				rset = stmt.executeQuery();
				if(rset.next())
				{
					fromvisitdate = rset.getString("from_visit_date")==null?"":rset.getString("from_visit_date");
					fromdischargedate = rset.getString("from_discharge_date")==null?"":rset.getString("from_discharge_date");
					establishrelnreqyn = rset.getString("establish_reln_req_yn")==null?"Y":rset.getString("establish_reln_req_yn");
					tab_menu_yn = (rset.getString("tab_menu_yn")==null)?"":rset.getString("tab_menu_yn");
				}
				
				fromvisitdate		= com.ehis.util.DateUtils.convertDate(fromvisitdate,"DMY","en",locale);
				fromdischargedate	= com.ehis.util.DateUtils.convertDate(fromdischargedate,"DMY","en",locale);
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				
				toDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			}
			catch(Exception e)
			{
				//out.println(e);//COMMON-ICN-0181
                                e.printStackTrace();//COMMON-ICN-0181
			}
		%>

	</head>
	<body onLoad='defaultGroupBy();checkboxes();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='PatCriteriaFrm' id='PatCriteriaFrm'>
		<%	
						 String  sql = "select PATIENT_CLASS, AM_GET_DESC.AM_PATIENT_CLASS(PATIENT_CLASS,?,'2') SHORT_DESC  from  am_patient_class where patient_class in ('OP','IP','EM','DC') order by 2   ";
			  				
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,locale);
							rset = pstmt.executeQuery();
		%>
			<table id='PatCriteriaTbl' width='100%' border='0' cellpadding=3 cellspacing=0>
				 <tr><td class='COLUMNHEADER'  colspan='9' ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td></tr>

				<tr>
					<script language=javascript>
						function changeLocnCode(){
							 obj=document.forms[0].medServiceCode;
							 //alert("value"+document.forms[0].encounterType.value);
								 
								if(obj.value=='ALL')
								document.forms[0].groupByMedService.disabled=false;
								else	{
									if(document.forms[0].encounterType.value=='Z'){
									}else{
										document.forms[0].groupByMedService.checked=true;
										document.forms[0].groupByMedService.disabled=true;
										document.forms[0].groupByMedService.value='Y';
									}
								}
								
						}
					</script> 
					<td class='label' width=25% ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>	</td>
					<td class='fields' width=25% >	<select name='encounterType' id='encounterType' onchange='encTypeChange(this);changeLocnCode();'>
						<option value='Z'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<% 
								String patientClass = "";
								String selected = "";
								while (rset.next())
								{
									patientClass = rset.getString("PATIENT_CLASS")==null?"":rset.getString("PATIENT_CLASS");
									selected = patientClass.equals("IP")?"selected":"";
								%>	
									<option value='<%=patientClass%>' <%=selected%>><%=rset.getString("SHORT_DESC")%></option>
								<%}								 
							 if(rset!=null)rset.close();
							 if(pstmt!=null)pstmt.close();
							 %>
						</select>
					</td>
	
					<td class='label' width=25%  id='locLed' ><fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/></td>
					<td class='fields' width=25% >					
					<input type='text' name='medServiceDesc' id='medServiceDesc' value='' onBlur='getServiceCode(this,encounterType,"<%=ca_practitioner_id%>","<%=facilityId%>");' ><input type='hidden' id='locVal' name='medServiceCode' id='medServiceCode' value='ALL'><input type='button' name='medServiceButton' id='medServiceButton' class='button' value='?' onClick='populateService(encounterType,"<%=ca_practitioner_id%>","<%=facilityId%>");changeLocnCode();'><img id='patClsServ' style='display:none' src='../../eCommon/images/mandatory.gif'/>
					</td>
						</tr>
						<tr>
					<td class='label'  ><fmt:message key="eCA.ViewList.label" bundle="${ca_labels}"/></td>
					<td class='fields' >
						<select name='viewList' id='viewList' onchange='enablePract(this)'>
							<option value='S' <%=seld%>><fmt:message key="Common.SelfRelated.label" bundle="${common_labels}"/></option>
							<option value='Z' <%=selp%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						</select>
					</td>
						<%
				String PatIDLen  = "";
				String QIDLen	 = "";
				String QIDLegend = "";
				String nationID ="";
				String nationLen="";
				String sqlLen ="Select a.PATIENT_ID_LENGTH,a.ALT_ID1_LENGTH, b.short_desc,a.NAT_ID_LENGTH,a.NAT_ID_PROMPT  from mp_param a, mp_alternate_id_type b where  a.alt_id1_type = b.alt_id_type" ;
				stmtLen = con.prepareStatement(sqlLen);
				rsetLen = null;
				rsetLen	= stmtLen.executeQuery();
				while(rsetLen.next()){
					PatIDLen   = (rsetLen.getString("PATIENT_ID_LENGTH")==null)?"0":rsetLen.getString("PATIENT_ID_LENGTH");
				    QIDLen	   = (rsetLen.getString("ALT_ID1_LENGTH")==null)?"0":rsetLen.getString("ALT_ID1_LENGTH");
					QIDLegend  = (rsetLen.getString("short_desc")==null)?"0":rsetLen.getString("short_desc");
					nationID = (rsetLen.getString("NAT_ID_PROMPT")==null)?"0":rsetLen.getString("NAT_ID_PROMPT");
					nationLen =(rsetLen.getString("NAT_ID_LENGTH")==null)?"0":rsetLen.getString("NAT_ID_LENGTH");
				}
				if(rsetLen !=null) rsetLen.close();
				if(stmtLen !=null)stmtLen.close();
			%>
					<td  class='label'width=25%><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
					<td class='fields' width=25%><input type='text'  name='patientId' id='patientId' value=''  onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>' ><input align='right' type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()"></td>
				</tr>
				<tr>
				<%
					pract_query ="Select AM_GET_DESC.AM_PRACTITIONER(?,?,'1') physician_name from dual " ;
					pstmt = con.prepareStatement(pract_query);
					pstmt.setString(1,ca_practitioner_id);
					pstmt.setString(2,locale);

					rset  = pstmt.executeQuery();
					if(rset.next())
					{
						pract_name = rset.getString("physician_name") == null ? "" : rset.getString("physician_name");
					}
					if(rset !=null) rset.close();
					if(pstmt !=null)pstmt.close();
				%>
					<td class='label' colspan='1' width ='25%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='fields' width ='25%'><input type='text'  name='pract' id='pract' value=''  onKeyPress='' onBlur='populatePract1(this)' size='20' maxlength='20'><input type='button' name='practSearch' id='practSearch' value='?' class='button' tabIndex="4" onClick="populatePract()"><input type="hidden" name="AttendPract" id="AttendPract" value=''>
					</td>
					<td class='label' width='25%' colspan='1'><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
					<td class='fields' width ='25%' colspan='1'><input type='text'  name='specialty' id='specialty' value=''  onKeyPress='' onBlur='getSpecialty1(this)' size='20' maxlength='20'><input type='button' name='search' id='search' value='?'  class='button' tabIndex="4" onClick="getSpecialty()"><input type="hidden" name="specialty_code" id="specialty_code" value=''></td>
				</tr>
		</table>
			
 			<table   border=0 cellpadding=0 cellspacing=0 width='100%' style='display:none' id='moreCriteria'  bordercolor=white> 
			<tr><td colspan=7><table border=0 width='100%' cellpadding='3' align='center'>
			  <tr>
				
					<td class='label'   width='25%' ><%=QIDLegend%></td>
					<td class='fields'><input type='text' name='queueId' id='queueId' value=''  width='25%' size='<%=QIDLen%>' maxlength='<%=QIDLen%>'onKeyPress='return CheckForSpecChars(event)' ></td>
					</td>
			 
					<td class='label' width=25% ><%=nationID%></td>
					<td class='fields' width=25%><input type='text' name='nationID' id='nationID' value=''   size='<%=nationLen%>' maxlength='<%=nationLen%>'onKeyPress='return CheckForSpecChars(event)' ></td>
			</tr>
			
			</table>
	</td>
</tr>
<tr>
			<td id=pa2 class=label width=25%><fmt:message key="eCA.PastVisits.label" bundle="${ca_labels}"/></td>
			<td class = fields><input type="checkbox" name="past" id="past"  onClick="setVisitDate(this)" disabled ></td>
			<td id=frv2 class=label width=25% ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td id=frv22 class='fields' width=25% nowrap >&nbsp;<input id="from_date1"  type="text" name="from_date1" id="from_date1" size=10 maxlength=10 onBlur='validateDate(this,"V","DMY","<%=locale%>");CheckSystemDateLesser(this,from_date11,"<%=toDate%>","DMY","<%=locale%>");' readonly><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('from_date1');" >&nbsp;<b>-</b>&nbsp;<input id="from_date11" type="text" name="from_date11" id="from_date11" size=10 maxlength=10 title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>' onBlur='CheckSystemDateLesser(from_date1,this,"<%=toDate%>","DMY","<%=locale%>");' readonly><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv1" title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>' onclick="return showCalendarValidate('from_date11');" ></td>
</tr>
						<script language=javascript>
								document.getElementById("cal_pv").disabled=true;
								document.getElementById("cal_pv1").disabled=true;
						</script>
<tr>
			<td id=dis2 class=label width=25%><fmt:message key="Common.discharged.label" bundle="${common_labels}"/></td>
			<td class = fields><input type="checkbox" name="discharged" id="discharged" onClick="setDischargeDate(this)"></td>
			<td id=frd2 class=label width='25%' nowrap><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td id=frd22 class='fields' width=25% >&nbsp;<input class =' fields' type="text" name="from_date2" id="from_date2" size=10 maxlength=10 onBlur='validateDate(this,"D","DMY","<%=locale%>");CheckSystemDateLesser(this,from_date22,"<%=toDate%>","DMY","<%=locale%>")' readonly><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_di" onclick="return showCalendarValidate('from_date2');">&nbsp;<b>-</b>&nbsp;<input type="text" name="from_date22" id="from_date22" size=10 maxlength=10 onBlur='validateDate(this,"D","DMY","<%=locale%>");CheckSystemDateLesser(from_date2,this,"<%=toDate%>","DMY","<%=locale%>")' readonly><input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_di1"  onclick="return showCalendarValidate('from_date22');"></td>
</tr>
						<script language=javascript>
								document.getElementById("cal_di").disabled=true;
								document.getElementById("cal_di1").disabled=true;
						</script>

<tr id='wtl'>
			<td class='label'  width=25% ><fmt:message key="eCA.AdmittedPeriod.label" bundle="${ca_labels}"/></td>
			<td class='fields' colspan = 2 width='50%' >&nbsp;<input type="text" name="daysVal" size=10 maxlength=10  id='daysVal'   onBlur='CheckDate(this);CheckSystemDateLesser(this,daysVal1,"<%=toDate%>","DMY","<%=locale%>");'><input type='image' id=adm_cal1  src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('daysVal');">&nbsp;&nbsp;<input type="text" name="daysVal1"  size=10 maxlength=10 id='daysVal1'  onBlur='CheckDate(this);CheckSystemDateLesser(daysVal,this,"<%=toDate%>","DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif"  id=adm_cal2 onclick="return  showCalendarValidate('daysVal1');"></td>
			<td colspan = 2>&nbsp;</td>
<table>
				
</table>
</td>
	
</tr>				
				
			
						<table  border=0 cellpadding=3 cellspacing=0 width='100%' style='display:none' id='more2Criteria' bordercolor=white align='center'>
						<tr>
							<td   class='label' colspan=4><b><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;&nbsp;<input type=checkbox name='QS' id='QS' onClick='checkAll(this)' disabled  value='00'></td> 

						</tr>
						<tr>
							<td  class='label' width='25%' ><fmt:message key="Common.CheckedIn.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='CI' id='CI'  value='01' onClick='appendStatus(this);' disabled ></td>
							<td  class=label width='25%'><fmt:message key="eCA.ArrivedatNS.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='AAN' id='AAN'  value='02' onClick='appendStatus(this);' disabled ></td>
							<td  class=label width='25%' ><fmt:message key="eCA.VSRecorded.label" bundle="${ca_labels}"/>&nbsp;<input type=checkbox name='VS' id='VS'  value='03' onClick='appendStatus(this);' disabled ></td>
							<td  class=label width='25%' ><fmt:message key="eCA.ConsInProgress.label" bundle="${ca_labels}"/>&nbsp;<input type=checkbox name='CIP' id='CIP'  value='04' onClick='appendStatus(this);' disabled ></td>
						</tr>
						<tr>
							<td  class=label width='25%' ><fmt:message key="Common.Treat/Invest.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name='TI' id='TI'  value='05' onClick='appendStatus(this);' disabled ></td>
							<td  class=label width='25%' ><fmt:message key="eCA.ReturnfromInvest.label" bundle="${ca_labels}"/>&nbsp;<input type=checkbox name='RFI' id='RFI'  value='06' onClick='appendStatus(this);' disabled ></td>
						
						
							<td  class=label width='25%'><fmt:message key="Common.CheckedOut.label" bundle="${common_labels}"/>&nbsp;<input type=checkbox  name='CO' id='CO'  value='07' onClick='appendStatus(this);' disabled ></td>	
							<td colspan=1></td>
						</tr>
						 </table>
					 						
								</tr>
									</table>
				<table  border=0 cellpadding=3 cellspacing=0   width='100%' id='more1Criteria' bordercolor=white align='center'>

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
				<td colspan='1' id='asOn' class='data'   align='left'></td><td>&nbsp</td>

				</tr>
				
				
				<tr>
					<td id=un1  class='label' width='25%'><fmt:message key="Common.Unassigned.label" bundle="${common_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name='unscheduled' id='unscheduled' value='Y' disabled onClick='changeViewListValue(this)'></input>
					</td>
					<td  class='label' colspan='2' width='50%' ><b><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></b>
					&nbsp;&nbsp;
					<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/><input type='checkbox' name='groupByEpisode' id='groupByEpisode' value='Y' checked onclick='checkboxChk(this)' >
					
					<fmt:message key="Common.MedicalService.label" bundle="${common_labels}"/><input type='checkbox' name='groupByMedService' id='groupByMedService' value='Y' checked onclick='checkboxChk(this)'></td>
					<td colspan='1'  class='data'   align='left'></td>
				</tr>
						<tr><td colspan='2'>&nbsp;</td>
						<td align='right' colspan='2' >
						<input type='button' class='button' name='search' id='search' id='searchID' 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'
						onclick="strcon();searchClick();disBtn(this);" ></input>
						<input type='button' class='button' name='clear' id='clear' onclick="javascript:clearClick()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' ></input>
						<input type="button" class='button' name='more' id='more' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.morecriteria.label","common_labels")%>'   onClick="makeVisible(this,'<%=tab_menu_yn%>');">
							</input>
						</td>
							
				</tr>
				</table>

				<!-- added by arvind @ 27-11-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->
							
			
				<input type=hidden name='sortOrder' id='sortOrder' value='v'><!--  -->
				<input type="hidden" name="from_visit_date" id="from_visit_date" value="<%=fromvisitdate%>">
				<input type="hidden" name="from_discharge_date" id="from_discharge_date" value="<%=fromdischargedate%>">
				<input type="hidden" name="establish_reln_req_yn" id="establish_reln_req_yn" value="<%=establishrelnreqyn%>">
				<input type="hidden" name="todaydate" id="todaydate" value="<%=toDate %>">
				<input type="hidden" name="mode" id="mode" value="search"><!--  -->
				<!-- added by ankur for saving the following values when sorting is done from fixed title bar -->
				<input type="hidden" name="order_by" id="order_by" value="">
				<input type="hidden" name="re_order" id="re_order" value="">
				<input type="hidden" name="anchor_id" id="anchor_id" value="">
				<input type="hidden" name="locn_type" id="locn_type" value="">
				<input type='hidden' name='queueStatus' id='queueStatus' value="">
				<input type='hidden' name='queueStatus1' id='queueStatus1' value=''>
				<input type='hidden' name='frameProperty' id='frameProperty' value=''>
				<input type='hidden' name='locale' id='locale' value='<%=locale%>'> 
				<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityId%>'> 
				<input type='hidden' name='url' id='url' value=''> 
				<input type=hidden value='<%=pract_name%>' name='pract_name'>
				<input type=hidden value='<%=ca_practitioner_id%>' name='ca_practitioner_id'>
			</form>

				<script language="JavaScript">
					var relnreqyn = '<%=establishrelnreqyn%>';
					var queueStatus=document.forms[0].queueStatus.value;
					//top.content.workAreaFrame.colorRefframe.location.href = '../jsp/CAPatColorReference.jsp?reln_req_yn='+relnreqyn
					//top.content.workAreaFrame.PatResultFr.location.href = '../jsp/PatListByMedServiceResultMain.jsp?encounterType=Z&medServiceCode=ALL&viewList=<%=visitvalue%>&groupByMedService=Y&groupByEpisode=Y&reln_req_yn='+relnreqyn+'&queueStatus=~01~,~02~,~03~,~04~,~05~,~06~';
				</script>




				<!-- Changes for Prevoius Next Functionality -->
				<input type="hidden" name="mode" id="mode" value="search">
				<!-- end of change-->

				<script>
					if(document.PatCriteriaFrm.viewList.value == 'S')
					{
						document.PatCriteriaFrm.pract.disabled = true;
						document.PatCriteriaFrm.practSearch.disabled = true;
						document.PatCriteriaFrm.AttendPract.value = '<%=ca_practitioner_id%>';
						document.PatCriteriaFrm.pract.value = '<%=pract_name%>';
					}
				</script>
		</body>
</html>

<%
}
catch ( Exception e) 
{
	//out.println(e);//COMMON-ICN-0181
         e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
			
 }
%>

