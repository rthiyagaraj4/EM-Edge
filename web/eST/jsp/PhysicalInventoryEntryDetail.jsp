<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
20/02/2017		IN0063027		Badmavathi B					GHL-CRF-0413.7 - US005 - Barcode search
21/08/2023	    51322    		Raja Hanumanth					Ramesh G		Item Code		
---------------------------------------------------------------------------------------------------------------
*/
%>
 <%@page  import=" eST.PhysicalInventoryEntryBean,eST.Common.*,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
<%
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	int i							=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	//String avail_qty				=		"";
	//String item_code				=		"";
	String phy_inv_id				=		(String)request.getParameter("phy_inv_id");
	ArrayList alDetailData			=		new ArrayList();
	mode							=		request.getParameter( "mode" ) ;
	if(mode==null)	mode			=		"1";
	function_id						=		request.getParameter( "function_id" ) ;
	bean_id							=		"PhysicalInventoryEntryBean" ;
	bean_name						=		"eST.PhysicalInventoryEntryBean";										
	//HashMap expdtl				=		new HashMap();

	PhysicalInventoryEntryBean bean =		(PhysicalInventoryEntryBean)getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);

	alDetailData					=		bean.getDtlRecords();
	boolean site = bean.isSite_spec_yn();//Added for GHL-CRF-0413.7
	%>	
	</head>
<body>
<form name='formPhysicalInventoryEntryDetail' id='formPhysicalInventoryEntryDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
	<th width ='3%'><fmt:message key="eST.S.label" bundle="${st_labels}"/> </th>
	<th width ='50%' colspan="2"><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>
	<%
		HashMap ht					=		null;
		String classValue			=		"";
		 String     severity		 =   "";
		for(i=0;i<alDetailData.size();i++){ 
			ht						=		(HashMap)alDetailData.get(i);
			if(i%2==0) classValue	=		"QRYEVEN";
			else	   classValue	=		"QRYODD"; 
		      if ((((String)ht.get("STA_CHK")).equalsIgnoreCase("NU")) && ((Integer.parseInt((String)(ht.get("COUNT"))))==0)) {
					severity		=	"RED";
					}
		     else if ((((String)ht.get("STA_CHK")).equalsIgnoreCase("N")) && ((Integer.parseInt((String)(ht.get("SUM_QTY"))))!=0)) {//Added SUM_QTY against MMS-DM-SCF-0364 by Badmavathi B
						severity		=	"ORANGE";
						}
			 else if( (((String)ht.get("STA_CHK")).equalsIgnoreCase("Y")) && ((Integer.parseInt((String)(ht.get("SUM_QTY"))))!=0)) {//Added SUM_QTY against MMS-DM-SCF-0364 by Badmavathi B
								severity		=	"GREEN";
						}else
			{
			severity		=	"";
			}

							
		%>
			<tr id="tr_<%=i%>" name="tr_<%=i%>"><!-- Added name for GHL-CRF-0413.7-->
                 <td  bgcolor='<%=severity%>'></td>
				<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
				<font size=1><a name="a_<%=i%>" href="javascript:modifyData(<%=i%>);">
						&nbsp;&nbsp;&nbsp;<%=ht.get("ITEM_CODE")%>_<%=ht.get("ITEM_DESC")%>
					</a></font>
				</td>
			  </tr>	
				
				<%--
					<tr id="tr_<%=i%>" name="tr_<%=i%>"><!-- Added name for GHL-CRF-0413.7-->
					<td  bgcolor='<%=severity%>'></td>
					<td class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
						<font size=1><a name="a_<%=i%>" href="javascript:modifyData(<%=i%>);">
							&nbsp;&nbsp;&nbsp;<%=ht.get("ITEM_DESC")%>
						</a></font>
					 </td>
					</tr>
									
				 --%>
					
			
		<input type="hidden" name="store_code_<%=i%>" id="store_code_<%=i%>" value="<%=ht.get("STORE_CODE")%>">
		<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=ht.get("ITEM_CODE")%>">
		<input type="hidden" name="item_desc_<%=i%>" id="item_desc_<%=i%>" value="<%=ht.get("ITEM_DESC")%>">
		<input type="hidden" name="store_desc_<%=i%>" id="store_desc_<%=i%>" value="<%=ht.get("STORE_DESC")%>">
		<input type="hidden" name="genuom_id_<%=i%>" id="genuom_id_<%=i%>" value="<%=ht.get("GEN_UOM_DESC")%>"><!--Added by suresh.r on 29-07-2014 against MMS-SCF-0390  -->
		<input type="hidden" name="uom_code_<%=i%>" id="uom_code_<%=i%>" value="<%=ht.get("PHY_UOM_CODE")%>"><!--Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 -->
	<%
			bean.setItem_code((String)ht.get("ITEM_CODE"));
			bean.setStore_code((String)ht.get("STORE_CODE"));
			bean.setPhy_inv_id(phy_inv_id);
			bean.loadData1(i);
		}
	%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="prev_index" id="prev_index"				value="">
	<input type="hidden" name="index" id="index"				value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">
	<input type="hidden" name="close_yn" id="close_yn"				value="">
	<input type="hidden" name="count" id="count"					value="">
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
<%if(i>0 && !site){ //Added site for GHL-CRF-0413.7%>
	<script>
		modifyData(0);
	</script>
<%}%>
</html>

