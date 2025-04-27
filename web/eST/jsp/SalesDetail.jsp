<!DOCTYPE html>
<!-- --------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
15/10/2019		IN071552			Shazana Hasan							TBMC-SCF-0099 
---------------------------------------------------------------------------------------------------------------
 -->

<%@page contentType="text/html;charset=UTF-8"  import=" eST.SalesBean,java.util.HashMap,java.util.ArrayList,java.util.StringTokenizer"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language='JavaScript' src='../../eCommon/js/showModalDialog.js' ></script>
		<script language="JavaScript" src="../../eST/js/Sales.js"></script>
<%
	try{
	int i						=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String store_code			=		"";
	String avail_qty			=		"";
	String pat_net_amt			=		"";
	String paid_amt				=		"";
	String gross_charge_amt		=		"";
	String kit12				=		(String)request.getParameter("kit12")==null?"":(String)request.getParameter("kit12");
	HashMap ExpDtl				=		new HashMap();
	ArrayList alDetailData		=		new ArrayList();
	int EWDays					=	    0;
	String view_cost_yn			=		"";
	String bl_install_yn		=		"N";
	String billable_item_yn		=		"N";
	int expired_batch			=		0 ;
	mode						=		request.getParameter( "mode" ) ;
	if(mode==null){	mode		=		"1";}
	function_id					=		request.getParameter( "function_id" ) ;
	
	bean_id						=		"salesBean" ;
	bean_name					=		"eST.SalesBean";

	SalesBean bean				=		(SalesBean) getBeanObject( bean_id, bean_name,request  );  
	bean.setLanguageId(locale);

	
	
	
	String BARCODE_YN					=		request.getParameter("BARCODE_YN")==null?"FALSE":request.getParameter("BARCODE_YN");
	
	//System.out.println("BARCODE_YN===>"+BARCODE_YN);

	if (BARCODE_YN.equals("TRUE"))
	alDetailData		=		bean.getDtlRecordsforBarCode();
	else
	alDetailData		=		bean.getDtlRecords();
	//System.out.println("alDetailData---------60--->"+alDetailData);
	store_code					=		bean.getStore_code();
    String temp					=		request.getParameter("arr")==null?"":request.getParameter("arr");
	java.util.StringTokenizer st =		new java.util.StringTokenizer(temp,",");
	ArrayList arr				 =		new ArrayList();
	
	while( st.hasMoreElements()){
			arr.add(st.nextElement() );
	}
	if(alDetailData.size()>0){
		view_cost_yn			=		(String)bean.getAccessCostDetails();
		bl_install_yn			=		(String)bean.getBLModuleInstalled();
		EWDays					=		bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));

	if (BARCODE_YN.equals("TRUE"))
		ExpDtl					=		bean.getExpRecordsforBarCode();
	else
		ExpDtl					=		bean.getExpRecords();
	}
%>

	</head>
<body>
<form name='formSalesDetail' id='formSalesDetail' >
	<table border='1' cellpadding='0' cellspacing='0' width=300 align="center" >
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/> </th>

	<%
	ArrayList alTemp			=	new ArrayList();
	String display_flag			=	"visibility:hidden";
	HashMap ht					=	null;
	HashMap hmTemp				=	null;
	HashMap rol_min				=	null;
/*Code added for SRR walk-thru on 3/3/2010*/
	StringTokenizer stRecordsToDelete	=	new StringTokenizer(bean.getRecords_to_delete(),",");
	String deleted				=		"";
	String chk_disabled         =       "";
/*Code added for SRR walk-thru on 3/4/2010*/
	String fontClass			=	"HYPERLINK";
	String curChange			=	"changeCursor(this);";
/*Code ended*/
	//System.out.println("alDetailData.size()===>"+alDetailData.size());
	for(i=0;i<alDetailData.size();i++)
	{
		String classValue		=		"";
		if(view_cost_yn.equals("Y"))
			display_flag		=		"visibility:visible";
			ht			=		(HashMap)alDetailData.get(i);
			//System.out.println("ht===109===>" +ht);
		if(i%2==0)classValue	=		"QRYEVEN";
		else	  classValue	=		"QRYODD";
			if((((String)ht.get("expiry_yn")).equals("XX"))||bean.checkForNull(((String)ht.get("item_unit_cost"))).equals("")||((String)ht.get("stock_available")).equals("0")){
				if(stRecordsToDelete.hasMoreTokens()){
					stRecordsToDelete.nextToken();
				}
%>			
			<tr id="tr_<%=i%>">

				<td align='center' width='1' class="<%=classValue%>"> 
					<input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" checked disabled>
					<input type="hidden" name="item_desc_<%=(i+1)%>" id="item_desc_<%=(i+1)%>" value="<%=ht.get("item_desc")%>"/>
				</td>

			<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;">
			<font size=1><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:0&nbsp;<span ><fmt:message key="eST.chargeAmt.label" bundle="${st_labels}"/>:&nbsp;&nbsp;<fmt:message key="eST.PayabAmt.label" bundle="${st_labels}"/></span></font>
			</td>
		</tr>
			<%}else{
		/*Code added for SRR walk-thru on 3/3/2010*/
			if(stRecordsToDelete.hasMoreTokens() && ((stRecordsToDelete.nextToken()).equals("Y"))){
				deleted = "checked";
				/*Code added for SRR walk-thru on 3/4/2010*/
				/*commented by Rabbani #Inc no:35383 on 25/09/12
				fontClass = "";  
				curChange = "";  */
				
			}else{
				deleted = "";
				/*Code added for SRR walk-thru on 3/4/2010*/
				fontClass = "HYPERLINK";
				curChange = "changeCursor(this);";
			}
		/*Code ended*/
			expired_batch		=	0 ;
			alTemp				=	(ArrayList)ExpDtl.get("" + i) ;

			for(int j=0;j<alTemp.size(); j++)
			 {
				hmTemp			=	(HashMap)alTemp.get(j); 
				int intTempNOD	=	Integer.parseInt((String)hmTemp.get("NOD"));

				if( (intTempNOD < EWDays || intTempNOD < 0 ) && (((String)hmTemp.get("EXPIRY_YN")).equals("Y")) ){ //IN071552
				  expired_batch  =	expired_batch + 1 ;
				}
			 }
		 
			
			avail_qty			=	(String)ht.get("stock_available") ;	
			pat_net_amt			=	bean.checkForNull((String)ht.get("pat_net_amt"),"0") ;	
			paid_amt			=	bean.checkForNull((String)ht.get("pat_paid_amt"),"0") ;	
			gross_charge_amt	=	bean.checkForNull((String)ht.get("gross_charge_amt"),"0" );
			billable_item_yn	=	bean.checkForNull((String)ht.get("billable_item_yn"),"N" );
			rol_min		=	(HashMap)bean.getROL((String)ht.get("item_code"),store_code);

			String alt_text="";

			if( expired_batch > 0){
				String exp_batch	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
				alt_text			=	expired_batch +exp_batch ;
			}
			
			
			 String kit_usage_type = "";

			 /* if(ht.containsKey("kit_temp_code")){
				 kit_usage_type = bean.checkForNull((String)bean.getUsageType((String)ht.get("kit_temp_code"),(String)ht.get("item_code")));
			  }*/
			  
			  if(ht.containsKey("usage_type")){
				 kit_usage_type = bean.checkForNull((String)ht.get("usage_type"));
			  }


			  //System.out.println("usage_type=221 detail==>" +kit_usage_type);
			  
			  if(kit_usage_type.equals("R")){
			    deleted   ="";
			    chk_disabled = "disabled";
			   }
			   else if(kit_usage_type.equals("O")){
			      deleted   ="";
			      chk_disabled = "";
			    }
			    else if(kit_usage_type.equals("P")){
			    deleted   ="checked";
			    chk_disabled = "";
			    }
			    else if(kit_usage_type.equals("D")){
				deleted   ="checked";
			    chk_disabled = "disabled";
				}
			

			%>

		<tr id="tr_<%=i%>">
			<td  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" onclick="disabledPreviwButton(this,'<%=i%>');chkstatus('<%=i%>');" <%=deleted%> <%=chk_disabled%> >
			<input type="hidden" name="item_desc_<%=(i+1)%>" id="item_desc_<%=(i+1)%>" value="<%=ht.get("item_desc")%>"/></td>
			<!--
				Code added for SRR walk-thru on 3/3/2010
				Onmouseover is add as the anchor tag on item details is removed.
			-->
			<td width='268' class="<%=classValue%>" id="td_<%=i%>" style="WORD-BREAK:BREAK-ALL;" onmouseover="<%=curChange%>">


			<% 
			if ( (Double.parseDouble(avail_qty) - Double.parseDouble((String)ht.get("item_qty")))  <  Double.parseDouble((String)rol_min.get("MIN_STK_QTY"))){
				String less_than_min_stock	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.lessthanminstock.label","st_labels");
				alt_text					=	less_than_min_stock+"\n"+alt_text;
			%>
			<img src="../images\info1.gif" alt="<%=alt_text%>" height=12 >&nbsp;
			<%}


			else if ( (Double.parseDouble(avail_qty) - Double.parseDouble((String)ht.get("item_qty")))  <  Double.parseDouble((String)rol_min.get("REORDER_LEVEL"))){
				String less_than_rol		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.lessthanROL.label","st_labels");
				alt_text					=	less_than_rol +"\n" + alt_text;
			%>
			<img src="../images\info1.gif" alt="<%=alt_text%>" height=12 >&nbsp;
			<%}


			 else if( expired_batch > 0){
			 %>
					<img src="../images\info1.gif" alt="<%=alt_text%>" height=12 >&nbsp;
			 <%
				} 
			 %>	
			<!--
				Code added for SRR walk-thru on 3/3/2010
				Anchor tag is removed and everything is handled using fong tag itself.
			-->

			 <font size=1 class='<%=fontClass%>' id="font_<%=i%>" onclick="javascript:modifyData(<%=i%>);disabledPreviwButton();"><%=ht.get("item_desc")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/>:<%=ht.get("item_qty")%>&nbsp;
			 
		 <%
		  if(bl_install_yn.equals("Y") && billable_item_yn.equals("Y")){				 
		 %>
			 <span ><fmt:message key="eST.chargeAmt.label" bundle="${st_labels}"/>:<%=gross_charge_amt%>&nbsp;<fmt:message key="eST.PayabAmt.label" bundle="${st_labels}"/>:<%=pat_net_amt%>
			&nbsp;Paid:<%=paid_amt%>
			<fmt:message key="Common.Included.label" bundle="${common_labels}"/>:
			<%
			
		 /*
				if(((String)ht.get("p_overridden_excl_incl_ind")).equals("I") ){
					out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
				}else {
					out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
					
				}

				*/

	if(((String)ht.get("bl_override_allowed_yn")).equals("I") )
	{

		if(((String)ht.get("p_overridden_excl_incl_ind")).equals("I") )
		{
			out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
		}else 
		{
			out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
			
		}
	}
	else if(((String)ht.get("bl_override_allowed_yn")).equals("E") )
	{
		if(((String)ht.get("p_overridden_excl_incl_ind")).equals("S") )
		{
			out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
		}else 
		{
			out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
			
		}
	}
	else if(((String)ht.get("bl_override_allowed_yn")).equals("B") )
	{
		if(((String)ht.get("p_overridden_excl_incl_ind")).equals("I") )
		{
			out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
		}else  
		{
			out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
			
		}
	}
	else
		{
			out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
		}

			%>

			 &nbsp;<fmt:message key="ePH.ApprovalReqd.label" bundle="${ph_labels}"/>:
			 <%
				if(((String)ht.get("approval_reqd_yn")).equals("Y")){
					out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
				}else if(((String)ht.get("approval_reqd_yn")).equals("N")){
					out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
				}else{
					out.println("");
			}
		 }
		 %>
			</span></font></font></a>
			</td>

		</tr>
	<%}} 
	bean.getTempBatchRecords().clear();//Added for GHL-CRF-0413
	%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">

    <input type="hidden" name="function_id" id="function_id" value="<%= function_id %>">
	<input type="hidden" name="BARCODE_YN" id="BARCODE_YN" value="<%= BARCODE_YN %>"
	</form>
	<%
//putObjectInBean(bean_id,bean,request);
%>

</body>
<%
	if(kit12.equals("kit")){
%>
	<script>
		setTimeout("kitNextItem();",300);//example1();
	</script>
<%}

if (request.getParameter("index")!=null  && !(kit12.equals("kit"))) {%>
<script language="JavaScript">
	document.getElementById("font_"+<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>).scrollIntoView();
	changeRowColor(document.getElementById("tr_"+<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>));	
</script>



<%}
	}
catch(Exception ex)
{
	ex.printStackTrace();
	System.out.println("Exception in SalesDetail.jsp...");
	System.out.println(ex.toString());
}

%>
</html>

