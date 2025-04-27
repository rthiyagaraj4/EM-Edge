<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %><%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugDetailsDisplay.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../js/DiscontinueDrug.js"></SCRIPT>
	    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
//Search Criteria's from Query Criteria page
/////////////////////////////////////////////////////////////////
		String drug_code			= "" ;
		//String ord[]				= request.getParameterValues("orderbycolumns");
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

		String classvalue			= "";
		String bean_id				= "DrugDetailsBean" ;
		String bean_name			= "ePH.DrugDetailsBean";
		String imageURL ="";
		String trade_code="";

		String img_bean_id = "DrugTradeImageBean" ;
		String img_bean_name = "ePH.DrugTradeImageBean";
		DrugTradeImageBean img_bean = (DrugTradeImageBean)getBeanObject( img_bean_id, img_bean_name, request ) ;

		DrugDetailsBean bean = (DrugDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		try{
			drug_code = CommonBean.checkForNull( bean.getDRUG_CODE() );

			//Common parameters.
			HashMap sqlMap = new HashMap();

			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_DETAILS_SELECT3"));
			//SELECT A.TRADE_ID,A.SHORT_DESC,A.MANUFACTURER_ID,C.SHORT_NAME FROM AM_TRADE_NAME A, PH_TRADE_NAME_FOR_DRUG B , AM_MANUFACTURER C WHERE A.TRADE_ID=B.TRADE_CODE AND A.MANUFACTURER_ID=C.MANUFACTURER_ID(+)

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add( "LONG_DESC" );
			displayFields.add( "TRADE_CODE");
			displayFields.add( "LONG_NAME");
			displayFields.add( "DISPLAY_SEQ_NO");

			//The fields are going to be in where condition * should match with the query
			ArrayList chkFields = new ArrayList();
			chkFields.add( drug_code.trim()+"" );
			chkFields.add(locale);
			chkFields.add(locale);

			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			//out.println("drug code="+drug_code);

			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<form name="queryResultForm" id="queryResultForm">
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
		// For display the previous/next link
								out.println(result.get(1));
%>
							</td>
						</tr>
					</table>

					<table  border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
						<tr>
							<th width="40%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></th>
							<th width="5"><fmt:message key="Common.Image.label" bundle="${common_labels}"/></th>
							<th width="40%"><fmt:message key="Common.ManufacturerName.label" bundle="${common_labels}"/></th>
							<th width="20%"><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></th>
						</tr>
<%
		//Retriving the records from result arraylist
						ArrayList records=new ArrayList();
						for(int recCount=2; recCount<result.size(); recCount++) {
							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
%>
							<tr onClick="Modify(this);" >
<%
							String link_columns = "";

							records=(ArrayList) result.get( recCount );
							for(int colCount=0; colCount<records.size(); colCount++){
								if(colCount==1){
									trade_code=(String)records.get( colCount );
									imageURL=img_bean.getImagePath(drug_code,trade_code);
								}
								if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>
									<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%></font></td>
<%
								}
								else{
%>
									<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
<%
									String dkVal = (String)records.get( colCount );
									if(dkVal == null)
										dkVal = "&nbsp" ;
									if(dkVal.equals(""))
										dkVal = "&nbsp;";
									if((colCount==3)){
										out.println("align=\"right\">");
										out.println(dkVal);
										out.println("</td>");
									}//if
									else{
										if(colCount==1){
											out.println("align='center'>&nbsp;");
											if(!imageURL.equals("")){
	%>
												<img src='../../ePH/images/camera.gif' width='17' height='15' onclick = "showImage('<%=drug_code%>','<%=trade_code%>');" onmouseover="changeCursor(this);">
	<%
											}
											out.println("</td>");
										}
										else{
											out.println("align='left'>");
											out.println(dkVal);
											out.println("</td>");
										}
									}
									dkVal = "";
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
%>
			</form>
<%
	//it is important to close the form above cause we are opening another form here
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugDetailsTradeNames.jsp", searched) );
		}
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

