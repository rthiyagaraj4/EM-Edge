<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.* , eCommon.Common.*, java.text.*, java.util.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title> </title>
		<meta name="Author" content="Rammohan">
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
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
	

    String disabled		=	"";
	String mode				=	"";
	ArrayList result=new ArrayList();
	String bean_id = "SuspendOrReinstateBatchBean" ;
	String bean_name = "eST.SuspendOrReinstateBatchBean";
		
	SuspendOrReinstateBatchBean bean = (SuspendOrReinstateBatchBean)getBeanObject( bean_id,  bean_name, request  );  
	bean.setLanguageId(locale);
	bean.clear() ;

	int maxRec=0; 
	int start = 0;
	int end  = 0;
	int displaySize = 0;
	int count = 0;
	String classvalue	= "";
	//String classvalueChange="";	
	String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String item_desc	= request.getParameter( "item_desc" )==null?"":request.getParameter( "item_desc" ) ;
    String uom_desc	    = request.getParameter( "uom_desc" )==null?"":request.getParameter( "uom_desc" ) ;


	//String Cost="";
	count	= start;
	//String deleteCheck="";
	//String deleteCheckVal="N";
	//String group_code ="";

	//String batch_status="";
	String batch_id="";
	String expiry_date="";
	String trade_name="";
	String manufacturer_name="";
	String qtyonhand="";
	String str_select="";
	//String flag_value="false";
   //Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  05-AUG-2013 Starts
	String facility_name    =       "";
	String store_desc       =      "";
	String item_code        =      "";
	String curr_store		=		"";
	String prev_store		=		"";
	String curr_facility	=		"";
	String prev_facility	=		"";
	String curr_item		=		"";
	String prev_item		=		"";
	String suspended_yn     = "";
	String curr_status = "";
	String prev_status = "";
	String  stStatus1 = "";
	String  stStatus_new = "";
	boolean check_status = false;
	int checked_value = 0;
	String availqty = "";
	 ArrayList alTemp = new ArrayList();
	  HashMap hmTemp = new HashMap();
	//ends
    String stStatus="";
	
	HashMap dataList	= null;
try{
	/* Mandatory checks start */
	mode	= request.getParameter( "mode" )==null?"":  request.getParameter( "mode" );
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	
	bean.setMode( mode ) ;
	
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
	
	}

	result=bean.getDataList();
	

	maxRec=  result.size();
		int no_of_decimals=bean.getNoOfDecimals();
		
	displaySize=maxRec;

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
	String store_code = CommonBean.checkForNull(bean.getStore_code());
	%>
	<body >
	<form name="SuspendOrReinstate_Detail" id="SuspendOrReinstate_Detail"  >
	<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>

	<tr align='right' width='10%'>
		<td class='WHITE'>
			<p align="right">
			<a href="javascript:goPrev();" id="prev"  style="visibility:hidden" ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a href="javascript:goNext();" id="next" style="visibility:hidden" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			</p>
		</td>
	</tr>
	</table>

	<%
	if(result.size() > 0 ){
	%>
	<div  style="position:relative;height:435px;overflow:auto">
<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center">
	<tr  style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
	<!--	
	* @Name - Priya
	* @Date - 19/02/2010
	* @Inc# - IN019466
	* @Desc - To align the headers in center . 					
	-->
		<td class='COLUMNHEADERCENTER'    style="TEXT-ALIGN:center"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/> </td>
		<td class='COLUMNHEADERCENTER'  style="TEXT-ALIGN:center"   ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"   ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"   ><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"   ><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></td>
		
		<td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"   ><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>
		
		<td class='COLUMNHEADERCENTER' style="TEXT-ALIGN:center"  ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<input type=checkbox name='selectAll' id='selectAll' onClick="changeStatusCheckBox(this);"></td>
		<td class='COLUMNHEADERCENTER'  style="TEXT-ALIGN:center"  ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER'  style="TEXT-ALIGN:center"  ><fmt:message key="Common.History.label" bundle="${common_labels}"/></td>
		<!-- <td class='COLUMNHEADERCENTER'    >&nbsp;</td> -->
		</tr>
	<%
	
	count	= start;
	int chkCount = 0;
    chkCount = request.getParameter("from")==null?0:Integer.parseInt(request.getParameter("from")) ;

//	ArrayList alSelectedTrays	=	bean.getAlSelectedTrays();
	while ( count < maxRec && count < end)
	{
			dataList = (HashMap)result.get(count);
			if ( count % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	
	
		batch_id		 = (String)dataList.get("BATCH_ID");
		expiry_date		 = (String)dataList.get("EXPIRY_DATE");
		trade_name = (String)dataList.get("TRADE_NAME");
		manufacturer_name	 = (String)dataList.get("MANUFACTURER_NAME");
		facility_name		 = CommonBean.checkForNull((String)dataList.get("FACILITY_NAME"),"");
		store_desc		     =   CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"");
		//suspended_yn		     =   CommonBean.checkForNull((String)dataList.get("SUSPENDED_YN"),"N");
		item_code		     =   CommonBean.checkForNull((String)dataList.get("ITEM_CODE"),"");
		 /** @ 
						 CRF_SRR20056-CRF-0537.1 
						qtyonhand for decimal
		**/ 
		if(bean.getAllowDecimalsYN((String)dataList.get("ITEM_CODE")).equals("Y")){

		qtyonhand		 = bean.setNumber((String)dataList.get("QTYONHAND"),no_of_decimals);
		availqty		 = bean.setNumber((String)dataList.get("AVAILQTY"),no_of_decimals);
		}else{
		qtyonhand		 = bean.setNumber((String)dataList.get("QTYONHAND"),0);
		availqty		 = bean.setNumber((String)dataList.get("AVAILQTY"),0);
		}
		str_select=(String)dataList.get("SELECTED");
        String stTempStatus = (String)dataList.get("BATCH_STATUS") ;
          stStatus = "";
		/*if(stTempStatus.equals("C"))
		  stStatus = "Notified" ;
		else if(stTempStatus.equals("S"))
  		  stStatus = "Suspended" ; */
		  
		  
		  alTemp = bean.getBatchSuspendStatus(item_code,batch_id,expiry_date);
		  
		  prev_status = "";
		  checked_value = 1;
		  
		   for(int j=0;j<alTemp.size();j++ ){
            hmTemp = (HashMap)alTemp.get(j);
			suspended_yn =  "";
			curr_status  =  "";
			stStatus1    =  "";
            suspended_yn =  (String)hmTemp.get("SUSPENDED_YN");
			
			if(suspended_yn.equals(prev_status)){
			   curr_status = suspended_yn;
			   stStatus1   = suspended_yn;
			   }
			 check_status = false;
			 prev_status  = suspended_yn;
		     if(curr_status.equals(prev_status))
			 checked_value++;
			 
			  suspended_yn = "";
             }
			 if(checked_value == alTemp.size())
			  check_status = true;
			 
			  if(stStatus1.equals("C"))
		       stStatus_new = "Notified" ;
		      else if(stStatus1.equals("Y"))
  		      stStatus_new = "Suspended" ;
		      else if(stStatus1.equals("N"))
  		       stStatus_new = "" ;
			   
               if(alTemp.size() == 1){			 
               hmTemp = (HashMap)alTemp.get(0);
			   
			   suspended_yn = "";
			   suspended_yn   =   (String)hmTemp.get("SUSPENDED_YN");
			  
		       if(suspended_yn.equals("C"))
		       stStatus = "Notified" ;
		      else if(suspended_yn.equals("Y"))
  		      stStatus = "Suspended" ;
		      else if(suspended_yn.equals("N"))
  		       stStatus = "" ;
		     }
        
if(!locale.equals("en"))
		{
	 expiry_date = com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);
		}
		

	//str_select=(String)alSelectedTrays.get(count);
	         //item_desc = java.net.URLEncoder.encode(item_desc,"UTF-8");
			 //java.net.URLDecoder.decode(item_desc,"UTF-8")
	%>
	
	     <!-- Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  05-AUG-2013 Starts -->
	            <% curr_facility		=		facility_name;
				if(!curr_facility.equals("") && !curr_facility.equals(prev_facility))
				{%>
				<tr>
				<td colspan=10 align='left' class='ITEMSELECT'><font size=1><b> <fmt:message key="eST.Facility.label" bundle="${st_labels}"/> :</b>   <%=CommonBean.checkForNull(facility_name,"")%></td>
				</tr>
				<%}
	               curr_store		=		store_desc;
				  if(!curr_store.equals("") && !curr_store.equals(prev_store))
				{%>
	            <tr>
				<td colspan=10 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.Store.label" bundle="${common_labels}"/>:</b> 
				<%=CommonBean.checkForNull(store_desc,"")%></td>
				</tr>
				<%}
					curr_item		=		item_code;
				  if(!curr_item.equals("") && !curr_item.equals(prev_item))
				{%>
				<tr>
				<td colspan=10 align='left' class='ITEMSELECT'><font size=1><b><fmt:message key="Common.item.label" bundle="${common_labels}"/>:</b> 
				<%=CommonBean.checkForNull(curr_item,"")%>&nbsp;&nbsp;&nbsp; <%=item_desc%></td>
				</tr>
			    <%}%>
				
		    <tr id="tr_<%=chkCount%>">
			<td class="<%=classvalue%>" onClick="DisplayBatchDetails(tr_<%=chkCount%>);" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><%=batch_id%></font></td>
			<td    class="<%=classvalue%>" ><%= expiry_date %></td>
			<td   class="<%=classvalue%>" ><%= trade_name %></td>
			<td    class="<%=classvalue%>" ><%= manufacturer_name %></td>
			 <!-- 					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Quantity on hand .				
					-->
			<td    class="<%=classvalue%>" style="TEXT-ALIGN:right"><%= qtyonhand %>&nbsp;</td>
			<td    class="<%=classvalue%>" style="TEXT-ALIGN:right"><%= availqty %>&nbsp;</td>
            <% if(suspended_yn.equals("C") || suspended_yn.equals("Y")|| suspended_yn.equals("N")) {%> 
      	      <td   style="TEXT-ALIGN:center" ><font class="DATAHIGHLIGHT"><%=stStatus%></font>&nbsp;</td>
            <% }else{%>
			
			 <%if(!check_status){%>
       	      <td class="<%=classvalue%>"  style="TEXT-ALIGN:center" title="For more information click on Batch Id hyperlink"><%=stStatus%><img  src='../../eST/images/info.gif' align="center"  ></img>&nbsp;</td>
			  <%}else{%>
			 
			 <td   style="TEXT-ALIGN:center" ><font class="DATAHIGHLIGHT"><%=stStatus_new%></font>&nbsp;</td>
             <% 
			    } 
             }%>
			 <!--<td     class="<%=classvalue%>" align="center" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  align="" name="checkbox<%=chkCount%>" id="checkbox<%=chkCount%>"   onClick="changeMyRowColor (<%=chkCount%>,10,this)" value="<%=str_select%>"  <%=str_select.equals("Y")?"checked":""%> onclick="assignValue(this);"    <%=disabled%> ></input></td> --> 
			
			<td     class="<%=classvalue%>"   style="TEXT-ALIGN:center"><input type="checkbox"  name="checkbox<%=chkCount%>" id="checkbox<%=chkCount%>"   onClick="changeMyRowColor (<%=chkCount%>,10,this)" value="<%=str_select%>"  <%=str_select.equals("Y")?"checked":""%> onclick="assignValue(this);"    <%=disabled%> ></input></td>
			
			<td  class="<%=classvalue%>"  onClick="showReason(tr_<%=chkCount%>,<%=chkCount%>);" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></td>
			<td   class="<%=classvalue%>" onClick="showHistory(tr_<%=chkCount%>,<%=chkCount%>);" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><fmt:message key="Common.History.label" bundle="${common_labels}"/></font></td>
         	<td class="NODISPLAY" ><%=item_desc%></td>
         	<td class="NODISPLAY" ><%=uom_desc%></td>
		</tr>
	<%
		count++;
		chkCount++;
		prev_facility=curr_facility;
		prev_store=curr_store;
		prev_item=curr_item;
	}
	%>
	
<%
	}
	else{
	%>
	<script>alert(getMessage( "NO_RECORD_FOUND_FOR_CRITERIA","Common" ));</script> 
	</table>
	<%
	
	}
	}
	catch(Exception es){
es.printStackTrace();
	}
%>

		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="start" id="start" value="<%=start%>">
		<input type="hidden" name="end" id="end" value="<%=end%>">
		<input type="hidden" name="totalRecords" id="totalRecords" value='<%=result.size()%>'>
		<input type="hidden" name="displaySize" id="displaySize" value="<%=displaySize%>">
		<input type="hidden" value="select" name="choosen_link" id="choosen_link">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="item_description" id="item_description" value="<%=item_desc%>">
		
	
	<script>
	maxRec = <%=maxRec%> ;
	displaySize = <%=displaySize%> ;
	end = <%=end%> ;
	start=<%=start%>;
	activeLink();
	</script>

		</form>
<%
putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>

