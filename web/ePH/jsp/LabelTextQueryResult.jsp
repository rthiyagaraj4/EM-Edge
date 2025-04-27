<!DOCTYPE html>
<!--	This sample function explains how to develop the Query Result Page for Type 2.-->
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/LabelText.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		//Search Criteria's from Query Criteria page
		String label_text_id			= request.getParameter( "label_text_id" ) ;
		String label_text_type			= request.getParameter( "label_text_type" ) ;
		String label_text_1     		= request.getParameter( "label_text_1" ) ;

		String eff_status     			= request.getParameter( "eff_status" ) ;
		String ord[]				= request.getParameterValues("orderbycolumns");
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			= "";
			label_text_id			= CommonBean.checkForNull( label_text_id );
			label_text_type			= CommonBean.checkForNull( label_text_type );
			label_text_type			= (label_text_type.equals("B") ? (""):(label_text_type )   )  ;
			label_text_1			= CommonBean.checkForNull( label_text_1 );
			eff_status				= CommonBean.checkForNull( eff_status );
			eff_status = (eff_status.equals("B") ? (""):(eff_status )   )  ;

			String mode	= request.getParameter( "mode" ) ;
			String bean_id = "LabelTextBean" ;
			String bean_name = "ePH.LabelTextBean";
			/* Initialize Function specific start */
			LabelTextBean bean = (LabelTextBean)getBeanObject( bean_id,  bean_name, request ) ;
			bean.clear() ;
			bean.setMode( mode ) ;
			bean.fetchCautionTextMax();//added for for MMS-QH-CRF-0200 [IN:052044]
			String caution_text_max_200=bean.getCautionTextMax();//added for MMS-QH-CRF-0200 [IN:052044]
			String strLocLblTextDisp = "none";

			//function call to get the param from ph_param to dislay in local language
			bean.YNforLocLang();
			String PARAM_YN=(String)bean.getPARAM_YN();
			//Common parameters.
			HashMap sqlMap = new HashMap();
			//include all the common parameters.
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_LABEL_TEXT_SELECT1"));

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add( "LABEL_TEXT_ID" );
			displayFields.add( "LABEL_TEXT_TYPE" );
			displayFields.add( "LABEL_TEXT_1" );
			//displayFields.add( "LABEL_TEXT_2" );
			displayFields.add( "LABEL_TEXT_1_LOC_LANG" );
			//displayFields.add( "LABEL_TEXT_2_LOC_LANG" );
			displayFields.add( "EFF_STATUS" );
			if(PARAM_YN.equals("Y") || caution_text_max_200.equals("Y"))//added for MMS-QH-CRF-0200 [IN:052044]
				strLocLblTextDisp = "inline";

			//The fields are going to be in where condition * should match with the query
			ArrayList chkFields = new ArrayList();

			chkFields.add( label_text_id.trim() + "%" );
			chkFields.add( label_text_type.trim() + "%" );
			chkFields.add( label_text_type.trim() + "%" );
			chkFields.add( label_text_1.trim() + "%" );
			chkFields.add( "%" );
			chkFields.add( eff_status.trim() + "%" );
			if(PARAM_YN.equals("Y") || caution_text_max_200.equals("Y"))//added for MMS-QH-CRF-0200 [IN:052044]
				chkFields.add("en");
			else
				chkFields.add(locale);
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<form name="queryResultForm" id="queryResultForm">
					<table cellpadding=0 cellspacing=0 width="100%" align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
								out.println(result.get(1));// For display the previous/next link
%>
							</td>
						</tr>
					</table>
					<table  border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
						<tr>
						<th width='5%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
						<th width='10%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
						<th width='*'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
						<th width='40%' style='display:<%=strLocLblTextDisp%>;'><fmt:message key="ePH.DescriptioninLocalLanguage.label" bundle="${ph_labels}"/></th>
						<th width='5%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					</tr>
<%
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String link_columns = "1", dkVal="";
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
%>
						<tr onClick="Modify(this);" >
<%
						link_columns = "1";
						records=(ArrayList) result.get( recCount );
						for(int colCount=0; colCount<records.size(); colCount++){
							if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>
								<td class="<%=classvalue%>" onmouseover="changeCursor(this);" nowrap style='text-align:center;'><font class='HYPERLINK'>  <%=(String)records.get( colCount )%> </font></td>
<%
							}
							else{
								dkVal = (String)records.get( colCount );
								if(dkVal == null)	dkVal = "&nbsp" ;
								if(dkVal.equals("")) dkVal = "&nbsp;";
								if(colCount==1){
%>
									<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+(String)records.get( colCount)+".label","ph_labels")%> </td>
<%
								}
								else if(colCount==6){
%>
									<td class="<%=classvalue%>" onclick="disableClick(event);" align="center"><%=dkVal%><%=getImage(dkVal)%>
									</td>
<%
								}
								else if(colCount==5 || colCount==4){//removed colCount==3 for MMS-QH-CRF-0200 [IN:052044]
%>
									<td class="<%=classvalue%>" style='text-align:center' onclick="disableClick(event);" align="center">
									<%=getImage(dkVal)%></td>
<%
								}
								else if(colCount==3){//added for for MMS-QH-CRF-0200 [IN:052044]
%>
									<td wrap style='display:<%=strLocLblTextDisp%>;' class="<%=classvalue%>" onclick="disableClick(event);" align="left" ><%=dkVal%></td>
<%
								}
								else{
%>
									<td wrap class="<%=classvalue%>" onclick="disableClick(event);" align="left" ><%=dkVal%></td>
<%
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
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/LabelTextQueryResult.jsp", searched) );
			putObjectInBean(bean_id,bean,request);

		} catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
<%!
		public String getImage(String value){
			if(value.equalsIgnoreCase("E"))
				return "<img src=\"../../eCommon/images/enabled.gif\"><input type='hidden' value='E'>";
			else 
				return "<img src=\"../../eCommon/images/disabled.gif\"><input type='hidden' value='D'>";
		}
%>
	</body>
</html>

