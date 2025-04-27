<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
	    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/SpltyHomePageLinkRep.js'></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
	<script>
	function CheckForNumsAndColon(event){
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function CheckDateTime(objText)
{
	
	if(objText.value !='')
	{	
		if(!doDateTimeChk(objText))
		{
			alert(getMessage("INVALID_DATE_FMT","CA"));
			objText.select();
			return false
		}
		else
		{
			var dateArray=objText.value.split(" ");
			var timeArray=dateArray[0].split("/");
			if(parseInt(timeArray[2],10)==0)
			{
				alert(getMessage("INVALID_DATE_FMT","CA"));
				objText.select();
				return false
			}
		}
	}
}
	</script>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RecClinicalNotesLinkHistRepCriteriaForm' id='RecClinicalNotesLinkHistRepCriteriaForm'>
<%
	Connection			con		=	null;
	try
	{
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;

	String	to_date_time		=	"";
	String	query_title			=	"";
	String	short_desc12		=	"";
	String  event_group			=	"",		short_desc		=	"";
	String  event_class			=	"",		short_desc1		=	"";
	String  encounter_id		=	"";
	String query_class_details   =   "" ;  
	String query_group_details   =   "" ;  
	String dft_date   =   "" ;  
	
	
	String patient_id="";
	String hist_rec_type="";
		
	patient_id=(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	encounter_id=(request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
   	//out.println("<script>alert('patient_id result"+patient_id+"');</script>"); 
	hist_rec_type=(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
	String return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");	
    

	


	
	//out.println("<script>alert('id"+id+"')</script>");
	/*String function_id		=	(request.getParameter("function_id")==null)?"":request.getParameter("function_id");*/
	
	try
	{
		con				=	ConnectionManager.getConnection(request);

		to_date_time		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		dft_date			=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,7,"d");

		//query_title	="SELECT SHORT_DESC FROM CR_HIST_REC_TYPE WHERE HIST_REC_TYPE  =?";
		query_title	="SELECT CR_GET_DESC.CR_HIST_REC_TYPE(?,?,'2') SHORT_DESC FROM DUAL";
		
		try
		{
			pstmt			=	con.prepareStatement(query_title);
			pstmt.setString(1,hist_rec_type);
			pstmt.setString(2,locale);
			rs				=	pstmt.executeQuery();

			if(rs.next())
				short_desc12	=	rs.getString("SHORT_DESC");
		}
		catch (Exception e6)
		{
			//out.println("Exception@6 from cri page : "+e6);//common-icn-0181
			e6.printStackTrace();//COMMON-ICN-0181
		}

		if(rs!=null){rs.close();rs=null;}
		if(pstmt!=null){pstmt.close();pstmt=null;}
	}
	catch(Exception e)
	{
		//out.println("Exception@1 from cri page : "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	
%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
<tr>
	<td class='columnheader'  colspan=4><b><%=short_desc12%></b></td>
</tr>	
<tr>
		<td  width='25%' class="LABEL" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td  width='25%' class="fields"><input type='text'  name='from_date_time' id='from_date_time' value="<%=dft_date%>" size='14' maxLength='18' OnKeyPress="return CheckForNumsAndColon(event)" onBlur='CheckDateTime(this);doDateCheck1(this,to_date_time,"<%=to_date_time%>","DMYHM","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');"></td>
       	<td  width='25%' class="LABEL" ><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td  width='25%' class="fields"><input type='text'  name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16' onBlur='CheckDateTime(this);doDateCheck1(from_date_time,this,"<%=to_date_time%>","DMYHM","<%=locale%>");' OnKeyPress="return CheckForNumsAndColon(event)" ><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');"></td> 
</tr>
   	</table>
	<table  border=0 cellpadding=3 cellspacing=0 width='100%' style='display:none' id='moreCriteria'  bordercolor=white>
	<tr>
		<td  class='label'  width='25%'><fmt:message key="Common.Component.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='25%'><input type="text" name="comp_id" id="comp_id" size="15" maxlength="20"  value=""><input type='button' name='comp' id='comp' value='?'  class='button' onClick='getcomponent()'></td>
		<td  class='label'  width='25%'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
		<td  class='fields' width='25%'><input type='text'  name='comp_val' id='comp_val' value=""  size="15" maxlength="20"  ></td>
	</tr>	
	<tr>
	    <td class="LABEL" width='25%'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
		<td class='fields'width='25%'><select name="search_criteria" id="search_criteria" >
		<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
		<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
		<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></td>
	    <td class="LABEL"  width='25%'><fmt:message key="eCA.EventGroup.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%'><select name="event_group" id="event_group" >
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- ----- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%
		try
		{
			//query_group_details="select SHORT_DESC, EVENT_GROUP  from cr_clin_event_group where HIST_REC_TYPE=? ORDER BY  SHORT_DESC  ";
			query_group_details="select SHORT_DESC, EVENT_GROUP from CR_CLN_EVT_GRP_LANG_VW	where HIST_REC_TYPE=? AND LANGUAGE_ID = ? ORDER BY  SHORT_DESC ";
			pstmt		=	con.prepareStatement(query_group_details);
			pstmt.setString(1,hist_rec_type);
			pstmt.setString(2,locale);
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				event_group		=	rs.getString("EVENT_GROUP");
				short_desc	=	rs.getString("SHORT_DESC");
		%>
				<option value="<%=event_group%>"><%=short_desc%></option>
		<%
			}

		
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
                          e.printStackTrace();//COMMON-ICN-0181
		}

		%>
		</select>
		</td>
  </tr>
  <tr>
    	<td class="LABEL" width='25%' ><fmt:message key="Common.Class.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><select name="class1" id="class1" >
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;----- ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- ----- &nbsp;&nbsp;&nbsp;&nbsp;</option>
		<%try
		{
			//query_class_details="select SHORT_DESC, EVENT_CLASS  from cr_event_class where HIST_REC_TYPE=? ORDER BY  SHORT_DESC  ";
			query_class_details="select	SHORT_DESC,EVENT_CLASS from CR_EVENT_CLASS_LANG_VW where HIST_REC_TYPE=? and language_id = ? ORDER BY  SHORT_DESC ";
			pstmt		=	con.prepareStatement(query_class_details);
			pstmt.setString(1,hist_rec_type);
			pstmt.setString(2,locale);
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				event_class		=	rs.getString("EVENT_CLASS");
				short_desc1	=	rs.getString("SHORT_DESC");
		%>
				<option value="<%=event_class%>"><%=short_desc1%></option>
		<%
			}

		
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
                        e.printStackTrace();//COMMON-ICN-0181
		}

		%>
		</select></td>
		
		<td class="LABEL" width='25%' ><fmt:message key="Common.Abnormalonly.label" bundle="${common_labels}"/> </td>
		<td class='fields' width='25%'><input type='checkbox'  name='abnormal' id='abnormal' checked value="Y"> </td>
		</tr>
		
		
</table>

	<table  border=0 cellpadding=3 cellspacing=0 width='100%' align='center' >	
	<tr>
	<!-- <td>&nbsp;</td>
	<td colspan=2 width='15%'>&nbsp;</td> -->
	<td  class='label' width='25%' ><fmt:message key="eCA.LimittoCurrentEncounter.label" bundle="${ca_labels}"/></td>
	<td  class='fields' width='25%'><input type='checkbox'  name='current_encounter' id='current_encounter' checked value="Y"> </td>
<!--	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td> -->
	<td width='25%' class="LABEL" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><select name="order_by1" id="order_by1" >
		<option value='D'><fmt:message key="eCA.EventDate.label" bundle="${ca_labels}"/></option>
		<option value='N'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></option></td>
	<!--	<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td> -->
    </tr>
	<tr>
	<td class="LABEL" width='25%'><fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/></td>
	<td class="fields" width='25%'><select name="order_by2" id="order_by2" >
		<option value='AS'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
		<option value='DE'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option></td>
	   <!-- <td  colspan=2>&nbsp;</td>  -->
    <td width='25%' colspan=2 align=right > 
	<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="showSearchLinkResult1()">
	<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onClick="clearClick()">
	<input type="button" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.morecriteria.label","common_labels")+">>"%>" name='more' onClick="makeVisible(this);"></input></td>
    </tr>
	</table>



<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="module_id" id="module_id" value='<%=request.getParameter("module_id")%>'>
<input type="hidden" name="cycle_no" id="cycle_no" value='<%=request.getParameter("cycle_no")%>'>
<input type="hidden" name="keyRef" id="keyRef" value='<%=request.getParameter("keyRef")%>'>
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="hist_rec_type" id="hist_rec_type" value="<%=hist_rec_type%>">
<input type="hidden" name="comp_id_code" id="comp_id_code" value="">
<input type="hidden" name="selectitems" id="selectitems" value="">
<input type="hidden" name="remitems" id="remitems" value="">
<input type="hidden" name="return_format" id="return_format" value="<%=return_format%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</center>
</body>
</html>
<%
}
catch(Exception ee)
{
	//out.println("Error RecClinicalNotesLinkHistRepCriteria.jsp :"+ee.toString());//common-icn-0181
        ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}
%>

