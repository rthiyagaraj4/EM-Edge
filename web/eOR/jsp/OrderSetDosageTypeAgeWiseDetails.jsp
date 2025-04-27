<!--
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		07/08/2017		Ramesh G		ML-MMOH-CRF-0345.1
																			Created this file for this CRF
21/08/2017	IN065036		Dinesh T		07/08/2017		Ramesh G		wrong age group range showing in Order Set -Age Wise 																			Definition window
12/02/2018	IN065713		Dinesh T		12/02/2018		Ramesh G		ML-MMOH-CRF-0987
09/08/2018  IN068201        Ramya Maddena    10/08/2018     Ramesh G        Ml-MMOH-SCF-1056
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
<%!
	String decode(String code)
	{
	  if(code.equalsIgnoreCase("H")) return "Hour(s)";
	  if(code.equalsIgnoreCase("D")) return "Day(s)";
	  if(code.equalsIgnoreCase("W")) return "Week(s)";
	  if(code.equalsIgnoreCase("L")) return "Month(s)";
  	  if(code.equalsIgnoreCase("M")) return "Minute(s)";
  	  if(code.equalsIgnoreCase("Y")) return "Year(s)";
	  return "";
	}

	//IN065036, starts
	String decodeForAgeGrp(String code)
	{
		if(code.equalsIgnoreCase("D")) return "Day";
		if(code.equalsIgnoreCase("H")) return "Hours";
		if(code.equalsIgnoreCase("N")) return "Minute";
		if(code.equalsIgnoreCase("M")) return "Month";
		if(code.equalsIgnoreCase("Y")) return "Year";  	  
		return "";
	}
	//IN065036, ends
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
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
	String rel_start_date_time="";
	String include="";
	String valid   = "";
	String route_code="";
	String route_desc="";
	String dosage_type = "";
	String freq_code_updatable = "Y";
	//String qty_reqd_updatable = "Y";//check style issue
	String route_updatable = "";
	String route_style    = "" ;
	String durn_value_updatable = "y";

	bean.setSettingsAgeGroupStr();
	HashMap   settingsAgeGroupStr	 =  bean.getSettingsAgeGroupStr();	
	
	settingsAgeGroupStr.put("AGE_GROUP_DESC0","ALL");
	settingsAgeGroupStr.put("AGE_GROUP_CODE0","*A");
	settingsAgeGroupStr.put("QTY_UNIT0","");
	settingsAgeGroupStr.put("FREQ_CODE0","");
	settingsAgeGroupStr.put("DURN_VALUE0","");
	settingsAgeGroupStr.put("DURN_TYPE0","");
	settingsAgeGroupStr.put("REL_START_DATE_TIME0","");
	settingsAgeGroupStr.put("ROUTE_CODE0","");
	settingsAgeGroupStr.put("ROUTE_DESC0","");
	settingsAgeGroupStr.put("PROMPT_MSG0","");
	
	Integer	noOfRecTempAgeGroup		 = (Integer)settingsAgeGroupStr.get("noRec");
	int ageGroupSize = noOfRecTempAgeGroup.intValue() ;
	String l_order_catalog_code  = request.getParameter("p_order_catalog_code")==null?"":request.getParameter("p_order_catalog_code");
	String l_qty_uom_code  = request.getParameter("p_qty_uom_code")==null?"":request.getParameter("p_qty_uom_code");
	//String l_qty_uom_desc  = request.getParameter("p_qty_uom_desc")==null?"":request.getParameter("p_qty_uom_desc");
	String l_qty_uom_desc  = request.getParameter("qty_uom_desc")==null?"":request.getParameter("qty_uom_desc");
	String l_order_catalog_desc  = request.getParameter("p_order_catalog_desc")==null?"":request.getParameter("p_order_catalog_desc");
	String l_order_set_seq_num  = request.getParameter("p_order_set_seq_num")==null?"":request.getParameter("p_order_set_seq_num");
	String l_qty_reqd_yn  = request.getParameter("p_qty_reqd_yn")==null?"":request.getParameter("p_qty_reqd_yn");
	String l_qty_unit  = "";
	//String l_order_type_desc = request.getParameter("p_order_type_desc")==null?"":request.getParameter("p_order_type_desc");//IN065713
	
	//if("".equals(l_order_type_desc))
	String l_order_type_desc = request.getParameter("order_type")==null?"":request.getParameter("order_type");
	
	String l_occ_no = request.getParameter("p_occ_no")==null?"":request.getParameter("p_occ_no");//IN065713
	String l_applicable_to = request.getParameter("applicable_to")==null?"":request.getParameter("applicable_to");
	valid = request.getParameter("valid")==null?"":request.getParameter("valid");
	
	HashMap hashCatalogAgeWise	= (HashMap)bean.getDBAgeWiseCatalogs();
	HashMap hashindex        = new HashMap();
	//IN065713, starts
	String l_min_age = "";		
	String l_max_age = "";
	String l_min_age_unit = "";
	String l_max_age_unit = "";		
	String l_age_group_desc = "";
	String l_age_group_code = "";
	String l_add_cata_age_grp_disp = "visibility:hidden";
	//IN065713, ends
%>
<body>
<form name='orderset_dosage_age_dtl_form' id='orderset_dosage_age_dtl_form'>
<table cellpadding='3' cellspacing='0' border='0' width='100%'>
<tr>
<td>
<table cellpadding='3' cellspacing='0' border='1' width='100%' class='grid'>
	<tr>
		<td class='clicked' width='30%' id='age_grp_tab' style="text-align:center;valign:middle">
		<b>Age</b>
		</td>
		<td class='normal' width='30%'  id='age_grp_add_cata_tab' style="text-align:center;valign:middle">
		<b>Additional</b>
		</td>
		<td colspan='9' class='<%=classValue%>'>
		&nbsp;
		</td>
	</tr>
	<tr>
		<td class=columnheader ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class='<%=classValue%>' colspan='10'><b><%=l_order_catalog_desc%></b></td>
	</tr>
	<tr>
		<td class='<%=classValue%>' colspan='11'>&nbsp;</td>
	</tr>
</table>
</td>
</tr>
<tr>
<td>
<table cellpadding='3' cellspacing='0' border='1' width='100%' align='center' class='grid'><!--IN065713-->
<tr>	
	<td class=columnheader width='1%'>&nbsp;</td> <!--IN065713-->
	<td class=columnheader width='10%'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='15%'><fmt:message key="eOR.AgeGroupDef.label" bundle="${or_labels}"/></td>
	<td class=columnheader width='5%'><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='5%'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td> 
	<td class=columnheader width='15%'><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td> 
	<td class=columnheader width='10%'><fmt:message key="eOR.DurnValue/DurnType.label" bundle="${or_labels}"/></td>
	<td class=columnheader width='5%'><fmt:message key="eOR.TimeFrame.label" bundle="${or_labels}"/></td>
	<td class=columnheader width='10%'><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='5%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
	<td class=columnheader width='5%'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></td>
</tr><!--IN065713-->
<%
	hashindex = (HashMap)hashCatalogAgeWise.get(l_order_catalog_code);
	for(i=0;i<=ageGroupSize;i++)
	{
		//valid = "";
		
		if(hashindex!=null && hashindex.size()>0 && hashindex.containsKey(settingsAgeGroupStr.get("AGE_GROUP_CODE"+i)))
		{
			HashMap hashindexAgeGrpWise = (HashMap)hashindex.get(settingsAgeGroupStr.get("AGE_GROUP_CODE"+i));
			include = "y";			
			
			l_add_cata_age_grp_disp = "visibility:visible";//IN065713
			
			l_qty_unit = (String)hashindexAgeGrpWise.get("qty_unit");
				if(l_qty_unit==null)l_qty_unit="";

			l_qty_uom_code = (String)hashindexAgeGrpWise.get("qty_uom");
				if(l_qty_uom_code==null)l_qty_uom_code="";	 

			freq_code = (String)hashindexAgeGrpWise.get("freq_code");
				if(freq_code==null)freq_code="";

			durn_value = (String)hashindexAgeGrpWise.get("durn_value");
				if(durn_value==null)durn_value="";

			durn_type = (String)hashindexAgeGrpWise.get("durn_type");
				if(durn_type==null)durn_type="";

			rel_start_date_time  = (String)hashindexAgeGrpWise.get("rel_start_date_time");
				if(rel_start_date_time==null)rel_start_date_time="0";	//IN068201			
			
			route_code = (String)hashindexAgeGrpWise.get("route_code");
				if(route_code==null) route_code="" ;

			route_desc = (String)hashindexAgeGrpWise.get("route_desc");
				if(route_desc==null) route_desc="" ;

			prompt_msg = (String)hashindexAgeGrpWise.get("prompt_msg");
				if(prompt_msg==null) prompt_msg="" ;							
		}
		else
		{
			include = "";	
			l_add_cata_age_grp_disp = "visibility:hidden";//IN065713
			//IN068201 Start.
			//rel_start_date_time  = "";
			  rel_start_date_time  = "0";
			//IN068201 End.
			l_qty_uom_code = "";
			route_desc = "";
			route_code = "" ;
			prompt_msg = "" ;
			freq_code = request.getParameter("p_freq_code")==null?"":request.getParameter("p_freq_code");
			durn_value = request.getParameter("p_durn_code")==null?"":request.getParameter("p_durn_code");
			durn_type = request.getParameter("p_durn_type")==null?"":request.getParameter("p_durn_type");
			l_qty_unit = request.getParameter("p_qty_unit")==null?"":request.getParameter("p_qty_unit");			
			l_qty_uom_code = request.getParameter("p_qty_unit")==null?"":request.getParameter("p_qty_uom_code");
			//l_qty_uom_desc = request.getParameter("p_qty_uom_desc")==null?"":request.getParameter("p_qty_uom_desc");
			l_qty_uom_desc = request.getParameter("qty_uom_desc")==null?"":request.getParameter("qty_uom_desc");
			route_code = request.getParameter("p_route_code")==null?"":request.getParameter("p_route_code");
			route_desc = request.getParameter("p_route_desc")==null?"":request.getParameter("p_route_desc");
			prompt_msg = request.getParameter("prompt_msg")==null?"":request.getParameter("prompt_msg");
		}
		
		//IN065713, starts
		l_min_age = (String)(settingsAgeGroupStr.get("MIN_AGE"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE"+i));		
		l_max_age = (String)(settingsAgeGroupStr.get("MAX_AGE"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE"+i));
		l_min_age_unit = (String)(settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE_UNIT"+i));
		l_max_age_unit = (String)(settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE_UNIT"+i));
		l_age_group_code = (String)settingsAgeGroupStr.get("AGE_GROUP_CODE"+i);
		l_age_group_desc = (String)settingsAgeGroupStr.get("AGE_GROUP_DESC"+i);		
		//IN065713, ends
%>
		<tr>

		<!--<td id='add_cata_age_grp<%=i%>' class='<%=classValue%>' style='<%=l_add_cata_age_grp_disp%>'><a onclick='if(includeAdditionalDosageTypeAgeWise()){loadAdditionalCatalogsAgeWise("<%=l_order_catalog_code%>","<%=l_qty_uom_code%>","<%=l_qty_uom_desc%>","<%=l_order_catalog_desc%>","<%=l_order_set_seq_num%>","<%=l_qty_unit%>","<%=l_qty_reqd_yn%>","<%=l_order_type_desc%>","<%=l_age_group_code%>","<%=request.getQueryString()%>",document.getElementById("freq_code")<%=i%>.value,document.getElementById("durn_value")<%=i%>.value,document.getElementById("durn_type_desc")<%=i%>.value,document.getElementById("rel_start_date_time")<%=i%>.value,document.getElementById("route_code")<%=i%>.value,"<%=l_age_group_desc%>")}' id = 'showHideDepDtls<%=i%>' href="#">+</a>-->
		<td id='add_cata_age_grp<%=i%>' class='<%=classValue%>' style='<%=l_add_cata_age_grp_disp%>'><a onclick='if(includeAdditionalDosageTypeAgeWise()){loadAdditionalCatalogsAgeWise("<%=l_order_catalog_code%>","<%=l_qty_uom_code%>","<%=l_qty_uom_desc%>","<%=l_order_catalog_desc%>","<%=l_order_set_seq_num%>",document.getElementById("qty_unit")<%=i%>.value,"<%=l_qty_reqd_yn%>","<%=l_order_type_desc%>","<%=l_age_group_code%>","<%=request.getQueryString()%>",document.getElementById("freq_code")<%=i%>.value,document.getElementById("durn_value")<%=i%>.value,document.getElementById("durn_type_desc")<%=i%>.value,document.getElementById("rel_start_date_time")<%=i%>.value,document.getElementById("route_code")<%=i%>.value,"<%=l_age_group_desc%>",document.getElementById("durn_type")<%=i%>.value,prompt_msg<%=i%>.value,"<%=l_occ_no%>")}' id = 'showHideDepDtls<%=i%>' href="#">+</a>
		</td><!--IN065713-->
		<!--<td class='<%=classValue%>'><%=settingsAgeGroupStr.get("AGE_GROUP_DESC"+i) %><input type='hidden' name='age_group_code<%=i%>' id='age_group_code<%=i%>' value='<%=settingsAgeGroupStr.get("AGE_GROUP_CODE"+i)%>'/></td>-->
		<td class='<%=classValue%>'><%=l_age_group_desc%><input type='hidden' name='age_group_code<%=i%>' id='age_group_code<%=i%>' value='<%=l_age_group_code%>'/></td>
	
		<!--IN065036, starts-->
		<!-- <td class='<%=classValue%>'><%if(i>0){%><%=settingsAgeGroupStr.get("MIN_AGE"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE"+i)%> <%=decode((String)(settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)))%> - <%=settingsAgeGroupStr.get("MAX_AGE"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE"+i)%> <%=decode((String)(settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)))%><%}else{%>All<%}%></td> -->
		<!--<td class='<%=classValue%>'><%if(i>0){%><%=settingsAgeGroupStr.get("MIN_AGE"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE"+i)%> <%=decodeForAgeGrp((String)(settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MIN_AGE_UNIT"+i)))%> - <%=settingsAgeGroupStr.get("MAX_AGE"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE"+i)%> <%=decodeForAgeGrp((String)(settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)==null?"":settingsAgeGroupStr.get("MAX_AGE_UNIT"+i)))%><%}else{%>All<%}%></td>--><!--IN065713-->
		<!--IN065036, ends-->
		<!--IN065713, starts-->
		<td class='<%=classValue%>'><%if(i>0){%><%=l_min_age%> <%=decodeForAgeGrp(l_min_age_unit)%> - <%=l_max_age%> <%=decodeForAgeGrp(l_max_age_unit)%><%}else{%>All<%}%></td>
		<!--IN065713, ends-->
				
		<td class='<%=classValue%>'><input type='text' name='qty_unit<%=i%>' id='qty_unit<%=i%>' onKeyPress='return(parent.parent.parent.checkValid(this,event,6,5))' size='6' maxlength='6'   <%=eHISFormatter.disabled("n",l_qty_reqd_yn)%> <%=eHISFormatter.disabled("y",valid)%> value='<%=l_qty_unit%>' style="text-align:right"></td>
		
		<td class='<%=classValue%>'><%=l_qty_uom_desc%></td>		

		<td class='<%=classValue%>'>
			<SELECT name="freq_code<%=i%>" id="freq_code<%=i%>" onchange='parent.parent.parent.getDurnType(this,"<%=i%>","orderset_dosage_age_dtl_form")' <%=eHISFormatter.disabled("y",valid)%>><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
		<%
			ArrayList frequencyList = bean.getFrequency("PH",l_order_catalog_code) ;
			String[] freqRecord=null;
			for(int freqInd=0; freqInd<frequencyList.size(); freqInd++)
			{
				freqRecord = (String[])frequencyList.get(freqInd);
				
				if(!"".equals(freq_code))
					durn_value_updatable = "n";
				
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
		<!--<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" size='3' maxlength='3'	class="number" <%=eHISFormatter.disabled("y",freq_code_updatable)%> <%=eHISFormatter.disabled("A",dosage_type)%>--><!--IN065713-->
		<input type="text" name="durn_value<%=i%>" id="durn_value<%=i%>" size='3' maxlength='3' class="number" <%=eHISFormatter.disabled("y",durn_value_updatable)%> <%=eHISFormatter.disabled("A",dosage_type)%>
		<%=eHISFormatter.disabled("y",valid)%> onblur='parent.parent.parent.OrCheckPositiveNumber1(this)'
		value="<%=durn_value%>">/<input type="text"  disabled name="durn_type_desc<%=i%>" id="durn_type_desc<%=i%>"	 size='3' <%=eHISFormatter.disabled("y",valid)%>  value="<%=decode(durn_type.trim())%>"></td>
		<input type='hidden' name='durn_type<%=i%>' id='durn_type<%=i%>' value="<%=durn_type.trim()%>" >
		
		<td class='<%=classValue%>'>
		<input type="text" name="rel_start_date_time<%=i%>" id="rel_start_date_time<%=i%>"	size='3'
		onblur='checkDecimal2(this)'
		<%=eHISFormatter.disabled("y",valid)%> <%=eHISFormatter.disabled("A",dosage_type)%> class='number' maxlength="3" value="<%=rel_start_date_time%>"><fmt:message key="eOR.Hrs.label" bundle="${or_labels}"/></td>

		<td class='<%=classValue%>'>
		<input type="hidden" name="route_code<%=i%>" id="route_code<%=i%>" value="<%=route_code%>">
		<input type="text" name="route_desc<%=i%>" id="route_desc<%=i%>" size='8' maxlength='8' value="<%=route_desc%>" <%=eHISFormatter.disabled("y",route_updatable)%> <%=eHISFormatter.disabled("A",dosage_type)%> <%=eHISFormatter.disabled("y",valid)%> onblur="parent.parent.parent.show_route_window(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'orderset_dosage_age_dtl_form')" ><input type="button" name="route_button<%=i%>" id="route_button<%=i%>" class='button' style="<%=route_style%>" value='?' <%=eHISFormatter.disabled("y",route_updatable)%> <%=eHISFormatter.disabled("A",dosage_type)%> <%=eHISFormatter.disabled("y",valid)%> onclick="parent.parent.parent.show_route_Lookupwindow(route_desc<%=i%>,route_code<%=i%>,<%=i%>,'orderset_dosage_age_dtl_form')">	
		</td>

		<td class='<%=classValue%>' ><input type='checkbox' name='include<%=i%>' id='include<%=i%>' onclick="chkInclude('<%=i%>','orderset_dosage_age_dtl_form');" value='Y' <%=eHISFormatter.disabled("y",valid)%>  <%=eHISFormatter.ChkBoxChecked("y",include)%>></td>

		<td class='<%=classValue%>' ><a class='gridLink' name='Cmts<%=i%>' href='javascript:parent.parent.parent.showDialog("<%=i%>","orderset_dosage_age_dtl_form")'><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></a></td>
		</tr>			
			
		<INPUT type = 'hidden' name='prompt_msg<%=i%>' id='prompt_msg<%=i%>' value='<%=prompt_msg%>'> 
		<input type="hidden" name="qty_uom<%=i%>" id="qty_uom<%=i%>" value="<%=l_qty_uom_code%>">
		<input type="hidden" name="qty_reqd_yn<%=i%>" id="qty_reqd_yn<%=i%>" value="<%=l_qty_reqd_yn%>">
		<input type="hidden" name="occ_no<%=i%>" id="occ_no<%=i%>" value="<%=l_occ_no%>">
		
	<%
	}
	%>	
<table>
</td>
</tr>
</table>

<input type = 'hidden' name = 'order_catalog_code' value = '<%=l_order_catalog_code%>'/>
<input type = 'hidden' name = 'order_set_seq_num' value = '<%=l_order_set_seq_num%>'/>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="age_group_size" id="age_group_size" value="<%=ageGroupSize%>">
<input type='hidden' name='detailPageMode' id='detailPageMode' value='<%=bean.getDetailPageMode()%>' >
<input type = 'hidden' name = 'order_type_desc' value = '<%=l_order_type_desc%>'/><!--IN065713-->
<input type = 'hidden' name = 'uom_desc' value = '<%=l_qty_uom_desc%>'/><!--IN065713-->
<input type = 'hidden' name = 'p_query_string' value = '<%=request.getQueryString()%>'/><!--IN065713-->
<input type = 'hidden' name = 'iv_prep_yn' value = '<%=l_applicable_to%>'/><!--IN065713-->
<input type = 'hidden' name = 'order_type' value = '<%=l_order_type_desc%>'/><!--IN065713-->
<input type = 'hidden' name = 'valid' value = '<%=valid%>'/>
<%
	putObjectInBean(bean_id,bean,request); 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</form>
</body>
</html>

