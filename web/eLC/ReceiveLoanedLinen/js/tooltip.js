	
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
	
	
	function move_box(an, box)
		{
		    var cleft = 0;
		    var ctop = 0;
		    var obj = an;
		
		    while (obj.offsetParent)
			    {
			        cleft += obj.offsetLeft;
			        ctop += obj.offsetTop;
			        obj = obj.offsetParent;
			    }
	
	   	 	box.style.left = cleft + 'px';
	
	    	ctop += an.offsetHeight + 3;
	
	    // Handle Internet Explorer body margins,
	    // which affect normal document, but not
	    // absolute-positioned stuff.
	    
		    if (document.body.currentStyle &&
		        document.body.currentStyle['marginTop'])
		    {
		        ctop += parseInt(
		            document.body.currentStyle['marginTop']);
		    }
		
		    box.style.top = ctop + 'px';
		}
	
	// Hides other alone popup boxes that might be displayed
	function hide_other_alone(obj)
		{
	    if (!document.getElementsByTagName)
	        return;
	
	    var all_divs = document.body.getElementsByTagName("DIV");
	
	    for (i = 0; i < all_divs.length; i++)
	    {
	        if (all_divs.item(i).style.position != 'absolute' ||
	            all_divs.item(i) == obj ||
	            !all_divs.item(i).alonePopupBox)
	        {
	            continue;
	        }
	
	        all_divs.item(i).style.display = 'none';
	    }
	    return;
	}
	
	// Shows a box if it wasn't shown yet or is hidden
	// or hides it if it is currently shown
	
	function show_hide_box(an, width, height, borderStyle)
	{	
	    var href = an.href;
	    var boxdiv = document.getElementById(href);
	
	    if (boxdiv != null)
	    {
	        if (boxdiv.style.display=='none')
	        {
	            hide_other_alone(boxdiv);
	            // Show existing box, move it
	            // if document changed layout
	            move_box(an, boxdiv);
	            boxdiv.style.display='block';
	
	            // Workaround for Konqueror/Safari
	            if (!boxdiv.contents.contentWindow)
	                boxdiv.contents.src = href;
	        }
	        else
	            // Hide currently shown box.
	            boxdiv.style.display='none';
	        return false;
	    }
	
	    hide_other_alone(null);
	
	    // Create box object through DOM
	    boxdiv = document.createElement('div');
	
	    // Assign id equalling to the document it will show
	    boxdiv.setAttribute('id', href);
	
	    // Add object identification variable
	    boxdiv.alonePopupBox = 1;
	
	    boxdiv.style.display = 'block';
	    boxdiv.style.position = 'absolute';
	    boxdiv.style.width = width + 'px';
	    boxdiv.style.height = height + 'px';
	    boxdiv.style.border = borderStyle;
	    boxdiv.style.textAlign = 'right';
	    boxdiv.style.padding = '4px';
	    boxdiv.style.background = '#FFFFFF';
	    document.body.appendChild(boxdiv);
	
	    var offset = 0;
	
	    // Remove the following code if 'Close' hyperlink
	    // is not needed.
	   // var close_href = document.createElement('a');
	  //  close_href.href = 'javascript:void(0);';
	 //   close_href.onclick = function()
	  //      { show_hide_box(an, width, height, borderStyle); }
	  //  close_href.appendChild(document.createTextNode('x'));
	  //  boxdiv.appendChild(close_href);
	  //  offset = close_href.offsetHeight;
	    // End of 'Close' hyperlink code.
	
	    var contents = document.createElement('iframe');
	    //contents.scrolling = 'no';
	    contents.overflowX = 'hidden';
	    contents.overflowY = 'scroll';
	    contents.frameBorder = '0';
	    contents.style.width = width + 'px';
	    contents.style.height = (height - offset) + 'px';
	
	    boxdiv.contents = contents;
	    boxdiv.appendChild(contents);
	
	    move_box(an, boxdiv);
	
	    if (contents.contentWindow)
	        contents.contentWindow.document.location.replace(
	            href);
	    else
	        contents.src = href;
	
	    // The script has successfully shown the box,
	    // prevent hyperlink navigation.
	    return false;
	}

