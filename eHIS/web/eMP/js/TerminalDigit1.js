function clearAll()
{
     if(terminal_level_form.group_count.value=="")
	  {
		
			          document.getElementById("div14").style.visibility = 'hidden';
						document.getElementById("div2").style.visibility = 'hidden';
						document.getElementById("div3").style.visibility = 'hidden';
						document.getElementById("div4").style.visibility = 'hidden';
						document.getElementById("div5").style.visibility = 'hidden';
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';
						document.getElementById("div10").style.visibility = 'hidden';
						document.getElementById("div11").style.visibility = 'hidden';
						document.getElementById("div12").style.visibility = 'hidden';
						document.getElementById("div13").style.visibility = 'hidden';						
					    terminal_level_form.pt1.style.visibility="hidden";
						terminal_level_form.pt1.value="";
						terminal_level_form.pt2.style.visibility="hidden";
						terminal_level_form.pt2.value="";
						terminal_level_form.pt3.style.visibility="hidden";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";
						terminal_level_form.pt7.value="";
						terminal_level_form.st1.style.visibility="hidden";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						terminal_level_form.pt8.style.visibility="hidden";
						terminal_level_form.st8.style.visibility="hidden";
						terminal_level_form.tt8.style.visibility="hidden";
	               	//	terminal_level_form.terminal_digit_count.focus();	
		          //	terminal_level_form.terminal_digit_count.blur();	
	}

}
    function chkdigitcnt(obj)
    {
	if (CheckNum(obj))
	{
		
		if(terminal_level_form.terminal_digit_count.value!=0 &&  terminal_level_form.group_count.value=="")
		{			
			if(terminal_level_form.terminal_digit_count.value<1||	terminal_level_form.terminal_digit_count.value>7)
			{	
				alert(getMessage("INV_RANGE","MP"));
				document.getElementById("div14").style.visibility = 'hidden';
				terminal_level_form.terminal_digit_count.focus();
				terminal_level_form.terminal_digit_count.select();
				if (terminal_level_form.terminal_digit1_position.style.visibility=="visible")
					terminal_level_form.terminal_digit1_position.value = "";
				if (terminal_level_form.terminal_digit2_position.style.visibility=="visible")
					terminal_level_form.terminal_digit2_position.value = "";				
				if (terminal_level_form.terminal_digit3_position.style.visibility=="visible")
					terminal_level_form.terminal_digit3_position.value = "";
				if (terminal_level_form.terminal_digit4_position.style.visibility=="visible")
					terminal_level_form.terminal_digit4_position.value = "";
				if (terminal_level_form.terminal_digit5_position.style.visibility=="visible")
					terminal_level_form.terminal_digit5_position.value = "";
				if (terminal_level_form.terminal_digit6_position.style.visibility=="visible")
					terminal_level_form.terminal_digit6_position.value = "";
				if (terminal_level_form.terminal_digit7_position.style.visibility=="visible")
					terminal_level_form.terminal_digit7_position.value = "";
				terminal_level_form.terminal_digit1_position.style.visibility="hidden";
				terminal_level_form.terminal_digit2_position.style.visibility="hidden";
				terminal_level_form.terminal_digit3_position.style.visibility="hidden";
				terminal_level_form.terminal_digit4_position.style.visibility="hidden";
				terminal_level_form.terminal_digit5_position.style.visibility="hidden";
				terminal_level_form.terminal_digit6_position.style.visibility="hidden";
				terminal_level_form.terminal_digit7_position.style.visibility="hidden";				
				terminal_level_form.img7.style.visibility="hidden";
				terminal_level_form.img6.style.visibility="hidden";
				terminal_level_form.img5.style.visibility="hidden";
				terminal_level_form.img4.style.visibility="hidden";
				terminal_level_form.img3.style.visibility="hidden";
				terminal_level_form.img2.style.visibility="hidden";
				terminal_level_form.img1.style.visibility="hidden";
			}
			else
			{	
						document.getElementById("div14").style.visibility = 'visible';
						document.getElementById("div2").style.visibility = 'hidden';
						document.getElementById("div3").style.visibility = 'hidden';
						document.getElementById("div4").style.visibility = 'hidden';
						document.getElementById("div5").style.visibility = 'hidden';
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';
						document.getElementById("div10").style.visibility = 'hidden';
						document.getElementById("div11").style.visibility = 'hidden';
						document.getElementById("div12").style.visibility = 'hidden';
						document.getElementById("div13").style.visibility = 'hidden';						
						
						terminal_level_form.terminal_digit1_position.value=""
						terminal_level_form.terminal_digit2_position.value=""
						terminal_level_form.terminal_digit3_position.value=""
						terminal_level_form.terminal_digit4_position.value=""
						terminal_level_form.terminal_digit5_position.value=""
						terminal_level_form.terminal_digit6_position.value=""
						terminal_level_form.terminal_digit7_position.value=""
						
						terminal_level_form.pt1.style.visibility="hidden";
						terminal_level_form.pt1.value="";
						terminal_level_form.pt2.style.visibility="hidden";
						terminal_level_form.pt2.value="";
						terminal_level_form.pt3.style.visibility="hidden";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";
						terminal_level_form.pt7.value="";
						terminal_level_form.pt8.style.visibility="hidden";
						terminal_level_form.pt8.value="";
						terminal_level_form.st1.style.visibility="hidden";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.st8.style.visibility="hidden";
						terminal_level_form.st8.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						terminal_level_form.tt8.style.visibility="hidden";				
						terminal_level_form.tt8.value="";
				if(terminal_level_form.terminal_digit_count.value==1)
				{				
					terminal_level_form.terminal_digit1_position.style.visibility="visible";
					terminal_level_form.terminal_digit2_position.style.visibility="hidden";
					terminal_level_form.terminal_digit3_position.style.visibility="hidden";
					terminal_level_form.terminal_digit4_position.style.visibility="hidden";
					terminal_level_form.terminal_digit5_position.style.visibility="hidden";
					terminal_level_form.terminal_digit6_position.style.visibility="hidden";
					terminal_level_form.terminal_digit7_position.style.visibility="hidden";

					terminal_level_form.img7.style.visibility="hidden";
					terminal_level_form.img6.style.visibility="hidden";
					terminal_level_form.img5.style.visibility="hidden";
					terminal_level_form.img4.style.visibility="hidden";
					terminal_level_form.img3.style.visibility="hidden";
					terminal_level_form.img2.style.visibility="hidden";
					terminal_level_form.img1.style.visibility="visible";
				}
				else if(terminal_level_form.terminal_digit_count.value==2)
				{
					terminal_level_form.terminal_digit1_position.style.visibility="visible";
					terminal_level_form.terminal_digit2_position.style.visibility="visible";
					terminal_level_form.terminal_digit3_position.style.visibility="hidden";
					terminal_level_form.terminal_digit4_position.style.visibility="hidden";
					terminal_level_form.terminal_digit5_position.style.visibility="hidden";
					terminal_level_form.terminal_digit6_position.style.visibility="hidden";
					terminal_level_form.terminal_digit7_position.style.visibility="hidden";
					terminal_level_form.img7.style.visibility="hidden";
					terminal_level_form.img6.style.visibility="hidden";
					terminal_level_form.img5.style.visibility="hidden";
					terminal_level_form.img4.style.visibility="hidden";
					terminal_level_form.img3.style.visibility="hidden";
					terminal_level_form.img2.style.visibility="visible";
					terminal_level_form.img1.style.visibility="visible";
				}				
				else if(terminal_level_form.terminal_digit_count.value==3)
				{
					terminal_level_form.terminal_digit1_position.style.visibility="visible";
					terminal_level_form.terminal_digit2_position.style.visibility="visible";
					terminal_level_form.terminal_digit3_position.style.visibility="visible";
					terminal_level_form.terminal_digit4_position.style.visibility="hidden";
					terminal_level_form.terminal_digit5_position.style.visibility="hidden";
					terminal_level_form.terminal_digit6_position.style.visibility="hidden";
					terminal_level_form.terminal_digit7_position.style.visibility="hidden";
					terminal_level_form.img7.style.visibility="hidden";
					terminal_level_form.img6.style.visibility="hidden";
					terminal_level_form.img5.style.visibility="hidden";
					terminal_level_form.img4.style.visibility="hidden";
					terminal_level_form.img3.style.visibility="visible";
					terminal_level_form.img2.style.visibility="visible";
					terminal_level_form.img1.style.visibility="visible";
    			}
				else if(terminal_level_form.terminal_digit_count.value==4)
				{
					terminal_level_form.terminal_digit1_position.style.visibility="visible";
					terminal_level_form.terminal_digit2_position.style.visibility="visible";
					terminal_level_form.terminal_digit3_position.style.visibility="visible";
					terminal_level_form.terminal_digit4_position.style.visibility="visible";
					terminal_level_form.terminal_digit5_position.style.visibility="hidden";
					terminal_level_form.terminal_digit6_position.style.visibility="hidden";
					terminal_level_form.terminal_digit7_position.style.visibility="hidden";
					terminal_level_form.img7.style.visibility="hidden";
					terminal_level_form.img6.style.visibility="hidden";
					terminal_level_form.img5.style.visibility="hidden";
					terminal_level_form.img4.style.visibility="visible";
					terminal_level_form.img3.style.visibility="visible";
					terminal_level_form.img2.style.visibility="visible";
					terminal_level_form.img1.style.visibility="visible";
				}
			else if(terminal_level_form.terminal_digit_count.value==5)
				{
					terminal_level_form.terminal_digit1_position.style.visibility="visible";
					terminal_level_form.terminal_digit2_position.style.visibility="visible";
					terminal_level_form.terminal_digit3_position.style.visibility="visible";
					terminal_level_form.terminal_digit4_position.style.visibility="visible";
					terminal_level_form.terminal_digit5_position.style.visibility="visible";
					terminal_level_form.terminal_digit6_position.style.visibility="hidden";
					terminal_level_form.terminal_digit7_position.style.visibility="hidden";
					terminal_level_form.img7.style.visibility="hidden";
					terminal_level_form.img6.style.visibility="hidden";
					terminal_level_form.img5.style.visibility="visible";
					terminal_level_form.img4.style.visibility="visible";
					terminal_level_form.img3.style.visibility="visible";
					terminal_level_form.img2.style.visibility="visible";
					terminal_level_form.img1.style.visibility="visible";
 			}
			else if(terminal_level_form.terminal_digit_count.value==6)
				{
					terminal_level_form.terminal_digit1_position.style.visibility="visible";
					terminal_level_form.terminal_digit2_position.style.visibility="visible";
					terminal_level_form.terminal_digit3_position.style.visibility="visible";
					terminal_level_form.terminal_digit4_position.style.visibility="visible";
					terminal_level_form.terminal_digit5_position.style.visibility="visible";
					terminal_level_form.terminal_digit6_position.style.visibility="visible";
					terminal_level_form.terminal_digit7_position.style.visibility="hidden";
					terminal_level_form.img7.style.visibility="hidden";
					terminal_level_form.img6.style.visibility="visible";
					terminal_level_form.img5.style.visibility="visible";
					terminal_level_form.img4.style.visibility="visible";
					terminal_level_form.img3.style.visibility="visible";
					terminal_level_form.img2.style.visibility="visible";
					terminal_level_form.img1.style.visibility="visible";
				}
				else if(terminal_level_form.terminal_digit_count.value==7)
				{	
					terminal_level_form.terminal_digit1_position.style.visibility="visible";
					terminal_level_form.terminal_digit2_position.style.visibility="visible";
					terminal_level_form.terminal_digit3_position.style.visibility="visible";
					terminal_level_form.terminal_digit4_position.style.visibility="visible";
					terminal_level_form.terminal_digit5_position.style.visibility="visible";
					terminal_level_form.terminal_digit6_position.style.visibility="visible";
					terminal_level_form.terminal_digit7_position.style.visibility="visible";
					terminal_level_form.img7.style.visibility="visible";
					terminal_level_form.img6.style.visibility="visible";
					terminal_level_form.img5.style.visibility="visible";
					terminal_level_form.img4.style.visibility="visible";
					terminal_level_form.img3.style.visibility="visible";
					terminal_level_form.img2.style.visibility="visible";
					terminal_level_form.img1.style.visibility="visible";
    			}
				if (terminal_level_form.terminal_digit1_position.style.visibility=="visible")
					terminal_level_form.terminal_digit1_position.focus();
			}
		}
		else if(terminal_level_form.terminal_digit_count.value!=0 &&  terminal_level_form.group_count.value!=0)
		{	
			
			if(terminal_level_form.terminal_digit_count.value > 7)
			{
				alert(getMessage("INV_RANGE","MP"));
				terminal_level_form.terminal_digit_count.focus();
				return false;

			}
			if(terminal_level_form.group_count.value<1||	terminal_level_form.group_count.value>3)
			{			
				alert(getMessage("INV_RANGE","MP"));
				document.getElementById("div14").style.visibility = 'hidden';
				terminal_level_form.group_count.focus();
				terminal_level_form.group_count.select();
				if (terminal_level_form.terminal_digit1_position.style.visibility=="visible")
					terminal_level_form.terminal_digit1_position.value = "";
				if (terminal_level_form.terminal_digit2_position.style.visibility=="visible")
					terminal_level_form.terminal_digit2_position.value = "";				
				if (terminal_level_form.terminal_digit3_position.style.visibility=="visible")
					terminal_level_form.terminal_digit3_position.value = "";
				if (terminal_level_form.terminal_digit4_position.style.visibility=="visible")
					terminal_level_form.terminal_digit4_position.value = "";
				if (terminal_level_form.terminal_digit5_position.style.visibility=="visible")
					terminal_level_form.terminal_digit5_position.value = "";
				if (terminal_level_form.terminal_digit6_position.style.visibility=="visible")
					terminal_level_form.terminal_digit6_position.value = "";
				if (terminal_level_form.terminal_digit7_position.style.visibility=="visible")
					terminal_level_form.terminal_digit7_position.value = "";
				terminal_level_form.terminal_digit1_position.style.visibility="hidden";
				terminal_level_form.terminal_digit2_position.style.visibility="hidden";
				terminal_level_form.terminal_digit3_position.style.visibility="hidden";
				terminal_level_form.terminal_digit4_position.style.visibility="hidden";
				terminal_level_form.terminal_digit5_position.style.visibility="hidden";
				terminal_level_form.terminal_digit6_position.style.visibility="hidden";
				terminal_level_form.terminal_digit7_position.style.visibility="hidden";
				terminal_level_form.img7.style.visibility="hidden";
				terminal_level_form.img6.style.visibility="hidden";
				terminal_level_form.img5.style.visibility="hidden";
				terminal_level_form.img4.style.visibility="hidden";
				terminal_level_form.img3.style.visibility="hidden";
				terminal_level_form.img2.style.visibility="hidden";
				terminal_level_form.img1.style.visibility="hidden";
			}
			
			else {
			    var count1 = terminal_level_form.group_count.value;
				
					
				var count2 = terminal_level_form.terminal_digit_count.value;
				
				if (count1!=0) 
					{				
						document.getElementById("div2").style.visibility = 'visible';					
						document.getElementById("div10").style.visibility = 'visible';
						document.getElementById("div14").style.visibility = 'visible';
					}
				if (count1==1)
					{
					document.getElementById("div11").style.visibility = 'visible';
				
					terminal_level_form.st8.checked=false;
					terminal_level_form.tt8.checked=false;
					terminal_level_form.pt8.style.visibility="visible";
					terminal_level_form.st8.style.visibility="hidden";
					terminal_level_form.tt8.style.visibility="hidden";
					document.getElementById("div12").style.visibility="hidden";	
					document.getElementById("div13").style.visibility="hidden";	
					if (count2==1)
						{						
						document.getElementById("div3").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";					
						document.getElementById("div4").style.visibility = 'hidden';
						document.getElementById("div5").style.visibility = 'hidden';
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';						
						terminal_level_form.pt2.style.visibility="hidden";
						terminal_level_form.pt2.value="";
						terminal_level_form.pt3.style.visibility="hidden";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";
						terminal_level_form.pt7.value="";
						terminal_level_form.st1.style.visibility="hidden";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==2)
						{		
								document.getElementById("div3").style.visibility = 'visible';
								document.getElementById("div4").style.visibility = 'visible';
								terminal_level_form.pt1.style.visibility="visible";
								terminal_level_form.pt2.style.visibility="visible";						
								document.getElementById("div5").style.visibility = 'hidden';
								document.getElementById("div6").style.visibility = 'hidden';
								document.getElementById("div7").style.visibility = 'hidden';
								document.getElementById("div8").style.visibility = 'hidden';
								document.getElementById("div9").style.visibility = 'hidden';						
								terminal_level_form.pt3.style.visibility="hidden";
								terminal_level_form.pt3.value="";
								terminal_level_form.pt4.style.visibility="hidden";
								terminal_level_form.pt4.value="";
								terminal_level_form.pt5.style.visibility="hidden";
								terminal_level_form.pt5.value="";
								terminal_level_form.pt6.style.visibility="hidden";
								terminal_level_form.pt6.value="";
								terminal_level_form.pt7.style.visibility="hidden";
								terminal_level_form.pt7.value="";
								terminal_level_form.st1.style.visibility="hidden";
								terminal_level_form.st1.value="";
								terminal_level_form.st2.style.visibility="hidden";
								terminal_level_form.st2.value="";
								terminal_level_form.st3.style.visibility="hidden";
								terminal_level_form.st3.value="";
								terminal_level_form.st4.style.visibility="hidden";
								terminal_level_form.st4.value="";
								terminal_level_form.st5.style.visibility="hidden";
								terminal_level_form.st5.value="";
								terminal_level_form.st6.style.visibility="hidden";
								terminal_level_form.st6.value="";
								terminal_level_form.st7.style.visibility="hidden";
								terminal_level_form.st7.value="";
								terminal_level_form.tt1.style.visibility="hidden";
								terminal_level_form.tt1.value="";
								terminal_level_form.tt2.style.visibility="hidden";
								terminal_level_form.tt2.value="";
								terminal_level_form.tt3.style.visibility="hidden";				
								terminal_level_form.tt3.value="";
								terminal_level_form.tt4.style.visibility="hidden";
								terminal_level_form.tt4.value="";
								terminal_level_form.tt5.style.visibility="hidden";
								terminal_level_form.tt5.value="";
								terminal_level_form.tt6.style.visibility="hidden";
								terminal_level_form.tt6.value="";
								terminal_level_form.tt7.style.visibility="hidden";
								terminal_level_form.tt7.value="";
						}
					else if (count2==3)
						{
							document.getElementById("div3").style.visibility = 'visible';
							document.getElementById("div4").style.visibility = 'visible';
							document.getElementById("div5").style.visibility = 'visible';
							terminal_level_form.pt1.style.visibility="visible";
							terminal_level_form.pt2.style.visibility="visible";
							terminal_level_form.pt3.style.visibility="visible";												
							document.getElementById("div6").style.visibility = 'hidden';
							document.getElementById("div7").style.visibility = 'hidden';
							document.getElementById("div8").style.visibility = 'hidden';
							document.getElementById("div9").style.visibility = 'hidden';
							terminal_level_form.pt4.style.visibility="hidden";
							terminal_level_form.pt4.value="";
							terminal_level_form.pt5.style.visibility="hidden";
							terminal_level_form.pt5.value="";
							terminal_level_form.pt6.style.visibility="hidden";
							terminal_level_form.pt6.value="";
							terminal_level_form.pt7.style.visibility="hidden";
							terminal_level_form.pt7.value="";
							terminal_level_form.st1.style.visibility="hidden";
							terminal_level_form.st1.value="";
							terminal_level_form.st2.style.visibility="hidden";
							terminal_level_form.st2.value="";
							terminal_level_form.st3.style.visibility="hidden";
							terminal_level_form.st3.value="";
							terminal_level_form.st4.style.visibility="hidden";
							terminal_level_form.st4.value="";
							terminal_level_form.st5.style.visibility="hidden";
							terminal_level_form.st5.value="";
							terminal_level_form.st6.style.visibility="hidden";
							terminal_level_form.st6.value="";
							terminal_level_form.st7.style.visibility="hidden";
							terminal_level_form.st7.value="";
							terminal_level_form.tt1.style.visibility="hidden";
							terminal_level_form.tt1.value="";
							terminal_level_form.tt2.style.visibility="hidden";
							terminal_level_form.tt2.value="";
							terminal_level_form.tt3.style.visibility="hidden";				
							terminal_level_form.tt3.value="";
							terminal_level_form.tt4.style.visibility="hidden";
							terminal_level_form.tt4.value="";
							terminal_level_form.tt5.style.visibility="hidden";
							terminal_level_form.tt5.value="";
							terminal_level_form.tt6.style.visibility="hidden";
							terminal_level_form.tt6.value="";
							terminal_level_form.tt7.style.visibility="hidden";
							terminal_level_form.tt7.value="";
							}
					else if (count2==4)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';					
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";
						terminal_level_form.pt7.value="";
						terminal_level_form.st1.style.visibility="hidden";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";}
					else if (count2==5)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";												
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';		
					    terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";
						terminal_level_form.pt7.value="";
						terminal_level_form.st1.style.visibility="hidden";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";	}
					else if (count2==6)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						document.getElementById("div8").style.visibility = 'visible';					
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";
						terminal_level_form.pt6.style.visibility="visible";
						document.getElementById("div9").style.visibility = 'hidden';			
						terminal_level_form.pt7.style.visibility="hidden";
						terminal_level_form.pt7.value="";
						terminal_level_form.st1.style.visibility="hidden";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";	}
					else if (count2==7)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						document.getElementById("div8").style.visibility = 'visible';
						document.getElementById("div9").style.visibility = 'visible';					
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";
						terminal_level_form.pt6.style.visibility="visible";
						terminal_level_form.pt7.style.visibility="visible";	
						
						terminal_level_form.st1.style.visibility="hidden";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";	


						}
					}
				else if (count1==2)
					{
						document.getElementById("div11").style.visibility = 'visible';
						document.getElementById("div12").style.visibility = 'visible';
						terminal_level_form.pt8.style.visibility="visible";
						terminal_level_form.st8.style.visibility="visible";				
						terminal_level_form.pt8.checked=false;
						terminal_level_form.st8.checked=false;	
						terminal_level_form.tt8.checked=false;
						terminal_level_form.tt8.style.visibility="hidden";
						document.getElementById("div13").style.visibility="hidden";	
					if (count2==1)
						{
						document.getElementById("div3").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						document.getElementById("div4").style.visibility = 'hidden';
						document.getElementById("div5").style.visibility = 'hidden';
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';						
						terminal_level_form.pt2.style.visibility="hidden";
                        terminal_level_form.pt2.value="";
						terminal_level_form.pt3.style.visibility="hidden";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==2)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";						
						document.getElementById("div5").style.visibility = 'hidden';
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';						
						terminal_level_form.pt3.style.visibility="hidden";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==3)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";					
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';								
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==4)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.st4.style.visibility="visible";						
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';		
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==5)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.st4.style.visibility="visible";
						terminal_level_form.st5.style.visibility="visible";				
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";}
					else if (count2==6)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						document.getElementById("div8").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";
						terminal_level_form.pt6.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.st4.style.visibility="visible";
						terminal_level_form.st5.style.visibility="visible";
						terminal_level_form.st6.style.visibility="visible";						
						document.getElementById("div9").style.visibility = 'hidden';
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st7.style.visibility="hidden";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";}
					else if (count2==7)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						document.getElementById("div8").style.visibility = 'visible';
						document.getElementById("div9").style.visibility = 'visible';
						
						terminal_level_form.pt1.value="";
						terminal_level_form.pt2.value="";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.value="";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.value="";
						
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";
						terminal_level_form.pt6.style.visibility="visible";
						terminal_level_form.pt7.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.st4.style.visibility="visible";
						terminal_level_form.st5.style.visibility="visible";
						terminal_level_form.st6.style.visibility="visible";
						terminal_level_form.st7.style.visibility="visible";						
						terminal_level_form.tt1.style.visibility="hidden";
						terminal_level_form.tt2.style.visibility="hidden";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt7.style.visibility="hidden";
						}
					}
				else if (count1==3)
					{
						document.getElementById("div11").style.visibility = 'visible';
						document.getElementById("div12").style.visibility = 'visible';
						document.getElementById("div13").style.visibility = 'visible';
						terminal_level_form.pt8.style.visibility="visible";
						terminal_level_form.st8.style.visibility="visible";
						terminal_level_form.tt8.style.visibility="visible";
					   	terminal_level_form.pt8.checked=false
						terminal_level_form.st8.checked=false;
						terminal_level_form.tt8.checked=false;
					
					if (count2==1)
						{
                          
						document.getElementById("div3").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";				
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.tt1.style.visibility="visible";
						document.getElementById("div4").style.visibility = 'hidden';
						document.getElementById("div5").style.visibility = 'hidden';
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';						
						terminal_level_form.pt2.style.visibility="hidden";
						terminal_level_form.pt2.value="";
						terminal_level_form.pt3.style.visibility="hidden";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st2.style.visibility="hidden";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";						
						terminal_level_form.st7.value="";
						terminal_level_form.pt2.style.visibility="hidden";
						terminal_level_form.pt2.value="";
						terminal_level_form.tt2.style.visibility="hidden";				
						terminal_level_form.tt2.value="";
						
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==2)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";				
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.tt1.style.visibility="visible";
						terminal_level_form.tt2.style.visibility="visible";
						document.getElementById("div5").style.visibility = 'hidden';
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';
						terminal_level_form.pt3.style.visibility="hidden";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st3.style.visibility="hidden";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";						
						terminal_level_form.st7.value="";
						terminal_level_form.tt3.style.visibility="hidden";				
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==3)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";				
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.tt1.style.visibility="visible";
						terminal_level_form.tt2.style.visibility="visible";
						terminal_level_form.tt3.style.visibility="visible";
						document.getElementById("div6").style.visibility = 'hidden';
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';
						terminal_level_form.pt4.style.visibility="hidden";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st4.style.visibility="hidden";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";						
						terminal_level_form.st7.value="";
						terminal_level_form.tt4.style.visibility="hidden";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==4)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.st4.style.visibility="visible";
						terminal_level_form.tt1.style.visibility="visible";
						terminal_level_form.tt2.style.visibility="visible";
						terminal_level_form.tt3.style.visibility="visible";				
						terminal_level_form.tt4.style.visibility="visible";				
						document.getElementById("div7").style.visibility = 'hidden';
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';
						

 
 	                    terminal_level_form.pt5.style.visibility="hidden";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st5.style.visibility="hidden";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";						
						terminal_level_form.st7.value="";
						terminal_level_form.tt5.style.visibility="hidden";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==5)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";				
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.st4.style.visibility="visible";
						terminal_level_form.st5.style.visibility="visible";
						terminal_level_form.tt1.style.visibility="visible";
						terminal_level_form.tt2.style.visibility="visible";
						terminal_level_form.tt3.style.visibility="visible";				
						terminal_level_form.tt4.style.visibility="visible";
						terminal_level_form.tt5.style.visibility="visible";
						document.getElementById("div8").style.visibility = 'hidden';
						document.getElementById("div9").style.visibility = 'hidden';					
						terminal_level_form.pt6.style.visibility="hidden";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st6.style.visibility="hidden";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.style.visibility="hidden";						
						terminal_level_form.st7.value="";
						terminal_level_form.tt6.style.visibility="hidden";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
						}
					else if (count2==6)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						document.getElementById("div8").style.visibility = 'visible';
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";
						terminal_level_form.pt6.style.visibility="visible";				
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.st4.style.visibility="visible";
						terminal_level_form.st5.style.visibility="visible";
						terminal_level_form.st6.style.visibility="visible";
						terminal_level_form.tt1.style.visibility="visible";
						terminal_level_form.tt2.style.visibility="visible";
						terminal_level_form.tt3.style.visibility="visible";				
						terminal_level_form.tt4.style.visibility="visible";
						terminal_level_form.tt5.style.visibility="visible";
						terminal_level_form.tt6.style.visibility="visible";
						document.getElementById("div9").style.visibility = 'hidden';
						terminal_level_form.pt7.style.visibility="hidden";						
						terminal_level_form.pt7.value="";
						terminal_level_form.st7.style.visibility="hidden";						
						terminal_level_form.st7.value="";
						terminal_level_form.tt7.style.visibility="hidden";
						terminal_level_form.tt7.value="";
											
						}
					else if (count2==7)
						{
						document.getElementById("div3").style.visibility = 'visible';
						document.getElementById("div4").style.visibility = 'visible';
						document.getElementById("div5").style.visibility = 'visible';
						document.getElementById("div6").style.visibility = 'visible';
						document.getElementById("div7").style.visibility = 'visible';
						document.getElementById("div8").style.visibility = 'visible';
						document.getElementById("div9").style.visibility = 'visible';
						terminal_level_form.pt1.value="";
						terminal_level_form.pt2.value="";
						terminal_level_form.pt3.value="";
						terminal_level_form.pt4.value="";
						terminal_level_form.pt5.value="";
						terminal_level_form.pt6.value="";
						terminal_level_form.pt7.value="";
						terminal_level_form.st1.value="";
						terminal_level_form.st2.value="";
						terminal_level_form.st3.value="";
						terminal_level_form.st4.value="";
						terminal_level_form.st5.value="";
						terminal_level_form.st6.value="";
						terminal_level_form.st7.value="";
						terminal_level_form.tt1.value="";
						terminal_level_form.tt2.value="";
						terminal_level_form.tt3.value="";
						terminal_level_form.tt4.value="";
						terminal_level_form.tt5.value="";
						terminal_level_form.tt6.value="";
						terminal_level_form.tt7.value="";
						
						
						terminal_level_form.pt1.style.visibility="visible";
						terminal_level_form.pt2.style.visibility="visible";
						terminal_level_form.pt3.style.visibility="visible";
						terminal_level_form.pt4.style.visibility="visible";
						terminal_level_form.pt5.style.visibility="visible";
						terminal_level_form.pt6.style.visibility="visible";
						terminal_level_form.pt7.style.visibility="visible";
						terminal_level_form.st1.style.visibility="visible";
						terminal_level_form.st2.style.visibility="visible";
						terminal_level_form.st3.style.visibility="visible";
						terminal_level_form.st4.style.visibility="visible";
						terminal_level_form.st5.style.visibility="visible";
						terminal_level_form.st6.style.visibility="visible";
						terminal_level_form.st7.style.visibility="visible";
						terminal_level_form.tt1.style.visibility="visible";
						terminal_level_form.tt2.style.visibility="visible";
						terminal_level_form.tt3.style.visibility="visible";				
						terminal_level_form.tt4.style.visibility="visible";
						terminal_level_form.tt5.style.visibility="visible";
						terminal_level_form.tt6.style.visibility="visible";
						terminal_level_form.tt7.style.visibility="visible";
						}
					}
			}
		}
		else if((terminal_level_form.terminal_digit_count.value!=0 &&  terminal_level_form.group_count.value==0)||(terminal_level_form.terminal_digit_count.value=="" &&  terminal_level_form.group_count.value==""))
		{
				terminal_level_form.terminal_digit1_position.style.visibility="hidden";
				terminal_level_form.terminal_digit2_position.style.visibility="hidden";
				terminal_level_form.terminal_digit3_position.style.visibility="hidden";
				terminal_level_form.terminal_digit4_position.style.visibility="hidden";
				terminal_level_form.terminal_digit5_position.style.visibility="hidden";
				terminal_level_form.terminal_digit6_position.style.visibility="hidden";
				terminal_level_form.terminal_digit7_position.style.visibility="hidden";				
				terminal_level_form.img7.style.visibility="hidden";
				terminal_level_form.img6.style.visibility="hidden";
				terminal_level_form.img5.style.visibility="hidden";
				terminal_level_form.img4.style.visibility="hidden";
				terminal_level_form.img3.style.visibility="hidden";
				terminal_level_form.img2.style.visibility="hidden";
				terminal_level_form.img1.style.visibility="hidden";
				document.getElementById("div14").style.visibility = 'hidden';
				document.getElementById("div2").style.visibility = 'hidden';
				document.getElementById("div3").style.visibility = 'hidden';
				document.getElementById("div4").style.visibility = 'hidden';
				document.getElementById("div5").style.visibility = 'hidden';
				document.getElementById("div6").style.visibility = 'hidden';
				document.getElementById("div7").style.visibility = 'hidden';
				document.getElementById("div8").style.visibility = 'hidden';
				document.getElementById("div9").style.visibility = 'hidden';
				document.getElementById("div10").style.visibility = 'hidden';
				document.getElementById("div11").style.visibility = 'hidden';
				document.getElementById("div12").style.visibility = 'hidden';
				document.getElementById("div13").style.visibility = 'hidden';						
				terminal_level_form.pt1.style.visibility="hidden";
				terminal_level_form.pt2.style.visibility="hidden";
				terminal_level_form.pt3.style.visibility="hidden";
				terminal_level_form.pt4.style.visibility="hidden";
				terminal_level_form.pt5.style.visibility="hidden";
				terminal_level_form.pt6.style.visibility="hidden";
				terminal_level_form.pt7.style.visibility="hidden";
				terminal_level_form.pt8.style.visibility="hidden";
				terminal_level_form.st1.style.visibility="hidden";
				terminal_level_form.st2.style.visibility="hidden";
				terminal_level_form.st3.style.visibility="hidden";
				terminal_level_form.st4.style.visibility="hidden";
				terminal_level_form.st5.style.visibility="hidden";
				terminal_level_form.st6.style.visibility="hidden";
				terminal_level_form.st7.style.visibility="hidden";
				terminal_level_form.st8.style.visibility="hidden";
				terminal_level_form.tt1.style.visibility="hidden";
				terminal_level_form.tt2.style.visibility="hidden";
				terminal_level_form.tt3.style.visibility="hidden";				
				terminal_level_form.tt4.style.visibility="hidden";
				terminal_level_form.tt5.style.visibility="hidden";
				terminal_level_form.tt6.style.visibility="hidden";
				terminal_level_form.tt7.style.visibility="hidden";
				terminal_level_form.tt8.style.visibility="hidden";
		        terminal_level_form.pt8.ckecked=false
				terminal_level_form.st8.checked=false
		        terminal_level_form.tt8.checked=false
				}

		if (terminal_level_form.group_count.value!=0)
		{
				terminal_level_form.terminal_digit1_position.style.visibility="hidden";
				terminal_level_form.terminal_digit2_position.style.visibility="hidden";
				terminal_level_form.terminal_digit3_position.style.visibility="hidden";
				terminal_level_form.terminal_digit4_position.style.visibility="hidden";
				terminal_level_form.terminal_digit5_position.style.visibility="hidden";
				terminal_level_form.terminal_digit6_position.style.visibility="hidden";
				terminal_level_form.terminal_digit7_position.style.visibility="hidden";
				terminal_level_form.img7.style.visibility="hidden";
				terminal_level_form.img6.style.visibility="hidden";
				terminal_level_form.img5.style.visibility="hidden";
				terminal_level_form.img4.style.visibility="hidden";
				terminal_level_form.img3.style.visibility="hidden";
				terminal_level_form.img2.style.visibility="hidden";
				terminal_level_form.img1.style.visibility="hidden";
		}	
	}
	else
	{	
		if((terminal_level_form.group_count.value=="")||(terminal_level_form.group_count.value==0)||((terminal_level_form.group_count.value=="")&&(terminal_level_form.terminal_digit_count.value=="")))
		{		
		if(terminal_level_form.terminal_digit1_position.style.visibility=="visible")
				terminal_level_form.terminal_digit1_position.style.visibility="visible";
		else terminal_level_form.terminal_digit1_position.style.visibility="hidden";
		if(terminal_level_form.terminal_digit2_position.style.visibility=="visible")
				terminal_level_form.terminal_digit2_position.style.visibility="visible";
		else terminal_level_form.terminal_digit2_position.style.visibility="hidden";
		if(terminal_level_form.terminal_digit3_position.style.visibility=="visible")
				terminal_level_form.terminal_digit3_position.style.visibility="visible";
		else terminal_level_form.terminal_digit3_position.style.visibility="hidden";
		if(terminal_level_form.terminal_digit4_position.style.visibility=="visible")
				terminal_level_form.terminal_digit4_position.style.visibility="visible";
		else terminal_level_form.terminal_digit4_position.style.visibility="hidden";
		if(terminal_level_form.terminal_digit5_position.style.visibility=="visible")
				terminal_level_form.terminal_digit5_position.style.visibility="visible";
		else terminal_level_form.terminal_digit5_position.style.visibility="hidden";
		if(terminal_level_form.terminal_digit6_position.style.visibility=="visible")
				terminal_level_form.terminal_digit6_position.style.visibility="visible";
		else terminal_level_form.terminal_digit6_position.style.visibility="hidden";
		if(terminal_level_form.terminal_digit7_position.style.visibility=="visible")
				terminal_level_form.terminal_digit7_position.style.visibility="visible";
		else terminal_level_form.terminal_digit7_position.style.visibility="hidden";					
						
				if(terminal_level_form.img7.style.visibility=="visible")
					terminal_level_form.img7.style.visibility="visible";	
				else terminal_level_form.img7.style.visibility="hidden";

				if(terminal_level_form.img6.style.visibility=="visible")
					terminal_level_form.img6.style.visibility="visible";	
				else terminal_level_form.img6.style.visibility="hidden";

				if(terminal_level_form.img5.style.visibility=="visible")
					terminal_level_form.img5.style.visibility="visible";	
				else terminal_level_form.img5.style.visibility="hidden";

				if(terminal_level_form.img4.style.visibility=="visible")
					terminal_level_form.img4.style.visibility="visible";	
				else terminal_level_form.img4.style.visibility="hidden";

				if(terminal_level_form.img3.style.visibility=="visible")
					terminal_level_form.img3.style.visibility="visible";	
				else terminal_level_form.img3.style.visibility="hidden";

				if(terminal_level_form.img2.style.visibility=="visible")
					terminal_level_form.img2.style.visibility="visible";	
				else terminal_level_form.img2.style.visibility="hidden";

				if(terminal_level_form.img1.style.visibility=="visible")
					terminal_level_form.img1.style.visibility="visible";	
				else terminal_level_form.img1.style.visibility="hidden";

				if(terminal_level_form.terminal_digit1_position.style.visibility=="visible")
				document.getElementById("div14").style.visibility = 'visible';
				else
				document.getElementById("div14").style.visibility = 'hidden';


				document.getElementById("div2").style.visibility = 'hidden';
				document.getElementById("div3").style.visibility = 'hidden';
				document.getElementById("div4").style.visibility = 'hidden';
				document.getElementById("div5").style.visibility = 'hidden';
				document.getElementById("div6").style.visibility = 'hidden';
				document.getElementById("div7").style.visibility = 'hidden';
				document.getElementById("div8").style.visibility = 'hidden';
				document.getElementById("div9").style.visibility = 'hidden';
				document.getElementById("div10").style.visibility = 'hidden';
				document.getElementById("div11").style.visibility = 'hidden';
				document.getElementById("div12").style.visibility = 'hidden';
				document.getElementById("div13").style.visibility = 'hidden';						
				terminal_level_form.pt1.style.visibility="hidden";
				terminal_level_form.pt2.style.visibility="hidden";
				terminal_level_form.pt3.style.visibility="hidden";
				terminal_level_form.pt4.style.visibility="hidden";
				terminal_level_form.pt5.style.visibility="hidden";
				terminal_level_form.pt6.style.visibility="hidden";
				terminal_level_form.pt7.style.visibility="hidden";
				terminal_level_form.pt8.style.visibility="hidden";
				terminal_level_form.st1.style.visibility="hidden";
				terminal_level_form.st2.style.visibility="hidden";
				terminal_level_form.st3.style.visibility="hidden";
				terminal_level_form.st4.style.visibility="hidden";
				terminal_level_form.st5.style.visibility="hidden";
				terminal_level_form.st6.style.visibility="hidden";
				terminal_level_form.st7.style.visibility="hidden";
				terminal_level_form.st8.style.visibility="hidden";
				terminal_level_form.tt1.style.visibility="hidden";
				terminal_level_form.tt2.style.visibility="hidden";
				terminal_level_form.tt3.style.visibility="hidden";				
				terminal_level_form.tt4.style.visibility="hidden";
				terminal_level_form.tt5.style.visibility="hidden";
				terminal_level_form.tt6.style.visibility="hidden";
				terminal_level_form.tt7.style.visibility="hidden";
				terminal_level_form.tt8.style.visibility="hidden";
				terminal_level_form.group_count.value="";
		}
		if((terminal_level_form.group_count.value=="")&&(terminal_level_form.terminal_digit_count.value==""))
		{					
		terminal_level_form.terminal_digit1_position.style.visibility="hidden";
		terminal_level_form.terminal_digit2_position.style.visibility="hidden";
		terminal_level_form.terminal_digit3_position.style.visibility="hidden";
		terminal_level_form.terminal_digit4_position.style.visibility="hidden";
		terminal_level_form.terminal_digit5_position.style.visibility="hidden";
		terminal_level_form.terminal_digit6_position.style.visibility="hidden";
		terminal_level_form.terminal_digit7_position.style.visibility="hidden";									
		terminal_level_form.img7.style.visibility="hidden";
		terminal_level_form.img6.style.visibility="hidden";
		terminal_level_form.img5.style.visibility="hidden";
		terminal_level_form.img4.style.visibility="hidden";
		terminal_level_form.img3.style.visibility="hidden";
		terminal_level_form.img2.style.visibility="hidden";
		terminal_level_form.img1.style.visibility="hidden";
		document.getElementById("div14").style.visibility = 'hidden';
		}
	}

}

