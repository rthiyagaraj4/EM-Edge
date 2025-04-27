<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import  ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXB.XBDBAdapter,java.sql.*,java.util.*,java.util.regex.Pattern,java.io.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML>
<HEAD> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<% 
String function_name="Application Level";
Connection con=null;															 
Statement stmt = null;																				  
ResultSet rs  = null;						 									  
ResultSet rs1  = null;												   		   
																							  
//String defaultval = "";										   
String code_yn="";																		    
//String version_no="";
//String application_id="";
//String ele_id=XBDBAdapter.checkNull(request.getParameter("elemnt_id"));
String fun_id=XBDBAdapter.checkNull(request.getParameter("fun_id")); 	 
//	System.out.println("ViewEventseBillShowDtlOption.jsp fun_id : "+fun_id);
String msg_status = XBDBAdapter.checkNull(request.getParameter("msg_status"));
String eventtype = XBDBAdapter.checkNull(request.getParameter("eventtype"));
String ToCols = "";

%>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>

<script language="JavaScript">
 

function onSelectStandardType()
{									  
	var	element_id=document.forms[0].element_id.value;
	var element_desc='';																		   
	var tab11=document.getElementById("tab1");
	//var stnd_code=document.forms[0].Standardcode_combo.value;
	//var seg_type=document.forms[0].segment_type.value;
	var appl_id=document.forms[0].application.value;
    var fun_id=document.forms[0].fun_id.value;

 /*   if(fun_id=='SWTCHTRANS')
	{																			    
	   parent.frames[2].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetupMain.jsp?applicationid='+appl_id+'&element_id='+element_id+'&element_desc=&fun_id='+fun_id;  	     
	}
	*/

																		  		 
}

 																		    

/*
function onSelectStandardTypeForm()
{																							  
var	element_id='';
var element_desc='';
var tab11=document.getElementById("tab1");									   
var stnd_code=document.forms[0].Standardcode_combo.value;
var seg_type=document.forms[0].segment_type.value;
var appl_id=document.forms[0].application.value;					 

 

if(appl_id=='')
{ 
	alert(getMessage( 'XH1003'));
	parent.parent.frames[0].document.forms[0].appli.focus();
	return;
}

/*parent.frames[2].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetupResult.jsp?applicationid='+appl_id+'&segment_type_id='+seg_type+'&standard_code='+stnd_code+'&element_id=&element_desc=';*/
 /*
parent.frames[2].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetupMain.jsp?applicationid='+appl_id+'&segment_type_id='+seg_type+'&standard_code='+stnd_code+'&element_id=&element_desc=';

}
													 


function funPrev()
{
	var stnd_code=document.forms[0].Standardcode_combo.value;
		var seg_type=document.forms[0].segment_type.value;
			var appl =  this.document.forms[0].application.value; 
		var dialogHeight = "125";									  
var dialogWidth  = "125";
var dialogTop    = "115";
var dialogLeft   = "115";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
var arguments  =new Array();
	var url="../../eXH/jsp/DataElementCrossRefApplicationElementSetupPreview.jsp?applicationid="+appl+"&segment_type_id="+seg_type+"&standard_code="+stnd_code;; 
 window.showModalDialog(url,arguments,features);  
} */

function dispResult(obj){
//	  alert("Result MsgStat : "+parent.frames[1].document.forms[0].msg_status.value);
//	  alert("Result EvntTyp : "+parent.frames[1].document.forms[0].eventtype.value);
	  var index		= obj.options.selectedIndex;
	  var Col    = obj.options[index].value;
	  var ColText    = obj.options[index].text;
  	  var ToCols = document.forms[0].ToCols.value;
	  var NewColList = "";
//	  alert("ColText : "+ColText.substring(0,4));
	  if(ColText.substring(0,4)=='Show'){
		  	  NewColList = ToCols+","+Col;
	  }else  if(ColText.substring(0,4)=='Hide'){		  
               arr=ToCols.split(','+Col);
			   NewColList = arr[0]+arr[1];
	  }
	  var msg_status = parent.frames[1].document.forms[0].msg_status.value;
	  var eventtype = parent.frames[1].document.forms[0].eventtype.value;
//	  alert("msg_status : eventtype "+msg_status+''+eventtype);
	  parent.frames[1].location.href='../../eXB/jsp/ViewEventseBillResult.jsp?NewColList='+NewColList+'&msg_status='+msg_status+'&eventtype='+eventtype;	  
	  parent.frames[0].location.href='../../eXB/jsp/ViewEventseBillShowDtlOption.jsp';	 //parent.frames[0].location.href='../../eXB/jsp/ViewEventseBillResult.jsp?NewColList='+NewColList+'&fun_idapp='+document.forms[0].fun_idapp.value+'&event_type='+event_type+'&stnd_code='+stnd_code;     

}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<!-- onLoad="onSelectStandardType()" -->
<BODY  leftmargin=0 topmargin=0   onMouseDown="CodeArrest()" onKeyDown ='lockKey()' >

<form name="application_element_setup_form" id="application_element_setup_form">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='30%'></td>
	<td width='25%'></td>
	<td width='10%'></td>										   
	<td width='20%'></td>
</tr>																									    
<tr>
<td width='40%'></td>
<td class=label align=center colspan=2>														    
<%																	 	    
try			 														  
{
	con=ConnectionManager.getConnection();
//	String qry = "SELECT * FROM XB_EVENT_APPL_MESSAGE_XL_VW  ";			
String qry = "SELECT APPLICATION_ID, APPLICATION_NAME, FACILITY_NAME, MESSAGE_ID, FACILITY_ID, MESSAGE_DATE, EVENT_TYPE, PATIENT_ID, MERGED_PATIENT_ID, EPISODE_TYPE, EPISODE_ID, VISIT_ID, ACCESSION_NUM, ACTION_TYPE, LAST_PROC_DATE, EVENT_STATUS, NOT_REQ_REASON, ADDED_BY_ID, ADDED_DATE, MODIFIED_BY_ID, MODIFIED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, EXT_ACCESSION_NUM, MESSAGE_STATUS, MESSAGE_STATUS_DESC, OUTBOUND_COMM_MODE, PROTOCOL_LINK_ID, SOLICITED_YN, ERR_MSG, MESSAGE_LENGTH, LAST_COMM_START_TIME, LAST_COMM_END_TIME, LAST_COMM_RETRIES, QUERY_ID, STATUS_TEXT, OUTBOUND_FILE_NAME, MESSAGE_TEXT,SYS_DEF_MESSAGE_TEXT,MESSAGE_TEXT,MESSAGE_LENGTH,LAST_COMM_START_TIME,LAST_COMM_END_TIME,LAST_COMM_RETRIES,QUERY_ID,STATUS_TEXT,OUTBOUND_FILE_NAME,'' INV_NO,'' INV_DATE,''  INV_AMOUNT,'' VISIT_DATE,'' PATIENT_NAME,'' PATIENT_TYPE,'' CARD_ID, '' CARD_ISSUE_DATE,'' CITIZEN_ID FROM XB_EVENT_APPL_MESSAGE_XL_VW "; 

	stmt = con.createStatement();		   
	 rs = stmt.executeQuery(qry);	
	 ResultSetMetaData rsmd = rs.getMetaData();
	 int col = rsmd.getColumnCount();

	String DataLinestr="";
	Pattern Regex=null;
	String Colstatus = "";
	String ColVal = "";

	 try{
			 File file = new File(config.getServletContext().getRealPath("/")+"eXB/html/XB_EVENT_APPL_MESSAGE_VW.html"  );
//			 boolean exists = file.exists();	
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			 DataLinestr = br.readLine();
			 br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
       }
//			System.out.println("ViewEventseBillDtlsResultPage.jsp DataLinestr :"+DataLinestr);
		try{
			Regex = Pattern.compile("\\,",Pattern.MULTILINE);
		}
		catch(Exception e)
		{
			System.out.println("erorr"+e);
		}															    


		String[] array=Regex.split(DataLinestr);
	
		for(int i=0;i<array.length;i++)
		{
			ToCols = ToCols+array[i]+",";	
		}
			ToCols = ToCols.substring(0,ToCols.length()-1);
	
%>
<select class='select' name='ShowHideCol' id='ShowHideCol'  style="width:200" onChange='dispResult(this)'>
 <option value='' selected>-------Show/Hide Columns-------</option>				 
<%
	for (int i=1; i <= col; i++)
	{
		for(int j=0;j<array.length;j++)
		{
//			String name=array[j].replaceFirst("_"," ");
//			System.out.println("Text Col : "+array[j]);
//			System.out.println("rsmd.getColumnName(i) : "+rsmd.getColumnName(i));			
				if(array[j].equals(rsmd.getColumnName(i)) ){
//				 System.out.println("equals");
                  Colstatus = "Hide";
				}
				else{
					Colstatus = "Show";
				}
				if(Colstatus.equals("Hide")) break;			
		}
			if(!Colstatus.equals("Hide")){ 
			Colstatus = "Show";
			}
			ColVal = Colstatus+" "+rsmd.getColumnName(i);
			//		System.out.println("ColVal : "+ColVal);
	 
	       if(rsmd.getColumnName(i).equals("EVENT_STATUS") || rsmd.getColumnName(i).equals("MESSAGE_STATUS") || rsmd.getColumnName(i).equals("MESSAGE_ID") || rsmd.getColumnName(i).equals("APPLICATION_ID") || rsmd.getColumnName(i).equals("EVENT_TYPE") || rsmd.getColumnName(i).equals("MESSAGE_DATE")|| rsmd.getColumnName(i).equals("FACILITY_ID")||rsmd.getColumnName(i).equals("ACCESSION_NUM")){  
			 
			}
			else{
  	 %>
			<option value='<%=rsmd.getColumnName(i)%>'   ><%=ColVal%></option>

	<%
			}
	}%>
		</select> <!--<img src='../../eCommon/images/mandatory.gif' align=middle> --> </td> 
	<td>
    </td>																  
 <%
}catch(Exception e1)
{
	System.out.println("ViewEventseBillShowDtlOption.jsp ERROR:"+e1.toString());
}

%>

 <td></td>
</tr>
<tr>
	<td width='30%'></td>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>				   
</tr>
</table>
           													  

<%
		if(rs!=null)rs.close();
		if(rs1!=null)rs1.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(con);
%>
<input type="hidden" name='code' id='code' value='<%=code_yn%>'/>
<input type="hidden" name='ToCols' id='ToCols' value='<%=ToCols%>'/>
<input type="hidden" name='function_name' id='function_name' value='<%=function_name%>'/>
<input type="hidden" name='fun_id' id='fun_id' id=fun_id value='<%=fun_id%>' >
<input type="hidden" name='msg_status' id='msg_status' value='<%=msg_status%>' >
<input type="hidden" name='eventtype' id='eventtype' value='<%=eventtype%>' >

</form>

</BODY>
</HTML>										 					    

