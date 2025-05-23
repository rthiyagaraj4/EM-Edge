/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function dtmlXMLLoaderObject(funcObject, dhtmlObject, async, rSeed) {
	this.xmlDoc = "";
	if (typeof (async) != "undefined") {
		this.async = async;
	} else {
		this.async = true;
	}
	this.onloadAction = funcObject || null;
	this.mainObject = dhtmlObject || null;
	this.waitCall = null;
	this.rSeed = rSeed || false;
	return this;
}
dtmlXMLLoaderObject.prototype.waitLoadFunction = function (dhtmlObject) {
	var once = true;
	this.check = function () {
		if ((dhtmlObject) && (dhtmlObject.onloadAction != null)) {
			if ((!dhtmlObject.xmlDoc.readyState) || (dhtmlObject.xmlDoc.readyState == 4)) {
				if (!once) {
					return;
				}
				once = false;
				dhtmlObject.onloadAction(dhtmlObject.mainObject, null, null, null, dhtmlObject);
				if (dhtmlObject.waitCall) {
					dhtmlObject.waitCall();
					dhtmlObject.waitCall = null;
				}
			}
		}
	};
	return this.check;
};
dtmlXMLLoaderObject.prototype.getXMLTopNode = function (tagName, oldObj) {
	if (this.xmlDoc.responseXML) {
		var temp = this.xmlDoc.responseXML.getElementsByTagName(tagName);
		var z = temp[0];
	} else {
		var z = this.xmlDoc.documentElement;
	}
	if (z) {
		this._retry = false;
		return z;
	}
	if ((_isIE) && (!this._retry)) {
		var xmlString = this.xmlDoc.responseText;
		var oldObj = this.xmlDoc;
		this._retry = true;
		this.xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		this.xmlDoc.async = false;
		this.xmlDoc["loadXM" + "L"](xmlString);
		return this.getXMLTopNode(tagName, oldObj);
	}
	dhtmlxError.throwError("LoadXML", "Incorrect XML", [(oldObj || this.xmlDoc), this.mainObject]);
	return document.createElement("DIV");
};
dtmlXMLLoaderObject.prototype.loadXMLString = function (xmlString) {
	try {
		var parser = new DOMParser();
		this.xmlDoc = parser.parseFromString(xmlString, "text/xml");
	}
	catch (e) {
		this.xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		this.xmlDoc.async = this.async;
		this.xmlDoc["loadXM" + "L"](xmlString);
	}
	this.onloadAction(this.mainObject, null, null, null, this);
	if (this.waitCall) {
		this.waitCall();
		this.waitCall = null;
	}
};
dtmlXMLLoaderObject.prototype.loadXML = function (filePath, postMode, postVars, rpc) {
	if (this.rSeed) {
		filePath += ((filePath.indexOf("?") != -1) ? "&" : "?") + "a_dhx_rSeed=" + (new Date()).valueOf();
	}
	this.filePath = filePath;
	if ((!_isIE) && (window.XMLHttpRequest)) {
		this.xmlDoc = new XMLHttpRequest();
	} else {
		if (document.implementation && document.implementation.createDocument) {
			this.xmlDoc = document.implementation.createDocument("", "", null);
			this.xmlDoc.onload = new this.waitLoadFunction(this);
			this.xmlDoc.load(filePath);
			return;
		} else {
			this.xmlDoc = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	if (this.async) {
		this.xmlDoc.onreadystatechange = new this.waitLoadFunction(this);
	}
	this.xmlDoc.open(postMode ? "POST" : "GET", filePath, this.async);
	if (rpc) {
		this.xmlDoc.setRequestHeader("User-Agent", "dhtmlxRPC v0.1 (" + navigator.userAgent + ")");
		this.xmlDoc.setRequestHeader("Content-type", "text/xml");
	} else {
		if (postMode) {
			this.xmlDoc.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		}
	}
	this.xmlDoc.send(null || postVars);
	if (!this.async) {
		(new this.waitLoadFunction(this))();
	}
};
dtmlXMLLoaderObject.prototype.destructor = function () {
	this.onloadAction = null;
	this.mainObject = null;
	this.xmlDoc = null;
	return null;
};
function callerFunction(funcObject, dhtmlObject) {
	this.handler = function (e) {
		if (!e) {
			e = window.event;
		}
		funcObject(e, dhtmlObject);
		return true;
	};
	return this.handler;
}
function getAbsoluteLeft(htmlObject) {
	var xPos = htmlObject.offsetLeft;
	var temp = htmlObject.offsetParent;
	while (temp != null) {
		xPos += temp.offsetLeft;
		temp = temp.offsetParent;
	}
	return xPos;
}
function getAbsoluteTop(htmlObject) {
	var yPos = htmlObject.offsetTop;
	var temp = htmlObject.offsetParent;
	while (temp != null) {
		yPos += temp.offsetTop;
		temp = temp.offsetParent;
	}
	return yPos;
}
function convertStringToBoolean(inputString) {
	if (typeof (inputString) == "string") {
		inputString = inputString.toLowerCase();
	}
	switch (inputString) {
	  case "1":
	  case "true":
	  case "yes":
	  case "y":
	  case 1:
	  case true:
		return true;
		break;
	  default:
		return false;
	}
}
function getUrlSymbol(str) {
	if (str.indexOf("?") != -1) {
		return "&";
	} else {
		return "?";
	}
}
function dhtmlDragAndDropObject() {
	if (window.dhtmlDragAndDrop) {
		return window.dhtmlDragAndDrop;
	}
	this.lastLanding = 0;
	this.dragNode = 0;
	this.dragStartNode = 0;
	this.dragStartObject = 0;
	this.tempDOMU = null;
	this.tempDOMM = null;
	this.waitDrag = 0;
	window.dhtmlDragAndDrop = this;
	return this;
}
dhtmlDragAndDropObject.prototype.removeDraggableItem = function (htmlNode) {
	htmlNode.onmousedown = null;
	htmlNode.dragStarter = null;
	htmlNode.dragLanding = null;
};
dhtmlDragAndDropObject.prototype.addDraggableItem = function (htmlNode, dhtmlObject) {
	htmlNode.onmousedown = this.preCreateDragCopy;
	htmlNode.dragStarter = dhtmlObject;
	this.addDragLanding(htmlNode, dhtmlObject);
};
dhtmlDragAndDropObject.prototype.addDragLanding = function (htmlNode, dhtmlObject) {
	htmlNode.dragLanding = dhtmlObject;
};
dhtmlDragAndDropObject.prototype.preCreateDragCopy = function (e) {
	if (e && (e || event).button == 2) {
		return;
	}
	if (window.dhtmlDragAndDrop.waitDrag) {
		window.dhtmlDragAndDrop.waitDrag = 0;
		document.body.onmouseup = window.dhtmlDragAndDrop.tempDOMU;
		document.body.onmousemove = window.dhtmlDragAndDrop.tempDOMM;
		return false;
	}
	window.dhtmlDragAndDrop.waitDrag = 1;
	window.dhtmlDragAndDrop.tempDOMU = document.body.onmouseup;
	window.dhtmlDragAndDrop.tempDOMM = document.body.onmousemove;
	window.dhtmlDragAndDrop.dragStartNode = this;
	window.dhtmlDragAndDrop.dragStartObject = this.dragStarter;
	document.body.onmouseup = window.dhtmlDragAndDrop.preCreateDragCopy;
	document.body.onmousemove = window.dhtmlDragAndDrop.callDrag;
	if ((e) && (e.preventDefault)) {
		e.preventDefault();
		return false;
	}
	return false;
};
dhtmlDragAndDropObject.prototype.callDrag = function (e) {
	if (!e) {
		e = window.event;
	}
	dragger = window.dhtmlDragAndDrop;
	if ((e.button == 0) && (_isIE)) {
		return dragger.stopDrag();
	}
	if (!dragger.dragNode && dragger.waitDrag) {
		dragger.dragNode = dragger.dragStartObject._createDragNode(dragger.dragStartNode, e);
		if (!dragger.dragNode) {
			return dragger.stopDrag();
		}
		dragger.gldragNode = dragger.dragNode;
		document.body.appendChild(dragger.dragNode);
		document.body.onmouseup = dragger.stopDrag;
		dragger.waitDrag = 0;
		dragger.dragNode.pWindow = window;
		dragger.initFrameRoute();
	}
	if (dragger.dragNode.parentNode != window.document.body) {
		var grd = dragger.gldragNode;
		if (dragger.gldragNode.old) {
			grd = dragger.gldragNode.old;
		}
		grd.parentNode.removeChild(grd);
		var oldBody = dragger.dragNode.pWindow;
		if (_isIE) {
			var div = document.createElement("Div");
			div.innerHTML = dragger.dragNode.outerHTML;
			dragger.dragNode = div.childNodes[0];
		} else {
			dragger.dragNode = dragger.dragNode.cloneNode(true);
		}
		dragger.dragNode.pWindow = window;
		dragger.gldragNode.old = dragger.dragNode;
		document.body.appendChild(dragger.dragNode);
		oldBody.dhtmlDragAndDrop.dragNode = dragger.dragNode;
	}
	dragger.dragNode.style.left = e.clientX + 15 + (dragger.fx ? dragger.fx * (-1) : 0) + (document.body.scrollLeft || document.documentElement.scrollLeft) + "px";
	dragger.dragNode.style.top = e.clientY + 3 + (dragger.fy ? dragger.fy * (-1) : 0) + (document.body.scrollTop || document.documentElement.scrollTop) + "px";
	if (!e.srcElement) {
		var z = e.target;
	} else {
		z = e.srcElement;
	}
	dragger.checkLanding(z, e);
};
dhtmlDragAndDropObject.prototype.calculateFramePosition = function (n) {
	if (window.name) {
		var el = parent.frames[window.name].frameElement.offsetParent;
		var fx = 0;
		var fy = 0;
		while (el) {
			fx += el.offsetLeft;
			fy += el.offsetTop;
			el = el.offsetParent;
		}
		if ((parent.dhtmlDragAndDrop)) {
			var ls = parent.dhtmlDragAndDrop.calculateFramePosition(1);
			fx += ls.split("_")[0] * 1;
			fy += ls.split("_")[1] * 1;
		}
		if (n) {
			return fx + "_" + fy;
		} else {
			this.fx = fx;
		}
		this.fy = fy;
	}
	return "0_0";
};
dhtmlDragAndDropObject.prototype.checkLanding = function (htmlObject, e) {
	if ((htmlObject) && (htmlObject.dragLanding)) {
		if (this.lastLanding) {
			this.lastLanding.dragLanding._dragOut(this.lastLanding);
		}
		this.lastLanding = htmlObject;
		this.lastLanding = this.lastLanding.dragLanding._dragIn(this.lastLanding, this.dragStartNode, e.clientX, e.clientY, e);
		this.lastLanding_scr = (_isIE ? e.srcElement : e.target);
	} else {
		if ((htmlObject) && (htmlObject.tagName != "BODY")) {
			this.checkLanding(htmlObject.parentNode, e);
		} else {
			if (this.lastLanding) {
				this.lastLanding.dragLanding._dragOut(this.lastLanding, e.clientX, e.clientY, e);
			}
			this.lastLanding = 0;
			if (this._onNotFound) {
				this._onNotFound();
			}
		}
	}
};
dhtmlDragAndDropObject.prototype.stopDrag = function (e, mode) {
	dragger = window.dhtmlDragAndDrop;
	if (!mode) {
		dragger.stopFrameRoute();
		var temp = dragger.lastLanding;
		dragger.lastLanding = null;
		if (temp) {
			temp.dragLanding._drag(dragger.dragStartNode, dragger.dragStartObject, temp, (_isIE ? event.target : e.target));
		}
	}
	dragger.lastLanding = null;
	if ((dragger.dragNode) && (dragger.dragNode.parentNode == document.body)) {
		dragger.dragNode.parentNode.removeChild(dragger.dragNode);
	}
	dragger.dragNode = 0;
	dragger.gldragNode = 0;
	dragger.fx = 0;
	dragger.fy = 0;
	dragger.dragStartNode = 0;
	dragger.dragStartObject = 0;
	document.body.onmouseup = dragger.tempDOMU;
	document.body.onmousemove = dragger.tempDOMM;
	dragger.tempDOMU = null;
	dragger.tempDOMM = null;
	dragger.waitDrag = 0;
};
dhtmlDragAndDropObject.prototype.stopFrameRoute = function (win) {
	if (win) {
		window.dhtmlDragAndDrop.stopDrag(1, 1);
	}
	for (var i = 0; i < window.frames.length; i++) {
		if ((window.frames[i] != win) && (window.frames[i].dhtmlDragAndDrop)) {
			window.frames[i].dhtmlDragAndDrop.stopFrameRoute(window);
		}
	}
	if ((parent.dhtmlDragAndDrop) && (parent != window) && (parent != win)) {
		parent.dhtmlDragAndDrop.stopFrameRoute(window);
	}
};
dhtmlDragAndDropObject.prototype.initFrameRoute = function (win, mode) {
	if (win) {
		window.dhtmlDragAndDrop.preCreateDragCopy();
		window.dhtmlDragAndDrop.dragStartNode = win.dhtmlDragAndDrop.dragStartNode;
		window.dhtmlDragAndDrop.dragStartObject = win.dhtmlDragAndDrop.dragStartObject;
		window.dhtmlDragAndDrop.dragNode = win.dhtmlDragAndDrop.dragNode;
		window.dhtmlDragAndDrop.gldragNode = win.dhtmlDragAndDrop.dragNode;
		window.document.body.onmouseup = window.dhtmlDragAndDrop.stopDrag;
		window.waitDrag = 0;
		if (((!_isIE) && (mode)) && ((!_isFF) || (_FFrv < 1.8))) {
			window.dhtmlDragAndDrop.calculateFramePosition();
		}
	}
	if ((parent.dhtmlDragAndDrop) && (parent != window) && (parent != win)) {
		parent.dhtmlDragAndDrop.initFrameRoute(window);
	}
	for (var i = 0; i < window.frames.length; i++) {
		if ((window.frames[i] != win) && (window.frames[i].dhtmlDragAndDrop)) {
			window.frames[i].dhtmlDragAndDrop.initFrameRoute(window, ((!win || mode) ? 1 : 0));
		}
	}
};
var _isFF = false;
var _isIE = false;
var _isOpera = false;
var _isKHTML = false;
var _isMacOS = false;
if (navigator.userAgent.indexOf("Macintosh") != -1) {
	_isMacOS = true;
}
if ((navigator.userAgent.indexOf("Safari") != -1) || (navigator.userAgent.indexOf("Konqueror") != -1)) {
	var _KHTMLrv = parseFloat(navigator.userAgent.substr(navigator.userAgent.indexOf("Safari") + 7, 5));
	if (_KHTMLrv > 525) {
		_isFF = true;
		var _FFrv = 1.9;
	} else {
		_isKHTML = true;
	}
} else {
	if (navigator.userAgent.indexOf("Opera") != -1) {
		_isOpera = true;
		_OperaRv = parseFloat(navigator.userAgent.substr(navigator.userAgent.indexOf("Opera") + 6, 3));
	} else {
		if (navigator.appName.indexOf("Microsoft") != -1) {
			_isIE = true;
		} else {
			_isFF = true;
			var _FFrv = parseFloat(navigator.userAgent.split("rv:")[1]);
		}
	}
}
function isIE() {
	if (navigator.appName.indexOf("Microsoft") != -1) {
		if (navigator.userAgent.indexOf("Opera") == -1) {
			return true;
		}
	}
	return false;
}
dtmlXMLLoaderObject.prototype.doXPath = function (xpathExp, docObj, namespace, result_type) {
	if ((_isKHTML)) {
		return this.doXPathOpera(xpathExp, docObj);
	}
	if (_isIE) {
		if (!docObj) {
			if (!this.xmlDoc.nodeName) {
				docObj = this.xmlDoc.responseXML;
			} else {
				docObj = this.xmlDoc;
			}
		}
		if (!docObj) {
			dhtmlxError.throwError("LoadXML", "Incorrect XML", [(docObj || this.xmlDoc), this.mainObject]);
		}
		if (namespace != null) {
			docObj.setProperty("SelectionNamespaces", "xmlns:xsl='" + namespace + "'");
		}
		if (result_type == "single") {
			return docObj.selectSingleNode(xpathExp);
		} else {
			return docObj.selectNodes(xpathExp) || new Array(0);
		}
	} else {
		var nodeObj = docObj;
		if (!docObj) {
			if (!this.xmlDoc.nodeName) {
				docObj = this.xmlDoc.responseXML;
			} else {
				docObj = this.xmlDoc;
			}
		}
		if (!docObj) {
			dhtmlxError.throwError("LoadXML", "Incorrect XML", [(docObj || this.xmlDoc), this.mainObject]);
		}
		if (docObj.nodeName.indexOf("document") != -1) {
			nodeObj = docObj;
		} else {
			nodeObj = docObj;
			docObj = docObj.ownerDocument;
		}
		var retType = XPathResult.ANY_TYPE;
		if (result_type == "single") {
			retType = XPathResult.FIRST_ORDERED_NODE_TYPE;
		}
		var rowsCol = new Array();
		var col = docObj.evaluate(xpathExp, nodeObj, function (pref) {
			return namespace;
		}, retType, null);
		if (retType == XPathResult.FIRST_ORDERED_NODE_TYPE) {
			return col.singleNodeValue;
		}
		var thisColMemb = col.iterateNext();
		while (thisColMemb) {
			rowsCol[rowsCol.length] = thisColMemb;
			thisColMemb = col.iterateNext();
		}
		return rowsCol;
	}
};
function _dhtmlxError(type, name, params) {
	if (!this.catches) {
		this.catches = new Array();
	}
	return this;
}
_dhtmlxError.prototype.catchError = function (type, func_name) {
	this.catches[type] = func_name;
};
_dhtmlxError.prototype.throwError = function (type, name, params) {
	if (this.catches[type]) {
		return this.catches[type](type, name, params);
	}
	if (this.catches["ALL"]) {
		return this.catches["ALL"](type, name, params);
	}
	alert("Error type: " + arguments[0] + "\nDescription: " + arguments[1]);
	return null;
};
window.dhtmlxError = new _dhtmlxError();
dtmlXMLLoaderObject.prototype.doXPathOpera = function (xpathExp, docObj) {
	var z = xpathExp.replace(/[\/]+/gi, "/").split("/");
	var obj = null;
	var i = 1;
	if (!z.length) {
		return [];
	}
	if (z[0] == ".") {
		obj = [docObj];
	} else {
		if (z[0] == "") {
			obj = (this.xmlDoc.responseXML || this.xmlDoc).getElementsByTagName(z[i].replace(/\[[^\]]*\]/g, ""));
			i++;
		} else {
			return [];
		}
	}
	for (i; i < z.length; i++) {
		obj = this._getAllNamedChilds(obj, z[i]);
	}
	if (z[i - 1].indexOf("[") != -1) {
		obj = this._filterXPath(obj, z[i - 1]);
	}
	return obj;
};
dtmlXMLLoaderObject.prototype._filterXPath = function (a, b) {
	var c = new Array();
	var b = b.replace(/[^\[]*\[\@/g, "").replace(/[\[\]\@]*/g, "");
	for (var i = 0; i < a.length; i++) {
		if (a[i].getAttribute(b)) {
			c[c.length] = a[i];
		}
	}
	return c;
};
dtmlXMLLoaderObject.prototype._getAllNamedChilds = function (a, b) {
	var c = new Array();
	if (_isKHTML) {
		b = b.toUpperCase();
	}
	for (var i = 0; i < a.length; i++) {
		for (var j = 0; j < a[i].childNodes.length; j++) {
			if (_isKHTML) {
				if (a[i].childNodes[j].tagName && a[i].childNodes[j].tagName.toUpperCase() == b) {
					c[c.length] = a[i].childNodes[j];
				}
			} else {
				if (a[i].childNodes[j].tagName == b) {
					c[c.length] = a[i].childNodes[j];
				}
			}
		}
	}
	return c;
};
function dhtmlXHeir(a, b) {
	for (var c in b) {
		if (typeof (b[c]) == "function") {
			a[c] = b[c];
		}
	}
	return a;
}
function dhtmlxEvent(el, event, handler) {
	if (el.addEventListener) {
		el.addEventListener(event, handler, false);
	} else {
		if (el.attachEvent) {
			el.attachEvent("on" + event, handler);
		}
	}
}
dtmlXMLLoaderObject.prototype.xslDoc = null;
dtmlXMLLoaderObject.prototype.setXSLParamValue = function (paramName, paramValue, xslDoc) {
	if (!xslDoc) {
		xslDoc = this.xslDoc;
	}
	if (xslDoc.responseXML) {
		xslDoc = xslDoc.responseXML;
	}
	var item = this.doXPath("/xsl:stylesheet/xsl:variable[@name='" + paramName + "']", xslDoc, "http://www.w3.org/1999/XSL/Transform", "single");
	if (item != null) {
		item.firstElementChild.nodeValue = paramValue;
	}
};
dtmlXMLLoaderObject.prototype.doXSLTransToObject = function (xslDoc, xmlDoc) {
	if (!xslDoc) {
		xslDoc = this.xslDoc;
	}
	if (xslDoc.responseXML) {
		xslDoc = xslDoc.responseXML;
	}
	if (!xmlDoc) {
		xmlDoc = this.xmlDoc;
	}
	if (xmlDoc.responseXML) {
		xmlDoc = xmlDoc.responseXML;
	}
	if (!isIE()) {
		if (!this.XSLProcessor) {
			this.XSLProcessor = new XSLTProcessor();
			this.XSLProcessor.importStylesheet(xslDoc);
		}
		var result = this.XSLProcessor.transformToDocument(xmlDoc);
	} else {
		var result = new ActiveXObject("Msxml2.DOMDocument.3.0");
		xmlDoc.transformNodeToObject(xslDoc, result);
	}
	return result;
};
dtmlXMLLoaderObject.prototype.doXSLTransToString = function (xslDoc, xmlDoc) {
	return this.doSerialization(this.doXSLTransToObject(xslDoc, xmlDoc));
};
dtmlXMLLoaderObject.prototype.doSerialization = function (xmlDoc) {
	if (!isIE()) {
		var xmlSerializer = new XMLSerializer();
		return xmlSerializer.serializeToString(xmlDoc);
	} else {
		return xmlDoc.xml;
	}
};
