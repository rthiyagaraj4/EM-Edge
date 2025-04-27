
var  testpopup5="";
var val="";


function openWindow(anchor) {
if(testpopup5=="")
{
 testpopup5 = new PopupWindow();
}
testpopup5.height=200;
testpopup5.width=300;
testpopup5.offsetX=-10;
testpopup5.offsetY=10;
testpopup5.autoHide();
testpopup5.populate('<title>Options</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/core/css/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center">Cancel</td></tr><tr><td  align="centet">View</td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();" value="OK"/></td></tr></table> </FORM></CENTER>');
testpopup5.showPopup(anchor);
}


<!-- Paste this code into an external JavaScript file named: popupBox.js  -->

/* This script and many more are available free online at
The JavaScript Source :: http://javascript.internet.com
Created by: JTricks.com :: http://www.jtricks.com/ */

function move_box(an, box) {
  var cleft = 0;
  var ctop = 0;
  var obj = an;
  while (obj.offsetParent) {
    cleft += obj.offsetLeft;
    ctop += obj.offsetTop;
    obj = obj.offsetParent;
  }
  box.style.left = cleft + 'px';
  ctop += an.offsetHeight + 8;
  if (document.body.currentStyle &&
    document.body.currentStyle['marginTop']) {
    ctop += parseInt(
      document.body.currentStyle['marginTop']);
  }
  box.style.top = ctop + 'px';
}

function show_hide_box(an, width, height, borderStyle) {
  var href = an.href;
  var boxdiv = document.getElementById(href);

  if (boxdiv != null) {
    if (boxdiv.style.display=='none') {
      move_box(an, boxdiv);
      boxdiv.style.display='block';
    } else
      boxdiv.style.display='none';
    return false;
  }

  boxdiv = document.createElement('div');
  boxdiv.setAttribute('id', href);
  boxdiv.style.display = 'block';
  boxdiv.style.position = 'absolute';
  boxdiv.style.width = width + 'px';
  boxdiv.style.height = height + 'px';
  boxdiv.style.border = borderStyle;
  boxdiv.style.backgroundColor = '#fff';

  var contents = document.createElement('iframe');
  contents.scrolling = 'no';
  contents.frameBorder = '0';
  contents.style.width = width + 'px';
  contents.style.height = height + 'px';
  contents.src = href;

  boxdiv.appendChild(contents);
  document.body.appendChild(boxdiv);
  move_box(an, boxdiv);

  return false;
}

