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
