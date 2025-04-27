<!DOCTYPE html>
<%@ page import= "java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, webbeans.eCommon.RecordSet,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- <modifeid by Arvind @06-12-2008> -->

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../js/MultiRecSubSection.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	

</head>
<%
/* 		Section Contains all the Variables Used in the  Program */
	Connection con			= null;
	PreparedStatement pstmt = null;
	ResultSet rs			= null;

	String startString = request.getParameter("start") == null ? "0" : request.getParameter("start");
	String endString = request.getParameter("end") == null ? "7" : request.getParameter("end");
	String hiddenFieldRemoveRow = request.getParameter("hiddenFieldRemoveRow") == null ? "" : request.getParameter("hiddenFieldRemoveRow");
	int count = 0;
	int tempCount=0;
	int index = 0;
	int rwIdIndex = 0;
	int dupRwIdIndex = 0;
	int start = Integer.parseInt(startString);
	int end = Integer.parseInt(endString);
	StringBuffer result_query = new StringBuffer();
	String tempRowIds = request.getParameter("tempRowIds") == null ? "" : request.getParameter("tempRowIds");

	if(tempRowIds.indexOf("^") != -1)
	{
		for(int y=0;y<tempRowIds.length();y++)
			tempRowIds = tempRowIds.replace('^','+');
	}

	if(!tempRowIds.equals(""))
		tempRowIds = tempRowIds.substring(0,tempRowIds.length()-1);

	String sec_hdg_code="", sec_hdg_desc ="", valid ="",seq_num	="", section_code="";
	String  classValue="", tblrow_id="", select_yn_prop="";
	String  sec_hdr_meta_desc="";
	String search_text ="";
	String error_msg = "";
	String row_id = "";
	String loadFirst = "No";
	try
	{
			con = ConnectionManager.getConnection(request);
			loadFirst = request.getParameter("loadFirst") == null ? "" : request.getParameter("loadFirst");
			section_code = request.getParameter("section_code");

			search_text = 	 request.getParameter("searchtext");
			if(section_code == null || section_code.equals("null"))section_code="";
			if((search_text==null ) || search_text.equals(""))
			{
				search_text = "";
			}
			 result_query.append("select rowID row_id,sec_hdg_code,'N' valid, to_number(null ) child_seq_num, sec_hdg_desc, sec_hdr_meta_desc  from  ca_section_hdg where ");
			 if(!loadFirst.equals("Yes"))
			 {
				 result_query.append("rowId in("+tempRowIds);
				 result_query.append(" ) and ");
			 }
			 result_query.append("CONTENT_TYPE != 'S' and NVL(SELECTION_TYPE,'S') != 'M' and sec_hdg_code not in (select CHILD_SEC_HDG_CODE from ca_subsection_link where header_sec_hdg_code = ?) and upper(sec_hdg_desc) like upper(?) 	union  select  b.rowId row_id,a.CHILD_SEC_HDG_CODE   sec_hdg_code,'Y' valid , a.CHILD_SEQ_NUM  , b.sec_hdg_desc, sec_hdr_meta_desc from ca_subsection_link a, ca_section_hdg b where  ");
			 if(!loadFirst.equals("Yes"))
			 {
				 result_query.append("b.rowId in("+tempRowIds);
				 result_query.append(" ) and ");				 
			 }
			 result_query.append("b.sec_hdg_code = a.child_sec_hdg_code and  a.HEADER_SEC_HDG_CODE =?  and upper(sec_hdg_desc) like upper(?) order by sec_hdg_desc");
			pstmt = con.prepareStatement(result_query.toString());// Query to Fetch Values for already Entered Sequence Numbers AND OTHERS NULL ENTRIES FROM THE DATABASE


			pstmt.setString(1,section_code);
			pstmt.setString(2,search_text+"%");
			pstmt.setString(3,section_code);
			pstmt.setString(4,search_text+"%");
			rs=pstmt.executeQuery();
%>
<body  class='CONTENT 'OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
			
			while(rs.next())
			{
				count++;
			}

			if(count == 0)
			{
					/*
						IF NO RECORDS ARE FOUND .MESSAGE IS ALERTED FROM MESSAGE.JS
					*/
					error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
					out.println("<script>parent.DetailsFrameMiddle.document.forms[0].searchtext.value=''</script>");
					out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
			}
			else
			{
				rs=pstmt.executeQuery();
			}
%>
	<form name='MultiRecSubSectionDtlForm' id='MultiRecSubSectionDtlForm' method="post">
	<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>	
		<tr>
			<td class='white' width='95%'></td> 
			<td  align='right' width='5%' nowrap><a class='gridLink' style='visibility:hidden' id='prevRecs' href="javascript:prevNextRecs('prev')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a class='gridLink' id='nextRecs' href="javascript:prevNextRecs('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		</tr>
	</table>
	<table cellpadding='3' cellspacing='0' border='1' id='dataTitleTable' width='100%' align='center' >
		<tr>
		<td class='COLUMNHEADERCENTER' width='75%'><fmt:message key="eCA.SubSectionDescription.label" bundle="${ca_labels}"/></td>
		<td class='COLUMNHEADERCENTER'width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
	</table>
	<table class='grid' cellpadding='3' cellspacing='0' border='1'  width='100%' align='center' >	
	<%
			if(rs != null)
			{
				while(rs.next())
				{
					
					index++;
					classValue = ((index%2)==0 )? "QRYEVEN" : "QRYODD";
					row_id			=	rs.getString("row_id");
					sec_hdg_code			=	rs.getString("sec_hdg_code");
					sec_hdg_desc			=	rs.getString("sec_hdg_desc");
					valid					=	rs.getString("valid");
					seq_num					=	rs.getString("child_seq_num");
					sec_hdr_meta_desc		=   rs.getString("sec_hdr_meta_desc");
					if(sec_hdg_code == null || sec_hdg_code.equals("null"))sec_hdg_code="";
					if(sec_hdg_desc == null || sec_hdg_desc.equals("null"))sec_hdg_desc="";
					if(valid == null || valid.equals("null"))valid="";
					if(seq_num == null || seq_num.equals("null"))seq_num="";
					if(sec_hdr_meta_desc == null || sec_hdr_meta_desc.equals("null"))sec_hdr_meta_desc="";
					if(!sec_hdr_meta_desc.equals(""))
						sec_hdg_desc = sec_hdg_desc +"&nbsp;-&nbsp;"+ sec_hdr_meta_desc;
					if(valid.equalsIgnoreCase("Y") && !(hiddenFieldRemoveRow.equals(sec_hdg_code)))
					{
						select_yn_prop="checked";
					}
					else
					{
						select_yn_prop="";
					}
					tblrow_id ="tblrow_id"+index;
					if(loadFirst.equals("Yes"))
					{
	%>
	<script>
		parent.parent.rowIDArraySubSecMain[<%=rwIdIndex%>] = "<%=row_id%>";
	</script>
		<%
		}
			if(rwIdIndex < 7)
			{
		%>
		<tr  id='<%=tblrow_id%>'>
				 <td  width='0'   style  ="display:none"  ><%=((sec_hdg_code.equals(""))?"&nbsp;":sec_hdg_code)%></td><!-- TD TO DISPLAY SUB SECTION CODE -->
				<td class='gridData'   width='75%' align='left'><%=((sec_hdg_desc.equals(""))?"":sec_hdg_desc)%></td>    <!-- TD TO DISPLAY SUBSECTION DESCRIPTION -->
				<td class='gridData'   width='25%' align='center'>
					<input type='checkbox' name='select_yn<%=index%>' id='select_yn<%=index%>'   value='Y' onClick="stringConCatenate(<%=index%>,<%=tblrow_id%>)" <%=select_yn_prop%>>
			   </td> <!-- CHECKBOX TO DISPLAY WHICH ALL ENTRIES HAVE NON -ZERO SEQUENCE NUMBER -->
		</tr>	
<%		dupRwIdIndex++;
			}
			rwIdIndex++;
			}
			if(loadFirst.equals("Yes"))
			{
				tempCount = rwIdIndex;
			}
			else
			{
				tempCount = request.getParameter("totalCount") == null ? 0 : Integer.parseInt(request.getParameter("totalCount"));
			}
		}
	%>
		<input type ="hidden" name ="sequence" value="<%=index%>"><!-- HAS THE LENGTH OF NUMBER OF TD CREATED  -->
		<input type ="hidden" name ="from" value="<%=start%>">
		<input type ="hidden" name ="to" value="<%=end%>">
		<input type ="hidden" name ="sectionCode" value="<%=section_code%>">
		<input type ="hidden" name ="searchText" value="<%=search_text%>">
		<input type ="hidden" name ="rwIdIndex" value="<%=dupRwIdIndex%>">
		<input type ="hidden" name ="count" value="<%=tempCount%>">
		<input type ="hidden" name ="hiddenFieldRemoveRow" value="<%=hiddenFieldRemoveRow%>">
<%	
if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
	//	out.println("EXCEPTION IN MAIN BLOCK :"+e.toString());
		e.printStackTrace();
}
finally
{
		
		if(con !=null) ConnectionManager.returnConnection(con);
}
%>
		</table>	
	</form>
	<script>
		//alert(parent.parent.rowIDArraySubSecMain);
		if(<%=start%> == 0)
			document.getElementById("prevRecs").style.visibility = 'hidden';
		else
			document.getElementById("prevRecs").style.visibility = 'visible';
		
		if(<%=rwIdIndex%> < 7)
			document.getElementById("nextRecs").style.visibility = 'hidden';
		else
			document.getElementById("nextRecs").style.visibility = 'visible';
	</script>

</body>
</html>

