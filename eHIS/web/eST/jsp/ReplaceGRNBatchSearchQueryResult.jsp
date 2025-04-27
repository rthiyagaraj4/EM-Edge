<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
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
		String sStyle			=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="Javascript" src="../../eST/js/ReplaceGRNBatchSearch.js"> </script>
		<script language="Javascript" src="../../eST/js/ReplacementGRN.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   </head>
<body>
<%
	String from							=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	BatchSearchReplaceGRNBean bean		=		(BatchSearchReplaceGRNBean) getBeanObject("batchSearchReplaceGRNBean","eST.BatchSearchReplaceGRNBean",request);
//	String index						=		bean.checkForNull(request.getParameter("index"),"-1");
//	String function						=		bean.checkForNull(request.getParameter("function"));
//	String item_code					=		bean.checkForNull(request.getParameter("item_code"));
//	String searchFunction				= 		bean.getSearchFunction() ;getItem_code
	String multipleSelect				=		bean.getMultipleSelect() ;
	String maxAllowed					=		bean.getMaxAllowed() ;
	//String decimal_precision			=		"0";
	bean.setLanguageId(locale);
	String allow_deci_yn = "";
    String no_deci    = "";
    allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN(bean.getItem_code()),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";
	int maxRec							=		0; 
	int start							=		0;
	int end								=		0;
	int displaySize						=		0;
	int count							=		0;	
//	int size							=		0;	
	String  className					=		"";
	ArrayList result					=		new ArrayList();	
//	size								=		result.size();
	HashMap hmBatchRecord				=		null;

//	String curr_item_store				=		"";
//	String prev_item_store				=		"";

	try{
		result							=		bean.getDataList();
		maxRec							=		result.size();
		displaySize						=		Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize						=		maxRec;


	    if ( from == null || from =="" )
			start = 0;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to ==""){
			end = displaySize ;
		}
		else{
			end = Integer.parseInt( to ) ;	
		}

       if(result.size() > 0 ){

		%>
			<form name="BatchsearchForm" id="BatchsearchForm">
						
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align="center">
			  <tr>
				<th  class='CAGROUP_HEADING' style="WORD-BREAK:BREAK-ALL;"><b>
				<fmt:message key="Common.item.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="Common.DocType.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> </b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="eST.DocSrlNo.label" bundle="${st_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="Common.PurchaseUOM.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="eST.ReplacementQty.label" bundle="${st_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="eST.ReceivedQuantity.label" bundle="${st_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="Common.close.label" bundle="${common_labels}"/> </b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b>
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> </b></font></th>
			  </tr>
		<%
			count	= start;
			int chkCount = 0;
			while ( count < maxRec && count < end)
			{
				hmBatchRecord = (HashMap)result.get(count);
//out.println(hmBatchRecord);
  
				if ( count % 2 == 0 )
					className = "QRYEVEN" ;
				else
					className = "QRYODD" ;

               %>

							
		<tr>
				<input type="hidden" name="item_code<%=count%>" id="item_code<%=count%>" value="<%=hmBatchRecord.get("ITEM_CODE")%>">
				<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;">   <%=hmBatchRecord.get("ITEM_DESC")%></td>
				<input type="hidden" name="item_desc<%=count%>" id="item_desc<%=count%>" value="<%=hmBatchRecord.get("ITEM_DESC")%>" >

				<td class="<%=className%>" nowrap  value=""><%=hmBatchRecord.get("DOC_TYPE_CODE")%></td>
				<input type="hidden" name="doc_type_code<%=count%>" id="doc_type_code<%=count%>" value="<%=hmBatchRecord.get("DOC_TYPE_CODE")%>" >

				<td class="<%=className%>" nowrap   value=""><%=hmBatchRecord.get("DOC_NO")%></td>
				<input type="hidden" name="doc_no<%=count%>" id="doc_no<%=count%>" value="<%=hmBatchRecord.get("DOC_NO")%>" >

				<td class="<%=className%>" nowrap value=""><%=bean.checkForNull((String)hmBatchRecord.get("DOC_SRL_NO"))%></td>
				<input type="hidden" name="doc_srl_no<%=count%>" id="doc_srl_no<%=count%>" value="<%=bean.checkForNull((String)hmBatchRecord.get("DOC_SRL_NO"))%>" >
				<td class="<%=className%>" nowrap value=""><%=bean.checkForNull((String)hmBatchRecord.get("PUR_UOM_DESC"))%></td>
				<input type="hidden" name="pur_uom_desc<%=count%>" id="pur_uom_desc<%=count%>" value="<%=bean.checkForNull((String)hmBatchRecord.get("PUR_UOM_DESC"))%>" >
				 	<!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Replacement Qty, Pending Qty.				
					-->
				<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"    value=""><%=bean.setNumber(bean.checkForNull((String)hmBatchRecord.get("RTV_REPL_QTY"),"0"),Integer.parseInt(no_deci))%>&nbsp;</td>
				<input type="hidden" name="rtv_repl_qty<%=count%>" id="rtv_repl_qty<%=count%>" value="<%=bean.checkForNull((String)hmBatchRecord.get("RTV_REPL_QTY"),"0")%>" >

				<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"    value=""><%=bean.setNumber(bean.checkForNull((String)hmBatchRecord.get("PEND_REPL_QTY"),"0"),Integer.parseInt(no_deci))%>&nbsp;</td>
				<input type="hidden" name="pend_repl_qty<%=count%>" id="pend_repl_qty<%=count%>" value="<%=bean.checkForNull((String)hmBatchRecord.get("PEND_REPL_QTY"),"0")%>" >
				<input type="hidden" name="rtv_unit_cost<%=count%>" id="rtv_unit_cost<%=count%>" value="<%=bean.checkForNull((String)hmBatchRecord.get("RTV_UNIT_COST"),"0")%>" >


				<td class="<%=className%>" ><input type='text' size='5' name="received_qty<%=count%>" id="received_qty<%=count%>" value="" class="NUMBER" onkeypress = "allow_restrict_decimals2(this,event);" onblur="checkDoubleFormat(this,true)"></td>
				<td class="<%=className%>" ><input type='checkbox' name="close_yn<%=count%>" id="close_yn<%=count%>" value="N" onClick="setValue(<%=count%>)"></td>
				<td class="<%=className%>" ><input type=checkbox onClick="setCloseValue(<%=count%>)" name="check<%=count%>" id="check<%=count%>" value="N" ></td>
				
				<%
					count++;
				chkCount++;
				}%>
           	</tr>
								
		<%
			
			//prev_item_store=curr_item_store;
	        //End of while loop
       %> </table>
		    <input type="hidden" name="start" id="start"			value="<%=start%>">
			<input type="hidden" name="end" id="end"				value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords"	value="<%=maxRec%>">
			<input type="hidden" name="displaySize" id="displaySize"		value="<%=displaySize%>">
			<input type="hidden" name="multipleSelect" id="multipleSelect"  value="<%=multipleSelect%>">
			<input type="hidden" name="maxAllowed" id="maxAllowed"		value="<%=maxAllowed%>">
			<input type="hidden" name="count" id="count"			value="1">
			<input type='hidden' name='allow_deci_yn' id='allow_deci_yn'		value="<%=allow_deci_yn%>">
        	<input type='hidden' name='no_deci' id='no_deci'		value="<%=no_deci%>">
            
	  <%  out.flush();
		  }else{ %>

			 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				parent.window.close();
			 </script>
		<% 	} 

  	  }catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=result.size()%>">
    </form>
<%
//putObjectInBean("batchSearchReplaceGRNBean",bean,request);
%>
</body>
</html>

