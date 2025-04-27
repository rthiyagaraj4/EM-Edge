// configure path to "navbar.js".  It can be relative or absolute.  We set it
// as relative here so that the demo works on file:// protocol.
_NavBar_url = "navbar";
//_NavBar_icons_url = "../../eDS/css/css2/themes/winxp";
_NavBar_icons_url = "../../eDS/css";

// this function constructs a label based on variable _NavBar_pageID which
// should be defined in the HTML file.
function L(label) {
	if (_NavBar_pageID.toLowerCase() == label.toLowerCase())
		label = "!" + label;
	return label;
}

// pass ID-s of some DIV-s as parameters:
//  - "content" is the DIV where the menu will be displayed
//  - "beforemenu" is a DIV that will appear in the nav. bar, before sections (optional)
//  - "aftermenu" is a DIV that will appear in the nav. bar but after the sections (optional)
var menu = new NavBar("SideMenu");

// adds top control buttons
menu.openMenu(true);

// set some options
//menu.prefs["animation"] = 3;    // "bloatware" ;-)
//menu.prefs["auto-hide"] = false; // the bar will autohide

// DEFINITION OF MENU SECTIONS.





// note, the last 4 links above open in a window with the name "_blank"--that is, a new window ;-)

//  label            url                                       tooltip                     icon

// call generate to create the menubar

// set current values in preferences panel
/*
function comboSelectValue(c, val) {
	var ops = c.getElementsByTagName("option");
	for (var i = 0; i < ops.length; ++i) {
		var op = ops[i];
		op.selected = (op.value == val);
	}
};*/

/*document.getElementById("autohide").checked = menu.prefs["auto-hide"];*/
/*document.getElementById("monosection").checked = menu.prefs["mono-section"];*/
/*document.getElementById("tooltips").checked = menu.prefs["tooltips"];*/
/*comboSelectValue(document.getElementById("animation"), menu.prefs["animation"]);*/
