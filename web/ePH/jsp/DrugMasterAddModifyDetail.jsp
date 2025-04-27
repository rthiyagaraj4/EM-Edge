<!DOCTYPE html>
 <!--Fine Tuning-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.ArrayList,java.util.HashMap, ePH.DrugMasterBean, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id				=	"DrugMasterBean" ;
	String bean_name			=	"ePH.DrugMasterBean";
	String mode					=	"";
	String link					=	request.getParameter("link");
	String item_code			=	"";
	String item_desc			=	"";
	String stock_uom_code		=	"";
	String stock_uom_desc		=	"";
	String base_uom				=	"";
	String strength_uom			=	"";
	String trade_id				=	"";
	String trade_name			=	"";
	String trade_image_filename	=	"";
	String manufacturer_id		=	"";
	String manufacturer_name	=	"";
	String generic_id			=	"";
	String generic_name			=	"";
	String drug_class			=	"";
	String disp_no				=	"";
	String select				=	"";
	String select_chk			=	"";
	String select_chk1			=	"";
	String flag					=	"";
	String eff_status			=	"";
	String classVal				=	"";
	String prescribing_desc		=	"";
	String age_group_code		=	"";
	String short_desc			=	"";
	String gender				=	"";
	String max_age				=	"";
	String age_unit				=	"";
	String min_age				=	"";
	String select_weight		=	"";
	String eff_status_weight	=	"";
	String select_chk_weight	=	"";
	String select_chk1_weight	=	"";
	String select_drug_appl		=	"";
	String eff_status_drug_appl	=	"";
	String select_chk_drug_appl	=	"";
	String select_chk1_drug_appl=	"";
	String ht_mand_yn = "N", ht_mand_chk = ""; //added for Bru-HIMS-CRF-079 IN[029945]
	int j						=	0;
	ArrayList inventory_values	=	null;
	ArrayList trade_values		=	null;
	ArrayList generic_values	=	null;
	ArrayList drugmastermain	=	null;
	ArrayList agegroupvalues	=	null;

	HashMap	record				=	null;

	DrugMasterBean beanObj		= (DrugMasterBean)getBeanObject(bean_id, bean_name, request);
	beanObj.setLanguageId(locale);
				mode		=	beanObj.getMode();
	drugmastermain			=	beanObj.getDrugmastermain();

	if(link.equals("inventory_tab"))	{
		inventory_values	=	beanObj.getInventory();
		prescribing_desc	=	beanObj.getPrescribingDesc();
	}
	else if(link.equals("trade_tab"))	{
		trade_values	=	beanObj.getTradeNames();
		if(!trade_values.equals("")){
			trade_values	=	beanObj.sortList(trade_values,"disp_seq_no");
		}
	}
	else if(link.equals("generic_tab"))	{
		generic_values	=	beanObj.getGenericNames();
	}
	else if(link.equals("weightrecording_tab"))	{
		agegroupvalues	=beanObj.getAgeGroups();
	}
%>
<html>
	<head>
<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DrugMasterDetail.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../ePH/js/DrugMaster.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onKeyDown="lockKey()" topmargin="0">
		<form name="drugMasterAddModifyDetailForm" id="drugMasterAddModifyDetailForm" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="detail">
<%	
			try{
				if(inventory_values!=null && inventory_values.size()!=0){
					for(j=0; j<inventory_values.size(); j++)	{
						record	=	(HashMap)inventory_values.get(j);
						item_code			=	(String) record.get("item_code");
						item_desc			=	(String) record.get("item_desc");
						stock_uom_code		=	(String) record.get("stock_uom_code");
						stock_uom_desc		=	(String) record.get("stock_uom_desc");
						base_uom			=	(String) record.get("base_uom");

						if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))
							strength_uom		=	prescribing_desc;
						else
							strength_uom		=	(String) record.get("strength_uom");

						flag				=	(String) record.get("flag");

						if(!flag.equals("D"))	{
							if(flag.equals("I") || flag.equals("DN"))	{
								select			=	(String) record.get("select");

								if(select.equals("Y"))
									select_chk	=	"checked";
								else if(select.equals("N"))
									select_chk	=	"unchecked";
								else if(select.equals(""))
									select_chk	=	"disabled";

							}

							if(j%2 == 0)
								classVal	= "QRYEVEN";
							else
								classVal	= "QRYODD";
%>
							<tr>
<% 
							if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))	{
								if(item_code.equals((String)drugmastermain.get(0)))	{
%>
									<td width="35%" class="<%=classVal%>"><%=item_desc%><input type='hidden' name='item_code<%=j%>' id='item_code<%=j%>' value="<%=item_code%>"><input type='hidden' name='item_desc<%=j%>' id='item_desc<%=j%>' value="<%=item_desc%>"></td>
<%	
								}
								else{
%>
									<td width="35%" class="<%=classVal%>"><a href='javascript:parent.callModify("<%=j%>")'><%=item_desc%></a><input type='hidden' name='item_code<%=j%>' id='item_code<%=j%>' value="<%=item_code%>"><input type='hidden' name='item_desc<%=j%>' id='item_desc<%=j%>' value="<%=item_desc%>"></td>
<%
								}
							}
							else{	
%>
								<td width="35%" class="<%=classVal%>"><%=item_desc%><input type='hidden' name='item_code<%=j%>' id='item_code<%=j%>' value="<%=item_code%>"><input type='hidden' name='item_desc<%=j%>' id='item_desc<%=j%>' value="<%=item_desc%>"></td>
<%	
							}
%>
							<td width="25%" class="<%=classVal%>"><%=stock_uom_desc%><input type='hidden' name='stock_uom_code<%=j%>' id='stock_uom_code<%=j%>' value="<%=stock_uom_code%>"><input type='hidden' name='stock_uom_desc<%=j%>' id='stock_uom_desc<%=j%>' value="<%=stock_uom_desc%>"></td>
							<td width="25%" class="<%=classVal%>"><%=base_uom%>/<%=strength_uom%><input type='hidden' name='base_uom<%=j%>' id='base_uom<%=j%>' value="<%=base_uom%>"><input type='hidden' name='strength_uom<%=j%>' id='strength_uom<%=j%>' value="<%=strength_uom%>"></td>

<%	
							if(flag.equals("I") || flag.equals("DB")){
%>
								<td width="15%" align="center" class="<%=classVal%>"><input type='hidden' name='flag<%=j%>' id='flag<%=j%>' value="<%=flag%>"><input type='checkbox' <%=select_chk%> name='select<%=j%>' onClick='parent.assignValue(this);parent.updateFormModify("parent.drugMasterMain.document.drugMasterMainForm")' value="<%=select%>"></td>
<%
							}	
							else{	
%>
								<td width="15%" align="center" class="<%=classVal%>">&nbsp;<input type='hidden' name='flag<%=j%>' id='flag<%=j%>' value="<%=flag%>"></td>
<%
							}
						}
					}
%>
					<script>
						parent.updateInventory("<%=inventory_values.size()%>");
					</script>
<% 
				}
				else if(trade_values!=null && trade_values.size()!=0)	{
					for(j=0; j<trade_values.size(); j++)	{
						record	=	(HashMap)trade_values.get(j);

						trade_id			=	(String) record.get("trade_id");
						trade_name			=	(String) record.get("trade_name");
						manufacturer_id		=	(String) record.get("manufacturer_id");
						manufacturer_name	=	(String) record.get("manufacturer_name");
						disp_no				=	(String) record.get("disp_seq_no");
						flag				=	(String) record.get("flag");
						trade_image_filename =	(String) record.get("trade_image_filename")==null?"":(String) record.get("trade_image_filename");
						
						if(flag.equals("DB")||flag.equals("I") )	{
							if(flag.equals("I"))	{

								select				=	(String) record.get("select");
										
								if( select.equals("Y"))
									select_chk="checked";
								else
									select_chk="unchecked";
						
							}
							else if(flag.equals("DB")){
								eff_status =(String) record.get("eff_status");
								select =	(String) record.get("select")==null?"":(String) record.get("select");
								if(record.size()==8)
								eff_status =(String) record.get("eff_status");
								else{
								 if(((String)record.get("select")).equals("N") && ((String)record.get("eff_status")).equals("Y"))
									 eff_status="D";
									else  if( ((String)record.get("select")).equals("") && ((String)record.get("eff_status")).equals("N") )
										eff_status="D";
									else  if( ((String)record.get("select")).equals("") && ((String)record.get("eff_status")).equals("Y") )
										eff_status="E";
										
									else{
										String yy=(String) record.get("select");
										if(yy.equals("Y") )
											eff_status="E";
										else if(yy.equals("N"))
											eff_status="D";
									}
								}
								if(eff_status.equals("E")){
									select_chk="checked";
									select_chk1="Y";
								}
								else {
									select_chk="unchecked";
									select_chk1="N"; 
								}
							}
				   
							if(j%2 == 0)
								classVal	= "QRYEVEN";
							else
								classVal	= "QRYODD";
%>
							<tr>
								<td width="30%" class="<%=classVal%>" wrap>
								<label style='cursor:pointer;color:blue;'  onClick='parent.updateTrade("<%=j%>","<%=java.net.URLEncoder.encode(trade_name,"UTF-8")%>","<%=trade_id%>","<%=disp_no%>","<%=java.net.URLEncoder.encode(manufacturer_name,"UTF-8")%>","<%=select%>","<%=manufacturer_id%>","<%=trade_image_filename%>")'  id="trade_id">	<%=trade_name%>
								</label>									
								<input type='hidden' name='trade_id<%=j%>' id='trade_id<%=j%>' value="<%=trade_id%>">
								<input type='hidden' name='trade_name<%=j%>' id='trade_name<%=j%>' value="<%=trade_name%>">
								</td>
								<td width="5" class="<%=classVal%>" nowrap>
<%
								if(!trade_image_filename.equals("")){
%>
									<a href="javascript:parent.showImage('<%=trade_image_filename%>');">
<%
								}
%>
								<fmt:message key="Common.Image.label" bundle="${common_labels}"/></a>
								<input type='hidden' name='trade_image_filename<%=j%>' id='trade_image_filename<%=j%>' value="<%=trade_image_filename%>">
								</td>
								<td width="35%" class="<%=classVal%>" wrap><%=java.net.URLDecoder.decode(manufacturer_name,"UTF-8")%><input type='hidden' name='manufacturer_id<%=j%>' id='manufacturer_id<%=j%>' value="<%=manufacturer_id%>"><input type='hidden' name='manufacturer_name<%=j%>' id='manufacturer_name<%=j%>' value="<%=manufacturer_name%>"></td>
								<td width="15%" class="<%=classVal%>" wrap align="center"><%=disp_no%><input type='hidden' name='disp_seq_no<%=j%>' id='disp_seq_no<%=j%>' value="<%=disp_no%>"></td>
<%		
								if(flag.equals("I")||flag.equals("DB"))	{	
%>
									<td width="15%" align="center" class="<%=classVal%>"><input type='hidden' name='flag<%=j%>' id='flag<%=j%>' value="<%=flag%>"><input type='checkbox' <%=select_chk%> name='select<%=j%>'onClick ='parent.assignValue(this);parent.updateFormModify("parent.drugMasterMain.document.drugMasterMainForm")' value="<%=select%>"></td>
									<input type='hidden' name='select_chk1<%=j%>' id='select_chk1<%=j%>' value="<%=select_chk1%>">

<%	
								}
								else{	
%>
									<td width="15%" align="center" class="<%=classVal%>">&nbsp;<input type='hidden' name='flag<%=j%>' id='flag<%=j%>' value="<%=flag%>"></td>
<%
								}
%>
							</tr>
<%
						}
					}
%>
					<script>
						parent.updateTradeNames("<%=trade_values.size()%>");
						parent.updateDispNo("<%=disp_no%>");
					</script>
<%
				}
				else if(agegroupvalues!=null && agegroupvalues.size()!=0)	{
					for(j=0; j<agegroupvalues.size(); j++)	{
						
						record	=	(HashMap)agegroupvalues.get(j);
						age_group_code			=	(String) record.get("age_group_code");
						short_desc				=	(String) record.get("short_desc");
						gender					=	(String) record.get("gender");
						max_age					=	(String) record.get("max_age");
						age_unit				=	(String) record.get("age_unit");
						flag					=	(String) record.get("flag");
						min_age					=	(String) record.get("min_age");
										
						if(flag.equals("DB")||flag.equals("I") )	{
							if(flag.equals("I"))	{
								select				=	(String) record.get("select");
								select_weight		=(String) record.get("select_weight");
								select_drug_appl=(String) record.get("select_drug_appl");
								ht_mand_yn=(String) record.get("ht_mand_yn")==null?"N":(String) record.get("ht_mand_yn");  //added for Bru-HIMS-CRF-079 IN[029945]
								if( select.equals("Y"))
									select_chk="checked";
								else
									select_chk="unchecked";
								
								if( select_weight.equals("Y"))
									select_chk_weight="checked";
								else
									select_chk_weight="unchecked";
								if( select_drug_appl.equals("Y"))
									select_chk_drug_appl="checked";
								else
									select_chk_drug_appl="unchecked";
						
							}
							else if(flag.equals("DB")){
								
								eff_status_weight	 =(String) record.get("eff_status_weight");
								eff_status			 =(String) record.get("eff_status");
								eff_status_drug_appl =(String) record.get("eff_status_drug_appl");
								select =	(String) record.get("select")==null?"":(String) record.get("select");
								select_weight		=(String) record.get("select_weight")==null?"":(String) record.get("select_weight");
								select_drug_appl=(String) record.get("select_drug_appl")==null?"":(String) record.get("select_drug_appl");
								ht_mand_yn=(String) record.get("ht_mand_yn")==null?"N":(String) record.get("ht_mand_yn");  //added for Bru-HIMS-CRF-079 IN[029945]
								if(record.size()==11) {
									eff_status = ((String)record.get("eff_status"));
								}
								else{    
									if(((String)record.get("select")).equals("N") && ((String)record.get("eff_status")).equals("Y"))
										eff_status="D";
									else  if( ((String)record.get("select")).equals("") && ((String)record.get("eff_status")).equals("N") )
										eff_status="D";
									else  if( ((String)record.get("select")).equals("") && ((String)record.get("eff_status")).equals("Y") )
										eff_status="E";
									else{
										String yy=(String) record.get("select");
										if(yy.equals("Y") )
											eff_status="E";
										else if(yy.equals("N"))
											eff_status="D";
									}
									if(select_drug_appl.equals("") && ((String)record.get("eff_status_drug_appl")).equals("N"))
										eff_status_drug_appl="N";
									else if(select_drug_appl.equals("") && ((String)record.get("eff_status_drug_appl")).equals("Y"))
										eff_status_drug_appl="Y";
									else
										eff_status_drug_appl=(String) record.get("select_drug_appl");
									
									if(select_weight.equals("") && ((String)record.get("eff_status_weight")).equals("N"))
										eff_status_weight="N";
									else if(select_weight.equals("") && ((String)record.get("eff_status_weight")).equals("Y"))
										eff_status_weight="Y";
									else
										eff_status_weight=(String) record.get("select_weight");
									ht_mand_yn=(String) record.get("ht_mand_yn")==null?"N":(String) record.get("ht_mand_yn");  //added for Bru-HIMS-CRF-079 IN[029945]
								}
								if(eff_status.equals("E")) {
									select_chk="checked";
									select_chk1="Y";
									select ="Y";
								}
								else {
									select_chk="unchecked";
									select_chk1="N"; 
									select = "N";
								}
								
								if(eff_status_weight.equals("Y")) {
									select_chk_weight="checked";
									select_chk1_weight="Y";
								}
								else {
									select_chk_weight="unchecked";
									select_chk1_weight="N"; 
								}
								if(eff_status_drug_appl.equals("Y")){
									select_chk_drug_appl="checked";
									select_chk1_drug_appl="Y";
								}
								else {
									select_chk_drug_appl="unchecked";
									select_chk1_drug_appl="N"; 
								}
							}

						if(ht_mand_yn.equals("Y")) { //added for Bru-HIMS-CRF-079 IN[029945] -start
							ht_mand_chk="checked";
						}
						else {
							ht_mand_chk="";
							ht_mand_yn="N"; 
						} //added for Bru-HIMS-CRF-079 IN[029945] -end
						if(j%2 == 0)
							classVal	= "QRYEVEN";
						else
							classVal	= "QRYODD";
%>
						<tr>
							<td width="20%" class="<%=classVal%>" wrap><%=short_desc%>
								<input type='hidden' name='age_group_code<%=j%>' id='age_group_code<%=j%>' value="<%=age_group_code%>">
								<input type='hidden' name='short_desc<%=j%>' id='short_desc<%=j%>' value="<%=short_desc%>">
							</td> 
							<td width="10%" class="<%=classVal%>" wrap>
<%
								if(gender.equals("") || gender.equals("A")){
%>
									<fmt:message key="Common.all.label" bundle="${common_labels}"/>
<%
								}
								else if(gender.equals("M")){
%>
									<fmt:message key="Common.male.label" bundle="${common_labels}"/>	
<%	 
								}
								else if(gender.equals("F")){
%>
									<fmt:message key="Common.female.label" bundle="${common_labels}"/>	
<%
								}
%>	
								<input type='hidden' name='gender<%=j%>' id='gender<%=j%>' value="<%=gender%>">&nbsp;</td>
								<td width="8%" class="<%=classVal%>" wrap align="center"><%=min_age%><input type='hidden' name='min_age<%=j%>' id='min_age<%=j%>' value="<%=min_age%>"></td> 
								<td width="8%" class="<%=classVal%>" wrap align="center"><%=max_age%><input type='hidden' name='max_age<%=j%>' id='max_age<%=j%>' value="<%=max_age%>"></td>
								<td width="10%" class="<%=classVal%>" wrap align="center">
<%
								if(age_unit.equals("Y")){
%>
									<fmt:message key="Common.Years.label" bundle="${common_labels}"/>
<%
								}
								else if(age_unit.equals("D")){
%>
									<fmt:message key="Common.Day(s).label" bundle="${common_labels}"/>
<%
								}
								else if(age_unit.equals("M")){
%>
									<fmt:message key="Common.months.label" bundle="${common_labels}"/>
<%
								}
								else if(age_unit.equals("H")){
%>
									<fmt:message key="Common.Hour(s).label" bundle="${common_labels}"/>
<%
								}
								else if(age_unit.equals("N")){
%>
									<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/>
<%
								}
%>
								<input type='hidden' name='age_unit<%=j%>' id='age_unit<%=j%>' value="<%=age_unit%>"></td> 
<%		
								if(flag.equals("I")||flag.equals("DB"))	{
%>
									<td width="10%" align="center" class="<%=classVal%>"> 
										<center>  
										<input type='checkbox' <%=select_chk_drug_appl%> name='select_drug_appl<%=j%>'onClick ='parent.assignValue(this);parent.updateFormModify("parent.drugMasterMain.document.drugMasterMainForm")'  value="<%=select_drug_appl%>">
										<center>
									</td>
										<input type='hidden' name='select_chk1_drug_appl<%=j%>' id='select_chk1_drug_appl<%=j%>' value="<%=select_chk1_drug_appl%>">  
									<td width="8%" align="center" class="<%=classVal%>"> 
										<center>  
										<input type='checkbox' <%=select_chk_weight%> name='select_weight<%=j%>'onClick ='parent.assignValue(this );parent.updateFormModify("parent.drugMasterMain.document.drugMasterMainForm")'  value="<%=select_weight%>">
										</center>
									</td>
										<input type='hidden' name='select_chk1_weight<%=j%>' id='select_chk1_weight<%=j%>' value="<%=select_chk1_weight%>">  
									<!-- added for Bru-HIMS-CRF-079 IN[029945] -start -->
									<td width="8%" align="center" class="<%=classVal%>"> 
										<center>  
										<input type='checkbox' <%=ht_mand_chk%> name='ht_mand_yn<%=j%>'onClick ='parent.assignValue(this );parent.updateFormModify("parent.drugMasterMain.document.drugMasterMainForm")'  value="<%=ht_mand_yn%>">
										</center>
									</td>
									<!-- added for Bru-HIMS-CRF-079 IN[029945] -end -->
									 <td width="10%" align="center" class="<%=classVal%>">
										<center> 
										<input type='checkbox' <%=select_chk%> name='select<%=j%>'onClick ='parent.assignValue(this);parent.updateFormModify("parent.drugMasterMain.document.drugMasterMainForm")' value="<%=select%>">
										</center>
									</td>
									<input type='hidden' name='select_chk1<%=j%>' id='select_chk1<%=j%>' value="<%=select_chk1%>">
									<input type='hidden' name='flag<%=j%>' id='flag<%=j%>' value="<%=flag%>">
<%	
								}
								else{	
%>
									<td width="15%" align="center" class="<%=classVal%>">&nbsp;
									<input type='hidden' name='flag<%=j%>' id='flag<%=j%>' value="<%=flag%>"></td>
<%
								}
%>
							</tr>
<%
						}
					}
%>
					<script>
						parent.updateGenericNames("<%=agegroupvalues.size()%>");
						//parent.updateDispNo("<%=disp_no%>");
					</script>
				
<%
				}
				else if(generic_values!=null && generic_values.size()!=0)	{
					for(j=0; j<generic_values.size(); j++)	{
						record	=	(HashMap)generic_values.get(j);
						generic_id				=	(String) record.get("generic_id");
						generic_name			=	(String) record.get("generic_name");
						drug_class				=	(String) record.get("drug_class");
						disp_no					=	(String) record.get("disp_seq_no");
						flag					=	(String) record.get("flag");

						if(!flag.equals("D"))	{
							if(flag.equals("I") || flag.equals("DN"))	{

							select					=	(String) record.get("select");

							if(select.equals("Y"))
								select_chk	=	"checked";
							else if(select.equals("N"))
								select_chk	=	"unchecked";
							else if(select.equals(""))
								select_chk	=	"disabled";
							}

							if(j%2 == 0)
								classVal	= "QRYEVEN";
							else
								classVal	= "QRYODD";
%>
							<tr>
<%	
							if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")))	{
								if(generic_id.equals((String)drugmastermain.get(6)))	{	
%>
									<td width="20%" class="<%=classVal%>" wrap><%=generic_id%><input type='hidden' name='generic_id<%=j%>' id='generic_id<%=j%>' value="<%=generic_id%>"></td>
<%	
								}
								else{	
%>
									<td width="20%" class="<%=classVal%>" wrap><a href='javascript:parent.callModify("<%=j%>")'><%=generic_id%></a><input type='hidden' name='generic_id<%=j%>' id='generic_id<%=j%>' value="<%=generic_id%>"></td>
<%	
								}
							} 
							else{	
%>
								<td width="20%" class="<%=classVal%>" wrap><a href='javascript:parent.callModify("<%=j%>")'><%=generic_id%></a><input type='hidden' name='generic_id<%=j%>' id='generic_id<%=j%>' value="<%=generic_id%>"></td>
<%	
							}
%>
							<td width="40%" class="<%=classVal%>" wrap><%=generic_name%><input type='hidden' name='generic_name<%=j%>' id='generic_name<%=j%>' value="<%=generic_name%>"></td>
							<td width="15%" class="<%=classVal%>" wrap><%=drug_class%><input type='hidden' name='drug_class<%=j%>' id='drug_class<%=j%>' value="<%=drug_class%>"></td>
							<td width="15%" class="<%=classVal%>" wrap align="center"><%=disp_no%><input type='hidden' name='disp_seq_no<%=j%>' id='disp_seq_no<%=j%>' value="<%=disp_no%>"></td>
<%
							if(flag.equals("I") || flag.equals("DN"))	{	
%>
								<td width="10%" align="center" class="<%=classVal%>"><input type='hidden' name='flag<%=j%>' id='flag<%=j%>' value="<%=flag%>"><input type='checkbox' <%=select_chk%> name='select<%=j%>' onClick='parent.assignValue(this);parent.updateFormModify("parent.drugMasterMain.document.drugMasterMainForm")' value="<%=select%>"></td>
<%	
							}
							else{	
%>
								<td width="10%" align="center" class="<%=classVal%>">&nbsp;<input type='hidden' name='flag<%=j%>' id='flag<%=j%>' value="<%=flag%>"></td>
<%
							}
						}
					}
%>
					<script>
						parent.updateGenericNames("<%=generic_values.size()%>");
					
						parent.updateDispNo("<%=disp_no%>");
					</script>
<%
				}
%>
			</table>
<%
			}
			catch(Exception e){
				e.printStackTrace();
			}
			if(inventory_values!=null && inventory_values.size()!=0){
%>
				<input type="hidden" id="tot_rows" name="rows" id="rows" value="<%=inventory_values.size()-1%>">
<%
			}
			else	if(trade_values!=null && trade_values.size()!=0) {
%>
				<input type="hidden" id="tot_rows" name="rows" id="rows" value="<%=trade_values.size()-1%>">
<%	
			}
			else if(generic_values!=null && generic_values.size()!=0){
%>
				<input type="hidden" id="tot_rows" name="rows" id="rows" value="<%=generic_values.size()-1%>">
<%	
			}else if(agegroupvalues!=null && agegroupvalues.size()!=0){
	
%>
				<input type="hidden" id="tot_rows" name="rows" id="rows" value="<%=agegroupvalues.size()-1%>">
<%	
			}
			else{
%>
				<input type="hidden" id="tot_rows" name="rows" id="rows" value="">
<%
			}
%>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,beanObj,request);
%>

