<!DOCTYPE html>
<%@ page import ="java.sql.*,,java.util.*,java.io.*,webbeans.eCommon.*,eXH.XHReturnArray"%>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<%
	String appl_name = request.getParameter("appl_name");
	String appdes = request.getParameter("appdes");
	String facility_name = request.getParameter("facility_name");
	String facdes = request.getParameter("facdes");
	String msg_type = request.getParameter("msg_type");
	String messagedes = request.getParameter("messagedes");
	if(msg_type.equals("")) messagedes="";
	String event_type = request.getParameter("event_type");
	String eventdes = request.getParameter("eventdes");
	if(event_type.equals("")) eventdes="";
	String msgg_id = request.getParameter("msg_id");
	String msg_date = request.getParameter("msg_date");
	String mode = request.getParameter("mode");
   if(mode.equalsIgnoreCase("F")){
	if(locale.equalsIgnoreCase("th")) ;
		//msg_date=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","th","en");
   }
	
	
	String patient_id = request.getParameter("patient_id");
	String msg_status = request.getParameter("msg_status");

String sRespName="Message Tree";

String msg[][]=null;
ArrayList arraylist=null;
String event[][]=null;
String msgdate[][]=null;
String msgid[][]=null;

Connection con = ConnectionManager.getConnection(request);

try{
  	XHReturnArray arr=new XHReturnArray();
	if((mode.equals("T"))||(mode.equals("FT"))){
        
	    msg=arr.checkStatus(con,appl_name,facility_name,msg_type,event_type,"","","",msg_status,locale); 

	}
 else    msg=arr.checkStatus(con,appl_name,facility_name,msg_type,event_type,msg_date,msgg_id,patient_id,msg_status,locale); 
	if(msg.length!=0)
	{
    //******************************************************************************
	if(!mode.equals("FT")){
	if((!msg_date.equals(""))||(!msgg_id.equals(""))||(!patient_id.equals(""))){
	arraylist=arr.getArrayList(con,appl_name,facility_name,msg_type,event_type,msg_date,msgg_id,patient_id,msg_status,locale);
	if(arraylist.size()!=0){
	msg_type=(String)arraylist.get(0);
	messagedes=(String)arraylist.get(1);
	event_type=(String)arraylist.get(2);
	eventdes=(String)arraylist.get(3);
	msg_date=(String)arraylist.get(4);
	msgg_id=(String)arraylist.get(5);
	}
	}
	}
    //******************************************************************************

	
	event=arr.checkEvent(con,appl_name,facility_name,msg_type,event_type,msg_date,msgg_id,patient_id,msg_status,locale);
    msgdate=arr.getMsgdateArray(con,appl_name,facility_name,msg_type,event_type,msg_date,msgg_id,patient_id,msg_status,locale);
    msgid=arr.getMsgidArray(con,appl_name,facility_name,msg_type,event_type,msg_date,msgg_id,patient_id,msg_status,locale);




	//******************************************************************************
	}
	

%>
<script>
	

</script>

<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="menu_tree" id="menu_tree">

<input type='hidden' name='appl_name' id='appl_name' value='<%=appl_name%>'>
<input type='hidden' name='appdes' id='appdes' value='<%=appdes%>'>
<input type='hidden' name='facility_name' id='facility_name' value='<%=facility_name%>'>
<input type='hidden' name='facdes' id='facdes' value='<%=facdes%>'>
<input type='hidden' name='msg_type' id='msg_type' value='<%=msg_type%>'>
<input type='hidden' name='messagedes' id='messagedes' value='<%=messagedes%>'>
<input type='hidden' name='event_type' id='event_type' value='<%=event_type%>'>
<input type='hidden' name='eventdes' id='eventdes'value='<%=eventdes%>'>
<input type='hidden' name='msg_id' id='msg_id' value='<%=msgg_id%>'>
<input type='hidden' name='msg_date' id='msg_date' value='<%=msg_date%>'>
<input type='hidden' name='patient_id' id='patient_id'value='<%=patient_id%>'>
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

//****************************************************************************************************
//****************************************************************************************************
if(mode.equalsIgnoreCase("F"))
{
out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
out.println("d.add(1,0,'"+appdes+"','','Dir Menu','');"); 
out.println("d.add(2,1,'"+facdes+"','','Dir Menu','');"); 

if(!messagedes.equals(""))
{     
	  out.println("d.add(3,2,'"+messagedes+"','','Dir Menu','');"); 
      if(!eventdes.equals(""))
      {
         out.println("d.add(4,3,'"+eventdes+"','','Dir Menu','');");
		 if(!msg_date.equals(""))
		 {
             //String tempdate=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","en",locale);
			 String tempdate=msg_date;
		   out.println("d.add(5,4,'"+tempdate+"','','Dir Menu','');"); 
           if(!msgg_id.equals(""))
		   {
             out.println("d.add(6,5,'"+msgg_id+"',\"javascript:callmsgText('"+msgg_id+"','"+msgg_id+"')\" );");
		   }
		   else
		   {
		   
         if(msgid!=null){
		 for(int i=0;i<msgid.length;i++)
         { 
        out.println("d.add("+(6+i)+","+(5)+",'"+msgid[i][0]+"',\"javascript:callmsgText('"+msgid[i][1]+"','"+msgid[i][0]+"')\" );");
         }
		 }
		   }
		 }
         else
		 {
		  
		  if(msgdate!=null){
		 for(int i=0;i<msgdate.length;i++)
         { 
       	             //String tempdate=com.ehis.util.DateUtils.convertDate(msgdate[i][0],"DMY","en",locale);
					String tempdate=msgdate[i][0];
 out.println("d.add("+(5+i)+","+(4)+",'"+tempdate+"',\"javascript:callmsgid('"+msgdate[i][1]+"','"+msgdate[i][0]+"')\" );");
         }
		 }
		 
		 }
      }
      else
      {
         if(event!=null){
		 for(int i=0;i<event.length;i++)
         { 
        out.println("d.add("+(4+i)+","+(3)+",'"+event[i][0]+"',\"javascript:callmsgdate('"+event[i][1]+"','"+event[i][0]+"')\" );");
         }
		 }

      }

}
else
{
    	
  for(int i=0;i<msg.length;i++)
  { 
   out.println("d.add("+(3+i)+","+(2)+",'"+msg[i][0]+"',\"javascript:callevent('"+msg[i][1]+"','"+msg[i][0]+"')\" );");
  }


}
}

//***********************************************************************************************************
// 2 level
//***********************************************************************************************************
if(mode.equalsIgnoreCase("S"))
{
msg=arr.checkStatus(con,appl_name,facility_name,"","","","","",msg_status,locale); 
out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
out.println("d.add(1,0,'"+appdes+"','','Dir Menu','');"); 
out.println("d.add(2,1,'"+facdes+"','','Dir Menu','');"); 
int temp=0; 
for(int i=0;i<msg.length;i++)
{ 
  
   if(msg[i][1].equalsIgnoreCase(msg_type))
   { 
     out.println("d.add("+(3+i)+","+(2)+",'"+msg[i][0]+"','','Dir Menu','');"); 
     for(int j=0;j<event.length;j++)
     { 
       if(event[j][1].equalsIgnoreCase(event_type))
       {
	 
		out.println("d.add("+(4+j)+","+(3+i)+",'"+event[j][0]+"','','Dir Menu','');"); 

	   }
	   else
	   {
         out.println("d.add("+(4+i+j)+","+(3+i)+",'"+event[j][0]+"',\"javascript:callmsgdate('"+event[j][1]+"','"+event[j][0]+"')\" );");
		 temp=(4+i+j);
	   }
	 
	 }
     
   }
   else
   {
      int tval=0;
	  if(temp==0) tval=3+i;
	  else tval=temp+i;
       out.println("d.add("+(tval)+","+(2)+",'"+msg[i][0]+"',\"javascript:callevent('"+msg[i][1]+"','"+msg[i][0]+"')\" );");
          
   }
}
}

//******************************************************************************************************
//3 level
//*******************************************************************************************************
if(mode.equalsIgnoreCase("T"))
{
msg=arr.checkStatus(con,appl_name,facility_name,"","","","","",msg_status,locale); 
event=arr.checkEvent(con,appl_name,facility_name,msg_type,"","","","",msg_status,locale);
msgdate=arr.getMsgdateArray(con,appl_name,facility_name,msg_type,event_type,"","","",msg_status,locale);

out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
out.println("d.add(1,0,'"+appdes+"','','Dir Menu','');"); 
out.println("d.add(2,1,'"+facdes+"','','Dir Menu','');");


int tval=0;
int temp=0;
int tval1=0;
int tval2=0;

for(int i=0;i<msg.length;i++)
{ 
  
   if(msg[i][1].equalsIgnoreCase(msg_type))
   { if(tval2!=0) tval2=tval2+i;
     else tval2=3+i;
     out.println("d.add("+(tval2)+","+(2)+",'"+msg[i][0]+"','','Dir Menu','');"); 
    
	 for(int j=0;j<event.length;j++)
     {   
         if(event[j][1].equalsIgnoreCase(event_type))
         {
	         if(tval!=0) tval=tval+1;
            else tval=4+i+j;
		     out.println("d.add("+(tval)+","+(3+i)+",'"+event[j][0]+"','','Dir Menu','');"); 
		     for(int jj=0;jj<msgdate.length;jj++)
             { 
               
//          	   String tempdate=com.ehis.util.DateUtils.convertDate(msgdate[jj][0],"DMY","en",locale); 
					String tempdate=msgdate[jj][0];
			   out.println("d.add("+(tval+jj+1)+","+(4+j+i)+",'"+tempdate+"',\"javascript:callmsgid('"+msgdate[jj][1]+"','"+msgdate[jj][0]+"')\" );");
				
			   temp=(tval+1+jj);
			  
		     }
		
	     }
	     else
	     {    
			 
			
			 if(temp==0) tval=4+i+j;
			 else tval=temp+i+j;
           out.println("d.add("+tval+","+(3+i)+",'"+event[j][0]+"',\"javascript:callmsgdate('"+event[j][1]+"','"+event[j][0]+"')\" );");
	     }
	 
	}
     
   }
   else
   {

     if(temp>tval) tval1= temp ;
             else tval1=tval;
			 if(temp==0) tval2=3+i;
			 else tval2=tval1+i;

     out.println("d.add("+(tval2)+","+(2)+",'"+msg[i][0]+"',\"javascript:callevent('"+msg[i][1]+"','"+msg[i][0]+"')\" );");
          
   }

}
}
//*********************************************************************************************************
//3 level
//*********************************************************************************************************
if(mode.equalsIgnoreCase("FT"))
{
msg=arr.checkStatus(con,appl_name,facility_name,"","","","","",msg_status,locale); 
event=arr.checkEvent(con,appl_name,facility_name,msg_type,"","","","",msg_status,locale);
msgdate=arr.getMsgdateArray(con,appl_name,facility_name,msg_type,event_type,"","","",msg_status,locale);
msgid=arr.getMsgidArray(con,appl_name,facility_name,msg_type,event_type,msg_date,"","",msg_status,locale);

out.println("d.add(0,-1,'<b>"+sRespName+"</b>');");
out.println("d.add(1,0,'"+appdes+"','','Dir Menu','');"); 
out.println("d.add(2,1,'"+facdes+"','','Dir Menu','');"); 

 
int tval=0;
int temp=0;
int tval1=0;
int tval2=0;
int tval3=0;

for(int i=0;i<msg.length;i++)
{ 
  
   if(msg[i][1].equalsIgnoreCase(msg_type))
   { 
     out.println("d.add("+(3+i)+","+(2)+",'"+msg[i][0]+"','','Dir Menu','');"); 
     
	 for(int j=0;j<event.length;j++)
     {    
         if(event[j][1].equalsIgnoreCase(event_type))
         {
	         
		     out.println("d.add("+(4+j+i)+","+(3+i)+",'"+event[j][0]+"','','Dir Menu','');"); 
			
		     for(int jj=0;jj<msgdate.length;jj++)
             { 
               

			   if(msgdate[jj][1].equalsIgnoreCase(msg_date))
               {
	             //String tempdate=com.ehis.util.DateUtils.convertDate(msgdate[jj][0],"DMY","en",locale);
				String tempdate=msgdate[jj][0];
				out.println("d.add("+(5+jj+j+i)+","+(4+j+i)+",'"+tempdate+"','','Dir Menu','');"); 
                
                for(int  jjj=0;jjj<msgid.length;jjj++)
				 {
                  out.println("d.add("+(6+jj+j+jjj+i)+","+(5+j+jj+i)+",'"+msgid[jjj][0]+"',\"javascript:callmsgText('"+msgid[jjj][1]+"','"+msgid[jjj][0]+"')\" );");
				  temp=6+jj+j+jjj+i;
				 }

			   }
			   else{
                      
			          if(temp==0) tval=5+jj+j+i;
			          else tval=temp+jj+i;
					//   String tempdate=com.ehis.util.DateUtils.convertDate(msgdate[jj][0],"DMY","en",locale);
						String tempdate=msgdate[jj][0];
					   out.println("d.add("+(tval)+","+(4+j)+",'"+tempdate+"',\"javascript:callmsgid('"+msgdate[jj][1]+"','"+msgdate[jj][0]+"')\" );");
				
			      }

		     }
		
	     }
	     else
	     {    
			 
			 if(temp>tval) tval1= temp ;
             else tval1=tval;
			 if(temp==0) tval2=4+i+j;
			 else tval2=tval1+i+j;
            out.println("d.add("+tval2+","+(3+i)+",'"+event[j][0]+"',\"javascript:callmsgdate('"+event[j][1]+"','"+event[j][0]+"')\" );");
	     }
	 
	}
     
   }
   else
   {
       if(temp>tval2) tval2= temp ;
             else tval2=tval1;
			 if(temp==0) tval3=3+i;
			 else tval3=tval2+i;

     out.println("d.add("+(tval3)+","+(2)+",'"+msg[i][0]+"',\"javascript:callevent('"+msg[i][1]+"','"+msg[i][0]+"')\" );");
          
   }

}
}

}
//***********************************************************************************
%>
<%}	catch (Exception e) {
		out.println(e) ;
		e.printStackTrace(System.err) ;
	}
		finally {
			
			ConnectionManager.returnConnection(con) ;
		}
//***************************************************************************************************
%>
document.write(d);
d.openAll();
parent.expand();
parent.openAll();
</script>
<% if(msg.length==0){ %>
<script>
alert(getMessage('XH1021'));
</script>
<% }

if(arraylist!=null) arraylist.clear();
%>
<form>
</body>
</div>
</HTML>

