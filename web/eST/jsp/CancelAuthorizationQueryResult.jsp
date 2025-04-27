<!DOCTYPE html>
 <%
 /*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
??
10/08/2022				ChandraShekar Raju A							MO-CRF-20177
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
		<script language='javascript' src='../../eST/js/CancelAuthorization.js'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
 textarea {
  resize: none;
  overflow-y: scroll;
} 
</style>
	</head>
	<body>
	<form name="formCancelAuthQueryResult" id="formCancelAuthQueryResult">
	<%
		request.setCharacterEncoding("UTF-8");
		String bean_id					=		"CancelAuthorizationBean";
		String bean_name				=		"eST.CancelAuthorizationBean";
		String mode						=		request.getParameter("mode");
		mode							=		mode.trim();
		String locale					=		(String)session.getAttribute("LOCALE");
		

		if ((mode == null) || (mode.equals(""))) 
			return;
		if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;

		CancelAuthorizationBean bean			=		(CancelAuthorizationBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	
		if(!searched){
		bean.clear();
		bean.initialize();
		}
	
		
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
		String checked					=		"checked"; 
		int checked_ind;
		
		String classvalue				=		"";
		String visibility				=		"visibility:hidden";  
        String trn_remarks  = "";		
		
		
		ArrayList AlDtlchkitems			=		new ArrayList();
		ArrayList alItems			    =		new ArrayList(); 
		 ArrayList  alParam             =       new ArrayList();
		AlDtlchkitems					=		bean.getDtlCheckItems();
		String item_code			    =		request.getParameter("item_code");
		String item_desc			    =		request.getParameter("item_desc");
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
		 String commt_qty               =        "";
		 String issue_item_qty          =        "";
		
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
			item_code				    =		CommonBean.checkForNull(item_code,"%");
			item_desc				    =		CommonBean.checkForNull(item_desc,"%");
			 

			HashMap sqlMap				=		new HashMap();
			String sql					=		"";
			
						
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
			displayFields.add("FACILITY_ID"); 

			ArrayList chkFields			=		new ArrayList();
			
			sql="SELECT DISTINCT hdr.doc_type_code, sy.short_desc doc_type_desc, hdr.doc_no, TO_CHAR (hdr.doc_date, 'dd/mm/yyyy') doc_date, hdr.req_by_store_code, rbys.short_desc req_by_store_desc, hdr.req_on_store_code, rons.short_desc req_on_store_desc, hdr.item_class_code, itm.short_desc item_class_desc, DECODE (request_status,'A', 'Authorized at Issue Store','P', 'Partially Issued',request_status) request_status ,hdr.facility_id facility_id FROM st_request_hdr hdr,st_request_dtl dtl, mm_store rbys, mm_store rons, mm_item_class itm, SY_DOC_TYPE_MASTER sy, st_store uaca, st_store uacb, st_acc_entity_param stpa, st_user_access_for_store uast ,mm_item_lang_vw mm WHERE hdr.doc_type_code = sy.doc_type_code AND HDR.DOC_TYPE_CODE =  DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND hdr.req_by_store_code = rbys.store_code AND hdr.req_on_store_code = rons.store_code AND hdr.item_class_code = itm.item_class_code(+) AND hdr.cancelled_by_id IS NULL    AND hdr.req_authorized_by_id IS NOT NULL AND (doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'dd/mm/yyyy') AND TO_DATE (NVL (?, '31/12/3012'), 'dd/mm/yyyy')) AND uaca.store_code = hdr.req_by_store_code AND uaca.iss_allowed_yn = 'Y' AND uacb.store_code = hdr.req_on_store_code AND uast.CANCEL_AUTHORIZE_ISS_ALLOW_YN = 'Y' AND uast.store_code = hdr.req_on_store_code AND uacb.req_allowed_yn = 'Y' AND hdr.request_status IN ('A', 'P','L') AND rons.facility_id = DECODE (stpa.trn_across_facility_yn, 'Y', rons.facility_id, ?) AND rbys.facility_id = DECODE (stpa.trn_across_facility_yn, 'Y', rbys.facility_id, ?) AND uast.USER_ID = ? and mm.language_id = ? and dtl.pending_item_qty > 0 and dtl.committed_item_qty > 0 ";
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
			
			
			sqlMap.put("sqlData",sql);
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
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
					<th width='150' align=center><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th width='80' align=center><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th width='100' align=center><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='150' align=center><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></th>
					<th width='150' align=center><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></th>
					<th width='150' align=center><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></th>
				<!-- <th width='3'>Cancel</th>   
					modified on Monday, July 26, 2004  -->
					
					<th width='100' align=center><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
						<input type="checkbox" value="Y" name="cancelAll" id="cancelAll"   onClick="return toggleCheck(formCancelAuthQueryResult);">
					</th> <!--  Modified on Monday, July 26, 2004 -->

					<th ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
					<th ><fmt:message key="Common.reason.label" bundle="${common_labels}"/> Details</th>
				</tr>		
		<%
			ArrayList records=new ArrayList();
			for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				if (recCount % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;

				
		%>
				<tr id="tr_<%=i%>">
		<%
				records				=		(ArrayList) result.get(recCount);
				  doctypecode   = "";
				  docno         = "";
				  facility_id   = "";
				  boolean hdr_disabled = false;
				  
				checked_ind			=		 Arrchkitem.indexOf(records.get(6)+"-"+records.get(1));
				checked				=		(checked_ind != -1 ? "checked":"");
				classvalue			=		(checked == ""?classvalue:"DATACHANGE");
				visibility				=		"visibility:hidden";
				if(checked.equals("checked"))
				visibility				=		"visibility:visible";
				
				String key				=		(String)records.get(6)+"-"+records.get(1);
				
				 doctypecode  =  (String)records.get(6);
				 docno        =  (String)records.get(1);
				 facility_id  =  (String)records.get(11);
				 
				 alItems = bean.loadData(facility_id,doctypecode,docno,item_code,item_desc);
				 int j=0;
						if(alItems.size()>0)
							exp_legend="+";  
						else
							exp_legend="-";

		%>
		           <td  onclick='javascript:expanddetails(this,tr_<%=i%>,<%=i%>)'  width='5%' align ='center'  class="<%=classvalue%>"><a id="view<%=i%>  href=''"><b><%=exp_legend%></b></a></td>
					
					<td class="<%=classvalue%>" onclick="disableClick(event);" align=center>
						<%=records.get(0)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" align=center >
						<%=records.get(1)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" align=center>
						<%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" align=center>
						<%=records.get(3)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" align=center>
						<%=records.get(4)%>
					</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" align=center>
						<%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%>
					</td>
						<td class="<%=classvalue%>" onclick="disableClick(event);"  title="<%=records.get(10)%>" align=center>

				 		<input type="checkbox" name="doc_<%=i%>" id="doc_<%=i%>"  id ="doc_<%=i%>" onClick="changeMyRowColor (<%=i%>,10,this)"  value="<%=records.get(6)%>~<%=records.get(1)%>~<%=records.get(11)%>" title="<%=records.get(10)%>"  <%=checked%>>											
					</td>		
				    <td class="fields">&nbsp;
					<select name="hed_remarks_code_<%=i%>" id="hed_remarks_code_<%=i%>"  onChange="defaultRemarksDesc(this,<%=i%>,'HDR','')" disabled> <%=bean.getMasterRemarks()%> </select>
					</td>
					<td>&nbsp;&nbsp;<textarea rows=2 cols=50 maxlength=100  name="hed_remarks_textarea_<%=i%>" id='hed_remarks_textarea_<%=i%>' onBlur="return checkLength(this,<%=i%>,'HDR','')" readonly></textarea></td>
					<input type="hidden" name="checked_yn_<%=i%>" id="checked_yn_<%=i%>"		value="" >
					<input type="hidden" name="details_<%=i%>" id="details_<%=i%>"			value="" >	
					<input type="hidden" name="rem_<%=i%>" id="rem_<%=i%>"               value="<%=trn_remarks%>">
					 
					
				 <tr  id ="item_dtls_<%=records.get(1)%>" >
				 <td colspan='12'>
				<table name ="tblItemList" id = "tblItemList_<%=i%>" border='1' width='60%' height = '20%'  cellpadding='0' cellspacing='0'   style="display:none;margin-left:2cm;border:1px solid black;" scrolling="auto">   
				<tr>
			    <th width="40%" style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
				<th width="10%"><fmt:message key="eST.IssQty.label" bundle="${st_labels}"/></th>
				<th width="10%"><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
				<th width="20%"><fmt:message key="Common.reason.label" bundle="${common_labels}"/> Details</th>
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
					CancelAuthorizationDetailBean detailBean;
					for (j=0;	j<totaldtlSize;	j++){
						detailBean = (CancelAuthorizationDetailBean) alItems.get(j);
						if (detailBean != null) {
					 
					 boolean line_disabled = false;
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
					  checked_item		=		AlDtlchkitems.indexOf(doctypecode+"-"+docno+"-"+detailBean.getItem_code());
				      checked		    =	   (checked_item != -1 ? "checked":"");
					   visibility		=		"visibility:hidden";
					   issue_item_qty   =      detailBean.getIssued_qty()==null?"0":detailBean.getIssued_qty();
					   commt_qty        =      detailBean.getComitted_item_qty()==null?"0":detailBean.getComitted_item_qty();
					   int iss_qty      =       Integer.parseInt(issue_item_qty);
					   int commited_qty =       Integer.parseInt(commt_qty);
					   if(iss_qty>0)
					      line_disabled =true;
					   if(commited_qty==0)
                          line_disabled =true;

					   if(line_disabled)
						   hdr_disabled =true;

				    if(checked.equals("checked")){
					   flag        =        true;
				       visibility  =		"visibility:visible";
					   }
					  }
					  String key_item				=		(String)doctypecode+"-"+docno+"-"+detailBean.getItem_code();
					         
							 
							 String   item_name = detailBean.getItem_desc();
							 
							 if(!item_name.equals("")){
					      item_name = item_name.replaceAll(" ","%20");
					      item_name = java.net.URLEncoder.encode(item_name,"UTF-8");
					      item_name = item_name.replaceAll("%2520","%20");
				          }
				%> 
				 <tr>  
				     <td  class="<%=className%>"   style="WORD-BREAK:BREAK-ALL;" ><font size=1><%=detailBean.getItem_desc()%></font></td>
					<input type = "hidden" name = "item_desc_<%=i%>_<%=j%>"  value = "<%=item_name%>">
					<input type = "hidden" name = "item_code_<%=i%>_<%=j%>"  value = "<%=detailBean.getItem_code()%>">
					<input type="hidden" name="doctypecode_<%=i%>_<%=j%>" id="doctypecode_<%=i%>_<%=j%>"	 	value="<%=records.get(6)%>">
				        <input type="hidden" name="docno_<%=i%>_<%=j%>" id="docno_<%=i%>_<%=j%>"	 	value="<%=records.get(1)%>">
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=bean.checkForNull(bean.setNumber(detailBean.getRequired_qty(),no_of_decimals),"&nbsp;")%>&nbsp;</td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right" ><%=bean.checkForNull(detailBean.getIssued_qty()).equals("")?"&nbsp;":bean.setNumber(detailBean.getIssued_qty(),no_of_decimals)%>&nbsp;</td>
					<td class="<%=className%>"><input type="checkbox" value="<%=records.get(6)%>~<%=records.get(1)%>~<%=detailBean.getItem_code()%>" id = "item_cancel_<%=i%>_<%=j%>" name ="item_cancel_<%=i%>_<%=j%>"   onClick="ItemCancel(<%=i%>,<%=j%>,this)"  <%=checked%>>&nbsp;</td> 
					<td class="fields">&nbsp;
					<select name="dtl_remarks_code_<%=i%>_<%=j%>" id="dtl_remarks_code_<%=i%>_<%=j%>"  onChange="defaultRemarksDesc(this,<%=i%>,'DTL',<%=j%>)" disabled> <%=bean.getMasterRemarks()%> </select>
					</td>
				   <input type="hidden" name="dtl_rem_<%=i%>_<%=j%>" id="dtl_rem_<%=i%>_<%=j%>"                value="">
				   <td>&nbsp;&nbsp;<textarea rows=2 cols=50 maxlength=100  name="dtl_remarks_textarea_<%=i%>_<%=j%>" id='dtl_remarks_textarea_<%=i%>_<%=j%>' onBlur="return checkLength(this,<%=i%>,'DTL',<%=j%>)" readonly ></textarea></td>

				   </tr> 

				   <script>disableHDR(<%=i%>,<%=j%>,<%=hdr_disabled%>,<%=line_disabled%>)</script>
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/CancelAuthorizationQueryResult.jsp", searched));
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

