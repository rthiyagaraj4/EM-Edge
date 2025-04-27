<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>

<%@ page  import="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,,eXH.XHReturnArray,java.util.*,webbeans.eCommon.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>	
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<% 
Connection con=null;
String applsql=null; 
ResultSet applrs=null;
ResultSet facilityres=null; 
Statement applstmt=null;   
Statement eventstmt=null;
ResultSet result=null;
Statement stmt=null;   
XHReturnArray arr=new XHReturnArray(); 
String interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));
String queryFacility="";
String qmsg_dt1 = XHDBAdapter.checkNull(request.getParameter("qmsg_dt1"));
String qmsg_dt2 = XHDBAdapter.checkNull(request.getParameter("qmsg_dt2"));
String applicationId=XHDBAdapter.checkNull(request.getParameter("qapplname"));
//String eventtype=XHDBAdapter.checkNull(request.getParameter("eventtype"));

  String qapplname=XHDBAdapter.checkNull(request.getParameter("qapplname")); 
  System.out.println("inside VQMH line 34 qapplname "+ qapplname);
  String qfacility=XHDBAdapter.checkNull(request.getParameter("qfacility"));
  String qstatus=XHDBAdapter.checkNull(request.getParameter("qstatus")); 
  String qry_id1=XHDBAdapter.checkNull(request.getParameter("qry_id1"));
  String qry_id2=XHDBAdapter.checkNull(request.getParameter("qry_id2"));
  String  eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));
  String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));

  String moduleListQuery	= "SELECT interface_module_id,interface_desc FROM xh_interface WHERE module_id=";
 // String qmsg_id1=XHDBAdapter.checkNull(request.getParameter("qmsg_id1"));
  //String qmsg_id2=XHDBAdapter.checkNull(request.getParameter("qmsg_id2"));
  String purge_status=XHDBAdapter.checkNull(request.getParameter("purge_status"));
  String msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
String isFromEditQuery = XHDBAdapter.checkNull(request.getParameter("editQuery"));
String queryEventType	= "SELECT DISTINCT me.EVENT_TYPE , me.EVENT_NAME FROM xh_application_event_type M,XH_EVENT_TYPE_LANG_VW me WHERE me.LANGUAGE_ID='en' AND M.APPLICATION_ID = NVL('"+applicationId+"',M.APPLICATION_ID) AND m.event_TYPE = ME.EVENT_TYPE and SOLICITED_YN='Y'";
 moduleListQuery	= "SELECT interface_module_id,interface_desc FROM xh_interface WHERE module_id="; 
queryFacility			= "SELECT DISTINCT A.FACILITY_ID code, s.facility_name name FROM XH_DATA_GROUP_DETAIL a, sm_facility_param_lang_vw s  WHERE s.LANGUAGE_ID='en' AND a.facility_id = s.facility_id AND a.application_id = NVL('"+applicationId+"', application_id) "; 



if(!("Y".equals(isFromEditQuery))) 
{
	qmsg_dt1 = qmsg_dt2 = DateUtils.getCurrentDate("DMY",locale);
	if(sub_module.equals("") || sub_module==null)
	{
 	  sub_module="XH";
	}
	
}




String string[][]=null;
//String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
String Sysdate=new Date().getDate()+""+new Date().getMonth()+""+new Date().getYear();
try
{ 
  con=ConnectionManager.getConnection();
  applsql="SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW where LANGUAGE_ID='en'  ";
  applstmt=con.createStatement();
  applrs=applstmt.executeQuery(applsql);
	
}catch(Exception e1)
{
	System.out.println("(ERROR:ViewQryMsgHeader.jsp) :"+e1.toString());
}
%>

<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/ViewQuerymessages.js'></script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<!--<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>--->

<script language="javascript" src="../../eXH/js/XHAjaxUtil.js"></script>
<script language="JavaScript">
//function setValues
function changeProtocolVal()
{
	document.getElementById("protocol_link_id").value=document.getElementById("protocol_link_name").value;
}
function CheckForSpecCharsforID(event){
		var strCheck = '0123456789';
		 var whichCode = (window.Event) ? event.which : event.keyCode;
		 key = String.fromCharCode(whichCode);  // Get key value from key code
		 if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
	}

function checkcurrdate(dates) 
{				
	var fromarray;
	var toarray; 
	var date = dates.value;
	var d =  new Date(); 
	fromarray =date.split("/");
	var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
	var todt = new Date(d.getYear(),d.getMonth() + 1,d.getDate());	

	if(date.length > 0 )
	{
		if(dates.name=='msg_dt1')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{
				alert(getMessage("XH1010",'XH'));
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	

		if(dates.name=='msg_dt2')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{
				alert(getMessage("XH1010","XH"));
				return false;
			}
			else 
				if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	
		if(dates.name=='msg_date')
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{
				alert(getMessage("XH1010","XH"));
				return false;
			}
			else 
				if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}	
		else
		{
			if(Date.parse(todt) < Date.parse(fromdt))
			{
				alert(getMessage("XH1010","XH"));
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
			{
				return true;
			}
		}
	}
	else return true;			
}

//**********************************************COMPARE DATE*********************************************
   function compare(date1,date2) 
	{
		var fromarray;
 		var toarray;
 		var frmdat = date1.value;
		var todat=date2.value;
		var d =  new Date(); 
		fromarray =frmdat.split("/");
		toarray=todat.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);	
     
	
		 if((frmdat.length > 0) &&(todat.length>0))
		 {
			if(Date.parse(todt) < Date.parse(fromdt))
			{
				alert(getMessage("XH1009","XH"));
				return false;
			}
			else 
				if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		 }	
		 else return true;
		      
			
       }
 
async function searchProtocolID(){     		
			var tdesc="";
            var tcode="";
			var appID=document.getElementById("qapplname").value;
			var commMode=document.getElementById("qostatus").value;
	
			
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit=getLabel("eXH.Gateway.Label","XH");
				//getLabel("eXH.Gateway.Label",'XH');
            var target=this.document.forms[0].protocol_link_name;
			var id=this.document.forms[0].protocol_link_id;
            sql="select distinct A.PROTOCOL_LINK_ID code,B.PROTOCOL_LINK_NAME description from XH_APPLICATION_QUERY A,XH_PROTOCOL_LINK B where A.PROTOCOL_LINK_ID=B.PROTOCOL_LINK_ID AND UPPER(A.PROTOCOL_LINK_ID) LIKE UPPER(?) AND UPPER(B.PROTOCOL_LINK_NAME) LIKE UPPER(?)  ";
			//AND PROTOCOL_ID IN (SELECT PROTOCOL_ID FROM xh_protocol WHERE PROTCOL_MODE='"+commMode+"') ";
          /*  sql="SELECT PROTOCOL_LINK_ID code,PROTOCOL_LINK_NAME description FROM XH_APPLICATION_QUERY "+
                    "   WHERE UPPER(PROTOCOL_LINK_ID) LIKE UPPER(?) AND "+ 
                    "   UPPER(PROTOCOL_LINK_NAME) LIKE UPPER(?) AND "+
					"	PROTOCOL_ID IN (SELECT PROTOCOL_ID FROM xh_protocol WHERE PROTCOL_MODE='"+commMode+"') ";*/
			if(appID != "") 
			{   
				sql=sql+" AND application_id ='"+appID+"'";
			}
			sql=sql+" ORDER BY 1";
			
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = "2"  ;
            argumentArray[7] = "DESC_CODE" ;
         
            retVal = await CommonLookup( tit, argumentArray );			
            
			var ret1=unescape(retVal);
			arr=ret1.split(","); 
			id.value=arr[0];
			
			if(arr[1] == undefined)	target.value="";
			else target.value=arr[1];            
}// End of searchProtocolLink
 
function displaybutton()
{ 

	if(document.forms[0].qostatus.value=='P')
	{
	 document.view_query_msgheasder_form.qstatus.options[0]=new Option(getLabel("Common.all.label","common"),"",  true, false)
	document.view_query_msgheasder_form.qstatus.options[1]=new Option(getLabel("Common.received.label","common")," ",false, false)
	document.view_query_msgheasder_form.qstatus.options[2]=new Option(getLabel("Common.Response.label","common")+" "+getLabel("eXH.Processed.Label","XH"),"S",  false, false)  
	document.view_query_msgheasder_form.qstatus.options[3]=new Option(getLabel("Common.Rejected.label","common"),"R", false, false)
	document.view_query_msgheasder_form.qstatus.options[4]=new Option(getLabel("eXH.ProcessingError.Label","XH"),"E", false, false)
			}
	else if(document.forms[0].qostatus.value=='A') 
	{
		document.view_query_msgheasder_form.qstatus.options[0]=new Option(getLabel("Common.all.label","common"),"",  true, false)
		document.view_query_msgheasder_form.qstatus.options[1]=new Option(getLabel("eXH.ProcessingPending.Label","XH"),"P",false,false)
		document.view_query_msgheasder_form.qstatus.options[2]=new Option(getLabel("eXH.TransmissionSuccessful.Label","XH"),"T", false,false)
		document.view_query_msgheasder_form.qstatus.options[3]=new Option(getLabel("eXH.LoadingSuccessful.Label","XH"),"L",false,false)
		document.view_query_msgheasder_form.qstatus.options[4]=new Option(getLabel("eXH.TransmissionError.Label","XH"),"E", false,false)
		document.view_query_msgheasder_form.qstatus.options[5]=new Option(getLabel("eXH.TransmissionPending.Label","XH"),"N",  false, false)
 
	}
	else
   {  
		
	    document.view_query_msgheasder_form.qstatus.options[0]=new Option(getLabel("Common.all.label","common"),"",  true, false)
		document.view_query_msgheasder_form.qstatus.options[1]=new Option(getLabel("Common.received.label","common")," ",false, false)
		document.view_query_msgheasder_form.qstatus.options[2]=new Option(getLabel("Common.Response.label","common")+" "+getLabel("eXH.Processed.Label","XH"),"S",  false, false)  
		document.view_query_msgheasder_form.qstatus.options[3]=new Option(getLabel("Common.Rejected.label","common"),"R", false, false)
		document.view_query_msgheasder_form.qstatus.options[4]=new Option(getLabel("eXH.ProcessingError.Label","XH"),"E", false, false)
  }
}
function setValues()
{
	console.log(document.getElementById("qapplname"));
	var select_boxf=document.getElementById("qfacility");
	var select_boxa=document.getElementById("qapplname");
	var select_boxs=document.getElementById("qstatus");
	var optn=new Array();
    <%
	
	// qmsg_dt1=request.getParameter("qmsg_dt1");
	// qmsg_dt2=request.getParameter("qmsg_dt2");
	//String qstatus=request.getParameter("qstatus");
	if(qapplname==null) qapplname=""; 
	%>  
	for( var j=0;j<select_boxa.options.length;j++)
	{
	   if(select_boxa.options[j].value =='<%=qapplname%>')
       select_boxa.options[j].selected=true; 
	}
	//removeAllOptions(select_boxf);
    <% 
	  string=arr.returnFacilityQueryArray(con,qapplname,locale);
	if(string==null)
	{
	}
	else
	{
	  for(int i=0;i<string.length;i++)
	  {
	%>
   	 optn[<%=i%>] = document.createElement("OPTION");
	 optn[<%=i%>].text ='<%=string[i][0]%>';
	 optn[<%=i%>].value ='<%=string[i][1]%>';
	 select_boxf.options.add(optn[<%=i%>]);
	<%	
	}
	}
	if(qmsg_dt1==null) qmsg_dt1="";
	if(qmsg_dt2==null) qmsg_dt2="";
	if(qstatus==null) qstatus="";
	%> 
	for( var j=0;j<select_boxs.options.length;j++)
	{ 
	 if(select_boxs.options[j].value =='<%=qstatus%>')
     select_boxs.options[j].selected=true;
	}
	//this.document.forms[0].qmsg_dt1.value='<%=qmsg_dt1%>';
///	this.document.forms[0].qmsg_dt2.value='<%=qmsg_dt2%>';
	
}
//function removeAllOptions
function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=1;i--)
	{
	selectbox.remove(i);
	}
}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="setValues()">
<form name="view_query_msgheasder_form" id="view_query_msgheasder_form" method="post">
<input  type="hidden" name="sortMode" id="sortMode" value='A' />
<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="1"/>
<input type="hidden" name="action_type" id="action_type" value='0'/>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr>
	   <td>
		<fieldset style=" border-color:black;"  ><legend style="color: black;"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></legend>
			<table cellspacing=0 cellpadding=3 width='100%' align=center>
			<tr>
				<td class=label ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text size=12 maxlength="12" id="qmsg_dt1" value='<%=qmsg_dt1%>' align="center"  name='qmsg_dt1' onBlur='CheckDate(this);sysDateCheck(sysdate,this);validate_date(this,"TO_DATE_LESS_FROM")' >
					<input type="image" name=showcalndr id="showcalndr" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('qmsg_dt1','dd/mm/y');">
			
			</tr>
			<tr>
				<td class=label ><fmt:message key="eXH.QueryID.Label" bundle="${xh_labels}"/></td>
				<td class='fields'><input type=text name="qry_id1" id="qry_id1" size=25 value='<%=qry_id1%>' onKeyPress='return CheckForSpecCharsforID(event);'></td>
			</tr>
			<%---<tr>
				<td class=label>External Acc No</td>				
				<td class='fields' colspan=1><INPUT TYPE="text" name="qmsg_id1" id="qmsg_id1" ID="qmsg_id1" maxlength="300"  size=25 value='<%=qmsg_id1%>' onKeyPress='return CheckForSpecCharsforID(event);'></td>  
			</tr>---%>
			</table>	
		   </fieldset>
      </td>
	   <td>
		<fieldset style=" border-color:black;"><legend style="color: black;"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></legend>		
			<table cellspacing=0 cellpadding=3 width='100%' align=center>
				<tr>
				<td class=label ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<input type=text size=12 maxlength="12"  value='<%=qmsg_dt2%>' id="qmsg_dt2" name=qmsg_dt2  onBlur="CheckDate(this);sysDateCheck(sysdate,this);validate_date(this,'TO_DATE_LESS_FROM')" 
					 align="center">
	        	<!---<input type='image' src='../../eCommon/images/CommonCalendar.gif'  onClick="return showCalendar('qmsg_dt2','dd/mm/y');">--->
					<input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('qmsg_dt2','dd/mm/y');">
				</td>				
				</tr>

				<tr>
				<td class=label ><fmt:message key="eXH.QueryID.Label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				<input type=text name="qry_id2" id="qry_id2"   size=25 value='<%=qry_id2%>' onKeyPress='return CheckForSpecCharsforID(event);'>
				</td>
				</tr>

				<%----<tr>
				<td class=label>External Acc No</td>				
				<td class='fields' colspan=1><INPUT TYPE="text" name="qmsg_id2" id="qmsg_id2" ID="qmsg_id2" maxlength="300" value='<%=qmsg_id2%>' onKeyPress='return CheckForSpecCharsforID(event);' size=25></td> 
				</tr>---%>
			</table>	
	    </fieldset> 
		</td>
		</tr> 
</table> 
<table cellspacing=0 cellpadding=3 width='101%' align=center>
<tr>
	<td class=label ><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name="qapplname" id="qapplname" id="qapplname" onchange='populateAction(this);' style="width:175">
	<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<%
	try
	{ 
           

		while(applrs.next())
		{ 
			if(qapplname.equalsIgnoreCase(applrs.getString(1).toString().trim()))
			{
				%>

				<option value='<%=applrs.getString(1)%>' selected><%=applrs.getString(2)%></option>
<%
			}
				else
			{
			%>	
			<option value='<%=applrs.getString(1)%>'><%=applrs.getString(2)%></option>
			<%	}
		}
		%>
	</select></td>
	<%
	}catch(Exception e1)
	{ 
	  System.out.println("Error in calling getconnection method of dooperate method of ViewQryMsgHeader.jsp:"+e1.toString());
	  e1.printStackTrace(System.err);
    }
	finally
	{
		try{
				if(applrs!=null)applrs.close();
				if(applstmt!=null)applstmt.close();
			
		   }
		   catch(Exception e)
	  	   {
				System.out.println("Error in calling getconnection method of dooperate method of ViewQryMsgHeader.jsp:"+e.toString());
	            e.printStackTrace(System.err);
		   }
	}//end of finally block
%>
<td class=label><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<select name="eventtype" id="eventtype" id="eventtype" onchange='populateAction(this);' style="width:175">
		<option value = ''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<% 
				try
				{  
					String tempEventType = "";
		
					// Check to populate list item Interactive
				   eventstmt=con.createStatement();
						
					result=eventstmt.executeQuery(queryEventType);
					while(result.next())
					{
						tempEventType = result.getString(1);
						if(!eventtype.equals("") && eventtype.equalsIgnoreCase(tempEventType))
						{
			 %>
				<option value='<%=tempEventType%>' selected><%=result.getString(2)%></option> 
			 <%
						}
			            else
						{
						%>
                       <option value='<%=tempEventType%>' ><%=result.getString(2)%></option> 
                  <%

					} 
					}
					if(result!=null) result.close();
					if(eventstmt!=null) eventstmt.close();
			 %>			
			 <%
				} 
				catch(Exception e1)
				{					
					e1.printStackTrace(System.err);
					System.out.println("(ViewEventsOutboundHeader.jsp:Exception-3) "+e1.toString());
				}
			 %>
			</select> 
			</td>
			
			<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name ="qfacility" id="qfacility" style="width:175" >
	<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<% 
	try
	{  
 						    stmt=con.createStatement();
						    facilityres=stmt.executeQuery(queryFacility);
							while(facilityres.next())
							{ 

								
							if(!qfacility.equals("") && qfacility.equalsIgnoreCase(facilityres.getString(1).toString().trim()))
						 {
					%>
								<option value='<%=facilityres.getString(1)%>' selected><%=facilityres.getString(2)%></option> 
					 <%
							}
					else
								{
						%>
	                   <option value='<%=facilityres.getString(1)%>' ><%=facilityres.getString(2)%></option> 
						<%
								}
							}
					       
            		}catch(Exception e1)
							{
								System.out.println("(ViewQryMsgHeader.jsp :Exception-2) :"+e1.toString());
							} 
						finally
					  {
						try
							{
							 if(facilityres!=null)facilityres.close();
							  if(stmt!=null) stmt.close();	

						// ConnectionManager.returnConnection(con);
							}
						catch(Exception e)
						   {
							  out.println("Exception is "+e);
							}
					   }
				 %>

          </select></td>
<!---<td  class=label>Communication Mode</td>
<td class='fields'>
<select name="qostatus" id="qostatus" id="qostatus" onChange='displaybutton()' style="width:200">
<option value='P'>Query Processed</option>
</select> ---->
</td>
  </tr>
  <tr>
	<td  class=label><fmt:message key="eXH.QueryOption.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<select name="qostatus" id="qostatus" id="qostatus" onChange='displaybutton()' style="width:175">
	<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
	<option value='P'><fmt:message key="eXH.QueryProcessed.Label" bundle="${xh_labels}"/></option>
	<option value='A'><fmt:message key="eXH.QueryInitiated.Label" bundle="${xh_labels}"/></option>
</select> <img src='../../eCommon/images/mandatory.gif' align=middle>
</td>
<td  class=label><fmt:message key="eXH.QueryStatus.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<select name="qstatus" id="qstatus" id="qstatus" style="width:175">
<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%----<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<option value='C' <%=(qstatus.trim()).equals(" ")?"selected":""%>>Received</option>
<option value='S' <%=(qstatus.trim()).equals("S")?"selected":""%>>Response Processed</option>
<option value='R' <%=(qstatus.trim()).equals("R")?"selected":""%>>Rejected</option>
<option value='E' <%=(qstatus.trim()).equals("E")?"selected":""%>>Error in Processing Response</option>----%>
</select>
</td> 
<td  class=label><fmt:message key="eXH.ResCommStatus.Label" bundle="${xh_labels}"/></td>
<td class='fields'>
<select name="msg_status" id="msg_status" id="msg_status" style="width:175">
<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<option value='P'<%=(msg_status.trim()).equals(" ")?"selected":""%>><fmt:message key="eXH.PendingComm.Label" bundle="${xh_labels}"/></option>
<option value='S' <%=(msg_status.trim()).equals("S")?"selected":""%>><fmt:message key="eXH.CommSuccessfully.Label" bundle="${xh_labels}"/></option> 
<option value='E' <%=(msg_status.trim()).equals("E")?"selected":""%>><fmt:message key="eXH.ErrorComm.Label" bundle="${xh_labels}"/></option> 
</select>
</td>  

	</tr>  
<!--</table>
<table cellspacing=0 cellpadding=3 width='101%' align=center>-->
	<tr>
	<td  class=label><fmt:message key="eXH.Gateway.Label" bundle="${xh_labels}"/></td>
		<td>
			<INPUT TYPE="text" id="protocol_link_name" name="protocol_link_name" id="protocol_link_name" onBlur='searchProtocolID();changeProtocolVal()' style="width:175" >
			<input class="BUTTON" type="button"  name=protocolIDSearch id=protocolIDSearch value='?' onClick="searchProtocolID()">
			<input type="hidden" id="protocol_link_id" name="protocol_link_id" id="protocol_link_id" >
		</td>
		
		<td class=label><fmt:message key="eXH.QueueType.Label" bundle="${xh_labels}"/></td>
		<td class=field>
			<select id="purge_status" name="purge_status" id="purge_status" style="width:175">
				<option value=""  <%=(purge_status.trim()).equals("")?"selected":""%>><fmt:message key="eXH.Online.Label" bundle="${xh_labels}"/></option>
				<option value="purge" <%=(purge_status.trim()).equals("purge")?"selected":""%>><fmt:message key="eXH.Purge.Label" bundle="${xh_labels}"/></option>
				<option value="offline" <%=(purge_status.trim()).equals("offline")?"selected":""%>><fmt:message key="eXH.Offline.Label" bundle="${xh_labels}"/></option>
			</select>
		</td>

		<td class=label><fmt:message key="eXH.OutputType.Label" bundle="${xh_labels}"/></td>
		<td class=field>
			<select id="dispMode" name="dispMode" id="dispMode" style="width:175" >
       			<!---<option value='Review'><fmt:message key="eXH.ReviewDisplay.Label" bundle="${xh_labels}"/></option>--->
           		<option value='display' ><fmt:message key="eXH.Qrydiplay.Label" bundle="${xh_labels}"/></option>
				<option value='excel' ><fmt:message key="eXH.WriteToXls.Label" bundle="${xh_labels}"/></option>
			</select>
		</td>
		<td>
		</td>
		<td>
		</td>
  	   </tr>
	   <tr>
	   <td class=label><fmt:message key="eXH.InterfaceDomain.Label" bundle="${xh_labels}"/></td>
		<td class='fields'>
		<select name="sub_module" id="sub_module" id="sub_module" style="width:175" >				
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</Option>
		<% 
		try
		{   
			String tempModuleID = "";
			String defSelect = sub_module;
		
			
			if(interface_module.equals(""))	moduleListQuery = moduleListQuery+"'XH'";
			else moduleListQuery = moduleListQuery+"'"+interface_module+"'";

			moduleListQuery = moduleListQuery+" ORDER BY interface_desc";	
			//"SELECT interface_module_id,interface_desc FROM xh_interface WHERE module_id='XH' and interface_module_id='XH' ORDER BY interface_desc";

			stmt = con.createStatement();
			result = stmt.executeQuery(moduleListQuery);

			while(result.next())
			{ 						
				tempModuleID = result.getString(1);
				
				if(defSelect.equals(tempModuleID)) 
				{ 
				%>
				<option value='<%=tempModuleID%>' selected><%=result.getString(2)%></option> 
				<%}
				else
				{
					
				
	%>
			<option value='<%=tempModuleID%>' ><%=result.getString(2)%></option> 
	<%
		}
			
			}					                                   
	%>				
		
	<%
		}catch(Exception e1)
		{
			System.out.println("(ViewEventsOutboundHeader.jsp:Exception-6) "+e1.toString());
		}
		finally
	  {
		try
			{
			 if(result!=null)result.close();
			  if(stmt!=null) stmt.close();	

		 ConnectionManager.returnConnection(con);
			}
		catch(Exception e)
		   {
			  out.println("Exception is "+e);
			}
	   }
	%>
			</option>
		</select>				
		<img src='../../eCommon/images/mandatory.gif'></td>
		<td>
		</td>
		<td>
		</td>
		<td>
		</td>
		<td>
		</td>
	   </tr>
</table>
</div>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
<td colspan='6'  align=right><input class='BUTTON' type="button"  name=search id=search value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="goSearch();"></td>
</tr>
<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
</table>
</form>
</body>
</html>   

