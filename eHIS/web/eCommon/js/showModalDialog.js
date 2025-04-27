/** top.dialogArray is used to kept the list of opening dialogbody in a array */
if (!top.dialogArray) {
    top.dialogArray = [];
  }
  
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
      window.showModalDialog = window.showModalDialog || function(url, arg, opt) {   
          var isFrameSet = false; 
          url = url || ''; //URL of a dialog
          arg = arg || null; //arguments to a dialog
          /*Calculating the modalframe height from param-opt*/
          try { 
          var paramHeightUnit = opt?.split(";").find(item => item.includes('dialogHeight'))?.split(":")[1];
        var paramHeight = parseInt(paramHeightUnit?.slice(0, -2));
          paramHeight > 59 && paramHeightUnit?.slice(-2) == "vh" ? paramHeight = (paramHeight + 10) >= 97 ? 97 : paramHeight + 10 : "";
          opt = opt.replace(opt?.split(";").find(item => item.split(":")[0] == 'dialogHeight') , "dialogHeight:"+paramHeight + paramHeightUnit?.slice(-2));
          } catch (error) {}
          opt = opt || 'dialogWidth:600px;dialogHeight:700px'; //options: dialogTop;dialogLeft;dialogWidth;dialogHeight or CSS styless
          var caller = arguments.callee.caller == null ? "" : arguments.callee.caller.toString();
          var dialog = parent.document.body.appendChild(parent.document.createElement('dialog'));
          dialog.setAttribute('id', "dialog_tag");
          dialog.setAttribute('name', "dialog_tag");
          dialog.setAttribute('style', opt.replace(/dialog/gi, ''));
          dialog.setAttribute('draggable', 'true');
          dialog.style.padding = '0';
         // dialog.innerHTML = '<a href="#" id="dialog-close" style="position: absolute; top: -8px; right: 0px; font-size: 20px; color: #000; text-decoration: none; outline: none;">&times;</a><iframe id="dialog-body" name ="dialog-body" src="' + url + '" style="border: 0; width: 100%; height: 98%;"  scrolling="no"></iframe>';
          dialog.innerHTML = '<iframe id="dialog-body" name ="dialog-body" src="' + url + '" style="border: 0; width: 100%; height: 98%;"  scrolling="no"></iframe>';
          parent.document.getElementById('dialog-body').contentWindow.dialogArguments = arg;
          /* 
           * Applying dialog header and style
           */
          var dialogTitle = ' ';
          var iframe ;
          const regex = /[?&]title=([^&]*)/;
          top.dialogArray.push(dialog);
          iframe = top.dialogArray[top.dialogArray.length - 1].querySelector('#dialog-body') ;
          if(url.match(regex)){   	  
              dialogTitle = url.match(regex)[1];
          }        
          
            iframe.onload = function() { 
                var iframeDoc, resultFrameHeight;
                 iframeDoc = top.dialogArray[top.dialogArray.length - 1]?.querySelector('#dialog-body').contentWindow.document;
              frameSet = top.dialogArray[top.dialogArray.length - 1]?.querySelector('#dialog-body').contentWindow.document.querySelector("frameset");
              !dialogTitle?.trim() ? dialogTitle = iframeDoc.querySelector('title')?.innerText : "";
              dialogTitle?.trim()|| !arg || !(arg && arg[9]) ? "" : dialogTitle = arg[9];
              /*Fetching the resultset frame*/
              resultFrameHeight = Array.from(iframeDoc.querySelectorAll("iframe")).filter(item=>{
                  return item.style.height?.slice(0, -2) > 50;
              });
              var link = iframeDoc.createElement('link');
              link.rel = 'stylesheet';
              link.href = '../../eCommon/html/'+top.document.querySelector('link').href?.split("/")[top.document.querySelector('link').href?.split("/").length -1];
              iframeDoc.head.appendChild(link);  
              if(frameSet&& !frameSet.querySelector("frame#closeIconFrame")){
                  isFrameSet = true;
                  var frameRows = frameSet.getAttribute("rows");
                  //frameSet.setAttribute("rows", "3.7%," + frameRows);
                  frameSet.setAttribute("rows",  (paramHeight < 80 ? "10%,":"3.7%,") + frameRows);
                  var closeFrame = document.createElement("frame");
                  closeFrame.setAttribute("id", "closeIconFrame");
                  closeFrame.setAttribute("frameborder", "0");
                  frameSet.insertBefore(closeFrame, frameSet.firstChild);
                  var closeFrameDoc = closeFrame.contentDocument || closeFrame.contentWindow.document;
                  closeFrameDoc.body.style.margin = "0";
                  closeFrameDoc.body.style.height = "100%"; 
                  var link = document.createElement('link');
                  link.rel = 'stylesheet';
                  link.type = 'text/css';
                  link.href = '../../eCommon/html/'+top.document.querySelector('link').href?.split("/")[top.document.querySelector('link').href?.split("/").length -1];
                  closeFrameDoc.head.appendChild(link);           
                  var frameHeader =  document.createElement("div");
                  frameHeader.classList.add('modalTitleBarBG');
                  frameHeader.style.padding = "0 0.5em .2em .2em";
                  frameHeader.style.fontWeight ='bolder';
                  frameHeader.style.fontFamily= 'verdana';
                  frameHeader.style.color = 'white';
                  frameHeader.style.fontSize = '9pt';
                  frameHeader.style.height = '.9rem';
                  frameHeader.innerHTML = '<span>'+decodeURIComponent(dialogTitle)+'</span><a href="#" id="dialog-close" class="modalCloseIcon" style="font-size: 10pt; color: black; text-decoration: none; outline: none; float: right;">&times;</a>';
                  closeFrameDoc.body.appendChild(frameHeader);
                  closeFrameDoc.querySelectorAll("#dialog-close")[ closeFrameDoc.querySelectorAll("#dialog-close").length-1].addEventListener('click', function(e) {
                      e.preventDefault();
                      dialog.close();
                  });
              }else{
                  var isCalendar = iframeDoc.getElementById("myCalTitle") ? true : false;
                  if(!isCalendar && !frameSet && !iframeDoc.querySelector(".modalTitleBarBG")){
                  /*Reducing the resultset frame height*/
                      if(resultFrameHeight.length){
                          resultFrameHeight[0].style.height = (resultFrameHeight[0].style.height?.slice(0, -2)) - 3 + "vh";
                      } 
                      var dialogHeader = document.createElement("div");
                      dialogHeader.classList.add('modalTitleBarBG');
                      dialogHeader.style.padding = "0 0.5em .2em .2em";
                      dialogHeader.style.marginBottom = ".5em";
                      dialogHeader.style.fontWeight ='bolder';
                      dialogHeader.style.fontFamily= 'verdana';
                      dialogHeader.style.color = 'white';
                      dialogHeader.style.fontSize = '9pt';
                      dialogHeader.style.height = '.9rem';
                      dialogHeader.innerHTML = '<span>'+decodeURIComponent(dialogTitle)+'</span><a href="#" id="dialog-close" class="modalCloseIcon" style="font-size: 10pt; color: black; text-decoration: none; outline: none; float: right;">&times;</a>';
                      iframeDoc.body.insertBefore(dialogHeader,iframeDoc.body.firstChild); 
                      iframeDoc.body.style.position = 'fixed';
                      iframeDoc.body.style.top = '0';
                      iframeDoc.body.style.margin = '0';
                      iframeDoc.body.style.width = '100%';  
                  }     	
                  iframeDoc.querySelectorAll("#dialog-close")[ iframeDoc.querySelectorAll("#dialog-close").length-1].addEventListener('click', function(e) {
                      e.preventDefault();
                      dialog.close();
                  });
          }
          }
          /*parent.document.getElementById('dialog-close').addEventListener('click', function(e) {
              e.preventDefault();
              alert("dialog"+dialog);
              dialog.close();
          });*/
          
          //************Added By Naveen 01/08/2024 ***************//
          // parent.document.querySelectorAll("#dialog-close")[parent.document.querySelectorAll("#dialog-close").length-1]?.addEventListener('click', function(e) {
  
          //     e.preventDefault();
          //     dialog.close();
  
          // });
  
          
          //**************************************//
          dialog.showModal();
          //if using yield or async/await
          if(!isFrameSet){
          if(caller.indexOf('yield') >= 0 || caller.indexOf('await') >= 0) {
              return new Promise(function(resolve, reject) {
                  dialog.addEventListener('close', function() {
                      var returnValue = parent.document.querySelectorAll('#dialog-body')[parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue;                   /******************/
                      /*
                       * Code added by Sethu on 10/07/2024
                       */
                      
                      /* Code Added by Vedesh A D for Edge Conversion */
                      if (returnValue == undefined) {
                          const diagElement = parent.document.getElementsByTagName("dialog");
                          var i = 0; var j = 0; let found = false;
                          // outer loop in reverse
                          for (i = diagElement.length - 1; i >= 0 && !found; i--) {
                              // inner loop in reverse
                              for (j = diagElement[i].children.length - 1; j >= 0; j--) {
                                  var element = diagElement[i].children[j];
                                  let dialogSrc = element.src;
                                  if (typeof dialogSrc !== "undefined") { 
                                     returnValue = element.contentWindow.returnValue;
                                      if (returnValue !== undefined){
                                          found = true; // to stop outer
                                          break; // to stop inner
                                      }
                                  }
                              }
                          }
                      }
                     
                      
                      /***************************/ 
                      var lastDialog = top.dialogArray.pop();
                      parent.document.body.removeChild(lastDialog);
                      resolve(returnValue);
                       /* end */
                  });
              });
          }
          //if using eval
          var isNext = false;
          var nextStmts = caller?.split('\n').filter(function(stmt) {
              if(isNext || stmt.indexOf('showModalDialog(') >= 0)
                  return isNext = true;
              return false;
          });
          dialog.addEventListener('close', function() {
              var returnValue = parent.document.getElementById('dialog-body').contentWindow.returnValue;
              var arguments = parent.document.getElementById('dialog-body').contentWindow.dialogArguments;
              //modalDialogReturn(arguments, returnValue);
              var lastDialog = top.dialogArray.pop();
              parent.document.body.removeChild(lastDialog);
              //parent.document.body.removeChild(dialog);
              //nextStmts[0] = nextStmts[0].replace(/(window\.)?showModalDialog\(.*\)/g, JSON.stringify(returnValue));
              //eval('{\n' + nextStmts.join('\n'));
          });
          //throw 'Execution stopped until showModalDialog is closed';
          
      };
  }
  })();
  
  //** Below Code's Added By Vedesh A D For Edge Conversion , Dont change any codes without discussing with Edge Team**/
  //** Start */
  function toCloseTopShowModal(retValue) {
      // IF we are using multiple showmodal in top we can call this function and we need to pass the returnvalue inside the function
      // Example =  toCloseTopShowModal(retvalue);
      var diagElements = parent.parent.document.getElementsByTagName('dialog');
      if (diagElements.length === 0) {
          diagElements = top.document.getElementsByTagName('dialog');
      }
      
      var found = false;
  
      // Loop through dialog elements in reverse order
      for (var i = diagElements.length - 1; i >= 0 && !found; i--) {
          // Loop through children in reverse order
          for (var j = diagElements[i].children.length - 1; j >= 0; j--) {
              var element = diagElements[i].children[j];
              var dialogSrc = element.src; 
              if (typeof dialogSrc !== "undefined") {
                  element.contentWindow.returnValue = retValue;
                  diagElements[i].close(); // Close the dialog
                  found = true; // Stop the outer loop
                  break; // Stop the inner loop
              }
          }
      }
  };
  
  //* If any value is assigned to Window.returnValue, the below function will get triggered and set the value to dialogbody */
  try {
      let settingReturnValue = false; // Flag to prevent recursion
      Object.defineProperty(window, 'returnValue', {
          set: function(value) {
              // Prevent recursive calls by using a flag
              if (settingReturnValue) return;
              // Set the value on the last dialog in top.dialogArray
              settingReturnValue = true; // Set the flag to true
              if(top.dialogArray && top.dialogArray.length > 0 && top.dialogArray[top.dialogArray.length - 1])
              {
                  var currentDialog = top.dialogArray[top.dialogArray.length - 1].querySelector("#dialog-body").contentWindow;
                  currentDialog.returnValue = value; 
              
              this._returnValue = value; // Optionally store the value in the window object
              settingReturnValue = false; // Reset the flag
              }
          },
          get: function() {
              return this._returnValue; // Return the stored value
          }
      });
  } catch (e) {
  }
  
  //* Overwriting the Close() function to close the window.showModal() */
  
  // Save the original window.close function to avoid infinite loop
  if (!window.__originalClose) {
      window.__originalClose = window.close;
  }
  window.close = function() {
      if (top.dialogArray && top.dialogArray.length > 0 && top.dialogArray[top.dialogArray.length - 1]) {
          // If there are dialogs in top.dialogArray, close the last one
          top.dialogArray[top.dialogArray.length - 1].close();
      } else {
          // Otherwise, call the default window.close behavior using the original close method
          const originalClose = window.__originalClose || window.close;
          originalClose.call(window);
      }
  };
  (function() {
      var originalAlert = window.alert;
      // Extract context path dynamically
      var pathArray = window.location.pathname.split('/');
      // Ensure we only set a context path if it exists (avoid using a file name as context)
      var contextPath = (pathArray.length > 1 && pathArray[1] !== "") ? "/" + pathArray[1] : "";
      var alertSound = new Audio(contextPath + "/eCommon/images/Notify_new.wav");  
      window.alert = function(message) {
          // Play the sound
          alertSound.play();
          // Call the original alert function
          originalAlert(message);
      };
  })();
  //** end */