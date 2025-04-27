<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
    <head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/RouteForForm.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page
		String form_code    = request.getParameter( "form_code" ) ;
		String route_code   = request.getParameter( "route_code" ) ;
		String form_desc    = request.getParameter( "form_desc" ) ;
		String route_desc   = request.getParameter( "route_desc" ) ;
		String action_text_label= request.getParameter( "action_text_label" ) ;
		String action_text_label_loc_lang= request.getParameter( "action_text_label_loc_lang" ) ;
		String ord[]                = request.getParameterValues("orderbycolumns");
		boolean searched            = request.getParameter( "searched" ) == null ? false : true  ;
		String bean_id = "RouteForFormBean" ;
		String bean_name = "ePH.RouteForFormBean";
		RouteForFormBean bean = (RouteForFormBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		bean.YNforLocLang();
		String PARAM_YN=(String)bean.getPARAM_YN();
		try{
			String classvalue           = "";
			form_code = CommonBean.checkForNull( form_code );
			route_code = CommonBean.checkForNull( route_code );
			form_desc = CommonBean.checkForNull( form_desc );
			route_desc = CommonBean.checkForNull( route_desc );
			action_text_label = CommonBean.checkForNull( action_text_label );
			action_text_label_loc_lang = CommonBean.checkForNull( action_text_label_loc_lang );
			
			//Common parameters.
			HashMap sqlMap = new HashMap();
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_FOR_FORM_SELECT3"));

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "form_code" );
			displayFields.add( "form_desc" );
			displayFields.add( "route_code" );
			displayFields.add( "route_desc" );
			displayFields.add( "action_text_label" );
			if(PARAM_YN.equals("Y")){ 
				displayFields.add( "action_text_label_loc_lang" );
			}
			displayFields.add( "route_color" );
			//The fields are going to be in where condition * should match with the query
			ArrayList chkFields = new ArrayList();
				   
			chkFields.add( form_code.trim() + "%" );
			chkFields.add( route_code.trim() + "%" );
			chkFields.add( form_desc.trim() + "%" );
			chkFields.add( route_desc.trim() + "%" );
			chkFields.add( action_text_label.trim() + "%" );
			chkFields.add(locale);
			//chkFields.add( action_text_label_in_loc_lang );

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
							// For display the previous/next link
							 out.println(result.get(1));
%>
							</td>
						</tr>
					</table>
					<table  border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
					<th><fmt:message key="ePH.FormCode.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.FormDescription.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.RouteCode.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.RouteDescription.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.ActionTextLabelinEnglish.label" bundle="${ph_labels}"/></th>
<%
					if(PARAM_YN.equals("Y")){ 
%>
						<th><fmt:message key="ePH.ActionTextLabelInLocalLanguage.label" bundle="${ph_labels}"/></th>
<%
					}
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String route_color="",fntColor="",  backgrndColor=""; // added for CRF RUT-CRF-0034.1[IN:037389]
					for(int recCount=2; recCount<result.size(); recCount++) {
						String link_columns = "1";
						records=(ArrayList) result.get( recCount );
						route_color=((String)records.get(5));// added for CRF RUT-CRF-0034.1[IN:037389]
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
%>
			            <tr onClick="Modify(this,'<%=route_color%>');" >
<%
							fntColor="";	// added for CRF RUT-CRF-0034.1[IN:037389]-start
							backgrndColor="";
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								}
							}
							else{
								fntColor= "";
								backgrndColor= "";
							}	// added for CRF RUT-CRF-0034.1[IN:037389]-end
							for(int colCount=0; colCount<records.size()-1; colCount++){
								if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
%>
									<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
<%
								}
								else{
									String dkVal = (String)records.get( colCount );
									if(dkVal == null)   
										dkVal = "&nbsp" ;
									if(dkVal.equals("")) 
										dkVal = "&nbsp;";
									
									if((colCount==10)){
%>
										<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
<%
										out.println("align=\"center\">");  
										out.println(getImage(dkVal)); 
										out.println("</td>"); 
									}//if
									else if((colCount==5)){
%>
										<td class="<%=classvalue%>" style='text-align:right' onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>" 
<%
										out.println("align=\"right\" >");
										out.println(dkVal);
										out.println("</td>");
									}
									else if(colCount==3 ){// added for CRF RUT-CRF-0034.1[IN:037389]-start
%>
										<td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>' value="<%=(String)records.get( colCount )%>" 
<%
										out.println("align=\"right\" >");
										out.println(dkVal);
										out.println("</td>");
									}// added for CRF RUT-CRF-0034.1[IN:037389]-end
									else{
%>
										<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
<%
										out.println("align=\"left\">");     
										out.println(dkVal);
										out.println("</td>"); 
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
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/RouteForFormQueryResult.jsp", searched) );
		} 
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
<%!
		public String getImage(String value){
			if(value.equalsIgnoreCase("E"))
				return "<img src=\"../../eCommon/images/enabled.gif\">";
			else 
				return "<img src=\"../../eCommon/images/disabled.gif\">";
		}
%>
	</body>
	<% putObjectInBean(bean_id,bean,request); %>
</html>

