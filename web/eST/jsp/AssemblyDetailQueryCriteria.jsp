<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
02/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import ="eST.AssemblyDetailBean,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>

<% 
		 request.setCharacterEncoding("UTF-8");
	
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<Script language='JavaScript' src='../../eCommon/js/common.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
		<Script language='JavaScript' src='../../eCommon/js/CommonResult.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<script>
			function focusObject(){
				document.forms[0].elements[0].focus();
			} 
			
			function addOrderByCol(){  
				var i=0;
				var from = document.getElementById("item")('orderbycols'); 
				if ( from.options.length > 0 ) {
					var to = document.getElementById("item")('orderbycolumns'); 
					var element = document.createElement('OPTION');
					var seltdIndex = from.selectedIndex;
					if(seltdIndex > -1){
						element.text = from.options[from.selectedIndex].text;
						element.value= from.options[from.selectedIndex].value; 
						to.add(element);      
						from.remove(from.selectedIndex);
						if(from.options[i])
							from.options[i].selected=true ;
						i++;
					}
				} 
			} 

			function removeOrderByCol(){
				var j=0;
				var from = document.getElementById("item")('orderbycolumns');
				if ( from.options.length > 0 ){ 
					var to = document.getElementById("item")('orderbycols');
					var element = document.createElement('OPTION');
					var seltdIndex = from.selectedIndex;
					if(seltdIndex > -1){
						element.text = from.options[from.selectedIndex].text;
						element.value = from.options[from.selectedIndex].value;
						to.add(element);    from.remove(from.selectedIndex);
						if(from.options[j]) 
							from.options[j].selected=true; 
						j++;
					}
				}
			}  

			function SelectAll(){
				var i = 0;
				document.getElementById("orderbycolumns").selectedIndex=0; 
				while ( i < document.getElementById("orderbycolumns").length) {
					document.getElementById("orderbycolumns").options[i].selected=true;
					i++; 
				}
			}  

			function execQuery(){
				if(document.getElementById("orderbycolumns").options.length >0 ){
									SelectAll(); 
					document.query_form.submit();
				}
				else{
				alert(getMessage('ORDERBY_NOT_BLANK','Common'))
				}
			}
		</script>
		<%
		
			//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
		String bean_id = "AssemblyDetailBean";
		String bean_name = "eST.AssemblyDetailBean";
		AssemblyDetailBean bean = (AssemblyDetailBean) getBeanObject( bean_id,bean_name,request);  
		
		String ACC_ENTITY_ID = "ZZ";
	    HashMap hmTemp	=	(HashMap)bean.fetchRecord(" SELECT PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_OTHERS_LG FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",ACC_ENTITY_ID);
		 
	     String prep_prepack  =   bean.checkForNull((String)hmTemp.get("PREP_PREPACK_LG"));
	     String prep_standard =   bean.checkForNull((String)hmTemp.get("PREP_STDFORM_LG"));
	     String prep_others   =   bean.checkForNull((String)hmTemp.get("PREP_OTHERS_LG"));
	     
	 if(prep_prepack.equals("") && prep_standard.equals("") &&  prep_others.equals("") ){
	    	 
	    	 prep_prepack  = "Pre Packing";
	         prep_standard = "Standard Formulary";
	         prep_others   =  "Others";
	     }
	 //ends
		%>
	</head>

	<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
		<form name='query_form' id='query_form' method='post' action='AssemblyDetailQueryCriteriaResult.jsp' >
			<table cellpadding=0 cellspacing=0 width="98%" align="center" border="0" >
				<tr>
					<td class='label' width='20%'   align='left' >            
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>&nbsp;&nbsp;&nbsp;
				<td width='*' >	<input type='text' name='item_code' id='item_code' value="" size='40' maxlength='100' >
				</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
				<td class='label' width='20%'     align='left'>    
				   <fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </td>&nbsp;&nbsp;&nbsp;<td width='*' ><input type='text' name='item_desc' id='item_desc' value=""  size='40' maxlength='100' >
			 <SELECT name="searchby_type" id="searchby_type"  >
			<OPTION value="S" >  <fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></OPTION>
			<OPTION value="C" ><fmt:message key="Common.contains.label" bundle="${common_labels}"/></OPTION>
			<OPTION value="E" ><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></OPTION>
				</SELECT>   
				</td>
				</tr> 
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
                <td class="label" width="10%">
				   <fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/> &nbsp; </td>
				  
			  <td class="data" >
		<SELECT name="preparation_type" id="preparation_type" >
			<OPTION value="%" >   <fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
			<!--<OPTION value="P" ><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></OPTION>
			<OPTION value="S" ><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></OPTION>
			<OPTION value="O" ><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION> -->
			<!-- Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts -->
			<%if(!prep_prepack.equals("")){ %>
			<OPTION VALUE="P"><%=prep_prepack %></OPTION>
			<%}if(!prep_standard.equals("")){ %>
			<OPTION VALUE="S"><%=prep_standard %></OPTION>
			<%}if(!prep_others.equals("")){ %>
			<OPTION VALUE="O"><%=prep_others %></OPTION>
			<%} %>
				</SELECT>   

	<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
                <td class="label" width="10%">
				   <fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/> &nbsp; </td>
				  
			  <td class="data" >
			<SELECT name="preparation_mode" id="preparation_mode" >
			<OPTION value="%" >   <fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
			<OPTION value="S" ><fmt:message key="eST.Sterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION value="N" ><fmt:message key="eST.NonSterile.label" bundle="${st_labels}"/></OPTION>
			<OPTION value="O" ><fmt:message key="Common.others.label" bundle="${common_labels}"/></OPTION>
				</SELECT>   
			
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
			</table>
			<br>
			<table width='98%' align='center' ><th width='20%' align='left' ><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
				<tr>
					<td width='60%' > 
					<p  title='Sort Order'>
					<table width='100%'align='center' ><td ><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
						<td>&nbsp;</td><td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
						<tr>
							<td width='45%' align='center'>
								<select name='orderbycols' id='orderbycols' size='5' width='20'>
									<option value='item_code'>                                     
									<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
									&nbsp;&nbsp;&nbsp;&nbsp;</option>
									<option value='item_desc'>                                    
									<fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/>
									&nbsp;&nbsp;&nbsp;&nbsp;</option>
									<option value='preparation_mode'>                             
									 <fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/> 
									&nbsp;&nbsp;&nbsp;&nbsp;</option>
								</select>
							</td>
							<td align='center' width='3%' >
								<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> 
								<input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
							</td>
							<td width='45%' align='center'>
								<select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true' width='20'>
									<option value='preparation_type'>
									<fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
								</select>
							</td>
						</tr>
					</table>
					</p>
					</td>
				</tr>
			</table>
			<br>
			<table border='0' width='100%' align='center'>
				<tr>
					<td width='100%' align='center' class='white'>
						<input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()' Value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>'>
					</td>
				</tr>
			</table> 
	
		</form>
	</body>
</html>

