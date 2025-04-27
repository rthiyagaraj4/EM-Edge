<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.net.*,java.text.*,java.io.*,ecis.utils.*,eCommon.Common.*,webbeans.eCommon.*,com.ehis.util.*,java.util.HashMap, java.util.ArrayList" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	
	String facility_id  = (String) session.getValue("facility_id");
	String sql="";
	String strCode="";
	String strDesc="";	
	String servingDate="";
	
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi') CURRENT_DATE FROM DUAL");
		rst = pstmt.executeQuery();
		while(rst.next()){
			servingDate = rst.getString("CURRENT_DATE");
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		System.err.println("====LabelStickerForFormulaQuery.jsp called====");
		System.err.println("localeName=="+locale);
		String SystemDate_display = DateUtils.convertDate(servingDate,"DMYHM" ,"en",localeName);
		String report_option="P";
		String report = "";
		String server = "";
		String copies		= "" ;
		String queue_name		= "" ;
		String message		= "" ;
		String app_server_ip	= "" ;
		String rep_server_key	= "" ;
		String report_ssl_yn	= (String) session.getValue( "report_ssl_yn" ) ;
		String ws_no		= (String) p.getProperty( "client_ip_address" )  ;
		String reportServer	= (String) session.getValue( "report_server" ) ;
		String userid="";
		String desname="";
	
	//	con = ConnectionManager.getConnection(request);
		CallableStatement cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" ) ;
		cs.setString( 1,	"DS" ) ;
		cs.setString( 2,	"DSLABSTIC1" ) ;
		cs.setString( 3,	"" ) ;
		cs.setString( 4,	"" ) ;
		cs.setString( 5,	facility_id ) ;
		cs.setString( 6,	ws_no ) ;
		cs.setString( 7,	report_option ) ;
		cs.registerOutParameter( 8,  Types.VARCHAR ) ;
		cs.registerOutParameter( 9,  Types.VARCHAR ) ;
		cs.registerOutParameter( 10, Types.VARCHAR ) ;
		cs.registerOutParameter( 11, Types.VARCHAR ) ;
		cs.registerOutParameter( 12, Types.VARCHAR ) ;
		cs.registerOutParameter( 13, Types.VARCHAR ) ;
		cs.registerOutParameter( 14, Types.VARCHAR ) ;
		cs.registerOutParameter( 15, Types.VARCHAR ) ;
		cs.registerOutParameter( 16, Types.VARCHAR ) ;
		cs.registerOutParameter( 17, Types.VARCHAR ) ;
		cs.execute() ;
		report	= cs.getString( 8 ) ;
		server	= cs.getString( 9 ) ;
		copies	= cs.getString( 10 ) ;		
		
		if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
		queue_name	= cs.getString( 12 ) ;
		message	= cs.getString( 15 ) ;
		
		if (message==null) message="";
		app_server_ip = cs.getString( 16 ) ;
		rep_server_key= cs.getString( 17 ) ;
		
		if (rep_server_key==null) rep_server_key="";
		if (report_ssl_yn==null) report_ssl_yn="";
		if(report_ssl_yn.equals("Y")){
			reportServer = "https://" + app_server_ip + reportServer ;
		}else{
			reportServer = "http://" + app_server_ip + reportServer ;
		}
	String url = "";
	if(message==""){
		System.err.println("reportServer========="+reportServer);
		StringBuffer stringBuffer = new StringBuffer();
	java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat( "yyyyMMddHHmmss" ) ;
	String currentDateTime = dateTimeFormat.format( new java.util.Date() ) ;
	
	String file_name_dir=report+"_"+currentDateTime+"" ;
	userid		= (String) session.getValue( "report_connect_string" ) ;
	
	
	String myRegExp = "/\\/g" ;
	String printerName = queue_name ;
	printerName = printerName.replace( myRegExp, "\\\\" ) ;
	queue_name = printerName ;
	String destype = "printer";
	desname =queue_name;
	String Report_ID="DSLABSTIC1";
	

	url = reportServer+"?report="+ report+"+server="+ server+"+destype="+ destype+"+desname="+ desname+"+recursive_load=no"+	"+copies="+ copies+"+background=yes"+"+P_REPORT_ID="+Report_ID;

					if(rep_server_key==""){ 
						url=url+"+userid="+ userid+"+";
					}else{
						url=url+"+cmdkey="+ rep_server_key+"+";
					}	
	}
			
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eDS/js/LabelStickerForFormula.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

</script>
</head>
<body>
<form name="LabelFormulaQuery" id="LabelFormulaQuery" method="post"  target="messageFrame">
<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
	<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
	<tr>
		<td>
		</td>
		<td align="left" class="label">
			<fmt:message key="Common.from.label" bundle="${common_labels}"/>
		</td>
		<td>
		</td>
		<td align="left" class="label">
			<fmt:message key="Common.to.label" bundle="${common_labels}"/>
		</td>
	</tr>
	
	<tr>
					<td align="left" class="label"><fmt:message	key="eDS.AuthorizedDateTime.label" bundle="${ds_labels}" /></td>
					<td align="right" class="label">
						<input type="text" name="authorizedFromDateTime" id="authorizedFromDateTime" id='authorizedFromDateTime' maxlength="16"  size="20" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);" onblur="isValidDateTime(this);">
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('authorizedFromDateTime',null,'hh:mm','modal');">
						<img src='../../eCommon/images/mandatory.gif' />
					</td>
		
										
					<td align="left" class="label"><fmt:message	key="eDS.AuthorizedDateTime.label" bundle="${ds_labels}" /></td>
					<td align="right" class="label">
						<input type="text" name="authorizedToDateTime" id="authorizedToDateTime" id='authorizedToDateTime'maxlength="16" size="20" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);"  onblur="isValidDateTime(this)">
						<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('authorizedToDateTime',null,'hh:mm','modal');">
						<img src='../../eCommon/images/mandatory.gif' />
					</td>
					
	</tr>
	
	<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}"/>
				</td>
				<td align="right" class='label'>
					<select name="nursingUnit" id="nursingUnit"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%
						try
						{
							sql ="SELECT NURSING_UNIT_CODE ,SHORT_DESC  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";
							pstmt=con.prepareStatement(sql);
							rst = pstmt.executeQuery();

							while(rst.next()){
							strCode = checkForNull(rst.getString(1));
							strDesc =  checkForNull(rst.getString(2));
					%>
					<option value="<%=strCode%>"><%=strDesc%></option>
					<%}
						}catch(Exception DCat)	  {}
						   finally
							   {
								   if(rst !=null) rst.close();
								   if(pstmt !=null) pstmt.close();
							   }
					%>
				</td>
				
				<%   
						String pat_id_length="";
						try
						{
							pstmt = con.prepareStatement("select patient_id_length from mp_param where MODULE_ID='MP'");
							rst	=pstmt.executeQuery();
							if (rst.next() && rst != null)
							 {
							  pat_id_length = rst.getString(1);							  
							 }
							}catch(Exception e){
								e.printStackTrace();
							}
							finally	{
							  if(rst !=null) rst.close();
							  if(pstmt != null) pstmt.close();
							}
				%>
					
				<td align="left" class='label'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
				<td align="right" class='label'>
					<input type="text" name="patientId" id="patientId"  maxlength='<%=pat_id_length%>' onKeypress='return CheckForSpecChars(event);' size='12' value="">
					<input align='right' type="button" class='BUTTON' name=search value='?'  class="button" onClick="PatSearch()">
				</td>
			</tr>
	
	<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
		<tr>
			</td>
			<td class="label" align="right">
			
			</td>
			<td class="label" align="right">
			
			</td>
			<td class="label" align="right">
			
			</td>
			
			<td class="label" align="right">
				<input type="button" value="Search"  class="BUTTON" onclick="getResult()">
				<input type="button" value="View label" id="View_label" disabled class="BUTTON" onclick="ViewLabel()">
				<input type="button" value="Print label" id="Print_label" disabled class="BUTTON" onclick="PrintLabel()">
			</td>
		</tr>
		
		<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value=<%=facility_id%>>
		<input type="hidden" id="locale" name="locale" id="locale" value=<%=locale%>>
		<input type="hidden" id="module_id" name="module_id" id="module_id" value="DS">
		<input type="hidden" id="user_name" name="user_name" id="user_name" value="<%= session.getValue( "login_user" ) %>">
		<input type="hidden" id = "view_report_id" name="view_report_id" id="view_report_id" value="DSLABSTIC">
		<input type="hidden" id = "print_report_id" name="print_report_id" id="print_report_id" value="DSLABSTIC1">
		<input type="hidden" id = "report_id" name="report_id" id="report_id" value="<%=report%>">
		<input type="hidden" id = "OrderID_param" name="OrderID_param" id="OrderID_param" value="">
		<input type="hidden" id = "Encounter_ID" name="Encounter_ID" id="Encounter_ID" value="">
		<input type="hidden" id = "url" name="url" id="url" value="<%=url%>">
		<input type="hidden" id = "reportServer" name="reportServer" id="reportServer" value="<%=reportServer%>">
		<input type="hidden" id = "server" name="server" id="server" value="<%=server%>">
		<input type="hidden" id = "userid" name="userid" id="userid" value="<%=userid%>">
		<input type="hidden" id = "desname" name="desname" id="desname" value="<%=desname%>">
		
		<input type="hidden" id = "message" name="message" id="message" value="<%=message%>">
		
</table>
		</form>
	</body>
</html>

