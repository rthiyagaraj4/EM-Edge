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
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	    String locale			= (String)session.getAttribute("LOCALE");
	//  
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
		String item_search_code		= request.getParameter( "item_search_code" )==null?"":request.getParameter( "item_search_code" ) ;
		String item_type		= request.getParameter( "item_type" )==null?"":request.getParameter( "item_type" ) ;
	//	String facility_id=(String) session.getValue( "facility_id" );
		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
	
		try{
			String classvalue			= "";
			//String sql= "SELECT a.drug_type, b.drug_type_desc, a.drug_code, c.drug_desc FROM ph_drug_drug_type a, ph_drug_type b, ph_drug c WHERE a.drug_type = b. drug_type AND a.drug_code = c.drug_code AND Upper(a.drug_type) LIKE (?) AND Upper(a.drug_code) LIKE (?)";
			String disp_locn_desc="";
			String store_desc="";
			String item_type1="";
			String item_desc="";
			String sql="";
			HashMap sqlMap = new HashMap();
		//	if(item_type.equals("M")){
			sql=" SELECT a.short_desc disp_locn_desc, c.short_desc store_desc, b.item_type, d.short_desc item_desc FROM PH_DISP_LOCN_LANG_VW a, PH_LOCN_STORE_DISP_ITEM b, mm_store_lang_vw c, mm_item_lang_vw d WHERE a.store_code = b.store_code AND a.store_code = c.store_code AND b.item_code = d.item_code and UPPER(a.disp_locn_code) LIKE UPPER(?) AND UPPER(b.item_code) LIKE UPPER(?) AND b.item_type = ? AND a.language_id=? AND c.language_id=? AND d.language_id=? ";
	//		}else{
	//	sql=" SELECT a.short_desc disp_locn_desc, c.short_desc store_desc, b.item_type, d.short_desc //item_desc FROM PH_DISP_LOCN_LANG_VW a, PH_LOCN_STORE_DISP_ITEM b, mm_store_lang_vw c, //mm_item_lang_vw d WHERE a.store_code = b.store_code AND a.store_code = c.store_code AND b.item_code //= d.item_code and UPPER(a.disp_locn_code) LIKE UPPER(?) AND UPPER(b.item_code) LIKE UPPER(?) AND //b.item_type =? AND a.language_id=? AND c.language_id=? AND d.language_id=? ";
		
		//	}
				sqlMap.put( "sqlData",sql);

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields that are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "disp_locn_desc");
			displayFields.add( "store_desc" );
			displayFields.add( "item_type");
			displayFields.add( "item_desc" );


			ArrayList chkFields = new ArrayList();
			chkFields.add( dispense_location.trim() + "%" );
			chkFields.add( item_search_code.trim() + "%" );
			chkFields.add(item_type);
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
						<th rowspan='2'> <fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></th>
						<th rowspan='2'> <fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
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
							item_type1 =(String) records.get(colCount++);
							item_desc =(String)records.get(colCount++);
													
						}		
						if(disp_locn_desc == null || disp_locn_desc.equals(""))
							disp_locn_desc="&nbsp";
						if(store_desc == null || store_desc.equals(""))
							store_desc="&nbsp";
						if(item_type1 == null || item_type1.equals(""))
							item_type1="&nbsp";
						if(item_desc == null || item_desc.equals(""))
							item_desc="&nbsp";
%>
					<td class='<%=classvalue%>'>&nbsp;<%=disp_locn_desc%>
					</td>
					<td class='<%=classvalue%>'>&nbsp;<%=store_desc%>
					</td>
					<% if (item_type1.equals("D")){%>
					<td class='<%=classvalue%>'>&nbsp;<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>
					</td>
					<%}else{%>
	<td class='<%=classvalue%>'>&nbsp;<fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/>
					</td>
					<%}%>
					<td class='<%=classvalue%>'>&nbsp;<%=item_desc%>
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
				document.location.href="../../ePH/jsp/LocationStoreItemsQueryCriteria.jsp?function_id="+function_id ;
			</script>
<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/LocationStoreItemsQueryResult.jsp", searched) );
	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
	</body>
</html>

