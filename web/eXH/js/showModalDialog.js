(function() {
	
    window.spawn = window.spawn || function(gen) {
        function continuer(verb, arg) {
            var result;
            try {
                result = generator[verb](arg);
            } catch (err) {
                return Promise.reject(err);
            }
            if (result.done) {
                return result.value;
            } else {
                return Promise.resolve(result.value).then(onFulfilled, onRejected);
            }
        }
        var generator = gen();
        var onFulfilled = continuer.bind(continuer, 'next');
        var onRejected = continuer.bind(continuer, 'throw');
        return onFulfilled();
    };
    window.showModalDialog1 = window.showModalDialog1 || function(url, arg, opt) {
		
        url = url || ''; //URL of a dialog
        arg = arg || null; //arguments to a dialog
        opt = opt || 'dialogWidth:600px;dialogHeight:700px'; //options: dialogTop;dialogLeft;dialogWidth;dialogHeight or CSS styles
        var caller = arguments.callee.caller.toString();
        var dialog = top.parent.document.body.appendChild(top.parent.document.createElement('dialog'));
        dialog.setAttribute('id', "dialog_tag");
        dialog.setAttribute('style', opt.replace(/dialog/gi, ''));
        dialog.innerHTML = '<a href="#" id="dialog-close" style="position: absolute; top: 0px; right: 0px; font-size: 20px; color: #000; text-decoration: none; outline: none;">&times;</a><iframe id="dialog-body" src="' + url + '" style="border: 0; width: 100%; height: 95%; scroll:no"></iframe>';
        top.parent.document.getElementById('dialog-body').contentWindow.dialogArguments = arg;
        /*parent.document.getElementById('dialog-close').addEventListener('click', function(e) {
            e.preventDefault();
			alert("dialog"+dialog);
            dialog.close();
        });*/
		
		//************Added By Naveen 01/08/2024 ***************//

		top.parent.document.querySelectorAll("#dialog-close")[top.parent.document.querySelectorAll("#dialog-close").length-1].addEventListener('click', function(e) {

            e.preventDefault();
            dialog.close();
        });
        dialog.showModal();
        //if using yield or async/await
        if(caller.indexOf('yield') >= 0 || caller.indexOf('await') >= 0) {
            return new Promise(function(resolve, reject) {
                dialog.addEventListener('close', function() {
                    var returnValue = top.parent.document.getElementById('dialog-body').contentWindow.returnValue;
                    
                    /******************/
                    /*
                	 * Code added by Sethu on 10/07/2024
                	 */
                    if(returnValue==undefined)
                    {
	                    const diagElement = top.parent.document.getElementsByTagName("dialog");
	                    var i = 0; var j = 0;
	                    for (i = 0; i < diagElement.length; i++) {
	                    	for (j = 0; j < diagElement[i].children.length; j++) {
	                    		var element = diagElement[i].children[j];
	                    		let dialogSrc = element.src;
	                    		if (typeof dialogSrc !== "undefined")
	                    		{ 
	                	    		if (dialogSrc.includes("CommonLookup.jsp"))
	                	        	{
	                	    			returnValue = element.contentWindow.returnValue;	  
	                	        		
	                	        	}
	                    		}    		
	                    	} 
	                	}
                    }
                    /***************************/                    
                    
                    top.parent.document.body.removeChild(dialog);
                    resolve(returnValue);
                });
            });
        }
        //if using eval
        var isNext = false;
        var nextStmts = caller.split('\n').filter(function(stmt) {
            if(isNext || stmt.indexOf('showModalDialog1(') >= 0)
                return isNext = true;
            return false;
        });
        dialog.addEventListener('close', function() {
        	var returnValue = top.parent.document.getElementById('dialog-body').contentWindow.returnValue;
        	var arguments = top.parent.document.getElementById('dialog-body').contentWindow.dialogArguments;
        	//modalDialogReturn(arguments, returnValue);
        	top.parent.document.body.removeChild(dialog);
            //nextStmts[0] = nextStmts[0].replace(/(window\.)?showModalDialog\(.*\)/g, JSON.stringify(returnValue));
            //eval('{\n' + nextStmts.join('\n'));
        });
        //throw 'Execution stopped until showModalDialog is closed';
        
    };
})();
