<%
/*
Date		Edit History	Name				Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------------------------------
26/07/2024    64277		 Gomathi Sivakumar						Ramesh G		File created for MMS-DM-CRF-0260-US005
-----------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String imgUrl="";
		if(sStyle.equals("IeStyle.css"))
		{
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		}
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkChief.js'></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>	
	<script>
		function CheckForNumsAndColon(event)
		{
			var strCheck = '0123456789:';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code

			if(strCheck.indexOf(key) == -1) 
				return false;  // Not a valid key

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
<form name='RecClinicalNotesLinkChiefCompCriteriaForm' id='RecClinicalNotesLinkChiefCompCriteriaForm'>
<%
	Connection			con		=	null;
	try
	{
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;
		String	to_date_time		=	"";
		String	query_title			=	"";
		String	short_desc		=	"";
		String  encounter_id		=	""; 
		String dft_date   =   "" ;  	
		String	patient_id="";
		String	hist_rec_type="";
		String dispResLinkHYMLYN="";
		String  sec_hdg_code="";	patient_id=(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
		encounter_id=(request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
   		hist_rec_type=(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
		sec_hdg_code=(request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");
		String return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");	
		dispResLinkHYMLYN = (request.getParameter("dispResLinkHYMLYN")==null)?"":request.getParameter("dispResLinkHYMLYN");
		
		try
		{
			con				=	ConnectionManager.getConnection(request);
			to_date_time		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			dft_date			=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,14,"d");
			query_title	="SELECT CR_GET_DESC.CR_HIST_REC_TYPE(?,?,'2') SHORT_DESC FROM DUAL";
			
			try
			{
				pstmt			=	con.prepareStatement(query_title);
				pstmt.setString(1,hist_rec_type);
				pstmt.setString(2,locale);
				rs				=	pstmt.executeQuery();

				if(rs.next())
					short_desc	=	rs.getString("SHORT_DESC");
			}
			catch (Exception e6)
			{
				e6.printStackTrace();
			}

			if(rs!=null)
			{
				rs.close();rs=null;
			}
			
			if(pstmt!=null)
			{
				pstmt.close();pstmt=null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
	<tr>
		<td class='columnheader'  colspan=4><b><%=short_desc%></b></td>
	</tr>
	<tr>
		<td  width='25%' class="LABEL" >
			<fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/>
		</td>
		<td  width='25%' class="fields">
			<input type='text'  name='from_date_time' id='from_date_time' value="<%=dft_date%>" size='14' maxLength='18' OnKeyPress="return CheckForNumsAndColon(event)" onBlur='CheckDateTime(this);doDateCheck1(this,to_date_time,"<%=to_date_time%>","DMYHM","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');">
		</td>
       	<td  width='25%' class="LABEL" >
			<fmt:message key="Common.periodto.label" bundle="${common_labels}"/>
		</td>
		<td  width='25%' class="fields">
			<input type='text'  name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16' onBlur='CheckDateTime(this);doDateCheck1(from_date_time,this,"<%=to_date_time%>","DMYHM","<%=locale%>");' OnKeyPress="return CheckForNumsAndColon(event)" ><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');">
		</td> 
	</tr>
</table>
<table  border=0 cellpadding=3 cellspacing=0 width='100%' align='center' >	
	<tr>
	<td  class='label' width='25%' >
			<fmt:message key="eCA.LimittoCurrentEncounter.label" bundle="${ca_labels}"/>
		</td>
		<td  class='fields' width='25%'>
			<input type='checkbox'  name='current_encounter' id='current_encounter' checked value="Y">
		</td>
		<td width='25%' class="LABEL">
			<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='25%'>
			<select name="order_by1" id="order_by1" >
				<option value='O'><fmt:message key="eCA.OnsetDatetime.label" bundle="${ca_labels}"/></option>
				<option value='C'><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></option>
			</select>
		</td>
			
	 </tr>
	 <tr>
		<td class="LABEL" width='25%'>
			<fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width='25%'>
			<select name="order_by2" id="order_by2" >
				<option value='AS'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
				<option value='DE'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td width='25%' colspan=2 align=right > 
			<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="showSearchLinkResult()">
			<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onClick="clearClick()">
		</td>
    </tr>
</table>
<%
	if(!imgUrl.equals(""))
	{ 
%>
		<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%
	}
%>
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="hist_rec_type" id="hist_rec_type" value="<%=hist_rec_type%>">
<input type="hidden" name="return_format" id="return_format" value="<%=return_format%>">
<input type="hidden" name="return_format_HTML" id="return_format_HTML" value="<%=return_format%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="sec_hdg_code" id="sec_hdg_code" value="<%=sec_hdg_code%>">
<input type="hidden" name="dispResLinkHYMLYN" id="dispResLinkHYMLYN" value="<%=dispResLinkHYMLYN%>">
<%
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	finally
	{
		if(con != null)
			ConnectionManager.returnConnection(con);
	}
%>
<script>
	showSearchLinkResult();
</script>
</form>
</center>
</body>
</html>

