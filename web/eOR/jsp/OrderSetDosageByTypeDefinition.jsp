<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
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


<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<title><fmt:message key="eOR.ByDosageTypeDefn.label" bundle="${or_labels}"/></title>
</head>
<%
	try
	{
		String bean_id = "Or_CareSet" ;
		String bean_name = "eOR.CareSetBean";
		int i = 0;		
		CareSetBean bean = (CareSetBean)getBeanObject( bean_id,  bean_name, request ) ;
		bean.setLanguageId(localeName);
		String classValue ="gridData";
		String freq_code		  ="";
		String durn_value		  ="";
		String durn_type	      ="";
		String prompt_msg	      ="";
		String rel_start_date_time="0";
		String include="";
		String valid   = "";
		String route_code="";
		String route_desc="";
		String dosage_type = "";
		String freq_code_updatable = "Y";
		String qty_reqd_updatable = "Y";
		String route_updatable = "";
		String route_style    = "" ;
		
		String l_order_set_code  = request.getParameter("p_order_set_code")==null?"":request.getParameter("p_order_set_code");	
		String l_order_catalog_code  = request.getParameter("p_order_catalog_code")==null?"":request.getParameter("p_order_catalog_code");
		
		if("".equals(l_order_catalog_code))
			l_order_catalog_code  = request.getParameter("order_category_code")==null?"":request.getParameter("order_category_code");
		String l_qty_uom_code  = request.getParameter("p_qty_uom_code")==null?"":request.getParameter("p_qty_uom_code");
		String l_qty_uom_desc  = request.getParameter("qty_uom_desc")==null?"":request.getParameter("qty_uom_desc");
		String l_order_catalog_desc  = request.getParameter("p_order_catalog_desc")==null?"":request.getParameter("p_order_catalog_desc");
		if("".equals(l_order_catalog_desc))
			l_order_catalog_desc  = request.getParameter("order_category_desc")==null?"":request.getParameter("order_category_desc");
		String l_order_set_seq_num  = request.getParameter("p_order_set_seq_num")==null?"":request.getParameter("p_order_set_seq_num");
		if("".equals(l_order_set_seq_num))
			l_order_set_seq_num  = request.getParameter("order_set_seq_num")==null?"":request.getParameter("order_set_seq_num");
		
		String l_qty_reqd_yn  = request.getParameter("p_qty_reqd_yn")==null?"":request.getParameter("p_qty_reqd_yn");
		String l_qty_unit  = request.getParameter("p_qty_unit")==null?"":request.getParameter("p_qty_unit");
		//String l_order_type_desc = request.getParameter("p_order_type_desc")==null?"":request.getParameter("p_order_type_desc");
		//if("".equals(l_order_type_desc))
		String l_order_type_desc = request.getParameter("order_type")==null?"":request.getParameter("order_type");
		String l_seq_num = request.getParameter("p_seq_num")==null?"":request.getParameter("p_seq_num");
		String l_rel_start_date_time = request.getParameter("p_rel_start_date_time")==null?"":request.getParameter("p_rel_start_date_time");
		String l_route_code = request.getParameter("p_route_code")==null?"":request.getParameter("p_route_code");
		String l_route_desc = request.getParameter("p_route_desc")==null?"":request.getParameter("p_route_desc");
		String l_query_string = request.getParameter("p_query_string")==null?"":request.getParameter("p_query_string");
		String l_reqd_or_opt_ind = request.getParameter("p_reqd_or_opt_ind")==null?"":request.getParameter("p_reqd_or_opt_ind");
		String l_applicable_to = request.getParameter("p_applicable_to")==null?"":request.getParameter("p_applicable_to");
		String l_selectedCatIndex = request.getParameter("selectedCatIndex")==null?"":request.getParameter("selectedCatIndex");
		String l_order_type_code =  request.getParameter("p_order_type_code")==null?"":request.getParameter("p_order_type_code");
		if("".equals(l_order_type_code))
			l_order_type_code  = request.getParameter("order_type")==null?"":request.getParameter("order_type");
		prompt_msg = request.getParameter("p_prompt_msg")==null?"":request.getParameter("p_prompt_msg");
		
		valid = request.getParameter("valid")==null?"":request.getParameter("valid");
		
		String l_min_age = "";		
		String l_max_age = "";
		String l_min_age_unit = "";
		String l_max_age_unit = "";		
		String l_age_group_desc = "";
		String l_age_group_code = "";
		String l_add_cata_age_grp_disp = "visibility:hidden";
		String l_fetch_dosage_type = "";
		String l_dosage_type = "";
		String l_dosage_type_seq_no = "";
		String eff_status = "";
		
		String[] displaySeq = {"K","M","A"};		
		String l_selected_dosage_type_seq_no = "";
		HashMap records = bean.getDosageTypeHashValues();
%>
<body>
<form name='orderset_by_dosage_type_dtl_form' id='orderset_by_dosage_type_dtl_form'>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td>
<table cellpadding='3' cellspacing='0' border='1' width='100%' align='center' class='grid'>
	<tr>
		<td class=columnheader width='15%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class='<%=classValue%>' colspan='11'><b><%=l_order_catalog_desc%></b></td>
	</tr>
	<tr>
		<td class='<%=classValue%>' colspan='12'>&nbsp;</td>
	</tr>
</table>
</td>
</tr>
<tr>
<td>
<table cellpadding='3' cellspacing='0' border='1' width='100%' align='center' class='grid'>
	<tr>	
		<td class=columnheader width='1%'>&nbsp;</td>
		<td class=columnheader width='5%'><fmt:message key="eOR.SeqNo.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='5%'><fmt:message key="eOR.OccurranceNo.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='5%'><fmt:message key="eOR.DosageType.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='5%'><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='5%'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td> 
		<td class=columnheader width='15%'><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td> 
		<td class=columnheader width='10%'><fmt:message key="eOR.DurnValue/DurnType.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='5%'><fmt:message key="eOR.TimeFrame.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='10%'><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='5%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='5%'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></td>
	</tr>
	<%
	for(i=0;i<displaySeq.length;i++)
	{		
		l_fetch_dosage_type = displaySeq[i];
		HashMap hashindexAgeGrpWise = null;
		HashMap hashindexCatalogWise = null;		
		
		if(records.containsKey(l_order_catalog_code))
		{
			hashindexCatalogWise = (HashMap)records.get(l_order_catalog_code);
			
			if(hashindexCatalogWise!=null && hashindexCatalogWise.containsKey(l_fetch_dosage_type))
				hashindexAgeGrpWise = (HashMap)hashindexCatalogWise.get(l_fetch_dosage_type);
		}
		
		if(hashindexAgeGrpWise!=null)
		{
			include = "y";
			
			l_add_cata_age_grp_disp = "visibility:visible";
			
			l_qty_unit = (String)hashindexAgeGrpWise.get("qty_value");
				if(l_qty_unit==null)l_qty_unit="";
			
			l_dosage_type = (String)hashindexAgeGrpWise.get("dosage_type");
				if(l_dosage_type==null)l_dosage_type="";
	
			/*l_qty_uom_code = (String)hashindexAgeGrpWise.get("qty_unit");
				if(l_qty_uom_code==null)l_qty_uom_code="";*/
	
			freq_code = (String)hashindexAgeGrpWise.get("freq_code");
				if(freq_code==null)freq_code="";
	
			durn_value = (String)hashindexAgeGrpWise.get("durn_value");
				if(durn_value==null)durn_value="";
	
			durn_type = (String)hashindexAgeGrpWise.get("durn_type");
				if(durn_type==null)durn_type="";
	
			rel_start_date_time  = (String)hashindexAgeGrpWise.get("rel_start_date_time");
				if(rel_start_date_time==null)rel_start_date_time="";			
			
			route_code = (String)hashindexAgeGrpWise.get("route_code");
				if(route_code==null) route_code="" ;
	
			route_desc = (String)hashindexAgeGrpWise.get("route_desc");
				if(route_desc==null) route_desc="" ;
	
			prompt_msg = (String)hashindexAgeGrpWise.get("prompt_msg");
				if(prompt_msg==null) prompt_msg="" ;
				
			l_qty_uom_code = (String)hashindexAgeGrpWise.get("qty_uom");
			if(l_qty_uom_code==null) l_qty_uom_code="" ;
				
			l_dosage_type_seq_no = (String)hashindexAgeGrpWise.get("dosage_type_seq_no");
			if(l_dosage_type_seq_no==null)l_dosage_type_seq_no="";			
		}
		else
		{
			include = "";	
			l_add_cata_age_grp_disp = "visibility:hidden";
			rel_start_date_time  = "";
			l_qty_uom_code = "";
			route_desc = "";
			route_code = "" ;
			prompt_msg = "" ;
			freq_code = request.getParameter("p_freq_code")==null?"":request.getParameter("p_freq_code");
			durn_value = request.getParameter("p_durn_code")==null?"":request.getParameter("p_durn_code");
			durn_type = request.getParameter("p_durn_type")==null?"":request.getParameter("p_durn_type");
			l_qty_unit = request.getParameter("p_qty_unit")==null?"":request.getParameter("p_qty_unit");			
			l_qty_uom_code = request.getParameter("p_qty_uom_code")==null?"":request.getParameter("p_qty_uom_code");
			l_qty_uom_desc = request.getParameter("qty_uom_desc")==null?"":request.getParameter("qty_uom_desc");
			rel_start_date_time = request.getParameter("p_rel_start_date_time")==null?"":request.getParameter("p_rel_start_date_time");
			route_code = request.getParameter("p_route_code")==null?"":request.getParameter("p_route_code");
			route_desc = request.getParameter("p_route_desc")==null?"":request.getParameter("p_route_desc");
			prompt_msg = request.getParameter("p_prompt_msg")==null?"":request.getParameter("p_prompt_msg");
			l_dosage_type_seq_no = "";			
		}
	%>
	<tr>	
		<%
		if("K".equals(l_fetch_dosage_type) || "M".equals(l_fetch_dosage_type))
		{
		%>
		<td id='Includes<%=i%>' class='<%=classValue%>' width='3%' style='<%=l_add_cata_age_grp_disp%>'><a href="javascript:callDosageTypeAdditionalRows('<%=i%>')">+</a></td>
		<%
		}
		else
		{
		%>
		<td id='Includes<%=i%>' class='<%=classValue%>' width='3%' style='<%=l_add_cata_age_grp_disp%>'><a href="javascript:showDosageAgeWiseDetails('<%=i%>')"><img src='../images/Age.gif'></a></td>
		<%
		}
		%>
		<td class='<%=classValue%>' DISABLED><input type='text' name='order_set_seq_num<%=i%>' id='order_set_seq_num<%=i%>' size=3 maxlength=3 value='<%=l_order_set_seq_num%>' style="text-align:right" readonly></td>		
		<td class='<%=classValue%>' width='5%'>
		<select name='dosage_type_seq_no<%=i%>' id='dosage_type_seq_no<%=i%>' onchange='validateDuplicateDosageTypeSeqNo("<%=i%>","0","3")' <%=eHISFormatter.disabled("y",valid)%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<%
		for(int idx=1;idx<=3;idx++)
		{
			l_selected_dosage_type_seq_no = "";
			

			
			if(l_dosage_type_seq_no.equals(""))
			{				
				if(i+1==idx)
					l_selected_dosage_type_seq_no = "selected";
			}
			else
			{
				if(l_dosage_type_seq_no.equals(String.valueOf(idx)))
					l_selected_dosage_type_seq_no = "selected";
			}
		%>		
		<option value='<%=idx%>' <%=l_selected_dosage_type_seq_no%>><%=idx%></option>
		<%
		}
		%>
		</select>
		</td>
		<td class='<%=classValue%>' width='5%'>
		<%
		if("K".equals(l_fetch_dosage_type))
		{%>
		<fmt:message key="eOR.Kg.label" bundle="${or_labels}"/><%
		}
		else if("M".equals(l_fetch_dosage_type))
		{%>
		<fmt:message key="eOR.M2.label" bundle="${or_labels}"/><%
		}
		else if("A".equals(l_fetch_dosage_type))
		{%>
		<fmt:message key="eOR.Age.label" bundle="${or_labels}"/><%
		}
		%></td>
		<td class='<%=classValue%>'><input type='text' name='qty_unit<%=i%>' id='qty_unit<%=i%>' onKeyPress='return(parent.parent.parent.checkValid(this,event,6,5))' size='6' maxlength='6'   <%=eHISFormatter.disabled("n",l_qty_reqd_yn)%> <%=eHISFormatter.disabled("y",valid)%> value='<%=l_qty_unit%>' style="text-align:right"></td>
		
		<td class='<%=classValue%>'><%=l_qty_uom_desc%></td>	

		<td class='<%=classValue%>'>
			<SELECT name="freq_code<%=i%>" id="freq_code<%=i%>" onchange='parent.parent.parent.getDurnType(this,"<%=i%>","orderset_by_dosage_type_dtl_form")' <%=eHISFormatter.disabled("y",valid)%>><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<%
			ArrayList frequencyList = bean.getFrequency("PH",l_order_catalog_code) ;
			String[] freqRecord=null;
			for(int freqInd=0; freqInd<frequencyList.size(); freqInd++)
			{
				freqRecord = (String[])frequencyList.get(freqInd);
				
				if(freq_code.equals(freqRecord[0]))
					out.println("<option value = '"+freqRecord[0]+"'  selected > "+freqRecord[1]+" ");	
				else
					out.println("<option value = '"+freqRecord[0]+"' > "+freqRecord[1]+" ");	 

				out.println("</option>");
			}
		%>
		 	</SELECT>
		</td>		
		<td class='<%=classValue%>' nowrap>		
		<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" size='3' maxlength='3'	class="number" <%=eHISFormatter.disabled("",freq_code)%>
		onblur='parent.parent.parent.OrCheckPositiveNumber1(this)'
		value="<%=durn_value%>">/<input type="text"  disabled name="durn_type_desc<%=i%>" id="durn_type_desc<%=i%>"	 size='3' <%=eHISFormatter.disabled("y",valid)%>  value="<%=bean.decode(durn_type.trim())%>"></td>
		<input type='hidden' name='durn_type<%=i%>' id='durn_type<%=i%>' value="<%=durn_type.trim()%>" >
		
		<td class='<%=classValue%>'>
		<input type="text" name="rel_start_date_time<%=i%>" id="rel_start_date_time<%=i%>"	size='3'
		onblur='checkDecimal2(this)'
		<%=eHISFormatter.disabled("y",valid)%> <%=eHISFormatter.disabled("A",dosage_type)%> class='number' maxlength="3" value="<%=rel_start_date_time%>"><fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>

		<td class='<%=classValue%>'>
		<input type="hidden" name="route_code<%=i%>" id="route_code<%=i%>" value="<%=route_code%>">
		<input type="text" name="route_desc<%=i%>" id="route_desc<%=i%>" size='8' maxlength='8' value="<%=route_desc%>" <%=eHISFormatter.disabled("y",route_updatable)%> <%=eHISFormatter.disabled("A",dosage_type)%> <%=eHISFormatter.disabled("y",valid)%> onblur="parent.parent.parent.show_route_window(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'orderset_by_dosage_type_dtl_form')" ><input type="button" name="route_button<%=i%>" id="route_button<%=i%>" class='button' style="<%=route_style%>" value='?' <%=eHISFormatter.disabled("y",route_updatable)%> <%=eHISFormatter.disabled("A",dosage_type)%> <%=eHISFormatter.disabled("y",valid)%> onclick="parent.parent.parent.show_route_Lookupwindow(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'orderset_by_dosage_type_dtl_form')">	
		</td>


		<td class='<%=classValue%>' ><input type='checkbox' name='include<%=i%>' id='include<%=i%>' onclick="IncludesByDosageType('<%=i%>','PH','','<%=l_fetch_dosage_type%>','<%=l_order_catalog_code%>');" value='Y' <%=eHISFormatter.disabled("y",valid)%>  <%=eHISFormatter.ChkBoxChecked("y",include)%>></td>

		<td class='<%=classValue%>' ><a class='gridLink' name='Cmts<%=i%>' href='javascript:showDialog("<%=i%>","orderset_by_dosage_type_dtl_form")'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></a></td>
		</tr>			
			
		<INPUT type = 'hidden' name='prompt_msg<%=i%>' id='prompt_msg<%=i%>' value='<%=prompt_msg%>'> 
		<input type="hidden" name="qty_uom<%=i%>" id="qty_uom<%=i%>" value="<%=l_qty_uom_code%>">
		<input type="hidden" name="qty_reqd_yn<%=i%>" id="qty_reqd_yn<%=i%>" value="<%=l_qty_reqd_yn%>">		
		<input type ='hidden' name = 'qty_uom_desc<%=i%>' value = '<%=l_qty_uom_desc%>'/>
		<input type ='hidden' name = 'reqd_or_opt_ind<%=i%>' value = '<%=l_reqd_or_opt_ind%>'/>
		<input type ='hidden' name = 'p_fetch_dosage_type<%=i%>' value = '<%=l_fetch_dosage_type%>'/>
	</tr>
	<%
	}
	%>
	</td>
	</tr>
<table>

<input type="hidden" name="mode" id="mode" value="1">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type='hidden' name ='p_order_catalog_code' value = '<%=l_order_catalog_code%>'/>
<input type='hidden' name ='p_order_set_seq_num' value = '<%=l_order_set_seq_num%>'/>
<input type="hidden" name="p_qty_uom" id="p_qty_uom" value="<%=l_qty_uom_code%>">
<input type ='hidden' name = 'qty_uom_desc' value = '<%=l_qty_uom_desc%>'/>
<input type ='hidden' name = 'qty_unit' value = '<%=l_qty_unit%>'/>
<input type="hidden" name="qty_reqd_yn" id="qty_reqd_yn" value="<%=l_qty_reqd_yn%>">	
<input type='hidden' name='detailPageMode' id='detailPageMode' value='<%=bean.getDetailPageMode()%>' >
<input type='hidden' name='p_query_string' id='p_query_string' value='<%=l_query_string%>'>
<input type="hidden" name="p_invoke_func" id="p_invoke_func" value="DOSAGE_TYPE_DEFN">
<input type="hidden" name="p_age_grp_code" id="p_age_grp_code" value="">
<input type="hidden" name="eff_status" id="eff_status" value="E">
<input type="hidden" name="order_category" id="order_category" value="PH">
<input type="hidden" name="p_appl_to" id="p_appl_to" value="<%=l_applicable_to%>">
<input type="hidden" name="p_order_catalog_desc" id="p_order_catalog_desc" value="<%=l_order_catalog_desc%>">
<input type='hidden' name ='p_order_type_code' value = '<%=l_order_type_code%>'/>
<input type='hidden' name ='order_type' value = '<%=l_order_type_desc%>'/>
<input type='hidden' name ='p_selectedCatIndex' value = '<%=l_selectedCatIndex%>'/>
<input type='hidden' name ='valid' value = '<%=valid%>'/>
</form>
			
<%
	putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</body>
</html>

