<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
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
<link rel="StyleSheet" href="../../eCommon/html/dtree.css" type="text/css" />
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel="StyleSheet" href="../../eCommon/html/lris_style.css" type="text/css" />
<script type="text/javascript" src="../../eXH/js/dtree1.js"></script>
<script language="javascript" src="../../eXH/js/Viewtreeimage.js" ></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='JavaScript' src='../../eXH/js/checkfield.js'></script>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
</head>					    
<body bgcolor='#F7F3F7' topmargin=0 leftmargin=0 valign=top >
<form >
<table cellspacing=0 cellpadding=3 width='99%' align=center >
	<tr> 
	<td colspan="6" class="COLUMNHEADER"><fmt:message key="Common.Response.label" bundle="${common_labels}"/></td>
	<input type=hidden id='Message' name='Message' id='Message'  >
	<input type=hidden id='Messagesyn' name='Messagesyn' id='Messagesyn'  >
	<input type=hidden id='Symbols' name='Symbols' id='Symbols'  >
	<input type=hidden id='standardtype' name='standardtype' id='standardtype'  >
	</tr>
	<tr>
	<td>
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
	var pip=0;var Cap=0;
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
	var som=0;
	var pip=0;
	var hasht=0;
	var dolt=0;
	var Pert=0;
	var ll=0;
	var capte1=0;
	var k2="";
	var symbolvalue;
	var temp='';
	var d1=0;
	var val="";
	var acchar=0;
	var sy='';
	var Symbols=new Array();
	var s1=0;
	var Lesstan=new Array();
	var less=0;
	var messagehead="";
	var CapVal1=new Array();
	var Capt1=0;
	var boxval=new Array();
	var box=0;
	var messegetext=unescape(parent.frames[0].document.forms[0].Res_txt.value);
	var messegesyntax=unescape(parent.frames[0].document.forms[0].Res_syn.value+'|');
	var standard_symbols=parent.frames[0].document.forms[0].Req_symbols.value;
	if(messegetext=='' || messegesyntax=='')
	{
	alert(getMessage('XH0057','XH'));
	}
	else
	{

		var compilesimples=3;
		if(messegesyntax.indexOf("###")!=-1);
		{
		standard_symbols="35|35|35{{{35|36|35{{{35|37|35{{{"+parent.frames[0].document.forms[0].Req_symbols.value;
		}
		var standard_type1=parent.frames[0].document.forms[0].Req_type.value;
		var perce=0;
		var SplitinElements=new Array();
		var sp=0;
		var spliting=standard_symbols.split("{{{");
		for(var s=0;s<spliting.length;s++)
		{
		if(spliting[s]!='')
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
			}

		}

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
		if(standard_type1=='H')
		   {
				var pipsimple="|";
				var pipsym=messegetext.indexOf('|');
				var firstmessage=messegetext.substring(0,pipsym);

				CapVal[0]=pipsimple;
				PiptVal[0]=firstmessage;
				var messagevaluepip=messegetext.substring((pipsym+1),messegetext.length);
				var nextpip=messagevaluepip.indexOf('|');
				var massagenextpip=messagevaluepip.substring(0,nextpip);
				var secondsplit=messagevaluepip.substring(nextpip,messagevaluepip.length);
				CapVal[1]=massagenextpip;
				if(Symbols[3]!=null )
				{
					var ch=Symbols[3].toString();
				}
				else
				{
				}
				var identifysimbol=messegesyntax.indexOf(ch);
				var identifypip=messegesyntax.indexOf('|');
				var MsgsubString=messegesyntax.substring(identifysimbol+1,identifypip);
				var tillMegHeead=messegesyntax.substring(0,identifysimbol);
				var tillsegHead=messegesyntax.substring(identifypip,messegesyntax.length);
				var Replace="";
				if(Symbols[5]!=null)
				{
					Replace=Symbols[5].toString()+MsgsubString;
				}
				else
				{
					Replace=ch+MsgsubString;
				}
				messegesyntax=tillMegHeead+ch+Replace+tillsegHead+'|';
				Capt=2;
				k2=secondsplit;
				Pipt=1;
				for(var i=0;i<k2.length;i++)
				{
					curval= (k2.charAt(i)).toString();
				if(curval=='+')
				{
					curval=' ';
				}
				if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == '*')
				{
					if(temp.length>0 || curval == intSymbols[3])
					{
						var somethingdata=temp.substring(0,1);
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
								Lesstan[less]=messagehead;
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
							Pipt++;
							break;
							case 6:
							CapVal[Capt]=temp.substring(1);
							Capt++;
							break;
							case 7:
							CapVal1[Capt1]=temp.substring(1);
							Capt1++;
							break;
							case '*':
							break;
							case '&':
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
						messagehead=temp.substring(1);
						if(messagehead=="" || messagehead==null)
						{
						}
						else
						{
							boxval[box]=messagehead;
							box++;
						}
						break;
						case 4:
						Lesstan[less]=temp.substring(1);
						less++;
						break;
						case 5:
						if(temp.substring(1)=='*')
						{
						}
						else
						{
							PiptVal[Pipt]=temp.substring(1);
							Pipt++;
						}
						break;
						case 6:
						CapVal[Capt]=temp.substring(1);
						Capt++;
						break;
						case 7:
						CapVal1[Capt1]=temp.substring(1);
						Capt1++;
						case '*':
						break;
						case '&':
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
			var boxte=0;
			d.add(0,-1,'');
			var counting=1;
			var spe=0;
			for(var i=0;i<messegesyntax.length;i++)
			{
				curval=(messegesyntax.charAt(i)).toString();
				curval1=(messegesyntax.charAt(i)).toString();
				some=(messegesyntax.charAt(i)).toString()+((messegesyntax.charAt(i+1)).toString())+((messegesyntax.charAt(i+2)).toString());;
				if((messegesyntax.charAt(i+2)).toString()=="" || (messegesyntax.charAt(i+1)).toString()=="")
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
				if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] || curval ==intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] || curval ==intSymbols[7] || curval == intSymbols[8] || curval == intSymbols[9] || curval ==intSymbols[10] || curval == intSymbols[11])
				{
				if(temp.length>0 )
				{
					temp=temp.substring(0,(temp.length-spe));
					if(temp.indexOf("#%#")!=-1)
					{
						counting=3
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
						d.add(cou1,0,value1,value1);
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
						d.add(cou1,hash,value2,value2);
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
						d.add(cou1,dola,value3,value3);
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
						d.add(cou1,perce,somevalue1,"");
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
						d.add(cou1,som,lessval1,valuePip);
						pipsom=som;
						pip=cou1;
						lesste++;
						cou1++;
						}
						break;
						case 5:
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
							}
						acchar=0;
						d.add(cou1,pip,valuePip,valuePip);
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
						var pipchar="";
						if(valueCap1=="")
						{
						}
						else
						{
							if(acchar<16)
							{
								pipchar=CapVal[capte];
								capte++;
							}
							else
							{
								pipchar="";
							}
							if(pipchar==null)
							{
								var valueCap=valueCap1;
							}
							else
							{
								var valueCap=valueCap1+"     =     "+pipchar;
							}
						acchar++;
						d.add(cou1,cap,valueCap,valueCap);
						ll=cou1;
						cou1++;
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
						d.add(cou1,ll,valueCap3,valueCap);
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
						d.add(cou1,0,value1,value1);
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
						}
						d.add(cou1,hash,value2,value2);
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
							}
						d.add(cou1,dola,value3,value3);
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
							}
						d.add(cou1,perce,somevalue1,"");
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
							}
						d.add(cou1,som,lessval1,valuePip);
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

							}

						d.add(cou1,pip,valuePip,valuePip);

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
							}
						d.add(cou1,cap,valueCap,valueCap);
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
						d.add(cou1,ll,valueCap3,valueCap);
						cou1++;
						capte1++;
						}
						break;
						case '*':
						break;
				}
			}
			document.write(d);
				}
			else
			{
		k2=messegetext;
		for(var i=0;i<k2.length;i++)
		{
		 curval=(k2.charAt(i)).toString();
		 curval1=(k2.charAt(i)).toString();
		 some=(k2.charAt(i)).toString()+((k2.charAt(i+1)).toString())+((k2.charAt(i+2)).toString());
		  if((k2.charAt(i+2)).toString()=="" && (k2.charAt(i+1)).toString()=="")
		  {
		 some=some+'laxs*.'+'lax*.';
		}
		 if(curval=='+')
		{
		curval='      ';
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
		 if(curval == intSymbols[0] || curval ==intSymbols[1] || curval == intSymbols[2] || curval == intSymbols[3] ||curval == intSymbols[4] || curval == intSymbols[5] || curval == intSymbols[6] ||curval == intSymbols[7] || curval == intSymbols[8] ||curval == intSymbols[9] ||curval == intSymbols[10] || curval == '*')
		 {
		 if(temp.length>0)
		{
		var somethingdata=temp.substring(0,counting);
		switch(test(somethingdata))
		{
		case 0:
		break;
		case 1:
		break;
		case 2:
		break;
		case 3:
		messagehead=temp.substring(1);

		if(messagehead=="" || messagehead==null)
		{
		}
		else
		{
		boxval[box]=messagehead;
		box++;
		}
		break;
		case 4:
			var value3=temp.substring(1);
		if (value3==null)
		{
		Lesstan[less]=messagehead;
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
		Pipt++;
		break;
		case 6:
		CapVal[Capt]=temp.substring(1);
		Capt++;
		break;
		case 7:
		CapVal1[Capt1]=temp.substring(1);
		Capt1++;
		break;
		case '*':
		break;
		case '&':
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
		messagehead=temp.substring(1);
		if(messagehead=="" || messagehead==null)
			{
		}
		else
		{
		boxval[box]=messagehead;
		box++;
		}
		break;
		case 4:
		Lesstan[less]=temp.substring(1);
		less++;
		break;
		case 5:
		if(temp.substring(1)=='*'){
		}
		else
		{
		PiptVal[Pipt]=temp.substring(1);
		Pipt++;
		}
		break;
		case 6:
		CapVal[Capt]=temp.substring(1);
		Capt++;
		break;
		case 7:
		CapVal1[Capt1]=temp.substring(1);
		Capt1++;
		case '*':
		break;
		case '&':
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
		var dolte=0;
		var perte=0;
		var lesste=0;
		var cap=0;
		d.add(0,-1,'');
		var some1;
		var boxte=0;
		for(var i=0;i<messegesyntax.length;i++)
			{
		 curval=(messegesyntax.charAt(i)).toString();
		 curval1=(messegesyntax.charAt(i)).toString();
		some=(messegesyntax.charAt(i)).toString()+((messegesyntax.charAt(i+1)).toString())+((messegesyntax.charAt(i+2)).toString());
		  if((messegesyntax.charAt(i+2)).toString()=="" && (messegesyntax.charAt(i+1)).toString()=="")
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


		//|| curval == intSymbols[3]

		 if(temp.length>0 )
		{

		temp=temp.substring(0,(temp.length-spe));
		if(temp.indexOf("#%#")!=-1)
		{
		counting=3;
		var somethingdata=temp.substring(0,counting);

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
		d.add(cou1,0,value1,value1);
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
		d.add(cou1,hash,value2,value2);
		dola=cou1;
		cou1++;
		dolte++;
		}


		break;
		case 2:
		dola=getData(dola,hash,1);
		var value3="";

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


		d.add(cou1,dola,value3,value3);
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


		d.add(cou1,perce,somevalue1,"");
		som=cou1;
		boxte++;
		cou1++;

		}


		break;
		case 4:

		som =getData(som,hash,1);
		som=getData(som,dola,2);
		//som=getdata(som,perce,3);
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
		d.add(cou1,som,lessval1,valuePip);
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

		}

		d.add(cou1,pip,valuePip,valuePip);

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


		}
		d.add(cou1,cap,valueCap,valueCap);
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
		d.add(cou1,ll,valueCap3,valueCap);
		cou1++;
		capte1++;

		}
		break;

		case '*':
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
		switch(test(curval))

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
		d.add(cou1,0,value1,value1);
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
		}
		d.add(cou1,hash,value2,value2);
		dola=cou1;
		cou1++;
		dolte++;

		break;
		case 2:
		dola=getData(dola,hash,1);
		var value13=temp.substring((counting));


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
		var value3=value13+"     =     "+PerVal[perte];
		}
		d.add(cou1,dola,value3,value3);
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


		var somevalue=temp.substring(counting+2);
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


		d.add(cou1,perce,somevalue1,"");
		som=cou1;
		boxte++;
		cou1++;

		}


		break;
		case 4:

		som =getData(som,hash,1);
		som=getData(som,dola,2);
		//som=getdata(som,perce,3);
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
		d.add(cou1,som,lessval1,valuePip);
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

		}

		d.add(cou1,pip,valuePip,valuePip);

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


		}
		d.add(cou1,cap,valueCap,valueCap);
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
		d.add(cou1,ll,valueCap3,valueCap);
		cou1++;
		capte1++;

		}
		break;

		case '*':
		break;
		}
		}
		document.write(d);
		}
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
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</td>
	</tr>
</table>
</form>
</body>
</html>









  

