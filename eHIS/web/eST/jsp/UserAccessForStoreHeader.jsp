<!DOCTYPE html>
<%/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

20/10/2021  			TFS:24105			Shazana																	MOHE-SCF-0162		
--------------------------------------------------------------------------------------------------------------------------------------------
*/ %> 

<%@ page import ="eST.Common.StRepository, eST.UserAccessForStoreBean, javax.servlet.ServletContext,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@	include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<!--<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>-->
		<script src='../../eOR/js/OrCommonLookup.js' language='javascript'></script>
		<script src='../../eST/js/UserAccessForStore.js' language='javascript'></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!-- <body onLoad='FocusFirstElement();'> -->

<%  String mode						=	"";
 mode	   = request.getParameter("mode");
 if (mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){ %>
 <body onLoad="document.forms[0].dflt_sal_type.focus()">  
 <% }else{ %>
 
 <body onLoad='FocusFirstElement();' > 
 <% } %>
<form name='Search_form' id='Search_form' onMouseDown="CodeArrest()">
<%
 //	String mode						=	"";
	String bean_id					=	"";
	String bean_name				=	"";
	String store_code_list			=	"";
	String deflt_search_item_modify	=	"";

    
	String user_name				=	"";
	String store_code				=	"";
	String store_desc				=	"";
	String deflt_search_item_insert	=	"";
    String usr_id					=	"";
  //Added by suresh.r 12-11-2013 against JD-CRF-156 beg
    String bl_install_yn 			= 	"";
    String disp_curr_enc_findtl_yn	= 	"";
  //Added by suresh.r 12-11-2013 against JD-CRF-156 end
	
	bean_id							= "userAccessForStoreBean" ;
	bean_name						= "eST.UserAccessForStoreBean" ;
	user_name						= request.getParameter("user_name");
	store_code						= request.getParameter("store_code");
	store_desc						= request.getParameter("store_desc");
    usr_id						= request.getParameter("user_id");
	
	
	
	/* Mandatory checks start */
	UserAccessForStoreBean bean	   = (UserAccessForStoreBean)getBeanObject( bean_id, bean_name, request );

	try{

	ServletContext context = getServletConfig().getServletContext();
	mode						   = request.getParameter("mode");

	if ( mode == null || mode.equals("") ) 
		return ;
	if (!(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( mode ) ; 
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	bl_install_yn = bean.getBLModuleInstalled();//Added by suresh.r 12-11-2013 against JD-CRF-156

		//Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria

	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		  store_code_list  = bean.getStore_code_List();
		  deflt_search_item_insert = bean.checkForNull(bean.getDflt_search_item());
		 }

	if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {
 		  deflt_search_item_modify = bean.checkForNull(request.getParameter("dflt_item_search"));
 		  disp_curr_enc_findtl_yn  = bean.checkForNull(request.getParameter("disp_curr_enc_findtl_yn"));//Added by suresh.r 12-11-2013 against JD-CRF-156  
		}
		//Added ends
		
   putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		out.println("Exception@1: "+e.toString());
		e.printStackTrace();
	}
%>

  <br>
  <table border='0' cellpadding='0' cellspacing='0' width='85%' align='center'>
    <tr>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	</tr>
    <tr>
	  	<td align='left' class='label'><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
	     <td align='left' class=label id=td5>
		 <input type="text" name="user_name" id="user_name" value="<%=user_name%>" size=60 maxLength=60    align="centre" disabled><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(user_name)" align="left" disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="user_id" id="user_id" value="" size="15"></td>
       	<%}else{%>
         <td align='left' class=label id=td5>
		 <input type="text" name="user_name" id="user_name" value="" size=60 maxLength=60    align="centre"><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(user_name)" align="left">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="user_id" id="user_id" value="" size="15"></td>
        <% } %>
		 <td></td>
		  <td></td>
	</tr> 
	
	<tr>
	  	<td align='left' class='label'><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
		<td align='left' class=label colspan='2'><select name="store_name" id="store_name" value="<%=store_code%>" disabled   ><option><%=store_desc%></option></select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="store_id" id="store_id" value="" size="15"></td>
		<td width='*' align = "right" ><input type="button" name="Search" id="Search" class= 'button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onclick="searchDetails()" disabled></input>
		</td>
        <%}else{%>
		<td align='left' class=label colspan='2'><select name="store_name" id="store_name" value="?" onChange="validate_sal_trn()"   ><%=store_code_list%></select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="store_id" id="store_id" value="" size="15"></td>
		<td width='*' align = "right" ><input type="button" name="Search" id="Search" class= 'button' value= '<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchDetails()" ></input>
		</td>
         <% } %>
	</tr>
<!-- <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>  Commented by suresh.r 12-11-2013 against JD-CRF-156-->
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><!-- Added by suresh.r 12-11-2013 against JD-CRF-156 -->
<!-- Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria -->
<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) {%>
		<tr id="trhidden" STYLE=display:none>
		<%}else{%>
	<tr>
<% } %>
		<td align='left' class='label'><fmt:message key="eST.DefaultItemSearchBy.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
		<td align='left' class=label ><select name="dflt_item_search" id="dflt_item_search" value="" onchange="checkRecordsDfltItmSearch(this.value);">
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		<option value="IC" <%=deflt_search_item_modify.equals("IC")?"Selected":""%>><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
		<option value="IN" <%=deflt_search_item_modify.equals("IN")?"Selected":""%>><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></option>
		<option value="MC" <%=deflt_search_item_modify.equals("MC")?"Selected":""%>><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></option>
		<option value="PN" <%=deflt_search_item_modify.equals("PN")?"Selected":""%>><fmt:message key="eST.PartNumber.label" bundle="${st_labels}"/></option>
		<option value="TI" <%=deflt_search_item_modify.equals("TI")?"Selected":""%>><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></option>
		<option value="TN" <%=deflt_search_item_modify.equals("TN")?"Selected":""%>><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></option>
		<option value="AC" <%=deflt_search_item_modify.equals("AC")?"Selected":""%>><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></option></select></td>
		<%}else{%>
		
		<td align='left' class=label ><select name="dflt_item_search" id="dflt_item_search" value="" onchange="checkRecordsDfltItmSearch(this.value);">
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		<option value="IC" <%=deflt_search_item_insert.equals("IC")?"Selected":""%>><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
		<option value="IN" <%=deflt_search_item_insert.equals("IN")?"Selected":""%>><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></option>
		<option value="MC" <%=deflt_search_item_insert.equals("MC")?"Selected":""%>><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></option>
		<option value="PN" <%=deflt_search_item_insert.equals("PN")?"Selected":""%>><fmt:message key="eST.PartNumber.label" bundle="${st_labels}"/></option>
		<option value="TI" <%=deflt_search_item_insert.equals("TI")?"Selected":""%>><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></option>
		<option value="TN" <%=deflt_search_item_insert.equals("TN")?"Selected":""%>><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></option>
		<option value="AC" <%=deflt_search_item_insert.equals("AC")?"Selected":""%>><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></option></select></td>
		<% } %>
		
		<!-- Start by Padmapriya-->
				
				
		<td align='left' class='label'><fmt:message key="eST.DefaultSaleType.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) { %>	
		<td align='left' class=label ><select name="dflt_sal_type" id="dflt_sal_type" value="" onFocus="addSalTrnList(dflt_sal_type); "  onchange="checkRecordsDfltSalType(this.value);">
		
		</select>					
		</td>
		<%}else{%> 
		<td align='left' class=label ><select name="dflt_sal_type" id="dflt_sal_type" value="" onchange="checkRecordsDfltSalType(this.value);">
	 </select>
		
		</td>
	<% } %>   
		<!-- End by Padmapriya-->
		
		
	</tr>
	<!-- Added ends-->
	<!-- Added by suresh r 12-11-2013 against JD-CRF-156 beg -->
<% /*if(bl_install_yn.equals("Y")){ //Commented by suresh.r on 07-05-2014 against #48871(MO-GN-5447) 
		if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) {*/%>
			<tr id="trhidfindtl" STYLE=display:none>
		<%//}else{%>
			<!-- <tr>-->
		<% //} %>
	  	<td align='left' class='label'><fmt:message key="eST.DispCurrEncFinDtl.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
        <td align='left' class=label id=td5>
		<input type=checkbox  name="disp_curr_enc_findtl_yn" id="disp_curr_enc_findtl_yn"  onClick="setDispCurrFind(this);" value="<%=disp_curr_enc_findtl_yn%>" <%=bean.getChecked(disp_curr_enc_findtl_yn)%>></td>
		<td></td>
		<td></td>
	</tr>
<% //} %>
	<!-- Added by suresh r 12-11-2013 against JD-CRF-156 end -->
	<tr>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	 <td align='right' class='label'>&nbsp;&nbsp;</td>
	</tr>
</table>
<input type='hidden'	name="SelectYNStr" id="SelectYNStr"							value="">
<input type="hidden"	name="SQL_ST_USER_LOOKUP_USERACCESS" id="SQL_ST_USER_LOOKUP_USERACCESS"		value="<%=StRepository.getStKeyValue("SQL_ST_USER_LOOKUP_USERACCESS")%>">
<input type='hidden'	name="mode" id="mode"									value="<%=mode%>">
<input type='hidden'	name="language_id" id="language_id"							value="<%=locale%>">
<input type='hidden'	name="str_code" id="str_code"	value="<%=store_code%>">		
<input type='hidden'	name="usr_id" id="usr_id"	value="<%=usr_id%>">		


</form>
</body>
</html>





