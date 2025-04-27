<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*, java.sql.*, java.util.Properties, java.util.ArrayList,java.util.HashMap, ePO.Common.PoRepository, eCommon.Common.OptionValues,ePO.Common.*, ePO.* ,java.sql.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoTransactionRemarks.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<center>
	<form name="frmPoTransactionRemarksDetail" id="frmPoTransactionRemarksDetail" >
<%
	HashMap data							=		new HashMap();
	String mode								=		request.getParameter( "mode" );
	String bean_id							=		"poTransactionRemarksBean";
	String bean_name						=		"ePO.PoTransactionRemarksBean";
	String remarks_code						=		"";
	String short_desc						=		"";
	String PreviousListValueExit			=		"";
	String master_type						=		request.getParameter("master_type");
	String from								=		request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to								=		request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String dispMode							=		request.getParameter( "dispMode" ) ;

	boolean searched						=		false;
	if(dispMode==null) dispMode				=		"";
	int  i									=		0;
	int  j									=		0;
	int start								=		0;
	int end									=		0;
	int displaySize							=		0;
	int count								=		0;
	count									=		start;
	
	try{
		if ( mode == null || mode.equals("") ) 
			return;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return;			

		PoTransactionRemarksBean bean			=		(PoTransactionRemarksBean)getBeanObject( bean_id,bean_name,request );  
		bean.setLanguageId(locale);
		bean.setMaster_Type(master_type);
		bean.loadRemarks();

		String classValue					=		"";
		String checked						=		"";
		String noDisplay					=		"";
		String highlight					=		"";
		String Color						=		"";
		ArrayList selectedRemarks			=		bean.getSelectedRemarks();
		ArrayList processedRemarks			=		bean.getRemarks();
		int	 maxRecords						=		bean.getTotalRecords();
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
		ArrayList result					=		bean.getResultPage();
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
				<th ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type=checkbox name='selectAll' id='selectAll' onClick="changeStatusCheckBox(this);" value="N"></th>
			</tr>
			<%
				i								=		start;
				j								=		start*2;

				data							=		bean.getData();
				String key_value				=		(String)data.get("MASTER_TYPE");
				HashMap hmRecord				=	null;
				while ( i < maxRecords  && i < end)
				{
					if ( i % 2 == 0 )
						classValue				=		"QRYEVEN" ;
					else
						classValue				=		"QRYODD" ;
			%>																		
			<tr>
			<%
				remarks_code					=		(String)result.get(j);		
				short_desc						=		(String)result.get(++j);		
		
				if (selectedRemarks.contains(remarks_code)) {
					checked						=		"checked";
				}
				else {
					checked						=		"";
				}
				if (processedRemarks.contains(remarks_code)) {
				highlight						=		"Y";
				if(bean.isRemarkChecked(remarks_code)){
					checked						=		"checked";
					Color						=		"DATAHIGHLIGHT";
				}
				else {
					checked						=		"";
					Color						=		"";
				}
		
				}
				else {
					checked						=		"";
					highlight					=		"";
					Color						=		"";
					
				}
				if((data.get((bean.getMaster_Type())))!=null){
			
				if(key_value.equals(bean.getMaster_Type()))
				{
					hmRecord						=		(HashMap)data.get(bean.checkForNull(bean.getMaster_Type()));
					String hmRecord_remarks_code	=		(String)hmRecord.get("REMARKS_CODE_"+i);
					String hmRecord_eff_status		=		(String)hmRecord.get("EFF_STATUS_"+i);
					
					if(hmRecord_remarks_code!=null){
						if(hmRecord_remarks_code.equals(remarks_code)){

							if(hmRecord_eff_status!=null){
								if(hmRecord_eff_status.equals("E"))
									checked						=		"checked";
								else
									checked						=		"";
							}
							

					}}
					

				}}
				
			%>
				<td class="<%=classValue%>"><font class='<%=Color%>'><%=remarks_code%></font></td>
				<td class="<%=classValue%>"><font  class='<%=Color%>'><%=short_desc%></font></td>
				<td class="<%=classValue%>"><input type="checkbox" name="remarks_code_<%=i%>" id="remarks_code_<%=i%>" value="<%=remarks_code%>" <%=checked%> class='<%=noDisplay%>' onClick='alterBean(this,"<%=i%>")'> </td>
			</tr>
				<input type="hidden"	name="remove_remarks_code_<%=i%>" id="remove_remarks_code_<%=i%>"		value="<%=remarks_code%>">
				<input type="hidden"	name="eff_status_<%=i%>" id="eff_status_<%=i%>"				value="">
				<input type="hidden"	name="highlight_<%=i%>" id="highlight_<%=i%>"					value="<%=highlight%>">
				<input type="hidden"	name="db_action_<%=i%>" id="db_action_<%=i%>"					value="">
			<%i++;
			j++;
			if(selectedRemarks.contains("E"))
				PreviousListValueExit="Y";
			else
			PreviousListValueExit="N";
				}
				out.flush();
				putObjectInBean(bean_id,bean,request);
			%>
				</table>	
				<input type="hidden"	name="total_records" id="total_records"			value="<%=result.size()/2%>">
				<input type="hidden"	name="total_remarks" id="total_remarks"			value="<%=i%>">
				<input type="hidden"	name="mode" id="mode"						value="<%=mode%>">
				<input type="hidden"	name="bean_id" id="bean_id"					value="<%=bean_id%>">
				<input type="hidden"	name="bean_name" id="bean_name"				value="<%=bean_name%>">
				<input type="hidden"	name="canProcess" id="canProcess"				value="<%=bean.hasRecords()%>">
				<input type="hidden"	name="PreviousListValueExit" id="PreviousListValueExit"	value="<%=PreviousListValueExit%>">
				<input type="hidden"	name="checked_yn" id="checked_yn"				value="N"	>
				<input type="hidden"	name="count" id="count"					value=""	>
				<input type="hidden"	name="start" id="start"					value="<%=start%>">
				<input type="hidden"	name="end" id="end"						value="<%=end%>">
				<input type="hidden"	name="master_type" id="master_type"				value="<%=master_type%>">
				<input type="hidden"	name="displaySize" id="displaySize"				value="14">
				<input type="hidden"	name="choosen_link" id="choosen_link"				value="select">
				<input type="hidden"	name="selectall" id="selectall"				value="">
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
%>			
				</form>
			<%
			}
			catch(Exception e){
				e.printStackTrace();
			}

			 %>
</table>
	<%
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/PoTransactionRemarksDetail.jsp", searched) );
	%>
</center>
			
<script>
gettotalcheckBoxes(document.frmPoTransactionRemarksDetail.total_remarks);
</script>
<script>
		var selectall=0,i=0,cnt=0,loop=14;
			cnt		=		document.frmPoTransactionRemarksDetail.end.value;
		//if(document.frmTransactionRemarksDetail.end.value>document.frmTransactionRemarksDetail.total_records.value)
	     if(parseInt(document.frmPoTransactionRemarksDetail.end.value)>parseInt(document.frmPoTransactionRemarksDetail.total_records.value))
		{		
		cnt		=		document.frmPoTransactionRemarksDetail.total_records.value;
		}
		
		for (i = document.frmPoTransactionRemarksDetail.start.value;i<cnt;i++) {
		if(eval("document.frmPoTransactionRemarksDetail.remarks_code_"+i+".checked"))selectall++;
			if(cnt==document.frmPoTransactionRemarksDetail.total_records.value)count++;
		
		}
			
		if(selectall==loop){
			document.frmPoTransactionRemarksDetail.selectAll.value		=	"Y";
			document.frmPoTransactionRemarksDetail.selectAll.checked		=	true;
		}
		
		else {
			var count=0;
			if(cnt==document.frmPoTransactionRemarksDetail.total_records.value)
			{for (i = document.frmPoTransactionRemarksDetail.start.value;i<cnt;i++) {
				if(cnt==document.frmPoTransactionRemarksDetail.total_records.value){
				
					count++;
				}
			}
			if(selectall==count){
				document.frmPoTransactionRemarksDetail.selectAll.value	=	"Y";
				document.frmPoTransactionRemarksDetail.selectAll.checked	=	true;}
			}
		else{
			document.frmPoTransactionRemarksDetail.selectAll.value		=	"N";
			document.frmPoTransactionRemarksDetail.selectAll.checked		=	false;}
		}
		</script>
</body>
</html>

