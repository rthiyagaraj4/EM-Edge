
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?                              ?           created
25/7/2011  IN27169		     Dinesh T	 OrderEntryFormat dependencies are not filtered properly
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
02/07/2014	IN049133		Chowminya											CRF:Disallow user to enter the future date in the LMP date field
07/09/2017  IN065192		Krishna Gowtham J	07/09/2017 		Ramesh G.		Alpha-CIS-OR-?Script Error' shows in Order Entry Format'
11/09/2017 IN065232			Krishna Gowtham J	11/09/2017		Ramesh G.		OR-Common-Order Entry Format
--------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.* ,java.util.*,eOR.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!---->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<!-- <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> -->
	<script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrderEntryFormats.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<!--  	<script language="JavaScript" src="../js/OrMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head><!-- onload='FocusFirstElement()'   onMouseDown="CodeArrest()" onKeyDown="lockKey()" -->
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
//	String readOnly = "" ;
//	String allDisabled = "";
//	String systemDisabled = "";
//	String checked = "checked" ;
	/* Mandatory checks start */
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderEntryFormats" ;
	String bean_name = "eOR.OrderEntryFormats";
//	String disabled = "" ;
	ArrayList Category_Data = new ArrayList();
	ArrayList mnemonic_values = new ArrayList();

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	OrderEntryFormats bean = (OrderEntryFormats)getBeanObject( bean_id,bean_name,request ) ;  
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setMode( mode ) ;

/* Initialize Function specific end */
	String format_id			= "";
	String format_level			= "";
	String order_category_id	= "";
	String order_category		= "";
	String order_type			= "";
	String order_type_desc		= "";
	String order_catalog		= "";
	String order_catalog_desc	= "";
	String sys_user_def_ind		= "";
	String frmt_lvl				= "";
	String final_from				= "";
	String format_type_level	= "";

	String meaning_value = "";

    StringBuffer prev_values = new StringBuffer();
	//String sql_or_order_entry_catalog = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_CATALOG");
	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {

		
		format_id = request.getParameter("format_id");

		
		String[] values		= (String[])bean.getMainData (format_id) ;
		format_level		= (String)values[0];
		order_category_id	= (String)values[1];
		order_category		= (String)values[2];
		order_type			= (String)values[3];
		order_type_desc		= (String)values[4];
		order_catalog		= (String)values[5];
		order_catalog_desc	= (String)values[6];
		sys_user_def_ind	= (String)values[7];
		bean.setFormatId(format_id) ;

		bean.setLevel(format_level) ;
		bean.setOrderCategory( order_category_id);
		bean.setOrderCategoryDesc(order_category);
		bean.setMeaningValue(sys_user_def_ind);
		bean.setOrderType(order_type) ;
		bean.setOrderTypeDesc(order_type_desc) ;
		bean.setOrderCatalog(order_catalog) ;
		bean.setOrderCatalogDesc(order_catalog_desc) ;
		

		if(sys_user_def_ind.equals("USER DEFINED"))
			meaning_value = "U";
		else 
			meaning_value = "S";

		if(format_level.equals("Line"))
			frmt_lvl = "L";
		if(format_level.equals("Header"))
			frmt_lvl = "H";

				

		mnemonic_values = bean.getMnemonics(frmt_lvl, order_category_id, order_type, order_catalog);//Gets the mnemonics from the db
		
		for(int i=0; i<mnemonic_values.size(); i++){
			String[] record = (String [])mnemonic_values.get(i);
			for(int j=0; j<9; j++){
				if(record[j] == null || record[j].trim().equals("null")){
						record[j] = " ";
				}
			}
			if(record[6].equals("Y")){
			ArrayList depend_values = new ArrayList();
		depend_values = bean.getDependency(frmt_lvl,order_category_id,order_type,order_catalog,record[0],record[1]);

		for(int k=0; k<depend_values.size(); k++){
			String[] record1 = (String [])depend_values.get(k);
			if(record1[2] == null)
				record1[2] = " ";
			if(record1[3] == null)
				record1[3] = " ";
			if(record1[5] == null)
				record1[5] = " ";
				if(record1[7].equals("Y")){
				String value_seq_num = record1[1];
				record1[7]="";
				ArrayList mnemonic_values1 = new ArrayList();
				mnemonic_values1 = bean.getOthMnemonic(frmt_lvl,order_category_id,order_type,order_catalog,record[0],record[1],value_seq_num);
				
				for(int h=0; h<mnemonic_values1.size(); h++){
					String[] record2 = (String [])mnemonic_values1.get(h);
					if(record2[4] == null)
						record2[4] = " ";
					if(record2[5] == null)
						record2[5] = " ";
					if(record2[6] == null)
						record2[6] = " ";
					if(record2[7] == null)
						record2[7] = "";
					if(record2[8] == null)
						record2[8] = "";
					//IN049133 - Start
					if(record2[9] == null)
						record2[9] = "";
					if(record2[9].equals("Y"))
					{
						record2[9]="";
						ArrayList oth_depend_values = new ArrayList();
						oth_depend_values = bean.getOthDependMnemonic(frmt_lvl,order_category_id,order_type,order_catalog,record2[0],record2[1]);
						
						for(int l=0; l<oth_depend_values.size(); l++)
						{
							String[] record3 = (String [])oth_depend_values.get(l);
							if(record3[2] == null)
								record3[2] = " ";
							if(record3[3] == null)
								record3[3] = " ";
							if(record3[4] == null || ("null").equals(record3[4]))
								record3[4] = " ";	
							if(record3[0]!=null||record3[0]!="")	
							{					
								bean.setFormatListValues("othdependency_"+k+"array"+l,record3[0]);	
							}	
							if(record3[5] == null)
								record3[5] = " ";
							record2[9]=record2[9]+record3[0]+"^"+record3[1]+"^"+record3[5]+"^"+record3[2]+"^"+record3[3]+"^"+record3[4]+"@";
						}
					}else if(record2[9].equals("N"))
						record2[9]=" ";		
				//IN049133 - End       
					if(record2[4]!=null||record2[4]!="")
					{
						bean.setFormatListValues("dfltValue_"+i+"Othernemonic_"+k+"array"+h,record2[4]);
					}
					if(record2[2]!=null||record2[2]!="")
					{
						bean.setFormatListValues("labeltext_"+i+"Othernemonic_"+k+"array"+h,record2[2]);	
					}
					//record1[7] = record1[7]+ record2[0]+"$"+record2[1]+"$"+"labeltext_"+i+"Othernemonic_"+k+"array"+h+"$"+record2[3]+"$"+"dfltValue_"+i+"Othernemonic_"+k+"array"+h+"$"+record2[5]+"$"+record2[6]+"$"+record2[7]+"$"+record2[8]+"!!"; //<IN27169>
					//IN065192 start
					//record1[7] = record1[7]+ record2[0]+"$"+record2[1]+"$"+"labeltext_"+i+"Othernemonic_"+k+"array"+h+"$"+record2[3]+"$"+"dfltValue_"+i+"Othernemonic_"+k+"array"+h+"$"+record2[5]+"$"+record2[6]+"$"+record2[7]+"$"+record2[8]+"$"+" "+"$"+" "+"$"+record2[9]+"!!"; //IN049133
					if((record2[7]!=null)&&(record2[7]!="") && (record2[8]!=null)&&(record2[8]!="")){
						record1[7] = record1[7]+ record2[0]+"$"+record2[1]+"$"+"labeltext_"+i+"Othernemonic_"+k+"array"+h+"$"+record2[3]+"$"+"dfltValue_"+i+"Othernemonic_"+k+"array"+h+"$"+record2[5]+"$"+record2[6]+"$"+record2[7]+"$"+record2[8]+"$"+record2[9]+"!!";
					}
					else{
						record1[7] = record1[7]+ record2[0]+"$"+record2[1]+"$"+"labeltext_"+i+"Othernemonic_"+k+"array"+h+"$"+record2[3]+"$"+"dfltValue_"+i+"Othernemonic_"+k+"array"+h+"$"+record2[5]+"$"+record2[6]+"$"+record2[7]+"$"+record2[8]+"$"+" "+"$"+" "+"$"+record2[9]+"!!";
					}
					//IN065192 end
					//record1[7] = record2[0]+"$"+record2[1]+"$"+record2[2]+"$"+record2[3]+"$"+record2[4]+"$"+record2[5]+"$"+record2[6]+"$"+record2[7]+"$"+record2[8]+"!!";			
					
				}
			}else if(record1[7].equals("N"))
					record1[7]=" ";	
			
			
				if(record1[0]!=null||record1[0]!="")	
				{					
					bean.setFormatListValues("dependency_"+i+"array"+k,record1[0]);	
				}	
			format_type_level = (String)record[7];
			//record[6] =record[6]+ record1[0]+","+record1[1]+","+record1[2]+","+record1[3]+","+record1[4]+","+record1[5]+","+record1[6]+","+record1[7]+"||";
			if(format_type_level.equals("L"))
			{
				record[6]=record[6]+"dependency_"+i+"array"+k+","+record1[1]+","+record1[2]+","+record1[3]+","+record1[4]+","+record1[5]+","+record1[6]+","+record1[7]+"||";
			}
			else
			{
				//IN065232 Start
				//record[6]=record[6]+record1[0]+","+record1[1]+","+record1[2]+","+record1[3]+","+record1[4]+","+record1[5]+","+record1[6]+","+record1[7]+"||";
				if(record[6].equals("Y")){
					record[6]=record1[0]+","+record1[1]+","+record1[2]+","+record1[3]+","+record1[4]+","+record1[5]+","+record1[6]+","+record1[7]+"||";
				}else{
					record[6]=record[6]+record1[0]+","+record1[1]+","+record1[2]+","+record1[3]+","+record1[4]+","+record1[5]+","+record1[6]+","+record1[7]+"||";
				}
				//IN065232 ends	
			}
			
		}
			}else if(record[6].equals("N"))
					record[6]=" ";
						
			//prev_values += record[0]+"~"+record[1]+"~"+record[2]+"~"+record[3]+"~"+record[4]+"~"+record[5]+"~"+record[6]+"~"+record[7]+"~"+record[8]+"`";

			//prev_values.append(record[0]+"~"+record[1]+"~"+record[2]+"~"+record[3]+"~"+record[4]+"~"+record[5]+"~"+record[6]+"~"+record[7]+"~"+record[8]+"`");
			if(record[4]!=null||record[4]!="")
			{
			bean.setFormatListValues("descValue_array"+i,record[4]);			
			}
				if(record[2]!=null||record[2]!="")
			{
			bean.setFormatListValues("labeltextValue_array"+i,record[2]);			
			}
			//String temp="descValue_array"+i;
			//prev_values.append(record[0]+"~"+record[1]+"~"+"labeltextValue_array"+record[0]+"~"+record[3]+"~"+"descValue_array"+record[0]+"~"+record[5]+"~"+record[6]+"~"+record[7]+"~"+record[8]+"`"); by Ambiga	
			final_from=record[0]+"~"+record[1]+"~"+"labeltextValue_array"+i+"~"+record[3]+"~"+"descValue_array"+i+"~"+record[5]+"~"+record[6]+"~"+record[7]+"~"+record[8];
			//bean.setFormatFinalValues(Integer.parseInt(record[0]),final_from);
			bean.setFormatFinalValues(i,final_from);			
		}
	}	
%>
<form name='Order_Entry_Formats' id='Order_Entry_Formats' target='messageFrame' >

	<input type="hidden" name="format_id" id="format_id" value="<%=format_id%>">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<!--<tr>
		<td colspan="4">&nbsp;</td>
	</tr> -->
	<tr>
		<td  class="label" width="25%"><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
		<td colspan=3 class="fields"><%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%><input type=text name="level_disp" id="level_disp" size='15' value="<%=bean.getLevel()%>" readOnly><input type=hidden name="level" id="level" size='15' value='<%=frmt_lvl%>'><%}else{%><SELECT name="level" id="level" onChange="checkLevel()">
		<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
		<option value="H"><fmt:message key="Common.Header.label" bundle="${common_labels}"/></option>
		<option value="L"><fmt:message key="Common.Line.label" bundle="${common_labels}"/></option>
		</SELECT><%}%><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	
	<tr>
		<td width=""   class="label" width="25%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td colspan=3 class="fields"><%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%><input type=text  name="order_category_disp" id="order_category_disp" size='15' value="<%=bean.getOrderCategoryDesc()%>" readOnly><input type=hidden  name="order_category" id="order_category" size='15' value="<%=bean.getOrderCategory()%>"><%}else{%><SELECT name="order_category" id="order_category" onChange='populateOrderTyoes(this)'>
			<option value=''>  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  
			 <!-- &nbsp;&nbsp;&nbsp;<option value='*A'>Non Specific  -->
		<%
				Category_Data = bean.getAllOrderCategory();

				for(int i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);
			
		%>
				<option value='<%=record[0]%>'><%=record[1]%>
		<%	
				}
		%>
			</SELECT><%}%><img src="../../eCommon/images/mandatory.gif">
		</td>
	</tr>
	
	<tr>
		<td  class="label" width="25%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td  class=fields colspan=3><%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%><input type=text  name="order_type_disp" id="order_type_disp" size='15' value="<%=bean.getOrderTypeDesc()%>" readOnly><input type='hidden'  name="order_type" id="order_type" size='15' value="<%=bean.getOrderType()%>"><%}else{%><SELECT name="order_type" id="order_type" onChange='checkOrderType()'>
				<option value=''>  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
				<option value='*ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			</SELECT><%}%><img src="../../eCommon/images/mandatory.gif" align=center></td>
	</tr>
	
	<tr >
		<td  width="" class="label" width="25%"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%><td width="20%" class=fields><input type=text  name="order_catalog_disp" id="order_catalog_disp" size='25' value="<%=bean.getOrderCatalogDesc()%>" readOnly><input type=hidden  name="order_catalog" id="order_catalog" size='' value="<%=bean.getOrderCatalog()%>"><%}else{%><td width="20%" class=fields><input type=text name=order_catalog_disp size='30' maxlength='40' value="" onfocus='blur()'><input type=hidden name=order_catalog size='' maxlength='' value=""><%}%><span   id='dynamicButton'><img src="../../eCommon/images/mandatory.gif" align=center></span></td><td class="fields" align="left" width="25%"><input type='button' name='field_mnemonic' id='field_mnemonic' value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FormatItem.label","common_labels")%>'  class='button' onClick='listDetail()'></td>
		</tr>
	
	<tr>
		<td  class="label" width="25%"><fmt:message key="Common.DefinitionType.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan="3"><%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%><input type=text  name="meaning" id="meaning" size='17' value="<%=bean.getMeaningValue()%>" readOnly><input type=hidden name='meaning_value' id='meaning_value' value='<%=meaning_value%>' size='1' maxlength='2'><%}else{%><input type=text name='meaning' id='meaning' value='User Defined' size='15' maxlength='25' readonly><input type=hidden name='meaning_value' id='meaning_value' value='U' size='1' maxlength='2'><%}%></td>
	</tr>
	

</table>

<input type="hidden"  name='listValues' id='listValues' value="<%=prev_values.toString()%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name='finalString' id='finalString' value=''>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<!-- <input type="hidden" name="sql_or_order_entry_catalog" id="sql_or_order_entry_catalog" value="<//%=sql_or_order_entry_catalog%>"> -->
<input type="hidden" name="function_id" id="function_id" value="">
<!-- <input type="text" name="mnemonic_size" id="mnemonic_size" value="<%=mnemonic_values.size()%>">
 -->
</form>
</body>
</html>
<%
 putObjectInBean(bean_id,bean,request);
%>

