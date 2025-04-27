<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	   
	</head>
	<title><fmt:message key="ePH.AllocatedtradeBatchdet.label" bundle="${ph_labels}"/></title>
	<body onMouseDown="" onKeyDown="lockKey()">
<%
Connection con			= null;  // Added for ML-MMOH-CRF-0468
try{	
       con				= ConnectionManager.getConnection(request);//added for ml-mmoh-crf-0468
         boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 
        String facility_id				= (String) session.getValue("facility_id");
        String patient_id				= request.getParameter("patient_id");
        String order_id					= request.getParameter("order_id") ;
		String order_line_no			= request.getParameter("order_line_no") ;
		String drug_code				= request.getParameter("drug_code");
		String alt_drug_yn				= request.getParameter("alt_drug_yn");
		String drug_name				= request.getParameter("drug_name");
		String alt_drug_code			="";
		
				HashMap	batch_data			=	new HashMap();// Added for ML-MMOH-CRF-0468
		String	bean_id					=	"DispMedicationAllStages" ;
	    String	bean_name				=	"ePH.DispMedicationAllStages";
	    DispMedicationAllStages bean	= (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
			
	 batch_data= (HashMap) bean.getbatchString(patient_id,order_id,order_line_no,drug_code);
	if(tpn_mf_label && batch_data.size()== 0){// if Added for ML-MMOH-CRF-0468
		  batch_data= (HashMap) bean.getDB_DrugDetailTpnStandard(order_id, order_line_no, drug_code);
	}
	   System.out.println("temp"+batch_data);
	   ArrayList temp=  new ArrayList();
	   ArrayList  trade_detail = null; //code added for ML-BRU-SCF-0883[IN040662]
	   String temp1="", alloc_qty="", trade_name="";
%>
		<form name="BlincludeexcludeForm" id="BlincludeexcludeForm" >
			<table cellpadding="0" cellspacing="0" width="100%"  border='1'>	
				<tr >
					<td class='COLUMNHEADER' width='45%'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width='15%'><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></td>
				</tr>	
<% 
				if(alt_drug_yn.equals("N")){
%>
					<tr>
						<td class="label" align="center"><label><b><%=drug_name%></b></label></td>
					    
<%
						for(int i=0;i<batch_data.size();i++){
							temp=(ArrayList)batch_data.get(order_id+order_line_no+drug_code);
							for(int j=0;j<temp.size();j=j+4){
								// below condition is added by sureshkumar T for the Inc:26328[SRR20056-SCF-6782]
								alloc_qty =(String)temp.get(j+2);
								int len= alloc_qty.length();
								if(len >0 && alloc_qty.indexOf(".")!=-1){
									temp1 = alloc_qty;
									int point= temp1.indexOf(".")+1;
									if(temp1.charAt(point)=='0')
									alloc_qty= alloc_qty.substring(0,point-1);
								}

								if(j>0){
%>						   
									<tr>
										<td class="label" align="center">&nbsp;</td>
<%
								}
								trade_name = "";//added for ML-BRU-SCF-0883[IN040662]	-Start
								trade_detail=  bean.getItemAndTradeName(drug_code,(temp.get(j+1)).toString() );	
								if(trade_detail!= null && trade_detail.size()>0)
									trade_name =trade_detail.get(0)==null?"":(String)trade_detail.get(0);//added for ML-BRU-SCF-0883[IN040662]	-End
%> 
								<td class="label" align="center"><%=trade_name%></td><!-- 'temp.get(j)' is replaced with trade_name for ML-BRU-SCF-0883[IN040662] -->
							   <!-- below alloc_qty is added instead of temp.get(j+2) sureshkumar T for the Inc:26328[SRR20056-SCF-6782] -->
								<td class="label" align="center"><%=temp.get(j+1)%></td>
								<td class="label" align="center"><%=alloc_qty%>&nbsp<%=bean.getUomDisplay(facility_id,(String)temp.get(j+3))%></td>
							</tr>
<% 
						}
					}
				}
				else{
					ArrayList multi_drugs		=(ArrayList)bean.getMultiDrugs(patient_id,order_id,order_line_no);
					for(int n=0; n<multi_drugs.size(); n+=5)	{
						alt_drug_code	=	(String)multi_drugs.get(n);
						temp			=	(ArrayList)batch_data.get(order_id+order_line_no+alt_drug_code);
%>
						<tr>
							<td class="label" align="center"><label><b><%=(String)multi_drugs.get(n+1)%></b></label></td>
<%
							for(int j=0;j<temp.size();j=j+4){  

								if(j>0){
%>
									<tr>
										<td class="label" align="center">&nbsp;</td>
<%									}
								trade_name = "";//added for ML-BRU-SCF-0883[IN040662]	-Start
								trade_detail=  bean.getItemAndTradeName(alt_drug_code,(temp.get(j+1)).toString() );
								if(trade_detail!= null && trade_detail.size()>0)
									trade_name = trade_detail.get(0)==null?"":(String)trade_detail.get(0);//added for ML-BRU-SCF-0883[IN040662]	-End
%>
								<td class="label" align="center"><%=trade_name%></td><!--'temp.get(j)' is replaced with trade_name for ML-BRU-SCF-0883[IN040662] -->
								<td class="label" align="center"><%=temp.get(j+1)%></td>								
								<td class="label" align="center"><%=temp.get(j+2)%>&nbsp<%=bean.getUomDisplay(facility_id,(String)temp.get(j+3))%></td>
							</tr> 
<%
						}
					}
				}
}
catch(Exception e){
	e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-0468 - start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-crf-0468 end
%>
			</table>
		</form>
	</body>
</html>

