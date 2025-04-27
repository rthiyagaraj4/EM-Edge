<!DOCTYPE html>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js"></Script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eSM/js/BackGroundProcesses.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function refreshmsg()
		{
			if(self.document.forms[0].mode.value=="modify")
			parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp";
		}
		async function Search()
		{
			parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp";
			var retVal;
			var dialogHeight= "80vh" ;
			var dialogWidth	= "60vw" ;
			var dialogTop = "200" ;
			var dialogLeft = "144" ;
			var center = "1" ;														   
			var status="no";
			var title=getLabel("eSM.BackGroundProcesses.label","SM");
			var features	= "dialogLeft: "+ dialogLeft + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";dialogTitle :"+title;
			var arguments	= "" ;
			var url = "../../eSM/jsp/SearchProcMain.jsp?procid="+document.BackGroundProcess.proc_id.value;

			retVal = await top.window.showModalDialog(url,arguments,features);
			if(retVal!=null)	
			{
				var a = retVal.split("`");
				document.forms[0].proc_id.value=a[0];
				getproc_name(a[0]);
			}

			return retVal;  

		}
		function aa()
		{
				getproc_name(document.forms[0].proc_id.value);
	}
		function getproc_name(p)
		{

			var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='GetProcName.jsp?proc_id="+p+"'></form></BODY></HTML>";

		
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.forms[0].submit();

				//document.forms[0].Submit.disabled=false;
				document.forms[0].mode.value="insert";
				document.forms[0].next_execution_date.value=convertDate(document.forms[0].sys_Date.value,"DMYHM","en",localeName);
				document.forms[0].interval.value="";

		}

		function CheckInterval(obj)
		{
	
			if(obj.value!="")
			{
			if(obj.value>0){
				CheckPositiveNumber(obj);
			}
			else
			{
				
				alert(getMessage('ONLY_POSITIVE_NUM','SM'));
				obj.select();
				obj.value="";
				obj.focus();
			}
			}
				
		}
		
		function callproc()
		{
			if(document.forms[0].proc_id.value=="")
			{  
				
				var msg=getMessage("PROC_ID_NOT_BLANK",'SM');
				alert(msg);
				return false
			}
		    if(document.forms[0].next_execution_date.value=="")
			{
				var msg=getMessage("NXT_EXE_TIME_NOT_BLANK","SM");
				alert(msg);
				return false
			
				
			}
			document.forms[0].job_type.value="S";
			parent.frames[2].document.forms[0].action="../../servlet/eSM.BackGroundProcessServlet";
			parent.frames[2].document.forms[0].target="messageFrame";
			parent.frames[2].document.forms[0].submit();
		}
		function callproc1()
		{
			document.forms[0].job_type.value="C";
			parent.frames[2].document.forms[0].action="../../servlet/eSM.BackGroundProcessServlet";
			parent.frames[2].document.forms[0].target="messageFrame";
			parent.frames[2].document.forms[0].submit();
		}
		
		function callproc2()
		{
	
			var msg=getMessage("JOB_IS_RUNNING",'SM');
			parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
			//alert(msg)
			document.forms[0].job_type.value="E";
			parent.frames[2].document.forms[0].action="../../servlet/eSM.BackGroundProcessServlet";
			parent.frames[2].document.forms[0].target="messageFrame";
			parent.frames[2].document.forms[0].submit();
			
			//parent.frames[2].document.forms[0].Submit.disabled=false;
			parent.frames[2].document.forms[0].Change.disabled=true;
			parent.frames[2].document.forms[0].Remove.disabled=true;
		}
		
		function callproc3()
		{
			document.forms[0].job_type.value="R";
			parent.frames[2].document.forms[0].action="../../servlet/eSM.BackGroundProcessServlet";
			parent.frames[2].document.forms[0].target="messageFrame";
			parent.frames[2].document.forms[0].submit();
			
		}

/** Added for Date Validation **/

		function ValidateDateTimesp(obj)
		{
			if(!(obj.value==""))
			{
				if(validDateObj(obj,"DMYHM",localeName))
				{
					if(!(isAfterNow(obj.value,"DMYHM",localeName)))
					 {
						obj.focus();
						obj.select();
						obj.value='';
						alert(getMessage('DT_NLT_CURR_DT','SM'));
					  }
				}
			 }
		}

	/*	function newfn(obj)
		{
			if(!(obj.value==""))
			{
			if(callme(obj))
				{	
				if(!ValidateDateTime(document.forms[0].sys_Date,obj))
					alert(getMessage('DT_NLT_CURR_DT','SM'));
				}
			}
		}
function ValidateDateTime(from,to)
{
	from = from.value
	to		= to.value
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]
	
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	 a=  to.split(" ")
	 splitdate=a[0];
	 splittime=a[1]
	 splitdate1 =a[0].split("/")
	 splittime1= a[1].split(":")
	
	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	 if(Date.parse(to_date) < Date.parse(from_date))
			return false
	else
			return true;	
}

function callme(obj)
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
				
                if(!checkDt1(dt) )
                {
                    retval= false
                    comp.focus()
                }
                else
                {
                 
					if(time==null || time=="")
                    {
                        alert(getMessage("INVALID_DATE_TIME","SM"))
                        comp.focus()
                    }

                    else
                    {	

                        if(!chkTime(time))
                        {
                                retval= false
                                alert(getMessage("INVALID_DATE_TIME","SM"))
                                comp.focus()
                        }
                    }
                }
            }
            else
            {
                retval= false
                alert(getMessage("INVALID_DATE_TIME","SM"))
                comp.focus()
            }

            if(retval)
            {
                
            }
        return retval
}
		 function checkDt1(date1)
        {
            retval=true
            var date1arr=new Array()

            date1arr=date1.split("/")

            if(date1arr.length==3)
            {
                var date1d=date1arr[0]
                var date1m=date1arr[1]
                var date1y=date1arr[2]

                date1d=parseInt(date1d)
                date1m=parseInt(date1m)
                date1yy=parseInt(date1y);

				if (date1m>12 || date1m<1)  return false;

                if(date1m<=12)
                {

                    if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31 || date1d < 1))
                    {
                    retval= false}

                    if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30 || date1d < 1))
                    {
                    retval= false}

                    if ((date1y.length <4) || (date1y.length >4))
                        {
                        retval= false}
					if (date1m == 2) 
					{
						if (date1d < 1) return false;
						if (LeapYear(date1y) == true) 
						{
							if (date1d > 29) return false;
						}
						else 
						{
							if (date1d > 28) return false;
						}
					}
                 }
                else
                    {
                    retval= false;}
            }
            else
                {retval= false;}
                return retval;
            }

        function chkTime(time1)
        {				

            var retval=true;

            if( (time1.charAt(time1.length-1) )!=":")
            {
                var time1arr=new Array()
                time1arr=time1.split(":")

                if( isNaN(parseInt(time1arr[0])))   return false ;
                if( isNaN(parseInt(time1arr[1])))   return false ;

                if(time1arr.length==2)
                {

                    var time1hr=time1arr[0]
                    var time1min=time1arr[1]

                    time1hr=parseInt(time1hr)
                    time1min=parseInt(time1min)
                    if(time1hr<=23)
                    {
                        if(time1min>=60)
                        {
                                retval=false;
                              
                        }
                    }
                    else
                            retval=false;

                }
                else
                    retval=false;

            }
            else
                    retval=false;


            return retval
        }



function LeapYear(strYear) {
    if (strYear % 100 == 0) {
        if (strYear % 400 == 0)  return true;
    }
    else {
        if ((strYear % 4) == 0)  return true;
    }
    return false;
}*/


function ValidateDate(from,to,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				var errormess = getMessage("NOSHOW_FM_DT_VALIDATION",'SM');  
				alert(errormess);
				//from.select();
				from.value="";
							//from.focus();
			}
	}	
}


function ValidateDate1(from,to,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
			alert(getMessage("OUTCOME_DT_GT_DIAG_DATE",'SM'));
				//to.select();
				//to.focus();
				to.value="";
			}
	}	
}

function CheckPositiveNumber1(obj) {
	if ( obj.value!=null && trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0)
		{		
	}
	else {
  		if ( obj.value.length > 0 ) {
  			alert(getMessage('ONLY_POSITIVE_NUM','SM'));
  			//obj.select();
  			//obj.focus();
  			obj.value="";
  		}
  		else if ( obj.value.length == 0 );
  	
  	}
}

		</script>
</head>
<%
request.setCharacterEncoding("UTF-8");
String locale		= (String)session.getAttribute("LOCALE");
String proc_id      =  request.getParameter("proc_id");


if(proc_id==null) proc_id="";

String proc_name="";
String next_execution_date="";
String interval="";
String job="";
String proc_srt_cmd="";

String sql="";
String mode="insert";
String dis_submit="disabled";
String dis_submit1="disabled";

String sys_Date="";

Connection con=null;
Statement stmt=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
CallableStatement  cs = null;

try{
	con = ConnectionManager.getConnection(request);

	boolean isConOGGApplicable	= CommonBean.isSiteSpecific(con, "SM","GGS_OWNER_BKG_JOB");


	stmt = con.createStatement();	
	String syssql = "select to_char(sysdate,'dd/mm/yyyy hh24:mi')  from dual";
	ResultSet rssql=stmt.executeQuery(syssql) ;
	if(rssql!=null)
	{
	 while(rssql.next())
	 {
		sys_Date = rssql.getString(1);
		next_execution_date=sys_Date;
	 }
	}
	if(rssql!=null)rssql.close();
	if(stmt!=null)stmt.close();
	sql=" Select proc_name, to_char(next_execution_date,'dd/mm/yyyy hh24:mi') next_execution_date1, rtrim(rtrim(rtrim(rtrim(ltrim(ltrim(ltrim(ltrim(lower(interval)),'sysdate')),'+')),'1440')),'/') interval1, job, proc_srt_cmd from sm_jobs_vw where proc_id='"+proc_id+"' ";

	
	stmt = con.createStatement();	
	rs=stmt.executeQuery(sql);
	if(rs!=null)
	{
		while(rs.next())
		{
			proc_name=rs.getString("proc_name");
			if(proc_name==null) proc_name="";

			next_execution_date=rs.getString("next_execution_date1");
			if(next_execution_date==null) next_execution_date="";

			interval=rs.getString("interval1");
			if(interval==null) interval="";
			else if(interval.equals("null")) interval="";

			job=rs.getString("job");
			if(job==null) job="";

			proc_srt_cmd=rs.getString("proc_srt_cmd");
			if(proc_srt_cmd==null) proc_srt_cmd="";

			mode="modify";
		}

	}
	else
	{
		mode="insert";
	
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	
	if(mode.equals("insert"))
	{   
		
		cs = con.prepareCall( "{ call CHK_JOB_QUEUE(?, ?)}");
			
			cs.setString ( 1,proc_srt_cmd   ) ;
			cs.registerOutParameter( 2,  Types.INTEGER ) ;
			cs.execute();
			int status=cs.getInt(2);
			if(status>0) 
			{
				dis_submit="disabled";
				out.println("<script>alert(getMessage('JOB_ALREADY_IN_QUEUE','SM'));</script>");
				
			}
	}


	if(mode.equals("modify") ) 
	{
		dis_submit="disabled";
		dis_submit1="";
	}
	else if(mode.equals("insert"))
	{
		dis_submit="disabled";
		dis_submit1="disabled";
	}


if(mode.equals("insert"))
	{


		String strsql2="select long_desc from sm_proc_id where controllable_yn='Y'  and proc_id='"+proc_id+"'";
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2);
		if(rs!=null)
		{
			while(rs.next())
			{
				proc_name=rs.getString(1);
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
	
	   if(!proc_id.equals(""))
		{pstmt=con.prepareStatement("select count(*) cnt  from sm_jobs_vw where   proc_id='"+proc_id+"'");
        
		rs=pstmt.executeQuery();
		rs.next();
		
		proc_id	="";
		proc_name="";
		next_execution_date="";
		interval="";
		if(rs.getInt("cnt")==0)
		{%>
      <script>parent.parent.frames[1].location.reload();parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+getMessage("JOB_DOESNOT_EXIST","SM")+'&err_value=0';  </script>
	
	  
	  <%}
		}
	
	
	}
if(pstmt!=null)pstmt.close();
if(rs!=null)rs.close();
next_execution_date=DateUtils.convertDate(next_execution_date,"DMYHM","en",locale);
%>
<body onload='refreshmsg()' onKeyDown = 'lockKey()' onmousedown='CodeArrest()'>
<form name='BackGroundProcess' id='BackGroundProcess'  action="../../servlet/eSM.BackGroundProcessServlet" method='post' target='messageFrame'>
<table border=0 cellspacing=0 cellpadding=0 width='100%'>
	<th width='100%' colspan=6 align=left><fmt:message key="Common.ProcessDetails.label" bundle="${common_labels}"/></th>
	<tr>
		<td width='2%'>&nbsp;</td>
		<td width='24%'>&nbsp;</td>
		<td width='24%'>&nbsp;</td>
		<td width='24%'>&nbsp;</td>
		<td width='24%'>&nbsp;</td>
		<td width='2%'>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td class=label><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type='text' name='proc_id' id='proc_id' value='<%=proc_id%>' size=18 maxlength=30 onblur='if(this.value!="") Search()'><input type='button' name='?' id='?' value='?' class='button' onclick='Search()'> <img align=center src='../../eCommon/images/mandatory.gif'></img></td>
		<td class=label ><fmt:message key="Common.ProcessName.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type='text' name='proc_name' id='proc_name' value='<%=proc_name%>' size=30 maxlength=30 readonly> </td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=6>&nbsp;</td>
	</tr>
	<tr>

		<td>&nbsp;</td>
		<td class=label ><fmt:message key="eSM.NextExecutionDateTime.label" bundle="${sm_labels}"/></td>
		<td class="fields"><input type='text' id='next_execution_date' name='next_execution_date' value='<%=next_execution_date%>'  onblur='ValidateDateTimesp(this)' size=16 maxlength=16><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick=" return showCalendar('next_execution_date',null,'hh:mm')"> 
      <img src='../../eCommon/images/mandatory.gif'></img></td>
		<td class=label><fmt:message key="Common.Interval(min).label" bundle="${common_labels}"/></td>
		<td class="fields"><input type='text' name='interval' id='interval' value='<%=interval%>' size=9 maxlength=9 onblur='CheckInterval(this)'></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=6>&nbsp;</td>
	</tr>
</table>
<table align=right border=0 cellspacing=0 cellpadding=0>
	<tr>
		<td class="fields"><input type= 'button' class='button' name= 'Submit' id= 'Submit' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Submit.label","common_labels")%>' onclick='callproc()' <%=dis_submit%>></td>
		<td class="fields"><input type= 'button' class='button' name= 'Change' id= 'Change' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.change.label","common_labels")%>' onclick='callproc1()' <%=dis_submit1%>></td>
		<td class="fields"><input type= 'button' class='button' name= 'Run' id= 'Run' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.run.label","common_labels")%>' onclick='callproc2()' <%=dis_submit1%>></td>
		<td class="fields"><input type= 'button' class='button' name= 'Remove' id= 'Remove' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>' onclick='callproc3()' <%=dis_submit1%>>	</td>
	</tr>
</table>
<input type='hidden' name='job_type' id='job_type' value=''> 
<input type='hidden' name='job' id='job' value='<%=job%>'>
<input type='hidden' name='sys_Date' id='sys_Date' value='<%=sys_Date%>'>
<input type='hidden' name='proc_srt_cmd' id='proc_srt_cmd' value='<%=proc_srt_cmd%>'>
<input type='hidden' name='mode' id='mode'  value='<%=mode%>'>
<input type='hidden' name='procid' id='procid' value='<%=proc_id%>'>
<input type='hidden' name='isConOGGApplicable' id='isConOGGApplicable' value='<%=isConOGGApplicable%>'>
</form>
</body>
<%
		if(stmt!=null) stmt.close();
		if(cs!=null) cs.close();
		
	}catch(Exception e){out.println(e);}
finally {
		ConnectionManager.returnConnection(con,request);
}	
%>

</html>

