<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.util.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
<body   class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" OnScroll="scrollTitle()" >
	 <form name="MultiRecResultfrm" id="MultiRecResultfrm" method="post"  action ='MultiRecSubSectionList.jsp'>
	 <div id='divDataTitle' style='postion:relative'>
	 <table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='left'>	
			<tr align='left'><th class='columnHeadercenter' colspan='3'><fmt:message key="eCA.SelectedSubSections.label" bundle="${ca_labels}"/></th></tr>
			<tr align='left'><th class='columnHeadercenter' width='50%'><fmt:message key="eCA.SubSectionDescription.label" bundle="${ca_labels}"/></th>
			<th class='columnHeadercenter'width='15%'><fmt:message key="eCA.OrderSequenceNumber.label" bundle="${ca_labels}"/></th>
			<th class='columnHeadercenter' width='15%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th></tr>	
	</table>
	 </div>
	<table class='grid' align='center' border="1" width="100%" id='dataTable' >
<%
/*
		Section Contains all the Variables Used in the  Program
	*/
Connection con			= null;
PreparedStatement pstmt = null;
ResultSet rs			= null;
StringTokenizer tokenizeTilde = null;
StringTokenizer tokenizePipe = null;
int index = 0;
try
{
	String result_query="";
	String remove_value ="",add_value="",section="";
	String text_name = "";String  tdrow_id="";String hiddenSubSectionCode = "";
	String sec_hdg_code="", sec_hdg_desc ="", valid ="",seq_num	="", section_code="";
	String operation ="", classValue="";
	String  sec_hdr_meta_desc="";
	String search_text ="";
	String finalString = "";
	String val = "";
	String val1= "";
	String val2= "";
	String val3= "";
	
	con = ConnectionManager.getConnection(request);
	section_code = request.getParameter("section_code");
	operation = request.getParameter("operation");
	if(operation ==null || operation.equals(""))
	{
			operation= "";
	}
	/*
		this part of Program Deals when Function is Loaded
	*/
	if(!operation.equals("split")) 
	{
			if(section_code == null || section_code.equals(""))section_code="";
			pstmt = con.prepareStatement("delete from   ca_subsection_link  where HEADER_SEC_HDG_CODE =? and child_seq_num is null ");//Query to Delete Null Entries from table
			pstmt.setString(1,section_code);
			pstmt.executeUpdate();
			con.commit();
			result_query="select sec_hdg_code,'N' valid, to_number(null ) child_seq_num, sec_hdg_desc, sec_hdr_meta_desc  from  ca_section_hdg where CONTENT_TYPE != 'S' and sec_hdg_code not in (select CHILD_SEC_HDG_CODE from ca_subsection_link where header_sec_hdg_code = ?) and upper(sec_hdg_desc) like upper(?) 	union  select  a.CHILD_SEC_HDG_CODE   sec_hdg_code,'Y' valid , a.CHILD_SEQ_NUM  , b.sec_hdg_desc, sec_hdr_meta_desc from ca_subsection_link a, ca_section_hdg b where  b.sec_hdg_code = a.child_sec_hdg_code and  a.HEADER_SEC_HDG_CODE =?  and upper(sec_hdg_desc) like upper(?) order by child_seq_num";
			if(pstmt!=null)pstmt.close();
			pstmt = con.prepareStatement(result_query);// Query to Fetch Values for already Entered Sequence Numbers
			pstmt.setString(1,section_code);
			pstmt.setString(2,search_text+"%");
			pstmt.setString(3,section_code);
			pstmt.setString(4,search_text+"%");
			
			rs=pstmt.executeQuery();
			
%>
<%
		while (rs.next())
		{
						valid					=	rs.getString("valid");
						if(valid.equalsIgnoreCase("Y"))
						{
								index++;
								classValue = ((index%2)==0 )? "QRYEVEN" : "QRYODD";
								sec_hdg_code			=	rs.getString("sec_hdg_code");
								sec_hdg_desc			=	rs.getString("sec_hdg_desc");
								seq_num					=	rs.getString("child_seq_num");
								sec_hdr_meta_desc		=   rs.getString("sec_hdr_meta_desc");
								if(sec_hdg_code == null || sec_hdg_code.equals("null"))sec_hdg_code="";
								if(sec_hdg_desc == null || sec_hdg_desc.equals("null"))sec_hdg_desc="";
								if(valid == null || valid.equals("null"))valid="";
								if(seq_num == null || seq_num.equals("null"))seq_num="";
								if(sec_hdr_meta_desc == null || sec_hdr_meta_desc.equals("null"))sec_hdr_meta_desc="";
								if(!sec_hdr_meta_desc.equals(""))
									sec_hdg_desc = sec_hdg_desc +"&nbsp;-&nbsp;"+ sec_hdr_meta_desc;
								text_name= "seq_num"+ index;
								tdrow_id = "tdrow_id"  + index;
								hiddenSubSectionCode = "subSectionCode"+index;
		
%>

	<tr id ="tdrow_id<%=index%>">			
			<td width='50%' class='gridData'  ><%=sec_hdg_desc%></td><!-- Displays the Description -->
			<td width='15%' align ="center" class='gridData'  >
				<input type="text" name="<%=text_name%>" id="<%=text_name%>" value="<%=seq_num%>" size="6" maxlength="6" onKeyPress='return allowValidNumber(this,event,6,0);' OnBlur="checkSequence(this)"><!--Text Field to display the Sequence Number -->
			</td>
			<td width='15%' align="center" class='gridData'   >
				<input type="checkbox" name="select_yn<%=index%>" id="select_yn<%=index%>" value='Y' <%out.println("checked");%> OnClick ="removeRow(<%=index%>)">
			</td>
	</tr>
    <input type ='hidden' name='<%=hiddenSubSectionCode%>' id='<%=hiddenSubSectionCode%>' value='<%=sec_hdg_code%>'>	<!-- Hidden Variable for Storing Code for the Corresponding Description -->
	<%			}	
			}
	}
/*
	 This Part of Code is Used when Values are Posted from Different JSPs,Strings are Tokenized and are Displayed
*/
	else
	{
			out.println("<script>parent.parent.HeaderFrame.document.HeaderForm.finalString.value=''</script>");
			finalString =request.getParameter("finalString");
			remove_value =request.getParameter("remove_value");
			add_value =  request.getParameter("add_value");
			section = request.getParameter("section_code");
			if(section==null ||section.equals("")) section="";
			if(remove_value==null ||remove_value.equals("")) remove_value="";
			if(add_value==null ||add_value.equals("")) add_value="";
			if(finalString==null || finalString.equals(""))
			{
				finalString = "";
			}
			tokenizeTilde = new StringTokenizer(finalString,"~");
			index=0;
			while(tokenizeTilde.hasMoreTokens())
								{
									index++;
									classValue = ((index%2)==0 )? "QRYEVEN" : "QRYODD";
									val = tokenizeTilde.nextToken();
									tokenizePipe =  new StringTokenizer(val,"||");
									val1 =java.net.URLDecoder.decode(tokenizePipe.nextToken());
									val2 = tokenizePipe.nextToken();
									val3 = tokenizePipe.nextToken();
									if(val2.equalsIgnoreCase("null"))
									{
										val2="";
									}
									text_name= "seq_num"+ index;
									tdrow_id = "tdrow_id"  + index;
									hiddenSubSectionCode = "subSectionCode" + index;
%>
		<tr id ="<%=tdrow_id%>">
			<td width='50%' class='gridData'  ><%=val1%></td><!-- Displays the Description -->
			<td width='15%' align ="center" class='gridData'  >
					<input type="text" name="<%=text_name%>" id="<%=text_name%>" value="<%=val2%>" size="6" maxlength="6" onKeyPress="return allowValidNumber(this,event,6,0)" OnBlur="minOccur2(this);checkSequence(this);"><!--Text Field to display the Sequence Number -->
			</td>
			<td width='15%'  align ="center" class='gridData'  >
					<input type="checkbox" name="select_yn<%=index%>" id="select_yn<%=index%>" value='Y' <%out.println("checked");%> OnClick ="removeRow(<%=index%>)">
			</td>
	</tr>							
	<input type ='hidden' name='<%=hiddenSubSectionCode%>' id='<%=hiddenSubSectionCode%>' value='<%=val3%>'>	<!-- Hidden Variable for Storing Code for the Corresponding Description -->
	
<%	}
	}

%>

		<TR style=' display:none; visibility:hidden'>
				<td class='columnHeader'><fmt:message key="eCA.SubSectionDescription.label" bundle="${ca_labels}"/></td>
				<td class='columnHeader'><fmt:message key="eCA.OrderSequenceNumber.label" bundle="${ca_labels}"/></td >
				<td class='columnHeader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		</tr>
	</table>
	<input type ='hidden' name='finalString' id='finalString' value=''>     <!-- has the ConCatenated String to be Posted to Servlet File and also used for Posting ConCatenated String between JSP's -->
	<input type ='hidden' name='section_code' id='section_code' value=''>  <!-- Section Code  Value of the Main Section  -->
	<input type ='hidden' name='array_length' id='array_length' value='<%=index%>'> <!-- has the value of  number of Dynamic Created Text Boxes -->
	<input type ='hidden' name='remove_value' id='remove_value' value=''> <!-- Has the Code Value to remove Entry from the Selected List -->
	<input type ='hidden' name='operation' id='operation' value=''> <!-- a flag  value used for performing default and posted Value  -->
	<input type ='hidden' name='add_value' id='add_value' value=''><!-- Has the Code Value to adding Entry into the Selected List -->
	<input type ='hidden' name='select_value' id='select_value' value=''>
  
  <%
	 if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
  }
 catch(Exception e){
	//out.println("Exception in Main Block :"+e.toString());//COMMON-ICN-0181
	 e.printStackTrace();
 }
 finally
 {
	
	if(con !=null) ConnectionManager.returnConnection(con);
	
 }

 %> 
</form>
</body>
</html>



