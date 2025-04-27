<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
?           100				?	         	?				?				created
02/06/2014	IN037701		Nijitha											SKR-CRF-0036
06/05/2018	IN67872		Dinesh T	06/05/2018	Ramesh G	GHL-CRF-0497.1
20/07/2018	IN067717		Ramesh G		20/07/2018							ML-MMOH-CRF-0898.1
07/08/2018	IN063818		Raja S		07/08/2018		Ramesh G		MMS-DM-CRF-0102.1
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<title>RecClinicalNotesSearchCriteria</title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		/** added by kishore kumar n on 03/11/2009  */
		String imgUrl="";

		if(sStyle.equals("IeStyle.css"))
		 {
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		 }
		 /** ends here*/
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RecClinicalNotesSearchCriteriaForm' id='RecClinicalNotesSearchCriteriaForm'>
<%
	
		
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	query_sys_date		=	"";
	String	query_string		=	"";
	String	from_date_time		=	"";
	String	to_date_time		=	"";
	String	note_type_new		=	"";	
	String   note_type			=	"";
	String	note_type_desc		=	"";
	String	note_group_new		=	"";
	String	note_group			=	"";	
	String	note_group_desc		=	"";
	String	inc_oth_unsign_nt	=	"";

	StringBuffer query_header_details = new StringBuffer();

	String patient_class				=	(request.getParameter("patient_class")==null)	?	""	:	request.getParameter("patient_class");
	String categoryId					=   request.getParameter("categ_id")==null?"":request.getParameter("categ_id");
	String appl_task_id					=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	String doc_linked_note_yn			=	(request.getParameter("doc_linked_note_yn")==null)?"":request.getParameter("doc_linked_note_yn");
	note_type							=	(request.getParameter("note_type")==null)?"":request.getParameter("note_type");
	note_group							=	(request.getParameter("note_group")==null)?"":request.getParameter("note_group");
	String patient_id					=	(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	String encounter_id					=	(request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
	String orderStatusCodeHdr					=	(request.getParameter("orderStatusCodeHdr")==null)?"N":request.getParameter("orderStatusCodeHdr"); //68801
	String facility_id					=	(String)	session.getValue("facility_id");
	String resp_id						=	(String)	session.getValue("responsibility_id");
	
	String relation_id					=	request.getParameter("relation_id");
	//IN037701 Starts
		String p_event_class_widget = request.getParameter("p_event_class_widget") == null ? "" : request.getParameter("p_event_class_widget");
	//IN037701 Ends
	//IN063818 starts
	boolean isModifyDescSS = false;
	String isModifyDescYN ="N";
	ArrayList<String> functionIds = new ArrayList<String>();
	functionIds.add("DIS_MODIFY_AS_UPDATE");
	String beanId					= "CAClinicalHistoryBean" ;
	String beanName				= "eCA.CAClinicalHistoryBean";
	CAClinicalHistoryBean bean1	= (CAClinicalHistoryBean)getBeanObject( beanId, beanName , request) ;
	bean1.setSiteSpecific(functionIds,"CA");
	isModifyDescSS = bean1.isSiteSpecific("DIS_MODIFY_AS_UPDATE");
	if(isModifyDescSS)
		isModifyDescYN ="Y";
	//IN063818 ends

	query_string = request.getQueryString();

	String facilityid		= (String) session.getValue("facility_id");
	try
	{
		con				=	ConnectionManager.getConnection(request);

		query_sys_date	=	" select to_char(sysdate-10,'dd/mm/yyyy hh24:mi') from_date_time, to_char(sysdate,'dd/mm/yyyy hh24:mi') to_date_time,nvl(GET_TASK_APPLICABILITY('INC_OTH_UNSIGN_NT',NULL,?,?,?,?,?),'X') inc_oth_unsign_nt from dual ";

		pstmt			=	con.prepareStatement(query_sys_date);
		
		pstmt.setString(1,resp_id);
		pstmt.setString(2,relation_id);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,encounter_id);
		pstmt.setString(5,patient_id);

		rs				=	pstmt.executeQuery();

		if(rs.next())
		{
		//	from_date_time		=	rs.getString("from_date_time");
		//	to_date_time		=	rs.getString("to_date_time");
			inc_oth_unsign_nt	=	rs.getString("inc_oth_unsign_nt");
		}

		
		to_date_time			=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		from_date_time			=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,10,"d");

//		from_date_time			=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM","en",locale);
//		to_date_time			=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM","en",locale);
	}
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);//COMMON-ICN-0181
               e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	}
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
	<tr>
		<td class="LABEL" width='25%' >
			<fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/>
		</td>
		<td class="fields" width='25%' >
			<select name="note_group" id="note_group" >
				<option value="">&nbsp;&nbsp;&nbsp;&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- ----- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%
		try
		{
			//String noteGroupSql="Select note_group, note_group_desc from ca_note_group where appl_task_id=? order by 2 ";
			String noteGroupSql="Select	note_group, note_group_desc from ca_note_group_lang_vw where appl_task_id=?  and language_id = ? order by 2";
			pstmt		=	con.prepareStatement(noteGroupSql);
			pstmt.setString(1,appl_task_id);
			pstmt.setString(2,locale);
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				note_group_new		=	rs.getString("note_group");
				note_group_desc	=	rs.getString("note_group_desc");

				if(note_group.equals(note_group_new))
				{
			%>
				<option value="<%=note_group_new%>" selected ><%=note_group_desc%></option>
			<%
				}
			else
				{
		%>
				<option value="<%=note_group_new%>"><%=note_group_desc%></option>
		<%
				}
			}

		
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{

		}
		%>
			</select>
		</td>
		<td class="LABEL" width='25%'>
			<fmt:message key="Common.NoteType.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width='25%'>
			<select name="note_type" id="note_type" >
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- ----- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%

		try
		{
			//query_header_details.append("Select note_type, replace(note_type_desc,'''','') note_type_desc  from ca_note_type_for_resp_view where resp_id = ? and privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN)='Y' AND NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) order by note_type_desc " );
			//query_header_details.append("Select a.note_type, replace(note_type_desc,'''','') note_type_desc  from ca_note_type_for_resp a,SM_RESP B, CA_NOTE_TYPE_LANG_VW C  WHERE B.RESP_ID=A.RESP_ID AND b.resp_id = ? and A.privilege_type != '5' AND C.NOTE_TYPE=A.NOTE_TYPE and c.language_id = ? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN)='Y' AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?) order by note_type_desc ");
			//IN037701 Starts
			//query_header_details.append("Select a.note_type, replace(note_type_desc,'''','') note_type_desc  from ca_note_type_for_resp a,SM_RESP B, CA_NOTE_TYPE_LANG_VW C  WHERE B.RESP_ID=A.RESP_ID AND b.resp_id = ? and A.privilege_type != '5' AND C.NOTE_TYPE=A.NOTE_TYPE and c.language_id = ? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN)='Y' AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  ");//Commented for IN067717
			query_header_details.append("Select a.note_type, replace(note_type_desc,'''','') note_type_desc  from ca_note_type_for_resp a,SM_RESP B, CA_NOTE_TYPE_LANG_VW C  WHERE B.RESP_ID=A.RESP_ID AND b.resp_id = ? and A.privilege_type != '5' AND C.NOTE_TYPE=A.NOTE_TYPE and c.language_id = ? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',patient_specific_yn)='Y' AND c.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  ");//IN067717
			if(!"".equals(p_event_class_widget))
			{
				query_header_details.append("AND C.EVENT_CLASS = ?");
			}
			query_header_details.append("order by note_type_desc");
			//IN037701 Ends
			pstmt		=	con.prepareStatement(query_header_details.toString());

			pstmt.setString(1,resp_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,patient_class);
			pstmt.setString(4,appl_task_id);

			if(!categoryId.equals(""))
			{
			     pstmt.setString(4,categoryId);
			}
			//IN037701 Starts
			if(!"".equals(p_event_class_widget))
			{
				pstmt.setString(5,p_event_class_widget);
			}
			//IN037701 Ends
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				note_type_new		=	rs.getString("note_type");
				note_type_desc	=	rs.getString("note_type_desc");
				if(note_type.equals(note_type_new))
				{
			%>
				<option value="<%=note_type_new%>" selected ><%=note_type_desc%></option>
			<%
				}
			else
				{
		%>
				<option value="<%=note_type_new%>"><%=note_type_desc%></option>
		<%
				}
			}
			
			}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		%>
			</select>
		</td>
		</tr>

		<tr>
        
	    <td class=label  width='25%'><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></td>
 	    <td class='fields' width='25%'>
        <input type='text' name="performed_by" id="performed_by" value=""  size='20' maxlength='20' 
	    onkeypress="" onBlur="checkRec(this)"  ><input type='button' class='button' value='?'  name='search_ref' id='search_ref' onClick="getServiceCode3()">
	    </td>

	    <td class=label width='25%'><fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/></td>
	    <td class='fields' width='25%'>
		<input type='text' name="med_anc" id="med_anc" value=""  size='20' maxlength='20' 
	    onkeypress="" onBlur="checkRec2(this)" ><input type='button' class='button' value='?'  name='search_ref2' id='search_ref2' onClick="getServiceCode4()">
	    </td>
	
    </tr> 

		<tr>
		<td class="LABEL"  width='25%' >
			<fmt:message key="Common.Period.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width='25%' nowrap>
			<input type='text' name='from_date_time' id='from_date_time' value="<%=from_date_time%>" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,to_date_time, "DMYHM","<%=locale%>")'><button id="common_calendar" type="button" style="background: none; border: none; padding: 0; margin: 0; display: inline-block;" onclick="return showCalendarValidate('from_date_time');">
            <img src="../../eCommon/images/CommonCalendar.gif" alt="Calendar Icon" style="width: 100%; height: auto; display: block;">
        </button>
			&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'  onBlur='CheckDateNew(this);checkPeriodFromTo(from_date_time,this,"DMYHM","<%=locale%>")'><button id="common_calendar" type="button" style="background: none; border: none; padding: 0; margin: 0; display: inline-block;" onclick="return showCalendarValidate('to_date_time');">
            <img src="../../eCommon/images/CommonCalendar.gif" alt="Calendar Icon" style="width: 100%; height: auto; display: block;">
        </button>
		</td>
	<!--</tr>
	<tr> -->	
		<td class="LABEL"  width='25%'>
			<fmt:message key="Common.status.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width='25%'>
			<SELECT name="status" id="status">
				<option value='0'> &nbsp;&nbsp;&nbsp;&nbsp;-<fmt:message key="Common.all.label" bundle="${common_labels}"/>--&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value='1'><fmt:message key="Common.InProgress.label" bundle="${common_labels}"/></option>
				<option value='2'><fmt:message key="Common.Transcribed.label" bundle="${common_labels}"/></option>
				<option value='3'><fmt:message key="Common.Unauthorized.label" bundle="${common_labels}"/></option>
				<option value='4'><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></option>
		<%if(isModifyDescYN.equals("Y")){%><!--IN063818 starts-->
				<option value='5'><fmt:message key="eCA.Updated.label" bundle="${ca_labels}"/></option>
		<%}else{%>
				<option value='5'><fmt:message key="Common.Modified.label" bundle="${common_labels}"/></option>
		<%}%>
				<option value='9'><fmt:message key="Common.InError.label" bundle="${common_labels}"/></option>
				<option value='8'><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option><!--IN67872-->
		</SELECT>
		</td>
		
      </tr>
	  <tr>
		
		
		<td class="LABEL" width='25%'>
			<fmt:message key="eCA.ShowNotes.label" bundle="${ca_labels}"/>
		</td>
		<td class="fields" width='25%'>
			<SELECT name="filter" id="filter">
				<option value='A'> &nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.all.label" bundle="${common_labels}"/>--&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value='R'><fmt:message key="eCA.AwaitingReview.label" bundle="${ca_labels}"/></option>
				<option value='S'><fmt:message key="eCA.AwaitingSign.label" bundle="${ca_labels}"/></option>
			</SELECT>
		</td> 

		<%
		if(!inc_oth_unsign_nt.equals("A")){
		%>
			<td class="label"><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/></td>
			<td class="fields"><input type="text" name="ref_no" id="ref_no" value="" width="" size="50" maxlength = '100' onkeyPress="if(event.keyCode == 39) return false;"></td></tr>
			<tr><td  colspan=4 width='' ALIGN ='RIGHT' class= 'button'><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick='return showSearchResults()'></td>
		<%
		}	
		%>
		
		<%
		if(inc_oth_unsign_nt.equals("A"))
		{
		%>
			<td class="LABEL" width='25%'><fmt:message key="eCA.IncudeOthersUnsignedNotes.label" bundle="${ca_labels}"/></td>
				<td class = 'fields'><input type='checkbox' name='other_unsigned' id='other_unsigned' value='N' onClick='changeUnsignedValue(this)'></td>
			</td> </tr>
			<tr><td class="label"><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/></td>
			<td colspan=2 class="fields">
				<input type="text" name="ref_no" id="ref_no" value="" width="30%" size="50" maxlength = '100' onkeyPress="if(event.keyCode == 39) return false;">
			</td>
			<td  colspan = 2 class = button align ='right' ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="return showSearchResults();"></td>
		
		<%
		}
		%>
    </tr>
	</table>
	<!-- added by kishore kumar n on 03/12/2009  -->
	<%if(!imgUrl.equals("")){ %>
		 <img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
	<!--ends here -->
	<input type='hidden' name='operation_mode' id='operation_mode'	value=''>
	<input type='hidden' name='query_string' id='query_string'	value="<%=query_string%>">
	<input type='hidden' name='doc_linked_note_yn' id='doc_linked_note_yn'	value="<%=doc_linked_note_yn%>">
	<input type='hidden' name='inc_oth_unsign_nt' id='inc_oth_unsign_nt'	value="<%=inc_oth_unsign_nt%>">
	<INPUT type='hidden' name='other_unsigned_yn' id='other_unsigned_yn' value=''>
	<input type='hidden' value='<%=facilityid%>' name='facilityid' ></input>
	<input type='hidden' value='<%=locale%>' name='locale'>
	<input type='hidden' value='' name='performed_by_code' id='performed_by_code' ></input>
	<input type='hidden' value='' name='med_anc_code' id='med_anc_code' ></input>
	<input type='hidden' value='<%=orderStatusCodeHdr%>' name='orderStatusCodeHdr' ></input>   <!-- 68801 -->
</form>
</center>
</body>
</html>
<script language='javascript'>
	if('<%=inc_oth_unsign_nt%>' != 'A')
		parent.notesSearchFrame.rows = '28%,*';
<%-- parent.RecClinicalNotesSrchResultFrame.location.href = "../../eCA/jsp/RecClinicalNotesSearchResult.jsp?<%=query_string%>&from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>";  includeInErrNoteCopyPreNoteYN   69004 --%>	
<%-- parent.RecClinicalNotesSrchResultFrame.location.href = "../../eCA/jsp/RecClinicalNotesSearchResult.jsp?<%=query_string%>&from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>&includeInErrNoteCopyPreNoteYN=<%=includeInErrNoteCopyPreNoteYN%>";    /* 68801 */
 --%>
parent.RecClinicalNotesSrchResultFrame.location.href = "../../eCA/jsp/RecClinicalNotesSearchResult.jsp?<%=query_string%>&from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>&orderStatusCodeHdr=<%=orderStatusCodeHdr%>";    /* 68801 */

</script>
		


