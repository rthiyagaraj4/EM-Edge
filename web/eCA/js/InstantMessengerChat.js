//Function to Arrest the View Source
function CodeArrest() {
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) {
        alert("Welcome to eHIS");
    }
}

//for table-header scrolling
function scrollHeader(){
  var x = document.body.scrollTop;
  if(x == 0){
   document.getElementById("divTableNum").style.position = 'static';
   document.getElementById("divTableNum").style.posTop  = 0;
   document.getElementById("divTableHeader").style.position = 'static';
   document.getElementById("divTableHeader").style.posTop  = 0;
  }else{
	document.getElementById("divTableNum").style.position = 'relative';
	document.getElementById("divTableNum").style.posTop  = x-1;
	document.getElementById("divTableHeader").style.position = 'relative';
	document.getElementById("divTableHeader").style.posTop  = x-1;
  
  }
}

//for table-width fitting
function alignHeading()
{
	if(parent.tableFrame.document.getElementById("TabHead") != null) {
		parent.tableFrame.document.getElementById("TabHead").width =	eval(parent.tableFrame.document.getElementById("chattable").offsetWidth);
		for (j=0; j < parent.tableFrame.document.getElementById("chattable").rows(0).cells.length; j++) {
			var wid=eval(parent.tableFrame.document.getElementById("chattable").rows(0).cells(j).offsetWidth);
   			 if(parent.tableFrame.document.getElementById("TabHead").rows(0).cells(j) != null){
				parent.tableFrame.document.getElementById("TabHead").rows(0).cells(j).width=wid;
			}
		}
	}
}

//to get the username to whom the message is intended
function displayusers(userName,userRespId)
{
	this.userName = userName;
	this.userRespId = userRespId;
	var valid = parent.tableFrame.document.forms[0].hiddenvar1.value;
	var disp = parent.sendtextframe.document.forms[0].to_user.value =	userName;
	var dispRespId = parent.sendtextframe.document.forms[0].to_user_resp_id.value =	userRespId;
	parent.sendtextframe.document.getElementById("chatwith").innerHTML = "<font color=black size=1>Status: chatting with " +disp+"</font>"
	parent.sendtextframe.document.forms[0].instantsendmsg.focus();
}
//to remove the user from the tree
function exit()
{
	parent.blankframe1.document.write("<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempForm' id='tempForm' method='get' action ='../../servlet/eCA.chat.AddRemoveOnlineUsers'><input type=hidden name=action value=remove></form></body></html>");
	parent.blankframe1.document.tempForm.submit();
}

function Node(id, pid, name, url, title, target, icon, iconOpen, open, userName,userRespId) {
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
	this.userName = userName;
	this.userRespId = userRespId;
};

// Tree object
function dTree(objName) {
		this.config = {
		target				: null,
		folderLinks			: true,
		useSelection		: true,
		useCookies			: false,
		useLines			: true,
		useIcons			: true,
		useStatusText		: false,
		closeSameLevel		: false,
		inOrder				: false
	}
	this.icon = {
		root				: '../images/base.gif',
		folder			: '../images/folder.gif',
		folderOpen		: '../images/folderopen.gif',
		node				: '../images/page.gif',
		empty			: '../images/empty.gif',
		line				: '../images/line.gif',
		join				: '../images/join.gif',
		joinBottom		: '../images/joinbottom.gif',
		plus				: '../images/plus.gif',
		plusBottom	: '../images/plusbottom.gif',
		minus			: '../images/minus.gif',
		minusBottom	: '../images/minusbottom.gif',
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
dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open,userName,userRespId) {
	//alert("ID :"+id+"       Parent ID :"+pid+"       Name:"+name+"");
	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open, userName,userRespId);
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
	if (this.config.useIcons) {
		if (!node.icon) node.icon = (this.root.id == node.pid) ? this.icon.root : ((node._hc) ? this.icon.folder : this.icon.node);
		if (!node.iconOpen) node.iconOpen = (node._hc) ? this.icon.folderOpen : this.icon.node;
		if (!node.icon) node.icon = (node.pid == '1') ? this.icon.node : this.icon.empty;
		if (this.root.id == node.pid) {
			node.icon = this.icon.root;
			node.iconOpen = this.icon.root;
		}

		if (node.id == '1' && node.pid == '0') {
			node.icon = this.icon.folder;
			node.iconOpen = this.icon.folderOpen;
		}

			if(node.pid!=-1)
			{
				str += '<img id="i' + this.obj + nodeId + '" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="" />';
			}
	}

	if (node.url) {
		if(node.pid!=-1)
		{
		
		str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '"';
		if (node.userName) str += ' userName="' + node.userName + '"';
		if (node.userRespId) str += ' userRespId="' + node.userRespId + '"';
		if (node.title) str += ' title="' + node.title + '"';
		if (node.target) str += ' target="' + node.target + '"';
		if (this.config.useStatusText) str += ' onmouseover="window.status=\'' + node.name + '\';return true;" onmouseout="window.status=\'\';return true;" ';
		if (this.config.useSelection && ((node._hc && this.config.folderLinks) || !node._hc))
		if(node.pid=='0'){
				str+='onclick='+this.obj+'.o(' +nodeId + ');';
			}
			else
			{
				str += 'onclick="' + this.obj + '.s(' + nodeId + ');'+'displayusers(userName,userRespId)"';
			}
		str += '>';
			}
	}
	else if ((!this.config.folderLinks || !node.url) && node._hc && node.pid != this.root.id)
		str += '<a href="javascript:' + this.obj + '.o(' + nodeId + ');" class="node">';
	str += node.name;
	if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';
	str += '</div>';
	if (node._hc) {
		str += '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';
		str += this.addNode(node);
		str += '</div>';
	}
	this.aIndent.pop();
	return str;

};

// Adds the empty and line icons

dTree.prototype.indent = function(node, nodeId) {
	var str = '';
	if (this.root.id != node.pid) {

		for (var n=1; n<this.aIndent.length; n++)
			str += '<img src="' + ( (this.aIndent[n] == 1 && this.config.useLines) ? this.icon.line : this.icon.empty ) + '" alt="" />';
		
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
	if(eJoin==null)
	{
		alert(getMessage('NO_USERS_FOR_GROUP','CA'));
		//parent.sendtextframe.document.forms[0].instantsendmsg.focus();
		return;
	}
	eJoin.src = (this.config.useLines)?
	((status)?((bottom)?this.icon.minusBottom:this.icon.minus):((bottom)?this.icon.plusBottom:this.icon.plus)):
	((status)?this.icon.nlMinus:this.icon.nlPlus);
	eDiv.style.display = (status) ? 'block': 'none';
	
	if(eJoin!=null)
	{
		if(parent.sendtextframe != null)
			parent.sendtextframe.document.forms[0].instantsendmsg.focus();
	}
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

//functions for InstantMessengerChatSendText.jsp starts

//function to handle the enter key.
function funcenter()
{
	var text = parseInt(event.keyCode);
    if(text==13)//keycode for enter key
	{
		if(parent.sendtextframe.document.form1.instantsendmsg.value!="")
			appendtext();//submits the message once enter key is pressed
		return false;
	}
}

function enableButton(a)
{
	var text = parseInt(event.keyCode);
	if(text==86)//keycode for v
	{
		if(a.value!="")
		{
			parent.sendtextframe.document.form1.sendButton.disabled=false;
		}
	}
	else if(text==90)//keycode for z
	{
		if(a.value=="")
		{
			parent.sendtextframe.document.form1.sendButton.disabled=true;
		}
	}
	if(text==46)//keycode for delete key
	{
		if(a.value=="")
		{
			parent.sendtextframe.document.form1.sendButton.disabled=true;
		}
	}
	else if(text==8)//keycode for backspace
	{
		if(a.value=="")
		{
			parent.sendtextframe.document.form1.sendButton.disabled=true;
		}
	}
	else if(a.value.length == 1)
	{
		parent.sendtextframe.document.form1.sendButton.disabled=false;
	}
	else
	{
		return;
	}
}
//functions for InstantMessengerChatSendText.jsp ends

//functions for InstantMessengerChatTreeRefresh.jsp starts

// function for timeout - this function is called after every 200 milliseconds.
function timehandle()
{
	parent.treeframe.location.href="../../eCA/jsp/InstantMessengerChatUserTree.jsp"
	parent.sendtextframe.document.getElementById("to_user").value="";
}
//used to refresh the tree
function timer()
{
	var timer1 = setTimeout("timehandle()",200);
}
//functions for InstantMessengerChatTreeRefresh.jsp ends

function selUser()
{
	var searchText = document.treeForm.filText.value;
	var newSearchText = searchText.toLowerCase();
	var numOfUsers = document.treeForm.hiddenNumOfUsers.value;
	var temp = "";
	var newTemp = "";
	var newTemp1 = "";
	if(searchText != "")
	{
		for(var t=1;t<=parseInt(numOfUsers,10);t++)
		{
			temp = document.getElementById('sobj'+t);
			if(temp != undefined)
			{
				if(temp.userRespId != undefined)
				{
					newTemp = temp.userName.toLowerCase();
					if(newTemp.substring(0,1) == newSearchText.substring(0,1))
					{
						temp.click();
						break;
					}
				}
			}
			else
			{
				alert(getMessage('NO_USER_FOUND','CA'));
				document.treeForm.filText.value = "";
				break;
			}
		}
	}
}

