/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function dhtmlXComboFromSelect(parent, size) {

	if (typeof (parent) == "string") {
		parent = document.getElementById(parent);
	}
	size = size || parent.getAttribute("width") || (window.getComputedStyle ? window.getComputedStyle(parent, null)["width"] : (parent.currentStyle ? parent.currentStyle["width"] : 0));
	if ((!size) || (size == "auto")) {
		size = parent.offsetWidth || 100;
	}
	var z = document.createElement("SPAN");
	parent.parentNode.insertBefore(z, parent);
	parent.style.display = "none";
	var s_type = parent.getAttribute("opt_type");
	var w = new dhtmlXCombo(z, parent.name, size, s_type, parent.tabIndex);
	var x = new Array();
	var sel = 0;
	for (var i = 0; i < parent.options.length; i++) {
		if (parent.options[i].selected) {
			sel = i;
		}
		var label = parent.options[i].innerHTML;
		var val = parent.options[i].getAttribute("value");
		if ((typeof (val) == "undefined") || (val === null)) {
			val = label;
		}
		x[i] = {value:val, text:label, img_src:parent.options[i].getAttribute("img_src")};
	}
	
	w.addOption(x);
	parent.parentNode.removeChild(parent);
	w.selectOption(sel, null, true);
	if (parent.onchange) {
		w.attachEvent("onChange", parent.onchange);
	}

	return w;
}
var dhtmlXCombo_optionTypes = [];
function dhtmlXCombo(parent, name, width, optionType, tabIndex) {
	if (typeof (parent) == "string") {
		parent = document.getElementById(parent);
	}
	this.dhx_Event();
	this.optionType = (optionType != window.undefined && dhtmlXCombo_optionTypes[optionType]) ? optionType : "default";
	this._optionObject = dhtmlXCombo_optionTypes[this.optionType];
	this._disabled = false;
	if (!window.dhx_glbSelectAr) {
		window.dhx_glbSelectAr = new Array();
		window.dhx_openedSelect = null;
		window.dhx_SelectId = 1;
		dhtmlxEvent(document.body, "click", this.closeAll);
		dhtmlxEvent(document.body, "keydown", function (e) {
			try {
				if ((e || event).keyCode == 9) {
					window.dhx_glbSelectAr[0].closeAll();
				}
			}
			catch (e) {
			}
			return true;
		});
	}
	if (parent.tagName == "SELECT") {
		dhtmlXComboFromSelect(parent);
	} else {
		this._createSelf(parent, name, width, tabIndex);
		dhx_glbSelectAr.push(this);
	}
}
dhtmlXCombo.prototype.setSize = function (new_size) {
	this.DOMlist.style.width = new_size + "px";
	if (this.DOMlistF) {
		this.DOMlistF.style.width = new_size + "px";
	}
	this.DOMelem.style.width = new_size + "px";
	this.DOMelem_input.style.width = (new_size - 19) + "px";
};
dhtmlXCombo.prototype.enableFilteringMode = function (mode, url, cache, autosubload) {
	this._filter = convertStringToBoolean(mode);
	if (url) {
		this._xml = url;
		this._autoxml = convertStringToBoolean(autosubload);
	}
	if (convertStringToBoolean(cache)) {
		this._xmlCache = [];
	}
};
dhtmlXCombo.prototype.setFilteringParam = function (name, value) {
	if (!this._prs) {
		this._prs = [];
	}
	this._prs.push([name, value]);
};
dhtmlXCombo.prototype.disable = function (mode) {
	var z = convertStringToBoolean(mode);
	if (this._disabled == z) {
		return;
	}
	this.DOMelem_input.disabled = z;
	this._disabled = z;
};
dhtmlXCombo.prototype.readonly = function (mode, autosearch) {
	this.DOMelem_input.readOnly = mode ? true : false;
	if (autosearch === false) {
		this.DOMelem.onkeyup = function (ev) {
		};
	} else {
		var that = this;
		this.DOMelem.onkeyup = function (ev) {
			ev = ev || window.event;
			if (ev.keyCode != 9) {
				ev.cancelBubble = true;
			}
			if ((ev.keyCode >= 48 && ev.keyCode <= 57) || (ev.keyCode >= 65 && ev.keyCode <= 90)) {
				for (var i = 0; i < that.optionsArr.length; i++) {
					var text = that.optionsArr[i].text;
					if (text.toString().toUpperCase().indexOf(String.fromCharCode(ev.keyCode)) == 0) {
						that.selectOption(i);
						break;
					}
				}
				ev.cancelBubble = true;
			}
		};
	}
};
dhtmlXCombo.prototype.getOption = function (value) {
	for (var i = 0; i < this.optionsArr.length; i++) {
		if (this.optionsArr[i].value == value) {
			return this.optionsArr[i];
		}
	}
	
	return null;
};
dhtmlXCombo.prototype.getOptionByLabel = function (value) {
	value = value.replace(/&/g, "&amp;");
	for (var i = 0; i < this.optionsArr.length; i++) {
		if (this.optionsArr[i].text == value) {
			return this.optionsArr[i];
		}
	}
	return null;
};
dhtmlXCombo.prototype.getOptionByIndex = function (ind) {
	return this.optionsArr[ind];
};
dhtmlXCombo.prototype.clearAll = function (all) {
	if (all) {
		this.setComboText("");
	}
	this.optionsArr = new Array();
	this.redrawOptions();
	if (all) {
		this._confirmSelection();
	}
};
dhtmlXCombo.prototype.deleteOption = function (value) {
	var ind = this.getIndexByValue(value);
	if (ind < 0) {
		return;
	}
	if (this.optionsArr[ind] == this._selOption) {
		this._selOption = null;
	}
	this.optionsArr.splice(ind, 1);
	this.redrawOptions();
};
dhtmlXCombo.prototype.render = function (mode) {
	this._skiprender = (!convertStringToBoolean(mode));
	this.redrawOptions();
};
dhtmlXCombo.prototype.updateOption = function (oldvalue, avalue, atext, acss) {
	var dOpt = this.getOption(oldvalue);
	if (typeof (avalue) != "object") {
		avalue = {text:atext, value:avalue, css:acss};
	}
	dOpt.setValue(avalue);
	this.redrawOptions();
	
};
dhtmlXCombo.prototype.addOption = function (options) {
	if (!arguments[0].length || typeof (arguments[0]) != "object") {
		args = [arguments];
	} else {
		args = options;
	}
	this.render(false);
	for (var i = 0; i < args.length; i++) {
		var attr = args[i];
		if (attr.length) {
			attr.value = attr[0] || "";
			attr.text = attr[1] || "";
			attr.css = attr[2] || "";
		}
		
		this._addOption(attr);
	}
	this.render(true);
};
dhtmlXCombo.prototype._addOption = function (attr) {
	dOpt = new this._optionObject();
	this.optionsArr.push(dOpt);
	dOpt.setValue.apply(dOpt, [attr]);
	this.redrawOptions();
};
dhtmlXCombo.prototype.getIndexByValue = function (val) {
	for (var i = 0; i < this.optionsArr.length; i++) {
		if (this.optionsArr[i].value == val) {
			return i;
		}
	}
	return -1;
};
dhtmlXCombo.prototype.getSelectedValue = function () {
	return (this._selOption ? this._selOption.value : null);
};
dhtmlXCombo.prototype.getComboText = function () {
	return this.DOMelem_input.value;
};

dhtmlXCombo.prototype.setComboText = function (text) {
	this.DOMelem_input.value = text;
};
dhtmlXCombo.prototype.setComboValue = function (text) {
	this.setComboText(text);
	for (var i = 0; i < this.optionsArr.length; i++) {
		if (this.optionsArr[i].data()[0] == text) {
			return this.selectOption(i, null, true);
		}
	}
	this.DOMelem_hidden_input.value = text;
};
dhtmlXCombo.prototype.getActualValue = function () {
	return this.DOMelem_hidden_input.value;
};
dhtmlXCombo.prototype.getSelectedText = function () {
	
	return (this._selOption ? this._selOption.text : "");
};
dhtmlXCombo.prototype.getSelectedIndex = function () {
	for (var i = 0; i < this.optionsArr.length; i++) {
		if (this.optionsArr[i] == this._selOption) {
			return i;
		}
	}
	return -1;
};

dhtmlXCombo.prototype.setName = function (name) {
	this.DOMforSbm.name = name;
	this.name = name;
};
dhtmlXCombo.prototype.show = function (mode) {
	if (convertStringToBoolean(mode)) {
		this.DOMelem.style.display = "";
	} else {
		this.DOMelem.style.display = "none";
	}
};
dhtmlXCombo.prototype.destructor = function () {
	var _sID = this._inID;
	this.DOMParent.removeChild(this.DOMelem);
	this.DOMlist.parentNode.removeChild(this.DOMlist);
	var s = dhx_glbSelectAr;
	this.DOMParent = this.DOMlist = this.DOMelem = 0;
	this.DOMlist.combo = this.DOMelem.combo = 0;
	for (var i = 0; i < s.length; i++) {
		if (s[i]._inID == _sID) {
			s[i] = null;
			s.splice(i, 1);
			return;
		}
	}
};
dhtmlXCombo.prototype._createSelf = function (selParent, name, width, tab) {
	if (width.toString().indexOf("%") != -1) {
		var self = this;
		var resWidht = parseInt(width) / 100;
		window.setInterval(function () {
			var ts = selParent.parentNode.offsetWidth * resWidht - 2;
			if (ts == self._lastTs) {
				return;
			}
			self.setSize(self._lastTs = ts);
		}, 500);
		var width = parseInt(selParent.offsetWidth);
	}
	var width = parseInt(width || 100);
	this.ListPosition = "Bottom";
	this.DOMParent = selParent;
	this._inID = null;
	this.name = name;
	this._selOption = null;
	this.optionsArr = Array();
	var opt = new this._optionObject();
	opt.DrawHeader(this, name, width, tab);
	this.DOMlist = document.createElement("DIV");
	this.DOMlist.className = "dhx_combo_list";
	this.DOMlist.style.width = width - (_isIE ? 0 : 0) + "px";
	if (_isOpera || _isKHTML) {
		this.DOMlist.style.overflow = "auto";
	}
	this.DOMlist.style.display = "none";
	document.body.insertBefore(this.DOMlist, document.body.firstElementChild);
	if (_isIE) {
		this.DOMlistF = document.createElement("IFRAME");
		this.DOMlistF.style.border = "0px";
		this.DOMlistF.className = "dhx_combo_list";
		this.DOMlistF.style.width = width - (_isIE ? 0 : 0) + "px";
		this.DOMlistF.style.display = "none";
		this.DOMlistF.src = "javascript:false;";
		document.body.insertBefore(this.DOMlistF, document.body.firstElementChild);
	}
	this.DOMlist.combo = this.DOMelem.combo = this;
	this.DOMelem_input.onkeydown = this._onKey;
	this.DOMelem_input.onkeypress = this._onKeyF;
	this.DOMelem_input.onblur = this._onBlur;
	this.DOMelem.onclick = this._toggleSelect;
	this.DOMlist.onclick = this._selectOption;
	
	this.DOMlist.onmousedown = function () {
		this._skipBlur = true;
	};
	this.DOMlist.onkeydown = function (e) {
		this.combo.DOMelem_input.focus();
		(e || event).cancelBubble = true;
		this.combo.DOMelem_input.onkeydown(e);
	};
	 this.DOMlist.onmouseover = this._listOver;
	
};
dhtmlXCombo.prototype._listOver = function (e) {
	e = e || event;
	
	e.cancelBubble = true;
	var node = (_isIE ? event.target : e.target);
	var that = this.combo;
	if (node.parentNode == that.DOMlist) {
		that.unSelectOption();
		var i = 0;
		for (i; i < that.DOMlist.childNodes.length; i++) {
			if (that.DOMlist.childNodes[i] == node) {
				break;
			}
		}
		var z = that.optionsArr[i];
		that._selOption = z;
		that._selOption.select();
		if ((that._autoxml) && ((i + 1) == that._lastLength)) {
			that._fetchOptions(i + 1, that._lasttext || "");
		}
	}
};
dhtmlXCombo.prototype._positList = function () {
	var pos = this.getPosition(this.DOMelem);
	if (this.ListPosition == "Bottom") {
		this.DOMlist.style.top = pos[1] + this.DOMelem.offsetHeight + "px";
		this.DOMlist.style.left = pos[0] + "px";
	} else {
		if (this.ListPosition == "Top") {
			this.DOMlist.style.top = pos[1] - this.DOMlist.offsetHeight + "px";
			this.DOMlist.style.left = pos[0] + "px";
		} else {
			this.DOMlist.style.top = pos[1] + "px";
			this.DOMlist.style.left = pos[0] + this.DOMelem.offsetWidth + "px";
		}
	}
};
dhtmlXCombo.prototype.getPosition = function (oNode, pNode) {
	if (!pNode) {
		var pNode = document.body;
	}
	var oCurrentNode = oNode;
	var iLeft = 0;
	var iTop = 0;
	while ((oCurrentNode) && (oCurrentNode != pNode)) {
		iLeft += oCurrentNode.offsetLeft - oCurrentNode.scrollLeft;
		iTop += oCurrentNode.offsetTop - oCurrentNode.scrollTop;
		oCurrentNode = oCurrentNode.offsetParent;
	}
	if (pNode == document.body) {
		if (_isIE) {
			if (document.documentElement.scrollTop) {
				iTop += document.documentElement.scrollTop;
			}
			if (document.documentElement.scrollLeft) {
				iLeft += document.documentElement.scrollLeft;
			}
		} else {
			if (!_isFF) {
				iLeft += document.body.offsetLeft;
				iTop += document.body.offsetTop;
			}
		}
	}
	return new Array(iLeft, iTop);
};
dhtmlXCombo.prototype._correctSelection = function () {
	if (this.getComboText() != "") {
		for (var i = 0; i < this.optionsArr.length; i++) {
			if (!this.optionsArr[i].isHidden()) {
				return this.selectOption(i, true, false);
			}
		}
	}
	this.unSelectOption();
};
dhtmlXCombo.prototype.selectNext = function (step) {
	var z = this.getSelectedIndex() + step;
	while (this.optionsArr[z]) {
		if (!this.optionsArr[z].isHidden()) {
			return this.selectOption(z, false, false);
		}
		z += step;
	}
};
dhtmlXCombo.prototype._onKeyF = function (e) {

	var that = this.parentNode.combo;
	
	var ev = e || event;
	ev.cancelBubble = true;
	if (ev.keyCode == "13" || ev.keyCode == "9") {
		that._confirmSelection();
		that.closeAll();
	} else {
		if (ev.keyCode == "27") {
			that._resetSelection();
			that.closeAll();
		} else {
			that._activeMode = true;
		}
	}
	if (ev.keyCode == "13" || ev.keyCode == "27") {
		that.callEvent("onKeyPressed", [ev.keyCode]);
		return false;
	}
	return true;
};
dhtmlXCombo.prototype._onKey = function (e) {
	var that = this.parentNode.combo;
	(e || event).cancelBubble = true;
	var ev = (e || event).keyCode;
	if (ev > 15 && ev < 19) {
		return true;
	}
	if (ev == 27) {
		return;
	}
	if ((that.DOMlist.style.display != "block") && (ev != "13") && (ev != "9") && ((!that._filter) || (that._filterAny))) {
		that.DOMelem.onclick(e || event);
	}
	if ((ev != "13") && (ev != "9")) {
		window.setTimeout(function () {
			that._onKeyB(ev);
		}, 1);
		if (ev == "40" || ev == "38") {
			return false;
		}
	} else {
		if (ev == 9) {
			that.closeAll();
			(e || event).cancelBubble = false;
		}
	}
};
dhtmlXCombo.prototype._onKeyB = function (ev) {

	if (ev == "40") {
		var z = this.selectNext(1);
	} else {
		if (ev == "38") {
			this.selectNext(-1);
		} else {
			this.callEvent("onKeyPressed", [ev]);
			if (this._filter) {
			
				return this.filterSelf((ev == 8) || (ev == 46));
			}
			for (var i = 0; i < this.optionsArr.length; i++) {
				if (this.optionsArr[i].data()[1] == this.DOMelem_input.value) {
					this.selectOption(i, false, false);
					return false;
				}
			}
			this.unSelectOption();
		}
	}
	return true;
};
dhtmlXCombo.prototype._onBlur = function () {
	var self = this.parentNode._self;
	window.setTimeout(function () {
		if (self.DOMlist._skipBlur) {
			return !(self.DOMlist._skipBlur = false);
		}
		self._confirmSelection();
		self.callEvent("onBlur", []);
	}, 100);
};


dhtmlXCombo.prototype.redrawOptions = function () {
	if (this._skiprender) {
		return;
	}
	for (var i = this.DOMlist.childNodes.length - 1; i >= 0; i--) {
		this.DOMlist.removeChild(this.DOMlist.childNodes[i]);
	}
	for (var i = 0; i < this.optionsArr.length; i++) {
		this.DOMlist.appendChild(this.optionsArr[i].render());
		
	}
	
};
dhtmlXCombo.prototype.loadXML = function (url, afterCall) {
	this._load = true;
	if ((this._xmlCache) && (this._xmlCache[url])) {
		this._fillFromXML(this, null, null, null, this._xmlCache[url]);
		if (afterCall) {
			afterCall();
		}
	} else {
		var xml = (new dtmlXMLLoaderObject(this._fillFromXML, this, true, true));
		if (afterCall) {
			xml.waitCall = afterCall;
		}
		if (this._prs) {
			for (var i = 0; i < this._prs.length; i++) {
				url += [getUrlSymbol(url), escape(this._prs[i][0]), "=", escape(this._prs[i][1])].join("");
			}
		}
		xml._cPath = url;
		xml.loadXML(url);
	}
};
dhtmlXCombo.prototype.loadXMLString = function (astring) {
	var xml = (new dtmlXMLLoaderObject(this._fillFromXML, this, true, true));
	xml.loadXMLString(astring);
};
dhtmlXCombo.prototype._fillFromXML = function (obj, b, c, d, xml) {
	if (obj._xmlCache) {
		obj._xmlCache[xml._cPath] = xml;
	}
	xml.getXMLTopNode("complete");
	var top = xml.doXPath("//complete");
	var options = xml.doXPath("//option");
	obj.render(false);
	if ((!top[0]) || (!top[0].getAttribute("add"))) {
		obj.clearAll();
		obj._lastLength = options.length;
		if (obj._xml) {
			if ((!options) || (!options.length)) {
				obj.closeAll();
			} else {
				if (obj._activeMode) {
					obj._positList();
					obj.DOMlist.style.display = "block";
					if (_isIE) {
						obj._IEFix(true);
					}
				}
			}
		}
	} else {
		obj._lastLength += options.length;
	}
	for (var i = 0; i < options.length; i++) {
		var attr = new Object();
		attr.text = options[i].firstElementChild ? options[i].firstElementChild.nodeValue : "";
		for (var j = 0; j < options[i].attributes.length; j++) {
			var a = options[i].attributes[j];
			if (a) {
				attr[a.nodeName] = a.nodeValue;
			}
		}
		obj._addOption(attr);
	}
	obj.render(true);
	if ((obj._load) && (obj._load !== true)) {
		obj.loadXML(obj._load);
	} else {
		obj._load = false;
		if ((!obj._lkmode) && (!obj._filter)) {
			obj._correctSelection();
		}
	}
	var selected = xml.doXPath("//option[@selected]");
	if (selected.length) {
		obj.selectOption(obj.getIndexByValue(selected[0].getAttribute("value")), false, true);
	}
};
dhtmlXCombo.prototype.unSelectOption = function () {
	if (this._selOption) {
		this._selOption.deselect();
	}
	this._selOption = null;
};
dhtmlXCombo.prototype._confirmSelection = function (data, status) {

	if (arguments.length == 0) {
		var z = this.getOptionByLabel(this.DOMelem_input.value);
		data = z ? z.value : this.DOMelem_input.value;
		status = (z == null);
		if (data == this.getActualValue()) {
			return;
		}
	}
	this.DOMelem_hidden_input.value = data;
	this.DOMelem_hidden_input2.value = (status ? "true" : "false");
	this.callEvent("onChange", []);
	this._activeMode = false;
	
};
dhtmlXCombo.prototype._resetSelection = function (data, status) {
	var z = this.getOption(this.DOMelem_hidden_input.value);
	this.setComboValue(z ? z.data()[0] : this.DOMelem_hidden_input.value);
	this.setComboText(z ? z.data()[1] : this.DOMelem_hidden_input.value);
};
dhtmlXCombo.prototype.selectOption = function (ind, filter, conf) {

	if (arguments.length < 3) {
		conf = true;
	}
	this.unSelectOption();
	var z = this.optionsArr[ind];
	if (!z) {
		return;
	}
	this._selOption = z;
	this._selOption.select();
	var corr = this._selOption.content.offsetTop + this._selOption.content.offsetHeight - this.DOMlist.scrollTop - this.DOMlist.offsetHeight;
	
	if (corr > 0) {
		this.DOMlist.scrollTop += corr;
	}
	corr = this.DOMlist.scrollTop - this._selOption.content.offsetTop;
	if (corr > 0) {
		this.DOMlist.scrollTop -= corr;
	}
	var data = this._selOption.data();
	
	if (conf) {
		this.setComboText(data[1]);
		this._confirmSelection(data[0], false);
	}
	if ((this._autoxml) && ((ind + 1) == this._lastLength)) {
		this._fetchOptions(ind + 1, this._lasttext || "");
	}
	if (filter) {
		var text = this.getComboText();
		if (text != data[1]) {
			this.setComboText(data[1]);
			dhtmlXRange(this.DOMelem_input, text.length + 1, data[1].length);
		}
	} else {
		this.setComboText(data[1]);
	
		
	}
	this._selOption.RedrawHeader(this);
		
	this.callEvent("onSelectionChange", []);

};
dhtmlXCombo.prototype._selectOption = function (e) {

	(e || event).cancelBubble = true;
	var node = (_isIE ? event.target : e.target);
	var that = this.combo;
	
	while (!node._self) {
		node = node.parentNode;
		if (!node) {
			return;
		}
	}
	var i = 0;
	for (i; i < that.DOMlist.childNodes.length; i++) {
		if (that.DOMlist.childNodes[i] == node) {
				break;
		}
	}
	that.selectOption(i, false, true);
	that.closeAll();
	that.callEvent("onBlur", []);
	that._activeMode = false;
	that.DOMelem_input.focus();
	
};

dhtmlXCombo.prototype.openSelect = function () {
	if (this._disabled) {
		return;
	}
	this.closeAll();
	this._positList();
	this.DOMlist.style.display = "block";
	this.callEvent("onOpen", []);
	if (_isIE) {
		this._IEFix(true);
	}
	this.DOMelem_input.focus();
	if (this._filter) {
		this.filterSelf();
		
	}
	
	
};
dhtmlXCombo.prototype._toggleSelect = function (e) {
	var that = this.combo;
	
	if (that.DOMlist.style.display == "block") {
		that.closeAll();
	} else {
	
		that.openSelect();
		
		if(that.optionsArr[0].text == ""){
		 that.optionsArr[1].select();
		}else{
		 that.optionsArr[0].select();
		}
	}
	(e || event).cancelBubble = true;
};
dhtmlXCombo.prototype._fetchOptions = function (ind, text) {

	if (text == "") {
		this.closeAll();
		return this.clearAll();
	}
	var url = this._xml + ((this._xml.indexOf("?") != -1) ? "&" : "?") + "pos=" + ind + "&mask=" + encodeURIComponent(text);
	this._lasttext = text;
	if (this._load) {
		this._load = url;
	} else {
		this.loadXML(url);
	}
};
dhtmlXCombo.prototype.filterSelf = function (mode) {
	var text = this.getComboText();
	if (this._xml) {
		this._lkmode = mode;
		this._fetchOptions(0, text);
	}
	try {
		var filter = new RegExp("^" + text, "i");
	}
	catch (e) {
		//var filter = new RegExp("^" + text.replace(/([\[\]\{\}\(\)\+\*\\])/g, "\\$1"));
		var filter = new RegExp("^" + text.replace(/([\[\?\]\{\}\(\)\+\*\\])/g, "\\$1"));
	}
	this.filterAny = false;
	for (var i = 0; i < this.optionsArr.length; i++) {
		var z = filter.test(this.optionsArr[i].text);
		this.filterAny |= z;
		this.optionsArr[i].hide(!z);
		
	}
	if (!this.filterAny) {
		this.closeAll();
		this._activeMode = true;
	} else {
		if (this.DOMlist.style.display != "block") {
		
			this.openSelect();
		}
		if (_isIE) {
			this._IEFix(true);
		}
	}
	if (!mode) {
		this._correctSelection();
	} else {
		this.unSelectOption();
	}
	
};
dhtmlXCombo.prototype._IEFix = function (mode) {
	this.DOMlistF.style.display = (mode ? "block" : "none");
	this.DOMlistF.style.top = this.DOMlist.style.top;
	this.DOMlistF.style.left = this.DOMlist.style.left;
};
dhtmlXCombo.prototype.closeAll = function () {

	if (window.dhx_glbSelectAr) {
		for (var i = 0; i < dhx_glbSelectAr.length; i++) {
			if (dhx_glbSelectAr[i].DOMlist.style.display == "block") {
				dhx_glbSelectAr[i].DOMlist.style.display = "none";
				if (_isIE) {
					dhx_glbSelectAr[i]._IEFix(false);
				}
			}
			dhx_glbSelectAr[i]._activeMode = false;
		}
	}
	
};
function dhtmlXRange(InputId, Start, End) {

	var Input = typeof (InputId) == "object" ? InputId : document.getElementById(InputId);
	try {
		Input.focus();
	}
	catch (e) {
	}
	var Length = Input.value.length;
	Start--;
	if (Start < 0 || Start > End || Start > Length) {
		Start = 0;
	}
	if (End > Length) {
		End = Length;
	}
	if (Input.setSelectionRange) {
		Input.setSelectionRange(Start, End);
	} else {
		if (Input.createTextRange) {
			var range = Input.createTextRange();
			range.moveStart("character", Start);
			range.moveEnd("character", End - Length);
			range.select();
		}
	}
}
dhtmlXCombo_defaultOption = function () {
	this.init();
};
dhtmlXCombo_defaultOption.prototype.init = function () {
	this.value = null;
	this.text = "";
	this.selected = false;
	this.css = "";
};
dhtmlXCombo_defaultOption.prototype.select = function () {
	if (this.content) {
	}
	this.content.className = "dhx_selected_option";
};
dhtmlXCombo_defaultOption.prototype.hide = function (mode) {
	this.render().style.display = mode ? "none" : "";
};
dhtmlXCombo_defaultOption.prototype.isHidden = function () {
	return (this.render().style.display == "none");
};
dhtmlXCombo_defaultOption.prototype.deselect = function () {
	if (this.content) {
		this.render();
	}
	this.content.className = "";
};
dhtmlXCombo_defaultOption.prototype.setValue = function (attr) {
	this.value = attr.value || "";
	this.text = attr.text || "";
	this.css = attr.css || "";
	this.content = null;
};
dhtmlXCombo_defaultOption.prototype.render = function () {
	if (!this.content) {
		this.content = document.createElement("DIV");
		this.content._self = this;
		this.content.style.cssText = "width:100%;overflow:hidden;\"+this.css+\"";
		if (_isOpera || _isKHTML) {
			this.content.style.padding = "2px 0px 2px 0px";
		}
		this.content.innerHTML = this.text;
		
		this._ctext = _isIE ? this.content.innerText : this.content.textContent;
		
	}
	
	return this.content;
};
dhtmlXCombo_defaultOption.prototype.data = function () {
	if (this.content) {
		return [this.value, this._ctext ? this._ctext : this.text];
	}
};
dhtmlXCombo_defaultOption.prototype.DrawHeader = function (self, name, width, tab) {

	var z = document.createElement("DIV");
	z.style.width = width + "px";
	z.className = "dhx_combo_box";
	z._self = self;
	self.DOMelem = z;
	this._DrawHeaderInput(self, name, width, tab);
	this._DrawHeaderButton(self, name, width);
	self.DOMParent.appendChild(self.DOMelem);
};
dhtmlXCombo_defaultOption.prototype._DrawHeaderInput = function (self, name, width, tab) {

	var z = document.createElement("input");
	z.className = "dhx_combo_input";
	z.setAttribute("autocomplete", "off");
	z.type = "text";
	if (tab) {
		z.tabIndex = tab;
	}
	z.style.width = (width - 30) + "px";
	self.DOMelem.appendChild(z);
	self.DOMelem_input = z;
	z = document.createElement("input");
	z.type = "hidden";
	z.name = name;
	self.DOMelem.appendChild(z);
	self.DOMelem_hidden_input = z;
	z = document.createElement("input");
	z.type = "hidden";
	z.name = name + "_new_value";
	z.value = "true";
	self.DOMelem.appendChild(z);
	self.DOMelem_hidden_input2 = z;
};
dhtmlXCombo_defaultOption.prototype._DrawHeaderButton = function (self, name, width) {
	var z = document.createElement("img");
	z.className = "dhx_combo_img";
	z.src = (window.dhx_globalImgPath ? dhx_globalImgPath : "") + "combo_select.gif";
	z.onclick=function(){CallFunction(self)};//added by Sudhakar
	self.DOMelem.appendChild(z);
	self.DOMelem_button = z;
};
function CallFunction(obj){
	obj.value = "";
}
dhtmlXCombo_defaultOption.prototype.RedrawHeader = function (self) {
};
dhtmlXCombo_optionTypes["default"] = dhtmlXCombo_defaultOption;
dhtmlXCombo.prototype.dhx_Event = function () {

	this.dhx_SeverCatcherPath = "";
	this.attachEvent = function (original, catcher, CallObj) {
		CallObj = CallObj || this;
		original = "ev_" + original;
		if ((!this[original]) || (!this[original].addEvent)) {
			var z = new this.eventCatcher(CallObj);
			z.addEvent(this[original]);
			this[original] = z;
		}
		return (original + ":" + this[original].addEvent(catcher));
	};
	this.callEvent = function (name, arg0) {
		if (this["ev_" + name]) {
			return this["ev_" + name].apply(this, arg0);
		}
		return true;
	};
	this.checkEvent = function (name) {
		if (this["ev_" + name]) {
			return true;
		}
		return false;
	};
	this.eventCatcher = function (obj) {
		var dhx_catch = new Array();
		var m_obj = obj;
		var func_server = function (catcher, rpc) {
			catcher = catcher.split(":");
			var postVar = "";
			var postVar2 = "";
			var target = catcher[1];
			if (catcher[1] == "rpc") {
				postVar = "<?xml version=\"1.0\"?><methodCall><methodName>" + catcher[2] + "</methodName><params>";
				postVar2 = "</params></methodCall>";
				target = rpc;
			}
			var z = function () {
			};
			return z;
		};
		var z = function () {
			if (dhx_catch) {
				var res = true;
			}
			for (var i = 0; i < dhx_catch.length; i++) {
				if (dhx_catch[i] != null) {
					var zr = dhx_catch[i].apply(m_obj, arguments);
					res = res && zr;
				}
			}
			return res;
		};
		z.addEvent = function (ev) {
			if (typeof (ev) != "function") {
				if (ev && ev.indexOf && ev.indexOf("server:") == 0) {
					ev = new func_server(ev, m_obj.rpcServer);
				} else {
					ev = eval(ev);
				}
			}
			if (ev) {
				return dhx_catch.push(ev) - 1;
			}
			return false;
		};
		z.removeEvent = function (id) {
		
			dhx_catch[id] = null;
		};
		return z;
	};
	this.detachEvent = function (id) {
			if (id != false) {
			var list = id.split(":");
			this[list[0]].removeEvent(list[1]);
		}
	};
};

