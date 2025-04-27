<%@page import="java.util.*, eMM.*, eMM.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%@include file ="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
	//locale ="en";
//	String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String supp_status			=	"";
	String bean_id				=	"ItemMasterBean" ;
	String bean_name			=	"eMM.ItemMasterBean";
	ItemMasterBean bean = (ItemMasterBean)getBeanObject( bean_id,bean_name,request ) ;  
	bean.setLanguageId(locale);
	String function_id = request.getParameter( "function_id" );
/*	if (bean.isAPModuleInstalled())
	{ 
	supp_status = "enabled";
	}
	else
	{
	supp_status= "disabled";
	
	}
*/
%>

<html>
<head>
<title><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></title>
<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script src='../../eCommon/js/messages.js' language='JavaScript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../js/Item.js"></script>
<script  language='javascript'>
function searchSupplier(objCode,objDesc) {
	objCode.value = "";
	objDesc.value = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
    var language_id  = document.forms[0].language_id.value;

	argumentArray[0] = document.query_form.SQL_MM_ITEM_MASTER_SUPPLIER.value+"'"+language_id+"'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = "";//objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
//String supp_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Supplier.label","common_labels");
	returnedValues = CommonLookup(getLabel("Common.Supplier.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}
function focusObject()
{	
	document.forms[0].elements[0].focus();
}
function addOrderByCol()
{
	var i=0; 
	var from = document.getElementById('item')('orderbycols'); 
	if ( from.options.length > 0 ) 
		{ 
			var to = document.getElementById('item')('orderbycolumns'); 
			var element = document.createElement('OPTION'); 
			element.text = from.options[from.selectedIndex].text; 
			element.value= from.options[from.selectedIndex].value; 
			to.add(element);
			from.remove(from.selectedIndex); 
				if(from.options[i])  
					from.options[i].selected=true ; i++;
		}
}

function removeOrderByCol()	
{  
	var j=0; 
	var from = document.getElementById('item')('orderbycolumns'); 
	if ( from.options.length > 0 )
		{ 
			var to = document.getElementById('item')('orderbycols');
			var element = document.createElement('OPTION'); 
			element.text = from.options[from.selectedIndex].text; 
			element.value = from.options[from.selectedIndex].value; 
			to.add(element);
			from.remove(from.selectedIndex);
				if(from.options[j]) from.options[j].selected=true; j++;
		 }
}

function SelectAll()
{
	var i = 0;
	document.getElementById("orderbycolumns").selectedIndex=0;
	while ( i < document.getElementById("orderbycolumns").length)
		{
			document.getElementById("orderbycolumns").options[i].selected=true; i++; 
		}
}
function execQuery()
{  
	if(document.getElementById("orderbycolumns").options.length >0 )
		{
		SelectAll();
		document.query_form.submit();
		}
	else
		{
		//alert(getMessage('ORDERBY_NOT_BLANK','ST'))
		}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad='focusObject()'>
<form name='query_form' id='query_form' method='post' action='../jsp/ItemQueryResult.jsp' onsubmit='SelectAll()'>

<table width='98%' align='center' cellspacing='0' cellpadding='0'>
	<tr>
		<th align='left' width='98%'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
		<tr>
			<td ><p title='Query Criteria'>
			<table width='100%'>
				<tr>
					<td align='right' class='label' ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td  align ='left' >&nbsp;&nbsp;<input type=text name = 'item_code' size='20' maxlength='20' onBlur='makeValidQueryCriteria(this);'></td>
				
					<td align='right' class='label' ><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/> </td>
					<td  align ='left' >&nbsp;&nbsp;<input type=text name = 'alpha_code' size='10' maxlength='10' onBlur='makeValidQueryCriteria(this);'></td>
				</tr>
				<tr>
					<td align='right' class='label' ><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td>
					<td  align ='left' >&nbsp;&nbsp;<input type=text name = 'short_desc' size='40' maxlength='40' onBlur='makeValidQueryCriteria(this);'></td>
				
					<td align='right'  class='label'><fmt:message key="eMM.CategoryType.label" bundle="${mm_labels}"/></td>
					<td ' align='left' >&nbsp;&nbsp;<select name='category_type_code' id='category_type_code'><option value='%'>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option><option value='ST'><fmt:message key="Common.Inventory.label" bundle="${common_labels}"/></option><option value='NS'><fmt:message key="eMM.Non-Inventory.label" bundle="${mm_labels}"/></option></select>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="curr_supp_desc" id="curr_supp_desc" value="" maxLength='15' size='15' readOnly <%=supp_status%> ><input type='button' class='BUTTON' value='?' onClick="searchSupplier(curr_supp_code,curr_supp_desc);" <%=supp_status%> ><input type="hidden" name="curr_supp_code" id="curr_supp_code" value=""></td>
					<td align="right" class="label" width='15%' ><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<select name="manufacturer_id" id="manufacturer_id" ><option value="">&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
					<%
						ArrayList	arrManu				=	null;
						HashMap		hmManu				=	null;	
						//String code = "",	
						String	desc  = "", code		=	"";
						arrManu =	bean.getManufacturerList();
						int arrLength	=	arrManu.size();
						for(int i=0;i<arrLength; i++)
						{
							hmManu		=	(HashMap) arrManu.get(i);

							code				=	(String)hmManu.get("code");
							desc				=	(String)hmManu.get("desc");

							%>
								<option value="<%=code%>" ><%=desc%></option>
							<%
						}
						%>
						</select></td>

				</tr>
				<tr>
					<td align='right' class='label'><fmt:message key="Common.SpecialItem.label" bundle="${common_labels}"/></td><td align='left' >&nbsp;&nbsp;<select name='special_item' id='special_item'><option value='%'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option><option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option><option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option></select>&nbsp;</td>
					<td align='right' class='label'><fmt:message key="Common.SoleSource.label" bundle="${common_labels}"/></td><td  align='left' >&nbsp;&nbsp;<select name='sole_source' id='sole_source'><option value='%'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option><option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option><option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option></select>&nbsp;</td>

				</tr>
				<tr>
					<td align='right' class='label'><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td><td   align='left' >&nbsp;&nbsp;<select name='nature' id='nature'><option value='%'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option><option value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option></select>&nbsp;</td>

				</tr>
			</table>
			</td>
		</tr>
	</table></p>
	<table width='98%' align='center'>
		<th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
			<tr>
				<td width='60%' ><p  title='Sort Order'>
				
					<table width='100%'>
						<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
						<td>&nbsp;</td>
						<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<tr>
						<td width='45%'  align='center'>
						<select name='orderbycols' id='orderbycols' size='5' ><option value='short_desc'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option></select></td><td align='center' width='3%' >
						<input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()'></img>
						</td>
						<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'><option value='item_code'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option></select>
						</td>
					</tr>
					</table></p>
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
		<input type="hidden" name="SQL_MM_ITEM_MASTER_SUPPLIER" id="SQL_MM_ITEM_MASTER_SUPPLIER" value="<%= bean.getMmRepositoryValue("SQL_MM_ITEM_MASTER_SUPPLIER")%>">
		<input type="Hidden" name="function_id" id="function_id" value="<%=function_id%>">
		<input type="Hidden" name="language_id" id="language_id" value="<%=locale%>">
		
		<input type="Hidden" name="from_query_or_create" id="from_query_or_create" value="query">

</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

