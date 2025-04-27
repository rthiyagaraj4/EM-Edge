/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//var tempCols			= "0%,*";
//var tempMainMenuCols1	= "0%,*,30%";
//var tempMainMenuCols2	= "30%,*,30%";
//var tempMainMenuCols3	= "30%,*";
//var tempMainMenuCols3	= "30%,*,0%";
//var tempMainMenuCols4	= "0%,*,0%";
//var clinicianMain		= "8%,*,5%,0%";
//var patientChart		= "12%,*,5%,0%";
//var clinicianMainBed	= "16%,*,5%,0%";
//var patientChartBed	= "20%,*,5%,0%";
//var patientChartNurse	= "16%,*,5%,0%";

function Node(id, pid, name, url, title, target, icon, iconOpen, open, function_type) {
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
	this.function_type = function_type;
};

// Tree object
function dTree(objName) {
 		this.config = {
 		target				: null,
		folderLinks			: true,
		useSelection		: true,
		useCookies			: false, //true by default
		useLines			: true,
		useIcons			: true,
		useStatusText		: false,
		closeSameLevel		: false,
		inOrder				: false
	}
	this.icon = {
		root				: '../../eCommon/images/base.gif',
 		//	root				: '../images/base.gif',
		folder				: '../../eCommon/images/folder.gif',
		folderOpen			: '../../eCommon/images/folderopen.gif',
		node				: '../../eCA/images/page.gif',
		view				: '../../eCommon/images/view.gif',
		empty				: '../../eCA/images/empty.gif',
		line				: '../../eCA/images/line.gif',
		join				: '../../eCA/images/join.gif',
		joinBottom			: '../../eCA/images/joinbottom.gif',
		plus				: '../../eCA/images/plus.gif',
		plusBottom			: '../../eCA/images/plusbottom.gif',
		minus				: '../../eCA/images/minus.gif',
		minusBottom			: '../../eCA/images/minusbottom.gif',
		nlPlus				: '../../eCA/images/nolines_plus.gif',
		nlMinus				: '../../eCA/images/nolines_minus.gif'
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
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open, function_type) {
	//alert('id='+id+'pid='+pid+'name='+name+'url='+url+'title='+title+'icon='+icon+'iconOpen='+iconOpen+'open='+open+'function_type='+function_type);
	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target,icon, iconOpen, open, function_type);
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
			//alert('cn fun='+cn.url);
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
				 //if(node.function_type == 'R'){
					str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';
				//}else if(node.function_type == 'V'){
					//str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';
					//	str += '<img id="i' + this.obj + nodeId + '" src="' + this.icon.view + '" alt="" />';
					
				//}
			}
	}
 	if (node.url) {
		if(node.pid!=-1)
		{
 		str += '<font size=1><a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"';
		if (node.title) str += ' title="' + node.title + '"';
		if (node.target) str += ' target="' + node.target + '"';
		if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';
		if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
			str += ' onclick="javascript: ' + this.obj + '.s(' + nodeId + ');"';
		str += '>';
		}
	}
	else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)
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
	//parent.menuFrame.frmMenu.txtCurrentPosition.value = id;
 /*	if(parent.CommonToolbar.HideAndShow.value == 'Show Menu'){
		parent.CommonToolbar.HideAndShow.value = 'Hide Menu';
	}
	if(parent.CommonToolbar.HideAndShow.value == 'Show  Menu'){
		parent.CommonToolbar.HideAndShow.value = 'Show Menu';
	}
*/
//	changeMainFrameSetSize();
//	changeMainSizeNursingActivityHide();
//	loadOrUnloadMenus(parent.CommonToolbar.HideAndShow);

	if (!this.config.useSelection) return;
	var cn = this.aNodes[id];
 
	if (cn._hc && !this.config.folderLinks) return;
	if (this.selectedNode != id) {
		if (this.selectedNode || this.selectedNode==0) {
			eOld = document.getElementById("s" + this.obj + this.selectedNode);
 			if(eOld!=null)
				eOld.className = "node";
		}				

//		eNew = document.getElementById("s" + this.obj + id);
//		eNew.className = "nodeSel";
		this.selectedNode = id; 
		if (this.config.useCookies) this.setCookie('cs' + this.obj, cn.id);
//		parent.CommonToolbar.displayFunctionName(this.aNodes[id].title);//comment this line, while uncommenting the below part
		/* Uncomment this part for Previous Next button
		if(eNew != null){
			var toolTips = parent.menuFrame.frmMenu.txtToolTips.value; 
			var nodePoistions = parent.menuFrame.frmMenu.txtNodePoistions.value; 

			var tempToolTips = toolTips.split("$");
			var positions = nodePoistions.split("$");	

			var tempLastNode = positions[(positions.length)-1];
			var tempFirstNode = positions[0];
			var newToolTip='';
			var prevTip='';
	
			for(var i=0;i<positions.length;i++){
				if(id == positions[i]){
					if(positions[i-1] !=null){
						if(tempToolTips[i+1] !=null){
							newToolTip = tempToolTips[i+1];
						}
						if(tempToolTips[i-1] !=null){
							prevTip = tempToolTips[i-1];
						}		
					}else{
						newToolTip = tempToolTips[i+1]; //in case last node(first one in the menu)
					}
					break;
				}
			}

			parent.CommonToolbar.previous.disabled = false; 
			parent.CommonToolbar.next.disabled = false; 
			parent.CommonToolbar.previous.title = prevTip; 
			parent.CommonToolbar.next.title = newToolTip; 
			parent.CommonToolbar.displayFunctionName(this.aNodes[id].title);

			if(tempLastNode == id){
				parent.CommonToolbar.next.disabled = true; 
				parent.CommonToolbar.next.title = '';
				parent.CommonToolbar.previous.disabled = false; 	
			}else if(tempFirstNode == id){
				parent.CommonToolbar.previous.disabled = true; 			
				parent.CommonToolbar.previous.title = '';
				parent.CommonToolbar.next.disabled = false; 
			}
		} */
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

//this function is used to hide and show the Menu Frame
//function loadOrUnloadMenus(obj1){
 	//alert();
//	var cols;
//  	cols = tempMainMenuCols3;
//	parent.CommonToolbar.HideAndShowLookup.value = 'History';
//	if(obj1.value == 'Show Menu'){
//	obj1.value = 'Hide Menu';
//	cols = tempMainMenuCols3;
/*	if(parent.CommonToolbar.HideAndShowLookup.value == 'Show Lookup'){
			cols = tempMainMenuCols3;
		}else if(parent.CommonToolbar.HideAndShowLookup.value == 'Hide Lookup'){
			cols = tempMainMenuCols2;
		}
*/
//}	else if(obj1.value == 'Hide Menu'){
//		obj1.value = 'Show Menu';
//		cols = tempMainMenuCols4;
/*
		if(parent.CommonToolbar.HideAndShowLookup.value == 'Show Lookup'){
			cols = tempMainMenuCols4;
		}else if(parent.CommonToolbar.HideAndShowLookup.value == 'Hide Lookup'){
			cols = tempMainMenuCols1;
}
*/
//}

//	parent.workArea.removeAttribute(cols);
//	parent.workArea.cols = cols;
 

	//top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
//}


/*
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

function moveForward(){
	//alert('moveForward');
	parent.menuFrame.obj.openAll();
	parent.menuFrame.frmMenu.toggleTree.value = 'Collapse All';
	//parent.CommonToolbar.previous.disabled = false; 

	var currentPosition = parent.menuFrame.frmMenu.txtCurrentPosition.value; 
	var nodePoistions = parent.menuFrame.frmMenu.txtNodePoistions.value; 
	var toolTips = parent.menuFrame.frmMenu.txtToolTips.value; 

	var positions = nodePoistions.split("$");
	var tempToolTips = toolTips.split("$");
	var tempPosition = "",counter=0,newToolTip="",prevTip="";

	for(var i=0;i<positions.length;i++){
		if(currentPosition == positions[i]){
			if(positions[i+1] !=null){
				tempPosition = positions[i+1];
				if(tempToolTips[i+2] !=null){
					newToolTip = tempToolTips[i+2];
				}
				if(tempToolTips[i] !=null){
					prevTip = tempToolTips[i];
				}		
			}else{
				counter++;
			}
			if(positions[i+2] == null){
				//parent.CommonToolbar.next.title='';
			//	parent.CommonToolbar.next.disabled = true; 	
			}
			break;
		}
	}

	if(counter == 0){
		//parent.CommonToolbar.next.title=newToolTip;
		//parent.CommonToolbar.previous.title=prevTip;
		parent.menuFrame.obj.s(tempPosition);
		var url = parent.menuFrame.obj.aNodes[tempPosition].url;
		//parent.CommonToolbar.displayFunctionName(parent.menuFrame.obj.aNodes[tempPosition].title);
		parent.workAreaFrame.location.href=url;
	}else{
		//parent.CommonToolbar.next.disabled = false; 
		parent.menuFrame.obj.s(tempPosition);
		var url = parent.menuFrame.obj.aNodes[tempPosition].url;
		parent.workAreaFrame.location.href=url;
	} 

	parent.menuFrame.frmMenu.txtCurrentPosition.value = tempPosition;
}

function moveBackward(){
	parent.menuFrame.obj.openAll();
	parent.menuFrame.frmMenu.toggleTree.value = 'Collapse All';
//	parent.CommonToolbar.next.disabled = false; 

	var toolTips = parent.menuFrame.frmMenu.txtToolTips.value; 
	var currentPosition = parent.menuFrame.frmMenu.txtCurrentPosition.value; 
	var nodePoistions = parent.menuFrame.frmMenu.txtNodePoistions.value; 
	var positions = nodePoistions.split("$");
	var tempToolTips = toolTips.split("$");

	var tempPosition = "",counter=0,newToolTip="",prevTip="";

	for(var i=0;i<positions.length;i++){
		if(currentPosition == positions[i]){
			if(positions[i-1] !=null){
				tempPosition = positions[i-1];				
				if(tempToolTips[i-2] !=null){
					newToolTip = tempToolTips[i-2];
				}
				if(tempToolTips[i] !=null){
					prevTip = tempToolTips[i];
				}		
			}else{
				counter++;
			}
			if(positions[i-2] == null){
//				parent.CommonToolbar.previous.title = '';
//				parent.CommonToolbar.previous.disabled = true; 	
			}
			break;
		}
	}

	if(counter == 0){
//		parent.CommonToolbar.next.title=prevTip;
//		parent.CommonToolbar.previous.title=newToolTip;
		parent.menuFrame.obj.s(tempPosition);
		var url = parent.menuFrame.obj.aNodes[tempPosition].url;
//		parent.CommonToolbar.displayFunctionName(parent.menuFrame.obj.aNodes[tempPosition].title);
		parent.workAreaFrame.location.href=url;
	}else{
//		parent.CommonToolbar.next.disabled = false; 
		parent.menuFrame.obj.s(tempPosition);
		var url = parent.menuFrame.obj.aNodes[tempPosition].url;
//		parent.CommonToolbar.displayFunctionName(parent.menuFrame.obj.aNodes[tempPosition].title);
		parent.workAreaFrame.location.href=url;
	} 
	parent.menuFrame.frmMenu.txtCurrentPosition.value = tempPosition;
}

function changeFramesOptions1() {
	var tempRows = "5%,0%,*,0%";
	parent.workArea.removeAttribute("rows");
	parent.workArea.setAttribute("rows");	
	parent.workArea.rows = tempRows;
}

function changeFramesOptions2() {
	var tempRows = "5%,5%,*,0%";
	parent.workArea.removeAttribute("rows");
	parent.workArea.setAttribute("rows");	
	parent.workArea.rows = tempRows;
}

function changeMainFrameSetSize(){
	var patient_id = top.content.CommonToolbar.document.refForm.ref_patient_id.value;

	if(patient_id == ""){
		parent.mainFrameSet.rows = clinicianMain;	
	}else{
		parent.mainFrameSet.rows = patientChart;
	}
	top.content.CommonToolbar.tab.style.display = "none";
	
}

function changeMainFrameSetSizeBed(){
	var patient_id = top.content.CommonToolbar.document.refForm.ref_patient_id.value;

	if(patient_id == ""){
		parent.mainFrameSet.rows = clinicianMainBed;
	}else{
		parent.mainFrameSet.rows = patientChartBed;
	}
	top.content.CommonToolbar.tab.style.display = "inline";
	
}

function clearBedManagementScreen(){
	var patient_id = top.content.CommonToolbar.document.refForm.ref_patient_id.value;

	if(patient_id == ""){
		top.content.mainFrameSet.rows = clinicianMain;	
	}else{
		top.content.mainFrameSet.rows = patientChart;
	}
	top.content.CommonToolbar.tab.style.display = "none";
	top.content.workAreaFrame.location.href="../../eCommon/html/blank.html";
}

function changeMainSizeNursingActivity(){
	top.content.CommonToolbar.document.getElementById("tabChart").style.display = "inline";
	top.content.mainFrameSet.rows = patientChartNurse;	
}

function changeMainSizeNursingActivityHide(){
	top.content.CommonToolbar.document.getElementById("tabChart").style.display = "none";
	var patient_id = top.content.CommonToolbar.document.refForm.ref_patient_id.value;
	if(patient_id == ""){
		top.content.mainFrameSet.rows = clinicianMain;	
	}else{
		top.content.mainFrameSet.rows = patientChart;
	}
}

function callTaskListFromChart(){
	var queryString = document.refForm.queryString.value;
	top.content.workAreaFrame.location.href="../../eOR/jsp/ResultReporting.jsp?TITLE_FRAME_EXPAND=Y&"+queryString;
	top.content.CommonToolbar.displayFunctionName("Task List");
	return false;
}

function callNotes()
 {
	 var queryString = document.refForm.queryString.value;
	 var dialogHeight= "26" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	var action_url	=	"../../eCA/jsp/RecClinicalNotes.jsp?title=Notes&"+queryString;
	top.content.workAreaFrame.location.href = action_url;
	top.content.CommonToolbar.displayFunctionName("Notes");
 }

function callAssessment(){
	var queryString = document.refForm.queryString.value;
	top.content.workAreaFrame.location.href = "../../eNM/jsp/PatientAssessmentMain.jsp?"+queryString;
	top.content.CommonToolbar.displayFunctionName("Assessment");
	
}

function callCarePlan(){
	var queryString = document.refForm.queryString.value;
	top.content.workAreaFrame.location.href = "../../eNM/jsp/CarePlanMain.jsp?"+queryString;
	top.content.CommonToolbar.displayFunctionName("Finalize Care Plan");
	
}
*/

/* OR Functions*/
function showOrderSetResults(){
	 query_string = document.frmMenu.query_string.value;
	 parent.ExistingOrderSetViewResult.location.href =  "../../eOR/jsp/OrderSetResultsView.jsp?"+query_string;
}
/* Till here */
