<!DOCTYPE html>

<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean,java.sql.ResultSetMetaData,webbeans.eCommon.ConnectionManager,java.util.StringTokenizer,eOT.*" %>
<%@ page contentType=" text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8"); 
   /* //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends  */
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	//Added against ML-MMOH-CRF-1939-US2...starts
	System.err.println("Search Page ");
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	boolean isIncludeFpp = false;
	String title = CommonBean.checkForNull(request.getParameter("title"));
	String episode_id = CommonBean.checkForNull(request.getParameter("episode_id"));
	String patient_class = CommonBean.checkForNull(request.getParameter("patient_class"));
	String encounter_id = CommonBean.checkForNull(request.getParameter("encounter_id"));
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	if(!title.equals("Surgery Type") && called_from.equals("Record_Surgeon")){
	Connection conn2 = null;
	PreparedStatement pstmt2 =null;
	ResultSet rs2 = null;


try{
	conn2 = ConnectionManager.getConnection(request);
	String sql2="SELECT PATIENT_CLASS,ENCOUNTER_ID FROM PR_ENCOUNTER WHERE EPISODE_ID ="+episode_id;
	pstmt2 = conn2.prepareStatement(sql2);
	rs2 = pstmt2.executeQuery();
	while(rs2.next()){
		patient_class = CommonBean.checkForNull(rs2.getString("PATIENT_CLASS"));
		encounter_id = CommonBean.checkForNull(rs2.getString("ENCOUNTER_ID"));
	}	
	if(pstmt2!=null)
		pstmt2.close();
}catch(Exception ex){
	System.err.println(ex);		
}finally{		
	if(pstmt2!=null)
			pstmt2.close();
	ConnectionManager.returnConnection(conn2, request);
}
	}
	//Added against ML-MMOH-CRF-1939-US2...ends
	String column_names = "";
	String search_criteria = "";
	String facility_id		= (String)session.getValue("facility_id") ;
	String column_descriptions = request.getParameter("column_descriptions");
	//String desc = request.getParameter("desc");
	//column_descriptions = java.net.URLDecoder.decode(column_descriptions,"UTF-8");
	String column_sizes = request.getParameter("column_sizes");
	String form_types = request.getParameter("form_types");
	 search_criteria = CommonBean.checkForNull(request.getParameter("search_criteria"));

	 if(search_criteria.equals("*All")) search_criteria="%";
	 if(search_criteria.equals("~")) search_criteria="&";
	String column_types = "";
	String search_by_index = "";
	String Fpp_yn = "";
	String sql = request.getParameter( "sql");
//	sql = java.net.URLDecoder.decode(sql,"UTF-8");
	String strColumnDelimiter = ",";
	String message = request.getParameter("message");
	message = (message == null) ? " ":message;
%>
<html>
<head>
<title> <%= title %></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
if(sStyle.equals("IeStyle.css"))
 {
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>

	function closew(){
		parent.window.close();
	}
	function CallDescFrame(){
		var search_by_index = document.forms[0].search_by.selectedIndex;
		document.forms[0].search_by_index.value = search_by_index;
		//Added Against ML-MMOH-CRF-1939-US2...starts
		fpp_yn = changeFpp(); 
		document.forms[0].Fpp_yn.value = fpp_yn;
		//Added Against ML-MMOH-CRF-1939-US2...ends
		document.forms[0].submit();
	 }
	 function valtext(comp){
		 
		if(document.getElementById("textFieldDiv").style.display == 'inline')
		{
			document.forms[0].search_text.value =
				document.forms[0].searchText.value;
			
			document.forms[0].addOprn.value = 'N';
		}
		else
		{
			document.forms[0].search_text.value =
				document.forms[0].searchCombo.value;
			
			if(document.forms[0].description.value != '')
			{
				document.forms[0].addOprn.value = 'Y';
			}
			
		}
		CallDescFrame(this);
	}

	//Copied by rajesh on 18/10,
	function autopopulate()
	{
	var search_criteria1 = document.forms[0].searchText;
	if(search_criteria1.value!="")
		{
			valtext(search_criteria1)	
		}
	}
	var comboValues = new Array();
	var valueString = "";
	
	<!-- Added for CRF 012-->
	function showSearchField()
	{
		
		var searchColumnSelected = document.forms[0].search_by.value;
		
		var showCombo = (comboValues[searchColumnSelected] != undefined);
		if(showCombo == true)
		{
			document.getElementById("textFieldDiv").style.display='none';
			document.getElementById("comboFieldDiv").style.display='Inline';
			
			var searchCombo = document.forms[0].searchCombo;
			searchCombo.options.length = 0;
			
			
			var keyValuesArray = comboValues[searchColumnSelected].split(",");
			for(i=0; i< keyValuesArray.length; i++)
			{
				var keyValue = keyValuesArray[i].split("~");
				if(keyValue[0] != "")
				{
					searchCombo.options.add(new Option(keyValue[1], keyValue[0]));
				}
			}
			
		}
		else
		{
			document.getElementById("textFieldDiv").style.display='Inline';
			document.getElementById("comboFieldDiv").style.display='none';
		}
	}
	<!-- Added for CRF 012-->
</script>

<body onLoad = "autopopulate()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='frm_search_criteria' id='frm_search_criteria' ACTION='OTGeneralSearchResults.jsp' method='post' target='code_desc'>
<%
Connection conn = null;
PreparedStatement pstmt =null;
String Include_Fpp_yn = "";
ResultSet rs = null;
//Added Against ML-MMOH-CRF-1939-US2...starts
String FPPPatient_yn = "N";
String Episode_Type = ""; 
Integer count = 0;
boolean bill_flag = false;
String tab_name = "";
//Added Against ML-MMOH-CRF-1939-US2...ends

try{
	conn = ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(sql);
	
	//Added Against ML-MMOH-CRF-1939-US2...starts
	
	bill_flag = bean.getBillFlag(facility_id);
	Include_Fpp_yn = CommonBean.checkForNull(bean.getIncludeFpp(facility_id));
	tab_name = CommonBean.checkForNull(request.getParameter("tab_name"));
	isIncludeFpp = CommonBean.isSiteSpecific(conn,"OT","OT_FPP");
	System.err.println("isIncludeFpp --->"+isIncludeFpp);
   	count = bean.getFppIcon();
	
	
	Episode_Type = bean.getPatientEncounterDetails(conn,facility_id,encounter_id);
	if(!Episode_Type.equals(""))
	FPPPatient_yn = bean.getFPPDetails(conn,facility_id,Episode_Type,encounter_id);
	if(Include_Fpp_yn.equals("Y") && isIncludeFpp && bill_flag && count==1 && title.equals("Operation") && !tab_name.equals("UNSCHEDULED") && (called_from.equals("DIRECT_BOOKING") || called_from.equals("Record_Surgeon"))){
	
		if(FPPPatient_yn.equals("Y")) {
			pstmt.setString( 1 , "Y");	
		}else{
			pstmt.setString( 1 , "N");
		}
    }
	//Added Against ML-MMOH-CRF-1939-US2...ends
	
	pstmt.execute();
	ResultSetMetaData rmeta = pstmt.getMetaData();
	int intCount = rmeta.getColumnCount() ;
	String strTempColumnTypeName = "";
	for (int i=1;i<=intCount ;i++ ){
		column_names =  column_names + rmeta.getColumnName(i) + strColumnDelimiter;
		strTempColumnTypeName = rmeta.getColumnTypeName(i);
		if (strTempColumnTypeName.equalsIgnoreCase("VARCHAR2") || strTempColumnTypeName.equalsIgnoreCase("VARCHAR") || strTempColumnTypeName.equalsIgnoreCase("CHAR"))
		{
			strTempColumnTypeName = "VARCHAR2";
		}
		column_types = column_types + rmeta.getColumnTypeName(i) + strColumnDelimiter;	
	}	

	if(pstmt!=null)
		pstmt.close();
}catch(Exception ex){
	System.err.println(ex);		
}finally{		
	if(pstmt!=null)
			pstmt.close();
	ConnectionManager.returnConnection(conn, request);
}

%>
<script>
  //Added Against ML-MMOH-CRF-1939-US2...starts
 function changeFpp() {
	var ar = document.getElementsByName('fpp');
	var value = document.getElementsByName('fpp').value;  
    var fpp_yn;	
	for(i = 0; i < ar.length; i++) {
	    if(ar[i].checked){
		  value = ar[i].value
			if(value == 'fpp'){
			  document.getElementsByName("Fpp_yn").value = "Y";
			  fpp_yn = "Y";			  
			}else{
			  document.getElementsByName("Fpp_yn").value = "N";  
			  fpp_yn = "N";
			}
		}
    }
	return fpp_yn;
 }
//Added Against ML-MMOH-CRF-1939-US2...ends 
</script>
<table align='center'  border="0" width=100% cellspacing='0' cellpadding=3  align='center'>
<tr>
		
		<td class='label' width='25%'>
			<fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		</td>
		<td>
			<select name="search_by" id="search_by" onchange='showSearchField()'>
					<%
					boolean first =  true;
					String strTempSelected = "SELECTED";
					StringTokenizer strColumnTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
					StringTokenizer strColumnDescriptionsTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
					
					while(strColumnDescriptionsTokenizer.hasMoreElements())
					{
						
						String columnName = strColumnTokenizer.nextElement().toString();
						String columnDesc = strColumnDescriptionsTokenizer.nextElement().toString();
						
						
						if (first) 
						{
							strTempSelected = "SELECTED";
							first = false;
						}
						else
						{
							strTempSelected = " ";
						}
						//out.println(strColumnTokenizer.nextElement()+"::::"+strColumnDescriptionsTokenizer.nextElement());
						if(columnDesc != null && !columnDesc.equals(""))
						{
							out.println("<option value='" + columnName + "'  " + strTempSelected + "  >" + columnDesc + "</option>");
						}
						
						
						//check if its a combo
						String comboSql = request.getParameter(columnName + "_SQL" );
						if(comboSql != null && !columnDesc.equals(""))
						{
							HashMap<String,String> comboValues = getComboValues(comboSql);
							
							int index = 0; 
							if(comboValues != null && !comboValues.isEmpty())
							{
								
			
								for(String key : comboValues.keySet())
								{
			%>
							<script>
									valueString += "<%= key %>"  + "~" + "<%= comboValues.get(key) %>"  + ",";
							</script>
			<%				
								}
							} 
							
							%>
							<script>
										comboValues['<%= columnName %>'] = valueString;
										valueString = '';
							</script>			
							<%					
						}
					
					}
			%>
			
			
			</select>
	
		</td>
		<td class="label">
			<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
		</td>
		<td>	
			<select class="fields" name="search_criteria" id="search_criteria">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
		</td>
</tr>
<tr>
	<td class='label' width='25%' nowrap>
		<fmt:message key="Common.searchtext.label" bundle="${common_labels}" />
	</td>
	<td class='label' colspan='3'>	
		<div id='textFieldDiv' style='display:none'>
			<input type="text" class='fields' onBlur='makeValidString(this);'  name="searchText" id="searchText" value="<%=search_criteria%>" width='30%' align="left" size='40' maxlength='70'   >
		</div>
		<!-- Added for CRF 012-->
		<div id='comboFieldDiv' style='display:none'>
			<select name="searchCombo" id="searchCombo" value="" >
			</select>
			<fmt:message key="Common.description.label" bundle="${common_labels}" />
			<input type="text" class='fields' onBlur='makeValidString(this);'  name="description" id="description" value="" width='30%' align="left" size='40' maxlength='70'   >
		</div>	
		<!-- Added for CRF 012-->
	</td>
	
</tr>
<tr>
<!--Added against Ml-MMOH-CRF-1939-US2...starts-->
	<%
	if(Include_Fpp_yn.equals("Y") && isIncludeFpp && bill_flag && count==1 && title.equals("Operation")&& !tab_name.equals("UNSCHEDULED") && (called_from.equals("DIRECT_BOOKING") || called_from.equals("Record_Surgeon"))){
		if( episode_id != null && FPPPatient_yn.equals("Y")){			
	%>
		<td class="label">
		  <fmt:message key="Common.FPP.label" bundle="${common_labels}"/>
          <input type="radio" name="fpp" id="fpp" id="fpp" class="fields" value="fpp" checked >
		  <fmt:message key="eOT.NonFPP.Label" bundle="${ot_labels}"/>
	      <input type="radio" name="fpp" id="fpp" id="non_fpp" class="fields" value="non_fpp" >		
		</td>
	<%
		}else{
	%>
	<td class="label">
		<fmt:message key="Common.FPP.label" bundle="${common_labels}"/>
        <input type="radio" name="fpp" id="fpp" id="fpp" class="fields" value="fpp"   disabled >
		<fmt:message key="eOT.NonFPP.Label" bundle="${ot_labels}"/>
	    <input type="radio" name="fpp" id="fpp" id="non_fpp" class="fields" value="non_fpp" checked >		
   	</td>
	<%
		}
	}
	%>
	<!--Added against Ml-MMOH-CRF-1939-US2...ends-->	
	<td class="button" colspan='4' align='right'>
		<input type="button" class='button' width='20%' align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtext(search_text);" class='button' >
		<input type="button" class='button' width='20%' align="left" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="document.forms[0].searchText.value='';document.forms[0].search_text.value='';" class='button' >
	</td>
	</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->
<input type='hidden' name='column_names' id='column_names' value="<%=column_names%>">
<input type='hidden' name='column_descriptions' id='column_descriptions' value="<%=column_descriptions%>">
<input type='hidden' name='column_sizes' id='column_sizes' value="<%=column_sizes%>">
<input type='hidden' name='column_types' id='column_types' value="<%=column_types%>">
<input type='hidden' name='search_by_index' id='search_by_index' value="<%=search_by_index%>">
<input type='hidden' name='search_criteria' id='search_criteria' value="<%=search_criteria%>">
<input type='hidden' name='search_criteria_flag' id='search_criteria_flag' value="">
<input type='hidden' name='search_text' id='search_text' value="">
<input type='hidden' name='addOprn' id='addOprn' value="">
<input type='hidden' name='sql' id='sql' value="<%=sql%>">
<input type='hidden' name='search_criteria1' id='search_criteria1' value="<%=search_criteria%>">
<!--Added against ML-MMOH-CRF-1939-US2...starts-->
<input type='hidden' name='FPPPatient_yn' id='FPPPatient_yn' value="<%=FPPPatient_yn%>">
<input type='hidden' name='title2' id='title2' value="<%=title%>">
<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">
<input type='hidden' name='Fpp_yn' id='Fpp_yn' value="<%=Fpp_yn%>">
<input type="hidden" name="tab_name" id="tab_name" value="<%=tab_name%>">
<!--Added against ML-MMOH-CRF-1939-US2...ends-->
<BR>
<BR>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

<script>
showSearchField();
</script>
</form>
</body>
</html>

<%!


	public HashMap<String,String> getComboValues(String sql) throws Exception
	{
	
		HashMap<String,String> comboValue = new LinkedHashMap<String,String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				comboValue.put(rs.getString(1), rs.getString(2));
			}	

			if(pstmt!=null)
				pstmt.close();
		}catch(Exception ex){
			System.err.println(ex);		
		}finally{		
			if(pstmt!=null)
					pstmt.close();
			if(rs!=null)
				rs.close();
			ConnectionManager.returnConnection(conn);
		}
		return comboValue;
	
	}

%>


