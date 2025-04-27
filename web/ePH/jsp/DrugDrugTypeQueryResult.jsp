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
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugDrugType.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		//Search Criteria's from Query Criteria page
		String drug_code		= request.getParameter( "drug_code" )==null?"": request.getParameter( "drug_code" );
		String drug_type_code		= request.getParameter( "drug_type_code" )==null?"":request.getParameter( "drug_type_code" ) ;

		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			= "";
			//String sql= "SELECT a.drug_type, b.drug_type_desc, a.drug_code, c.drug_desc FROM ph_drug_drug_type a, ph_drug_type b, ph_drug c WHERE a.drug_type = b. drug_type AND a.drug_code = c.drug_code AND Upper(a.drug_type) LIKE (?) AND Upper(a.drug_code) LIKE (?)";
			String drug_desc="";
			String drug_type_desc="";
			HashMap sqlMap = new HashMap();
			sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_DRUG_BY_DRUG_TYPE_SELECT2"));
			//sqlMap.put( "sqlData",sql);

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields that are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "drug_desc");
			displayFields.add( "drug_type_desc" );

			ArrayList chkFields = new ArrayList();
			
			chkFields.add( drug_type_code.trim() + "%" );
			chkFields.add( drug_code.trim() + "%" );
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
						<th rowspan='2'><fmt:message key="ePH.DrugType.label" bundle="${ph_labels}"/></th>
						<th rowspan='2'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
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
							drug_type_desc =(String) records.get(colCount++);
							drug_desc =(String)records.get(colCount++);
							//colCount++;
						}		
						if(drug_type_desc == null || drug_type_desc.equals(""))
							drug_type_desc="&nbsp";
						if(drug_desc == null || drug_desc.equals(""))
							drug_desc="&nbsp";
%>
					<td class='<%=classvalue%>'>&nbsp;<%=drug_desc%>
					</td>
					<td class='<%=classvalue%>'>&nbsp;<%=drug_type_desc%>
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
				document.location.href="../../ePH/jsp/DrugDrugTypeQueryCriteria.jsp?function_id="+function_id ;
			</script>
<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugDrugTypeQueryResult.jsp", searched) );
	} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
	</body>
</html>

