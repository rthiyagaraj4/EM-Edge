
<%@page import="java.sql.*,  webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"> -->

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String imgUrl="";
	
	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	String styleMap = "";
	if(sStyle.equals("IeStyleBlue.css"))
	{
		styleMap = "Blue";
	}
	else if(sStyle.equals("IeStyleLime.css"))
	{
		styleMap = "Lime";
	}
	else if(sStyle.equals("IeStyleOrange.css"))
	{
		styleMap = "Orange";
	}
	else if(sStyle.equals("IeStyleVoilet.css"))
	{
		styleMap = "Violet";
	}
	else
	{
		styleMap = "";
	}
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	<style type='text/css'>
	
	img
	{
		border:0;
	}
	</style>
</head>
<body OnMouseDown='CodeArrest()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='RecClinicalNotesPrevNotesCriteriaForm' id='RecClinicalNotesPrevNotesCriteriaForm'>
<%
	Connection			con1		=	null;
	
	PreparedStatement	pstmt1	=	null;
	PreparedStatement	pstmt2	=	null;
	PreparedStatement	pstmt3	=	null;
	ResultSet			rs1		=	null;
	ResultSet			rs2		=	null;
	ResultSet			rs3		=	null;
	String	query_string		=	"";
	String	from_date_time		=	"",		to_date_time		=	"";
	String  sys_date_time="";
	String  note_type			=	"",		note_type_desc		=	"";
	String  note_group			=	"",		appl_task_id		=	"";
	String  note_group_desc		=	"";
	String parent_note_type="";
	String parent_note_group="";
	String pre_ql_ref=request.getParameter("pre_ql_ref")==null?"":request.getParameter("pre_ql_ref");
	String noteGroupSql="";
	
	if(!pre_ql_ref.equals("")){
	parent_note_type=(request.getParameter("parent_note_type")==null)	?	""	:	request.getParameter("parent_note_type");
	parent_note_group=(request.getParameter("parent_note_group")==null)	?	""	:	request.getParameter("parent_note_group");
	}
	
	
	StringBuffer query_header_details = new StringBuffer();
	String resp_id			=	(String)		session.getValue("responsibility_id");
	String patient_class	=	(request.getParameter("patient_class")==null)	?	""	:	request.getParameter("patient_class");
//	String categoryId          =   request.getParameter("categ_id")==null?"":request.getParameter("categ_id");
	appl_task_id          =   request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");
	String prev_notes_indicator = request.getParameter("prev_notes")==null?"N":request.getParameter("prev_notes");//IN043031

	//Added By DINESH T for CRF 789
	if(pre_ql_ref.equals(""))
	{
	from_date_time=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	to_date_time=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	}
	
	//IN043031 Starts
	if("Y".equals(prev_notes_indicator))
	{
		try
		{
			con1				=	ConnectionManager.getConnection();
			StringBuilder ca_note_param_qry = new  StringBuilder();
			String curr_date = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			ca_note_param_qry.append("SELECT VW_PREV_NOTE_DAYS FROM CA_NOTE_PARAM WHERE MODULE_ID=?");
			pstmt1		=	con1.prepareStatement(ca_note_param_qry.toString());
			pstmt1.setString(1, "CA");
			rs1=pstmt1.executeQuery();
			while(rs1.next())
			{
				from_date_time = com.ehis.util.DateUtils.minusDate(curr_date, "DMYHM", locale, rs1.getInt("VW_PREV_NOTE_DAYS"), "d");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			rs1.close();
			pstmt1.close();
			if(con1!=null) ConnectionManager.returnConnection(con1,request);
		}
		
	}
	//IN043031 Ends
	
	HashMap funcFilter=new HashMap();
	ArrayList per_from=new ArrayList();
	ArrayList per_to=new ArrayList();
	ArrayList status=new ArrayList();
	String statusValue="0";
	String note_grp_value="";
	String note_type_value="";
	String noteGrp_value="";
	String noteType_value="";
	ArrayList funcCriteria = new ArrayList();
	ArrayList note_grp=new ArrayList();
	ArrayList note_typ=new ArrayList();
	query_string	=	request.getQueryString();
	String	status_sel1="",status_sel2="",status_sel3="";
	try
	{	
		
		con1				=	ConnectionManager.getConnection(request);
		if(!pre_ql_ref.equals(""))
		{
		try
		{
			String defSql=
			"SELECT a.column_id,(SELECT column_desc FROM sm_quick_link_criteria WHERE column_id = a.column_id AND option_id = b.option_id) column_desc,a.value_type, a.actual_value, a.datetime_relative_ind,a.datetime_relative_val, a.datetime_relative_unit,a.relative_field_ref FROM sm_quick_link_defn a, sm_quick_link_list b  WHERE a.quick_link_ref = ? and b.quick_link_ref = a.quick_link_ref";
			pstmt1		=	con1.prepareStatement(defSql);
			pstmt1.setString(1,pre_ql_ref);
			rs1=pstmt1.executeQuery();
			
			funcFilter = new HashMap();
			while(rs1.next())
			{	
				funcCriteria = new ArrayList();
				funcCriteria.add(rs1.getString("column_desc")==null?"":rs1.getString("column_desc"));
				funcCriteria.add(rs1.getString("value_type")==null?"":rs1.getString("value_type"));
				funcCriteria.add(rs1.getString("actual_value")==null?"":rs1.getString("actual_value"));
				funcCriteria.add(rs1.getString("datetime_relative_ind")==null?"":rs1.getString("datetime_relative_ind"));
				funcCriteria.add(rs1.getString("datetime_relative_val")==null?"":rs1.getString("datetime_relative_val"));
				funcCriteria.add(rs1.getString("datetime_relative_unit")==null?"":rs1.getString("datetime_relative_unit"));
				funcCriteria.add(rs1.getString("relative_field_ref")==null?"":rs1.getString("relative_field_ref"));
				funcFilter.put(rs1.getString("column_id"), funcCriteria);
				
			}
		}
	catch(Exception e)
	{
	
	e.printStackTrace();
	}
	finally
	{
		rs1.close();
		pstmt1.close();
	}
		}
	
	
	if(!pre_ql_ref.equals(""))
	{
		per_from=(ArrayList)funcFilter.get("PERIOD_FROM");
		per_to=(ArrayList)funcFilter.get("PERIOD_TO");
		sys_date_time=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);


		//For defaulting from and to period Added By DINESH T
		if(per_from.get(1).toString().equals("R") && per_from.get(3).toString().equals("B") && per_from.get(6)	.toString().equals("SYSDATETIME")&& per_from.get(4).toString()!="")	
		{
		from_date_time=com.ehis.util.DateUtils.minusDate(sys_date_time,"DMYHM",locale,Integer.parseInt(per_from.get(4).toString()),per_from.get(5).toString());
		}
		else if(per_from.get(1).toString().equals("R") && per_from.get(3).toString().equals("A")&& per_from.get(6)	.toString().equals("SYSDATETIME")&& per_from.get(4).toString()!="")	
		{
		from_date_time=com.ehis.util.DateUtils.plusDate(sys_date_time,"DMYHM",locale,Integer.parseInt(per_from.get(4).toString()),per_from.get(5).toString());
		}
		else if(per_from.get(6)	.toString().equals("SYSDATETIME"))
			
		{
		from_date_time=sys_date_time;
		}
		else
		{
			from_date_time="";//sys_date_time;
		}

		if(per_to.get(1).toString().equals("R") && per_to.get(3).toString().equals("B") && per_to.get(6).toString().equals("SYSDATETIME")&& per_to.get(4).toString()!="")	
		{
		to_date_time=com.ehis.util.DateUtils.minusDate(sys_date_time,"DMYHM",locale,Integer.parseInt(per_to.get(4).toString()),per_to.get(5).toString());	
		}
		else if(per_to.get(1).toString().equals("R") && per_to.get(3).toString().equals("A")&&	per_to.get(6).toString().equals("SYSDATETIME")&& per_to.get(4).toString()!="")	
		{
		to_date_time=com.ehis.util.DateUtils.plusDate(sys_date_time,"DMYHM",locale,Integer.parseInt(per_to.get(4).toString()),per_to.get(5).toString());
		}
		else if(per_to.get(6).toString().equals("SYSDATETIME"))
			to_date_time=sys_date_time;
		else
		{			
		to_date_time="";//sys_date_time;
		}

		//For defaulting status Field  Added By DINESH T
		status=(ArrayList)funcFilter.get("STATUS");
		statusValue=(status.get(2).toString()==""?"0":status.get(2).toString());
		if(statusValue.equals("A"))
			statusValue="4";
		else if(statusValue.equals("M"))
			statusValue="5";
		if(status.get(2).toString().equals("A"))
		{status_sel1="selected";status_sel2="";status_sel3="";}
		else if(status.get(2).toString().equals("M"))
		{status_sel2="selected";status_sel1="";status_sel3="";}
		else
		{status_sel3="selected";status_sel1="";status_sel2="";}

		
	}
	
	
%>
 <table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
	<tr>
		<td class="LABEL"  width='25%'><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%' ><input type='text' name='from_date_time' id='from_date_time' value="<%=from_date_time%>" size='14' maxLength='16'  onBlur='return validateFromAndToDates(this,to_date_time, "DMYHM","<%=locale%>");'><button id="common_calendar" type="button" style="background: none; border: none; padding: 0; margin: 0; display: inline-block;" onclick="return showCalendarValidate('from_date_time');">
            <img src="../../eCommon/images/CommonCalendar.gif" alt="Calendar Icon" style="width: 100%; height: auto; display: block;">
        </button>
		<td class="LABEL"  width='25%'><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%'><input type='text' name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'  onBlur='return validateFromAndToDates(from_date_time,this,"DMYHM","<%=locale%>");'><button id="common_calendar" type="button" style="background: none; border: none; padding: 0; margin: 0; display: inline-block;" onclick="return showCalendarValidate('to_date_time');">
            <img src="../../eCommon/images/CommonCalendar.gif" alt="Calendar Icon" style="width: 100%; height: auto; display: block;">
        </button></td>
	</tr>
	<tr>	
		<td class="LABEL" width='25%' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%'><SELECT name="status" id="status">
		<option value='0' <%=status_sel3%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='4' <%=status_sel1%>><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></option>
		<option value='5' <%=status_sel2%>><fmt:message key="Common.Modified.label" bundle="${common_labels}"/></option>
		</SELECT></td>

		<td class="LABEL" width='25%' > <fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></td>
		<td class="fields" width='25%'><select name="note_group" id="note_group" id="note_group" onchange="populateNoteTypesForGroup(this,'<%=patient_class%>','Prev_Notes');">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%			
		//For defaulting NoteGroup Field  Added By DINESH T
		note_grp=new ArrayList();
		if(!pre_ql_ref.equals(""))
		{
			note_grp=(ArrayList)funcFilter.get("NOTE_GROUP");
			if(note_grp.get(1).toString().equals("A"))
			note_grp_value=note_grp.get(2).toString();
			if(note_grp.get(1).toString().equals("R") && note_grp.get(6).toString().equals("CURR_NOTE_GROUP"))
			note_grp_value=parent_note_group;			
		}
		try
		{
			noteGroupSql="Select note_group, note_group_desc from 	ca_note_group_lang_Vw where 	appl_task_id=?  and language_id = ?	order by 2";
			pstmt2		=	con1.prepareStatement(noteGroupSql);
			pstmt2.setString(1,appl_task_id);
			pstmt2.setString(2,locale);
			rs2			=	pstmt2.executeQuery();
			while(rs2.next())
			{
				note_group		=	rs2.getString("note_group");
				note_group_desc	=	rs2.getString("note_group_desc");
				
				String selectVal="";
				if(note_grp_value.equals(note_group))
				{
					selectVal="selected";
					noteGrp_value=note_grp_value;
				}
				else
					selectVal="";
		%>
				<option value="<%=note_group%>" <%=selectVal%>><%=note_group_desc%></option>
		<%
			}
			if(rs2!=null) rs2.close();
			if(pstmt2!=null) pstmt2.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			//if(con1!=null) ConnectionManager.returnConnection(con1,request);
		}
		%>
		</select></td>
		</tr>
		<tr>
		<td class="LABEL" width='25%'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%'><select name="note_type" id="note_type" >
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%
		try
		{
			//For defaulting NoteType Field  Added By DINESH T
			note_typ=new ArrayList();
			if(!pre_ql_ref.equals(""))
			{
				note_typ=(ArrayList)funcFilter.get("NOTE_TYPE");				
				if(note_typ.get(1).toString().equals("A"))
				note_type_value=note_typ.get(2).toString();
				if(note_typ.get(1).toString().equals("R") && note_typ.get(6).toString().equals("CURR_NOTE_TYPE"))
				note_type_value=parent_note_type;

			}
			query_header_details.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc from ca_note_type_for_resp a, sm_resp b,ca_note_type_lang_vw c  where b.resp_id = ?  and b.resp_id = a.resp_id and a.note_type = c.note_type and c.language_id = ?  and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN)='Y'  AND NOTE_GROUP_ID IN ( SELECT NOTE_GROUP FROM CA_NOTE_GROUP  WHERE APPL_TASK_ID=? ");
			if(!noteGrp_value.equals(""))
				query_header_details.append("and note_group=nvl(?,note_group) ");

			query_header_details.append(" ) order by note_type_desc");
			pstmt3		=	con1.prepareStatement(query_header_details.toString());
			pstmt3.setString(1,resp_id);
			pstmt3.setString(2, locale);
			pstmt3.setString(3,patient_class);
			pstmt3.setString(4,appl_task_id);
			if(!noteGrp_value.equals(""))
				pstmt3.setString(5,note_grp_value);

		/*	if(!categoryId.equals(""))
			{
				pstmt3.setString(4,categoryId);
			}*/
			rs3			=	pstmt3.executeQuery();
			while(rs3.next())
			{
				note_type		=	rs3.getString("note_type");
				note_type_desc	=	rs3.getString("note_type_desc");				
				String selectVal="";
				if(note_type_value.equals(note_type))
				{
					selectVal="selected";
					noteType_value=note_type;
				}
				else
					selectVal="";
		%>
				<option value="<%=note_type%>" <%=selectVal%>><%=note_type_desc%></option>
		<%
				
			}
			if(rs3!=null) rs3.close();
			if(pstmt3!=null) pstmt3.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			//if(con1!=null) ConnectionManager.returnConnection(con1,request);
		}
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{	
		funcFilter.clear();
		per_from.clear();
		per_to.clear();
		funcCriteria.clear();
		status.clear();
		note_typ.clear();
		note_grp.clear();
		if(con1!=null) ConnectionManager.returnConnection(con1,request);
	}
		%>
		</select></td>
			
	<td width='25%'></td>
	<td class="fields"  width='25%'> 
	<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="return showSearchData();"> &nbsp;
	&nbsp;<input type='button' name='back' id='back' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")%>' class='BUTTON'onClick="switchToNote();"></td>
	</tr>
	</table>
	
	<%if(!imgUrl.equals(""))
	{ 
	%>
		<img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%
	}
	
	%>
	
	<input type='hidden' name='locale' id='locale'	value='<%=locale%>'>
	<input type='hidden' name='operation_mode' id='operation_mode'	value=''>
	<input type='hidden' name='query_string' id='query_string'	value="<%=query_string%>">
	<input type='hidden' name='appl_task_id' id='appl_task_id'	value="<%=appl_task_id%>">
</form>
</center>
</body>
<script language='javascript'>
if(validateFromAndToDates(document.getElementById("from_date_time"),document.getElementById("to_date_time"),"DMYHM","<%=locale%>"))
{	
	parent.RecClinicalNotesPrevNotesSearchDetailFrame.location.href = "../../eCA/jsp/RecClinicalNotesPrevNotesSearchDetail.jsp?from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>&note_group=<%=noteGrp_value%>&note_type=<%=noteType_value%>&status=<%=statusValue%>&<%=query_string%> ";
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

