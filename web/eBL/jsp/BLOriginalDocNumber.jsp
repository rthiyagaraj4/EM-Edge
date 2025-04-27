<!DOCTYPE html>
<%@ page  import="eBL.*,eBL.Common.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*,org.apache.commons.codec.binary.Base64" 			contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

    <!--  By Vijay  -->
<!-- 
Sr No        Version          TFS/Incident        SCF/CRF            		    	Developer Name
--------------------------------------------------------------------------------------------------------
1			 V220801			34745		BL-Deposit Receipt/Refund-Encounter	    Mohanapriya
--------------------------------------------------------------------------------------------------------
-->
<html>

<title>Original Document Number</title>
<head>
<%!
private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}

private String qtydecimal(String input)
{
		CurrencyFormat cf1 = new CurrencyFormat();		
	input = cf1.formatCurrency(input,2);  
	return input;
}

%>

<% 
Connection con=null;
 ResultSet rs=null;
PreparedStatement pstmt=null;
String doc_date="";
String doc_type="";
String doc_num="";
String classval="";
String srNo="";
String rn="";
String rt="";
String se="";
String episode_type="";
String episode_id="";
String visit_id="";
String doc_amt="";
String oust_amt="";
String facility_id="";
String patient_id="";
String recpt_nature_code="";
String recpt_type_code="";
String recpt_desc="";
String deposit_type="";
String remarks="";
try{
	
	HttpSession httpSession = request.getSession(false);				
	con	=	ConnectionManager.getConnection(request);		
	 
	 facility_id = (String)httpSession.getValue("facility_id");
	 System.out.println("facility_id"+facility_id);
	episode_type=request.getParameter("episode_type");
	if(episode_type==null)	episode_type="";		
	 System.out.println("episode_type"+episode_type);
	episode_id = checkForNull(request.getParameter("episode_id"));	
	 System.out.println("episode_id"+episode_id);
	// System.out.println("encoded "+encoded);
	// patient_id= checkForNull(request.getParameter("patient_id"));//V220801	 
	 
	//V220801	 
	if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
		patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	}else{
		patient_id	= checkForNull(request.getParameter("patient_id"));
	}
	System.out.println("patient_id BLOriginalDocNumber.jsp-"+patient_id);
	 //V220801
	 recpt_nature_code=request.getParameter("recpt_nature_code");
	 visit_id=checkForNull(request.getParameter("visit_id"));
	 if(visit_id.equals("") || visit_id==null){
		 visit_id="0";
		 
	 }
	 
	
	
}
catch(Exception e)
{
	System.out.println("Exception in e"+e);
	e.printStackTrace();
	
}
%>


<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>



<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<script language='javascript' src='../js/BLDepositReceipt.js'></script>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language='javascript' src='../js/json2.js'></script>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>



	
	<script>
	function orgDocRedirect(index ,obj)
	{
//alert(obj.text);
	/*alert($('#row'+index+'_col2').text());
	alert($('#row'+index+'_col3').text());
	alert($('#row'+index+'_col4').text());*/
	
	var doc_type=$('#row'+index+'_col2').text();
	var doc_num=$('#row'+index+'_col3').text();
	var srno=$('#row'+index+'_col4').text();
	var outstamt=$('#row'+index+'_col12').text();
	var recpt_type_code=$('#recpt_type_code'+index).val();
	var recpt_desc=$('#recpt_desc'+index).val();
	var deposit_type=$('#deposit_type'+index).val();
	var remarks=$("#remarks"+index).val();
	
	var bookingRefNum = '';
	if(deposit_type == 'S'){
		$.ajax({
			type:"GET",
			url:"../jsp/BillReceiptAjax.jsp",
			data:'calledFrom=getBookRef&docType='+$.trim(doc_type)+'&docNum='+$.trim(doc_num),
			dataType:"text",
			async:false,
			success: function(data){
				bookingRefNum = $.trim(data);
			},
			 error: function(data){
				 alert(data.flag)
		      }
		});
	}
	
	
	//parent.window.returnValue=doc_type+","+doc_num+","+srno+","+outstamt+","+recpt_type_code+","+recpt_desc+","+deposit_type+","+remarks+","+bookingRefNum;
	//parent.window.close();
	
	let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = doc_type+","+doc_num+","+srno+","+outstamt+","+recpt_type_code+","+recpt_desc+","+deposit_type+","+remarks+","+bookingRefNum;
    
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
	
	}
	
	</script>
	
	
<style>
div.tableContainer {
	width: 100%;		/* table width will be 99% of this*/
	height: 160px; 	/* must be greater than tbody*/
	overflow: auto;
	margin: 0 auto;
}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
	}	
		TD.YELLOW 
		{			
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
		}
		
		.LocalYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			border: 1x;
			border-style: dashed;
			border-left-color: #D5E2E5;
			border-right-color: #D5E2E5;
			border-top-color: #D5E2E5;
			border-bottom-color: #D5E2E5; 
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
SPAN.LABEL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.LABEL1
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  /*TEXT-ALIGN: LEFT;*/
  TEXT-ALIGN: RIGHT;
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}

SPAN.SpanYellow
		{
			COLOR:#444444;
			BACKGROUND-COLOR: yellow ;
			FONT-SIZE: 8pt ;
			PADDING-LEFT:7px;
  			PADDING-RIGHT:7px
		}
	</style>

</head>
<body>
<Form name='orignaldocnumber' id='orignaldocnumber'  id='orignaldocnumber'>
<%
try{
String query= "";

if("".equals(patient_id)){
	query = "select  to_char(a.org_doc_date,'dd/mm/yyyy') org_doc_date,a.narration,a.org_doc_type_code,a.org_doc_num,a.org_doc_srno,a.recpt_nature_code,a.recpt_type_code, "+
			"(select long_desc from bl_receipt_type_lang_vw where receipt_type_code=a.RECPT_TYPE_CODE "+
			"and RECPT_NATURE_CODE=a.recpt_nature_code and LANGUAGE_ID = 'en') recept_desc , "+
					" (SELECT ip_adm_trf_dep_ind FROM bl_receipt_refund_hdr WHERE doc_type_code = a.org_doc_type_code AND doc_number =  a.org_doc_num "+
					" ) Deposit_type, "+
			"a.slmt_type_code,a.episode_type,a.episode_id,a.visit_id,a.doc_amt,a.doc_outst_amt "+
"from bl_patient_ledger a "+
"where a.doc_outst_amt != 0 and a.trx_type_code = '5' and a.operating_facility_id='"+facility_id+"' "+
"and a.recpt_nature_code='MI'  "+
"and a.patient_id is null "+
"order by a.org_doc_date desc";
}
else{
	query = " select to_char(a.org_doc_date,'dd/mm/yyyy') org_doc_date ,a.narration,a.org_doc_type_code,a.org_doc_num,a.org_doc_srno,a.recpt_nature_code,a.recpt_type_code, "+
" (select long_desc from bl_receipt_type_lang_vw where receipt_type_code=a.RECPT_TYPE_CODE "+
" and RECPT_NATURE_CODE=a.recpt_nature_code and LANGUAGE_ID = 'en') recept_desc , "+
" (SELECT ip_adm_trf_dep_ind FROM bl_receipt_refund_hdr WHERE doc_type_code = a.org_doc_type_code AND doc_number =  a.org_doc_num "+
" AND episode_id = '"+episode_id+"') Deposit_type, "+
" a.slmt_type_code,a.episode_type,a.episode_id,a.visit_id,a.doc_amt,a.doc_outst_amt "+
" from bl_patient_ledger a where a.doc_outst_amt != 0 and a.trx_type_code = '5' and a.operating_facility_id='"+facility_id+"' "+
" and a.patient_id='"+patient_id+"' and a.recpt_nature_code='"+recpt_nature_code+"' and a.episode_id='"+episode_id+"' and nvl(visit_id,0)=nvl(null,'"+visit_id+"') "+
" order by a.org_doc_date, a.org_doc_type_code, a.org_doc_num ";
}


/*" SELECT   a.org_doc_date, a.org_doc_type_code, a.org_doc_num, a.org_doc_srno, a.recpt_nature_code, a.recpt_type_code, "+
" (SELECT long_desc FROM bl_receipt_type_lang_vw WHERE receipt_type_code = a.recpt_type_code AND recpt_nature_code = a.recpt_nature_code "+
"  AND language_id = 'en') long_desc,(SELECT ip_adm_trf_dep_ind FROM bl_receipt_refund_hdr WHERE doc_type_code = a.org_doc_type_code "+
"  AND doc_number = 7871 AND episode_id = 10206054) Deposit_type, a.slmt_type_code, a.episode_type, a.episode_id, a.visit_id, "+
"  a.doc_amt, a.doc_outst_amt FROM bl_patient_ledger a WHERE a.doc_outst_amt != 0 AND a.trx_type_code = '5' "+
" AND a.operating_facility_id = 'QF' AND a.patient_id = '"+patient_id+"' AND a.recpt_nature_code = '"+recpt_nature_code+"' AND a.episode_id = '"+episode_id+"' "+
" AND NVL (visit_id, 0) = NVL (NULL, '"+visit_id+"') ORDER BY a.org_doc_date, a.org_doc_type_code, a.org_doc_num ";*/

System.out.println("query::"+query);

pstmt = con.prepareStatement(query);
rs= pstmt.executeQuery();





%>
<div id="tblContainer">
			<table border='' cellpadding='3' cellspacing='0'  id='tbl' width='100%'>	
			<thead>
		

			<tr>
								
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='11%'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>					
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.DocNum.label" bundle="${bl_labels}"/></td>	
				<td class='COLUMNHEADER' width='07%'><fmt:message key="eBL.SRNO.label" bundle="${bl_labels}"/></td>					
				<td class='COLUMNHEADER' width='06%'><fmt:message key="eBL.RN.label" bundle="${bl_labels}"/></td>	
				<td class='COLUMNHEADER' width='06%'><fmt:message key="Common.RT.label" bundle="${common_labels}"/></td>		
				<td class='COLUMNHEADER' width='06%'><fmt:message key="eBL.SE.label" bundle="${bl_labels}"/></td>	
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.episodeId.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='05%'><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.docamt.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='13%'><fmt:message key="eBL.oustamt.label" bundle="${bl_labels}"/></td>
				
							
				</tr>
				
	            </thead>
				<tbody>
				<% 
				int i=1;
				
					if(rs != null){
					
					while(rs.next()){
						System.out.println("while");
						classval = "label";
						doc_date=  checkForNull(rs.getString("org_doc_date"));
						doc_type=  checkForNull(rs.getString("org_doc_type_code"));
						doc_num=   checkForNull(rs.getString("org_doc_num"));
						srNo=	   checkForNull(rs.getString("org_doc_srno"));
						rn=	   	   checkForNull(rs.getString("recpt_nature_code"));
						rt=		   checkForNull(rs.getString("recpt_type_code"));
						se=		   checkForNull(rs.getString("slmt_type_code"));
						episode_type=checkForNull(rs.getString("episode_type"));
						//episode_id=checkForNull(rs.getString("episode_id"));
						//visit_id=checkForNull(rs.getString("visit_id"));
						recpt_desc=checkForNull(rs.getString("recept_desc"));
						recpt_type_code=checkForNull(rs.getString("recpt_type_code"));
						deposit_type=checkForNull(rs.getString("Deposit_type"));
						remarks=checkForNull(rs.getString("narration"));
						
						
						System.out.println("visit_id"+visit_id);
						/*if(visit_id==null || visit_id.equals(""))
						{
							visit_id=Integer.toString(0);
							System.out.println("if,visit_id"+visit_id);
						}*/
						//else
							//visit_id=Integer.parseInt(visit_id);
						System.out.println("visit_id"+visit_id);
						doc_amt=qtydecimal(checkForNull(rs.getString("doc_amt")));
						oust_amt=qtydecimal(checkForNull(rs.getString("doc_outst_amt")));
						
						
						
						
						%>
				<tr>
				
				<td nowrap id='row<%=i %>_col1' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='doc_date' name='doc_date'><%=doc_date%></span>
				</td>
				<td id='row<%=i %>_col2' class=<%=classval%> width="11%" >  
				
				<a href	class="LABEL" id='doc_type' name='doc_type' onClick='orgDocRedirect("<%=i%>",this);'><%=doc_type%></a> 
			<!--  	<span class="LABEL" id='doc_type' name='doc_type'></span>-->
				</td>
				<td id='row<%=i %>_col3' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='doc_num' name='doc_num'><%=doc_num%></span>
				</td>
				<td id='row<%=i %>_col4' class=<%=classval%> width="07%" >  
				<span class="LABEL" id='sr_no' name='sr_no'><%=srNo%></span>
				</td>
				<td id='row<%=i %>_col5' class=<%=classval%> width="06%" >  
				<span class="LABEL" id='rn' name='rn'><%=rn%></span>
				</td>
				<td id='row<%=i %>_col6' class=<%=classval%> width="06%" >  
				<span class="LABEL" id='rt' name='rt'><%=rt%></span>				
				</td>
				<td id='row<%=i %>_col7' class=<%=classval%> width="06%" >  
				<span class="LABEL" id='se' name='se'><%=se%></span>
				</td>
				<td id='row<%=i %>_col8' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='episode_type' name='episode_type'><%=episode_type%></span>
				</td>
				<td id='row<%=i %>_col9' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='episode_id' name='episode_id'><%=episode_id%></span>
				</td>
				<td id='row<%=i %>_col10' class=<%=classval%> width="05%" >  
				<span class="LABEL" id='visit_id' name='visit_id'><%=visit_id%></span>
				</td>
				<td nowrap="nowrap" id='row<%=i %>_col11' class=<%=classval%> width="10%" >  
				<span class="LABEL" id='doc_amt' name='doc_amt'><%=doc_amt%></span>
				</td>
				<td nowrap="nowrap" id='row<%=i %>_col12' class=<%=classval%> width="15%" >  
				<span class="LABEL" id='oust_amt' name='oust_amt'><%=oust_amt%></span>
				</td>
				
				</tr>
				<input type="hidden" name="recpt_type_code<%=i %>" id="recpt_type_code<%=i %>" value="<%=recpt_type_code%>">
				<input type="hidden" name="recpt_desc<%=i %>" id="recpt_desc<%=i %>" value="<%=recpt_desc%>">
				<input type="hidden" name="deposit_type<%=i %>" id="deposit_type<%=i %>" value="<%=deposit_type%>">
				<input type="hidden" name="remarks<%=i %>" id="remarks<%=i %>" value="<%=remarks%>">
				
				<%
				System.out.println("i value"+i);
				i++;
					}//while
					}//if
					
				%>
</tbody>
</table>
</div>
<%				
		}
		catch(Exception eX)
		{		
			System.out.println("Error1= "+eX);			
		}
		finally
		{
			if (rs != null)   rs.close();
			if (pstmt != null) pstmt.close();
			if(con!=null) 
			{
				ConnectionManager.returnConnection(con, request);
			}
		}
%>

</Form>
</body>
</html>

