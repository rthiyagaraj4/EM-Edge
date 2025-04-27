<!DOCTYPE html>
<%@page  import ="java.util.HashMap,eOT.OTBillingBean,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.Common.CommonBean,webbeans.eCommon.ConnectionManager,eOR.OrderEntryBillingQueryBean,eCommon.XSSRequestWrapper,eOT.CheckInBean,eOT.Common.*,eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<%
	
	String ot_bean_id = "OTBillingBean";
	String ot_bean_name= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)mh.getBeanObject( ot_bean_id, request,ot_bean_name  ) ;
	String bean_id = "CheckInBean";
	String bean_name = "eOT.CheckInBean";
	CheckInBean chk_bean = (CheckInBean)mh.getBeanObject( bean_id, request, bean_name );
	String or_bean_id 						= "Or_billingQueryBean";
	String or_bean_name 					= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)mh.getBeanObject( or_bean_id,request, or_bean_name ) ;
%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/PreOperCheckIn.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		// Modified by DhanasekarV aginst remarks
		//var remarks_value=getLabel("Common.remarks.label","common");
		var remarks_value=getLabel("eOT.PreOperativeComments.Label","common");
	</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OperationDetail' id='OperationDetail'>
<%
	String called_from =checkForNull(request.getParameter("called_from"));
	String booking_num =checkForNull(request.getParameter("booking_num"));
	String bill_flag =checkForNull(request.getParameter("bill_flag"));
	String order_id =checkForNull(request.getParameter("order_id"));		
	String tab_name = checkForNull(request.getParameter("tab_name"));//50467
	String order_line_no="";
	String operation_code ="";
	String operation_desc ="";
	String side_applicable="";
	String side_applicable_desc="";
	String side_applicable_yn="";
	String remarks="";
	String result="";
	String  bill_str="";
	String  panel_str="";
	String  rate="";
	HashMap bill_info = new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
    String locale = (String)session.getAttribute("LOCALE"); 
	//String speciality_code="";
	StringBuffer collect_speciality_code=new StringBuffer();
	String speciality_code="";
	StringBuffer code=new StringBuffer();
	String arr[]=null;
	String ammendBooking = checkForNull(request.getParameter("ammendBooking"));
	String chkedRecsOrderIds = checkForNull(request.getParameter("chkedRecsOrderIds"));
   /* 
   System.out.println("====called_from====ChkListOperationDtls======="+called_from);
   System.out.println("====tab_name====ChkListOperationDtls======="+tab_name);
   System.out.println("====booking_num====ChkListOperationDtls======="+booking_num);
   System.out.println("====order_id====ChkListOperationDtls======="+order_id);
   System.out.println("====ammendBooking====ChkListOperationDtls======="+ammendBooking);
   System.out.println("====chkedRecsOrderIds====ChkListOperationDtls======="+chkedRecsOrderIds); */
   
	//Added Against ML-MMOH-CRF-1939-US4...starts
				
		String facility_id		= (String)session.getValue("facility_id") ;
		Connection conn = null;
		String fpp_category = "";
		String fpp_order_yn = "";
		String fpp_categoryDesc = "";
		String Include_Fpp_yn = "";
		boolean isIncludeFpp = false;
		Integer count =0;
		String bean_id2 = "OTCommonBean";
		String bean_name2 = "eOT.OTCommonBean";
		OTCommonBean ot_bean = (OTCommonBean)mh.getBeanObject( bean_id2, request, bean_name2 );
	
		//Added Against ML-MMOH-CRF-1939-US4...ends
	if(called_from.equalsIgnoreCase("OT_SLATE"))
		tab_name = checkForNull(request.getParameter("tab_name"));
	if(tab_name.equals("UNSCHEDULED"))
		called_from = "BOOKING";
	if(called_from.equals("OT_SLATE")){
		chk_bean.loadBookingDtlsBasedOnBooking(booking_num);
	}
	if(called_from.equals("BOOKING"))
	{
		//chk_bean.loadBookingDtlsBasedOnOrder(order_id);
		if(ammendBooking != null && chkedRecsOrderIds != null && ammendBooking.equals("Y") && chkedRecsOrderIds.trim().length() > 0)
			order_id = chkedRecsOrderIds;
		chk_bean.loadBookingDtlsBasedOnOrder(order_id);
	}

	HashMap operation_map = chk_bean.getOperationDtls();
%>
<table class='grid' border='1' cellpadding=3  cellspacing='0' width='100%' align='center'>
<th class='ColumnHeaderCenter' width='15%' nowrap> <fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/></td>
<th class='ColumnHeaderCenter'  width='30%' nowrap> <fmt:message key="Common.description.label" bundle="${common_labels}"/> </td>
<th class='ColumnHeaderCenter'  width='20%' nowrap><fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/></td>
<th class='ColumnHeaderCenter'  width='10%' nowrap><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/></td>
<%
	if(("true").equals(bill_flag))
	{
%>
<th class='columnHeaderCenter'  width='20%' nowrap><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>
<th class='columnHeaderCenter'  width='10%' nowrap></td>
<%		
	}
	HashMap  oper_dtls_map = new HashMap();
	int size = operation_map.size();
	String right_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RightSide.Label","ot_labels") ;
	String left_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LeftSide.Label","ot_labels") ;
	String bilateral_side = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Bilateral.Label","ot_labels") ;
	String not_applicable = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels") ;
	String classValue = "";

	//Added Against ML-MMOH-CRF-1939-US4...starts
	try{
		conn = ConnectionManager.getConnection(request);
			
		Include_Fpp_yn = ot_bean.getIncludeFpp(facility_id);
		System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
		isIncludeFpp = CommonBean.isSiteSpecific(conn,"OT","OT_FPP");
		//isIncludeFpp=true;
		System.err.println("isIncludeFpp --->"+isIncludeFpp);
			
		count = ot_bean.getFppIcon();
	}catch(Exception ex){
	System.err.println(ex);		
	}finally{
	ConnectionManager.returnConnection(conn, request);
	}
		//Added Against ML-MMOH-CRF-1939-US4...ends
	for (int i=1;i<=size;i++)
	{
		oper_dtls_map = (HashMap)operation_map.get(i+"");
		if(oper_dtls_map!=null && oper_dtls_map.size()>0)
		{
			operation_code=checkForNull((String) oper_dtls_map.get("operation_code"));
			operation_desc=checkForNull((String) oper_dtls_map.get("operation_desc"));
			side_applicable = checkForNull((String) oper_dtls_map.get("side_applicable"),"N");
			
			//Added Against ML-MMOH-CRF-1939-US4...starts
			ArrayList Fpplist = new ArrayList();
			Fpplist = billing_bean.getFPPDetails(operation_code);
			for (int j = 0; j < Fpplist.size(); j++){
			  if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
              if(j==1) fpp_category=checkForNull((String)Fpplist.get(j));
			}
			fpp_category=checkForNull((String) oper_dtls_map.get("fpp_category"));
			if("S".equals(fpp_category) || "M".equals(fpp_category) || "C".equals(fpp_category))
			{
					  //fpp_order_yn = "Y";
			if(fpp_category.equals("S")) fpp_categoryDesc ="Simple";
			if(fpp_category.equals("M")) fpp_categoryDesc ="Moderate";
			if(fpp_category.equals("C")) fpp_categoryDesc ="Complex";
			}
				  else
				  {
					  fpp_order_yn = "N";
				  }

			
			//Added Against ML-MMOH-CRF-1939-US4...ends
			
			switch(side_applicable.charAt(0))
			{
				case 'R': //R-Right
					side_applicable_desc =right_side;
					break;
				case 'L':  //L-Left
					side_applicable_desc =left_side;
					break;
				case 'B': //B-Bilateral
					side_applicable_desc =bilateral_side;
					break;
				default:   //N-Not Applicable
					side_applicable_desc =not_applicable;
					break;

			}
			order_line_no=checkForNull((String) oper_dtls_map.get("order_line_num")); 
			side_applicable_yn = checkForNull((String) oper_dtls_map.get("side_applicable_yn"));
			remarks=checkForNull((String) oper_dtls_map.get("remarks"));
			if(("true").equals(bill_flag))
			{
	        bill_info = or_bean.getOrderBillDtls(order_id+order_line_no);	
		   if((bill_info==null || bill_info.size()==0) && !called_from.equals("OT_MENU"))
			{
			   bill_info = new HashMap();
			    bill_info.put("key",order_id);
				bill_info.put("key_line_no",order_line_no);
				bill_info.put("oper_code",operation_code);
				bill_info.put("locale",locale);
				bill_info.put("module_id","OR");//after booking billing is done need to change.
				bill_info.put("quantity","1");
				bill_info.put("called_from",called_from);
				bill_info.put("fpp_category",fpp_category); //ML-MMOH-CRF-1939-US4
				bill_info = billing_bean.getCheckInBillingParams(bill_info,"S");
					System.err.println("bill_info in billing_bean OprDtls.jsp ->" + bill_info);//Sanjay
					System.err.println("bill_str total_payable	  -> " + bill_info.get("total_payable"));//Sanjay
					System.err.println("bill_str patient_payable  -> " +bill_info.get("patient_payable"));//Sanjay
					System.err.println("bill_str patient_paid_amt -> " +bill_info.get("patient_paid_amt"));//Sanjay
				or_bean.setOrderBillDtls(order_id+order_line_no,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
			}
               String overridden_incl_excl=null;
			   String overridden_action_reason_code=null;
			if("BOOKING".equals(called_from)||"OT_SLATE".equals(called_from))
			{
				panel_str=checkForNull((String) bill_info.get("bl_panel_str"));
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");				
					System.err.println("panel_str -> " +panel_str);//Sanjay
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("err_id"),""));
				bill_str = bl_bfr.toString();
					System.err.println("bill_str ->" + bill_str);//Sanjay
					System.err.println("bill_str total_payable	OT_SLATE   -> " + bill_info.get("total_payable"));//Sanjay
					System.err.println("bill_str patient_payable  OT_SLATE -> " +bill_info.get("patient_payable"));//Sanjay
					System.err.println("bill_str patient_paid_amt OT_SLATE -> " +bill_info.get("patient_paid_amt"));//Sanjay
				bl_bfr.setLength(0);
				oper_dtls_map.put("bill_str",bill_str);
				oper_dtls_map.put("panel_str",panel_str);
				oper_dtls_map.put("rate",rate);
				operation_map.put(""+i,oper_dtls_map);
			}
			panel_str=checkForNull((String)oper_dtls_map.get("panel_str")); 
			bill_str=checkForNull((String)oper_dtls_map.get("bill_str")); 
			rate=checkForNull((String)oper_dtls_map.get("rate")); 
			}// end of if(("true").equals(bill_flag)) condtion
			speciality_code=checkForNull((String) oper_dtls_map.get("speciality_code"));
			collect_speciality_code.append(speciality_code+",");
			result=operation_code+"::"+operation_desc+"::"+side_applicable+"::"+remarks+"::"+i+"::"+"U"+"::"+side_applicable_yn;
			code.append(operation_code+",");
			classValue=(i%2==0)?"gridData":"gridData";
	}//end of if 
	        if(("true").equals(bill_flag))
			{
				if(!bill_str.equals(""))
			 {
			arr=bill_str.split("::");
			 }
			else
			{
				  bill_str="0.0::0.0::0.0::N::null::N::L::null::null::";
				 arr=bill_str.split("::");
			 }
			}
  %>        
		  <tr>
			 <%
			if(called_from.equals("OT_MENU"))
			{
             %>
			<td class="<%=classValue%>" align='left'  nowrap>
			<input type="hidden" name="result<%=i%>" id="result<%=i%>" value="<%=result%>" >
				<a href="javascript:sendParams(<%=i%>);"> <%=operation_code%></a></td>
		   <%
			}
			else if(called_from.equals("OT_SLATE") || called_from.equals("BOOKING") )
			{
		    %>
			<td class='<%=classValue%>' class='ColumnHeaderCenter' class='fields' nowrap><%=operation_code%></td>
<%
			}
%>
			<input type="hidden" name="operation_desc<%=i%>" id="operation_desc<%=i%>" value="<%=operation_desc%>" >
			<td class="<%=classValue%>" align='left' class='fields' nowrap><%=operation_desc%></td>
			<td class="<%=classValue%>" class='ColumnHeaderCenter' class='fields'  nowrap>
				<%=side_applicable_desc%>
			</td>
			<input type="hidden" name="side_applicable_desc<%=i%>" id="side_applicable_desc<%=i%>" value="<%=side_applicable_desc%>" >
			<td class="<%=classValue%>" class='ColumnHeaderCenter' class='fields' nowrap>
				<input type="hidden" name="remarks<%=i%>" id="remarks<%=i%>" value="<%=remarks%>" >
				<a href="javascript:openDialogWindow(remarks_value,document.forms[0].remarks<%=i%>,'2000');" >
					<fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/> 	
				</a>
			</td>
<%
		String inclexcl="";
	        String approvalreqd="";
			if(("true").equals(bill_flag))
			{
			if(("S").equals(arr[6]))
			{
			if(("E").equals(arr[8]) ||("").equals(arr[8])) inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
			if(("I").equals(arr[8])) inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
			if(("Y").equals(arr[5])) approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
			if(("N").equals(arr[5])) approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
			}
			else
			{
			inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
			approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
			}
			}
		if(("true").equals(bill_flag))
		{
		%>
			<td class="<%=classValue%>" class='ColumnHeaderCenter' class='fields' nowrap >
			<div id="charge<%=i%>">
		<%if(isIncludeFpp  && count==1 && Include_Fpp_yn.equals("Y") && fpp_order_yn.equals("Y") && tab_name.equals("SCHEDULED")){%>
			<B><font color='Indigo' ><fmt:message key="eOT.FppCategory.Label" bundle="${ot_labels}"/>:&nbsp;<%=fpp_categoryDesc%>&nbsp;</font><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;<%=arr[0]%></font>&nbsp;<font color='crimson'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;<%=arr[1]%></font>&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:<%=arr[2]%></font></b><br><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/><%=inclexcl%><!--//Added Against ML-MMOH-CRF-1939-US4-->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%
		}else{
		%>
			<B></font><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;<%=arr[0]%></font>&nbsp;<font color='crimson'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;<%=arr[1]%></font>&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:<%=arr[2]%></font></b><br><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/><%=inclexcl%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<%
		}
		%>
				 
				 <fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/><%=approvalreqd%> 
			</div></td>
			<td class="<%=classValue%>" class='ColumnHeaderCenter' class='fields' nowrap><a href="javascript:callBillingWindow1(<%=i%>);"><img src='../../eOT/images/dollar.png'></img></a></td>
<%
		}
%>
		</tr>	
		<input type="hidden" name="operation_code<%=i%>" id="operation_code<%=i%>" value="<%=operation_code%>" > 
			<input type="hidden" name="side_applicable<%=i%>" id="side_applicable<%=i%>" value="<%=side_applicable%>" >
			<input type="hidden" name="side_applicable_yn<%=i%>" id="side_applicable_yn<%=i%>" value="<%=side_applicable_yn%>" >
			<input type="hidden" name="bill_st<%=i%>" id="bill_st<%=i%>" value="<%=bill_str%>" >
			<input type="hidden" name="order_line_num<%=i%>" id="order_line_num<%=i%>" value="<%=order_line_no%>" >
<%
	}
%> 
		
	
</table>	
<input type='hidden' name='code' id='code' value='<%=code.toString()%>' >
<input type='hidden' name='size' id='size' value='<%=size%>' >
<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>' >
<input type='hidden' name='booking_num' id='booking_num' value='<%=booking_num%>' >
<input type='hidden' name='collect_speciality_code' id='collect_speciality_code' value='<%=collect_speciality_code.toString()%>' >
<% code.setLength(0); %>
<% collect_speciality_code.setLength(0); %>
</form>
</body>
</html>

