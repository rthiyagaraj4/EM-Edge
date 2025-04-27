<%@page  import=" eST.*,eST.Common.*,java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title> </title>
	<%
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		KitTemplateBean bean	=		(KitTemplateBean)getBeanObject( "kitTemplateBean","eST.KitTemplateBean", request ) ;  
		bean.setLanguageId(locale);

		String index			=		bean.checkForNull(request.getParameter("index"),"-1");
		String mode				=		request.getParameter("mode");
		String item_code		=		"";
		String item_desc		=		"";
		String qty				=		"";
		String uom_code			=		"";
		String seq_no			=		"";
		String eff_status		=		"";
		String cheked			=		"";
		String disab			=		"";
		String db_action		=		"";
		String usage_type       =        "";  //27/07/12
		String legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
		NumberFormat nf_qty = NumberFormat.getInstance(new Locale(locale));

		item_code				=		request.getParameter("item_code")==null?"":request.getParameter("item_code");
		item_desc				=		request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
		qty						=		request.getParameter("qty")==null?"":request.getParameter("qty");
		uom_code				=		request.getParameter("uom_code")==null?"":request.getParameter("uom_code");
		seq_no					=		request.getParameter("seq_no")==null?"":request.getParameter("seq_no");
		eff_status				=		request.getParameter("eff_status")==null?"E":request.getParameter("eff_status");
		usage_type				=		request.getParameter("usage_type")==null?"":request.getParameter("usage_type").trim(); //27/07/12
		 System.out.println("usage_type=======>" +usage_type);

		if(item_code!="")
				disab			=		"disabled";
		if(eff_status.equals("E"))
				cheked			=		"checked";
				db_action		=		request.getParameter("db_action")==null?"I":request.getParameter("db_action");

		if(!index.equals("-1")){
				 legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		}
		/**
		* @Name - Krishna Kiran 
		* @Date - 20/01/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - added code to handle the decimal values DYNAMICALLY.
		*/
		int no_of_decimals		=			bean.getNoOfDecimals();
		if (item_code != ""){
			if((bean.getAllowDecimalsYN(item_code)).equals("N")){
				no_of_decimals = 0;
			}
		}
		nf_qty.setMaximumFractionDigits(no_of_decimals);
		nf_qty.setMinimumFractionDigits(no_of_decimals);
		if (qty!=""){
			//qty = nf_qty.format(Double.parseDouble(bean.checkForNull(qty,"0")));		
			  qty = bean.setNumber(bean.checkForNull(qty,"0"),no_of_decimals);
		}
		/*code ends for handling the decimal values DYNAMICALLY.*/
		
		
		        if(usage_type.equals("Required")){
					 usage_type = "R";
				 }else if(usage_type.equals("Optional Required")){
					 usage_type = "O";
				 }else if(usage_type.equals("Optional Pre-Selected")){
					 usage_type = "P";
				 }else if(usage_type.equals("Optional De-Selected")){
					 usage_type = "D";
				 } 
%>

        <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/KitTemplate.js"></script>
        <Script language="JavaScript" src="../../eCommon/js/showModalDialog.js"></Script>



	</head>
	<body onLoad="CodeArrest()">
	<form name="KitTemplateAddModifyform" id="KitTemplateAddModifyform">
		<table border='0' cellpadding='0' cellspacing='0' width='100%' height='50%'>
		<th colspan='7' align="left"><fmt:message key="eST.Add/ModifyItem.label" bundle="${st_labels}"/></th>
		<tr>
			<td class="label" align="left"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan="6" align=left class='label'>&nbsp;<input type=text name="item_desc" id="item_desc" size=70 maxlength=60 value="<%=item_desc%>" <%=disab%>><input type=button name="item_search" id="item_search" class="button"  onClick="callItemSearchScreen()"  value='?'<%=disab%>><%=bean.getImage("M")%><input type="hidden" name="item_code" id="item_code" value="<%=item_code%>"></td>
		</tr>
		<tr>
		<!-- 	/**
			* @Name - Krishna Kiran
			* @Date - 20/01/2010
			* @Inc# - IN015496
			* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12.
			*/
		 -->	
		 <!-- 	/**
			* @Name - Priya
			* @Date - 12/02/2010
			* @Inc# - IN019273
			* @Desc - the parameter for integer value is changed to 7 from 12 in the func. isValidNumber(this,event,12,<%=no_of_decimals%>).
			*/
		 -->
			<td class=label align="left"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td align=left>&nbsp;&nbsp;<input type=text name="qty" id="qty" size=12 maxlength=12 class="NUMBER" onKeyPress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="checkDoubleFormat(this,false);" value="<%=qty%>" ><%=bean.getImage("M")%>
			</td>
			<%
				if ((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))&&(item_code!="")) {
					
			%>
			<td class="label"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
			<td><select name="uom_code" id="uom_code"><%=bean.getPur_uom_code_Modify_List(uom_code,item_code)%></select><%=bean.getImage("M")%>
			</td>
			<%
			}else{
			%>
			<td class="label"><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
			<td><select name="uom_code" id="uom_code"><option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option></select><%=bean.getImage("M")%>
			</td>
			<%}%>
			<td class=label align=right colspan="2"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
			<td align=left>&nbsp;<input type=text name="seq_no" id="seq_no" size=6 maxlength=4 class="NUMBER" onKeyPress="return CheckForSequence(event);"  onBlur="checkSeqNo(this);" value="<%=seq_no%>" ><%=bean.getImage("M")%>
		</tr>
		<tr>
			<td class=label align="left"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>&nbsp;
			<td><input type="checkBox" name="eff_status" id="eff_status" value="<%=eff_status%>" <%=cheked%> onclick="assignValue(this);"></td>
			
			
			
				<%if ((mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")))&& !(item_code.equals(""))) {%>	
			
			     <td  class="label"><fmt:message key="eST.UsageType.label" bundle="${st_labels}"/></td>
		        <td><select name="usage_type" id="usage_type"> <!--<option value="" >&nbsp;&nbsp;&nbsp;&nbsp;---------<fmt:message key="Common.defaultSelect.label"   bundle="${common_labels}"/>---------&nbsp;&nbsp;</option>-->
  			    <option value="O" <%=usage_type.equals("O")?"Selected":""%>><fmt:message key="eST.Optional/Required.label" bundle="${st_labels}"/></option>
	            <option value="R" <%=usage_type.equals("R")?"Selected":""%>><fmt:message key="eST.Required.label" bundle="${st_labels}"/> </option>
			    <option value="P" <%=usage_type.equals("P")?"Selected":""%>><fmt:message key="eST.Optional/PreSelected.label" bundle="${st_labels}"/></option>
			    <option value="D" <%=usage_type.equals("D")?"Selected":""%>><fmt:message key="eST.Optional/DeSelected.label" bundle="${st_labels}"/></option>
				</select><%=bean.getImage("M")%></td>
			
				<%}else{ %>
			    <td  class="label"><fmt:message key="eST.UsageType.label" bundle="${st_labels}"/></td>
		        <td><select name="usage_type" id="usage_type"> 
		        <!--<option value="" >&nbsp;&nbsp;&nbsp;&nbsp;---------<fmt:message key="Common.defaultSelect.label"   bundle="${common_labels}"/>---------&nbsp;&nbsp;</option>-->
				<option value="O"><fmt:message key="eST.Optional/Required.label" bundle="${st_labels}"/></option>
	            <option value="R"><fmt:message key="eST.Required.label" bundle="${st_labels}"/> </option>
			    <option value="P"><fmt:message key="eST.Optional/PreSelected.label" bundle="${st_labels}"/></option>
			    <option value="D"><fmt:message key="eST.Optional/DeSelected.label" bundle="${st_labels}"/></option>
				</select><%=bean.getImage("M")%></td>
				<%}%>
			<td class=label align=right colspan='2'>&nbsp;</td>
			<td><input type=button name="save" id="save" value="<%=legend%>" class=button onclick="addToList();">&nbsp;<input type=button name=Cancel value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="cancel_me();"></td>
		</tr>
		</table>
		<input type="hidden" name="index" id="index"		value="<%=index%>">
		<input type="hidden" name="db_action" id="db_action"	value="<%=db_action%>">
		<input type="hidden" name="dec_allowed_yn" id="dec_allowed_yn"	value="<%=bean.getAllowDecimalsYN(item_code)%>">
	</form>
<%  
  putObjectInBean("kitTemplateBean",bean,request);
%>
	</body>
</html>


