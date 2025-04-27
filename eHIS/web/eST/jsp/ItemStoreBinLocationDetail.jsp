<%@ page import =" java.sql.*, java.util.Properties, java.util.ArrayList,java.util.HashMap, eST.Common.StRepository, eCommon.Common.OptionValues,eST.Common.*, eST.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"> -->
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!--<script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/ItemStoreBinLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body >
	<form name="formItemStoreBinLocationDetail" id="formItemStoreBinLocationDetail">
	<%
	
	String mode								=		"";
	String bean_id							=		"";
	String bean_name						=		"";
	String bin_location_code				=		"";
	String short_desc						=		"";
	String Color							=		"";
	String store_code						=		request.getParameter("store_code");
	String item_code						=		request.getParameter("item_code");
	String bin_location_search_string		=		request.getParameter("bin_location_search_string");
	String bin_location_criteria			=		request.getParameter("bin_location_criteria");
	String from								=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to								=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String dispMode							=		request.getParameter( "dispMode" ) ;
	String chk								=		"";
	int  i									=		0;
	int  j									=		0;
	int start								=		0;
	int end									=		0;
	int displaySize							=		0;
	int count								=		0;
	bean_id									=		"ItemStoreBinLocationBean";
	bean_name								=		"eST.ItemStoreBinLocationBean";
	mode									=		request.getParameter( "mode" );
	if(dispMode==null) dispMode				=		"";
	String disabled							=       "";
	try{	

	if ( mode == null || mode.equals("") ) 
			return;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return;		
		
	ItemStoreBinLocationBean bean			=		(ItemStoreBinLocationBean)getBeanObject( bean_id,bean_name,request );  
	bean.setLanguageId(locale);
	
	count									=		start;
	int	 maxRecords							=		bean.getTotalCntRecords(store_code);
	if (bin_location_criteria.equals("S")) {
		bin_location_search_string		=		bin_location_search_string.trim()+"%";
	}
	else if (bin_location_criteria.equals("E")) {
		bin_location_search_string		=		"%"+bin_location_search_string.trim();
	}
	else{
		if (!bin_location_search_string.trim().equals("")) {
			bin_location_search_string	=		"%"+bin_location_search_string+"%";
		}
		else{
			bin_location_search_string	=		"%";
		}
	}
		boolean searched					=		false;
		
		//int recCount						=		0;
	
		
		ServletContext context				=		getServletConfig().getServletContext();
	

	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode(mode);
		bean.setStore_code(store_code);
		bean.setItem_code(item_code);
		bean.initExistingBin_location_code();
		displaySize							=		14;
		searched							=		(request.getParameter("searched") == null) ?false:true;
		

		if ( from == null || from =="" )
			start							=		0;
		else
			start							=		Integer.parseInt( from ) ;

		if ( to == null || to ==""){
			end								=		displaySize ;
		}
		else{
			end								=		Integer.parseInt( to ) ;	
			}
		String className					=		"";
		String checked						=		"";
		

		ArrayList alSelectedBin_location_code	=		bean.getSelectedBin_location_code();
		
		ArrayList alExistingBin_location_code	=		bean.getBin_location_code();
		ArrayList result						=		bean.getResultPage(store_code,bin_location_search_string);
		
		if(result.size()>0 ){
		
		%>
		<table cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
		<tr align='right' width='10%'>
		<td class='WHITE'>
			<p align="right">
			<a href="javascript:goPrev('select');" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNext('select');" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>
			
			<table border="1" cellpadding="0" cellspacing="0" width="95%" align=center>
			<tr>
				<th ><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> </th>
			</tr>
			<%
				
				String noDisplay			=		"";
				String highlight			=		"";
				
				i								=		start;
				j								=		start*2;
					
				
				while ( i < result.size()/2  && i < end)
				{
				
					if ( i % 2 == 0 )
						className			=		"QRYEVEN";
					else
						className			=		"QRYODD";
			%>																		
			<tr>
			<%
		
				bin_location_code			=		(String)result.get(j);
				short_desc					=		(String)result.get(++j);	
				
				if (alSelectedBin_location_code.contains(bin_location_code)) {
					checked					=		"checked";
				}
				else {
					checked					=		"";
				}
				if (alExistingBin_location_code.contains(bin_location_code)) {
					String eff_status		=		bean.getEffStatus(store_code,item_code,bin_location_code);
					noDisplay				=		"";
				
					if(eff_status.equals("Y")){
					checked					=		"checked";
					highlight				=		"DATAHIGHLIGHT";
					Color					=		"DATAHIGHLIGHT";
					}
					else{
					checked					=		"";
					highlight				=		"DATAHIGHLIGHT";
					Color					=		"";
					}
				}
				else {
					noDisplay				=		"";
					highlight				=		"";
					Color					=		"";
				}
				 try{
				
				
				HashMap hmData				=		bean.getData();
				if(hmData!=null && hmData.size()==1){
					HashMap hmRecord =(HashMap)hmData.get(item_code+store_code);
					
					if((String)hmRecord.get("BIN_LOCATION_CODE_"+i)!=null){
					if(((String)hmRecord.get("BIN_LOCATION_CODE_"+i)).equals(bin_location_code))
					{
						
						if(((String)hmRecord.get("EFF_STATUS_"+i)).equals("Y"))
						{
					
						checked					=		"checked";
							
						}
						else{
							checked					=		"";
							
						}

					}
					
				}
				}
			
				 }
				catch(Exception e)
					{
					e.printStackTrace();
					} 
				
		     

    	int BinlocationStatus		=bean.getBinlocationStatus(store_code,item_code,bin_location_code);
		 if(BinlocationStatus==1)
					{
			    disabled ="disabled";
					}
			else  if(BinlocationStatus==0){
				  disabled="";
			}
		 

		//String disable="SELECT COUNT(*) FROM st_item_store WHERE item_code = 'DD' AND store_code = 'PHSPCS' AND bin_location_code ='BIN2_002' AND eff_status = 'E'";


			%>
				<td class="<%=className%>"><font class='<%=Color%>'><%=short_desc%></font></td>
				<td class="<%=className%>" > <input type="checkbox" name="add_bin_location_<%=i%>" id="add_bin_location_<%=i%>" value="<%=bin_location_code%>" <%=checked%> <%=chk%> <%=disabled%> class='<%=noDisplay%>' onClick='checkStock("<%=i%>");alterBean(this,"<%=i%>")' > </td>
			</tr>

				<input type="hidden"	name="remove_bin_location_<%=i%>" id="remove_bin_location_<%=i%>"		value="<%=bin_location_code%>">
				<input type="hidden"	name="eff_status_<%=i%>" id="eff_status_<%=i%>"				value="">
				<input type="hidden"	name="highlight_<%=i%>" id="highlight_<%=i%>"					value="<%=highlight%>">
				<input type="hidden"	name="db_action_<%=i%>" id="db_action_<%=i%>"					value="">
				<input type="hidden"	name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>"			value="">
				
			<%i++;
			j++;
				}
				
				//out.flush();
				putObjectInBean(bean_id,bean,request);
				}
				else{
			%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				parent.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader.store_code.disabled					= false;
				parent.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader.item_desc.disabled					= false;
				parent.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader.item_search.disabled					= false;
				parent.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader.bin_location_criteria.disabled		= false;
				parent.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader.bin_location_search_string.disabled  = false;
				parent.frameItemStoreBinLocationHeader.document.formItemStoreBinLocationHeader.search.disabled						= false;
				self.location.href="../../eCommon/html/blank.html"
				</script>
			  <%}%>
				</table>
				<input type="hidden"	name="mode" id="mode"						value="<%=mode%>">
				<input type="hidden"	name="bean_id" id="bean_id"					value="<%=bean_id%>">
				<input type="hidden"	name="bean_name" id="bean_name"				value="<%=bean_name%>">
				<input type="hidden"	name="stock_status" id="stock_status"			value="">
				<input type="hidden"	name="start" id="start"					value="<%=start%>">
				<input type="hidden"	name="end" id="end"						value="<%=end%>">
				<input type="hidden"	name="displaySize" id="displaySize"				value="14">
				<input type="hidden"	name="choosen_link" id="choosen_link"				value="select">
				<input type="hidden"	name="total_records" id="total_records"			value="<%=result.size()/2%>">
				<input type="hidden"	name="total_bin_codes" id="total_bin_codes"			value="<%=i%>">
				<input type="hidden"	name="checked_yn" id="checked_yn"				value="N"	>
				<input type="hidden"	name="select_all" id="select_all"				value="">
				 <input type="hidden"	name="count" id="count"					value="">
			
				<%
if(dispMode.equals("")){
%>
	<script>
		maxRecords = <%=maxRecords%> ;
		if(maxRecords>0)
		activeLink();
	</script>
<%
}
	else{
	%>
	<script>
		maxRecords = <%=maxRecords%> ;
		if(maxRecords>0)
		activeLink();
	</script>
<%
	}
%>		<%
		//out.println(CommonBean.setForm ( request ,"../../eST/jsp/ItemStoreBinLocationDetail.jsp", searched) );
	%>
	
					</table>
				</form>
			<%
			}
			catch(Exception e){
				e.printStackTrace();
			}

			 %>
	<script>
		var selectall=0,i=0,cnt=0,loop=14;
			cnt		=		document.formItemStoreBinLocationDetail.end.value;
		if(document.formItemStoreBinLocationDetail.end.value>document.formItemStoreBinLocationDetail.total_records.value)
		{		cnt		=		document.formItemStoreBinLocationDetail.total_records.value;
		}
		
		for (i = document.formItemStoreBinLocationDetail.start.value;i<cnt;i++) {
			if(eval("document.formItemStoreBinLocationDetail.add_bin_location_"+i)!=null){
		if(eval("document.formItemStoreBinLocationDetail.add_bin_location_"+i+".checked"))selectall++;
			if(cnt==document.formItemStoreBinLocationDetail.total_records.value)count++;
		
		}
		}
		/*if(selectall==loop){
			document.formItemStoreBinLocationDetail.selectAll.value		=	"Y";
			document.formItemStoreBinLocationDetail.selectAll.checked		=	true;
		}
		
		else {*/
			var count=0;
			if(cnt==document.formItemStoreBinLocationDetail.total_records.value)
			{for (i = document.formItemStoreBinLocationDetail.start.value;i<cnt;i++) {
				if(cnt==document.formItemStoreBinLocationDetail.total_records.value){
				
					count++;
				}
			}
			/*if(selectall==count){
				document.formItemStoreBinLocationDetail.selectAll.value	=	"Y";
				document.formItemStoreBinLocationDetail.selectAll.checked	=	true;}
			}
		else{
			document.formItemStoreBinLocationDetail.selectAll.value		=	"N";
			document.formItemStoreBinLocationDetail.selectAll.checked		=	false;}*/
		}
		</script>
		<script>
			getTotalCheckBoxes(document.formItemStoreBinLocationDetail.total_bin_codes);
		</script>
	</body>
</html>

