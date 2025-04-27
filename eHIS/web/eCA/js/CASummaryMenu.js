/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
18/07/2017	IN061885	Raja S			18/07/2017		Ramesh G			ML-MMOH-CRF-0537
---------------------------------------------------------------------------------------------------------------
*/
var chkCount = 0;

function Node(id, pid, name, url, title, target, icon, iconOpen, open) {
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
};

// Tree object
function dTree(objName) {
		this.config = {
		target					: null,
		folderLinks			: true,
		useSelection		: true,
		useCookies			: false,
		useLines				: true,
		useIcons				: true,
		useStatusText		: false,
		closeSameLevel	: false,
		inOrder					: false
	}
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
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open) {
	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open);
//	alert("Hi    "+this.aNodes.length);

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
			
		//	alert(this.setCS(cn)+"    cn   "+cn);
			if (!cn.target && this.config.target) cn.target = this.config.target;
			if (cn._hc && !cn._io && this.config.useCookies) cn._io = this.isOpen(cn.id);
			if (!this.config.folderLinks && cn._hc) cn.url = null;
			if (this.config.useSelection && cn.id == this.selectedNode && !this.selectedFound) {
					cn._is = true;
					this.selectedNode = n;
					this.selectedFound = true;
			}
			//alert(cn._ls);
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
			//var urlLink = node.url+"?treeOBJ="+this.obj;
			
			str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"';
			if (node.title) str += ' title="' + node.title + '"';
			if (node.target) str += ' target="' + node.target + '"';
			if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';
			if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
				str += ' onclick="javascript:' + this.obj + '.s(' + nodeId + ');"';
			str += '>';
		}
	}
	else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id){
		//alert("nodeId  :  "+nodeId);
		str += '<a href="javascript:' + this.obj + '.o(' + nodeId + ');" class="node">';
	}
	str += node.name;
	
	if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';
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
// this method for panel sliding

function slidePanels(obj,obj1,obj2,obj3)
{	
	
	/*var frameTop = document.body.clientTop;
	var frameHeight = document.body.clientHeight;	*/
	
	var frameTop = document.documentElement.clientTop;
	var frameHeight = document.documentElement.clientHeight;
	
	if (obj.id == "Summary")
	{ 
		if (obj2.style.display == "inline")
		{				
			var tempObj = obj2;
			obj2 = obj3;
			obj3 = tempObj;					
			obj1.style.top=eval(frameTop+39)+"px";	
			obj2.style.top=eval(frameTop+59)+"px";
			obj2.style.height=eval(frameHeight - 59)+"px";	
			//IN061885 Starts
			//obj.className="divslideInActive";
			//obj1.className="divslideActive";
			obj.className="divslideInActive1";
			obj1.className="divslideActive1";
			//IN061885 Ends
		}
		else 
		{
			obj2.style.top=eval(frameTop+40)+"px";
			obj1.style.top=eval(frameHeight - 20)+"px";		
			obj2.style.height=eval(frameHeight - 53)+"px";
			//IN061885 Starts
			//obj.className="divslideActive";
			//obj1.className="divslideInActive";
			obj.className="divslideActive1";
			obj1.className="divslideInActive1";
			//IN061885 Ends
		}

		obj.style.height='20px';											
		obj2.style.display='inline';

		obj1.style.height='20px';							
		obj3.style.height='0px';
		obj3.style.display='none';

	}
	else if (obj.id == "Navigation")
	{	
		if (obj2.style.display == "inline")							
		{					
			var tempObj = obj2;
			obj2 = obj3;
			obj3 = tempObj;
				
			obj.style.top=eval(frameHeight - 19)+"px";
			obj2.style.height=eval(frameHeight - 41)+"px";	
			//IN061885 Changes Starts
			//obj.className="divslideInActive";
			//obj1.className="divslideActive";
			obj.className="divslideInActive1";
			obj1.className="divslideActive1";
			//IN061885 Changes Ends
			obj3.style.height='0px';
		}
		else 
		{					
			obj3.style.height='0px';					
			//IN061885 Changes starts
			//obj1.className="divslideInActive";
			//obj.className="divslideActive";
			obj1.className="divslideInActive1";
			obj.className="divslideActive1";
			//IN061885 Changes Ends
			obj2.style.top=eval(frameTop+59)+"px";
			obj2.style.height=eval(frameHeight - 60)+"px";
			obj.style.top=eval(frameTop+39)+"px";
		}

		obj1.style.height='20px';
		obj1.style.top='20px';							
		obj3.style.display='none';			
		obj.style.height='20px';				
		//obj2.style.top=frameTop+60;	
		obj2.style.display='inline';	
		obj2.style.overflow='auto';	
	}	
}
		
function slidPanelOnclick(obj,obj1,obj2,obj3)
{				
	/*obj1 = eval("document.all."+obj1);
	obj2 = eval("document.all."+obj2);
	obj3 = eval("document.all."+obj3);*/
	// Replace `document.all` with standard DOM methods

	obj1 = document.getElementById(obj1);
	obj2 = document.getElementById(obj2);
	obj3 = document.getElementById(obj3);

/*	console.log("Inside CASummaryMenu JS 487 ");
	console.log(" ************************ obj ************************ ");
	console.log(obj);
	console.log(" ************************ obj1 ************************ ");
	console.log(obj1);
	console.log(" ************************ obj2 ************************ ");
	console.log(obj2);
	console.log(" ************************ obj3 ************************ ");
	console.log(obj3);*/

	document.getElementById("persMenuFrm").style.display="none";
	slidePanels(obj,obj1,obj2,obj3);						
}

//this method is checking customize panels layout

		function onLoadCheck(obj,obj1,obj2,obj3){
			
			var layout_value=document.desktopParam.layoutValue.value;	
					
					if(layout_value==("F")){ 
					
					 obj1.style.height='400px';
					 obj1.style.top='40px';
					 
					 obj2.style.top='430px';
					 //obj2.className="divslideInActive";
					 //alert(obj2.className);
					 //obj2.style.font="normal";
					 
					 //obj3.style.height='0px';
					// obj3.style.top='625';
					//obj2.style.display="inline";
					obj3.style.display="none";					
					return;
				}
				
			//}

		}
		function setCustLayout(obj,obj1,obj2,obj3)
		{			
			//obj = eval("document.all."+obj);
			//obj1 = eval("document.all."+obj1);
			//obj2 = eval("document.all."+obj2);
			//obj3 = eval("document.all."+obj3);
			obj = document.getElementById(obj);
			obj1 = document.getElementById(obj1);
			obj2 = document.getElementById(obj2);
			obj3 = document.getElementById(obj3);
			onLoadCheck(obj,obj1,obj2,obj3);
		}
	function imagetoolFunction(str,userId) {
				if(str == 1) {
					fnLogout(userId);//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
					parent.parent.content.location.href="../../eCommon/jsp/logoff.jsp"
				}else if(str == 2){
					mainwin = top.opener
					var myBars = 'directories=no,location=no,menubar=no,status=no' ;
					var myOptions = 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=no, fullscreen=yes' ;
					var myFeatures = myBars + ', ' + myOptions ;
					mainwin = window.open("../../eSM/jsp/change_responsibility.jsp?persFrom=HomeSummary","eHISMain2",myFeatures)
					top.close();
				} else if(str == 3 ){					
					PanelsSetting();
					
				}
			}
function PanelsSetting(){	


	//show Personalize menu when both panels layout in 50 %
if((document.getElementById("Navigation").style.top=="320px")&&(document.getElementById("Desktop").style.height=="283px")){	
		document.getElementById("Desktop").style.height="184px";		
		showHidepersMenuFrm();
		return;	
	}

	//Hide Personalize menu when both panels layout in 50 %

	if(document.getElementById("Desktop").style.height=="184px"){		
			document.getElementById("Desktop").style.height="283px"
			showHidepersMenuFrm();
		return;	
	}

//show Personalize menu when Summary details not displaying

if((document.getElementById("SummaryDtl").style.display=="none")&&((document.getElementById("Desktop").style.height=="561px")||(document.getElementById("Desktop").style.height=="560px")||(document.getElementById("Desktop").style.height=="579px"))){		
		document.getElementById("Desktop").style.height="462px";
			showHidepersMenuFrm();
			return;
	
	}
	//hide Personalize menu when Summary details not displaying
if(document.getElementById("Desktop").style.height=="462px"){	
		document.getElementById("Desktop").style.height="560px";
		showHidepersMenuFrm();
		return;	
	}	

	//show Personalize menu when DeskTop not displaying
	//alert(document.getElementById("Desktop").style.display);
if((document.getElementById("Desktop").style.display=="none")&&(document.getElementById("Navigation").style.top !="430px")){	
	document.getElementById("SummaryDtl").style.height="400px";	
	document.getElementById("Navigation").style.top="430px";
	showHidepersMenuFrm();
	
	return;
	}

//hide Personalize menu when DeskTop not displaying

if(document.getElementById("Navigation").style.top=="430px"){	
		document.getElementById("Navigation").style.top="37px";
		document.getElementById("SummaryDtl").style.height="400px";
		showHidepersMenuFrm();
	return;	
}

//show Personalize menu When panel have Navigation menu  only
if((	document.getElementById("Desktop").style.height=="444px")&&(document.getElementById("Desktop").style.height!="470px")){	
		document.getElementById("Desktop").style.height="470px";
		showHidepersMenuFrm();
			return;	

}
//hide Personalize menu When panel have Navigation menu  only

if(document.getElementById("Desktop").style.height=="470px"){	
		document.getElementById("Desktop").style.height="444px";
		showHidepersMenuFrm();
			return;

}

}
function showHidepersMenuFrm(){
  var flag="";
  if(document.getElementById("persMenuFrm").style.display=="none"){
	flag='false';
  }
  else
	flag='true'
  if(flag=="true"){
	document.getElementById("persMenuFrm").style.display="none"
  }
  else{	 
  document.getElementById("persMenuFrm").style.display="inline";  
}


}



