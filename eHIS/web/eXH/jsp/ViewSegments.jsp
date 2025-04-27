<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
  
<%request.setCharacterEncoding("UTF-8"); %>
<!--head-->
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,oracle.sql.ARRAY" %>
<% /*
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
*/
%>
<% 
Connection connection = null;
CallableStatement  oraclecallablestatement = null;
String applicationId="";
String applicationName="";
String facilityId="";
//String facilityName="";
String msgId="";
String eventType="";
//String eventName="";
String ProtocolID="";
String Msq_txt="";						 
String MsgText="";
String Standard_code="";
String Message_syntax="";
String Standard_symbols="";
String errorMsg="";
String Standard_type="";
applicationId=(String)session.getAttribute("application_Id");
applicationName=(String)session.getAttribute("applicationName");
facilityId=(String)session.getAttribute("Facility_Id");
msgId=(String)session.getAttribute("Msg_Id");
Msq_txt=(String)session.getAttribute("Message_Text");
ProtocolID="F";
eventType=(String)session.getAttribute("Even_type");


try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method of ViewSegmentJSP :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try
{
oraclecallablestatement = connection.prepareCall("{ call xhgeneric.standard_message_viewer(?,?,?,?,?,?,?,?,?,?,?) }" ); 
oraclecallablestatement.setString(1,applicationId);
//out.println("applicationId"+applicationId);
oraclecallablestatement.setString(2,facilityId);
//out.println("facilityId"+facilityId);
oraclecallablestatement.setString(3,msgId);
//out.println("msgId"+msgId);
oraclecallablestatement.setString(4,ProtocolID);
//out.println("ProtocolID"+ProtocolID);
oraclecallablestatement.setString(5,eventType);
//out.println("eventType"+eventType);
oraclecallablestatement.setString(6,Msq_txt);
//out.println("Msq_txt"+Msq_txt);
oraclecallablestatement.registerOutParameter(6,java.sql.Types.VARCHAR);
oraclecallablestatement.registerOutParameter(7,java.sql.Types.VARCHAR);
oraclecallablestatement.registerOutParameter(8,java.sql.Types.VARCHAR);
oraclecallablestatement.registerOutParameter(9,java.sql.Types.VARCHAR);
oraclecallablestatement.registerOutParameter(10,java.sql.Types.VARCHAR);
oraclecallablestatement.execute();
MsgText = oraclecallablestatement.getString(6);
Standard_code= oraclecallablestatement.getString(7);
Standard_type=oraclecallablestatement.getString(8);


Message_syntax=oraclecallablestatement.getString(9);
Standard_symbols=oraclecallablestatement.getString(10);
errorMsg=oraclecallablestatement.getString(11);

//System.out.println("Message_syntax"+Message_syntax);
//System.out.println("Msq_txt"+MsgText);
if(oraclecallablestatement!=null) 
	oraclecallablestatement.close();
		}
catch(Exception ex)
	{ 
		 System.out.println("Error in calling dbrelated statements in callejb method of InterfaceStandardAddModifyServlett:"+ex.toString());
		//exceptions=exceptions+"3"+"*"+ex.toString();
		//ex.printStackTrace(System.err);

	}
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of ViewSegments :"+ex.toString());
		   ex.printStackTrace(System.err); }
	    
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<link rel="StyleSheet" href="../../eCommon/html/dtree.css" type="text/css" />
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel="StyleSheet" href="../../eCommon/html/lris_style.css" type="text/css" />
	<script type="text/javascript" src="../../eCommon/js/dtree1.js"></script>
<script language="JavaScript"> 

function  getData(val1,val2)
 {
 if(val1 < val2)   val1 =val2; 
   return val1;	
 }
</script>
</head>
<BODY >
<form name="view_segment_form" id="view_segment_form" >
<input type=hidden name='Facility' id='Facility' value=''>
<input type=hidden name='Message_ID' id='Message_ID' value=''>
<input type=hidden name='Protocol_link' id='Protocol_link' value=''>
<input type=text id='Message_text' name='Message_text' id='Message_text' value='<%=MsgText%>'  >
<input type=text id='Message_Syn'name='Message_Syn' value='<%=Message_syntax%>'>
<input type=text id='Standard_Symbols' name='Standard_Symbols' id='Standard_Symbols' value='<%=Standard_symbols%>'>
<input type=text id='Standard_code' name='Standard_code' id='Standard_code' value='<%=Standard_code%>'>
<input type=text id='Standard_type' name='Standard_type' id='Standard_type' value='<%=Standard_type%>'>


<!--<input type=hidden name='Facility' id='Facility' value=''>
<input type=hidden name='Message_ID' id='Message_ID' value=''>
<input type=hidden name='Protocol_link' id='Protocol_link' value=''>
<input type=hidden name='Message_text' id='Message_text' value='<%=MsgText%>'>
<input type=hidden name='Message_Syn' id='Message_Syn' value='<%=Message_syntax%>'>
<input type=hidden name='Standard_Symbols' id='Standard_Symbols' value='<%=Standard_symbols%>'>
<input type=hidden name='Standard_code' id='Standard_code' value='<%=Standard_code%>'>--->
<div class="tree">
<script language="JavaScript">
d = new dTree('d');
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
var CloseVal=new Array();
var tsw=0;
var cou=1;
var temp='';
var Exc=0;
var At=0;
var pip=0;
var tswt=0;
var Att=0;
var Exct=0;
var Pipt=0;
var Capt=0;
var Ampert=0
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
var pip=0;
var Cap=0;
var hash=0;
var hashCou;
var dolCou;
var perCou;
var pipCou;
var capCou;
var l_pos;
var cou=1;
var temp='';
var perce=0;
var dola=0;

var hasht=0;
var dolt=0;
var Pert=0;
var Capt=0;

//alert("frm name1 : "+parent.parent.frames[0].document.forms[0].name);
//alert("frm name2 : "+parent.parent.frames[1].document.forms[0].name);
//alert("Syst Def Str : "+parent.parent.frames[1].document.forms[0].SysDefStr.value);
//alert("Inp_txt Val : "+parent.parent.frames[1].document.forms[0].InputText.value);
//alert(parent.frames[0].document.forms[0].name);
var k=document.forms[0].Message_Syn.value;
// alert(parent.frames[0].document.forms[0].name);
 var k2=document.forms[0].Message_text.value;
  //var f=view_segments_form.Message_Syn.value;


//var k="#PACS Application$Hospital Siriraj%Update patient information #$@*";
//var k2="#MSH|^~\&|IBAEHIS|HS^HS-Facility Siriraj(SRDV)|pacs Application|getwell hospital|20071112105056||ADT^A08|8125|P|2.3|||ALEVN|A08|20071112105056||||20071112105056 PID|||Z100000037||^Test_patient est1^^^||19080310000000|F||OTHERS^Others|^^^^^^M|||||||Z100000037|123456|||||||5110^American||5110^|| PO|Z100000037||||||||Y||||||UN|U||||||KUILA|12-NOV-07|INDBGL-W00155|HS|KUILA|12-NOV-07|INDBGL-W00155|HS| PA|Z100000037||||RES||||||||N|MAI||||||||||N|||||||||N|||||||||N|||||||||N|KUILA|12-NOV-07|INDBGL-W00155|HS|KUILA|12-NOV-07|INDBGL-W00155|HS| ZPR|Z100000037|||||||||||||||||||NEXT||||||||||||FRST||||||||||||EMPR||||||||||||||||||||||||||||||||||||||||4555123568899444|KUILA|12-NOV-07|INDBGL-W00155|HS|KUILA|12-NOV-07|INDBGL-W00155|HS||ID11||ID2||ID3||ID4|||| ZPD|Z100000037|||||||||||||||||||||||||||| ZPI|Z100000037||||||||||||||||||N||||||||||||||HS|HS|N|N||Y|N|||||12-NOV-07|N|||KUILA|12-NOV-07|INDBGL-W00155|HS|KUILA|12-NOV-07|INDBGL-W00155|HS||N||Y|Y|||N|N|Z1|12-NOV-07||123456|ID11|4555123568899444|||||||||||||PRN|||ORN||||||||||||||||||||Test_patient|Test1|||||Test_patient Test1 ,||Test_patient|Test_patie||||Test_patient Test_patie  ,|T231|T230|||T231|T231|TST_FTET|TST1|||TST_FTETST1|TST_FTET|F|10-MAR-08|Y||||1|1||OTHERS||||5110|||N|N";
//var k=parent.parent.frames[1].document.forms[0].Message_syntax.value;
//alert(k);
//var identify=k;
//var identify=parent.frames[0].document.forms[0].Message_Syn.value;
//var k2=document.getElementById("Message_text");
//alert(k2);
var simple1="";
var simple2="";
var simple3="";
var simple4="";
var simple5="";
var currentvalue;
for(var i=0;i<k.length;i++)
{
curval= k.charAt(i);


if(curval == '~' ||curval == '@' ||curval == '!' ||curval == '|' ||curval == '^' || curval == '#' || curval == '$' ||curval == '%' || curval == '&' ||curval == '(' ||curval == ')' )
 {

	
if(temp.length>0)
{
switch(temp.charAt(0))
{
case '#':
simple1='#';
break;
case '$':
simple2='$';

break;
case '%':
	simple3='%';
break;
case '|':
simple4='|';
break;
case '^':
simple5='^';
break;
case '~':
simple1='~';
break;
case '@':
simple2='@';
break;
case '!':
	simple3='!';
break;
case '^':
simple1='^';
break;
case '&':
simple2='|';
break;
case '(':
simple3='|';
break;
case ')':
simple4='|';
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

for(var i=0;i<k2.length;i++)
{
 curval= k2.charAt(i);
  if(curval == '~' ||curval == '@' ||curval == '!' ||curval == '|' ||curval == '^' || curval == '#' || curval == '$' ||curval == '%' || curval == '&' ||curval == '(' ||curval == ')' )
 {
 if(temp.length>0)
{
switch(temp.charAt(0))
{
case simple1:
var value1=temp.substring(1);
if(value1=="")
{
}
else
{
tswVal[tswt]=value1;
tswt++;
}
break;
case simple2:
var value9=temp.substring(1);

if(value9=="")
{
}
else
{
hashVal[hasht]=value9;
hasht++;
}
break;
case simple3:
var value10=temp.substring(1);
if(value10=="")
{
}
else
{
dolVal[dolt]=value10;
dolt++;
}
break;
case simple4:
var value11=temp.substring(1);
if(value11=="")
{
}
else
{
PerVal[Pert]=value11;
Pert++;
}
break;
case simple5:
var value122=temp.substring(1);
if(value11=="")
{
}
else
{
CapVal[Capt]=value122;
Capt++;
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
 if(temp.length>0)
{
switch(temp.charAt(0))
{
case simple1:
var value1=temp.substring(1);
if(value1=="")
{
}
else
{
tswVal[tswt]=value1;
tswt++;
}
break;
case simple2:
var value9=temp.substring(1);

if(value9=="")
{
}
else
{
hashVal[hasht]=value9;
hasht++;
}
case simple3:
var value10=temp.substring(1);
if(value10=="")
{
}
else
{
dolVal[dolt]=value10;
dolt++;
}
break;
case simple4:
var value11=temp.substring(1);
if(value11=="")
{
}
else
{
PerVal[Pert]=value11;
Pert++;
}
break;
case simple5:
var value122=temp.substring(1);
if(value11=="")
{
}
else
{
CapVal[Capt]=value122;
Capt++;
}
break;
}

}



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
d.add(0,-1,'');
var curval1;


for(var i=0;i<k.length;i++)
{
 curval= k.charAt(i);
if(curval == '~' ||curval == '@' ||curval == '!' ||curval == '|' ||curval == '^' || curval == '#' || curval == '$' ||curval == '%' || curval == '&' ||curval == '(' ||curval == ')' )
 {
 if(temp.length>0)
{
switch(temp.charAt(0))
{
case simple1:
var valuetsw1=temp.substring(1);
if(valuetsw1=="")
{
}
else
{
if(tswVal[tswte]==null)
{
var valuetsw=valuetsw1;
}
else
{
var valuetsw=valuetsw1+"="+tswVal[tswte];

}
d.add(cou1,0,valuetsw,valuetsw);
tsw=cou1;
cou1++;
tswte++;
}
break;
case simple2:
var value11=temp.substring(1);
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
var value1=value11+"="+hashVal[hashte];
}

d.add(cou1,tsw,value1,value1);
hash=cou1;
cou1++;
hashte++;
}
break;
case simple3:
var value12=temp.substring(1);
alert(value12+""+hash);

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
var value2=value12+"="+dolVal[dolte];
}

d.add(cou1,hash,value2,value2);
dola=cou1;
cou1++;
}
break;
case simple4:
dola=getData(dola,hash,1);
var value13=temp.substring(1);
if(value3=="")
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
var value3=value13+"="+PerVal[perte];
}

d.add(cou1,dola,value3,value3);
perce=cou1;
perce=cou1;
cou1++;
perte++;
}
break;
/*case simple5:
dola=getData(dola,hash,1);
var value13=temp.substring(1);
if(value3=="")
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
var value3=value13+"="+PerVal[perte];
}

d.add(cou1,dola,value3,value3);
perce=cou1;
perce=cou1;
cou1++;
perte++;
}
break;*/






/*case simple1:
var value1=temp.substring(1);
if(value1=="")
{
}
else
{
if(tswVal[tswte]==null)
{
var valuetsw=value1;
}
else
{
var valuetsw=value1+"="+tswVal[tswte];
}
d.add(cou1,0,valuetsw,valuetsw);
hash=cou1;
cou1++;
tswte++;
}
break;
case simple2:
var value2=temp.substring(1);
if(value2=="")
{
}
else
{
if(hashVal[hashte]==null)
{
var value1=value2;
}
else
{
var value1=value2+"="+hashVal[hashte];
}
d.add(cou1,hash,value1,value1);
dola=cou1;
cou1++;
hashte++;
}
break;
case simple3:
dola=getData(dola,hash,1);
var value3=temp.substring(1);


if(value3=="")
{
}
else
{
if(dolVal[dolte]==null)
{
var valueDOL=value3;
}
else
{
var valueDOL=value3+"="+dolVal[dolte];
}
d.add(cou1,dola,valueDOL,valueDOL);
perce=cou1;
cou1++;
hashte++;
}
break;
case simple4:
perce =getData(perce,hash,1);
perce=getData(perce,dola,2);
var value4=temp.substring(1);
if(value4=="")
{
}
else
{
if(PerVal[perte]==null)
{
var value5=value4;
}
else
{
var value5=value4+"="+PerVal[perte];
}
d.add(cou1,dola,value5,value5);
perce=cou1;
perce=cou1;
cou1++;
perte++;
 }
break;*/
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
switch(temp.charAt(0))
{
case simple1:
var valuetsw1=temp.substring(1);
if(valuetsw1=="")
{
}
else
{
if(tswVal[tswte]==null)
{
var valuetsw=valuetsw1;
}
else
{
var valuetsw=valuetsw1+"="+tswVal[tswte];
}
d.add(cou1,0,valuetsw,valuetsw);
tsw=cou1;
cou1++;
tswte++;
}
break;
case simple2:
var value11=temp.substring(1);
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
var value1=value11+"="+hashVal[hashte];
}
d.add(cou1,tsw,value1,value1);
hash=cou1;
cou1++;
hashte++;
}
break;
case simple3:
var value12=temp.substring(1);
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
var value2=value12+"="+dolVal[dolte];
}

d.add(cou1,hash,value2,value2);
dola=cou1;
cou1++;
}
break;
case simple4:
dola=getData(dola,hash,1);
var value13=temp.substring(1);
if(value3=="")
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
var value3=value13+"="+PerVal[perte];
}
d.add(cou1,dola,value3,value3);
perce=cou1;
perce=cou1;
cou1++;
perte++;
}
break;
/*case simple1:
var value1=temp.substring(1);
if(value1=="")
{
}
else
{
if(tswVal[tswte]==null)
{
var valuetsw=value1;
}
else
{
var valuetsw=value1+"="+tswVal[tswte];
}
d.add(cou1,0,valuetsw,valuetsw);
hash=cou1;
cou1++;
tswte++;
}
break;
case simple2:
var value2=temp.substring(1);
if(value2=="")
{
}
else
{
if(hashVal[hashte]==null)
{
var value1=value2;
}
else
{
var value1=value2+"="+hashVal[hashte];
}
d.add(cou1,hash,value1,value1);
dola=cou1;
cou1++;
hashte++;
}
break;
case simple3:
dola=getData(dola,hash,1);
var value3=temp.substring(1);
if(value3=="")
{
}
else
{
if(dolVal[dolte]==null)
{
var valueDOL=value3;
}
else
{
var valueDOL=value3+"="+dolVal[dolte];
}
d.add(cou1,dola,valueDOL,valueDOL);
perce=cou1;
perce=cou1;
cou1++;
dolte++;
}
break;
case simple4:
perce =getData(perce,hash,1);
perce=getData(perce,dola,2);
var value4=temp.substring(1);
if(value4=="")
{
}
else
{
if(PerVal[perte]==null)
{
var value5=value4;
}
else
{
var value5=value4+"="+PerVal[perte];
}
d.add(cou1,dola,value5,value5);
perce=cou1;
perce=cou1;
cou1++;
perte++;
 }
break;*/
}

}
document.write(d);
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


</div>


<!--<table cellspacing=0 cellpadding=3 width='100%' align=center>
</table>
<div id="style123" style="display:none">
<fieldset style=" border-color:black;" ><legend><b> Query Details </b></legend> 
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<td></td>


<tr>
	<td width='30%'></td>
	<td width='70%'></td>
</tr>

 

<tr>
	<td width='30%'></td>
	<td width='70%'></td>
</tr>


</table>

</div>



<!--<script>
document.location.href="../../eCommon/html/Left2.html";
</scipt>--->

</form>
</BODY>
</html>


