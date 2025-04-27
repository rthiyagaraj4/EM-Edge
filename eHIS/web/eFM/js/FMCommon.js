function CheckSpecialChar(obj)
{
	var fieldval = obj.value;
	var fieldlen = fieldval.length;
	var to_check = true;
	var SpChar = new Array();

	SpChar[0] = '~';
	SpChar[1] = '`';
	SpChar[2] = '!';
	SpChar[3] = '@';
	SpChar[4] = '#';
	SpChar[5] = '$';
	SpChar[6] = '%';
	SpChar[7] = '^';
	SpChar[8] = '&';
	SpChar[9] = '*';
	SpChar[10] = '(';
	SpChar[11] = ')';
	SpChar[12] = '-';
	SpChar[13] = '+';
	SpChar[14] = '=';
	SpChar[15] = '|';
	SpChar[16] = '\\';
	SpChar[17] = '[';
	SpChar[18] = ']';
	SpChar[19] = '{';
	SpChar[20] = '}';
	SpChar[21] = ':';
	SpChar[22] = ';';
	SpChar[23] = '"';
	SpChar[24] = '<';
	SpChar[25] = '>';
	SpChar[26] = '?';
	SpChar[27] = '/';
	SpChar[28] = '\'';
	SpChar[29] = '';
	SpChar[30] = ',';
	SpChar[31] = '.';

	if (fieldval.substr(0,1) == '_' ) 
	{
		to_check = false;
	}

	for (var i=0;i<fieldlen;i++)
	{

		if (fieldval.substr(i,1) == ' ' || fieldval.substr(i,1) == null)
		{
			to_check = false;
		}

		for (var j=0;j<=31;j++)
		{
			if (fieldval.substr(i,1) == SpChar[j])
			{
				to_check = false;
			}
		}
	}

	if (to_check == false)
	{
		alert(getMessage('SPECIAL_CHARACTERS_NOT_ALLOWED','FM'));
		obj.select();
		obj.focus();
		//obj.value='';
	}
}
