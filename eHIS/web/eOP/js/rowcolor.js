	/*var prev=0;
	var i=0;
	function changeRowColor(obj,n)
	{
		for(i=0;i<n;i++)
			document.getElementById("tb1").rows(prev).cells(i).style.backgroundColor=obj.bgColor;
		for(i=0;i<n;i++)
			obj.cells(i).style.backgroundColor="#B2B6D7";
		prev	=obj.rowIndex;

	}*/

	prev=0;
	k=0;
	function changeRowColor(obj,n)
	
	{
			var i= obj.name;
			i=parseInt(i);

			for( k=0;k<n;k++)
					document.getElementById("tb1").rows[prev].cells[k].style.backgroundColor=obj.style.backgroundColor;

			for( k=0;k<n;k++)
					document.getElementById("tb1").rows[i].cells[k].style.backgroundColor="#B2B6D7" ;

			prev = i;
}
