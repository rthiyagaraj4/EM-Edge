<!--<!DOCTYPE html>-->
<%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.*,java.util.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title> </title>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");
	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/ManufacturingReceipts.js"></script>
</head>
<%
	int i								=	0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String check						=	"";
	String baseqty						=	"1";
	String alt_text						=	"";
	String ExpiredBatch					=	"";
	//String EWD						=	"";
	String sbi							=	"";  
	String sbn							=	"";
	String display_flag					=	"visibility:hidden";
	String allow_deci_yn        =       "";
	String no_deci              =       "";

	ArrayList ALDetailData				=	new ArrayList();
	ArrayList alDfltList				=	new ArrayList();
	boolean proceed						=	false;
	boolean display						=	true;
	mode								=	request.getParameter( "mode" ) ;
	if(mode==null)
		mode="1";
	function_id							=	request.getParameter( "function_id" ) ;
	
	bean_id								=	"ManufacturingReceiptsBean" ;
	bean_name							=	"eST.ManufacturingReceiptsBean";

	ManufacturingReceiptsBean bean		=	(ManufacturingReceiptsBean) getBeanObject( "ManufacturingReceiptsBean","eST.ManufacturingReceiptsBean", request  );
	bean.setLanguageId(locale);
	ExpiredBatch						=	 bean.checkForNull(bean.getExpiredBatch(),""); 
	//EWD								=	 bean.checkForNull(bean.getEWD(),"");
	String datMode						=	 bean.checkForNull(request.getParameter("datMode"),"Add");
    //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	String dflt_mfg_mode						=	 bean.checkForNull(request.getParameter("dflt_mfg_mode"),"R");
	String expiry						        =	 bean.checkForNull(request.getParameter("expiry"),"");
	
	String composition_for_qty			=	"";
	String ROL_YN						=	"";
	String Min_YN						=	"";
	String doc_no						=	"";

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
		doc_no							=	request.getParameter("doc_no");

	double prep_qty						=	0.0;
	ArrayList al123Exp					=	new ArrayList();
	try { 
			if(datMode.equals("Add")){
				proceed					=	true;
				composition_for_qty		=	request.getParameter("composition_for_qty");
				baseqty					=	request.getParameter("baseqty");

				bean.setComposition_for_qty(composition_for_qty);
				if (baseqty==null || baseqty.equals("") )
					baseqty				=	bean.getReq_qty();
					bean.setBase_qty(baseqty);

			}
			else{
				composition_for_qty		=			bean.getComposition_for_qty();
				baseqty					=			bean.getBase_qty();
				proceed					=			false;
			}
			if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
				ArrayList ALDtlData		=			bean.getDataDtlList();
			
				ArrayList ALExpDataAll	=			bean.getExpDetailsList();
				HashMap ALExpData		=			new HashMap();
				int index				=			0;
				int size				=			ALDtlData.size();
				bean.setBatchDataDisp(doc_no,bean.getDoc_type_code());
		
				ArrayList al123Exptemp	=		new ArrayList();
				for(int j=0;j<size;j++) {
					al123Exptemp = new ArrayList();
						
						if(bean.getDoc_type_code().equals((String)(((HashMap)ALDtlData.get(j)).get("DOC_TYPE_CODE"))) &&  
						bean.getDoc_no().equals((String)(((HashMap)ALDtlData.get(j)).get("DOC_NO")))) {
						ALDetailData.add(ALDtlData.get(j));
						if(proceed){
							index=Integer.parseInt((String)(((HashMap)ALDtlData.get(j)).get("DOC_SRL_NO")) );
							for (int k=0;k<ALExpDataAll.size();k++){
							if(bean.getDoc_type_code().equals((String)(((HashMap)ALExpDataAll.get(k)).get("DOC_TYPE_CODE"))) &&  
									bean.getDoc_no().equals((String)(((HashMap)ALExpDataAll.get(k)).get("DOC_NO"))) && 
									index==(Integer.parseInt((String)(((HashMap)ALExpDataAll.get(k)).get("DOC_SRL_NO")) )) ){
				
									ALExpData	=		(HashMap)ALExpDataAll.get(k);
									al123Exptemp.add(ALExpData);
								}
							}
							al123Exp.add(al123Exptemp);
						}
					}
				}
			}
		   else{
				ALDetailData			=		bean.getDataDtlList();
				alDfltList				=		bean.getExpBatchDetailsList();
				if(datMode.equals("Add"))
					proceed=true;
		   }
%>
<body>
<form name='formDetail' id='formDetail' >
<table border='1' cellpadding='0' cellspacing='0' width=300 align=center >
	<th><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
	<th ><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/></th>
	<%
	int expired_batch_no		=		0;
	int exp_batch               =       0;
	String nod					=		"";
	StringBuffer sb				=		new StringBuffer();
	StringBuffer sb2			=		new StringBuffer();
	int EWDays					=		bean.getEntityparam_EWDay((String)session.getAttribute("ACC_ENTITY_ID"));
	
	HashMap ht				=	new HashMap();
	HashMap hmParameters	=	new HashMap();
	ArrayList alBatchRecords=new ArrayList();
	HashMap a =  null;
	HashMap hmReturn	= null;
	HashMap hmTemp		= null;
	StUtilities bean1;
	for(i=0;i<ALDetailData.size();i++)
	{
		
	if (mode.equals("2") && datMode.equals("Add")){
		expired_batch_no		=		0;
		for(int k=0; k<((ArrayList)al123Exp.get(i)).size(); k++)	{
			nod					=		(String)((HashMap)((ArrayList)al123Exp.get(i)).get(k)).get("NOD");
			
			if(Integer.parseInt(nod) < EWDays)
				expired_batch_no++;
			}
		}
		if(mode.equals("2") && datMode.equals("modify")){
		 ArrayList alExpModifydata	=			bean.getExpDetailsList();
		 expired_batch_no		=		0;
		    for(int l=0; l<((ArrayList)alExpModifydata.get(i)).size(); l++)	{
			nod		=		(String)((HashMap)((ArrayList)alExpModifydata.get(i)).get(l)).get("NOD");
			if(Integer.parseInt(nod) < EWDays)
				expired_batch_no++;
			}
		 }
		 
		
		String classValue		=	"";
		ht=(HashMap)ALDetailData.get(i);
		%><script>var short_desc_<%=i%>=encodeURIComponent("<%=ht.get("SHORT_DESC")%>");</script><%//Added by suresh.r on 26-03-2015
		System.out.println("ht=180==>" +ht);
	
		if(i%2==0)classValue	=	"QRYEVEN";
		else classValue			=	"QRYODD";
        double qty				=	0.0;
        double cost				=	0.0;
		String disable			=	"";
		
		//Added by Rabbani #Inc no:29950 on 27/FEB/2013 Starts
		  if (mode.equals("1") && expiry.equals("expiry")){
		        exp_batch			=		0;
				nod				  =		bean.checkForNull((String)ht.get("NOD"),"0");				
				 if(Integer.parseInt(nod) < EWDays && Integer.parseInt(nod) != 0){
						exp_batch++;
					}
			}
			//ends
		
		allow_deci_yn        =       bean.checkForNull(bean.getAllowDecimalsYN((String)ht.get("CHILD_ITEM_CODE")),"N");
            if(allow_deci_yn.equals("Y"))
			no_deci              =       ""+bean.checkForNull(""+bean.getNoOfDecimals(),"0");
			else
            no_deci   = "0";
		
		if(((String)ht.get("MANDATORY_ITEM")).equals("Y") || ((String)ht.get("MANDATORY_ITEM")).equals("E")){
				disable			=	"disabled";
		}
		else{
				disable			=	"";
		}
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		//if(dflt_mfg_mode.equals("D"))
		//disable			=	"";
		String item_names		=	"";
		double conv_qty			=	0.0;
		qty						=	Double.parseDouble((String)ht.get("COMPONENT_QTY"))*Double.parseDouble(bean.checkForNull(composition_for_qty,"0"));
	
		if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
			conv_qty=qty*Double.parseDouble(bean.checkForNull(((String)ht.get("CONV_FACTOR")),"1"));
	//		if(!((String)ht.get("MANDATORY_ITEM")).equals("E"))
			conv_qty=conv_qty/Double.parseDouble(baseqty);
		}
		else{
			conv_qty=qty;	
		}
/*	
		cost=(conv_qty)*Float.parseFloat(bean.setNumber(((String)ht.get("UNIT_COST")),3));
		cost=Float.parseFloat(bean.setNumber(""+cost,3));	
		
*/
		int count = bean.LinkChk((String)ht.get("CHILD_ITEM_CODE"),(String)bean.getStore_code());
		if(count==0){
			check="checked";
			display=false;    
			         
			if ( (mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) && !(datMode.equals("modify")))||(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) )
			{
			 sb.append(ht.get("SHORT_DESC"));
	 		 sb.append(",");
			}
		}else{
			check="";
			display=true;    
		}

		a = bean.getROL((String)ht.get("CHILD_ITEM_CODE"),bean.getStore_code());
		 if(a!=null&&a.size()>0){
		 //if( mode.equals("1") && ExpiredBatch != ""  && Integer.parseInt(ExpiredBatch) > 0 ) {
		 if( mode.equals("1") && exp_batch > 0 ) { //Added by Rabbani #Inc no:29950 on 27/FEB/2013
		String exp_legend= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
			//alt_text = ExpiredBatch+exp_legend;
			 alt_text = exp_batch+exp_legend;
		}
		else if (mode.equals("2") && expired_batch_no > 0){
			String exp_legend_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
				alt_text = expired_batch_no+exp_legend_1;
		}
		if((Double.parseDouble((String)a.get("QTY_ON_HAND")) - qty) < Double.parseDouble((String)a.get("REORDER_LEVEL")))
				ROL_YN = "Y";
			else
				ROL_YN = "N" ;
			
			if((Double.parseDouble((String)a.get("QTY_ON_HAND")) - qty) < Double.parseDouble((String)a.get("MIN_STK_QTY")))
				Min_YN = "Y";
			else
				Min_YN = "N";
		 }
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ){
		try { 
				bean1 = (StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
				bean1.setLanguageId(locale);
					hmParameters.put("ITEM_CODE",ht.get("CHILD_ITEM_CODE"));
					hmParameters.put("STORE_CODE",bean.getStore_code());
					// added by Pankaj 
                    double conv_qty1 = ((double)conv_qty);
					// Critical Check Once 1/13/2010
					hmParameters.put("TRN_QTY",""+Double.parseDouble((bean.setNumber(""+conv_qty1,Integer.parseInt(no_deci)))));
					hmReturn	=	bean1.getBatches(hmParameters);
				if(proceed){
					alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA");
					alDfltList.add(alBatchRecords);
					exp_batch			=		0;
				/*for(int n=0; n<((ArrayList)alDfltList.get(i)).size(); n++){
				nod		=		(String)((HashMap)((ArrayList)alDfltList.get(i)).get(n)).get("NOD");
                 ht.put("NOD", nod);
				 ALDetailData.set(i,ht);				
				 if(Integer.parseInt(nod) < EWDays){
						exp_batch++;
					}
				}*/
				for(int n=0;n<alBatchRecords.size(); n++)
			 {
				hmTemp			=	(HashMap)alBatchRecords.get(n); 
				nod	            =	(String)hmTemp.get("NOD");
				ht.put("NOD", nod);
				ALDetailData.set(i,ht);				
			   if(Integer.parseInt(nod) < EWDays){
					exp_batch++;
				   }
					break;
			 }
				if(a!=null&&a.size()>0){
		        if(exp_batch > 0 ) { //Added by Rabbani #Inc no:29950 on 28/FEB/2013
		        String exp_legend= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.expiredBatches.label","st_labels");
			     alt_text = exp_batch+exp_legend;
		         }
				}
			}
					display=true;
					check="";
					putObjectInBean("stUtilities",bean1,request);

			}catch (eST.Common.InsufficientBatchException insufficientBatchException) {
				display=false;
						if(((String)ht.get("MANDATORY_ITEM")).equals("Y")  || ((String)ht.get("MANDATORY_ITEM")).equals("E")  ){
						check="checked";
								}
						else{
							check="checked";
						}
							if(proceed){
							if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ){
								item_names=item_names+ht.get("SHORT_DESC");
								%>
								<script>
									//if(!confirm('<%=insufficientBatchException.getMessage()%>'+' For the Item '+'<%=item_names%>'));
									//alert('<%=insufficientBatchException.getMessage()%>'+' For the Item '+'<%=item_names%>');
								</script>
								<%	//insufficientBatchException.printStackTrace();
						    sb2.append(ht.get("SHORT_DESC"));
	 						sb2.append(",");
							}
						}
			}
			catch (Exception exception) {
				out.println(exception.getMessage());
				exception.printStackTrace();
			}
			finally {
			}
		}


	/*	if(datMode.equals("modify") && request.getParameter("index") != null && Integer.parseInt(request.getParameter("index"))==i)
			conv_qty=Integer.parseInt((String)ht.get("COMPONENT_QTY"));
		out.println(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ));
		out.println("MODE_MODIFY  inserta------"+datMode);*/
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )  && !(datMode.equals("modify"))){
//			prep_qty = Float.parseFloat((String)ht.get("COMPONENT_QTY"));
			prep_qty = Double.parseDouble((String)ht.get("TRANS_QTY"));

		}else{
				prep_qty = Double.parseDouble((String)ht.get("PREP_QTY"));
		if(prep_qty == 0.0)
				prep_qty=conv_qty;
		}
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )  && !(datMode.equals("modify"))) 
				prep_qty = conv_qty;
		/**
		 * @Name - Priya
		 * @Date - 03/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost and round up cost with noOfDecimalsForCost
		 */
	int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());

		cost=(prep_qty)*Double.parseDouble(bean.setNumber(((String)ht.get("UNIT_COST")),noOfDecimalsForCost));
		cost=Double.parseDouble(bean.setNumber(""+cost,noOfDecimalsForCost));	
	%>
	<tr id="tr_<%=i%>">
		<td  width='1' class="<%=classValue%>"><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disable%> <%=check%> ></td>
		<td width='230' class="<%=classValue%>" style="WORD-BREAK:BREAK-ALL;"><font size=1><%//alDfltList.get(0)%>

		<% 

		if (Min_YN.equals("Y") && Min_YN.equals("Y")){
			//String less_than_min_stock=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.lessthanminstock.label","st_labels");
		%>
		<img src="../images\info1.gif" alt="<%=alt_text%>"  height=12 >&nbsp;

		<%}
		else if (ROL_YN.equals("Y")){
			String less_than_rol=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.lessthanROL.label","st_labels");
		%>
		<img src="../images\info1.gif" alt="<%=less_than_rol%> \n <%=alt_text%>" height=12 >&nbsp;
		<%}
		else if((exp_batch > 0)|| (mode.equals("2") && expired_batch_no > 0)){
			%>
				<img src="../images\info1.gif" alt="<%=alt_text%>" height=12 >&nbsp;
<%		}
		if(((String)bean.getAccessCostDetails()).equals("Y"))
			display_flag			= "visibility:visible";
		%>	
<!--  commented on 25/11/04		<%if (display){%>
		<a name="a_<%=i%>" href="javascript:populateData('<%=i%>','<%=ht.get("CHILD_ITEM_CODE")%>','<%=mode%>','<%=bean.getStore_code()%>','<%=ht.get("COMPONENT_QTY")%>','<%=bean.getReq_qty()%>','<%=ht.get("SHORT_DESC")%>','<%=conv_qty%>','<%=baseqty%>');"><%=ht.get("SHORT_DESC")%><br>Quantity:<%=prep_qty%>&nbsp;Value:<%=cost%></font></a>
		<%}else{%>
		<%=ht.get("SHORT_DESC")%><br>Quantity:<%=conv_qty%>&nbsp;Value:<%=cost%></font>
		<%}%>-->
		<%if (display){%>
		<a name="a_<%=i%>" href="javascript:populateData('<%=i%>','<%=ht.get("CHILD_ITEM_CODE")%>','<%=mode%>','<%=bean.getStore_code()%>','<%=ht.get("COMPONENT_QTY")%>','<%=bean.getReq_qty()%>',short_desc_<%=i%>,'<%=prep_qty%>','<%=baseqty%>');"><%=ht.get("SHORT_DESC")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/><%=bean.setNumber(""+prep_qty,Integer.parseInt(no_deci))%>&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/><%=cost%></span></font></a>
		<%}else{%>
		<%=ht.get("SHORT_DESC")%><br><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/><%=bean.setNumber(""+conv_qty,Integer.parseInt(no_deci))%>&nbsp;<span style=<%=display_flag%>><fmt:message key="Common.Value.label" bundle="${common_labels}"/><%=cost%></span></font>
		<%}%>
		<input type="hidden" name="qty_<%=i%>" id="qty_<%=i%>" value="<%=conv_qty%>"></input><input type="hidden" name="child_item_code_<%=i%>" id="child_item_code_<%=i%>" value="<%=ht.get("CHILD_ITEM_CODE")%>"></input><input type="hidden" name="child_item_desc_<%=i%>" id="child_item_desc_<%=i%>" value="<%=ht.get("SHORT_DESC")%>"></input></td>
	</tr>
	<%
		((HashMap)ALDetailData.get(i)).remove("PREP_QTY");
		if (display){
			((HashMap)ALDetailData.get(i)).put("PREP_QTY",prep_qty+"");
		}else{
			((HashMap)ALDetailData.get(i)).put("PREP_QTY",conv_qty+"");
		}
		
		}

		
		bean.setDataDtlList(ALDetailData);	
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
			bean.setModDtlList(ALDetailData);
			if(proceed){
			
				bean.setExpDetailsList(al123Exp);
			}
		}
		else{
			if(proceed)
		
				bean.setExpDetailsList(alDfltList);
		}
		if(sb.length()>0){
			sbi=sb.toString();
			sbi =sbi.substring(0,sbi.length()-1);	
		}
		if(sb2.length()>0) {
			sbn=sb2.toString();
			
			sbn =sbn.substring(0,sbn.length()-1);	
			
	   }
	%>
</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= function_id %>">
	<input type="hidden" name="batch_id" id="batch_id" >
	<input type="hidden" name="expiry_date" id="expiry_date" >
	<input type="hidden" name="bin_location" id="bin_location" >
	<input type="hidden" name="trade_id" id="trade_id" >
	<input type="hidden" name="process_loss" id="process_loss" >
	<input type="hidden" name="batch_function" id="batch_function" >
	<input type="hidden" name="composition_for_qty" id="composition_for_qty" >
	<input type="hidden" name="checkBoxVals" id="checkBoxVals" >
	<input type="hidden" name="baseqty" id="baseqty" >
	<input type="hidden" name="finalized_yn" id="finalized_yn" >
	<input type="hidden" name="remarks" id="remarks" > 
	<input type="hidden" name="packed_by" id="packed_by" >
	<input type="hidden" name="counter" id="counter" >
	<input type="hidden" name="auto_gen_batch_yn" id="auto_gen_batch_yn" >
	<input type="hidden" name="sbi" id="sbi"					value="<%=sbi%>">
	<input type="hidden" name="sbn" id="sbn"					value="<%=sbn%>">
	<input type="hidden" name="dflt_mfg_mode" id="dflt_mfg_mode"		value="<%=dflt_mfg_mode%>">
<%
		}
		catch (Exception exception) {
			out.println(exception.getMessage());
			exception.printStackTrace();
		}
		finally {
		}
%>				
</form>
<%
putObjectInBean("ManufacturingReceiptsBean",bean,request);
%>
</body>

<%if (sbi.length()>0) {%>

<script>
 
var arr_string = new Array();
var Item_Desc="";
var Item_First;
var Item_sec;
arr_string = formDetail.sbi.value;

if(arr_string != null && arr_string.length > 0) {
		arr_string      = arr_string.split(",");
	for(var i=0;i<arr_string.length;i++) {
		if (i==0){
			Item_First =arr_string[i];
			Item_First = Item_First+","+"\n";
		}else{
			for(var k=i;k<i+3;k++){
				if(arr_string[k]!=undefined) 
					Item_Desc = Item_Desc +","+arr_string[k];
			}
            Item_Desc = Item_Desc+"\n";
			i=k-1;
		} 
	 }

}
 Item_Desc =Item_Desc.substring(1,Item_Desc.length-1);
 if(Item_Desc.length>0)
	Item_Desc=Item_First+Item_Desc;
  else
	Item_Desc =Item_First.substring(0,Item_First.length-2);
 
 alert(getMessage("ITEM_STORE_NOT_FOUND","ST")+" "+Item_Desc);
</script>			 
	<% }%>
<%if (sbn.length()>0) {
	
	eST.Common.InsufficientBatchException insufficientBatchException=new eST.Common.InsufficientBatchException();
%>			
<script>
//				alert('<%=insufficientBatchException.getMessage()%>'+' For the Item '+'<%=sbn%>');
var arr_string = new Array();
var arr_string1 = new Array();
var Item_Desc="";
var Item_First="";
var Item_sec="";
var temp=0;
var temp1=0;
arr_string = formDetail.sbn.value;
arr_string1=formDetail.sbi.value;
	
var arr_string3 = new Array();

	if((arr_string != null && arr_string.length > 0)&&(arr_string1 != null && arr_string1.length > 0)) {
		arr_string      = arr_string.split(",");
		arr_string1      = arr_string1.split(",");

		for(var i=0;i<arr_string.length;i++) {
			for(var j=0;j<arr_string1.length;j++) {
			//alert("arr_string1[j]"+arr_string1[j]+arr_string[i]);
			if(arr_string[i]!=arr_string1[j])
				{   temp=temp+1;
						continue;
				}
				else
					{
				 temp=0; 	
				break;
				  }
			}
				
				if(temp!=0)
				arr_string3[i]=arr_string[i]
		}
	}else { 
	if(arr_string != null && arr_string.length > 0) 	
		{
			arr_string      = arr_string.split(",");
			for(var i=0;i<=arr_string.length;i++) {
				arr_string3[i]=arr_string[i];
			}
		 }
	}
	if(arr_string3 != null && arr_string3.length > 0) {
		for(var i=0;i<arr_string3.length;i++) {
			 if ((i==0)&&(arr_string3[i]!=undefined)){
				Item_First =arr_string3[i];
				Item_First = Item_First+","+"\n";
			}else{
				for(var k=i;k<i+3;k++){
					if(arr_string3[k]!=undefined) 
						Item_Desc = Item_Desc +","+arr_string[k];
				}
				Item_Desc = Item_Desc+"\n";
				i=k-1;
			} 
		 }
	}
 Item_Desc =Item_Desc.substring(1,Item_Desc.length-2);
	if(Item_Desc.length>0)
		Item_Desc=Item_First+Item_Desc;
	else
		Item_Desc =Item_First.substring(0,Item_First.length-3);
	if(Item_Desc.length>0)
	 {
		Item_Desc =Item_Desc.substring(0,Item_Desc.length-3);
		alert(getMessage("INSUFFICIENT_BATCH_QTY","ST")+" "+Item_Desc);
	 }
</script>
     <% }%>
<%if (request.getParameter("index")!=null) {%>
	<script language="JavaScript">
		document.getElementById("a_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>.scrollIntoView();
		changeRowColor(document.getElementById("tr_")<%=(request.getParameter("index")).equals("-1")?""+(i-1):request.getParameter("index")%>);	
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>

</html>

