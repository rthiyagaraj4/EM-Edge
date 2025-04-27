<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import ="eST.CancelCountSheetBean,java.util.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
			
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src="../../eST/js/CancelCountSheet.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body>
	<form name="formCancelCountSheetQueryResult" id="formCancelCountSheetQueryResult">
	<%
		String bean_id = "CancelCountSheetBean";
		String bean_name = "eST.CancelCountSheetBean";
		CancelCountSheetBean bean = (CancelCountSheetBean) getBeanObject( bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		//bean.clear( );	
		String mode = eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");			
				
		String phy_inv_id=request.getParameter("phy_inv_id")==null?"":request.getParameter( "phy_inv_id" ) ;
		String store_code = request.getParameter("store_code")==null?"":request.getParameter( "store_code" ) ;
		String item_code=request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String classvalue = "";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String curr_item_store="";
		String prev_item_store="";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));

			ArrayList result=(ArrayList)bean.queryResultDetails(facility_id,store_code,item_code,phy_inv_id);
			int recCount=0,i = 0;
			int cnt=result.size();
			if(result.size()>0){
	%>
	<div name='HeaderLabels' id='HeaderLabels' style='width:1010;overflow-x:no;overflow-y:no'>

			<table border="1" cellpadding="0" height='2' cellspacing="0" width="100%"  id='tb1'   >
				<tr>
					<td class='COLUMNHEADER' width='3%'>
					<td class='COLUMNHEADER' width='27%' ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER'  class='label' width='52%' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER'  class='label' width='80%'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER'  class='label' width='100%'> Cancel<input type='checkbox' name="item_chk" id="item_chk"  onclick="selectCheck(<%=cnt%>);" value="on"></td>
				</tr>
			</table>
			</div>
			<div name='RecordsDtl' id='RecordsDtl' style='width:1010;height:435;overflow-x:auto;overflow-y: auto'>

		<%
			HashMap records=new HashMap();
			for(recCount=0,i = 0; recCount<result.size(); recCount++,i++) {
				if (recCount % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;
		%>
				
		<%
				records=(HashMap) result.get(recCount);
		%>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1'  align=center >
					<tr id="tr_<%=i%>">
				
			<%
				
				curr_item_store=(records.get("STORE_DESC")).toString();
				if(!curr_item_store.equals(prev_item_store))
				{
				%>
					<td colspan=8  class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b> <!-- Modified for IN:074037  -->
					<%=(String)records.get("STORE_DESC")%>&nbsp;</td>
					</tr>
					<%
					}else{ }
					int colourDisplay = bean.colourReturn((String)records.get("ITEM_CODE"),phy_inv_id);	

					String colorDisp = "";
					if(colourDisplay==1){
						colorDisp = "RED";
					}else if(colourDisplay==2){
						colorDisp = "ORANGE";
					}else if(colourDisplay==3){
						colorDisp = "";
					}else if(colourDisplay==4){
						colorDisp = "GREEN";
					}
					%>
					<td bgcolor="<%=colorDisp%>" width='3%'></td>
					<td class="<%=classvalue%>" width='27%'><%=(String)records.get("ITEM_CODE")%></td>
					<td class="<%=classvalue%>"  width='52%'><%=(String)records.get("ITEM_DESC")%></td>
					<td class="<%=classvalue%>" width='80%'><%=(String)records.get("UOM")%></td>
					<td class="<%=classvalue%>"   width='100%'><input  type='checkbox'   <%=(records.get("SELECTED")).equals("Y")?"":"" %> id="t<%=i%>" name="t<%=i%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					
					<td class='NODISPLAY'><%=(String)records.get("STORE_CODE")%></td>
					
					<td class='NODISPLAY'><%=(String)records.get("PHY_INV_ID")%></td>
					
			</tr>
				<%
			prev_item_store=curr_item_store;
			}
		%>
		</table>
			</div>
		<input type="hidden" name="total_check_boxes" id="total_check_boxes" value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name%>">
		<input type="hidden" name="mode" id="mode" value="<%= mode%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type="hidden" name="count" id="count" value="<%=cnt%>">
		<input type="hidden" name="checkBoxVals" id="checkBoxVals">
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/CancelCountSheetQueryResult.jsp", searched));
	
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

