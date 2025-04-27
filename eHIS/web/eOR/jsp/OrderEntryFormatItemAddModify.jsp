<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.* ,java.util.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>
	-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
 	<script language="JavaScript" src="../../eOR/js/OrderEntryFormatItem.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head><!--  -->
<body  onload='FocusFirstElement()'   onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String readOnly = "" ;
	String allDisabled = "";
	String systemDisabled = "";
	String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderEntryFormatItems" ;
	String bean_name = "eOR.OrderEntryFormatItem";
//	String disabled = "" ;
	ArrayList Category_Data = new ArrayList();
	ArrayList List_Data = new ArrayList();
//	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

/* Mandatory checks end */

	/* Initialize Function specific start */
	OrderEntryFormatItem bean = (OrderEntryFormatItem)getBeanObject( bean_id,bean_name, request ) ;
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;

/* Initialize Function specific end */
	String field_mnemonic	= "";
	String field_mnemonic_desc	= "";
	String field_type		= "";
	String order_category	= "";
	String order_category_id= "";
	String eff_status		= "";
	String meaning			= "";
	String meaning_val		= "";
	String hint				= "";
	String min_num_value	= "";
	String max_num_value	= "";
	String single_or_multi	= "";
	String presentation_type	= "";
	String discr_msr_id		= "";
	String discr_msr_id_val	= "";
	String finalVals = ""; 
	int i=0;
	//StringBuffer finalVals=new StringBuffer();
	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) 
	{
		field_mnemonic		= request.getParameter("field_mnemonic").trim();
		field_mnemonic_desc		= request.getParameter("field_mnemonic_desc").trim();
		field_type			= request.getParameter("field_type").trim();
		order_category_id	= request.getParameter("order_category_id").trim();
		order_category		= request.getParameter("order_category").trim();

		
		String[] values			= (String[])bean.getMainData (field_mnemonic, field_type, order_category_id) ;

//		order_category			= (String)values[0];
		single_or_multi			= (String)values[1];
		presentation_type		= (String)values[2];
		meaning					= (String)values[3];
		hint					= (String)values[4];
		eff_status				= (String)values[5];

		if(order_category == null ) order_category = "";
		if(single_or_multi == null ) single_or_multi = "";
		if(presentation_type == null ){
		//	presentation_type = "S";
			presentation_type = "";
		}
		if(meaning == null ) meaning = "";
		if(hint == null ) hint = "";
		if(eff_status == null ) eff_status = "";


		bean.setFieldMnemonic(field_mnemonic.trim());
		bean.setFieldMnemonicDesc(field_mnemonic_desc.trim());
		bean.setFieldType( field_type.trim());
		bean.setOrderCategory( order_category_id);
		bean.setEffectiveStatus(eff_status.trim());
		bean.setHint(hint.trim());
		bean.setMeaningValue(meaning.trim());

		if(eff_status.equals("D"))
		{
			checked			= "";
			readOnly		= "readonly" ;
			allDisabled		= "disabled";
		}
		else
		{
			checked			= "checked";
		}

		try{
			if(meaning.equals("S")){
				meaning_val		= "System Defined" ;
				systemDisabled	= "disabled";
			}else{
				meaning_val			= "User Defined" ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		 if(field_type.equals("I") || field_type.equals("N")){
			String[] numData = (String[])bean.getNumericData();
			min_num_value = numData[0];
			max_num_value = numData[1];

			if(field_type.equals("I") ){
				int tempIndex = 0;
				tempIndex = min_num_value.indexOf(".");
				min_num_value = min_num_value.substring(0,tempIndex);
				tempIndex = max_num_value.indexOf(".");
				max_num_value = max_num_value.substring(0,tempIndex);
			}

			if((min_num_value==null)||(min_num_value.trim()).equals("0.0") || (min_num_value.trim()).equals("0"))
				min_num_value="";
			if((max_num_value==null)||(max_num_value.trim()).equals("0.0") || (max_num_value.trim()).equals("0"))
				max_num_value="";

			bean.setMinValue(min_num_value);
			bean.setMaxValue(max_num_value);
		}else if(field_type.equals("M")){
			String[] discData = (String[])bean.getDiscreteData();
			discr_msr_id = discData[0];
			discr_msr_id_val=discData[1];
			bean.setDiscreteMeasure(discr_msr_id);
			if((discr_msr_id_val==null))discr_msr_id_val = "";
		}else if(field_type.equals("V")){
			String[] discData = (String[])bean.getClinicalEventsData();
			discr_msr_id = discData[0];
			discr_msr_id_val=discData[1];
			bean.setDiscreteMeasure(discr_msr_id);
			if((discr_msr_id_val==null))discr_msr_id_val = "";
		}

	}
%>

<form name='Order_Entry_Format_Item' id='Order_Entry_Format_Item' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	
	<tr>
		<td    class="label"><fmt:message key="eOR.FieldMnemonic.label" bundle="${or_labels}"/></td>
		<td colspan=2 class="fields"><%if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )){ %><input type=text name="field_mnemonic_disp" id="field_mnemonic_disp" size=20 maxlength=20  value="<%=(bean.getFieldMnemonic()).trim()%>" readonly><input type=hidden name="field_mnemonic" id="field_mnemonic" size=20 maxlength=20  value="<%=(bean.getFieldMnemonic()).trim()%>"><%}else{%><input type=text name="field_mnemonic" id="field_mnemonic" size=20 maxlength=20  value="<%=(bean.getFieldMnemonic()).trim()%>" onBlur='ChangeUpperCaseSpecific(this)'  onkeypress="return CheckForSpecChars(event)"><%}%><img src="../../eCommon/images/mandatory.gif" align="center" ></td></tr>
		<tr><td class="label"><fmt:message key="eOR.FieldMnemonicDesc.label" bundle="${or_labels}"/></td>
		<td colspan=2 class="fields"><%if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )){ %><input type=text name="field_mnemonic_desc_disp" id="field_mnemonic_desc_disp" size=20 maxlength=20  value="<%=(bean.getFieldMnemonicDesc()).trim()%>" onBlur="set_field_mnemonic_desc(this);"><input type=hidden name="field_mnemonic_desc" id="field_mnemonic_desc" size=20 maxlength=20  value="<%=(bean.getFieldMnemonicDesc()).trim()%>"><%}else{%><input type=text name="field_mnemonic_desc" id="field_mnemonic_desc" size=20 maxlength=20  value="<%=(bean.getFieldMnemonicDesc()).trim()%>" 
		><%}%><img src="../../eCommon/images/mandatory.gif" align="center" >
	</tr>
	<tr>
		<td class="label"></td>
		<td>
			<%
				if(mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )){
			%>
		   <table cellpadding=3 cellspacing=0 border=0 >
			<tr>
				<td class="fields" width='' id='dynamicLables'></td>
			</tr>
			</table>

			<%
				}
				out.println("<input type=hidden name='listValues' id='listValues' value='"+finalVals+"'>");
				%>
		</td>
		<td width='' class="label"></td>
	</tr>
	<%if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )){%>
	<tr>
		<td  class="label"></td>
		<td  class="label">
		<%if(bean.getFieldType().equals("N") || bean.getFieldType().equals("I")){%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.MIN.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Max.label" bundle="${common_labels}"/> 
			<%}%>
		</td>
		<td  class="label">
	</tr>
	<%}%>
	<tr>
   
		<td width="25%"   class="label"><fmt:message key="eOR.FieldType.label" bundle="${or_labels}"/></td>
		<td nowrap class=fields><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
				String disp_value = "";
				if(bean.getFieldType().equals("A")){
					disp_value="Alphanumeric";
				} else if(bean.getFieldType().equals("V")){
					disp_value="Clinical Event";
				} else if(bean.getFieldType().equals("D")){
					disp_value="Date";
				} else if(bean.getFieldType().equals("E")){
					disp_value="Date/Time";
				} else if(bean.getFieldType().equals("N")){
					disp_value="Decimal Numeric";
				} else if(bean.getFieldType().equals("M")){
					disp_value="Discrete measure";
				} else if(bean.getFieldType().equals("I")){
					disp_value="Integer Numeric";
				} else if(bean.getFieldType().equals("L")){
					disp_value="List";
				}  else if(bean.getFieldType().equals("R")){
					disp_value="Radio Group";
				}else if(bean.getFieldType().equals("T")){
					disp_value="Time";
				} else if(bean.getFieldType().equals("C")){
					disp_value="Yes/No";
				} 
			%><input type=text name=field_type_display value='<%=disp_value%>' readonly><input type=hidden name=field_type  value="<%=bean.getFieldType()%>">
			<%}else{%><SELECT name="field_type" id="field_type" onChange='chkType()'>
								<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
								<option value='A'><fmt:message key="eOR.Alphanumeric.label" bundle="${or_labels}"/></option>
								<option value='V'><fmt:message key="Common.ClinicalEvent.label" bundle="${common_labels}"/></option>
								<option value='D'><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>
								<option value='E'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></option>
								<option value='N'><fmt:message key="Common.DecimalNumeric.label" bundle="${common_labels}"/></option>
								<option value='M'><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></option>
								<option value='I'><fmt:message key="Common.IntegerNumeric.label" bundle="${common_labels}"/></option>
								<option value='L'><fmt:message key="Common.List.label" bundle="${common_labels}"/></option>
								<option value='R'><fmt:message key="eOR.RadioGroup.label" bundle="${or_labels}"/></option>
								<option value='T'><fmt:message key="Common.time.label" bundle="${common_labels}"/></option>
								<option value='C'><fmt:message key="Common.YesNo.label" bundle="${common_labels}"/></option>
							</SELECT>
			<%}%><img src="../../eCommon/images/mandatory.gif" align="center" >
			<span id='dynamicValues'>
			<%
			if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
				if(field_type.equals("L") || field_type.equals("R")){
				out.println("<input type='button' name='list_button' id='list_button' class='button'  id='NumericField'  value='Fields' onClick='listDetail()' "+allDisabled+" >");

					try{
						List_Data = bean.getAllListData(field_mnemonic,order_category_id);
						//bean.setDataList(List_Data);
						
						
						if(List_Data.size() > 0){
							
							for(i=0; i<List_Data.size(); i++){

								String[] record = (String [])List_Data.get(i);
								bean.setFormatListValues("desc_array"+i,record[0]);
								bean.setFormatListValues("seq_array"+i,record[1]);
								bean.setFormatListValues("key_array"+i,record[2]);
								bean.setFormatListValues("total_rows",String.valueOf(i+1));

								//finalVals =finalVals+ record[0]+"~"+record[1]+"~"+record[2]+"`";
									//finalVals.append(record[0]+"~"+record[1]+"`");
									finalVals=finalVals+record[2];
									
							}
						
							try{
								//finalVals = finalVals.substring(0,(finalVals.length()-1));
								//finalVals.append(finalVals.toString().substring(0,(finalVals.length()-1)));
								}catch(Exception e){
									e.printStackTrace();
								}

					  }		
					  			//bean.setFinalString(finalVals);
								out.println("<input type=hidden name='finalString' id='finalString' value='"+finalVals+"'>");
								out.println("<script>document.Order_Entry_Format_Item.listValues.value ='"+finalVals+"';</script>");
																
					}catch(Exception e){
						e.printStackTrace();
					}
				}else if(field_type.equals("I") || field_type.equals("N")){
					String chk_func="";
					if(field_type.equals("I")){
						chk_func = "return allowPositiveNumber()";
					}else
						chk_func = "return OrAllowDecimalNumber()";
					out.println("<input type=text name='min_value' id='min_value' size=6 maxlength=6   onKeyPress='"+chk_func+"'    onKeyDown='return check(this)'    value='"+bean.getMinValue()+"' "+allDisabled+" >");
					out.println("<input type=text name='max_value' id='max_value' size=6 maxlength=6   onKeyPress='"+chk_func+"' onBlur='chkValues()'  value='"+bean.getMaxValue()+"' "+allDisabled+" >");
				}else if(field_type.equals("M") || field_type.equals("V")){
					out.println("<input type=text name='discrete_value_disp' id='discrete_value_disp' size=15 maxlength=40  readonly value='"+discr_msr_id_val+"'>");
					if(discr_msr_id_val.equals("")){
						out.println("<input type='hidden' name='discrete_value' id='discrete_value' value=''><input type='button' name='descrete_button' id='descrete_button' class='button'  id='descFields'  value='?' onClick='show_discrete_window()'>");
					} else {
						out.println("<input type=hidden name='discrete_value' id='discrete_value' size=15 maxlength=40 value='"+discr_msr_id+"'>");
					}

				}

			}
			%>
		</td>
		<td class="label"></td>
    <tr>	
		<td    class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td colspan=2 class="fields"><% if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {%><input type=text name="order_category_display" id="order_category_display" value="<%=order_category%>" readonly><input type=hidden name="order_category" id="order_category" value="<%=order_category_id%>"><%}else{%><SELECT name="order_category" id="order_category" ><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- <!--  onFocus='chkValues()' --></option><option value='AL'><fmt:message key="eOR.AllCategories.label" bundle="${or_labels}"/></option>
			<!-- <option value='*A'>Non Specific -->
		<%
			try{
				Category_Data = bean.getAllOrderCategory();

				for(i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);

		%>
				<option value=<%=record[0]%>><%=record[1]%></option>
		<%
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		%>
			</SELECT><%}%><img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
	</tr>

	
	<!-- <tr>
		<td width="35%"  align=right class="label">Meaning</td>
		<td colspan=2><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%><input type=text name='meaning' id='meaning' value='<%=meaning_val%>' readonly><input type=hidden name='meaning_value' id='meaning_value' value='<%=meaning%>' size='1' maxlength='2'><%}else{%><input type=text name='meaning' id='meaning' value='User Defined' size='15' maxlength='25' readonly><input type=hidden name='meaning_value' id='meaning_value' value='U' size='1' maxlength='2'><%}%></td>
	</tr> -->



	 <tr>
		<td    class="label"><fmt:message key="Common.DefinitionType.label" bundle="${common_labels}"/></td>
		<td colspan=2 class="fields"><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%><input type=text name='meaning_display' id='meaning_display' value="<%=meaning_val%>" readonly><input type=hidden name='meaning_value' id='meaning_value' value='<%=meaning%>' size='1' maxlength='2'><INPUT TYPE="hidden" value="<%=meaning%>" name="meaning"><%}else{%><input type=text name='meaning' id='meaning' value='User Defined' size='15' maxlength='25' readonly><input type=hidden name='meaning_value' id='meaning_value' 		value='U' size='1' maxlength='2'><%}%></td>
	</tr>
	

<!-- 	<tr>
		<td width="35%"  align=right class="label">Single/Multi</td>
		<td colspan=2><SELECT name="single_multi" id="single_multi" <%=allDisabled%>   <%=systemDisabled%>>
		<option value='S' <%if(single_or_multi.equals("S")) out.println(" selected ");%>>Single
		<option value='M' <%if(single_or_multi.equals("M")) out.println(" selected ");%>>Multi
		</SELECT></td>
	</tr> -->


	<tr>
		<td   class="label"><fmt:message key="Common.Presentation.label" bundle="${common_labels}"/></td>
		<td colspan=2 class="fields"><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){%><SELECT name="presentation_type" id="presentation_type" <%=allDisabled%>   <%//=systemDisabled%> <%if(!(field_type.equals("L"))){%>disabled <%}%>>
		<option value='' <%if(presentation_type.equals("")) out.println(" selected ");%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<option value='S' <%
			//if(presentation_type.equals("S") || (!(field_type.equals("L"))))
		if(presentation_type.equals("S")) 	
		out.println(" selected ");%>><fmt:message key="Common.single.label" bundle="${common_labels}"/>
		<option value='M' <%if(presentation_type.equals("M")) out.println(" selected ");%>><fmt:message key="eOR.Multi.label" bundle="${or_labels}"/>
		</SELECT></td>
		<%}else{%>
		<SELECT name="presentation_type" id="presentation_type" <%=allDisabled%>   <%=systemDisabled%> >
		<option value='' <%if(presentation_type.equals("")) out.println(" selected ");%>>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<option value='S' <%if(presentation_type.equals("S")) out.println(" selected ");%>><fmt:message key="Common.single.label" bundle="${common_labels}"/>
		<option value='M' <%if(presentation_type.equals("M")) out.println(" selected ");%>><fmt:message key="eOR.Multi.label" bundle="${or_labels}"/>
		</SELECT></td>
	   	<%}%>
	</tr>

	
	<tr>
		<td    class="label"><fmt:message key="Common.Selection.label" bundle="${common_labels}"/></td>
		<td colspan=2 class="fields"><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){%><SELECT name="single_multi" id="single_multi" <%=allDisabled%>   <%=systemDisabled%>>
		<option value='S' <%if(single_or_multi.equals("S")) out.println(" selected ");%>><fmt:message key="Common.single.label" bundle="${common_labels}"/>
		<option value='M' <%if(single_or_multi.equals("M")) out.println(" selected ");%>><fmt:message key="eOR.Multi.label" bundle="${or_labels}"/>
		</SELECT></td>
<!-- <INPUT TYPE="hidden" value="<%=single_or_multi%>" name="single_multi"> -->
		<%}else{%>
		<SELECT name="single_multi" id="single_multi" <%=allDisabled%>   <%=systemDisabled%>>
		<option value='S' <%if(single_or_multi.equals("S")) out.println(" selected ");%>><fmt:message key="Common.single.label" bundle="${common_labels}"/>
		<option value='M' <%if(single_or_multi.equals("M")) out.println(" selected ");%>><fmt:message key="eOR.Multi.label" bundle="${or_labels}"/>
		</SELECT></td>
	   	<%}%>
	</tr>
	

	<!-- <tr>
		<td width="35%"  align=right class="label">Hint</td>
		<td colspan=2><input type=text name='hint' id='hint' value='<%=bean.getHint()%>' size='25' maxlength='100' onBlur = "return makeValidString(this)"  <%=allDisabled%>   <%=systemDisabled%>></td>
	</tr>
	 -->


	 <tr>
		<td  class="label"><fmt:message key="eOR.Hint.label" bundle="${or_labels}"/></td>
		<td colspan=2 class="fields"><%
		if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
		%><input type=text name='hint' id='hint' value="<%=bean.getHint()%>" size='25' maxlength='100' onBlur = "return makeValidString(this)"  <%=allDisabled%>   <%=systemDisabled%>>
		<%}else{%><input type=text name='hint' id='hint' value="<%=bean.getHint()%>" size='25' maxlength='100' onBlur = "return makeValidString(this)"  <%=allDisabled%>   <%=systemDisabled%>>
		<%}%>
		</td>
	</tr>

	<tr>
		<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){%>
		<td  colspan=2 class="fields"><INPUT TYPE="checkbox" name="eff_status" id="eff_status" VALUE="E" <%=checked%> <%=readOnly%>  <%=systemDisabled%>></td>
		<%}else{%>
		<td  colspan=2 class="fields"><INPUT TYPE="checkbox" name="eff_status" id="eff_status" VALUE="E" <%=checked%> <%=readOnly%>  <%=systemDisabled%>></td>
		<%}%>
	</tr>
	

</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="sql_or_order_entry_dscr_msr" id="sql_or_order_entry_dscr_msr" value='<%=OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_DRCS_MSR")%>'>
<input type="hidden" name="sql_or_order_entry_dscr_msr1" id="sql_or_order_entry_dscr_msr1" value='<%=OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ITEM_DRCS_MSR1")%>'>

</form>
</body>
</html>

<%putObjectInBean(bean_id,bean,request);%>

