/*hierMenus.js
* by Peter Belesis. v3.10.2 000720
* Copyright (c) 2000 internet.com Corp. All Rights Reserved.
* Originally published and documented at http://www.dhtmlab.com/
* You may use this code on a public Web site only if this entire
* copyright notice appears unchanged and you publicly display
* on the Web page a link to http://www.dhtmlab.com/.
*
* Contact pbel@websentric.com for all other uses.
*/

loader = (isFrames) ? (NS4) ? parent : parent.document.body : window;
loader.onload = startIt;
if(NS4){
	origWidth = loader.innerWidth;
	origHeight = loader.innerHeight;
	loader.onresize = reDo;
}
isLoaded = false;
NSresized = false;

if (!window.menuVersion) {
	clickKill = keepHilite = clickStart = false;
}

if (!window.imgHspace) imgHspace=0;

isWin = (navigator.appVersion.indexOf("Win") != -1)

mSecsVis = secondsVisible*1000;
isRight = (window.navFrLoc && navFrLoc == "right");
fullImgSize = (imgSiz+(imgHspace*2));
if(!IE5) {
	 imgSuf = (isRight) ? ">"  : " ALIGN=RIGHT>";
	 imgStr = "<IMG SRC='" + imgSrc + "' WIDTH=" + imgSiz + " HEIGHT=" + imgSiz +" VSPACE=2 HSPACE="+ imgHspace +" BORDER=0"+ imgSuf;
	 if(IE4) imgStr = "<SPAN STYLE='height:100%;width:"+ (fullImgSize-(isRight?3:0)) +";float:"+ (isRight?"left":"right") +";overflow:hidden'>"+ imgStr +"</SPAN>";
}

areCreated = false;
menuLoc = "content";

function initVars() {
	if(areCreated) {
		for(i=1; i<topCount; i++) {
			cur = eval("elMenu"+i);
			clearTimeout(cur.hideTimer);
			cur.hideTimer=null;
		}
		clearTimeout(allTimer);
	}
	topCount = 1;
	areCreated = false;
	beingCreated = false;
	isOverMenu = false;
	currentMenu = null;
	allTimer = null;
}

initVars();

function NSunloaded(){
	isLoaded = false;
}

function NSloaded(e){
	if (e.target.name == mainFrName) {
		initVars();
		startIt();
	}
}

function IEunloaded() {
	initVars();
	isLoaded = false;
	setTimeout("keepTrack()",50)
}

function keepTrack() {
	if (menuLoc.document.readyState == "complete") {
		initVars();
		startIt();
	}
	else {
		setTimeout("keepTrack()",50);
	}
}

function startIt() {
	isLoaded = true;
	if (isFrames) {
		menuLoc = eval("parent.frames." + mainFrName);
		if (NS4) {
			loader.captureEvents(Event.LOAD);
			loader.onload = NSloaded;
			menuLoc.onunload = NSunloaded;
		}
		if (IE4) {
			menuLoc.document.body.onunload = IEunloaded;
		}
	}
	else {
		menuLoc = window;
	}
	menuLoc.nav = nav = window;
	if (clickKill) {
		if (NS4) menuLoc.document.captureEvents(Event.MOUSEDOWN);
		menuLoc.document.onmousedown = clicked;
	}
	makeTop();   
}

function makeTop(){
	beingCreated = true;
	if(IE4) {
		topZ = 0;
		for (z=0;z<menuLoc.document.getElementById("length");z++){
			oldEl = menuLoc.document.all(z);
			topZ = Math.max(oldEl.style.zIndex,topZ)
		}
	}
	while(eval("window.arMenu" + topCount)) {
		(NS4) ? makeMenuNS(false,topCount) : makeMenuIE(false,topCount);
		topCount++
	}

	status = (topCount-1) + " Hierarchical Menu Trees Created"
	areCreated = true;
	beingCreated = false;
}

function makeMenuNS(isChild,menuCount,parMenu,parItem) {
	tempArray = eval("arMenu" + menuCount);
	
	if (!isChild) {
		tempWidth = tempArray[0] ? tempArray[0] : menuWidth;
		menu = makeElement("elMenu" + menuCount,tempWidth,null,null);
	}
	else {
		menu = makeElement("elMenu" + menuCount,null,parMenu,null);
	}
	menu.array = tempArray;
	menu.setMenuTree = setMenuTree;
	menu.setMenuTree(isChild,parMenu);

	while (menu.itemCount < menu.maxItems) {
		menu.itemCount++;
		status = "Creating Hierarchical Menus: " + menuCount + " / " + menu.itemCount;
		prevItem = (menu.itemCount > 1) ? menu.item : null;
		itemName = "item" + menuCount + "_" + menu.itemCount;

		menu.item = makeElement(itemName,null,null,menu);

		menu.item.prevItem = prevItem;
		menu.item.setup = itemSetup;
		menu.item.setup(menu.itemCount,menu.array);
		if (menu.item.hasMore) {
			makeMenuNS(true,menuCount + "_" + menu.itemCount,menu,menu.item);
			menu = menu.parentMenu;
		}
	}
	menu.lastItem = menu.item;
	menu.setup(isChild,parMenu,parItem);
}

function findTree(men){
	foundTree = false;
	for(i=11;i<men.array.length;i+=3){
		if(men.array[i]) {
			foundTree = true;
			break;
		}
	}
	return foundTree;
}

function setMenuTree(isChild,parMenu) {
	if (!isChild) {
		this.menuWidth = this.array[0] ? this.array[0] : menuWidth;
		this.menuLeft = this.array[1];
		this.menuTop = this.array[2];
		this.menuFontColor = this.array[3] ? this.array[3] : fntCol;
		this.menuFontOver = this.array[4] ? this.array[4] : overFnt;
		this.menuBGColor = this.array[5] ? this.array[5] : backCol;
		this.menuBGOver = this.array[6] ? this.array[6] : overCol;
		this.menuBorCol = this.array[7] ? this.array[7] : borCol;
		this.menuSeparatorCol = this.array[8] ? this.array[8] : separatorCol;
		this.treeParent = this;
		this.startChild = this;
		this.isTree = findTree(this);
	}
	else {
		this.menuWidth = parMenu.menuWidth;
		this.menuLeft = parMenu.menuLeft;
		this.menuTop = parMenu.menuTop;
		this.menuFontColor = parMenu.menuFontColor;
		this.menuFontOver = parMenu.menuFontOver;
		this.menuBGColor = parMenu.menuBGColor;
		this.menuBGOver = parMenu.menuBGOver;
		this.menuBorCol = parMenu.menuBorCol;
		this.menuSeparatorCol = parMenu.menuSeparatorCol;
		this.treeParent = parMenu.treeParent;
		this.isTree = parMenu.isTree;
	}

	this.maxItems = (isChild) ? this.array.length/3 : (this.array.length-9)/3;
	this.hasParent = isChild;
	this.setup = menuSetup;
	this.itemCount = 0;
}

function makeMenuIE(isChild,menuCount,parMenu) {
	menu = makeElement("elMenu" + menuCount);
	menu.array = eval("arMenu" + menuCount);
	menu.setMenuTree = setMenuTree;
	menu.setMenuTree(isChild,parMenu);
	menu.itemStr = "";
	
	while (menu.itemCount < menu.maxItems) {
		menu.itemCount++;
		status = "Creating Hierarchical Menus: " + menuCount + " / " + menu.itemCount;
		itemName = "item" + menuCount + "_" + menu.itemCount;

		arrayPointer = (isChild) ? (menu.itemCount-1)*3 :((menu.itemCount-1)*3)+9;
		dispText = menu.array[arrayPointer];
		hasMore = menu.array[arrayPointer + 2];

		if(IE5) {
			newSpan = menuLoc.document.createElement("SPAN");
			with(newSpan) {
				id = itemName;
				with(style) {
					width = (menu.menuWidth-(borWid*2));
					fontSize = fntSiz + "pt";
					fontWeight = (fntBold) ? "bold" : "normal";
					fontStyle = (fntItal) ? "italic" : "normal";
					fontFamily = fntFam;
					padding = itemPad;
					borderBottomWidth = separator + "px";
					borderBottomStyle = "solid";
				}
				innerHTML = dispText;
			}
	
			newBreak = menuLoc.document.createElement("BR");
			menu.appendChild(newSpan);
			menu.appendChild(newBreak);
			if(hasMore) {

//3.10.2 added next 2 statements:
				if (isRight) newSpan.style.paddingLeft = itemPad+fullImgSize;
				else newSpan.style.paddingRight = itemPad+fullImgSize;

				newImage = menuLoc.document.createElement("IMAGE");
				with(newImage){
					src = imgSrc;
					with(style) {
						position = "absolute";
						width = imgSiz;
						height = imgSiz;
						left = (isRight) ? itemPad : (newSpan.style.pixelWidth - itemPad - imgSiz);
						top = newSpan.offsetTop + itemPad + (isMac ? 0 : 2);
					}
				}
				newSpan.appendChild(newImage);
			}
		}
		else {
			htmStr = (hasMore) ? imgStr + dispText : dispText;
			menu.itemStr += "<SPAN ID=" + itemName + " STYLE=\"width:" + (menu.menuWidth-(borWid*2)) + "\">" + htmStr + "</SPAN><BR>";
		}
		if (hasMore) {
			makeMenuIE(true,menuCount + "_" + menu.itemCount,menu);
			menu = menu.parentMenu;
		}
	}

	if(!IE5) menu.innerHTML = menu.itemStr;

	itemColl = menu.children.tags("SPAN");
	for (i=0; i<itemColl.length; i++) {
		it = itemColl(i);
		it.setup = itemSetup;
		it.setup(i+1,menu.array);
	}
	menu.lastItem = itemColl(itemColl.length-1);
	menu.setup(isChild,parMenu);
}

function makeElement(whichEl,whichWidth,whichParent,whichContainer) {
	if (NS4) {
		if (whichWidth) {
			elWidth = whichWidth;
		}
		else {
			elWidth = (whichContainer) ? whichContainer.menuWidth : whichParent.menuWidth;
			if (whichContainer) elWidth = elWidth-(borWid*2)-(itemPad*2);
		}
		if (!whichContainer) whichContainer = menuLoc;
		eval(whichEl + "= new Layer(elWidth,whichContainer)");
	}
	else {
		if (IE5) {
			newDiv = menuLoc.document.createElement("DIV");
			newDiv.style.position = "absolute";
			newDiv.id = whichEl;
			menuLoc.document.body.appendChild(newDiv);
		}
		else {
			elStr = "<DIV ID=" + whichEl + " STYLE='position:absolute'></DIV>";
			menuLoc.document.body.insertAdjacentHTML("BeforeEnd",elStr);
		}
		if (isFrames) eval(whichEl + "= menuLoc." + whichEl);
	}
	return eval(whichEl);
}

function itemSetup(whichItem,whichArray) {
	this.onmouseover = itemOver;
	this.onmouseout = itemOut;
	this.container = (NS4) ? this.parentLayer : this.parentElement;

	arrayPointer = (this.container.hasParent) ? (whichItem-1)*3 : ((whichItem-1)*3)+9;
	this.dispText = whichArray[arrayPointer];
	this.linkText = whichArray[arrayPointer + 1];
	this.hasMore = whichArray[arrayPointer + 2];

	if (IE4 && this.hasMore) {
		this.child = eval("elMenu" + this.id.substr(4));
		this.child.parentMenu = this.container;
		this.child.parentItem = this;
	}

	if (this.linkText) {
		if (NS4) {
			this.captureEvents(Event.MOUSEUP)
			this.onmouseup = linkIt;
		}
		else {
			this.onclick = linkIt;
			this.style.cursor = "hand";
		}
	}

	if (NS4) {
		htmStr = this.dispText;
		if (fntBold) htmStr = htmStr.bold();
		if (fntItal) htmStr = htmStr.italics();

		htmStr = "<FONT FACE='" + fntFam + "' POINT-SIZE=" + fntSiz + ">" + htmStr+ "</FONT>";
		this.htmStrOver = htmStr.fontcolor(this.container.menuFontOver);
		this.htmStr = htmStr.fontcolor(this.container.menuFontColor);
		if(this.hasMore) {
			this.document.write(imgStr);
			this.document.close();
		}
		this.visibility = "inherit";
		this.bgColor = this.container.menuBGColor;
		if (whichItem == 1) {
			this.top = borWid + itemPad;
		}
		else {
			this.top = this.prevItem.top + this.prevItem.clip.height + separator;
		}
		this.left = borWid + itemPad;
		this.clip.top = this.clip.left = -itemPad;
		this.clip.right = this.container.menuWidth-(borWid*2)-itemPad;
		maxTxtWidth = this.container.menuWidth-(borWid*2)-(itemPad*2);
		if (this.container.isTree) maxTxtWidth-=(fullImgSize);

		this.txtLyrOff = new Layer(maxTxtWidth,this);
		if (isRight && this.container.isTree) this.txtLyrOff.left = fullImgSize;
		this.txtLyrOff.document.write(this.htmStr);
		this.txtLyrOff.document.close();
		this.txtLyrOff.visibility = "inherit";

		this.clip.bottom = this.txtLyrOff.document.height+itemPad;

		this.txtLyrOn = new Layer(maxTxtWidth,this);
		if (isRight && this.container.isTree) this.txtLyrOn.left = fullImgSize;
		this.txtLyrOn.document.write(this.htmStrOver);
		this.txtLyrOn.document.close();
		this.txtLyrOn.visibility = "hide";

		this.dummyLyr = new Layer(100,this);
		this.dummyLyr.left = this.dummyLyr.top = -itemPad;
		this.dummyLyr.clip.width = this.clip.width;
		this.dummyLyr.clip.height = this.clip.height;
		this.dummyLyr.visibility = "inherit";
	}
	else {
		with (this.style) {
			if(!IE5) {
				fontSize = fntSiz + "pt";
				fontWeight = (fntBold) ? "bold" : "normal";
				fontStyle =   (fntItal) ? "italic" : "normal";
				fontFamily = fntFam;
				padding = itemPad;
				borderBottomWidth = separator + "px";
				borderBottomStyle = "solid";
			}

//3.10.2 modified next statement to one following
//			if (this.container.isTree && (IE5 || (!IE5 && !this.hasMore))) {
			if (this.container.isTree && !this.hasMore) {
				if (isRight) paddingLeft = itemPad+fullImgSize;
				else paddingRight = itemPad+fullImgSize;
			}
			color = this.container.menuFontColor;
			borderBottomColor = this.container.menuSeparatorCol;
			backgroundColor = this.container.menuBGColor;
		}
	}
}   

function menuSetup(hasParent,openCont,openItem) {
	this.onmouseover = menuOver;
	this.onmouseout = menuOut;
	
	this.showIt = showIt;
	this.keepInWindow = keepInWindow;
	this.hideTree = hideTree
	this.hideParents = hideParents;
	this.hideChildren = hideChildren;
	this.hideTop = hideTop;
	this.hasChildVisible = false;
	this.isOn = false;
	this.hideTimer = null;

	this.childOverlap = (perCentOver != null) ? ((perCentOver/100) * this.menuWidth) : childOverlap;
	this.currentItem = null;
	this.hideSelf = hideSelf;
		
	if (hasParent) {
		this.hasParent = true;
		this.parentMenu = openCont;
		if (NS4) {
			this.parentItem = openItem;
			this.parentItem.child = this;
		}
	}
	else {
		this.hasParent = false;
	}

	if (NS4) {
		this.bgColor = this.menuBorCol;
		this.fullHeight = this.lastItem.top + this.lastItem.clip.bottom + borWid;
		this.clip.right = this.menuWidth;
		this.clip.bottom = this.fullHeight;
	}
	else {
		with (this.style) {
			width = this.menuWidth;
			borderWidth = borWid;
			borderColor = this.menuBorCol;
			borderStyle = borSty;
			zIndex = topZ;

//3.10.2 added next statement
			overflow = "hidden";
		}
		this.lastItem.style.border="";
		this.fullHeight = this.offsetHeight;
		if(isMac)this.style.pixelHeight = this.fullHeight;
		this.fullHeight = this.scrollHeight;
		this.showIt(false);
		this.onselectstart = cancelSelect;
		this.moveTo = moveTo;
		this.moveTo(0,0);
	}
}

function popUp(menuName,e){
	if (NS4 && NSresized) startIt();
	if (!isLoaded) return;
	linkEl = (NS4) ? e.target : event.target;
	if (clickStart) linkEl.onclick = popMenu;
	if (!beingCreated && !areCreated) startIt();
	linkEl.menuName = menuName;   
	if (!clickStart) popMenu(e);
}

function popMenu(e){
	if (!isLoaded || !areCreated) return true;

	eType = (NS4) ? e.type : event.type;
	if (clickStart && eType != "click") return true;
	hideAll();

	linkEl = (NS4) ? e.target : event.target;
	
	currentMenu = eval(linkEl.menuName);
	currentMenu.hasParent = false;
	currentMenu.treeParent.startChild = currentMenu;
	
	if (IE4) menuLocBod = menuLoc.document.body;
	if (!isFrames) {
		xPos = (currentMenu.menuLeft) ? currentMenu.menuLeft : (NS4) ? e.pageX : (event.clientX + menuLocBod.scrollLeft);
		yPos = (currentMenu.menuTop) ? currentMenu.menuTop : (NS4) ? e.pageY : (event.clientY + menuLocBod.scrollTop);
	}
	else {
		switch (navFrLoc) {
			case "left":
				xPos = (currentMenu.menuLeft) ? currentMenu.menuLeft : (NS4) ? menuLoc.pageXOffset : menuLocBod.scrollLeft;
				yPos = (currentMenu.menuTop) ? currentMenu.menuTop : (NS4) ? (e.pageY-pageYOffset)+menuLoc.pageYOffset : event.clientY + menuLocBod.scrollTop;
				break;
			case "top":
				xPos = (currentMenu.menuLeft) ? currentMenu.menuLeft : (NS4) ? (e.pageX-pageXOffset)+menuLoc.pageXOffset : event.clientX + menuLocBod.scrollLeft;
				yPos = (currentMenu.menuTop) ? currentMenu.menuTop : (NS4) ? menuLoc.pageYOffset : menuLocBod.scrollTop;
				break;
			case "bottom":
				xPos = (currentMenu.menuLeft) ? currentMenu.menuLeft : (NS4) ? (e.pageX-pageXOffset)+menuLoc.pageXOffset : event.clientX + menuLocBod.scrollLeft;
				yPos = (currentMenu.menuTop) ? currentMenu.menuTop : (NS4) ? menuLoc.pageYOffset+menuLoc.innerHeight : menuLocBod.scrollTop + menuLocBod.clientHeight;
				break;
			case "right":
				xPos = (currentMenu.menuLeft) ? currentMenu.menuLeft : (NS4) ? menuLoc.pageXOffset+menuLoc.innerWidth : menuLocBod.scrollLeft+menuLocBod.clientWidth;
				yPos = (currentMenu.menuTop) ? currentMenu.menuTop : (NS4) ? (e.pageY-pageYOffset)+menuLoc.pageYOffset : event.clientY + menuLocBod.scrollTop;
				break;
		}
	}

	currentMenu.moveTo(xPos,yPos);
	currentMenu.keepInWindow()
	currentMenu.isOn = true;
	currentMenu.showIt(true);

	return false;
}

function menuOver(e) {
	this.isOn = true;
	isOverMenu = true;
	currentMenu = this;
	if (this.hideTimer) clearTimeout(this.hideTimer);
}

function menuOut() {
	if (IE4) {
		theEvent = menuLoc.event;
		if (theEvent.srcElement.contains(theEvent.toElement)) return;
	}
	this.isOn = false;
	isOverMenu = false;

	menuLoc.status = "";
	if (!clickKill) allTimer = setTimeout("currentMenu.hideTree()",10);  
}

function itemOver(){
	if (keepHilite) {
		if (this.container.currentItem && this.container.currentItem != this) {
			if (NS4) {
				this.container.currentItem.bgColor = this.container.menuBGColor;
				this.container.currentItem.txtLyrOff.visibility = "inherit";
				this.container.currentItem.txtLyrOn.visibility = "hide";
			}
			else {
				with (this.container.currentItem.style) {
					backgroundColor = this.container.menuBGColor;
					color = this.container.menuFontColor;
				}
			}
		}
	}

	if (IE4) {
		theEvent = menuLoc.event;
		if (theEvent.srcElement.tagName == "IMG") return;
		this.style.backgroundColor = this.container.menuBGOver;
		this.style.color = this.container.menuFontOver;
	}
	else {
		this.bgColor = this.container.menuBGOver;
		this.txtLyrOff.visibility = "hide";
		this.txtLyrOn.visibility = "inherit";
	}

	menuLoc.status = this.linkText;

	this.container.currentItem = this;

	if (this.container.hasChildVisible) {
		this.container.hideChildren(this);
	}

	if (this.hasMore) {
		horOffset = (isRight) ? (this.container.childOverlap - this.container.menuWidth) : (this.container.menuWidth - this.container.childOverlap);

		if (NS4) {
			this.childX = this.container.left + horOffset;
			this.childY = (this.pageY+this.clip.top) + childOffset;
		}
		else {
			this.childX = this.container.style.pixelLeft + horOffset;
			this.childY = this.offsetTop + this.container.style.pixelTop + childOffset + borWid;
		}

		this.child.moveTo(this.childX,this.childY);
		this.child.keepInWindow();
		this.container.hasChildVisible = true;
		this.container.visibleChild = this.child;
		this.child.showIt(true);
	}
}

function itemOut() {
	if (IE4) {
		theEvent = menuLoc.event;
		 if (theEvent.srcElement.contains(theEvent.toElement)
	  || (theEvent.fromElement.tagName=="IMG" && theEvent.toElement.contains(theEvent.fromElement)))
		  return;
		if (!keepHilite) {
			this.style.backgroundColor = this.container.menuBGColor;
			this.style.color = this.container.menuFontColor;
		}
	}
	else {
		if (!keepHilite) {
			this.bgColor = this.container.menuBGColor;
			this.txtLyrOff.visibility = "inherit";
			this.txtLyrOn.visibility = "hide";
		}
		if (!isOverMenu && !clickKill) {
			allTimer = setTimeout("currentMenu.hideTree()",10); 
		}
	}
}

function moveTo(xPos,yPos) {
	this.style.pixelLeft = xPos;
	this.style.pixelTop = yPos;
}

function showIt(on) {
	if (NS4) {
		this.visibility = (on) ? "show" : "hide";
		if (keepHilite && this.currentItem) {
			this.currentItem.bgColor = this.menuBGColor;
			this.currentItem.txtLyrOff.visibility = "inherit";
			this.currentItem.txtLyrOn.visibility = "hide";
		}
	}
	else {
		this.style.visibility = (on) ? "visible" : "hidden";
		if (keepHilite && this.currentItem) {
			with (this.currentItem.style) {
				backgroundColor = this.menuBGColor;
				color = this.menuFontColor;
			}
		}
	}
	this.currentItem = null;
}

function keepInWindow() {
	scrBars = 20;
	botScrBar = (isFrames && navFrLoc=="bottom") ? (borWid*2) : scrBars;
	rtScrBar = (isFrames && navFrLoc=="right") ? (borWid*2) : scrBars;
	if (NS4) {
		winRight = (menuLoc.pageXOffset + menuLoc.innerWidth) - rtScrBar;
		rightPos = this.left + this.menuWidth;
	
		if (rightPos > winRight) {
			if (this.hasParent) {
				parentLeft = this.parentMenu.left;
				newLeft = ((parentLeft-this.menuWidth) + this.childOverlap);
				this.left = newLeft;
			}
			else {
				dif = rightPos - winRight;
				this.left -= dif;
			}
		}

		winBot = (menuLoc.pageYOffset + menuLoc.innerHeight) - botScrBar ;
		botPos = this.top + this.fullHeight;

		if (botPos > winBot) {
			dif = botPos - winBot;
			this.top -= dif;
		}
		
		winLeft = menuLoc.pageXOffset;
		leftPos = this.left;

		if (leftPos < winLeft) {
			if (this.hasParent) {
				parentLeft = this.parentMenu.left;
				newLeft = ((parentLeft+this.menuWidth) - this.childOverlap);
				this.left = newLeft;
			}
			else {
				this.left = 5;
			}
		}
	}
	else {
		 winRight = (menuLoc.document.body.scrollLeft + menuLoc.document.body.clientWidth) - rtScrBar;
		rightPos = this.style.pixelLeft + this.menuWidth;
	
		if (rightPos > winRight) {
			if (this.hasParent) {
				parentLeft = this.parentMenu.style.pixelLeft;
				newLeft = ((parentLeft - this.menuWidth) + this.childOverlap);
				this.style.pixelLeft = newLeft;
			}
			else {
				dif = rightPos - winRight;
				this.style.pixelLeft -= dif;
			}
		}

		winBot = (menuLoc.document.body.scrollTop + menuLoc.document.body.clientHeight) - botScrBar;
		botPos = this.style.pixelTop + this.fullHeight;

		if (botPos > winBot) {
			dif = botPos - winBot;
			this.style.pixelTop -= dif;
		}
		
		winLeft = menuLoc.document.body.scrollLeft;
		leftPos = this.style.pixelLeft;

		if (leftPos < winLeft) {
			if (this.hasParent) {
				parentLeft = this.parentMenu.style.pixelLeft;
				newLeft = ((parentLeft+this.menuWidth) - this.childOverlap);
				this.style.pixelLeft = newLeft;
			}
			else {
				this.style.pixelLeft = 5;
			}
		}
	}
}

function linkIt() {
	if (this.linkText.indexOf("javascript:")!=-1) 
		eval(this.linkText)
	else 
		{
		menuLoc.location.href = this.linkText;
		}
}

function popDown(menuName){
	if (!isLoaded || !areCreated) return;
	whichEl = eval(menuName);
	whichEl.isOn = false;
	if (!clickKill) whichEl.hideTop();
}

function hideAll() {
	for(i=1; i<topCount; i++) {
		temp = eval("elMenu" + i + ".startChild");
		temp.isOn = false;
		if (temp.hasChildVisible) temp.hideChildren();
		temp.showIt(false);
	}   
}

function hideTree() { 
	allTimer = null;
	if (isOverMenu) return;
	if (this.hasChildVisible) {
		this.hideChildren();
	}
	this.hideParents();
}

function hideTop() {
	whichTop = this;
	(clickKill) ? whichTop.hideSelf() : (this.hideTimer = setTimeout("if(whichTop.hideSelf)whichTop.hideSelf()",mSecsVis));
}

function hideSelf() {
	this.hideTimer = null;
	if (!this.isOn && !isOverMenu) { 
		this.showIt(false);
	}
}

function hideParents() {
	tempMenu = this;
	while (tempMenu.hasParent) {
		tempMenu.showIt(false);
		tempMenu.parentMenu.isOn = false;      
		tempMenu = tempMenu.parentMenu;
	}
	tempMenu.hideTop();
}

function hideChildren(item) {
	tempMenu = this.visibleChild;
	while (tempMenu.hasChildVisible) {
		tempMenu.visibleChild.showIt(false);
		tempMenu.hasChildVisible = false;
		tempMenu = tempMenu.visibleChild;
	}

	if (!this.isOn || !item.hasMore || this.visibleChild != this.child) {
		this.visibleChild.showIt(false);
		this.hasChildVisible = false;
	}
}

function cancelSelect(){return false}

function reDo(){
	if (loader.innerWidth==origWidth && loader.innerHeight==origHeight) return;
	initVars();
	NSresized=true;
	menuLoc.location.reload();
}

function clicked() {
	if (!isOverMenu && currentMenu!=null && !currentMenu.isOn) {
		whichEl = currentMenu;
		whichEl.hideTree();
	}
}

window.onerror = handleErr;

function handleErr(){
	arAccessErrors = ["permission","access"];
	mess = arguments[0].toLowerCase();
	found = false;
	for (i=0;i<arAccessErrors.length;i++) {
		errStr = arAccessErrors[i];
		if (mess.indexOf(errStr)!=-1) found = true;
	}
	return found;
}

//end

