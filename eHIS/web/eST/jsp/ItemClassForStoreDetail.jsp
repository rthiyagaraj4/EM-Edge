<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*, java.sql.*, java.util.Properties, java.util.ArrayList,java.util.HashMap, eST.Common.StRepository, eCommon.Common.OptionValues,eST.Common.*, eST.* ,java.sql.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css">
 -->
 <%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

 String locale			= (String)session.getAttribute("LOCALE");
 		

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/ItemClassForStore.js"></script>
		<!-- 	<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<body>
<center>
	<form name="formItemClassForStoreDetail" id="formItemClassForStoreDetail">
	<%
	Properties jdbc_props =	null;
	String mode = "";
	String bean_id = "";
	String bean_name = "";
	String	 item_class_code = "";
	String short_desc = "";
	String store_code = request.getParameter("store_code");
	boolean searched =false;
	int  i =	0;
	int recCount =	0;
	try{
		mode	= request.getParameter( "mode" );
		bean_id = "itemClassForStoreBean";
		bean_name = "eST.ItemClassForStoreBean";
		if ( mode == null || mode.equals("") ) 
			return;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return;			
		ItemClassForStoreBean bean = (ItemClassForStoreBean)getBeanObject( bean_id,bean_name,request );  
		bean.setLanguageId(locale);
		ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

		bean.setMode(mode);
		bean.setStore_code(store_code);
		bean.loadItemClass();
		String user_id = CommonAdapter.checkForNull( request.getParameter("user_id") );
		jdbc_props =	(Properties) session.getAttribute("jdbc");
		searched = (request.getParameter("searched") == null) ?false:true;
//String Sql="SELECT item_class_code,short_desc FROM mm_item_class_lang_vw mm_item_class	WHERE eff_status ='E' AND appl_st_yn ='Y'  ORDER	BY short_desc";
		String classValue = "";
		String checked = "";
		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST1"));
//sqlMap.put("sqlData", Sql);
		HashMap funcMap = new HashMap();
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add("item_class_code");
		displayFields.add("short_desc");
	  //The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(locale);
	 // Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		ArrayList selectedItemClass = bean.getSelectedItemClass();
		ArrayList processedItemClasses = bean.getItemClasses();
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding="0" cellspacing="0" width="95%" align=center>
			<tr>
				<td colspan=2 class="white">&nbsp;</td>
			</tr>
			<tr>
				<td width="80%" class="white"></td>
				<td width="20%" class="white"><%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="95%" align=center>
			<tr>
				<th ><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
			</tr>
			<%
				String noDisplay = "";
				String highlight = "";
				ArrayList records = new ArrayList();
				for(recCount=2,i=0; recCount<result.size(); recCount++,i++) {
					if ( recCount % 2 == 0 )
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";
			%>																		
			<tr>
			<%
				//String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				item_class_code = (String)records.get(0);
				short_desc =	(String)records.get(1);
				if (selectedItemClass.contains(item_class_code)) {
					checked = "checked";
				}
				else {
					checked = "";
				}
				if (processedItemClasses.contains(item_class_code)) {
					noDisplay = "NODISPLAY";
					highlight = "DATAHIGHLIGHT";
				}
				else {
					noDisplay = "";
					highlight = "";
				}
			%>
				<td class="<%=classValue%>"><font class='<%=highlight%>'><%=short_desc%></font></td>
				<td class="<%=classValue%>" > <input type="checkbox" name="item_class_<%=i%>" id="item_class_<%=i%>" value="<%=item_class_code%>" <%=checked%> class='<%=noDisplay%>'> </td>
			</tr>
				<input type="hidden" name="remove_item_class_<%=i%>" id="remove_item_class_<%=i%>" value="<%=item_class_code%>">
			<%
				}
				out.flush();
				}
				else{
			%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					history.go(-1);
				</script>
			  <%}%>
					<%		putObjectInBean(bean_id,bean,request);
			%>
				</table>
				<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>"> 
				<input type="hidden" name="total_item_class" id="total_item_class" value="<%=i%>">
				<input type="hidden" name="mode" id="mode" value="<%=mode%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="canProcess" id="canProcess" value="<%=bean.hasRecords()%>">
				<input type="hidden" name="PreviousListValueExit" id="PreviousListValueExit" value="<%=selectedItemClass.size()>0 ? "Y":"N"%>">
				</form>
			<%
			}
			catch(Exception e){
				e.printStackTrace();
			}

			 %>
</table>
	<%
		out.println(CommonBean.setForm (request ,"../../eST/jsp/ItemClassForStoreDetail.jsp", searched) );

	%>
</center>
			
<script>
gettotalcheckBoxes(document.formItemClassForStoreDetail.total_item_class);
</script>
</body>
</html>

