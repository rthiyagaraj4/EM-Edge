<!DOCTYPE html>
<!-- Created Against ML-MMOH-CRF-1208 [IN:068081] -->

<%@page import="java.sql.*,eCommon.Common.CommonBean,webbeans.eCommon.*,eOT.Common.OTRepository" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>
	<fmt:message key="eOT.Ot.Label" bundle="${ot_labels}"/>&nbsp;
	<fmt:message key="Common.notes.label" bundle="${common_labels}"/>
	<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
</title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" );
	String locale = (String) p.getProperty("LOCALE");
	String imgUrl="";
	if(sStyle.equals("IeStyle.css")){
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<script language='javascript' src='../../eOT/js/OTNotesSearch.js'></script>	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type='text/javascript' src='../../eCommon/js/dchk.js'></script> 
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='OTNotesSearchCriteriaForm' id='OTNotesSearchCriteriaForm'>
<%		
		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;
		String	fromDateTime		=	"";
		String	toDateTime			=	"";
		String	noteTypeCode		=	"";	
		String	noteTypeDesc		=	"";
		boolean  isModifyNote        =   false ; //Added Against ML-MMOH-CRF-1993
		StringBuffer sqlQueryBuffer = new StringBuffer();
		String doc_linked_note_yn	=	(request.getParameter("doc_linked_note_yn")==null)?"":request.getParameter("doc_linked_note_yn");
		String query_string		= request.getQueryString();
		String facilityid		= (String) session.getValue("facility_id");
		con		=	ConnectionManager.getConnection(request);
		
		try{		
			String sysdateSql="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') TODATE,TO_CHAR(SYSDATE-7,'DD/MM/YYYY') DFLTDATE FROM DUAL";
		
			pstmt = con.prepareStatement(sysdateSql);
			rs = pstmt.executeQuery();

			if(rs.next()){
				toDateTime		=	rs.getString(1);
				fromDateTime	=	rs.getString(2);
			}
		}catch(Exception e){
			System.err.println("OTNotesSearchCriteria.jsp, Exception1==="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
%>
<br/>
<br/>		
<br/>
<table border=0 cellspacing=0 cellpadding=0 width='90%'  align=center>
	<tr>
		<td width='25%' colspan='2'>&nbsp;</td>
		<td width='25%' colspan='2' >&nbsp;</td>
	</tr>
	<tr>
		<td class="label"  width='25%' ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%' nowrap>
			<input type='text' size=10 maxlength='10' name='fromDateTime' id='fromDateTime' value='<%=fromDateTime%>' onKeyPress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);isDateCheck(this);'>			
			<img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('fromDateTime');">
			
			<b>&nbsp;&nbsp;&nbsp;&nbsp;</b>
	
			<input type='text' size=10 maxlength='10' name='toDateTime' id='toDateTime' value='<%=toDateTime%>' onKeyPress="return checkForSpecCharsforID(event);" onblur="isValidDate(this);isDateCheck(this);">
			<img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendar('toDateTime');">
		</td>
	</tr>
	<tr>  <td> &nbsp; </td> </tr>
	<tr>
		<td class="label" width='25%' ><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%'>
			<select name="noteType" id="noteType" >
			<option value=""><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
		<%
		try{
			isModifyNote = CommonBean.isSiteSpecific(con,"OT","OT_MODIFY_NOTE");//Added against ML-MMOH-CRF-1993
			
			
			if(isModifyNote){	
				sqlQueryBuffer.append("SELECT a.NOTE_TYPE_DESC NOTE_TYPE_DESC, a.NOTE_TYPE NOTE_TYPE FROM     CA_NOTE_TYPE_LANG_VW a, ca_note_group b WHERE a.LANGUAGE_ID='"+locale+"' AND NVL(a.EFF_STATUS,'D')='E' AND a.note_group_id = b.note_group AND b.appl_task_id = 'OT_NOTES' ORDER BY 1");//Added against ML-MMOH-CRF-1993
			}else{
				sqlQueryBuffer.append("SELECT distinct S.NOTE_TYPE, NOTE_TYPE_DESC FROM OT_NOTE_TYPE_FOR_SPECIALTIES S, CA_NOTE_TYPE C WHERE LOCN_TYPE='30' AND S.NOTE_TYPE=C.NOTE_TYPE");
			}//Modified Against ML-MMOH-CRF-1993
				pstmt	=	con.prepareStatement(sqlQueryBuffer.toString());
				rs		=	pstmt.executeQuery();
				while(rs.next()){
					noteTypeCode = rs.getString("NOTE_TYPE");
					noteTypeDesc = rs.getString("NOTE_TYPE_DESC");				
			%>	
					<option value="<%=noteTypeCode%>"><%=noteTypeDesc%></option>
			<%
				}		
		}catch(Exception e){
			System.err.println("OTNotesSearchCriteria.jsp, Exception2==="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		%>
			</select>
		</td>		
	</tr>
	<tr>
		<td colspan='4' class="button" align='right' >
				<input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='BUTTON' onClick="return showSearchResults();">
		</td>		
	</tr>
</table>
	<%if(!imgUrl.equals("")){ %>
		 <img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
	<input type='hidden' name='query_string' id='query_string'	value="<%=query_string%>">
	<input type='hidden' name='doc_linked_note_yn' id='doc_linked_note_yn'	value="<%=doc_linked_note_yn%>">
	<input type='hidden' value='<%=facilityid%>' name='facilityid' ></input>
	<input type='hidden' value='<%=locale%>' name='locale'>	
</form>
</center>
</body>
</html>
<script language='javascript'>
	parent.OTNotesSearchResultFrame.location.href = "../../eOT/jsp/OTNotesSearchResult.jsp?<%=query_string%>&fromDateTime=<%=fromDateTime%>&toDateTime=<%=toDateTime%>";
</script>

