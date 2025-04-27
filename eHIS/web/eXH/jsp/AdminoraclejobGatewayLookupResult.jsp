<!DOCTYPE html>
   <%@page contentType="text/html;charset=UTF-8" import="java.lang.*,java.util.HashMap,java.util.ArrayList,java.util.Properties,eXH.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.ConnectionManager "%>

<%@include file="../../eCommon/jsp/CommonBean.jsp"%>				    
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>						 

<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");
																		   
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
 String pageCount=request.getParameter("pageCount")!=null?request.getParameter("pageCount"):"0";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>															  				 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>				     
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
var arvalues=new Array();		   
var y=0;
function enableCheck(obj,listvalue,cou)
{
	if(obj.checked)
	{
	  obj.value="Y";


	  	document.forms[0].action_type.value ="R";
		var act = '../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp';      
		this.document.forms[0].action = act;
		this.document.forms[0].target='refusal_resultframe_list';	     
		this.document.forms[0].submit(); 
	//  parent.refusal_resultframe_list.document.location.href="../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp";
	 /* 	var boo=false;
	    if(arvalues.length>0)
		{																				   
		  
		    for(var k=0;k<arvalues.length;k++)
			{									 						    
				if(arvalues[k]==listvalue)
				{

				 boo=true;
				}
				 else
				{
					 boo=false;
				}

		}
			

		}
		 else
			{
			 boo=false;
			}

			if(!boo)
			{
			var additem=arvalues.splice(cou,0,listvalue);
			  y++;
			}


		  
	  parent.frames[0].document.forms[0].search_optiontext.value=document.forms[0].search_option.value+arvalues;  */
	 // document.forms[0].search_option.value= parent.frames[0].document.forms[0].search_optiontext.value;
	}
	else
	{
	   obj.value="N";
		document.forms[0].action_type.value ="R";
		var act = '../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp';      
		this.document.forms[0].action = act;
		this.document.forms[0].target='refusal_resultframe_list';	     
		this.document.forms[0].submit();  //parent.refusal_resultframe_list.document.location.href="../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp";
		/* if(arvalues.length>0)
		{
	      var valuecom=arvalues.splice(cou,1);
		  y--;
		}
		
		  parent.frames[0].document.forms[0].search_optiontext.value=document.forms[0].search_option.value+arvalues;
		  alert(parent.frames[0].document.forms[0].search_optiontext.value);   	*/

	}
	
}  
function selectAllCheck(obj,cou)
{
	var Arrayval=new Array();
	if(obj.checked)										    
	{
	   //obj.value="Y";

		obj.checked=true;
	   	for(var u=0;u<parseInt(document.forms[0].count.value);u++)
	  	{
			document.getElementById(u+"_check").value="Y";
			document.getElementById(u+"_check").checked=true;
	  	}	  

	  
		document.forms[0].selectYN.value="Y";
	}						 
	else										    		 
	{
	    obj.value="N";
		obj.checked=false;
	  
		for(var u=0;u<parseInt(document.forms[0].count.value);u++)
	  	{
			document.getElementById(u+"_check").value="N";
			document.getElementById(u+"_check").checked=false;
	  	}	  
		
	  	document.forms[0].selectYN.value="N";   	  
	}

//	 parent.frames[0].document.forms[0].search_optiontext.value=document.forms[0].search_option.value+Arrayval;		 

/*	document.forms[0].rule.value ="N";		  	  
	document.forms[0].action_type.value ="R";
	var act = '../../eXH/jsp/AdminoraclejobGatewayLookupResult.jsp';      
	this.document.forms[0].action = act;
	this.document.forms[0].target='';	     
	this.document.forms[0].submit(); 	 */
	
	document.forms[0].action_type.value ="R";
	var act = '../../eXH/jsp/AdminoraclejobGatewayLookupResultList.jsp';      
	this.document.forms[0].action = act;
	this.document.forms[0].target='refusal_resultframe_list';	     
	this.document.forms[0].submit(); 
}
/*function funSubmit()
{
	var act = '../../eXH/jsp/AdminoraclejobGatewayLookupResult.jsp?';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}																								  
function funAction(typ)
{
	document.forms[0].action_type.value = typ;			   
	this.document.forms[0].target=''
	funSubmit();	     
}			*/

function funAction(type)
{

  if(type=="N")
 {
   document.forms[0].pageCount.value=parseInt(document.forms[0].pageCount.value)+1;
 }
 else
{
  document.forms[0].pageCount.value=parseInt(document.forms[0].pageCount.value)-1;
}

	funSubmit(type);  
}																				 

//***********************************************************************************************
function funSubmit(type)
{
	 document.forms[0].action_type.value = type; 
	 var page=document.forms[0].pageCount.value;		  
	/*	   if(document.forms[0].selectAll.checked)			    
	{
	   document.forms[0].selectAll.value="Y";
	   document.forms[0].selectYN.value="Y";								 
	   
	  //document.getElementById(page+"selectYN").value="Y";

	}						 				 		  				   
	else										   
	{
	    document.forms[0].selectAll.value="N";
		document.forms[0].selectYN.value="N";	
		// document.getElementById(page+"selectYN").value="N";
	}	 		*/


		 
	 document.forms[0].rule.value ="Y";	  
	var act = '../../eXH/jsp/AdminoraclejobGatewayLookupResult.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].target='';	    
	this.document.forms[0].submit();	  
}																   

var gtwyList = new Array();

function getDescription(obj,cnt,val)
{
	if(document.getElementById(cnt+"_enable").checked)			   
	{
//		alert("Checked");
		document.getElementById(cnt+"_enable").value="Y";	

		gtwyList[cnt] = val;
	}
	else
	{
		document.getElementById(cnt+"_enable").value="N";
//		alert("UnChecked");
		gtwyList[cnt] = "";	     


	}

//	funAction("R");
}

function funok() 
{
//	var gatwayList = gtwyList;
	var str=parent.frames[0].document.getElementById("search_optiontext").value;
	toCloseTopShowModal(str)
	if(str!=null || str!=''||str!='undefined'||str!=undefined)
	{
	str=str.substring(0,(str.length));
	//window.returnValue=str;
	toCloseTopShowModal(str)
	}	
//	alert("gtwyList : "+gtwyList);
	//window.close();
}
function formLoad()
{
	
   /*if(parent.frames[0].document.forms[0].search_optiontext.value==null||parent.frames[0].document.forms[0].search_optiontext.value=='')
	{
	  document.forms[0].search_option.value=''; 
	}
	else
	{	
		document.forms[0].search_option.value=parent.frames[0].document.forms[0].search_optiontext.value+",";
	} */



}
</script>
	</head>
	<body onload="formLoad()" >
	<form name="MedicationListResult" id="MedicationListResult" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >	
	<input type=hidden name="pageCount" id="pageCount" value="<%=pageCount%>">	   
	 															   
	<%
		int i = 0;
//int count=0;														 		   
//boolean boolToggle =  true;						   
//String strTDClass = ""; 
String strBeanName = XHGatewayListControllerBean.strBeanName; 
Connection conn = null;
ArrayList arrRow = null;
ArrayList arrCol = null;
HashMap resultsQry=null;							 	  
String strPrevious = "";  
String strNext  = "";													 
String classvalue="";
//Statement stmt=null;
//ResultSet rs=null;	
String action_type=request.getParameter("action_type")!=null?request.getParameter("action_type"):"";   
String search_option=request.getParameter("search_option")!=null?request.getParameter("search_option"):"";
String selectAll=""; 
//java.util.Date date_time	 	= new java.util.Date();
//String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	   
LinkedList fullList=null;	 
try
{  


	String commode= XHDBAdapter.checkNull(request.getParameter("commmode"));
	String search_by=request.getParameter("search_by");
	if(search_by==null || search_by=="null") search_by = "C";
 	String description_code=(request.getParameter("description_code")==null||request.getParameter("description_code").equals("null"))?"":request.getParameter("description_code");
	String long_desc=request.getParameter("search_text");  
	if(long_desc==null || long_desc=="null") long_desc = "";

	String option_list=request.getParameter("search_optiontext");
	if(option_list==null || option_list=="null") option_list = "";
	String interfc_mod_id = XHDBAdapter.checkNull(request.getParameter("interfc_mod_id"));
	String gateway_id="";
	String whereCaluse=""; 
	String ResultQry="";
	if(long_desc.equals(""))										   
	{
		 if(option_list.equals(""))	  
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
			   ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";
		}
		else
		{

			if(option_list.indexOf(",")!=-1)
			{										   
			

			 String[] splitstr=option_list.split(",");

		
			String addComma="";
			for(int l=0;l<splitstr.length;l++)
		  {
			if(l==(splitstr.length-1))
			{
			addComma=new String("'"+splitstr[l]+"'");		 
			}
			else
			{
			addComma=new String("'"+splitstr[l]+"',");
			}

			gateway_id=gateway_id+addComma;
			}
			whereCaluse=whereCaluse+"AND PROTOCOL_LINK_ID in ("+gateway_id+") UNION SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) and PROTOCOL_LINK_ID not in ("+gateway_id+") ";	

			 ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'Y'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";

																										    
		}
			else
			{
				gateway_id=option_list;
			  whereCaluse=whereCaluse+"AND PROTOCOL_LINK_ID in ('"+gateway_id+"') UNION SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) and PROTOCOL_LINK_ID not in ('"+gateway_id+"') ";	

			 ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'Y'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";    
			}

		}

	}
	 else
	{
		 if(search_by.equals("C"))									   			  
		{
		if(description_code.equals("S"))
		{
			whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}  
	   else if(description_code.equals("E"))			 
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%"+long_desc+"') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}
		else
		{
		 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}
	 }
	 else
	 {																													    
	   if(description_code.equals("S"))
		{
			whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('"+long_desc+"%') ";																					  
		} 
	   else if(description_code.equals("E"))
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%"+long_desc+"') ";
		}
		else
		{
		 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%"+long_desc+"%') ";
		}
	 }
	  ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";

	}

		 


/*if(long_desc.indexOf(",")!=-1)
{
	String[] splitstr=long_desc.split(",");
	String addComma="";
	for(int l=0;i<splitstr.length;l++)
	{
		if(l==(splitstr.length-1))
		{
		addComma=new String("'"+splitstr[l]+"'");
		}
		else
		{
		addComma=new String("'"+splitstr[l]+"',");
		}

	gateway_id=gateway_id+addComma;
    }
    whereCaluse=whereCaluse+"AND PROTOCOL_LINK_ID in ("+gateway_id+") UNION SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'N'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) and PROTOCOL_LINK_ID not in ("+gateway_id+") ";		    
}
else
{

	if(search_by.equals("C"))									   
	{
		if(description_code.equals("S"))
		{
			whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}  
	   else if(description_code.equals("E"))			 
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%"+long_desc+"') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}
		else
		{
		 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%"+long_desc+"%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%') ";
		}
	 }
	 else
	 {																													    
	   if(description_code.equals("S"))
		{
			whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('"+long_desc+"%') ";
		} 
	   else if(description_code.equals("E"))
		{
			 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%"+long_desc+"') ";
		}
		else
		{
		 whereCaluse=whereCaluse+" AND UPPER(PROTOCOL_LINK_ID) LIKE UPPER('%') AND UPPER(PROTOCOL_LINK_NAME) LIKE UPPER('%"+long_desc+"%') ";
		}
	 }
}	  */
	 String rule=request.getParameter("rule")!=null?request.getParameter("rule"):"N";
			 																				  
		if(rule.equals("N"))
	{
		selectAll=request.getParameter("selectYN")!=null?request.getParameter("selectYN"):"";
	}
														 						 			   
	 request.setAttribute("commode",commode);	 
	 request.setAttribute("interfce_module_id",interfc_mod_id);
		request.setAttribute("Query",ResultQry);
	 request.setAttribute("selectAll",selectAll);					 
	 request.setAttribute("action_attr","");				  
	 conn = ConnectionManager.getConnection(request);			  
	 XHGatewayListControllerBean	xhBean = XHGatewayListControllerBean.getBean(strBeanName,request,session);
	 xhBean.action(request,conn);					    
	 resultsQry = xhBean.getResultSet(); 	
	 arrRow = (ArrayList)resultsQry.get("qry_result"); 
	  fullList=(LinkedList)resultsQry.get("listA");
	 boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 										 
	 boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 	
	
	 if(rule.equals("Y"))
	{
	 selectAll=((String)resultsQry.get("selectAll")).equals("")?"":((String)resultsQry.get("selectAll"));    		   
	}
																	 
	  strPrevious = "Previous";
	 strNext  = "Next";
	 if (boolPrevious == true)														    
	{																	  
		strPrevious ="Previous";			 							   
	}
	else													    
	{													   
		strPrevious = " ";
	}														   
	if (boolNext== true)
	{
		strNext  ="Next";
	}
	else								  
	{													 										  
		strNext  = " ";
	}
	 
	%>
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="reprint_rep">
<tr>
	<td colspan="8" align="right"  > 
	<A class='label'  style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
	</tr>
 
<%
if(arrRow.size()==0)											 	    
{														    			    
	%>						  
<script>																					 
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));

</script>
<%
}
else
{
	%>
<tr>
<th> <fmt:message key="Common.code.label" bundle="${common_labels}"/> </th>		   			    
<th> <fmt:message key="Common.description.label" bundle="${common_labels}"/> </th>
<th> <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> 
<input type="checkbox"  name="selectAll" id="selectAll" value="<%=selectAll%>"    onClick="selectAllCheck(this,'<%=pageCount%>')" <%=(selectAll).equals("Y")?"checked":""%> ></th>   
</tr>
<%									 			    
for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if ( i % 2 == 0 )
				classvalue = "QRYEVEN" ;				    
			else
				classvalue = "QRYODD" ;
	%>														 			     
	<tr>	
	
<td class="<%=classvalue%>" style="font-size=9" nowrap>&nbsp<%=(String)arrCol.get(0)%></td>
<input type=hidden id='<%=i+"proto"%>' value='<%=(String)arrCol.get(0)%>'>
<td class="<%=classvalue%>" style="font-size=9" nowrap>&nbsp;<%=(String)arrCol.get(1)%></td>   	     	   
<%if(selectAll.equals("Y"))
{%>																	 
<td class="<%=classvalue%>" style="font-size=9" nowrap><input type="checkbox"  name='<%=(String)arrCol.get(0)+"_check"%>' id='<%=(String)arrCol.get(0)+"_check"%>' id='<%=j+"_check"%>' value="Y"   onClick="enableCheck(this,'<%=(String)arrCol.get(0)%>','<%=j%>')" checked>  </td>   		  
<%}							   
else
		{%>
		<td class="<%=classvalue%>" style="font-size=9" nowrap>
		<input type="checkbox"  name='<%=(String)arrCol.get(0)+"_check"%>' id='<%=j+"_check"%>' value="<%=((String)arrCol.get(2)).equals("Y")?"Y":"N"%>"   onClick="enableCheck(this,'<%=(String)arrCol.get(0)%>','<%=j%>')" <%=((String)arrCol.get(2)).equals("Y")?"checked":""%>  >   
		</td>
		<%}%>																  
</tr>																  	  
	<%	   i++;
			}					   
}
	}
	
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		//arrRow.clear();
	//	arrCol.clear();
		ConnectionManager.returnConnection(conn);
		
	}%>


	
	<input type=hidden name="count" id="count" value="<%=i%>"  >	
	<input type=hidden name="selectYN" id="selectYN"  >									  
	<input type=hidden name="rule" id="rule"> 
	<input type=hidden name="search_option" id="search_option" value='<%=search_option%>' > 
	<input type=hidden name="GatewayList" id="GatewayList" id="GatewayList" value='<%=fullList%>'>
	<input type=hidden name="action_type" id="action_type" value="<%=action_type%>"> 	 
	</table>																		  
	<table border='0' width='100%'>
	 <tr><td  align='right'><input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' width='25%' onclick='funok()'></td></tr>
	 </table>

</table>
												 												    
	 
</form>
</body>
</html>

