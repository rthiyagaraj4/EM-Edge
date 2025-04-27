<%
/*
Date		Edit History	Name				Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------------------------------
29/07/2024    64277		 Gomathi Sivakumar						Ramesh G		File created for  MMS-DM-CRF-0260-US005
30/08/2024    66232		 Gomathi Sivakumar						Ramesh G		CA-MMS-DM-CRF-0260-US005/02-Long Text-Chief Complaint Link Doc
-----------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkChief.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<body onScroll="scrollTitle()" onKeyDown="lockKey()"> 
<script language=javascript>     
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
</head>
<%
	
	String facility_id=(String) session.getValue("facility_id");
	String patient_id		=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id		=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String from_date_time	=	request.getParameter("from_date_time")==null?"":request.getParameter("from_date_time");
	String to_date_time		=	request.getParameter("to_date_time")==null?"":request.getParameter("to_date_time");
	String current_encounter		=	request.getParameter("current_encounter")==null?"":request.getParameter("current_encounter");
	String order_by1		=	request.getParameter("order_by1")==null?"":request.getParameter("order_by1");
	String order_by2		=	request.getParameter("order_by2")==null?"":request.getParameter("order_by2");
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	
	String classValue="gridData";
	String rowid			=	"";
	ArrayList  temp			=	new ArrayList();
	ArrayList  fields			=	new ArrayList();

	from_date_time			=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time			=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
			
	Connection con = null;
	ResultSet rs=null;
	ResultSet rs1=null;
	Statement stmt1 = null;
	PreparedStatement stmt=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rset=null;
	
	String complaintID = "";
	String complaint = "";
	String complaintDetails = "";
	String onsetDateTime = "";
	String remarks = "";
	
	String StrSql3="",StrSql4="",StrSql5 ="",row_id="", field_ref="", col_field = "";
	
	int col_width=0;
	int col_span=0;
	int i=0, j=0, k=0, l=0, m=0, p=0, z=0;
	int maxRecord =0;
	
   	try
	{
		con =  ConnectionManager.getConnection(request);	  
		
		String categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

		stmt = con.prepareStatement(categ_sec_qry);
		
		stmt.setString(1,sec_hdg_code);
		stmt.setString(2,result_linked_rec_type);
		stmt.setString(3,result_linked_rec_type);

		rset = stmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());

		}
		else
		{
			 if (rset != null) rset.close();
			 if (stmt != null) stmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			stmt = con.prepareStatement(categ_sec_qry);
			stmt.setString(1,result_linked_rec_type);
			stmt.setString(2,result_linked_rec_type);

			rset = stmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(stmt != null) stmt.close();

			}
		

		}
	%>
<form name="RecClinicalNotesLinkChiefResultForm" id="RecClinicalNotesLinkChiefResultForm">	
<div id='authorizeMode' style='position:absolute; visibility:hidden;overflow:overflow'></div>
<div id='divDataTitle' style='postion:relative'>
<table  id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr>
	<%
			out.println("<td width='75%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td>");
	%>
</tr>
</table>
</div>
<table width="100%" class='grid' name="resultTable" id="resultTable" id="resultTable">
	<tr>
		<td class='columnheadercenter' width="1%" ><div  id='head0'  class='myClass' nowrap width='3%'>&nbsp;&nbsp;<fmt:message key="Common.all.label" bundle="${common_labels}"/><input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></div></td>	
		<%
			if(fields.size()>0)
			{
				col_span = fields.size();
				col_width = 98/col_span;
			
				for(i=0;i<fields.size();++i)
				{
				
					 col_field = (String)fields.get(i);
					if(col_field.equals("COMPLAINT"))
					{
					%>

						<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
					<%
					}
					else if(col_field.equals("COMPLAINTDETAILS"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.ComplaintDetails.label" bundle="${ca_labels}"/></td>
					<%
					}
					else if(col_field.equals("REMARKS"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
					<%
					}
					else if(col_field.equals("ONSETDATETIME"))
					{
					%>
						<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.OnsetDatetime.label" bundle="${ca_labels}"/></td>
					<%
					}
				}	
			}
			else
	{
	%>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.ComplaintDetails.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.OnsetDatetime.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' style="font-size:10"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
		<%
	}
			%>
	</tr>
		<%
				int rowcolor=0;
				if(order_by1.equals("O"))
				{
				  StrSql3="a.onset_datetime";
				  StrSql5="a.complaint_id";
				}
				else if(order_by1.equals("C"))
				{
				   StrSql3="a.complaint_id";
				   StrSql5="a.onset_datetime";
				}

				if(order_by2.equals("AS"))
				  StrSql4="ASC";
				else if(order_by2.equals("DE"))
				   StrSql4="DESC";
		StringBuffer sql2 = new StringBuffer();		
		StringBuffer sqlcount = new StringBuffer();	
		
		sqlcount.append("select count(*) as total from ca_encntr_chief_complaint a where a.facility_id=? ");
		
		sql2.append("select a.rowid row_id, a.complaint_id, complaint_desc, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH24:MI') onset_datetime_str from ca_encntr_chief_complaint a where a.facility_id=? ");
		if(!from_date_time.equals("")){
			 sqlcount.append(" and a.onset_datetime  >=  to_date(?,'dd/mm/yyyy hh24:mi')");
			 sql2.append(" and a.onset_datetime  >=  to_date(?,'dd/mm/yyyy hh24:mi')");
		}
		if(!to_date_time.equals("")){
			sqlcount.append(" and a.onset_datetime  <=  to_date(?,'dd/mm/yyyy hh24:mi')");
			sql2.append(" and a.onset_datetime  <=  to_date(?,'dd/mm/yyyy hh24:mi')");
		}
		if(current_encounter.equals("Y")) //66232
		{
			sqlcount.append(" and a.encounter_id = ?");
			sql2.append(" and a.encounter_id = ?");
		}
		else
		{
			sqlcount.append(" and a.encounter_id in (select encounter_id from pr_encounter where patient_id = ?)");
			sql2.append(" and a.encounter_id in (select encounter_id from pr_encounter where patient_id = ?)");
		}
		
		sql2.append(" ORDER BY "+StrSql3+" "+StrSql4+", "+StrSql5+" ");
		
		int pstmtcount1 =1;
		pstmt1=con.prepareStatement(sqlcount.toString());
		pstmt1.setString(pstmtcount1++, facility_id);
		if(!from_date_time.equals(""))
			pstmt1.setString(pstmtcount1++, from_date_time);
		if(!to_date_time.equals(""))
			pstmt1.setString(pstmtcount1++, to_date_time);
		if(current_encounter.equals("Y")) //66232
			pstmt1.setString(pstmtcount1++, encounter_id);
		else
			pstmt1.setString(pstmtcount1++, patient_id);
		
		rs1=pstmt1.executeQuery();
		
		if(rs1!=null && rs1.next())
		{
			maxRecord=rs1.getInt("total");
		}
  
	  
		int pstmtcount =1;
		pstmt=con.prepareStatement(sql2.toString());
		pstmt.setString(pstmtcount++, locale);
		pstmt.setString(pstmtcount++, facility_id);
		if(!from_date_time.equals(""))
			pstmt.setString(pstmtcount++, from_date_time);
		if(!to_date_time.equals(""))
			pstmt.setString(pstmtcount++, to_date_time);
		if(current_encounter.equals("Y")) //66232
			pstmt.setString(pstmtcount++, encounter_id);
		else
			pstmt.setString(pstmtcount++, patient_id);
		
		rs=pstmt.executeQuery();
		
		if(rs !=null)
		{
			while(rs.next())
			  {
					 row_id=rs.getString("row_id");
					//row_id = row_id.replace('+','$');
					 j++;
					
					complaintID = rs.getString("complaint_id");
					complaint = rs.getString("complaint_desc");
					complaint = complaint.replace("\"", "'");
					if(complaint.length()>200){
						complaint=complaint.substring(0,200)+"...";
					}
					complaintDetails = rs.getString("complaint_text");
					remarks = rs.getString("remarks");
					remarks = remarks.replace("\"", "'");
					onsetDateTime = rs.getString("onset_datetime_str");
					
		String beankey="";		
		String checkstatus="";		
         
			for( m=0;m<Beannew.getSize();m+=2)
				{
					beankey=Beannew.getObject(m).toString();

  					if(row_id.equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					beankey="";
				}
				if(p == maxRecord)
					{
					%>
					<script>document.forms[0].ctrlChkBox.checked = true</script> 
					<%}
				
	 %>
			<tr>
			<td class="<%=classValue%>" align="center"><input type="checkbox" name="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>" <%=checkstatus%>><input type='hidden' name='checking_value<%=k%>' value="<%=row_id%>">
			  <input type='hidden' name='ret_value<%=k%>' value='<%=java.net.URLEncoder.encode(row_id,"UTF-8")%>~<%=java.net.URLEncoder.encode(complaintID,"UTF-8")%>|<%=java.net.URLEncoder.encode(complaint,"UTF-8")%>|<%=java.net.URLEncoder.encode(complaintDetails,"UTF-8")%>|<%=java.net.URLEncoder.encode(remarks,"UTF-8")%>|<%=java.net.URLEncoder.encode(onsetDateTime,"UTF-8")%>'>	
			
			<%
			if(fields.size()>0)
				{
					col_span = fields.size();
					
					for(int n=0;n<fields.size();++n)
					{
						
						col_field = (String)fields.get(n);

						if(col_field.equals("COMPLAINT"))
						{
						%>
						<td class="<%=classValue%>"><%=complaint%></td>

						<%
						}
						else if(col_field.equals("ONSETDATETIME"))
						{
						%>
						<td   class='<%=classValue%>'> <%=onsetDateTime%></td>
						<%
						}
						else if(col_field.equals("COMPLAINTDETAILS"))
						{
						%>
						 <td  class='<%=classValue%>' > <%=complaintDetails%> </td>
						 <%
							
						}
						else if(col_field.equals("REMARKS"))
						{
						%>
						 <td  class='<%=classValue%>' ><%=remarks%> </td>
						 <%
							
						}
				}// for loop	
				}	
			else
				{
				%>
				<td class="<%=classValue%>"><%=complaint%></td>
				<td class="<%=classValue%>"><%=complaintDetails%></td>
				<td class="<%=classValue%>"><%=onsetDateTime%></td>
				<td class="<%=classValue%>"><%=remarks%></td>
			<%
				}
			%>
			</tr>
			
			<input type='hidden' name='row_value<%=l%>' value='<%=k%>'>
					 
				<%	
					k++;
					rowcolor ++;
					l++;
					//maxRecord++;
			  }  			

			%>

			</table>
					
			
			<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' class='grid' width='auto' height='100%' align='center'>
			<tr><td width='100%' id='t'></td></tr>
		</table>
	</div><%
	}
		if(maxRecord==0)
		{
		%>
	  		<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				document.forms[0].ctrlChkBox.disabled = true;
			</script>
		<%
		}
	%>
	<input type="hidden" name="rowcolor" id="rowcolor" value="<%=rowcolor%>" >
 <%
     } catch(Exception e) {
			   e.printStackTrace();
		
         if (rs != null) rs.close();
         if (stmt1 != null) stmt1.close();
         if (pstmt != null) pstmt.close();
    } 
	finally
	{
	    if (rs != null) rs.close();
		if (stmt1 != null) stmt1.close();
		if (pstmt != null) pstmt.close();
		if (con != null) con.close();

	}
%>
</table>	
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="from_date_time" id="from_date_time" value="<%=from_date_time%>">
<input type="hidden" name="to_date_time" id="to_date_time" value="<%=to_date_time%>">
<input type="hidden" name="count" id="count" value="<%=j%>">
<input type="hidden" name="finalString" id="finalString" value="<%=temp%>">
<input type="hidden" name="chkcount" id="chkcount" value="<%=k%>">
<input type="hidden" name="sec_hdg_code" id="sec_hdg_code" value="<%=sec_hdg_code%>">
<input type="hidden" name="result_linked_rec_type" id="result_linked_rec_type" value="<%=result_linked_rec_type%>"> 
 </form>
</body>
</html>

