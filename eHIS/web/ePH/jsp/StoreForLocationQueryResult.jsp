<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/StoreForLocation.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page

		String dispense_location		= request.getParameter( "dispense_location_code" )==null?"": request.getParameter( "dispense_location_code" );
		String location_code		= request.getParameter( "location_code" )==null?"":request.getParameter( "location_code" ) ;
		String location_type		= request.getParameter( "location_type" )==null?"":request.getParameter( "location_type" ) ;
		String facility_id=(String) session.getValue( "facility_id" );
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

		try{
			String classvalue			= "";
			String sql= "";	String disp_locn_desc="";
			String store_desc="";
			String locn_type="";
			String locn_desc="";
			HashMap sqlMap = new HashMap();
			if(location_type.equals("N")){
			sql="SELECT B.DISP_LOCN_CODE, B.SHORT_DESC DISP_LOCN_DESC, X.STORE_CODE, A.SHORT_DESC STORE_DESC, X.LOCN_TYPE, X.LOCN_CODE,C.SHORT_DESC LOCN_DESC FROM PH_LOCN_FOR_STORE X, MM_STORE_LANG_VW A, PH_DISP_LOCN_LANG_VW B, IP_NURSING_UNIT_LANG_VW C WHERE X.STORE_CODE = B.STORE_CODE AND X.FACILITY_ID = B.FACILITY_ID AND A.STORE_CODE = B.STORE_CODE AND C.FACILITY_ID = B.FACILITY_ID AND C.NURSING_UNIT_CODE = X.LOCN_CODE  AND  UPPER(B.DISP_LOCN_CODE) LIKE UPPER(?) AND UPPER(X.LOCN_CODE) LIKE UPPER(?) AND B.FACILITY_ID = ? AND  X.LOCN_TYPE = ? AND  B.LANGUAGE_ID = ?   AND A.LANGUAGE_ID = ? AND C.LANGUAGE_ID =? ";
			}else{
		sql="SELECT B.DISP_LOCN_CODE, B.SHORT_DESC DISP_LOCN_DESC, X.STORE_CODE, A.SHORT_DESC STORE_DESC, X.LOCN_TYPE, X.LOCN_CODE,C.SHORT_DESC LOCN_DESC FROM PH_LOCN_FOR_STORE X, MM_STORE_LANG_VW A, PH_DISP_LOCN_LANG_VW B, OP_CLINIC_LANG_VW C WHERE   X.STORE_CODE = B.STORE_CODE AND X.FACILITY_ID = B.FACILITY_ID AND  A.STORE_CODE = B.STORE_CODE  AND C.FACILITY_ID = B.FACILITY_ID  AND C.CLINIC_CODE = X.LOCN_CODE AND UPPER(B.DISP_LOCN_CODE) LIKE UPPER(?) AND UPPER(X.LOCN_CODE) LIKE UPPER(?)  AND B.FACILITY_ID = ? AND X.LOCN_TYPE = ? AND B.LANGUAGE_ID = ? AND A.LANGUAGE_ID = ? AND C.LANGUAGE_ID = ?";
		
			}
				sqlMap.put( "sqlData",sql);

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields that are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add("disp_locn_desc");
			displayFields.add("store_desc");
			displayFields.add("Locn_type");
			displayFields.add("locn_desc");

    //The fields are going to be in where condition * should match with the query
			ArrayList chkFields = new ArrayList();
			
			chkFields.add(dispense_location.trim()+ "%" );
			chkFields.add(location_code.trim() + "%" );
			chkFields.add(facility_id);
			chkFields.add(location_type.trim() );
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
		
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
					//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);


			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
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
				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
					<tr >
						<th rowspan='2'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
						<th rowspan='2'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
							<th rowspan='2'>   <fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
				
					<th rowspan='2'> <fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				
					</tr>
					<tr>
<%
						//Retriving the records from result arraylist
						ArrayList records=new ArrayList();
						for(int recCount=2; recCount<result.size(); recCount++) {

							if ( recCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
%>
						<tr>
<%
						records=(ArrayList) result.get( recCount );
						for(int colCount=0; colCount<records.size(); colCount++){
							disp_locn_desc =(String) records.get(colCount++);
							store_desc =(String)records.get(colCount++);
							locn_type =(String) records.get(colCount++);
						//	if(locn_type.equals("N"))
									
							locn_desc =(String)records.get(colCount++);
							
							//colCount++;
						}		
						if(disp_locn_desc == null || disp_locn_desc.equals(""))
							disp_locn_desc="&nbsp";
						if(store_desc == null || store_desc.equals(""))
							store_desc="&nbsp";
						if(locn_type == null || locn_type.equals(""))
							locn_type="&nbsp";
						if(locn_desc == null || locn_desc.equals(""))
							locn_desc="&nbsp";
%>
					<td class='<%=classvalue%>'>&nbsp;<%=disp_locn_desc%>
					</td>
					<td class='<%=classvalue%>'>&nbsp;<%=store_desc%>
					</td>
					<%if (locn_type.equals("N")){%>
					<td class='<%=classvalue%>'>&nbsp;<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
					</td>
					<%}else{%>
	<td class='<%=classvalue%>'>&nbsp;<fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
		<%}%>			
					<td class='<%=classvalue%>'>&nbsp;<%=locn_desc%>
					</td>

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
				document.location.href="../../ePH/jsp/StoreForLocationQueryCriteria.jsp?function_id="+function_id ;
			</script>
<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/StoreForLocationQueryResult.jsp", searched) );
	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	
	}
%>
	</body>
</html>

