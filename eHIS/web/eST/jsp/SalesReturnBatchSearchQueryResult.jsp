<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------------------------
24/07/2018		66199				Shazana Hasan							GHL-CRF- 0499 - Added Challan_No in Batch Search
16/11/2018		69074				Shazana Hasan							GHL-ICN-0032
-----------------------------------------------------------------------------------------------------------------------------
*/
%> 




<%@ page import ="eST.SalesReturnBatchSearchBean,java.util.ArrayList,java.util.HashMap,java.sql.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%><!-- MODIFIED FOR GHL-CRF-0499 -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>

	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>


<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
	 	<script language="javascript" src="../../eCommon/js/common.js"></script> 
		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
		<script language="Javascript" src="../../eST/js/SalesReturnBatchSearch.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   </head>

<body>
<%
	String from	= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to	= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	


	SalesReturnBatchSearchBean bean = (SalesReturnBatchSearchBean) getBeanObject( "SalesReturnBatchSearchBean",  "eST.SalesReturnBatchSearchBean" , request );
	bean.setLanguageId(locale);

	String searchFunction	= 	bean.getSearchFunction() ;
	String multipleSelect	=	bean.getMultipleSelect() ;
	String maxAllowed	    =	bean.getMaxAllowed() ;

	int maxRec=0; 
	int start = 0;
	int end  = 0;
	int displaySize = 0;
	int count = 0;	
		
	String  classvalue="";
	ArrayList result=new ArrayList();	
	HashMap dataList	= null;

	//Added for GHL-CRF-0499 starts 
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_DISPLAY_CHALLAN_NO");
	bean.setSite_spec_yn(site_main);
	//Added for GHL-CRF-0499 ends

	String storeCd= bean.getStore_code();//added for ghl-icn-0032
	try{
	
		result=bean.getDataList();

		maxRec=  result.size();
		displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize = maxRec;
		String challanNo= "";//added for GHL-CRF-0499

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
			<form name=BatchsearchForm id=BatchsearchForm>
						
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align="center">
			  <tr>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></b></font></th>
				
				<!-- added for ghl-crf-0499 start -->
				<% if(site_main){ %>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.ChallanNo.label" bundle="${common_labels}"/></b></font></th>
				<%} %>
				<!-- added for ghl-crf-0499 end -->
				
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.TradeName.label" bundle="${mm_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.SaleQuantity.label" bundle="${common_labels}"/></b></font></th>
				<th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></b></font></th>
				<%if(searchFunction.equals("Y")){%>
				   <th  class='CAGROUP_HEADING'><font size=1><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></b></font></th>
			    <%}%>
			  </tr>
		<%
			count	= start;
			int chkCount = 0;
			while ( count < maxRec && count < end)
			{
				dataList = (HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
			String sales_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Sales.label","st_labels");
			String itemCode=(String)dataList.get("ITEM_CODE");
			//ADDED FOR ghl-crf-0499
			String batch_id = (String)dataList.get("BATCH_ID");
			String expiry_date = (String)dataList.get("EXPIRY_RECEIPT_DT");
               %>
							
			<tr>
				<td class="<%=classvalue%>"  title="<%=sales_title%>: <%=(String)dataList.get("SAL_DOC_NO")%>/<%=(String)dataList.get("SAL_DOC_TYPE_CODE")%>"><font size=1><%=CommonBean.checkForNull((String)dataList.get("ITEM_DESC"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"&nbsp;")%></font></td>
				<!-- ADDED FOR GHL-CRF-0499 START -->
				<% if( site_main ){
					challanNo = bean.getChallanNo(itemCode, batch_id, expiry_date,storeCd);	//modified for GHL-ICN-0032
				%>
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull(challanNo,"&nbsp;")%></font></td>
				<% } %>
				
				<!-- ADDED FOR GHL-CRF-0499 END -->
				
				<td class="<%=classvalue%>" ><font size=1><%=CommonBean.checkForNull((String)dataList.get("TRADE_NAME"),"&nbsp;")%></font></td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)dataList.get("SAL_ITEM_QTY"),"0")%></font></td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><font size=1><%=CommonBean.checkForNull((String)dataList.get("AVAIL_QTY"),"0")%></font></td>
				<% if(searchFunction.equals("Y")) {%>
				<td  class="<%=classvalue%>"><input type=checkbox onClick="return checkAllowed(this);" name="check<%=count%>" id="check<%=count%>"></font></td><input type=hidden name="batch_id<%=count%>" id="batch_id<%=count%>" value="<%=(String)dataList.get("BATCH_ID")%>"><input type=hidden name="item_code<%=count%>" id="item_code<%=count%>" value="<%=(String)dataList.get("ITEM_CODE")%>"><input type=hidden name="item_desc<%=count%>" id="item_desc<%=count%>" value="<%=(String)dataList.get("ITEM_DESC")%>"><input type=hidden name="store_code<%=count%>" id="store_code<%=count%>" value="<%=(String)dataList.get("STORE_CODE")%>"><input type=hidden name="store_desc<%=count%>" id="store_desc<%=count%>" value="<%=(String)dataList.get("STORE_DESC")%>"><input type=hidden name="expiry_date<%=count%>" id="expiry_date<%=count%>" value="<%=(String)dataList.get("EXPIRY_RECEIPT_DT")%>"><input type=hidden name="bin_location_code<%=count%>" id="bin_location_code<%=count%>" value="<%=(String)dataList.get("BIN_LOCATION_CODE")%>"><input type=hidden name="bin_desc<%=count%>" id="bin_desc<%=count%>" value="<%=(String)dataList.get("BIN_DESC")%>"><input type=hidden name="trade_id<%=count%>" id="trade_id<%=count%>" value="<%=(String)dataList.get("TRADE_ID")%>"><input type=hidden name="trade_name<%=count%>" id="trade_name<%=count%>" value="<%=(String)dataList.get("TRADE_NAME")%>"><input type=hidden name="qty_on_hand<%=count%>" id="qty_on_hand<%=count%>" value="<%=(String)dataList.get("QTY_ON_HAND")%>"><input type=hidden name="nod<%=count%>" id="nod<%=count%>" value="<%=(String)dataList.get("NOD")%>"><input type=hidden name="avail_qty<%=count%>" id="avail_qty<%=count%>" value="<%=(String)dataList.get("AVAIL_QTY")%>"><input type=hidden name="sal_doc_srl_no<%=count%>" id="sal_doc_srl_no<%=count%>"  value="<%=(String)dataList.get("SAL_DOC_SRL_NO")%>"><input type=hidden name="sal_doc_date<%=count%>" id="sal_doc_date<%=count%>" value="<%=(String)dataList.get("SAL_DOC_DATE")%>"><input type=hidden name="sal_doc_no<%=count%>" id="sal_doc_no<%=count%>" value="<%=(String)dataList.get("SAL_DOC_NO")%>"><input type=hidden name="sal_doc_type_code<%=count%>" id="sal_doc_type_code<%=count%>" value="<%=(String)dataList.get("SAL_DOC_TYPE_CODE")%>">

				</td>
				<%}%>
           	</tr>
								
		<%
			count++;
			chkCount++;
			
	      }  //End of while loop
       %> </table>
		    <input type="hidden" name="start" id="start" value="<%=start%>">
			<input type="hidden" name="end" id="end" value="<%=end%>">
			<input type="hidden" name="totalRecords" id="totalRecords" value="<%=result.size()%>">
			<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
			<input type="hidden" name="multipleSelect" id="multipleSelect" value="<%=multipleSelect%>">
			<input type="hidden" name="maxAllowed" id="maxAllowed" value="<%=maxAllowed%>">
			<input type="hidden" name="count" id="count" value="1">
			<%
%>
	  <%  out.flush();
		  }else{ %>

			 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				parent.window.close();
			 </script>
		<% 	} 


  	  }
	  catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
	//ADDED FOR GHL-CRF-0499 
finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	
	}
%>

</body>

</form>
</html>

