<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.Common.*, eST.*,eCommon.XSSRequestWrapper " %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<html>
<head>
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
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/Store.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String store_code = request.getParameter("store_code");
	String long_desc = request.getParameter("long_desc");
	String store_type_flag= request.getParameter("store_type_flag");
	String chk_stk_lvl_for_pur_yn= request.getParameter("chk_stk_lvl_for_pur_yn");
	String eff_status = request.getParameter("eff_status");
	String bean_id = "StoreBean";
	String bean_name = "eST.StoreBean";

	StoreBean bean = (StoreBean)getBeanObject(bean_id,  bean_name,request );
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
		HashMap   sqlMap				=	new HashMap();
		HashMap   funcMap				=	new HashMap();
		ArrayList displayFields			=	new ArrayList();
		ArrayList chkFields				=	new ArrayList();
		ArrayList result				=	new ArrayList();
		ArrayList records				=	new ArrayList();
   		ArrayList alTempFlagTypeRecord	=	new ArrayList();  
		ArrayList alFlagRecords			=	new ArrayList();
		ArrayList alTempFlagTypeRecord2	=	new ArrayList();  
		ArrayList alTempFlagTypeRecord1	=	new ArrayList();  
		ArrayList alTempFlagTypeRecord3	=	new ArrayList();  

	try{
		store_code = CommonBean.checkForNull(store_code)+"%";
		store_type_flag = CommonBean.checkForNull(store_type_flag)+"%";
		chk_stk_lvl_for_pur_yn = CommonBean.checkForNull(chk_stk_lvl_for_pur_yn)+"%";
		long_desc = CommonBean.checkForNull(long_desc)+"%";
		eff_status = CommonBean.checkForNull(eff_status);
		

		sqlMap.put("sqlData", "SELECT	A.STORE_CODE, B.LONG_DESC, B.SHORT_DESC, NVL(A.PARENT_STORE_CODE,'') PARENT_STORE_CODE,DECODE(A.STORE_TYPE_FLAG,'M','MAIN','S','SUB STORE','P','PHARMACY','N','NON	STOCK')	STORE_TYPE_DESC	, A.STORE_TYPE_FLAG,B.EFF_STATUS,A.MEDICAL_ITEM_YN, A.NONMEDICAL_ITEM_YN,A.CHK_STK_LVL_FOR_PUR_YN	,A.DFLT_BIN_LOCATION_CODE BIN_LOC_CODE  FROM ST_STORE A, MM_STORE_LANG_VW B WHERE A.STORE_CODE=B.STORE_CODE AND B.FACILITY_ID LIKE	? AND A.STORE_CODE LIKE	UPPER(?) AND UPPER(B.SHORT_DESC)	LIKE UPPER(?) AND A.STORE_TYPE_FLAG	LIKE(?)	AND	A. CHK_STK_LVL_FOR_PUR_YN LIKE(?) AND B.EFF_STATUS LIKE	(?) AND B.LANGUAGE_ID= ?");
				
		displayFields.add("store_code");
		displayFields.add("short_desc");
		displayFields.add("bin_loc_code");
		displayFields.add("medical_item_yn");
		displayFields.add("nonmedical_item_yn");
		displayFields.add("chk_stk_lvl_for_pur_yn");
		displayFields.add("eff_status");
		displayFields.add("store_type_desc");
		displayFields.add("store_type_flag");
		displayFields.add("parent_store_code");

		chkFields.add( (String)session.getAttribute("facility_id"));
		chkFields.add( store_code);
		chkFields.add( long_desc);
		chkFields.add( store_type_flag);
		chkFields.add( chk_stk_lvl_for_pur_yn);
		chkFields.add( eff_status);
		chkFields.add( locale);

		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);
		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center" >
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.StoreDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.ParentStore.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.NonMedicalItems.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="eST.ReorderableStore.label" bundle="${st_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				<%
						String store_type="";

						 for(int recCount=2; recCount<result.size(); recCount++) {    
                           
                             if(( (String)((ArrayList)result.get(recCount)).get(8)).equals("M") ){
							   alTempFlagTypeRecord2=(ArrayList) result.get(recCount);
							   alFlagRecords.add(alTempFlagTypeRecord2);	  
                              }
                          }

                        for(int recCount=2; recCount<result.size(); recCount++) {    
                             if(( (String)((ArrayList)result.get(recCount)).get(8)).equals("N") ){
							  alTempFlagTypeRecord=(ArrayList) result.get(recCount);
						      alFlagRecords.add(alTempFlagTypeRecord);	  
                              }
						}
						 for(int recCount=2; recCount<result.size(); recCount++) {    
                           
                             if(( (String)((ArrayList)result.get(recCount)).get(8)).equals("P") ){
							 alTempFlagTypeRecord1=(ArrayList) result.get(recCount);
							 alFlagRecords.add(alTempFlagTypeRecord1);	  
                             }
                          }
						 for(int recCount=2; recCount<result.size(); recCount++) {    
                           
                             if(( (String)((ArrayList)result.get(recCount)).get(8)).equals("S") ){
							 alTempFlagTypeRecord3=(ArrayList) result.get(recCount);
							 alFlagRecords.add(alTempFlagTypeRecord3);	  
                             }
                          }

						for(int recCount=0; recCount<alFlagRecords.size(); recCount++) {
							classvalue = (recCount % 2 == 0)?"QRYEVEN":"QRYODD";
							//String link_columns = "1";
							records=(ArrayList) alFlagRecords.get(recCount);
							
							if( !store_type_flag.equals((String)records.get(8)) )  {
								store_type_flag= (String)records.get(8);
								store_type= (String)records.get(7);
								out.println("<tr><td class='ITEMSELECT'  colspan='8'><b>"+store_type+"</b></td></tr>");
					}
				
				String 	bin_loc_code=CommonBean.checkForNull((String)records.get(2),"");
				ArrayList arr_lang=new ArrayList();
				arr_lang.add(bin_loc_code);
				arr_lang.add(locale);
				HashMap hmRecord=bean.fetchRecord("select SHORT_DESC Description from MM_BIN_LOCATION_lang_vw where EFF_STATUS='E' and BIN_LOCATION_CODE=? and language_id=?", arr_lang);
				String 	bin_loc_desc=CommonBean.checkForNull((String)hmRecord.get("DESCRIPTION"),"&nbsp;");			
				%>
				<tr onClick="Modify(this);" >
				<td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer';" ><font class='HYPERLINK'><%=records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=CommonBean.checkForNull((String)records.get(9),"&nbsp")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=bin_loc_desc%></td>
			 	<td class="<%=classvalue%>" onclick="disableClick(event);" > 

				<%
					if(((String)records.get(3)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

				%>
				</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<%
					if(((String)records.get(4)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

				%>
				</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<%
					if(((String)records.get(5)).equals("Y"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

				%>
				</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<%
					if(((String)records.get(6)).equals("E"))
						out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
					else
						out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

				%>
				</td>
				<td class="NODISPLAY"><%=records.get(7)%></td>
			
			</tr>
		<%
			}
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/StoreQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception in  Result JSP :"+e.toString());
	}finally{
		sqlMap.clear();	
		funcMap.clear();
		displayFields.clear();
		chkFields.clear();		
		result.clear();		
		records.clear();
		alTempFlagTypeRecord.clear();	
		alFlagRecords.clear();			
		alTempFlagTypeRecord2.clear();
		alTempFlagTypeRecord1.clear();
		alTempFlagTypeRecord3.clear();
	}
%>
</body>
</html>

