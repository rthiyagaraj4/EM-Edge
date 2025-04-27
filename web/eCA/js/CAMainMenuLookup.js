/** Modified by kishore kumar N on 22/12/2008 for CRF 0387 , alterd the cols to 200px*/

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        Rev.Date 	Rev.by 		Description
--------------------------------------------------------------------------------------------------------------
?				?					?			?			?			?
06/01/2022		27605				Ramesh G 							Common-ICN-0086
--------------------------------------------------------------------------------------------------------------
*/
var tempLookupCols1 = "0%,0%,*,200px";
/** ends here.*/
//var tempLookupCols1 = "0%,0%,*,32%";
var tempLookupCols2 = "30%,*,30%";
var tempLookupCols3 = "30%,*,0%";
var tempLookupCols4 = "0%,0%,*,0%";
var windowObjectsArray = new Array();
var windowNamesArray = new Array();
var chartWindowObj = new Array();
var windowTitles = new Array();
var windowIcons = new Array();
var previewWindowObjectReference;

function Node(id, pid, name, url, title, target, icon_file_name, icon, iconOpen, open) {
	this.id = id;
	this.pid = pid;
	this.name = name;
	this.url = url;
	this.title = title;
	this.target = target;
	this.icon_file_name = icon_file_name;
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
		useCookies			: false, //true by default
		useLines			: true,
		useIcons			: true,
		useStatusText		: true,
		closeSameLevel		: false,
		inOrder				: false
	}
	/*this.icon = {
		root			: '../images/base.gif',
		folder			: '../images/folder.gif',
		folderOpen		: '../images/folderopen.gif',
		//node			: '../images/page.gif',
		node			: '../images/view.gif',
		empty			: '../images/empty.gif',
		line			: '../images/line.gif',
		join			: '../images/join.gif',
		joinBottom		: '../images/joinbottom.gif',
		plus			: '../images/plus.gif',
		plusBottom		: '../images/plusbottom.gif',
		minus			: '../images/minus.gif',
		minusBottom		: '../images/minusbottom.gif',
		nlPlus			: '../images/nolines_plus.gif',
		nlMinus			: '../images/nolines_minus.gif'
	};*/

	this.icon = {
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
dTree.prototype.add = function(id, pid, name, url, title, target, icon_file_name, icon, iconOpen, open) {
	//alert(icon_file_name);
	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon_file_name, icon, iconOpen, open);
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
		str += '<font size=1><a href="java_script_:;" id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') ;//+ '" href="' + node.url + '"';z
		
			
		if (node.title) str += ' title="' + node.title + '"';
		if (node.target) str += ' target="' + node.target + '"';
		if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';
		if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
		str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + '); return false;"';
		str += '>';
		}
	}else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)
		str += '<font size=1><a href="javascript: ' + this.obj + '.o(' + nodeId + ');" class="node">';
	str += node.name;

	if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</font></a>';

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
			str += '<img src="' + ( (this.config.useLines) ? this.icon.line : this.icon.empty ) + '" alt="" />';
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

	if(parent.CommonToolbar.HideAndShowLookup.value == 'History'){
		parent.CommonToolbar.HideAndShowLookup.value = ' History';
	}
	
	loadOrUnloadLookup(parent.CommonToolbar.HideAndShowLookup);
	openLookup(id); //to open in a new window
	

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
		//alert('dTree.prototype.o');
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
	//alert('dTree.prototype.openTo');
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
	//alert('dTree.prototype.nodeStatus');
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
	//alert('dTree.prototype.clearCookie');
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



//this function is used to expand or collapse the tree structure
function changeTree(toggleButton){
	/*if(toggleButton.value=='Collapse All'){
		toggleButton.value='Expand All';
		objLookupMenu.closeAll();
	}else{
		toggleButton.value='Collapse All';
		objLookupMenu.openAll();	
	}*/
	if(toggleButton.id == 'toggleTreeExpand')
	{
		document.getElementById('toggleTreeExpand').style.display = "none";
		document.getElementById('toggleTreeCollapse').style.display = "inline";		
		obj.openAll();
	}
	else
	{
		document.getElementById('toggleTreeCollapse').style.display = "none";
		document.getElementById('toggleTreeExpand').style.display = "inline";		
		obj.closeAll();
	}
}

//this function is used to hide and show the Lookup Menu Frame

function loadOrUnloadLookup(lookupButton){
	
	var objMenuFrame = top.content.lookupMenuFrame;
	var objMainMenuFrame = top.content.CommonToolbar;	
	var counter =0;
	for(var i=0;i<objMenuFrame.windowObjectsArray.length;i++){
		if(!objMenuFrame.windowObjectsArray[i].closed){
			counter++;
		}
	}

	if(counter == 2){
		alert(getMessage('MAX_2LOOKUP','CA'));
		return false;                          
	}
	
	if(lookupButton.value == '' || lookupButton.value == undefined){
		lookupButton.value = ' History';
		var cols = parent.workArea.cols;		
		
		if(cols=='0%,200px,*,0%')
		{
			cols = '0%,200px,*,200px' ;
		}
		else
		{
			cols = tempLookupCols1;
		}
		parent.workArea.removeAttribute(cols);
		parent.workArea.cols = cols;
		
	}else if(lookupButton.value == ' History'){
		
		lookupButton.value = '';
		var cols = parent.workArea.cols;		
		
		if(cols=='0%,200px,*,200px')
		{
			cols = '0%,200px,*,0%';
		}
		else
		{
			cols = tempLookupCols4;		
		}
		parent.workArea.removeAttribute(cols);
		parent.workArea.cols = cols;	
		
	}
	if(parent.workArea.cols == tempLookupCols1)
	{			
	var matfrmval=parent.menuFrame.frmMenu.matfrmval.value
			if(matfrmval=='1'){
			parent.workAreaFrame.maternitycols.cols="0%,0%,*,0%";
	}
		objMainMenuFrame.ShowMenu.style.display = "inline";
		objMainMenuFrame.HideMenu.style.display = "none";		
		
	}
	else if(parent.workArea.cols == tempLookupCols4)
	{	
		objMainMenuFrame.ShowMenu.style.display = "inline";
		objMainMenuFrame.HideMenu.style.display = "none";		
	}
	
}

function openLookup(id){

	var tempArrayNames = new Array();
	var tempArrayObjs = new Array();
	var tempTitleObjs = new Array();	
	var tempIconObjs = new Array();	

	var obj = top.window.opener.top.content.CommonToolbar;
	var url = objLookupMenu.aNodes[id].url;
	var objMenuFrame = top.content.lookupMenuFrame;
	var window_name = objLookupMenu.aNodes[id].target;
	var title = objLookupMenu.aNodes[id].title;
	var icon_file_name = objLookupMenu.aNodes[id].icon_file_name;

	var chart_window_name = top.content.CommonToolbar.document.pat_info.window_name.value;

	//alert("window_name  "+window_name+"chart_window_name  "+chart_window_name);
	//alert("currentWindowName  "+currentWindowName);

	var counter = 0;
	var position = 0;
	for(var i=0;i<objMenuFrame.windowNamesArray.length;i++){
		if(!(objMenuFrame.windowObjectsArray[i].closed)){		
			//alert();
			tempArrayNames[position] = objMenuFrame.windowNamesArray[i];
			tempArrayObjs[position] = objMenuFrame.windowObjectsArray[i];
			tempTitleObjs[position] = objMenuFrame.windowTitles[i];
			tempIconObjs[position] = objMenuFrame.windowIcons[i];
			position++;
		}
	}

	objMenuFrame.windowNamesArray = tempArrayNames;
	objMenuFrame.windowObjectsArray = tempArrayObjs;
	objMenuFrame.windowTitles = tempTitleObjs; 
	objMenuFrame.windowIcons = tempIconObjs; 

	for(var i=0;i<objMenuFrame.windowNamesArray.length;i++){
		if(objMenuFrame.windowNamesArray[i] == window_name){
			if(objMenuFrame.windowObjectsArray[i].closed){				
				break;
			}else{
				counter++;
				objMenuFrame.windowObjectsArray[i].focus();
				flag=1;
				break;
			}
		}
	}

	if(objMenuFrame.windowNamesArray.length == 3 && counter == 0){
		
		alert(getMessage('MAX_3LOOKUP','CA'));
		return false;                          
	}

	if(counter == 0){
		url = url+"&window_name=" +chart_window_name+"&lookup_window_name="+window_name+"&function_display_name="+encodeURIComponent(title,"UTF-8");
		objMenuFrame.windowNamesArray[objMenuFrame.windowNamesArray.length] = window_name;
		//27605 Start.
		//objMenuFrame.windowObjectsArray[objMenuFrame.windowObjectsArray.length] = window.open(url,window_name,'height=500,width=790,top=50,left=0,resizable=yes,toolbar=nomenubar=no');	
		objMenuFrame.windowObjectsArray[objMenuFrame.windowObjectsArray.length] = window.open(url,window_name,'height='+screen.height +',width='+screen.width+',top=50,left=0,resizable=yes,toolbar=nomenubar=no');	
		//27605 end.
		objMenuFrame.windowTitles[objMenuFrame.windowTitles.length] = title;
		//alert('before'+objMenuFrame.windowIcons.length);
		objMenuFrame.windowIcons[objMenuFrame.windowIcons.length] = icon_file_name;
		//alert('after'+objMenuFrame.windowIcons[objMenuFrame.windowIcons.length-1]);
	}		

	/*for(var i=0;i<objMenuFrame.windowNamesArray.length;i++){
		eval("obj.btn"+i+".style.visibility='hidden'");
	}

	for(var i=0;i<objMenuFrame.windowNamesArray.length;i++){
		eval("obj.btn"+i+".style.visibility='visible'");
		eval("obj.btn"+i+".title=obj.windowTitles[i]");		
	}*/
}

//this function is used to expand or collapse the tree structure
function changeLookupTree(toggleButton){
	if(toggleButton.value=='Collapse All'){
		toggleButton.value='Expand All';
		objLookupMenu.closeAll();
	}else{
		toggleButton.value='Collapse All';
		objLookupMenu.openAll();	
	}
}

function getParentWindow(){
	chartWindowObj[0].focus();
	
	/*var obj = top.window.opener.top.content.CommonToolbar;
	var wname = top.content.CommonToolbar.document.pat_info.window_name.value;

	if(obj.pat_info != null){
		for(var i=0;i<obj.pat_info.length;i++){
			if(wname == obj.pat_info[i].winname ){
				if(obj.pat_info[i].window_obj.closed) break;
					//alert('chart = '+obj.pat_info[i].window_obj.name);
					obj.pat_info[i].window_obj.focus();
					break;
			}
		}
	}*/
}

function getChartWindow(windowName){
	var obj = top.window.opener.top.content.CommonToolbar;
	//alert(obj.name);
	//alert(top.window.opener.name);
	//var wname = top.content.CommonToolbar.document.pat_info.window_name.value;

	/*if(obj.pat_info != null){
		for(var i=0;i<obj.pat_info.length;i++){
			if(windowName == obj.pat_info[i].winname ){
				if(obj.pat_info[i].window_obj.closed){
					alert('Patient Chart Closed');	
				}else{
					alert('Patient Chart is Open.');					
				}
			}
		}
	}*/
	if(obj.pat_info != null){
		for(var i=0;i<obj.pat_info.length;i++){
			if(windowName == obj.pat_info[i].winname ){
				if(obj.pat_info[i].window_obj.closed) break;
				chartWindowObj[chartWindowObj.length] = obj.pat_info[i].window_obj;
				break;
			}
		}
	}
}

function makeLookupButtonsVisible(lookup_window_name){
		////Bru-HIMS-CRF-016 for Genogram Start [for Genogram].
		var obj;
		var objTool;
		if(chartWindowObj[0] != undefined || chartWindowObj[0] != null)
		{
			obj = chartWindowObj[0].top.content.lookupMenuFrame;
			objTool = chartWindowObj[0].top.content.CommonToolbar;
		}
		else
		{
			obj = parent.top.content.lookupMenuFrame;
			objTool = parent.top.content.CommonToolbar;
		}
		////Bru-HIMS-CRF-016 for Genogram End. [for Genogram].
		var objToolLookup = self.top.content.CommonToolbar;
		//alert(objTool.name);
		
		if(obj.windowNamesArray != undefined || obj.windowNamesArray != null)		//Bru-HIMS-CRF-016 for Genogram
		{																			//Bru-HIMS-CRF-016 for Genogram
			for(var i=0;i<obj.windowNamesArray.length;i++){
				//eval("objTool.div"+i+".style.display='none'");
				//eval("objTool.link"+i+".style.display='none'");
			}
			
			for(var i=0;i<obj.windowNamesArray.length;i++){
				//if(lookup_window_name == obj.windowNamesArray[i]){
					//eval("objTool.div"+i+".style.display='inline'");
					//eval("objTool.link"+i+".style.display='inline'");
					//alert(obj.windowNamesArray[i]);
					//alert(chartWindowObj[0].top.content.lookupMenuFrame.windowIcons.length);
					var url = '../../eCA/images/'+chartWindowObj[0].top.content.lookupMenuFrame.windowIcons[i];
					//eval("objTool.btn"+i+".src = url");
					//eval("objTool.btn"+i+".value=obj.windowTitles[i]");		
					//eval("objTool.link"+i+".title=obj.windowTitles[i]");		
				//}
			}
		}	//Bru-HIMS-CRF-016 for Genogram
	
}

function callWindow(id){

	//var obj = self.top.content.lookupMenuFrame;
	var obj = top.content.lookupMenuFrame;
	/*var objTool = top.content.CommonToolbar;

	var tempArrayObjs = new Array();
	var tempArrayNames = new Array();
	var tempArrayTitles = new Array();*/

	if(obj.windowObjectsArray[id] != null){
		obj.windowObjectsArray[id].focus();
	}
	/*
	for(var i=0;i<obj.windowNamesArray.length;i++){
		if(! obj.windowObjectsArray[i].closed){
			tempArrayNames[i] = obj.windowNamesArray[i]
			tempArrayObjs[i] = obj.windowObjectsArray[i];
			tempArrayTitles[i] = obj.windowTitles[i];
		}
	}

	obj.windowNamesArray = tempArrayNames;
	obj.windowNamesArray = tempArrayObjs;
	obj.windowNamesArray = tempArrayTitles;

	for(var i=0;i<obj.windowNamesArray.length;i++){
		eval("objTool.btn"+i+".style.visibility='hidden'");
	}


	for(var i=0;i<obj.windowNamesArray.length;i++){
		eval("objTool.btn"+i+".style.visibility='visible'");
		eval("objTool.btn"+i+".title=obj.windowTitles[i]");		
	}*/
}

//to remove the lookup buttons
function lookupButtons(lookup_window_name){
	var obj = chartWindowObj[0].top.content.lookupMenuFrame;
	var objTool = chartWindowObj[0].top.content.CommonToolbar;
	var objToolLookup = self.top.content.CommonToolbar;

	for(var i=0;i<obj.windowNamesArray.length;i++){
		if(lookup_window_name == obj.windowNamesArray[i]){
			eval("objTool.link"+i+".style.display='inline'");
			eval("objTool.btn"+i+".src='../../eCA/images/obj.windowIcons[i]'");		
			eval("objTool.link"+i+".title=obj.windowTitles[i]");		
		}
	}
}

/*
to hide the lookup button in the chart 
while closing the lookup window using close button
*/
function hideLookupButton(){
	//Bru-HIMS-CRF-016 for Genogram Start [for Genogram].
	//var obj = chartWindowObj[0].top.content.lookupMenuFrame;
	//var objTool = chartWindowObj[0].top.content.CommonToolbar;
	var obj;
	var objTool;
	if(chartWindowObj[0] != undefined || chartWindowObj[0] != null)
	{
		obj = chartWindowObj[0].top.content.lookupMenuFrame;
		objTool = chartWindowObj[0].top.content.CommonToolbar;
	}
	else
	{
		obj = parent.top.content.lookupMenuFrame;
		objTool = parent.top.content.CommonToolbar;
	}
	//Bru-HIMS-CRF-016 for Genogram End. [for Genogram].
	
	var obj1= self.top.content.CommonToolbar;
	var tempArrayLength = 0;

	var currentWindowName = obj1.document.pat_info.lookup_window_name.value;
	if(obj.windowNamesArray != undefined || obj.windowNamesArray != null)		//Bru-HIMS-CRF-016 for Genogram
	{																			//Bru-HIMS-CRF-016 for Genogram
		tempArrayLength = obj.windowObjectsArray.length;
		
		for(var i=0;i<obj.windowNamesArray.length;i++){
			if(currentWindowName == obj.windowNamesArray[i]){
				// added by marwan-EDGE work to handle missing link element issue
				if(objTool.document.getElementById("link") !== undefined && objTool.document.getElementById("link") !== null){
					eval("objTool.link"+i+".style.display='none'");	
        }		
			}
		}

		for(var i=0;i<obj.windowNamesArray.length;i++){
			if(currentWindowName == obj.windowNamesArray[i]){				
				obj.windowObjectsArray[i].close();
				tempArrayLength--;
				chartWindowObj[0].focus();
				break;
			}
		}
	//Bru-HIMS-CRF-016 for Genogram Start.
	}else{
		obj.close();
	}
	//Bru-HIMS-CRF-016 for Genogram End.
}

/*
to hide the lookup button in the chart 
while closing the lookup window using X 
*/
function hideLookupButtonOnX(){
	var tempArrayLength = 0;

	if (navigator.appVersion.indexOf("MSIE") != -1)
      version = parseFloat(navigator.appVersion.split("MSIE")[1]);


	if(window.event.clientX < 0 || version == 7)
	{	if(chartWindowObj[0] != undefined || chartWindowObj[0] != null) //Bru-HIMS-CRF-016 for Genogram
		{																//Bru-HIMS-CRF-016 for Genogram
			if(!chartWindowObj[0].closed)
			{
				var obj = chartWindowObj[0].top.content.lookupMenuFrame;
				var obj1= self.top.content.CommonToolbar;
				var objTool = chartWindowObj[0].top.content.CommonToolbar;
				tempArrayLength = obj.windowNamesArray.length;
				var currentWindowName = obj1.document.pat_info.lookup_window_name.value;
				for(var i=0;i<obj.windowNamesArray.length;i++){
					if(! obj.windowObjectsArray[i].closed && ! chartWindowObj[0].closed){
						if(currentWindowName == obj.windowNamesArray[i]){				
							//eval("objTool.div"+i+".style.display='none'");
							eval("objTool.link"+i+".style.display='none'");
							tempArrayLength--;
							obj.windowObjectsArray[i].focus();
							break;
						}
					}
				}
			}
		}  //Bru-HIMS-CRF-016 for Genogram													
	}	
}

//to close all the lookup windows while closing the chart
function closeAllLookups(){
	if(window.event.clientX < 0){
		var obj = top.content.lookupMenuFrame;
		if(obj.windowNamesArray != null){
			for(var i=0;i<obj.windowNamesArray.length;i++){
				if(! obj.windowObjectsArray[i].closed){
					obj.windowObjectsArray[i].close();
				}
			}
		}
	}	
	//if any preview window is opened from this chart from notes
	 if(previewWindowObjectReference!=null)
	 {
		 if(!previewWindowObjectReference.closed)
			previewWindowObjectReference.close();						 
	 }
}

function alignLookupButtons(){
	//alert();
/*	var tempArrayNames = new Array();
	var tempArrayObjs = new Array();
	var tempTitleObjs = new Array();	

	var objMenuFrame = top.content.lookupMenuFrame;
	var objTool= top.content.CommonToolbar;

	var position = 0;

	for(var i=0;i<objMenuFrame.windowNamesArray.length;i++){
		if(!(objMenuFrame.windowObjectsArray[i].closed)){		
			tempArrayNames[position] = objMenuFrame.windowNamesArray[i];
			tempArrayObjs[position] = objMenuFrame.windowObjectsArray[i];
			tempTitleObjs[position] = objMenuFrame.windowTitles[i];
			position++;
		}
	}
	alert(objMenuFrame.windowNamesArray.length);
	objMenuFrame.windowNamesArray = tempArrayNames;
	objMenuFrame.windowObjectsArray = tempArrayObjs;
	objMenuFrame.windowTitles = tempTitleObjs; 
	alert(objMenuFrame.windowNamesArray.length);	
	for(var i=0;i<objMenuFrame.windowNamesArray.length;i++){
		eval("objTool.btn"+i+".style.visibility='hidden'");
	}

	for(var i=0;i<objMenuFrame.windowNamesArray.length;i++){
		eval("objTool.btn"+i+".style.visibility='visible'");
		eval("objTool.btn"+i+".title=objMenuFrame.windowTitles[i]");		
	}*/
}
