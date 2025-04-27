<!DOCTYPE html>
<%@ page import="eST.*, eST.Common.* , ePH.Common.* , eCommon.Common.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
request= new XSSRequestWrapper(request); 
response.addHeader("X-XSS-Protection", "1; mode=block"); 
response.addHeader("X-Content-Type-Options", "nosniff"); 
//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../ePH/js/PresRemarkForDrug.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String remarks_desc = java.net.URLDecoder.decode(request.getParameter("remarks_desc"),"UTF-8");
		String drug_code	= request.getParameter("drug_code");
		String drug_desc	= request.getParameter("drug_desc");
		String form_desc    = request.getParameter("form_desc");
		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String classvalue = "";
		try{
			
			remarks_desc = CommonBean.checkForNull(remarks_desc)+"%";
			drug_code = CommonBean.checkForNull(drug_code)+"%";
			drug_desc = CommonBean.checkForNull(drug_desc)+"%";
			form_desc = CommonBean.checkForNull(form_desc)+"%";

			HashMap sqlMap = new HashMap();
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			
			String sql = "SELECT DRUG.DRUG_CODE, DRUG.DRUG_DESC, FORMS.FORM_DESC, PRES.REMARK_DESC, ROUTE.ROUTE_DESC,  PRESDRUG.DEFAULT_REMARK_YN, PRESDRUG.EFF_STATUS, PRES.ROUTE_CODE, DRUG.FORM_CODE,ROUTE.ROUTE_COLOR FROM PH_DRUG_LANG_VW DRUG, PH_PRES_REMARK_LANG_VW PRES, PH_PRES_REMARK_FOR_DRUG PRESDRUG, PH_FORM_LANG_VW FORMS, PH_ROUTE_LANG_VW ROUTE WHERE UPPER (PRES.REMARK_DESC) LIKE UPPER (?) AND UPPER (DRUG.DRUG_CODE) LIKE UPPER (?) AND UPPER (DRUG.DRUG_DESC) LIKE UPPER (?) AND UPPER (DRUG.FORM_CODE) LIKE UPPER (?) AND DRUG.DRUG_CODE = PRESDRUG.DRUG_CODE AND PRES.REMARK_CODE = PRESDRUG.REMARK_CODE AND PRES.LANGUAGE_ID = DRUG.LANGUAGE_ID AND DRUG.FORM_CODE = FORMS.FORM_CODE AND PRES.ROUTE_CODE = ROUTE.ROUTE_CODE AND PRES.LANGUAGE_ID = ? AND FORMS.LANGUAGE_ID = ? AND ROUTE.LANGUAGE_ID = ?  ";

			//sqlMap.put("sqlData", PhRepository.getPhKeyValue("SQL_PH_PRES_REMARK_FOR_DRUG_QUERY_RESULT"));
			sqlMap.put("sqlData",sql);
			
			displayFields.add("DRUG_CODE");
			displayFields.add("DRUG_DESC");
			displayFields.add("FORM_DESC");
			displayFields.add("REMARK_DESC");
			displayFields.add("ROUTE_DESC");
			displayFields.add("DEFAULT_REMARK_YN");
			displayFields.add("EFF_STATUS");
			displayFields.add("ROUTE_CODE");
			displayFields.add("FORM_CODE");
			displayFields.add("ROUTE_COLOR");
			
			chkFields.add(remarks_desc);
			chkFields.add(drug_code );
			chkFields.add(drug_desc);	
			chkFields.add(form_desc );
			chkFields.add(locale);	
			chkFields.add(locale);	
			chkFields.add(locale);	
			
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
				<table border="1" cellpadding="0" cellspacing="0" width="99%"align=center>
					<tr>
						<th><fmt:message key="Common.DrugCode.label" bundle="${common_labels}" />
						<th><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}" /></th>
						<th><fmt:message key="ePH.Form.label" bundle="${ph_labels}" /></th>
						<th><fmt:message key="ePH.RemarkDescription.label" bundle="${ph_labels}" /></th>
						<th><fmt:message key="Common.Route.label" bundle="${common_labels}" /></th>
						<th><fmt:message key="ePH.DefaultRemark.label" bundle="${ph_labels}" /></th>
						<th><fmt:message key="Common.enabled.label" bundle="${common_labels}" /></th>
					</tr>
<%
					ArrayList records=new ArrayList();
					String route_color="", fntColor="", backgrndColor="", link_columns="", eff_status="", route_code="", form_code=""; // added for CRF RUT-CRF-0034.1[IN:037389]
			
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYEVEN" ;
							
						else
							classvalue = "QRYODD" ;
						link_columns = "1";
						records=(ArrayList) result.get( recCount );
						eff_status=((String)records.get( 6 ));				
						route_code = ((String)records.get( 7 ));					
						form_code=((String)records.get( 8 ));
						// added for CRF RUT-CRF-0034.1[IN:037389]-start
						route_color=((String)records.get( 9 ));
						if(route_color!= null && !route_color.equals("")){
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}
						else{
							fntColor= "";
							backgrndColor= "";
						}// added for CRF RUT-CRF-0034.1[IN:037389]-end
%>
						<tr	onClick="Modify(this,'<%=eff_status%>','<%=route_code%>','<%=form_code%>','<%=route_color%>');">
<%
						for(int colCount=0; colCount<records.size(); colCount++){
							if(colCount>6)
								continue;
							if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>
								<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font	class='HYPERLINK'> <%=(String)records.get( colCount )%> </font></td>
<%
							}
							else{
%>
								<td class="<%=classvalue%>" onclick="disableClick(event);" 
<% 
								if(colCount == 6) {
										
									if( ((String)records.get( colCount )).equals("E"))
										out.println("align='center' ><img src='../../eCommon/images/enabled.gif'></img>");
									else
										out.println("align='center' ><img src='../../eCommon/images/disabled.gif'></img>");
								}
								else if(colCount == 5){
									if( ((String)records.get( colCount )).equals("Y"))
										out.println("align='center' ><img src='../../eCommon/images/enabled.gif'></img>");
									else
										out.println("align='center' ><img src='../../eCommon/images/disabled.gif'></img>");
								}
								else if(colCount == 4){// added for CRF RUT-CRF-0034.1[IN:037389]-start
%>
									<td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>'  value="<%=(String)records.get( colCount )%>"
<%	
									out.println(">"+CommonBean.checkForNull((String)records.get( colCount )));
								}// added for CRF RUT-CRF-0034.1[IN:037389]-end
								else{
									out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp"));
								}
%>
								</td>
<%
							}
						}
%>
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
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PresRemarkForDrugQueryResult.jsp", searched) );
	} 
	catch(Exception e) {
		e.printStackTrace();
	}
%>
	</body>
</html>

