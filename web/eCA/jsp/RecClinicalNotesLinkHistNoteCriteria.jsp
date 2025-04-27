
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
	<%
	    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		/** added by kishore kumar n on 10/12/2008  */
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
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkHist.js'></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RecClinicalLinkHistNoteCriteriaForm' id='RecClinicalLinkHistNoteCriteriaForm'>

<%
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	PreparedStatement	pstmt2	=	null;
	ResultSet			rs		=	null;
	ResultSet			rs2		=	null;

	String	query_title			=	"";
	String	short_desc			=	"";
	String	to_date_time		=	"";
	String  note_group			=	"",		note_group_desc		=	"";
	String	query_group_details1 ="" ;
	String	patient_id			=	"";
	String	encounter_id		=	"";
	String	result_linked_rec_type="";
	String	dft_date			=	"";

	patient_id		=	(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	encounter_id	=	(request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
	

	
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

	manageEmailBean.clearBean();

	
	putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);
	
	result_linked_rec_type=(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
	
	
	try
	{
		con				=	ConnectionManager.getConnection(request);

		to_date_time		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		dft_date			= com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,7,"d");
	
		query_title	="SELECT CR_GET_DESC.CR_HIST_REC_TYPE(?,?,'2') SHORT_DESC FROM DUAL ";

		pstmt			=	con.prepareStatement(query_title);
		pstmt.setString(1,result_linked_rec_type);
		pstmt.setString(2,locale);
		rs				=	pstmt.executeQuery();

		if(rs.next())
			short_desc	=	rs.getString("SHORT_DESC");

		if(rs!=null){rs.close();rs=null;}
		if(pstmt!=null){pstmt.close();pstmt=null;}
	}
	
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}



%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
	<tr>
	<td class='columnheader'  colspan=6><b><%=short_desc%></b></td>
</tr>
	
	
	<tr>
		<td width='25%' class="LABEL" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td width='25%' class="fields" ><input type='text'  name='from_date_time' id='from_date_time' value="<%=dft_date%>" size='14' maxLength='16'  onBlur='chkToDate(this);doDateCheck1(this,to_date_time, "<%=to_date_time%>","DMYHM","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');"></td>
		<td width='25%' class="LABEL" ><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td width='25%'><input type='text'  name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'  onBlur='chkToDate(this);doDateCheck1(from_date_time,this, "<%=to_date_time%>","DMYHM","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');"></td>
	</tr>
	<tr>
		<td class="LABEL"  width='25%'><fmt:message key="eCA.Author.label" bundle="${ca_labels}"/></td>
		<td class="fields"  width='25%'><select name="author" id="author" >
		<option value='A'> <fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='S'><fmt:message key="Common.self.label" bundle="${common_labels}"/></option></td>
		<td width='25%' > </td> <td width='25%' > </td>
	</tr>
			
   	</table>
	<table  border=0 cellpadding=3 cellspacing=0 width='100%' style='display:none' id='moreCriteria'  bordercolor=white>
	<tr>
		 <td class="LABEL" width='25%'><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></td>
		 <td class="fields" width='25%'><select onChange="populatenotetype()" name="note_group" id="note_group" >
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- ----- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%
		try
		{
         //query_group_details1 = "SELECT NOTE_GROUP_DESC,NOTE_GROUP from ca_note_group ORDER BY NOTE_GROUP_DESC";
		 query_group_details1 = "SELECT NOTE_GROUP_DESC,NOTE_GROUP from ca_note_group_lang_vw where language_id = ? ORDER BY NOTE_GROUP_DESC";
		 pstmt2=con.prepareStatement(query_group_details1);
		 pstmt2.setString(1,locale);
		 rs2=pstmt2.executeQuery();
			while(rs2.next())
			{
				
				note_group		=	rs2.getString("NOTE_GROUP");
				note_group_desc	=	rs2.getString("NOTE_GROUP_DESC");
		%>
				
		<option value="<%=note_group%>"><%=note_group_desc%></option>
		<%
			}

		
			if(rs2!=null) rs2.close();
			if(pstmt2!=null) pstmt2.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
		
			 if(con != null) ConnectionManager.returnConnection(con,request);
		}
		%>
		</select>
		</td>
		<td class="LABEL" ><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select disabled=true onChange="populatesection()" name="note_type" id="note_type" >
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- ----- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		</select></td>
	</tr><tr >	
		<td class="LABEL" width='25%' ><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%'><select disabled=true name="section" id="section" >
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- ----- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		</select></td>
		<td class='label' width='25%' >&nbsp;</td> <td class='label' width='25%' >&nbsp;</td>  
		</tr>
</table>

	<table  border=0 cellpadding=3 cellspacing=0 width='100%' align='center' >	
	<tr>
	<td width='25%' class='label' ><fmt:message key="eCA.LimittoCurrentEncounter.label" bundle="${ca_labels}"/></td>
	<td width='25%' class='fields'><input type='checkbox'  name='current_encounter' id='current_encounter' checked value="Y"> </td>
	<td class="LABEL" width='25%' ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
	<td width='25%' class='fields'><select name="order_by1" id="order_by1" >
		<option value='D'><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option> </select></td>
    </tr>
	<tr>
	<td class="LABEL" width='25%' ><fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/></td>
	<td class="fields" width='25%'><select name="order_by2" id="order_by2" >
	<option value='AS'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
	<option value='DE'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option></select></td>
	<td width='50%' colspan = 2 align=right > 
	<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="showSearchLinkResult()">&nbsp;
	<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onClick="clearClick()">
	<input type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.morecriteria.label","common_labels")%> >>" name='more' id='more' onClick="makeVisible(this);"></input></td>
	</tr>
	</table>
	<!-- added by kishore kumar n on 10/12/2008  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->


<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="result_linked_rec_type" id="result_linked_rec_type" value="<%=result_linked_rec_type%>">
<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">

</form>
</center>
</body>
</html>

