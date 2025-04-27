
var tempCols = "0%,*";

var tempMainMenuCols1 = "0%,*,30%";
var tempMainMenuCols2 = "30%,*,30%";
var tempMainMenuCols3 = "30%,0%,*,0%";
var tempMainMenuCols4 = "0%,0%,*,0%";
var clinicianMain = "10%,*,5%,0%";
var patientChart = "11%,*,5%,0%";

var clinicianMainBed = "16%,*,5%,0%";
var patientChartBed = "20%,*,5%,0%";

var patientChartNurse = "16%,*,5%,0%";

function Node(id, pid, name, url, title, target, icon, iconOpen, open,function_type) {
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
		target					: null,
		folderLinks			: true,
		useSelection		: true,
		useCookies			: false, //true by default
		useLines				: true,
		useIcons				: true,
		useStatusText		: false,
		closeSameLevel	: false,
		inOrder					: false
	}
	this.icon = {
		root			: '../images/base.gif',
		folder			: '../images/MCT_Close.gif',
		folderOpen		: '../images/MCT_Open.gif',
		node			: '../images/MCT_Doc.gif',
		view			: '../images/view.gif',
		empty			: '../images/empty.gif',
		line			: '../images/line.gif',
		join			: '../images/join.gif',
		joinBottom		: '../images/joinbottom.gif',
		plus			: '../images/join.gif',
		plusBottom		: '../images/joinbottom.gif',
		minus			: '../images/join.gif',
		minusBottom		: '../images/joinbottom.gif',
		nlPlus			: '../images/nolines_plus.gif',
		nlMinus			: '../images/nolines_minus.gif',
		Doc				: '../images/MCT_Note.gif',
		Chart			: '../images/MCT_Chart.gif',
		//motherOpen			: '../images/MCT_MotherOpen.gif',
		motherOpen		: '../images/RecodeRemarks.gif',
		//motherClose			: '../images/MCT_MotherClose.gif',
		motherClose		: '../images/RecodeRemarks.gif',
		babyOpen		: '../images/MCT_Doc.gif',
		babyClose		: '../images/MCT_Doc.gif'
	};

	/*this.icon = {
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
	};*/

	this.obj = objName;
	this.aNodes = [];
	this.aIndent = [];
	this.root = new Node(-1);
	this.selectedNode = null;
	this.selectedFound = false;
	this.completed = false;
};

// Adds a new node to the node array
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open,function_type) {
	//alert('id='+id+'pid='+pid+'name='+name+'url='+url+'title='+title+'icon='+icon+'iconOpen='+iconOpen+'open='+open+'function_type='+function_type);
	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target,icon, iconOpen, open,function_type);
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
		
		
		var stat_ind = '';
		var nodeStr = node.id;
		
		if(nodeStr.length>=20){
				
			stat_ind = nodeStr.substring(0,8);
		}
		
		if (!node.icon && stat_ind != '$$SIGN##' && stat_ind != '$$RECD##') 
		{	
			
			node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);
		}
		else if(!node.icon && (stat_ind != '$$SIGN##' || stat_ind != '$$RECD##'))
		{
			
			if(stat_ind == '$$SIGN##')
			{
				node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.motherClose : this.icon.motherOpen);
			}
			else if(stat_ind == '$$RECD##')
			{
				node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.babyClose : this.icon.babyOpen);
			}
		}
		if (!node.iconOpen && stat_ind != '$$SIGN##' && stat_ind != '$$RECD##')
		{
			node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;
		}
		else if(!node.iconOpen && (stat_ind == '$$SIGN##' || stat_ind == '$$RECD##'))
		{
			if(stat_ind == '$$SIGN##')
			{
				
				node.iconOpen = (node._hc) ? this.icon.motherOpen : this.icon.motherClose;
			}
			else if(stat_ind == '$$RECD##') 
			{
				node.iconOpen = (node._hc) ? this.icon.babyOpen : this.icon.babyClose;
			}
		}
		if (this.root.id == node.pid) 
		{
			node.icon = this.icon.root;
			node.iconOpen = this.icon.root;
		}
			if(node.pid!=-1)
			{
				
			/*	if(node.id == 'MOTHER'){
					str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.motherOpen : node.motherClose) + '" alt="" />';
				}else if(node.id == 'FOETUS'){
					str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.babyOpen : node.babyClose) + '" alt="" />';
				}*/

				if(node.function_type == 'R' && node.pid != 'MOTHER' && node.pid != 'FOETUS' && node.id != 'MOTHER' && node.id != 'FOETUS'){
					
					str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';
				}				
				
				/*
				if(node.id == 'MOTHERDOCUMENT' || node.id == 'FOETUSDOCUMENT'){
					str += '<img id="i' + this.obj + nodeId + '" src="../images/MCT_Note.gif" alt="" />';
					
				}else if(node.id == 'FOETUSCHART' || node.id == 'MOTHERCHART'){
					str += '<img id="i' + this.obj + nodeId + '" src="../images/MCT_Chart.gif" alt="" />';
				} 
				*/
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
dTree.prototype.s = function(id) 
{
	//parent.parent.menuFrame.frmMenu.txtCurrentPosition.value = id;

	/*if(parent.CommonToolbar.HideAndShow.value == 'Show Menu'){
		parent.CommonToolbar.HideAndShow.value = 'Hide Menu';
	}
	if(parent.CommonToolbar.HideAndShow.value == 'Show  Menu'){
		parent.CommonToolbar.HideAndShow.value = 'Show Menu';
	}*/
	//changeMainFrameSetSize();
	//changeMainSizeNursingActivityHide();
//	loadOrUnloadMenus(parent.CommonToolbar.HideAndShow);
//	loadOrUnloadMenus(parent.CommonToolbar.HideMenu);
	
	if (!this.config.useSelection) return;
	var cn = this.aNodes[id];
	
	if (cn._hc && !this.config.folderLinks) return;
	
	
	if (this.selectedNode != id) 
	{

		if (this.selectedNode || this.selectedNode==0) 
		{
			eOld = document.getElementById("s" + this.obj + this.selectedNode);
			eOld.className = "node";
		}				
		
		
		eNew = document.getElementById("s" + this.obj + id);
		eNew.className = "nodeSel";
		this.selectedNode = id; 
		if (this.config.useCookies) this.setCookie('cs' + this.obj, cn.id);
		//parent.CommonToolbar.displayFunctionName(this.aNodes[id].title);//comment this line, while uncommenting the below part
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
function loadOrUnloadMenus(obj1){
	//alert();
	var cols;
	//parent.CommonToolbar.HideAndShowLookup.value = '';

	if(obj1.name == 'ShowMenu' ){
		parent.CommonToolbar.ShowMenu.style.display='none';
		parent.CommonToolbar.HideMenu.style.display='inline';
		cols = tempMainMenuCols3;



	}
	else if(obj1.name == 'HideMenu')
	{
		parent.CommonToolbar.ShowMenu.style.display='inline';
		parent.CommonToolbar.HideMenu.style.display='none';
		cols = tempMainMenuCols4;


	}



	parent.workArea.removeAttribute(cols);
	parent.workArea.cols = cols;

	top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

//this function is used to expand or collapse the tree structure
function changeTree(toggleButton){

	if(toggleButton.id == 'toggleTreeExpand')
	{	
		obj.openAll();
	}
	else if(toggleButton.id == 'toggleTreeCollapse')
	{
		obj.closeAll();
	}
}

function moveForward(){
	//alert('moveForward');
	parent.menuFrame.obj.openAll();
	parent.menuFrame.frmMenu.toggleTree.value = 'Collapse All';
	parent.CommonToolbar.previous.disabled = false; 

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
				parent.CommonToolbar.next.title='';
				parent.CommonToolbar.next.disabled = true; 	
			}
			break;
		}
	}

	if(counter == 0){
		parent.CommonToolbar.next.title=newToolTip;
		parent.CommonToolbar.previous.title=prevTip;
		parent.menuFrame.obj.s(tempPosition);
		var url = parent.menuFrame.obj.aNodes[tempPosition].url;
		parent.CommonToolbar.displayFunctionName(parent.menuFrame.obj.aNodes[tempPosition].title);
		parent.workAreaFrame.location.href=url;
	}else{
		parent.CommonToolbar.next.disabled = false; 
		parent.menuFrame.obj.s(tempPosition);
		var url = parent.menuFrame.obj.aNodes[tempPosition].url;
		parent.workAreaFrame.location.href=url;
	} 

	parent.menuFrame.frmMenu.txtCurrentPosition.value = tempPosition;
}

function moveBackward(){
	//alert('moveBackward');
	parent.menuFrame.obj.openAll();
	parent.menuFrame.frmMenu.toggleTree.value = 'Collapse All';
	parent.CommonToolbar.next.disabled = false; 

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
				parent.CommonToolbar.previous.title = '';
				parent.CommonToolbar.previous.disabled = true; 	
			}
			break;
		}
	}

	if(counter == 0){
		parent.CommonToolbar.next.title=prevTip;
		parent.CommonToolbar.previous.title=newToolTip;
		parent.menuFrame.obj.s(tempPosition);
		var url = parent.menuFrame.obj.aNodes[tempPosition].url;
		parent.CommonToolbar.displayFunctionName(parent.menuFrame.obj.aNodes[tempPosition].title);
		parent.workAreaFrame.location.href=url;
	}else{
		parent.CommonToolbar.next.disabled = false; 
		parent.menuFrame.obj.s(tempPosition);
		var url = parent.menuFrame.obj.aNodes[tempPosition].url;
		parent.CommonToolbar.displayFunctionName(parent.menuFrame.obj.aNodes[tempPosition].title);
		parent.workAreaFrame.location.href=url;
	} 
	parent.menuFrame.frmMenu.txtCurrentPosition.value = tempPosition;
}



function changeMainFrameSetSize(){
	var patient_id = top.content.CommonToolbar.document.refForm.ref_patient_id.value;

	if(patient_id == ""){
		top.content.mainFrameSet.rows = clinicianMain;	
	}else{
		top.content.mainFrameSet.rows = patientChart;
	}
	
}

function hideShowNodes(id)
{
	var noOfEvents = document.maternityMenu.noOfEvents.value;
	noOfEvents = parseInt(noOfEvents,10);
	var strTD = document.getElementById('tdId'+id);
	if(strTD.style.display == 'inline')
	{
		strTD.style.display = "none";
	}
	else
	{
		strTD.style.display = "inline";
		for(var t=0;t<noOfEvents;t++)
		{
			if(id != t)
				document.getElementById('tdId'+t).style.display = "none";
		}
	}
}

function hideAllCycles()
{
	var noOfEvents = document.maternityMenu.noOfEvents.value;
	noOfEvents = parseInt(noOfEvents,10);

	var module_id = document.maternityMenu.module_id.value;
	var patient_id = document.maternityMenu.patient_id.value;
	var cycle_no = parent.maternityeventframe.document.tempmaternityMenu.cycle_select.value;

	for(var t=0;t<noOfEvents;t++)
	{
		if(t != noOfEvents-1)
			document.getElementById('tdId'+t).style.display = "none";
	}

	parent.parent.workAreaFrame.location.href = '../../eCA/jsp/CycleFrame.jsp?patient_id='+patient_id+'&module_id='+module_id+'&cycle_no='+cycle_no;
}
