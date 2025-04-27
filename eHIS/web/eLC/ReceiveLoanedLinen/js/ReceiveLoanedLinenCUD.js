
// ****************** FOR SUBMIT RECEIVELOANEDLINEN PAGE(2nd option of Ref.Num) ***********************
	
	function submitFormNullCheck(){
	
		var flag="";
		flag = checkNull();
		if(flag == true){
			 var f1=checkReceivedQty();
			 if(f1==true){
						 document.ReceiveLoanedLinenForm.submit();
			 }
			}
		}

// ****************** FOR CHECK NULL VALUES OF MANDATORY FIELDS BASED ON RECEIVEWRITEOFF OPTION *******

	function checkNull(){
			
			var flag;
			var error="";
			var key_value=new Array();
			if(document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedWriteOff"].value == 'R')
			{
				var fieldName = new Array(
					"com.iba.ehis.lc.receive/writeOff", 
					"com.iba.ehis.lc.receiveloanedlinen.receivedQty", 
					"com.iba.ehis.lc.receiveloanedlinen.receivedBackBy",
					"com.iba.ehis.lc.receiveloanedlinen.givenBackBy");
				var fields = new Array(
					document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedWriteOff"], 
					document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedQty"], 
					document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedBackBy"],
					document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.givenBackBy"]);
			}
			else if(document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedWriteOff"].value == 'W')
			{
			
				var fieldName =new Array(
					"com.iba.ehis.lc.receive/writeOff",
					"com.iba.ehis.lc.receiveloanedlinen.receivedBackBy",
					"com.iba.ehis.lc.receiveloanedlinen.givenBackBy");
				var fields =new Array(
					document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedWriteOff"],
					document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedBackBy"],
					document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.givenBackBy"]);
			}
			
			
			for(j=0;j<fieldName.length;j++)
			{	
				///alert(fieldName[j]);
				//alert(fields[j].value);
				if(fields[j].value=="")
				{	
					//alert("Entered loop for " +j);
					getServerMessage(fieldName[j]);
					key_value[j]=dwrMessage;
					getServerMessage("message.cannot.blank");
					msg=dwrMessage;
					msgArray=msg.split('#');
					error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] + "<br>";
					flag=false;
				
				}
					
			}
		//	 alert(error);
		parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		if(flag==false) return false; else return true;
	
	}
	
// ****************** CHECK NUMERIC VALUES ************************************************************
	
	function checkQty(){
		obj =  String.fromCharCode(window.event.keyCode);
   		var alphaFilter =/^[0-9]+$/;
   		if (!(alphaFilter.test(obj))) { 
	   	getServerMessage("message.Numbers.Allowed");
		window.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
		arg.value="";
	   }
	}

// ****************** SUBMIT FORM TO ACTION CLASS *****************************************************

	function insert(){
		var loadMethod='2';
		loanRefNum=document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanRefNum"].value;
		receivedBackBy=document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedBackBy"].value;
		location.href=contextPath+"/ReceiveLoanedLinenAction.do?method="+loadMethod+"&vo.receiveLoanedLinenVO.loanRefNum"+loanRefNum
	}

// ****************** TO DISABLED AND ENABLED RECEIVE QTY BASED ON RECEIVEWRITEOFF ********************

	function receivedQtyStatus(){
		
		var Qty = document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedWriteOff"].value;
		
		if(Qty ==  'W'){
			document.getElementById("hide").style.visibility="hidden";
			/*document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedQty"].value="";
			document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedQty"].disabled=true; */
		}else{ 
			document.getElementById("hide").style.visibility="visible";
			//document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedQty"].disabled=false;	
		}
	}

// ****************** TO CHECK RECEIVE QTY BASED ON LOANED QUANTITY ********************

	function checkReceivedQty()
	{
		var flag=true;
		var error="";
		var rqty=document.getElementById("vo.receiveLoanedLinenVO.receivedQty").value;
		var lqty=document.getElementById("vo.receiveLoanedLinenVO.loanQty").value;
		if(parseInt(rqty)>parseInt(lqty))
			{
				getServerMessage("com.iba.ehis.lc.receiveloanedlinen.receivedQty");
				var receivedQty = dwrMessage;
				getServerMessage("com.iba.ehis.lc.receiveloanedlinen.loanedQty");
				var loanedQty =dwrMessage;
				getServerMessage("messege.number.greatethan");
				msg=dwrMessage;
				msgArray=msg.split('#');
				error=error +msgArray[0]+ receivedQty + " " + msgArray[1] + " "+loanedQty+ " " + lqty + "<br>";
				flag=false;
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;

			} 
			return flag;
	}
	
// ****************** TO ASSIGN THE VALUES TO CUD PAGE ************************************************
	
	function assignVal(){
		
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanRefNum"].value = dialogArguments[5];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanDate"].value = dialogArguments[6];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.sourceType"].value = dialogArguments[3];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.sourceCode"].value = dialogArguments[4];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanedToSourceType"].value = dialogArguments[1];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.loanedToSourceCode"].value = dialogArguments[2];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.givenBy"].value = dialogArguments[7];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.receivedBy"].value = dialogArguments[8];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.reasonforLoan"].value = dialogArguments[12];
		document.ReceiveLoanedLinenForm["vo.receiveLoanedLinenVO.remarks"].value = dialogArguments[15];
	} 
	
// *****************************************************************************************************