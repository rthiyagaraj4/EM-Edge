<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%


	
	Connection con=null;
	try{
	
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	String facilityId = (String)session.getValue("facility_id");
		
	Statement stmt =con.createStatement();
	ResultSet rs =null;	
	String sdate="";
	
	String sysdate="Select to_char(sysdate,'dd/mm/yyyy')sys from dual ";
	ResultSet rsdate=stmt.executeQuery(sysdate);
	while (rsdate.next())
	sdate=rsdate.getString("sys");

	if( rsdate != null) rsdate.close();
%>

<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<script language="JavaScript">

async function selectPrinter1(desc,code)
{
	if(desc.value == "")
	{desc.value="";
	 code.value="";
	  
	
	if(desc.name=="printer_id1desc")
		 {
		disableTime1(desc)
		 }else if(desc.name=="printer_id2desc")
			 {
			 disableTime2(desc)
			 }else if(desc.name=="printer_id3desc")
			 {
			 disableTime3(desc)
			 }
	return ;
	}
await selectPrinter(desc,code)

}
async	function selectPrinter(desc,code)
	{
			tar=desc.value
		
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('eSM.Printers.label','SM')	
		var reportclass=document.forms[0].reportclass.value
			
		
			sql="Select printer_id code,printer_name description from sm_printer where eff_status='E' and upper(printer_id) like upper(?) and upper(printer_name) like upper(?) order by 2";
	
	
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = tar;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
	//	retArray = await CommonLookup( title, argArray );		
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		
		if(retVal != null && retVal != "" )
		  {
			
		    var ret1=unescape(retVal);
			arr=ret1.split(",");
			desc.value=arr[1];
			code.value=arr[0];
			
			if(desc.name=="printer_id1desc")
			 {
				disableTime1(desc)
			 
			 }else if(desc.name=="printer_id2desc")
			 {
			 disableTime2(desc)
			 }else if(desc.name=="printer_id3desc")
			 {
			 disableTime3(desc)
			 }
	/*	if(retVal != null && retVal != "" )
		  {
			
		  //  var ret1=unescape(retVal);
			//arr=ret1.split(",");
			//desc.value=arr[1];
			//code.value=arr[0];
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			
			if(desc.name=="printer_id1desc")
			 {
				disableTime1(desc)
			 
			 }else if(desc.name=="printer_id2desc")
			 {
			 disableTime2(desc)
			 }else if(desc.name=="printer_id3desc")
			 {
			 disableTime3(desc)
			 }*/

			//desc.blur();
			}else
		{
		//desc.value="";
		//code.value="";
			desc.value=arr[1];
			code.value=arr[0];
		}
				
	}
function CheckPositiveNumber1(obj)
		{	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {		
	}
	else {
  		if ( obj.value.length > 0 ) {
  			alert(getMessage('COPY_GR_ZERO','SM'));
  			obj.select();
  			obj.focus();
  		}
  	}
}

function ChkNumberInput1(fld, e)
{
   var strCheck = '0123456789';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

	function checkNum(obj) {
			if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {		
				if(obj.value.indexOf(".") >= 0)
				{
					alert(parent.parent.frames[0].getMessage('INVALID_INTEGER','SM'));
					obj.select();
					obj.focus();
				}
				}
				else {
					if ( obj.value.length > 0 ) {
						alert(getMessage('NUM_ALLOWED','SM'));
						obj.select();
						obj.focus();
					}
				}
	}

function CheckTime(obj) {
	  if (obj.value.length>0 )
		     {
				if(ValidateTime(obj)==false) {
					alert(getMessage('INVALID_TIME_FMT','SM'));
					//obj.select();
					obj.value='';
					obj.readOnly=false;
obj.focus();
				  }
			 }
}
function ValidateTime(obj)
{
	time = obj.value
if (time.indexOf(":") > -1) {
	if  (time.length<5) return false;
	var a=  time.split(":")
	splithrs=a[0];
	splitmin=a[1]
	
	if (splithrs >23 || splithrs <0) 
		{
			alert(getMessage('HR_LESS_TWENTYFOUR','SM'));
			obj.select();
			obj.focus();
		}
	if (splitmin >59 || splitmin <0) 
		{
			alert(getMessage('MI_LESS_SIXTY','SM'));
			obj.select();
		    obj.focus();
		}
	} else return false;
	return true
}

function disableTime1(obj){
				var fieldval = obj.value;
				
				if(fieldval != '')
				{   
					document.forms[0].printer_id2desc.readOnly = false;
					document.forms[0].from_time.readOnly = false;
					document.forms[0].from_time.value = "";
					document.forms[0].printer_id2.disabled = false;
					document.forms[0].printer_id3.value = "";
					document.forms[0].printer_id3desc.readOnly = true;
					document.forms[0].from_time3.readOnly= true;
				    document.forms[0].printer2.disabled = false;
					// document.forms[0].printer3.disabled = false;
				}
				else
				{	document.forms[0].printer_id2desc.value="";
				    document.forms[0].printer_id3desc.value="";
					document.forms[0].from_time.value='';
					document.forms[0].from_time.readOnly=true;
					document.forms[0].from_2time.value='';
					document.forms[0].printer_id2.value='';
					document.forms[0].from_3time.value='';
					document.forms[0].from_3time.readOnly=true;
					document.forms[0].printer_id3.value='';
					document.forms[0].printer_id3.disabled=true;
					document.forms[0].from_2time.readOnly = true;
					document.forms[0].printer_id2.disabled = true;
				    document.forms[0].printer_id2desc.readOnly = true;
					document.forms[0].printer2.disabled = true;
					document.forms[0].printer3.disabled = true;
				}
			}


			function disableTime2(obj){
				var fieldval = obj.value;
				
				if(fieldval != '')
				{document.forms[0].printer_id2desc.disabled=false;
					document.forms[0].from_2time.readOnly = false;
					document.forms[0].from_2time.value = "";
					document.forms[0].from_3time.readOnly = false;
					//document.forms[0].printer_id3.disabled = false;
					document.forms[0].printer_id3desc.readOnly = false;
					document.getElementById("printer3").disabled=false;
				}
				else
				{	document.forms[0].printer_id3desc.value="";
					document.forms[0].from_2time.value='';
					document.forms[0].from_3time.value='';
					document.forms[0].printer_id3.value='';
					document.forms[0].from_2time.readOnly = true;
			
					document.forms[0].from_3time.readOnly = true;
					document.forms[0].printer_id3desc.readOnly = true;
					document.getElementById("printer3").disabled=true;
				}
			}

			function disableTime3(obj){
				if(obj.value != '')
				{
					document.forms[0].from_3time.readOnly = false;
			
				}
				else
				{
					document.forms[0].from_3time.value='';
					document.forms[0].from_2time.readOnly = true;
					document.forms[0].from_3time.readOnly = true;
				}
			}

function initialLoad()
			{
				if(document.forms[0].printer_id.value!="")
				{
					document.forms[0].printer_id2desc.readOnly = false;
					document.forms[0].printer2.disabled = false;
				}
				else
				{
					document.forms[0].printer_id2desc.readOnly = true;
					document.forms[0].printer3.disabled = true;
				}
				if(document.forms[0].printer_id2.value!="")
				{
					document.forms[0].printer_id3desc.readOnly = false;
					document.forms[0].printer3.disabled = false;
					}
				else
				{
					document.forms[0].printer_id3desc.readOnly = true;
					document.forms[0].printer3.disabled = true;
				}
			}

	function Pass2MsgFrm(num){

				
		if(num=="one")
			{
               if(document.getElementById("module_id").value=="")
				{
				document.getElementById("printer_id1desc").value="";
				document.getElementById("printer_id2desc").value="";
				document.getElementById("printer_id3desc").value="";
                document.getElementById("printer_id").value="";
				document.getElementById("printer_id2").value="";
				document.getElementById("printer_id3").value="";
			    document.forms[0].printer_id1desc.readOnly = true;
				document.forms[0].printer1.disabled = true;
				document.forms[0].printer_id2desc.readOnly = true;
				document.forms[0].printer2.disabled = true;
				document.forms[0].printer_id3desc.readOnly = true;
				document.forms[0].printer3.disabled = true;
				return false;
				}else
				{
					document.getElementById("facility_id").disabled=false;
					document.getElementById("dest_locn_code").disabled=false;
					document.getElementById("facimg").style.visibility='visible';
					
					
				
				var n=parent.document.f_query_add_mod.document.forms[0].report_id.options.length;
				for(var i=0;i<n;i++)
				{
					parent.document.f_query_add_mod.document.forms[0].report_id.remove("report_id");
				}		
		
				var n1=parent.document.f_query_add_mod.document.forms[0].dest_locn_type.options.length;
				for(var i=0;i<n1;i++)
				{
					parent.document.f_query_add_mod.document.forms[0].dest_locn_type.remove("dest_locn_type");
				}

				var n2=parent.document.f_query_add_mod.document.forms[0].facility_id.options.length;
				for(var i=0;i<n2;i++)
				{
					parent.document.f_query_add_mod.document.forms[0].facility_id.remove("facility_id");
				}						
				var n3=parent.document.f_query_add_mod.document.forms[0].dest_locn_code.options.length;
				for(var i=0;i<n3;i++)
				{
					parent.document.f_query_add_mod.document.forms[0].dest_locn_code.remove("dest_locn_code");
				}
			
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest()	;
					
			    xmlStr ="<root><SEARCH Chksrc=\""+num+"\" Common_Text=\""+document.getElementById("module_id").value+"\" Common_Text1=\""+document.getElementById("report_id").value+"\" /></root>"
 			    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");				
			    xmlHttp.open("POST","GetValues.jsp",false)

				xmlHttp.send(xmlDoc)
			    responseText=xmlHttp.responseText
			    responseText = trimString(responseText)
			
			   eval(responseText)
				
				
				}
				}
			else if (num=="three")
			{
				
				var n=parent.document.f_query_add_mod.document.forms[0].dest_locn_code.options.length;
				for(var i=0;i<n;i++)
				{
					parent.document.f_query_add_mod.document.forms[0].dest_locn_code.remove("dest_locn_code");
				}		
				
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
			    xmlStr ="<root><SEARCH Chksrc=\""+num+"\" Common_Text=\""+document.getElementById("dest_locn_type").value+"\" mod_id=\""+document.getElementById("module_id").value+"\"  Common_Text1=\""+document.getElementById("facility_id").value+"#"+document.getElementById("report_id").value+"\" /></root>"
 			    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			    xmlHttp.open("POST","GetValues.jsp",false)

			    xmlHttp.send(xmlDoc)
			    responseText=xmlHttp.responseText
			    responseText = trimString(responseText)
				
			    eval(responseText)
					
			}
			else if(num=="five")
			{
				var n=parent.document.f_query_add_mod.document.forms[0].dflt_report_mode.options.length;
				for(var i=0;i<n;i++)
				{
					parent.document.f_query_add_mod.document.forms[0].dflt_report_mode.remove("dflt_report_mode");
				}							
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
			    xmlStr ="<root><SEARCH Chksrc=\""+num+"\" Common_Text=\""+document.getElementById("module_id").value+"\" Common_Text1=\""+document.getElementById("report_id").value+"\" /></root>"
 			    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			    xmlHttp.open("POST","GetLocnValues.jsp",false)

			    xmlHttp.send(xmlDoc)
			    responseText=xmlHttp.responseText
			    responseText = trimString(responseText)
			    eval(responseText)
			}
			else if(num=="six")
			{
				
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
			    xmlStr ="<root><SEARCH Chksrc=\""+num+"\" Common_Text=\""+document.getElementById("dflt_report_mode").value+"\" Common_Text1=\""+document.getElementById("module_id").value+"\" Common_Text2=\""+document.getElementById("report_id").value+"\" /></root>"
 			    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			    xmlHttp.open("POST","GetLocnValues.jsp",false)

			    xmlHttp.send(xmlDoc)
			    responseText=xmlHttp.responseText
			    responseText = trimString(responseText)
			    eval(responseText)
				
			}
			else //for two
			{
									
				document.getElementById("printer_id1desc").value="";
				document.getElementById("printer_id2desc").value="";
				document.getElementById("printer_id3desc").value="";
                document.getElementById("printer_id").value="";
				document.getElementById("printer_id2").value="";
				document.getElementById("printer_id3").value="";
				
				if(document.getElementById("report_id").value=="")
				{
				// Tuesday, February 16, 2010  19357 Venkat S.
				document.getElementById("facility_id").disabled=false;
				var n=document.forms[0].facility_id.options.length;
				for(var i=0;i<n;i++)
				{
				document.forms[0].facility_id.remove("facility_id");
				}
			    var tp ="-----------"+getLabel("Common.defaultSelect.label","Common")+ "--------"
				var opt=document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				document.forms[0].facility_id.add(opt);
				// end 
				document.getElementById("printer_id1desc").readOnly=true
				document.getElementById("printer1").disabled=true
				document.getElementById("printer_id2desc").readOnly=true
				document.getElementById("printer2").disabled=true
				document.getElementById("printer_id3desc").readOnly=true
				document.getElementById("printer3").disabled=true
				}else
				{
				document.getElementById("printer_id1desc").readOnly=false
				document.getElementById("printer1").disabled=false
				/*document.getElementById("printer_id2desc").readOnly=false
				document.getElementById("printer2").disabled=false
				document.getElementById("printer_id3desc").readOnly=false
				document.getElementById("printer3").disabled=false*/
					}
				var n=parent.document.f_query_add_mod.document.forms[0].dest_locn_type.options.length;
				for(var i=0;i<n;i++)
				{
					parent.document.f_query_add_mod.document.forms[0].dest_locn_type.remove("dest_locn_type");
				}
				
			/*	var n=parent.document.frames[1].document.forms[0].printer_id.options.length;
				for(var i=0;i<n;i++)
				{
					parent.document.frames[1].document.forms[0].printer_id.remove("printer_id");
				}						
				
				var n2=parent.document.frames[1].document.forms[0].printer_id2.options.length;
				for(var i=0;i<n2;i++)
				{
					parent.document.frames[1].document.forms[0].printer_id2.remove("printer_id2");
				}
				
				var n3=parent.document.frames[1].document.forms[0].printer_id3.options.length;
				for(var i=0;i<n3;i++)
				{
					parent.document.frames[1].document.forms[0].printer_id3.remove("printer_id3");
				}*/	
				
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
			    xmlStr ="<root><SEARCH Chksrc=\""+num+"\" Common_Text=\""+document.getElementById("module_id").value+"\" Common_Text1=\""+document.getElementById("report_id").value+"\" /></root>"
 			    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			    xmlHttp.open("POST","GetValues.jsp",false)

			    xmlHttp.send(xmlDoc)
			    responseText=xmlHttp.responseText
			    responseText = trimString(responseText)
					
			    eval(responseText)
				
			
			
			}
			
	}		


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='initialLoad();FocusFirstElement()' >
<form name="printrouting_form" id="printrouting_form" action="../../servlet/eSM.PrintRoutingServlet" method="post" target="messageFrame">

<table name=mainTable border="0" cellpadding="0" cellspacing="0" width="95%" align='center'>
  	<tr>
  		<td width='25%'>&nbsp;</td>
  		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan="2"><select name="module_id" id="module_id" onChange="Pass2MsgFrm('one')">
		<OPTION VALUE=''>&nbsp;&nbsp;---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------&nbsp&nbsp;  			       
	<%
		    rs = stmt.executeQuery( "Select distinct a.module_id,a.module_name from sm_module a , sm_report b where install_yn='Y' and b.module_id=a.module_id order by module_name");
	
		      if( rs != null )
		       {
		          while( rs.next() )
			    {
			     String moduleid = rs.getString( "module_id" ) ;
				 String modulename = rs.getString("module_name");
	%>

	    		    <OPTION VALUE='<%= moduleid %>' ><%= modulename %>
					
	<%
			    } 
	      		}
	      		rs.close();
	      		stmt.close();
	%>	     	 
		  </select> <img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	</tr>
  <tr>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  </tr>
  <tr>
      <td class="label"><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
      <td nowrap class='fields' colspan="2"><select name="report_id" id="report_id" onChange="Pass2MsgFrm('two')">
	       	<option value="">-----------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------
	 	 </select>
	    	<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	  </td>
  </tr>
 <tr>
 	<td>&nbsp;</td>
 	<td>&nbsp;</td>
 	<td>&nbsp;</td>
 </tr>
	<tr>
		<td nowrap class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td nowrap class='fields' colspan="2"><select name="facility_id" id="facility_id"  onChange="Pass2MsgFrm('three')">
				<OPTION VALUE=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------	
			</select>
			<img id="facimg" src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				
 
		</td>
	</tr>
	      <%
	         if( stmt != null) stmt.close();
	         if( rs != null) rs.close();
	      %>
   <tr>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
   	<td>&nbsp;</td>
   </tr>
    <tr>
	      <td nowrap class="label"><fmt:message key="Common.Destination.label" bundle="${common_labels}"/></td>
	      <td nowrap class='fields'><select name="dest_locn_type" id="dest_locn_type"  onChange="Pass2MsgFrm('three')">
	      <OPTION VALUE=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
	      </select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	       <td class='fields'><select name="dest_locn_code" id="dest_locn_code">
	       <OPTION VALUE=''>-------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------
	      </select><img id="locnimg" src='../../eCommon/images/mandatory.gif' align='center'></img>
	      <input type="text" name="dest_locn_code1" id="dest_locn_code1"  onKeyPress="return CheckForSpecChars(event)" onBlur='makeValidString(this)' size="6" maxlength="6" disabled><img id="locnimg1" src='../../eCommon/images/mandatory.gif' align='center'></img>
	       
		   </td>
		<script>document.getElementById("locnimg1").style.visibility = 'hidden';document.getElementById("locnimg").style.visibility = 'hidden';document.getElementById("facimg").style.visibility = 'visible';</script>
  </tr>
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
    <tr>
	      <td  nowrap class="label"><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></td>
	<td nowrap colspan="2"  class='fields'><input type="text" name="ws_no" id="ws_no" size="32" maxlength="30" onBlur='ChangeUpperCase(this)'onKeyPress="return CheckForSpecChars_1(event)" ></td> <!-- on keypress Method Name Changed against incident Number 30866 on 30-03-2012 by Saanthaakumar-->
	
	
    
  </tr> 

<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr> 
  <tr>
   		<td nowrap class="label"><fmt:message key="eSM.DefaultReportMode.label" bundle="${sm_labels}"/></td>
       		<td nowrap colspan="2"  class='fields'><select name="dflt_report_mode" id="dflt_report_mode" >
 	       	<option value="">------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------
 	       	       	
 	 	 </select>
 	    	<img src='../../eCommon/images/mandatory.gif' align='center'></img>
 	  </td>
  </tr>
 
<tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>

  <tr>
	      <td nowrap class="label"><fmt:message key="eSM.NumberofCopies.label" bundle="${sm_labels}"/></td>
	      <td colspan="2" class='fields'><input type="text" name="no_of_copies" id="no_of_copies" size="2" maxlength="2" value="1"   onBlur="CheckPositiveNumber1(this)" onKeyPress="return ChkNumberInput1(this,event)"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
  </tr>
  <tr>
	<td colspan=3>&nbsp;</td>
  </tr>
</table>

<table name=mainTable1 border="0" cellpadding="0" cellspacing="0" width="95%" align='center'>

		<tr class="black" width="100">
					<th  align='left' colspan='8'><fmt:message key="eSM.PrinterDetails.label" bundle="${sm_labels}"/></th>		
		</tr>
<tr>
	<td colspan=7>&nbsp;</td>
  </tr>

  <tr>
   		<td  nowrap class="label" width='25%'><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>&nbsp;1</td>
       		<td colspan="4"  class='fields'><INPUT TYPE="text" name="printer_id1desc" id="printer_id1desc"   onblur='selectPrinter1(printer_id1desc,printer_id);return makeValidString(this);'  readOnly value='' size=60><input type=button class=button value='?' disabled name='printer1' id='printer1' onClick='selectPrinter(printer_id1desc,printer_id);' ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
         	 <!-- <select name="printer_id" id="printer_id" onChange='disableTime1(this)'>
 	       	<option value="">-------------------------- Select ---------------------------
 	 	 </select> -->
 	    	
			<INPUT TYPE="hidden"   name='printer_id' id='printer_id'>
			</td>
			<td nowrap class='label' ><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="from_time" id="from_time" size="5" onBlur='CheckTime(this)' maxlength="5" >
			</td>
 	 
  </tr>
  <tr>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
	<td>&nbsp;</td>
  </tr>
  <tr>
   		<td nowrap class="label"><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>&nbsp;2</td>
       		<td colspan="4"  class='fields'><INPUT TYPE="text" name="printer_id2desc" id="printer_id2desc" onblur='selectPrinter1(printer_id2desc,printer_id2);return makeValidString(this);' readOnly value='' size=60><input type=button class=button value='?' disabled name='printer2' id='printer2' onClick='selectPrinter(printer_id2desc,printer_id2);' ><!-- <select name="printer_id2" id="printer_id2"  onChange='disableTime2(this)'>
 	       	<option value="">-------------------------- Select ---------------------------
 	 	 </select> -->
		 <INPUT TYPE="hidden"   name='printer_id2' id='printer_id2'>
		 </td>
		 <td class='label' nowrap ><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="from_2time" id="from_2time" readonly size="5" onBlur='CheckTime(this)'		maxlength="5" ></td>
 	 
  </tr>
  <tr>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
	<td>&nbsp;</td>
  	<td>&nbsp;</td>
  	<td>&nbsp;</td>
	<td>&nbsp;</td>
  </tr>
  <tr>
   		<td nowrap class="label"><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>&nbsp;3</td>
       	<td colspan="4" class='fields'><INPUT TYPE="text" name="printer_id3desc" id="printer_id3desc"  onblur='selectPrinter1(printer_id3desc,printer_id3);return makeValidString(this);' readOnly value='' size=60 ><input type=button class=button value='?' disabled name='printer3' id='printer3' onClick='selectPrinter(printer_id3desc,printer_id3);' >

			<!-- <select name="printer_id3" id="printer_id3" onChange='disableTime3(this)'>
 	       	<option value="">-------------------------- Select ---------------------------
 	 		</select> -->
			
			<INPUT TYPE="hidden" name='printer_id3' id='printer_id3' ></td>
			<td class='label' nowrap ><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<input type="text" name="from_3time" id="from_3time" size="5" onBlur='CheckTime(this)' readonly  maxlength="5" >
			</td>

  </tr>
<tr><td colspan=7 class=label>&nbsp;</td></tr>
</table>
<input type="hidden" name="checkval" id="checkval" value="two">
<input type="hidden" name="dst_loc_code" id="dst_loc_code" value="">
<input type="hidden" name="sys" id="sys" value="<%=sdate%>">

<input type="hidden" name="from_time1" id="from_time1" >
<input type="hidden" name="from_time2" id="from_time2" >
<input type="hidden" name="from_time3" id="from_time3" >

<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
<input type='hidden' name='function_name' id='function_name' value='insert'>
	<input type='hidden' name='reportclass' id='reportclass' value=''>
	

<input type="hidden" name="function1" id="function1" value="insert">

<input type="hidden" name="facilityYN" id="facilityYN" value="N">
<input type="hidden" name="login_facility" id="login_facility" value="<%=facilityId%>">


</form>
<%

	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
}catch(Exception e){
	out.println(e);
	e.printStackTrace();
	}

finally { 
	ConnectionManager.returnConnection(con,request);
}
%> 
<!-- Modififcation Against incident number 30866 on 30-03-2012 by Saanthaakumar-->
<Script>
	function CheckForSpecChars_1(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
</script>	
<!-- Modidifcation Over Here-->

</body>
</html>

