<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>  
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>							    
<%// String locale = ((String)session.getAttribute("LOCALE"));
 																	  
%>
<% 															  
String sStyle =							 
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HEAD>																 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<SCRIPT language='javascript' src='../../eXH/js/menu.js'></script>						 
<script language="javascript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>					   
<script language="javascript" src="../../eCommon/js/common.js" ></script>			    		 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>				   
<script language="javascript" src="../../eXH/js/MessagesForApplication.js" ></script>				    
<script language="JavaScript">		

function checkDisabled(obj,segment_type,event_type_code,whichelement,stnd_code)	  				    
{ 

	var flag=true;
	document.getElementById("_field"+whichelement).value="Y";
	var checkinuse=document.getElementById(segment_type+event_type_code+"_inuse1");				    
	/*if(checkinuse.disabled==true)
	{
		if(checkinuse.checked==true)					    
		{
             if(obj.value=='')
			{															    
				 alert(getMessage('XH0072','XH'));
					obj.focus();
			}
			else
			{ 
					checkText(obj,segment_type,event_type_code,whichelement); 
			}
		}																				   
	}
	else
	{
		checkText(obj,segment_type,event_type_code,whichelement);
	}*/

if(checkinuse.disabled==true)
{
	if(checkinuse.checked==true)
	{
		if(obj.value=='')
		{
		 alert(getMessage('XH0072','XH'));
		 searchProfile(segment_type,event_type_code,whichelement,stnd_code);
		}
		else
		{
           searchProfile(segment_type,event_type_code,whichelement,stnd_code);
		}
	}
}
else
{
	if(checkinuse.checked==true)
	{
		if(obj.value=='')
		{
			var i=window.confirm("Do you want to Enable the segment?");
			if(i==true)
			{
			flag=true;
			}														     
			else
			{
			
			flag = false;
			 

			parent.frames[1].document.getElementById(segment_type+event_type_code+"_inuse1").checked=false;					
			document.getElementById(segment_type+event_type_code+"_inuse").value="N";

			}
		}
		else
		{
			flag = true;
		}

	}
	else
	{
	flag=false;
	}
   
	if(flag)
	{
		searchProfile(segment_type,event_type_code,whichelement,stnd_code);
	}	
 }
}
   function checkrRepeatedYN(obj,whichelement)
   { 
  	    document.getElementById("_field"+whichelement).value="Y";
		 if(obj.checked==true)
		{
		  obj.value="Y";
		}
		else
	   {
		 obj.value="N";
	   }
   }



function checkText(obj,segment_type,event_type_code,whichelement)
{
	
 
	/*document.getElementById("_field"+whichelement).value="Y";
	if(obj.value=='')
	{
		
 
		if(document.getElementById(segment_type+event_type_code+"_inuse1").checked==true)
		{
         searchProfile(segment_type,event_type_code,whichelement);
		}
		else
		{
 
		}
	}
	else
	{
      //searchProfile(segment_type,event_type_code,whichelement);
	}*/
}
//function validatecheckbox 
function validatecheckbox(obj,segment_type,event_type,whichelement,stnd_code)						 
{ 

	document.getElementById("_field"+whichelement).value="Y";
	var name=obj.name;
	var countpage=parseInt(document.forms[0].count_page.value);
	if(name.indexOf("_optional_yn1")!=-1)
	{
		if(obj.checked==true)
		{
			obj.value="Y";
			document.getElementById(segment_type+event_type+"_optional_yn").value="Y";
		}
		else
		{
			obj.value="N";
			document.getElementById(segment_type+event_type+"_optional_yn").value="N";
		
		}
	}
else
	{
       if(obj.checked==true)
		{												    
			obj.value="Y";
		  document.getElementById(segment_type+event_type+"_profile_desc").disabled=false;
					document.getElementById(segment_type+event_type+"ProfileSearch").disabled=false;
			document.getElementById(segment_type+event_type+"_inuse").value="Y";
			if((document.getElementById(segment_type+event_type+"_profile_id").value=='') || (document.getElementById(segment_type+event_type+"_profile_desc").value==''))
			{
				//alert(getMessage('XH0072'));
                  searchProfile(segment_type,event_type,whichelement,stnd_code);
				//document.getElementById(segment_type+event_type+"_profile_desc").focus();
			}																							 
            else
			{

			}
			
			//document.getElementById(countpage+"_inuse"+whichelement).value="Y";
          //  document.getElementById(countpage+"_inuse1"+whichelement).value="Y";
		} 
		else
		{
			obj.value="N";
			document.getElementById(segment_type+event_type+"_inuse").value="N";
						//document.getElementById(segment_type+event_type+"_inuse1").checked=false;
			//document.getElementById(countpage+"_inuse"+whichelement).value="N";
           // document.getElementById(countpage+"_inuse1"+whichelement).value="N";
		}

	}
 
	
}

function funcheckBox(obj,cou)
{

	if(obj.checked==true)
		{
		obj.value="Y";
		}
		else
	{
         obj.value="N";
	}

	this.document.forms[0].target ='';
//	alert(parent.frames[2].name);
//	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	//this.document.forms[0].action_type.value = typ;
//	alert(this.document.forms[0].action_type.value);
	this.document.forms[0].action = '../../eXH/jsp/MsgForApplDisplayEventTypeMaster.jsp?&count_page='+cou+'&action_type=A';
	this.document.forms[0].submit();
}




function funAction(typ,obj)
{
						var flag=false;
						var cou=parseInt(document.forms[0].count_page.value); 
						for(var i=0;i<(cou-1);i++)			   
						{
							 if(document.getElementById("in_use"+i))
						  	 {
								if(document.getElementById("in_use"+i).checked==true)
								{
									
									 if(document.getElementById("profile"+i).value==''||document.getElementById("profile"+i).value==null)
									{
										
										flag=true;
																	   
									}
								}						 
							  }								   
						}						   


				if(flag==true)		  
				{
					alert(getMessage('XH0072','XH'));						
				}
				else									  
				{
					this.document.forms[0].target = 	"";
					//	alert(parent.frames[2].name);
					//	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
					this.document.forms[0].action_type.value = typ;
					//	alert(this.document.forms[0].action_type.value);
					this.document.forms[0].action = '../../eXH/jsp/MsgForApplDisplayEventTypeMaster.jsp?&count_page='+cou+'&action_type='+typ;
					this.document.forms[0].submit();
					window.parent.parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";
				}
}






function funShowSgmntViewer(obj)						  
{

	var Segment_id = obj.getAttribute('segment_type');
	//		alert("Segment_id : "+Segment_id);
	var Segment_name = obj.getAttribute('segment_name');
	//		alert("Segment_name : "+Segment_name);
	var stand_code = obj.getAttribute('standard_code');
	//	alert("stand_code : "+stand_code);
	var appl_id = obj.getAttribute('appl_id');
	//		alert("appl_id : "+appl_id);
	var appl_name = obj.getAttribute('appl_name');
	//		alert("appl_name : "+appl_name);
	var Profile_id = obj.getAttribute('profile_id');
	//		alert("Profile_id : "+Profile_id);
	 var fun_idapp	= obj.getAttribute('fun_idapp');
	 var  com_mode= obj.getAttribute('com_mode');
	 var event_type=obj.getAttribute('event_type');
	var messageLabel		= getLabel("eXH.SegmentViewer.Label","xh");
																		 
	 var linkset	= new Array();				    
	 var viewMsgLink = '<a href="#" onClick='+'\''+'showSegmentMessageViewer("'+Segment_id+'","'+Segment_name+'","'+stand_code+'","'+appl_id+'","'+appl_name+'","'+Profile_id+'");'+'\''+'>'+messageLabel+'</a>';			
	 linkset[0] =viewMsgLink;
	 if(fun_idapp=='SWTCHINB')
	{										  
/*				 if(com_mode=='O')
			{ */
			  var outboundatamapping	= getLabel("eXH.InboundDataMapping.Label","xh");   
			  var outboundLabel=outboundatamapping.replace("Inbound Data","Outbound");
			  var viewoutLink='<a href="#" onClick='+'\''+'showOutboundDataMapping("'+Segment_id+'","'+Segment_name+'","'+stand_code+'","'+appl_id+'","'+appl_name+'","'+Profile_id+'");'+'\''+'>'+outboundLabel+'</a>';
				 linkset[0]+=viewoutLink;
/*			}
			else
			{ */
				 var inboundmapping	= getLabel("eXH.InboundDataMapping.Label","xh");   
				var inboundLabel= inboundmapping.replace("Data",""); 
			    var viewinLink='<a href="#" onClick='+'\''+'showInboudDataMapping("'+Segment_id+'","'+Segment_name+'","'+stand_code+'","'+appl_id+'","'+appl_name+'","'+Profile_id+'","'+event_type+'");'+'\''+'>'+inboundLabel+'</a>';
				 linkset[0]+=viewinLink;
//			}																				   
	  
		
	}

	 dispMenu(linkset);
								   
									 
}
async function showInboudDataMapping(Segment_id,Segment_name,stand_code,appl_id,appl_name,Profile_id,event_type)
{			    
  var url =				    '../../eXH/jsp/MsgforApplInterfaceLibraryMain.jsp?Segment_id='+Segment_id+'&Segment_name='+Segment_name+'&Profile_id='+Profile_id+'&stand_code='+stand_code+'&appl_name='+appl_name+'&appl_id='+appl_id+'&function_type=F&access=NYYYY'+'&flag=SWITCHINBOUNDCONFIG&home_required_yn=N&event_type='+event_type;    
	var arguments  =new Array();
	 							 		 										  	   
	var dialogHeight = "75vh";					 			 				 	  	 			 				  
	var dialogWidth  = "85vw";				 				    
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	await window.showModalDialog(url,arguments,features); 
}
async function showOutboundDataMapping(Segment_id,Segment_name,stand_code,appl_id,appl_name,Profile_id)
{												    
											   			    
	     			 						 
	var url =											   '../../eXH/jsp/MsgforElementSegmentconfiguraionMain.jsp?Segment_id='+Segment_id+'&Segment_name='+Segment_name+'&Profile_id='+Profile_id+'&stand_code='+stand_code+'&appl_name='+appl_name+'&appl_id='+appl_id+'&function_type=F&access=NYYYN'+'&fun_id=SWITCHCONFIG&home_required_yn=N';    
	var arguments  =new Array();					    
									 												  
	var dialogHeight = "75vh";														      			 				  
	var dialogWidth  = "85vw";								    			 
	var dialogTop    = "230";								   
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	await window.showModalDialog(url,arguments,features); 
	  
}
async function showSegmentMessageViewer(Segment_id,Segment_name,stand_code,appl_id,appl_name,Profile_id)
{

	var url = '../../eXH/jsp/SegmentTypeMessageViewerMain.jsp?Segment_id='+Segment_id+'&Segment_name='+Segment_name+'&Profile_id='+Profile_id+'&stand_code='+stand_code+'&appl_name='+appl_name;
	var arguments  =new Array();
	
	var dialogHeight = "75vh";															 
	var dialogWidth  = "85vw";
	var dialogTop    = "230";					  
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	await window.showModalDialog(url,arguments,features); 
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2'onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
int start=0;
int r=0;
ArrayList arrRow = null;
ArrayList arrCol = null;			 
String strPrevious = "";  
String strNext  = "";				  
HashMap resultsQry=null; 
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
Statement stmt1=null;		    
ResultSet rs1=null;
String selectall="N";
String classValue="";
String segment_type="";
String segment_name="";
String optional_yn="";
String in_use_yn="";
String status="";
String com_mode="";
int cou=0;
System.out.println(" MsgForApplDisplayEventTypeMaster cou : "+cou);						  
String event_type=request.getParameter("event_type");
String appl_id=request.getParameter("appl_id");
System.out.println("MsgForApplDisplayEventTypeMaster.jsp appl_id : "+appl_id);
String appl_name = request.getParameter("appl_name");
String standard_code = XHDBAdapter.checkNull(request.getParameter("standard_code"));   
String fun_idapp=XHDBAdapter.checkNull(request.getParameter("fun_idapp"));			   
System.out.println("fun_idapp MsgForApplDisplayEventTypeMaster.jsp :"+fun_idapp);
//	System.out.println("standard_code : "+standard_code);									   
//String action_type = XHDBAdapter.checkNull(request.getParameter("action_type"));
//	System.out.println("action_type : "+action_type);
String profile_id = "";
String repeatable_yn="";
String profile_desc="";
String stnd_desc="";				    
// added on Jan 11 								  
String event_type_code = "";											   
String qrystnd_code = "";																				  
int singlecount=0;
boolean flag_rec_enbld = false;
%>
<form name="ApplicationSegmentListForEventTypeForm" id="ApplicationSegmentListForEventTypeForm" target='messageFrame' method='post' action=''>
<%
	request.setAttribute("application_Id",appl_id);
	request.setAttribute("message_type",event_type);
	request.setAttribute("standard_code",standard_code);
	 try
	 {																    
		 if(con==null)
		  con = ConnectionManager.getConnection(request);
	 }
	 catch(Exception e)
	 {
		 System.out.println(" MsgForApplDisplayEventTypeMaster :"+e);
	 }

try{
		boolean boolToggle =  true;	
//		String strTDClass = "";
	//	String qry_id = "MSGFORAPPLEVNTWSGMNT";
	//	con=ConnectionManager.getConnection();
		//String sql1="";
		String sql="";
		
        sql=" SELECT SEGMENT_TYPE FROM  XH_EVENT_TYPE_SEGMENT  WHERE EVENT_TYPE=NVL('"+event_type+"',EVENT_TYPE) "; 
		System.out.println("sql : "+sql);	 
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=stmt.executeQuery(sql);
        rs.last(); 
		if(rs.getRow()==0) 								    
		{
			%>
				<script>
					alert(getMessage('XH1016','XH'));
				</script>
			<%
		}
		else {

			rs.close();
			stmt.close(); 
		 // ORDER BY 11 "; B.SEGMENT_TYPE NOT IN 	 			  
			request.setAttribute("application_Id",appl_id);
			request.setAttribute("message_type",event_type);
            request.setAttribute("standard_code",standard_code);
        //  request.setAttribute(XHMsgForApplicationElementControllerBean.element_desc,element_desc); 
	        //con = ConnectionManager.getConnection(request);
			XHMsgForEventwiseElementControllerBean	xhBean = XHMsgForEventwiseElementControllerBean.getBean(XHMsgForEventwiseElementControllerBean.strBeanName,request,session);
			xhBean.action(request,con);				  
			resultsQry = xhBean.getResultSet();
			arrRow = (ArrayList)resultsQry.get("qry_result"); 
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 		   
		    start=Integer.parseInt(XHDBAdapter.checkNullZero((String)resultsQry.get("start")));   
              
  //          System.out.println("start 223 :"+start+"end :"+end);							  
			strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
			if (boolPrevious == true)
			{ 
				strPrevious =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
			}
			else								   
			{
				strPrevious = " ";					 						    
			}
			if (boolNext== true)											    
			{ 
				strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels"); 
			}
			else
			{
				strNext  = " ";							 
			}

		%>
		<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
		<input type=hidden name='event_type' id='event_type' id='event_type' value=<%=event_type%>>
		<%
//			System.out.println("arrRow.size() : "+arrRow.size());
		if(arrRow.size()==0)
		{%>
		<script>
					alert(getMessage('XH1021','XH'));
		</script>
		<%}
		else											    
		{
	%>		
			<tr>
			<td colspan="8" align="right" class="CAGROUP" > 
			<A class='label' style='cursor:pointer' onClick="funAction('P',document.forms[0].count_page)"><%=strPrevious %></A>
			<A class='label'  onClick="funAction('N',document.forms[0].count_page)" style='cursor:pointer' ><%=strNext %></A>
			</td>
			</tr>
			<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/></td>
			<td class='COLUMNHEADER' width='20%'><fmt:message key="eXH.SegmentType.Label" bundle="${xh_labels}"/>  <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.Standardcode.Label" bundle="${xh_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='17%'><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></td>
			 <td class='COLUMNHEADER' width='10%'><fmt:message key="eXH.Repeatable.Label" bundle="${xh_labels}"/></td>   
			<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		  
		<%  
//            System.out.println("arrRow.size() :"+arrRow.size());
	    selectall=XHDBAdapter.checkNull((String)resultsQry.get("selectall")); 
//			  System.out.println("selectall :"+selectall);
		if(selectall.equals("Y"))
		{
			if(optional_yn.equals("N"))										   
			{

			}
			else														    
			{
				in_use_yn="Y";
			}
		}
		for (int j=0; j<arrRow.size();j++)
		{
			arrCol = (ArrayList)arrRow.get(j);
			if (boolToggle == true)
			{
				classValue = "QRYEVEN" ;
				boolToggle =  false;
			}
			else
			{
				classValue = "QRYODD" ;
				boolToggle =  true;
			}
			
		    cou=Integer.parseInt((String)arrCol.get(13));
			singlecount=Integer.parseInt((String)arrCol.get(14));
			segment_type=(String)arrCol.get(0);
			segment_name=(String)arrCol.get(1);
			optional_yn=(String)arrCol.get(2); 
			in_use_yn=(String)arrCol.get(3);
			profile_id = XHDBAdapter.checkNull((String)arrCol.get(5));
			profile_desc=XHDBAdapter.checkNull((String)arrCol.get(6));
			stnd_desc=XHDBAdapter.checkNull((String)arrCol.get(7));
			event_type_code=XHDBAdapter.checkNull((String)arrCol.get(8));
			qrystnd_code =XHDBAdapter.checkNull((String)arrCol.get(9));	    
			status = XHDBAdapter.checkNull((String)arrCol.get(11));
			com_mode = XHDBAdapter.checkNull((String)arrCol.get(15));
			repeatable_yn = XHDBAdapter.checkNull((String)arrCol.get(16));
//			System.out.println(" MsgForApplDisplayEventTypeMaster.jsp status :"+status);
			%>
			<tr>
            <%									   
				if(segment_type.equals("ALL"))
			{
			}
			else
			{

			%>
											  

			<% if (status.equals("G")){ 
				flag_rec_enbld = true; %>
	
			<td class='<%=classValue%>' ><font color=green><%=segment_type%></font></td>
			<% }else {
				
				if(profile_id.equals("")||	profile_id==null)
				{ %>
				   <td class='<%=classValue%>' ><%=segment_type%></td>
				<%}				   
				  else
				{
				 %>
			<td class='<%=classValue%>'   segment_type="<%=segment_type%>" 
			segment_name="<%=segment_name%>"  standard_code="<%=qrystnd_code%>"  
			appl_id= "<%=appl_id%>"  appl_name= "<%=appl_name%>"  profile_id= "<%=profile_id%>"	  fun_idapp='<%=fun_idapp%>' com_mode='<%=com_mode%>'   event_type='<%=event_type_code%>'
			onMouseDown='funShowSgmntViewer(this)' >											  
			<a href="#"><%=segment_type%></a></td>    
			<%
				}												 
			}							    			 					    
			 if (status.equals("G")){ %>
            <td class='<%=classValue%>' align=left ><font color=green><%=segment_name%></font></td><%} else {%>
			<td class='<%=classValue%>' align=left ><%=segment_name%></td> <%} %>
			<td class='<%=classValue%>' align=left ><%=qrystnd_code%></td>			 
			<td class='<%=classValue%>' align=left ><%=event_type_code%></td>
			<td class='<%=classValue%>' align=left >													 
					<input type=hidden   name='<%=segment_type+event_type_code+"_profile_id"%>' id='<%=segment_type+event_type_code+"_profile_id"%>' value='<%=XHDBAdapter.checkNull(profile_id)%>' id='<%="profile"+singlecount%>'  > 	 
					<input type=text   name='<%=segment_type+event_type_code+"_profile_desc"%>' id='<%=segment_type+event_type_code+"_profile_desc"%>'   value='<%=XHDBAdapter.checkNull(profile_desc)%>'  onBlur="checkDisabled(this,'<%=segment_type%>','<%=event_type_code%>','<%=singlecount%>','<%=qrystnd_code%>');" style="width:150"> <input class="button" type="button"  name='<%=segment_type+event_type_code+"ProfileSearch"%>' id='<%=segment_type+event_type_code+"ProfileSearch"%>' value='?'    onClick="searchProfile('<%=segment_type%>','<%=event_type_code%>','<%=singlecount%>','<%=qrystnd_code%>');" >
            </td>	    
			<td class='<%=classValue%>' align=center >
		<%----	<%if(event_type.equals("I13") || event_type.equals("I14") || event_type.equals("O01") ||  event_type.equals("O02") ||  event_type.equals("R01") ||  event_type.equals("R02") ||  event_type.equals("R04") ||  event_type.equals("R05"))
			{
			%>

           <input type=checkbox	name='<%=segment_type+event_type_code+"_optional_yn1"%>' id='<%=segment_type+event_type_code+"_optional_yn1"%>'  onClick="validatecheckbox(this,'<%=segment_type%>','<%=event_type_code%>','<%=singlecount%>');" value='N' disabled><input type=hidden name='<%=segment_type+event_type_code+"_optional_yn"%>' id='<%=segment_type+event_type_code+"_optional_yn"%>' value='N' ></td>
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=segment_type+event_type_code+"_inuse1"%>' id='<%=segment_type+event_type_code+"_inuse1"%>' disabled   value='N'  onClick="validatecheckbox(this,'<%=segment_type%>','<%=event_type_code%>','<%=singlecount%>');" ><input type=hidden name='<%=segment_type+event_type_code+"_inuse"%>' id='<%=segment_type+event_type_code+"_inuse"%>' value='N' ><input type=hidden name='<%=segment_type+event_type_code+"_field"%>' id='<%=segment_type+event_type_code+"_field"%>'  id='<%="_field"+singlecount%>' value='N'>

			
			
			<%}
			else
				{%>----%>
			<input type=checkbox	name='<%=segment_type+event_type_code+"_optional_yn1"%>' id='<%=segment_type+event_type_code+"_optional_yn1"%>' <%=optional_yn.equals("Y")?"checked":""%> onClick="validatecheckbox(this,'<%=segment_type%>','<%=event_type_code%>','<%=singlecount%>');" value='<%=optional_yn.equals("Y")?"Y":"N"%>' disabled>
			<input type=hidden name='<%=segment_type+event_type_code+"_optional_yn"%>' id='<%=segment_type+event_type_code+"_optional_yn"%>' value='<%=optional_yn.equals("Y")?"Y":"N"%>' ></td>
				<td class='<%=classValue%>' align=center >
			<input type=checkbox name='<%=segment_type+event_type_code+"_repeat"%>' id='<%=segment_type+event_type_code+"_repeat"%>' <%=repeatable_yn.equals("Y")?"checked":""%> value='<%=repeatable_yn.equals("Y")?"Y":"N"%>'  onClick="checkrRepeatedYN(this,'<%=singlecount%>');" id='<%="repeat"+singlecount%>'>
			<td class='<%=classValue%>' align=center ><input type=checkbox name='<%=segment_type+event_type_code+"_inuse1"%>' id='<%=segment_type+event_type_code+"_inuse1"%>' <%=optional_yn.equals("N")?"disabled  ":""%> <%=in_use_yn.equals("Y")?"checked":""%> value='<%=in_use_yn.equals("Y")?"Y":"N"%>'  onClick="validatecheckbox(this,'<%=segment_type%>','<%=event_type_code%>','<%=singlecount%>','<%=qrystnd_code%>');" id='<%="in_use"+singlecount%>'><input type=hidden name='<%=segment_type+event_type_code+"_inuse"%>' id='<%=segment_type+event_type_code+"_inuse"%>'  value='<%=in_use_yn.equals("Y")?"Y":"N"%>' ><input type=hidden name='<%=segment_type+event_type_code+"_field"%>' id='<%=segment_type+event_type_code+"_field"%>'  id='<%="_field"+singlecount%>' value='<%=(String)arrCol.get(12)%>'>


			<%----<%}%>-----%>
			</td>	



		
			


			<%----<%}%>-----%>
			</td>
			
			
			<!-- name='<%=segment_type%>_in_use_yn' -->
			</tr>
			<%												  							 
			}													    
//				i++;
r++;
cou++;
		} // end of for
		} // end of else 
	} // end of else - If records found in XH_EVENT_TYPE_SEGMENT
}catch(Exception exp)
    {
  	    System.out.println("MsgForApplDisplayEventTypeMaster.jsp : "+exp.toString());
	   exp.printStackTrace(System.err);
    }
finally
{       
		try
		{
			if(stmt1!=null)stmt1.close();
			if(rs1!=null)rs1.close();														  
			ConnectionManager.returnConnection(con);	 
		}
		catch(Exception exp)
		{       
		   exp.printStackTrace(System.err);
		}		
}
														    
%>
<input type='hidden' name='count' id='count' value='<%=r%>'>

<tr>
 <% if (flag_rec_enbld == true)
 { %>
	
	<td colspan=8 class=label><img src='../../eXH/images/green_square.jpg' width=40 height=15 ><fmt:message key="eXH.Recently.Label" bundle="${xh_labels}"/></td> 

   
			</tr>
		<%
 } else
 {	%>  

 <%
 }		%>

</table>

<input type=hidden name=appl_id id=appl_id value=<%=appl_id%>>
<input type=hidden name=stnd_code id=stnd_code value=<%=standard_code%>>
<input type=hidden name='status' id='status' value='<%=status%>'>
<input type='hidden' name='action_type' id='action_type' value=''>
<input type='hidden' name='count_page' id='count_page' value='<%=cou%>'>							   
<input type='hidden' name='fun_idapp' id='fun_idapp' id='fun_idapp' value='<%=fun_idapp%>'>
  
</form>

</body>
</html>													 	  

