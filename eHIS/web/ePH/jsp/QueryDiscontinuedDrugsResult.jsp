<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>      
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
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
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page
		String drug_code		= request.getParameter( "drug_code" );
		String drug_name		= request.getParameter( "drug_name" );
		String drug_class		= request.getParameter( "drug_class" ) ;
		String dt_from     		= request.getParameter( "dt_from" ) ;
		String dt_to     		= request.getParameter( "dt_to" ) ;

		String ord[]			= request.getParameterValues("orderbycolumns");
		boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			=	"";
			String details				=	"";
			String strength				=	"";
			// added for CRF RUT-CRF-0034.1[IN:037389]-start
			String route            =   "";
			String route_color      = "";
			String fntColor="";
			String backgrndColor="";
			// added for CRF RUT-CRF-0034.1[IN:037389]-end
			drug_code	= CommonBean.checkForNull( drug_code.trim() );
			drug_name	= CommonBean.checkForNull( drug_name.trim() );
			drug_class	= CommonBean.checkForNull( drug_class.trim() );
			dt_from		= CommonBean.checkForNull( dt_from.trim() );
			dt_to		= CommonBean.checkForNull( dt_to.trim() );
			//Common parameters.
			HashMap sqlMap = new HashMap();
			//include all the common parameters.
			//sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_DRUG_QUERY_SELECT2"));

			sqlMap.put( "sqlData","SELECT A.DRUG_CODE DRUG_CODE, A.DRUG_DESC DRUG_DESC, C.GENERIC_NAME GENERIC_NAME, A.STRENGTH_VALUE STRENGTH_VALUE,G.SHORT_DESC STRENGTH_UOM_DESC, D.FORM_DESC FORM_DESC, E.ROUTE_DESC ROUTE_DESC,E.ROUTE_COLOR, TO_CHAR (A.DISCONTINUED_DATE, 'DD/MM/YYYY HH24:MI') DISCONTINUED_DATE, A.DISCONTINUED_REASON DISCONTINUED_REASON, A.DISCONTINUED_BY_ID DISCONTINUED_BY_ID FROM PH_DRUG_LANG_VW A, PH_GENERIC_NAME_LANG_VW C, AM_UOM_LANG_VW G, PH_FORM_LANG_VW D, PH_ROUTE_LANG_VW E WHERE A.GENERIC_ID = C.GENERIC_ID AND A.STRENGTH_UOM = G.UOM_CODE(+) AND A.FORM_CODE = D.FORM_CODE AND A.ROUTE_CODE = E.ROUTE_CODE AND A.DRUG_CODE LIKE UPPER (?) AND UPPER(A.DRUG_DESC) LIKE UPPER (?) AND A.DRUG_CLASS LIKE (?) AND DISCONTINUED_YN = 'Y' AND DISCONTINUED_DATE BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, '31/12/5000'), 'DD/MM/YYYY') + 0.99999  AND A.LANGUAGE_ID = C.LANGUAGE_ID AND A.LANGUAGE_ID = D.LANGUAGE_ID AND A.LANGUAGE_ID = E.LANGUAGE_ID  AND A.LANGUAGE_ID = G.LANGUAGE_ID(+) AND A.LANGUAGE_ID = ? ORDER BY DRUG_DESC");

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add("drug_code");
			displayFields.add("drug_desc");
			displayFields.add( "generic_name" );
			displayFields.add( "strength_value" );
			displayFields.add( "strength_uom_desc" );
			displayFields.add( "form_desc" );
			displayFields.add( "route_desc" );
			displayFields.add( "route_color" );// added for CRF RUT-CRF-0034.1[IN:037389]
			displayFields.add( "discontinued_date" );
			displayFields.add( "discontinued_reason" );
			displayFields.add( "discontinued_by_id" );

			ArrayList chkFields = new ArrayList();
			chkFields.add( drug_code.trim() + "%");
			chkFields.add( drug_name.trim() + "%");
		//	chkFields.add("%");
			chkFields.add( drug_class.trim() + "%");
			chkFields.add( dt_from.trim() + "");
			chkFields.add( dt_to.trim() + "");
			chkFields.add(locale);

			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );

			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<table cellpadding=0 cellspacing=0 width="99%" align="center">
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
				<table border="1" cellpadding="0" cellspacing="0" width="99%" align="center">
					<th width="2%">&nbsp;</th>
					<th width="30%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
					<th width="20%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
					<th width="14%"><fmt:message key="ePH.Strength/Unit.label" bundle="${ph_labels}"/></th>
					<th width="10%"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></th>
					<th width="10%"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></th>
					<th width="10%"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></th>
<%
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String dkVal = "";
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODDSMALL" ;
						else
							classvalue = "QRYEVENSMALL" ;
%>
						<tr>
<%
							records=(ArrayList) result.get( recCount );
							for(int colCount=0; colCount<records.size(); colCount++){
								if(colCount==0)	{
%>
									<td class="<%=classvalue%>"><a href="javascript:parent.callDrugDetails('<%=(String)records.get( colCount )%>')">+</a></td>
<%
								} 
								else	if (colCount==8 || colCount==9 || colCount==10) {
									if(colCount!=10)	{
										details +=(String)records.get( colCount )+",";
										continue;
									}
									else	{
										details +=(String)records.get(colCount);
									}
%>
									<td class="<%=classvalue%>"><a href="javascript:parent.showDiscontinuedDetails('<%=details%>')"><fmt:message key="Common.details.label" bundle="${common_labels}"/></a></td>
<%				
									details	 =	"";
								}	
								else if(colCount==3 || colCount==4)	{
									if(colCount!=4)	{
										strength	+=CommonBean.checkForNull( (String)records.get( colCount ))+"/";
										continue;
									}	
									else	{
										strength	+=CommonBean.checkForNull( (String)records.get( colCount ));
									}
%>
									<td class="<%=classvalue%>"><%=strength%></td>
<%
									strength	=	"";
								}
								else if(colCount==6 || colCount==7 )	{// added for CRF RUT-CRF-0034.1[IN:037389]-start
									if(colCount==6)	{
										route	+=CommonBean.checkForNull( (String)records.get( colCount ));
										continue;
									}
									if(colCount==7){
										route_color	+=CommonBean.checkForNull( (String)records.get( colCount ));
										if(route_color!= null && !route_color.equals("")){
											if(route_color.length()==12){
												fntColor= route_color.substring(0, 6);
												backgrndColor= route_color.substring(6, 12);
											}
										}
										else{
											fntColor= "";
											backgrndColor= "";
										}
									}
%>
									<td class="<%=classvalue%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>'><%=route%></td>
<%
									route	=	"";
									route_color="";// added for CRF RUT-CRF-0034.1[IN:037389]-end
								}	
								else{
%>
									<td class="<%=classvalue%>" value="<%=(String)records.get( colCount )%>" wrap
<%
								dkVal = (String)records.get( colCount );
								if(dkVal == null || dkVal.equals(""))	
									dkVal = "&nbsp" ;
									out.println("align=\"left\">");
									out.println(dkVal);
									out.println("</td>");
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
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				//history.go(-1);
				</script>
<%
			}
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryDiscontinuedDrugsResult.jsp", searched) );
		}
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
		}
%>
	</body>
</html>

