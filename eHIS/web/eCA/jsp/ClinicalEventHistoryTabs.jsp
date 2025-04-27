<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7
05/08/2020      IN072762    	chandrashekar                                   		MO-CRF-20101.11
22/08/2020      IN073751    	Chandrashekar                                   		MO-CRF-20101.11
27/08/2020      IN073816    	Chandrashekar                                   		MO-CRF-20101.11
03/09/2020      IN073884    	Chandrashekar                                   		MO-CRF-20101.11
26/11/2020	6450	SIVABAGYAM M   		26/11/2020		RAMESH G		MO-CRF-20101.10

---------------------------------------------------------------------------------------------------------------
*/ 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
	<title></title>
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCA/html/Tabs.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../../eCA/js/ClinicalEventHistoryNew.js'></script>
<script language='javascript' src='../../eCA/js/MedicationOrders.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

	

</script>
</head>
<%
	Properties p;
	session = request.getSession(false);
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection con = null;
	ArrayList eventHistArr = new ArrayList() ;
	String bean_id					= "NewClinicalEventHistBean" ;
	String bean_name				= "eCA.NewClinicalEventHistBean";
	int totalHistTypes=0; //Ramesh
	String fromDate="",toDate="";
	fromDate = request.getParameter("from_date")==null	?"":request.getParameter("from_date");
	toDate = request.getParameter("to_date")==null	?"":request.getParameter("to_date");
	String grphistory_type			= request.getParameter("grphistory_type")==null	?"LBIN":request.getParameter("grphistory_type");//IN069654
	String ql_ref			= request.getParameter("ql_ref")==null	?" ":request.getParameter("ql_ref");//IN069654
	String facility_id      = (String)session.getValue( "facility_id" ) ;
	String def_facility      =  request.getParameter("facility_id")==null	?" ":request.getParameter("facility_id");//IN069654
	String ql_tab				= request.getParameter("personal_view")==null	?"":request.getParameter("personal_view");//IN069654 starts
	if(ql_tab.equals(""))
		ql_tab="S";
	String ql_nlcyInd			= request.getParameter("normalcy_ind")==null ?"":request.getParameter("normalcy_ind");
	if(ql_nlcyInd.equals(""))
		ql_nlcyInd="I";
	String ql_abnrml			= request.getParameter("abnormal")==null	?"":request.getParameter("abnormal");
	String ql_viewBy			= request.getParameter("view_by")==null	?"":request.getParameter("view_by");
	if(ql_viewBy.equals(""))
		ql_viewBy="P";
	String ql_patClass			= request.getParameter("patient_class")==null	?"":request.getParameter("patient_class");
	String ql_evntGrp			= request.getParameter("event_group")==null	?"":request.getParameter("event_group");
	String ql_evntGrpDsc			= request.getParameter("event_groupDesc")==null	?"":request.getParameter("event_groupDesc");
	String ql_evntItm			= request.getParameter("event_Item")==null	?"":request.getParameter("event_Item");
	String ql_evntItmDsc			= request.getParameter("event_ItemDesc")==null	?"":request.getParameter("event_ItemDesc");
	String evntClss			= request.getParameter("event_class")==null	?"":request.getParameter("event_class");
	String date_Ordr		= request.getParameter("date_Ordr")==null	?"":request.getParameter("date_Ordr");
	String p_status		= request.getParameter("status")==null	?"":request.getParameter("status");//IN072762
	String all_sel ="",c_sel="",f_sel="",a_sel="",dc_sel ="",hd_sel ="",r_sel="",cn_sel="",pg_sel ="",po_sel="",pc_sel="",ps_sel ="";//IN072762 
	//adding start for  IN073751
	String patient_id	= request.getParameter("patient_id") ==null?"":request.getParameter("patient_id");
	String dt_from		= request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String dt_to		= request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String pat_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String encounter_id	    =	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String pract_id		=	request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
	String tab_click ="";//Adding end for IN073751
	
	if(p_status.equals(""))//IN072762
	    p_status  ="A";//IN072762
	if(date_Ordr.equals(""))
		date_Ordr="D"; 
	
	String view_Pnl="";
	String view_Ind="";
	//IN069654 ends
	if(grphistory_type.equals("MEDN")){//Adding start for MO-CRF-20101.11//IN072762
		if(ql_evntGrp.equals(""))
		    ql_evntGrp="D";
	}//Adding end for MO-CRF-20101.11//IN072762
	NewClinicalEventHistBean bean	= (NewClinicalEventHistBean)getBeanObject( bean_id, bean_name , request) ; 
try
{
	con = ConnectionManager.getConnection(request);	
	eventHistArr = bean.getHistRecType(con,locale);
%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='eventDetailsFrame' id='eventDetailsFrame'>
	<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'>
		<tr>
			<td  class="white" colspan="3" height="30px">
				<ul style=padding-left:0px; id="tablist" class="tablist" >
				<%for(int i=0;i<eventHistArr.size();i++) {
					String[] eventHistStr =(String[])eventHistArr.get(i);
					totalHistTypes++;
					if(grphistory_type.equals(eventHistStr[0])){
				%>
						<li class="tablistitem" title='<%=eventHistStr[1]%>'  style='display' width="100px"  >				
							<a class="tabClicked" id="histTab<%=i%>" value='<%=eventHistStr[1]%>' onclick="selHistType('<%=eventHistStr[0]%>',<%=i%>);" >
								<span class="tabSpanclicked" id="histTabSpan<%=i%>"><span class="tabtext1"><%=eventHistStr[1]%></span></span>
							</a>				
						</li>				
				<%			
					}else{
				%>
						<li class="tablistitem" title='<%=eventHistStr[1]%>'  style='display' width="100px"  >				
							<a class="tabA" id="histTab<%=i%>" value='<%=eventHistStr[1]%>' onclick="selHistType('<%=eventHistStr[0]%>',<%=i%>);" >
								<span class="tabAspan" id="histTabSpan<%=i%>"><span class="tabtext1"><%=eventHistStr[1]%></span></span>
							</a>				
						</li>
				<%		
					}
				}
				%>
				</ul>
			</td>
		</tr>
		<!-- <tr style='height:5px;' ><td class="white" colspan="2">&nbsp;</td></tr> -->
		<tr class="rowBackGround">
			<td width= "20%"  class="fields"><!-- changed 40 to 30 forMO-CRF-20101.11 -->
				<ul style=padding-left:0px; id="tablist" class="tablist" >
					<li class="tablistitem" title='Self'  style='display'  >				
						<a onclick="tab_clickAdd('self_tab')" value='<%if(ql_tab.equals("S")){%>Y<%}else{%>N<%}%>' class='<%if(ql_tab.equals("S")){%>tabClicked<%}else{%>tabA<%}%>' id="self_tab" >
							<span class='<%if(ql_tab.equals("S")){%>tabSpanclicked<%}else{%>tabAspan<%}%>' id="self_tabspan"><span class="tabtext">Self</span></span>
						</a>				
					</li>
					<li class="tablistitem" title='My Specialty'  style='display' >
						<a onclick="tab_clickAdd('my_tab')" value='<%if(ql_tab.equals("M")){%>Y<%}else{%>N<%}%>' class='<%if(ql_tab.equals("M")){%>tabClicked<%}else{%>tabA<%}%>' id="my_tab" >
							<span class='<%if(ql_tab.equals("M")){%>tabSpanclicked<%}else{%>tabAspan<%}%>' id="my_tabspan"><span class="tabtext">My Specialty</span></span>
						</a>
					</li>
					<li class="tablistitem" title='All'  style='display' >
						<a onclick="tab_clickAdd('all_tab')" value='<%if(ql_tab.equals("A")){%>Y<%}else{%>N<%}%>' class='<%if(ql_tab.equals("A")){%>tabClicked<%}else{%>tabA<%}%>' id="all_tab" >
							<span class='<%if(ql_tab.equals("A")){%>tabSpanclicked<%}else{%>tabAspan<%}%>' id="all_tabspan"><span class="tabtext">All</span></span>
						</a><!-- IN069654 endss -->
					</li>
				</ul>
			</td>
			<%
			String viewByLabDisplay="";
			String viewByCLNTDisplay="";
			String viewByOtherDisplay="";
			String viewByMEDNDisplay ="";//Added for MO-CRF-20101.11
			if("LBIN".equals(grphistory_type)){
				viewByLabDisplay="display";
				viewByCLNTDisplay="display:none";
				viewByOtherDisplay="display:none";
				viewByMEDNDisplay="display:none";//Added for MO-CRF-20101.11
			}
			else if("CLNT".equals(grphistory_type)||"RDIN".equals(grphistory_type)||"SUNT".equals(grphistory_type)||"MERP".equals(grphistory_type))//6450
				{
					viewByLabDisplay="display:none";
					viewByCLNTDisplay="display";
					viewByOtherDisplay="display:none";
					viewByMEDNDisplay="display:none";//Added for MO-CRF-20101.11
				}
			else if("MEDN".equals(grphistory_type))//Adding starting for MO-CRF-20101.11
				{
					viewByLabDisplay="display:none";
					viewByCLNTDisplay="display:none";
					viewByOtherDisplay="display:none";
					viewByMEDNDisplay="display";
				}//Adding end for MO-CRF-20101.11
			if(ql_viewBy.equals("P")) {
				view_Pnl="checked";
			}else{
				view_Ind="checked";
			}
//Adding start for //IN072762
			if(p_status.equals("*A"))
				all_sel ="selected";
			if(p_status.equals("C"))
				c_sel ="selected";
			if(p_status.equals("F"))
				f_sel ="selected";
			if(p_status.equals("A"))
				a_sel ="selected";
			if(p_status.equals("DC"))
				dc_sel ="selected";
			if(p_status.equals("HD"))
				hd_sel ="selected";
			if(p_status.equals("R"))
				r_sel ="selected";
			if(p_status.equals("CN"))
				cn_sel ="selected";
			if(p_status.equals("PG"))
				pg_sel ="selected";
			if(p_status.equals("PO"))
				po_sel ="selected";
			if(p_status.equals("PC"))
				pc_sel ="selected";
            if(p_status.equals("PS"))
				ps_sel ="selected";
//Adding end for //IN072762
			%>
			<td width= "60%" class="fields" id="ViewByLabID" style="<%=viewByLabDisplay%>">
				<fmt:message key="eCA.ViewBy.label" bundle="${ca_labels}"/>&nbsp;&nbsp; :&nbsp;&nbsp;<fmt:message key="Common.Panel.label" bundle="${common_labels}"/> <input type="radio" value="P" name="group_panel" id="group_panel" onClick="loadPanel(this)" <%=view_Pnl%>>&nbsp; &nbsp;&nbsp;<fmt:message key="Common.Individual.label" bundle="${common_labels}"/><input type="radio" value="A" onClick="loadPanel(this)" <%=view_Ind%> name="group_panel">
			</td>						
			<td width= "60%" class="fields" id="ViewByCLNTID" style="<%=viewByCLNTDisplay%>">				
				<input type="button" name="expand" id="expand" value="Expand" onClick="expendedSetOfNotes();"/>&nbsp;
				<input type="button" name="collapse" id="collapse" value="Collapse" onClick="collpesedAllNotes();"/>&nbsp;				
			</td>
			<td width= "80%" class="fields" id="ViewByMEDNID" style="<%=viewByMEDNDisplay%>"><!-- //IN072762 start -->
				<fmt:message key="Common.GenericName.label" bundle="${common_labels}"/>&nbsp;&nbsp; <input type="text" name="generic_name" id="generic_name"  onblur="searchGenericName()" maxlength="40" size="40" ><input type="button" class="button" value="?" name="generic_name_search" id="generic_name_search"  onclick="searchGenericName()">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="drug_name" id="drug_name"  onblur="searchDrugName()" maxlength="40" size="40"   value ='<%=ql_evntItmDsc%>'><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search"  onclick="searchDrugName()">&nbsp; &nbsp;&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp; &nbsp;&nbsp;<select name="status" id="status" onchange ="tab_clickAdd('<%=tab_click%>')">
						<option value="*A" <%=all_sel%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="C" <%=c_sel%>><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
						<option value="F" <%=f_sel%>><fmt:message key="ePH.FutureRx.label" bundle="${ph_labels}"/></option>
						<option value="A" <%=a_sel%>><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
						<option value="DC" <%=dc_sel%>><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
						<option value="HD" <%=hd_sel%>><fmt:message key="ePH.OnHold.label" bundle="${ph_labels}"/></option>
						<option value="R" <%=r_sel%>><fmt:message key="Common.returned.label" bundle="${common_labels}"/></option>
						<option value="CN" <%=cn_sel%>><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
						<option value="PG" <%=pg_sel%>><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
						<option value="PO" <%=po_sel%>><fmt:message key="Common.PendingAuthorization.label" bundle="${common_labels}"/></option>
						<option value="PC" <%=pc_sel%>><fmt:message key="Common.PendingConsent.label" bundle="${common_labels}"/></option>
						<option value="PS" <%=ps_sel%>><fmt:message key="ePH.PendingSplAprvl.label" bundle="${ph_labels}"/></option>
						</select>
			</td><!-- //IN072762 end -->
			<td width= "60%" class="fields" id="ViewByOtherID" style="<%=viewByOtherDisplay%>">&nbsp;</td>
			
		</tr>
	</table>
<input type='hidden' value="<%=grphistory_type%>" name="histSelected" /><!--IN069654 starts-->
<input type='hidden' value="self_tab" name="tabSelected" id="tabSelected" />
<input type='hidden' value="<%=ql_tab%>" name="ql_tab" id="ql_tab" />
<input type='hidden' value="<%=ql_ref%>" name="ql_ref" id="ql_ref" />
<input type='hidden' value="<%=ql_nlcyInd%>" name="ql_nlcyInd" id="ql_nlcyInd" />
<input type='hidden' value="<%=ql_abnrml%>" name="ql_abnrml" id="ql_abnrml" />
<input type='hidden' value="<%=ql_viewBy%>" name="ql_viewBy" id="ql_viewBy" />
<input type='hidden' value="<%=ql_patClass%>" name="ql_patClass" id="ql_patClass" />
<input type='hidden' value="<%=ql_evntGrp%>" name="ql_evntGrp" id="ql_evntGrp" />
<input type='hidden' value="<%=ql_evntGrpDsc%>" name="ql_evntGrpDsc" id="ql_evntGrpDsc" />
<input type='hidden' value="<%=ql_evntItm%>" name="ql_evntItm" id="ql_evntItm" />
<input type='hidden' value="<%=ql_evntItmDsc%>" name="ql_evntItmDsc" id="ql_evntItmDsc" />
<input type='hidden' value="<%=evntClss%>" name="evntClss" id="evntClss" />
<input type='hidden' value="<%=facility_id%>" name="facility_id" id="facility_id" />
<input type='hidden' value="<%=date_Ordr%>" name="date_Ordr" id="date_Ordr" /><!--IN069654 ends-->
<input type='hidden' value="<%=request.getQueryString()%>" name="queryString" id="queryString" />
<input type='hidden' value="<%=totalHistTypes%>" name="totalHistTypes" id="totalHistTypes" /> <!-- Ramesh -->
<input type='hidden' value="<%=locale%>" name="locale" id="locale" /> <!-- MO-CRF-20101.11 -->
<input type="hidden" name="generic_id" id="generic_id" value=""><!-- //IN072762 -->
<input type="hidden" name="drug_code" id="drug_code" value=""><!-- //IN072762 -->
<input type="hidden" name="tab_click" id="tab_click" value=""><!-- //IN073751 -->
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"><!-- //IN073751 -->
<input type="hidden" name="patient_class" id="patient_class" value="<%=pat_class%>"><!-- //IN073751 -->
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>"><!-- //IN073751 -->
<input type="hidden" name="from_date" id="from_date" value="<%=dt_from%>"><!-- //IN073751 -->
<input type="hidden" name="to_date" id="to_date" value="<%=dt_to%>"><!-- //IN073751 -->
<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>"><!-- //IN073751 -->
<input type="hidden" name="def_facility" id="def_facility" value="<%=def_facility%>"><!-- //IN073816 -->
<script>
populateDates();
</script>
</form>
</center>

</body>

<%}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</html>



