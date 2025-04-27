<!DOCTYPE html>
 <%
 /*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
??
23/06/2017		IN064596		Badmavathi B							MO-CRF-20174
---------------------------------------------------------------------------------------------------------
*/
%>
 <%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/RejectRequest.js'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<form name="formRejectRequestQueryResult" id="formRejectRequestQueryResult">
	<%
		request.setCharacterEncoding("UTF-8");
		String bean_id					=		"rejectRequestBean";
		String bean_name				=		"eST.RejectRequestBean";
		String mode						=		request.getParameter("mode");
		mode							=		mode.trim();
		String locale					=		(String)session.getAttribute("LOCALE");
		

		if ((mode == null) || (mode.equals(""))) 
			return;
		if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;

		RejectRequestBean bean			=		(RejectRequestBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		//Added by Rabbani  # Bru-HIMS-CRF-118[INC NO:30077] on 22-JULY-2013
		if(!searched){
		bean.clear();
		bean.initialize();
		}
		//ends
		
		ArrayList Arrchkitem			=		new ArrayList();
		Arrchkitem						=		bean.getCheckItems();
		String doc_type_code			=		request.getParameter("doc_type_code");
		String doc_no					=		request.getParameter("doc_no");
		String from_doc_date			=		request.getParameter("from_doc_date");
		String to_doc_date				=		request.getParameter("to_doc_date");
		String request_by_store			=		request.getParameter("request_by_store");
		String request_on_store			=		request.getParameter("request_on_store");
		String item_class_code			=		request.getParameter("item_class_code");
		String request_type				=		request.getParameter("request_type");
	//	String request_status			=		request.getParameter("request_status");
		String request_status = "";  
		String checked					=		"checked"; // Added on Monday, July 26, 2004
		int checked_ind;
		
		String classvalue				=		"";
		String visibility				=		"visibility:hidden";  //Added by Rabbani #INC NO:37466 on 18/FEB/2013
        String trn_remarks  = "";		
		
		//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 19-JULY-2013  Starts
		ArrayList AlDtlchkitems			=		new ArrayList();
		ArrayList alItems			    =		new ArrayList(); 
		 ArrayList  alParam             =       new ArrayList();
		AlDtlchkitems					=		bean.getDtlCheckItems();
		String item_code			    =		request.getParameter("item_code");
		String item_desc			    =		request.getParameter("item_desc");
		System.out.println("item_code: "+item_code);
		System.out.println("item_desc: "+item_desc); 
		String className			    =		"";
		 int totaldtlSize               =       0;
		 int dtl_count                  =       0;
		 int no_of_decimals_temp	    =		bean.getNoOfDecimals();
		 int no_of_decimals				=		0;
		 String checked_flag			=		"checked";
		 String display_flag			=		"visibility:hidden";
		 int checked_item;
		 String item_remarks            =        "";
		 String doctypecode             =        "";
		 String docno                   =        "";
		 String facility_id             =        "";
		 String exp_legend              =        "+";
		 boolean flag                   =      false;
		 String requestbystore			=		CommonBean.checkForNull(request.getParameter("request_by_store"));
		 String requestonstore			=		CommonBean.checkForNull(request.getParameter("request_on_store"));
		 //ends
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code				=		CommonBean.checkForNull(doc_type_code,"%");
			doc_no						=		CommonBean.checkForNull(doc_no,"%");
			from_doc_date				=		CommonBean.checkForNull(from_doc_date,"");
			from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
			to_doc_date					=		CommonBean.checkForNull(to_doc_date,"");
            to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
			request_by_store			=		CommonBean.checkForNull(request_by_store,"%");
			request_on_store			=		CommonBean.checkForNull(request_on_store,"%");
			item_class_code				=		CommonBean.checkForNull(item_class_code,"%");
			request_type				=		CommonBean.checkForNull(request_type,"%");
			item_code				    =		CommonBean.checkForNull(item_code,"%");//Added by Rabbani Bru-HIMS-CRF-118[INC NO:30077]
			item_desc				    =		CommonBean.checkForNull(item_desc,"%");//Added by Rabbani Bru-HIMS-CRF-118[INC NO:30077]
			 

			HashMap sqlMap				=		new HashMap();
			String sql					=		eST.Common.StRepository.getStKeyValue("SQL_ST_REJECT_REQUEST_HDR_QUERY_RESULT");//MO-CRF-20174  
			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_HDR_QUERY_RESULT"));
						
			HashMap funcMap				=		new HashMap();
			ArrayList displayFields		=		new ArrayList();

			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("REQ_BY_STORE_DESC");
			displayFields.add("REQ_ON_STORE_DESC");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("REQ_BY_STORE_CODE");
			displayFields.add("REQ_ON_STORE_CODE");
			displayFields.add("ITEM_CLASS_CODE");
			displayFields.add("REQUEST_STATUS");
			displayFields.add("FACILITY_ID"); //Added by Rabbani #Bru-HIMS-CRF-118[INC NO:30077]

			ArrayList chkFields			=		new ArrayList();
			
			/*chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(request_by_store);
			chkFields.add(request_on_store);
			chkFields.add(item_code);//Added by Rabbani #Bru-HIMS-CRF-118[INC NO:30077]
			chkFields.add(item_desc);//Added by Rabbani #Bru-HIMS-CRF-118[INC NO:30077]
			chkFields.add(item_class_code);
			chkFields.add(request_type);
			chkFields.add(request_status);
			chkFields.add((String)session.getValue("facility_id"));
			chkFields.add((String)session.getValue("facility_id"));
			chkFields.add(bean.getLoginById());
			chkFields.add(locale);//Added by Rabbani #Bru-HIMS-CRF-118[INC NO:30077]
			*/
			//Modified by Sakti to pass the parameters dynamically for performance issue starts Inc# 51157
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add((String)session.getValue("facility_id"));
			chkFields.add((String)session.getValue("facility_id"));
			chkFields.add(bean.getLoginById());
			chkFields.add(locale);
			if(!doc_type_code.equals("%")) {
				sql = sql+"AND hdr.doc_type_code = ?";
				chkFields.add(doc_type_code);
			}
			if(!doc_no.equals("%")) {
				sql = sql+"AND hdr.doc_no = ?";
				chkFields.add(doc_no);
			}
			if(!request_by_store.equals("%")) {
				sql = sql+"AND hdr.req_by_store_code = ?";
				chkFields.add(request_by_store);
			}
			if(!request_on_store.equals("%")) {
				sql = sql+" AND hdr.req_on_store_code = ?";
				chkFields.add(request_on_store);
			}
			if(!item_code.equals("%")) {
				sql = sql+" AND dtl.item_code = ?";
				chkFields.add(item_code);
			}			
			if(!item_desc.equals("%")) {
				sql = sql+" AND  (mm.short_desc) = ?";
				chkFields.add(item_desc);
			}
			if(!item_class_code.equals("%")) {
				sql = sql+" AND hdr.item_class_code = ?";
				chkFields.add(item_class_code);
			}
			if(!request_type.equals("%")) {
				sql = sql+" AND rbys.external_yn = DECODE (?, 'Y', 'Y', 'N', 'N', '%') ";
				chkFields.add(request_type);
			}
			/*if(!request_status.equals("%")) {
				sql = sql+" AND request_status = ?";
				chkFields.add(request_status);
			}*/
			//Modified by Sakti to pass the parameters dynamically for performance issue ends
			
			// Adding function related array list into the HashMap
			sqlMap.put("sqlData",sql);
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			System.out.println("sql: "+sql);
			System.out.println("chkFields: "+chkFields); 

			ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("result: "+result);  
			int recCount=0,i = 0;
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){


	%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%=result.get(1)%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
		   		<tr>
				   <th></th>
					<th width='260'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
				<!-- <th width='3'>Cancel</th>   
					modified on Monday, July 26, 2004  -->
					
					<th><fmt:message key="eST.Reject.label" bundle="${st_labels}"/><!-- MO-CRF-20174 -->
						<input type="checkbox" value="Y" name="cancelAll" id="cancelAll"   onClick="return toggleCheck(formRejectRequestQueryResult);">
					</th> <!--  Modified on Monday, July 26, 2004 -->

					<th ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
			ArrayList records=new ArrayList();
		System.out.println("result.size(): "+result.size());  
			for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				if (recCount % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;

				
		%>
				<tr id="tr_<%=i%>">
		<%
				records				=		(ArrayList) result.get(recCount);
		System.out.println("records: "+records);  
				 //Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 19-JULY-2013  Starts
				  doctypecode   = "";
				  docno         = "";
				  facility_id   = "";
				  
				checked_ind			=		 Arrchkitem.indexOf(records.get(6)+"-"+records.get(1));
				checked				=		(checked_ind != -1 ? "checked":"");
				classvalue			=		(checked == ""?classvalue:"DATACHANGE");
				//Added by Rabbani #INC NO:37466 on 18/FEB/2013  Starts
				visibility				=		"visibility:hidden";
				if(checked.equals("checked"))
				visibility				=		"visibility:visible";
				//ends
				//Added by Rabbani #Inc no:37466  on 07-MAR-2013
				String key				=		(String)records.get(6)+"-"+records.get(1);
		        trn_remarks			    =		 bean.getRemarks(key);
				
				//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013  Starts
				 doctypecode  =  (String)records.get(6);
				 docno        =  (String)records.get(1);
				 facility_id  =  (String)records.get(11);
				 bean.loadData(facility_id,doctypecode,docno,item_code,item_desc);
				 alItems      =	 bean.getAlItems();
				 int j=0;
						if(alItems.size()>0)
							exp_legend="+";  
						else
							exp_legend="-";
				//ends

		%>
		           <td  onclick='javascript:expanddetails(this,tr_<%=i%>,<%=i%>)'  width='5%' align ='center'  class="<%=classvalue%>"><a id="view<%=i%>  href=''"><b><%=exp_legend%></b></a></td>
					<!--<td class="<%=classvalue%>" onClick="displayPending(tr_<%=i%>);" onmouseover="changeCursor(this);" nowrap>
						<font class='HYPERLINK'>
							<%=(String)records.get(0)%>
						</font>
					</td> -->
					
					<td class="<%=classvalue%>" onclick="disableClick(event);" >
						<%=records.get(0)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" >
						<%=records.get(1)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" >
						<%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" >
						<%=records.get(3)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" >
						<%=records.get(4)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);">
						<%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%>
					</td>
						<td class="<%=classvalue%>" onclick="disableClick(event);"  title="<%=records.get(10)%>">

				 		<input type="checkbox" name="doc_<%=i%>" id="doc_<%=i%>" onClick="changeMyRowColor (<%=i%>,9,this)"  value="<%=records.get(6)%>~<%=records.get(1)%>~<%=records.get(11)%>" title="<%=records.get(10)%>"  <%=checked%>>											
					</td>		
				<td class="<%=classvalue%>" onClick="showReason(tr_<%=i%>,<%=i%>);" onmouseover="changeCursor(this);" >
				<font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font><img id="img_<%=i%>" name="img_<%=i%>" src="../../eCommon/images/mandatory.gif" style="<%=visibility%>"/></td>
					<td class='NODISPLAY'>
						<%=records.get(6)%>
						
					</td>
					<input type="hidden" name="checked_yn_<%=i%>" id="checked_yn_<%=i%>"		value="" >
					<input type="hidden" name="details_<%=i%>" id="details_<%=i%>"			value="" >	
					<input type="hidden" name="rem_<%=i%>" id="rem_<%=i%>"               value="<%=trn_remarks%>">
					 
					
					 <!--Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013 Starts -->
				 <tr  id ="item_dtls_<%=records.get(1)%>" >
				 <td colspan='9'>
				<table name ="tblItemList" id = "tblItemList_<%=i%>" border='1' width='45%' height = '20%'  cellpadding='0' cellspacing='0'   style="display:none;margin-left:2cm;border:1px solid black;" scrolling="auto">   
				<tr>
			    <th width="60%" style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
				<th width="10%"><fmt:message key="eST.IssQty.label" bundle="${st_labels}"/></th>
				<th width="10%"><fmt:message key="eST.Reject.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
				</tr>  
				<%
				if (alItems != null && (alItems.size()>0)){
					  totaldtlSize = alItems.size();
					     alParam   =  new ArrayList();
				try{
					alParam.add(facility_id);
					alParam.add(doctypecode);
					alParam.add(docno);
					dtl_count = Integer.parseInt((String)((HashMap)bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_REQUEST_DTL WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND PENDING_ITEM_QTY >0  ",alParam)).get("COUNT"));
				 }catch(Exception e){
					e.printStackTrace();
				  }
					RejectRequestDetailBean detailBean;
					for (j=0;	j<totaldtlSize;	j++){
						detailBean = (RejectRequestDetailBean) alItems.get(j);
						if (detailBean != null) {
						className	=	((j%2)==0)?"QRYEVEN":"QRYODD";
					if((bean.getAllowDecimalsYN(detailBean.getItem_code())).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals = no_of_decimals_temp;
					}
					if(flag){
					checked = "";
					}
					
					 if(checked.equals("")){
					  checked_item		=		 AlDtlchkitems.indexOf(doctypecode+"-"+docno+"-"+detailBean.getItem_code());
				      checked		    =	   (checked_item != -1 ? "checked":"");
					   visibility		=		"visibility:hidden";
					   
				    if(checked.equals("checked")){
					   flag        =        true;
				       visibility  =		"visibility:visible";
					   }
					  }
					  String key_item				=		(String)doctypecode+"-"+docno+"-"+detailBean.getItem_code();
					         item_remarks	        =        bean.checkForNull(bean.getItemRemarks_code(key_item));
					
							 if(item_remarks.equals("")){
		                  	 item_remarks	        =		 bean.checkForNull(bean.getItemRemarks(key_item));
							  if(item_remarks.equals(""))
							 item_remarks	        =	trn_remarks;
							 }
							 
							 String   item_name = detailBean.getItem_desc();
							 
							 if(!item_name.equals("")){
					      item_name = item_name.replaceAll(" ","%20");
					      item_name = java.net.URLEncoder.encode(item_name,"UTF-8");
					      item_name = item_name.replaceAll("%2520","%20");
				          }
				%> 
				 <tr>  
				     <td  class="<%=className%>"   style="WORD-BREAK:BREAK-ALL;" ><font size=1><%=detailBean.getItem_desc()%></font>
					<input type = "hidden" name = "item_desc_<%=i%>_<%=j%>"  value = "<%=item_name%>">
					<input type = "hidden" name = "item_code_<%=i%>_<%=j%>"  value = "<%=detailBean.getItem_code()%>"></td>
					<!-- Added for ML-BRU-SCF-1715 starts-->
					<input type="hidden" name="doctypecode_<%=i%>_<%=j%>" id="doctypecode_<%=i%>_<%=j%>"	 	value="<%=records.get(6)%>">
				        <input type="hidden" name="docno_<%=i%>_<%=j%>" id="docno_<%=i%>_<%=j%>"	 	value="<%=records.get(1)%>">
					<!-- Added for ML-BRU-SCF-1715 ends-->
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=bean.checkForNull(bean.setNumber(detailBean.getRequired_qty(),no_of_decimals),"&nbsp;")%>&nbsp;</td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right" ><%=bean.checkForNull(detailBean.getIssued_qty()).equals("")?"&nbsp;":bean.setNumber(detailBean.getIssued_qty(),no_of_decimals)%>&nbsp;</td>
					<td class="<%=className%>"><input type="checkbox" value="<%=records.get(6)%>~<%=records.get(1)%>~<%=detailBean.getItem_code()%>" id = "item_cancel_<%=i%>_<%=j%>" name ="item_cancel_<%=i%>_<%=j%>"   onClick="ItemCancel(<%=i%>,<%=j%>,this)"  <%=checked%>>&nbsp;</td> 
					<td class="<%=classvalue%>" onClick="showItemReason(<%=i%>,<%=j%>);" onmouseover="changeCursor(this);" >
				   <font  size=1 class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font><img id="dtl_img_<%=i%>_<%=j%>" name="dtl_img_<%=i%>_<%=j%>" src="../../eCommon/images/mandatory.gif" style="<%=visibility%>"/></td>
				   <input type="hidden" name="dtl_rem_<%=i%>_<%=j%>" id="dtl_rem_<%=i%>_<%=j%>"                value="<%=item_remarks%>">
				   </tr> 
				<%
					} 
				 }
				}
			%>
			  <input type="hidden" name="item_size_<%=i%>" id="item_size_<%=i%>"              value="<%=totaldtlSize%>">
			  <input type="hidden" name="item_dtl_length_<%=i%>" id="item_dtl_length_<%=i%>"	 	value="<%=dtl_count%>">
			   </table>
			   </td>
			  </tr> 
			  </tr>
		<%
			}
		%>
		</table>
		<input type="hidden" name="checkedIndices" id="checkedIndices"					value="" %>
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"				value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"						value="<%= bean_name%>">
		<input type="hidden" name="mode" id="mode"							value="<%= mode%>">
		<input type="hidden" name="item_code" id="item_code"	 				   value="<%=item_code%>">
		<input type="hidden" name="checked_item_indices" id="checked_item_indices"	 		value="" >
		
		<input type="hidden" name="request_on_store" id="request_on_store"	 	   value="<%=requestonstore%>" >
		<input type="hidden" name="request_by_store" id="request_by_store"	 	   value="<%=requestbystore%>" >
		<input type="hidden" name="from_doc_date" id="from_doc_date"	 	        value="<%=from_doc_date%>" >
		<input type="hidden" name="to_doc_date" id="to_doc_date"	 	            value="<%=to_doc_date%>" >

	</form>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/RejectRequestQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

