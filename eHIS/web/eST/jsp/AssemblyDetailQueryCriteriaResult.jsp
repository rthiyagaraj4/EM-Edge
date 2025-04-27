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
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/AssemblyDetail.js"></script>
	<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()">
<%
	String bean_id = "AssemblyDetailBean";
	String bean_name = "eST.AssemblyDetailBean";
	AssemblyDetailBean bean = (AssemblyDetailBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String item_code = request.getParameter("item_code");
	String preparation_type = request.getParameter("preparation_type");
	String preparation_mode = request.getParameter("preparation_mode");
	String item_desc1 = request.getParameter("item_desc");
	String searchby_type = request.getParameter("searchby_type");

	ArrayList records=null;
	ArrayList recordsModify=new ArrayList();
	String temp_store = "";
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
	try{
		preparation_type = CommonBean.checkForNull(preparation_type)+"%";
		preparation_mode = CommonBean.checkForNull(preparation_mode)+"%";
		item_code = CommonBean.checkForNull(item_code).toUpperCase()+"%";
		HashMap sqlMap = new HashMap();
		HashMap funcMap = new HashMap();
		ArrayList displayFields = new ArrayList();
		ArrayList chkFields = new ArrayList();
		String item_desc="";
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
		String ACC_ENTITY_ID = "ZZ";
	    HashMap hmTemp	=	(HashMap)bean.fetchRecord(" SELECT PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_OTHERS_LG FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",ACC_ENTITY_ID);
		 
	    String prep_prepack  =   bean.checkForNull((String)hmTemp.get("PREP_PREPACK_LG"));
	     String prep_standard =   bean.checkForNull((String)hmTemp.get("PREP_STDFORM_LG"));
	     String prep_others   =   bean.checkForNull((String)hmTemp.get("PREP_OTHERS_LG"));
	     
	 if(prep_prepack.equals("") && prep_standard.equals("") && prep_others.equals("") ){
	    	 
	    	 prep_prepack  = "Pre Packing";
	         prep_standard = "Standard Formulary";
	         prep_others   =  "Others";
	     }
		 
		//String sql_1="SELECT a.item_code, base_qty,DECODE (preparation_type,'P', 'Pre Packing','S', 'Standard	Formulary','E', 'Extemporaneous','O', 'Others') prep_type_desc,DECODE (preparation_mode,'S', 'Sterile','N', 'Non Sterile','O', 'Others') prep_mode_desc,process_loss_percent, preparation_type, preparation_mode, label_type,b.short_desc item_desc, c.short_desc uom_desc FROM st_assembly_hdr a, mm_item_lang_vw b, am_uom_lang_vw c WHERE a.item_code = b.item_code AND b.gen_uom_code = c.uom_code(+) AND UPPER (a.item_code) LIKE (? || '%') AND UPPER (b.short_desc) LIKE (? || '%') AND preparation_type LIKE (?) AND preparation_mode LIKE (?) AND b.language_id = ? AND c.language_id(+) = ? and UPPER (b.SHORT_DESC) like UPPER(?)";
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ASSEMBLY_HDR_QUERY_RESULT"));
	//	sqlMap.put("sqlData",sql_1);
		displayFields.add("item_code");
		displayFields.add("base_qty");
		displayFields.add("prep_type_desc");
		displayFields.add("prep_mode_desc");
		displayFields.add("process_loss_percent");
		displayFields.add("preparation_type");
		displayFields.add("preparation_mode");
		displayFields.add("label_type");
		displayFields.add("item_desc");
		displayFields.add("uom_desc");
		displayFields.add("instruction_text"); //Added by Rabbani #Incno:33366 on:18/10/2012
		displayFields.add("shelf_life_value"); //Added for ML-MMOH-CRF-1909
        displayFields.add("shelf_life_flag"); //Added for ML-MMOH-CRF-1909
		
		chkFields.add(item_code);
		chkFields.add(item_desc);
		chkFields.add(preparation_type);
		chkFields.add(preparation_mode);
		chkFields.add(locale);
		chkFields.add(locale);
		if(item_desc1.length()==0){
		chkFields.add("%");
		}else{
		if(searchby_type.equals("S")){
		chkFields.add(item_desc1+"%");
		}else if(searchby_type.equals("C")){
			chkFields.add("%"+item_desc1+"%");
		}else if(searchby_type.equals("E")){
			chkFields.add("%"+item_desc1);
		}
		}
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
	

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align=center>
		
				<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.BaseQuantity.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.PreparationMode.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ProcessLoss.label" bundle="${st_labels}"/></th>
				
			
				<%
					int i=0;
						records=new ArrayList();
						

						for(int recCount=2; recCount<result.size(); recCount++) {
							classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
							records=(ArrayList) result.get(recCount);
							recordsModify.add(records);
							String preparation_desc="";
							//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
							String prep_type = bean.checkForNull((String)records.get(5));
							if (prep_type.equals("P"))
								preparation_desc = prep_prepack;
							else if (prep_type.equals("S"))
								preparation_desc = prep_standard;
							else
								preparation_desc = prep_others;
							//ends

							if(! ((String)records.get(5)).equals(temp_store)) {
								
								out.println("<tr><td class='ITEMSELECT'  colspan='8'><b>"+preparation_desc+"</b></td></tr>");
							}
							String allow_deci_yn            =   bean.checkForNull(bean.getAllowDecimalsYN((String)records.get(0)),"N");
	                        String no_deci =   bean.checkForNull(""+bean.getNoOfDecimals(),"0");
		                    if(allow_deci_yn.equals("N"))
                            no_deci ="0";
						
				%>
				<tr onClick="Modify('<%=recCount%>');" >
					<!--
					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Base Quantity, Process Loss .
										
					-->
				<td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer'"><font class='HYPERLINK'><%=records.get(0)%></font></td>
				<td class="<%=classvalue%>"   onclick="disableClick(event);"><%=records.get(8)%></td>
				<td class="<%=classvalue%>"  style="TEXT-ALIGN:right"><font onclick="disableClick(event);"><%=bean.setNumber((String)records.get(1),Integer.parseInt(no_deci))%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" style="TEXT-ALIGN:right" > <%=CommonBean.checkForNull((String)records.get(4),"&nbsp;")%>&nbsp;</td>
				
				

			</tr>
		<%
					i++;
			temp_store = (String)records.get(5) ;
			}
				bean.setDataList(result);
		
		%>
		</table>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/AssemblyDetailQueryCriteriaResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

