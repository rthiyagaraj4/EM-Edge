<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            New File            8157          NMC-JD-CRF-0072               Shikha Seth
2            V210211             8157          NMC-JD-CRF-0072               Shikha Seth
3            V210224             8157          NMC-JD-CRF-0072               Shikha Seth
4            V210319             16156         NMC-JD-CRF-0072.2             Shikha Seth
 -->
<!DOCTYPE html>
<%@ page import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, eCommon.Common.*,org.json.simple.*, java.util.Map.Entry,java.util.Set,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,eBL.*,eBL.resources.*,webbeans.op.CurrencyFormat, java.io.*,eXH.*,eCommon.Common.CommonBean,eBL.BLReportIdMapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<%	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<meta name="viewport" http-equiv="X-UA-Compatible" content="IE=edge,chrome=1, width=device-width, initial-scale=1" />
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js" ></script>	
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language ="javascript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<script language = "javascript">
function cancel()
{
	//V210224 start
	var couponcount = document.forms[0].couponcount.value;
	var couponSelectedYN="N";	
	for(i=0;i<couponcount;i++){
		if (document.getElementById("select"+i).checked) {
			couponSelectedYN = "Y";		
		}
	}			
	if (couponSelectedYN == "Y") { 			
			if(confirm(getMessage("BL0932","BLEXT"))) {
				window.returnValue = "";
				window.close();
			}else {
				return false;
			}		
	}else {
		window.returnValue = "";
		window.close();
	} //V210224 end
}
function confirm_ok() {
	var couponcount = document.forms[0].couponcount.value;		
	var patientID = document.forms[0].patientID.value;
	var clientIpAddress = document.forms[0].clientIpAddress.value;
	var LoggedUser = document.forms[0].LoggedUser.value;
	var setld_amt = parseInt(document.forms[0].setld_amt.value);		
	//V210224 start
	var remainingAmt = parseInt(document.forms[0].remainingAmt.value);		
	if(isNaN(setld_amt)){
		setld_amt=0;
	}
	//V210224 end
	var transactionid = "";
	var retVal="";
	var i=0;
	var coupon="";
	var couponAndAmt="";
	var totamount=0;
	for(i=0;i<couponcount;i++){
		if (document.getElementById("select"+i).checked) {
			var couponcode = document.getElementById("couponcode"+i).innerText;
			 totamount = parseInt(totamount)+parseInt(document.getElementById("couponAmt"+i).innerText);				
			if (coupon =="") {
				coupon=couponcode;
				retVal=couponcode;
				couponAndAmt=couponcode.concat("-"+(document.getElementById("couponAmt"+i).innerText));
			} else {
				coupon=coupon+","+couponcode;
				retVal=retVal+"::"+couponcode;
				couponAndAmt=couponAndAmt+", "+couponcode.concat("-"+(document.getElementById("couponAmt"+i).innerText));
			}
		}
	}		
	
	if (!(coupon =="")) {			
		//V210224 start			
			if ((totamount+parseInt(setld_amt)) > parseInt(remainingAmt)) {
				if(confirm(getMessage("BL0923","BLEXT"))) {
					var NuhdeekResponse = NuhdeekTransactions('HOLD',patientID,coupon,transactionid, LoggedUser, clientIpAddress);		
					var NuhdeekResponseArr = NuhdeekResponse.split("$!^");		
					if (NuhdeekResponseArr[0] == 'S') {							
						window.returnValue = coupon+"::"+totamount+"::"+couponAndAmt;
						window.close();
					} else if (NuhdeekResponseArr[0]=='E') {
							alert(NuhdeekResponseArr[4]);
							return false;
					} 
				}else {
					return false;
				}
			} else{				
				var NuhdeekResponse = NuhdeekTransactions('HOLD',patientID,coupon,transactionid, LoggedUser, clientIpAddress);		
				var NuhdeekResponseArr = NuhdeekResponse.split("$!^");		
				if (NuhdeekResponseArr[0] == 'S') {							
					window.returnValue = coupon+"::"+totamount+"::"+couponAndAmt;
					window.close();
				} else if (NuhdeekResponseArr[0]=='E') {
						alert(NuhdeekResponseArr[4]);
						return false;
				} //V210224 end
		} 
	}else {
		window.returnValue = "";
		window.close();
	}
}	

function selectcoupon(index,couponcode,couponAmt) {	
	var couponcount = document.forms[0].couponcount.value;		
	var count=0;	
	var i=0;
	var selectCB = document.getElementById('select'+index);
	if (selectCB.checked){
		document.getElementById('select'+index).value='Y';
		for(i=0;i<couponcount;i++) {
			if(document.getElementById("select"+i).checked == true)
			count++;
		}
		if(count==couponcount) {
			document.getElementById("selectall").checked=true;
		}
	}
	else if(selectCB.checked==false) {
		document.getElementById("selectall").checked=false;
	}
}

function selectallcoupon(){
	var couponcount = document.forms[0].couponcount.value;	
	var selectallCB = document.getElementById("selectall");
	var i=0;	
	if(selectallCB.checked) {		
		for( i=0;i<couponcount;i++){			
			document.getElementById("select"+i).checked = true;
			document.getElementById("select"+i).value = "Y";
		}
	}
}

function findcoupon() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("findstring");
  filter = input.value.toUpperCase();
  table = document.getElementById("couponTable");
  tr = table.getElementsByTagName("tr");
  for (i = 1; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>     
    .couponbody {
	  height: 345px;
	  overflow: auto;
	  overflow-x: hidden;
	}
   </style>
<title>
	<%=request.getParameter("title")%>
</title>

<%		
	request.setCharacterEncoding("UTF-8");
	try
	{
		String query_string="";
		query_string = (request.getQueryString());
		System.out.println("query_string in nuhdeek.jsp:"+ query_string);
		}
	catch(Exception e)
	{
		System.out.println("main exception in nuhdeek-"+e);
		e.printStackTrace();
	}
%>	

</head>
<body>
<form>
<center>
<table>
	<table >
<tr>
<td width="8%" class="label"><fmt:message key="eBL.Find.Label" bundle="${bl_labels}"/></td>
<td><input type='text' name='findstring' id='findstring' id='findstring' value='' size='50' maxlength='50' > </td>
</tr>
</table>
<tr>
<div class="couponbody">
	<table width='100%' align="center" cellpadding="4" cellspacing="0" class='grid' id="couponTable" >          		
			<tr>
            <td class='COLUMNHEADER' >Coupon Code</td>
			<td class='COLUMNHEADER' >Coupon Description </td>
            <td class='COLUMNHEADER' >Amount </td>
            <td class='COLUMNHEADER' >Select All <input type='checkbox' name="selectall" id="selectall" id="selectall" onclick="selectallcoupon()"></td>            
           </tr>
<%
request.setCharacterEncoding("UTF-8");
String coupons = request.getParameter("coupons");
String clientIpAddress = request.getParameter("clientIpAddress");
String LoggedUser = request.getParameter("LoggedUser");
String patientID = request.getParameter("patientID");
String setld_amt = request.getParameter("setld_amt");
String remainingAmt = request.getParameter("remainingAmt"); //V210224
System.err.println("setld_amt="+setld_amt+"/"+remainingAmt);
  StringTokenizer st = new StringTokenizer(coupons,"|");  
  int count =st.countTokens();  
//  V210211 START
	if (count <= 0) {  
  %> <script>		
	alert(getMessage('BL0922','BLEXT')); 
	window.close();
</script>
<%
	}%>
<%
	//V210211 END
  for(int i=0;i<count;i++) {
  String couponNAmt = st.nextToken();
  String coupon[] = couponNAmt.split("~");  
%>
<tr>
<td id='couponcode<%=i%>'><%=coupon[0] %></td>
<td id='couponDesc<%=i%>'><%=coupon[2] %></td> <!-- V210319 -->
<!-- <td id='couponDesc<%=i%>'>NMC100000003180000000003266394Coupon Amount 100 OFF</td> -->
<td id='couponAmt<%=i%>'><%=coupon[1] %></td>
<td><input type='checkbox' id="select<%=i%>" name="select<%=i%>" value='' onclick="selectcoupon('<%=i%>','<%=coupon[0] %>','<%=coupon[1] %>')"></td>
</tr>
  <%}%>
</table>
</div>
</tr>
<div>
<tr>
<td><input type='button' id='find' name='find' id='find' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.Find.Label","bl_labels")%>" class='button' onClick="findcoupon()"> </td> 
<td><input type='button' id='ok' name='ok' id='ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" class='button' onClick='confirm_ok()'> </td>
<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'>
</tr>
</div>
</table>
</center>
<input type='hidden' name='coupons' id='coupons' value='<%=coupons%>'>
<input type='hidden' name='clientIpAddress' id='clientIpAddress' value='<%=clientIpAddress%>'>
<input type='hidden' name='LoggedUser' id='LoggedUser' value='<%=LoggedUser%>'>
<input type='hidden' name='patientID' id='patientID' value='<%=patientID%>'>
<input type='hidden' name='couponcount' id='couponcount' value='<%=count%>'>
<input type='hidden' name='setld_amt' id='setld_amt' value='<%=setld_amt%>'>
<input type='hidden' name='remainingAmt' id='remainingAmt' value='<%=remainingAmt %>'>
</form>
</body>
</html>

