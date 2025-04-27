//Version 3.0a (RapidSpell Web assembly version 4.0.0 onwards)
//Copyright Keyoti Inc. 2005-2012
//This code is not to be modified, copied or used without a license in any form.
//-

var rsw_updatingShadow = false;
var rsw_useBattleShipStyle = false;
var rsw_key_down_timeout = 150;
var rsw_inline_script_loaded = true;
var rsw_rs_styleURL = ""; //'/Keyoti_RapidSpell_Web_Common/rs_style.css'
var rsw_rs_menu_styleURL = "";
var rsw_config = new Array();
var rsw_tbs = new Array();
var rsw_scs = new Array();
var rsw_isASPX = true;
var rsw_activeTextbox;
var rsw_previouslyActiveTextbox;
var rsw_ASPNETAJAX_OnHandlersAdded = false;
var rsw_ayt_check = false;
var rsw_ayt_enabled = true;
//var rsw_key_downed_flag = false; //whether keydown occurred since this was last set false
var rsw_key_down_timer = null;
//var rsw_key_downed_within_lim = false;G
var rsw_contextMenu = null;
var rsw_lastRightClickedError;
var rsw_comIF = window.frames["rswinline"];
var rsw_inProcessTB;
var rsw_inProcessSC;
var rsw_spellBoot = "";
var rsw_channel_state = "INACTIVE"; //INACTIVE - not doing anything - ACTIVE - waiting for response
var rsw_channel_timeout;
var RS_ContextMenuTable_Class = "RS_ContextMenuTable";
var RS_CMItemSeparator_Class = "RS_CMItemSeparator";
var RS_ContextMenuItem_Class = "RS_ContextMenuItem";
var RS_ContextMenuItem_AllSubItem_Class = "RS_ContextMenuItem_AllSubItem";
var RS_ContextMenuItem_Disabled_Class = "RS_ContextMenuItem_Disabled";
var rsw_debug = false;
var rsw_inProcessTBResetCaret = true;
var rsw_correctCaret = true;
var rsw_reconcileChanges = true;
var rsw_id_waitingToInitialize = null;
var rsw_overlayCSSClassName = "oldBrowserBox";
var rsw_yScroll = null;
var rsw_isMac = typeof (navigator.userAgent) != 'undefined' && navigator.userAgent.indexOf("Mac") > -1;

var rsw_mozly = navigator.userAgent.indexOf("Gecko") > -1;
var rsw_msie = navigator.userAgent.indexOf("MSIE") > -1;
var rsw_chrome = navigator.userAgent.indexOf("Chrome") > -1;
var rsw_applewebkit = navigator.userAgent.indexOf("AppleWebKit") > -1;
var rsw_compatibleBrowser = rsw_msie || rsw_mozly || rsw_chrome || rsw_applewebkit;

//Set true for right click - currently issues are.
//1 Safari flakes on 'right' click, so just allow any click for Safari
var rsw_MenuOnRightClick = false;

var rsw_newlineexp = new RegExp(rsw_msie?"\r":"\n");
var rsw_ffMaxLengthChecker;
var rsw_haltProcesses = false;
var rsw_cancelCall = false;
var rsw_suppressWarnings = rsw_suppressWarnings ? rsw_suppressWarnings : false;

//Potential initialisation methods
var rsw_aux_oninit_handlers = new Array(); //string array of functions to be called via eval when tbs are initialised
var rsw_ObjsToInit = new Array(); //array of objects that should have .Init() called on them when tbs are initialised
var RSWITextBox_DownLevels = new Array(); //array of downlevel textbox wrappers.
var rsw_showHorizScrollBarsInFF = true;
var rsw_autoFocusAfterAJAX = true;

var rsw_ie9Standards = false;
var rsw_ie9;
try {
    rsw_ie9 = navigator.appVersion.indexOf("MSIE 9.") > -1 || navigator.appVersion.indexOf("MSIE 10.") > -1;
    rsw_ie9Standards = rsw_ie9 && document.compatMode == "CSS1Compat";
} catch (e) { }

function rsw_addTBConfig(config) {
    //check if we already have a config for this TB, if so replace - otherwise add new
    var found = false;
    for (var i = 0; rsw_config != null && i < rsw_config.length; i++) {
        if (rsw_config[i].values[0] == config.values[0]) {//same ID
            found = true;
            rsw_config[i] = config;
        }
    }
    if (!found)
        rsw_config[rsw_config.length] = config;
}

function rsw_debug_getTime() {
    var now = new Date();
    return now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds() + ":" + now.getMilliseconds() + "  ";
}


function rsw_setShadowTB(shadow, value) {
    if (typeof ('rsw_ignorePropertyChange') != 'undefined') rsw_ignorePropertyChange = true;
    
  //  try {
        shadow.removeAttribute('oldValue');
        //  } catch (e) { }
        shadow.value = value;
    if (typeof ('rsw_ignorePropertyChange') != 'undefined') rsw_ignorePropertyChange = false;
}


//Rich stuff----------------------------------------------------------------------



function rsw_getTBSFromID(id, copyStyle) {
    //gets the rsw_tbs object from the ID of the original TB (shadow tb for rich)
    for (var i = 0; i < rsw_tbs.length; i++) {

        if (rsw_tbs[i].shadowTBID == id) {

            return rsw_tbs[i];
        }
    }

    //we dont have a rich rsw_tbs for it, so create an old rsw_tbs
    var tbs = _createTBSForPlainTB(id, copyStyle);
    if (tbs != null) {
        rsw_tbs[rsw_tbs.length] = tbs;
        return rsw_tbs[rsw_tbs.length - 1];

    } else return null;


    //	alert('Couldnt find rsw_tbs for id:'+id);
}

function rsw_createBackUpPlainTBS(id) {

    var divElement = document.createElement('DIV');
    divElement.id = id + "_D";
    divElement.setAttribute('class', rsw_overlayCSSClassName); //TECHNICALLY THIS SHOULD BE _CssClassStaticOverlay passed from control, but this is a fail safe.
    divElement.setAttribute('style', 'display:none;width:1px; height:1px;position:absolute;');
    document.getElementsByTagName('body')[0].appendChild(divElement);
    var myIFrame = document.getElementById(id + "_D");
    myIFrame.style.display = "none"; //force it
    myIFrame.className = rsw_overlayCSSClassName;

    return myIFrame;
}

function _createTBSForPlainTB(id, copyStyle) {
    if (rsw_haltProcesses) return;

    var myIFrame = document.getElementById(id + "_D");
    if (myIFrame == null && document.getElementById(id) != null)//couldnt find a div - so create one now
        myIFrame = rsw_createBackUpPlainTBS(id);

    if (myIFrame == null) //no div, and no textbox
        return null;

    var ptb = new OldIETB(myIFrame);
    var theTB = document.getElementById(id);

    //powerweb hack fix - to be resolved in 3.4
    try {
        if (theTB.name == "pwHtmlBox" && theTB.parentNode.tagName.toLowerCase() == "div") {
            theTB = theTB.parentNode;
            theTB.id = id + "__RSFIX";
        }
    } catch (excep) { } //just incase it goes wrong, we can continue as usual
    //--


    myIFrame.style.position = "absolute";
    //myIFrame.style.left = rsw_findPosX(theTB);
    //myIFrame.style.top = rsw_findPosY(theTB);
    rsw_updatePosition(myIFrame, theTB);

    myIFrame.style.backgroundColor = theTB.style.backgroundColor; /*|| "white";*/
    if (theTB.style.fontFamily)
        myIFrame.style.fontFamily = theTB.style.fontFamily;
    if (theTB.style.fontSize)
        myIFrame.style.fontSize = theTB.style.fontSize;

    ptb.initialize();


    if (copyStyle)
        rsw_copyComputedStyle(myIFrame, theTB);

    rsw_resetTBSSize(myIFrame, theTB.id);

    if (theTB.tagName.toLowerCase() != "textarea")
        ptb.multiline = false;

    return ptb;
}

function rsw_resetTBSSize(myIFrame, theTBid) {

    var tbWidth = rsw_getElementWidth(theTBid);

    if ((document.compatMode && document.compatMode != "BackCompat") || rsw_mozly)//correct width when in strict mode
        tbWidth = rsw_adjustOffsetWidthForStrict(myIFrame, tbWidth);

    if (tbWidth >= 0)
        myIFrame.style.width = tbWidth + "px";

    var tbHeight = rsw_getElementHeight(theTBid);
    if ((document.compatMode && document.compatMode != "BackCompat") ||rsw_mozly)//correct width when in strict mode
        tbHeight = rsw_adjustOffsetHeightForStrict(myIFrame, tbHeight);

    if (tbHeight < 26) {//it's either a single line input, or we dont know what it is, so give a little extra room
        tbHeight = 50;
        myIFrame.style.overflowX = 'scroll';
    }


    if (tbHeight >= 0)
        myIFrame.style.height = tbHeight + "px";
}


function rsw_updatePosition(targetElement, sourceElement) {
    targetElement.style.left = rsw_findPosX(sourceElement) + "px";
    targetElement.style.top = rsw_findPosY(sourceElement) + "px";

}

function rsw_adjustOffsetWidthForStrict(el, width) {

    try {
        var tpLeft = rsw_getStyleProperty(el, "paddingLeft");
        var tpRight = rsw_getStyleProperty(el, "paddingRight");
        var pX = parseInt(tpLeft.substring(0, tpLeft.length - 2)) + parseInt(tpRight.substring(0, tpRight.length - 2));
        var tbLeft = rsw_getStyleProperty(el, "borderLeftWidth");
        var tbRight = rsw_getStyleProperty(el, "borderRightWidth");
        var bX = parseInt(tbLeft.substring(0, tbLeft.length - 2)) + parseInt(tbRight.substring(0, tbRight.length - 2));
        if (isNaN(pX) || isNaN(bX)) return width;
        else
            return width - pX - bX;
    } catch (e) {
        //some browsers are crap
        return width;
    }
}

function rsw_adjustOffsetHeightForStrict(el, height) {
    try {
        var tpTop = rsw_getStyleProperty(el, "paddingTop");
        var tpBottom = rsw_getStyleProperty(el, "paddingBottom");
        var pY = parseInt(tpTop.substring(0, tpTop.length - 2)) + parseInt(tpBottom.substring(0, tpBottom.length - 2));
        var tbTop = rsw_getStyleProperty(el, "borderTopWidth");
        var tbBottom = rsw_getStyleProperty(el, "borderBottomWidth");
        var bY = parseInt(tbTop.substring(0, tbTop.length - 2)) + parseInt(tbBottom.substring(0, tbBottom.length - 2));
        if (isNaN(pY) || isNaN(bY)) return height;
        else
            return height - pY - bY;
    } catch (e) {
        //some browsers are crap
        return height;
    }

}
function rsw_getStyleProperty(obj, IEStyleProp) {

    if (obj.currentStyle) {//IE
        return obj.currentStyle[IEStyleProp];
    } else if (document.defaultView.getComputedStyle) {//W3C
        return document.defaultView.getComputedStyle(obj, null)[IEStyleProp]; //.getPropertyValue(CSSStyleProp);
    } else {
        return null;
    }
}


/*
function rsw_adjustOffsetWidthForStrict(tObj, width){
var t_paddingLeft = rsw_getStyleProperty(tObj, "paddingLeft", "padding-left");
var t_paddingRight = rsw_getStyleProperty(tObj, "paddingRight", "padding-right");
var paddingX = parseInt(t_paddingLeft.substring(0, t_paddingLeft.length-2)) + parseInt(t_paddingRight.substring(0, t_paddingRight.length-2));
var t_borderLeft = rsw_getStyleProperty(tObj, "borderLeftWidth", "border-left-width");
var t_borderRight = rsw_getStyleProperty(tObj, "borderRightWidth", "border-right-width");
var borderX = parseInt(t_borderLeft.substring(0, t_borderLeft.length-2)) + parseInt(t_borderRight.substring(0, t_borderRight.length-2));
return width - paddingX - borderX;
}

function rsw_adjustOffsetHeightForStrict(tObj, height){
var t_paddingTop = rsw_getStyleProperty(tObj, "paddingTop", "padding-top");
var t_paddingBottom = rsw_getStyleProperty(tObj, "paddingBottom", "padding-bottom");
var paddingY = parseInt(t_paddingTop.substring(0, t_paddingTop.length-2)) + parseInt(t_paddingBottom.substring(0, t_paddingBottom.length-2));
var t_borderTop = rsw_getStyleProperty(tObj, "borderTopWidth", "border-top-width");
var t_borderBottom = rsw_getStyleProperty(tObj, "borderBottomWidth", "border-bottom-width");
var borderY = parseInt(t_borderTop.substring(0, t_borderTop.length-2)) + parseInt(t_borderBottom.substring(0, t_borderBottom.length-2));
return height - paddingY - borderY;
}
function rsw_getStyleProperty(obj, IEStyleProp, CSSStyleProp)
{
if (obj.currentStyle) {//IE
return obj.currentStyle[IEStyleProp];
}else if (window.getComputedStyle) {//W3C
return document.defaultView.getComputedStyle(obj, null)[IEStyleProp];//.getPropertyValue(CSSStyleProp);
}else{
return null;
}
}
*/

//copies style from sEl to tEl
function rsw_copyComputedStyle(tEl, sEl) {
    var col;



    if (sEl.currentStyle)
        col = sEl.currentStyle;
    else if (document.defaultView && document.defaultView.getComputedStyle)
        col = document.defaultView.getComputedStyle(sEl, null);
    else
        return;
    //var e = "";
    //var t=false;

    for (sp in col) {
        if(isNaN(parseInt(sp))){//we can get numbers (in a string) with chrome, for sp
        try {
            if (sp.indexOf("webkit")==-1 && sp != "zIndex" && sp != "position" && sp != "left" && sp != "right" && sp != "top" && sp != "display" && sp != "overflow" && sp != "resize"
				&& sp != "bottom" && sp != "width" && sp != "height" && sp.indexOf("scrollbar") == -1 && sp.indexOf("border") == -1
				&& sp.indexOf("css") == -1 && sp.indexOf("class") == -1 && sp.indexOf("get") == -1 && sp.indexOf("set") == -1
				&& sp.indexOf("Moz") == -1 && sp.indexOf("whiteSpace") == -1 && sp.indexOf("word") == -1
				&& sp.indexOf("text") == -1 && sp.indexOf("remove") == -1 && sp.indexOf("item") == -1
				&& sp.indexOf("margin") == -1
				&& sp.indexOf("clip") == -1 && sp.indexOf("visibility") == -1
				&& sp.indexOf("line") == -1 && sp.indexOf("table") == -1//&& sp.indexOf("overflow")==-1
				&& sp.indexOf("max") == -1 && sp.indexOf("min") == -1
				) {
                var v = rsw_getStyleProperty(sEl, sp);
                //we can allow overflowX/Y when the value isnt visible (MOZ has visible for textboxes, even thought they're scroll)
                if (typeof (v) != 'undefined' && v != '' && v != null
					&& (sp.indexOf("overflow") == -1 || v != "visible")
					&& (sp.indexOf("backgroundColor") == -1 || v != "transparent")//transparent is no use to us
					) {
                    //eval("tEl.style." + sp + "=v");
                    tEl.style[sp] = v;
                }
                //t=!t;
            }

        } catch (ex) {//alert(ex.message+" "+ex.name+" "+ex.stack);
        }
        }
    }
    //alert(e);
}

//Rich stuff----------------------------------------------------------------------


//AJAX

var rsw_http_request = false;

//creates an XMLHttpRequest
function rsw_createRequest() {
    if (rsw_haltProcesses) return;

    rsw_http_request = false;

    if (window.XMLHttpRequest) { // Mozilla, Safari,...

        rsw_http_request = new XMLHttpRequest();
        if (rsw_http_request.overrideMimeType) {
            rsw_http_request.overrideMimeType('text/xml');
        }

    } else if (window.ActiveXObject) { // IE

        try {
            rsw_http_request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                rsw_http_request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) { }
        }
    }

    return rsw_http_request;
}

//sends an XMLHttpRequest
function rsw_sendRequest(req, url, paramXML, callBack, synchronous) {
    req.onreadystatechange = callBack;

    //req.open('POST', url, true);
    req.open('POST', url, !synchronous);
    req.setRequestHeader('Content-Type', 'text/xml; charset=UTF-8');

    //ie9 in standards mode - the DOMParser seems to cause problems whereever there are newlines - the newlines are stripped by the time they come out on the server side, so just dont use it
    if (!rsw_ie9Standards && typeof (DOMParser) != 'undefined' && navigator.userAgent.indexOf("Safari") == -1) {//safari's domparser erroneously unescapes entities.
        var domParser = new DOMParser();
        var xmlDocument = domParser.parseFromString(paramXML, 'application/xml');
        req.send(xmlDocument);
    } else {
        req.send(paramXML);
    }

    if (synchronous) {

    }
}


//----AJAX
//var rsw_RapidSpellCheckerClient = null;
//var RapidSpellCheckerClient = new RapidSpellCheckerClient();
function RapidSpellCheckerClient(helperPageURL) {
    //public
    this.Check = Check;
    this.AddWord = AddWord;

    this.userCallback = null;
    this.result = null;
    this.generateResult = generateResult;
    this.createErrorHTML = createErrorHTML;
    this.createErrorMouseUp = createErrorMouseUp;
    this.textChecked = null;

    //Common to SpellChecker object
    this.OnSpellCheckCallBack = OnSpellCheckCallBack;
    this.rapidSpellWebPage = helperPageURL;
    this.getSpellBootString = getSpellBootString;
    this.config;
    this.useXMLHTTP = true;
    this.getParameterValue = getParameterValue;
    this.setParameterValue = setParameterValue;

    function getParameterValue(param) {
        for (var pp = 0; pp < this.config.keys.length; pp++) {
            if (this.config.keys[pp] == param)
                return this.config.values[pp];
        }
    }

    function setParameterValue(param, value) {
        for (var pp = 0; pp < this.config.keys.length; pp++) {
            if (this.config.keys[pp] == param)
                this.config.values[pp] = value;
        }
    }


    function getSpellBootString(xml) {
        //xml==true means <p1>v1</p1>
        //otherwise form field style
        var res = new String();
        if (xml) {
            for (var pp = 0; pp < this.config.keys.length; pp++) {
                var val = rsw_escapeHTML(this.config.values[pp]);
                res += "<" + this.config.keys[pp] + ">" + val + "</" + this.config.keys[pp] + ">";
            }
        } else {

            for (var pp = 0; pp < this.config.keys.length; pp++) {
                res += "<input type=hidden name=" + this.config.keys[pp] + " id=" + this.config.keys[pp] + " value='" + this.config.values[pp] + "'>";
            }
        }
        return res;
    }
    /*
    function GetInstance(){
    if(rsw_RapidSpellCheckerClient==null)
    rsw_RapidSpellCheckerClient = new RapidSpellCheckerClient();
    return rsw_RapidSpellCheckerClient;
    }*/

    //if asynchronousCallback isn't specified, we will block
    function Check(text, asynchronousCallback) {
        //make request, and wait for answer.
        var blocking = true;
        if (typeof (asynchronousCallback) == 'function') {
            blocking = false;
            this.userCallback = asynchronousCallback;
        } else
            this.userCallback = null;

        rsw_inProcessSC = this;
        this.textChecked = text;
        rsw_spellCheckText(text, true, blocking);

        if (blocking) {//try to wait for response
            _rsXMLCallBack();
            return this.result;
        }
    }

    function AddWord(word) {
        rsw_inProcessSC = this;
        rsw_serverAdd(word);
    }

    function OnSpellCheckCallBack(response, numberOfErrors) {
        this.result = this.generateResult(response, numberOfErrors);
        if (this.userCallback != null)
            this.userCallback(this.result);

    }

    function unescapeEntities(text) {
        //this has to tie in with entity escaping in RapidSpellWInlineHelper
        return rsw_unescapeHTML(text);

    }

    function createErrorMouseUp(suggestions) {

        var suggestionList = "";
        if (suggestions.length > 0) {
            suggestionList = "'";
            for (var i = 0; i < suggestions.length; i++) {
                //##NOCRUNCH
                var reg1 = new RegExp("'", "g");
                var reg2 = new RegExp("\"", "g");
                suggestionList += suggestions[i].replace(/\\/g, "\\\\").replace(reg1, "^apos^").replace(reg2, "^qt^");
                //##ENDNOCRUNCH
                if (i < suggestions.length - 1)
                    suggestionList += "','";
            }
            suggestionList += "'";
        }
        //return "rsw_showMenu([" + suggestionList + "], this, event)";
        return suggestionList;

    }

    function createErrorHTML(word, suggestions) {
        var mouseup = createErrorMouseUp(suggestions);

        //##NOCRUNCH
        var html = "<span class='rs_err_hl' onmouseup=\"" + mouseup + "\" oncontextmenu=\"try{event.cancelBubble=true;event.preventDefault();}catch(e){}return false;\">" + word + "</span>";
        //##ENDNOCRUNCH
        return html;
    }


    function generateResult(response, numberOfErrors, forceIgnoreXML) {
        //THIS CODE IS DEPENDENT ON RAPIDSPELLWINLINEHELPER PRODUCING SPANS WITH FORMAT
        //<span class='rs_err_hl' onmouseup="rsw_showMenu(['x','y','z'],this,event)"
        //extract suggestions from onmouseup handler and send to show menu

        /*  if (typeof ('forceIgnoreXML') == 'undefined') {
        if (this.getParameterValue("IgnoreXML").toLowerCase() == "false")
        response = unescapeEntities(response);
        } else if (forceIgnoreXML)
        */
        //because the server will encode &, < and > we need to unescape them
        response = unescapeEntities(response);

        var result = new RapidSpellChecker_Result();
        result.originalText = this.textChecked;
        result.numberOfErrors = numberOfErrors;

        //##NOCRUNCH
        var errorReg = /<span class=[^>]* onmouseup="rsw_showMenu\(([^\]]*\]),this,event\)[^>]*>([^<]*)<\/span>/g;
        //##ENDNOCRUNCH

        var match;
        var lengthToDiscard = 0;
        var wordStart = 0;
        result.errorPositionArray = new Array();
        while ((match = errorReg.exec(response)) != undefined) {
            //var sugs = eval(match[1]);
            var sugs = rsw_getSuggestionsArray(match[1]);
            for (var s = 0; s < sugs.length; s++) {
                sugs[s] = rsw_decodeSuggestionItem(sugs[s]);
            }
            wordStart = match.index - lengthToDiscard;
            result.errorPositionArray[result.errorPositionArray.length] = { start: wordStart,
                end: match[2].length + wordStart,
                word: match[2],
                suggestions: sugs
            };

            lengthToDiscard += errorReg.lastIndex - match.index - match[2].length;
        }

        return result;
    }
}

function RapidSpellChecker_Result() {
    this.originalText;
    this.numberOfErrors;
    this.errorPositionArray;
}


//Common stuff********************************************************************

function rsw_spellCheck() {
    rsw_spellCheckText(rsw_inProcessSC.tbInterface.getText(), rsw_inProcessSC.useXMLHTTP, false);
}

function rsw_spellCheckText(textToCheck, useXmlHttp, synchronous) {
    var rsw_useXMLHttpReq = useXmlHttp;
    var req = false;

    if (rsw_haltProcesses) return;
    else if (rsw_cancelCall) rsw_cancelCall = false;

    if (rsw_useXMLHttpReq)//see if we can get an XML req.
        req = rsw_createRequest();

    if (!req) { //use iframe to communicate
        rsw_comIF = window.frames["rswinline"];
        rsw_spellBoot = "<form accept-charset='UTF-8' action='" + rsw_inProcessSC.rapidSpellWebPage + "' method='post'>";
        rsw_spellBoot += "<input type='hidden' name='textToCheck' id='textToCheck' value=''><input type='hidden' name='IAW' id='IAW' value=''>";
        rsw_spellBoot += rsw_inProcessSC.getSpellBootString(false);
        rsw_spellBoot += "</form>";

        if (rsw_comIF.document.body)
            rsw_comIF.document.body.innerHTML = rsw_spellBoot;
        else {
            rsw_comIF.document.open();
            rsw_comIF.document.write(rsw_spellBoot);
        }
        rsw_comIF.document.forms[0].textToCheck.value = textToCheck;
        rsw_comIF.document.forms[0].IAW.value = rsw_ignoreAllWords.join("|");
        rsw_comIF.document.forms[0].submit();

    } else {//use XMLhttp
        var paramString = new String();
        var text = rsw_escapeHTML(textToCheck);
        paramString = "<r><resp>xml</resp><textToCheck>" + text + "</textToCheck><IAW>" + rsw_ignoreAllWords.join("|") + "</IAW>" + rsw_inProcessSC.getSpellBootString(true) + "</r>";
        //		rsw_sendRequest(req, rsw_inProcessSC.rapidSpellWebPage, paramString, _rsXMLCallBack, synchronous);
        try {
            req.rsw_sc = rsw_inProcessSC;
        } catch (error) { }
        rsw_sendRequest(req, rsw_inProcessSC.rapidSpellWebPage, paramString, _rsXMLCallBack, synchronous);
    }

}

function rsw_getSuggestionsArray(handlerCode) {
    var suggsClean = handlerCode;
    if(suggsClean.indexOf("[")>-1)
        suggsClean = suggsClean.substring(suggsClean.indexOf("[") + 1, suggsClean.indexOf("]"));
    if (suggsClean.length > 1) {
        suggsClean = suggsClean.substring(1, suggsClean.length - 1); //take out open and close '
    }
    var resArray = suggsClean.split("','");
    if (resArray.length == 1 && resArray[0] == '') return [];
    else return resArray;
}

//------------------------=========================              INTERFACES ///////////////////////////////////////////////////////

function RSStandardInterface(tbElementName) {
    this.tbName = tbElementName;
    this.getText = getText;
    this.setText = setText;
    function getText() {
        //if (rsw_ie9Standards) {
        var t = document.getElementById(tbElementName).value;
        if (t.indexOf('\r') == -1) {
            //in standards mode it seems to not include \r
            //##NOCRUNCH
            var rx = new RegExp("\n", "g");
            t = t.replace(rx, "\r\n");
            //##ENDNOCRUNCH
        }
        return t;
        //} else
        //    return document.getElementById(tbElementName).value;
    }
    function setText(text) {
        document.getElementById(tbElementName).value = (text);
        if (rsw_tbs != null) {
            for (var i = 0; i < rsw_tbs.length; i++) {
                if (rsw_tbs[i].shadowTB.id == this.tbName) {
                    if (rsw_tbs[i].updateIframe) { rsw_tbs[i].updateIframe(); rsw_tbs[i].focus(); }
                }
            }
        }
    }
}


function RSAutomaticInterface(tbElementName) {

    this.tbName = tbElementName; this.getText = getText; this.setText = setText;
    this.identifyTarget = identifyTarget;
    this.target = null;
    this.targetContainer = null;
    this.searchedForTarget = false;
    this.targetIsPlain = true;
    this.showNoFindError = showNoFindError;
    this.finder = null;

    this.findContainer = findContainer;

    function findContainer() {
        this.identifyTarget();
        return this.targetContainer;
    }

    function showNoFindError() {
        alert("Sorry, a textbox with ID=" + this.tbName + " couldn't be found - please check the TextComponentID or TextComponentName property.");
    }

    function identifyTarget() {
        if (!this.searchedForTarget) {
            this.searchedForTarget = true;

            if (this.finder == null)
                this.finder = new RSW_EditableElementFinder();

            var plain = this.finder.findPlainTargetElement(this.tbName);
            var richs = this.finder.findRichTargetElements();

            if (plain == null && (richs == null || richs.length == 0) && !rsw_suppressWarnings) showNoFindError();
            else {

                if (richs == null || richs.length == 0) { //must be a plain
                    this.targetIsPlain = true;
                    this.target = plain;
                    this.targetContainer = plain;
                } else {


                    if (plain == null && richs.length == 1) {//no plain, and just one rich, so go with the rich
                        this.targetIsPlain = false;
                        this.target = this.finder.obtainElementWithInnerHTML(richs[0][0]);
                        this.targetContainer = richs[0][1];

                    } else {
                        //we have >1 rich text boxes
                        //look for our _IFs first
                        var findIdentical = false;
                        for (var rp = 0; rp < richs.length && !findIdentical; rp++)
                            findIdentical = typeof (richs[rp][1].id) != 'undefined' && richs[rp][1].id == this.tbName + "_IF";

                        for (var rp = 0; rp < richs.length; rp++) {
                            if (typeof (richs[rp][1].id) != 'undefined' &&
                                (
                                    (!findIdentical && richs[rp][1].id.indexOf(this.tbName) > -1) ||
                                    (findIdentical && richs[rp][1].id == this.tbName)
                                )) {
                                //exclusion, when it's our dynamic textbox, we dont want to use rich, plain is correct
                                if (plain != null && richs[rp][1].id == plain.id + "_IF") {
                                    this.targetIsPlain = true;
                                    this.target = plain;
                                    this.targetContainer = plain;
                                    break;
                                } else {
                                    this.targetIsPlain = false;
                                    this.target = this.finder.obtainElementWithInnerHTML(richs[rp][0]);
                                    this.targetContainer = richs[rp][1];
                                    break;
                                }
                            }
                        }

                        

                        if (this.target == null) {//no rich matches, so lets go with plain
                            this.target = plain;
                            this.targetIsPlain = true;
                            this.targetContainer = plain;
                        }
                    }
                }
            }
        }
    }
    function getText() {
        this.identifyTarget();


        if (this.targetIsPlain)
            return this.target.value;
        else
            return this.target.innerHTML;
    }
    function setText(text) {
        this.identifyTarget();

        if (this.targetIsPlain)
            this.target.value = text;
        else
            this.target.innerHTML = text;

        if (typeof (rsw_tbs) != 'undefined') {
            for (var i = 0; i < rsw_tbs.length; i++) {

                if (rsw_tbs[i].shadowTB.id == this.tbName) {
                    if (rsw_tbs[i].updateIframe) { rsw_tbs[i].updateIframe(); /*rsw_tbs[i].focus(); taken out for auto*/
					}
                }
            }
        }
    }
}
//------------------------=========================              INTERFACES


function SpellChecker(textBoxID) {

    this.state; //"regTB" - text box is an old text box without overlay showing
    //"overlay" - text box has overlay showing
    //"rich"	- text box is rich
    //"running"* - spell checker is currently being called * CURRENTLY UNUSED
    this.getTBS = getTBS;
    this.textBoxID = textBoxID;
    this.rsw_tbs = null;
    this.OnSpellButtonClicked = OnSpellButtonClicked;
    this.OnSpellCheckCallBack = OnSpellCheckCallBack;
    this.finishedListener;
    this.leaveStaticSpellCheckListener;
    this.enterStaticSpellCheckListener;
    this.tbInterface = new RSStandardInterface(textBoxID);
    this.config; //configuration for the spell checker
    this.getSpellBootString = getSpellBootString;
    this.buttonID;
    this.getParameterValue = getParameterValue;
    this.setParameterValue = setParameterValue;
    this.showNoSpellingErrorsMesg = true;
    this.enterEditModeWhenNoErrors = true;
    this.noSuggestionsText = "No suggestions";
    this.ignoreAllText = "Ignore All";
    this.showChangeAllItem = false;
    this.changeAllText = "All";
    this.addText = "Add";
    this.editText = "Edit...";
    this.removeDuplicateText = "Remove duplicate word";
    this.buttonTextSpellChecking = "Checking...";
    this.buttonTextSpellMode = "Resume Editing";
    this.buttonText = "Check Spelling";
    this.noSpellingErrorsText = "No Spelling Errors In Text.";
    this.changeButtonTextWithState = true;
    this.showAddMenuItem = true;
    this.showIgnoreAllMenuItem = true;
    this.showEditMenuItem = true;
    this.responseTimeout = 20; //secs before alerting user about no response
    this.responseTimeoutMessage = "Sorry the server has failed to respond to the spell check request.  Please check the URL set in the RapidSpellWebInlinePage property in the RapidSpellWebInline ctrl.";
    this.hasRunFieldID;
    this.OnTextBoxDoubleClicked = OnTextBoxDoubleClicked;
    this.doubleClickSwitchesMode = true;
    this.onLeaveEdit = onLeaveEdit;
    this.onEnterEdit = onEnterEdit;
    this.useXMLHTTP;
    this.ignoreXML = false;
    this.copyComputedStyleToOverlay = true;
    this.overlayCSSClassName = "oldBrowserBox";
    this.hasRun = false;

    function OnTextBoxDoubleClicked() {
        if (this.doubleClickSwitchesMode)
            this.OnSpellButtonClicked(true);
    }

    function getSpellBootString(xml) {
        //xml==true means <p1>v1</p1>
        //otherwise form field style
        var res = new String();
        if (xml) {
            for (var pp = 0; pp < this.config.keys.length; pp++) {
                var val;
				if(typeof(this.config.values[pp])=='string')
	 				val = rsw_escapeHTML(this.config.values[pp]);
				else 
					val = this.config.values[pp].toString();
                res += "<" + this.config.keys[pp] + ">" + val + "</" + this.config.keys[pp] + ">";
            }
        } else {

            for (var pp = 0; pp < this.config.keys.length; pp++) {
                res += "<input type=hidden name=" + this.config.keys[pp] + " id=" + this.config.keys[pp] + " value='" + this.config.values[pp] + "'>";
            }
        }
        return res;
    }

    function getParameterValue(param) {
        for (var pp = 0; pp < this.config.keys.length; pp++) {
            if (this.config.keys[pp] == param)
                return this.config.values[pp];
        }
    }

    function setParameterValue(param, value) {
        for (var pp = 0; pp < this.config.keys.length; pp++) {
            if (this.config.keys[pp] == param)
                this.config.values[pp] = value;
        }
    }

    //returns a rsw_tbs for the textbox the checker is working with
    function getTBS() {
        if (rsw_haltProcesses) return;

        if (this.rsw_tbs == null) {
            var el = document.getElementById(this.textBoxID);
            if (el == null && !rsw_suppressWarnings) alert("Textbox with ID=" + this.textBoxID + " could not be found, please check the TextComponentID property in the RapidSpell control.");
            else if (el != null) {

                //might need to generate a backup DIV, inwhich case it'll need to know the style for this spell checker
                rsw_overlayCSSClassName = this.overlayCSSClassName;
                this.rsw_tbs = rsw_getTBSFromID(this.textBoxID, this.copyComputedStyleToOverlay);

                if (this.rsw_tbs == null) return null;

                this.rsw_tbs.spellChecker = this;

                if (this.rsw_tbs.isStatic) {
                    this.state = "regTB";
                } else
                    this.state = "rich";
            }
        }

        if (this.rsw_tbs != null && this.rsw_tbs.isStatic) {
            //browser rendering may have changed since TBS div was created
            rsw_updatePosition(this.rsw_tbs.iframe, this.rsw_tbs.shadowTB);

            this.rsw_tbs.targetIsPlain = !this.ignoreXML;
        }
        return this.rsw_tbs;
    }



    function OnSpellButtonClicked(quietFinish, dontResetCaretPosition) {
        if (rsw_haltProcesses) return;
        this.hasRun = true;//we also have a form field to tell server control what happened
        if (this.hasRunFieldID && document.getElementById(this.hasRunFieldID))
            document.getElementById(this.hasRunFieldID).value = 'true';
        //set the TB being worked on during send-callback
        if (typeof (this.tbInterface.findContainer) != 'undefined') {
            this.textBoxID = this.tbInterface.findContainer().id;
            //we're using the automatic interface, so lets also see if we need to set IgnoreXML = true
            if (!this.tbInterface.targetIsPlain) {
                this.setParameterValue("IgnoreXML", "True");
                this.ignoreXML = true;
            }
        }
        rsw_inProcessTB = this.getTBS();

        if (rsw_inProcessTB == null) return;

        if (!rsw_inProcessTB.enabled && (typeof (rsw_ignoreDisabledBoxes) != 'undefined' && rsw_ignoreDisabledBoxes)) return;

        // if (typeof (rsw_inProcessTB.insertErrorHighlights) != 'undefined')
        //         rsw_inProcessTB.setContent(rsw_inProcessTB.getContentText()); //we need it to be plain text


        

        rsw_inProcessTB.spellChecker = this; //do this because its possible to have two spell checkers working on the same TB - this ensures theres no confusion
        rsw_inProcessSC = this;
        //NEED TO REFACTOR THESE PARTS so they can be called externally and separately
        if (this.state == "regTB" || this.state == "rich") {
            if (rsw_channel_state == "INACTIVE") {
                rsw_channel_state = "ACTIVE";
                clearTimeout(rsw_channel_timeout);
                var lc_SD6F5S67DF576SD57F6S76F576S576E5R76WE5675WE76R76W567SD5F76SD56F7576E76W5R76EW5757 = "";
                var timeoutFn = 'if(rsw_channel_state == "ACTIVE" && !rsw_suppressWarnings){alert("' + this.responseTimeoutMessage + '");rsw_channel_state = "INACTIVE";}';
                rsw_channel_timeout = setTimeout(timeoutFn, this.responseTimeout * 1000);

                rsw_inProcessTBResetCaret = !dontResetCaretPosition;


                //-called again in callback code, during AYT check (as user may have continued typing)
                if (typeof (rsw_inProcessTB.recordCaretPos) != 'undefined')//record where the caret was
                    rsw_inProcessTB.recordCaretPos();


                if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + "starting check";
                rsw_spellCheck();
                if (this.state == "regTB") {
                    rsw_resetTBSSize(rsw_inProcessTB.iframe, this.textBoxID); //in FF the text box can be resized while we're not looking
                    this.onLeaveEdit();
                }

            }

        } else {	//overlay

            rsw_inProcessTB.updateShadow();
            rsw_inProcessTB.iframe.style.display = "none";
            this.state = "regTB";
            try {
                if (typeof (rsw_inProcessTB.shadowTB.focus) != 'undefined')
                    rsw_inProcessTB.shadowTB.focus();
            } catch (ee) {
                //can cause issues

            }
            this.onEnterEdit();

            //---
            rsw_broadcastToListeners("spellcheckfinish");
            if (this.finishedListener != null && this.finishedListener != "" && !quietFinish) {
                eval(this.finishedListener + "(true,-1)");
            }
            
            if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("ayt_spellcheckfinish",rsw_inProcessTB, true, -1);
            if (typeof (rswm_auto_NotifyDone) == 'function' && !quietFinish) rswm_auto_NotifyDone(true, -1);
            //++++
        }
        rsw_hideCM();
    }


    function onEnterEdit() {
        if (window.rsw_inline_button_OnStateChanged && this.changeButtonTextWithState) {
            rsw_inline_button_OnStateChanged("EDITING", rsw_inProcessSC.buttonID, this.buttonTextSpellChecking, this.buttonTextSpellMode, this.buttonText);
        }
        if (this.leaveStaticSpellCheckListener != null && this.leaveStaticSpellCheckListener != "")
            eval(this.leaveStaticSpellCheckListener + "()");
    }

    function onLeaveEdit() {
        if (window.rsw_inline_button_OnStateChanged && this.changeButtonTextWithState) {
            rsw_inline_button_OnStateChanged("TRANSITION-CHECKING", rsw_inProcessSC.buttonID, this.buttonTextSpellChecking, this.buttonTextSpellMode, this.buttonText);
        }
        if (this.enterStaticSpellCheckListener != null && this.enterStaticSpellCheckListener != "")
            eval(this.enterStaticSpellCheckListener + "()");
    }

    this.reconcileChange = reconcileChange;
    function reconcileChange(beforeS, afterS) {//returns the reconciled text and whether there was a change made
        if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + "before:" + beforeS + "\r\nafter:" + afterS;
        //find the diff
        var dif = RSW_diff(beforeS, afterS);
        if (dif.position == -1)
            return [beforeS, false];
        else if (dif.vector > 0) {//something added, so add that
            //alert(dif.addedText);
            return [this.insertAtVisible(beforeS, dif.addedText, dif.position), true];
        } else if (dif.vector < 0)//something removed, so lets ignore the spell check for now
        {
            //alert(dif.vector +"  "+afterS+"  ---"+beforeS);
            return [afterS, true];
        }
        else return [beforeS, false];
    }

    this.insertAtVisible = insertAtVisible;
    function insertAtVisible(str, addition, pos) {
        var cs = new RSW_VisibleCharSeq(str);
        return cs.insertAtVisible(addition, pos);
    }

    var rsw_OnSpellCheckCallBack_vars_text;
    var rsw_OnSpellCheckCallBack_vars_innerHTMLLength;
    var rsw_OnSpellCheckCallBack_vars_haveResetFocus;


    var rsw_tempClient = new RapidSpellCheckerClient();
    function OnSpellCheckCallBack_Breather() {

        if (rsw_haltProcesses) return;



        //one last attempt to check if text changed
        if (rsw_OnSpellCheckCallBack_vars_innerHTMLLength != rsw_inProcessTB.getContent().length) {
            if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + " **abort";
            return;
        }



        if (typeof (rsw_inProcessTB.insertErrorHighlights) != 'undefined') {

            rsw_inProcessTB.insertErrorHighlights(rsw_tempClient.generateResult(rsw_OnSpellCheckCallBack_vars_text, rsw_OnSpellCheckCallBack_vars_numErrors, rsw_inProcessSC.ignoreXML), rsw_tempClient);
        } else
            rsw_inProcessTB.setContent(rsw_OnSpellCheckCallBack_vars_text);

        if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + "setting caret";

        //we dont reset caret if we inserted our highlights as caret wont have moved.
        if (typeof (rsw_inProcessTB.insertErrorHighlights) == 'undefined' && typeof (rsw_inProcessTB.resetCaretPos) != 'undefined' && rsw_inProcessTBResetCaret)//resets where the caret was
            rsw_inProcessTB.resetCaretPos();

        rsw_OnSpellCheckCallBack_vars_haveResetFocus = true;

        if (rsw_inProcessTB.isStatic) {
            rsw_inProcessTB.iframe.style.display = "block";
            if (rsw_inProcessSC.state == "regTB") {
                rsw_inProcessSC.state = "overlay";
                if (window.rsw_inline_button_OnStateChanged && rsw_inProcessSC.changeButtonTextWithState) {
                    rsw_inline_button_OnStateChanged("CHECKING", rsw_inProcessSC.buttonID, rsw_inProcessSC.buttonTextSpellChecking, rsw_inProcessSC.buttonTextSpellMode, rsw_inProcessSC.buttonText);
                }
            }
        }

    }

    function OnSpellCheckCallBack(text, numberOfErrors) {
        var workingTB = this.getTBS();
        var workingSC = this;
        if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + "server responded " + numberOfErrors + " errors";

        try {
           


            rsw_channel_state = "INACTIVE";
            clearTimeout(rsw_channel_timeout);

            if (rsw_cancelCall) { rsw_cancelCall = false; return; }

            //				workingTB.isDirty = false;
            workingTB.isDirty = false;
            rsw_OnSpellCheckCallBack_vars_haveResetFocus = false;
       //     if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + "CALLBACK workingTB ID="+workingTB.shadowTBID;
            workingTB.rsw_key_downed_flag = false; //reset flag to false, it will be flipped to true if a keydown occurs
            //				var innerHTMLLength = workingTB.getContent().length;
            var innerHTMLLength = workingTB.getContent().length;

            if (numberOfErrors > 0) {



                //we need to regrab the caret here, incase the user carried on typing and also try to reconcile the change -- note that with non
                //AYT mode we dont want to do this, since focus is off.
                if (!workingTB.isStatic) {
                    if (rsw_haltProcesses) return;

                    if (typeof (workingTB.insertErrorHighlights) == 'undefined') {//for this mode we shouldn't need to reconcile
                        var curText = workingSC.tbInterface.getText(); //workingTB.getContentText();
                        //we have to normalize returns because FF somehow still gives just \n sometimes
//                        if (text.indexOf('\r') > -1 && curText.indexOf('\r') == -1)
                        //                            curText = curText.replace(/\n/g, "\r\n");                        
                        //sometimes FF gives us \r\n on one line and \n on others, so normalize thoroughly
                        if (rsw_mozly) {
                            curText = curText.replace(/\r\n/g, "\n");
                            curText = curText.replace(/\r/g, "\n");
                            //curText = curText.replace(/\n/g, "\r\n");
                            text = text.replace(/\r\n/g, "\n");
                            text = text.replace(/\r/g, "\n");
                        }
                       // text = text.replace(/\n/g, "\r\n"); 
                        var rec = this.reconcileChange(text, curText);
                        if (rsw_reconcileChanges) text = rec[0];
                    }

                    //check nothing has been changed while we reconciled which may not be trivially short - if it has, abort spell check and reconcile
                    if (workingTB.rsw_key_downed_flag || workingTB.rsw_key_downed_within_lim) {
                        if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + " **abort rsw_key_downed_flag.  rsw_key_down_timeout=" + rsw_key_down_timeout+" flag="+workingTB.rsw_key_downed_flag +" lim="+ workingTB.rsw_key_downed_within_lim;
                        return;
                    }

                    if (typeof (workingTB.recordCaretPos) != 'undefined')//record where the caret was
                        workingTB.recordCaretPos();
                    if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + "caret at:" + workingTB.caretBL + "," + workingTB.caretBT;

                }
                //--------------

                rsw_OnSpellCheckCallBack_vars_text = text;
                rsw_OnSpellCheckCallBack_vars_innerHTMLLength = innerHTMLLength;
                rsw_OnSpellCheckCallBack_vars_numErrors = numberOfErrors;

                if (rsw_ayt_check && !rsw_ayt_initializing) setTimeout(OnSpellCheckCallBack_Breather, 10);
                else OnSpellCheckCallBack_Breather(); //its not safe to call func via a timeout since multiple could trigger another check and modify inprocesstb



            } else {

                if (workingSC.showNoSpellingErrorsMesg)
                    alert(workingSC.noSpellingErrorsText);

                if (workingSC.state == "regTB") {
                    workingSC.onEnterEdit();
                }

            }

            if (!workingTB.isStatic && !rsw_ayt_initializing && rsw_inProcessTBResetCaret) {
                //this used to be necessary, but for whatever reason its not helpful now (causes unexpected user focus issues) - see if we can
                //live without
                //			workingTB.focus();
            }

            if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + "reset caret2";
            //useful when the check is triggered by a button, but not when it's as-you-type with no errors
            if (!rsw_OnSpellCheckCallBack_vars_haveResetFocus && typeof (workingTB.resetCaretPos) != 'undefined' && rsw_inProcessTBResetCaret && !rsw_ayt_check)//resets where the caret was
                workingTB.resetCaretPos();


            rsw_broadcastToListeners("spellcheckfinish");
            if (workingSC.finishedListener != null && workingSC.finishedListener != "") {
                eval(workingSC.finishedListener + "(true,numberOfErrors)");
            }
            if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("ayt_spellcheckfinish", workingTB, true, numberOfErrors);
            if (typeof (rswm_auto_NotifyDone) == 'function') rswm_auto_NotifyDone(true, numberOfErrors);

        } catch (e) {
            //ignore
  //      debugger;
            //alert(e);
        }
    }

}

function _rsXMLCallBack() {

    if (rsw_http_request.readyState == 4) {
        if (rsw_http_request.status == 200) {
            var responseText = rsw_http_request.responseText;
            rsw_showXMLResponseError(responseText);
            var rcs = responseText.indexOf("id='resultContent'>") + 19;
            //var rce = responseText.indexOf("</div>", rcs);
            var rns = responseText.indexOf("id='numberOfErrors'>") + 20;
            var rce = responseText.lastIndexOf("</div>", rns);
            var rne = responseText.indexOf("</div>", rns);

            //mozly seems to lose \r at this point.
            //alert(responseText.indexOf('\r',1) +' '+responseText.substring(rcs, rce).indexOf('\r',1));
            var responseContent = responseText.substring(rcs, rce);
            if (responseContent.indexOf('\r') == -1) {
                var pos = -1;
                while ((pos = responseContent.indexOf("\n", pos + 2)) > -1)
                    responseContent = responseContent.substring(0, pos) + "\r\n" + responseContent.substring(pos + 1);
            }


            _rsCallBack(responseContent, responseText.substring(rns, rne), this);

        } else if (rsw_http_request.status == 404 && !rsw_suppressWarnings) {
            alert("The page holding the RapidSpellWInlineHelper control couldn't be found, please check the URL in the RapidSpellWInlineHelperPage property, it should be set to the URL of the page holding the RapidSpellWInlineHelper control.");
        } else if (rsw_http_request.status == 500 && !rsw_suppressWarnings) {
            alert("The page holding the RapidSpellWInlineHelper control returned a 500 server error - which means the page has an error, please visit the URL specified in the RapidSpellWInlineHelperPage to debug this page.  " + (rsw_isASPX ? "(HINT: Most likely, you need to add validateRequest='false' to the Page directive if you are spell checking HTML content.)" : ""));
        } else if (rsw_http_request.status == 405 && !rsw_suppressWarnings) {
            alert("There was a problem with the request, please check the URL set in the RapidSpellWInlineHelperPage property. Http Error Code: " + rsw_http_request.status);
        } else if (!rsw_suppressWarnings) {
            alert("There was a problem with the request. Http Error Code: " + rsw_http_request.status);
        }
    }
}

function _rsCallBack(text, numberOfErrors, request) {
    
    if (request.rsw_sc)//rsw_inProcessSC)
        request.rsw_sc.OnSpellCheckCallBack(text, numberOfErrors);
    else if (rsw_inProcessSC)//rsw_inProcessSC)
        rsw_inProcessSC.OnSpellCheckCallBack(text, numberOfErrors);
}



function rsw_getAbsSel(range, len, contentElements, findRangeEnd) {
    var i;
    var r = new Array();
    r[0] = len;
    r[1] = false;
    r[2] = false;//whether we ran out of elements
    var tarContainer = findRangeEnd ? range.endContainer : range.startContainer;
    var tarOffset = findRangeEnd ? range.endOffset : range.startOffset;
    var numberOfElementsToCount = contentElements.length;

   // if (!rsw_chrome) {
        if (tarContainer.nodeType != 3)//3==text node, if its not 3 it means the offset is number of child nodes, not chars
            numberOfElementsToCount = tarOffset; //we want to count all element lengths upto tarOffset
  //  }


    for (i = 0; i < numberOfElementsToCount && i < contentElements.length && contentElements[i] != tarContainer && !r[1]; i++) {//numberOfElementsToCount could be larger than length during recursion
        if (contentElements[i].nodeValue) {
            len += contentElements[i].nodeValue.length;
        } else if (contentElements[i].tagName == "BR" && i < contentElements.length - 1) {//new 3.5 - also, trailing BR is ignored
            len += 2; //br is equiv to \r\n
        }
        if (contentElements[i].childNodes.length > 0) {
            r = rsw_getAbsSel(range, len, contentElements[i].childNodes, findRangeEnd);
            len = r[0];
            if(r[2])//we ran out of elements, but we were 'recursed' so unset finish flag
             r[1] = false;
        }

    }



    if (contentElements[i] == tarContainer) {
        if (contentElements[i].tagName == "DIV") len+=2;//*C add a newline
        len += tarOffset;
        r[1] = true;
    } else if (tarContainer.nodeType != 3 && i == numberOfElementsToCount - 1) {//tarContainer will not have matched any contentElements
        r[1] = true;
        r[2] = true;
    }

    r[0] = len;
    return r;
}


function rsw_getAbsRance(len, absStart, contentElements) {
    var i;
    var r = new Array();
    r[0] = len;
    r[1] = false;
    for (i = 0; i < contentElements.length && !r[1]; i++) {
        if (contentElements[i].nodeValue) {
            if (contentElements[i].nodeValue.length + len >= absStart) {
                r[2] = contentElements[i];
                r[3] = absStart - len;
                r[1] = true;
                return r;
            } else {
                len += contentElements[i].nodeValue.length;
            }

        } else if (contentElements[i].tagName == "BR" && i < contentElements.length - 1) {//new 3.5 and  trailing BR is ignored
            //br is equiv to \r\n

            if (2 + len == absStart) {
                r[2] = contentElements[i];
                r[3] = 0;
                r[4] = true; //let selector know we want the selection to start after node in r[2]
                r[1] = true;
                return r;
            } else {
                len += 2;
            }

        }
        if (contentElements[i].childNodes.length > 0) {
            r = rsw_getAbsRance(len, absStart, contentElements[i].childNodes);
            len = r[0];
        }
    }
    r[0] = len;
    return r;
}



function rsw_serverAdd(word) {

    var rsw_useXMLHttpReq = rsw_inProcessSC.useXMLHTTP;
    var req = false;

    if (rsw_useXMLHttpReq)//see if we can get an XML req.
        req = rsw_createRequest();

    if (!req) { //use iframe to communicate
        rsw_comIF = window.frames["rswinline"];
        var boot = "";
        boot += "<fo" + "rm accept-charset='UTF-8' action='" + rsw_inProcessSC.rapidSpellWebPage + "' method='post'>" +
			"<input type='hidden' name='action' id='action' value='add'>" +
			"<input type='hidden' name='w' id='w' value=''><input type='hidden' name='UserDictionaryFile' id='UserDictionaryFile' value=\"\"></form>";

        if (rsw_comIF.document.body)
            rsw_comIF.document.body.innerHTML = boot;
        else {
            //do like this, all for Opera
            rsw_comIF.document.open();
            rsw_comIF.document.write(boot);
        }
        rsw_comIF.document.forms[0].w.value = word;
        rsw_comIF.document.forms[0].UserDictionaryFile.value = rsw_inProcessSC.getParameterValue("UserDictionaryFile");
        rsw_comIF.document.forms[0].submit();

    } else {//use XMLhttp
        var paramString = new String();
        paramString = "<r><action>add</action><w>" + rsw_escapeHTML(word) + "</w><UserDictionaryFile>" + rsw_escapeHTML(rsw_inProcessSC.getParameterValue("UserDictionaryFile")) + "</UserDictionaryFile></r>";
        rsw_sendRequest(req, rsw_inProcessSC.rapidSpellWebPage, paramString, rsw_serverAddCallback, false);
    }

}

function rsw_serverAddCallback() {
    //not interested unless an error
    if (rsw_http_request.readyState == 4) {
        if (rsw_http_request.status == 200) {
            rsw_showXMLResponseError(rsw_http_request.responseText);
        } else if (rsw_http_request.status == 404 && !rsw_suppressWarnings) {
            alert("The page holding the RapidSpellWInlineHelper control couldn't be found, please check the URL in the RapidSpellWInlineHelperPage property, it should be set to the URL of the page holding RapidSpellWInlineHelperPage.");
        } else if (rsw_http_request.status == 500 && !rsw_suppressWarnings) {
            alert("The page holding the RapidSpellWInlineHelper control returned a 500 server error - which means the page has an error, please visit the URL specified in the RapidSpellWInlineHelperPage to debug this page.  (HINT: Most likely, you need to add validateRequest='false' to the Page directive if you are spell checking HTML content.)");
        } else if (rsw_http_request.status == 405 && !rsw_suppressWarnings) {
            alert("There was a problem with the request, please check the URL set in the RapidSpellWInlineHelperPage property. Http Error Code: " + rsw_http_request.status);
        } else if (!rsw_suppressWarnings) {
            alert("There was a problem with the request. Http Error Code: " + rsw_http_request.status);
        }
    }
}

function rsw_showXMLResponseError(responseText) {
    var rcs = responseText.indexOf("id='errorContent'>") + 18;
    if (rcs > 17) {
        var rce = responseText.indexOf("</div>", rcs);
        alert(responseText.substring(rcs, rce));
    }
}


function rsw_showMenu(menuItems, element, e) {

    function isRightClick(e) {
        var rightclick;
        // Tests if an event is a right-click - see http://www.xs4all.nl/~ppk/js/events_properties.html
        if (!e) var e = window.event;
        if (e.which) rightclick = (e.which == 3);
        else if (e.button) rightclick = (e.button == 2);
        return rightclick;
    }



    rsw_lastRightClickedError = element;
    /*
    for (var i=0; i<rsw_tbs.length; i++)//force right click focus in mozly
    if(rsw_tbs[i].containsElement(element))

    */
    var atbs = rsw_getTBSHoldingElement(element);

    if (atbs.focus && !atbs.isFocused) {
        var yScroll = null;
        if (typeof (rsw_activeTextbox.iframe.contentWindow) != 'undefined')
            yScroll = rsw_getScrollY(rsw_activeTextbox.iframe.contentWindow);
        atbs.focus();
        if (yScroll != null) rsw_setScrollY(rsw_activeTextbox.iframe.contentWindow, yScroll);
    }
    else rsw_activeTextbox = atbs;


    //if (rsw_yScroll != null) rsw_setScrollY(rsw_activeTextbox.iframe.contentWindow, rsw_yScroll);

    setTimeout("if (rsw_activeTextbox.recordCaretPos) rsw_activeTextbox.recordCaretPos();", 200);

    if (rsw_isMac)//Mac's dont have right click
        rsw_MenuOnRightClick = false;

    if (!rsw_MenuOnRightClick && (e.button == 1 || e.button == 0)) {//(e.button!=2 && rsw_activeTextbox.isStatic) || (e.button==2 && !rsw_activeTextbox.isStatic)){
        rsw_showCM(element, menuItems, e);
    } else if (rsw_MenuOnRightClick && isRightClick(e)) {
        rsw_showCM(element, menuItems, e);
    }

    return false;
}

function rsw_getTBSHoldingElement(element) {
    for (var i = 0; i < rsw_tbs.length; i++)//force right click focus in mozly
        if (rsw_tbs[i].containsElement(element))
            return rsw_tbs[i];
}

function rsw_getScrollX(windowEl) {
    if (windowEl.pageYOffset) // all except Explorer
    {
        return windowEl.pageXOffset;

    }
    else if (windowEl.document.documentElement && windowEl.document.documentElement.scrollTop)
    // Explorer 6 Strict
    {
        return windowEl.document.documentElement.scrollLeft;
    }
    else if (windowEl.document.body) // all other Explorers
    {
        return windowEl.document.body.scrollLeft;
    }
}

function rsw_getClientWidth(windowEl) {
    if (windowEl.innerHeight) // all except Explorer
        return windowEl.innerWidth;
    else if (windowEl.document.documentElement && document.documentElement.clientHeight)	// Explorer 6 Strict Mode
        return windowEl.document.documentElement.clientWidth;
    else if (document.body) // other Explorers
        return windowEl.document.body.clientWidth;
}

function rsw_getClientHeight(windowEl) {
    if (windowEl.innerHeight) // all except Explorer
        return windowEl.innerHeight;
    else if (windowEl.document.documentElement && document.documentElement.clientHeight)
    // Explorer 6 Strict Mode
        return windowEl.document.documentElement.clientHeight;
    else if (document.body) // other Explorers
        return windowEl.document.body.clientHeight;
}


function rsw_getScrollY(windowEl) {
    if (windowEl.pageYOffset) // all except Explorer
        return windowEl.pageYOffset;
    else if (windowEl.document.documentElement && windowEl.document.documentElement.scrollTop)
    // Explorer 6 Strict
        return windowEl.document.documentElement.scrollTop;
    else if (windowEl.document.body) {// all other Explorers
        
        return windowEl.document.body.scrollTop;
    }
}


function rsw_setScrollY(windowEl, scrollY) {
    windowEl.scrollTo(0, scrollY);
    
}

function rsw_showCM(element, menuItems, event) {


    rsw_contextMenu = new RS_ContextMenu(element, menuItems, rsw_activeTextbox);
    rsw_contextMenu.x = rsw_activeTextbox.getAbsX(element, event) + 20;
    rsw_contextMenu.y = rsw_activeTextbox.getAbsY(element, event) + 20;

    if (typeof (rsw_getContextMenuOffsetX) == 'function')
        rsw_contextMenu.x += rsw_getContextMenuOffsetX(rsw_contextMenu.x, element, rsw_activeTextbox, event);
    if (typeof (rsw_getContextMenuOffsetY) == 'function')
        rsw_contextMenu.y += rsw_getContextMenuOffsetY(rsw_contextMenu.y, element, rsw_activeTextbox, event);

    //alert("s"+rsw_contextMenu.y+"  "+parent+" c"+rsw_getScrollY(this));

    //find the edge of the window, and move the CM if necessary
    //var winWidth = rsw_getClientWidth(parent) + rsw_getScrollX(parent);//parent.document.body.clientWidth?(parent.document.body.clientWidth + rsw_getScrollX(parent)):(parent.innerWidth+rsw_getScrollX(parent));
    var winWidth = rsw_getClientWidth(this) + rsw_getScrollX(this);
    if (rsw_contextMenu.x + 220 > winWidth)
        rsw_contextMenu.x = winWidth - 240 - 10; //winwidth-menuwidth-menudisplace-buffer for mozly



    rsw_contextMenu.show();

    //adjust height if necessary (need to show first to find height).
    var menuHeight = rsw_getElementHeight(rsw_contextMenu.CMelement.id);
    //var winHeight = rsw_getClientHeight(parent) + rsw_getScrollY(parent);//parent.document.body.clientHeight?(parent.document.body.clientHeight + rsw_getScrollY(parent)):(parent.innerHeight+rsw_getScrollY(parent));
    var winHeight = rsw_getClientHeight(this) + rsw_getScrollY(this);
    if (rsw_contextMenu.y + menuHeight > winHeight) {
        //alert("adjusting"+menuHeight+" "+winHeight+" "+rsw_getScrollY(parent));
        rsw_contextMenu.y = winHeight - menuHeight - 10;
    }

    //should never be less than zero
    if (rsw_contextMenu.x <= 0)
        rsw_contextMenu.x = 1;

    if (rsw_contextMenu.y <= 0)
        rsw_contextMenu.y = 1;
    //alert("e"+rsw_contextMenu.y);

    rsw_contextMenu.moveCMElement();
}



//------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------


function rsw__resize() {
    //window resize
    for (var i = 0; i < rsw_tbs.length; i++) {
        if (rsw_tbs[i].isStatic) {
            rsw_updatePosition(document.getElementById(rsw_tbs[i].iframe.id), rsw_tbs[i].shadowTB);
        }
    }
}

function rsw_setSettings(tbs) {

   // alert('settings');
    //set settings
    if (typeof (tbs.tbConfig) != 'undefined' && tbs.tbConfig != null && tbs.tbConfig.keys != null) {
        for (var pp = 3; pp < tbs.tbConfig.keys.length; pp++) {
            try {
                if (!rsw_useBattleShipStyle || tbs.tbConfig.keys[pp].indexOf("border") == -1) {//dont set border styles if we're using battleship
                    // eval("tbs." + tbs.tbConfig.keys[pp] + "=" + tbs.tbConfig.values[pp]);
                    var c;
                    var parts = tbs.tbConfig.keys[pp].split(".");
                    if (parts.length == 1) {
                        tbs[parts[0]] = tbs.tbConfig.values[pp];
                    } else if (parts.length == 2) {
                        tbs[parts[0]][parts[1]] = tbs.tbConfig.values[pp];
                    } else if (parts.length == 3) {
                        tbs[parts[0]][parts[1]][parts[2]] = tbs.tbConfig.values[pp];
                    } else if (parts.length == 4) {
                        tbs[parts[0]][parts[1]][parts[2]][parts[3]] = tbs.tbConfig.values[pp];
                    }

                }
            } catch (e) {
                //alert(e.message);
            }
        }

        var tbHeight = rsw_getElementHeight(tbs.iframe.id);
        if (tbHeight < 26 && tbs.multiline) {//it's not a single line input, or we dont know what it is, so give a little extra room
            tbHeight = 36;
            tbs.iframe.style.height = tbHeight + "px";
        }

        tbs.updateIframe();

        //v3.1 - need to point rsw_showMenu in iframe to parent
        tbs.iframe.contentWindow.rsw_showMenu = rsw_showMenu;
    }

}

function rsw__unhook() {

    for (var i = 0; rsw_tbs != null && i < rsw_tbs.length; i++) {
        if (rsw_tbs[i] != null)
            rsw_tbs[i].unhook();
    }
}

function rsw__initTB(ptr) {
    var tbConfig = rsw_config[ptr];
    
    if (rsw_mozly || rsw_chrome || rsw_applewebkit)
        rsw_tbs[ptr] = new MozlyTB(myIFrame, true);    
    else
        rsw_tbs[ptr] = new IETB(myIFrame, true);

    rsw_tbs[ptr].enabled = tbConfig.values[1];
    rsw_tbs[ptr].CssSheetURL = tbConfig.values[2];

    try {
        rsw_tbs[ptr].tbConfig = tbConfig;
        rsw_tbs[ptr].initialize();

    } catch (ex) {
        //alert(ex);
    }
}

function rsw__init(fromAJAXEnd) {
    //window load
    if (rsw_haltProcesses) return;




    for (var ptr = 0; ptr < rsw_config.length; ptr++) {
        if (rsw_haltProcesses) return;

        var tbConfig = rsw_config[ptr];

        var myIFrame = document.getElementById(tbConfig.values[0]);

        if (myIFrame == null) {//this can occur if an iframe 'disappears' without us knowing (eg. ajax made ctrl invisible), so rsw_config will still have element for now missing iframe
            rsw_config.splice(ptr, 1); //delete this element
            //remove rsw_scs associated with it
            for (var sp = 0; sp < rsw_scs.length; sp++) {
                if (rsw_scs[sp].textBoxID + "_IF" == tbConfig.values[0]) rsw_scs.splice(sp, 1);
            }
            ptr--; //redo this index
            continue;
        }

        if (rsw_chrome || rsw_applewebkit)
            rsw_tbs[ptr] = new MozlyTB(myIFrame, true);
        else if (rsw_mozly )
            rsw_tbs[ptr] = new MozlyTB(myIFrame, true);        
        else
            rsw_tbs[ptr] = new IETB(myIFrame, true);

        rsw_tbs[ptr].enabled = tbConfig.values[1];
        rsw_tbs[ptr].CssSheetURL = tbConfig.values[2];

        try {
            rsw_tbs[ptr].tbConfig = tbConfig;
            rsw_tbs[ptr].initialize();

        } catch (ex) {
            //alert(ex);
        }

    }


    rsw_activeTextbox = rsw_tbs[0];
    /*
    //wait for all to be initialized
    var breakout=0;
    while(rsw_id_waitingToInitialize!=null && breakout < 99999999){ breakout++;}
    alert(rsw_id_waitingToInitialize==null);

    if(fromAJAXEnd){
    if(rsw_tbs.length>0){
    var last = rsw_tbs[rsw_tbs.length-1];
    try{
    var caret = last.ifDoc.selection.createRange();
    last.correctCaret(caret);
    }catch (e){}
    }
    }

    //	document.getElementById('rsw_focus_targ').focus();//force focus away from last textbox
    //	document.getElementById('rsw_focus_targ').contentWindow.document.body.setAttribute('contentEditable', 'true');

    if(window.RS_OnTextBoxesInitialized)
    RS_OnTextBoxesInitialized();

    for(var h=0; h<rsw_aux_oninit_handlers.length; h++){
    eval(rsw_aux_oninit_handlers[h]);
    }
    */
    rsw_onFinish(fromAJAXEnd, 0);

}

function rsw_onFinish(fromAJAXEnd, attempts) {
    if (rsw_haltProcesses) return;
    if (!attempts) attempts = 0;
    //wait for it to load - timeout just in case blank didnt include correct load script.
    if (rsw_id_waitingToInitialize != null && attempts < 100) {
        attempts++;
        eval("setTimeout( function() {	rsw_onFinish(" + fromAJAXEnd + ", " + attempts + ");}, 100 ); ");
        return;
    }

    //wait for all to be initialized

    if (fromAJAXEnd && rsw_autoFocusAfterAJAX) {
        if (rsw_tbs.length > 0) {
            var first = rsw_tbs[0];
            first.focus();
        }
    }

    //	document.getElementById('rsw_focus_targ').focus();//force focus away from last textbox
    //	document.getElementById('rsw_focus_targ').contentWindow.document.body.setAttribute('contentEditable', 'true');

    if (window.RS_OnTextBoxesInitialized)
        RS_OnTextBoxesInitialized();

    for (var h = 0; h < rsw_ObjsToInit.length; h++) {
        rsw_ObjsToInit[h].Init();
    }

    for (var h = 0; h < rsw_aux_oninit_handlers.length; h++) {
        eval(rsw_aux_oninit_handlers[h]);
    }

    if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("ayt_textboxesinitialized", null);
}

function rsw_spellCheckTextBox(textBox, optionalButton) {
    var found = false;
    if (textBox != null) {
        if (typeof (textBox.isStatic) == "boolean") {
            for (var i = 0; i < rsw_scs.length; i++) {
                if (rsw_scs[i].textBoxID == textBox.shadowTB.id && textBox.isDirty) {
                    if (typeof (optionalButton) != 'undefined') rsw_scs[i].buttonID = optionalButton.id;
                    rsw_scs[i].OnSpellButtonClicked();
                    found = true;
                } else if (rsw_scs[i].textBoxID == textBox.shadowTB.id) found = true;
            }
        } else {
            for (var i = 0; i < rsw_scs.length; i++) {
                if (rsw_scs[i].textBoxID == textBox.id) {
                    if (typeof (optionalButton) != 'undefined') rsw_scs[i].buttonID = optionalButton.id;
                    rsw_scs[i].OnSpellButtonClicked();
                    found = true;
                }
            }
        }
    }
    if (!found && typeof(rsw_addTextBoxSpellChecker)=='function') {//create a checker for it and check statically (probably an iframe)
        rsw_addTextBoxSpellChecker(textBox, true, 0);
        if (typeof (optionalButton) != 'undefined') rsw_scs[rsw_scs.length - 1].buttonID = optionalButton.id;
        rsw_scs[rsw_scs.length - 1].OnSpellButtonClicked();
    }
}


function rsw_createLink(contentWindowDoc, CssSheetURL) {
    var linkElement = contentWindowDoc.createElement('LINK');
    linkElement.type = 'text/css';
    var url = (typeof (CssSheetURL) == 'undefined' || CssSheetURL == "") ? rsw_rs_styleURL : CssSheetURL;

    linkElement.setAttribute('href', url); //'/Keyoti_RapidSpell_Web_Common/rs_style.css'
    linkElement.setAttribute('rel', 'stylesheet');
    contentWindowDoc.getElementsByTagName('head')[0].appendChild(linkElement);

}

function rsw_updateActiveTextbox(activeElement) {
    var activeID = -1;
    for (var i = 0; i < rsw_tbs.length; i++) {
        if (activeElement == rsw_tbs[i].ifDoc || activeElement == rsw_tbs[i].iframe) {
            rsw_previouslyActiveTextbox = rsw_activeTextbox;
            rsw_activeTextbox = rsw_tbs[i];
            activeID = i;
        }
    }

}


//ignores all instances of error (removes underlines and records in list)
function rsw_ignoreAll(error) {
    var errorText = error.innerHTML.replace(/<[^>]+>/g, "");
    var tError;
    for (var i = 0; i<rsw_tbs.length; i++) {
        rsw_ignoreAllTB(errorText, rsw_tbs[i]);
    }
}

function rsw_ignoreAllTB(errorText, tb) {

    var errors = tb.getSpanElements();

    var changeIndexes = new Array();
    for (var i = 0; i < errors.length; i++) {
        tError = errors[i].innerHTML.replace(/<[^>]+>/g, "");
        if (errors[i].className == 'rs_err_hl' && tError == errorText) {
            /*not ie7 friendly
            //##NOCRUNCH
            var rx = new RegExp("&amp;", "g");
            rsw_changeTo(errors[i], errorText.replace(rx, "&"));
            //##ENDNOCRUNCH
            //i--;
            */
            rsw_dehighlight(errors[i]);
            rsw_addIgnoreAllWord(errorText);
        }
    }

    //called via change to... - rsw_activeTextbox.OnCorrection();
}

function rsw_dehighlight(errorNode) {
    try {
        errorNode.removeNode(false);
    } catch (e) {
        //old way
        errorNode.removeAttribute("class"); //rsw_mozly
        errorNode.removeAttribute("className"); //IE
        errorNode.setAttribute("onmouseup", ""); //IE doesnt work with remove??
    }
}

//unused
function rsw_getTargetElement(e) {
    var relTarg;
    if (!e) var e = window.event;
    if (e.relatedTarget) relTarg = e.relatedTarget;
    else if (e.fromElement) relTarg = e.fromElement;
    return relTarg;
}


function rsw_edit(error) {
    rsw_activeTextbox.createEditBox(error);
    rsw_activeTextbox.OnCorrection(new RSW_CorrectionEvent('correction', error.innerHTML.replace(/<[^>]+>/g, ""), "#edit"));
}

function rsw_inlineTB_onBlur() {
    rsw_activeTextbox.updateShadow();
}

function rsw_inlineTB_onkeypress(e) {
    var ev;
    if (typeof (e) != 'undefined')
        ev = e;
    else
        ev = event;

    if (ev && ev.keyCode) {
        if (ev.keyCode == 13) {
            if (ev.preventDefault) ev.preventDefault();
            return false;
        }
    }
    return true;
}

//adds error to user dictionary
function rsw_add(error) {
    var errorText = rsw_innerHTMLToText(error.innerHTML);
    rsw_ignoreAll(error);
    rsw_inProcessSC = rsw_activeTextbox.spellChecker;
    rsw_serverAdd(errorText);
}

function rsw_innerHTMLToText(html) {
    return html.replace(/<[^>]+>/g, "");
}

//note when pasting from Word into FF wraps seems to come out as \n, when they should be spaces

function rsw_innerText(node, lastElementInCollection, lastElementInCollectionIsBR) {
    var t = "";
    var innerT;

    if (node.nodeName.toLowerCase() == "br")
        t = "\r\n";

    if (node.nodeName.toLowerCase() == "li")
        t = String.fromCharCode(8226);

    if (node.childNodes.length == 0) {
        if (node.nodeValue && node.nodeType == 3) {

            innerT = node.nodeValue;

            //document.getElementById('debug').value += ":"+escape(innerT)+":\n";
            while (rsw_newlineexp.test(innerT))
                innerT = innerT.replace(rsw_newlineexp, "");


            t += innerT; //node.nodeValue;
        }
    } else {
        for (var i = 0; i < node.childNodes.length; i++)
            t += rsw_innerText(node.childNodes[i]);

        if (node.nodeName.toLowerCase() == "li") t += "\r\n";
        //if (node.nodeName.toLowerCase()=="ul")	t += "\r\n";
    }
    if(!node.scopeName || (node.scopeName=="" || node.scopeName=="HTML")){
    if (node.nodeName.toLowerCase() == "input")
        t += node.value;
    //rsw_activeTextbox==null is a hacky way to see if we're in static mode
    if (node.nodeName.toLowerCase() == "p" && !lastElementInCollection && (rsw_activeTextbox==null || node.parentElement == null || node.parentElement.nodeName.toLowerCase() != "div") /*unsure about this && !lastElementInCollectionIsBR*/)
        t += "\r\n";
    if (node.nodeName.toLowerCase() == "div" && !lastElementInCollection/* && !rsw_stringContainsWhitespaceOnly(node.innerText)*/ /*unsure about this && !lastElementInCollectionIsBR*/)
        t += "\r\n";
        }
    return t;
}

function rsw_stringContainsWhitespaceOnly(t) {
    for(var i=0; i<t.length; i++)
     if( !/\s/.test(t.charAt(i))) return false;
    return true;
}

var rsw_ignoreAllWords = new Array();
//adds a word to the list of words that should be ignored during checking
function rsw_addIgnoreAllWord(word) {
    var found = false;
    for (var i = 0; i < rsw_ignoreAllWords.length; i++)
        if (rsw_ignoreAllWords[i] == word)
            found = true;

    if (!found)
        rsw_ignoreAllWords[rsw_ignoreAllWords.length] = word;

}

function rsw_changeTo(error, replacement) {
    var orig = rsw_activeTextbox.getShadowText();
    rsw_activeTextbox.changeTo(error, replacement);
    rsw_activeTextbox.updateShadow();

    rsw_activeTextbox.OnCorrection(new RSW_CorrectionEvent('correction', error.innerHTML.replace(/<[^>]+>/g, ""), replacement, orig));
}

function rsw_changeAllTo(error, replacement) {
    var errorText = error.innerHTML.replace(/<[^>]+>/g, "");
    var tError;
    var errors = rsw_activeTextbox.getSpanElements();
    //var changeIndexes = new Array();
    for (var i = 0; i < errors.length; i++) {
        tError = errors[i].innerHTML.replace(/<[^>]+>/g, "");
        if (errors[i].className == 'rs_err_hl' && tError == errorText) {
            rsw_changeTo(errors[i], replacement);
            i--;
        }
    }
}


function rsw_escapeHTML(t) {
    var pos = -1;
    while ((pos = t.indexOf("&", pos + 1)) > -1)
        t = t.substring(0, pos) + "&amp;" + t.substring(pos + 1);


    var exp1 = new RegExp("<");
    while (exp1.test(t)) t = t.replace(exp1, "&lt;");

    var exp2 = new RegExp(">");
    while (exp2.test(t)) t = t.replace(exp2, "&gt;");
    return t;
}

function rsw_unescapeHTML(t) {
    var pos = -1;
    while ((pos = t.indexOf("&amp;", pos + 1)) > -1)
        t = t.substring(0, pos) + "&" + t.substring(pos + 5);


    var exp1 = new RegExp("&lt;");
    while (exp1.test(t)) t = t.replace(exp1, "<");

    var exp2 = new RegExp("&gt;");
    while (exp2.test(t)) t = t.replace(exp2, ">");
    return t;
}




/*

/////////////////////////////////////////////////////////////////////////
WRAPPER Text Box -------------------------------------------------------------
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


*/



function RSWITextBox(controlClientID) {
    //priv
    this.shadowTBID = controlClientID;
    this._getTBS = _getTBS;
    this._onKeyDown = _onKeyDown;
    this._onKeyUp = _onKeyUp;
    this._onKeyPress = _onKeyPress;
    this._onCorrection = _onCorrection;
    this._onPaste = _onPaste;
    this._onContextMenu = _onContextMenu;
    this._onBlur = _onBlur;
    this._onFocus = _onFocus;
    this._onMouseDown = _onMouseDown;
    this._onMouseUp = _onMouseUp;
    this.tbs = null;
    rsw_ObjsToInit[rsw_ObjsToInit.length] = this;
    this.Init = Init;


    function Init() {
        this._getTBS();
    }

    function _getTBS() {
        if (this.tbs == null) {
            this.tbs = rsw_getTBSFromID(this.shadowTBID, false);
            this.tbs.repObj = this; //now we can get informed about events
        }

        return this.tbs;
    }

    function _onKeyDown(e) { if (typeof (this.OnKeyDown) == 'function') this.OnKeyDown(this, e); }
    function _onKeyUp(e) { if (typeof (this.OnKeyUp) == 'function') this.OnKeyUp(this, e); }
    function _onKeyPress(e) { if (typeof (this.OnKeyPress) == 'function') this.OnKeyPress(this, e); }
    function _onCorrection(e) { if (typeof (this.OnCorrection) == 'function') this.OnCorrection(this, e); }
    function _onPaste(e) { if (typeof (this.OnPaste) == 'function') this.OnPaste(this, e); }
    function _onContextMenu(e) { if (typeof (this.OnContextMenu) == 'function') this.OnContextMenu(this, e); }
    function _onBlur(e) { if (typeof (this.OnBlur) == 'function') this.OnBlur(this, e); }
    function _onFocus(e) { if (typeof (this.OnFocus) == 'function') this.OnFocus(this, e); }
    function _onMouseDown(e) { if (typeof (this.OnMouseDown) == 'function') this.OnMouseDown(this, e); }
    function _onMouseUp(e) { if (typeof (this.OnMouseUp) == 'function') this.OnMouseUp(this, e); }


    //pub
    this.GetText = GetText;
    this.SetText = SetText;
    this.OnKeyDown;
    this.OnKeyUp;
    this.OnKeyPress;
    this.OnCorrection;
    this.OnPaste;
    this.OnContextMenu;
    this.OnBlur;
    this.OnFocus;
    this.OnMouseDown;
    this.OnMouseUp;
    this.GetNumberOfErrors = GetNumberOfErrors;
    this.Focus = Focus;
    this.SetDisabled = SetDisabled;
    this.Select = Select;

    function SetDisabled(disabled) {
        var tbs = this._getTBS();
        return tbs.setDisabled(disabled);
    }

    function Select() {
        var tbs = this._getTBS();
        tbs.select();
    }

    function GetText() {
        var tbs = this._getTBS();
        return tbs.shadowTB.value;
    }

    function SetText(text) {
        var tbs = this._getTBS();

        rsw_setShadowTB(tbs.shadowTB, text);
        
        tbs.updateIframe();

    }

    function GetNumberOfErrors() {
        var tbs = this._getTBS();
        return tbs.getNumberOfErrors();
    }

    function Focus() {
        var tbs = this._getTBS();
        return tbs.focus();
    }

}



function RSWITextBox_DownLevel(controlClientID) {
    //priv
    this.shadowTBID = controlClientID;
    this._getTBS = _getTBS;
    this._onKeyDown = _onKeyDown;
    this._onKeyUp = _onKeyUp;
    this._onKeyPress = _onKeyPress;
    this._onCorrection = _onCorrection;
    this._onPaste = _onPaste;
    this._onContextMenu = _onContextMenu;
    this._onBlur = _onBlur;
    this._onFocus = _onFocus;
    this._onMouseDown = _onMouseDown;
    this._onMouseUp = _onMouseUp;
    this.tbs = null;
    rsw_ObjsToInit[rsw_ObjsToInit.length] = this;

    RSWITextBox_DownLevels[RSWITextBox_DownLevels.length] = this;
    this.Init = Init;
    this.shadowTB; //the plain tb
    this._getShadowTB = _getShadowTB;

    function Init() {
        this._getShadowTB().onkeydown = this._onKeyDown;
        this._getShadowTB().onkeyup = this._onKeyUp;
        this._getShadowTB().onkeypress = this._onKeyPress;
        this._getShadowTB().onpaste = this._onPaste;
        this._getShadowTB().oncontextmenu = this._onContextMenu;
        this._getShadowTB().onblur = this._onBlur;
        this._getShadowTB().onfocus = this._onFocus;
        this._getShadowTB().onmouseup = this._onMouseUp;
        this._getShadowTB().onmousedown = this._onMouseDown;

    }

    function _getShadowTB() {
        if (this.shadowTB == null) this.shadowTB = document.getElementById(this.shadowTBID);
        return this.shadowTB;
    }

    function _getTBS() {
        if (this.tbs == null) {
            this.tbs = rsw_getTBSFromID(this.shadowTBID, false);
            this.tbs.repObj = this; //now we can get informed about events
        }

        return this.tbs;
    }

    function _tb(e) {
        if (e)
            return _findRSWITextBox_DownLevel(e.target.id);
        else
            return _findRSWITextBox_DownLevel(event.target.id);
    }
    function _findRSWITextBox_DownLevel(id) {
        for (var i = 0; i < RSWITextBox_DownLevels.length; i++) {
            if (RSWITextBox_DownLevels[i].shadowTBID == id) return RSWITextBox_DownLevels[i];
        }
        return null;
    }

    function _onKeyDown(e) { var tb = _tb(e); if (typeof (tb.OnKeyDown) == 'function') tb.OnKeyDown(tb, e != null ? e : event); }
    function _onKeyUp(e) { var tb = _tb(e); if (typeof (tb.OnKeyUp) == 'function') tb.OnKeyUp(tb, e != null ? e : event); }
    function _onKeyPress(e) { var tb = _tb(e); if (typeof (tb.OnKeyPress) == 'function') tb.OnKeyPress(tb, e != null ? e : event); }
    function _onCorrection(e) { var tb = _tb(e); if (typeof (tb.OnCorrection) == 'function') tb.OnCorrection(tb, e != null ? e : event); }
    function _onPaste(e) { var tb = _tb(e); if (typeof (tb.OnPaste) == 'function') tb.OnPaste(tb, e != null ? e : event); }
    function _onContextMenu(e) { var tb = _tb(e); if (typeof (tb.OnContextMenu) == 'function') tb.OnContextMenu(tb, e != null ? e : event); }
    function _onBlur(e) { var tb = _tb(e); if (typeof (tb.OnBlur) == 'function') tb.OnBlur(tb, e != null ? e : event); }
    function _onFocus(e) { var tb = _tb(e); if (typeof (tb.OnFocus) == 'function') tb.OnFocus(tb, e != null ? e : event); }
    function _onMouseDown(e) { var tb = _tb(e); if (typeof (tb.OnMouseDown) == 'function') tb.OnMouseDown(tb, e != null ? e : event); }
    function _onMouseUp(e) { var tb = _tb(e); if (typeof (tb.OnMouseUp) == 'function') tb.OnMouseUp(tb, e != null ? e : event); }


    //pub
    this.GetText = GetText;
    this.SetText = SetText;
    this.OnKeyDown;
    this.OnKeyUp;
    this.OnKeyPress;
    this.OnCorrection;
    this.OnPaste;
    this.OnContextMenu;
    this.OnBlur;
    this.OnFocus;
    this.OnMouseDown;
    this.OnMouseUp;
    this.GetNumberOfErrors = GetNumberOfErrors;
    this.Focus = Focus;
    this.SetDisabled = SetDisabled;
    this.Select = Select;

    function Select() {
        this._getShadowTB().select();
    }


    function SetDisabled(disabled) {
        this._getShadowTB().disabled = disabled;
    }


    function GetText() {
        return this._getShadowTB().value;
    }

    function SetText(text) {
        this._getShadowTB().value = text;
    }

    function GetNumberOfErrors() {
        var tbs = this._getTBS();
        return tbs.getNumberOfErrors();
    }

    function Focus() {
        return this._getShadowTB().focus();
    }

}


function rsw_broadcastToListeners(eventType, evt) {//evt may not be available
    if (eventType == "keydown") {
        rsw_activeTextbox.rsw_key_downed_flag = true;
        rsw_activeTextbox.rsw_key_downed_within_lim = true;
        if (rsw_key_down_timer != null) clearTimeout(rsw_key_down_timer);
        rsw_key_down_timer = setTimeout("rsw_activeTextbox.rsw_key_downed_within_lim=false;", rsw_key_down_timeout);
        if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + rsw_activeTextbox.shadowTBID+" DOWN " + String.fromCharCode(rsw_activeTextbox.iframe.contentWindow.event.keyCode);
    }

    if (window._INT_notifyTextBoxListeners)
        _INT_notifyTextBoxListeners(eventType, evt);

    if (window._notifyTextBoxListeners)
        _notifyTextBoxListeners(eventType, evt);
}





/*

/////////////////////////////////////////////////////////////////////////
IE Text Box -------------------------------------------------------------
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


*/
function RSW_IntEvent(eventType) { this.type = eventType; }
function RSW_CorrectionEvent(eventType, errorWord, replacement, oldText) { this.type = eventType; this.errorWord = errorWord, this.replacement = replacement; this.originalText = oldText; }



function IETB(iframeEl, editable) {
    this.iframe = iframeEl;
    this.editable = editable;
    this.ifDoc; 	//content window's document
    this.initialize = initialize;
    this.ifDocElement;
    this.setContent = setContent;
    this.getContent = getContent;
    this._onKeyPress = _onKeyPress;
    this._onKeyUp = _onKeyUp;
    this._onKeyDown = _onKeyDown;
    this._onPaste = _onPaste;
    this._onMouseDown = _onMouseDown;
    this._onMouseUp = _onMouseUp;
    this._onContextMenu = _onContextMenu;
    this._onFocus = _onFocus;
    this._onBlur = _onBlur;
    this.focus = focus;
    this.getSpanElements = getSpanElements;
    this.changeTo = changeTo;
    this.getAbsY = getAbsY;
    this.getAbsX = getAbsX;
    this.isStatic = false;
    this.getContentText = getContentText;
    this.selectedErrorNode = selectedErrorNode;
    this.containsElement = containsElement;
    this.multiline = true;
    this.enabled = true;
    this.maxlength = 0;
    this.shadowTB;
    this.shadowTBID;
    this.updateIframe = updateIframe;
    this.updateShadow = updateShadow;
    this.getShadowText = getShadowText;
    this.spellChecker;
    this.OnCorrection = OnCorrection;
    this.oldOnBlur;
    this.oldOnFocus;
    this.isDirty = false;
    this.recordCaretPos = recordCaretPos;
    this.resetCaretPos = resetCaretPos;
    this.caretBL;
    this.caretBT;
    this.selectedText;
    this.CssSheetURL;
    this.getNumberOfErrors = getNumberOfErrors;
    this.textIsXHTML;
    this.unhook = unhook; //remove event handlers
    this.repObj = null;
    this.setDisabled = setDisabled;
    this.select = select;
    this.isFocused = false;
    this.insertErrorHighlights = insertErrorHighlights;
    this.attachEvents = attachEvents;
    this.isVisible = isVisible;

    function isVisible() {
        //if porting to saf/chrome, might need to worry about scrolly pos
     /*only works if element isn't hidden because of where scroll bar is   
        var el = document.elementFromPoint(rsw_findPosX(this.iframe) + (rsw_getElementWidth(this.iframe.id) / 2), rsw_findPosY(this.iframe) + (rsw_getElementHeight(this.iframe.id) / 2));
        if (el != null && el.id)
            return el.id == this.iframe.id;
        else return false;
          */
        var rect = this.iframe.getBoundingClientRect();
        return rect.left != 0 || rect.top != 0 || rect.bottom != 0 || rect.right != 0;
    }

    //select all text
    function select() {
        this.focus();

        var r = this.ifDoc.selection.createRange();
        r.expand("textedit");
        r.select();
    }

    function getNumberOfErrors() {
        var errors = this.getSpanElements();
        var numErrors = 0;
        for (var i = 0; i < errors.length; i++) {
            if (errors[i].className == 'rs_err_hl') {
                numErrors++;
            }
        }
        return numErrors;
    }

    function insertErrorHighlights(result, client) {

        try {
            
            


            var selection = this.ifDoc.selection;
            var selRange = selection.createRange().duplicate();
            var bookmark = selRange.getBookmark();
            var range; // = this.ifDoc.body.createTextRange().duplicate();

            var numRs;
            var content = this.getContentText();

            //calibrate - range.move will ignore all leading linebreaks (BR) at the start of the text, so find out how many it's ignoring
            var calibration = -1;
            range = this.ifDoc.body.createTextRange().duplicate();
            range.collapse(true);

            //scan through, only considering letters and digits because whitespace is unreliable
            var contentChar;
            var rangeCharCode;
            var contentCharCode;
            var lookingForLeadingSpace = false;


            // range = this.ifDoc.body.createTextRange().duplicate();
            // range.collapse(true);
            //range.moveEnd("character", 1);

            var start = 0;
            var k = 0;
            var numberOfChars = 0;
            for (var i = 0; i < result.errorPositionArray.length; i++) {
                /* range = this.ifDoc.body.createTextRange().duplicate();
                range.collapse(true);
                range.moveEnd("character", 1);
                */
                if (i > 0) start = result.errorPositionArray[i - 1].start;

                lookingForLeadingSpace = result.errorPositionArray[i].word.charAt(0) == " ";

                if (lookingForLeadingSpace) result.errorPositionArray[i].start++;

                for (var j = start; j <= result.errorPositionArray[i].start; j++) {

                    contentCharCode = content.charCodeAt(j);
                    if (
                          (contentCharCode > 0x20 && contentCharCode < 0x7f) || contentCharCode > 0xA1

                        )//not letter or digit
                        numberOfChars++;
                }



                //found next letter or digit
                //problem at moment is that when i==1, range is still at old position (ie 'a'), so we need to budge it
                //use a do while?
                /*rangeCharCode = range.text.charCodeAt(0);
                while (!((rangeCharCode >= 65 && rangeCharCode <= 122) || (rangeCharCode >= 48 && rangeCharCode <= 57))) {
                range.move("character", 1);
                range.moveEnd("character", 1);
                rangeCharCode = range.text.charCodeAt(0);
                }
                */

                //for (var j = start; j < numberOfChars; ) {

                do {

                    range.moveEnd("character", 1);
                    rangeCharCode = range.text.charCodeAt(0);
                    if ((rangeCharCode > 0x20 && rangeCharCode < 0x7f) || rangeCharCode > 0xA1) //((rangeCharCode >= 65 && rangeCharCode <= 122) || (rangeCharCode >= 48 && rangeCharCode <= 57)))
                        k++;


                    range.move("character", 1);

                } while (k < numberOfChars);

                if (lookingForLeadingSpace)
                    range.move("character", -2); //we already went over the character we wanted to stop at.
                else
                    range.move("character", -1); //we already went over the character we wanted to stop at.

                var startRangeParent = range.parentElement();

                if (lookingForLeadingSpace)
                    delta = -1;
                else
                    delta = 0;
                range.moveEnd("character", (result.errorPositionArray[i].end - result.errorPositionArray[i].start) - delta);

                var rangeParent = range.parentElement();
                if (rangeParent.nodeName == "A") {
                    rangeParent.removeNode(false); //autolinking in IE8- can cause problems and isnt relevant to our editor anyway
                    rangeParent = range.parentElement();
                }

                if (rangeParent != null && (rangeParent.getAttribute("class") == null || rangeParent.getAttribute("class") != 'rs_err_hl') && range.text == result.errorPositionArray[i].word) {
                    //isn't already an underline over the range
                    if (startRangeParent.getAttribute("class") == 'rs_err_hl') startRangeParent.removeNode(false); //if there was an underline at the start of the range (ie previously underlined start of word)

                    range.execCommand("Subscript", false);
                    var span = this.ifDoc.createElement("span");
                    span.setAttribute("className", "rs_err_hl"); //quirks mode
                    span.setAttribute("class", "rs_err_hl"); //strict mode

                    var mouseup = client.createErrorMouseUp(result.errorPositionArray[i].suggestions);
                    span.setAttribute("suggestions", mouseup);

                    //SUPERHACK - if we use .onmouseup to register event handler in IE, then we have access to 'this' (the span that was click), but no 'event' object.
                    // whereas if we use attachEvent we do not have 'this' but do have 'event'!
                    // workaround by storing 'this' by first event handler and using in second...
                    //

                    span.onmouseup = function () { rsw_clickedSpan = this; };

                    //                    span.attachEvent("onmouseup", function () { if (rsw_clickedSpan != null) { rsw_showMenu(eval('[' + rsw_clickedSpan.getAttribute("suggestions") + ']'), rsw_clickedSpan, arguments[0]); } rsw_clickedSpan = null; });   //args[0] is event obj


                    span.attachEvent("onmouseup", function () { if (rsw_clickedSpan != null) { var suggsClean = rsw_clickedSpan.getAttribute("suggestions"); rsw_showMenu(rsw_getSuggestionsArray(suggsClean), rsw_clickedSpan, arguments[0]); } rsw_clickedSpan = null; });   //args[0] is event obj
                    span.oncontextmenu = function () { try { event.cancelBubble = true; event.preventDefault(); } catch (e) { } return false; };
                    //span.ownerDocument = this.ifDoc;
                    var italic = range.parentElement();
                    italic.applyElement(span, "inside");
                    italic.removeNode(false);

                
                }
            }

            /* calc amount of ignored chars for range.move
            var at = range.moveEnd("character", 999999);//move to end of text
            for (var i = 0; i < content.length && calibration<0; i++) {
            if (content.slice(i, i+1) == range.text.slice(0,1)) calibration = i;
            }


            for (var i = 0; i < result.errorPositionArray.length && calibration>=0; i++) {
            //adjust for newlines (moveStart doesn't count \r as a char)
            // numRs= content.slice(calibration, result.errorPositionArray[i].start).split("\r").length - 1;//start from where range will start from, and see how many other newlines there are



            range = this.ifDoc.body.createTextRange().duplicate();
            range.collapse(true);

            //when .move goes past a <p> it counts as 1 char, but when it goes past a <br> it counts as 2.
            var count=0;
            while (count < result.errorPositionArray[i].start - calibration) {
            range.move("character", 1);
            range.moveEnd("character", 2);
            if (range.htmlText.indexOf("<BR") == 0)
            count += 1;//only inc. by 1 because we'll see 2x chars with htmlText==<BR>
            else if (range.htmlText.indexOf("<P") == 0)
            count += 2; //inc. by 2 because we'll see 1x char with htmlText=<P>
            else
            count++;
            }

            var delta = 0;
            if (count > 0)
            delta = 2; //subtract 1 because we already had 1 from the while loop
            range.moveEnd("character", (result.errorPositionArray[i].end - result.errorPositionArray[i].start) - delta);

            //var moved = range.move("character", result.errorPositionArray[i].start - (numRs+calibration));
            //var movedEnd = range.moveEnd("character", (result.errorPositionArray[i].end - result.errorPositionArray[i].start));

            // range.pasteHTML(client.createErrorHTML(result.errorPositionArray[i].word, result.errorPositionArray[i].suggestions)); //"<span style='background-color:yellow;'>" + result.errorPositionArray[i].word + "</span>");
            var rangeParent = range.parentElement();

            if (rangeParent != null && (rangeParent.getAttribute("class") == null || rangeParent.getAttribute("class") != 'rs_err_hl') && range.text == result.errorPositionArray[i].word) {
            range.execCommand("Subscript", false);
            var span = this.ifDoc.createElement("span");
            span.setAttribute("className", "rs_err_hl");//quirks mode
            span.setAttribute("class", "rs_err_hl"); //strict mode

            var mouseup = client.createErrorMouseUp(result.errorPositionArray[i].suggestions);
            span.setAttribute("suggestions", mouseup);

            //SUPERHACK - if we use .onmouseup to register event handler in IE, then we have access to 'this' (the span that was click), but no 'event' object.
            // whereas if we use attachEvent we do not have 'this' but do have 'event'!
            // workaround by storing 'this' by first event handler and using in second...
            //

            span.onmouseup = function () { rsw_clickedSpan = this; };

            span.attachEvent("onmouseup", function () { rsw_showMenu(eval('[' + rsw_clickedSpan.getAttribute("suggestions") + ']'), rsw_clickedSpan, arguments[0]); });//args[0] is event obj
            span.oncontextmenu= function () { try{event.cancelBubble=true;event.preventDefault();}catch(e){}return false; };
            //span.ownerDocument = this.ifDoc;
            var italic = range.parentElement();
            italic.applyElement(span, "inside");
            italic.removeNode(false);
            }

            }
            */
            //selRange.select();
        } catch (e) {
          //  alert(e);
        }
    }


    function recordCaretPos() {
        //if we have a selection do one way, otherwise the other method is safer
        //if(caret.text.length==0)

        try {
            var selection = this.ifDoc.selection;
            var range = selection.createRange().duplicate();
            /*var start = 0, end = 0, normalizedValue, textInputRange, len, endRange;

            start =  -range.moveEnd('character', -9000000);//count chars, not including \r
            this.origTextInRange = this.getContentText().replace(/\r\n/g, "\n").slice(0, start);
            this.cursorPosition = start;
            if (rsw_debug) document.getElementById("debug").value += "\r\nRECORD " + start + " ==>" + this.origTextInRange+"<==";
            */

            if (rsw_ie9) {

                //this code works really well with IE9 (RC) but not so well with IE8
                var start = 0, end = 0, normalizedValue, textInputRange, len, endRange;
                el = this.ifDoc;
                //alert(this.ifDoc.selectionStart);

                this.origTextInRange = this.getContentText();
                len = this.origTextInRange.length;
                normalizedValue = this.origTextInRange.replace(/\r\n/g, "\n"); // el.value.replace(/\r\n/g, "\n");
                // Create a working TextRange that lives only in the input
                textInputRange = this.ifDoc.body.createTextRange();
                textInputRange.moveToBookmark(range.getBookmark());


                // Check if the start and end of the selection are at the very end
                // of the input, since moveStart/moveEnd doesn't return what we want
                // in those cases
                endRange = this.ifDoc.body.createTextRange();
                endRange.collapse(false);

                /*this.origTextInRange = range.text.replace(/\r\n/g, "\n");
                start = range.moveStart('sentence', -9000000) - (normalizedValue.slice(0, end).split("\n").length - 1);//subtract \r instances
                */

                if (rsw_debug) document.getElementById("debug").value += "\r\nRECORD A " + textInputRange.text + "  " + textInputRange.compareEndPoints("StartToEnd", endRange);
                if (textInputRange.compareEndPoints("StartToEnd", endRange) > -1) {
                    start = end = len;
                } else {
                    start = -textInputRange.moveStart("character", -len);
                    //if (rsw_debug) document.getElementById("debug").value += "\r\nRECORD B start is" +start +" adjusting to ";
                    //start -= normalizedValue.slice(0, start).split("\n").length - 1;
                    // if (rsw_debug) document.getElementById("debug").value += start ;
                    if (rsw_debug) document.getElementById("debug").value += "\r\nRECORD B " + textInputRange.compareEndPoints("EndToEnd", endRange);
                    if (textInputRange.compareEndPoints("EndToEnd", endRange) > -1) {
                        end = len;
                    } else {
                        end = -textInputRange.moveEnd("character", -len);
                        end += normalizedValue.slice(0, end).split("\n").length - 1;
                    }


                }



                this.cursorPosition = start;
            } else {

                range.moveStart('sentence', -9000000);

                this.origTextInRange = range.text.replace(/\n/g, "");
                //this.origTextInRange = range.text.replace(/\r\n/g, "\n");

                this.cursorPosition = this.origTextInRange.length;

            }



            if (rsw_debug) document.getElementById("debug").value += "\r\nRECORD CARET" + this.cursorPosition;
        } catch (e) {
            //alert(e);
        }
    }

    function resetCaretPos() {

        try {
            var selection = this.ifDoc.selection;
            var newRange = selection.createRange();
            newRange.move('sentence', -9000000);
            var o = newRange.moveEnd('character', this.cursorPosition);
            var ignNewL = this.origTextInRange.replace(/\r/g, "");
            //var ignNewL = this.origTextInRange.replace(/\r\n/g, "\n");
            if (rsw_debug) document.getElementById("debug").value += "\r\nSET CARET," + o + " has\\r=" + newRange.text.indexOf("\r") + "\r\nnew  text=>" + newRange.text.replace(/\r\n/g, "\n") + "<== \r\n\r\nOLD=>" + ignNewL + "<==\r\n"; ;
            var moveAmount = 1;
            /*
            while (ignNewL.length > newRange.text.replace(/\r\n/g, "").length && moveAmount > 0) {
            moveAmount = newRange.moveEnd('character', 1);
            if (rsw_debug) document.getElementById("debug").value += "\r\nMove caret forward 1, =>" + newRange.text.replace(/\n/g, "").length;
            }
            */
            /*
            if (rsw_debug) document.getElementById("debug").value += "\r\nignNewL.length=" + ignNewL.length + " & newRange.length=" + newRange.text.replace(/\r\n/g, "\n").length;
            while (ignNewL.length > newRange.text.replace(/\r\n/g, "\n").length && moveAmount > 0) {
            moveAmount = newRange.moveEnd('character', 1);
            if (rsw_debug) document.getElementById("debug").value += "\r\nMove caret forward 1, =>" + newRange.text.length;
            }
            */
            if (navigator.userAgent.indexOf("MSIE 7") > -1)
                newRange.moveStart('character', this.cursorPosition);//doesnt actually work properly with IE7 either
            else
                newRange.collapse(false);
            newRange.select();

        } catch (e) {
           //  alert(e);
        }

    }

    /*in use at 3.7
    // older, but doesnt work with selections properly, and also has trouble with scrolling!?
    function recordCaretPos(){
    //if we have a selection do one way, otherwise the other method is safer
    //if(caret.text.length==0)

    try{
    var caret=this.ifDoc.selection.createRange().duplicate();
    this.caretBL = caret.offsetLeft;
    this.caretBT = caret.offsetTop;
    this.selectedText = caret.text;
    //alert(this.caretBT);
    } catch (e){
    }
    }

    function resetCaretPos(){

    try{
    var caret=this.ifDoc.selection.createRange();
    caret.moveToPoint(this.caretBL-1, this.caretBT);//the minus 1 cures a problem with the caret slipping onto the next line, when using <br> for linebreaks
    if(this.selectedText!=null && this.selectedText.length>0)
    caret.moveEnd('character', this.selectedText.length);
    caret.select();
    } catch (e){
    }

    }
    */

    /*pre 3.? but has issues with our " " to &nbsp; conversion (cant always reposition in a block of spaces)*/
    /*
    function recordCaretPos()
    {
    //this.convertToNBSP();
    //alert(this.ifDoc.selection);
    //alert(this.ifDoc.selection.type +"  "+this.ifDoc.selection.typeDetail +"  "+this.ifDoc.selection.TextRange );
    //if(this.ifDoc.selection.type != "None"){
    try	{
    this.savedcaret = this.ifDoc.selection.createRange().getBookmark();
    //alert(this.ifDoc.selection.createRange().offsetLeft);
    }
    catch (e)
    {//alert(e);
    }
    //}
    }

    this.convertToNBSP=convertToNBSP;
    function convertToNBSP(){
    this.setContent(this.getContentText(), true);
    }

    function resetCaretPos()
    {

    try
    {
    var caret = this.ifDoc.selection.createRange();
    caret.moveToBookmark(this.savedcaret);
    correctCaret(caret);

    //with this method (moveToBookmark) its important to refocus the TB, otherwise our listeners wont be called.
    //with moveToPoint this wasnt necessary.
    //apparently, now it doesnt matter this.focus();
    }
    catch (e)
    {
    //alert(e);
    }
    }
    */



    function OnCorrection(e) {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onCorrection(e);



        rsw_broadcastToListeners("correction");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("ayt_correction", rsw_activeTextbox, e);
    }

    function focus() {

        this.iframe.contentWindow.focus();
        //Seems to mess things up
        try { this.iframe.focus(); } catch (e) { }
        //alert('d');
        this.iframe.contentWindow.focus();

        try {
            var caret = this.ifDoc.selection.createRange();
            correctCaret(caret);
        }
        catch (e) {
            //alert(e);
        }
    }


    function containsElement(element) {
        return element.ownerDocument == this.ifDoc;
    }


    function selectedErrorNode() {
        try {
            var selection = rsw_activeTextbox.ifDoc.selection;
            var parentEl = selection.createRange().parentElement();



            if (parentEl.className == "rs_err_hl")
                return parentEl;
            else {

                if (parentEl.children.length > 0 && parentEl.children[parentEl.children.length - 1].className=="rs_err_hl") {
                    var r = this.ifDoc.body.createTextRange();
                    r.moveToElementText(parentEl.children[parentEl.children.length - 1]);
                    if (r.compareEndPoints("EndToEnd", selection.createRange()) == 0) {
                        return parentEl.children[parentEl.children.length - 1];
                    }
                }
                return null;
            }
        } catch (e) {
            return null;
        }
    }

    function getAbsX(element, event) {
        //return this.iframe.offsetLeft + element.offsetLeft - this.ifDoc.body.scrollLeft;

        var obj = this.iframe;
        var curLeft = 0;
        var index = 0;

        if (obj.offsetParent) {

            while (obj.offsetParent) {

                index++;
                var delta = 0;
                if (!window.opera && index > 1)
                    delta = obj.scrollLeft;
                curLeft += obj.offsetLeft - delta;
                obj = obj.offsetParent;
            }
        }
        else if (obj.clientY)
            curLeft += obj.clientY;
        return curLeft + element.offsetLeft - this.ifDoc.body.scrollLeft;
    }

    function getAbsY(element, event) {

        var obj = this.iframe;
        var curtop = 0;
        var index = 0;
        if (obj.offsetParent) {
            while (obj.offsetParent) {
                index++;
                var delta = 0;
                if (!window.opera && index > 1)
                    delta = obj.scrollTop;

                curtop += obj.offsetTop - delta;
                obj = obj.offsetParent;
            }
        }
        else if (obj.clientY)
            curtop += obj.clientY;

        return curtop + element.offsetTop - this.ifDoc.body.scrollTop;
    }

    function changeTo(error, replacement) {
        try {
            var repl = this.ifDoc.createTextNode(replacement);
            error.parentNode.replaceChild(repl, error);
        } catch (e) {
            return null;
        }
    }

    function getSpanElements() {
        return this.ifDoc.getElementsByTagName("span");
    }


    function _onKeyPress() {

        rsw_hideCM();

        var evt = rsw_activeTextbox.iframe.contentWindow.event;



        var errorNode = rsw_activeTextbox.selectedErrorNode();
        if (errorNode)
            rsw_dehighlight(errorNode);


        //special behaviours
        //return
        if (evt != null && evt.keyCode == 13 && !rsw_activeTextbox.multiline) {
            evt.returnValue = false;
        } else if (evt != null && evt.keyCode == 13) {
            //use a br instead of p tag
            /*
            var selection = rsw_activeTextbox.ifDoc.selection;
            var range = selection.createRange();
            range.pasteHTML("<br />");
            range.moveStart("word", 1);
            evt.returnValue = false;
            */
        }

        rsw_activeTextbox.isDirty = true;

        //max number of chars
        if (rsw_activeTextbox.maxlength > 0) {
            if (rsw_activeTextbox.getContentText().replace(/\r/g, "").replace(/\n/g, "").length >= rsw_activeTextbox.maxlength)
                evt.returnValue = false;
        }

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyPress(rsw_activeTextbox.iframe.contentWindow.event);


        rsw_broadcastToListeners("keypress");

        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keypress", rsw_activeTextbox, evt);

    }


    function _onKeyDown() {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyDown(rsw_activeTextbox.iframe.contentWindow.event);



        rsw_broadcastToListeners("keydown");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keydown", rsw_activeTextbox, rsw_activeTextbox.iframe.contentWindow.event);
    }

    function _onKeyUp() {
        rsw_hideCM();

        if (!rsw_ie9) rsw_activeTextbox.ifDoc.body.createTextRange().execCommand('unlink'); //prevent autolinking, as not consistent with plain TB and causes issues

        var evt = rsw_activeTextbox.iframe.contentWindow.event;
        if (evt == null || !(evt.keyCode >= 33 && evt.keyCode <= 40)) {//it wasnt a navigation key (pg up, cursor etc) or we dont know what it was
            var errorNode = rsw_activeTextbox.selectedErrorNode();
            if (errorNode)
                rsw_dehighlight(errorNode);

        }



        rsw_activeTextbox.updateShadow();

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyUp(evt);


        rsw_broadcastToListeners("keyup", evt);
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keyup", rsw_activeTextbox, evt);

    }

    function _onMouseDown() {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onMouseDown(rsw_activeTextbox.iframe.contentWindow.event);

        rsw_hideCM();
        rsw_broadcastToListeners("mousedown");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("mousedown", rsw_activeTextbox, rsw_activeTextbox.iframe.contentWindow.event);

        rsw_activeTextbox.updateShadow();
    }

    function _onMouseUp() {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onMouseUp(rsw_activeTextbox.iframe.contentWindow.event);


        rsw_broadcastToListeners("mouseup");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("mouseup", rsw_activeTextbox, rsw_activeTextbox.iframe.contentWindow.event);

        /*clear clicked on error
        var evt = rsw_activeTextbox.iframe.contentWindow.event;
        if(evt!=null && evt.button!=2){
        var errorNode = rsw_activeTextbox.selectedErrorNode();
        if(errorNode)
        rsw_dehighlight(errorNode);
        }*/
    }

    function _onFocus(event, circle) {
        if (typeof (rsw_activeTextbox.iframe.contentWindow) != 'undefined')
            rsw_yScroll = rsw_getScrollY(rsw_activeTextbox.iframe.contentWindow);

        //alert(rsw_yScroll);
        rsw_activeTextbox.isFocused = true;
        //seems as if this call isn't needed - strangely though it only matters in a bizaare situation involving 2 popups, 1 of which
        //being modal, see tic#2011010675000148
        if (typeof (rsw_useIFrameMenuBacker) == 'undefined' || rsw_useIFrameMenuBacker) rsw_hideCM();


        rsw_activeTextbox.updateShadow();



        rsw_updateActiveTextbox(this); //'this' is the element, not obj

        //fix uneditable element when working with AJAX
        if (rsw_correctCaret) {
            var caret = rsw_activeTextbox.ifDoc.selection.createRange();
            correctCaret(caret);
        }
        //fix uneditable element when working with AJAX

        rsw_broadcastToListeners("focus");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("focus", rsw_activeTextbox, event);

        if (navigator.userAgent.indexOf("MSIE 7") > -1 || navigator.userAgent.indexOf("MSIE 6") > -1) {
            rsw_activeTextbox.ifDoc.body.setAttribute('contentEditable', 'true');
            if (rsw_yScroll != null) rsw_setScrollY(rsw_activeTextbox.iframe.contentWindow, rsw_yScroll ); //setTimeout("rsw_setScrollY(rsw_activeTextbox.iframe.contentWindow, " + rsw_yScroll + ")", 10);
        }

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onFocus(new RSW_IntEvent('focus'));

        if (rsw_activeTextbox.oldOnFocus && rsw_activeTextbox.oldOnFocus != rsw_activeTextbox._onFocus && !circle) rsw_activeTextbox.oldOnFocus(event, true);

//        if (rsw_yScroll != null) setTimeout("rsw_setScrollY(rsw_activeTextbox.iframe.contentWindow, " + rsw_yScroll + ")", 10);
        
    }


    function _onBlur(event, circle) {
        rsw_activeTextbox.isFocused = false;
        rsw_activeTextbox.rsw_key_downed_within_lim = false; //we can't rely on the timer to set this to false because it will be working on different instance of rsw_activeTextbox
        rsw_activeTextbox.updateShadow();
        
        function callOnchange(event, textbox)
        {
            return function () {
                /*   if (event.target) event.target = rsw_activeTextbox.shadowTB;
                if (event.target) event.target = rsw_activeTextbox.shadowTB;
                rsw_activeTextbox.shadowTB.onchange(event);*/
                try {
                    if (typeof (rsw_fireEventInShadow) == 'function')
                        rsw_fireEventInShadow("change", textbox);
                    else if (typeof (textbox.shadowTB.onchange) == 'function') textbox.shadowTB.onchange(event);
                } catch (x) { }
            }
        }

        
            if (rsw_activeTextbox.shadowTB.defaultValue != rsw_activeTextbox.shadowTB.value)
                setTimeout(callOnchange(event, rsw_activeTextbox), 100);
                //setTimeout(rsw_activeTextbox.shadowTB.onchange, 100, [event]);
                //setTimeout("rsw_activeTextbox.shadowTB.onchange();", 100);
        

        //rsw_hideCM(); - cant do this unfortunately because CM menu causes blur
//        if (navigator.userAgent.indexOf("MSIE 7") > -1 || navigator.userAgent.indexOf("MSIE 6") > -1)
        //            setTimeout("rsw_activeTextbox.ifDoc.body.blur()", 500);
        if (navigator.userAgent.indexOf("MSIE 7") > -1 || navigator.userAgent.indexOf("MSIE 6") > -1) rsw_activeTextbox.ifDoc.body.setAttribute('contentEditable', 'false');

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onBlur(new RSW_IntEvent('blur'));

        if (rsw_debug) document.getElementById("debug").value += "\r\nblur";
        if (rsw_activeTextbox.isAYT) rsw_spellCheckTextBox(rsw_activeTextbox); 

        rsw_broadcastToListeners("blur");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("blur", rsw_activeTextbox, event);


        if (rsw_activeTextbox.oldOnBlur && rsw_activeTextbox.oldOnBlur != rsw_activeTextbox._onBlur && !circle) rsw_activeTextbox.oldOnBlur(event, true);
    }

    function setContent(content, contentIsFromShadow) {
        if (rsw_debug) document.getElementById("debug").value += "\r\nSET CONTENT" + content + " & fromshadow=" + contentIsFromShadow;
        //alert("B"+content);
        var pos = -1;
        var ppos = 0;
        var t = "";
        while ((pos = content.indexOf("\n", pos + 1)) > -1) {
            if (pos > ppos + 2) {
                /*				if(content.substring(pos-1, pos)=='\r')
                t += "<P style='margin:0px;'>"+content.substring(ppos, pos-1)+"</P>";
                else
                t += "<P style='margin:0px;'>"+content.substring(ppos, pos)+"</P>";
                */
                if (content.substring(pos - 1, pos) == '\r')
                    t += content.substring(ppos, pos - 1) + "<br />";
                else
                    t += content.substring(ppos, pos) + "<br />";


            } else {
                if (content.charAt(ppos) != '\r')
                    t += content.substring(ppos, pos) + "<br />"; //"<P style='margin:0px;'>&nbsp;</P>";
                //fails badly t += content.substring(ppos, pos)+ "<P style='margin:0px;'>&nbsp;</P>";
                else
                    t += "<br />";

            }
            ppos = pos + 1;
        }

        /*while( (pos=content.indexOf("\n", pos+1)) > -1){
        if(pos>ppos+2){
        if(content.substring(pos-1, pos)=='\r')
        t += content.substring(ppos, pos-1)+"<br />";
        else
        t += content.substring(ppos, pos)+"<br />";
        } else{
        if(content.charAt(ppos)!='\r')
        t += content.substring(ppos, pos)+"<br />";//"<P style='margin:0px;'>&nbsp;</P>";
        //fails badly t += content.substring(ppos, pos)+ "<P style='margin:0px;'>&nbsp;</P>";
        else
        t += "<br />";
        }
        ppos = pos+1;
        }*/

        //alert("A"+t);

        if ((ppos < content.length || ppos == 0) && !rsw_ie9Standards) {
//            t += "<p style='margin: 0px;'>" + content.substring(ppos, content.length) + "</p>";
        } else if (ppos == content.length) {//there was a newline and it's at the end - have commented out because this browser treats</p><br> has two newlines
            //		t += "<br />";
            //	alert(pos+" "+ppos);

        } else {

        }

//        if (rsw_ie9Standards)
            t += content.substring(ppos, content.length);


        if (!this.multiline) {//dont allow word wrapping
            var pos = -1;
            var ppos = 0;
            var opener = -1;
            var closer = -1;
            while ((pos = t.indexOf(" ", pos + 1)) > -1) {
                opener = t.lastIndexOf("<", pos);
                closer = t.lastIndexOf(">", pos);
                if ((opener == -1 && closer == -1) || opener == -1 || opener < closer)//not inside a tag, so change space
                    t = t.substring(0, pos) + String.fromCharCode(160) + t.substring(pos + 1);
                //t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
                ppos = pos;
            }

            t = "<nobr>" + t + "</nobr>";
        } else {

            var pos = -1;
            var ppos = 0;
            var opener = -1;
            var closer = -1;
            var flag = true;
            while ((pos = t.indexOf(" ", pos + 1)) > -1) {
                if (pos + 1 < t.length && (t.charAt(pos + 1) == ' ' || (pos > 4 && t.charAt(pos - 1) == '>' && t.substring(pos - 5, pos - 1) != 'span'))) {//we want to convert ' ' next to <p> tags and the like otherwise they collapse, but not next to span which otherwise cause our underlined words to wrap when next to edge of box
                    opener = t.lastIndexOf("<", pos);
                    closer = t.lastIndexOf(">", pos);
                    if ((opener == -1 && closer == -1) || opener == -1 || opener < closer) {//not inside a tag, so change space
                        //					t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
                        t = t.substring(0, pos) + String.fromCharCode(160) + t.substring(pos + 1);

                        //flag=!flag; --- used to have this, but actually in IE we can change all to &nbsp; and it still wraps
                    }
                    ppos = pos;
                }
            }
            //t = "<pre wrap='wrap' class='RS_MultiLineTB' id='prewrap'>"+t+"</pre>";
            //t = "<div  class='RS_MultiLineTB'>"+t+"</div>";

        }
        //if(rsw_debug)document.getElementById("debug").value=t;
        if(this.ifDoc.body!=null) this.ifDoc.body.innerHTML = t;



        /*
        if(this.multiline){
        //assign style from body to 'pre'
        var prewrap = this.ifDoc.getElementById('prewrap');
        if(prewrap != null){
        for(var prop in this.ifDoc.body.style){
        try{
        eval("prewrap.style."+prop+" = this.ifDoc.body.style."+prop);
        } catch (e){}
        }
        }
        }*/

        //this causes the textbox to focus initially, and therefore scroll problems
        /*try
        {
        var caret = this.ifDoc.selection.createRange();
        correctCaret(caret);
        }
        catch (e)
        {
        }*/

        //apart from it being redundant, updating the shadow also causes odd focus issues when IE initialises, so
        //by not updating when the content came from the shadow we avoid putting focus in the TB without our handlers attached.
        if (!contentIsFromShadow) this.updateShadow();
    }

    function correctCaret(caret) {

        //following trick solves problem of selecting outside end paragraph		IE only
        if (caret.text.length == 0 && caret.moveStart("character", -1) < 0) {
            caret.select();
            caret.moveStart("character", 1);
            caret.select();
            caret.collapse(true);
        }
        caret.select();

    }

    function getContent() {
        return this.ifDoc.body.innerHTML;

    }


    function getContentText() {
        //parse the DOM and pull the text
        if (this.ifDocElement == null) return "";
        var contentElements 
        for(var i=0; i<this.ifDocElement.childNodes.length;i++)
            if (this.ifDocElement.childNodes[i].tagName=="BODY") contentElements = this.ifDocElement.childNodes[i].childNodes;
        var contents = "";
        for (var i = 0; i < contentElements.length; i++) {

            if (contentElements[i].nodeValue)//this isnt required and screws up sometimes it seems
                contents += contentElements[i].nodeValue;
            else if (contentElements[i].nodeName.toLowerCase() == "br" && i < contentElements.length - 1)//browser always gives us a trailing newline, even when there isnt one in the 'text'
                contents += "\r\n";
            else if (contentElements[i].nodeName.toLowerCase() == "input")
                contents += contentElements[i].value;
            else //if (contentElements[i].nodeName.toLowerCase()!="p" || i < contentElements.length-1)
                contents += rsw_innerText(contentElements[i],
						i == contentElements.length - 1, contentElements[contentElements.length - 1].nodeName.toLowerCase() == "br"); //br doesnt count as last element in collection

            /*	if (ie9Standards) {
            if (contentElements[i].nodeName.toLowerCase() == "p" && i < contentElements.length - 1)
            contents += "\r\n";
            }*/
        }
        //if(rsw_debug)document.getElementById("debug").value=contents;
        /*if(contents.length>0 && contents.charAt(contents.length-1)=='\n')
        contents = contents.substring(0, contents.length-1);
        if(contents.length>0 && contents.charAt(contents.length-1)=='\r')
        contents = contents.substring(0, contents.length-1);
        */

        return contents;
    }



    //---unique functions

    function _onContextMenu() {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onContextMenu(rsw_activeTextbox.iframe.contentWindow.event);

        rsw_broadcastToListeners("contextmenu");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("contextmenu", rsw_activeTextbox, rsw_activeTextbox.iframe.contentWindow.event);
        //now we allow return false;
        //if(rsw_MenuOnRightClick) return false;
    }

    function _onPaste() {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onPaste(rsw_activeTextbox.iframe.contentWindow.event);
        var errorNode = rsw_activeTextbox.selectedErrorNode();
        if (errorNode)
            rsw_dehighlight(errorNode);
        setTimeout("rsw_activeTextbox.updateShadow();if(rsw_activeTextbox.maxlength>0){"+
        "rsw_setShadowTB(rsw_activeTextbox.shadowTB, rsw_activeTextbox.shadowTB.value.substring(0,rsw_activeTextbox.maxlength));}rsw_activeTextbox.recordCaretPos();rsw_activeTextbox.updateIframe();rsw_activeTextbox.resetCaretPos();", 300);

        rsw_broadcastToListeners("paste");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("paste", rsw_activeTextbox, rsw_activeTextbox.iframe.contentWindow.event);

    }

    function initialize(attempts) {
        //if(this.iframe==null)//we dont have the iframe, possibly because it was invisible when we first init'ed
        //	this.iframe =  document.getElementById(this.tbConfig.values[0]);



        var ifID;
        if (!this.iframe)
            ifID = this.tbConfig.values[0];
        else
            ifID = this.iframe.id;

        this.shadowTBID = ifID.substring(0, ifID.length - 3); //we need to have a separate copy of the ID, since it the
        //shadow is display:none to begin with, we wont get it from getElementById
        this.shadowTB = document.getElementById(this.shadowTBID);

        //--check initializing
        if (rsw_id_waitingToInitialize == null)//this'll try to initialize now
            rsw_id_waitingToInitialize = ifID;
        //may not have been passed this param
        if (!attempts) attempts = 0;
        //wait for it to load - timeout just in case blank didnt include correct load script.
        if ((!this.iframe.contentWindow.loaded && attempts < 100) || attempts == 0 || rsw_id_waitingToInitialize != ifID) {//keep trying upto 5 seconds for this to load
            var time = 50 + Math.floor(Math.random() * 50);
            attempts++;
            eval("setTimeout( function() {try{	rsw_getTBSFromID('" + this.shadowTBID + "').initialize(" + attempts + ");}catch(exc){}}, " + time + " ); ");
            return;
        }
        rsw_id_waitingToInitialize = null;
        //---------------------------------

        //the rest may fail if the iframe is display:none, so important to call above first.
        this.ifDoc = this.iframe.contentWindow.document;

        this.iframe.contentWindow.document.documentElement.setAttribute("spellcheck", false);

        this.ifDocElement = this.iframe.contentWindow.document.documentElement;

        //this.ifDocElement.style.whiteSpace="pre";

        rsw_createLink(this.ifDoc, this.CssSheetURL);

        //fix line spacing
        this.ifDoc.styleSheets[0].addRule("P", "margin:0;");

        if (this.enabled) {

            if (this.editable) {//this.ifDoc.designMode = "On";
                this.ifDoc.body.setAttribute('contentEditable', 'true');
            }

            this.attachEvents();

        }

        rsw_setSettings(this);



        //with lots of textboxes we can end up with un-enterable windows, this fixes that but causes scrolling issues
        /*try{
        var caret = this.ifDoc.selection.createRange();
        correctCaret(caret);
        }catch (e){}
        */
    }

    function attachEvents() {
        if (this.ifDocElement.onmousedown != this._onMouseDown) {
            this.ifDocElement.onmousedown = this._onMouseDown;
            this.ifDocElement.onmouseup = this._onMouseUp;
            this.ifDocElement.onkeypress = this._onKeyPress;
            this.ifDocElement.onkeydown = this._onKeyDown;
            this.ifDocElement.onkeyup = this._onKeyUp;
            this.ifDocElement.onpaste = this._onPaste;
        }

        if (this._onFocus != this.iframe.onfocus) {
            this.oldOnFocus = this.iframe.onfocus;
            this.iframe.onfocus = this._onFocus;

            this.oldOnBlur = this.iframe.onblur;
            this.iframe.onblur = this._onBlur;
            this.ifDoc.oncontextmenu = this._onContextMenu;
        }

        try {
            document.execCommand("AutoUrlDetect", false, false); //in IE9 we can turn off auto url linking
        } catch (exc) { }
    }

    function setDisabled(disabled) {
        this.ifDoc.body.setAttribute('contentEditable', !disabled);

        this.enabled = !disabled;

        if (this.enabled) this.attachEvents();

        if (typeof (rsw_ignoreDisabledBoxes) != 'undefined' && rsw_ignoreDisabledBoxes && disabled) 
            this.updateIframe();

        if (this.enabled) this.attachEvents();

        if (this.multiline) {
            if (disabled) this.ifDoc.body.className = 'RS_MultiLineTB_Disabled';
            else this.ifDoc.body.className = 'RS_MultiLineTB';
        } else {
            if (disabled) this.ifDoc.body.className = 'RS_SingleLineTB_Disabled';
            else this.ifDoc.body.className = 'RS_SingleLineTB';
        }
    }

    function unhook() {
        this.ifDoc.body.setAttribute('contentEditable', 'false');


        this.ifDocElement.onmousedown = null;
        this.ifDocElement.onmouseup = null;
        this.ifDocElement.onkeypress = null;
        this.ifDocElement.onkeydown = null;
        this.ifDocElement.onkeyup = null;
        this.ifDocElement.onpaste = null;



        this.oldOnFocus = null;
        this.iframe.onfocus = null;

        this.oldOnBlur = null;
        this.iframe.onblur = null;
        this.ifDoc.oncontextmenu = null;

    }


    function updateIframe() {
        if (this.textIsXHTML)
            this.setContent((this.shadowTB.value), true);
        else
            this.setContent(rsw_escapeHTML(this.shadowTB.value), true);

    }

    function updateShadow() {
        
        var reg = new RegExp(String.fromCharCode(160), "g");
        rsw_setShadowTB(this.shadowTB, this.getContentText().replace(reg, " "));

        
    }

    function getShadowText() {

        return this.shadowTB.value;
    }

}

















/*

-------------------------------------------------------------------------
Mozilla Text Box --------------------------------------------------------
-------------------------------------------------------------------------


*/






function MozlyTB(iframeEl, editable) {
    this.iframe = iframeEl;
    this.editable = editable;
    this.ifDoc; 	//content window's document element
    this.designMode;
    this.initialize = initialize;
    this.ifDocElement;
    this.setContent = setContent;
    this.getContent = getContent;
    this._onKeyPress = _onKeyPress;
    this._onKeyUp = _onKeyUp;
    this._onKeyDown = _onKeyDown;
    this._onMouseDown = _onMouseDown;
    this._onMouseUp = _onMouseUp;
    this._onFocus = _onFocus;
    this.isFocused = false;
    this._onBlur = _onBlur;
    this._onClick = _onClick;
    this._onContextMenu = _onContextMenu;
    this.getSpanElements = getSpanElements;
    this.changeTo = changeTo;
    this.getAbsY = getAbsY;
    this.getAbsX = getAbsX;
    this.isStatic = false;
    this.getContentText = getContentText;
    this.selectedErrorNode = selectedErrorNode;
    this.containsElement = containsElement;
    this.focus = focus;
    this.multiline = false;
    this.enabled = true;
    this.maxlength = 0;
    this.shadowTB;
    this.updateIframe = updateIframe;
    this.updateShadow = updateShadow;
    this.getShadowText = getShadowText;
    this.spellChecker;
    this.OnCorrection = OnCorrection;
    this.isWrappedInNOBR = false;
    this.oldOnBlur;
    this.oldOnFocus;
    this.isDirty = false;
    this.recordCaretPos = recordCaretPos;
    this.resetCaretPos = resetCaretPos;
    this.selOffset;
    this.selOffsetEnd;
    this.CssSheetURL;
    this.getNumberOfErrors = getNumberOfErrors;
    this.textIsXHTML;
    this.unhook = unhook;
    this.repObj = null;
    this.setDisabled = setDisabled;
    this.select = select;
    this.attachEvents = attachEvents;
    //this.insertErrorHighlights = insertErrorHighlights;
    this.isVisible = isVisible;
    this.recordCaretPosAppleWebKit = recordCaretPosAppleWebKit;
    this.resetCaretPosAppleWebKit = resetCaretPosAppleWebKit;

    function isVisible() {
        //if porting to saf/chrome, might need to worry about scrolly pos
        //return document.elementFromPoint(rsw_findPosX(this.iframe), rsw_findPosY(this.iframe)).id == this.iframe.id;
       /* var el = document.elementFromPoint(rsw_findPosX(this.iframe) + (rsw_getElementWidth(this.iframe.id) / 2), rsw_findPosY(this.iframe) + (rsw_getElementHeight(this.iframe.id) / 2));
        if (el != null && el.id)
            return el.id == this.iframe.id;
        else return false;*/
        var rect = this.iframe.getBoundingClientRect();
        return rect.left != 0 || rect.top != 0 || rect.width != 0 || rect.height != 0;
    }


    //select all text
    function select() {
        this.focus();
        if (this.getContentText().length > 0) {
            var sel = this.iframe.contentWindow.getSelection();
            var range = sel.getRangeAt(0);
            var contentElements = this.ifDoc.body.childNodes;
            range.setStartBefore(contentElements[0]);
            range.setEndAfter(contentElements[contentElements.length - 1]);
        }
    }

    function getNumberOfErrors() {
        var errors = this.getSpanElements();
        var numErrors = 0;
        for (var i = 0; i < errors.length; i++) {
            if (errors[i].className == 'rs_err_hl') {
                numErrors++;
            }
        }
        return numErrors;
    }

    /*
    function insertErrorHighlights(result, client) {

    try {

    var selection = this.iframe.contentWindow.getSelection();
    var selRange = selection.getRangeAt(0);
    //var bookmark = selRange.getBookmark();
    var range;

    var numRs;
    var content = this.getContentText();

    //calibrate - range.move will ignore all leading linebreaks (BR) at the start of the text, so find out how many it's ignoring
    var calibration = -1;
    range = this.ifDoc.body.createRange();
    range.collapse(true);

    //scan through, only considering letters and digits because whitespace is unreliable
    var contentChar;
    var rangeCharCode;
    var contentCharCode;


    // range = this.ifDoc.body.createTextRange().duplicate();
    //range.collapse(true);
    //range.moveEnd("character", 1);

    var start = 0;
    var k = 0;
    var numberOfChars = 0;
    for (var i = 0; i < result.errorPositionArray.length; i++) {

    if (i > 0) start = result.errorPositionArray[i - 1].start;


    for (var j = start; j <= result.errorPositionArray[i].start; j++) {

    contentCharCode = content.charCodeAt(j);
    if (((contentCharCode >= 65 && contentCharCode <= 122) || (contentCharCode >= 48 && contentCharCode <= 57)))//not letter or digit
    numberOfChars++;
    }




    //for (var j = start; j < numberOfChars; ) {

    do {

    range.moveEnd("character", 1);
    rangeCharCode = range.text.charCodeAt(0);
    if (((rangeCharCode >= 65 && rangeCharCode <= 122) || (rangeCharCode >= 48 && rangeCharCode <= 57)))
    k++;


    range.move("character", 1);

    } while (k < numberOfChars);

    range.move("character", -1); //we already went over the character we wanted to stop at.

    delta = 0; //subtract 1 because we already had 1 from the while loop
    range.moveEnd("character", (result.errorPositionArray[i].end - result.errorPositionArray[i].start) - delta);

    var rangeParent = range.parentElement();
    if (rangeParent.nodeName == "A") rangeParent.removeNode(false); //autolinking in IE8- can cause problems and isnt relevant to our editor anyway

    if (rangeParent != null && (rangeParent.getAttribute("class") == null || rangeParent.getAttribute("class") != 'rs_err_hl') && range.text == result.errorPositionArray[i].word) {
    range.execCommand("Subscript", false);
    var span = this.ifDoc.createElement("span");
    span.setAttribute("className", "rs_err_hl"); //quirks mode
    span.setAttribute("class", "rs_err_hl"); //strict mode

    var mouseup = client.createErrorMouseUp(result.errorPositionArray[i].suggestions);
    span.setAttribute("suggestions", mouseup);

    //SUPERHACK - if we use .onmouseup to register event handler in IE, then we have access to 'this' (the span that was click), but no 'event' object.
    // whereas if we use attachEvent we do not have 'this' but do have 'event'!
    // workaround by storing 'this' by first event handler and using in second...
    //

    span.onmouseup = function () { rsw_clickedSpan = this; };

    span.attachEvent("onmouseup", function () { if (rsw_clickedSpan != null) { rsw_showMenu(eval('[' + rsw_clickedSpan.getAttribute("suggestions") + ']'), rsw_clickedSpan, arguments[0]); } rsw_clickedSpan = null; });   //args[0] is event obj
    span.oncontextmenu = function () { try { event.cancelBubble = true; event.preventDefault(); } catch (e) { } return false; };
    //span.ownerDocument = this.ifDoc;
    var italic = range.parentElement();
    italic.applyElement(span, "inside");
    italic.removeNode(false);
    }
    }


    } catch (e) { alert(e); }

    }
    */


    function recordCaretPos() {
        //if (rsw_applewebkit){ this.recordCaretPosAppleWebKit();return;}

        try {
            var sel = this.iframe.contentWindow.getSelection();
            var range = sel.getRangeAt(0);
            var len = 0;
            var contentElements = this.ifDoc.body.childNodes;
            this.selOffset = rsw_getAbsSel(range, len, contentElements)[0];
            this.selOffsetEnd = rsw_getAbsSel(range, len, contentElements, true)[0];
        } catch (e) {
            //alert(e);


        }

    }

    function recordCaretPosAppleWebKit() {
        var oWin = this.iframe.contentWindow;
        //var oDoc = oWin.document;
        var sel = oWin.getSelection();

        this._previous_range = new Object();
        this._previous_range.baseNode = sel.baseNode;
        this._previous_range.baseOffset = sel.baseOffset;
        this._previous_range.extentNode = sel.extentNode;
        this._previous_range.extentOffset = sel.extentOffset;
    }

    function resetCaretPosAppleWebKit() {
        var oWin = this.iframe.contentWindow;
        var sel = oWin.getSelection();
        sel.setBaseAndExtent(this._previous_range.baseNode,
                       this._previous_range.baseOffset,
                       this._previous_range.extentNode,
                       this._previous_range.extentOffset);
    }

    function resetCaretPos() {
       // if (rsw_applewebkit) { this.resetCaretPosAppleWebKit(); return; }
        try {
            var sel = this.iframe.contentWindow.getSelection();
            var range;
            if(sel.rangeCount==0) range = this.iframe.contentWindow.document.createRange();
            else range = sel.getRangeAt(0);
            var contentElements = this.ifDoc.body.childNodes;
            var absRange = rsw_getAbsRance(0, this.selOffset, contentElements);
            var absRangeEnd = rsw_getAbsRance(0, this.selOffsetEnd, contentElements);
            if (absRangeEnd[4])
                range.setEndAfter(absRangeEnd[2]);
            else
                range.setEnd(absRangeEnd[2], absRangeEnd[3]);

            if (absRange[4])
                range.setStartAfter(absRange[2]);
            else
                range.setStart(absRange[2], absRange[3]);

            if (rsw_chrome || rsw_applewebkit) {
                sel.removeAllRanges();
                sel.addRange(range);
            }
        } catch (e) {
            try {
                var range;//problems so put caret at end
                if (sel.rangeCount == 0) range = this.iframe.contentWindow.document.createRange();
                else range = sel.getRangeAt(0);
                var contentElements = this.ifDoc.body.childNodes;
                //range.setStartAfter(contentElements[contentElements.length-1]);
                var lastElPtr = contentElements.length - 1;
                while (!contentElements[lastElPtr].nodeValue && lastElPtr > 0) {
                    lastElPtr--;
                }
                range.setEnd(contentElements[lastElPtr], contentElements[lastElPtr].nodeValue.length);
                range.setStart(contentElements[lastElPtr], contentElements[lastElPtr].nodeValue.length);
                if (rsw_chrome || rsw_applewebkit) {
                    sel.removeAllRanges();
                    sel.addRange(range);
                }
            } catch (ex) {
                //alert(ex);
            }
        }
    }





    function OnCorrection(e) {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onCorrection(e);

        rsw_broadcastToListeners("correction");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("ayt_correction", rsw_activeTextbox, e);
    }


    function focus() {

        this.iframe.contentWindow.focus();

    }




    function containsElement(element) {
        return element.ownerDocument == this.ifDoc;
    }

    function selectedErrorNode() {
        try {
            var selection = rsw_activeTextbox.iframe.contentWindow.getSelection();
            if (selection.anchorNode.parentNode.className == "rs_err_hl")
                return selection.anchorNode.parentNode;
            else return null;
        } catch (e) {
            return null;
        }
    }

    function getAbsX(element, event) {
        //return this.iframe.offsetLeft + element.offsetLeft- this.iframe.scrollLeft - this.ifDoc.body.scrollLeft;

        var obj = this.iframe;
        var curLeft = 0;
        var index = 0;
        if (obj.offsetParent) {
            while (obj.offsetParent) {
                index++;
                var delta = 0;
                if (!window.opera && index > 1)
                    delta = obj.scrollLeft;

                curLeft += obj.offsetLeft - delta;
                obj = obj.offsetParent;
            }
        }
        else if (obj.clientY)
            curLeft += obj.clientY;

        return curLeft + element.offsetLeft - this.iframe.scrollTop - this.ifDoc.body.scrollLeft;
    }

    function getAbsY(element, event) {


        var obj = this.iframe;
        var curtop = 0;
        var index = 0;
        if (obj.offsetParent) {
            while (obj.offsetParent) {

                index++;
                var delta = 0;
                if (!window.opera && index > 1)
                    delta = obj.scrollTop;

                curtop += obj.offsetTop - delta;

                obj = obj.offsetParent;
            }
        }
        else if (obj.clientY)
            curtop += obj.clientY;

        return curtop + element.offsetTop - this.iframe.scrollTop - this.ifDoc.body.scrollTop;

    }


    function changeTo(error, replacement) {
        var repl = this.ifDoc.createTextNode(replacement);
        error.parentNode.replaceChild(repl, error);
    }


    function getSpanElements() {
        return this.ifDoc.getElementsByTagName("span");
    }

    function getContentText() {
        //parse the DOM and pull the text

        var contentElements = this.ifDoc.body.childNodes;

        /*
        for(var q=0; q<contentElements.length; q++){
        document.getElementById('debug').value += contentElements[q].nodeName +" -> " +contentElements[q].nodeValue + " " +  "\n";
        /*if(contentElements[q].contentElements){
        for(var qi=0; qi<contentElements[q].contentElements.length; qi++){
        document.getElementById('debug').value += contentElements[q].contentElements[qi].nodeName +" => " +contentElements[q].contentElements[qi].nodeValue +"\n";

        }
        }
        document.getElementById('debug').value += rsw_innerText(contentElements[q]);

        }		*/
        //didnt work in NS
        // this.ifDocElement.childNodes[1].childNodes;

        var contents = "";
        var innerT = "";
        for (var i = 0; i < contentElements.length; i++) {

            if (contentElements[i].nodeName.toLowerCase() == "input")
                contents += contentElements[i].value;
            else if (contentElements[i].nodeName.toLowerCase() != "br" || i < contentElements.length - 1)//browser always gives us a trailing newline, even when there isnt one in the 'text'
            {
                innerT = rsw_innerText(contentElements[i]);


                contents += innerT;
            }

        }
        /*Unsure why this was here, suspect that we were getting things like <br>\n -
        var newlineexp = new RegExp("\n");
        var t = contents;
        while(newlineexp.test(t))
        t = t.replace(newlineexp, "");
        contents = t;
        */
        //document.getElementById('TextBox1').value = t;



        /*
        //when text comes from Word, it wraps with \n, which should actually be space
        var newlineexp = new RegExp("\n");
        var t = contents;
        while(newlineexp.test(t))
        t = t.replace(newlineexp, " ");
        contents = t;
        */


        return contents;
    }


    function _onClick(event) {
        //internally send event to representative
        //if(rsw_activeTextbox.repObj!=null) rsw_activeTextbox.repObj._onClick(event);

        //THIS CODE IS DEPENDENT ON RAPIDSPELLWINLINEHELPER PRODUCING SPANS WITH FORMAT
        //<span class='rs_err_hl' onmouseup="rsw_showMenu(['x','y','z'],this,event)"
        //extract suggestions from onmouseup handler and send to show menu
        if (navigator.userAgent.toLowerCase().indexOf("firefox/1.0") == -1 && navigator.userAgent.toLowerCase().indexOf("firefox") > -1) {
            //in FF1.0 the IFrame event handlers are enabled, in 1.5 (and on?) they're not
            if (typeof event != 'undefined') {
                try {
                    var embedhandler = event.target.attributes['onmouseup'].nodeValue;

                    //var suggestionsString = "[" + embedhandler.substring(embedhandler.indexOf("[") + 1, embedhandler.indexOf("]") + 1);
                    //var suggestions = eval(suggestionsString);

/*
                    var suggsClean = embedhandler.substring(embedhandler.indexOf("[") + 1, embedhandler.indexOf("]"));
                    if(suggsClean.length>1) {
                        suggsClean = suggsClean.substring(1, suggsClean.length-1);//take out open and close '
                    }

                    var suggestions = suggsClean.split("','");
*/
                    var suggestions = rsw_getSuggestionsArray(embedhandler);
                    rsw_showMenu(suggestions, event.target, event);
                } catch (ex) {

                }
            }
        }

    }



    function _onKeyPress(event) {

        rsw_hideCM();



        var evt = event;

        if (evt != null && evt.keyCode == 13 && !rsw_activeTextbox.multiline) {
            event.preventDefault();
            event.cancelBubble = true;

        }

        //tab behaviour in MOZLY is different to IE
        if (evt != null && evt.keyCode == 9) {
            //			event.preventDefault();
            //			event.cancelBubble = true;

        }

        rsw_activeTextbox.isDirty = true;

        //max number of chars
        if (rsw_activeTextbox.maxlength > 0) {
            if (
				evt.keyCode != 8 && evt.keyCode != 46 //delete and backspace exceptions
				&& (evt.keyCode < 33 || evt.keyCode > 40) //arrow key exceptions
				&& rsw_activeTextbox.getContentText().replace(/\r/g, "").replace(/\n/g, "").length >= rsw_activeTextbox.maxlength) {
                event.preventDefault();
                event.cancelBubble = true;
            }
        }

        if (!rsw_activeTextbox.multiline && rsw_activeTextbox.getContentText() == "\r\n")//when theres no text and we're in single line mode, need to remove <nobr> tags otherwise cant type
        {
            var els = rsw_activeTextbox.ifDoc.getElementsByTagName("nobr");
            for (var xi = 0; xi < els.length; xi++) {
                els[xi].parentNode.removeChild(els[xi]);
            }
        }

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyPress(event);

        rsw_broadcastToListeners("keypress");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keypress", rsw_activeTextbox, event);
    }


    function _onKeyDown(event) {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyDown(event);

        rsw_broadcastToListeners("keydown");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keydown", rsw_activeTextbox, event);
    }

    function _onFocus(event) {
        rsw_activeTextbox.isFocused = true;
        rsw_hideCM();
        rsw_activeTextbox.updateShadow();

        rsw_updateActiveTextbox(this); //'this' is the element, not obj


        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onFocus(event);

        rsw_broadcastToListeners("focus");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("focus", rsw_activeTextbox, event);
        //if(rsw_activeTextbox.oldOnFocus)rsw_activeTextbox.oldOnFocus();
    }

    function _onBlur(event) {
        rsw_activeTextbox.isFocused = false;
        rsw_activeTextbox.rsw_key_downed_within_lim = false; //we can't rely on the timer to set this to false because it will be working on different instance of rsw_activeTextbox
        rsw_activeTextbox.updateShadow();

        if (rsw_activeTextbox.shadowTB.onchange) {
            if (rsw_activeTextbox.shadowTB.defaultValue != rsw_activeTextbox.shadowTB.value) {

                //we need to properly dispatch the event otherwise ASP.NET validators can get upset, for eg.
                var evt = document.createEvent("UIEvents");
                evt.initUIEvent("change", event.canBubble, event.cancelable, event.view,
                     event.detail);
                rsw_activeTextbox.shadowTB.dispatchEvent(evt);
                //rsw_activeTextbox.shadowTB.onchange(evt);
            }
        }

        //rsw_hideCM(); - cant do this unfortunately because CM menu causes blur
        if(rsw_activeTextbox.isAYT)
            rsw_spellCheckTextBox(rsw_activeTextbox);
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onBlur(event);

        rsw_broadcastToListeners("blur");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("blur", rsw_activeTextbox, event);



        //if(rsw_activeTextbox.oldOnBlur)rsw_activeTextbox.oldOnBlur();
    }


    function _onKeyUp(event) {

        if (event == null || !(event.keyCode >= 33 && event.keyCode <= 40)) {//it wasnt a navigation key (pg up, cursor etc) or we dont know what it was
            var errorNode = rsw_activeTextbox.selectedErrorNode();
            if (errorNode)
                rsw_dehighlight(errorNode);
        }

        rsw_activeTextbox.updateShadow();


        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyUp(event);

        rsw_broadcastToListeners("keyup");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keyup", rsw_activeTextbox, event);

    }

    function _onMouseDown(event) {
        rsw_hideCM();

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onMouseDown(event);

        rsw_broadcastToListeners("mousedown");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("mousedown", rsw_activeTextbox, event);
        rsw_activeTextbox.updateShadow();
    }

    function _onMouseUp(event) {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onMouseUp(event);

        rsw_broadcastToListeners("mouseup");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("mouseup", rsw_activeTextbox, event);

        //clear clicked on error
        /*
        if(evt!=null && evt.button!=2){
        var errorNode = rsw_activeTextbox.selectedErrorNode();
        if(errorNode)
        rsw_dehighlight(errorNode);
        }*/
    }


    function setContent(content) {

        var t = content;



        if (this.multiline) {
            //var newlineexp = new RegExp("\n");
            while (rsw_newlineexp.test(t))
                t = t.replace(rsw_newlineexp, "<br>");


        }

        //dont want any lingering \r
        var newlineexp = new RegExp("\r");
        while (newlineexp.test(t))
            t = t.replace(newlineexp, "");


        if (!this.multiline) {//dont allow word wrapping
            var pos = -1;
            var ppos = 0;
            var opener = -1;
            var closer = -1;

            while ((pos = t.indexOf(" ", pos + 1)) > -1) {
                opener = t.lastIndexOf("<", pos);
                closer = t.lastIndexOf(">", pos);
                if ((opener == -1 && closer == -1) || opener == -1 || opener < closer)//not inside a tag, so change space
                    t = t.substring(0, pos) + "&nbsp;" + t.substring(pos + 1);
                ppos = pos;
            }
            if (t.length == 0)
                t = "";
            else {
                t = "<nobr>" + t + "</nobr>";
                this.isWrappedInNOBR = true;
            }

            /*
            } else {
            //t = "<pre wrap='wrap' class='RS_MultiLineTB' id='prewrap'>"+t+"</pre>";
            var pos=-1;
            var ppos=0;
            var opener=-1;
            var closer=-1;
            var flag=false;
            while( (pos=t.indexOf(" ", pos+1)) > -1){
            opener = t.lastIndexOf("<", pos);
            closer = t.lastIndexOf(">", pos);
            if((opener==-1 && closer==-1) || opener==-1 || opener<closer){//not inside a tag, so change space
            if(flag)
            t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
            else
            t = t.substring(0, pos)+" " + t.substring(pos+1);
            flag=!flag;
            }
            ppos = pos;
            }
            }*/
        } else {
            var pos = -1;
            var ppos = 0;
            var opener = -1;
            var closer = -1;
            var flag = true;
            while ((pos = t.indexOf(" ", pos + 1)) > -1) {

                //				if(pos+1<t.length && t.charAt(pos+1)==' '){
                //if(pos+1<t.length && (t.charAt(pos+1)==' ' || (pos>0 && t.charAt(pos-1)=='>'))){
                if (pos + 1 < t.length && (t.charAt(pos + 1) == ' ' || (pos > 4 && t.charAt(pos - 1) == '>' && t.substring(pos - 5, pos - 1) != 'span'))) {//we want to convert ' ' next to <p> tags and the like otherwise they collapse, but not next to span which otherwise cause our underlined words to wrap when next to edge of box
                    opener = t.lastIndexOf("<", pos);
                    closer = t.lastIndexOf(">", pos);
                    if ((opener == -1 && closer == -1) || opener == -1 || opener < closer) {//not inside a tag, so change space
                        //					t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
                        t = t.substring(0, pos) + String.fromCharCode(160) + t.substring(pos + 1);

                        /*
                        if(flag)
                        t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
                        else
                        t = t.substring(0, pos)+" " + t.substring(pos+1);
                        flag=!flag;
                        */
                    }
                    ppos = pos;
                }
            }
            //t = "<pre wrap='wrap' class='RS_MultiLineTB' id='prewrap'>"+t+"</pre>";
            //t = "<div  class='RS_MultiLineTB'>"+t+"</div>";

            //NEW 3.5
            //mozly adds a trailing <br> when you type, even though its not visible, so we should add one aswell, except when only one line of text
            t += "<BR>";

        }

        this.ifDoc.body.innerHTML = t;


        /*
        if(this.multiline){
        //assign style from body to 'pre'
        var prewrap = this.ifDoc.getElementById('prewrap');
        if(prewrap != null){
        for(var prop in this.ifDoc.body.style){
        try{
        eval("prewrap.style."+prop+" = this.ifDoc.body.style."+prop);
        } catch (e){}
        }
        }
        }*/


        this.updateShadow();

    }

    function getContent() {
        return this.ifDoc.body.innerHTML;
    }

    function setDisabled(disabled) {
        if (disabled)
            this.iframe.contentDocument.designMode = 'off';
        else
            this.iframe.contentDocument.designMode = 'on';

        this.enabled = !disabled;

        if (typeof (rsw_ignoreDisabledBoxes) != 'undefined' && rsw_ignoreDisabledBoxes && disabled)
            this.updateIframe();

        if (this.multiline) {
            if (disabled) this.ifDoc.body.className = 'RS_MultiLineTB_Disabled';
            else this.ifDoc.body.className = 'RS_MultiLineTB';
        } else {
            if (disabled) this.ifDoc.body.className = 'RS_SingleLineTB_Disabled';
            else this.ifDoc.body.className = 'RS_SingleLineTB';
        }
    }

    //---unique functions

    function _onContextMenu(e) {
        //now allowed		e.preventDefault();

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onContextMenu(e);

        if (rsw_MenuOnRightClick) {
            e.cancelBubble = true;
            e.preventDefault();
        }



        rsw_broadcastToListeners("contextmenu");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("contextmenu", rsw_activeTextbox, event);
        //if(rsw_MenuOnRightClick)return false;
    }


    function initialize(attempts) {

        //alert('i'+this.iframe.id);
        var ifID = this.iframe.id;
        this.shadowTBID = ifID.substring(0, ifID.length - 3); //we need to have a separate copy of the ID, since it the
        //shadow is display:none to begin with, we wont get it from getElementById
        this.shadowTB = document.getElementById(this.shadowTBID);


        //may not have been passed this param
        if (!attempts) attempts = 0;
        //wait for it to load - timeout just in case blank didnt include correct load script.
        if (!this.iframe.contentWindow.loaded && attempts < 100) {//keep trying upto 5 seconds for this to load
            eval("setTimeout( function() {	rsw_getTBSFromID('" + this.shadowTBID + "').initialize(" + attempts + ");}, 50 ); ");
            return;
        }


        this.ifDoc = this.iframe.contentWindow.document;

        this.iframe.contentWindow.document.documentElement.setAttribute("spellcheck", false);

        this.ifDocElement = this.iframe.contentWindow.document.documentElement;
        rsw_createLink(this.ifDoc, this.CssSheetURL);

        if (this.enabled) {

            if (this.editable) {
                //beats that cheesy 'cant delete' bug in MOZLY
                //this.ifDoc.designMode = 'On';
                //this.ifDoc.body.contentEditable = true;
               // eval("setTimeout( function() {try{ 	document.getElementById('" + this.iframe.id + "').contentDocument.designMode = 'On';} catch (exc){alert(exc);} }, 400 ); ");

                eval("setTimeout( function() {try{ 	document.getElementById('" + this.iframe.id + "').contentDocument.designMode = 'On';} catch (exc){} }, 400 ); ");
             //   eval("setTimeout( function() {try{ 	document.getElementById('" + this.iframe.id + "').contentDocument.body.contentEditable = true;} catch (exc){} }, 400 ); ");
                this.attachEvents();
            }
        }



        rsw_setSettings(this);

        if (rsw_ffMaxLengthChecker == null && this.maxlength > 0)
            rsw_ffMaxLengthChecker = setInterval("if(rsw_activeTextbox.maxlength>0&&rsw_activeTextbox.shadowTB.value.length>rsw_activeTextbox.maxlength){rsw_activeTextbox.updateShadow();rsw_setShadowTB(rsw_activeTextbox.shadowTB, rsw_activeTextbox.shadowTB.value.substring(0,rsw_activeTextbox.maxlength));rsw_activeTextbox.updateIframe();}", 300);

    }

    function attachEvents() {


        this.ifDoc.addEventListener('mousedown', this._onMouseDown, false);
        this.ifDoc.addEventListener('mouseup', this._onMouseUp, false);
        this.ifDoc.addEventListener('keypress', this._onKeyPress, false);
        this.ifDoc.addEventListener('keydown', this._onKeyDown, false);
        this.ifDoc.addEventListener('keyup', this._onKeyUp, false);
        this.ifDoc.addEventListener('contextmenu', this._onContextMenu, false);
        this.ifDoc.addEventListener('focus', this._onFocus, false);
        this.ifDoc.addEventListener('blur', this._onBlur, false);

        //because FF1.5 wont cooperate with event handlers, we need to attach a listener to
        //span clicks from here
        this.ifDoc.addEventListener('click', this._onClick, false);

        if (typeof (this.tbConfig) != 'undefined' && this.tbConfig != null && this.tbConfig.keys != null) {
            for (var v = 0; v < this.tbConfig.keys.length; v++)
                if (this.tbConfig.keys[v] == "multiline")
                    this.multiline = this.tbConfig.values[v];

            if (!this.multiline && rsw_showHorizScrollBarsInFF) {
                this.iframe.scrolling = "yes";
                for (var v = 0; v < this.tbConfig.keys.length; v++) {
                    //alert(this.tbConfig.keys[v]);
                    if (this.tbConfig.keys[v] == "iframe.style.height") {
                        var hstr = parseInt(this.tbConfig.values[v].substring(1, this.tbConfig.values[v].length - 3), 10) + 22;
                        if (hstr < 50)
                            this.tbConfig.values[v] = "'" + hstr + "px'";

                    }
                }

            }
        }
    }

    function unhook() {
        this.ifDoc.removeEventListener('mousedown', this._onMouseDown, false);
        this.ifDoc.removeEventListener('mouseup', this._onMouseUp, false);
        this.ifDoc.removeEventListener('keypress', this._onKeyPress, false);
        this.ifDoc.removeEventListener('keydown', this._onKeyDown, false);
        this.ifDoc.removeEventListener('keyup', this._onKeyUp, false);
        this.ifDoc.removeEventListener('contextmenu', this._onContextMenu, false);
        this.ifDoc.removeEventListener('focus', this._onFocus, false);
        this.ifDoc.removeEventListener('blur', this._onBlur, false);

        //because FF1.5 wont cooperate with event handlers, we need to attach a listener to
        //span clicks from here
        this.ifDoc.removeEventListener('click', this._onClick, false);
    }


    function updateIframe() {
        if (this.textIsXHTML)
            this.setContent((this.shadowTB.value), true);
        else
            this.setContent(rsw_escapeHTML(this.shadowTB.value), true);
    }
    function updateShadow() {
        //to be confirmed
        //due to some intricacy which couldnt be identified, Java causes issues with FF when submitting a tb with tabs.
        //tabs in the RSWITB turn into &nbsp;, which when submitted (in FF) are read as A (grave).  Solution is to convert
        //&nbsp; to space here.  However for .NET this messes up the reconcilliation routine.  Ideally this should be handled
        //closer to the source of the problem, which is probably the server code.
        //if(!rsw_isASPX){
        
        var reg = new RegExp(String.fromCharCode(160), "g");
        rsw_setShadowTB(this.shadowTB, this.getContentText().replace(reg, " "));


        
        /*} else
        this.shadowTB.value = this.getContentText();*/
    }

    function getShadowText() {
        return this.shadowTB.value;
    }

}









function WebkitTB(iframeEl, editable) {
    this.iframe = iframeEl;
    this.editable = editable;
    this.ifDoc; 	//content window's document element
    this.designMode;
    this.initialize = initialize;
    this.ifDocElement;
    this.setContent = setContent;
    this.getContent = getContent;
    this._onKeyPress = _onKeyPress;
    this._onKeyUp = _onKeyUp;
    this._onKeyDown = _onKeyDown;
    this._onMouseDown = _onMouseDown;
    this._onMouseUp = _onMouseUp;
    this._onFocus = _onFocus;
    this.isFocused = false;
    this._onBlur = _onBlur;
    this._onClick = _onClick;
    this._onContextMenu = _onContextMenu;
    this.getSpanElements = getSpanElements;
    this.changeTo = changeTo;
    this.getAbsY = getAbsY;
    this.getAbsX = getAbsX;
    this.isStatic = false;
    this.getContentText = getContentText;
    this.selectedErrorNode = selectedErrorNode;
    this.containsElement = containsElement;
    this.focus = focus;
    this.multiline = false;
    this.enabled = true;
    this.maxlength = 0;
    this.shadowTB;
    this.updateIframe = updateIframe;
    this.updateShadow = updateShadow;
    this.getShadowText = getShadowText;
    this.spellChecker;
    this.OnCorrection = OnCorrection;
    this.isWrappedInNOBR = false;
    this.oldOnBlur;
    this.oldOnFocus;
    this.isDirty = false;
    this.recordCaretPos = recordCaretPos;
    this.resetCaretPos = resetCaretPos;
    this.selOffset;
    this.selOffsetEnd;
    this.CssSheetURL;
    this.getNumberOfErrors = getNumberOfErrors;
    this.textIsXHTML;
    this.unhook = unhook;
    this.repObj = null;
    this.setDisabled = setDisabled;
    this.select = select;
    this.attachEvents = attachEvents;
    //this.insertErrorHighlights = insertErrorHighlights;
    this.isVisible = isVisible;

    function isVisible() {
        //if porting to saf/chrome, might need to worry about scrolly pos
        //return document.elementFromPoint(rsw_findPosX(this.iframe), rsw_findPosY(this.iframe)).id == this.iframe.id;
        /* var el = document.elementFromPoint(rsw_findPosX(this.iframe) + (rsw_getElementWidth(this.iframe.id) / 2), rsw_findPosY(this.iframe) + (rsw_getElementHeight(this.iframe.id) / 2));
        if (el != null && el.id)
        return el.id == this.iframe.id;
        else return false;*/
        var rect = this.iframe.getBoundingClientRect();
        return rect.left != 0 || rect.top != 0 || rect.width != 0 || rect.height != 0;
    }


    //select all text
    function select() {
        this.focus();
        if (this.getContentText().length > 0) {
            var sel = this.iframe.contentWindow.getSelection();
            var range = sel.getRangeAt(0);
            var contentElements = this.ifDoc.body.childNodes;
            range.setStartBefore(contentElements[0]);
            range.setEndAfter(contentElements[contentElements.length - 1]);
        }
    }

    function getNumberOfErrors() {
        var errors = this.getSpanElements();
        var numErrors = 0;
        for (var i = 0; i < errors.length; i++) {
            if (errors[i].className == 'rs_err_hl') {
                numErrors++;
            }
        }
        return numErrors;
    }

    /*
    function insertErrorHighlights(result, client) {

    try {

    var selection = this.iframe.contentWindow.getSelection();
    var selRange = selection.getRangeAt(0);
    //var bookmark = selRange.getBookmark();
    var range;

    var numRs;
    var content = this.getContentText();

    //calibrate - range.move will ignore all leading linebreaks (BR) at the start of the text, so find out how many it's ignoring
    var calibration = -1;
    range = this.ifDoc.body.createRange();
    range.collapse(true);

    //scan through, only considering letters and digits because whitespace is unreliable
    var contentChar;
    var rangeCharCode;
    var contentCharCode;


    // range = this.ifDoc.body.createTextRange().duplicate();
    //range.collapse(true);
    //range.moveEnd("character", 1);

    var start = 0;
    var k = 0;
    var numberOfChars = 0;
    for (var i = 0; i < result.errorPositionArray.length; i++) {

    if (i > 0) start = result.errorPositionArray[i - 1].start;


    for (var j = start; j <= result.errorPositionArray[i].start; j++) {

    contentCharCode = content.charCodeAt(j);
    if (((contentCharCode >= 65 && contentCharCode <= 122) || (contentCharCode >= 48 && contentCharCode <= 57)))//not letter or digit
    numberOfChars++;
    }




    //for (var j = start; j < numberOfChars; ) {

    do {

    range.moveEnd("character", 1);
    rangeCharCode = range.text.charCodeAt(0);
    if (((rangeCharCode >= 65 && rangeCharCode <= 122) || (rangeCharCode >= 48 && rangeCharCode <= 57)))
    k++;


    range.move("character", 1);

    } while (k < numberOfChars);

    range.move("character", -1); //we already went over the character we wanted to stop at.

    delta = 0; //subtract 1 because we already had 1 from the while loop
    range.moveEnd("character", (result.errorPositionArray[i].end - result.errorPositionArray[i].start) - delta);

    var rangeParent = range.parentElement();
    if (rangeParent.nodeName == "A") rangeParent.removeNode(false); //autolinking in IE8- can cause problems and isnt relevant to our editor anyway

    if (rangeParent != null && (rangeParent.getAttribute("class") == null || rangeParent.getAttribute("class") != 'rs_err_hl') && range.text == result.errorPositionArray[i].word) {
    range.execCommand("Subscript", false);
    var span = this.ifDoc.createElement("span");
    span.setAttribute("className", "rs_err_hl"); //quirks mode
    span.setAttribute("class", "rs_err_hl"); //strict mode

    var mouseup = client.createErrorMouseUp(result.errorPositionArray[i].suggestions);
    span.setAttribute("suggestions", mouseup);

    //SUPERHACK - if we use .onmouseup to register event handler in IE, then we have access to 'this' (the span that was click), but no 'event' object.
    // whereas if we use attachEvent we do not have 'this' but do have 'event'!
    // workaround by storing 'this' by first event handler and using in second...
    //

    span.onmouseup = function () { rsw_clickedSpan = this; };

    span.attachEvent("onmouseup", function () { if (rsw_clickedSpan != null) { rsw_showMenu(eval('[' + rsw_clickedSpan.getAttribute("suggestions") + ']'), rsw_clickedSpan, arguments[0]); } rsw_clickedSpan = null; });   //args[0] is event obj
    span.oncontextmenu = function () { try { event.cancelBubble = true; event.preventDefault(); } catch (e) { } return false; };
    //span.ownerDocument = this.ifDoc;
    var italic = range.parentElement();
    italic.applyElement(span, "inside");
    italic.removeNode(false);
    }
    }


    } catch (e) { alert(e); }

    }
    */


    function recordCaretPos() {

        try {
            var sel = this.iframe.contentWindow.getSelection();
            var range = sel.getRangeAt(0);
            var len = 0;
            var contentElements = this.ifDoc.body.childNodes;
            this.selOffset = rsw_getAbsSel(range, len, contentElements)[0];
            this.selOffsetEnd = rsw_getAbsSel(range, len, contentElements, true)[0];
        } catch (e) {
            //alert(e);


        }

    }

    function resetCaretPos() {
        try {
            var sel = this.iframe.contentWindow.getSelection();
            var range = sel.getRangeAt(0);
            var contentElements = this.ifDoc.body.childNodes;
            var absRange = rsw_getAbsRance(0, this.selOffset, contentElements);
            var absRangeEnd = rsw_getAbsRance(0, this.selOffsetEnd, contentElements);
            if (absRangeEnd[4])
                range.setEndAfter(absRangeEnd[2]);
            else
                range.setEnd(absRangeEnd[2], absRangeEnd[3]);

            if (absRange[4])
                range.setStartAfter(absRange[2]);
            else
                range.setStart(absRange[2], absRange[3]);


            //chrome requirement
            sel.removeAllRanges();
            sel.addRange(range);

        } catch (e) {
            try {
                var range = sel.getRangeAt(0); //we blew it, so position at end
                var contentElements = this.ifDoc.body.childNodes;
                //range.setStartAfter(contentElements[contentElements.length-1]);
                var lastElPtr = contentElements.length - 1;
                while (!contentElements[lastElPtr].nodeValue && lastElPtr > 0) {
                    lastElPtr--;
                }
                range.setEnd(contentElements[lastElPtr], contentElements[lastElPtr].nodeValue.length);
                range.setStart(contentElements[lastElPtr], contentElements[lastElPtr].nodeValue.length);

            } catch (ex) {
                //alert(ex);
            }
        }
    }





    function OnCorrection(e) {
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onCorrection(e);

        rsw_broadcastToListeners("correction");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("ayt_correction", rsw_activeTextbox, e);
    }


    function focus() {
        
        this.iframe.contentWindow.focus();

    }




    function containsElement(element) {
        return element.ownerDocument == this.ifDoc;
    }

    function selectedErrorNode() {
        
        try {
            var selection = rsw_activeTextbox.iframe.contentWindow.getSelection();
            if (selection.anchorNode.parentNode.className == "rs_err_hl")
                return selection.anchorNode.parentNode;
            else return null;
        } catch (e) {
            return null;
        }
    }

    function getAbsX(element, event) {
        //return this.iframe.offsetLeft + element.offsetLeft- this.iframe.scrollLeft - this.ifDoc.body.scrollLeft;

        var obj = this.iframe;
        var curLeft = 0;
        var index = 0;
        if (obj.offsetParent) {
            while (obj.offsetParent) {
                index++;
                var delta = 0;
                if (!window.opera && index > 1)
                    delta = obj.scrollLeft;

                curLeft += obj.offsetLeft - delta;
                obj = obj.offsetParent;
            }
        }
        else if (obj.clientY)
            curLeft += obj.clientY;

        return curLeft + element.offsetLeft - this.iframe.scrollTop - this.ifDoc.body.scrollLeft;
    }

    function getAbsY(element, event) {


        var obj = this.iframe;
        var curtop = 0;
        var index = 0;
        if (obj.offsetParent) {
            while (obj.offsetParent) {

                index++;
                var delta = 0;
                if (!window.opera && index > 1)
                    delta = obj.scrollTop;

                curtop += obj.offsetTop - delta;

                obj = obj.offsetParent;
            }
        }
        else if (obj.clientY)
            curtop += obj.clientY;

        return curtop + element.offsetTop - this.iframe.scrollTop - this.ifDoc.body.scrollTop;

    }


    function changeTo(error, replacement) {
        var repl = this.ifDoc.createTextNode(replacement);
        error.parentNode.replaceChild(repl, error);
    }


    function getSpanElements() {
        return this.ifDoc.getElementsByTagName("span");
    }

    function getContentText() {
        
        //parse the DOM and pull the text

        var contentElements = this.ifDoc.body.childNodes;

        /*
        for(var q=0; q<contentElements.length; q++){
        document.getElementById('debug').value += contentElements[q].nodeName +" -> " +contentElements[q].nodeValue + " " +  "\n";
        /*if(contentElements[q].contentElements){
        for(var qi=0; qi<contentElements[q].contentElements.length; qi++){
        document.getElementById('debug').value += contentElements[q].contentElements[qi].nodeName +" => " +contentElements[q].contentElements[qi].nodeValue +"\n";

        }
        }
        document.getElementById('debug').value += rsw_innerText(contentElements[q]);

        }		*/
        //didnt work in NS
        // this.ifDocElement.childNodes[1].childNodes;

        var contents = "";
        var innerT = "";
        for (var i = 0; i < contentElements.length; i++) {

            if (contentElements[i].nodeName.toLowerCase() == "input")
                contents += contentElements[i].value;
            else if (contentElements[i].nodeName.toLowerCase() != "br" || i < contentElements.length - 1)//browser always gives us a trailing newline, even when there isnt one in the 'text'
            {
                innerT = rsw_innerText(contentElements[i]);


                contents += innerT;
            }

        }
        /*Unsure why this was here, suspect that we were getting things like <br>\n -
        var newlineexp = new RegExp("\n");
        var t = contents;
        while(newlineexp.test(t))
        t = t.replace(newlineexp, "");
        contents = t;
        */
        //document.getElementById('TextBox1').value = t;



        /*
        //when text comes from Word, it wraps with \n, which should actually be space
        var newlineexp = new RegExp("\n");
        var t = contents;
        while(newlineexp.test(t))
        t = t.replace(newlineexp, " ");
        contents = t;
        */


        return contents;
    }


    function _onClick(event) {
        
        //internally send event to representative
        //if(rsw_activeTextbox.repObj!=null) rsw_activeTextbox.repObj._onClick(event);

        //THIS CODE IS DEPENDENT ON RAPIDSPELLWINLINEHELPER PRODUCING SPANS WITH FORMAT
        //<span class='rs_err_hl' onmouseup="rsw_showMenu(['x','y','z'],this,event)"
        //extract suggestions from onmouseup handler and send to show menu
        if (navigator.userAgent.toLowerCase().indexOf("firefox/1.0") == -1 && navigator.userAgent.toLowerCase().indexOf("firefox") > -1) {
            //in FF1.0 the IFrame event handlers are enabled, in 1.5 (and on?) they're not
            if (typeof event != 'undefined') {
                try {
                    var embedhandler = event.target.attributes['onmouseup'].nodeValue;

                    //var suggestionsString = "[" + embedhandler.substring(embedhandler.indexOf("[") + 1, embedhandler.indexOf("]") + 1);
                    //var suggestions = eval(suggestionsString);

                    /*
                    var suggsClean = embedhandler.substring(embedhandler.indexOf("[") + 1, embedhandler.indexOf("]"));
                    if(suggsClean.length>1) {
                    suggsClean = suggsClean.substring(1, suggsClean.length-1);//take out open and close '
                    }

                    var suggestions = suggsClean.split("','");
                    */
                    var suggestions = rsw_getSuggestionsArray(embedhandler);
                    rsw_showMenu(suggestions, event.target, event);
                } catch (ex) {

                }
            }
        }

    }



    function _onKeyPress(event) {
        

        rsw_hideCM();



        var evt = event;

        if (evt != null && evt.keyCode == 13 && !rsw_activeTextbox.multiline) {
            event.preventDefault();
            event.cancelBubble = true;

        }

        //tab behaviour in MOZLY is different to IE
        if (evt != null && evt.keyCode == 9) {
            //			event.preventDefault();
            //			event.cancelBubble = true;

        }

        rsw_activeTextbox.isDirty = true;

        //max number of chars
        if (rsw_activeTextbox.maxlength > 0) {
            if (
				evt.keyCode != 8 && evt.keyCode != 46 //delete and backspace exceptions
				&& (evt.keyCode < 33 || evt.keyCode > 40) //arrow key exceptions
				&& rsw_activeTextbox.getContentText().replace(/\r/g, "").replace(/\n/g, "").length >= rsw_activeTextbox.maxlength) {
                event.preventDefault();
                event.cancelBubble = true;
            }
        }

        if (!rsw_activeTextbox.multiline && rsw_activeTextbox.getContentText() == "\r\n")//when theres no text and we're in single line mode, need to remove <nobr> tags otherwise cant type
        {
            var els = rsw_activeTextbox.ifDoc.getElementsByTagName("nobr");
            for (var xi = 0; xi < els.length; xi++) {
                els[xi].parentNode.removeChild(els[xi]);
            }
        }

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyPress(event);

        rsw_broadcastToListeners("keypress");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keypress", rsw_activeTextbox, event);
    }


    function _onKeyDown(event) {
        
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyDown(event);

        rsw_broadcastToListeners("keydown");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keydown", rsw_activeTextbox, event);
    }

    function _onFocus(event) {
        
        rsw_activeTextbox.isFocused = true;
        rsw_hideCM();
        rsw_activeTextbox.updateShadow();

        rsw_updateActiveTextbox(this); //'this' is the element, not obj


        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onFocus(event);

        rsw_broadcastToListeners("focus");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("focus", rsw_activeTextbox, event);
        //if(rsw_activeTextbox.oldOnFocus)rsw_activeTextbox.oldOnFocus();
    }

    function _onBlur(event) {
        
        rsw_activeTextbox.isFocused = false;
        rsw_activeTextbox.rsw_key_downed_within_lim = false; //we can't rely on the timer to set this to false because it will be working on different instance of rsw_activeTextbox
        rsw_activeTextbox.updateShadow();

        if (rsw_activeTextbox.shadowTB.onchange) {
            if (rsw_activeTextbox.shadowTB.defaultValue != rsw_activeTextbox.shadowTB.value) {

                //we need to properly dispatch the event otherwise ASP.NET validators can get upset, for eg.
                var evt = document.createEvent("UIEvents");
                evt.initUIEvent("change", event.canBubble, event.cancelable, event.view,
                     event.detail);
                rsw_activeTextbox.shadowTB.dispatchEvent(evt);
                //rsw_activeTextbox.shadowTB.onchange(evt);
            }
        }

        //rsw_hideCM(); - cant do this unfortunately because CM menu causes blur
        if (rsw_activeTextbox.isAYT)
            rsw_spellCheckTextBox(rsw_activeTextbox);
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onBlur(event);

        rsw_broadcastToListeners("blur");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("blur", rsw_activeTextbox, event);



        //if(rsw_activeTextbox.oldOnBlur)rsw_activeTextbox.oldOnBlur();
    }


    function _onKeyUp(event) {
        

        if (event == null || !(event.keyCode >= 33 && event.keyCode <= 40)) {//it wasnt a navigation key (pg up, cursor etc) or we dont know what it was
            var errorNode = rsw_activeTextbox.selectedErrorNode();
            if (errorNode)
                rsw_dehighlight(errorNode);
        }

        rsw_activeTextbox.updateShadow();


        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onKeyUp(event);

        rsw_broadcastToListeners("keyup");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keyup", rsw_activeTextbox, event);

    }

    function _onMouseDown(event) {
        
        rsw_hideCM();

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onMouseDown(event);

        rsw_broadcastToListeners("mousedown");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("mousedown", rsw_activeTextbox, event);
        rsw_activeTextbox.updateShadow();
    }

    function _onMouseUp(event) {
        
        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onMouseUp(event);

        rsw_broadcastToListeners("mouseup");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("mouseup", rsw_activeTextbox, event);

        //clear clicked on error
        /*
        if(evt!=null && evt.button!=2){
        var errorNode = rsw_activeTextbox.selectedErrorNode();
        if(errorNode)
        rsw_dehighlight(errorNode);
        }*/
    }


    function setContent(content) {
        

        var t = content;



        if (this.multiline) {
            //var newlineexp = new RegExp("\n");
            while (rsw_newlineexp.test(t))
                t = t.replace(rsw_newlineexp, "<br>");


        }

        //dont want any lingering \r
        var newlineexp = new RegExp("\r");
        while (newlineexp.test(t))
            t = t.replace(newlineexp, "");


        if (!this.multiline) {//dont allow word wrapping
            var pos = -1;
            var ppos = 0;
            var opener = -1;
            var closer = -1;

            while ((pos = t.indexOf(" ", pos + 1)) > -1) {
                opener = t.lastIndexOf("<", pos);
                closer = t.lastIndexOf(">", pos);
                if ((opener == -1 && closer == -1) || opener == -1 || opener < closer)//not inside a tag, so change space
                    t = t.substring(0, pos) + "&nbsp;" + t.substring(pos + 1);
                ppos = pos;
            }
            if (t.length == 0)
                t = "";
            else {
                t = "<nobr>" + t + "</nobr>";
                this.isWrappedInNOBR = true;
            }

            /*
            } else {
            //t = "<pre wrap='wrap' class='RS_MultiLineTB' id='prewrap'>"+t+"</pre>";
            var pos=-1;
            var ppos=0;
            var opener=-1;
            var closer=-1;
            var flag=false;
            while( (pos=t.indexOf(" ", pos+1)) > -1){
            opener = t.lastIndexOf("<", pos);
            closer = t.lastIndexOf(">", pos);
            if((opener==-1 && closer==-1) || opener==-1 || opener<closer){//not inside a tag, so change space
            if(flag)
            t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
            else
            t = t.substring(0, pos)+" " + t.substring(pos+1);
            flag=!flag;
            }
            ppos = pos;
            }
            }*/
        } else {
            var pos = -1;
            var ppos = 0;
            var opener = -1;
            var closer = -1;
            var flag = true;
            while ((pos = t.indexOf(" ", pos + 1)) > -1) {

                //				if(pos+1<t.length && t.charAt(pos+1)==' '){
                //if(pos+1<t.length && (t.charAt(pos+1)==' ' || (pos>0 && t.charAt(pos-1)=='>'))){
                if (pos + 1 < t.length && (t.charAt(pos + 1) == ' ' || (pos > 4 && t.charAt(pos - 1) == '>' && t.substring(pos - 5, pos - 1) != 'span'))) {//we want to convert ' ' next to <p> tags and the like otherwise they collapse, but not next to span which otherwise cause our underlined words to wrap when next to edge of box
                    opener = t.lastIndexOf("<", pos);
                    closer = t.lastIndexOf(">", pos);
                    if ((opener == -1 && closer == -1) || opener == -1 || opener < closer) {//not inside a tag, so change space
                        //					t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
                        t = t.substring(0, pos) + String.fromCharCode(160) + t.substring(pos + 1);

                        /*
                        if(flag)
                        t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
                        else
                        t = t.substring(0, pos)+" " + t.substring(pos+1);
                        flag=!flag;
                        */
                    }
                    ppos = pos;
                }
            }
            //t = "<pre wrap='wrap' class='RS_MultiLineTB' id='prewrap'>"+t+"</pre>";
            //t = "<div  class='RS_MultiLineTB'>"+t+"</div>";

            //NEW 3.5
            //mozly adds a trailing <br> when you type, even though its not visible, so we should add one aswell, except when only one line of text
            t += "<BR>";

        }

        this.ifDoc.body.innerHTML = t;


        /*
        if(this.multiline){
        //assign style from body to 'pre'
        var prewrap = this.ifDoc.getElementById('prewrap');
        if(prewrap != null){
        for(var prop in this.ifDoc.body.style){
        try{
        eval("prewrap.style."+prop+" = this.ifDoc.body.style."+prop);
        } catch (e){}
        }
        }
        }*/


        this.updateShadow();

    }

    function getContent() {        
        return this.ifDoc.body.innerHTML;
    }

    function setDisabled(disabled) {
        
        if (disabled)
            this.iframe.contentDocument.designMode = 'off';
        else
            this.iframe.contentDocument.designMode = 'on';

        this.enabled = !disabled;

        if (typeof (rsw_ignoreDisabledBoxes) != 'undefined' && rsw_ignoreDisabledBoxes && disabled)
            this.updateIframe();

        if (this.multiline) {
            if (disabled) this.ifDoc.body.className = 'RS_MultiLineTB_Disabled';
            else this.ifDoc.body.className = 'RS_MultiLineTB';
        } else {
            if (disabled) this.ifDoc.body.className = 'RS_SingleLineTB_Disabled';
            else this.ifDoc.body.className = 'RS_SingleLineTB';
        }
    }

    //---unique functions

    function _onContextMenu(e) {
        
        //now allowed		e.preventDefault();

        //internally send event to representative
        if (rsw_activeTextbox.repObj != null) rsw_activeTextbox.repObj._onContextMenu(e);

        if (rsw_MenuOnRightClick) {
            e.cancelBubble = true;
            e.preventDefault();
        }



        rsw_broadcastToListeners("contextmenu");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("contextmenu", rsw_activeTextbox, event);
        //if(rsw_MenuOnRightClick)return false;
    }


    function initialize(attempts) {

        //alert('i'+this.iframe.id);
        var ifID = this.iframe.id;
        this.shadowTBID = ifID.substring(0, ifID.length - 3); //we need to have a separate copy of the ID, since it the
        //shadow is display:none to begin with, we wont get it from getElementById
        this.shadowTB = document.getElementById(this.shadowTBID);


        //may not have been passed this param
        if (!attempts) attempts = 0;
        //wait for it to load - timeout just in case blank didnt include correct load script.
        if (!this.iframe.contentWindow.loaded && attempts < 100) {//keep trying upto 5 seconds for this to load
            eval("setTimeout( function() {	rsw_getTBSFromID('" + this.shadowTBID + "').initialize(" + attempts + ");}, 50 ); ");
            return;
        }


        this.ifDoc = this.iframe.contentWindow.document;

        this.iframe.contentWindow.document.documentElement.setAttribute("spellcheck", false);

        this.ifDocElement = this.iframe.contentWindow.document.documentElement;
        rsw_createLink(this.ifDoc, this.CssSheetURL);

        if (this.enabled) {

            if (this.editable) {
                //beats that cheesy 'cant delete' bug in MOZLY
//                this.iframe.contentDocument.designMode = 'on';
              //  this.ifDoc.body.contentEditable = true;
                // eval("setTimeout( function() {try{ 	document.getElementById('" + this.iframe.id + "').contentDocument.designMode = 'On';} catch (exc){alert(exc);} }, 400 ); ");

                eval("setTimeout( function() {try{ 	document.getElementById('" + this.iframe.id + "').contentDocument.designMode = 'On';} catch (exc){} }, 400 ); ");
                //   eval("setTimeout( function() {try{ 	document.getElementById('" + this.iframe.id + "').contentDocument.body.contentEditable = true;} catch (exc){} }, 400 ); ");
                this.attachEvents();
            }
        }



        rsw_setSettings(this);

        if (rsw_ffMaxLengthChecker == null && this.maxlength > 0)
            rsw_ffMaxLengthChecker = setInterval("if(rsw_activeTextbox.maxlength>0&&rsw_activeTextbox.shadowTB.value.length>rsw_activeTextbox.maxlength){rsw_activeTextbox.updateShadow();rsw_setShadowTB(rsw_activeTextbox.shadowTB, rsw_activeTextbox.shadowTB.value.substring(0,rsw_activeTextbox.maxlength));rsw_activeTextbox.updateIframe();}", 300);

    }

    function attachEvents() {
        

        this.ifDoc.addEventListener('mousedown', this._onMouseDown, false);
        this.ifDoc.addEventListener('mouseup', this._onMouseUp, false);
        this.ifDoc.addEventListener('keypress', this._onKeyPress, false);
        this.ifDoc.addEventListener('keydown', this._onKeyDown, false);
        this.ifDoc.addEventListener('keyup', this._onKeyUp, false);
        this.ifDoc.addEventListener('contextmenu', this._onContextMenu, false);
        this.ifDoc.addEventListener('focus', this._onFocus, false);
        this.ifDoc.addEventListener('blur', this._onBlur, false);

        //because FF1.5 wont cooperate with event handlers, we need to attach a listener to
        //span clicks from here
        this.ifDoc.addEventListener('click', this._onClick, false);

        if (typeof (this.tbConfig) != 'undefined' && this.tbConfig != null && this.tbConfig.keys != null) {
            for (var v = 0; v < this.tbConfig.keys.length; v++)
                if (this.tbConfig.keys[v] == "multiline")
                    this.multiline = this.tbConfig.values[v];

            if (!this.multiline && rsw_showHorizScrollBarsInFF) {
                this.iframe.scrolling = "yes";
                for (var v = 0; v < this.tbConfig.keys.length; v++) {
                    //alert(this.tbConfig.keys[v]);
                    if (this.tbConfig.keys[v] == "iframe.style.height") {
                        var hstr = parseInt(this.tbConfig.values[v].substring(1, this.tbConfig.values[v].length - 3), 10) + 22;
                        if (hstr < 50)
                            this.tbConfig.values[v] = "'" + hstr + "px'";

                    }
                }

            }
        }
    }

    function unhook() {
        this.ifDoc.removeEventListener('mousedown', this._onMouseDown, false);
        this.ifDoc.removeEventListener('mouseup', this._onMouseUp, false);
        this.ifDoc.removeEventListener('keypress', this._onKeyPress, false);
        this.ifDoc.removeEventListener('keydown', this._onKeyDown, false);
        this.ifDoc.removeEventListener('keyup', this._onKeyUp, false);
        this.ifDoc.removeEventListener('contextmenu', this._onContextMenu, false);
        this.ifDoc.removeEventListener('focus', this._onFocus, false);
        this.ifDoc.removeEventListener('blur', this._onBlur, false);

        //because FF1.5 wont cooperate with event handlers, we need to attach a listener to
        //span clicks from here
        this.ifDoc.removeEventListener('click', this._onClick, false);
    }


    function updateIframe() {
        if (this.textIsXHTML)
            this.setContent((this.shadowTB.value), true);
        else
            this.setContent(rsw_escapeHTML(this.shadowTB.value), true);
    }
    function updateShadow() {
        //to be confirmed
        //due to some intricacy which couldnt be identified, Java causes issues with FF when submitting a tb with tabs.
        //tabs in the RSWITB turn into &nbsp;, which when submitted (in FF) are read as A (grave).  Solution is to convert
        //&nbsp; to space here.  However for .NET this messes up the reconcilliation routine.  Ideally this should be handled
        //closer to the source of the problem, which is probably the server code.
        //if(!rsw_isASPX){

        var reg = new RegExp(String.fromCharCode(160), "g");
        rsw_setShadowTB(this.shadowTB, this.getContentText().replace(reg, " "));



        /*} else
        this.shadowTB.value = this.getContentText();*/
    }

    function getShadowText() {
        return this.shadowTB.value;
    }

}




/*

=========================================================================
DIV Text Box ------------------------------------------------------------
=========================================================================


*/







function OldIETB(iframe) {
    this.iframe = iframe; //document.getElementById(iframe.id.substring(0, iframe.id.length-1) + "2"); //STRICT MODE HACK, USE NESTED DIVS OUTER ONE HAS NO PADDING
    this.ifDoc; 	//content window's document
    this.initialize = initialize;
    this.ifDocElement;
    this.setContent = setContent;
    this.getContent = getContent;
    this._onKeyPress = _onKeyPress;
    this._onPaste = _onPaste;
    this._onMouseDown = _onMouseDown;
    this._onContextMenu = _onContextMenu;
    this._onDoubleClick = _onDoubleClick;
    this.getSpanElements = getSpanElements;
    this.changeTo = changeTo;
    this.getAbsY = getAbsY;
    this.getAbsX = getAbsX;
    this.isStatic = true;
    this.createEditBox = createEditBox;
    this.getContentText = getContentText;
    this.containsElement = containsElement;
    this.getShadowText = getShadowText;
    this.updateShadow = updateShadow;
    this.multiline = true;
    this.spellChecker;
    this.OnCorrection = OnCorrection;
    this.getNumberOfErrors = getNumberOfErrors;
    this.getContentCleanHTML = getContentCleanHTML;
    this.targetIsPlain = true; 	//whether the 'shadow' holds plain text, or html
    this.unhook = unhook;
    this.resetCaretPos = unimplementedFunction;
    this.recordCaretPos = unimplementedFunction;

    function unimplementedFunction() { }

    function containsElement(element) {
        //look up parents to see if find this.iframe
        var p;
        if (element == this.iframe) return true;

        while ((p = element.parentNode)) {
            if (p == this.iframe)
                return true;
            element = p;
        }

        return false;
    }

    function getAbsX(element, ev) {

        if (typeof ev.pageX == 'number') { //Moz 1 & Net 6

            return ev.pageX - 15;

        } else if (document.documentElement && document.documentElement.scrollLeft) {
            //strict IE
            return (ev.clientX + document.documentElement.scrollLeft) - 15;
        } else if ((ev.x) && (ev.srcElement) && (!top.opera)) { //IE 4+

            return (ev.clientX + self.document.body.scrollLeft) - 15;

        } else { //Opera 5+
            return ev.clientX - 15;
        }

    }

    function getAbsY(element, ev) {

        if (typeof ev.pageY == 'number') {
            return ev.pageY - 15;
        } else if (document.documentElement && document.documentElement.scrollTop) {
            //strict IE
            return (ev.clientY + document.documentElement.scrollTop) - 15;
        } else if ((ev.y) && (ev.srcElement) && (!top.opera)) {
            return (ev.clientY + self.document.body.scrollTop) - 15;
        } else {
            return ev.clientY - 15;
        }
    }

    function changeTo(error, replacement) {
        var repl = document.createTextNode(replacement);
        error.parentNode.replaceChild(repl, error);
    }

    function findElementsCell(element) {
        var p = element;
        while ((p = p.parentNode) != null && p.tagName.toLowerCase() != "td") { }
        return p;
    }

    function createEditBox(error) {
        var width = error.offsetWidth;
        var repl = document.createElement("input");
        repl.setAttribute("value", rsw_innerHTMLToText(error.innerHTML));
        repl.setAttribute("class", "inlineTB");
        repl.onkeypress = rsw_inlineTB_onkeypress;


        repl.onblur = rsw_inlineTB_onBlur;
        repl.style.width = width * 1.8;
        error.parentNode.replaceChild(repl, error);




        //preserve scroll, for mozly
        var scrollTop = this.iframe.scrollTop;
        repl.focus();
        this.iframe.scrollTop = scrollTop;
    }


    function getSpanElements() {
        //return document.getElementsByTagName("span");
        return this.iframe.getElementsByTagName("span");
    }


    function _onKeyPress() {

        rsw_hideCM();
        rsw_broadcastToListeners("keypress");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("keypress", null, null);
    }

    function _onMouseDown() {

        rsw_hideCM();
        rsw_broadcastToListeners("mousedown");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("mousedown", null, null);
    }

    function _onDoubleClick() {
        rsw_getTBSHoldingElement(this).spellChecker.OnTextBoxDoubleClicked();

        rsw_broadcastToListeners("doubleclick");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("doubleclick", null, null);
    }

    function setContent(content) {
        //document.getElementById('qq').value+=(content);
        //content = escEntities(content); NOW PERFORMED SERVER SIDE
        //RICH EXP

        if (this.targetIsPlain) {
            var pos = -1;
            var ppos = 0;
            var t = "";
            while ((pos = content.indexOf("\n", pos + 1)) > -1) {
                if (pos > ppos + 2) {
                    if (content.substring(pos - 1, pos) == '\r')
                        t += "<P style='margin:0px;'>" + content.substring(ppos, pos - 1) + "</P>";
                    else
                        t += "<P style='margin:0px;'>" + content.substring(ppos, pos) + "</P>";
                } else
                    t += content.substring(ppos, pos) + "<br>"; //"<P style='margin:0px;'>&nbsp;</P>";
                ppos = pos;
            }

            if (ppos < content.length - 1)
                t += "<P style='margin:0px;'>" + content.substring(ppos, content.length) + "</P>";


            var flag = false;
            if (!this.multiline) {//dont allow word wrapping
                var pos = -1;
                var ppos = 0;
                var opener = -1;
                var closer = -1;
                while ((pos = t.indexOf(" ", pos + 1)) > -1) {
                    opener = t.lastIndexOf("<", pos);
                    closer = t.lastIndexOf(">", pos);
                    if ((opener == -1 && closer == -1) || opener == -1 || opener < closer)//not inside a tag, so change space
                        t = t.substring(0, pos) + "&nbsp;" + t.substring(pos + 1);
                    ppos = pos;
                }

                t = "<nobr>" + t + "</nobr>";
                /*} else {
                //t = "<pre wrap='wrap' class='RS_MultiLineTB' id='prewrap'>"+t+"</pre>";
                var pos=-1;
                var ppos=0;
                var opener=-1;
                var closer=-1;
                var flag=false;
                while( (pos=t.indexOf(" ", pos+1)) > -1){
                opener = t.lastIndexOf("<", pos);
                closer = t.lastIndexOf(">", pos);
                if((opener==-1 && closer==-1) || opener==-1 || opener<closer){//not inside a tag, so change space
                if(flag)
                t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);
                else
                t = t.substring(0, pos)+" " + t.substring(pos+1);
                flag=!flag;
                }
                ppos = pos;
                }
                }*/

            } else {
                var pos = -1;
                var ppos = 0;
                var opener = -1;
                var closer = -1;
                var flag = true;
                while ((pos = t.indexOf(" ", pos + 1)) > -1) {
                    if (pos + 1 < t.length && t.charAt(pos + 1) == ' ') {
                        opener = t.lastIndexOf("<", pos);
                        closer = t.lastIndexOf(">", pos);
                        if ((opener == -1 && closer == -1) || opener == -1 || opener < closer) {//not inside a tag, so change space
                            //					t = t.substring(0, pos)+"&nbsp;" + t.substring(pos+1);

                            if (flag)
                                t = t.substring(0, pos) + "&nbsp;" + t.substring(pos + 1);
                            else
                                t = t.substring(0, pos) + " " + t.substring(pos + 1);
                            flag = !flag;
                        }
                        ppos = pos;
                    }
                }
                //t = "<pre wrap='wrap' class='RS_MultiLineTB' id='prewrap'>"+t+"</pre>";
                //t = "<div  class='RS_MultiLineTB'>"+t+"</div>";
            }


            //tab => &#09;
            var tabexp = new RegExp("\t");
            while (tabexp.test(t))
                t = t.replace(tabexp, "<span class='tab'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>");



            this.iframe.innerHTML = t;
        } else
            this.iframe.innerHTML = content;


    }

    function getContent() {
        return this.iframe.innerHTML;
    }

    //returns the HTML content of the iframe, but without spell checker elements (such as underline spans
    //or input text boxes
    function getContentCleanHTML() {
        /*
        var content = this.getContent();
        alert(content);
        var spanexp = new RegExp("<span[^>]*class=rs_err_hl[^>]*>([^<]*)</span>", "i");
        while(spanexp.test(content))
        content = content.replace(spanexp, spanexp.exec(content)[1]);

        //var spanexp = new RegExp("<input[^>]*class=rs_err_hl[^>]*>([^<]*)</span>", "i");
        //while(spanexp.test(content))
        //	content = content.replace(spanexp, spanexp.exec(content)[1]);

        var nobrexp = new RegExp("<[/]?nobr>", "i");
        while(nobrexp.test(content))
        content = content.replace(nobrexp, "");

        var newlineexp = new RegExp("\n");
        while(newlineexp.test(content))
        content = content.replace(newlineexp, "");

        newlineexp = new RegExp("\r");
        while(newlineexp.test(content))
        content = content.replace(newlineexp, "");

        alert(content);
        return content;

        */

        //parse the DOM and pull the text

        rsw_processedNodes = new Array();

        var nodes = this.iframe.childNodes;
        var out = "";
        for (var i = 0; i < nodes.length; i++) {

            out += rsw_cleanHTML(nodes[i]);
        }
        return out;


    }

    function isNodeKnownToBeProcessed(node) {
        if (rsw_processedNodes == null || typeof (node.sourceIndex) == 'undefined') return false;

        for (var i = 0; i < rsw_processedNodes.length; i++) {
            if (node.sourceIndex == rsw_processedNodes[i]) return true;
        }
        return false;
    }

    var rsw_processedNodes = null;

    function rsw_cleanHTML(node) {
        var t = "";
        var styleInAttr = false;


        if (isNodeKnownToBeProcessed(node)) return t;
        if (rsw_processedNodes != null && typeof (node.sourceIndex) != 'undefined')
            rsw_processedNodes.push(node.sourceIndex);

        if (node.nodeName.toLowerCase() != "#text" && node.nodeName.toLowerCase() != "input"
			&& !(node.nodeName.toLowerCase() == "span" && node.className == 'rs_err_hl')
			) {


            t += "<" + node.nodeName + " "; //+">";

            for (var att = 0; node.attributes!=null && att < node.attributes.length; att++) {
                //			document.getElementById('qq').value+=(node.attributes[att].nodeName+" "+node.attributes[att].nodeValue);
                if (node.attributes[att].nodeValue) {
                    styleInAttr = styleInAttr || node.attributes[att].nodeName.toLowerCase() == "style";
                    t += node.attributes[att].nodeName + "=\"" + node.attributes[att].nodeValue + "\" ";
                }
            }
            //alert(node.style);
            if (typeof (node.style) != 'undefined' && !styleInAttr) {
                t += "style=\"";
                t += node.style.cssText;
                t += "\" ";
            }



            if (node.childNodes.length == 0 && !node.nodeValue)
                t += "/";
            t += ">";
            //document.getElementById('qq').value+=t;
        }


        if (node.childNodes.length == 0) {

            if (node.nodeValue) {

                t += node.nodeValue.replace("<", "&lt;").replace(">", "&gt;");
            }

            if (node.value) {

                t += node.value.replace("<", "&lt;").replace(">", "&gt;");
                //	t += node.value;
            }

        } else {
            for (var i = 0; i < node.childNodes.length; i++)
                t += rsw_cleanHTML(node.childNodes[i]);

        }

        if (node.nodeName.toLowerCase() != "#text" && node.nodeName.toLowerCase() != "input"
			&& !(node.nodeName.toLowerCase() == "span" && node.className == 'rs_err_hl')
			&& !(node.childNodes.length == 0 && !node.nodeValue)
			)
            t += "</" + node.nodeName + ">";

        return t;
    }



    /* specialist*/
    function getContentText() {

        //parse the DOM and pull the text
        var contentElements = this.iframe.childNodes;
        var contents = "";

/*

        for (var i = 0; i < contentElements.length; i++) {

            //if(contentElements[i].innerHTML)

            //contents += contentElements[i].innerHTML;
            if (contentElements[i].nodeValue) {

                contents += contentElements[i].nodeValue;
            }
            else if (contentElements[i].nodeName.toLowerCase() == "br")
                contents += "\r\n";
            else if (contentElements[i].nodeName.toLowerCase() == "input") {
                contents += contentElements[i].value;

            }
            else {
                contents += rsw_innerText(contentElements[i]);

            }

        }
        */
        for (var i = 0; i < contentElements.length; i++) {
            if (contentElements[i].nodeValue)//this isnt required and screws up sometimes it seems
                contents += contentElements[i].nodeValue;
            else if (contentElements[i].nodeName.toLowerCase() == "br" && i < contentElements.length - 1)//browser always gives us a trailing newline, even when there isnt one in the 'text'
                contents += "\r\n";
            else if (contentElements[i].nodeName.toLowerCase() == "input")
                contents += contentElements[i].value;
            else //if (contentElements[i].nodeName.toLowerCase()!="p" || i < contentElements.length-1)
                contents += rsw_innerText(contentElements[i],
						i == contentElements.length - 1, contentElements[contentElements.length - 1].nodeName.toLowerCase() == "br"); //br doesnt count as last element in collection
        }
        //var newlineexp = new RegExp("\n");


        var t = contents;
        while (rsw_newlineexp.test(t))
            t = t.replace(rsw_newlineexp, "");
        contents = t;




        return contents;

    }


    //---unique functions

    function _onContextMenu() {

        rsw_broadcastToListeners("contextmenu");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("contextmenu", null, null);
        return false;
    }

    function _onPaste() {
        rsw_broadcastToListeners("paste");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("paste", null, null);
    }

    function getShadowText() {
        return this.shadowTB.value;
    }


    function updateShadow() {
        if (this.targetIsPlain)
            this.spellChecker.tbInterface.setText(this.getContentText());
        else
            this.spellChecker.tbInterface.setText(this.getContentCleanHTML());

    }

    function initialize() {

        this.iframe.onmousedown = this._onMouseDown;
        this.iframe.ondblclick = this._onDoubleClick;



        var ifID = this.iframe.id;
        this.shadowTBID = ifID.substring(0, ifID.length - 2); //we need to have a separate copy of the ID, since it the
        //shadow is display:none to begin with, we wont get it from getElementById
        this.shadowTB = document.getElementById(this.shadowTBID);

        //Not done with static TB rsw_setSettings(this);
    }

    function unhook() {
        this.iframe.onmousedown = null;
        this.iframe.ondblclick = null;
    }

    function OnCorrection(e) {
        if (this.getNumberOfErrors() == 0) {
            if (this.spellChecker.enterEditModeWhenNoErrors) {
                this.spellChecker.OnSpellButtonClicked(true);
            }
        }
        rsw_broadcastToListeners("correction");
        if (typeof (rsw_broadcastEvent) == 'function') rsw_broadcastEvent("ayt_correction", null, e);
    }

    function getNumberOfErrors() {
        var errors = this.getSpanElements();
        var numErrors = 0;
        for (var i = 0; i < errors.length; i++) {
            if (errors[i].className == 'rs_err_hl') {
                numErrors++;
            }
        }
        return numErrors;
    }

}



//---Old TB helpers

function rsw_getElementHeight(Elem) {
    var op5 = (navigator.userAgent.indexOf("Opera 5") != -1)
		|| (navigator.userAgent.indexOf("Opera/5") != -1);


    if (document.layers) {
        var elem = rsw_getObjNN4(document, Elem);
        return elem.clip.height;
    } else {
        if (document.getElementById) {
            var elem = document.getElementById(Elem);
        } else if (document.all) {
            var elem = document.all[Elem];
        }
        if (op5) {
            xPos = elem.style.pixelHeight;
        } else {
            xPos = elem.offsetHeight;

        }
        return xPos;
    }
}
function rsw_getObjNN4(obj, name) {
    var x = obj.layers;
    var foundLayer;
    for (var i = 0; i < x.length; i++) {
        if (x[i].id == name)
            foundLayer = x[i];
        else if (x[i].layers.length)
            var tmp = rsw_getObjNN4(x[i], name);
        if (tmp) foundLayer = tmp;
    }
    return foundLayer;
}

function rsw_getElementWidth(Elem) {
    var op5 = (navigator.userAgent.indexOf("Opera 5") != -1)
		|| (navigator.userAgent.indexOf("Opera/5") != -1);

    if (document.layers) {
        var elem = rsw_getObjNN4(document, Elem);
        return elem.clip.width;
    } else {
        if (document.getElementById) {
            var elem = document.getElementById(Elem);
        } else if (document.all) {
            var elem = document.all[Elem];
        }
        if (op5) {
            xPos = elem.style.pixelWidth;
        } else {
            xPos = elem.offsetWidth;

        }
        return xPos;
    }
}

function rsw_findPosX(obj) {
    var curleft = 0;
    /*alert(obj.clientLeft);
    if(obj.clientLeft)
    curleft += obj.clientLeft;	*/
    if (typeof (obj.offsetParent) != 'undefined' && obj.offsetParent)//this if is probably not redundent because if also detects if member exists
    {
        while (obj.offsetParent) {
            curleft += obj.offsetLeft;
            //alert(curleft);
            obj = obj.offsetParent;
        }
        curleft += obj.offsetLeft;
    }
    else if (obj.x)
        curleft += obj.x;




    return curleft;

    //fails with tables return obj.offsetLeft;
    /*
    var curLeft = 0;
    var index = 0;
    if (obj.offsetParent)
    {
    while (obj.offsetParent)
    {
    index++;
    var delta=0;
    if (!window.opera && index>1)
    delta = obj.scrollLeft ;

    curLeft += obj.offsetLeft - delta;
    obj = obj.offsetParent;
    }
    }
    else if (obj.clientY)
    curLeft += obj.clientY;

    return curLeft;// + element.offsetLeft - this.ifDoc.body.scrollLeft;
    */
}

function rsw_findPosY(obj) {
    var curtop = 0;
    /*if(obj.clientTop)
    curtop += obj.clientTop;	*/
    if (typeof (obj.offsetParent) != 'undefined' && obj.offsetParent) {
        while (obj.offsetParent) {
            curtop += obj.offsetTop;
            obj = obj.offsetParent;
        }
        curtop += obj.offsetTop;
        //alert('a'+curtop);
    }
    else if (obj.y)
        curtop += obj.y;


    return curtop;

    /*
    var curtop = 0;
    var index = 0;
    if (obj.offsetParent)
    {
    while (obj.offsetParent)
    {
    index++;
    var delta=0;
    if (!window.opera && index>1)
    delta = obj.scrollTop ;

    curtop += obj.offsetTop - delta;
    obj = obj.offsetParent;
    }
    }
    else if (obj.clientY)
    curtop += obj.clientY;

    return curtop;// + element.offsetTop - this.ifDoc.body.scrollTop;
    */
    //fails with table		return obj.offsetTop;

}
//--end helpers




////------------------------------------------------------------------------------------------------------------------




function rsw_decodeSuggestionItem(item) {
    return unescape(item).replace("^apos^", "'").replace("^qt^", "\"");
}


function RS_ContextMenu(errorElement, suggestions, textBox) {
    this.suggestions = suggestions;
    this.CMItems = new Array();
    this.x = 0;
    this.y = 0;
    this.CMelement = null;
    this.textBox = textBox;
    this.show = show;
    this.setCMContent = setCMContent;
    this.hide = hide;
    this.setVisible = setVisible;
    this.moveCMElement = moveCMElement;
    this.getContentHtml = getContentHtml;
    this.addItems = addItems;
    this.addItems();

    function addItems() {
        //filter out suggestions that would make the text too long
        var newSuggs = new Array();
        var errorLength = errorElement.textContent ? errorElement.textContent.length : errorElement.innerText.length;
        for (var i = 0; i < this.suggestions.length; i++) {
            if (this.suggestions[i].indexOf('#') == 0 || this.textBox.maxlength == 0 || typeof(this.textBox.maxlength)=='undefined' || rsw_decodeSuggestionItem(this.suggestions[i]).length - errorLength + this.textBox.getContentText().length <= this.textBox.maxlength)
                newSuggs[newSuggs.length] = this.suggestions[i];
        }
        this.suggestions = newSuggs;

        //add suggestion items                
        var isDuplicateWordErr = false;
        for (i = 0; i < this.suggestions.length; i++) {
            if (this.suggestions[i].indexOf('#') < 0) {
                this.CMItems[this.CMItems.length] = new RS_ContextMenuItem(errorElement,
                //unescape(this.suggestions[i]).replace("^apos^", "'").replace("^qt^", "\""),
					rsw_decodeSuggestionItem(this.suggestions[i]),
					escape(this.suggestions[i]),
					"change"
				);
                if (this.textBox.spellChecker.showChangeAllItem) {
                    this.CMItems[this.CMItems.length] = new RS_ContextMenuItem(errorElement,
						unescape(this.textBox.spellChecker.changeAllText),
						escape(this.suggestions[i]),
						"changeall", "subitem"
					);
                }
            } else {
                this.CMItems[this.CMItems.length] = new RS_ContextMenuItem(errorElement,
					this.textBox.spellChecker.removeDuplicateText,
					escape(this.suggestions[i].substring(1)),
					"remove duplicate"
				);
                isDuplicateWordErr = true;
            }

        }

        if (this.suggestions.length == 0) {
            this.CMItems[0] = new RS_ContextMenuItem(errorElement,
					this.textBox.spellChecker.noSuggestionsText,
					"No suggestions",
					"no_suggestions"
				);

            i = 1;
        } else {
            i = this.CMItems.length;
        }


        if (!isDuplicateWordErr || this.textBox.isStatic) {
            this.CMItems[i] = new RS_ContextMenuItem(errorElement,
				"-",
				"-",
				"-"
			);
        }


        if (this.textBox.isStatic) {
            if (this.textBox.spellChecker.showEditMenuItem) {
                this.CMItems[i + 1] = new RS_ContextMenuItem(errorElement, this.textBox.spellChecker.editText,
					"Edit...",
					"edit"
				);

                i++;
            }
        }

        if (!isDuplicateWordErr) {
            if (this.textBox.spellChecker.showIgnoreAllMenuItem) {
                this.CMItems[i + 1] = new RS_ContextMenuItem(errorElement,
				this.textBox.spellChecker.ignoreAllText,
				"Ignore All",
				"ignore_all"
			    );
            } else i--;//because we're going to +2 below

            if (this.textBox.spellChecker.showAddMenuItem) {
                this.CMItems[i + 2] = new RS_ContextMenuItem(errorElement,
					this.textBox.spellChecker.addText,
					"Add",
					"add"
				);
            }
        }

        if (document.getElementById("RS_CM_DIV") == null)//sometimes under AJAX the menu DIV isnt picked up properly.
            rsw_create_menu_div();

        this.CMelement = document.getElementById("RS_CM_DIV");
        this.CMIFelement = document.getElementById("RS_CM_IF");



        this.setVisible(false);
    }



    function show() {
        if (typeof(this.textBox.enabled)!='undefined' && !this.textBox.enabled) return;
        
        this.setVisible(true);
        this.moveCMElement();
        this.setCMContent(this.getContentHtml());
        if (typeof (rsw_useIFrameMenuBacker) == 'undefined' || rsw_useIFrameMenuBacker) {
            //IFRAME MENU
            if (navigator.userAgent.toLowerCase().indexOf("msie") > -1 && !rsw_isMac) {//avoid shine through issue
                this.CMIFelement.style.left = this.x + "px";
                this.CMIFelement.style.top = this.y + "px";
                this.CMIFelement.style.height = (rsw_getElementHeight("RS_CM_DIV") - 4) + "px"; //4 is shadow width
                this.CMIFelement.style.width = (rsw_getElementWidth("RS_CM_DIV") - 4) + "px";
            }
        }

        //*/
    }

    function hide() {
        this.setVisible(false);

        this.CMelement.innerHtml = "";
    }

    function setCMContent(s) {
        this.CMelement.innerHTML = s;


    }




    function setVisible(visible) {
        this.CMelement.style.visibility = visible ? 'visible' : 'hidden';

        /* IFRAME MENU		*/
        if (typeof (rsw_useIFrameMenuBacker) == 'undefined' || rsw_useIFrameMenuBacker) {
            if (navigator.userAgent.toLowerCase().indexOf("msie") > -1 && !rsw_isMac) {
                this.CMIFelement.style.visibility = visible ? 'visible' : 'hidden';
                this.CMIFelement.style.display = visible ? 'block' : 'none';
            }
            //*/
        }
        this.isVisible = visible;
    }

    function moveCMElement() {

        this.CMelement.style.left = this.x + "px";
        this.CMelement.style.top = this.y + "px";
        if (typeof (rsw_useIFrameMenuBacker) == 'undefined' || rsw_useIFrameMenuBacker) {
            /* IFRAME MENU*/
            if (navigator.userAgent.toLowerCase().indexOf("msie") > -1 && !rsw_isMac) {
                this.CMIFelement.style.left = this.x + "px";
                this.CMIFelement.style.top = this.y + "px";
            }
        }
        //*/
    }

    function getContentHtml() {
        var s = "<table class=\"" + RS_ContextMenuTable_Class + "\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">";
        var hasSubMenu = false;
        for (var i = 0; i < this.CMItems.length; i++) {
            hasSubMenu = i < this.CMItems.length - 1 && this.CMItems[i + 1].type == 'subitem';
            s += "<tr><td width='100%' " + (hasSubMenu ? "colspan='1'" : "colspan='2'") + ">";
            s += this.CMItems[i].getContentHtml();
            s += "</td>";

            if (hasSubMenu) {
                i++;
                s += "<td>" +
						this.CMItems[i].getContentHtml()
						+ "</td>";
            }
            s += "</tr>";
        }
        s += "</table>";
        return s;
    }
}




function RS_ContextMenuItem(e, unescapedValue, escapedValue, action, type) {
    this.unescapedValue = unescapedValue;
    this.escapedValue = escapedValue;
    this.action = action;
    this.getContentHtml = getContentHtml;
    this.type = type ? type : "standard";

    function getContentHtml() {


        var s;
        if (this.unescapedValue != '-' && this.action != "no_suggestions") {
            s = "<span class=\"" +
					(this.type == "standard" ?
						RS_ContextMenuItem_Class :
						RS_ContextMenuItem_AllSubItem_Class
					)
					+ "\" "
					+ " onclick=\"RS_CMItemClicked( '" + this.escapedValue + "', '" + this.action + "') ;\""
					+ " onMouseOut=\" RS_CMItemHighlight(this, 'out');\" "
					+ " onMouseOver=\"RS_CMItemHighlight(this, 'over'); \" "
					+ ">" + this.unescapedValue + "</span>";




        } else if (this.action == "no_suggestions") {
            s = "<span class=\"" + RS_ContextMenuItem_Disabled_Class + "\" "
					+ ">" + this.unescapedValue + "</span>";

        } else {
            s = "<hr class=\"" + RS_CMItemSeparator_Class + "\"/>";
        }
        return s;
    }
}





function RS_CMItemHighlight(e, type) {
    var p = e.className.indexOf("_Over");
    if (type == "out") {
        if (p > 0) e.className = e.className.substring(0, p);
    } else {
        if (p == -1) e.className = e.className + "_Over";
    }

}



function RS_CMItemClicked(replacement, action) {
    var yScroll = null;
    if (typeof(rsw_activeTextbox.iframe.contentWindow) != 'undefined')
        yScroll = rsw_getScrollY(rsw_activeTextbox.iframe.contentWindow);

    replacement = unescape(replacement).replace("^apos^", "'").replace("^qt^", "\"");
    if (action == 'ignore_all') {
        rsw_ignoreAll(rsw_lastRightClickedError);
    } else if (action == 'edit') {
        rsw_edit(rsw_lastRightClickedError);
    } else if (action == 'add') {
        rsw_add(rsw_lastRightClickedError);
    } else if (action == 'remove duplicate') {
        rsw_changeTo(rsw_lastRightClickedError, "");
    } else if (action == 'changeall') {
        rsw_changeAllTo(rsw_lastRightClickedError, replacement);
    } else {
        rsw_changeTo(rsw_lastRightClickedError, replacement);
    }

    rsw_hideCM();
    //scrolling issue - after choosing an item, the focus is out of the TB, so if you choose another it scrolls to top.
    if (rsw_activeTextbox.focus && !rsw_activeTextbox.isFocused) {
        //var caret = rsw_activeTextbox.ifDoc.selection.createRange();
        //caret.moveToPoint(1, 300);




        rsw_activeTextbox.focus();

        if (rsw_activeTextbox.resetCaretPos)
            rsw_activeTextbox.resetCaretPos();

        if(yScroll!=null)
            rsw_setScrollY(rsw_activeTextbox.iframe.contentWindow, yScroll);


        //rsw_activeTextbox.iframe.scrollIntoView(rsw_lastRightClickedError);
        //rsw_activeTextbox.iframe.scrollTop = 300;
    }

}

function rsw_hideCM() {


    if (rsw_contextMenu) {

        rsw_contextMenu.hide();

    }
}

/* Moved to rswinlne*/
function rsw_create_menu_div() {

    //document.writeln('<div id="RS_CM_DIV" ></div>');

    var divElement = document.createElement('DIV');
    divElement.id = 'RS_CM_DIV';
    divElement.setAttribute("oncontextmenu", "try{event.cancelBubble=true;event.preventDefault();}catch(e){}return false;");
    try {
        divElement.oncontextmenu = function () { try { event.cancelBubble = true; event.preventDefault(); } catch (e) { } return false; };
    } catch (e) { }
    document.getElementsByTagName('body')[0].appendChild(divElement);


    //IFRAME MENU
    if (navigator.userAgent.toLowerCase().indexOf("msie") > -1) {
        //document.writeln('<iframe id="RS_CM_IF" src="javascript: false;"  scrolling="no"  frameborder="0"  style="position:absolute; top:0px; left:0px; display:none;"></iframe>');
        var ifElement = document.createElement('IFRAME');
        ifElement.id = 'RS_CM_IF';
        ifElement.setAttribute("src", "javascript: false;");
        ifElement.setAttribute("scrolling", "no");
        ifElement.setAttribute("frameborder", "0");
        ifElement.setAttribute("style", "position:absolute; top:0px; left:0px; display:none;");
        document.getElementsByTagName('body')[0].appendChild(ifElement);
    }
    //
}


//--------------------------------- AS YOU TYPE CLASS ---------------------------------------------------------------------------
var rsw_ayt_initializing = false;
function RapidSpell_Web_AsYouType() {


    this.triggeredLast = false;
    this.checkerCurrentlyInitializing = 0;
    this.onTextBoxesInit = onTextBoxesInit;
    this.checkNext = checkNext;
    this.onFinish = onFinish;
    this.onPause = onPause;
    this.checkAsYouTypeOnPageLoad = true;
    this.stop = stop;
    this.start = start;
    this.stopped = false;

    function start() {
        this.stopped = false;
    }
    function stop() {
        this.stopped = true;
    }

    function onPause() {
        //store the caret position
        //if(!rsw_ayt_initializing){
        //DONE BY SPELLCHECKER NOW rsw_activeTextbox.recordCaretPos();
        //}
        //run the spell check
        //if(rsw_activeTextbox && rsw_activeTextbox.spellChecker)
        if (!this.stopped && typeof (rsw_activeTextbox) != 'undefined' && rsw_activeTextbox != null && rsw_activeTextbox.spellChecker != null) {
            rsw_activeTextbox.updateShadow();
            rsw_activeTextbox.spellChecker.OnSpellButtonClicked();
        }
    }


    function onTextBoxesInit() {
        //run check when page loads

        rsw_ayt_initializing = true;
        rsw_ayt_check = true;
        this.checkNext();
    }

    //spell checks the next text box, and returns if there are more to check
    function checkNext() {
        if (rsw_haltProcesses || !rsw_ayt_enabled || this.stopped) { rsw_ayt_initializing = false; this.checkerCurrentlyInitializing++; this.onFinish(); }
        if (rsw_scs.length > this.checkerCurrentlyInitializing) {
            var tbs = rsw_scs[this.checkerCurrentlyInitializing].getTBS();
            if (tbs != null && (tbs.isStatic || !tbs.isVisible())) {//skip
                this.checkerCurrentlyInitializing++;
                this.onFinish();
            } else if (tbs!=null){
                if (this.checkAsYouTypeOnPageLoad)
                    rsw_scs[this.checkerCurrentlyInitializing].OnSpellButtonClicked();

                this.checkerCurrentlyInitializing++;

                if (!this.checkAsYouTypeOnPageLoad)
                    this.onFinish();

                tbs.isAYT = true;
            }
        }
        return this.checkerCurrentlyInitializing < rsw_scs.length;
    }

    function onFinish() {
        //alert('d2');
        //place caret back where it was when spell check started
        if (!rsw_ayt_initializing) {
            //DONE BY SPELLCHECKER NOW 	rsw_activeTextbox.resetCaretPos();
            //alert('d');
        }

        if (rsw_ayt_initializing && this.triggeredLast) {//when this func is called after triggering the last, we unset initializing
            rsw_ayt_initializing = false;
            //**J not a nice soln rsw_activeTextbox.focus();//this doesnt seem important, but in IE the last TB can be hard to enter, otherwise

            //<input type=text id=f1 style="width:0px; height:0px;">
            //if(this.triggeredLast)
            //	document.getElementById('rsw_focus_targ').focus();//force focus away from last textbox


            if (typeof (_notifySpellCheckListeners) != 'undefined')
                _notifySpellCheckListeners('ayt_finished_initializing');
        }

        if (rsw_ayt_initializing) {
            //set triggeredLast when there are no more
            this.triggeredLast = !this.checkNext();

        }

    }
}


//---- Differencing code=========
String.prototype.rsw_reverse = function () { return this.split('').reverse().join(''); };

function RSW_Diff(p, v, a) {
    this.position = p;
    this.vector = v;
    this.addedText = a;
}



function RSW_VisibleCharSeq(str) {
    this.str = str;
    this.length = str.length;
    this.allVisible = false;
    this.reverse = reverse;
    this.isReversed = false;
    function reverse() {
        this.str = this.str.rsw_reverse();
        this.isReversed = !this.isReversed;
    }

    this.insertAtVisible = insertAtVisible;
    function insertAtVisible(addition, pos) {
        return this.visibleSubstring(0, pos) + addition + this.visibleSubstring(pos, this.visibleLength());
    }

    this.toString = toString;
    function toString() {
        return this.str;
    }

    this.visibleSubstring = visibleSubstring;
    function visibleSubstring(start, end) {

        var visiChars = 0;
        var inTag = false;
        var inEnt = false;
        var sub = "";
        var includeTags = true;
        var tagOpen = this.isReversed ? ">" : "<";
        var tagClose = this.isReversed ? "<" : ">";
        var entOpen = this.isReversed ? ";" : "&";
        var entClose = this.isReversed ? "&" : ";";

        for (var i = 0; i < this.str.length; i++) {

            //we want all chars once we've gobbled enough visible chars, so as to include tags around our change
            //	if(includeTags && visiChars>=start && visiChars<end) sub += this.str.charAt(i);


            if (this.str.charAt(i) == tagOpen && !inTag && !this.allVisible) inTag = true;
            if (this.str.charAt(i) == entOpen && !inTag && !inEnt && !this.allVisible) {
                var closer = this.str.indexOf(entClose, i);
                if (closer > -1 && closer - i < 9) {
                    inEnt = true;
                    if (visiChars >= start && visiChars < end) {
                        //sub += this.str.charAt(i);
                        var entity = this.str.substring(i, closer);
                        if (entity == "&amp") sub += "&";
                        if (entity == "&nbsp") sub += " ";
                        if (entity == "&lt") sub += "<";
                        if (entity == "&gt") sub += ">";
                    }
                    visiChars++;
                }
            }

            if (includeTags && inTag && visiChars >= start && visiChars <= end) sub += this.str.charAt(i);

            if (!inTag && !inEnt) {
                //if we dont want tags around the substring
                if ( /*!includeTags &&*/
				visiChars >= start && visiChars < end) sub += this.str.charAt(i);
                visiChars++;
            }

            if (this.str.charAt(i) == tagClose && inTag) inTag = false;
            if (this.str.charAt(i) == entClose && inEnt) inEnt = false;
        }
        return sub;
    }

    this.lastDiffI = 0;
    this.lastDiffPos = 0;

    this.visibleCharAt = visibleCharAt;
    function visibleCharAt(pos) {
        //return str.charAt(pos);
        //get the 'pos'th visible char
        //eg. str="<blah>i", pos=0 : return = i
        var startI = 0;
        var visiChars = 0;
        var tagOpen = this.isReversed ? ">" : "<";
        var tagClose = this.isReversed ? "<" : ">";
        var entOpen = this.isReversed ? ";" : "&";
        var entClose = this.isReversed ? "&" : ";";
        var entityChar;
        if (pos > this.lastDiffPos)//go from where we were
        {
            startI = this.lastDiffI;
            visiChars = this.lastDiffPos;
        }



        var inTag = false;
        var inEnt = false;
        for (var i = startI; i < this.str.length; i++) {
            if (this.str.charAt(i) == tagOpen && !inTag && !this.allVisible) inTag = true;
            if (this.str.charAt(i) == entOpen && !inTag && !inEnt && !this.allVisible) {
                var closer = this.str.indexOf(entClose, i);
                if (closer > -1 && closer - i < 9) {
                    inEnt = true;

                    var entity = this.str.substring(i, closer);
                    if (entity == "&amp") entityChar = "&";
                    if (entity == "&nbsp") entityChar = " ";
                    if (entity == "&lt") entityChar = "<";
                    if (entity == "&gt") entityChar = ">";

                    if (visiChars == pos) return entityChar;
                    visiChars++;
                }
            }


            if (!inTag && !inEnt) {
                if (visiChars == pos) {
                    this.lastDiffI = i;
                    this.lastDiffPos = visiChars;

                    if (this.str.charAt(i) == String.fromCharCode(160))//we dont want nbsp to be treated differently to space
                        return ' ';

                    if (this.str.charAt(i) == '\r')//we dont want \r to be treated differently to \n
                        return '\n';




                    return this.str.charAt(i);
                }

                //if(!inEnt)//ents are counted once, when they first occur, not for each char inside
                visiChars++;
            }



            if (this.str.charAt(i) == tagClose && inTag) inTag = false;
            if (this.str.charAt(i) == entClose && inEnt) inEnt = false;
        }
    }

    this.visibleLength = visibleLength;
    function visibleLength() {
        //THIS METHOD FAILS WHEN reverse has been applied
        //if(this.isReversed)alert('cant work with reversed');

        //get number of visible chars
        var visiChars = 0;
        var inTag = false;
        var inEnt = false;

        for (var i = 0; i < this.str.length; i++) {
            if (this.str.charAt(i) == '<' && !inTag && !this.allVisible) inTag = true;
            if (this.str.charAt(i) == '&' && !inTag && !inEnt && !this.allVisible) {
                //dont want a closer too far away, incase its not really an entity
                var closer = this.str.indexOf(';', i);
                if (closer > -1 && closer - i < 9) {
                    inEnt = true;
                    visiChars++; //count one for an entity
                }
            }

            if (!inTag && !inEnt) {
                visiChars++;
            }

            if (this.str.charAt(i) == '>' && inTag) inTag = false;
            if (this.str.charAt(i) == ';' && inEnt) inEnt = false;
        }
        return visiChars;
    }


}

function RSW_diff(beforeS, afterS) {
    var cs = -1;
    var ce = -1;
    var scanLength = 0;
    var before = new RSW_VisibleCharSeq(beforeS);

    //since after is not escaped HTML
    var after = new RSW_VisibleCharSeq(afterS);
    after.allVisible = true;

    var beforeVisiLen = before.visibleLength();
    var afterVisiLen = after.visibleLength();

    for (var i = 0; i < beforeVisiLen && cs < 0; i++)
        if (!(i >= afterVisiLen || after.visibleCharAt(i) == before.visibleCharAt(i))) cs = i;
    //if (!(i>=afterVisiLen || afterS.charAt(i)==before.visibleCharAt(i))) cs=i;


    if (cs == -1 && afterVisiLen != beforeVisiLen) cs = beforeVisiLen;

    //cs is now positioned where the change occurs

    //work backwards now
    after.reverse();
    //afterS = afterS.rsw_reverse();
    before.reverse();

    //for(var i=0; i<afterVisiLen && ce<0; i++)
    //	if (!(i>=beforeVisiLen || after.visibleCharAt(i)==before.visibleCharAt(i))) ce=(afterVisiLen-i);

    //i>=(beforeVisiLen-cs) means we dont want to go past where the change starts, v. important w/ duplicate chars
    for (var i = 0; i < afterVisiLen && ce < 0; i++)
    //if (i>=(beforeVisiLen-cs) || !(i>=beforeVisiLen || afterS.charAt(i)==before.visibleCharAt(i))) ce=(afterVisiLen-i);
        if (i >= (beforeVisiLen - cs) || !(i >= beforeVisiLen || after.visibleCharAt(i) == before.visibleCharAt(i))) ce = (afterVisiLen - i);

    if (ce == -1) ce = afterVisiLen;

    var vector = ce - cs;

    if (vector == 0)//chars may have been deleted
        vector = afterVisiLen - beforeVisiLen;


    after.reverse(); //put it back right order
    //afterS = afterS.rsw_reverse();

    //where in the after text the change is and how many chars are different
    //note that displacement of change is
    //after.length - before.length
    //return new RSW_Diff(cs, vector, afterS.substring(cs, ce));
    return new RSW_Diff(cs, vector, after.visibleSubstring(cs, ce));
}
//---- Differencing code=========


//--------------------------------- AS YOU TYPE CLASS ---------------------------------------------------------------------------


//___________________AUTO FINDER CLASS Update copy in launcher!!!!!!!!!!!!!!!!!!!!!!!!!!
function RSW_EditableElementFinder() {
    this.findPlainTargetElement = findPlainTargetElement;
    this.findRichTargetElements = findRichTargetElements;
    this.obtainElementWithInnerHTML = obtainElementWithInnerHTML;
    this.findEditableElements = findEditableElements;
    this.elementIsEditable = elementIsEditable;
    this.getEditableContentDocument = getEditableContentDocument;

    function findPlainTargetElement(elementID) {
        var rsw_elected = document.getElementById(elementID);

        if (rsw_elected != null && rsw_elected.tagName &&
				(rsw_elected.tagName.toUpperCase() == "TEXTAREA" || rsw_elected.tagName.toUpperCase() == "INPUT")) {
            return rsw_elected;
        } else
            return null;
    }

    function findRichTargetElements(debugTextBox) {
        //look for any editable elements in the document, with IDs containing elementID
        var editables = new Array();
        this.findEditableElements(document, editables, window, "", debugTextBox);
        return editables;
    }

    function obtainElementWithInnerHTML(editable) {
        //in mozly the document can be designMode, but its the documentElement with the innerHTML
        //in IE anything can be contenteditable, and may also have innerHTML
        if (typeof (editable.innerHTML) != 'undefined') return editable;
        else
            if (typeof (editable.documentElement) != 'undefined')
                return editable.documentElement;

        return null;
    }


    function findEditableElements(node, editables, parent, debugInset, debugTextBox) {
        //var tout = document.getElementById('qq');
        var children = node.childNodes;
        var editableElement;

        //if(debugTextBox)
        //	debugTextBox.value += debugInset + node.tagName +" NODEid=" + node.id+" ";

        if ((editableElement = this.elementIsEditable(node)) != null ||
					(editableElement = this.getEditableContentDocument(node, debugTextBox)) != null
				) {
            //	if(debugTextBox)
            //		debugTextBox.value += " EDITABLE id="+editableElement[0].id+"/"+editableElement[1].id+" ";
            editables[editables.length] = editableElement;
        }

        //if(debugTextBox)
        //		debugTextBox.value += "\r\n";

        for (var i = 0; i < children.length; i++) {
            this.findEditableElements(children[i], editables, node, debugInset + " ", debugTextBox);
        }

    }

    function elementIsEditable(element) {
        if (
					(
						typeof (element.getAttribute) != 'undefined' &&
						(
						element.getAttribute('contentEditable') == "true" ||
						element.getAttribute('designMode') == "on"
						)
					)
					||
					(
						(element.contentEditable && element.contentEditable == true) ||
						(element.designMode && element.designMode.toLowerCase() == "on")
					)
        /*||
        (	//it seems possible (with RTB.com at least) that the documentElement is contentEditable='inherit' and isContentEditable=true, unsure where editabilty came from
        (element.isContentEditable && element.isContentEditable==true)
        )*/

				)
            return [element, element]; //the element is editable
        else return null;
    }

    function getEditableContentDocument(element, debugTextBox) {
        if (element.tagName && element.tagName == "IFRAME") {
            var kids = new Array();
            if (element.contentWindow && element.contentWindow.document) {

                //if(debugTextBox)debugTextBox.value += " -- has contentWindow.document ";

                this.findEditableElements(element.contentWindow.document, kids, element, "*", debugTextBox);


                if (kids.length > 0) {//only expecting one editable in an iframe
                    var editable = kids[0][0];
                    if (typeof (editable.body) != 'undefined')
                        editable = editable.body;
                    return [editable, element]; //kids[0][0] is editable, but its held in element (iframe)
                }
            }
        }
        return null;
    }
}
//___________________AUTO FINDER CLASS





//-----------------------------------------------------------------ASP.NET AJAX
var rsw_require_init = true;
function rsw_ASPNETAJAX_OnInitializeRequest(sender, eventArgs) {
    //	rsw__unhook();
    rsw_cancelCall = true;
    rsw_haltProcesses = true;
    rsw_require_init = true;

    //check each SpellChecker to see if its overlayed, if it is, we need to switch to back to edit mode
    for (var i = 0; i < rsw_scs.length; i++) {
        if (rsw_scs[i].state == "overlay") {//swtich
            //rsw_scs[i].OnSpellButtonClicked(true);
            rsw_scs[i].rsw_tbs.updateShadow();
            rsw_scs[i].rsw_tbs.iframe.style.display = "none";
        }
        rsw_scs[i].rsw_tbs = null;
    }
    rsw_tbs = new Array();
    //rsw_scs = new Array(); //added for tic 2012052375000017
    //sometimes we need to clear out because the rsw_configs may be readded
    //but other times its damaging - instead, lets make it so that we only add if not already known.
    //rsw_config = new Array();

}

function rsw_ASPNETAJAX_OnEndRequest(sender, eventArgs) {
    rsw_haltProcesses = false;
    ///link in the menu CSS sheet, incase not already linked.
    rsw_createLink(document, rsw_rs_menu_styleURL);
    rsw_createLink(document, rsw_rs_styleURL);

    if (typeof (attachInitHandler) != 'undefined')
        attachInitHandler();

    if (rsw_require_init) {
        //rsw__init();
        if (typeof (rsw_autoCallRSWInit) == 'undefined' || rsw_autoCallRSWInit)
            setTimeout('rsw__init(true)', 200);
    }

    rsw_require_init = false;


}






//---Tell Ajax it loaded OK

//similar code is initialized in rswinline ctrl
//-------------------------





/*       EXPERIMENTAL DIV BASED RICH TB




function IEDIVTB(iframeEl, editable){
this.iframe = iframeEl;
this.editable = editable;
this.ifDoc;		//content window's document
this.initialize = initialize;
this.ifDocElement;
this.setContent = setContent;
this.getContent = getContent;
this._onKeyPress = _onKeyPress;
this._onKeyUp = _onKeyUp;
this._onPaste = _onPaste ;
this._onFocus = _onFocus;
this._onMouseDown = _onMouseDown;
this._onContextMenu = _onContextMenu;
this.getSpanElements = getSpanElements;
this.changeTo = changeTo;
this.getAbsY = getAbsY;
this.getAbsX = getAbsX;
this.isStatic = false;
this.getContentText = getContentText;
this.selectedErrorNode = selectedErrorNode;
this.containsElement = containsElement;
this.spellChecker;
this.getNumberOfErrors = getNumberOfErrors;

this.enabled = true;

this.focus = focus;
this.OnCorrection = OnCorrection;

function OnCorrection(){}

function getNumberOfErrors(){
var errors = this.getSpanElements();
var numErrors=0;
for(var i=0; i<errors.length; i++){
if(errors[i].className=='rs_err_hl'){
numErrors++;
}
}
return numErrors;
}


function focus(){
this.iframe.focus();
}


function containsElement(element){
return element.ownerDocument == this.ifDoc;
}


function selectedErrorNode(){

var selection = document.selection;
var parentEl = selection.createRange().parentElement();
if(parentEl.className == "rs_err_hl")
return parentEl;
else return null;
}

function getAbsX(element, event){
return this.iframe.offsetLeft + element.offsetLeft- this.iframe.scrollLeft;
}

function getAbsY(element, event){

var obj = this.iframe;
var curtop = 0;
var index = 0;
if (obj.offsetParent)
{
while (obj.offsetParent)
{
index++;
var delta=0;
if (!window.opera && index>1)
delta = obj.scrollTop ;

curtop += obj.offsetTop - delta;
obj = obj.offsetParent;
}
}
else if (obj.clientY)
curtop += obj.clientY;

return curtop + element.offsetTop - this.iframe.scrollTop;
}

function changeTo(error, replacement){
var repl = this.ifDoc.createTextNode(replacement);
error.parentNode.replaceChild(repl, error);
}

function getSpanElements(){
return this.ifDoc.getElementsByTagName("span");
}


function _onKeyPress(){
rsw_hideCM();

var evt = event;
//special behaviours

//check event came from active text box, because "event" here is global
if(rsw_activeTextbox.iframe.document.hasFocus()){
if(evt!=null && evt.keyCode == 13 && !rsw_activeTextbox.multiline){
evt.returnValue = false;
}
}

rsw_broadcastToListeners("keypress");

}

function _onFocus(event){
rsw_hideCM();
rsw_updateActiveTextbox(this);//this is the element, not obj
rsw_broadcastToListeners("focus");
}

function _onKeyUp(){
var errorNode = rsw_activeTextbox.selectedErrorNode();
if(errorNode)
rsw_dehighlight(errorNode);

rsw_broadcastToListeners("keyup");

}

function _onMouseDown(){
rsw_hideCM();
rsw_broadcastToListeners("mousedown");


}


function setContent(content){
this.iframe.innerHTML = content;
}

function getContent(){
return this.iframe.innerHTML;
}


function getContentText(){
//parse the DOM and pull the text

var contentElements = this.ifDocElement.childNodes[1].childNodes;
var contents = "";
for (var i = 0; i < contentElements.length; i++) {

if(contentElements[i].nodeValue)
contents += contentElements[i].nodeValue;
else if(contentElements[i].nodeName.toLowerCase()=="br")
contents += "\r\n";
else if(contentElements[i].nodeName.toLowerCase()=="input")
contents += contentElements[i].value;
else
contents += rsw_innerText(contentElements[i]);

}
return contents;
}




//---unique functions

function _onContextMenu(){
rsw_broadcastToListeners("contextmenu");
return false;
}

function _onPaste(){
rsw_broadcastToListeners("paste");
}

function initialize(){
this.ifDoc		      = this.iframe.document;
this.ifDocElement = this.iframe.document.documentElement;

rsw_createLink(document);


this.iframe.onmousedown = this._onMouseDown ;
this.iframe.onkeypress = this._onKeyPress ;
this.iframe.onkeyup = this._onKeyUp;
this.iframe.onpaste = this._onPaste ;
this.iframe.onfocus = this._onFocus;
this.iframe.oncontextmenu=this._onContextMenu;

}



}

*/






/*<![CDATA[*/
var rsw_mozly = navigator.userAgent.indexOf("Gecko") > -1;
var rsw_msie = navigator.userAgent.indexOf("MSIE") > -1;
var rsw_chrome = navigator.userAgent.indexOf("Chrome") > -1;
var rsw_applewebkit = navigator.userAgent.indexOf("AppleWebKit") > -1;

if(typeof(RapidSpell)=='undefined')RapidSpell = function () {
    /// <summary>RapidSpell Web client class.</summary>
};

RapidSpell.prototype.getConfigurationObject = rsw_getConfigurationObject;
RapidSpell.prototype.setParameterValue = rsw_setParameterValue;
RapidSpell.prototype.getParameterValue = rsw_getParameterValue;
RapidSpell.prototype.addEventListener = rsw_addEventListener;
RapidSpell.prototype.removeEventListener = rsw_removeEventListener;

var rsw_eventListeners = [];

function rswEventListener(eventName, listener) {
    this.eventName = eventName;
    this.listener = listener;
}

function rsw_addEventListener(eventName, listenerFunction) {
    /// <summary>Add an event listener.</summary>
    rsw_eventListeners[rsw_eventListeners.length] = new rswEventListener(eventName, listenerFunction);
}

function rsw_removeEventListener(eventName, listenerFunction) {
    /// <summary>Remove an event listener.</summary>
    var foundAt=-1;
    for (var i = 0; foundAt==-1 && i < rsw_eventListeners.length; i++) {
        if(rsw_eventListeners[i].listener==listenerFunction && rsw_eventListeners[i].eventName==eventName)
            foundAt=i;
    }
    if(foundAt>-1)
        rsw_eventListeners.splice(foundAt, 1);
}

function rsw_broadcastEvent(eventName, source, data1, data2, data3, data4, data5) {
    for (var i = 0; i < rsw_eventListeners.length; i++) {
        if (rsw_eventListeners[i].eventName == eventName)
            rsw_eventListeners[i].listener(source, data1, data2, data3, data4, data5);
    }
}



function rsw_getScriptLocation(name) {
    var scripts = document.getElementsByTagName('script');
    var l;
    for (var i = 0; i < scripts.length; i++) {
        if ((l = scripts[i].src.indexOf(name)) > -1) {
            return scripts[i].src.substring(0, l);
        }
    }
    alert('Sorry, cannot find a script import named ' + name + '.js, please do not rename any RapidSpell scripts.');
}

var rsw_scriptLocation = rsw_getScriptLocation('RapidSpell-');
var rapidSpell = rapidSpell ? rapidSpell : new RapidSpell();

//var rsw_scriptLocation = rsw_scriptLocation ? rsw_scriptLocation : "/scripts/";

var rsw_RapidSpell_Core=true;
var rsw_ignoreDisabledTextBoxes = true;
var rsw_ignoreReadyOnlyTextBoxes = true;
//var rsw_scriptLocation = "/scripts/";
var rsw_blankLocation = '<%= WebResource("blank.html") %>'.indexOf('<') > -1 ? rsw_scriptLocation + 'blank.html' : '<%= WebResource("blank.html") %>';
rsw_rs_menu_styleURL = '<%= WebResource("menu-net2.css") %>'.indexOf('<') > -1 ? rsw_scriptLocation + 'menu.css' : '<%= WebResource("menu-net2.css") %>';
rsw_rs_styleURL = '<%= WebResource("rs_style-net2.css") %>'.indexOf('<') > -1 ? rsw_scriptLocation + 'rs_style.css' : '<%= WebResource("rs_style-net2.css") %>';
rsw_modalHelperURL = '<%= WebResource("RapidSpellModalHelperNET2.html") %>'.indexOf('<') > -1 ? rsw_scriptLocation + 'RapidSpellModalHelper.html' : '<%= WebResource("RapidSpellModalHelperNET2.html") %>';
var rsw_targetIDs = new Array();
var rsw_rapidSpellControls = new Array();
var rsw_config_textBoxKeys = new Array();
var rsw_config_textBoxValues = new Array();
var rsw_config_defaults = { keys: ['UserDictionaryFile', 'SuggestionsMethod', 'SeparateHyphenWords', 'IncludeUserDictionaryInSuggestions', 'IgnoreXML', 'IgnoreCapitalizedWords', 'GuiLanguage',
                                 'LanguageParser', 'Modal', 'AllowAnyCase', 'IgnoreWordsWithDigits', 'ShowFinishedMessage', 'ShowNoErrorsMessage', 'ShowXMLTags', 'AllowMixedCase',
                                 'WarnDuplicates', 'DictFile', 'PopUpWindowName', 'CreatePopUpWindow', 'ConsiderationRange', 'LookIntoHyphenatedText', 'CheckCompoundWords', 'EnableUndo',
                                 'LeaveWindowOpenForUndo', 'SSLFriendlyPage', 'IgnoreURLsAndEmailAddresses', 'IgnoreIncorrectSentenceCapitalization', 'IgnoreInEnglishLowerCaseI', 'SuggestSplitWords',
                                 'CorrectionNotifyListener'],
    values: ['~/user-dictionary.txt', 'HASHING_SUGGESTIONS', 'false', 'true', 'false', 'false', 'ENGLISH',
                                    'ENGLISH', 'false', 'false', 'false', 'true', 'false', 'false', 'false',
                                    'true', '', '', 'false', '80', 'true', 'false', 'true',
                                    'false', rsw_blankLocation, 'false', 'false', 'false', 'true',
                                    'rsw_ondialogcorrection']
};

function rsw_ondialogcorrection(a, b, c, tbName) {
    rsw_broadcastEvent('dialog_correction', null, document.getElementById(tbName), a,  b, c);
}

var rsw_menuOptionKeys = ["ENGLISH", "FRENCH", "SPANISH", "GERMAN", "ITALIAN", "PORTUGUESE", "DUTCH", "POLISH"];
var rsw_menuOptionValues = [
        ["Ignore", "Ignore All", "Add", "Edit...", "All", "Remove duplicate word", "No suggestions", "The spelling check is complete."],
        ["Ignorer", "Ignorer Tout", "Ajouter", "Ã?â?°ditez...", "Tout", "Enlevez le mot double", "Aucun", "Fini."],
        ["Ignorar", "Ignorar Todas", "Agregar", "Corrija...", "Todas", "Quite la palabra duplicada", "Ningunas sugerencias", "La verificaciÃ?Â³n ortogrÃ?Â¡fica ha finalizado."],
        ["Ignorieren", "Alle ignorieren", "HinzufÃ?Â¼gen", "Redigieren...", "Alle", "Doppelte WÃ?Â¶rter entfernen", "Keine vorschlÃ?Â¤ge", "Die RechtschreibprÃ?Â¼fung ist abgeschlossen."],
        ["Ignora", "Ignora tutto", "Aggiungi", "Modifica...", "Tutto", "Rimuovi la parola duplicata", "Nessun suggerimento", "Controllo completato."],
        ["Ignore", "Ignore Tudo", "Adicione", "Edite...", "Tudo", "Remova a palavra duplicada", "Nenhumas sugestÃ?Âµes", "A verificaÃ?Â§Ã?Â£o de soletraÃ?Â§Ã?Â£o estÃ?Â¡ completa."],
        ["Negeren", "Alles negeren", "Toevoegen", "Corrigeren...", "Allen", "Verwijder herhaald woord", "Geen suggesties", "De spellingscontrole is voltooid."],
        ["Ignoruj", "Ignoruj wszystko", "Dodaj", "Edytuj...", "Wszystko", "UsuÃ?â?? podwÃ?Â³jne wystÃ?â?¦pienie sÃ?â??owa", "Nie ma sugestii", "ZakoÃ?â??czono Sprawdzanie pisowni."]
                           ];

function rsw_getLanguageArray(lang) {
    for (var i = 0; i < rsw_menuOptionKeys.length; i++) {
        if (rsw_menuOptionKeys[i] == lang)
            return rsw_menuOptionValues[i];
    }
    return null;
}

function rsw_getParameterValue(textBox, param) {
    var searchObj;
    var pos = rsw_getTextBoxIndex(textBox);


    if (pos == -1 && textBox != "default") return rsw_getParameterValue('default', param); //give default val
    else {
        if (textBox == "default") {
            searchObj = rsw_config_defaults;
        } else
            searchObj = rsw_config_textBoxValues[pos];

        var found = -1;
        for (var pp = 0; searchObj.keys && pp < searchObj.keys.length && found == -1; pp++) {
            if (searchObj.keys[pp] == param)
                found = pp;
        }
        if (found == -1) return rsw_getParameterValue('default', param);//give default val
        else {
            return searchObj.values[found];
        }
    }
}

function rsw_getConfigurationObject(textBox) {
    var synthObject = {keys:[], values:[]};
    for (var i = 0; i < rsw_config_defaults.keys.length; i++) {
        synthObject.keys[synthObject.keys.length] = rsw_config_defaults.keys[i];
        synthObject.values[synthObject.values.length] = rsw_getParameterValue(textBox, rsw_config_defaults.keys[i]);
    }
    return synthObject;
}

function rsw_getTextBoxIndex(textBox) {
    for (var i = 0; i < rsw_config_textBoxKeys.length; i++) {
        if (rsw_config_textBoxKeys[i] == textBox) return i;
    }
    return -1;
}

function rsw_setParameterValue(textBox, param, value) {
    var pos;
    if (textBox != 'default') {

        pos = rsw_getTextBoxIndex(textBox);
        if (pos == -1) {
            rsw_config_textBoxKeys[rsw_config_textBoxKeys.length] = textBox;
            pos = rsw_config_textBoxKeys.length - 1;
            rsw_config_textBoxValues[pos] = {};
        }

    }

    var targ;
    if (textBox != 'default')
        targ = rsw_config_textBoxValues[pos];
    else
        targ = rsw_config_defaults;

    var found = -1;

    for (var pp = 0; targ.keys && pp < targ.keys.length && found == -1; pp++) {
        if (targ.keys[pp] == param)
            found = pp;
    }

    if (!targ.keys) {
        targ.keys = new Array();
        targ.values = new Array();
    }

    if (found == -1) found = targ.keys.length;
    targ.keys[found] = param;
    targ.values[found] = value;

    //update scs for AYT
    if(typeof(rsw_scs)!='undefined'){
        for (var i = 0; i < rsw_scs.length; i++) {
            if (textBox=='default' || rsw_scs[i].textBoxId == textBox.id) {
                rsw_scs[i].config = rsw_getConfigurationObject(document.getElementById(rsw_scs[i].textBoxId));
                if (param == "GuiLanguage") {
                    var langArray = rsw_getLanguageArray(value);
                    if (langArray != null) {
                        rsw_scs[i].ignoreText = langArray[0];
                        rsw_scs[i].ignoreAllText = langArray[1];
                        rsw_scs[i].addText = langArray[2];
                        rsw_scs[i].editText = langArray[3];
                        rsw_scs[i].changeAllText = langArray[4];
                        rsw_scs[i].removeDuplicateText = langArray[5];
                        rsw_scs[i].noSuggestionsText = langArray[6];
                    }
                }
            }
        }
    }




}

function rsw_isElementVisible(tb) {
    if (document.getElementById(tb.id + "_IF") != null) return true;
    if ((tb.style && tb.style.visibility && tb.style.visibility == "hidden") || (tb.style && tb.style.display == "none"))
        return false;
    if (tb.parentElement != null)
        return rsw_isElementVisible(tb.parentElement);
    else if (typeof (tb.parentElement) == 'undefined' && tb.parentNode != null)
        return rsw_isElementVisible(tb.parentNode);
    else
        return true;
}


//---Tell Ajax it loaded OK

//-------------------------

/*]]>*/

/*<![CDATA[*/
/*
function rsw_addScript(url) {
    var scriptElement = document.createElement('SCRIPT');
    scriptElement.type = 'text/javascript';
    var url = (typeof (CssSheetURL) == 'undefined' || CssSheetURL == "") ? rsw_rs_styleURL : CssSheetURL;

    linkElement.setAttribute('src', url); //'/Keyoti_RapidSpell_Web_Common/rs_style.css'
    document.getElementsByTagName('head')[0].appendChild(linkElement);
}
*/

rsw_createLink(document, rsw_scriptLocation + 'menu.css');
rsw_createLink(document, rsw_scriptLocation + 'rs_style.css');

RapidSpell.prototype.ayt_removeUnderlines = rsw_removeUnderlines;
RapidSpell.prototype.ayt_refreshUnderlines = rsw_refreshUnderlines;
RapidSpell.prototype.ayt_setupTextBoxes = rsw_setupTextBoxes;
RapidSpell.prototype.ayt_spellCheck = rsw_spellCheckProxy;



rapidSpell.ayt_helperURL = rsw_scriptLocation+"rswihelper.aspx";
rapidSpell.ayt_aytEnabled = true;
rapidSpell.ayt_staticMode = false;
rapidSpell.ayt_recheckDelay = 500;
rapidSpell.ayt_ignoreTextBoxIds = new Array();


function rsw_spellCheckProxy(optionalID, button) {
    if (typeof (optionalID) == 'string') {
        rsw_spellCheckTextBox(document.getElementById(optionalID), button);
    } else{
        rsw_spellCheckAll();
    }
}


if (!rsw_RapidSpell_Core) alert("Please ensure that you include the RapidSpell-Core.js file in your page, before the RapidSpell-AYT.js file is imported.");

rsw_isASPX = true;
//rsw_rs_menu_styleURL = rsw_scriptLocation+'menu.css';
//rsw__init();//setup some minor vars


var rsw_haveadded = false;
var rsw_prm = null;

function rsw_endRequest(sender, args) {
    rsw_setupTextBoxes(false);
}

function rsw_refreshUnderlines() {
    rsw_removeUnderlines(); 
    rsw_startAYT(0);
}

function rsw_removeUnderlines() {
    ///<summary>Removes underlines from the textboxes.</summary>
    for (var j = 0; j < rsw_tbs.length; j++) {
        var tb = rsw_tbs[j];
        var errors = tb.getSpanElements();
        for (var i = 0; i < errors.length; i++) {
            tError = errors[i].innerHTML.replace(/<[^>]+>/g, "");
            if (errors[i].className == 'rs_err_hl') {
                rsw_dehighlight(errors[i]);
            }
        }
    }
}

function rsw_isTextBoxIgnored(tbId) {
    for (var i = 0; i < rapidSpell.ayt_ignoreTextBoxIds.length; i++)
        if (tbId == rapidSpell.ayt_ignoreTextBoxIds[i]) return true;
    return false;
}

var rsw_ignorePropertyChange = false;

//need to monitor changes to visib and display on the shadow TB, and do same to IF, but at moment we're catching ourselves hiding it, need to ignore
function rsw_watchedElementChange(e) {
    if (rsw_ignorePropertyChange) return;
    if (e) {
        var tbs = rsw_getTBSFromTB(e.target);
        if (e.attrName == "value") {
            tbs.updateIframe();
            tbs.spellChecker.OnSpellButtonClicked();
        }
        if ((e.attrName == "style" && e.newValue.indexOf("visibility:") > -1 && e.target.style.visibility == "hidden") || (e.attrName == "style" && e.newValue.indexOf("display:") > -1 && e.target.style.display == "none")) {
            if (tbs != null) tbs.iframe.style.display = "none";
        }
        if (
        (e.attrName == "style" && e.newValue.indexOf("visibility:") > -1 && e.target.style.visibility == "visible")
            ||
        (e.attrName == "style" && e.newValue.indexOf("visibility:") > -1 && (e.target.style.display == "block" || e.target.style.display == "inline"))
        ) {
            if (tbs != null) tbs.iframe.style.display = "block";
        }
    } else {
        var tbs = rsw_getTBSFromTB(event.target);
        if (event.propertyName == "value") tbs.setContent(event.target.value);
        if ((event.propertyName == "style.visibility" && event.target.style.visibility == "hidden") || (event.propertyName == "style.display" && event.target.style.display == "none")) {
            if (tbs != null) tbs.iframe.style.display = "none";
        }
        if (
        (event.propertyName == "style.visibility" && event.target.style.visibility == "visible")
            ||
        (event.propertyName == "style.display" && (event.target.style.display == "block" || event.target.style.display == "inline"))
        ) {
            if (tbs != null) tbs.iframe.style.display = "block";
        }
    }
       // alert(event.target+" "+ event.propertyName);
}

function rsw_checkValuesForChange() {
    if (rsw_ignorePropertyChange) return;
    var ov;
    for (var i = 0; i < rsw_tbs.length; i++) {
        ov = rsw_tbs[i].shadowTB.getAttribute('oldValue');

        if (rsw_debug) document.getElementById("debug").value += "\r\n" + rsw_debug_getTime() + "\r\nOLD " + ov + " \r\nNEW " + rsw_tbs[i].shadowTB.value+"\r\n";
        rsw_tbs[i].shadowTB.setAttribute('oldValue', rsw_tbs[i].shadowTB.value);
        if (ov != null) {
            if (ov != rsw_tbs[i].shadowTB.value) {
                
                var e = new Object();
                e.target = rsw_tbs[i].shadowTB;
                e.srcElement = rsw_tbs[i].shadowTB;
                e.attrName = 'value';
                rsw_watchedElementChange(e);
            }
        } 

    }
}


function rsw_attachListeners(tb) {
    if (typeof (tb.addEventListener) == 'function')
        tb.addEventListener('DOMAttrModified', rsw_watchedElementChange, true);
    else if (typeof (tb.onpropertychange) == 'object')
        tb.onpropertychange = rsw_watchedElementChange;



    if(navigator.userAgent.indexOf("Gecko") > -1)
        setInterval('rsw_checkValuesForChange()', 50);  
}

function rsw_setupTextBoxes(activate) {

    var textareas = document.getElementsByTagName("textarea");
    var inputs = document.getElementsByTagName("input");
//    var iframes = document.getElementsByTagName("iframe");
    var textboxes = [];
    for (var i = 0; i < textareas.length; i++) textboxes[textboxes.length] = textareas[i];
    for (var i = 0; i < inputs.length; i++) if(inputs[i].type=='text') textboxes[textboxes.length] = inputs[i];
  //  for (var i = 0; i < iframes.length; i++) if (iframes[i].designMode == 'On' || iframes[i].contentEditable == 'true') textboxes[textboxes.length] = iframes[i];

    textareas = null;
    inputs = null;
    
    var startAt = -1;
    var actives = new Array();
    var tbs;
    // textboxes[i].onpropertychange = rsw_watchedElementChange;
    for (var i = 0; i < textboxes.length; i++) {
        if (rapidSpell.ayt_staticMode &&
                    (!rsw_ignoreReadyOnlyTextBoxes || !textboxes[i].readOnly) &&
                    (!rsw_ignoreDisabledTextBoxes || !textboxes[i].disabled) &&
                    textboxes[i].getAttribute("nospell") != "true" && rsw_isElementVisible(textboxes[i]) && !rsw_isTextBoxIgnored(textboxes[i].id)
        ) {
            rsw_AYT_configureSpellChecker(new SpellChecker(textboxes[i].id), textboxes[i].id);
        } else {
            tbs = rsw_getTBSFromTB(textboxes[i]);
            if (!rsw_isElementVisible(textboxes[i]) && tbs != null)
                actives[actives.length] = tbs;
            else if (
                    (!rsw_ignoreReadyOnlyTextBoxes || !textboxes[i].readOnly) &&
                    (!rsw_ignoreDisabledTextBoxes || !textboxes[i].disabled) &&
                    textboxes[i].getAttribute("nospell") != "true" && rsw_isElementVisible(textboxes[i]) && !rsw_isTextBoxIgnored(textboxes[i].id)
                ) {
                if (tbs == null) {
                    rsw_enableAsYouTypeTextBox(textboxes[i]);

                    rsw_attachListeners(textboxes[i]);

                    if (activate) {
                        rsw__initTB(rsw_tbs.length);
                        if (rsw_activeTextbox == null)
                            rsw_activeTextbox = rsw_tbs[0];
                        rsw_addTbFinish(0, textboxes[i].id);
                        rsw_ayt_initializing = true;
                        if (startAt == -1)
                            startAt = rsw_tbs.length - 1;
                    }
                    actives[actives.length] = rsw_tbs[rsw_tbs.length - 1];
                } else {
                    if (tbs.iframe.style.display == "none") {
                        tbs.iframe.style.display = "block";
                    }
                    actives[actives.length] = tbs;
                }
            }
        }
    }


    setTimeout("rsw_startAYT(" + startAt + ")", 1000);

    var found;
    //remove any TBS instance no longer in use
    for (var i = rsw_tbs.length - 1; i >= 0; i--) {
        found = false;
        for (var j = 0; j < actives.length; j++) {
            if (rsw_tbs[i] == actives[j]) {
                found = true;
                break;
            }
        }
        if (!found) {
           rsw_tbs[i].iframe.style.display = "none";

        }
   }

}




function rsw_startAYT(startAt) {
    if (startAt >= 0 && rapidSpell.ayt_aytEnabled) {
        rs_AYT.checkerCurrentlyInitializing = startAt;
        rs_AYT.triggeredLast = false;
        rs_AYT.onTextBoxesInit();
    }
}
/*
function rsw_spellCheckTextBox(textBoxId) {
    rsw_currentlyCheckingMultiple = false;
    var found = false;
    for (var i = 0; i < rsw_scs.length; i++) {
        if (rsw_scs[i].textBoxID == textBoxId) {
            rsw_scs[i].OnSpellButtonClicked();
            found=true;
        }
    }
    if(!found){//create a checker for it and check statically (probably an iframe)
        rsw_addTextBoxSpellChecker(document.getElementById(textBoxId), true, 0);
        rsw_scs[rsw_scs.length-1].OnSpellButtonClicked();
    }

}
*/
var rsw_currentlyChecking = 0;
var rsw_checkCompleted;
var rsw_isOverlayed;
var rsw_currentlyCheckingMultiple;
function rsw_spellCheckAll(buttonClick) {
    rsw_currentlyCheckingMultiple = true;
    //? if (typeof (rsw_StartedOnTextBoxListener) != 'undefined') rsw_StartedOnTextBoxListener(document.getElementById(textBoxId));

    var curState = null;
    if (rsw_scs.length > rsw_currentlyChecking)
      curState = rsw_scs[rsw_currentlyChecking].state;
    if (rsw_currentlyChecking == 0) {
        rsw_isOverlayed = false;
        for (var ch = 0; ch < rsw_scs.length; ch++) {
            if (rsw_scs[ch].state == 'overlay') rsw_isOverlayed = true;
        }
    }
    if (rsw_isOverlayed && curState != 'overlay') {
        rswm_auto_NotifyDone(true);
    } else {
        rsw_scs[rsw_currentlyChecking].OnSpellButtonClicked();
    }
}

function rswm_auto_NotifyDone(spellCheckFinished) {
    if (!rsw_currentlyCheckingMultiple) return;
    rsw_currentlyChecking++;
    rsw_checkCompleted = spellCheckFinished;

    //(FinishedOnTextBoxListener!=""?FinishedOnTextBoxListener+"(document.getElementById(eval(rapidSpellControls[currentlyChecking-1]+\"_SpellChecker.textBoxID\")));":"")+

    if (rsw_currentlyChecking < rsw_scs.length && spellCheckFinished) {
        rsw_spellCheckAll(false);

    } else rsw_currentlyChecking = 0;

}


function rsw_getTBSFromTB(tb) {
    //gets the rsw_tbs object from the ID of the original TB (shadow tb for rich)
    //DO NOT want to compare instances of 'tb' because AJAX can switch the instance while preserving the id, so use id to compare
    for (var i = 0; i < rsw_tbs.length; i++) {

        if (rsw_tbs[i].shadowTB.id == tb.id) {

            return rsw_tbs[i];
        }
    }
    return null;
}


function rsw_inline_button_OnStateChanged(state, buttonID, buttonTextSpellChecking, buttonTextSpellMode, buttonText) {
    try {
        if (buttonID.length == 0) return;
        var button = document.getElementById(buttonID);
        if (button != null && state == 'TRANSITION-CHECKING') { button.value = buttonTextSpellChecking; button.disabled = true; }
        if (button != null && state == 'CHECKING') { button.value = buttonTextSpellMode; button.disabled = false; }
        if (button != null && state == 'EDITING') { button.value = buttonText; button.disabled = false; }
    } catch (e) { }
}


function rsw__initTB(ptr) {
    rsw_mozly = navigator.userAgent.indexOf("Gecko") > -1;
    rsw_msie = navigator.userAgent.indexOf("MSIE") > -1;
    rsw_chrome = navigator.userAgent.indexOf("Chrome") > -1;
    rsw_applewebkit = navigator.userAgent.indexOf("AppleWebKit") > -1;
    rsw_compatibleBrowser = rsw_msie || rsw_mozly || rsw_chrome || rsw_applewebkit;
    //find the config for this tbs
    var tbConfig = rsw_config[ptr];
    var myIFrame = document.getElementById(tbConfig.values[0]);

    if (rsw_chrome || rsw_applewebkit)
        rsw_tbs[ptr] = new MozlyTB(myIFrame, true);
    else if (rsw_mozly)
        rsw_tbs[ptr] = new MozlyTB(myIFrame, true);
    else
        rsw_tbs[ptr] = new IETB(myIFrame, true);

    rsw_tbs[ptr].enabled = tbConfig.values[1];
    rsw_tbs[ptr].CssSheetURL = tbConfig.values[2];

    try {
        rsw_tbs[ptr].tbConfig = tbConfig;
        rsw_tbs[ptr].initialize();

    } catch (ex) {
        //alert(ex);
    }
}

var rsw_AYT_oldEvt = window.onload;
window.onload = function () {
    if (rapidSpell.ayt_staticMode) {
        rsw_setupTextBoxes();
        return;
    }
    

    if (typeof (Sys) != 'undefined' && Sys.WebForms && Sys.WebForms.PageRequestManager)
        rsw_prm = Sys.WebForms.PageRequestManager.getInstance();
    if (!rsw_haveadded && rsw_prm != null) {
        rsw_prm.add_endRequest(rsw_endRequest);
        rsw_haveadded = true;

        rsw_prm.add_initializeRequest(rsw_ASPNETAJAX_OnInitializeRequest);
        rsw_prm.add_endRequest(rsw_ASPNETAJAX_OnEndRequest);
        rsw_ASPNETAJAX_OnHandlersAdded = true;
    }


    rsw_setupTextBoxes();
    if (rsw_AYT_oldEvt) rsw_AYT_oldEvt();
    rsw__init();
};

var rsw_AYT_oldEvt2 = document.onclick;
document.onclick = function (ev) {
    if (rsw_AYT_oldEvt2) rsw_AYT_oldEvt2();
    var gEvent;
    if (window.event) {
        gEvent = window.event;
    } else {
        gEvent = ev;
    }
    var gTar;
    if (gEvent.target) {
        gTar = gEvent.target;
    } else {
        gTar = gEvent.srcElement;
    }
    var gParent;
    if (gTar != null && gTar.parentNode) {
        gParent = gTar.parentNode;
    } else {
        gParent = gTar.parentElement;
    }
    if (gTar != null && gTar.className != 'rs_err_hl' && (gParent == null || gParent.className != 'rs_err_hl')) {
        rsw_hideCM();
    }
};
var rsw_AYT_oldEvtRESIZE = window.onresize;
window.onresize = function () {
    if (rsw_AYT_oldEvtRESIZE) rsw_AYT_oldEvtRESIZE();
    rsw__resize();
};






function rsw_AYT_configureSpellChecker(sc, tbid) {
/*    sc.config = {
        keys: ['UserDictionaryFile', 'DictFile', 'SuggestionsMethod', 'LanguageParser', 'SeparateHyphenWords', 'V2Parser', 'SSLFriendlyPage', 'SuggestSplitWords', 'IncludeUserDictionaryInSuggestions', 'WarnDuplicates', 'IgnoreWordsWithDigits', 'CheckCompoundWords', 'LookIntoHyphenatedText', 'GuiLanguage', 'IgnoreXML', 'IgnoreCapitalizedWords', 'ConsiderationRange', 'IgnoreURLsAndEmailAddresses', 'AllowMixedCase'],
        values: ['', '', 'HASHING_SUGGESTIONS', 'ENGLISH', 'false', 'true', rsw_scriptLocation+'blank.html', 'true', 'true', 'true', 'true', 'false', 'true', '10001', 'false', 'false', '-1', 'false', 'false']
    };
    */

    sc.config = rsw_getConfigurationObject(document.getElementById(tbid));

    sc.rapidSpellWebPage = rapidSpell.ayt_helperURL;
    sc.buttonID = "rswi1_button";
    sc.showNoSpellingErrorsMesg = false;
    sc.noSuggestionsText = 'No suggestions';
    sc.ignoreAllText = 'Ignore All';
    sc.addText = 'Add';
    sc.editText = 'Edit...';
    sc.changeAllText = 'All';
    sc.showChangeAllItem = false;
    sc.removeDuplicateText = 'Remove duplicate word';
    sc.buttonTextSpellChecking = 'Checking...';
    sc.buttonTextSpellMode = 'Resume Editing';
    sc.buttonText = 'Check Spelling';
    sc.noSpellingErrorsText = 'No Spelling Errors In Text.';
    sc.responseTimeout = '20';
    sc.responseTimeoutMessage = 'Sorry the server has failed to respond to the spell check request.  Please check the URL set in the RapidSpellWInlineHelperPage property in the RapidSpellWInlineHelper ctrl.';
    sc.changeButtonTextWithState = true;
    sc.showAddMenuItem = true;
    sc.doubleClickSwitchesMode = true;
    sc.useXMLHTTP = true;
    sc.ignoreXML = false;
    sc.copyComputedStyleToOverlay = true;
    sc.enterEditModeWhenNoErrors = true;
    sc.overlayCSSClassName = 'oldBrowserBox';
    if (typeof (rapidSpell.textInterfaceNeeded) == 'function') sc.tbInterface = rapidSpell.textInterfaceNeeded(tbid);
    else sc.tbInterface = new RSAutomaticInterface(tbid);
    sc.textBoxId = tbid;
    rsw_scs[rsw_scs.length] = sc;
}


function rsw_enableAsYouTypeTextBox(textBox) {
    var multiline = textBox.tagName.toUpperCase() == "TEXTAREA";
    var createdIF = false;
    var newIF = document.getElementById(textBox.id + "_IF");
    if (newIF == null) {
        newIF = document.createElement("iframe");
        createdIF = true;
    }
    newIF.setAttribute("id", textBox.id + "_IF");
    newIF.setAttribute("src", rsw_blankLocation);
    newIF.setAttribute("style", "display:none; overflow-x:hidden;overflow-y:scroll;  " + (rsw_useBattleShipStyle?"":"border-width:1px;border-color:#7F9DB9;border-style:solid;")+"height:1px;width:1px;");
    newIF.setAttribute("frameborder", rsw_useBattleShipStyle?"1":"0");
    //    newIF.setAttribute("scrolling", "no");
    newIF.setAttribute("tabindex", textBox.getAttribute("tabindex"));
    //textBox.parentElement.appendChild(newIF);
newIF.style.display="none";


    if (createdIF) {
        if (textBox.parentNode)
            textBox.parentNode.insertBefore(newIF, textBox);
        else
            textBox.parentElement.insertBefore(newIF, textBox);
    }
    // textBox.style.display="none";

    try {
        //   rsw_copyComputedStyle(newIF, textBox);
    } catch (e) { }
    var maxlen = textBox.getAttribute("maxlength");
    if (!(maxlen > 0))
        maxlen = 0;

    rsw_addTextBoxSpellChecker(textBox, multiline, maxlen);
}

function rsw_addTextBoxSpellChecker(textBox, multiline, maxlen){
    rsw_addTBConfig({
        keys: ["elementID", "enabled", "CssSheetURL", "multiline", "ifDoc.body.className",  "iframe.style.position", "iframe.style.top", "iframe.style.left", "iframe.style.zIndex", "ifDoc.body.style.backgroundColor", "iframe.style.borderColor", "maxlength", "ifDoc.body.style.color", "iframe.style.borderStyle", "iframe.style.borderWidth", "ifDoc.body.style.fontSize", "ifDoc.body.style.fontWeight", "ifDoc.body.style.fontStyle", "ifDoc.body.style.fontFamily", "ifDoc.body.style.textDecoration", "textIsXHTML", "ifDoc.body.style.border"],
        values: [textBox.id + "_IF", !textBox.disabled, rsw_rs_styleURL, multiline, (multiline ? "RS_MultiLineTB" : "RS_SingleLineTB") + (textBox.disabled ? "_Disabled" : ""),  "", "", "", "", "", "#7F9DB9", maxlen , "", (rsw_useBattleShipStyle ? "" : "solid"), (rsw_useBattleShipStyle ? "" : "1"), "", "", "", "", "", false, "none"]
    });
    textBox.rsw_extension = new RSWITextBox(textBox.id);

    

    rsw_AYT_configureSpellChecker(new SpellChecker(textBox.id), textBox.id);



}



var rs_AYT;
var rsw_oldOnload = window.onload;
window.onload = function () {
    rsw_attachInitHandler();
    if (rsw_oldOnload) rsw_oldOnload();
    rsw_MenuOnRightClick = true;
    var newDIV = document.createElement("div");
    newDIV.setAttribute("id", "RS_CM_DIV");
    newDIV.setAttribute("style", "visibility:hidden;");
    newDIV.setAttribute("oncontextmenu", "try{event.cancelBubble=true;event.preventDefault();}catch(e){}return false;");
    newDIV.oncontextmenu = function () { try { event.cancelBubble = true; event.preventDefault(); } catch (e) { } return false; };
    document.body.appendChild(newDIV);

    var newIF = document.createElement("iframe");
    newIF.setAttribute("id", "RS_CM_IF");
    newIF.setAttribute("src", "javascript: false;");
    newIF.setAttribute("scrolling", "no");
    newIF.setAttribute("frameborder", "0");
    newIF.setAttribute("style", "position:absolute; top:0px; left:0px; visibility:hidden;");
    newIF.style.display = "none";
    document.body.appendChild(newIF);


};

var rsw_autoCheckTimeout;
function rsw_attachInitHandler() {
    if (typeof (rsw_debug) != 'undefined' && rsw_debug) alert('rsw_attachInitHandler');
    var found = false;
    for (var i = 0; !found && i < rsw_aux_oninit_handlers.length; i++) {
        found = rsw_aux_oninit_handlers[i] == 'rsw_onRSTextBoxesInit()';    
    }
    if(!found)rsw_aux_oninit_handlers[rsw_aux_oninit_handlers.length] = 'rsw_onRSTextBoxesInit()';
}

function rsw_fireEventInShadow(eventName, textbox) {
    if (!textbox) textbox = rsw_activeTextbox;
    try {
        var event;
        var element = textbox.shadowTB;
        if (document.createEvent) {
            event = document.createEvent("HTMLEvents"); // ("HTMLEvents");
            event.initEvent(eventName, true, true);
        } else {
            event = document.createEventObject();
            event.eventType = eventName;
        }

        event.eventName = eventName;
        // event.memo = memo || {};

        if (document.createEvent) {
            element.dispatchEvent(event);
        } else {
            element.fireEvent("on" + event.eventType, event);
        }
    } catch (e) { }//some of our events come thru and blow up
}

function _INT_notifyTextBoxListeners(eventName) {
    if (rapidSpell.ayt_staticMode) return;
    rsw_fireEventInShadow(eventName);
    if (eventName == "keyup") {
        clearTimeout(rsw_autoCheckTimeout);
        rsw_autoCheckTimeout = null;
        if (rsw_autoCheckTimeout == null && rapidSpell.ayt_aytEnabled) rsw_autoCheckTimeout = setTimeout('rs_AYT.onPause()', rapidSpell.ayt_recheckDelay);
    } else if (eventName == "keydown") {
        clearTimeout(rsw_autoCheckTimeout);
        rsw_autoCheckTimeout = null;
    } else if (eventName == "spellcheckfinish" && rapidSpell.ayt_aytEnabled) rs_AYT.onFinish();
}
function rsw_onRSTextBoxesInit() {
    if (typeof (rsw_debug) != 'undefined' && rsw_debug) alert('rsw_onRSTextBoxesInit');
    rs_AYT = new RapidSpell_Web_AsYouType();
    rs_AYT.checkAsYouTypeOnPageLoad = true;


    setTimeout('rsw_delayInit()', 50);
}

function rsw_delayInit() {

    for (var i = 0; i < rsw_tbs.length; i++) {
        rsw_switchTB(rsw_tbs[i].shadowTBID);
    }
    if(rapidSpell.ayt_aytEnabled)
        setTimeout('rs_AYT.onTextBoxesInit()', 100);
    if (typeof (rsw_onRSTextBoxesReady) == 'function')
        rsw_onRSTextBoxesReady();
}

function rsw_switchTB(id) {
    var ifr = document.getElementById(id + '_IF');
    //        ifr.style.position = "absolute";
    var shtb = document.getElementById(id);
    rsw_updatePosition(ifr, shtb);

    //P2 uncomment
    //ifr.style.position = "absolute";
    rsw_resetTBSSize_X(ifr, id);
    var tb = rsw_getTBSFromID(id, false);

    try {
        if (shtb.tagName == "TEXTAREA")
            ifr.contentWindow.document.body.style.overflowY = "scroll";
    } catch (e) { } //contentWindow might not be ready yet



/*csc
    if (ifr.style.left == "0px" && ifr.style.top == "0px")
        ifr.style.display = 'none';
    else
        ifr.style.display = 'inline';
    */
    ifr.style.backgroundColor = 'white';
    //document.getElementById(id).style.visibility='hidden';
    //P2
    rsw_ignorePropertyChange = true;
        tb.shadowOriginalDisplay = shtb.style.display;
//csc        shtb.style.display = 'none';
        rsw_ignorePropertyChange = false;

        rsw_auto_copyStyle(ifr.id, shtb.id);
        setTimeout('rsw_auto_copyStyle("'+ifr.id+'", "'+shtb.id+'")', 200);//FF seems to need a second shot

        shtb.style.display = 'none';

/*csc*/
    if (ifr.style.left == "0px" && ifr.style.top == "0px")
        ifr.style.display = 'none';
    else
        ifr.style.display = 'inline';
/**/
    //need this because intermittenly the position property just wont be set by IE9 and ?
    //P2setTimeout(function () { ifr.style.position = "absolute"; }, 50);
    return tb;
}

function rsw_auto_copyStyle(iframeId, tbId) {
    
    var shtb = document.getElementById(tbId);
    var ifr = document.getElementById(iframeId);

    try {
        if (shtb.style.zIndex)
            ifr.style.zIndex = shtb.style.zIndex;
        /*else
        ifr.style.zIndex = '9999997';
        */
        // rsw_copyComputedStyle(ifr, document.getElementById(id));
        if (!rsw_mozly && !rsw_chrome && !rsw_applewebkit) {
            rsw_copyComputedStyle(ifr.contentWindow.document.body, shtb);
        } else {
            rsw_copyComputedStyle(ifr, shtb);
            rsw_copyComputedStyle(ifr.contentWindow.document.body, shtb);
        }

        // alert('switch');

        ifr.style.position = shtb.style.position;
        ifr.style.left = shtb.style.left;
        ifr.style.top = shtb.style.top;
        if (shtb.style.border)
            ifr.style.border = shtb.style.border;


    } catch (e) { }
}

function _notifySpellCheckListeners(eventName) {
    if (eventName == 'ayt_finished_initializing') {
        var sx = 0;
        var sy = 0;
        if (document.getElementById('__SCROLLPOSITIONX') != null) {
            sx = document.getElementById('__SCROLLPOSITIONX').value;
            sy = document.getElementById('__SCROLLPOSITIONY').value;
            window.scrollTo(sx, sy);
        }

    }
}


function rsw_resetTBSSize_X(myIFrame, theTBid) {

    var tbWidth = rsw_getElementWidth(theTBid);

    if ((document.compatMode && document.compatMode != "BackCompat") ||rsw_mozly)//correct width when in strict mode
        tbWidth = rsw_adjustOffsetWidthForStrict(myIFrame, tbWidth);

    if (tbWidth >= 0)
        myIFrame.style.width = tbWidth + "px";

    var tbHeight = rsw_getElementHeight(theTBid);
    if ((document.compatMode && document.compatMode != "BackCompat") ||rsw_mozly)//correct width when in strict mode
        tbHeight = rsw_adjustOffsetHeightForStrict(myIFrame, tbHeight);



    if (tbHeight >= 0)
        myIFrame.style.height = tbHeight + "px";
}

//waits until the iframe has loaded its content properly before proceeding
function rsw_addTbFinish(attempts, tbid) {
    if (rsw_haltProcesses) return;
    if (!attempts) attempts = 0;
    //wait for iframe content to load.
    if (rsw_id_waitingToInitialize != null && attempts < 100) {
        attempts++;
        eval("setTimeout( function() {	rsw_addTbFinish( " + attempts + ", '" + tbid + "');}, 50 ); ");
        return;
    }
    var tb = rsw_switchTB(tbid);


    

    if (document.getElementById(tbid).tagName == "TEXTAREA") {
        tb.iframe.contentWindow.document.body.style.overflowY = "scroll";
        tb.iframe.contentWindow.document.body.style.overflow = "scroll";

    }




    tb.isDirty = true;

//P2    rsw_spellCheckTextBox(tb);
    //        setTimeout("tb.iframe.style.position='absolute';", 1000);
}

function rsw_removeTB(id){
    
    for (var i = rsw_tbs.length - 1; i >= 0; i--) {


        if (rsw_tbs[i].shadowTBID == id) {
            rsw_tbs[i].shadowTB.style.display = (rsw_tbs[i].shadowOriginalDisplay != null && rsw_tbs[i].shadowOriginalDisplay.length > 0) ? rsw_tbs[i].shadowOriginalDisplay : "block";
            rsw_tbs[i].iframe.style.display = "none";
            rsw_tbs.splice(i, 1);
            break;
        }
    }
}

var count = 0;
var rsw_require_init = true;
function rsw_addTb(tb) {
    rsw_enableAsYouTypeTextBox(tb);

    rsw__initTB(rsw_tbs.length);
    if (rsw_activeTextbox == null)
        rsw_activeTextbox = rsw_tbs[0];
    rsw_addTbFinish(0, tb.id);
    //    rsw_switchTB(tb.id);
    //setTimeout("rsw_switchTB('"+tb.id+"')", 500);
    /*
    rsw_cancelCall=true;
    rsw_haltProcesses=true;
    rsw_require_init=true;

    //check each SpellChecker to see if its overlayed, if it is, we need to switch to back to edit mode
    for(var i=0; i<rsw_scs.length; i++){
    if (rsw_scs[i].state == "overlay") {//swtich
    //rsw_scs[i].OnSpellButtonClicked(true);
    rsw_scs[i].rsw_tbs.updateShadow();
    rsw_scs[i].rsw_tbs.iframe.style.display = "none";
    }
    rsw_scs[i].rsw_tbs = null;
    }
    rsw_tbs = new Array();

    rsw_enableAsYouTypeTextBox(tb);
    rsw_switchTB(tb.id);
    //rsw__init();


    rsw_haltProcesses=false;
    ///link in the menu CSS sheet, incase not already linked.
    rsw_createLink(document, rsw_rs_menu_styleURL);
    rsw_createLink(document, rsw_rs_styleURL);

    if(typeof(rsw_attachInitHandler)!='undefined')
    rsw_attachInitHandler();

    if(rsw_require_init){
    //rsw__init();
    if(typeof(rsw_autoCallRSWInit)=='undefined' || rsw_autoCallRSWInit)
    setTimeout('rsw__init(true)', 50);
    }

    rsw_require_init = false;
    rs_AYT.onTextBoxesInit();
    */
}



//---Tell Ajax it loaded OK
if (typeof (Sys) != 'undefined' && typeof (Sys.Application) != 'undefined') Sys.Application.notifyScriptLoaded();
//-------------------------

/*]]>*/

