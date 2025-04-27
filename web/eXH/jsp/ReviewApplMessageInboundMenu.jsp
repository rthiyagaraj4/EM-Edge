<!DOCTYPE html>
<%@ page import ="java.sql.*,,java.util.*,java.io.*,webbeans.eCommon.*,eXH.XHReturnArray"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<%
	String appl_name = request.getParameter("appl_name");
	String appdes = request.getParameter("appdes");
	String client_id = request.getParameter("client_id");
	String msgg_id = request.getParameter("msg_id");
	String msg_date = request.getParameter("msg_date");
	String mode = request.getParameter("mode");
   	 if(mode.equalsIgnoreCase("F")){
	if(locale.equalsIgnoreCase("th")) msg_date=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","th","en");
   }
	String msg_status = request.getParameter("msg_status");
 String sRespName="Message Tree";
String msg[][]=null;
String msgid[][]=null;
String client_ida[][]=null;
Connection con = ConnectionManager.getConnection(request);
try{
  	XHReturnArray arr=new XHReturnArray();
	if(client_id.equals(""))
	{ 
		client_ida=arr.getClient_id(con,appl_name,client_id,msg_date,msgg_id,msg_status,locale);
		if(client_ida.length!=0) client_id=client_ida[0][0];
		else client_id="Not defined";
    }
	if(mode.equalsIgnoreCase("S"))
    {
	msg=arr.returnInbound(con,appl_name,client_id,msg_date,"",msg_status,locale);}
	else {
	
		msg=arr.returnInbound(con,appl_name,client_id,msg_date,msgg_id,msg_status,locale);

	}
	msgid=arr.returnInboundmsgid(con,appl_name,client_id,msg_date,msgg_id,msg_status,locale);
%>

<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="menu_tree" id="menu_tree">
<input type='hidden' name='appl_name' id='appl_name' value='<%=appl_name%>'>
<input type='hidden' name='appdes' id='appdes' value='<%=appdes%>'>
<input type='hidden' name='client_id' id='client_id' value='<%=client_id%>'>
<input type='hidden' name='msg_id' id='msg_id' value='<%=msgg_id%>'>
<input type='hidden' name='msg_date' id='msg_date' value='<%=msg_date%>'>
<input type='hidden' name='msg_status' id='msg_status'value='<%=msg_status%>'>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<div class='dtree'>
<script type='text/javascript' src='../../eXH/js/dtree.js'></script></head>
<script type='text/javascript'>
	d = new dTree('d');
	d.config.useStatusText=true;
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body class='TREEBODY' >

<script>
<%
if(msg.length!=0){

//***********************************************************************************************************
//***********************************************************************************************************
if(mode.equalsIgnoreCase("F"))
{
msg=arr.returnInbound(con,appl_name,client_id,"","","",locale); 

out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
out.println("d.add(1,0,'"+client_id+"','','Dir Menu','');"); 
out.println("d.add(2,1,'"+appdes+"','','Dir Menu','');"); 

if(!msg_date.equals(""))
{     String tempdate=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","en",locale);
 	  out.println("d.add(3,2,'"+tempdate+"','','Dir Menu','');"); 
      if(!msgg_id.equals(""))
      {
         out.println("d.add(4,3,'"+msgg_id+"',\"javascript:callmsgTextmsg('"+msgg_id+"','"+msgg_id+"')\" );");
	  }	 
      else
      {
         if(msgid!=null){
		 for(int i=0;i<msgid.length;i++)
         { 
        out.println("d.add("+(4+i)+","+(3)+",'"+msgid[i][0]+"',\"javascript:callmsgTextmsg('"+msgid[i][1]+"','"+msgid[i][0]+"')\" );");
         }
		 }

      }

}
else
{
    	
  for(int i=0;i<msg.length;i++)
  { 
     String tempdate=com.ehis.util.DateUtils.convertDate(msg[i][0],"DMY","en",locale);
   out.println("d.add("+(3+i)+","+(2)+",'"+tempdate+"',\"javascript:callmsgIdIN('"+msg[i][1]+"','"+msg[i][0]+"')\" );");
  }
}
}

if(mode.equalsIgnoreCase("S"))
{
msg=arr.returnInbound(con,appl_name,client_id,"","","",locale); 
msgid=arr.returnInboundmsgid(con,appl_name,client_id,msg_date,"","",locale); 
out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
out.println("d.add(1,0,'"+client_id+"','','Dir Menu','');"); 
out.println("d.add(2,1,'"+appdes+"','','Dir Menu','');"); 
int temp=0;
for(int i=0;i<msg.length;i++)
{ 
  
   if(msg[i][1].equalsIgnoreCase(msg_date))
   { 
         String tempdate=com.ehis.util.DateUtils.convertDate(msg[i][0],"DMY","en",locale);
	  out.println("d.add("+(3+i)+","+(2)+",'"+tempdate+"','','Dir Menu','');"); 
      for(int j=0;j<msgid.length;j++)
      { 
        	 
		out.println("d.add("+(4+i+j)+","+(3+i)+",'"+msgid[j][0]+"',\"javascript:callmsgTextmsg('"+msgid[j][0]+"','"+msgid[j][0]+"')\" );");
		temp=4+j;
      }
  
   }
   else
	{  int tval=0;
	   if (temp==0) tval=3+i;
       else tval=temp+i+1;
         String tempdate=com.ehis.util.DateUtils.convertDate(msg[i][0],"DMY","en",locale);
      out.println("d.add("+(tval)+","+(2)+",'"+tempdate+"',\"javascript:callmsgIdIN('"+msg[i][1]+"','"+msg[i][0]+"')\" );");

	
	}
}
}

}
//***************************************************************************
%>
<%}	catch (Exception e) {
		out.println(e) ;
		e.printStackTrace(System.err) ;
	}
		finally {
			
			ConnectionManager.returnConnection(con) ;
		}
//***************************************************************************
%>
document.write(d);
d.openAll();
parent.expand();
</script>
<% if(msg.length==0){ %>
<script>
alert(getMessage('XH1021','XH'));
</script>
<% }%>
<form>
</body>
</div>
</HTML>

