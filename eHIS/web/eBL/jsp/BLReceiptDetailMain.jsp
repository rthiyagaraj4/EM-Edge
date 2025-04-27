<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
	<HEAD>
  		<TITLE> <fmt:message key="eBL.Receipt_Detail.label" bundle="${bl_labels}"/> </TITLE> 
  		
  <%	
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";		
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
  	</HEAD>
<%!
 private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null; 
con	=	ConnectionManager.getConnection(request);
String doctype			= request.getParameter("doc_type_code")==null?"": request.getParameter("doc_type_code");
String docnum			= request.getParameter("doc_number")==null?"": request.getParameter("doc_number");
String strdoc_srno = "";
String strdoc_amt = "";
String strslmt_type_code = "";
String strcash_amt_given = "";
String strcash_amt_returned = "";
String strslmt_doc_ref_desc = "";
String strbank_code = "";
String strslmt_doc_remarks = "";
String strbank_branch = "";
String strcc_batch_no = "";
String strapproval_ref_no = "";	
String strcc_swapped_yn = "";
String strcc_sale_draft_no = "";
String strpayer_name = "";
String strnominee_name = "";
String strpost_month = "";
String strpost_year = "";
String strconsolidated_receipt_yn = "";

System.out.println("suganya-"+doctype);	
try
	{		
	System.out.println("suganya 2-"+doctype);
		pstmt = con.prepareStatement("SELECT rownum rnum,doc_srno, doc_amt, slmt_type_code, cash_amt_given, cash_amt_returned, slmt_doc_ref_desc,  bank_code, slmt_doc_remarks, bank_branch, cc_batch_no, approval_ref_no, cc_swapped_yn, cc_sale_draft_no, payer_name, nominee_name, post_month, post_year, consolidated_receipt_yn FROM bl_receipt_refund_dtl  WHERE doc_type_code BETWEEN NVL ('"+doctype+"', '!!!!!!' ) AND NVL ('"+doctype+"', '~~~~~~') AND doc_number BETWEEN NVL ("+docnum+", 0) AND NVL ("+docnum+", 99999999)");
		System.out.println("suganya 3-"+"SELECT rownum rnum,doc_srno, doc_amt, slmt_type_code, cash_amt_given, cash_amt_returned, slmt_doc_ref_desc,  bank_code, slmt_doc_remarks, bank_branch, cc_batch_no, approval_ref_no, cc_swapped_yn, cc_sale_draft_no, payer_name, nominee_name, post_month, post_year, consolidated_receipt_yn FROM bl_receipt_refund_dtl  WHERE doc_type_code BETWEEN NVL ('"+doctype+"', '!!!!!!' ) AND NVL ('"+doctype+"', '~~~~~~') AND doc_number BETWEEN NVL ("+docnum+", 0) AND NVL ("+docnum+", 99999999)");
		rs = pstmt.executeQuery();	
		System.out.println("suganya 4-"+doctype);
	%>
	<body>
		<div id="tableContainer">
		<tr style=" border: '1';" id='trProgress'>
		<table border='1' cellpadding='3' cellspacing='0'  id='tbl' width='100%' class='grid'  align='center' > 
		<thead>
		
		<tbody>		
		<tr>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.doc_srno.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.cash_amt_given.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.slmt_type_code.label" bundle="${bl_labels}"/></td>
		
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.doc_amt.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.cash_amt_returned.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.slmt_doc_ref_desc.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.bank_code.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.slmt_doc_remarks.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.bank_branch.label" bundle="${bl_labels}"/></td>
		</tr>
		<tr>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.cc_batch_no.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.approval_ref_no.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.cc_swapped_yn.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.cc_sale_draft_no.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.payer_name.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.nominee_name.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.post_month.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.post_year.label" bundle="${bl_labels}"/></td>
		<td class='COLUMNHEADER' width='16%'><fmt:message key="eBL.consolidated_receipt_yn.label" bundle="${bl_labels}"/></td>
		</tr>
		</thead>
		<%
		if ( rs != null){
			int rowNum = 0;
			String bgColor = "";
			while(rs.next()){			
				System.out.println("suganya 5-"+doctype);
				if(rowNum % 2 ==0){
					//bgColor = "#FF0000";//"#ffffff";
					System.err.println("Even");
				}
				else{
					//bgColor = "#C0C0C0";
					System.err.println("Odd");
				}
				//classval = "label";
				strdoc_srno=  checkForNull(rs.getString("doc_srno"));
				strdoc_amt= checkForNull(rs.getString("doc_amt"));
				strslmt_type_code = checkForNull(rs.getString("slmt_type_code"));
				strcash_amt_given = checkForNull(rs.getString("cash_amt_given"));
				strcash_amt_returned = checkForNull(rs.getString("cash_amt_returned"));
				strslmt_doc_ref_desc = checkForNull(rs.getString("slmt_doc_ref_desc"));
				strbank_code = checkForNull(rs.getString("bank_code"));
				strslmt_doc_remarks = checkForNull(rs.getString("slmt_doc_remarks"));
				strbank_branch = checkForNull(rs.getString("bank_branch"));
				strcc_batch_no = checkForNull(rs.getString("cc_batch_no"));
				strapproval_ref_no = checkForNull(rs.getString("approval_ref_no"));	
				strcc_swapped_yn = checkForNull(rs.getString("cc_swapped_yn"));
				strcc_sale_draft_no = checkForNull(rs.getString("cc_sale_draft_no"));
				strpayer_name = checkForNull(rs.getString("payer_name"));
				strnominee_name = checkForNull(rs.getString("nominee_name"));
				strpost_month = checkForNull(rs.getString("post_month"));
				strpost_year = checkForNull(rs.getString("post_year"));
				strconsolidated_receipt_yn = checkForNull(rs.getString("consolidated_receipt_yn"));
			//System.out.println("suganya 6-"+doctype);							

%>
		<tr style="background-color: <%=bgColor%>">
		<td  class ='LABEL' width="10%" ><span  name='strdoc_srno'><%=strdoc_srno%></span></td>
		<td class ='LABEL'  width="10%" ><span  name='strcash_amt_given'><%=strcash_amt_given%></span></td>		
				
		<td  class ='LABEL' width="10%" ><span  name='strslmt_type_code'><%=strslmt_type_code%></span></td>
		<td  class ='LABEL' width="10%" ><span  name='strdoc_amt'><%=strdoc_amt%></span></td>		
		<td  class ='LABEL' width="10%" ><span  name='strcash_amt_returned'><%=strcash_amt_returned%></span></td>		
		<td  class ='LABEL' width="10%" ><span  name='strslmt_doc_ref_desc'><%=strslmt_doc_ref_desc%></span></td>
		<td class ='LABEL'  width="10%" ><span  name='strbank_code'><%=strbank_code%></span></td>		
		<td class ='LABEL'  width="10%" ><span  name='strslmt_doc_remarks'><%=strslmt_doc_remarks%></span></td>		
		<td class ='LABEL'  width="10%" ><span  name='strbank_branch'><%=strbank_branch%></span></td>
		</tr>
		<tr style="background-color: <%=bgColor%>">
		<td  class ='LABEL' width="10%" ><span  name='strcc_batch_no'><%=strcc_batch_no%></span></td>	
		<td  class ='LABEL' width="10%" ><span  name='strapproval_ref_no'><%=strapproval_ref_no%></span></td>		
		<td  class ='LABEL' width="10%" ><span  name='strcc_swapped_yn'><%=strcc_swapped_yn%></span></td>
		<td  class ='LABEL' width="10%" ><span  name='strcc_sale_draft_no'><%=strcc_sale_draft_no%></span></td>	
		<td  class ='LABEL' width="10%" ><span  name='strpayer_name'><%=strpayer_name%></span></td>		
		<td class ='LABEL'  width="10%" ><span  name='strnominee_name'><%=strnominee_name%></span></td>
		<td class ='LABEL'  width="10%" ><span  name='strpost_month'><%=strpost_month%></span></td>		
		<td class ='LABEL'  width="10%" ><span  name='strpost_year'><%=strpost_year%></span></td>	
		<td class ='LABEL'  width="10%" ><span  name='strconsolidated_receipt_yn'><%=strconsolidated_receipt_yn%></span></td>
		</tr>
	<%
	rowNum++;
		}
			}		%>
			</tbody>	 
		</table>
		</div>
		</tr>
		
<br><br><br><br><br><br><br>
		<tr width="100%">
		<td width="50%" align="right"></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		<td width="50%"><input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick=" parent.parent.document.getElementById('dialog_tag').close();"></td>
		
		</tr>	
		
<%		
rs.close();
	} catch(Exception e ) {System.out.println("error");}
	finally {
		
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();
	}
%>
 
  	</div>
  	</body>
  </HTML>
  

