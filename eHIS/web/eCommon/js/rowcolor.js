/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
prev=0;
k=0;
function changeRowColor(obj,n)
{
		var i= obj.name||obj.id;
		i=parseInt(i);

		for( k=0;k<n;k++)
				document.getElementById("tb1").rows[prev].cells[k].style.backgroundColor=obj.style.backgroundColor;

		/*for( k=0;k<n;k++){
			    console.log(document.getElementById("tb1").rows[i]);
			    document.getElementById("tb1").rows[i].cells[k].style.backgroundColor="#d3d3d3" ;*/
         
			    for (let k = 0; k < n; k++) {
			        if (i >= 0 && i < table.rows.length) { // Check if row index i is valid
			            let row = table.rows[i];
			            
			            if (k >= 0 && k < row.cells.length) { // Check if cell index k is valid
			                row.cells[k].style.backgroundColor = "#d3d3d3"; // Change background color
			            }
		prev = i;
		}
}
}