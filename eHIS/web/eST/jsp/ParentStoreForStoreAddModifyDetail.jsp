<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
  <%
		request.setCharacterEncoding("UTF-8");
		String locale			=			(String)session.getAttribute("LOCALE");
		String sStyle			=			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/ParentStoreForStore.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
    <script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()">
<%
	String mode							=	(request.getParameter( "mode" ) !=null ? (request.getParameter("mode").trim()):"" );
	String store_code					=	request.getParameter("store_code");
	String store_desc					=	request.getParameter("store_desc");
	String parent_store_code			=	request.getParameter("parent_store_code");
	String parent_store_desc			=	request.getParameter("parent_store_desc");
	String store_index					=	request.getParameter("store_index");
	String	eff_status					=	(request.getParameter( "eff_status" ) !=null ? (request.getParameter("eff_status").trim()):"D" );
	String	item_class_code				=	(request.getParameter( "item_class_code" ) !=null ? (request.getParameter("item_class_code").trim()):"" );

	String store_code_1					=	store_code;
	String parent_store_code_1			=	parent_store_code;
	String store_desc_1					=	store_desc;
	String parent_store_desc_1			=	parent_store_desc;

	String bean_id						=	"ParentStoreForStoreBean";
	String bean_name					=	"eST.ParentStoreForStoreBean";
	String  checked						=		"";
	ArrayList alItemClass				=	new ArrayList();

	ParentStoreForStoreBean bean		=	(ParentStoreForStoreBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	
	if ( mode == null || mode.equals("") )
		return ;

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || 
	       mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
			bean.setEff_Status(eff_status);
	}
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//boolean searched					=	(request.getParameter("searched") == null) ?false:true;
	String classvalue					=	"";
	String item_class_code_1			=	"";
	String db_action_1					=	"";
	String eff_stat_1					=	"";
	int total_index						=	0;
	int index							=	0;
	int count							=	0;
	eff_stat_1							=	(request.getParameter( "eff_stat_1" ) !=null ? (request.getParameter("eff_stat_1").trim()):"D" );
	try{
		store_code					=	 CommonBean.checkForNull(store_code);
		store_desc					=	 CommonBean.checkForNull(store_desc)+"%";
		parent_store_code			=	 CommonBean.checkForNull(parent_store_code);
		parent_store_desc			=	 CommonBean.checkForNull(parent_store_desc)+"%";
		ArrayList chkFields			=	 new ArrayList();
	
		chkFields.add(store_code);	
		chkFields.add(parent_store_code);	
		chkFields.add(store_code);	
		chkFields.add(parent_store_code);	
		chkFields.add(store_code);	
		chkFields.add(parent_store_code);	
		
		

		ArrayList result=(ArrayList)
		bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_PARENT_STORE_SELECT"),chkFields);
			
		if(result.size()!=0){
		%>
		
	<form name="formStoreDetail" id="formStoreDetail" onreset="FocusFirstElement()">
		<input type="hidden"   name="store_index" id="store_index"			value="<%=store_index%>">
<div name='HeaderLabels' id='HeaderLabels' style='width:1010;overflow-x:no;overflow-y:no'>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" height="5%" align="center">
			<tr>	
				<th width="70%"><fmt:message    key="Common.ItemClass.label"     bundle="${common_labels}"/></th>
				<th width="30%"><fmt:message    key="Common.defaultSelect.label"     bundle="${common_labels}"/>
				<input type="checkbox" name="select_all" id="select_all" align="center" onClick="return selectCheck('result.size()');" value="D" ></th>
		</tr>
		</table>
		</div>
<div name='RecordsDtl' id='RecordsDtl' style='width:1022;height:185;overflow-x:auto;overflow-y: auto'>
	
<%
		
			HashMap records=new HashMap();
			for(int recCount=0; recCount<result.size(); recCount++){	
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
%>
			<tr>
<%
				total_index			=	total_index+1;
				records				=	(HashMap) result.get( recCount );
				item_class_code_1	=	(String)records.get("ITEM_CLASS_CODE");
				db_action_1			=	(String)records.get("DB_ACTION");
				eff_stat_1			=	(String)records.get("EFF_STATUS");
				
				for(int colCount=0; colCount<1; colCount++){
					if(colCount==0){
%>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  align="center">
						<td width="70%" class="<%=classvalue%>" > <%=(String)records.get("LONG_DESC")%></td>
						<td class="NODISPLAY" >
						<input type="hidden" name ="item_class_code_<%=index%>" value='<%=item_class_code_1%>'></td>
						<td class="NODISPLAY" >
						<input type="hidden"   name="db_action_<%=index%>" id="db_action_<%=index%>"     value='<%=db_action_1%>'></td>   
						
						<td  class="<%=classvalue%>" width="30%" >
						<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {
							if(eff_stat_1.equals("D"))
								checked="";
							else
								checked="Checked";
							if(bean.alhmData.containsKey(parent_store_code_1)){
								alItemClass = (ArrayList)bean.alhmData.get(parent_store_code_1);
								for(int x=0;x<alItemClass.size();x++){
									if(alItemClass.get(x).equals(item_class_code_1)){
										checked="Checked";
										count++;
										break;
									}
									else
										checked="";
								}
							}
							%>
						<input type="checkbox" name="eff_status_<%=index%>" id="eff_status_<%=index%>"   align="center" value="<%=eff_stat_1%>" onClick="set_Status('<%=index%>',this);" <%=checked%>  ></td>
						<input type="hidden"   name="item_class_code<%=index%>" id="item_class_code<%=index%>"     value="<%=item_class_code%>">
						<% }
					 else {
						alItemClass = (ArrayList)bean.alhmData.get(parent_store_code);
							for(int x=0;x<alItemClass.size();x++){
								if(alItemClass.get(x).equals(item_class_code_1)){
									checked="Checked";
									break;
								}
								else
									checked="";
							}
							
							%>
		
						<input type="checkbox" name="eff_status_<%=index%>" id="eff_status_<%=index%>"   align="center"  onClick="set_Status('<%=index%>',this);" value="<%=eff_stat_1%>" <%=checked%>></td>
						<input type="hidden"   name="item_class_code<%=index%>" id="item_class_code<%=index%>"     value="<%=item_class_code%>">
						<%}%>	

					<%
					index=index+1;
					}else 
					{
						%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<% 
							out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp"));
					%> </td>
					<%
					}
				}
				%>
			</tr>
		<%}	%>
					<input type="hidden"   name="mode" id="mode" 					value="<%=mode%>">
					<input type="hidden"   name="bean_id" id="bean_id" 				value="<%=bean_id%>">
					<input type="hidden"   name="bean_name" id="bean_name" 			value="<%=bean_name%>">
					<input type="hidden"   name="total_index" id="total_index" 			value="<%=total_index%>">
					<input type="hidden"   name="index" id="index" 				value="<%=count%>">
					<input type="hidden"   name="store_code" id="store_code" 			value="<%=store_code_1%>">
					<input type="hidden"   name="store_desc" id="store_desc" 			value="<%=store_desc_1%>">
					<input type="hidden"   name="parent_store_code" id="parent_store_code"     value="<%=parent_store_code_1%>">
					<input type="hidden"   name="parent_store_desc" id="parent_store_desc"     value="<%=parent_store_desc_1%>">
					
				</table>
		</form>
		<%
			out.flush();
		%>
			<script>
				if(eval(document.forms[0].index.value)==eval(document.forms[0].total_index.value))
					document.forms[0].select_all.checked = true;
			</script>
		<%
		}else{
		%>
		<input type="hidden" name="store_index" id="store_index"	value="<%=store_index%>">
			<script>
				alert(getMessage("COMMON_ITEM_CLASS_NOT_FOUND","ST"));
				var store_index = parent.frames[2].document.getElementById("store_index").value;
				//var parentStoreFrame = document.getElementById('parentStoreFrame');
				//eval("parent.frames[1].document.forms[0].chk_"+store_index).checked = false;
				//eval("parent.frames[1].document.forms[0].document.getElementById("td_")"+store_index).style.cursor="";
				//eval("parent.frames[1].document.forms[0].document.getElementById("td_")"+store_index).style.color="";
				eval(parent.frames[1].document.getElementById('chk_'+store_index)).checked = false;
				eval(parent.frames[1].document.getElementById('td_'+store_index)).style.cursor="";
				eval(parent.frames[1].document.getElementById('td_'+store_index)).style.color="";
				document.location.href = "../../eCommon/html/blank.html";
			</script> 
		<%
		}
	
	} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
<% 
   putObjectInBean(bean_id,bean,request);
%>
</html>

