<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
24/10/2017		IN065452		Krishna Gowtham		25/10/2017		Ramesh G	ML-MMOH-CRF-0566.2
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 28/01/2009  */
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg"; 
	 }
	 /** ends here*/
	String fromPage= request.getParameter("linkValue") == null ? "" : request.getParameter("linkValue");
	if((fromPage==null)||fromPage.equals(""))
	{
		fromPage= request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
	}
	String sel="";
	String sel1="";
	String sel2="";
	if(fromPage.equals("SE"))
	sel="selected";
	if(fromPage.equals("SP"))
	sel1="selected";
	if(fromPage.equals("PAT_LIST_BY_REFERAL"))
	sel2="selected";
	
%>
	
	<link rel='stylesheet' type='text/css' href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../js/ReferralPatList.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>		
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		
	<%
		Connection con = null;
		
		try
		{
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			String clinicianType = "";
			String ca_practitioner_id = (String)session.getValue("ca_practitioner_id");
					if(ca_practitioner_id == null) ca_practitioner_id = "";
			String facilityId = (String) session.getValue("facility_id");
					if(facilityId == null) facilityId = "";
			String selp = "";
			String seld = "";
			String visitvalue = "S";
			String establishrelnreqyn = "";
			String toDate = "";
			String dt = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			String dt1 = com.ehis.util.DateUtils.minusDate(dt,"DMY",locale,7,"d");
			
			String linkValue = request.getParameter("linkValue") == null ? "" : request.getParameter("linkValue");
			
			if(clinicianType.equals("P"))
			{
				selp = "selected";
				visitvalue = "Z";
			}
			else
			{
				seld = "selected";
			}
			
			con = ConnectionManager.getConnection(request);
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String sql1 = " select establish_reln_req_yn  from ca_encntr_param ";

			pstmt = con.prepareStatement(sql1);
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				establishrelnreqyn = rset.getString("establish_reln_req_yn")==null?"Y":rset.getString("establish_reln_req_yn");
			}

			if(rset!=null)rset.close();
			if(pstmt != null)pstmt.close();

			//IN064836 start
			String refRegSiteYN = "";
			Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
			if(referralRegister)
			{
				refRegSiteYN = "Y";
			}
			else
			{
				refRegSiteYN = "N";
			}
			//IN064836 ends

	 %>
	
	</head>
	<body class='CONTENT' onLoad='defaultGroupBy();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='PatCriteriaFrm' id='PatCriteriaFrm'>
			<table id='PatCriteriaTbl' width='100%' border='0' cellpadding='0' cellspacing=0>
				<tr><td class ='columnheader' colspan=5><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td></tr>
				<tr>
			<%	
					String  sql = "select PATIENT_CLASS, SHORT_DESC  from  am_patient_class_lang_vw where LANGUAGE_ID=? and  patient_class in ('OP','IP','EM','DC') order by 2 ";
			  				
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);

					rset = pstmt.executeQuery();
			
					String locnType = request.getParameter("locationType")==null?"":request.getParameter("locationType"); 
					String display = "";
			%>
					<td class='LABEL' colspan=1 width='25%' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td width='25%'  class='fields'>
						<select name = 'locationType' onchange='locnTypeChange(this)'> 
						<option value = 'Z'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			
			<% 
					while (rset.next())
					{
						if(locnType.equals(rset.getString("PATIENT_CLASS")))
							display = rset.getString("PATIENT_CLASS")+"    selected ";
						else
						{
							display = rset.getString("PATIENT_CLASS");
						}

						out.println("<option value="+display+">"+rset.getString("SHORT_DESC")+"</option>");
					}	
							
					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
			%>
						</select>
					</td>
					<td class='LABEL'   id='locLed' width='5%'>&nbsp;</td>
					<td class='LABEL'   id='locLed' width='10%'>&nbsp;</td>
					<!-- <td class='LABEL' colspan=1 width='20%' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td> -->
					<td  width='35%'  class='fields' colspan=2>
						<input type='text' name="locationDesc"  id='locVal' value=""  size='20' maxlength='20' 
						 onkeypress="" onBlur="getClinicCode1(this)"><input type='button' class='button' value='?' id='src_butn'  name='search_ref' id='search_ref' onClick="getClinicCode()">
						<input type="hidden" name="locationCode" id="locationCode" value='*ALL'>
					</td>
										
					
					<%	if(!locnType.equals("")){ // this condition will be get fired when you are calling this page from Home Page%>
							<script language="JavaScript">
									
							</script>	
					<% }%>


					  <script language="JavaScript">						 
						//document.getElementById("locLed").innerText=' ';//getLabel("Common.clinic.label","COMMON");
						document.getElementById("locVal").style.visibility='hidden';
						document.getElementById("src_butn").style.visibility='hidden';
						document.forms[0].locationDesc.disabled = false;
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 					
					</tr><tr>
			<%
					String PatIDLen  = "";
					String QIDLen	  = "";
					String QIDLegend = "";
					String nationID = "";
					String nationLen= "";
		
					String sqlLen ="Select a.PATIENT_ID_LENGTH,a.ALT_ID1_LENGTH,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(a.alt_id1_type,?,'2') short_desc,a.NAT_ID_LENGTH,a.NAT_ID_PROMPT from mp_param a " ;
					PreparedStatement stmtLen = con.prepareStatement(sqlLen);
					stmtLen.setString(1,locale);

					ResultSet rsetLen = null;
					rsetLen  = stmtLen.executeQuery();
					while(rsetLen.next())
					{
						PatIDLen   = (rsetLen.getString("PATIENT_ID_LENGTH")==null)?"0":rsetLen.getString("PATIENT_ID_LENGTH");
						nationID = (rsetLen.getString("NAT_ID_PROMPT")==null)?"0":rsetLen.getString("NAT_ID_PROMPT");
						nationLen =(rsetLen.getString("NAT_ID_LENGTH")==null)?"0":rsetLen.getString("NAT_ID_LENGTH");
					    QIDLen	   = (rsetLen.getString("ALT_ID1_LENGTH")==null)?"0":rsetLen.getString("ALT_ID1_LENGTH");
						QIDLegend  = (rsetLen.getString("short_desc")==null)?"0":rsetLen.getString("short_desc");
					}
					if(rsetLen !=null) rsetLen.close();
					if(stmtLen !=null)stmtLen.close();
			%>
					<td class='label'  width='25%' colspan=1 ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields' width ='25%' colspan=1><input type='text'  name='patientId' id='patientId' value=''  onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>'><input type=button name=search value='?' class=button tabIndex="4" onClick="callPatientSearch()"></td>
					<td class='label' width='5%'>&nbsp;</td>
					<td id=frv2 class='label' width ='10%' style="text-align:right">
						<b><fmt:message key="Common.Period.label" bundle="${common_labels}"/></b></td>					
					<td class ='fields' width ='35%' nowrap>
						<input class = 'fields' id="from_date"  type="text" name="from_date" id="from_date" size=10 maxlength=10 value='<%=dt1%>' onBlur='doDateCheckLoc(this,to_date,"<%=toDate%>","DMY","<%=locale%>",this);'>
						<input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('from_date');" ><img src='../../eCommon/images/mandatory.gif'></img><B>-</B>
						<input class = 'fields' id="to_date" type="text" name="to_date" id="to_date" size=10 maxlength=10 title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>' onBlur='doDateCheckLoc(from_date,this,"<%=toDate%>","DMY","<%=locale%>",this);' value='<%=dt%>'>
						<input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv1" title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>'; onclick="return showCalendarValidate('to_date');"><img src='../../eCommon/images/mandatory.gif'></img>
					</td>
					</tr>
					<tr>
					<td class='label' width ='25%'><b><fmt:message key="Common.Include.label" bundle="${common_labels}"/></b></td>
					<td nowrap class ='fields' width ='25%'>					
					<select name="IncCriteria" id="IncCriteria">
						<option value="Self" <%=sel%>><fmt:message key="Common.self.label" bundle="${common_labels}"/></option>
						<option value="Unassigned" <%=sel1%>><fmt:message key="eCA.SpltySpcific.label" bundle="${ca_labels}"/></option>
						<option value="Both" <%=sel2%>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					</select>
					&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.PendingReferrals.label" bundle="${ca_labels}"/> 
					<!--IN065452 start-->
					<!--<input type='checkbox' name='pendingRef' id='pendingRef' value='Y' checked onclick='setCheckedOut(this)'></td>-->
				<%
					if(referralRegister){
				%>
						<input type='radio' name='pendingRef' id='pendingRef' value='Y' checked onclick='setCheckedRef(this)'>
						&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.MyReferrals.label" bundle="${ca_labels}"/>
						<input type='radio' name='pendingRef' id='pendingRef' value='R' onclick='setCheckedRef(this)' >
				<%
					}
					else{
				%>
						<input type='checkbox' name='pendingRef' id='pendingRef' value='Y' checked onclick='setCheckedOut(this)'>
				<%		
					}
				%>
					<td class='label' width='5%'>&nbsp;</td>
					<td class='label' width ='10%' style="text-align:right"><b><fmt:message key="Common.status.label" bundle="${common_labels}"/></b></td> 
					
					<td nowrap class ='fields' width ='35%'>
					<select name="RefStatus" id="RefStatus">
						<option value="O"><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%
						if(referralRegister)
						{
						%>
							<option value="C"><fmt:message key="eIP.SeenandClosed.label" bundle="${ip_labels}"/></option>
							<option value="N"><fmt:message key="eIP.NotSeenandClosed.label" bundle="${ip_labels}"/></option>
							<option value="S"><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
							<option value="X"><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
						<%
						}
						else
						{
						%>
							<option value="Z"><fmt:message key="Common.closed.label" bundle="${common_labels}"/></option>
						<%
						}
						%>
					</select>
					</td>
					<input type = 'hidden' name='open' id='open' value='Y'>
					<!--<td class ='fields' width ='30%'><fmt:message key="Common.closed.label" bundle="${common_labels}"/> 
					<input type='checkbox' name='closed' id='closed' value='N'  onclick='setCheckedOut(this)'>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.open.label" bundle="${common_labels}"/> 
					<input type='checkbox' name='open' id='open' value='Y'  checked onclick='setCheckedOut(this)'></td>--><!--Commented for IN064836-->
					<!--IN064836 ends-->
					</tr>
					<tr>
					<td  style='display:none'  class='label' colspan='2' width='50%'><b><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
					<input type='checkbox' name='groupByEpisode' id='groupByEpisode' value='Y'  onclick='checkboxChk(this)' ></input>&nbsp;&nbsp;
					<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
					<input type='checkbox' name='groupByLocn' id='groupByLocn' value='Y'  onclick='checkboxChk(this)'></input></td>
					
						<td  align='right' width='100%' colspan='5'>						
						<input type='button' class='button' name='search'  id='searchID' onclick="javascript:searchClick()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'>&nbsp;<input type='button' class='button' name='clear' id='clear' onclick="javascript:clearClick()"value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>

					</tr>
				</table>
				<!-- added by kishore kumar n on 28/01/2009  -->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
				<!--ends here -->
				<input type='hidden' value='<%=facilityId%>' name='facilityid' >
				<input type='hidden' value='<%=ca_practitioner_id%>' name='ca_practitioner_id'></input>
				<input type=hidden value='<%=locale%>' name='locale'>
				<input type="hidden" name="mode" id="mode" value="search">
				<input type='hidden' name='url' id='url' value=''>
				<input type="hidden" name="order_by" id="order_by" value="">
				<input type="hidden" name="re_order" id="re_order" value="">
				<input type="hidden" name="anchor_id" id="anchor_id" value="">
				<input type="hidden" name="function_id" id="function_id" value='<%=request.getParameter("function_id")%>'>
				<input type="hidden" name="establish_reln_req_yn" id="establish_reln_req_yn" value="<%=establishrelnreqyn%>">
				<input type="hidden" name="refRegSiteYN" id="refRegSiteYN" value="<%=refRegSiteYN%>">
				<!--IN065452 start-->
				<input type="hidden" name="self" id="self" value="<%=sel%>">
				<input type="hidden" name="speciality" id="speciality" value="<%=sel1%>">
				<input type="hidden" name="both" id="both" value="<%=sel2%>">
				<!--IN065452 ends-->
		</form>
		<script>
			document.PatCriteriaFrm.pendingRef.checked = true;
			document.PatCriteriaFrm.pendingRef.value = 'Y';
			document.PatCriteriaFrm.searchID.click();
		</script>
		<!--<script>
			if('<%=linkValue%>' != null && '<%=linkValue%>' != '')
			{
				if('<%=linkValue%>' == 'SP')
				{
					//document.PatCriteriaFrm.unAssigned.checked = true;
					document.PatCriteriaFrm.pendingRef.checked = true;
					document.PatCriteriaFrm.IncCriteria.value = 'Y';
					document.PatCriteriaFrm.pendingRef.value = 'Y';
				}
				document.PatCriteriaFrm.searchID.click();
			}
		</script>-->
	</body>
</html>

<%
}
catch(Exception e)
{
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}
%> 


