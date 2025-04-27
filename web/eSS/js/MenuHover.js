/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
		var previous=null;
		var clicked =new Array(30);
		var previousIndex=0
		for(i=0;i<30;i++)
			clicked[i]=false;
		function mouseClickChangeMenuColor(tblrow,index)
		{
			if(previous!=null)
				previous.cells(0).className='MENUSUBLEVELCOLOR';
			tblrow.cells(0).className='MENUSELECTEDCOLOR';
			previous=tblrow;
			clicked[previousIndex]=false
			clicked[index]=true;
			previousIndex=index;
		}
		function swapPictureOnClick(obj,divTag)
		{
			var innerText=obj.innerText;
			if (innerText=="+") 
				obj.innerText="-"
			else
				obj.innerText="+";

			if(divTag.style.display=="inline")
				divTag.style.display="none";
			else
				divTag.style.display="inline";
		}
