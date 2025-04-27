<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import="java.sql.*,java.util.*,java.io.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.*,oracle.jdbc.driver.*" %>
<link rel="StyleSheet" href="../../eXH/html/IeStyle.css" type="text/css" />
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
System.out.println("XHViewMessageSimulateDisplay.jsp 7:");
request.setCharacterEncoding("UTF-8"); 
Properties p = (Properties) session.getValue("jdbc"); 
%>		
<HEAD> 
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<style type = 'text/css'> 
TD.COLUMNHEADER { 														    	    
   BACKGROUND-COLOR: #404040;
   COLOR: white ; 															  
   FONT-SIZE: 8pt;   
   font-weight: bolder;
   PADDING-LEFT:7px;
   PADDING-RIGHT:7px
}
  </STYLE>
<%  
	Connection connection = null;
	CallableStatement  oraclecallablestatement = null;
	boolean authToElement = false;
	try
	{
	if(connection == null) connection = ConnectionManager.getConnection();
	String rule=request.getParameter("rule");
	String rule2=request.getParameter("rule2");
	String img = XHDBAdapter.checkNull(request.getParameter("img"));
		

%>																							    
	
<link rel="StyleSheet" href="../../eXH/html/IeStyle.css" type="text/css" />
<link rel="StyleSheet" href="../../eXH/html/dtree.css" type="text/css" />
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel="StyleSheet" href="../../eXH/html/lris_style.css" type="text/css" />
<script type="text/javascript" src="../../eXH/js/dtree1.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script> 					    
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 

 </head>
 <BODY   >     														      
<form name="view_segment_form" id="view_segment_form">
<div class="dtree">																			 
<table cellspacing=0 cellpadding=3 width='99%' align=center >
<tr> 
<td>
<%		
	 String Msg_syntax="";
	String url="";									  
	String event_name=""; 
	String applicationId = "";
	String facilityId = "";
	String msgId = "";
	String eventType = "";
	String ProtocolID = "";
	String Msq_txt = "";
	String MsgText = "";
	String Standard_code = "";
	String Message_syntax = "";
	String Standard_symbols = "";
	String errorMsg = "";
	String event="";
	String Standard_type = "";
	String msgstatus = "";
	String applicationName=XHDBAdapter.checkNull(request.getParameter("applicationName"));
	String facilityName=XHDBAdapter.checkNull(request.getParameter("facilityName"));
	String protocol_mode = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
	String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
	String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
    applicationId = XHDBAdapter.checkNull(request.getParameter("applicationID")); 
    facilityId = XHDBAdapter.checkNull(request.getParameter("facilityID"));
    msgId = XHDBAdapter.checkNull(request.getParameter("msgID"));				     
    ProtocolID = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
	String Msg_text=java.net.URLDecoder.decode(XHDBAdapter.checkNull(request.getParameter("Msg_text")));	     
	System.out.println("applicationName :"+applicationName+"facilityName :"+facilityName+"protocol_mode :"+protocol_mode+"sub_module :"+sub_module+"srlNo :"+srlNo+"applicationId :"+applicationId+"facilityId :"
	+facilityId+"msgId :"+msgId+"ProtocolID :"+ProtocolID+"Msg_text :"+Msg_text);
	
														     
	if(protocol_mode.equals("Inbound")) 														 
	{
		protocol_mode="I";  									 
	} 																   
	else if(protocol_mode.equals("Outbound"))
	{
	protocol_mode="O";
	}
    eventType = request.getParameter("even_type");										 
	String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
    event_name=XHDBAdapter.checkNull(request.getParameter("event_name"));
	try
	{
		oraclecallablestatement =  connection.prepareCall("{ call xhgeneric.standard_message_viewer(?,?,?,?,?,?,?,?,?,?,?) }" ); 
		oraclecallablestatement.setString(1,applicationId);

		System.out.println("applicationId :"+applicationId);

		oraclecallablestatement.setString(2,facilityId);
		System.out.println("facilityId :"+facilityId);
		oraclecallablestatement.setString(3,msgId);
		System.out.println("msgId :"+msgId);
		oraclecallablestatement.setString(4,ProtocolID);	
		System.out.println("ProtocolID :"+ProtocolID);
		oraclecallablestatement.setString(5,eventType);
		System.out.println("eventType :"+eventType);			  
		CLOB clob = CLOB.createTemporary(connection, true, CLOB.DURATION_SESSION);						 
		java.io.Writer out1 = clob.getCharacterOutputStream();							    
		out1.write(Msg_text);		 
		out1.close(); 
		oraclecallablestatement.setClob(6, clob); 
		oraclecallablestatement.registerOutParameter(6,java.sql.Types.CLOB);
		oraclecallablestatement.registerOutParameter(7,java.sql.Types.VARCHAR);							  
		oraclecallablestatement.registerOutParameter(8,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(9,java.sql.Types.CLOB);
		oraclecallablestatement.registerOutParameter(10,java.sql.Types.VARCHAR);
		oraclecallablestatement.registerOutParameter(11,java.sql.Types.VARCHAR);
		oraclecallablestatement.execute();
		MsgText = oraclecallablestatement.getString(6);						     
		Standard_code = oraclecallablestatement.getString(7);
		Standard_type = oraclecallablestatement.getString(8);
		Message_syntax = oraclecallablestatement.getString(9).trim();

		System.out.println("Message_syntax 131 :"+Message_syntax);
		Standard_symbols = oraclecallablestatement.getString(10).trim();

		System.out.println("Standard_symbols :"+Standard_symbols);

		errorMsg = oraclecallablestatement.getString(11);	
		
			System.out.println("errorMsg :"+errorMsg);
		if(Standard_symbols.indexOf("{64")!=-1)
		{
			Message_syntax=Message_syntax.replaceFirst("@","[");
			MsgText=MsgText.replaceFirst("@","[");
			Standard_symbols=Standard_symbols.replaceFirst("64","91");
		}
		System.out.println("errorMsg 2:");
		Msg_syntax =java.net.URLEncoder.encode(Message_syntax);
		Msg_text = java.net.URLEncoder.encode(MsgText);
			//java.net.URLEncoder.encode(MsgText);
		System.out.println("errorMsg 4:");
	//	System.out.println("XHViewMessageSimulateDisplay Msg_syntax 136:"+Msg_syntax);
		//System.out.println("XHViewMessageSimulateDisplay Msg_text 136:"+Msg_text);
		if(oraclecallablestatement!=null) 
		oraclecallablestatement.close();
	}
	catch(Exception exp)
    {
       																			  
	   exp.printStackTrace(System.err);
	   System.out.println("(ViewTree:StandardMessageViewer)Exception: "+exp);
    }


	//catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewSegments :"+ex.toString());
	//	   ex.printStackTrace(System.err); }
	    
%>
<input type=hidden id='Standard_Symbols' name='Standard_Symbolsright' id='Standard_Symbolsright' value='<%=Standard_symbols%>' > 
<input type=hidden name='Facility' id='Facility' value='' >
<input type=hidden name='Message_ID' id='Message_ID' value='' >
<input type=hidden name='Protocol_link' id='Protocol_link' value='' >
<input type=hidden id='Message_text' name='Message_textright' id='Message_textright' value='<%=Msg_text%>'  >	   
<input type=hidden id='Message_Syn' name='Message_Synright' id='Message_Synright' value='<%=Msg_syntax%>' >
<input type=hidden id='rule' name='rule' id='rule' value='<%=rule%>' >
<input type=hidden id='Standard_code' name='Standard_code' id='Standard_code' value='<%=Standard_code%>' >
<input type=hidden id='Standard_type' name='Standard_typeright' id='Standard_typeright' value='<%=Standard_type%>' >
<input type=hidden id='rules' name='rules' id='rules' value='<%=rule2%>'>
<input type=hidden id='applicationId' name='applicationId' id='applicationId' value='<%=applicationId%>'>
<input type=hidden id='facilityId' name='facilityId' id='facilityId' value='<%=facilityId%>'>
<input type=hidden id='Msg_Id' name='Msg_Id' id='Msg_Id' value='<%=msgId%>'>
<input type=hidden id='even_type' name='even_type' id='even_type' value='<%=eventType%>'>
<input type=hidden id='ProtocolID' name='ProtocolID' id='ProtocolID' value='<%=ProtocolID%>'>
<input type=hidden id='sub_module' name='sub_module' id='sub_module' value='<%=sub_module%>'>
<input type=hidden id='applicationName' name='applicationName' id='applicationName' value='<%=applicationName%>'>
<input type=hidden id='facilityName' name='facilityName' id='facilityName' value='<%=facilityName%>'>
<input type=hidden id='protocolMode' name='protocolMode' id='protocolMode' value='<%=protocol_mode%>'>
<input type=hidden id='srlNo' name='srlNo' id='srlNo' value='<%=srlNo%>'>
<input type=hidden id='event_name' name='event_name' id='event_name' value='<%=event_name%>'>
<input type=hidden id='element' name='element' id='element' value=''>
<input type=hidden id='img' name='img' id='img' value='<%=img%>'>

<input type="hidden" name="purge_status" id="purge_status" id="purge_status" value='<%=purge_status%>'/> 
<script>
try { 
var remind=0;
var eventre=0;
var deboo=false;
var Mainboolean=true;
var comsixteen;
var storecap="";
var gendrcou=0;
var boxte=0;
var storegenc=0;
d = new dTree('d');
var caplength=0;
var pipsing=-1;
var capcsec=0;
var dollor=0;
var countingpip=new Array();
var countcap=new Array();
var treeval =new Array();
var tswArr =new Array();
var AtArr =new Array();
var ExcArr =new Array();
var pipArr =new Array();
var capArr =new Array();
var TextVal=new Array();
var tswVal=new Array();
var AtVal=new Array();
var ExcVal=new Array(); 
var PiptVal=new Array();
var CapVal=new Array();
var AmperVal=new Array();
var OpenVal=new Array();
var piplength=0;
var CloseVal=new Array();
var tsw=0;
var cou=1;
var Exc=0;
var At=0;
var pip=0;
var tswt=0;
var Att=0;
var Exct=0;
var Pipt=0;
var cc=0;
var cc1=-1;
var Capt=0;
var Ampert=0;
var cate=-1;
var storecate=0
var treeval =new Array();
var hashArr =new Array();
var dolArr =new Array();
var perArr =new Array();
var pipArr =new Array();
var capArr =new Array();
var dolVal=new Array();
var PerVal=new Array();
var hashVal=new Array();
var TextVal=new Array();
var Open=0;
var Amper=0;
var Opent=0;
var Closet=0;
var pip=0;var Cap=0;
var elementflag=false;
var hash=0;
var hashCou;
var dolCou;
var perCou;
var pipCou;
var capCou;
var l_pos;
var boo=true;
var cou=1;
var temp='';
var perce=0;
var dola=0;
var som=0;
var pip=0;
var hasht=0;
var dolt=0;
var Pert=0;
var ll=0;
var capte1=0;
var k2="";
var ic3=0;
var symbolvalue;
var losec=0;
var temp='';
var d1=0;
var val="";
var piptwoarray=new Array();
var captwoarray=new Array();
var captwoarraysec=new Array();
var acchar=0;
var sy='';
var Symbols=new Array();
var elementval=new Array();
var s1=0;
var Lesstan=new Array();
var less=0;
var MessageHead="";
var CapVal1=new Array();
var Capt1=0;
var boxval=new Array();
var box=0;
var checkpu=0;
var messegetext=unescape(document.forms[0].Message_textright.value); 
var Messegesyntax=unescape(document.forms[0].Message_Synright.value); 
   

var emptyflag=false;
if(Messegesyntax=='')
{
	var message=getMessage('XH0076','XH');
	message=message.replace('$','');
	   alert(message);
	   emptyflag=true;
	/*parent.f_query_add_mod_tree.document.location.href="../../eXH/jsp/XHViewMessageSimulateDisplay.jsp?applicationID="+document.forms[0].applicationId.value+"&facilityID="+document.forms[0].facilityId.value+"&purge_status="+document.forms[0].purge_status.value+"&msgID="+document.forms[0].Msg_Id.value+"&even_type="+document.forms[0].even_type.value+"&protocol_link_id="+document.forms[0].ProtocolID.value+"&sub_module="+document.forms[0].sub_module.value+"&applicationName="+document.forms[0].applicationName.value+"&facilityName="+document.forms[0].facilityName.value+"&srlNo="+document.forms[0].srlNo.value+"&event_name="+document.forms[0].event_name.value+"&protocolMode="+document.forms[0].protocolMode.value+"&rule=J&rule2=H&img="+document.forms[0].img.value;	*/ 
}
var Standard_symbols=document.forms[0].Standard_Symbolsright.value;
var count=0;

var compilesimples=3;
var Standard_type1=document.forms[0].Standard_typeright.value;


var SplitinElements=new Array();
var sp=0;
var spliting=Standard_symbols.split("{{{");

for(var s=0;s<spliting.length;s++)
{

if(spliting[s].indexOf('|')!=-1)
{
var SpilitngStandardpip=spliting[s].split('|');


SplitinElements[sp]=SpilitngStandardpip[1];

}

else
{
SplitinElements[sp]=spliting[s];

}
sp++;

//} 
}

var pi=1;
var lo=1;
var spt1=0;
var intSymbols=new Array();
var intd=0;
for(var spt=0;spt<SplitinElements.length;spt++)
{
if(spt==0 || spt==1 || spt==2)
{
Symbols[spt1]="#"+String.fromCharCode(SplitinElements[spt])+"#";
intSymbols[intd]="#"+String.fromCharCode(SplitinElements[spt])+"#";
intd++;
}
else																   
{

Symbols[spt1]=String.fromCharCode(SplitinElements[spt]);
intSymbols[intd]=String.fromCharCode(SplitinElements[spt]);
intd++;
}
spt1++;

}


if(Standard_type1=='H')
{
var acchar1=0;
var pipsimple="|";
var pipsym=messegetext.indexOf('|');
var firstmessage=messegetext.substring(0,pipsym);
piptwoarray[0]=new Array();
captwoarray[0]=new Array();
piptwoarray[0][0]=pipsimple;
//CapVal[0]=pipsimple;
PiptVal[0]=firstmessage;
var messagevaluepip=messegetext.substring((pipsym+1),messegetext.length);
var nextpip=messagevaluepip.indexOf('|');
var massagenextpip=messagevaluepip.substring(0,(nextpip+1));
var secondsplit=messagevaluepip.substring(nextpip,messagevaluepip.length);
piptwoarray[0][1]=massagenextpip;
//CapVal[1]=massagenextpip;
if(Symbols[3]!=null )
{
var ch=Symbols[3].toString();
}
else
{

}

var identifysimbol=Messegesyntax.indexOf(ch);
var identifypip=Messegesyntax.indexOf('|');

var MsgsubString=Messegesyntax.substring(identifysimbol+1,identifypip);
var tillMegHeead=Messegesyntax.substring(0,identifysimbol);
var tillsegHead=Messegesyntax.substring(identifypip,Messegesyntax.length);
var ic1=2;
var ic2=2;
var Replace="";
var pp=0;
if(Symbols[5]!=null)
{
Replace=Symbols[5].toString()+MsgsubString;

}
else
{
Replace=ch+MsgsubString;
}

 Messegesyntax=tillMegHeead+ch+Replace+tillsegHead+'|';
// alert(Messegesyntax);

Capt=2;
k2=secondsplit;
Pipt=1;
var flag=0;

var pipflag=0;

for(var i=0;i<k2.length;i++)
{
 someval=(k2.charAt(i)).toString()+((k2.charAt(i+1)).toString())+((k2.charAt(i+2)).toString());
  if((k2.charAt(i+2)).toString()=="" || (k2.charAt(i+1)).toString()=="")
  {
    someval=someval+"lam,x"+"lam,x";
   }
   if(someval == intSymbols[0] || someval == intSymbols[1] || someval == intSymbols[2]  || someval == intSymbols[3]  || someval == intSymbols[4] ||  someval == intSymbols[5] || someval == intSymbols[6] )
{

}
 var nextsimpol=someval.substring(0,1);
 curval= (k2.charAt(i)).toString();
 if(curval=='+')
{
curval=' ';
}



if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == '*')
{


 if(temp.length>0 )
{
if(temp.indexOf("^")!=-1 || temp.indexOf("|")!=-1 )
{
var somethingdata1=temp.substring(0,1);

if(somethingdata1=='|')
{

pipflag=ic1;

ic3=0;

}
else if(somethingdata1=='^')
{

captwoarraysec[losec]=new Array();
losec++;
}
}
var somethingdata=temp.substring(0,1);
if(somethingdata=='|' && nextsimpol=='|' )
{

}
else
{

//Capt=0;
//pp++;
}

switch(test(somethingdata))
{

case 0:

break;
case 1:

break;
case 2:

break;
case 3:
boxval[box]=temp.substring(1);
box++;
break;
case 4:
var value3=temp.substring(1);

if (value3==null)
{
Lesstan[less]=MessageHead;
less++;
}
else
{
Lesstan[less]=value3;

less++;
}
break;
case 5:
PiptVal[Pipt]=temp.substring(1);
piptwoarray[pi]=new Array();
captwoarray[lo]=new Array();
cc=lo;
lo++;
ic2=0;
Capt=0;
pp++;
pi++;
Pipt++;
break;
case 6:
if(nextsimpol=='^')
{
piptwoarray[pp][Capt]=temp.substring(1)+nextsimpol;
}
else
{
piptwoarray[pp][Capt]=temp.substring(1);

}

if(piptwoarray[pp][Capt]=="")
{
boo=false;
}
else
{

boo=true;
ic1++;
ic3=0;
ic2++;
}

Capt++;




break;
case 7:
if(boo==true)
{
cc1++;
}
captwoarray[cc][ic2]=temp.substring(1);
captwoarraysec[cc1][ic3]=temp.substring(1);



//alert("cc :"+cc1+" ic2 "+ic3+" captwoarray[cc][ic2] :"+captwoarraysec[cc1][ic3]);
ic3++;

CapVal1[Capt1]=pipflag;
ic2++;
Capt1++;

boo=false;


break;


}
}
temp=curval;
}
else 
  {
	temp=temp+curval;
  }
}
 if(temp.length>0)
{
switch(test(curval))
{

case 0:

break;
case 1:

break;
case 2:

break;
case 3:
boxval[box]=temp.substring(1);
box++;
break;
case 4:
var value3=temp.substring(1);

if (value3==null)
{
Lesstan[less]=MessageHead;
less++;
}
else
{
Lesstan[less]=value3;

less++;
}
break;
case 5:
PiptVal[Pipt]=temp.substring(1);
piptwoarray[pi]=new Array();
captwoarray[lo]=new Array();
cc=lo;
lo++;
ic2=0;
Capt=0;
pp++;
pi++;
Pipt++;
break;
case 6:
if(nextsimpol=='^')
{
piptwoarray[pp][Capt]=temp.substring(1)+nextsimpol;
}
else
{
piptwoarray[pp][Capt]=temp.substring(1);

}

if(piptwoarray[pp][Capt]=="")
{
boo=false;
}
else
{

boo=true;
ic1++;
ic3=0;
ic2++;
}

Capt++;




break;
case 7:
if(boo==true)
{
cc1++;
}
captwoarray[cc][ic2]=temp.substring(1);
captwoarraysec[cc1][ic3]=temp.substring(1);
//alert("cc :"+cc+" ic2 "+ic2+" captwoarray[cc][ic2] :"+captwoarray[cc][ic2]);
ic3++;

CapVal1[Capt1]=pipflag;
ic2++;
Capt1++;

boo=false;


break;

}
}


/**************************populate Tree*************************////
/**********************************Populate Tree*****************************/
var tswte=0;
var Atte=0;
var Excte=0;
var pipte=0;
var capte=0;
var cou1=1;
var Opente=0;
var Closete=0;
var Amperte=0
var hashte=0;
var pipsom=0;
var dolte=0;
var perte=0;
var lesste=0;
var cap=0;

var pipcheck=0;
var capc=0;
d.add(0,-1,'');
var counting=1;
var spe=0;
var incr=0;
for(var i=0;i<Messegesyntax.length;i++)
{

	 curval=(Messegesyntax.charAt(i)).toString();
	 curval1=(Messegesyntax.charAt(i)).toString();
	some=(Messegesyntax.charAt(i)).toString()+((Messegesyntax.charAt(i+1)).toString())+((Messegesyntax.charAt(i+2)).toString());


  if((Messegesyntax.charAt(i+2)).toString()=="" || (Messegesyntax.charAt(i+1)).toString()=="")
  {
    some=some+"lam,x"+"lam,x";
   }

if(compilesimples==i)
{
curval=some1;

}

if(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )
{
compilesimples=(i+2);
some1=some;
counting=3;
spe=2;
}
else if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])
{
curval=curval1;
spe=0;
counting=1;
}

       if(curval=="+")
{

curval=" ";
}
 var nextsimpol=some.substring(0,1);
		 
	  


 
 if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])
 
 {


 if(temp.length>0 )
{




temp=temp.substring(0,(temp.length-spe));

if(temp.indexOf("#%#")!=-1)
{
counting=3;

}

var somethingdata=temp.substring(0,counting);


switch(test(somethingdata))
{
case 0:
var value11=temp.substring(counting);
if(value11=="")
{
}
else
{
if(hashVal[hashte]==null)
{
var value1=value11;
}
else
{

var value1=value11+"     =     "+hashVal[hashte];

}

elementval[eventre]=value11;
eventre++;
d.add(cou1,0,value1,"javascript:selectLink()");

hash=cou1;
cou1++;
hashte++;

}
break;
case 1:
var value12=temp.substring((counting));
if(value12=="")
{


}
else
{
if(dolVal[dolte]==null)
{
var value2=value12;
}
else
{
var value2=value12+"     =     "+dolVal[dolte];

}
elementval[eventre]=value12;
eventre++;
d.add(cou1,hash,value2,"javascript:selectLink()");
dola=cou1;
cou1++;
dolte++;
}
break;
case 2:

dola=getData(dola,hash,1);
var value13=temp.substring((counting));


if(value13=="")
{
}
else
{
if(PerVal[perte]==null)
{
var value3=value13;
}
else
{
var value3=value13+"     =     "+PerVal[perte];

}
elementval[eventre]=value13;
eventre++; 
d.add(cou1,dola,value3,"javascript:selectLink()");
d.oPnode(true,0);
perce=cou1;
perce=cou1;
cou1++;
perte++;
counting=0;
}
break;
case 3:

perce =getData(perce,hash,1);
perce=getData(perce,dola,2);


var somevalue1="";


var somevalue=temp.substring(counting);
if(somevalue=="")
{
}
else
{
if(boxval[boxte]==null)
{
somevalue1=somevalue;


}
else
{
somevalue1=somevalue+"     =     "+boxval[boxte];

}

elementval[eventre]=somevalue;
eventre++;
d.add(cou1,perce,somevalue1,"javascript:selectLink()");
pipsom=cou1;
//som=cou1;
boxte++;
cou1++;

}


break;
case 4:

som =getData(som,hash,1);
som=getData(som,dola,2);
som=getData(pipsom,perce,3);
var lessval1="";

var lessval=temp.substring(1);

if(lessval=="")
{
}
else
{
if(Lesstan[lesste]==null)
{
lessval1=lessval;
}
else
{
lessval1=lessval+"     =     "+Lesstan[lesste];


}
elementval[eventre]=lessval;
eventre++;
d.add(cou1,som,lessval1,"javascript:selectLink()");
pipsom=som;
pip=cou1;
lesste++;
cou1++;

}

break;
case 5:
checkRemainingVal(caplength,capc,cou1,ll);
pip=getData(pip,hash,1);
pip=getData(pip,dola,2);
pip=getData(pip,perce,3);
pip=getData(pip,pipsom,4);
var valuePip1=temp.substring(1);
if(valuePip1=="")
{
}
else
{
if(PiptVal[pipte]==null)
{
var valuePip=valuePip1;
}
else
{
var valuePip=valuePip1+"     =     "+PiptVal[pipte];
pipsing=pipsing+1;
countingpip[pipte]=new Array();

}
elementval[eventre]=valuePip1;
eventre++;
//acchar1=0;
acchar=0;
capc=0;

//d.add(cou1,pip,valuePip,valuePip);
d.add(cou1,pip,valuePip,"javascript:selectLink()");

piplength=piptwoarray[pipsing].length;
 cap=cou1;
 cou1++;
 pipte++;

//cate++;
 }
break;
case 6:
//checkFunCap();
checkRemainingVal(caplength,capc,cou1,ll);
checkIndexChar(storecap,storegenc);
cap=getData(cap,hash,1);
cap=getData(cap,dola,2);
cap=getData(cap,perce,3);
cap=getData(cap,som,4);
cap=getData(cap,pip,5);
var valueCap1=temp.substring(1);
var comsixteen="";



//if(acchar<16)                                  remove  16 characters condition 
//{
if(!piptwoarray[pipsing][acchar])
{
deboo=false;
}
else
{

comsixteen=piptwoarray[pipsing][acchar];
capc++;
}
if(comsixteen=="" )
{
deboo=false;
}
else
{

deboo=true;
}
//}                                             end   16 character loop 



if(comsixteen.indexOf('^')!=-1)
{

var capcheck=comsixteen.substring(comsixteen.length-1);
comsixteen=comsixteen.substring(0,comsixteen.length-1);
if(capcheck.indexOf('^')!=-1)
{


storecap="^";
storegenc=gendrcou;
}
else if(capcheck.indexOf('^')==-1)
{
storecap="";
}
}

  
elementval[eventre]=valueCap1;
 
//alert(" elementval : "+elementval[eventre]+" valueCap1 : "+valueCap1+" eventre :"+eventre);



//alert(document.forms[0].element.value);
countingpip[pipsing][gendrcou]=valueCap1+" = "+comsixteen;
d.add(cou1,cap,countingpip[pipsing][gendrcou],"javascript:selectLink()");
gendrcou++;
acchar++;
eventre++;
caplength=0; 
ll=cou1;
cou1++;
flag=0;   
//}
break;
case 7:

var compacap="";
//alert(capc);
if(deboo==true)
{
//cate++;
if(flag==0)
{
if(captwoarray[pipsing][capc] || captwoarray[pipsing][capc]=='')
{
cate++;
if(cate<captwoarraysec.length)
{
caplength=captwoarraysec[cate].length;
}
var valueCap13=temp.substring(1);
//alert(valueCap13);
}
else if(captwoarray[pipsing][capc]==undefined )
{
}
else if(captwoarray[pipsing][capc]==null )
{
}
else
{
//cate++;
//if(cate<captwoarraysec.length)
//{

//caplength=captwoarraysec[cate].length;
//}
///var valueCap13=temp.substring(1);
//var check=captwoarray[pipsing][capc]=""?"empty":captwoarray[pipsing][capc];


}

}
capcsec=0;
}
ll=getData(ll,hash,1);
ll=getData(ll,dola,2);
ll=getData(ll,perce,3);
ll=getData(ll,som,4);
ll=getData(ll,pip,5);
ll=getData(ll,cap,6);
var valueCap12=temp.substring(1);
compacap=captwoarray[pipsing][capc];
if(compacap==null)
{
var capattanddet=valueCap12+" = ";
//countingpip[pipsing][gendrcou]=valueCap12+" = ";
}
else
{
var capattanddet=valueCap12+" = "+compacap;
//alert(capattanddet);
remind=1;

caplength=caplength-remind;																				 
//countingpip[pipsing][gendrcou]=valueCap12+" = "+compacap;
capc++;
}
if(valueCap12=='')
{
elementval[eventre]=valueCap12;
eventre++; 
}
else
{
elementval[eventre]=valueCap12;
eventre++; 
}
d.add(cou1,ll,capattanddet,"");



/*if(cate<captwoarraysec.length)
{
if(!captwoarraysec[cate][capcsec])
{
compacap="";
}
else
{
compacap=captwoarraysec[cate][capcsec];
}


if(caplength>0)
{
//countingpip[pipsing][gendrcou]=valueCap12+" = "+compacap;
capcsec++;
}
else
{
countingpip[pipsing][gendrcou]=valueCap12+" = ";
}
caplength--;
}
else
{
countingpip[pipsing][gendrcou]=valueCap12+" = ";
}*/

flag=1;
deboo=false;
gendrcou++;
cou1++;

break;

}
}


temp=curval;

}
else 
{
	temp=temp+curval;

	
}










  }
 if(temp.length>0 )
{
temp=temp.substring(0,(temp.length-spe));

if(temp.indexOf("#%#")!=-1)
{
counting=3;
}


var somethingdata=temp.substring(0,counting)


switch(test(somethingdata))
 /*curval= Messegesyntax.charAt(i);
if(curval=='+')
{

curval=' ';
}


if(curval == Symbols[0] ||curval ==Symbols[1] ||curval == Symbols[2] || curval == Symbols[3] ||curval == Symbols[4] || curval == Symbols[5] || curval == Symbols[6] ||curval == Symbols[7] || curval == Symbols[8] ||curval == Symbols[9] ||curval == Symbols[10] || curval == '*')
 {
 if(temp.length>0)
{
switch(test())*/
{
case 0:


var value11=temp.substring(counting);

if(value11=="")
{
}
else
{
if(hashVal[hashte]==null)
{
var value1=value11;
}
else
{

var value1=value11+"     =     "+hashVal[hashte];
elementval[eventre]=value11;
eventre++;
}

d.add(cou1,0,value1,"javascript:selectLink()");
hash=cou1;
cou1++;
hashte++;

}
break;
case 1:

var value12=temp.substring((counting));



if(value12=="")
{
}
else
{
if(dolVal[dolte]==null)
{
var value2=value12;
}
else
{
var value2=value12+"     =     "+dolVal[dolte];
elementval[eventre]=value12;
eventre++;
}
}

d.add(cou1,hash,value2,"javascript:selectLink()");
dola=cou1;
cou1++;
dolte++;

break;
case 2:
dola=getData(dola,hash,1);
var value13=temp.substring((counting));
if(value13=="")
{
}
else
{
if(PerVal[perte]==null)
{
var value3=value13;
}
else
{
var value3=value13+"     =     "+PerVal[perte];
elementval[eventre]=value13;
eventre++;
}

d.add(cou1,dola,value3,"javascript:selectLink()");
perce=cou1;
perce=cou1;
cou1++;
perte++;
counting=0;
}
break;
case 3:

perce =getData(perce,hash,1);
perce=getData(perce,dola,2);

var somevalue1="";


var somevalue=temp.substring(counting);
if(somevalue=="")
{
}
else
{
if(boxval[boxte]==null)
{
somevalue1=somevalue;


}
else
{
somevalue1=somevalue+"     =     "+Lesstan[lesste];
elementval[eventre]=somevalue;
eventre++;
}


d.add(cou1,perce,somevalue1,"javascript:selectLink()");
som=cou1;
boxte++;
cou1++;

}


break;
case 4:

som =getData(som,hash,1);
som=getData(som,dola,2);
som=getData(som,perce,3);
var lessval1="";
var lessval=temp.substring(1);

if(lessval=="")
{
}
else
{
if(Lesstan[lesste]==null)
{
lessval1=lessval;
}
else
{
lessval1=lessval+"     =     "+Lesstan[lesste];
elementval[eventre]=lessval;
eventre++;
}

d.add(cou1,som,lessval1,"javascript:selectLink()");
pip=cou1;
lesste++;
cou1++;

}

break;
case 5:
pip=getData(pip,hash,1);
pip=getData(pip,dola,2);
pip=getData(pip,perce,3);
pip=getData(pip,som,4);


var valuePip1=temp.substring(1);



if(valuePip1=="")
{
}
else
{
if(PiptVal[pipte]==null)
{
var valuePip=valuePip1;
}
else
{
var valuePip=valuePip1+"     =     "+PiptVal[pipte];
elementval[eventre]=valuePip1;
eventre++;

}

d.add(cou1,pip,valuePip,"javascript:selectLink()");

 cap=cou1;
 cou1++;
 pipte++;

 }
break;
case 6:
cap=getData(cap,hash,1);
cap=getData(cap,dola,2);
cap=getData(cap,perce,3);
cap=getData(cap,som,4);
cap=getData(cap,pip,5);
var valueCap1=temp.substring(1);


if(valueCap1=="")
{
}
else
{
if(CapVal[capte]==null)
{
var valueCap=valueCap1;
}
else
{
var valueCap=valueCap1+"     =     "+CapVal[capte];
elementval[eventre]=valueCap1;
eventre++;


}

d.add(cou1,cap,valueCap,"javascript:selectLink()");
ll=cou1;
cou1++;
capte++;

}
break;
case 7:
ll=getData(ll,hash,1);
ll=getData(ll,dola,2);
ll=getData(ll,perce,3);
ll=getData(ll,som,4);
ll=getData(ll,pip,5);
ll=getData(ll,cap,6);
var valueCap12=temp.substring(1);

if(CapVal1[capte1]==null)
{
var valueCap3=valueCap12;
}
else
{
var valueCap3=valueCap12+"     =     "+CapVal1[capte1];
elementval[eventre]=valueCap12;
eventre++;
}
d.add(cou1,ll,valueCap3,"");
cou1++;
capte1++;


break;

}
}


document.write(d);
d.nodeStatus(true,1,true);
d.nodeStatus(true,2,true);
d.nodeStatus(true,3,true);
//d.openAll();
}

else
{

var temp1='';
k2=messegetext;
for(var i=0;i<k2.length;i++)
{
 curval= (k2.charAt(i)).toString();

 if(curval=='+')
{


curval='      ';
}


  if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == '*')
 {

 

 if(temp1.length>0 )
{
var somethingdata=temp1.substring(0,1);


switch(test(somethingdata))
{

case 0:

break;
case 1:

break;
case 2:

break;
case 3:
MessageHead=temp1.substring(1);
if(MessageHead=="" || MessageHead==null)
{
}
else
{
boxval[box]=MessageHead;

box++;

}
break;
case 4:
var value3=temp1.substring(1);


if (value3==null)
{
Lesstan[less]=MessageHead;
less++;
}
else
{
Lesstan[less]=value3;

less++;
}
break;
case 5:
PiptVal[Pipt]=temp1.substring(1);

Pipt++;
break;
case 6:
CapVal[Capt]=temp1.substring(1);


Capt++;
break;
case 7:
CapVal1[Capt1]=temp1.substring(1);

Capt1++;
break;



}
}
temp1=curval;
}
else 
  {
	temp1=temp1+curval;
  }
}
 if(temp1.length>0)
{
switch(test(somethingdata))
{

case 0:

break;
case 1:

break; 
case 2:

break;
case 3:

MessageHead=temp1.substring(1);



if(MessageHead=="" || MessageHead==null)
{
}														 
else
{
boxval[box]=MessageHead;
box++;

}

break;
case 4:

Lesstan[less]=temp1.substring(1);

less++;
break;
case 5:

if(temp1.substring(1)=='*')
{
}
else
{
PiptVal[Pipt]=temp1.substring(1);

Pipt++;
}
break;
case 6:
CapVal[Capt]=temp1.substring(1);
Capt++;
break;
case 7:
CapVal1[Capt1]=temp1.substring(1);
Capt1++;

}
}


/**************************populate Tree*************************////
/**********************************Populate Tree*****************************/
var tswte=0;
var Atte=0;
var Excte=0;
var pipte=0;
var capte=0;
var cou1=1;
var Opente=0;
var Closete=0;
var Amperte=0
var hashte=0;
var dolte=0;
var perte=0;
var lesste=0;
var cap=0;
d.add(0,-1,'');
var some1;




for(var i=0;i<Messegesyntax.length;i++)
{
 curval=(Messegesyntax.charAt(i)).toString();
 curval1=(Messegesyntax.charAt(i)).toString();
some=(Messegesyntax.charAt(i)).toString()+((Messegesyntax.charAt(i+1)).toString())+((Messegesyntax.charAt(i+2)).toString());


  if((Messegesyntax.charAt(i+2)).toString()=="" && (Messegesyntax.charAt(i+1)).toString()=="")
  {
 some=some+"lak,xm"+"lak,xm";
}


if(compilesimples==i)
{
curval=some1;

}

if(some == intSymbols[0] || some == intSymbols[1] || some == intSymbols[2]  || some == intSymbols[3]  || some == intSymbols[4] ||  some == intSymbols[5] || some == intSymbols[6] )
{
compilesimples=(i+2);
some1=some;
counting=3;
spe=2;
}
else if(curval1 == intSymbols[0] || curval1 == intSymbols[1] || curval1 == intSymbols[2]  || curval1 == intSymbols[3]  || curval1 == intSymbols[4] ||  curval1 == intSymbols[5] || curval1 == intSymbols[6])
{
curval=curval1;
spe=0;
counting=1;
}
          
if(curval=="+")
{

curval="  ";
}
/*if(compilesimples%3=0)
{


}*/

//if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == Symbols[3] ||curval == Symbols[4] || curval == Symbols[5] || curval == Symbols[6] ||curval == Symbols[7] || curval == Symbols[8] ||curval == Symbols[9] ||curval == Symbols[10] ||  curval == '*')
 
 if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])
 
 {
 if(temp.length>0 )
{

temp=temp.substring(0,(temp.length-spe));
if(temp.indexOf("#%#")!=-1)
{
counting=3;


}


var somethingdata=temp.substring(0,counting)

switch(test(somethingdata))
 {
case 0:


var value11=temp.substring(counting);

if(value11=="")
{
}
else
{
if(hashVal[hashte]==null)
{
var value1=value11;
}
else
{

var value1=value11+"     =     "+hashVal[hashte];
}
elementval[eventre]=value11;
eventre++;
d.add(cou1,0,value1,"javascript:selectLink()");
hash=cou1;
cou1++;
hashte++;

}
break;
case 1:

dola=getData(dola,hash,1);

var value12=temp.substring((counting));



if(value12=="")
{
}
else
{
if(dolVal[dolte]==null)
{
var value2=value12;
}
else
{
var value2=value12+"     =     "+dolVal[dolte];

}
elementval[eventre]=value12;
eventre++;
d.add(cou1,hash,value2,"javascript:selectLink()");
dola=cou1;
cou1++;
dolte++;
}


break;
case 2:
dollor=getData(dollor,hash,1);
dollor=getData(dollor,dola,2);


var value13=temp.substring((counting));


if(value13=="")
{
}
else
{
if(PerVal[perte]==null)
{
var value3=value13;
}
else
{
var value3=value13+"     =     "+PerVal[perte];

}
elementval[eventre]=value13;
eventre++;
d.add(cou1,dola,value3,"javascript:selectLink()");
perce=cou1;
perce=cou1;
cou1++;
perte++;
counting=0;
}
break;
case 3:

perce =getData(perce,hash,1);
perce=getData(perce,dola,2);
perce=getData(perce,dollor,3);
var somevalue1="";


var somevalue=temp.substring(counting);

if(somevalue=="")
{
}
else
{
if(boxval[boxte]==null)
{
somevalue1=somevalue;
}
else
{
somevalue1=somevalue+"     =     "+boxval[boxte];

}

elementval[eventre]=somevalue;
eventre++;
d.add(cou1,perce,somevalue1,"javascript:selectLink()");
som=cou1;
boxte++;
cou1++;

}


break;
case 4:

som =getData(som,hash,1);
som=getData(som,dola,2);
som=getData(som,dollor,3);
som=getData(som,perce,4);
var lessval1="";

var lessval=temp.substring(counting);

if(lessval=="")
{
}
else
{
if(Lesstan[lesste]==null)
{
lessval1=lessval;
}
else
{
lessval1=lessval+"     =     "+Lesstan[lesste];

}
elementval[eventre]=lessval;
eventre++;
d.add(cou1,som,lessval1,"javascript:selectLink()");
pip=cou1;
lesste++;
cou1++;

}

break;
case 5:
pip=getData(pip,hash,1);
pip=getData(pip,dola,2);
pip=getData(pip,dollor,3);
pip=getData(pip,perce,4);
pip=getData(pip,som,5);



var valuePip1=temp.substring(1);



if(valuePip1=="")
{
}
else
{
if(PiptVal[pipte]==null)
{
var valuePip=valuePip1;
}
else
{
var valuePip=valuePip1+"     =     "+PiptVal[pipte];

}
elementval[eventre]=valuePip1;
eventre++;
d.add(cou1,pip,valuePip,"javascript:selectLink()");

 cap=cou1;
 cou1++;
 pipte++;

 }
break;
case 6:
cap=getData(cap,hash,1);
cap=getData(cap,dola,2);
cap=getData(cap,dollor,3);
cap=getData(cap,perce,4);
cap=getData(cap,som,5);
cap=getData(cap,pip,6);
var valueCap1=temp.substring(1);


if(valueCap1=="")
{
}
else
{
if(CapVal[capte]==null)
{
var valueCap=valueCap1;
}
else
{
var valueCap=valueCap1+"     =     "+CapVal[capte];


}
elementval[eventre]=valueCap1;
eventre++;
d.add(cou1,cap,valueCap,"javascript:selectLink()");
ll=cou1;
cou1++;
capte++;

}
break;
case 7:
ll=getData(ll,hash,1);
ll=getData(ll,dola,2);
ll=getData(ll,dollor,3);
ll=getData(ll,perce,4);
ll=getData(ll,som,5);
ll=getData(ll,pip,6);
ll=getData(ll,cap,7);
var valueCap12=temp.substring(1);
if(valueCap12=="")
{
}
else
{
if(CapVal1[capte1]==null)
{
var valueCap3=valueCap12;
}
else
{
var valueCap3=valueCap12+"     =     "+CapVal1[capte1];


}
elementval[eventre]=valueCap12;
eventre++;
d.add(cou1,ll,valueCap3,"");
cou1++;
capte1++;

}
break;


}
}


temp=curval;

}
else 
{
	temp=temp+curval;

	
}
  }
 if(temp.length>0 )
{
temp=temp.substring(0,(temp.length-spe));
switch(test(somethingdata))

{
case 0:


var value11=temp.substring(counting);

if(value11=="")
{
}
else
{
if(hashVal[hashte]==null)
{
var value1=value11;
}
else
{

var value1=value11+"     =     "+hashVal[hashte];

}
elementval[eventre]=value11;
eventre++;
d.add(cou1,0,value1,"javascript:selectLink()");
hash=cou1;
cou1++;
hashte++;

}
break;
case 1:

dola=getData(dola,hash,1);

var value12=temp.substring((counting));



if(value12=="")
{
}
else
{
if(dolVal[dolte]==null)
{
var value2=value12;
}
else
{
var value2=value12+"     =     "+dolVal[dolte];

}
elementval[eventre]=value12;
eventre++;
d.add(cou1,hash,value2,"javascript:selectLink()");
dola=cou1;
cou1++;
dolte++;
}


break;
case 2:
dollor=getData(dollor,hash,1);
dollor=getData(dollor,dola,2);


var value13=temp.substring((counting));


if(value13=="")
{
}
else
{
if(PerVal[perte]==null)
{
var value3=value13;
}
else
{
var value3=value13+"     =     "+PerVal[perte];

}
elementval[eventre]=value13;
eventre++;
d.add(cou1,dola,value3,"javascript:selectLink()");
perce=cou1;
perce=cou1;
cou1++;
perte++;
counting=0;
}
break;
case 3:

perce =getData(perce,hash,1);
perce=getData(perce,dola,2);
perce=getData(perce,dollor,3);
var somevalue1="";


var somevalue=temp.substring(counting);

if(somevalue=="")
{
}
else
{
if(boxval[boxte]==null)
{
somevalue1=somevalue;


}
else
{
somevalue1=somevalue+"     =     "+Lesstan[lesste];

}

elementval[eventre]=somevalue;
eventre++;
d.add(cou1,perce,somevalue1,"javascript:selectLink()");
som=cou1;
boxte++;
cou1++;

}


break;
case 4:

som =getData(som,hash,1);
som=getData(som,dola,2);
som=getData(som,dollor,3);
som=getData(som,perce,4);
var lessval1="";

var lessval=temp.substring(counting);

if(lessval=="")
{
}
else
{
if(Lesstan[lesste]==null)
{
lessval1=lessval;
}
else
{
lessval1=lessval+"     =     "+Lesstan[lesste];

}
elementval[eventre]=lessval;
eventre++;
d.add(cou1,som,lessval1,"javascript:selectLink()");
pip=cou1;
lesste++;
cou1++;

}

break;
case 5:
pip=getData(pip,hash,1);
pip=getData(pip,dola,2);
pip=getData(pip,dollor,3);
pip=getData(pip,perce,4);
pip=getData(pip,som,5);



var valuePip1=temp.substring(1);



if(valuePip1=="")
{
}
else
{
if(PiptVal[pipte]==null)
{
var valuePip=valuePip1;
}
else
{
var valuePip=valuePip1+"     =     "+PiptVal[pipte];

}
elementval[eventre]=valuePip1;
eventre++;
d.add(cou1,pip,valuePip,"javascript:selectLink()");

 cap=cou1;
 cou1++;
 pipte++;

 }
break;
case 6:
cap=getData(cap,hash,1);
cap=getData(cap,dola,2);
cap=getData(cap,dollor,3);
cap=getData(cap,perce,4);
cap=getData(cap,som,5);
cap=getData(cap,pip,6);
var valueCap1=temp.substring(1);


if(valueCap1=="")
{
}
else
{
if(CapVal[capte]==null)
{
var valueCap=valueCap1;
}
else
{
var valueCap=valueCap1+"     =     "+CapVal[capte];

}
elementval[eventre]=valueCap1;
eventre++;

d.add(cou1,cap,valueCap,"javascript:selectLink()");
ll=cou1;
cou1++;
capte++;

}
break;
case 7:
ll=getData(ll,hash,1);
ll=getData(ll,dola,2);
ll=getData(ll,dollor,3);
ll=getData(ll,perce,4);
ll=getData(ll,som,5);
ll=getData(ll,pip,6);
ll=getData(ll,cap,7);
var valueCap12=temp.substring(1);
if(valueCap12=="")
{
}
else
{
if(CapVal1[capte1]==null)
{
var valueCap3=valueCap12;
}
else
{
var valueCap3=valueCap12+"     =     "+CapVal1[capte1];


}
elementval[eventre]=valueCap12;
eventre++;
d.add(cou1,ll,valueCap3,"");
cou1++;
capte1++;

}
break;


}
}

 
document.write(d);
d.nodeStatus(true,1,true);
d.nodeStatus(true,2,true);
d.nodeStatus(true,3,true);
//d.openAll();

}

function  getData(val1,val2)
 {
 if(val1 < val2)   val1 =val2; 
   return val1;	
 }
function  test(val1)
{
var align=0;


for(var spk=0;spk<SplitinElements.length;spk++)
{
if(val1==intSymbols[spk])
{

align=(spk);


}

}


return align;
}
function  compare(val1)
 {

var val2;




if(val1==Symbols[0]  || val1==Symbols[1] || val1==Symbols[2] || val1==Symbols[3] || val1==Symbols[4] || val1==Symbols[5] || val1==Symbols[6] || val1==Symbols[7] || val1==Symbols[8] || val1==Symbols[9] || val1==Symbols[10] || val1==Symbols[11] || val1==Symbols[11]  )
{

val2=val1;
}
else
{

for(var intds=0;intds<intSymbols.length;intds++)
{

if(val1==intSymbols[intds])
{

val2=intSymbols[intds];
}

}
}
return val2;	

}
  function  test2(firstar,secondar)
{

	if(!captwoarray[firstar][secondar])
	{
		align=6; 
		Mainboolean==true;							   
	}
	else
	{
		Mainboolean=false;
		align=7;
	}
	return align;
}
function  test1(val1,current,next,firstar,secondar)
{
var align=0;
var pipsym='|';														  
var capsym='^';
if(val1==pipsym)
{
	if(next==capsym)
	{
      if(!captwoarray[firstar][secondar])
		{
			 align=6;
             Mainboolean=true;
		}

	}
}


}
/*
function  test1(val1,current,next,firstar,secondar)
{

var align=0;
var pipsym='|';
var capsym='^';
if(val1==pipsym)
{
	if(next==pipsym)
	{
	        for(var spk=0;spk<SplitinElements.length;spk++)
			{
				if(val1==intSymbols[spk])
				{
                   
					align=(spk);
					Mainboolean=true;
				}

			}
		/*if(!captwoarray[(firstar+1)][secondar])
		{
			for(var spk=0;spk<SplitinElements.length;spk++)
			{
				if(val1==intSymbols[spk])
				{
                   
					align=(spk);
					Mainboolean=true;
				}

			}
		}
		else
		{
	alert(firstar+" secondar : "+secondar+" " +captwoarray[(firstar+1)][secondar]);
		 alert("condi 1: 2")
			align=7;
			deboo=true;
            Mainboolean=false;
		//}

	}
    else if(next==capsym)
    {
	alert("condi 1: 3");
        align=7;
		Mainboolean=true;
	}
	else
	{
	    for(var spk=0;spk<SplitinElements.length;spk++)
			{
				if(val1==intSymbols[spk])
				{

					align=(spk);
                    Mainboolean=true;
				}

			}
	}

}
else if(val1==capsym)
{
   if(next==pipsym)
	{
       if(!captwoarray[firstar][secondar])
		{
			align=6;
             Mainboolean=true;
		}
		else
		{
            align=7;
			  Mainboolean=false;
		}
	 
	}
	else if(next==capsym)
	{
            align=7;
			Mainboolean=true;
	}
    else
	{
	    for(var spk=0;spk<SplitinElements.length;spk++)
			{
				if(val1==intSymbols[spk])
				{

					align=(spk);
					Mainboolean=true;
				}

			}
	}


}

else
{
for(var spk=0;spk<SplitinElements.length;spk++)
{
if(val1==intSymbols[spk])
{

align=(spk);
Mainboolean=true;

}

}
}
alert("Mainboolean "+Mainboolean);
alert("align :"+align);
return align;
}
*/


 

 function Trim(str)
{ 
while(str.charAt(0) == (" ") )
  {  str = str.substring(1);
  }
  while(str.charAt(str.length-1) == " " )
  {  str = str.substring(0,str.length-1);

  }
  return str;
}


function checkFunCap()
{

while(caplength>0)
{


countingpip[pipsing][gendrcou]=" "+"  =  "+captwoarraysec[cate][capcsec];
d.add(cou1,storecate,countingpip[pipsing][gendrcou],"javascript:selectLink()");
capc++;
capcsec++;
cou1++;
gendrcou++;
caplength--;

}

}
function checkRemainingVal(rem,capc1,cou1,ll)
{
var bool=false;

while(rem>0)
{

	var check=captwoarraysec[cate][capcsec];
elementval[eventre]="";
eventre++;
   d.add((cou1-1),ll," "+" = "+captwoarray[pipsing][capc1],"");
	countingpip[pipsing][gendrcou]=" "+"  =  "+captwoarray[pipsing][capc];
bool=true;
gendrcou++;
capcsec++;
capc1++;
cou1++;

rem--;
}


if(bool==true)
{
//alert("inga");
//alert("capc "+capc);
capc=capc1;
//cate++;
//capcsec=0;

}											 
//cate++;
}

async function selectLink()
{ 
 	var url='../../eXH/jsp/ViewElementTreeText.jsp?&standard_code='+document.forms[0].Standard_code.value+'&event='+elementval[(d.selectedNode-1)];
	   var arguments  =new Array();
var dialogTop   = "350";
var dialogHeight= "27" ;
var dialogWidth = "250" ;	
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	
	await window.showModalDialog(url,arguments,features);

	//parent.parent.frames[2].location.href=str
																			  
}  
function checkIndexChar(sym,gen)
{

 
	if(sym=='^')
	{

		if(gen==(gendrcou-1))
		{ 
        capcsec=0;
        cate=cate+1;
	
		var leng=captwoarraysec[cate].length;
	
       while(leng>0)
		{
  
		 //d.add(cou1,ll,countingpip[pipsing][gendrcou],valueCap); 
		countingpip[pipsing][gendrcou]=" "+"  =  "+captwoarraysec[cate][capcsec];
	    d.add(cou1,ll,countingpip[pipsing][gendrcou],""); 
		gendrcou++;
		capcsec++;
        capc++;
		leng--;
		cou1++;
		elementval[eventre]="";
		eventre++;
		}
	
		}
		
	}
}
}
catch(e)
{
	  

/*parent.frames[0].document.location.href="../../eXH/jsp/ViewTree.jsp?applicationID="+document.forms[0].applicationId.value+"&facilityID="+document.forms[0].facilityId.value+"&purge_status="+document.forms[0].purge_status.value+"&msgID="+document.forms[0].Msg_Id.value+"&even_type="+document.forms[0].even_type.value+"&protocol_link_id="+document.forms[0].ProtocolID.value+"&sub_module="+document.forms[0].sub_module.value+"&applicationName="+document.forms[0].applicationName.value+"&facilityName="+document.forms[0].facilityName.value+"&srlNo="+document.forms[0].srlNo.value+"&event_name="+document.forms[0].event_name.value+"&protocolMode="+document.forms[0].protocolMode.value+"&rule=J&rule2=H&img="+document.forms[0].img.value;	 */

if(e instanceof RangeError)
{


	if(document.forms[0].rule.value=='R')
	{

		if(emptyflag==false)
	{
		var message=getMessage('XH0076','XH');
		message=message.replace('$','');
	   alert(message);
	}
	else
	{
	}
	}
	else 
	{
	}
} 
else
{ 
	if(emptyflag==false)
	{
		var message=getMessage('XH0076','XH');
		message=message.replace('$','');
		alert(message);
	}
	else
	{

	}
}
 
}



</script>
<%	
}
	catch(Exception e)
	{
		System.out.println("Error in calling getconnection method of ViewTree.JSP Exception:"+e);
	}

	 finally{
		ConnectionManager.returnConnection(connection);
		//	if(stmt!=null)stmt.close();
	}%>
</td>
</tr>
</table>
</div>
</form>

</BODY>
</html>

