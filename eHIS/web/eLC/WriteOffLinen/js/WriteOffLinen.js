	
	/************************************************************************************************************
	/*                                           WriteOffLinen.js                                               */
	/************************************************************************************************************/
	  	var contentList =new Hashtable();
	  function create() {
		  var function_id = document.getElementById("function_id").value;
		  content.location.href=contextPath+"/eLC/WriteOffLinen/jsp/WriteOffLinenFrames.jsp?function_id="+function_id;
		  
		
		}
	
	  function reset(){
	 	    content.location.href=contextPath+"/eLC/WriteOffLinen/jsp/WriteOffLinenFrames.jsp";
	   }
	 
		 
	 /****************************************************************
	                  Disabling the source and lookup
	  **************************************************************** */ 
		
	  function disableSource(){
	
	    var method=document.getElementById("vo.sourceType").value;
	 	
	 	if(method=="L"){
	 	document.getElementById("vo.source").value="";
	 	document.getElementById("vo.sourceCode").value="";
	 	document.getElementById("vo.source").disabled=true;
	 	document.getElementById("lookup").disabled=true;
		document.getElementById("srcImg").style.visibility="hidden";
	 	}else{
	 	document.getElementById("vo.source").value="";
	 	document.getElementById("vo.sourceCode").value="";
	 	document.getElementById("vo.source").disabled=false;
	 	document.getElementById("lookup").disabled=false;
		document.getElementById("srcImg").style.visibility="visible";
	 	}
	  }
	 
	 /****************************************************************
	                          Lookup
	  **************************************************************** */
	function writeOffCommonLookup(mode)
	{
			if(mode=="source"){
								if(document.getElementById("vo.source").value!="")
									{showLookup(mode);}
							
			}
			else if(mode=="linenItem"){
								if(document.getElementById("vo.linenItem").value!="")
									{showLookup(mode);}
							
			}
			else if(mode=="reason"){
								if(document.getElementById("vo.reason").value!="")
									{showLookup(mode);}
							
			}

	}
	
	 function showLookup(mode) {
	 	
	 	var retArr;
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		var method=document.getElementById("vo.sourceType").value;
		var linenItem=document.getElementById("vo.linenItem");
		var source=document.getElementById("vo.source");
		var reason=document.getElementById("vo.reason");
		var sourceCode=document.getElementById("vo.sourceCode");
		var linenItemCode=document.getElementById("vo.linenItemCode");
		var reasonCode=document.getElementById("vo.reasonCode");
		var languageId = document.getElementById("languageId").value;
		var facilityId=document.getElementById("facilityId").value;
		
		namesArray[1] = "languageId";
		valuesArray[1] = document.getElementById("languageId").value;
		
		if(mode=="source"){
			if(method=="L"){
				argArray[0] = "ehis.lc.writeOffLinen.sourceType";
			}else if(method=="W"){
				argArray[0] = "ehis.lc.standardStock.nursingUnit";
				namesArray[0] = "facilityId";
				valuesArray[0] = document.getElementById("facilityId").value;
			}else if(method=="C"){
				argArray[0] = "ehis.lc.standardStock.clinic";
				namesArray[0] = "facilityId";
				valuesArray[0] = document.getElementById("facilityId").value;
			}else if(method=="D"){
				argArray[0] = "ehis.lc.standardStock.deptCode";
			}
		}
		else if(mode=="linenItem"){
					argArray[0] = "ehis.lc.standardStock.linenItem";

		}else if(mode=="reason"){
			argArray[0] = "ehis.lc.writeofflookup";
		}
		//Display Order
	
		argArray[3] = DESC_CODE;
	
		// Link Description
		argArray[4] = DESC_LINK;
		if(mode=="source")
		{
			
			argArray[1] = namesArray;
			argArray[2] = valuesArray;

			if(method=="L"){
				argArray[5] = document.getElementById("vo.source").value;
			}else if(method=="W"){
				argArray[5] = document.getElementById("vo.source").value;
			}else if(method=="C"){
				argArray[5] = document.getElementById("vo.source").value;
			}else if(method=="D"){
				argArray[5] = document.getElementById("vo.source").value;
			}			
		}
		else if(mode=="linenItem"){

		var sourceCode=document.getElementById("vo.sourceCode");
		
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
		
			argArray[5] = document.getElementById("vo.linenItem").value;
		}
		else if(mode=="reason"){
	//		alert(namesArray)
	//		alert(valuesArray)
//			alert(namesArray)
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[5] = document.getElementById("vo.reason").value;
		}
		if(mode=="source"){
			if(method=="L"){
				getServerMessage("com.iba.ehis.lc.laundry");
				retArr = Lookup(dwrMessage, argArray);
			}else if(method=="W"){
				getServerMessage("com.iba.ehis.lc.ward");
				retArr = Lookup(dwrMessage, argArray);
			}else if(method=="C"){
				getServerMessage("com.iba.ehis.lc.clinic");
				retArr = Lookup(dwrMessage, argArray);
			}else if(method=="D"){
				getServerMessage("com.iba.ehis.lc.department");
				retArr = Lookup(dwrMessage, argArray);
				getServerMessage("com.iba.ehis.lc.writeOffLinen.reason");
			var lable = dwrMessage;
			}
		}else if(mode=="linenItem"){
			getServerMessage("com.iba.ehis.lc.linenItem");
			retArr = Lookup(dwrMessage, argArray);
		}else if(mode=="reason"){
			getServerMessage("com.iba.ehis.lc.writeOffLinen.reason");
			var lable = dwrMessage;
			retArr = Lookup(lable, argArray);
		}
		if(retArr!=null){
			//Set the data in to the fields
			if(mode=="source"){
				if(method="L"||"W"||"C"||"D"){
					source.value = retArr[1];
					sourceCode.value = retArr[0];
				}
			}
			else if(mode=="linenItem"){
				linenItem.value = retArr[1];
				linenItemCode.value = retArr[0];
			}else if(mode=="reason"){
				reason.value = retArr[0];
				reasonCode.value = retArr[1];
			}
		}
		else
		 {
			if(mode=="source"){
				if(method="L"||"W"||"C"||"D"){
					source.value = "";
					sourceCode.value = "";
				}
			}
			else if(mode=="linenItem"){
				linenItem.value ="";
				linenItemCode.value = "";
			}else if(mode=="reason"){
				reason.value = "";
				reasonCode.value ="";
			}
		}
	}
	
	 /****************************************************************
	                     Mandatory fields
	  **************************************************************** */
	

	    function checkNullLocal1(){ 
	 	var flag;
	 	var error="";
	 	var f1;
	    var fieldName=new Array("com.iba.ehis.lc.standardStock.source","com.iba.ehis.lc.standardStock.source","com.iba.ehis.lc.writeOffLinen.refNum","com.iba.ehis.lc.date","com.iba.ehis.lc.linenItem","com.iba.ehis.lc.linenType","com.iba.ehis.lc.writeOffLinen.writeOffQty","com.iba.ehis.lc.writeOffLinen.reason");
		var fields = new Array(document.WriteOffLinenForm["vo.sourceType"],document.WriteOffLinenForm["vo.sourceCode"],document.WriteOffLinenForm["vo.refNum"],document.WriteOffLinenForm["vo.date"],document.WriteOffLinenForm["vo.linenItem"],document.WriteOffLinenForm["vo.linenTypeCode"],document.WriteOffLinenForm["vo.writeOffQty"],document.WriteOffLinenForm["vo.reason"]);
	    var method=document.getElementById("vo.sourceType").value;
	    if (method=="L"){
	    fieldName.splice(1,1); 
	    fields.splice(1,1); 
	    }
		var key_value=new Array();
	 	for (j = 0; j <fields.length; j++) 
	 	   {
	       if (fields[j].value=="") {
				getServerMessage(fieldName[j]);
				key_value[j] = dwrMessage;
				getServerMessage("APP-LC0004");
				var message_key = dwrMessage;
				var split_message = message_key.split("#");
				error = error + split_message[0]+" "+key_value[j] + " " + split_message[1] + "<br>";
				f1=false;
				}
		    }
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			if(f1==false) return false; else return true;
	  }
	
	 /****************************************************************
	                  Current Date and Time
	  **************************************************************** */
	       
	        function CurrDate(){	
			
			var currDate = new Date();
			var date = currDate.getDate();
			var mon = currDate.getMonth();
			var hrNow = currDate.getHours();
			var mnNow = currDate.getMinutes();
			scNow = currDate.getSeconds();
			
			mon = mon+1;
			var year = currDate.getYear();
			if(date <10)
				date = "0"+date;
			if(mon <10)
				mon = "0"+mon;
			var convert1= date + "/" + mon + "/" + year;
			if(hrNow<10)
					hrNow="0"+hrNow;
			if(mnNow<10)
					mnNow="0"+mnNow;
			
			convert1=convert1+" "+hrNow+ ":" +mnNow;
			document.getElementById("vo.date").value=convert1;
			}
	 
	  /***************************************************************
	                Write-Off Qty limitation
	   **************************************************************** */
	  
	      function limit(){
	       var flag="";
	      var value2=parseInt(document.getElementById("vo.existingQty").value);
		  if(value2=="")value2=0;
	      var value1=parseInt(document.getElementById("vo.writeOffQty").value);
	      var error=" ";
	      if(value1 > value2){
	      var fieldName="com.iba.ehis.lc.writeOffLinen.existingQty";
	      var fieldName1="com.iba.ehis.lc.writeOffLinen.writeOffQty";
          var key_value;
          getServerMessage(fieldName);	      
          key_value=dwrMessage;
          var key_value1;
          getServerMessage(fieldName1);	      
          key_value1=dwrMessage;
          getServerMessage("APP-LC00012")
          var message_key = dwrMessage;
          getServerMessage("APP-LC0002")
          var message_key1 = dwrMessage;
          var split_message = message_key.split("#");
          var split_message1= message_key1.split("#");
          error=split_message[0]+" "+ key_value1+" "+split_message[1]+" "+key_value+"<br>"+split_message1[0];
          document.getElementById("vo.writeOffQty").value="";
          var obj= document.getElementById("vo.writeOffQty");
          obj.value=0;
		  obj.focus();
          parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		  flag=false;
          }
		  else
			  {
			  flag=true;
				}
		return flag;
	  }
	 /*****************************************************************
	            Disabling the unwanted options in the listbox
	  **************************************************************** */
	  function disable1(){
			getServerMessage("com.iba.ehis.lc.withLaundry");
			var wLaundry = dwrMessage;
			getServerMessage("com.iba.ehis.lc.mending");
			var mending = dwrMessage;
			getServerMessage("com.iba.ehis.lc.inCleaning");
			var inClining = dwrMessage;
			getServerMessage("com.iba.ehis.lc.writeOffLinen.in-use");
			var inUse = dwrMessage;
			getServerMessage("com.iba.ehis.lc.soiled");
			var soiled = dwrMessage;
			getServerMessage("com.iba.ehis.lc.writeOffLinen.loaned");
			var loaned = dwrMessage;
			
	     var method=document.getElementById("vo.sourceType").value;
	    
          if(method == "C" || "W" ||"D") {
			
           if(document.getElementById("vo.linenTypeCode").options.length==1)
           {
           var listOption1	=	document.createElement('OPTION');
           listOption1.text =	inUse;
           listOption1.value=	"U" ;
	       document.getElementById("vo.linenTypeCode").add(listOption1);
   		   document.getElementById("vo.linenTypeCode").value="U"; 
   		 
   		   var listOption1	=	document.createElement('OPTION');
           listOption1.text =	soiled;
           listOption1.value=	"S" ;
	       document.getElementById("vo.linenTypeCode").add(listOption1);
   		   document.getElementById("vo.linenTypeCode").value="S"; 
   		 
   		   var listOption1	=	document.createElement('OPTION');
           listOption1.text =	loaned;
           listOption1.value=	"L" ;
	       document.getElementById("vo.linenTypeCode").add(listOption1);
   		   document.getElementById("vo.linenTypeCode").value="L"; 
   		   document.getElementById("vo.linenTypeCode").options.remove(0); 
           }
			
	       document.getElementById("vo.linenTypeCode").value="U"; 
	       
   		   if((document.getElementById("vo.linenTypeCode").options.length==4 ))
   		   {
   		   document.getElementById("vo.linenTypeCode").options.remove(3); 
   		   }
   		  }
	  
	  }
	   /****************************************************************** 
	                            ExistingQty 
	   ********************************************************************* */  		       
	    function getExQty(){
		  		
			var facilityId= document.getElementById("facilityId").value;
			var linenItem=document.getElementById("vo.linenItemCode").value;
			var sourceType=document.getElementById("vo.sourceType").value;
			var sourceCode=document.getElementById("vo.sourceCode").value;

			//alert(facilityId+" "+linenItem+" "+sourceType)
			//alert("linenItem="+linenItem)
			//alert("sourceType="+sourceType)
			//alert("sourceCode="+sourceCode)

			if(sourceType=="L"){ 
		   	   if(linenItem != null && facilityId != null ){	
					WriteOffLinen.getExistingQty(facilityId,linenItem, callExistingQtyForlaundry);
			   	   }
		   	  }
		   	  else if(sourceType!="L"){	
			   	  document.getElementById("vo.existingQty").value="";
		   	  if(linenItem != null && sourceCode != null && sourceType != null){
				  WriteOffLinen.getExistQty(facilityId,sourceType,sourceCode,linenItem,callExistingQty);
			   	  }
		   	 }
		 }

		 function callExistingQtyForlaundry(data){		
			 var existingQty=0;
              for(prop in data){
            	for(prop1 in data[prop]){
            		var linenType = document.getElementById("vo.linenTypeCode").value
					
					if(linenType == "M"){
						existingQty=data[prop][3]
							document.getElementById("vo.existingQty").value=existingQty;
						}else if(linenType=="W"){
							existingQty=data[prop][1]
								document.getElementById("vo.existingQty").value=existingQty;
							}else if(linenType=="C"){
								existingQty=data[prop][2]
									document.getElementById("vo.existingQty").value=existingQty;
							}
						}
					}
				}

			function callExistingQty(data){
			 var existQty=0;
        	 var linenType = document.getElementById("vo.linenTypeCode").value
              for(prop in data){
            	for(prop1 in data[prop])
					{	
						if(linenType == "U"){
						existingQty=data[prop][1]
							document.getElementById("vo.existingQty").value=existingQty;
						}else if(linenType=="S"){
							existingQty=data[prop][2]
								document.getElementById("vo.existingQty").value=existingQty;
							}else if(linenType=="L"){
								existingQty=data[prop][3]
									document.getElementById("vo.existingQty").value=existingQty;
							}
						//existQty = parseInt(data[prop][1])+parseInt(data[prop][2])+parseInt(data[prop][3])
						//	document.getElementById("vo.existingQty").value=existQty;
					}
				 }
				}

	  /***********************************************
	                Systemgenerated Number
	   ************************************************* */   
		
		function getRefNumber(){
		  	var facilityId= document.getElementById("facilityId").value;
			WriteOffLinen.getRefNum(facilityId, callRefNum);
			}
		
        function callRefNum(data){
		     var max=0;
		     for(prop in data){
		       if(prop!=null){
			        if(parseInt(prop)>parseInt(max))
					     max=parseInt(prop);
		     		}
	           }
    	       max=parseInt(max)+1;
	    	   document.getElementById("vo.refNum").value=max;
	       	}
function submitData(){
															  
	     var flag=checkNullLocal1();
	     if(flag==true){
						var f1=limit();
						 if(f1==true){settime()}
			
  	     }
  	   }

function settime()
{
 window.setTimeout(AlertMsg,1000);	
}
function AlertMsg()
{
	var obj=document.getElementById("vo.refNum");
	getServerMessage("com.iba.ehis.lc.pnyrequestNum");
	alert(dwrMessage+" "+" : "+obj.value);
	var formObj = document.WriteOffLinenForm;
	formObj.submit();
}
	      
	  /******************************************************************
	                             Logged in User
	  ******************************************************************* */     
	       
	     function  getUser(){
		   		var user = document.getElementById("loggedInUser").value;
				var facilityId= document.getElementById("facilityId").value;
		   		WriteOffLinen.getLoggedInUser(user, facilityId, callRefUser);
         }
		
        function callRefUser(data){
		  var user = document.getElementById("loggedInUser").value;
	     for(prop in data){
		    
	       if(data[prop]==user)		  
	        {
			  
	        document.getElementById("vo.sourceType").value="L";
	        document.getElementById("vo.sourceType").options.remove(0);
	        document.getElementById("vo.sourceType").options.remove(1);
			document.getElementById("vo.sourceType").options.remove(1);	 
			//document.getElementById("vo.sourceType").disabled=true;
	        disable1();
		   // document.getElementById("vo.sourceType").disabled=true;
		    document.getElementById("vo.source").disabled=true;
		    document.getElementById("lookup").disabled=true;
		    }
			
		    }
    	   }     	  
	   
	   /*********************************************************
	                 Reason (TextArea) size limitation
	    **********************************************************/
	   
	   function maxlength(ta){
	      
		   if(ta.value.length>100){
		        ta.value = ta.value.substring(0,100);
		        var fieldName="com.iba.ehis.lc.writeOffLinen.remarks";
	            var key_value;
                getServerMessage(fieldName);	      
                key_value=dwrMessage;
                getServerMessage("APP-LC00015");
         	    var message_key = dwrMessage;
          		var split_message = message_key.split("#");
          		error=split_message[0]+" "+ key_value+" "+split_message[1]+" "+100;
         		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		   	   }
	   }
//======================
function showLookupLinen() {

	var languageId=document.WriteOffLinenForm["languageId"].value;
	var argArray = new Array();
	var namesArray = new Array("languageId");
	var valuesArray = new Array(languageId);
	var datatypesArray = new Array();
	argArray[0] = "ehis.lc.standardStock.linenItem"
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = DESC_CODE;
	argArray[4] = DESC_LINK;
	argArray[5] =document.WriteOffLinenForm["vo.linenItem"].value;
	getServerMessage("com.iba.ehis.lc.linenitemcode");
	var title=dwrMessage;
	retArr = Lookup(title, argArray);
	if(retArr!=null){
		var linenItemCode = document.WriteOffLinenForm["vo.linenItemCode"];
		var linenItemDesc = document.WriteOffLinenForm["vo.linenItem"];
		//Set the data in to the fields
		linenItemCode.value = retArr[0];
		linenItemDesc.value = retArr[1];
		//alert(linenItemCode.value)
		if(linenItemCode.value!=""){getExQty();}
	}
	
	}