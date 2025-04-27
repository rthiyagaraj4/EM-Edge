<!DOCTYPE html>
<%@ page import ="ePO.Common.PoRepository, ePO.UserAccessForDOBean,java.util.*, javax.servlet.ServletContext " contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@	include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<script src='../../ePO/js/UserAccessForDO.js' language='javascript'></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad='FocusFirstElement();'>
<form name='Search_form' id='Search_form' onMouseDown="CodeArrest()">
<%
 	String mode						=	"";
	String bean_id					=	"";
	String bean_name				=	"";
	String store_code_list			=	"";
	String deflt_search_item_modify	=	"";

    
	String user_name				=	"";
	String store_code				=	"";
	String store_desc				=	"";
	String deflt_search_item_insert	=	"";
	String po_unit_code				=	"";
	String po_unit_desc				=	"";
	String user_store_access_appl	=	"";
	String user_store_access_list	=	"";

	
	bean_id							= "userAccessForDOBean" ;
	bean_name						= "ePO.UserAccessForDOBean" ;
	user_name						= request.getParameter("user_name");
	store_code						= request.getParameter("store_code");
	store_desc						= request.getParameter("store_desc");
	po_unit_code						= request.getParameter("po_unit_code");
	po_unit_desc						= request.getParameter("po_unit_desc");
	

	

	
	
	
	/* Mandatory checks start */
	UserAccessForDOBean bean	   = (UserAccessForDOBean)getBeanObject( bean_id, bean_name, request );

	try{

	ServletContext context = getServletConfig().getServletContext();
	mode						   = request.getParameter("mode");
	System.out.println("mode"+mode);
	

	if ( mode == null || mode.equals("") ) 
		return ;
	if (!(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( mode ) ; 
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	

		//Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria

	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		 // store_code_list  = bean.getStore_code_List();
		  //deflt_search_item_insert = bean.checkForNull(bean.getDflt_search_item());
		 }

	if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {
 		 // deflt_search_item_modify = bean.checkForNull(request.getParameter("dflt_item_search"));
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
	</tr>
    <tr>
	  	<td align='right' class='label'><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
	     <td align='left' class=label id=td5>
		 <input type="text" name="user_name" id="user_name" value="<%=user_name%>" size=60 maxLength=60    align="centre" disabled><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(user_name)" align="left" disabled>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="user_id" id="user_id" value="" size="15"></td>
       	<%}else{%>
         <td align='left' class=label id=td5>
		 <input type="text" name="user_name" id="user_name" value="" size=60 maxLength=60    align="centre"><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(user_name)" align="left">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'><input type="hidden" name="user_id" id="user_id" value="" size="15"></td>
        <% } %>
		 <td></td>
		 <td width='*' align = "right" ><input type="button" name="Search" id="Search" class= 'button' value= '<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchDetails()" ></input>
		</td>
	</tr> 
	
	

		
</table>
<input type='hidden'	name="SelectYNStr" id="SelectYNStr"							value="">
<input type="hidden"	name="SQL_ST_USER_LOOKUP_USERACCESS" id="SQL_ST_USER_LOOKUP_USERACCESS"		value="<%=PoRepository.getPoKeyValue("SQL_ST_PO_USER_LOOKUP_USERACCESS")%>">
<input type='hidden'	name="mode" id="mode"									value="<%=mode%>">
<input type='hidden'	name="language_id" id="language_id"							value="<%=locale%>">



</form>
</body>
</html>





