<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
12/08/2015	  	IN0037679	   		Karthi	 								SRR20056-SCF-9534
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import=" eST.CondemnExpiredBatchesHeaderBean,java.util.ArrayList,java.util.HashMap"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 --><%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<%
	String mode;
	String trn_type;
	mode	= request.getParameter( "mode" ) ;	
	if(mode==null) {
		mode="1";
	}
	CondemnExpiredBatchesHeaderBean bean =  null;
	
	try{
		bean = (eST.CondemnExpiredBatchesHeaderBean) getBeanObject( "condemnExpiredBatchesHeaderBean","eST.CondemnExpiredBatchesHeaderBean",request);
	bean.setLanguageId(locale);
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}	

	trn_type	= "CEB";
	bean.setTrn_type(trn_type);
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
	bean.initialize();
	bean.setDefault_doc(bean.checkForNull(request.getParameter("default_doc"),trn_type));
	bean.initialize(trn_type);
	}
	bean.initDoc_type_code_List();
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode); 
%>

<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<!-- <script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/CondemnExpiredBatches.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script> <!--   added DateUtils.js  for SRR20056-SCF-9534 -->
	</head>

	<body>
	<table border=0 cellpadding=2 cellspacing=0  width='100%'>
		<tr>
			<td class=ITEMSELECT  >
				<span style="cursor:pointer;color:#FFFF99" onClick="ModifyDocDetails();">
					<b>
						<u>
							<fmt:message key="Common.Document.label" bundle="${common_labels}"/>
						</u>
					</b>
				</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				
				<b> 
					:
				</b>
			</td>
			<td class=ITEMSELECT>
				<span id="doc_type_desc">
					<b>
						<%=bean.getDoc_type_desc(bean.getDoc_type_code())%>
					</b>
				</span>	
				&nbsp; 
				<span id="comn_id">
					<b>
						<%=(bean.getCon_doc_no().equals(""))?"":"/"+bean.getCon_doc_no()%>
					</b>
				</span>
			</td>				
			<td class=ITEMSELECT >
				<b>
					<fmt:message key="Common.date.label" bundle="${common_labels}"/> :
				</b>				
			</td>
			<%
			String doc_date=(String)bean.getDoc_date();
			if(!locale.equals("en"))
			{
             doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
			}
			%>
			<td class=ITEMSELECT>
				<span id="adj_doc_date">
					<b>
						<%=doc_date%>
					</b>
				</span>				
			</td>
			<td class=ITEMSELECT  >
				<b>
					<fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/>:
				</b>				
			</td>
			<td class=ITEMSELECT>
				<span id="doc_ref_id">
					<b>
					<%if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))){ %>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<%}else{ %>
						 <%= bean.getDoc_ref() %>
						<%} %>
					</b>
				</span>							
			</td>
		</tr>
		<tr>
			<td class=ITEMSELECT >
				<b>
					<fmt:message key="eST.ReportExecutedBy.label" bundle="${st_labels}"/> :
				</b>
			</td>
			<td class=ITEMSELECT id="report_executed_by">
				<b>
					<%=bean.getLoginById()%>
				</b>
			</td>
			<td class=ITEMSELECT >
				<b>
					<!-- <fmt:message key="eST.TransferExecutedby.label" bundle="${st_labels}"/> : -->
					Condemn By :
				</b>
			</td>
			<td class=ITEMSELECT id="transfer_executed_by" name="transfer_executed_by">
				<b>
					<%=bean.getLoginById()%>
				</b>
			</td>

			<td class=ITEMSELECT>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td class=ITEMSELECT>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</td>

		</tr>
		<tr>
			<td class=ITEMSELECT >
				<b>
				</b>
			</td>			
			<td class=ITEMSELECT  colspan = 5>
				 <span id="adj_remarks"> 
					<b>
						 &nbsp; 
					</b>
				</span>				
			</td>
		</tr>

	</table>
	<input type="hidden" name="adj_doc_no" id="adj_doc_no" value="<%=bean.getDoc_no()%>">
	<input type="hidden" name="adj_doc_ref" id="adj_doc_ref" value="<%=bean.getDoc_ref()%>"> 
	<input type="hidden" name="adj_doc_type_code" id="adj_doc_type_code" value="<%=bean.getDoc_type_code()%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
	<!--//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 -->
     <input type="hidden" name="hdr_remarks" id="hdr_remarks" value="<%=bean.getAdj_remarks_Desc()%>">	
	<%
putObjectInBean("condemnExpiredBatchesHeaderBean",bean,request);
if (!bean.hasAllMandatoryValue()) {
%>
	<script language="JavaScript">
		ModifyDocDetails();
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<%
}
%>	</body>
</html>

