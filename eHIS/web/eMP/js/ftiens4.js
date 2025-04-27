
var count=0;
var imgcounter=0;


function Folder(folderDescription, hreference) //constructor 
{ 
  //constant data 
 
  
  this.desc = folderDescription 
  this.hreference = hreference 
  this.id = -1   
  this.navObj = 0  
  this.iconImg = 0  
  this.nodeImg = 0  
  this.isLastNode = 0 
 
  //dynamic data 
  this.isOpen = true 
 if(sex[imgcounter] == "M")
  this.iconSrc = "../../eCommon/images/Male.gif"   
 else
 this.iconSrc = "../../eCommon/images/Female.gif"   
 
  this.children = new Array 
  this.nChildren = 0 
 imgcounter++;
 
  //methods 
  this.initialize = initializeFolder 
  this.setState = setStateFolder 
  this.addChild = addChild 
  this.createIndex = createEntryIndex 
  this.hide = hideFolder 
  this.display = display 
  this.renderOb = drawFolder 
  this.totalHeight = totalHeight 
  this.subEntries = folderSubEntries 
  this.outputLink = outputFolderLink 
} 
 
function setStateFolder(isOpen) 
{ 
  var subEntries 
  var totalHeight 
  var fIt = 0 
  var i=0 
 
  if (isOpen == this.isOpen) 
    return 
 
  if (browserVersion == 2)  
  { 
    totalHeight = 0 
    for (i=0; i < this.nChildren; i++) 
      totalHeight = totalHeight + this.children[i].navObj.clip.height 
      subEntries = this.subEntries() 
    if (this.isOpen) 
      totalHeight = 0 - totalHeight 
    for (fIt = this.id + subEntries + 1; fIt < nEntries; fIt++) 
      indexOfEntries[fIt].navObj.moveBy(0, totalHeight) 
  }  
  this.isOpen = isOpen 
  propagateChangesInState(this) 
} 
 


function propagateChangesInState(folder) 
{   
  var i=0 
 
  if (folder.isOpen) 
  { 
    if (folder.nodeImg) 
      if (folder.isLastNode) 
        folder.nodeImg.src = "../../eCommon/images/ftv2mlastnode.gif" 
      else 
	  folder.nodeImg.src = "../../eCommon/images/ftv2mnode.gif" 
  folder.iconImg.src =  "../../eCommon/images/Male.gif"  
     for (i=0; i<folder.nChildren; i++) 
      folder.children[i].display() 
  } 
  else 
  { 
    if (folder.nodeImg) 
      if (folder.isLastNode) 
        folder.nodeImg.src = "../../eCommon/images/ftv2plastnode.gif" 
      else 
	  folder.nodeImg.src = "../../eCommon/images/ftv2pnode.gif" 
    folder.iconImg.src = "../../eCommon/images/ftv2folderclosed.gif" 
    for (i=0; i<folder.nChildren; i++) 
      folder.children[i].hide() 
  }  
} 
 


function hideFolder() 
{ 
  if (browserVersion == 1) { 
    if (this.navObj.style.display == "none") 
      return 
    this.navObj.style.display = "none" 
  } else { 
    if (this.navObj.visibility == "hiden") 
      return 
    this.navObj.visibility = "hiden" 
  } 
   
  this.setState(0) 
} 
 

function initializeFolder(level, lastNode, leftSide) 
{ 
var j=0 
var i=0 
var numberOfFolders 
var numberOfDocs 
var nc 
      
  nc = this.nChildren 
   
  this.createIndex() 
 
  var auxEv = "" 
 
  //if (browserVersion > 0) 
    //auxEv = "<a href='javascript:clickOnNode("+this.id+")'>" 
 // else 
    //auxEv = "<a>" 
 
  if (level>0) 
    if (lastNode) //the last 'brother' in the children array 
    { 
      this.renderOb(leftSide + auxEv + "<img name='nodeIcon" + this.id + "' src='../../eCommon/images/ftv2mlastnode.gif' width=16 height=22 border=0></a>") 
      leftSide = leftSide + "<img src='../../eCommon/images/ftv2blank.gif' width=16 height=22>"  
      this.isLastNode = 1 
    } 
    else 
    { 
      this.renderOb(leftSide + auxEv + "<img name='nodeIcon" + this.id + "' src='../../eCommon/images/ftv2mnode.gif' width=16 height=22 border=0></a>") 
      leftSide = leftSide + "<img src='../../eCommon/images/ftv2vertline.gif' width=16 height=22>" 
      this.isLastNode = 0 
    } 
  else 
    this.renderOb("") 
   
  if (nc > 0) 
  { 
    level = level + 1 
    for (i=0 ; i < this.nChildren; i++)  
    { 
      if (i == this.nChildren-1) 
        this.children[i].initialize(level, 1, leftSide) 
      else 
        this.children[i].initialize(level, 0, leftSide) 
      } 
  } 
} 
 

function drawFolder(leftSide) 
{ 
	
  if (browserVersion == 2) { 
    if (!doc.yPos) 
      doc.yPos=8 
    doc.write("<layer id='folder" + this.id + "' top=" + doc.yPos + " visibility=hiden>") 
  } 
  
  doc.write("<table ") 
  if (browserVersion == 1) 
    doc.write(" id='folder" + this.id + "' style='position:block;' ") 
  doc.write(" border=0 cellspacing=0 cellpadding=0>") 
 // doc.write("<tr><td class='BODYCOLORFILLED'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") 
 doc.write("<tr><td class='BODYCOLORFILLED'>");
  doc.write(leftSide) 
  this.outputLink() 
  doc.write("<img name='folderIcon" + this.id + "' ") 
  doc.write("src='" + this.iconSrc+"' border=0></a>") 
	
	
if(count==hddn ){
  	doc.write("</td><td class='BODYCOLORFILLED' valign=middle ><b><font color='Red'>&nbsp;") 
  	count++; 
  }
  else
  {
  	doc.write("</td><td  class='BODYCOLORFILLED' valign=middle >&nbsp;") 
  	count++;
  }
  if (USETEXTLINKS) 
  { 
    this.outputLink() 
    doc.write(this.desc + "</a>") 
 // doc.write("<a href=" + this.link + ">" + this.desc + "</a>") 
  } 
  else 
   doc.write(this.desc) 
   doc.write("</font></B></td>")  
   doc.write("</table>") 
   
  if (browserVersion == 2) { 
    doc.write("</layer>") 
  } 
 
  if (browserVersion == 1) { 
    this.navObj = doc.all["folder"+this.id] 
    this.iconImg = doc.all["folderIcon"+this.id] 
    this.nodeImg = doc.all["nodeIcon"+this.id] 
  } else if (browserVersion == 2) { 
    this.navObj = doc.layers["folder"+this.id] 
    this.iconImg = this.navObj.document.images["folderIcon"+this.id] 
    this.nodeImg = this.navObj.document.images["nodeIcon"+this.id] 
    doc.yPos=doc.yPos+this.navObj.clip.height 
  } 
  
  
} 

function loadPages() {
	
//	alert(parent.frames[2].document.forms[0].p_id.value);
//	alert(this.hreference);
	if (this.hreference) 
	{ 

	}

}

function outputFolderLink() 
{ 
  var Patient_ID="";
 
   if (this.hreference) 
  { 
	//Patient_ID=parent.frames[2].document.Patient_ID.value;
	doc.write("<a href=" +this.hreference+ " ") 
   	if (browserVersion > 0) 
      var arr=this.desc.split(",");
  //  doc.write("onClick='javascript:clickOnFolder("+this.id+")'") 
    doc.write(">") 
  } 
  else 
     doc.write("<a>") 
//  doc.write("<a href='javascript:clickOnFolder("+this.id+")'>")   
} 



function addChild(childNode) 
{ 
  this.children[this.nChildren] = childNode 
  this.nChildren++ 
  return childNode 
} 
 
function folderSubEntries() 
{ 
  var i = 0 
  var se = this.nChildren 
 
  for (i=0; i < this.nChildren; i++){ 
    if (this.children[i].children) //is a folder 
      se = se + this.children[i].subEntries() 
  } 
 
  return se 
} 
 
 
// Definition of class Item (a document or link inside a Folder) 
// ************************************************************* 
 
function Item(itemDescription, itemLink) // Constructor 
{ 
  // constant data 
  this.desc = itemDescription 
  this.link = itemLink 
  this.id = -1 //initialized in initalize() 
  this.navObj = 0 //initialized in render() 
  this.iconImg = 0 //initialized in render() 
 
  if(sex[imgcounter] == "M")
  this.iconSrc = "../../eCommon/images/Male.gif"    
  
  else
  this.iconSrc = "../../eCommon/images/Female.gif"   
 
 
  // methods 
  this.initialize = initializeItem 
  this.createIndex = createEntryIndex 
  this.hide = hideItem 
  this.display = display 
  this.renderOb = drawItem 
  this.totalHeight = totalHeight 
  imgcounter++;
} 
 
function hideItem() 
{ 
  if (browserVersion == 1) { 
    if (this.navObj.style.display == "none") 
      return 
    this.navObj.style.display = "none" 
  } else { 
    if (this.navObj.visibility == "hiden") 
      return 
    this.navObj.visibility = "hiden" 
  }     
} 
 
function initializeItem(level, lastNode, leftSide) 
{  
  this.createIndex() 
 
  if (level>0) 
    if (lastNode) //the last 'brother' in the children array 
    { 
      this.renderOb(leftSide + "<img src='../../eCommon/images/ftv2lastnode.gif' width=16 height=22>") 
      leftSide = leftSide + "<img src='../../eCommon/images/ftv2blank.gif' width=16 height=22>"  
    } 
    else 
    { 
      this.renderOb(leftSide + "<img src='../../eCommon/images/ftv2node.gif' width=16 height=22>") 
      leftSide = leftSide + "<img src='../../eCommon/images/ftv2vertline.gif' width=16 height=22>" 
    } 
  else 
    this.renderOb("")   
} 
 


function drawItem(leftSide) 
{ 
	
  if (browserVersion == 2) 
    doc.write("<layer id='item" + this.id + "' top=" + doc.yPos + " visibility=hiden></td>") 
  /*doc.write("<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>");
  doc.write("<style>; Body; ----BODY { MARGIN-LEFT: 25; } </style>");*/
    doc.write("<table ") 
  if (browserVersion == 1) 
    doc.write(" id='item" + this.id + "' style='position:block;' ") 
  doc.write(" border=0 cellspacing=0 cellpadding=0>") 
  //doc.write("<tr><td class='BODYCOLORFILLED'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") 
doc.write("<tr><td class='BODYCOLORFILLED'>");
  doc.write(leftSide) 
  doc.write("<a href=" + this.link + ">") 
  doc.write("<img id='itemIcon"+this.id+"' ") 
  doc.write("src='"+this.iconSrc+"' border=0>") 
  doc.write("</a>") 
if(count==hddn){
  	doc.write("</td><td  class='BODYCOLORFILLED' valign=middle >&nbsp;<B><font color='Red'>")
  	count++;
  }
  else {
  	doc.write("</td><td  class='BODYCOLORFILLED' valign=middle >&nbsp;")
  	count++;
  }	
  
  if (USETEXTLINKS) 
    doc.write("<a href=" + this.link + ">" + this.desc + "</a>") 
  else 
    doc.write(this.desc) 
  doc.write("</table>") 
   
  if (browserVersion == 2) 
    doc.write("</layer>") 
    
 
  if (browserVersion == 1) { 
    this.navObj = doc.all["item"+this.id] 
    this.iconImg = doc.all["itemIcon"+this.id] 
  } else if (browserVersion == 2) { 
    this.navObj = doc.layers["item"+this.id] 
    this.iconImg = this.navObj.document.images["itemIcon"+this.id] 
    doc.yPos=doc.yPos+this.navObj.clip.height 
  } 
doc.write("</body></html>");
 
 //GifBlink(u13,'parent.frames[1].document');
} 
 
 
// Methods common to both objects (pseudo-inheritance) 
// ******************************************************** 
 
function display() 
{ 
  if (browserVersion == 1) 
    this.navObj.style.display = "block" 
  else 
    this.navObj.visibility = "show" 
} 
 
function createEntryIndex() 
{ 
  this.id = nEntries 
  indexOfEntries[nEntries] = this 
  nEntries++ 
} 
 
// total height of subEntries open 
function totalHeight() //used with browserVersion == 2 
{ 
  var h = this.navObj.clip.height 
  var i = 0 
   
  if (this.isOpen) //is a folder and _is_ open 
    for (i=0 ; i < this.nChildren; i++)  
      h = h + this.children[i].totalHeight() 
 
  return h 
} 
 
 
// Events 
// ********************************************************* 

 
function clickOnFolder(folderId) 
{ 
  var clicked = indexOfEntries[folderId] 
 
 // if (!clicked.isOpen) 

   // clickOnNode(folderId) 
   // return  
 
//   if (clicked.isSelected) 
  //  return 
} 
 
function clickOnNode(folderId) 
{ 
  var clickedFolder = 0 
  var state = 0 
 
  clickedFolder = indexOfEntries[folderId] 
  state = clickedFolder.isOpen 
 
  clickedFolder.setState(!state) //open<->close  
} 
 
function initializeDocument() 
{
	var SStyle = document.forms[0].s_Style.value;
 
doc.write("<html>");
doc.write("<body>");
doc.write("<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>");
  doc.write("<style>; Body; ----BODY { MARGIN-LEFT: 25; } </style>");
doc.write("<br>");
//doc.write("<table border='0' cellpadding='0' cellspacing='0' width='97%'>");
	//doc.write("<tr>");
	//doc.write("<td CLASS='BODYCOLORFILLED'  width='3%'>&nbsp;</td><td  class='PATIENTLINECOLOR' width='75%' id='patdetails' style='position:relative;'>&nbsp;</td><td class='PATIENTLINECOLOR' width='25%' align='right'><IMG name='nam' src='../../eCommon/images/Blank1.gif'><img name='nam1' src='../../eCommon/images/Blank1.gif'></td>");
	//doc.write("</tr>");	
//doc.write("</table>");	
//doc.write("<B><font color='Red>"+u13+"</font></B>");
 //doc.write("<br><br>");
 
 if (doc.all) 
    browserVersion = 1 //IE4   
  else 
    if (doc.layers) 
      browserVersion = 2 //NS4 
    else 
      browserVersion = 0 //other 
 
  foldersTree.initialize(0, 1, "") 
  foldersTree.display()
  
  if (browserVersion > 0) 
  { 
    doc.write("<layer top="+indexOfEntries[nEntries-1].navObj.top+">&nbsp;</layer>") 
 
    // close the whole tree 
 // clickOnNode(0) 
    // open the root folder 
  //  clickOnNode(0) 
  } 
  //GifBlink(u13,'parent.frames[1].document');
} 
// Auxiliary Functions for Folder-Treee backward compatibility 
// ********************************************************* 
 
function gFld(description, hreference) 
{ 
  folder = new Folder(description, hreference) 
  return folder 
} 
 
function gLnk(target, description, linkData) 
{ 
  fullLink = "" 
 /*
  if (target==0) 
  { 
    fullLink = "'"+linkData+"' target=\"f_query_add_mod\"" 
  } 
  else 
  { 
    if (target==1) 
       fullLink = "'http://"+linkData+"' target=_blank" 
    else 
       fullLink = "'http://"+linkData+"' target=\"f_query_add_mod\"" 
  } 
 */
 fullLink = linkData;
  linkItem = new Item(description, fullLink)   
  return linkItem 
} 
 
function insFld(parentFolder, childFolder) 
{
return parentFolder.addChild(childFolder) 
} 
 
function insDoc(parentFolder, document) 
{ 
  parentFolder.addChild(document) 
} 
 
// Global variables 
// **************** 
 
USETEXTLINKS = 0 
indexOfEntries = new Array 
nEntries = 0 
doc = document 
browserVersion = 0 
selectedFolder=0

