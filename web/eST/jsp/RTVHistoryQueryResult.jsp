<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.lang.*,java.text.NumberFormat"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/STMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/STTransaction.js"></script>
	<script language="javascript" src="../../eST/js/RTVHistory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	
	String doc_type_code="";
	String doc_no="";
	String doc_date="";
	String rtv_val="";
	String supp_code="";
	String item_qty_normal="";
	String expiry_date_or_receipt_date="";
	String item_qty_bonus="";
	
	String rtv_unit_cost_in_pur_uom="";
	String store_code="";
	String grn_doc_no="";
	String grn_doc_type_code="";
	String item_code_temp = "";
	String item_desc = "";
	String doc_no_temp = "";
	String rtv_grn_cnt = "";
	String classvalue ="" ;      
	String batch_id ="" ;      
	String stlightgreen = "";
	String item_code = "";
	String item_qty = "";
	int maxRec = 0;
	int displaySize = 0;
	int start  = 0;
	int end  = 0;
	int count   = 0;
	
	String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String bean_id = "RTVHistoryBean";
	String bean_name = "eST.RTVHistoryBean";
	RTVHistoryBean bean = (RTVHistoryBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale);
	ArrayList result=new ArrayList();	
	HashMap dataList	= null;
	try{
		/**
			* @Name - Priya
			* @Date - 11/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function 
		*/
		int no_of_decimals=bean.getNoOfDecimals();

		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());


		result=bean.getDataList();
		maxRec=  result.size();
		displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize=Integer.parseInt("12");
		if ( from == null || from =="" )
			start = 0;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to =="")
			end = displaySize ;
		
		else
			end = Integer.parseInt( to ) ;	
		
		if(result.size() > 0 ){
		%>
			<form name=RTVResultForm id=RTVResultForm>
			<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
			</div>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
		
				<th>&nbsp;</th>         
				<th><fmt:message key="eST.DocType/No.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>			 
				<th><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></th>			 
				<th><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></th>			 
				<th><fmt:message key="eST.NormalQty.label" bundle="${st_labels}"/></th>			 
				<th><fmt:message key="eST.BonusQuantity.label" bundle="${st_labels}"/></th>			 
				<th><fmt:message key="eST.RTVValue.label" bundle="${st_labels}"/></th>			 
				<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>		
			  	<th><fmt:message key="eST.BatchQuantity.label" bundle="${st_labels}"/></th>	
			  	<th><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>	
				<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th>
		
		<%
			
			count	= start;
			int chkCount = 0;
			while ( count < maxRec && count < end)                       
			{
				++chkCount;
				dataList = (HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else 
					classvalue = "QRYODD" ;
		
				item_code=CommonBean.checkForNull((String)dataList.get("ITEM_CODE"));
				doc_type_code=CommonBean.checkForNull((String)dataList.get("DOC_TYPE_CODE"));
				doc_no=CommonBean.checkForNull((String)dataList.get("DOC_NO"));
				doc_date=CommonBean.checkForNull((String)dataList.get("DOC_DATE"));
				supp_code=CommonBean.checkForNull((String)dataList.get("SUPP_CODE"),"");
				item_qty_normal=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_NORMAL"),"");
				item_qty_bonus=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_BONUS"),"");
				
				rtv_unit_cost_in_pur_uom=bean.setNumber(CommonBean.checkForNull((String)dataList.get("RTV_UNIT_COST"),"0"),noOfDecimalsForCost);
				store_code=CommonBean.checkForNull((String)dataList.get("STORE_CODE"),"");
				batch_id=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"");
				expiry_date_or_receipt_date=CommonBean.checkForNull((String)dataList.get("EXPIRY_DATE_OR_RECEIPT_DATE"),"");
				rtv_val=bean.setNumber(CommonBean.checkForNull((String)dataList.get("ITEM_COST_VALUE"),"0"),noOfDecimalsForCost);
				grn_doc_no=CommonBean.checkForNull((String)dataList.get("GRN_DOC_NO"));
				grn_doc_type_code=CommonBean.checkForNull((String)dataList.get("GRN_DOC_TYPE_CODE"));
				item_desc=CommonBean.checkForNull((String)dataList.get("SHORT_DESC"),"");			
 				rtv_grn_cnt=CommonBean.checkForNull((String)dataList.get("RTV_GRN_CNT"),"");				
 				item_qty=CommonBean.checkForNull((String)dataList.get("ITEM_QTY"),"");				
				 if(!locale.equals("en"))
				{
				 if(batch_id.equals(expiry_date_or_receipt_date))
				{
					 batch_id=com.ehis.util.DateUtils.convertDate(batch_id,"DMY","en",locale);
				}
				else
				{
				 batch_id= batch_id;
				}
				}
				if(!locale.equals("en"))
				{
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
				
				expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date,"DMY","en",locale);
				
				}else 
				{
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
				expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date,"DMY","en",locale);
				}

				if(maxRec==1){
				%>
				
				<%
				}

		%>
			<tr>	
			<%
				
				stlightgreen = classvalue;
				String tool ="";
				String description = "";
				String finalized_yn = (String)dataList.get("FINALIZED_YN");
				int flag = 0;
				String dispflag = "";
				if ((finalized_yn).equals("Y")) 
					{
							stlightgreen = "STLIGHTCREAM";
							tool = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalized.label","common_labels");
							description = "F";
							flag = 1;
				}
				else if (finalized_yn.equals("N"))
					{
						stlightgreen = "STLIGHTCREAM";
						tool =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnFinalized.label","common_labels");
						description ="U";												
					}
					dispflag = "N";
				if( !item_code_temp.equals((String)dataList.get("ITEM_CODE")))
						{
							//	dispflag = "Y";
								doc_no_temp="";
								item_code_temp = (String)dataList.get("ITEM_CODE") ;
								out.println("<tr><td class='ITEMSELECT' align='left' colspan='13'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ItemCode.label","common_labels")+" : <b>"+item_code_temp+"</b> "+          com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+" : <b>"+item_desc+" </b></td></tr>");          
						}
				if( !doc_no_temp.equals((String)dataList.get("DOC_NO")))
						{
								dispflag = "Y";
								doc_no_temp = (String)dataList.get("DOC_NO") ;
							//	out.println("<tr><td class='ITEMSELECT' align='left' colspan='13'><b>"+item_code_temp+"</b></td></tr>");
						}
			%>
				<td class="<%=stlightgreen%>" 
				<%   
					if (flag == 1) 
					{
					 if (dispflag.equals("Y"))
						{
				%>
					style="cursor:pointer" onClick="displayPending('<%=doc_type_code%>','<%=doc_no%>','<%=grn_doc_no%>','<%=grn_doc_type_code%>','<%=item_code%>',<%=chkCount%>);" style ="color=blue"
				<%
						}
					}
				%>
					
				 title= "<%=tool%>"  align="center"><font align = "center" size = 1 ><B><%=description%></B></font></td>

				<td  class="<%=classvalue%>"
				<%	String tool_repl =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ReplacementGRNExists.label","st_labels");
					if (Integer.parseInt(rtv_grn_cnt)!=0) 
					{
				%>
					 title = "<%=tool_repl%>" onClick="displayRTV_GRN('<%=doc_type_code%>','<%=doc_no%>','<%=item_code_temp%>');" style ="color=blue ;cursor:pointer "
				<%
					}
				%>					
				 align="center" id="doc_type_no_<%=chkCount%>" > <font align = "center" size = 1 ><%=(dispflag=="Y"?doc_type_code+"/"+doc_no:"")%>&nbsp;</B></font></td>
				<td class="<%=classvalue%>"  align='left'  id="doc_date_<%=chkCount%>"			onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?doc_date:"")%>&nbsp; </td>
				<td class="<%=classvalue%>"  align='left'  id="supp_code_<%=chkCount%>"			onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?supp_code:"")%>&nbsp;</td>
					<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Unit Cost, Normal Qty, Bonus Quantity, Batch Quantity, RTV Value.				
					-->
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" id="rtv_unit_cost_in_pur_uom_<%=chkCount%>" onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?rtv_unit_cost_in_pur_uom:"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" id="item_qty_normal_<%=chkCount%>"	onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_normal,"0"),no_of_decimals):"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right" id="item_qty_bonus_<%=chkCount%>"	onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_bonus,"0"),no_of_decimals):"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"  id="rtv_val_<%=chkCount%>"			onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?rtv_val:"")%>&nbsp;</td>			
				<td class="<%=classvalue%>"  align='left'  id="store_code_<%=chkCount%>"		onclick="disableClick(event);" nowrap><%=(dispflag=="Y"?store_code:"")%>&nbsp;</td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"  id="item_qty_<%=chkCount%>"			onclick="disableClick(event);" nowrap><%=bean.setNumber(bean.checkForNull((String)item_qty,"0"),no_of_decimals)%>&nbsp;</td>
				<td class="<%=classvalue%>"  align='left'  id="batch_id_<%=chkCount%>"			onclick="disableClick(event);" nowrap><%=batch_id%>&nbsp;</td>
				<td class="<%=classvalue%>"  align='left'  id="expiry_date_or_receipt_date_<%=chkCount%>" onclick="disableClick(event);" nowrap><%=expiry_date_or_receipt_date%>&nbsp;</td>


				

			</tr>
		<%
				count++;
			chkCount++;
			}
		%>
			</table>
			<input type="hidden" name="start" id="start" value="<%=start%>">
			<input type="hidden" name="end" id="end" value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords" value='<%=result.size()%>'>
			<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
			<input type="hidden" name="count" id="count" value="1">
		<%
			out.flush();
		} else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}

	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</form>
<script>activeLink();</script>
</html>
<%!
	public String replaceNewLineChar(String message) {
	
		String changed = "";
        changed = message.replaceAll("\n","\\n/");
		changed = changed.replaceAll("\"","\\\"");
		changed = changed.replaceAll("'","\\\\'");	
        return changed;
}

/* Modified on 5/9/2006  as per TSG request
   public String replaceNewLineChar(String message) {
	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\"","'"};
        String chChar[]={"\\n/","\\\"","\\\'"};

        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
							i+=chChar[j].length();
                            continue upper;
                        }
                    }
	}
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
        return sb.toString();
    }*/

%>
<%
putObjectInBean(bean_id,bean,request);
%>

