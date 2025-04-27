<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"
	import="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.Common.*,org.json.simple.*, java.util.Map.Entry,java.util.Set,webbeans.eCommon.*, eBL.Common.*,eBL.*,eBL.resources.*,webbeans.op.CurrencyFormat, java.io.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />

<%
/*
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210203             7339  	       	MOHE-CRF-0050		           Mohana Priya K
2            V210216             14534 	       	MOHE-CRF-0050		           Mohana Priya K
-->
*/
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/dailycashTabFrame.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function onLoadMaintainServ(from){
	if(from=='createserv'){
		var serviceValues=parent.AssocServtab.document.getElementById("tempserviceVal").value;
		var table = document.getElementById("MaintainserviceTbl");
		var length=parent.AssocServtab.document.getElementById("servcnt").value;
		var tablen=table.rows.length;
		serviceValues = serviceValues.slice(0, -5);
		var arrOfServ = serviceValues.split(",,,,,");
		for(var i=1; i<=length; i++) {
			var row = table.insertRow(i);
			
			var newcell	= row.insertCell(0);
			newcell.innerHTML ="<td class='fields' nowrap> "+
				"<select id='ServTypeval"+i+"' style='width:90%;' name='ServTypeval"+i+"' id='ServTypeval"+i+"' onChange='servTypeChange(this)'> "+
					"<option value='S'>Billing Service</option> "+
					"<option value='I'>Material Item</option> "+
				"</select> "+
				"</td>";
			var newcell1	= row.insertCell(1);
			newcell1.innerHTML ="<td align='center' ><input type='text' onblur=\"if(this.value!=''){servItemlkup(this);}\" style='width:90%;' maxlength='150' name='servitem"+i+"' id='servitem"+i+"'  id='servitem"+i+"'  value=''   >" +
					" <input type='button' name='servitembtn"+i+"' id='servitembtn"+i+"' id='servitembtn"+i+"' value='?' onClick='servItemlkup(this)'> "+
					"<input type='hidden' name='serv_item"+i+"' id='serv_item"+i+"' id='serv_item"+i+"'>"+
					"</td>";
			newcell1.style.textAlign = "left";
			var newcell2	= row.insertCell(2);
			newcell2.innerHTML ="<td align='center' colspan='2'><input type='text'  onfocus='this.blur();' style='width:100%;' maxlength='350' name='serviceitmDesc"+i+"' id='serviceitmDesc"+i+"'  id='serviceitmDesc"+i+"' value='' readonly></td>";
			newcell2.style.textAlign = "center";
			
			var k=i-1;
			var arrOfStrg = arrOfServ[k].split("~");
			var code=arrOfStrg[0];
			var desc=arrOfStrg[1];
			var ind=arrOfStrg[2];
			document.getElementById("serviceitmDesc"+i).value=desc;
			document.getElementById("servitem"+i).value=code;
			var s=document.getElementById("ServTypeval"+i);
			for(var j=0; j<s.options.length; j++)
	   		{
				if(s.options[j].value==ind){
					s.options[j].selected=true;
				}
			}	
		}
	}	
}



</script>
<style>
#table-wrapper {
  position:relative;
}
#table-scroll {
  height:360px; 
  overflow:auto;  
  margin-top:20px;
}
#table-wrapper table {
  width:100%;
}
#table-wrapper table  {
  background:white;
  color:black;
}
#table-wrapper table thead tr {
  position:relative; 
  top: expression(offsetParent.scrollTop);
  z-index:2;
  height:20px;
  width:35%;
}
</style>
</head>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1   
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
	String locale = "";
	String facilityId = "";
	String isUserCanAcess = "";
	int l=14;
	int limit=1;
	int serSize=0;
	int extra=0;
	int totRec=0;
	int extraID=0;
	String serviceSave	=	"N";
	String disabled="";
	String readonly="";
	String onfocus="";
	String servGpCode="";
	String selectall="";
	try {
		locale = (String) session.getAttribute("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		isUserCanAcess = (String) (session.getValue("isUserCanAcess") == null ? "Y" : (session.getValue("isUserCanAcess")));
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties) httpSession.getValue("jdbc");
		String WS_NO  = p.getProperty("client_ip_address");
		String strLoggedUser = p.getProperty("login_user");
		if (strLoggedUser == null)
			strLoggedUser = "";
		String Called = request.getParameter("called") == null ? "" : request.getParameter("called");
		System.err.println("called from-->"+Called);
%>
<body onload="onLoadMaintainServ('<%=Called %>')">
	<form name='MaintReportServ' id='MaintReportServ' id='MaintReportServ' method='post' action="../../servlet/eBL.BLDailyCashServlet" target="messageFrame">
		<center>
			<%
					String loginUser = (String) session.getValue("login_user");
					String localeLang = (String) session.getAttribute("LOCALE");
			%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<div id="table-wrapper">
					<div id="table-scroll">
					<table width='100%' align="center" cellpadding="4" cellspacing="0" class='grid' id="MaintainserviceTbl">
					<thead>
						<tr>
							<td class='COLUMNHEADER' align='center' width='7%'>Service Type</td>
							<td class='COLUMNHEADER' align='center' width='10%'>Service Item Code</td>
							<td class='COLUMNHEADER' align='center' colspan='2' width='20%'>Description</td>
						</tr>
						</thead>
						<%
					if (Called.equals("servload")) {
						servGpCode=request.getParameter("servGpCode") == null ? "" :request.getParameter("servGpCode");
						System.err.println("servGpCode maint >" + servGpCode);
						String bean_id		=	"";
						String bean_name	=	"";
						bean_id		= 	"DailyCashDeliveryReport" ;
						bean_name	= 	"eBL.DailyCashDeliveryReport"; 
						LinkedHashMap 	DailyCashReprt	=	null;
						DailyCashDeliveryReport DailyCashDeliveryReport = 	null;
						DailyCashReportBean	DailyCashReportBean =new DailyCashReportBean();	
						DailyCashReprt	=	new LinkedHashMap();
						DailyCashDeliveryReport	= 	(DailyCashDeliveryReport)PersistenceHelper.getBeanObject( bean_id, bean_name, request );
						DailyCashDeliveryReport.clearBean();
						DailyCashDeliveryReport.getServValues(localeLang,servGpCode);//Loading DB Values from Temporary table to HasMap
						DailyCashReprt	= 	(LinkedHashMap)DailyCashDeliveryReport.getDailyCashSearchValues();
						String servtypI="";
						String servtypS="";
						String KeyValue="";
						
						serSize=DailyCashReprt.size();
						System.err.println("serSize From Bean  "+serSize);
						totRec=serSize;
						if(serSize<14){
							extra=14-serSize;
							System.err.println("extra size  "+extra);
						}
						if(!DailyCashReprt.isEmpty()) {
							Iterator it = DailyCashReprt.entrySet().iterator();
							while(it.hasNext()) {
							   Map.Entry obj = (Entry)it.next();
							   DailyCashReportBean=(DailyCashReportBean)obj.getValue();
							   KeyValue=(String)obj.getKey();
							   if(DailyCashReportBean!=null){
									//service indicator
								   String ServInd= DailyCashReportBean.getServItmInd();
								   ServInd=(ServInd==null?"":ServInd);
								   System.err.println("ServInd From Bean  "+ServInd);
									
								   if(ServInd.equals("I")){
									   servtypI="selected";
									   servtypS="";
									}else{
										 servtypS="selected";
										 servtypI="";
									}	
								   
								   //Service item Code
								   String servItmCode= DailyCashReportBean.getServItmCode();
								   servItmCode=(servItmCode==null?"":servItmCode);
								   System.err.println("servItmCode From Bean  "+servItmCode);
									
								   //service item Desc
								   String ServItmDesc= DailyCashReportBean.getServItmDesc();
								   ServItmDesc=(ServItmDesc==null?"":ServItmDesc);
								   System.err.println("ServItmDesc From Bean  "+ServItmDesc);
							   %>
							<tr id="servitmCode<%=limit%>">
								<td>
									<select name="ServTypeval<%=limit%>" id="ServTypeval<%=limit%>" id="ServTypeval<%=limit%>" readonly style="width:90%;" onfocus="this.blur()" readonly="readonly">
										<option value="S" <%=servtypS %>>Billing Service</option>
										<option value="I" <%=servtypI %>>Material Item</option>
									</select>
								</td>
								<td>
									<input class="gridDataInputLess" type="text" maxlength="150" style="width:90%;" name="servitem<%=limit%>" id="servitem<%=limit%>" id="servitem<%=limit%>" value="<%=servItmCode%>" onfocus="this.blur()" readonly="readonly">
								</td>
								<td colspan='2'>
									<input class="gridDataInputLess" type="text" maxlength="150" style="width:100%;" name="serviceitmDesc<%=limit%>" id="serviceitmDesc<%=limit%>" id="serviceitmDesc<%=limit%>" value="<%=ServItmDesc%>" onfocus="this.blur()" readonly="readonly">
								</td>
							</tr>
									   <%
									   }
									   limit++;	
									}
								}
							}
								
											   
					if (Called.equals("createserv")) {
						selectall=request.getParameter("selectall") == null ? "N" :request.getParameter("selectall");
						System.err.println("selectall--"+selectall);
						servGpCode=request.getParameter("servGpCode") == null ? "" :request.getParameter("servGpCode");
						String size=request.getParameter("paramlen") == null ? "" :request.getParameter("paramlen");
						int length=Integer.parseInt(size);
						totRec=length;
						System.err.println("length--"+length);
						if(length<14){
							extra=14-length;
							System.err.println("extra size  "+extra);
						}
						limit=length+1;
					}
					if(extra>0){
						extraID=limit;
						for(int k=0;k<extra;k++){
							if(k==0){
								disabled="";
								readonly="";
								onfocus="";
							}else{
								disabled="disabled";
								readonly="readonly" ;
								onfocus="this.blur()";
							}	%>
					<tr id="servitmCode<%=extraID%>" <%=disabled%>>
						<td>
							<select name="ServTypeval<%=extraID%>" id="ServTypeval<%=extraID%>" id="ServTypeval<%=extraID%>" onChange='servTypeChange(this)' style="width:90%;" <%=disabled%> <%=onfocus%> <%=readonly%>>
								<option value="S" selected>Billing Service</option>
								<option value="I">Material Item</option>
							</select>
						</td>
						<td>
							<input class="gridDataInputLess" type="text" maxlength="150" style="width:90%;" name="servitem<%=extraID%>" id="servitem<%=extraID%>" id="servitem<%=extraID%>" onblur="if(this.value!=''){servItemlkup(this);enableNextRow(this)}" value="" <%=disabled%> <%=onfocus%> <%=readonly%>>
							<input type='button' class='button' name="servitembtn<%=extraID%>" id="servitembtn<%=extraID%>" id="servitembtn<%=extraID%>" value='?' onClick="servItemlkup(this);enableNextRow(this)" <%=disabled%> <%=onfocus%> <%=readonly%>/> 
							<input type="hidden" name="serv_item<%=extraID%>" id="serv_item<%=extraID%>" id="serv_item<%=extraID%>" value="">
						</td>
						<td colspan='2'>
							<input class="gridDataInputLess" type="text" maxlength="150" style="width:100%;" name="serviceitmDesc<%=extraID%>" id="serviceitmDesc<%=extraID%>" id="serviceitmDesc<%=extraID%>" value="" <%=disabled%> <%=onfocus%> readonly>
						</td>
					</tr>
					<%
					extraID++;
					}
				}%>
				</table>
				</div>
			</div>	
			</td>
		</tr>
		<tr>
			<td><br>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" >
					<tr>
						<td align='right'>
							<input type='button' class='BUTTON' value='Add' onclick="AddRowServ()">
							<input type='button' class='BUTTON' id="savebtn" value='Save' onclick='saveNewServ()'>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
		</td>
		</tr>
	</table>
	<input type="hidden" name="locale" id="locale" id="locale" value="<%=localeLang%>"> 
	<input type="hidden" name="FacilityId" id="FacilityId" id="FacilityId" value="<%=facilityId%>"> 
	<input type="hidden" name="servGrpCode" id="servGrpCode" id="servGrpCode" value="<%=servGpCode%>">
	<input type="hidden" name="servGrpDesc" id="servGrpDesc" id="servGrpDesc" value="">
	<input type="hidden" name="grpSize" id="grpSize" id="grpSize" value="<%=serSize%>">
	<input type="hidden" name="rowval" id="rowval" id="rowval" value=""> 
	<input type='hidden' name='user' id='user' id='user' value="<%=strLoggedUser%>">
	<input type="hidden" name="servArrCode" id="servArrCode" id="servArrCode" value="">
	<input type="hidden" name="totalRec" id="totalRec" id="totalRec" value="<%=totRec%>">  
	<input type="hidden" name="count" id="count" id="count" value="">  
	<input type="hidden" name="createselidx" id="createselidx" id="createselidx" value="<%=selectall%>">  
	<input type="hidden" name="modeType" id="modeType" id="modeType" value="MaintainServIns">
	<input type="hidden" name="serviceSave" id="serviceSave" id="serviceSave" value="<%=serviceSave%>">
	<input type="hidden" name="WS_NO" id="WS_NO" id="WS_NO" value="<%=WS_NO%>">
	<input type="hidden" name="called" id="called" id="called" value="maintainserv">
	</form>
</body>
<%	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in maintainserv.jsp::" + e);
	}
%>
<%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}%>
</html>

