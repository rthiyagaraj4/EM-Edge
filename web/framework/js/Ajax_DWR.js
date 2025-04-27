/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function doAjaxRequest(remoteMethod,callBackHandler,parameters) 
{
	alert("indwr ")
	alert(parameters.arr1);
	alert(parameters.arr2);
	alert("length is"+parameters.length);
	
	
	for(i=0;i<(doAjaxRequest.arguments.length);i++)
	{
	alert("watch out"+doAjaxRequest.arguments[i]);
	}
	
	
	var obj=doAjaxRequest.arguments[2]
	alert("impt"+obj)
	alert("length"+parameters.length)
	alert("in agjax")
	   
	    var returnValue;
	    if (parameters == undefined)
	    {
	
	        returnValue = remoteMethod + "(" + callBackHandler + ");";
	    }
	     else 
	    {
			/*for(i=0;i<(doAjaxRequest.arguments.length);i++)
			{
			alert("watch out"+doAjaxRequest.arguments[i]);
			}*/
			var parameterOne=","+parameters[0];
			
			var paramArray=new Array();
			 paramArray[0]=callBackHandler
	
	         for(i=0;i<parameters.length;i++)
	         {
	       		 // alert(typeof(parameters[i]))
	               var parameterLoop = "," + parameters[i];
	              parameterOne=parameterOne + parameterLoop;
	              paramArray[i+1]=parameters[i]
	
			 }
	
			funct =eval(remoteMethod)
			alert(funct.toSource())
			Function.prototype.funct1=funct
			 alert(funct1(paramArray));
	
			 
	      // returnValue = eval(remoteMethod + "(" + callBackHandler +eval( parameterOne )+ ");");
	
	           
	    }
	   // var afterEval = eval(returnValue);
	    alert("afterEval")
     
}

/**
 * Added by Sabarinathan S
 * 17/10/2006
 * @todo: Now the current implementation will just alert the requested message. 
 *        We need to enhance this to return the message with the same function request instead of separate callback function.
 */

function getServerMessage(key, message) {
    DWREngine.setAsync(false);
    if (message == null) {
        MessageReader.getMessage(key, {callback:function (dataFromServer) {
            getServerMessage(null, dataFromServer);
        }});
    } else {
        dwrMessage=message;
	  //DWRUtil.setValue("serverMessage",message);
                
    }
    DWREngine.setAsync(true);
}


	
