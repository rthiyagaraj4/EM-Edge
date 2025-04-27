<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
30/01/2018	IN066493		Dinesh T		30/01/2018		Ramesh G		Issues - Old issues related to display, durn type description etc
12/02/2018	IN065713		Dinesh T		12/02/2018		Ramesh G		ML-MMOH-CRF-0987	
------------------------------------------------------------------------------------------------------------------------------
-->
	<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ page import ="webbeans.eCommon.* " %>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	<script language='javascript' src='../js/OrderSet.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%!
//IN066493, starts
private String decodeDesc(String desc_type)
{
String desc = "";	
if(desc_type.equals("H")) desc = "Hour(s)";
if(desc_type.equals("D")) desc = "Day(s)";
if(desc_type.equals("W")) desc = "Week(s)";
if(desc_type.equals("L")) desc = "Month(s)";
if(desc_type.equals("M")) desc = "Minute(s)";
return desc;
}
//IN066493, ends
private String decodeDosageType(String desc_type)
{
String desc = "";	
if(desc_type.equals("K")) desc = "Kg";
if(desc_type.equals("M")) desc = "M2";
if(desc_type.equals("A")) desc = "Age";
return desc;
}


%>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	

</head>
<%
	
	String bean_id = "Or_CareSet1" ;
	String bean_name = "eOR.CareSetBean1";

	String bean_id1 = "Or_CareSet" ;
	String bean_name1 = "eOR.CareSetBean";
	String order_set_code="";
	String order_type_code="";
	String iv_prep_yn="";
	Connection con=null ;
	int i=1;
	int j=1;

	CareSetBean bean1 = (CareSetBean)getBeanObject( bean_id1,  bean_name1, request ) ;
	bean1.setLanguageId(localeName);

	CareSetBean1 bean = (CareSetBean1)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	
	HashMap careSetHeaderStr = (HashMap)bean1.getCareSetHeaderStr();
 	order_set_code=(String)careSetHeaderStr.get("order_set_code");
 	order_type_code=(String)careSetHeaderStr.get("order_type_code");
 	iv_prep_yn=(String)careSetHeaderStr.get("iv_prep_yn");
	String classValue ="gridData";
	String order_category_desc=request.getParameter("order_category_desc")==null?"":request.getParameter("order_category_desc");
	String order_category_code=request.getParameter("order_category_code")==null?"":request.getParameter("order_category_code");
	order_category_code = order_category_code.trim();
	String order_set_seq_num=request.getParameter("order_set_seq_num")==null?"":request.getParameter("order_set_seq_num");
	String order_type=request.getParameter("order_type")==null?"":request.getParameter("order_type");	
	String qty_value=request.getParameter("qty_value")==null?"":request.getParameter("qty_value");
	String qty_uom_desc=request.getParameter("qty_uom_desc")==null?"":request.getParameter("qty_uom_desc");
	String freq_code=request.getParameter("freq_code")==null?"":request.getParameter("freq_code");
	String durn_value=request.getParameter("durn_value")==null?"":request.getParameter("durn_value");
	String durn_type_desc=request.getParameter("durn_type_desc")==null?"":request.getParameter("durn_type_desc");
	String rel_start_date_time=request.getParameter("rel_start_date_time")==null?"":request.getParameter("rel_start_date_time");
	String durn_type=request.getParameter("durn_type")==null?"":request.getParameter("durn_type");
	String qty_uom=request.getParameter("qty_uom")==null?"":request.getParameter("qty_uom");
	String reqd_or_opt_ind=request.getParameter("reqd_or_opt_ind")==null?"":request.getParameter("reqd_or_opt_ind");
	String route_code=request.getParameter("route_code")==null?"":request.getParameter("route_code");
	String prompt_msg=request.getParameter("prompt_msg")==null?"":request.getParameter("prompt_msg");
	String l_age_grp_code=request.getParameter("p_age_grp_code")==null?"":request.getParameter("p_age_grp_code");//IN065713
	String l_order_catalog_code=request.getParameter("p_order_catalog_code")==null?"":request.getParameter("p_order_catalog_code");//IN065713
	String l_applicable_to=request.getParameter("p_appl_to")==null?"":request.getParameter("p_appl_to");//IN065713
	String l_fetch_dosage_type=request.getParameter("p_fetch_dosage_type")==null?"":request.getParameter("p_fetch_dosage_type");
	String eff_status="";
	String ctgcode="";
	String typcode="";
	String order_category="";
	String checked="";
	String route_desc="";
	String route_updatable="";
	String route_style="";
	String occ_no = "";
	String l_show_order_set_seq_no = "style='display:inline'";//IN68241

	eff_status=request.getParameter("eff_status");
	ctgcode=request.getParameter("ctgcode");
	typcode=request.getParameter("typcode");
	order_category=request.getParameter("order_category");
	if(eff_status == null || eff_status.equals("null")) eff_status =" "; else eff_status = eff_status.trim();
	if(ctgcode == null || ctgcode.equals("null")) ctgcode =" "; else ctgcode = ctgcode.trim();
	if(typcode == null || typcode.equals("null")) typcode =" "; else typcode = typcode.trim();
	if(prompt_msg == null || prompt_msg.equals("null")) prompt_msg =" "; else prompt_msg = prompt_msg.trim();
	if(order_category == null || order_category.equals("null")) order_category =" "; else order_category = order_category.trim();
	String l_invoke_func=request.getParameter("p_invoke_func")==null?"":request.getParameter("p_invoke_func");//IN065713
	String l_age_grp_desc = request.getParameter("p_age_grp_desc")==null?"":request.getParameter("p_age_grp_desc");//IN065713
	String l_dosage_type = request.getParameter("p_fetch_dosage_type")==null?"":request.getParameter("p_fetch_dosage_type");//IN065713
	String valid = request.getParameter("valid")==null?"":request.getParameter("valid");//IN68241
	
	l_applicable_to = bean1.getApplicableTo();
	try
    {			
		  	con = ConnectionManager.getConnection(request);
	        PreparedStatement		pstmt		 = con.prepareStatement("select 1 from or_order_catalog	where order_catalog_code=? ");
			pstmt.setString(1,order_set_code);
			ResultSet rs= pstmt.executeQuery();
			 if(!rs.next())
		    {	%>
				 <script>alert("This Operation is possible in update mode");
				 //IN065713, starts
				 //window.close();
				 if("ORD_SET_AGE_GRP" == "<%=l_invoke_func%>")
				 	//parent.orderset_dosage_age_btn.document.getElementById('cancel_addi_window').click();//IN68241
					 parent.orderset_dosage_type_btn.document.getElementById('cancel_addi_window').click();//IN68241
				 else if("DOSAGE_TYPE_DEFN"== "<%=l_invoke_func%>")//IN68241, starts
					 parent.orderset_dosage_type_btn.document.getElementById('cancel_addi_window').click();
				 else if("DOSAGE_TYPE_DEFN_ADDITIONAL"== "<%=l_invoke_func%>")
					 parent.orderset_dosage_type_btn.document.getElementById('cancel_addi_window').click();//IN68241, ends
				 else 
					 window.close();
				 //IN065713, ends
				 </script>
			<%
				 
			 }

			 rs.close();
			pstmt.close();
			pstmt		 = con.prepareStatement("select short_desc from or_order_catalog	where order_catalog_code=? ");
			pstmt.setString(1,order_category_code);
			rs= pstmt.executeQuery();
			 while(rs.next())
			{
				order_category_desc=rs.getString("short_desc");
			}
			 rs.close();
			pstmt.close();
			//pstmt = con.prepareStatement("select    ORDER_SET_SEQ_NUM     ,ORDER_TYPE_CODE       ,ORDER_CATEGORY        ,REQD_OR_OPT_IND       ,REL_START_DATE_TIME   ,ROUTE_CODE  ,QTY_VALUE             ,QTY_UNIT              ,FREQ_CODE             ,DURN_VALUE            ,DURN_TYPE             ,ITEM_NARRATION,(select sHORT_DESC from  am_uom where UOM_CODE=QTY_UNIT) QTY_UNIT_desc     FROM OR_ORDER_SET_COMPONENT WHERE ORDER_SET_CODE =? AND ORDER_CATALOG_CODE  =? AND OCURRANCE_NUM=? ");

	%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="additionalDetailForm" id="additionalDetailForm" >
<table cellpadding='3' cellspacing='0' border='0' width='100%'>
	<tr>
		<td>
<%
	if(!"".equals(l_age_grp_desc))
	{
%>	
		<table cellpadding='3' cellspacing='0' border='1' width='100%' class='grid'>
			<tr>
				<td class='normal' id='age_grp_tab' width='30%' style="text-align:center;valign:middle">
				<b>Age</b>
				</td>
				<td class='clicked'id='age_grp_add_cata_tab' width='30%' style="text-align:center;valign:middle">
				<b>Additional</b>
				</td>
				<td class='<%=classValue%>'>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td class='columnheader' id='age_grp_tab' width='30%' style="text-align:center;valign:middle">
					<b>Age Group</b>
				</td>
				<td id='age_grp_tab' colspan='2' class='<%=classValue%>'>
					<b><%=l_age_grp_desc%></b>
				</td>
			</tr>
			<tr>
				<td colspan='3' class='<%=classValue%>'>&nbsp;</td>
			</tr>
		</table>
<%
	}
%>
		</td>
	</tr>
	<tr>
		<td>
<%
	//IN065713, starts
	if(!"".equals(l_dosage_type))
	{
	%>
		<table cellpadding='3' cellspacing='0' border='1' width='100%' class='grid'>
			<tr>
				<td class='columnheader' width='30%' align='center'><b><%=decodeDosageType(l_dosage_type)%></b></td>
				<td class='<%=classValue%>'>&nbsp;</td>
			</tr>
			<tr>
				<td class='<%=classValue%>' colspan='2'>&nbsp;</td>
			</tr>
		</table>
	<%
	}
	//IN065713, ends
%>
		</td>
	</tr>
<!----------      Next Previous Logic     ------------------------>


<!----------------END OF THE PREVOIUS NEXT  ---------------------------->
	<tr>
		<td>
<table cellpadding='3' cellspacing='0' border='1' width='100%' align='center' class='grid'>	
	<tr>
	<td class=columnheader></td>
	<td class=columnheader width='15%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<%	
	if(bean1.isSiteSpecificYN() && "C".equals(l_applicable_to) && ("DOSAGE_TYPE_DEFN_ADDITIONAL".equals(l_invoke_func) || "ORD_SET_AGE_GRP".equals(l_invoke_func) || "additionalDetailForm".equals(l_invoke_func)))
	{
		l_show_order_set_seq_no = "style='display:none'";
	}
	%>
	<td class=columnheader width='10%' <%=l_show_order_set_seq_no%>><fmt:message key="eOR.SeqNo.label" bundle="${or_labels}"/></td>
	<%
	if(bean1.isSiteSpecificYN() && "C".equals(l_applicable_to))
	{
	%>
	<td class=columnheader width='10%'><fmt:message key="eOR.OccurranceNo.label" bundle="${or_labels}"/></td>
	<%
	}
	%>
	<td class=columnheader width='15%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='5%'><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='15%'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td> 
	<td class=columnheader width='15%'><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td> 
	<td class=columnheader width='15%'><fmt:message key="eOR.DurnValue/DurnType.label" bundle="${or_labels}"/></td>
	<td class=columnheader width='10%'><fmt:message key="eOR.TimeFrame.label" bundle="${or_labels}"/></td>
	<td class=columnheader width='10%'><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='10%' style='display:none'><fmt:message key="Common.required.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='5%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='5%'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></td>
	</tr>
	<%
	//IN065713, starts
	//HashMap AdditionalCatalogs	= (HashMap)bean1.getDBAdditionalCatalogs();
	HashMap AdditionalCatalogs = null;

	if("ORD_SET_AGE_GRP".equals(l_invoke_func))
		AdditionalCatalogs	= (HashMap)bean1.getDBAgeWiseAdditionalCatalogs();
	else if("DOSAGE_TYPE_DEFN".equals(l_invoke_func))
		AdditionalCatalogs	= (HashMap)bean1.getDosageTypeHashValues();
	else if("DOSAGE_TYPE_DEFN_ADDITIONAL".equals(l_invoke_func) && "K".equals(l_dosage_type))
		AdditionalCatalogs	= (HashMap)bean1.getDosageTypeAdditionalKgHashValues();
	else if("DOSAGE_TYPE_DEFN_ADDITIONAL".equals(l_invoke_func) && "M".equals(l_dosage_type))
		AdditionalCatalogs	= (HashMap)bean1.getDosageTypeAdditionalM2HashValues();
	else
	{
		AdditionalCatalogs	= (HashMap)bean1.getDBAdditionalCatalogs();
		//IN065713, ends
	
		
		HashMap dosageTypeMap = (HashMap)bean1.getDosageTypeHashValues();
		if(dosageTypeMap!=null && dosageTypeMap.containsKey(order_category_code) && ((HashMap)dosageTypeMap.get(order_category_code)).size()>0) 
		{
			%>
			<script>
			alert(getMessage("MULTI_DOSAGE_TYPE_CONFIG","OR"));
			window.close();
			</script>
			<%
		}
	}
	
	HashMap hashCatalogs        = new HashMap();
	HashMap hashindex        = new HashMap();
	if(AdditionalCatalogs!=null)
	{
		if(AdditionalCatalogs.size()>0)
		{
			//IN065713, starts
			//hashCatalogs = (HashMap)AdditionalCatalogs.get(order_category_code);
			if("ORD_SET_AGE_GRP".equals(l_invoke_func))
				hashCatalogs = (HashMap)AdditionalCatalogs.get(order_category_code+"_"+l_age_grp_code);
			else if("DOSAGE_TYPE_DEFN".equals(l_invoke_func))
				hashCatalogs = (HashMap)AdditionalCatalogs.get(order_category_code+"_"+l_fetch_dosage_type);
			else if("DOSAGE_TYPE_DEFN_ADDITIONAL".equals(l_invoke_func))
				hashCatalogs = (HashMap)AdditionalCatalogs.get(order_category_code);
			else
				hashCatalogs = (HashMap)AdditionalCatalogs.get(order_category_code);
			//IN065713, ends
		}
	}
	
	String rowindex = "";

for(i=1;i<=9;i++)
{
	 j=i+1;
	 rowindex = String.valueOf(j);
	

	 if(hashCatalogs!=null)
	 {
		 if(hashCatalogs.size()>0)
		 {
			hashindex = (HashMap)hashCatalogs.get(rowindex);

		 }
	 }
	
	 if(hashindex!=null && hashindex.size()>0)
	{
		checked="checked";
		//order_set_seq_num	 = (String)hashindex.get("order_set_seq_num");
		order_set_seq_num	= request.getParameter("order_set_seq_num")==null?"":request.getParameter("order_set_seq_num");
		qty_value			 = (String)hashindex.get("qty_value");
				if(qty_value==null)qty_value="";

		freq_code			 = (String)hashindex.get("freq_code");
				if(freq_code==null)freq_code="";

		durn_value			 = (String)hashindex.get("durn_value");
				if(durn_value==null)durn_value="";


		rel_start_date_time  = (String)hashindex.get("rel_start_date_time");
				if(rel_start_date_time==null)rel_start_date_time="";

		reqd_or_opt_ind      = (String)hashindex.get("reqd_or_opt_ind");
				if(reqd_or_opt_ind==null)reqd_or_opt_ind="";

		durn_type            = (String)hashindex.get("durn_type");
				if(durn_type==null)durn_type="";

		//qty_uom               = (String)hashindex.get("qty_unit");//IN065713
		qty_uom               = (String)hashindex.get("qty_uom");//IN065713

				if(qty_uom==null) request.getParameter("qty_uom");    
				if(qty_uom==null)qty_uom="";


	   qty_uom_desc           = (String)hashindex.get("qty_unit_desc");
				if(qty_uom_desc==null) qty_uom_desc=request.getParameter("qty_uom_desc");
				if(qty_uom_desc==null) qty_uom_desc="" ;
		
	   route_code             = (String)hashindex.get("route_code");
				if(route_code==null) route_code=request.getParameter("route_code");
				if(route_code==null) route_code="" ;
	   prompt_msg             = (String)hashindex.get("prompt_msg");
			if(prompt_msg==null) prompt_msg=request.getParameter("prompt_msg");
			if(prompt_msg==null) prompt_msg="" ;
		
			durn_type_desc             = (String)hashindex.get("durn_type_desc");
			if(durn_type_desc==null) durn_type_desc=request.getParameter("durn_type_desc");
			
			durn_type_desc = decodeDesc(durn_type);//IN066493			
			
			 occ_no            = (String)hashindex.get("occ_no");
				if(occ_no==null) occ_no=request.getParameter("occ_no");
	}
	else
	{			
		   checked="";
		   occ_no = request.getParameter("occ_no")==null?"":request.getParameter("occ_no");
		   //order_category_desc=request.getParameter("order_category_desc");                                     
		   order_category_code  = request.getParameter("order_category_code")==null?"":request.getParameter("order_category_code");
		   order_category_code  = order_category_code.trim();
		   order_set_seq_num	= request.getParameter("order_set_seq_num")==null?"":request.getParameter("order_set_seq_num");
		   order_type			= request.getParameter("order_type")==null?"":request.getParameter("order_type");
		   qty_value				= request.getParameter("qty_value")==null?"":request.getParameter("qty_value");
		   qty_uom_desc			= request.getParameter("qty_uom_desc")==null?"":request.getParameter("qty_uom_desc");
		   freq_code			= request.getParameter("freq_code")==null?"":request.getParameter("freq_code"); 
		   durn_value			= request.getParameter("durn_value")==null?"":request.getParameter("durn_value"); 
		   durn_type_desc		= request.getParameter("durn_type_desc")==null?"":request.getParameter("durn_type_desc");
		   rel_start_date_time	= request.getParameter("rel_start_date_time")==null?"":request.getParameter("rel_start_date_time");
		   durn_type			= request.getParameter("durn_type")==null?"":request.getParameter("durn_type");
		   qty_uom				= request.getParameter("qty_uom")==null?"":request.getParameter("qty_uom");
		   reqd_or_opt_ind		= request.getParameter("reqd_or_opt_ind")==null?"":request.getParameter("reqd_or_opt_ind");
		   route_code			= request.getParameter("route_code")==null?"":request.getParameter("route_code");
		   prompt_msg			= request.getParameter("prompt_msg")==null?"":request.getParameter("prompt_msg");

	}

	route_desc =bean1.getRouteDesc(route_code);
	if(route_desc.equals("N"))
	{
		route_desc="";
	}
	
	String selectedValue = "";	
%>
<tr id='row<%=i%>'>
			<!-- Catalog Desc -->
			<!-- <td><%=i%></td> --><!--//IN066493-->
			<td class='<%=classValue%>'><%=i%></td><!--//IN066493-->
			<td class='<%=classValue%>'><%=order_category_desc%></td>
			<input type="hidden" name="catalog<%=i%>" id="catalog<%=i%>" value="<%=order_category_desc%>" >
			<!-- Seq No -->
			<%
			if(l_show_order_set_seq_no.equals("style='display:inline'"))
			{
			%>			
			<td class='<%=classValue%>' <%=l_show_order_set_seq_no%> DISABLED><input type='text' name='order_set_seq_num<%=i%>' id='order_set_seq_num<%=i%>' size=3 maxlength=3 value='<%=order_set_seq_num%>' style="text-align:right" readonly></td>
			<%
			}
			else
			{
			%>
			<input type="hidden" name="order_set_seq_num<%=i%>" id="order_set_seq_num<%=i%>" value="<%=order_set_seq_num%>"/>
			<%
    		}
			%>
			<%
			if(bean1.isSiteSpecificYN() && "C".equals(l_applicable_to))
			{					
				
			%>
			<td class='<%=classValue%>'>
			<select name='occ_no<%=i%>' id='occ_no<%=i%>' id='occ_no<%=i%>' onchange='validateDuplicateOccuranceNo("<%=i%>","1","10")'>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%

			for(int idx = 2;idx <=10; idx++)
			{
				selectedValue = "";
				int l_acc_no = 0;				

				if(occ_no.equals(""))
				{				
					if(i+1 == idx)
						selectedValue = "selected";
				}
				else
				{
					if(!occ_no.equals(""))
						l_acc_no = Integer.parseInt(occ_no);
					
					if( l_acc_no == idx)
					{
						selectedValue = "selected";
					}
				}
			%>
			<option value='<%=idx%>' <%=selectedValue%>><%=idx%></option>		
			<%
			}
			%>
			</select>
			</td>
			<%
			}
			%>
			<!-- Order type -->
			<td class='<%=classValue%>'><%=order_type%>
			</td>
			<input type="hidden" name="order_type_code<%=i%>" id="order_type_code<%=i%>" value="<%=order_type_code%>" >
			<input type="hidden" name="order_catalog_code<%=i%>" id="order_catalog_code<%=i%>" value="<%=order_category_code%>" >

			<!-- Qty unit -->
			<td class='<%=classValue%>'><input type='text' name='qty_value<%=i%>' id='qty_value<%=i%>' onKeyPress='return(checkValid(this,event,6,5))' size=6 maxlength=6   value='<%=qty_value%>' style="text-align:right"></td>

			<!-- UOM unit     -->     
			
			<td class='<%=classValue%>'>
		    <input type="hidden" name="qty_uom<%=i%>" id="qty_uom<%=i%>" value="<%=qty_uom%>" >



    		<input type="text" name="qty_uom_desc<%=i%>" id="qty_uom_desc<%=i%>" size=8 maxlength=8 value="<%=qty_uom_desc%>"  readonly><input type="button" name="qty_uom_button<%=i%>" id="qty_uom_button<%=i%>" class='button' style="" value='?' 
			onclick="show_qty_uom_Look(qty_uom_desc<%=i%>,qty_uom<%=i%>,<%=i%>);" disabled>	
			</td>  
			<!-- fREQ unit -->
			<!--<td class='<%=classValue%>'><SELECT name="freq_code<%=i%>" id="freq_code<%=i%>" ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>--><!--//IN066493-->
			<td class='<%=classValue%>'><SELECT name="freq_code<%=i%>" id="freq_code<%=i%>" onchange='getDurnType(this,"<%=i%>","<%=l_invoke_func%>")'><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><!--//IN066493-->
			
				<%ArrayList Order_Category = bean1.getFrequency(order_category,order_category_code);
			  String[] record=null;
			  for(int ii=0; ii<Order_Category.size(); ii++)
			  {
					record = (String[])Order_Category.get(ii);
					if(freq_code.equals(record[0]))
							out.println("<option value = '"+record[0]+"'  selected > "+record[1]+" ");	
					else
						out.println("<option value = '"+record[0]+"' > "+record[1]+" ");	 

						out.println("</option>");
			  }%>
		 	</SELECT>
			</td>

		  	<!-- Durn Val/Durn Desc -->
		 	<td class='<%=classValue%>' nowrap>
			<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" size='3' maxlength='3'	class="number" 
			onblur='OrCheckPositiveNumber1(this)'
			value="<%=durn_value%>">/<input type="text"  readonly name="durn_type_desc<%=i%>" id="durn_type_desc<%=i%>"	 size='3'   value="<%=durn_type_desc%>"></td>
		  	<input type='hidden' name='durn_type<%=i%>' id='durn_type<%=i%>' value="<%=durn_type%>" >
		

		   <!-- time Frame -->
		   <!-- <td> --><!--//IN066493-->
		   <td class='<%=classValue%>'><!--//IN066493-->
		   <input type="text" name="rel_start_date_time<%=i%>" id="rel_start_date_time<%=i%>"	size='3'
		   onblur='checkDecimal2(this)'
		     class='number' maxlength="3" value="<%=rel_start_date_time%>"><fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>

			 <!--Route-->
			<td class='<%=classValue%>'>
		    <input type="hidden" name="route_code<%=i%>" id="route_code<%=i%>" value="<%=route_code%>" >
		    

    		<input type="text" name="route_desc<%=i%>" id="route_desc<%=i%>" size=8 maxlength=8 value="<%=route_desc%>" <%=eHISFormatter.disabled("y",route_updatable)%> onblur="show_route_window(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'detailForm');" ><input type="button" name="route_button<%=i%>" id="route_button<%=i%>" class='button' style="<%=route_style%>" value='?' <%=eHISFormatter.disabled("y",route_updatable)%>
			onclick="show_route_Lookupwindow(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'detailForm');" >	
			</td>  

   		   <!--Required-->
		   <td class='<%=classValue%>' style='display:none'>		   
		   <SELECT name="reqd_or_opt_ind<%=i%>" id="reqd_or_opt_ind<%=i%>"   >
		   <option value="R" ><fmt:message key="Common.required.label" bundle="${common_labels}"/></option>
		   <option value="O" ><fmt:message key="eOR.OptionalPreSelected.label" bundle="${or_labels}"/></option>
		   <option value="D" ><fmt:message key="eOR.OptionalDeSelected.label" bundle="${or_labels}"/></option>
	       </SELECT></td>


    	  <!--Include-->
		  <td class='<%=classValue%>' ><input type='checkbox' name='include<%=i%>' id='include<%=i%>' onclick=""value='Y'   onClick='' <%=checked%>></td>

		<!---------comments------->

	
					</a></td>
		<td class='<%=classValue%>' ><A class='gridLink' name='Cmts<%=i%>' href='#' onClick='showDia("<%=i%>")'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></A></td>

	 <INPUT TYPE="hidden" name="prompt_msg<%=i%>" id="prompt_msg<%=i%>" value="<%=prompt_msg%>"> 
	 <INPUT TYPE="hidden" name="occurance<%=i%>" id="occurance<%=i%>" value="<%=j%>"> 
	 <INPUT TYPE="hidden" name="ctgcode<%=i%>" id="ctgcode<%=i%>" value="<%=ctgcode%>"> 
	 <INPUT TYPE="hidden" name="typcode<%=i%>" id="typcode<%=i%>" value="<%=typcode%>"> 
	 <input type='hidden' name='p_fetch_dosage_type<%=i%>' id='p_fetch_dosage_type<%=i%>' value='<%=l_fetch_dosage_type%>' >	
	</tr>	
<%	}
	
	rs.close();
	//pstmt.close();
	
	%>
<%	%>
	<input type='hidden' name='detailPageMode' id='detailPageMode' value='<%=bean1.getDetailPageMode()%>' >
	<input type='hidden' name='eff_status' id='eff_status' value='<%=eff_status%>' >
	<input type='hidden' name='order_set_code' id='order_set_code' value='<%=order_set_code%>' >
	<input type='hidden' name='iv_prep_yn' id='iv_prep_yn' value='<%=iv_prep_yn%>' >
	<input type=hidden name='total_recs' id='total_recs' value='9'>
	<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id1%>'>
	<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name1%>'>
	<input type="hidden" name="mode" id="mode" value="1">
	<input type="hidden" name="which_place" id="which_place" value="orderset_added">
	<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
	<input type="hidden" name="route_sql" id="route_sql" 	value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_SET_COMPONENT_ROUTE")%>">
	
	<input type='hidden' name='p_age_grp_code' id='p_age_grp_code' value='<%=l_age_grp_code%>' ><!--IN065713-->
	<input type='hidden' name= 'p_site_specific_dosage_type' value='<%=bean1.isSiteSpecificYN()%>'/>
	<input type='hidden' name= 'p_dosage_type' value='<%=l_fetch_dosage_type%>'/>
	<input type='hidden' name= 'valid' value='<%=valid%>'/>
	<input type='hidden' name= 'applicable_to' value='<%=l_applicable_to%>'/>
	
<!-----------------------Display Logic ------------------>

 <%
 	 }
	 catch(Exception e)
	 {
		e.printStackTrace();
	 } 
	 finally
	 {
		con.close();
	 }
%>
</td>
</tr>
</table>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="p_invoke_func" id="p_invoke_func" value="<%=l_invoke_func%>"><!--IN065713-->
<%
	putObjectInBean(bean_id,bean,request); 
%>
</form>
</body>
</html>

