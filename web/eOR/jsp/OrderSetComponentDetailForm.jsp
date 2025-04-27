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
03/08/2017	IN062992		Dinesh T		7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
04/09/2017	IN065021		Dinesh T		04/09/2017		Ramesh G		Unable to update comments
12/02/2018	IN065713		Dinesh T		12/02/2018		ML-MMOH-CRF-0987	
------------------------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

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
	<script language='javascript' src='../../eOR/js/OrderSet.js'></script>
    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

</head>

<%!
	String decode(String code)
	{
	  if(code.equalsIgnoreCase("H")) return "Hour(s)";
	  if(code.equalsIgnoreCase("D")) return "Day(s)";
	  if(code.equalsIgnoreCase("W")) return "Week(s)";
	  if(code.equalsIgnoreCase("L")) return "Month(s)";
  	  if(code.equalsIgnoreCase("M")) return "Minute(s)";
	  return "";
	}
%>
<%
	final  int DISPLAY_RECORDS = 8 ;
	//int row_disp=DISPLAY_RECORDS,start = 0 ,end = 0 ;

	int  fm_disp=0, to_disp=0 ,noOfRecords=0,	previousRecord=0, nextRecord =0;

	//String action="",detailPageMode="";
	//String  from= "", to ="";
	
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";

	String freq_code_updatable = "Y";
	String reqd_or_opt_ind_updatable = "Y";
	String qty_reqd_updatable = "Y";
	String qty_uom_updatable = "";
	String route_updatable = "";
	//String prompt_msg_default="";

	CareSetBean bean = (CareSetBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	//int j = 0 ;
	String classValue ="";
	
	String nextPrevFlag		= ChkDef.defaultString(request.getParameter("nextPrevFlag"));
	previousRecord			= ChkDef.defaultInt(request.getParameter("previousRecord"));
	nextRecord				= ChkDef.defaultInt(request.getParameter("nextRecord"));
	//detailPageMode			= request.getParameter("detailPageMode") ;

	String act				= request.getParameter("action");
	String order_category	= request.getParameter("order_category");

	String l_applicable_to	= request.getParameter("applicable_to")==null?"":request.getParameter("applicable_to");//IN062992
	String l_invoke_func	= request.getParameter("p_invoke_func")==null?"":request.getParameter("p_invoke_func");//IN062992

	
	String uom_style    = "" ;    
	String route_style    = "" ;    

	try
    {		
		bean.handleAction(request);	
		//bean.reloadFreqRecordedData();//IN062992
		noOfRecords =bean.getRecordsNo();	
		bean.setSettingsFreqStr();


		if(act.equalsIgnoreCase("IndexSelect")||
					act.equalsIgnoreCase("associated"))
		{
			previousRecord = 0;
			nextRecord =  0 ;
		}



	//ArrayList recordSet		= null;


	/***GET THE STORE FOR THIS TAB***/
//	ArrayList  settingsRecStr		 =  bean.getSettingsRecStr();
	%>

		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="detailLowerForm" id="detailLowerForm" >

		<!----------      Next Previous Logic     ------------------------>

		<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='WHITE' align="right">
			<%
			if("next".equalsIgnoreCase(nextPrevFlag.trim()))
			{

				fm_disp			= nextRecord	   + 1;			
				if(noOfRecords < DISPLAY_RECORDS)
					to_disp	=	noOfRecords;
				else
					to_disp			= fm_disp + (DISPLAY_RECORDS-1);//put x-1 in place of 9 where x RecTODisplay

				if(to_disp > noOfRecords)
					to_disp   = noOfRecords;

				if(nextRecord-1> 0)
				{
				%>
			
					<a class='gridLink' href="javascript:parent.parent.parent.getNext('previous')" text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/><a>
				 <%
				}
				
				if(nextRecord + DISPLAY_RECORDS < noOfRecords )
				{//put x in place of DISPLAY_RECORDS where x is RecTODisplay%>
					<a class='gridLink' href="javascript:parent.parent.parent.getNext('next')" text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/><a>
				<%
				}
			}
			
			if("previous".equalsIgnoreCase(nextPrevFlag.trim()))
			{
			   fm_disp		= previousRecord   - DISPLAY_RECORDS;//put x in place of DISPLAY_RECORDS where x is RecTODisplay
			   to_disp	    = fm_disp + (DISPLAY_RECORDS-1);//put x-1 place of 9 where x is RecTODisplay
			   if( previousRecord - DISPLAY_RECORDS  > 1)
			   {//put x in place of DISPLAY_RECORDS where x is RecTODisplay%>
			 
					<a class='gridLink' href="javascript:parent.parent.parent.getNext('previous')" text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
				<%
				}

				if(previousRecord <= noOfRecords )
				{
				%>
					<a class='gridLink' href="javascript:parent.parent.parent.getNext('next')" text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
				<%
				}
			}
			%>
			</td>
		</tr>
	</table>
<!----------------END OF THE PREVOIUS NEXT  ---------------------------->

<table class='grid' width='100%'>
<tr><!--IN065713-->
	<td class=columnheader></td>
		<th class=columnheader width='15%' align="left" style="position: sticky; top: 0; z-index: 1;">catalogs</td>

	<th class=columnheader width='15%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<th class=columnheader width='10%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="eOR.SeqNo.label" bundle="${or_labels}"/></td>
	<th class=columnheader width='15%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<%
		//IN062992, starts
		if(bean.isSiteSpecificYN() && "C".equals(l_applicable_to))
		{
	%>
	<%--<td class=columnheader width='15%'><fmt:message key="eOR.DosageType.label" bundle="${or_labels}"/></td>--%>
	<th class=columnheader width='15%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
	<%
		}
		//IN062992, ends
	%>
	<th class=columnheader width='5%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>	
	<th class=columnheader width='15%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td> 
	<th class=columnheader width='15%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td> 
	<th class=columnheader width='15%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="eOR.DurnValue/DurnType.label" bundle="${or_labels}"/></td>
	<th class=columnheader width='10%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="eOR.TimeFrame.label" bundle="${or_labels}"/></td>
	<th class=columnheader width='10%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
	<th class=columnheader width='10%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.required.label" bundle="${common_labels}"/></td>
	<th class=columnheader width='5%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
	<th class=columnheader width='5%' align="left" style="position: sticky; top: 0; z-index: 1;"><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></td> 
</tr><!--IN065713-->
<!-----------------------Display Logic ------------------>

<%
		if(noOfRecords!= 0)
		{

			if(!act.equalsIgnoreCase("IndexSelect"))//i:e Ascc Mode
				bean.SortedArrayListAscc();

			HashMap recCurrent=null;
			String order_catalog_code ="";
			String order_catalog_desc ="";
			String order_set_seq_num  ="";
			String order_type_code    ="";
			//String order_category_rec ="";
			String qty_unit			  ="";
			String qty_uom_default	  ="";	
			String qty_uom_val        ="";
			String qty_uom_db         ="";
			String qty_uom_desc       ="";	
			String freq_code		  ="";
			String durn_value		  ="";
			String durn_type	      ="";
			String prompt_msg	      ="";
			String rel_start_date_time="";
			String reqd_or_opt_ind ="";
			String include="";
			String valid   = "";
			String DataBaseRecord ="";
			String eff_status="";
			String order_category1    ="";
			String route_code="";
			String route_desc="";
			String dosage_type = "";//IN062992
			String disableDosageType = "n";//IN062992
			String strength_value = "";//IN062992
			String strength_uom	= "";//IN062992
			

			for(int i=fm_disp-1; i < to_disp; i++)
			{		 
				classValue			="gridData";

				recCurrent  =(HashMap)bean.getRecord(i);	


				if(!bean.getDetailPageMode().trim().equalsIgnoreCase("A"))
					recCurrent			=bean.Validaty(recCurrent);//gives dataBase Record	Original

				order_category1 =(String)recCurrent.get("order_category");			
				order_catalog_code =(String)recCurrent.get("order_catalog_code");
				order_catalog_desc =(String)recCurrent.get("order_catalog_desc");
				order_set_seq_num  =(String)recCurrent.get("order_set_seq_num");
				order_type_code    =(String)recCurrent.get("order_type_code");

				route_code=(String)recCurrent.get("route_code");
				route_desc =bean.getRouteDesc(route_code);

				if(route_desc.equals("N"))
				{
					route_desc="";
				}

				if(order_category1.equals("PH"))
				{
					route_updatable = "N";		
				}
				else
				{
					route_updatable = "Y";		
				}
			

				if(order_catalog_code == null || order_catalog_code.equals("null")) order_catalog_code =" "; else order_catalog_code = order_catalog_code.trim();
				if(order_catalog_desc == null || order_catalog_desc.equals("null")) order_catalog_desc =" "; else order_catalog_desc = order_catalog_desc.trim();
				if(route_code == null || route_code.equals("null")) route_code =" "; else route_code = route_code.trim();

				String sqlParam[]  = {order_catalog_code.trim()};
				Hashtable defVal						=new Hashtable();

				// To display the default value for qty_UOM
				defVal = bean.settingsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);
				if(defVal.containsKey("*A"))
				{
					HashMap currRec					=(HashMap)defVal.get("*A");
					qty_uom_default =(String)currRec.get("qty_uom");
				}

				qty_uom_db           =(String)recCurrent.get("qty_value");
				if(qty_uom_db == null || qty_uom_db.equals("null") || qty_uom_db.equals("")) 
				qty_uom_val = qty_uom_default.trim(); else qty_uom_val = qty_uom_db.trim();

				strength_value		  = (String)(recCurrent.get("strength_value")==null?"":recCurrent.get("strength_value"));//IN062992
				strength_uom		  = (String)(recCurrent.get("strength_uom")==null?"":recCurrent.get("strength_uom"));//IN062992

				//IN062992, starts
				if(bean.isSiteSpecificYN() && "C".equals(l_applicable_to))
				{

					if("".equals(strength_value) || "0".equals(strength_value))
					{
						disableDosageType = "y";
					}
					else
					{
						disableDosageType = "n";
						qty_uom_val = strength_uom;
					}
				}
				//IN062992, ends
			
				qty_uom_desc =bean.getqty_uom_desc(qty_uom_val);
				if(qty_uom_desc.equals("N"))
				qty_uom_desc = "";
			 
			   /*   if(!qty_uom_db.equals("") && !qty_uom_db.equals("1")) 
				{
					qty_uom_default = "";
				}   */

				//order_category_rec =(String)recCurrent.get("order_category");
				qty_unit				 =(String)recCurrent.get("qty_unit");
				freq_code				 =(String)recCurrent.get("freq_code");
				durn_value				 =(String)recCurrent.get("durn_value");
				durn_type	             =(String)recCurrent.get("durn_type");		
				prompt_msg	             =(String)recCurrent.get("prompt_msg");

				if(prompt_msg == null || prompt_msg.equals("null")) prompt_msg =" "; else prompt_msg = prompt_msg.trim();

				/*Get options for freq and Order Type  */
				ArrayList freq_val = null;
				ArrayList freq_desc = null;
				freq_val		  = (ArrayList)recCurrent.get("freq_val_opts");
				freq_desc		  = (ArrayList)recCurrent.get("freq_desc_opts");
				ArrayList order_val		  = (ArrayList)recCurrent.get("order_val_opts");
				ArrayList order_desc	  = (ArrayList)recCurrent.get("order_desc_opts");
				rel_start_date_time		  =(String)recCurrent.get("rel_start_date_time");

				if(rel_start_date_time=="")
				{
					rel_start_date_time="0";
				}

				reqd_or_opt_ind           = (String)recCurrent.get("reqd_or_opt_ind");
				include		              = (String)recCurrent.get("associate_yn");

				qty_reqd_updatable		  = "";//Intialise
				qty_reqd_updatable		  = (String)recCurrent.get("qty_reqd_yn");
				dosage_type		  = (String)(recCurrent.get("dosage_type")==null?"":recCurrent.get("dosage_type"));//IN062992

				//IN062992, starts
				if(bean.isSiteSpecificYN() && "A".equals(dosage_type))
				{
					rel_start_date_time="";					
				}
				//IN062992, ends

				//order_category_rec = "";
				//order_catalog_code = "";
				valid   = "";
				qty_uom_updatable  = "";
				DataBaseRecord ="";

				if(bean.getDetailPageMode().equalsIgnoreCase("S"))
				{
					valid				  =(String)recCurrent.get("valid");
				}
				else
				{
					valid		   ="";
					qty_uom_updatable  = "";
					if(bean.getDetailPageMode().equalsIgnoreCase("A"))
						if(((String)recCurrent.get("valid")).equalsIgnoreCase("Y"))
						DataBaseRecord = "<B>" ;
				}				

				HashMap careSetHeaderStr = (HashMap)bean.getCareSetHeaderStr();

				if(careSetHeaderStr.size() > 0)
				{//In modify mode only when aff status is 'D' disabling all the record
					eff_status			=(String)careSetHeaderStr.get("eff_status");

					if(eff_status.trim().equalsIgnoreCase("D"))
					{
						valid = "Y";
						qty_reqd_updatable = "N";
						qty_uom_updatable  = "Y";
					}
				}
				



				if(valid.trim().equalsIgnoreCase("y"))
				{//i:E db Record
					qty_reqd_updatable = "N";
					qty_uom_updatable  = "Y";				
				}

				if(order_category1.equals("PH"))
				{
					qty_uom_updatable = "Y";		
				}


		%>

			<tr id='row<%=i%>'>
				<!-- Catalog Desc -->
				<!--<td id="Includes<%=i%>"></td>--><!--IN065713-->
				<!--IN065713, starts-->
				<td id="Includes<%=i%>"></td>
				<!--IN065713, ends-->
				<td class='<%=classValue%>' id="order_catalog_code<%=i%>"><%=order_catalog_code%>
				<input type="hidden" name="catalog_code<%=i%>" id="catalog_code<%=i%>"  value="<%=order_catalog_code%>">
				</td>
				<td class='<%=classValue%>'><%=DataBaseRecord%><%=order_catalog_desc%></td>

				<!-- Seq No -->
				<td class='<%=classValue%>' ><input type='text' name='order_set_seq_num<%=i%>' id='order_set_seq_num<%=i%>' onblur='parent.parent.parent.checkDecimal1(this)' size=3 maxlength=3	  <%=eHISFormatter.disabled("y",valid)%>  value='<%=order_set_seq_num%>' style="text-align:right"></td>

				<!-- Order type -->
				<td class='<%=classValue%>'><select name='order_type_code<%=i%>' id='order_type_code<%=i%>' <%=eHISFormatter.disabled("y",valid)%>>
				<%=eHISFormatter.populateList(order_val,order_desc,order_type_code)%></select>
				</td>

				<!--IN062992, starts-->
				<!--Dosage Type-->				
				<%if(bean.isSiteSpecificYN()) { if("C".equals(l_applicable_to)){%>
				<%--<td class='<%=classValue%>'><select name='dosage_type<%=i%>' id='dosage_type<%=i%>' <%=eHISFormatter.disabled("y",valid)%> <%=eHISFormatter.disabled("y",disableDosageType)%> onchange='showDosageTypeAgeDetails("<%=i%>")'><option value="" <%=eHISFormatter.select(dosage_type,"")%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><option value='K' <%=eHISFormatter.select(dosage_type,"K")%>><fmt:message key="eOR.Kg.label" bundle="${or_labels}"/></option><option value='M' <%=eHISFormatter.select(dosage_type,"M")%>><fmt:message key="eOR.M2.label" bundle="${or_labels}"/></option><option value='A' <%=eHISFormatter.select(dosage_type,"A")%>><fmt:message key="eOR.Age.label" bundle="${or_labels}"/></option></select><span id='dosage_type_age<%=i%>' name='dosage_type_age' style='<%if(dosage_type.equals("A")){%>display:inline<%}else{%>display:none<%}%>'>&nbsp;<img src="../images/Age.gif" align=center width='25' height = '25' title = 'Age Wise Definition' alt = 'Age Wise Definition' style="width:25px;height:25px;border:none;outline:none;cursor:pointer;" <%if(!eHISFormatter.disabled("y",valid).equals("disabled")){%> onclick='showDosageAgeWiseDetails("<%=i%>")' <%}%><%=eHISFormatter.disabled("y",valid)%>></span>
				</td>--%><!--IN065713--><!--IN68241-->
				<%--<td class='<%=classValue%>'><select name='dosage_type<%=i%>' id='dosage_type<%=i%>' <%=eHISFormatter.disabled("y",valid)%> <%=eHISFormatter.disabled("y",disableDosageType)%> onchange='showDosageTypeAgeDetails("<%=i%>")'><option value="" <%=eHISFormatter.select(dosage_type,"")%>>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option><option value='K' <%=eHISFormatter.select(dosage_type,"K")%>><fmt:message key="eOR.Kg.label" bundle="${or_labels}"/></option><option value='M' <%=eHISFormatter.select(dosage_type,"M")%>><fmt:message key="eOR.M2.label" bundle="${or_labels}"/></option><option value='A' <%=eHISFormatter.select(dosage_type,"A")%>><fmt:message key="eOR.Age.label" bundle="${or_labels}"/></option></select>--%><!--IN065713--><!--IN68241-->
				<td class='<%=classValue%>'><a href='#' <%=eHISFormatter.disabled("y",disableDosageType)%> <%if("n".equals(disableDosageType)){%>onclick='showDosageTypeDefWindow("<%=i%>")'<%}%>><fmt:message key="eOR.DosageTypeDefn.label" bundle="${or_labels}"/></a></td><!--IN68241-->
				</td>
				<%}
				else
				{
				dosage_type = "";
				%>
				<input type='hidden' name = 'dosage_type<%=i%>' value = ''/>
				<%}
				}%>
				<!--IN062992, ends-->

				<!-- Qty unit -->
				<!--IN062992, starts-->
				<!--<td class='<%=classValue%>'><input type='text' name='qty_unit<%=i%>' id='qty_unit<%=i%>' onKeyPress='return(parent.parent.parent.checkValid(this,event,6,5))' size=6 maxlength=6   <%=eHISFormatter.disabled("n",qty_reqd_updatable)%> value='<%=qty_unit%>' style="text-align:right"></td>-->
				
				<td class='<%=classValue%>'><input type='text' name='qty_unit<%=i%>' id='qty_unit<%=i%>' onKeyPress='return(parent.parent.parent.checkValid(this,event,6,5))' size=6 maxlength=6   <%=eHISFormatter.disabled("n",qty_reqd_updatable)%> <%=eHISFormatter.disabled("A",dosage_type)%>  value='<%=qty_unit%>' style="text-align:right"></td>
				<!--IN062992, ends-->

				<!-- UOM unit     -->				
				<td class='<%=classValue%>'>
				<input type="hidden" name="qty_uom<%=i%>" id="qty_uom<%=i%>" value="<%=qty_uom_val%>" >
		  
				
		<!--	    <input type="hidden" name="qty_uom_default<%=i%>" id="qty_uom_default<%=i%>" value="<%=qty_uom_default%>" >   
			
				<input type="text" name="qty_uom_desc<%=i%>" id="qty_uom_desc<%=i%>" size=8 maxlength=8 value="<%=qty_uom_desc%>" <%=eHISFormatter.disabled("y",qty_uom_updatable)%> 
		onblur="parent.parent.parent.show_qty_uom_window(qty_uom_desc<%=i%>,qty_uom<%=i%>,<%=i%>,qty_uom_default<%=i%>);" >   		    -->

				<input type="text" name="qty_uom_desc<%=i%>" id="qty_uom_desc<%=i%>" size=8 maxlength=8 value="<%=qty_uom_desc%>" <%=eHISFormatter.disabled("y",qty_uom_updatable)%> onblur="parent.parent.parent.show_qty_uom_window(qty_uom_desc<%=i%>,qty_uom<%=i%>,<%=i%>);" ><input type="button" name="qty_uom_button<%=i%>" id="qty_uom_button<%=i%>" class='button' style="<%=uom_style%>" value='?' <%=eHISFormatter.disabled("y",qty_uom_updatable)%>
		onclick="parent.parent.parent.show_qty_uom_Lookupwindow(qty_uom_desc<%=i%>,qty_uom<%=i%>,<%=i%>);" >	
				</td>

				<!-- fREQ unit -->
				<td class='<%=classValue%>'><SELECT name="freq_code<%=i%>" id="freq_code<%=i%>"  <%=eHISFormatter.disabled("y",valid)%> 1 <%=eHISFormatter.chkReturn("y",freq_code_updatable,"","disabled")%> <%=eHISFormatter.disabled("A",dosage_type)%> onchange='parent.parent.parent.getDurnType(this,"<%=i%>")'><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
				<%=eHISFormatter.populateList(freq_val,freq_desc,freq_code)%></SELECT>
				</td>

				<%
				//IN062992, starts
				if(!freq_val.contains(freq_code))	
				{
					durn_value = "";
					durn_type = "";
				}
				//IN062992, ends
				%>				

				<!-- Durn Val/Durn Desc -->
				<!--IN062992, starts-->
				<!--<td class='<%=classValue%>' nowrap>
				<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" size='3' maxlength='3'	class="number" <%=eHISFormatter.disabled("y",freq_code_updatable)%> 
				onblur='parent.parent.parent.OrCheckPositiveNumber1(this)'
				value="<%=durn_value%>">/<input type="text"  readonly name="durn_type_desc<%=i%>" id="durn_type_desc<%=i%>"	 size='3' <%=eHISFormatter.disabled("y",valid)%>  value="<%=decode(durn_type.trim())%>"></td>-->
				<td class='<%=classValue%>' nowrap>
				<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" size='3' maxlength='3'	class="number" <%=eHISFormatter.disabled("y",freq_code_updatable)%> <%=eHISFormatter.disabled("A",dosage_type)%>
				onblur='parent.parent.parent.OrCheckPositiveNumber1(this)'
				value="<%=durn_value%>">/<input type="text"  readonly name="durn_type_desc<%=i%>" id="durn_type_desc<%=i%>"	 size='3' <%=eHISFormatter.disabled("y",valid)%>  value="<%=decode(durn_type.trim())%>"></td>
				<input type='hidden' name='durn_type<%=i%>' id='durn_type<%=i%>' value="<%=durn_type.trim()%>" >
				<!--IN062992, ends-->

				<!-- time Frame -->
				<!--IN062992, starts-->
				<!--<td>
				<input type="text" name="rel_start_date_time<%=i%>" id="rel_start_date_time<%=i%>"	size='3'
				onblur='checkDecimal2(this)'
				<%=eHISFormatter.disabled("y",valid)%>  class='number' maxlength="3" value="<%=rel_start_date_time%>"><fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>-->
				<td nowrap>
				<input type="text" name="rel_start_date_time<%=i%>" id="rel_start_date_time<%=i%>"	size='3'
				onblur='checkDecimal2(this)'
				<%=eHISFormatter.disabled("y",valid)%> <%=eHISFormatter.disabled("A",dosage_type)%> class='number' maxlength="3" value="<%=rel_start_date_time%>"><fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>
				<!--IN062992, ends-->

				<!--IN062992, starts-->
				<!--<td class='<%=classValue%>'>
				<input type="hidden" name="route_code<%=i%>" id="route_code<%=i%>" value="<%=route_code%>">
				<input type="text" name="route_desc<%=i%>" id="route_desc<%=i%>" size=8 maxlength=8 value="<%=route_desc%>" <%=eHISFormatter.disabled("y",route_updatable)%> onblur="parent.parent.parent.show_route_window(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'detailLowerForm')" ><input type="button" name="route_button<%=i%>" id="route_button<%=i%>" class='button' style="<%=route_style%>" value='?' <%=eHISFormatter.disabled("y",route_updatable)%>
				onclick="parent.parent.parent.show_route_Lookupwindow(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'detailLowerForm')">	
				</td> -->
				<td class='<%=classValue%>' nowrap>
				<input type="hidden" name="route_code<%=i%>" id="route_code<%=i%>" value="<%=route_code%>">
				<input type="text" name="route_desc<%=i%>" id="route_desc<%=i%>" size=8 maxlength=8 value="<%=route_desc%>" <%=eHISFormatter.disabled("y",valid)%> <%=eHISFormatter.disabled("A",dosage_type)%> onblur="parent.parent.parent.show_route_window(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'detailLowerForm')" ><input type="button" name="route_button<%=i%>" id="route_button<%=i%>" class='button' style="<%=route_style%>" value='?' <%=eHISFormatter.disabled("y",valid)%> <%=eHISFormatter.disabled("A",dosage_type)%>				onclick="parent.parent.parent.show_route_Lookupwindow(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'detailLowerForm')">	
				</td>
				<!--IN062992, ends-->

				<!--Required-->
				<td class='<%=classValue%>' >
				<SELECT name="reqd_or_opt_ind<%=i%>" id="reqd_or_opt_ind<%=i%>" <%=eHISFormatter.disabled("y",valid)%>    <%=eHISFormatter.chkReturn("y",reqd_or_opt_ind_updatable,"","disabled")%> >
				<option value="R" <%=eHISFormatter.select(reqd_or_opt_ind,"R")%>><fmt:message key="Common.required.label" bundle="${common_labels}"/></option>
				<option value="O" <%=eHISFormatter.select(reqd_or_opt_ind,"O")%>><fmt:message key="eOR.OptionalPreSelected.label" bundle="${or_labels}"/></option>
				<option value="D" <%=eHISFormatter.select(reqd_or_opt_ind,"D")%>><fmt:message key="eOR.OptionalDeSelected.label" bundle="${or_labels}"/></option>
				</SELECT></td>

				<!--Include-->
				<!--IN062992, starts-->
				<!-- <td class='<%=classValue%>' ><input type='checkbox' name='include<%=i%>' id='include<%=i%>' onclick="parent.parent.parent.chkInclude('<%=i%>');Includes('<%=i%>','<%=order_category%>')" value='Y' <%=eHISFormatter.disabled("y",valid)%>  <%=eHISFormatter.ChkBoxChecked("y",include)%> onClick=''></td> -->
				<td class='<%=classValue%>' ><input type='checkbox' name='include<%=i%>' id='include<%=i%>' onclick="parent.parent.parent.chkInclude('<%=i%>');Includes('<%=i%>','<%=order_category%>','<%=l_applicable_to%>')" value='Y' <%=eHISFormatter.disabled("y",valid)%>  <%=eHISFormatter.ChkBoxChecked("y",include)%> onClick=''></td>
				<!--IN062992, ends-->

				<!---------comments------->

				<!--IN062992, starts-->
				<!--<td class='<%=classValue%>' ><A class='gridLink' name='Cmts<%=i%>' HREF='javascript:parent.parent.parent.showDialog("<%=i%>")'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></A></td>-->
				<%if(dosage_type.equals("A")){%>
				<td class='<%=classValue%>' ><A name='Cmts<%=i%>' HREF='#' disabled style='cursor:none'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></A></td>
				<%
				}
				else
				{
				%>
				<td class='<%=classValue%>' ><A class='gridLink' name='Cmts<%=i%>' HREF='javascript:parent.parent.parent.showDialog("<%=i%>")'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></A></td>
				<%
				}
				%>
				
				
			
			
				
				<!--IN062992, ends-->
				<INPUT TYPE="hidden" name="prompt_msg<%=i%>" id="prompt_msg<%=i%>" value="<%=prompt_msg%>"> 
				<INPUT TYPE="hidden" name="order_catalog_desc<%=i%>" id="order_catalog_desc<%=i%>" value="<%=order_catalog_desc%>"><!--IN062992-->
				<INPUT TYPE="hidden" name="qty_reqd_yn<%=i%>" id="qty_reqd_yn<%=i%>" value="<%=qty_reqd_updatable%>"><!--IN062992-->
				<input type="hidden" name="freq_code_val<%=i%>" id="freq_code_val<%=i%>" value="<%=freq_code%>"><!--IN062992-->
				<input type="hidden" name="durn_code_val<%=i%>" id="durn_code_val<%=i%>" value="<%=durn_value%>"><!--IN062992-->
				<input type="hidden" name="durn_desc_val<%=i%>" id="durn_desc_val<%=i%>" value="<%=durn_type%>"><!--IN062992-->
				<input type="hidden" name="dis_comments<%=i%>" id="dis_comments<%=i%>" value="<%=valid%>"><!--IN065021-->
				<input type="hidden" name="valid<%=i%>" id="valid<%=i%>" value="<%=valid%>">
					
			</tr>
			
			
				<tr id="div0"></tr>
						
			  <script>parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="</script>
			<%
			}//END OF FOR LOOP%>
			
			 <input type="hidden" name="eff_status" id="eff_status" value="<%=eff_status%>"> 
			<%
		}
		else
		{
		%>
		<script>		
			var message  = parent.parent.parent.getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");
			parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ message;
		</script>
		<%
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	%>

<table>

<input type="hidden" name="mode" id="mode" value="1">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type='hidden' name='tabType' id='tabType' value="C" >
<input type='hidden' name='nextPrevFlag' id='nextPrevFlag' value='<%=nextPrevFlag%>' >
<input type="hidden" name="noOfRecords" id="noOfRecords" value="<%=noOfRecords%>">
<input type='hidden' name='previousRecord' id='previousRecord' value='<%=fm_disp%>' >
<input type='hidden' name='nextRecord' id='nextRecord' value='<%=to_disp%>' >
<input type='hidden' name='order_category' id='order_category' value='<%=order_category%>' >
<input type='hidden' name='OrderCatalogIndex' id='OrderCatalogIndex' value='' >
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type='hidden' name='detailPageMode' id='detailPageMode' value='<%=bean.getDetailPageMode()%>' >
<input type='hidden' name='action' id='action' value='<%=bean.getAction()%>' >
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="p_appl_to" id="p_appl_to" value="<%=l_applicable_to%>"><!--IN062992-->
<input type="hidden" name="p_invoke_func" id="p_invoke_func" value="<%=l_invoke_func%>">
<input type="hidden" name="p_applicable_to" id="p_applicable_to" value="<%=l_applicable_to%>">
<%
	putObjectInBean(bean_id,bean,request); 
%>
</form>
</body>
<script>
	//showIncluded('<%=order_category%>');//IN062992
	showIncluded('<%=order_category%>','<%=l_applicable_to%>');//IN062992
</script>
</html>

