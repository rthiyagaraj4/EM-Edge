<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title>Batch Details </title>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
         String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/SuspendOrReinstateBatch.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	    <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   </head>
<%
	String bean_id = "SuspendOrReinstateBatchBean" ;
	String bean_name = "eST.SuspendOrReinstateBatchBean";
		
	SuspendOrReinstateBatchBean bean = (SuspendOrReinstateBatchBean)getBeanObject( bean_id,  bean_name, request  );  
	//bean.setLanguageId(locale);
	//bean.clear() ;

	
	int displaySize = 0;
	int count = 0;
	String classvalue	= "";
	String item_desc	=   request.getParameter( "item_desc" )==null?"":request.getParameter( "item_desc" ) ;
	String batch_id     =   request.getParameter("batch_id").trim();
    String expiry_date  =    request.getParameter("expiry_date").trim();
	expiry_date		 =		com.ehis.util.DateUtils.convertDate(expiry_date,"DMY",locale,"en");
	String trade_name="";
	String manufacturer_name="";
	String qtyonhand="";
	String curr_facility	=		"";
	String prev_facility	=		"";
	String stStatus = "";
    String suspended = "";
    String batch_item = "";
    String st_batch = "";
	
	        if(bean.getBatch().equals("C")){
			 batch_item = "C";
			}else if(bean.getBatch().equals("S")){
			 batch_item = "Y";
			}else{
			 batch_item = "N";
			}
			
			 if(bean.getBatchStatusNotify().equals("C")){
			 st_batch = "C";
			}else if(bean.getBatchStatusNotify().equals("S")){
			 st_batch = "Y";
			}else{
			 st_batch = "N";
			}
	%>
	<body >
	<form name="SuspendOrReinstate_BatchDetail" id="SuspendOrReinstate_BatchDetail">
	<%
	
     try{
	          HashMap sqlMap				=		new HashMap();
			sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_SUSPEND_BATCH_DETAILS_QUERY"));
			 
			HashMap funcMap				=		new HashMap();
			ArrayList displayFields		=		new ArrayList();
			
			displayFields.add("BATCH_ID");
			displayFields.add("EXPIRY_DATE");
			displayFields.add("TRADE_NAME");
			displayFields.add("MANUFACTURER_NAME");
			displayFields.add("QTYONHAND");
			displayFields.add("AVAILQTY");
			displayFields.add("BATCH_STATUS");
			displayFields.add("STORE_CODE");
			displayFields.add("STORE_DESC");
			displayFields.add("FACILITY_NAME");
			displayFields.add("SUSPENDED_YN");
			
			
			ArrayList chkFields			=		new ArrayList();
			chkFields.add(locale);
			chkFields.add(bean.getItem_code());
			chkFields.add(batch_item);
			chkFields.add(st_batch);
			chkFields.add(bean.getManufacturer());
			chkFields.add(batch_id);
			chkFields.add(expiry_date);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(CommonBean.checkForNull(bean.getStore_code(),"%"));
			chkFields.add(CommonBean.checkForNull(bean.getFacility(),"%"));
			chkFields.add(bean.getLoginById());
			
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			
			 

			ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			int recCount=0,i = 0;
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
			%>
			
	           <table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center  style = "border:1px solid black;" scrolling="auto">
				<tr>
				<td colspan=10 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/>:</b> 
				<%=CommonBean.checkForNull((String)bean.getItem_code(),"")%>&nbsp;&nbsp;&nbsp; <%=CommonBean.checkForNull(item_desc,"")%></td>
				</tr>
				<tr>
				<td colspan=10 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>:</b> 
				<%=CommonBean.checkForNull(batch_id,"")%></td>
				</tr>
		   		<tr>
			  <td class='COLUMNHEADERCENTER'  style="TEXT-ALIGN:center" > </td>
		      <td class='COLUMNHEADERCENTER'  style="TEXT-ALIGN:center"   ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
		      <td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"   ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
		      <td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"   ><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></td>
		      <td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"   ><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></td>
		       <td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"   ><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>
		       <td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"  ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
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
				 
		       suspended		 = (String)records.get(10);
			   stStatus = "";
			  if(suspended.equals("C")){
				 stStatus =	"Notified";
			    }
	          else if(suspended.equals("Y"))
  		       stStatus = "Suspended" ;
			   
			   else if(suspended.equals("N"))
  		       stStatus = "" ;
			   
			    
			   
	           
			   curr_facility		=		(String)records.get(9);
				if(!curr_facility.equals("") && !curr_facility.equals(prev_facility))
				{%>
				<tr>
				<td colspan=10 align='left' class='ITEMSELECT'><font size=1><b> <fmt:message key="eST.Facility.label" bundle="${st_labels}"/> :</b>   <%=CommonBean.checkForNull((String)records.get(9),"")%></td>
				</tr>
				<%}%>
				
			 <td class="<%=classvalue%>" onclick="disableClick(event);" ><%=(String)records.get(8)%></td>
			 <td class="<%=classvalue%>" onclick="disableClick(event);" ><%=com.ehis.util.DateUtils.convertDate((String)records.get(1),"DMY","en",locale)%></td>
			 <td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(2)%></td>
			 <td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(3)%></td>
			 <td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(4)%></td>
			 <td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(5)%></td>
			 <td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull(stStatus,"&nbsp;")%></td>
 
		</tr>
	<%
		prev_facility=curr_facility;
	}
	
	%>
	
	  
	</table>
	<table  width="100%" >
 	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
		 
	<td align="right" colspan=8 ><input type=button name='canel' id='canel'  value='<fmt:message key="eST.Cancel.label" bundle="${st_labels}"/>' class='Button'  onClick="const dialogTag = parent.document.getElementById('dialog_tag'); dialogTag.close();"></td>
 
	  </tr>
	  </table>
	   
    <%
   out.flush();
	}
	else{
	%>
	<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA","Common" ));</script> 
	<%
	}
	}
	catch(Exception es){
es.printStackTrace();
	}
%>

</form> 
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

