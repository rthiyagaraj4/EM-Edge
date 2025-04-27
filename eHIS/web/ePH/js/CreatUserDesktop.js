
 
var len;
var spc="         ";
var cnt=0;

// this function invoked on click on the Priview Button, which gets the PID and calls a modalwindow.. 
//passing the array of values to construct the tree...

/*function callpriview()
{
	
	var fields = new Array(parent.construct_ca_menu.document.Construct_ca_menu_form.Menu);
    var names = new Array (parent.construct_ca_menu.getLabel("Common.MenuID.label",'COMMON'));
	if(checkFieldsofMst(fields, names, parent.frames[2])){	

	var obj = Construct_ca_menu_form.MainMenus;
	var arr = new Array();
	for(i=0;i<obj.length;i++)
	{
		var val = obj.options(i).value;
		var level = val.split("#");
		var text = obj.options(i).text;
		var trimtxt = trimString(text);
		index=i+1;
		var add="";
		if(level[1] == 1)
		{
			add = "#"+index+"#0";
			var L1index = index;
		}
		else if( level[1] == 2 )
		{
			add ="#"+index+"#"+L1index;
			var L2index = index;
		}
		else if( level[1] == 3 )
		{
			add ="#"+index+"#"+L2index;
			var L3index = index;
		}
		else if( level[1] == 4 )
		{
			add = "#"+index+"#"+L3index;
			var L4index = index;
		}
		else if( level[1] == 5 )
		{
			add = "#"+index+"#"+L4index;
			var L5index = index;
		}

		arr[i] = trimtxt+add;
		
	
	}
		
				var obj = Construct_ca_menu_form.Menu.selectedIndex;
				var menuid = Construct_ca_menu_form.Menu.options(obj).text;

				var url_mod	= "../../eCA/jsp/ConstructCAMenuPreviewMain.jsp?menuid="+menuid;
				var dialogHeight	= "32" ;
				var dialogWidth	= "18" ;
				var arguments	= arr;
				var status = "no";
				var scroll = "yes";
				var dialogTop = "60";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
				
				var reportURL 	= window.showModalDialog( url_mod, arguments, features ) ;
				//parent.document.frames[1].document.forms[0].Preview.disabled=true;
	}
}*/

// this clearfun makes, both ManinMenus and Menuopts list box clear.. i,e it deselects whatevere selected..

function clearfun()
{
			Construct_ca_menu_form.MainMenus.selectedIndex= -1;
			Construct_ca_menu_form.Menuopts.selectedIndex=-1;
}

/* This getVal function is invoked whenever a item is selected from the Menuopts and funcopt listbox..
It gets the value from these listbox and puts in the MainMenus listbox..*/


function getVal(num) 
{
				Construct_ca_menu_form.MainMenus.selectedIndex= -1;
				Construct_ca_menu_form.Menuopts.selectedIndex=-1;
				//if(num==1) 
					Construct_ca_menu_form.funcopt.selectedIndex=1;
				//else 
				//	Construct_ca_menu_form.Menuopts=1;
				return true;
}


// This header_id function is used to get the Header_id of the child nodes based upon there levels..

function header_id()
{
	var obj = construct_ca_menu.document.Construct_ca_menu_form.MainMenus;	

	var obj1 = construct_ca_menu.document.Construct_ca_menu_form.Menu.selectedIndex;
	var menuid = construct_ca_menu.document.Construct_ca_menu_form.Menu.options(obj1).value;

	for(i=0;i<obj.length;i++)
	{
		
		var val = obj.options(i).value;
		var level = val.split("#");
		var text = obj.options(i).text;
		var trimtxt = trimString(text);
		var header_opt_occ = 1;
		
		var option_id = level[0];
		index=i+1;
		var add="";
		if(level[1] == 1)
		{
			add =menuid;
			var H1index = option_id;
		}
		else if( level[1] == 2 )
		{
			add =H1index;
			var H2index = option_id;
		}
		else if( level[1] == 3 )
		{
			add =H2index;
			var H3index = option_id;
		}
		else if( level[1] == 4 )
		{
			add = H3index;
			var H4index = option_id;
		}
		else if( level[1] == 5 )
		{
			add = H4index;
			var H5index = option_id;
		}

	}
	return add;
}



function Menufun()
{
	
	Construct_ca_menu_form.funcopt.selectedIndex=-1;
	Construct_ca_menu_form.MainMenus.selectedIndex= -1;
}

// This function is used to get the values from the mainfunctions or subfunctions 
//and put them in the main tree structure list box...

function putVal()
{
		var addedFlag =true;
		var subaddFlag =false;
		var chkFlag=false;
		var subaddFlag1=false;

		var fields = new Array(Construct_ca_menu_form.Menu);
		var names = new Array (getLabel("Common.MenuID.label",'COMMON'));
		var topval = "";
		var topchk ="";
	
	//if(checkFieldsofMst(fields, names,  parent.frames[2]))
	//{	
		var obj1=Construct_ca_menu_form.funcopt;
		var index1=obj1.selectedIndex;
		
		var obj2=Construct_ca_menu_form.Menuopts;
		var index2=obj2.selectedIndex;
		
		var obj3=Construct_ca_menu_form.MainMenus;
		var index3=obj3.selectedIndex;
		if(obj1.selectedIndex!=-1){
			var val1=obj1.options(index1).value;
			var val2=obj1.options(index1).text;
			var toplen = obj3.length;
			if(toplen!= 0){
				 topval = obj3.options(toplen-1).value;
				 topchk = topval.split("#");
			}
			var splitval = val1.split("#");
			var addvalue = val1;
			var proceed=true;
			if(index3!=-1){
				if(obj3.length!=0){
					for(var i=0;i<obj3.length;i++){
					if(trimString(obj3.options[i].text)==val2){
						alert(getMessage("SUMMARY_DUPLICATE","SM"))
						proceed=false;
					}
					else
					{
					proceed=true;
					for(var i=0;i<obj3.length;i++){
					if(trimString(obj3.options[i].text)==val2){
					alert(getMessage("SUMMARY_DUPLICATE","SM"))
					proceed=false;
					break;					
					}
					}
					if(proceed){
					var oOption = document.createElement("OPTION");
					oOption.text=val2;
					var val=val1;
					oOption.value=val;
					var index_sv=Construct_ca_menu_form.MainMenus.length;
					document.getElementById("MainMenus").add(oOption,index_sv);
					break;	
					}
			
				}
				break;					
			}
			
		}
/*				if(proceed){
						obj3.options(index3).value=val1;
						obj3.options(index3).text=val2;
			}*/

	}else{
		if((obj3.length == 0)){

					var element=document.createElement("OPTION");
					element.style.color='BLACK';
					element.text=val2;
					addvalue =splitval[0]+"#1#"+splitval[2]; 
					element.value=addvalue;

				obj3.add(element);
					subaddFlag=false;
			}

		else if((obj3.length!=0)&&(topchk[1] =='1' && topchk[2]=='F')){
					for(var i=0;i<obj3.length;i++){
					if(trimString(obj3.options[i].text)==val2){
					alert(getMessage("SUMMARY_DUPLICATE","SM"))
					subaddFlag1=false;
					chkFlag	 =	true;
					break;					
				}else{subaddFlag1=true;}
			}
		}
		else  if(obj3.length!=0&&!chkFlag){
				for(var i=0;i<obj3.length;i++){
				if(trimString(obj3.options[i].text)==val2){
					alert(getMessage("SUMMARY_DUPLICATE","SM"))
					subaddFlag=false;
					break;					
				}else{subaddFlag=true;}
			}
		}
		if(subaddFlag1){
				var element=document.createElement("OPTION");
				element.style.color='BLACK';
				addvalue =splitval[0]+"#1#"+splitval[2]; 
				element.value=addvalue;
				element.text=val2;
			/*	alert('subaddFlag1')
				 var index9=Construct_ca_menu_form.MainMenus.length;
			// alert('index9'+index9)
			//document.getElementById("MainMenus").add(element,index9); */
				obj3.add(element);
		}
	if(subaddFlag){
					var element=document.createElement("OPTION");
					element.style.color='BLACK';
					element.value=addvalue;
					element.text=spc+val2;
				/* alert('subaddFlag')
						 var index9=Construct_ca_menu_form.MainMenus.length;
					 alert('index111'+index9)
					 document.getElementById("MainMenus").add(element,index9); */
					obj3.add(element);
			}
}
//			obj3.selectedIndex=-1;
//alert("Added Value==>" +addvalue)
			/*var element=document.createElement("OPTION");
			element.style.color='BLACK';
			
			if((obj3.length == 0)||(topchk[1] =='1' && topchk[2]=='F')){
				element.text=val2;
				addvalue =splitval[0]+"#1#"+splitval[2]; 
			}else{
				element.text=spc+val2;
			}
				element.value=addvalue;
				obj3.add(element);==Befoew Modification*/
				/*if((topchk[1] =='1' && topchk[2]=='F')){
					addvalue =splitval[0]+"#1#"+splitval[2]; 
				}*/
//				alert(topchk[1])
//	

			
				obj1.selectedIndex=-1;
				obj2.selectedIndex=-1;
				obj3.selectedIndex=-1;
				val1="";
				val2="";
		}else{
			if(obj2.selectedIndex!=-1){
			var proceed=true;
			var val1=obj2.options(index2).value;
			var val2=obj2.options(index2).text;
				if(index3!=-1){
				var val3=obj3.options(index3).value;
				var val4=obj3.options(index3).text;
				if(obj3.length!=0){
				for(var i=0;i<obj3.length;i++){alert(obj3.options[i].value+"="+val1);
				if(trimString(obj3.options[i].value)==val1){
					alert(getMessage("SUMMARY_DUPLICATE","SM"))
					proceed=false;
					//break;					
				}
					else
					{
					proceed=true;
					for(var i=0;i<obj3.length;i++){
					if(trimString(obj3.options[i].text)==val2){
					alert(getMessage("SUMMARY_DUPLICATE","SM"))
					proceed=false;
					break ;					
					}
					}
					if(proceed){
					var oOption = document.createElement("OPTION");
					oOption.style.color='RED';
					oOption.text=val2;
					var val=val1;
					oOption.value=val;
					var index_sv=Construct_ca_menu_form.MainMenus.length;
					document.getElementById("MainMenus").add(oOption,index_sv);
					break;	
					}
					}
				 break;					

			}
		}
				/*if(proceed){
					var level=val3.split("#");
					if (level[1]==1 && level[2] == "M"){
						obj3.options(index3).value=val1;
						obj3.options(index3).text=val2;
						}else{
						var element=document.createElement("OPTION");
						element.style.color='RED';
						element.value=val1;
						element.text=val2;
						obj3.add(element);
					}
			}*/
	}else{
			if(obj3.length==0){
				var element=document.createElement("OPTION");
				element.style.color='RED';
				element.value=val1;
				element.text=val2;
				obj3.add(element);
			}else{
				for(var i=0;i<obj3.length;i++){
				if(trimString(obj3.options[i].value)==val1){
					alert(getMessage("SUMMARY_DUPLICATE","SM"))
					addedFlag=false;
					break;					
				}
			}
		if(addedFlag){
				var element=document.createElement("OPTION");
				element.style.color='RED';
				element.value=val1;
				element.text=val2;
				obj3.add(element);
		}
}

				/*
				var element=document.createElement("OPTION");
				element.value=val1;
				element.text=val2;
				obj3.add(element);
				*/
			}
			val1="";
			obj1.selectedIndex= -1;
			obj2.selectedIndex= -1;
			obj3.selectedIndex=-1;
		}
	}
		len=obj3.length;

	
	//}
}

/* This moveIndex function is invoked based on the number passed on click of the corresponding buttons..
1. 1 is passed on click of Top button... 
2. 2 is passed on click of Bottom button... 
3. 3 is passed on click of Right button... 
4. 4 is passed on click of Left button... 
*/


function MoveIndex(num)
{
		
		var obj3=Construct_ca_menu_form.MainMenus;
		var index3=obj3.selectedIndex;
		var len1 = obj3.length;	

	if(index3!=-1)           //it checks whether the MainMenus listbox is been selected r not..
	{
			var val1=obj3.options(index3).value;
			var val2=obj3.options(index3).text;
			var level=val1.split("#");
			
	
		if(num==1 && index3!=-1 && index3!=0  ) //moving upwards.. 1 is passed on click of Top button... 
		{
			
			var val3=obj3.options(index3-1).value;
			var val4=obj3.options(index3-1).text;
			var trimtxt = trimString(val4);
			var toptxt = val4;
			var topval = val3;
					
			if((len1-1)!=index3){

			var belowval = obj3.options(index3+1).value;
			var belowtxt = obj3.options(index3+1).text;
			var belval = belowval.split("#");
			var trimbel = trimString(belowtxt);
			var Bval = belowval;
			var Btxt = belowtxt;
			}
			else
			{
				var belval = new Array();
				belval[0] = "";
				belval[1] = '-2';
				belval[2] = '-2';
			}

			var fintxt=val2;
			var finval=val1;
			var toplevel= val3.split("#");
	var top = parseInt(toplevel[1])+1;

	if((top >= belval[1]) && !( level[2]=="M" && (belval[2] == "F" || belval[2] == "M") && (parseInt(level[1])+1) == belval[1] ) || (level[2]=="M" && (belval[2] == "M" || toplevel[2] == "M" )&& level[1] == toplevel[1] && toplevel[2] != "F"))
	//	if((top >= belval[1]) && !( level[2]=="M" && (belval[2] == "F" || belval[2] == "M") && (parseInt(level[1])+1) == belval[1] ))
	{
	
			if( (parseInt(level[1])+1) != toplevel[1]  || (parseInt(level[1])-1) != toplevel[1] || level[1] != toplevel[1] )
			{
				finval="";
				var splittxt = trimString(val2);
				
				if(toplevel[1] == 5)
				{
					fintxt=spc+spc+spc+spc+splittxt;
					finval=level[0]+"#5#"+level[2];
				
				}

				else if(toplevel[1] == 4)
				{
					fintxt=spc+spc+spc+splittxt;
					finval=level[0]+"#4#"+level[2];
			
				}

				else if(toplevel[1] == 3)
				{
					fintxt=spc+spc+splittxt;
					finval=level[0]+"#3#"+level[2];
			
				}
				
				else if(toplevel[1] == 2)
				{
					fintxt=spc+splittxt;
					finval=level[0]+"#2#"+level[2];
			
				}
				else if(toplevel[1] == 1)
				{
					fintxt=splittxt;
					finval=level[0]+"#1#"+level[2];
				
				}
			}
	
		
			var colr = obj3.options(index3).style.color;
			var colr1 = obj3.options(index3-1).style.color;			
			

			obj3.options(index3).value=topval;
			obj3.options(index3).text=toptxt;
			
			if((len1-1)!=index3){
				obj3.options(index3+1).value=Bval;
				obj3.options(index3+1).text=Btxt;
			}
				obj3.options(index3-1).value=finval;
				obj3.options(index3-1).text=fintxt;
				obj3.options(index3-1).selected=true;
						
			//adding colors.........

			if(colr == 'red' && colr1 == 'black')
			{
				obj3.options(index3-1).style.color='RED';
				obj3.options(index3).style.color='BLACK';
			}
			else if(colr == 'red' && colr1 == 'red')
			{
				obj3.options(index3-1).style.color='RED';
				obj3.options(index3).style.color='RED';
			}
			else if(colr == 'black' && colr1 == 'red')
			{
				obj3.options(index3-1).style.color='BLACK';
				obj3.options(index3).style.color='RED';
			}
			else if(colr == 'black' && colr1 == 'black')
			{
				obj3.options(index3-1).style.color='black';
				obj3.options(index3).style.color='black';
			}


		}					
	}

	//moving downwards.....2 is passed on click of Bottom button... 
	
	else if(num==2 && index3!=-1 && index3!=len1-1 )
		{
				
				var val4 = obj3.options(index3+1).text;
				var val3 = obj3.options(index3+1).value;
				var belowval = val3.split("#");
				
				if((index3-1)!=-1)
				{
				
				var topvals = obj3.options(index3-1).value;
				var toplevel = topvals.split("#");
				}
				else
				{
					var toplevel = new Array();
					toplevel[0]= "";
					toplevel[1] = '-2';
				}

				if((index3+2)!= obj3.length){
						var botval=obj3.options(index3+2).value;
						var botlevel = botval.split("#");
				}
				else
				{
					var botlevel = new Array();
					botlevel[0]="";
					botlevel[1]="-2";
				}


				var val4=obj3.options(index3+1).text;
				
				var splitval = val1.split("#");
					
				var trimtext = trimString(val2);
				var fintext = "";
				var finval = "";
			

	if((splitval[1] == belowval[1]) || (splitval[1] == "1" && belowval[1] == "1"))   
	//if((splitval[1] == "1" && belowval[1] == "1"))   
	{
				if(botlevel[1] == '1' && splitval[1] == '1' && splitval[2] == "F")
				{
					fintext = trimtext;
					finval = splitval[0]+"#1#"+splitval[2];
				}
				else if(botlevel[1] == '1' && splitval[1] == '1' && splitval[2] == "M")
				{
					fintext = trimtext;
					finval = splitval[0]+"#1#"+splitval[2];
				}
				else if(botlevel[1] == '1')
				{
					fintext = spc+trimtext;
					finval = splitval[0]+"#2#"+splitval[2];
				}
				else if(botlevel[1] == '2')
				{
					fintext = spc+trimtext;
					finval = splitval[0]+"#2#"+splitval[2];
				}
				else if(botlevel[1] == '3')
				{
					fintext = spc+spc+trimtext;		
					finval = splitval[0]+"#3#"+splitval[2];
				}
				else if(botlevel[1] == '4')
				{
					fintext = spc+spc+spc+trimtext;		
					finval = splitval[0]+"#4#"+splitval[2];
				}
				else if(botlevel[1] == '5')
				{
					fintext = spc+spc+spc+spc+trimtext;		
					finval = splitval[0]+"#5#"+splitval[2];
				}
				else if(botlevel[1] == '-2')
				{
					fintext = trimtext;		
					finval = splitval[0]+"#1#"+splitval[2];
				}

		
		/*		if( (belowval[1] == '1' && belowval[2] == 'F') || (toplevel[1] == '1' && toplevel[2] == 'F') )
				{
					fintext = trimtext;		
					finval = splitval[0]+"#1#"+splitval[2];
				}

				else if( (botlevel[1]!='-2') && (botlevel[2] == 'F' && botlevel[1] == '3')|| (botlevel[2] == 'F' && botlevel[1] == '4'))
				{
						fintext = spc+spc+trimtext;		
						finval = splitval[0]+"#3#"+splitval[2];
				}*/
				/*else
				{
					fintext = spc+trimtext;
					finval = splitval[0]+"#2#"+splitval[2];

				}*/
								
				var colr = obj3.options(index3).style.color;
				var colr1 = obj3.options(index3+1).style.color;	
			
				obj3.options(index3).value=val3;
				obj3.options(index3).text=val4;
				
				obj3.options(index3+1).value=finval;
				obj3.options(index3+1).text=fintext;
				
				obj3.options(index3+1).selected=true;

			// adding colors... red to mainmenus and Black to submenus

			if(colr == 'red' && colr1 == 'black')
			{
				obj3.options(index3+1).style.color='RED';
				obj3.options(index3).style.color='BLACK';
			}
			else if(colr == 'red' && colr1 == 'red')
			{
				obj3.options(index3+1).style.color='RED';
				obj3.options(index3).style.color='RED';
			}
			else if(colr == 'black' && colr1 == 'red')
			{
				obj3.options(index3+1).style.color='BLACK';
				obj3.options(index3).style.color='RED';
			}
			else if(colr == 'black' && colr1 == 'black')
			{
				obj3.options(index3+1).style.color='black';
				obj3.options(index3).style.color='black';
			}

		}			
	}

	
	//moving towards right... 3 is passed on click of Right button... 

	else if(num == 3)
	{
		var obj1 ='';//Construct_ca_menu_form.Menu.selectedIndex;
		var menuid = '';//Construct_ca_menu_form.Menu.options(obj1).value;

				
				var trimval=trimString(val2);
				if(index3!=0)
				{
				var topval=obj3.options(index3-1).value;
				var toplevel=topval.split("#");
				}
				else
				{
					var toplevel = new Array();
					toplevel[1] = "-2";
				}
		
	if(level[1] <= toplevel[1] && level[1] < 5 && index3!=0 && toplevel[1]!=-2 )
	{
		var j = 0;
		for(i=0;i<obj3.length && j!=-1;i++)
	{

		var val = obj3.options(i).value;
		var level = val.split("#");
		var text = obj3.options(i).text;
		var opt_level = 0;

		if(i == obj3.length-1)
		{
			var opt_level = parseInt(level[1])+1;
	
		}
		else if(i == index3)
		{
			var opt_level = parseInt(level[1])+1;
		}
		else 
		{
			opt_level = level[1];
		}

		var option_id = level[0];

	
		if(opt_level == 1)
		{
			add =menuid;
			var H1index = val;
			
		}
		else if( opt_level == 2 )
		{
			add =H1index;
			var H2index = val;
		}
		else if( opt_level == 3 )
		{
			add =H2index;
			var H3index = val;
		}
		else if( opt_level == 4 )
		{
			add = H3index;
			var H4index = val;
		}
		else if( opt_level == 5 )
		{
			add = H4index;
			var H5index = val;
		}
		if (i == index3 )
			j = -1;
		else
			j = 1;
				
	}


	var chkmenu = add.split("#");
			
	if(	chkmenu[2] == 'M')
	{
								
			if(level[1] == 1 )
			{
				var add = "#2#"+level[2];
				var lefttxt = spc+trimval;
				var leftval = level[0]+add;
			
			}
			else if(level[1] == 2 )
			{
				var add = "#3#"+level[2];
				var lefttxt = spc+spc+trimval;
				var leftval = level[0]+add;
			
			}
			else if(level[1] == 3 )
			{
				var add = "#4#"+level[2];
				var lefttxt = spc+spc+spc+trimval;
				var leftval = level[0]+add;
			}
			else if(level[1] == 4 )
			{
				var add = "#5#"+level[2];
				var lefttxt = spc+spc+spc+spc+trimval;
				var leftval = level[0]+add;
			}
				
			obj3.options(index3).value=leftval;
			obj3.options(index3).text=lefttxt;
			

				}
			}	
	}

	//moving towards left....... 4 is passed on click of left button... 
		
		else if(num == 4 && level[1]!=1)
		{
		
			var len = obj3.length;
			var trmval2=trimString(val2);
			if(index3+1 != obj3.length)
			{
				var botval=obj3.options(index3+1).value;
				var botlevel=botval.split("#");
			}
			else
			{
				var botlevel = new Array();
				botlevel[0]="";
				botlevel[1]="-2";
			}
				
				
		if(level[1]+1 == botlevel[1] || level[1] == botlevel[1] || level[1] >= botlevel[1] || botlevel[1]== -2 )
		{

			var i = index3+1;
			var checkval = "";

		
		if(level[2] == 'F' && i!=obj3.length && botlevel[2]!='M' && botlevel[1]!='1')
			{
	
				var lowval=obj3.options(i).value;
				var lowlevel=lowval.split("#");
				
				for(i;lowlevel[1]!=1 && i!=len;i++)
				{
					if((lowlevel[2] == 'M' && level[1] <=lowlevel[1]) || (lowlevel[2] == 'F' && level[2] == 'F' && level[1] ==lowlevel[1]))
					{
						checkval = "-2";
						break;
					}
					else
					{	
						checkval = " ";
						lowval=obj3.options(i).value;
						lowlevel=lowval.split("#");
						
					}
			
				}
			

		}
		
		if((checkval!="-2") && ((botlevel[2] != 'M' && level[1] >= botlevel[1]) || (botlevel[2] == 'M' && level[1] > botlevel[1]) || (botlevel[2] == 'M' && level[2] == 'M')) )		
//if((checkval!="-2") && (botlevel[2] != 'M' && level[1] >= botlevel[1]) )		
		{
				if(level[1] == 2 )
				{
					var add = "#1#"+level[2];
					var rightval=level[0]+add;		
					var righttxt=trmval2;
				}
				else if(level[1] == 3)
				{
					var add = "#2#"+level[2];
					var rightval=level[0]+add;		
					var righttxt=spc+trmval2;
				}
				else if(level[1] == 4)
				{
					var add = "#3#"+level[2];
					var rightval=level[0]+add;		
					var righttxt=spc+spc+trmval2;
				}
				else if(level[1] == 5)
				{
					var add = "#4#"+level[2];
					var rightval=level[0]+add;		
					var righttxt=spc+spc+spc+trmval2;
				}
								
				obj3.options(index3).text=righttxt;
				obj3.options(index3).value=rightval;
				
			}
		}
	}			
}

}

// remove function is invoked on click remove button 
function remove()
{
	var obj=Construct_ca_menu_form.MainMenus;
	var index=obj.selectedIndex;
	if(index!=-1)
	{
		if(index == 0 && obj.length == 1)
		{
				obj.remove(index);
				return;
		}

		var val4=obj.options(index).value;
		var level1=val4.split("#");

		//var topval = obj.options(index+1).value;
		//var toplevel=topval.split("#");
		
		
		//var botval = obj.options(index-1).value;
		//var botlevel=botval.split("#");
		
		if(index!= 0)
		{
			var botval = obj.options(index-1).value;
			var botlevel=botval.split("#");
		}
		else
		{
			var botlevel = new Array(); 
			botlevel[0]="";
			botlevel[1]='-2';
		}

		if(obj.length-1!=index)
		{
			var val3=obj.options(index+1).value;
			var level=val3.split("#");
		}
		else
		{
			var level = new Array(); 
			level[0]="";
			level[1]='-2';
		}
	}
	if(index!=-1)
	{
		if(level1[1] == 1 || level1[1] == -2)
		{
			if(level[1]!=2 || level[1] == -2)
			{
				obj.remove(index);
			}
		}
		else
		{
			
			var cnts =parseInt(botlevel[1]);
			//cnts = botlevel[1];
			cnts++;
			//if( ((level[1]+1) >= botlevel[1]) && ((level[2] =='M' && botlevel[2] =='F' && level[1] > botlevel[1]) || (level[2] =='F' && botlevel[2] =='F' && level[1] > botlevel[1])))
			if((level[1] >(cnts)) || ((level[2] =='M' && botlevel[2] =='F' && level[1] > botlevel[1]) || (level[2] =='F' && botlevel[2] =='F' && level[1] > botlevel[1])))
			{
				//alert(cnts);	
			}
			else
			{
				obj.remove(index);
			}
		}

	}
}


function create()
{
	//f_query_add_mod.location.href = "../../eCA/jsp/ConstructCAMenuMain_temp.jsp" ;
	f_query_add_mod.location.href = "../../ePH/jsp/CreateUserDesktopFrame.jsp" ;
	
	//construct_ca_menu.location.href='../../eCA/jsp/AddModifyCreateUserDesktop.jsp';
	//frameAddModifyCreateUserDesktopResult.location.href='../../eCA/jsp/ConstructUserDesktop.jsp';
}

function reset()
{
		//construct_ca_menu.location.reload();
		f_query_add_mod.document.location.reload();
}

function childcheck()
{
	var obj = construct_ca_menu.document.Construct_ca_menu_form.MainMenus;	
	k=0;j=0;l=0;
	var level1=new Array();
	var level2=new Array();

	for(i=0;i<obj.length;i++)
	{
		var val = obj.options(i).value;
		var level = val.split("#");
		if (level[2]=='M')
		{	
			if(level[1]==1)
			{
				level1[k]=i;
				k++;
			}	
			if(level[1]==2)
			{
				level2[j]=i;
				j++;
			}
			/*if(level[1]==3)
			{
				level3[o]=i;
				o++;
			}
			if(level[1]==4)
			{
				level4[p]=i;
				p++;
			}*/
			

					
					
			var head=new Array();
			head[l]=i;
			
			headlength=head.length;
			if ((head[headlength-1])==((obj.length)-1))
			{
				
				var msg=getMessage("ATLEAST_ONE_CHILD_MENU",'CA');
				alert(msg);
				construct_ca_menu.document.Construct_ca_menu_form.MainMenus.focus();
				return false;
			}
			l++;
	}
	
	for(m=0;m<level1.length;m++)
	{
		for(n=0;n<level2.length;n++)
		{
			if(level2[n]<level1[m])
			{
				for(v=level2[n];v<level1[m];v++)
				{
				  if(level[2]!='F')
					{
						var msg=getMessage("ATLEAST_ONE_CHILD_MENU",'CA');
						alert(msg);
						//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
						construct_ca_menu.document.Construct_ca_menu_form.MainMenus.focus();
						return false;
					}
				}
			}
		}
	}
}
  return true;
}

function childcheck1()
{
	var obj = f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus;
	k=0;j=0;l=0,n=0,p=0,s=0,h=0;
	found=0;next=0;
   	var level1=new Array();
	var level2=new Array();
	var level3=new Array();

	for(i=0;i<obj.length;i++)
	{
		var val = obj.options(i).value;
		var level = val.split("#");
		if (level[2]=='M')
		{	level2[j]=i;
			if(level[1]==1)
			{
				level1[k]=i;
				k++;
			}
			headlength=level2.length;
			if ((level2[headlength-1])==((obj.length)-1))
			{
				
				var msg=getMessage("ATLEAST_ONE_CHILD_MENU",'CA');
				alert(msg);
				f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus.focus();
				return false;
			}
			j++;
		}
		
		
		
		if((level1.length)>1){
			for(l=1;l<level1.length;l++)
			{
				for(m=0;m<level2.length;m++)
				{
						if(level2[m]==level1[l])
						{
							found=level2[m-1];
							next=level2[m];
						}
				}
			}
		}
					/*for(n=found+1;n<(level2[m]-1);n++)
					{
						//alert("n"+n);
						//alert(level[2]);
						if(level[2]!='F')
						var msg=getCAMessage("ATLEAST_ONE_CHILD_MENU");
						alert(msg);
						construct_ca_menu.document.Construct_ca_menu_form.MainMenus.focus();
						return false;
					}*/
					if(next>0 && found>0)
					{
						if (next==(found+1))
						{
							var msg=getMessage("ATLEAST_ONE_CHILD_MENU",'CA');
							alert(msg);
							f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus.focus();
							return false;
						}
					}
					/*if(found>0 && next>0){
					for(n=(found+1);n<(next-1);n++){
					//alert("n"+n);
					//alert("level"+level[2]);
					if (level[2]!='F')
					{
						var msg=getCAMessage("ATLEAST_ONE_CHILD_MENU");
						alert(msg);
						construct_ca_menu.document.Construct_ca_menu_form.MainMenus.focus();
						return false;
					}
					
					}
					}*/
					headlength=level2.length;
					if ((level2[headlength-1])==((obj.length)-1))
					{
							if(level[2]=='F')
							{
								return true;
							}

					}
	}
	return true;
}


//For branch check
		//alert(level1[0]);
		//alert(level1[1]);
function branchcheck()
{

	var obj = f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus;
	k=0;j=0;l=0,n=0,p=0,s=0,h=0,q=2;
	   
	var level3=new Array();
	var lvlno=new Array();
	var lvlname=new Array();

	for(i=0;i<obj.length;i++)
	{
		var val = obj.options(i).value;
		var level = val.split("#");
		if(level[2]=='M')
			{
				if(level[1]==1)
					{
						level3[h]=i;
						//alert("level"+level3[h]);
						h++;
					}
			}
			lvlno[i]=level[1];
			lvlname[i]=level[2];
			//alert("levels"+lvlno[i]);
	}

	for(i=0;i<obj.length;i++)
	{
		
		var val = obj.options(i).value;
		var level = val.split("#");
		if ((level3.length)!=0)
		{	
			for(p=0;p<((level3.length)-1);p++)
			{
				//alert("p"+p);
				q=2;
				from=level3[p];
				to=level3[p+1];
			
					for(s=(from+1);s<=(to-1);s++)
					{
						if(s==1)q=2;
						
							
						if(lvlname[s]=='M')
						{
							if(lvlname[s-1]=='F')if(lvlno[s]<=(q-1))q=lvlno[s];
							if (lvlno[s]!=q)
							{
						var msg=getMessage("ATLEAST_ONE_CHILD_MENU",'CA');
								alert(msg);
								f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus.focus();
								return false;
							}
							q++;
						}
				
					if(lvlname[s]=='F')
					{   //for leaf node    
						if(lvlname[s-1]=='F')if(lvlno[s]<=(q-1))q=lvlno[s];
							if(lvlno[s]!=q)
							{
						var msg=getMessage("ATLEAST_ONE_CHILD_MENU",'CA');
								alert(msg);
								f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus.focus();
								return false;
							}
					}
						
			    }
		    }
		
		}

	}
	
	if (((level3.length)!=0) && (obj.length!=0))
	{	
		q=2;
		for(f=(level3[(level3.length)-1]+1);f<((obj.length)-1);f++)
		{
			if(lvlname[f]=='M')
						{
							if(lvlname[f-1]=='F')if(lvlno[f]<=(q-1))q=lvlno[f];
							if (lvlno[f]!=q)
							{
						        var msg=getMessage("ATLEAST_ONE_CHILD_MENU",'CA');
								alert(msg);
								frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus.focus();
								return false;
							}
							q++;
						}//}
						/*else
						{
							alert("here"+q);
							q=q-1;
							if (lvlno[f]!=q)
							{
								//alert("here");
								var msg=getCAMessage("ATLEAST_ONE_CHILD_MENU");
								alert(msg);
								construct_ca_menu.document.Construct_ca_menu_form.MainMenus.focus();
								return false;
							}
							q++;
						}*/	
					if(lvlname[f]=='F')
					{
							if(lvlno[f]!=q)
							{
						var msg=getMessage("ATLEAST_ONE_CHILD_MENU",'CA');
								alert(msg);
								f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus.focus();
								return false;
							}
					}

		}
	}	
	

return true;
}


function apply()
{
	if(f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form==null)
    {
	    var Desktop_code = f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Desktop_code;
		var Desktop_name=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Desktop_name;
		var module_id=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.module_id;
		var Function_id=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Function_id;
		var desktop_summary_type=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.desktop_summary_type;
		var eff_status=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.eff_status;
		var summ_show_by=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.summ_show_by;
		var function_name=f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.function_name;
		var fields = new Array(Desktop_code,Desktop_name,module_id,Function_id);
		var names = new Array (f_query_add_mod.construct_ca_menu.getLabel("eSM.Desktop.label",'eSM')+" "+f_query_add_mod.construct_ca_menu.getLabel("Common.code.label",'COMMON'),f_query_add_mod.construct_ca_menu.getLabel("eSM.Desktop.label",'eSM')+" "+f_query_add_mod.construct_ca_menu.getLabel("Common.name.label",'COMMON'),f_query_add_mod.construct_ca_menu.getLabel("Common.Module.label",'COMMON'),f_query_add_mod.construct_ca_menu.getLabel("Common.Function.label",'COMMON'));
    
	if(checkFieldsofMst(fields, names, messageFrame))
   {
		var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='formtemp' id='formtemp' method='post' action='../../servlet/eSM.CreateUserDesktopServlet'>";
	
	HTMLVal+="<input type='hidden' name='Desktop_code' id='Desktop_code' value='"+Desktop_code.value+"'>";
	HTMLVal+="<input type='hidden' name='Desktop_name' id='Desktop_name' value='"+Desktop_name.value+"'>";
	HTMLVal+="<input type='hidden' name='module_id' id='module_id' value='"+module_id.value+"'>";
	HTMLVal+="<input type='hidden' name='Function_id' id='Function_id' value='"+Function_id.value+"'>";
	HTMLVal+="<input type='hidden' name='desktop_summary_type' id='desktop_summary_type' value='"+desktop_summary_type.value+"'>";
	HTMLVal+="<input type='hidden' name='eff_status' id='eff_status' value='"+eff_status.value+"'>";
	HTMLVal+="<input type='hidden' name='summ_show_by' id='summ_show_by' value='"+summ_show_by.value+"'>";
	HTMLVal+="<input type='hidden' name='function_name' id='function_name' value='"+function_name.value+"'></form></body></html>";
	frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	frames[2].document.formtemp.submit();
	}	
  }
	
	else if(f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form!=null)
	{
		var Desktop_code = f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Desktop_code;
		var Desktop_name=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Desktop_name;
		var module_id=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.module_id;
		var Function_id=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Function_id;
		var desktop_summary_type=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.desktop_summary_type;
		var eff_status=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.eff_status;
		var summ_show_by=  f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.summ_show_by;
        var function_name=f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.function_name;
		var fields = new Array(Desktop_code,Desktop_name,module_id,Function_id);
		var names = new Array (f_query_add_mod.construct_ca_menu.getLabel("eSM.Desktop.label",'eSM')+" "+f_query_add_mod.construct_ca_menu.getLabel("Common.code.label",'COMMON'),f_query_add_mod.construct_ca_menu.getLabel("eSM.Desktop.label",'eSM')+" "+f_query_add_mod.construct_ca_menu.getLabel("Common.name.label",'COMMON'),f_query_add_mod.construct_ca_menu.getLabel("Common.Module.label",'COMMON'),f_query_add_mod.construct_ca_menu.getLabel("Common.Function.label",'COMMON'));


if(checkFieldsofMst(fields, names, messageFrame))
{	
	if(branchcheck()){

	if(childcheck1()){

	var obj = f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.MainMenus;	

	var menuid = f_query_add_mod.construct_ca_menu.document.CreateDesktop_form.Desktop_code.value;
	
	var arr = new Array();

	var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='formtemp' id='formtemp' method='post' action='../../servlet/eSM.CreateUserDesktopServlet'>";
	
	HTMLVal+="<input type='hidden' name='Desktop_code' id='Desktop_code' value='"+Desktop_code.value+"'>";
	HTMLVal+="<input type='hidden' name='Desktop_name' id='Desktop_name' value='"+Desktop_name.value+"'>";
	HTMLVal+="<input type='hidden' name='module_id' id='module_id' value='"+module_id.value+"'>";
	HTMLVal+="<input type='hidden' name='Function_id' id='Function_id' value='"+Function_id.value+"'>";
	HTMLVal+="<input type='hidden' name='desktop_summary_type' id='desktop_summary_type' value='"+desktop_summary_type.value+"'>";
	HTMLVal+="<input type='hidden' name='eff_status' id='eff_status' value='"+eff_status.value+"'>";
	HTMLVal+="<input type='hidden' name='summ_show_by' id='summ_show_by' value='"+summ_show_by.value+"'>";
	HTMLVal+="<input type='hidden' name='function_name' id='function_name' value='"+function_name.value+"'>";

	var rowcnt = obj.length;
	for(i=0;i<obj.length;i++)
	{
		var val = obj.options(i).value;
		var level = val.split("#");
		var text = obj.options(i).text;
		var trimtxt = trimString(text);
		var header_opt_occ = 1;
		var option_id = level[0];
		var add="";
		var head_index = 0;
		if(level[1] == 1)
		{
			add =menuid;
			head_index = -1;
			var H1index = option_id;
			var H1occur = i;
		}
		else if( level[1] == 2 )
		{
			add =H1index;
			head_index = H1occur;
			var H2index = option_id;
			var H2occur = i;
		}
		else if( level[1] == 3 )
		{
			add =H2index;
			head_index = H2occur;
			var H3index = option_id;
			var H3occur = i;
		}
		else if( level[1] == 4 )
		{
			add = H3index;
			head_index = H3occur;
			var H4index = option_id;
			var H4occur = i;
		}
		else if( level[1] == 5 )
		{
			add = H4index;
			head_index = H4occur;
			var H5index = option_id;
			var H5occur = i;
		}

		arr[i] = option_id+"#"+add+"#"+i;
		var findindx = arr[i].split("#");
		var header = findindx[1]; 
		var counter = 0;
		for(j=0;j<=findindx[2];j++)
		{
			var chkarr = arr[j].split("#");
			
			var opt_id = 0 ;
		
			if(trimString(option_id) == trimString(chkarr[0]))
			{
				counter++;
			}
		}
		if(counter == 0){
			counter = 1;
		}
		arr[i]+="#"+counter;
		var header_occur = "1";
		if(head_index!= -1)
		{
			var headersplit = arr[head_index].split("#");	
			header_occur = headersplit[3];
		}
		else
			header_occur = "1";
		
		
/**************/		
		
	/*	var headercount = 0;
		header_opt_occ = 1;
		for(k=0;k<=findindx[2];k++)
		{
			var chkarr = arr[k].split("#");
		//	alert("h:"+option_id+":chk:"+chkarr[0]+":");			
			
			if(trimString(option_id) == trimString(chkarr[0]))
			{

				headercount++;
			//	alert("cont"+headercount);
			}
			if(header == menuid )
			{
					header_opt_occ="1";
			}
			
		
		}
		if(headercount == 0)
		{
			headercount = 1;
		}
		//alert("hcount"+headercount);
		header_opt_occ = headercount;*/

		arr[i]+="#"+header_occur;
		
		var splitval = arr[i].split("#");
		
		
		HTMLVal+="<input type='hidden' name=option_id"+i+" value='"+splitval[0]+"'>";
		HTMLVal+="<input type='hidden' name=option_occurance"+i+" value='"+splitval[3]+"'>";
		HTMLVal+="<input type='hidden' name=header_option_id"+i+" value='"+splitval[1]+"'>";
		HTMLVal+="<input type='hidden' name=header_option_occurance"+i+" value='"+splitval[4]+"'>";
		HTMLVal+="<input type='hidden' name=order_seq_no"+i+" value='"+splitval[2]+"'>";
		
		
		}
			
HTMLVal+="<input type='hidden' name='row_count' id='row_count' value='"+rowcnt+"'>";
HTMLVal+="<input type='hidden' name='mode' id='mode' value='"+f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.mode.value+"'>";
HTMLVal+="<input type='hidden' name='desktop_chart' id='desktop_chart' value='"+f_query_add_mod.frameAddModifyCreateUserDesktopResult.document.Construct_ca_menu_form.desktop_chart.value+"'>";
HTMLVal+="<input type='hidden' name='menu_id' id='menu_id' value='"+menuid+"'></form></body></html>";

	frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	frames[2].document.formtemp.submit();
}else
{
messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
return false;
}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		return false;
	}

}

	}
	else
	{
		
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		return false;
	}

}


function onSuccess(){
	f_query_add_mod.location.href = "../../ePH/jsp/CreateUserDesktopFrame.jsp" ;
	f_query_add_mod.location.reload();

}

//dTree construction

// Node object
function Node(id, pid, name, url, title, target, icon, iconOpen, open) {
	this.id = id;
	this.pid = pid;
	this.name = name;
	this.url = url;
	this.title = title;
	this.target = target;
	this.icon = icon;
	this.iconOpen = iconOpen;
	this._io = open || false;
	this._is = false;
	this._ls = false;
	this._hc = false;
	this._ai = 0;
	this._p;
};

// Tree object
function dTree(objName) {
	this.config = {
		target					: null,
		folderLinks			: true,
		useSelection		: true,
		useCookies			: true,
		useLines				: true,
		useIcons				: true,
		useStatusText		: false,
		closeSameLevel	: false,
		inOrder					: false
	}
	this.icon = {
		/*root		: '../images/dtree/base.gif',
		folder		: '../images/dtree/folder.gif',
		folderOpen	: '../images/dtree/folderopen.gif',
		node		: '../images/dtree/page.gif',
		empty		: '../images/dtree/empty.gif',
		line		: '../images/dtree/line.gif',
		join		: '../images/dtree/join.gif',
		joinBottom	: '../images/dtree/joinbottom.gif',
		plus		: '../images/dtree/plus.gif',
		plusBottom	: '../images/dtree/plusbottom.gif',
		minus		: '../images/dtree/minus.gif',
		minusBottom	: '../images/dtree/minusbottom.gif',
		nlPlus		: '../images/dtree/nolines_plus.gif',
		nlMinus		: '../images/dtree/nolines_minus.gif'*/

		root				: '../../images/base.gif',
		folder			: '../../eCommon/images/blank.gif',
		folderOpen	: '../../eCommon/images/blank.gif',
		node				: '../../eCommon/images/blank.gif',
		view			: '../../eCommon/images/blank.gif',
		empty				: '../images/empty.gif',
		line				: '../images/line.gif',
		join				: '../images/join.gif',
		joinBottom	: '../images/joinbottom.gif',
		plus				: '../../eCommon/images/tree_handlerightmiddle.gif',
		plusBottom	: '../../eCommon/images/tree_handlerightlast.gif',
		minus				: '../../eCommon/images/tree_handledownmiddle.gif',
		minusBottom	: '../../eCommon/images/tree_handledownlast.gif',
		nlPlus			: '../images/nolines_plus.gif',
		nlMinus			: '../images/nolines_minus.gif'
	};
	this.obj = objName;
	this.aNodes = [];
	this.aIndent = [];
	this.root = new Node(-1);
	this.selectedNode = null;
	this.selectedFound = false;
	this.completed = false;
};

	// Adds a new node to the node array
	dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open) {
		this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open);
	};

	// Open/close all nodes
	dTree.prototype.openAll = function() {
		this.oAll(true);
	};
	dTree.prototype.closeAll = function() {
		this.oAll(false);
	};

	// Outputs the tree to the page
	dTree.prototype.toString = function() {
		var str = '<div class="dtree">\n';
		if (document.getElementById) {
			if (this.config.useCookies) this.selectedNode = this.getSelected();
			str += this.addNode(this.root);
		} else str += 'Browser not supported.';
		str += '</div>';
		if (!this.selectedFound) this.selectedNode = null;
		this.completed = true;
		return str;
	};

	// Creates the tree structure
	dTree.prototype.addNode = function(pNode) {
		
		var str = '';
		var n=0;
			
		if (this.config.inOrder) n = pNode._ai;

		for (n; n<this.aNodes.length; n++) {
			if (this.aNodes[n].pid == pNode.id) {
			

				var cn = this.aNodes[n];
				
				cn._p = pNode;
				cn._ai = n;
				this.setCS(cn);
				if (!cn.target && this.config.target) cn.target = this.config.target;
				if (cn._hc && !cn._io && this.config.useCookies) cn._io = this.isOpen(cn.id);
				if (!this.config.folderLinks && cn._hc) cn.url = null;
				if (this.config.useSelection && cn.id == this.selectedNode && !this.selectedFound) {
						cn._is = true;
						this.selectedNode = n;
						this.selectedFound = true;
				}
				str += this.node(cn, n);
				if (cn._ls) break;
			}
		}
		return str;
	};


	//this function is used to expand or collapse the tree structure
	function changeTree(toggleButton){
		if(toggleButton.value=='Collapse All'){
			toggleButton.value='Expand All';
			obj.closeAll();
		}else{
			toggleButton.value='Collapse All';
			obj.openAll();	
		}
	}

	// Creates the node icon, url and text
	dTree.prototype.node = function(node, nodeId) {
		var str = '<div class="dTreeNode">' 
		if(node.name!="")
			str = str + this.indent(node, nodeId);
		else
			str = '<div class="dTreeNode">' + this.indent(node, nodeId);

		//if(node.name!="Root")
		//{

		if (this.config.useIcons) {
			if (!node.icon) node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);
			if (!node.iconOpen) node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;
			if (this.root.id == node.pid) {
				node.icon = this.icon.root;
				node.iconOpen = this.icon.root;
			}
				if(node.pid!=-1)
				{
					str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';
				}
		}
		if (node.url) {
			if(node.pid!=-1)
			{
			str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"';
			if (node.title) str += ' title="' + node.title + '"';
			if (node.target) str += ' target="' + node.target + '"';
			if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';
			if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
				str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');"';
			str += '>';

			}
		}
		else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)
			str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');" class="node">';
		str += node.name;
		if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';
		str += '</div>';
		if (node._hc) {
			str += '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';
			str += this.addNode(node);
			str += '</div>';
		}
		this.aIndent.pop();
		//}
		return str;

	};

	// Adds the empty and line icons
	dTree.prototype.indent = function(node, nodeId) {
		var str = '';
		if (this.root.id != node.pid) {
			for (var n=0; n<this.aIndent.length; n++)
				str += '<img src="' + ( (this.aIndent[n] == 1 && this.config.useLines) ? this.icon.line : this.icon.empty ) + '" alt="" />';
			(node._ls) ? this.aIndent.push(0) : this.aIndent.push(1);
			if (node._hc) {
				str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');"><img id="j' + this.obj + nodeId + '" src="';
				if (!this.config.useLines) str += (node._io) ? this.icon.nlMinus : this.icon.nlPlus;
				else str += ( (node._io) ? ((node._ls && this.config.useLines) ? this.icon.minusBottom : this.icon.minus) : ((node._ls && this.config.useLines) ? this.icon.plusBottom : this.icon.plus ) );
				str += '" alt="" /></a>';
			} else str += '<img src="' + ( (this.config.useLines) ? ((node._ls) ? this.icon.joinBottom : this.icon.join ) : this.icon.empty) + '" alt="" />';
		}
		return str;
	};

	// Checks if a node has any children and if it is the last sibling
	dTree.prototype.setCS = function(node) {
		var lastId;
		for (var n=0; n<this.aNodes.length; n++) {
			if (this.aNodes[n].pid == node.id) node._hc = true;
			if (this.aNodes[n].pid == node.pid) lastId = this.aNodes[n].id;
		}
		if (lastId==node.id) node._ls = true;
	};

	// Returns the selected node
	dTree.prototype.getSelected = function() {
		var sn = this.getCookie('cs' + this.obj);
		return (sn) ? sn : null;
	};

	// Highlights the selected node
	dTree.prototype.s = function(id) {
		if (!this.config.useSelection) return;
		var cn = this.aNodes[id];
		if (cn._hc && !this.config.folderLinks) return;
		if (this.selectedNode != id) {
			if (this.selectedNode || this.selectedNode==0) {
				eOld = document.getElementById("s" + this.obj + this.selectedNode);
				eOld.className = "node";
			}
			eNew = document.getElementById("s" + this.obj + id);

			eNew.className = "nodeSel";

			this.selectedNode = id;
			if (this.config.useCookies) this.setCookie('cs' + this.obj, cn.id);
		}
	};

	// Toggle Open or close
	dTree.prototype.o = function(id) {
		var cn = this.aNodes[id];
		this.nodeStatus(!cn._io, id, cn._ls);
		cn._io = !cn._io;
		if (this.config.closeSameLevel) this.closeLevel(cn);
		if (this.config.useCookies) this.updateCookie();
	};

	// Open or close all nodes
	dTree.prototype.oAll = function(status) {
		for (var n=0; n<this.aNodes.length; n++) {
			if (this.aNodes[n]._hc && this.aNodes[n].pid != this.root.id) {
				this.nodeStatus(status, n, this.aNodes[n]._ls)
				this.aNodes[n]._io = status;
			}
		}
		if (this.config.useCookies) this.updateCookie();
	};

	// Opens the tree to a specific node
	dTree.prototype.openTo = function(nId, bSelect, bFirst) {
		if (!bFirst) {
			for (var n=0; n<this.aNodes.length; n++) {
				if (this.aNodes[n].id == nId) {
					nId=n;
					break;
				}
			}
		}
		var cn=this.aNodes[nId];
		if (cn.pid==this.root.id || !cn._p) return;
		cn._io = true;
		cn._is = bSelect;
		if (this.completed && cn._hc) this.nodeStatus(true, cn._ai, cn._ls);
		if (this.completed && bSelect) this.s(cn._ai);
		else if (bSelect) this._sn=cn._ai;
		this.openTo(cn._p._ai, false, true);
	};

	// Closes all nodes on the same level as certain node
	dTree.prototype.closeLevel = function(node) {
		for (var n=0; n<this.aNodes.length; n++) {
			if (this.aNodes[n].pid == node.pid && this.aNodes[n].id != node.id && this.aNodes[n]._hc) {
				this.nodeStatus(false, n, this.aNodes[n]._ls);
				this.aNodes[n]._io = false;
				this.closeAllChildren(this.aNodes[n]);
			}
		}
	}

	// Closes all children of a node
	dTree.prototype.closeAllChildren = function(node) {
		for (var n=0; n<this.aNodes.length; n++) {
			if (this.aNodes[n].pid == node.id && this.aNodes[n]._hc) {
				if (this.aNodes[n]._io) this.nodeStatus(false, n, this.aNodes[n]._ls);
				this.aNodes[n]._io = false;
				this.closeAllChildren(this.aNodes[n]);		
			}
		}
	}

	// Change the status of a node(open or closed)
	dTree.prototype.nodeStatus = function(status, id, bottom) {
		eDiv	= document.getElementById('d' + this.obj + id);
		eJoin	= document.getElementById('j' + this.obj + id);
		if (this.config.useIcons) {
			eIcon	= document.getElementById('i' + this.obj + id);
			eIcon.src = (status) ? this.aNodes[id].iconOpen : this.aNodes[id].icon;
		}
		eJoin.src = (this.config.useLines)?
		((status)?((bottom)?this.icon.minusBottom:this.icon.minus):((bottom)?this.icon.plusBottom:this.icon.plus)):
		((status)?this.icon.nlMinus:this.icon.nlPlus);
		eDiv.style.display = (status) ? 'block': 'none';
	};


	// [Cookie] Clears a cookie
	dTree.prototype.clearCookie = function() {
		var now = new Date();
		var yesterday = new Date(now.getTime() - 1000 * 60 * 60 * 24);
		this.setCookie('co'+this.obj, 'cookieValue', yesterday);
		this.setCookie('cs'+this.obj, 'cookieValue', yesterday);
	};

	// [Cookie] Sets value in a cookie
	dTree.prototype.setCookie = function(cookieName, cookieValue, expires, path, domain, secure) {
		document.cookie =
			escape(cookieName) + '=' + escape(cookieValue)
			+ (expires ? '; expires=' + expires.toGMTString() : '')
			+ (path ? '; path=' + path : '')
			+ (domain ? '; domain=' + domain : '')
			+ (secure ? '; secure' : '');
	};

	// [Cookie] Gets a value from a cookie
	dTree.prototype.getCookie = function(cookieName) {
		var cookieValue = '';
		var posName = document.cookie.indexOf(escape(cookieName) + '=');
		if (posName != -1) {
			var posValue = posName + (escape(cookieName) + '=').length;
			var endPos = document.cookie.indexOf(';', posValue);
			if (endPos != -1) cookieValue = unescape(document.cookie.substring(posValue, endPos));
			else cookieValue = unescape(document.cookie.substring(posValue));
		}
		return (cookieValue);
	};

	// [Cookie] Returns ids of open nodes as a string
	dTree.prototype.updateCookie = function() {
		var str = '';
		for (var n=0; n<this.aNodes.length; n++) {
			if (this.aNodes[n]._io && this.aNodes[n].pid != this.root.id) {
				if (str) str += '.';
				str += this.aNodes[n].id;
			}
		}
		this.setCookie('co' + this.obj, str);
	};

	// [Cookie] Checks if a node id is in a cookie
	dTree.prototype.isOpen = function(id) {
		var aOpen = this.getCookie('co' + this.obj).split('.');
		for (var n=0; n<aOpen.length; n++)
			if (aOpen[n] == id) return true;
		return false;
	};

	// If Push and pop is not implemented by the browser
	if (!Array.prototype.push) {
		Array.prototype.push = function array_push() {
			for(var i=0;i<arguments.length;i++)
				this[this.length]=arguments[i];
			return this.length;
		}
	};
	if (!Array.prototype.pop) {
		Array.prototype.pop = function array_pop() {
			lastElement = this[this.length-1];
			this.length = Math.max(this.length-1,0);
			return lastElement;
		}
	};

	function loadTree()
	{
		var counter = document.forms[0].MainMenus.length;
		for(var i=0;i<counter;i++){	
			document.forms[0].MainMenus.options.remove("MainMenus");
		}
		var HTMLVal="";
		var obj = Construct_ca_menu_form.Menu.selectedIndex;
	
		var main_menu_id = Construct_ca_menu_form.Menu.options(obj).value;
		HTMLVal+="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='formtemphtml' id='formtemphtml' action='../../ePH/jsp/ConstructExistingUserDesktopMenu.jsp' method='post'><input type='hidden' name='main_menu_id' id='main_menu_id' value='"+main_menu_id+"'></input><input type='hidden' name='desktop_chart' id='desktop_chart' value='"+document.Construct_ca_menu_form.desktop_chart.value+"'></input></form></body></html>";

		parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.parent.frames[2].document.formtemphtml.submit();
	}
function loadTreeonLoad()
	{
		var HTMLVal="";
		var main_menu_id = Construct_ca_menu_form.desktop_code.value;
		HTMLVal+="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='formtemphtml' id='formtemphtml' action='../../ePH/jsp/ConstructExistingUserDesktopMenu.jsp' method='post'><input type='hidden' name='main_menu_id' id='main_menu_id' value='"+main_menu_id+"'></input><input type='hidden' name='desktop_chart' id='desktop_chart' value='"+document.Construct_ca_menu_form.desktop_chart.value+"'></input></form></body></html>";

		parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.parent.frames[2].document.formtemphtml.submit();
	}


/*function Menu_Select(form)
	{	
		document.Construct_ca_menu_form.default_menu.disabled=false;

		if(form.value == "D")
		{
			document.Construct_ca_menu_form.desktop_hdn.value="Y";
			document.Construct_ca_menu_form.patient_hdn.value="N";
			document.Construct_ca_menu_form.desktop_chart.value="D";
		}
		else 
		{
			document.Construct_ca_menu_form.patient_hdn.value="Y";
			document.Construct_ca_menu_form.desktop_hdn.value="N";
			document.Construct_ca_menu_form.desktop_chart.value="P";
		}

		var count=document.forms[0].Menu.length;
		if(count>0)
		{
			for(var i=0;i<=count;i++)
			{
				parent.frames[1].document.forms[0].Menu.options.remove("Menu");
			}
			var opt = parent.frames[1].document.createElement('OPTION');
			opt.text = '---------'+getLabel("Common.defaultSelect.label","Common")+'---------';
			opt.value ='';
			parent.frames[1].document.forms[0].Menu.add(opt);
		}

		var funcntr = parent.frames[1].document.forms[0].funcopt.length;
		for(var i=0;i<funcntr;i++){	
			parent.frames[1].document.forms[0].funcopt.options.remove("funcopt");
		}

		var counter = parent.frames[1].document.forms[0].MainMenus.length;
		for(var i=0;i<counter;i++){	
			parent.frames[1].document.forms[0].MainMenus.options.remove("MainMenus");
		}

		var HTMLVal="";
		HTMLVal+="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='formMenuTemphtml' id='formMenuTemphtml' action='../../eCA/jsp/ConstructPopulateMenu.jsp' method='post'><input type='hidden' name='desktop_hdn' id='desktop_hdn' value='"+document.Construct_ca_menu_form.desktop_hdn.value+"'></input><input type='hidden' name='patient_hdn' id='patient_hdn' value='"+document.Construct_ca_menu_form.patient_hdn.value+"'></input><input type='hidden' name='Menulength' id='Menulength' value='"+document.Construct_ca_menu_form.MainMenus.length+"'></input><input type='hidden' name='desktop_chart' id='desktop_chart' value='"+document.Construct_ca_menu_form.desktop_chart.value+"'></input></form></body></html>";

		parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.frames[2].document.formMenuTemphtml.submit();
}

function Call_default()
{
	var fields = new Array(parent.construct_ca_menu.document.Construct_ca_menu_form.Menu);
    var names = new Array (parent.construct_ca_menu.getLabel("Common.MenuID.label",'COMMON'));
	if(checkFieldsofMst(fields, names, parent.frames[2])){	
		
		var count=document.forms[0].MainMenus.length;
		if(count>0)
		{
			for(var i=0;i<=count;i++){
				parent.frames[1].document.forms[0].MainMenus.options.remove("MainMenus");
			}
		}
		var HTMLVal="";
		var obj = Construct_ca_menu_form.Menu.selectedIndex;
		var main_menu_id = Construct_ca_menu_form.Menu.options(obj).value;
		HTMLVal+="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='formtemphtml' id='formtemphtml' action='../../eCA/jsp/ConstructExistingMenu.jsp' method='post'><input type='hidden' name='main_menu_id' id='main_menu_id' value='MED_DFLT'></input><input type='hidden' name='desktop_chart' id='desktop_chart' value='"+document.Construct_ca_menu_form.desktop_chart.value+"'></input></input></form></body></html>";

		parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.frames[2].document.formtemphtml.submit();	 	

	}
}*/

function query()
{
	
	f_query_add_mod.location.href ="../../ePH/jsp/CreateDesktopQueryCriteria.jsp?function=modify";

}




function Getvalues(obj)
{
	var Module_Name=obj.name;
	var module_id=obj.value;
	removeitems(document.forms[0].Function_id);

	if(module_id=="PH" || module_id=="ST"){
	   var mode='PHIS_SUMMARY';	   
	   HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown='lockKey()' class='message'><form name='form1' id='form1' method='post' action='../../ePH/jsp/GetUserDesktopValue.jsp'><input type='hidden' name='module_id' id='module_id' value='"+module_id+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'></form></BODY></HTML>";
       parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
       parent.parent.messageFrame.document.form1.submit();
	   document.forms[0].module_id.disabled=true;

	   parent.frames[1].location.href = "../../ePH/jsp/ConstructUserDesktopforPharmacist.jsp?module_id="+module_id;
	}else{

 
		HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown='lockKey()' class='message'><form name='form1' id='form1' method='post' action='../../ePH/jsp/GetUserDesktopValue.jsp'><input type='hidden' name='module_id' id='module_id' value='"+module_id+"'><input type='hidden' name='mode' id='mode' value='function'></form></BODY></HTML>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
	}
} 

function GetvaluesOnLoad(value)
{
	
	var module_id=value;
	removeMenuitems(parent.frameAddModifyCreateUserDesktopResult.document.getElementById("Menuopts"));
	removeMenuitems(parent.frameAddModifyCreateUserDesktopResult.document.getElementById("funcopt"));

   HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><BODY onKeyDown='lockKey()' class='message'><form name='form1' id='form1' method='post' action='../../ePH/jsp/GetUserDesktopValue.jsp'><input type='hidden' name='module_id' id='module_id' value='"+module_id+"'></form></BODY></HTML>";
   parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
   parent.parent.messageFrame.document.form1.submit();
} 

 function removeitems(obj)
{
    var len=obj.length;
    var i=1;
    while(i<len)
    {
        len=obj.length
        obj.remove(i)
    }
}

function removeMenuitems(obj)
{
    var len=obj.length;
    var i=0;
    while(i<len)
    {
        len=obj.length
        obj.remove(i)
    }
}

/*function onSuccess() {
	f_query_add_mod.location.reload();
}*/
var temp="";
var temp1="";


function checkvalue(Obj,i)
{
	if(Obj.checked){
		Obj.value="Y";		
	}else{
		Obj.value="N";	
	}

}
function check_eff(obj){
	if(obj.checked){
		obj.value="E";
	}else{
		obj.value="D";
	}
}

function setClinrad(obj)
{		
   document.getElementById("desktop_summary_type").value=obj.value;	
   if(obj.value=="C")
	{
	   temp = 'CA';
	   temp1='Clinician Access';
	   var opt= parent.frames[0].document.createElement('OPTION');
	   opt.text=temp1;
	   opt.value=temp;
	   parent.frames[0].document.forms[0].module_id.add(opt);
	   document.forms[0].module_id.value='CA';
	   removeitems(document.forms[0].Function_id);
	   var mode='CA_summary';	   
	   HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown='lockKey()' class='message'><form name='form1' id='form1' method='post' action='../../ePH/jsp/GetUserDesktopValue.jsp'><input type='hidden' name='module_id' id='module_id' value='"+module_id+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'></form></BODY></HTML>";
      parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
      parent.parent.messageFrame.document.form1.submit();
	  document.forms[0].module_id.disabled=true;
	  

	   parent.frames[1].location.href = "../../ePH/jsp/ConstructUserDesktop.jsp";
	}
   else
	{
      document.forms[0].module_id.value='';
      document.forms[0].module_id.disabled=false;
	  i=0;
	   while(i<document.forms[0].module_id.length)
		{
		   if(document.forms[0].module_id(i).value=='CA')
			{
               document.forms[0].module_id.remove(i);
			}
			i++;
		 }
	  removeitems(document.forms[0].Function_id);
	  parent.frames[1].location.href = "../../eCommon/html/blank.html";
	}

/*?Desktop_code="+Desktop_code+"&Desktop_name="+Desktop_name+"&eff_status="+eff_status+"&module_id="+module_id+"&Function_id="+Function_id+"&desktop_summary_type="+desktop_summary_type+"&summ_show_by="+summ_show_by;

	if(obj.value=="N")
	{
		document.getElementById("menuhalf").disabled=true;
		document.getElementById("menufull").disabled=true;
	}
	else
	{
		document.getElementById("menuhalf").disabled=false;
		document.getElementById("menufull").disabled=false;
	}

	//second part
	var module_id = document.getElementById("module_id").value
	var appl_scope =obj.value; 

	//removeitems(document.forms[0].Function_id);
	removeMenuitems(parent.frameAddModifyCreateUserDesktopResult.document.getElementById("Menuopts"));
	removeMenuitems(parent.frameAddModifyCreateUserDesktopResult.document.getElementById("funcopt"));
	removeMenuitems(parent.frameAddModifyCreateUserDesktopResult.document.getElementById("MainMenus"));
	removeitems(parent.frameAddModifyCreateUserDesktopResult.document.getElementById("Menu"));
	 
   HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown='lockKey()' class='message'><form name='form1' id='form1' method='post' action='../../ePH/jsp/GetUserDesktopValue.jsp'><input type='hidden' name='module_id' id='module_id' value='"+module_id+"'><input type='hidden' name='appl_scope' id='appl_scope' value='"+appl_scope+"'><input type='hidden' name='mode' id='mode' value='summary'></form></BODY></HTML>";
   parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
   parent.parent.messageFrame.document.form1.submit();*/


	
}

function setMenurad(obj)
{
	document.getElementById("summ_show_by").value=obj.value;
}



function frameLoad()
{
	if(document.getElementById("desktop_summary_type").value=="C")
    {
		 var Desktop_code= document.getElementById("Desktop_code").value;
	     var Desktop_name=document.getElementById("Desktop_name").value;
		 var eff_status= document.forms[0].eff_status.value;
		 parent.frames[1].location.href = "../../ePH/jsp/ConstructUserDesktop.jsp?Desktop_code="+ Desktop_code +"&Desktop_name="+Desktop_name+"&eff_status="+eff_status+"&operation=modify";
	}
	else if(document.getElementById("desktop_summary_type").value=="N" && (document.getElementById("module_id").value=="PH" || document.getElementById("module_id").value=="ST"))
    {	 		 
		 var Desktop_code= document.getElementById("Desktop_code").value;
	     var Desktop_name=document.getElementById("Desktop_name").value;
		 var eff_status= document.forms[0].eff_status.value;
		 parent.frames[1].location.href = "../../ePH/jsp/ConstructUserDesktopforPharmacist.jsp?Desktop_code="+ Desktop_code +"&Desktop_name="+Desktop_name+"&eff_status="+eff_status+"&module_id="+document.getElementById("module_id").value+"&operation=modify";
	}
	else
	{
		parent.frames[1].location.href = "../../eCommon/html/blank.html";
	}
}

