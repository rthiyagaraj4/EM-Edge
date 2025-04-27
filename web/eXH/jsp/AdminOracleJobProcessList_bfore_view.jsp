<!DOCTYPE html>
<%@ page import=  "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eXH.*,java.util.*,eXH.XHDBAdapter" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eXH/html/style.css" /> 
<SCRIPT Language="JavaScript" src="../../eCommon/js/common.js"></SCRIPT>
<SCRIPT Language="JavaScript" src="../../eCommon/js/ValidateControl.js" ></SCRIPT>
<SCRIPT Language="JavaScript" src="../../eXH/js/menu.js" ></SCRIPT>
<SCRIPT language="JavaScript" src='../../eXH/js/AdministerReviewCommunicationProcess.js'></SCRIPT>
 
<SCRIPT>
var tooltip=function(){
	var id = 'tt';
	var top = 3;
	var left = 3;
	var maxw = 500;
	var speed = 10;
	var timer = 20;
	var endalpha = 200;
	var alpha = 0;										   
	var tt,t,c,b,h;
	var ie = document.all ? true : false;
	return{
		show:function(v,w){
		v=unescape(v);
			 	if(tt == null){
				tt = document.createElement('div');
				tt.setAttribute('id',id);
				t = document.createElement('div');							   
				t.setAttribute('id',id + 'top');
				c = document.createElement('div');
				c.setAttribute('id',id + 'cont');
				b = document.createElement('div');
				b.setAttribute('id',id + 'bot');
				tt.appendChild(t);
				tt.appendChild(c);
				tt.appendChild(b);
				document.body.appendChild(tt);
				tt.style.opacity = 0;
			
				tt.style.filter = 'alpha(opacity=0)';
				document.onmousemove =this.pos;
				
			}
			tt.style.display = 'block';			  
			c.innerHTML = v;  
			  c.style.width="1010px";
				  	c.style.wordBreak='break-all';
			tt.style.width = w ? w + 'px' : '50';
			if(!w && ie){
				t.style.display = 'none';
				
				b.style.display = 'none';
				tt.style.width =tt.offsetWidth;
				t.style.display = 'block';
				b.style.display = 'block';
			}
			if(tt.offsetWidth > maxw){tt.style.width = maxw + 'px'}
			h = parseInt(tt.offsetHeight) + top;
			clearInterval(tt.timer);
			tt.timer = setInterval(function(){tooltip.fade(1)},timer);
		},
		pos:function(e){
			var u =ie ? event.clientX + document.documentElement.scrollTop : e.pageX;
			var l =	100;
				//ie ? event.clientY + document.documentElement.scrollLeft : e.pageY;
			tt.style.top =(u - h) ;
			tt.style.left =0;
		},
		fade:function(d){
			var a = alpha;
			if((a != endalpha && d == 1) || (a != 0 && d == -1)){
				var i = speed;
				if(endalpha - a < speed && d == 1){
					i = endalpha - a;
				}else if(alpha < speed && d == -1){
					i = a;
				}														 
				alpha = a + (i * d);
				tt.style.opacity = alpha * .01;
				tt.style.filter = 'alpha(opacity=' + alpha + ')';
			}else{
				clearInterval(tt.timer);									   
				if(d == -1){tt.style.display = 'none'}
			}
		},
		hide:function(){
			clearInterval(tt.timer);
			tt.timer = setInterval(function(){tooltip.fade(-1)},timer);
		}
	};
}();
function breakFun()
{														  
	var cou=parseInt(document.forms[0].count.value);
														 									   
     for(var k=0;k<cou;k++)
	{
       document.getElementById("check"+k).style.wordBreak='break-all';
	}
	
}
</SCRIPT>

</HEAD>								    
 
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="breakFun();">

<form name="AdminOracleJobProcessListForm" id="AdminOracleJobProcessListForm" method="post">

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center> 


<%
int count = 0;
	boolean boolToggle =  true;	
	String strTDClass = "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst1 = null;
	String process_name="";
	PreparedStatement pstmt2 = null;
	ResultSet rst2 = null;
	String job = "";
	String what = "";
	String log_user= "";
	String last_date = "";
	String next_date = "";
	String prev_status = "";
	String qryStr = "";
	String display_what="";
    String interval="";
	String functionID = request.getParameter("functionID") ;
	//String mainModule_id	= request.getParameter("module_id") ;
	 
	String intervalss="";	
	String long_desc="";
	String err_msg = "";
	String qry_id="ADMINORACLEJOBQUERY";
	String select_substr="";
	String this_date = "";

	String SQL1="select proc_id,LONG_DESC from xh_proc_id where proc_srt_cmd=?";

	//String SQL2="SELECT TO_CHAR(msg_date_time, 'DD/MM/YYYY HH:MI:SS AM')||' '||err_msg error FROM sy_proc_msg WHERE UPPER(PROC_ID)=? ";



try
{
	request.setAttribute(XHQueryRender.strQueryId,qry_id);
	request.setAttribute(XHQueryRender.col,"9");
	request.setAttribute(XHQueryRender.maxRec,"15");
	con = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,con);
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	
	if (boolPrevious == true)
	{
	  strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	  //strPrevious = "Previous";
	}
	else																		    
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
	 strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	 // strNext = "Next";
	}
	else
	{
	   strNext  = " ";
	}


        pstmt1 = con.prepareStatement(SQL1);
		/*con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL);
		pstmt1 = con.prepareStatement(SQL1);
//		pstmt2 = con.prepareStatement(SQL2);
		rst = pstmt.executeQuery();
		
		int count = 0;
		int index = 0;
		String select_option="";
		
		
		while(rst.next()){
			job = rst.getString(1);
			what = rst.getString(2);
			log_user = rst.getString(3);  if(log_user==null) log_user="";
			last_date = rst.getString(4);  if(last_date==null) last_date="";
//			System.out.println("last_date : "+last_date);
			next_date = rst.getString(5);  if(next_date==null) next_date="";
			prev_status = CommonBean.checkForNull(rst.getString(7));
			interval=rst.getString(8);
			intervalss=	interval.substring(8,interval.length());
			intervalss=intervalss.substring(0,intervalss.length()-5);
			prev_status = ("".equals(prev_status))?"Idle":prev_status;
			qryStr = count%2==0?"QRYEVEN":"QRYODD";
			index=what.indexOf('(');
			display_what=what.substring(0,index==-1?what.indexOf(';'):index);
				System.out.println("display_what : "+display_what);						   
			pstmt1.setString(1,display_what);
			rst1 = pstmt1.executeQuery();	 
			if(rst1.next()) select_option=rst1.getString(1);
			if(select_option.equals("XIQTYUPD")){
				select_option = "XIPO";
			}
			if(rst1!=null)rst1.close();
				System.out.println("select_option : "+select_option);
	/*	    pstmt2.setString(1,select_option);
			rst2 = pstmt2.executeQuery();	 
			while(rst2.next())  {
				err_msg=err_msg+"\n"+(String)rst2.getString(1);
			}
//			System.out.println("err_msg : "+err_msg);
			err_msg = java.net.URLEncoder.encode(err_msg);
//			System.out.println("encoded err_msg : "+java.net.URLEncoder.encode(err_msg)); 
			if(rst2!=null)rst2.close();*/

			//interval1=interval.substring(8,10); 
			//long_desc=rst.getString(9);		 
		

		%>
	<tr>
		<!--<td colspan="4" class="CAGROUP" > Job-Queue</td>--->
	  <td colspan="5" align="right" class="CAGROUP"> 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><u><%=strPrevious%></u></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer'><u><%=strNext%></u></A>
	</td>
	</tr>
	<tr>					    
	<td class='COLUMNHEADER' width='65%'  nowrap><fmt:message key="Common.Process.label" bundle="${common_labels}"/></td>
	<!---<td class='COLUMNHEADER'  width='10%' nowrap>Submitted By</td>--->
	<td class='COLUMNHEADER'  width='15%' nowrap><fmt:message key="Common.LastExecution.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='15%' nowrap><fmt:message key="Common.NextExecution.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='5%' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
<%
	try
	{
		int index = 0;
		String select_option = "";
		String moduleID = "";

for (int j=0; j<arrRow.size();j++)
{
arrCol = (ArrayList)arrRow.get(j);												   
if (boolToggle == true)
{
  strTDClass = "class='QRYEVEN'";
  boolToggle =  false;
}
else
{
  strTDClass = "class='QRYODD'";
 boolToggle =  true;
}

            job = XHDBAdapter.checkNull((String)arrCol.get(0));
			what = XHDBAdapter.checkNull((String)arrCol.get(1));


			

			log_user = XHDBAdapter.checkNull((String)arrCol.get(2));  if(log_user==null) log_user="";

			last_date = XHDBAdapter.checkNull((String)arrCol.get(3));  
			
			next_date = XHDBAdapter.checkNull((String)arrCol.get(4));  if(next_date==null) next_date="";
			
			this_date = XHDBAdapter.checkNull((String)arrCol.get(5));  if(this_date==null) this_date="";
			
			prev_status = CommonBean.checkForNull((String)arrCol.get(6));
		
			interval=XHDBAdapter.checkNull((String)arrCol.get(7));
			  


		 


		    	if(interval.equals("") || interval==null)
				{
				}
				else
				{		intervalss=	interval.substring(8,interval.length());
						intervalss=intervalss.substring(0,intervalss.length()-5);

				}
		

			prev_status = ("".equals(prev_status))?"Idle":prev_status;
			if(!this_date.equals("")) {
					prev_status	=	"Running";
			}
			else{
				if( last_date.equals("") ||  (last_date==null ) ) {
					prev_status	=	"Idle";
				}
			}

			qryStr = count%2==0?"QRYEVEN":"QRYODD";

			index=what.indexOf('(');
			display_what=what.substring(0,index==-1?what.indexOf(';'):index);


				
			pstmt1.setString(1,display_what);
			rst1 = pstmt1.executeQuery();	 									 
			if(rst1.next())
	{
				select_option = rst1.getString(1);	 
				process_name=rst1.getString(2);	
	}

			moduleID = select_option.substring(0,2);
		
																   
			if(select_option.equals("XIQTYUPD")){
				select_option = "XIPO";
			}
			if(rst1!=null)rst1.close();													 
				
	/*	    pstmt2.setString(1,select_option);
			rst2 = pstmt2.executeQuery();	 
			while(rst2.next())  {
				err_msg=err_msg+"\n"+(String)rst2.getString(1);
			}
//			System.out.println("err_msg : "+err_msg);
			err_msg = java.net.URLEncoder.encode(err_msg);
//			System.out.println("encoded err_msg : "+java.net.URLEncoder.encode(err_msg)); 
			if(rst2!=null)rst2.close();*/

			//interval1=interval.substring(8,10);
		    long_desc=XHDBAdapter.checkNull((String)arrCol.get(8));
				 select_substr=select_option.substring(0,2);								   


				 String orginalStr="";
				String orginalTitle=java.net.URLEncoder.encode((job+"-"+what));
					 if((job+"-"+what).length()>90)
					{
					 orginalStr=(job+"-"+what).substring(0,90);
					}
					else
					{
					 orginalStr=(job+"-"+what); 
					}

//System.out.println("interval1 : "+interval1);		
																		  			    
if(functionID.equals("XF_J_ADMNREV_SVR_PROCESS"))								 			    
{
	   if(select_substr.equals("XF")||select_substr.equals("DF")||select_substr.equals("BL"))
		{
%>

	<tr>
		<td id='<%="check"+count%>' class='<%=qryStr%>' 																  
			job="<%=job%>" what="<%=what%>" select_option="<%=select_option%>" interval="<%=intervalss%>"
			last_date="<%=last_date%>" next_date="<%=next_date%>" long_desc="<%=long_desc%>" err_msg="<%=err_msg%>"
		onClick='sendParam(this)'  width='40%' ><span class="hotspot" onmouseover="tooltip.show('<%=process_name+" - "+(orginalTitle)%>');" onmouseout="tooltip.hide();"><a href="#"><%=orginalStr%></a></span> </td>	  

	    <% if (last_date.equals("")) { %>
			<td class='<%=qryStr%>' width='15%' >&nbsp;</td>							  
		<% } else {  	%>
			<td class='<%=qryStr%>' width='15%' ><%=last_date%>&nbsp;</td>
         <% } %>
		<td class='<%=qryStr%>' width='15%'><%=next_date%></td>
		<%---<% if("DF".equalsIgnoreCase(moduleID) || "XF".equalsIgnoreCase(moduleID) || "BL".equalsIgnoreCase(moduleID)){ %>
			<td class='<%=qryStr%>' select_option="<%=select_option%>" run_job="<%=job%>" what="<%=what%>" interval="<%=intervalss%>"  proc_date="<%=next_date%>" onMouseDown='showErrors(this)' >
				<a href="#"><%=prev_status%>&nbsp;</a>
			</td>
		<%}else{%>
			<td class='<%=qryStr%>'><%=prev_status%></td>
		<%}%>	  ---%>												   
		

		<td class='<%=qryStr%>' select_option="<%=select_option%>" run_job="<%=job%>" what="<%=what%>" interval="<%=intervalss%>"  proc_date="<%=next_date%>" onMouseDown='showErrors(this)' >
		<a href="#"><%=prev_status%></a>
		</td>										   
		
<!--			err_msg="<%=err_msg%>" -->		 
	</tr>
	<%count++;}	}										 
else
	{																 			 
	%>
	  <tr>
		<td id='<%="check"+count%>' class='<%=qryStr%>' 
			job="<%=job%>" what="<%=what%>" select_option="<%=select_option%>" interval="<%=intervalss%>"
			last_date="<%=last_date%>" next_date="<%=next_date%>" long_desc="<%=long_desc%>" err_msg="<%=err_msg%>"
		onClick='sendParam(this)'  width='40%'  >
		<span class="hotspot" onmouseover="tooltip.show('<%=process_name+" - "+(orginalTitle)%>');" onmouseout="tooltip.hide();"><a href="#"><%=orginalStr%></a></span>
											 

	
	<%---	<a href="#"><%=process_name%></a> ---%>
		</td>
	<!-- <td class='<%=qryStr%>' width='15%' ><%=log_user%></td> -->
		<td class='<%=qryStr%>'  width='15%'><%=last_date%>&nbsp;</td>
		<td class='<%=qryStr%>'  width='15%'><%=next_date%>&nbsp;</td>
		
		<% if("DF".equalsIgnoreCase(moduleID) || "XF".equalsIgnoreCase(moduleID) || "BL".equalsIgnoreCase(moduleID)){ %>
			<td class='<%=qryStr%>' select_option="<%=select_option%>" run_job="<%=job%>" what="<%=what%>" interval="<%=intervalss%>"  proc_date="<%=next_date%>" onMouseDown='showErrors(this)'>
				<a href="#"><%=prev_status%></a>
			</td>																	    
		<%}else{%>
			<td class='<%=qryStr%>'><%=prev_status%>&nbsp;</td>
		<%}%>	 										   						 
		

		
											   
																			    
<!--			err_msg="<%=err_msg%>" -->		 
	</tr>
	 <%
	count++;													 
	}

		}							   
	}
	catch(Exception e){
			System.err.println("Err Msg From AdminOracleJobProcessList.jsp first: "+e);
		}
		
		}	catch(Exception e){
			System.err.println("Err Msg From AdminOracleJobProcessList.jsp : "+e);
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(pstmt1!=null)pstmt1.close();
		if(rst2!=null)rst2.close(); 
		if(pstmt2!=null)pstmt2.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>																			 
</table>
<INPUT TYPE="hidden" name="count" id="count" value="<%=count%>">
<INPUT TYPE="hidden" name="mode" id="mode" value="U">
<INPUT TYPE="hidden" name="job" id="job" value="">
<INPUT TYPE="hidden" name="what" id="what" value="">
<INPUT TYPE="hidden" name="interval" id="interval" value="">
<INPUT TYPE="hidden" name="process_id" id="process_id" value="">
<!-- <INPUT TYPE="hidden" name="process_val" id="process_val" value=""> -->
<INPUT TYPE="hidden" name="process" id="process" value="">
<INPUT TYPE="hidden" name="select_option" id="select_option" value="">
<INPUT TYPE="hidden" name="last_date" id="last_date" value="">
<INPUT TYPE="hidden" name="next_date" id="next_date" value="">
<INPUT TYPE="hidden" name="long_desc" id="long_desc" value="">
<INPUT TYPE="hidden" name="intervalss" id="intervalss" value="">
<INPUT TYPE="hidden" name="err_msg" id="err_msg" value="">
<INPUT TYPE="hidden" name="action_type" id="action_type" value="U">
<INPUT TYPE="hidden" name="proc_date" id="proc_date" value="">
<INPUT TYPE="hidden" name="actionduplicate" id="actionduplicate" value=""> 
<INPUT TYPE="hidden" name="functionID" id="functionID" value="<%=functionID%>"> 


<script>

function funAction(typ)
{
	document.forms[0].action_type.value = typ;

	funSubmit();
}
function funSubmit()
{
	var act = '../../eXH/jsp/AdminOracleJobProcessList.jsp?';			   
	this.document.forms[0].action = act;
	this.document.forms[0].target='';
	this.document.forms[0].submit();	
}
</script>

</form>	
</BODY>
</HTML>

