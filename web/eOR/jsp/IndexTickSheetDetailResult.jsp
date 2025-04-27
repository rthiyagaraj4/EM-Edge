<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
09/10/2014	IN050655		VijayakumarK	09/10/2014							iASSIST ID : 807002 Index Tick sheet by practitioner is a 
																				good functionality to provide personalised tick sheets to practitioners.
------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%!int row_count=0;%>
<html>
<head>
	
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/IndexTickSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>

</head>
<%
	

	/* Mandatory checks start */
	int row_disp=7;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String bean_id = "indexticksheet" ;
	String bean_name = "eOR.IndexTickSheet";
	//String readOnly = "", status="E", key="";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="";

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	String pract_desc="", dispMode="", tabVal="";
	String diplayLabel="", pract_index="",index_type="",fac_id="";
	String order_category="", tick_sheet_id="", code="";
	//String status_db = "";
	String mode			=	request.getParameter("mode");
	pract_index			=	request.getParameter("pract_index");
	boolean stats = false;
	String update_val = "";
	//boolean alteredRecord = false, alteredDBRecord = false;
	String source_type = "";//IN050655
	
	eOR.Common.MultiRecordBean IndexSheetRecordSet		= new eOR.Common.MultiRecordBean();

	
	fac_id			=	request.getParameter("fac_id");
	tabVal			=	request.getParameter("tabVal");
	dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;
	
	order_category	=	request.getParameter( "order_category" ) ;
	tick_sheet_id	=	request.getParameter( "tick_sheet_id" ) ;

	diplayLabel	=	request.getParameter( "diplayLabel" ) ;

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(dispMode == null || dispMode.equals("null")) dispMode="";
	if(fac_id == null || fac_id.equals("null"))fac_id="";
	if(mode == null || mode.equals("null"))mode="";
	if(pract_index == null || pract_index.equals("null"))pract_index="";
	if(tabVal == null || tabVal.equals("null"))tabVal="";
	if(diplayLabel == null || diplayLabel.equals("null"))diplayLabel="";
	if(order_category == null || order_category.equals("null"))order_category="";
	if(tick_sheet_id == null || tick_sheet_id.equals("null"))tick_sheet_id="";	

	mode="1";
	if ( mode == null || mode.equals("") ) 
		return;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexTickSheet bean = (IndexTickSheet)getBeanObject( bean_id,  bean_name , request) ;  
	//bean.clear() ;
	//bean.setMode( mode ) ;
	/* Initialize Function specific end */
	
	//IN050655 starts
	//IN050655 - starts CRR changes updated
	String search_by 		= bean.checkForNull(request.getParameter("p_search_by"),"");
	String search_text 		= bean.checkForNull(request.getParameter("p_search_txt"),"");
	String filter_option 	= bean.checkForNull(request.getParameter("p_filter_opt"),"");
	String radioval			= bean.checkForNull(request.getParameter("p_radioval"),"");
	//IN050655 - ends CRR changes updated
	
	String param_desc = "";
	String param_code = "";
	
	if(filter_option.equals("S"))
	{
		if(radioval.equals("C"))
		{	
			param_desc = "%";
			if(search_by.equals("S"))
			{
				param_code = search_text + "%";
			}
			else if(search_by.equals("C")){
				param_code = "%"+search_text+"%";
			}
			else if(search_by.equals("E")){
				param_code = "%"+search_text;
			}
		}	
		else if(radioval.equals("D"))
		{	
			param_code = "%";
			if(search_by.equals("S"))
			{
				param_desc = search_text + "%";
			}
			else if(search_by.equals("C")){
				param_desc = "%"+search_text+"%";
			}
			else if(search_by.equals("E")){
				param_desc = "%"+search_text;
			}
		}
	}
	//IN050655 ends
	if(dispMode.equals("")){
		
		index_type   =	request.getParameter("index_type");
		source_type  =  request.getParameter("source_type");//IN050655
		if(index_type == null || index_type.equals("null"))index_type="";

		if(index_type.equals("S"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels");
		else if(index_type.equals("P"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
		//else if(index_type.equals("C"))
		else if(index_type.equals("F")){//IN050655
			if(source_type.equals("C"))//IN050655
				diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			//else if(index_type.equals("N"))//IN050655
			else if(source_type.equals("N"))//IN050655
				diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		}
		
		//out.println("<script>alert('order_category :"+order_category+"');</script>");
		//out.println("<script>alert('tick_sheet_id :"+tick_sheet_id+"');</script>");
		//out.println("<script>alert('index_type :"+index_type+"');</script>");
		//out.println("<script>alert('fac_id :"+fac_id+"');</script>");
//out.println("<script>alert('===="+order_category+"-"+tick_sheet_id+"----"+index_type+"----"+fac_id+"')</script>");
		//IN050655 starts
			//bean.fetchDBRecords(order_category,tick_sheet_id,index_type,fac_id );
			bean.fetchDBRecords(order_category,tick_sheet_id,index_type, source_type, fac_id );
		//IN050655 ends
		//int dbRecordCount		=  bean.fetchDBRecords(order_category,tick_sheet_id,index_type,fac_id );
		
		//out.println("<script>alert('dbRecordCount :"+""+dbRecordCount+"');</script>");
		if(tabVal.equals("S")){
		//IN050655 starts
			if(!filter_option.equals("S")){
			//IndexSheetRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(pract_index,index_type, fac_id, tabVal);
			IndexSheetRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(pract_index, index_type, source_type, fac_id, tabVal);
			}else{
			IndexSheetRecordSet		= (eOR.Common.MultiRecordBean)bean.getSearchRecordSet(param_code,param_desc,index_type,source_type, fac_id, tabVal);
			}
		//IN050655 ends
			row_count				=	IndexSheetRecordSet.getSize("SELECT");
		}else if(tabVal.equals("A")){
			IndexSheetRecordSet		=(eOR.Common.MultiRecordBean)bean.getBean();
			row_count				= IndexSheetRecordSet.getSize("DB");
		}
		
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		%>

		<script>
			if('<%=row_count%>' <= 0){
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");	
			//alert(msg);
			parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		</script>
		<%
	}
	else
	{
		
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){

			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			diplayLabel	= diplayLabel;
			
		}else if(dispMode.equals("Previous")){

			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
			diplayLabel	= diplayLabel;
		}
		
		
		if(to_val > (row_count-1))
			to_val=(row_count-1);

		IndexSheetRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();
	
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				IndexSheetRecordSet.setBeanValue(j,update_val);
				//alteredRecord = IndexSheetRecordSet.setBeanValue(j,update_val);
			}else if(tabVal.equals("A")){
				IndexSheetRecordSet.setDBBeanValue(j,update_val);
				//alteredDBRecord = IndexSheetRecordSet.setDBBeanValue(j,update_val);
			}
		}
			
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);

	}

	%>
	<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'>
	<form name="formIndexTickShDetailResult" id="formIndexTickShDetailResult">
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr width='10%'>
	<td class='WHITE' align="right">
	<%
/*
	out.println("start :"+start);
	out.println("row_disp :"+row_disp);
	out.println("row_count :"+row_count);
*/
	if ( (!(start <= 1)) && (start < row_count)){
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	<%	
	}

	if ( !( (start+row_disp) >= row_count ) ){
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
	<%
	}

	%>
	</td>
	</tr>
	</table> 
	<table class='grid' width='100%'>
	<th class='columnheader' width='75%' align="left"><%=diplayLabel%></th>
	<th class='columnheader' width='25%' align="left"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	<%
	try{
		if(tabVal.equals("S")){	
			for(int i=fm_disp; i<=to_disp; i++){

				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	IndexSheetRecordSet.getListObject(i);
										
				code				=	(String)	htListRecord.get("code");
				pract_desc			=	(String)	htListRecord.get("pract_desc");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");

				if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
				//status				=	(String)    htListRecord.get("status");
				stats  				=	IndexSheetRecordSet.containsObject(code);
				
				if(stats){
					valid = IndexSheetRecordSet.getValidKey(code);
				}

				/********************/
				if(valid.equals("Y")){
					checkValue="checked";
					disabled="disabled";
				}else{
					if(associate_yn.equals("Y")){
						checkValue="checked";
						disabled="";
					}else{
						if((stats)&&(associate_yn.equals("N"))){
							checkValue="checked";
							disabled="";
						}else{
							checkValue="";
							disabled="";
						}
					}
				}

				/**********************/
			
				//out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("stats :"+stats);
					
				tblrow_id	=	"tblrow_id"+i;

				%>
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' ><%=((pract_desc.equals(""))?"&nbsp;":pract_desc)%></td>
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> <%=disabled%>></td>
				</tr>
				<%
				}
			}else if(tabVal.equals("A")){
				for(int i=fm_disp; i<=to_disp; i++){
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	IndexSheetRecordSet.getObject(i);
										
				code				=	(String)	htListRecord.get("code");
				pract_desc			=	(String)	htListRecord.get("pract_desc");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				//status_db			=	(String)	htListRecord.get("status");


				//out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("status_db :"+status_db);

				tblrow_id	=	"tblrow_id"+i;

			
				if(valid.equals("N")){
					if(associate_yn.equals("Y"))
						checkValue="checked";
					else 
						checkValue="";
				}
				else{
					if(associate_yn.equals("D"))
						checkValue="";
					else 
						checkValue="checked";
				}
								
				%>
				<tr id='<%=tblrow_id%>'>
				<%if(valid.equals("Y")){%>
					<td class='<%=classValue%>' ><b><%=((pract_desc.equals(""))?"&nbsp;":pract_desc)%></b></td>
				<%}else{%>
					<td class='<%=classValue%>' ><%=((pract_desc.equals(""))?"&nbsp;":pract_desc)%></td>
				<%}%>
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y'  <%=checkValue%> ></td>
				
				</tr>
				<%
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception@2: "+e);
		}
	%>
	</table>
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value=<%=to%>>
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type='hidden' name='SelectYNStr' id='SelectYNStr' value="">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="diplayLabel" id="diplayLabel" value=<%=diplayLabel%>>
	<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="tabVal" id="tabVal" value=<%=tabVal%>>
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>"><!-- IN050655 -->
	</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


