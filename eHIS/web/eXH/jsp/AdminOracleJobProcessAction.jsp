<!DOCTYPE html>
<HTML>  
<HEAD> 
<%@ page import= "java.util.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,java.util.HashMap,java.util.Iterator,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eCommon.Common.CommonBean,eXH.*" %>
<!-- ,com.ehis.util.* -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %> 
<%  String locale = ((String)session.getAttribute("LOCALE"));	%> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src='../../eXH/js/AdministerReviewCommunicationProcess1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>  
	 var z=0;										   														  
/** Added for Date Validation **/  						  		   
																	   
 function doDateTimeChk(obj)  
        {


            if(obj.value.indexOf('.') !=-1)
            {
                retval= false
                obj.focus()
            }
            else
            {
                var comp=obj
                obj=obj.value
                var dttime = obj.split(" ");
                var dt
                var time
                var retval=true
                if(dttime.length>1)
                {
                    dt=dttime[0]
                    time=dttime[1]

                    if(!checkDt(dt) )
                    {
                        retval= false
                        comp.focus()
                    }
                    else
                    {
                        if(time==null || time=="")
                        {
                            //alert(getMessage("INVALID_DATE_TIME"))
                            retval= false;
                            comp.focus()
                        }

                        else
                        {							    
                            if(!chkTime(time))
                            {
                                    retval= false
                                    //alert(getMessage("INVALID_DATE_TIME"))
                                    comp.focus()
                            }
                        }
                    }
                }
                else
                {
                    retval= false
                    //alert(getMessage("INVALID_DATE_TIME"))
                    comp.focus()
                }

                if(retval)
                {
                    //callDateFunction(comp)
                }
            }
            return retval
        }
function CheckForSpecCharsforID(event,obj){
	
     if(obj.value.indexOf('.')==-1)
	{
		       z=0;
    }
		 
		var strCheck = '0123456789.';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
			 if(key=='.')
			{
				   if(z>0)
				{
				  return false; 
				}
			   z++;

			}
		 if (strCheck.indexOf(key) == -1)
	{
			 return false;  // Not a valid key
	}
	
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}
	

		
		
		function ValidateDateTimesp(obj)
		{
			if(!(obj.value==""))
			{
				if(!doDateTimeChk(obj)){
			//		alert('it is wrong.');
			var datemessage=getMessage('INVALID_VALUE','Common').replace('#','date time format')
			
					alert(datemessage);
				}
				else{
			//		alert("else");									 
					Checkcurrdate(obj);
				}
				/*if(validDateObj(obj,"DMYHM",localeName))
				{																  	  
					if(!(isAfterNow(obj.value,"DMYHM",localeName)))
					 {
						obj.focus();
						obj.select();
						obj.value='';
						//alert(getMessage('DT_NLT_CURR_DT','SM'));
						alert(getMessage('DT_NLT_CURR_DT'));
					  }
				}*/
			 }
		}



function Checkcurrdate(from) {
	var fromarray; var toarray;
	var fromdate = from.value ;
//	alert("fromdate : "+fromdate);
	var d =  new Date(); 
//	alert("d : "+d);
	if(fromdate.length > 0 ) {
																								     
			fromarray = fromdate.split("/");
//			alert("fromarray : "+fromarray); 
			var year =  fromarray[2].split(" ");
         var hourmins=year[1].split(":");

//			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var fromdt = new Date(year[0],fromarray[1],fromarray[0],hourmins[0],hourmins[1]);			
		
			var todt = new Date(d.getYear(),d.getMonth() + 1,d.getDate(),d.getHours(),d.getMinutes());	
//			alert("todt : "+todt);
			if(Date.parse(todt) > Date.parse(fromdt)) {
//			alert(getMessage('XH1010'));

			alert(getMessage('XH0073','XH'));
				from.focus();
				return false;
			}
			else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
	}	
return true;
}

function CheckInterval(obj)
		{	
		if(obj.value!='.')
		{
          if(document.forms[0].process_id.value == "XHPURGE"){
	  if(obj.value<1440){

		  msg=getMessage('XH0078','XH'); 
				msg=msg.replace('$','Purge Interval');
				msg=msg.replace('#','1440');
				alert(msg);
//		  alert("Interval Should be > 0 ");
// 		  alert(getMessage('XH0056','XH'));
 		
		  //intervslObj.value = "1"; 
	  	  obj.focus();
	  }
  }
			else
			{
			if(obj.value!="")
			{
			if(obj.value>0)
				CheckPositiveNumber(obj);
			else
			{
				//alert(getMessage('ONLY_POSITIVE_NUM','SM'));
				alert(getMessage('VALUE_SHOULD_BE_GR_ZERO','Common'));
				obj.select();
				obj.focus();
			}
			}
			}
		}
		else
		{
          alert(getMessage('XH1026','XH'));
		}
		
}

function chkPurgeIntrvl(intervslObj){
//	alert("chkPurgeIntrvl");
//	alert("Proc_id : "+document.forms[0].process_id.value);
 
}

function clearProcess(){
	document.forms[0].process_id.value = "";
	document.forms[0].process.value = "";
	document.forms[0].interval.value = "";
	document.getElementById("application_disp").style.display='none';
	document.getElementById("msgstatus_disp").style.display='none';
	document.getElementById("module_disp").style.display='none';
//	document.getElementById("commtype_disp").style.display='none';
	document.getElementById("protocolLink_disp").style.display='none';
	document.getElementById("eventtype_disp").style.display='none';
	document.getElementById("OracleTblProc_disp").style.display='none';
	document.getElementById("modl_disp").style.display='none';		
	document.getElementById("resp_inc_disp").style.display='none';
	document.getElementById("facility_disp").style.display='none';
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

</script>
</HEAD>
	  
<body  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%

	   
//		System.out.println("AdminOracleJobProcessAction module_id : "+mainModule_id);

	   String process_id = "";
	   String process = "";
	   String application_id = "";
	   String appl_name = "";
       String module_Id = "";				    
	   String module_Name = "";
       String protocol_link_id = "";
	   String protocol_linkName = "";
	   String default_date = "";
	   String job = "";
	   String processID="";
	   String facility_id = "";
	   String facility_name = "";
	   String functionID = request.getParameter("functionID") ;					 		 
	   String mainModule_id	= request.getParameter("module_id") ;								  
//	   System.out.println("AdminOracleJobProcessAction.jsp functionID : "+functionID);
//	   System.out.println("AdminOracleJobProcessAction.jsp mainModule_id : "+mainModule_id);

	   String event_type_id1 = "";
	   String sess_facilityId = (String) session.getAttribute("facility_id") == null ? "" : (String) session.getAttribute("facility_id");
   %>																				  


<form name="AdminOracleJobProcessActionForm" id="AdminOracleJobProcessActionForm" id="frmid"  method="get" action="../../servlet/eXH.XHAdminOracleJobProcessServlet">

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>										 

<tr>
   <td> </td>	   <td> </td>    <td> </td>
   <td>
<!--    <fmt:message key="Common.Refresh.label" bundle="${common_labels}"/> -->
		<input class="button" type="button"   name="refresh" id="refresh" value=<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")%> onClick="reloadJobQueueFrame();">
   </td>
</tr>

<tr>
<!-- <fmt:message key="Common.ProcessDetails.label" bundle="${common_labels}"/> -->
<th class='COLUMNHEADER' colspan=4 ><fmt:message key="Common.ProcessDetails.label" bundle="${common_labels}"/></th>
</tr>


	<input type=hidden name='comm_type1' id='comm_type1' >


<!--
<tr>
<!--<td class=label><fmt:message key="eXH.CommunicationType.Label" bundle="${common_labels}"/> </td> -->
<!--<fmt:message key="eXH.ProcessGroup.Label" bundle="${xh_labels}"/>
<td class=label>Process Group</td> 
<td class='fields'>
<!--	<select name='comm_type1' id='comm_type1'  title='Communication Type' onchange='clearProcess();'> -->

<!-- 		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value='I'><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></option> 
		<option value='O'><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></option> 
		<option value='IO'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
		<option value='Q'><fmt:message key="Common.query.label" bundle="${common_labels}"/></option>
		<option value='R'><fmt:message key="eXH.replication.Label" bundle="${xh_labels}"/></option>
		<option value='5.1'><fmt:message key="eXH.V5-1.Label" bundle="${xh_labels}"/></option> -->
<!--
	<select name='comm_type1' id='comm_type1'  title='Process Group' onchange='clearProcess();'>
		<option value=''>-----------select---------</option>
		<option value='I'>Inbound</option> 
		<option value='O'>Outbound</option> 
		<option value='IO'>Both</option>
		<option value='Q'>Query</option>
		<option value='R'>Replication</option>
		<option value='5.1'>V5-1</option>
	</select>
</td>
<td colspan=2> </td>
</tr>
-->
<tr>
<!-- <fmt:message key="Common.Process.label" bundle="${common_labels}"/> -->
<td class=label ><fmt:message key="Common.Process.label" bundle="${common_labels}"/></td>
<td align=left>
<input type=hidden id="process_id"  name='process_id' id='process_id' value='<%=process_id%>' size=15 >
<input type=text id="process"  name="process" id="process" value='<%=process%>' size=35 onBlur="searchProcess('<%=mainModule_id%>');"> <input  type="button" class="button" name=ProcessSearch value='?'    onClick="searchProcess('<%=mainModule_id%>');"> <img src='../../eCommon/images/mandatory.gif' align=middle>
</td>

	<%!String proc_srt_cmd[];%>

	<%
			HashMap procIdCmnd = new HashMap();

/* cmmntd on jan 9th - displaying proc_ids based on module(XH/XI)
		String SQL1 = "";

        if(mainModule_id.equals("XH")){
//			SQL1="SELECT proc_id,proc_srt_cmd FROM sy_proc_id where proc_id like 'X%' ORDER BY 1 ";
			SQL1="   SELECT proc_id,proc_srt_cmd FROM sy_proc_id where controllable_yn='N' ORDER BY 1 ";

		}
        else if(mainModule_id.equals("XI")){
			SQL1="SELECT proc_id,proc_srt_cmd FROM sy_proc_id WHERE PROC_ID IN('XHGNCRTR','XHGENMESSAGEBUILDER','XHORATABPRC','XIQTYUPD') ORDER BY 1 ";
		}

*/  
        Connection con = null;
		Statement stmt1 = null;
		ResultSet rst1    = null;
        String central_yn = "";

	try{		
			con = ConnectionManager.getConnection(request);
			stmt1 = con.createStatement();
			String SQL1="SELECT CENTRAL_YN FROM SM_FACILITY WHERE FACILITY_ID = '"+sess_facilityId+"' ";
			rst1=stmt1.executeQuery(SQL1);
		
			while(rst1.next()){
				central_yn = rst1.getString(1);
			}
//			System.out.println("central_yn : "+central_yn);
	}catch(Exception e){
			System.err.println("Err Msg in AdminOracleJobProcessAction.jsp : "+e);
	}finally{
			if(rst1!=null)rst1.close();
			if(stmt1!=null)stmt1.close();			
			ConnectionManager.returnConnection(con);
	}
	
   %>

	<td></td><td></td>
		
</tr>
 
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>

</table>


<!-- cmmntd on jan 9th
<div id='commtype_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
<td class=label><fmt:message key="eXH.CommunicationType.Label" bundle="${xh_labels}"/> </td>
<td class='fields'>
	<select name=comm_type  title='Communication Type'>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value='I'><fmt:message key="eXH.Inbound.Label" bundle="${xh_labels}"/></option> 
		<option value='O'><fmt:message key="eXH.Outbound.Label" bundle="${xh_labels}"/></option> 
	</select>
</td>
<td colspan=2> </td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td> 
	<td width='20%'></td>
</tr>
</table>
</div>
-->

<div id='protocolLink_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<!-- Commented on Feb 23rd to provide an option to submit jobs with Multiple Gateways 
<tr>
	<td class=label ><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td>
	<td align=left>
	<input type="hidden" id="protocol_link_id" name="protocol_link_id" id="protocol_link_id" value="<%=protocol_link_id%>" size=15  >
	<input type=text id="protocol_link_name"  name ='protocol_linkName' size=35 value='<%=protocol_linkName%>'  onBlur='searchProtocolLink();'> <input type="button" class="button" name=protocolLinkSearch value='?'    onClick='searchProtocolLink(process_id);'>
	 <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td colspan=2> </td> 
</tr>	 -->

<tr>
	<td class=label ><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td> 
	<td align=left>
	<input type="hidden" id="protocol_link_id" name="protocol_link_id" id="protocol_link_id" value="<%=protocol_link_id%>" size=15  >
	<input type="text" id="protocol_linkName"  name ='protocol_linkName' size=35 value='<%=protocol_linkName%>'> <input type="button" class="button" name="protocolLinkSearch" id="protocolLinkSearch" value='?'  onClick='searchProtocolLinkList();'>
	 <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td colspan=2> </td>
</tr>
												    
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td> 
	<td width='20%'></td>
</tr>																 
</table>
</div>

<div id='application_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
<!-- <fmt:message key="Common.Application.label" bundle="${common_labels}"/> -->
<td class=label ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td align=left>
<!-- <%=application_id%>  <%=appl_name%> -->
<input type=hidden id="application_id"  name ='application_id'  size=15 >
<input type=text id="appl_name"  name ='appl_name'  size=35 onBlur="searchApplication();"> <input  type="button" class="button"  name=ApplicationSearch value='?'    onClick="searchApplication();">
<td> </td><td> </td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>

<div id='msgstatus_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
<!-- <fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/> -->
<td class=label><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/></td> 
<td class='fields'>
	<select name=msg_status  title='Message Status'>
		<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
		<option value='C'><fmt:message key="eXH.Communicated.Label" bundle="${xh_labels}"/></option> 
		<option value='N'><fmt:message key="eXH.NonCommunicated.Label" bundle="${xh_labels}"/></option> 
		
	</select>
</td>
<td colspan=2> </td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>

 <div id='modl_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
	<td class=label ><fmt:message key="eXH.InterfaceDomain.Label" bundle="${xh_labels}"/></td>
	<td align=left>
		<input type="hidden" id="mod_id" name="mod_id" id="mod_id" value="" readOnly size=15>
		<input type="text" name="mod_name" id="mod_name" readOnly size=35 >
	</td>
	<td colspan=2> </td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>


<div id='module_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
	<td class=label ><fmt:message key="eXH.InterfaceDomain.Label" bundle="${xh_labels}"/></td>
	<td align=left>
	<input type="hidden" id="module_Id" name="module_Id" id="module_Id" value="<%=module_Id%>" size=15  >
	<input type=text id="module_Name"  name ='module_Name' size=35 value='<%=module_Name%>' onBlur='searchModuleName();'> <input  type="button" class="button" name=moduleNameSearch value='?'    onClick='searchModuleName();'>
   <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td colspan=2> </td>
</tr>	

<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>

<div id='eventtype_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
<td class=label ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
<td align=left  colspan=2>
	<input type="hidden" id="event_type_id1" name="event_type_id1" id="event_type_id1" value="<%=event_type_id1%>" size=15  >
	<input type=text id="event_type_id"  name ='event_type_id' size=80 readOnly> <input  type="button" class="button" name=eventNameSearch value='?'    onClick='searchEventName();'> <img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td > </td>
<!-- <input type="text" name="event_type_id" id="event_type_id" readOnly size=35 >
</td>
<td> </td><td> </td>  --> 
</tr>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>

<div id='OracleTblProc_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>

<!--
<tr>
<td class=label ><fmt:message key="eXH.SubDomain.Label" bundle="${xh_labels}"/></td>
<td align=left>
<input type="hidden" id="OTmodule_id" name="OTmodule_id" id="OTmodule_id" value="" readOnly size=15 >
<input type="text" name="OTmodule_name" id="OTmodule_name" readOnly size=25 >
</td>
<td colspan=2> </td></tr>

<tr>
<td class=label ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td align=left>
<input type="hidden" id="OTapplcation_id" name="OTapplcation_id" id="OTapplcation_id" value="" readOnly size=15 >
<input type="text" name="OTapplcation_name" id="OTapplcation_name" readOnly size=25 >

</td>
<td colspan=2> </td></tr>
-->
<tr>
<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
<td align=left>
<input type="hidden" id="OTfacility_id" name="OTfacility_id" id="OTfacility_id" value="" readOnly size=15>
<input type="text" name="OTfacility_name" id="OTfacility_name" readOnly size=35 value="">

</td>
<td colspan=2> </td></tr>

<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>

<div id='facility_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
	<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td align=left>
	<input type="hidden" id="facility_id" name="facility_id" id="facility_id" value="<%=facility_id%>" size=15  >
	<input type=text id="facility_name"  name ='facility_name' size=35 value='<%=facility_name%>' onBlur='searchFacility();'> <input type="button" class="button" name="facilityNameSearch" id="facilityNameSearch" value='?'    onClick='searchFacility();'>
	</td>
	<td colspan=2> </td>
</tr>	

<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>

<div id='resp_inc_disp' style='display:none'>
<table cellspacing=0 cellpadding=3 width='100%' align=center border=0>
<tr>
<td class=label><fmt:message key="eXH.ResponseInc.Label" bundle="${xh_labels}"/></td> 
<td class='fields'>
	<select name='resp_inc' id='resp_inc'  title='Response Increment Option'>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value='SI'><fmt:message key="eXH.SITEINC.Label" bundle="${xh_labels}"/></option> 
		<option value='FI'><fmt:message key="eXH.FACBASED.Label" bundle="${xh_labels}"/></option> 
		<option value='*A'><fmt:message key="eXH.ALLAPPL.Label" bundle="${xh_labels}"/>/option>
	</select>
</td>
<td colspan=2> </td>
</tr>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
</div>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<!--
	<td class=label ><fmt:message key="eXH.NextProcessDateTime.Label" bundle="${xh_labels}"/></td>
	<td class='fields' ><input type=text size=15 maxlength="12"  value='<%=default_date%>' name=proc_date onBlur='CheckDate(this);setNextProcTime(this);' > <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif'  onClick="return showCalendar('proc_date','dd/mm/y');"  > <img src='../../eCommon/images/mandatory.gif' align=middle>
-->
	<td class=label ><fmt:message key="eXH.NextProcessDateTime.Label" bundle="${xh_labels}"/></td>
	<td class="fields"><input type=text id='backgnd' name=proc_date value='<%=default_date%>'  onblur='ValidateDateTimesp(this)' size=16 maxlength=16> <input type="image" name=showcalndr id="showcalndr"  src="../../eCommon/images/CommonCalendar.gif" onClick=" return showCalendar('backgnd',null,'hh:mm')"> 
    <img src='../../eCommon/images/mandatory.gif'></img>
   </td>

	<td  class=label><fmt:message key="Common.Interval(min).label" bundle="${common_labels}"/>
	<!--		<input type=text size=3 onBlur="CheckPositiveNumber(this);chkPurgeIntrvl(this);" value="0" maxlength="2" name=interval> -->
		<input type=text name=interval  size=9 maxlength=9 
		onKeyPress='return CheckForSpecCharsforID(event,document.forms[0].interval);' onblur='CheckInterval(this);'>
		<img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td>  
</tr>
<tr>
	<td width='20%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table>
<table cellspacing=0 cellpadding=3 width='100%' border=0 align=center>
<tr><td colspan="6"></td></tr>

<tr>																	 
   <td  colspan=6>
	<input class="button" type="button"  name='submit' id='submit' value='<fmt:message key="Common.Submit.label" bundle="${common_labels}"/>' onClick="submitForm(this);">
	<input class="button" type="button"  name="change" id="change" disabled value='<fmt:message key="Common.change.label" bundle="${common_labels}"/>'  onClick="submitForm(this);">
	<input class="button" type="button"  name="run" id="run" disabled value='<fmt:message key="Common.run.label" bundle="${common_labels}"/>'		   onClick="submitForm(this);">
	<input class="button" type="button"  name="remove" id="remove" disabled value='<fmt:message key="Common.Remove.label" bundle="${common_labels}"/>'  onClick="submitForm(this);">
<!--	<input class="button" type="button"  name="cancel" id="cancel" disabled value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onClick="parent.frames[2].location.reload();"> -->
	<input class="button" type="submit"  name="ove" id="ove" disabled style='display:none' value='Move' > 
	
   </td>
</tr>
</table>
<input TYPE="hidden"  name ="action" value="">
<input TYPE="hidden"  name ="internal_job" value="">	

<!-- <input TYPE="hidden"  name ="facility_id" value="*A"> -->
<!-- <input TYPE="hidden"  name ="what" value="">-->
<input TYPE="hidden"  name ="wht1" value=''>
<input TYPE="hidden"  name ="wht2" value=''>
<input TYPE="hidden"  name ="job" value="<%=job%>">
<input TYPE="hidden"  name ="processID" value="<%=processID%>">
<input TYPE="hidden"  name ="job1" value=''>
<input TYPE="hidden"  name ="disabled" value="" > 
<input TYPE="hidden"  name ="param" value="" >
<input TYPE="hidden"  name ="comm_type" value="" >
<input TYPE="hidden"  name ="comm_mode" value="" >
<input TYPE="hidden"  name ="sess_facilityId" value="<%=sess_facilityId%>" >
<input TYPE="hidden"  name ="central_yn" value="<%=central_yn%>" >
<input TYPE="hidden"  name ="functionID" value="<%=functionID%>" >
<input TYPE="hidden"  name ="mainModule_id" value="<%=mainModule_id%>" >

 <input type='hidden' name='locale' id='locale'  value='<%=locale%>'> 
<!-- cmmntd on jan 9th
<select name="hidden_proc_srt_cmd" id="hidden_proc_srt_cmd" style='display:none'>
   
   <%
   		 for (Iterator it = procIdCmnd.keySet().iterator(); it.hasNext();) { 
					String type = (String) it.next();
				//		System.out.println("VldtQry App Id : "+type);
					String desc=	(String)procIdCmnd.get(type);
					%>
					 <option value='<%=type%>'>  <%=desc%> </option>
	<% }  %>
</select>
-->

</form>
</body>
</html>

