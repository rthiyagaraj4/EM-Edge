function currencyFormat(obj)
{
	var currency = 2;

	var val = new Number(obj.value);
	var num = val;

	if(isNaN(num))
		num = "0";

	sign = (num == (num = Math.abs(num)));

	num = Math.floor(num*100+0.50000000001);
	
	decpor = num%100;

	num = Math.floor(num/100).toString();

	if(decpor<10)
	decpor = "0" + decpor;
	val = ((sign)?'':'-') +  num + '.' + decpor;

	obj.value = val;
}
function currencyTableFormat(obj)
{
	var currency = 2;

	var val = new Number(obj.innerText);
	var num = val;

	if(isNaN(num))
		num = "0";

	sign = (num == (num = Math.abs(num)));

	num = Math.floor(num*100+0.50000000001);
	
	decpor = num%100;

	num = Math.floor(num/100).toString();

	if(decpor<10)
	decpor = "0" + decpor;
	val = ((sign)?'':'-') +  num + '.' + decpor;

	obj.innerText = val;
}

function checkNumber(obj)
{
	if (isNaN(obj.value))
	{
		obj.focus();
		return false;
	}
	return(true);
}


