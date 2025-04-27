<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
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
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/IndexOrderCareSet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	int row_disp=14;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String bean_id = "indexordercareset" ;
	String bean_name = "eOR.IndexOrderCareSetBean";
	//String readOnly = "";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="";//String key="";

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	String pract_desc="", dispMode="", tabVal="";
	String diplayLabel="", pract_index="",index_type="",fac_id="",chkflag="";
	String order_category="", care_set_id="", code="";
	//String status="E";
	//String status_db = "";
	String mode	= request.getParameter("mode");
	pract_index	= request.getParameter("pract_index");
	boolean stats = false;
	String update_val = "";
	//boolean alteredRecord = false, alteredDBRecord = false;

	eOR.Common.MultiRecordBean IndexSheetRecordSet = new eOR.Common.MultiRecordBean();
	
	fac_id			=	request.getParameter("fac_id");
	tabVal			=	request.getParameter("tabVal");
	dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter("from" ) ;
	to				=	request.getParameter("to" ) ;
	order_category	=	request.getParameter("order_category" ) ;
	care_set_id		=	request.getParameter("care_set_id" ) ;
	diplayLabel		=	request.getParameter("diplayLabel" ) ;
	chkflag			=	request.getParameter("chkflag" ) ;


	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(dispMode == null || dispMode.equals("null"))		dispMode="";
	if(mode == null || mode.equals("null"))		mode="";
	if(pract_index == null || pract_index.equals("null"))	pract_index="";
	if(tabVal == null || tabVal.equals("null"))		tabVal="";
	if(diplayLabel == null || diplayLabel.equals("null"))	diplayLabel="";
	if(order_category == null || order_category.equals("null"))	order_category="";
	if(care_set_id == null || care_set_id.equals("null"))	care_set_id="";	
	if(fac_id == null || fac_id.equals("null"))		fac_id="";

	mode="1";
	if ( mode == null || mode.equals("") ) 
		return;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || 	mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexOrderCareSetBean bean = (IndexOrderCareSetBean)getBeanObject( bean_id, bean_name, request ) ;  
	/* Initialize Function specific end */
	
	if(dispMode.equals("")){
		
		index_type   =	request.getParameter("index_type");
		if(index_type == null || index_type.equals("null"))index_type="";

		if(index_type.equals("S"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels");
		else if(index_type.equals("P"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
		else if(index_type.equals("D"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels");
		else if(index_type.equals("C"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		else if(index_type.equals("N"))
			diplayLabel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		
//out.println("<script>alert('===="+care_set_id+"-----"+index_type+"----"+fac_id+"')</script>");
		//int dbRecordCount = bean.fetchDBRecords(care_set_id,index_type,fac_id );
		bean.fetchDBRecords(care_set_id,index_type,fac_id );

		if(tabVal.equals("S"))
		{
			IndexSheetRecordSet	= (eOR.Common.MultiRecordBean)bean.getRecordSet(pract_index,index_type, fac_id, tabVal );	
			row_count = IndexSheetRecordSet.getSize("SELECT");
		}else if(tabVal.equals("A"))
		{	
			IndexSheetRecordSet = (eOR.Common.MultiRecordBean)bean.getBean();
			row_count = IndexSheetRecordSet.getSize("DB");
		}
	
		fm_disp	= 0;
		to_disp	= (row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		%>

		<script>
			if('<%=row_count%>' <= 0){
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'common');	
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
	<form name="form_index_care_set_detail_result" id="form_index_care_set_detail_result">
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr width='10%'>
	<td class='WHITE' align="right">
	<%
	if ((!(start <= 1)) && (start < row_count)){
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
	<td class='columnheader' width='75%'><%=diplayLabel%></td>
	<td class='columnheader' width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
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
	<input type="hidden" name="chkflag" id="chkflag" value="<%=chkflag%>">
	</form>
</body>
</html>


<%
		putObjectInBean(bean_id,bean,request);
 
%>


