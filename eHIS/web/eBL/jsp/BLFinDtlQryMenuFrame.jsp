<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String login_user = "";
	//String strCashCounterCode = "";
	String strCashCounterArray = "";
	String strLogoutTime  = "";
	
	//Connection con = null;
	//PreparedStatement pstmt = null ;
	//ResultSet rs = null;
	//String sql="";
	//Statement stmt	= null;

	String dep_adjust="1000.50";
	String disc_amt="200.75";
	String exmpt_amt="50.90";
	String adj_amt="10.91";
	String write_off_amt="5.50";

	String locale	= (String)session.getAttribute("LOCALE");

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		login_user =  p.getProperty("login_user");

	}
	catch(Exception eX)
	{
			out.println("Error= "+eX);
	}


%>

<html>
<head>
<script>
/*
 function funEpiTypeChk()
 {
	 var episodetype=document.forms[0].episodetype.value;
	 if(episodetype=='R')
	 {
		 document.forms[0].episodeid.disabled=true;
		 document.forms[0].visitid.disabled=true;
	 }
	 else if{episodetype=='O' || episodetype=='E')
	 {
		 document.forms[0].episodeid.disabled=false;
		 document.forms[0].visitid.disabled=false;
	 }
	 else if(episodetype=='I' || episodetype=='D')
	 {
		 document.forms[0].visitid.disabled=true;
	 }
	 else
	 {
	 }
}

function funEpiTypeOE()
{
	var episodetype = document.forms[0].episodetype.value;
	var episodeid = document.forms[0].episodeid.value;
	var visitid = document.forms[0].visitid.value;
	
	if((episodetype=='E' || episodetype=='O') && episodeid=="")
	{
		alert('Episode id should not be blank');
		document.forms[0].episodeid.focus();
		
	}
}
function funEpi()
{
	var episodetype = document.forms[0].episodetype.value;
	var episodeid = document.forms[0].episodeid.value;
	var visitid = document.forms[0].visitid.value;
	
	if((episodetype=='E' || episodetype=='O') && visitid=='')
	{		
		alert('Visit id should not be blank');
		document.forms[0].visitid.focus();
	}
}
*/
function funmand()
{
	var episodetype = document.forms[0].episodetype.value;
	var patientid= document.forms[0].patientid.value;
	if(episodetype=="" && patid=="")
	{
		//alert("Episode type and Patient id should not be blank")
	}
}

function funQry()
{
	var retVal = 	new String();
	var episode1;
	var episodetype = document.forms[0].episodetype.value;
	var episodeid = document.forms[0].episodeid.value;
	if(episodeid=="") episodetype="R";
	var visitid = document.forms[0].visitid.value;
	var patientid= document.forms[0].patientid.value;

	var episode1 ="";

	if(episodetype=="D")
	{
		episode1=getLabel("Common.daycare.label","common");
	}
	else if(episodetype=="I")
	{
		episode1=getLabel("Common.inpatient.label","common");
	}
	else if(episodetype=="E")
	{
		episode1=getLabel("Common.emergency.label","common");
	}
	else if(episodetype=="O")
	{
		episode1=getLabel("Common.Outpatient.label","common");
	}
	else if(episodetype=="R")
	{
		episode1=getLabel("Common.external.label","common");
	}

	var title=getLabel("eBL.PAT_ENCOUNTER_FIN_DTLS.label","BL");
	parent.frames[2].location.href="../../eBL/jsp/BLFinDtlsQryBanner.jsp?title="+title+"&episodetype="+episodetype+"&"+"episodeid="+episodeid+"&"+"visitid="+visitid+"&"+"patientid="+patientid+"&"+"episode1="+episode1;
}

function displayToolTip(dep_adjust,disc_amt,exmpt_amt,adj_amt,write_off_amt)
{
	buildTable(dep_adjust,disc_amt,exmpt_amt,adj_amt,write_off_amt);
	resizeWindow();
}

function buildTable(dep_adjust,disc_amt,exmpt_amt,adj_amt,write_off_amt)
{

	var tab_dat  = "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='1'   class='columnHeader' width='100%' height='100%' align='center'>"

	tab_dat		+= "<td class='columnHeader' width='20%'>Deposit Adjust</td>";
	tab_dat		+= "<td class='columnHeader' width='20%'>Discount Amount</td>";
	tab_dat		+= "<td class='columnHeader' width='20%'>Exempt Amount</td>"
	tab_dat		+= "<td class='columnHeader' width='20%'>Adjust Amount</td>";
	tab_dat		+= "<td class='columnHeader' width='20%'>Write-off Amt Rounded</td>"

	tab_dat     += "<tr>";
	tab_dat     += "<td class='fields' width='20%'>"+dep_adjust+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+disc_amt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+exmpt_amt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+adj_amt+"</td>";
	tab_dat     += "<td class='fields' width='20%'>"+write_off_amt+"</td>";
	tab_dat     += "</tr> ";
	tab_dat     += "</table> ";
	document.getElementById("t").innerHTML = tab_dat;
}

function resizeWindow()
{
	bodwidth = parent.frames[0].document.body.offsetWidth;
	bodheight = parent.frames[0].document.body.offsetHeight;

	var x =event.x;
	var y =event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth);
	y = y + (document.getElementById("tooltiplayer").offsetHeight);

	if(x<bodwidth)
	{
		x =event.x;
	}
	else
	{
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2);
	}

	if(y<bodheight)
	{
		 y =event.y;
	}
	else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2);
	}

	y+=document.body.scrollTop;
	x+=document.body.scrollLeft;

	document.getElementById("tooltiplayer").style.posLeft= x;
	document.getElementById("tooltiplayer").style.posTop = y;
	document.getElementById("tooltiplayer").style.visibility='visible';
}

function hideToolTip()	
{
	  document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

</script>




<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script> 
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>






	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form >
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>

		<tr>
		<td class='COLUMNHEADER'><fmt:message key="eBL.FIN_DTLS_QRY.label" bundle="${bl_labels}"/>
		
		</tr>
		</table>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		
		<tr>
		<td width='25%'  class='label'><b><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></b></td>
		<td  width='25%' class='fields'>
		   <select name='episodetype' id='episodetype' onchange=''>
		   <option value=''>-------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option>
		   <option value='E'>Emergency</option>
		   <option value='O'>OutPatient</option>
		   <option value='I'>Inpatient</option>
		   <option value='D'>Daycare</option>
		   <option value='R'>External</option>
		   </select><img src='../../eCommon/images/mandatory.gif'></td>
		   <td width='25%'   class='label'><b><fmt:message key="Common.patientId.label"  		 		 bundle="${common_labels}"/></b></td>
		 <td  width='25%'  class="fields"><input type='text' name='patientid' id='patientid' size='20' maxlength='30' value=''><img src='../../eCommon/images/mandatory.gif'></td>
		   
	
	</tr>
	<tr>
		<td width='25%' class='label'><b><fmt:message key="Common.episodeid.label"	bundle="${common_labels}"/></b></td>
		<td width='25%' class="fields"><input type='text' name='episodeid' id='episodeid' size='8' maxlength='30'style='text-align:right'  value='' onBlur=''></td>
		<td width='25%' class='label'> <b><fmt:message key="Common.VisitID.label" bundle="${common_labels}"/></b> </td>
		<td width='25%' class="fields"><input type='text' name='visitid' id='visitid' size='4' maxlength='30' style='text-align:right'  value='' onBlur=''></td>
	</tr>	
		<tr>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'></td>

		<td width="25%" align='left'><input type='button' class='button' onclick='funQry()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.query.label","common_labels")%>" ></td>
		</tr>
	
	<tr>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%' align='right'><a href='#' onMouseOver='displayToolTip(<%=dep_adjust%>,<%=disc_amt%>,<%=exmpt_amt%>,<%=adj_amt%>,<%=write_off_amt%>)' onMouseOut='hideToolTip()'> >>> </a></td>
	</tr>

	
	</table>
		<input type='hidden' name='cashcounter_array' id='cashcounter_array' value='<%=strCashCounterArray%>'>
		<input type='hidden' name='temp_logout_time' id='temp_logout_time' value='<%=strLogoutTime%>'>
		<input type='hidden' name="locale" id="locale"  value='<%=locale%>'>

</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:relative; width:75%; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=3 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
				<tr>
					<td width='100%' id='t'></td>
					</td>
				</tr>
			</table>
		</div>
</body>

</html>

