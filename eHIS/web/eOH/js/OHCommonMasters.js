//, --> MTaskLink

function CharCheck(obj){ //to restrict # and ~ and " and ' and > and < and ,
	//if ((event.keyCode == 35) || (event.keyCode == 126) || (event.keyCode == 34) || (event.keyCode == 39) || (event.keyCode == 62)|| (event.keyCode == 92))
	if ((event.keyCode == 35) || (event.keyCode == 126) || (event.keyCode == 34) || (event.keyCode == 39) || (event.keyCode == 62) || (event.keyCode == 60) || (event.keyCode == 44))
	{
		event.keyCode=0;
	}
}