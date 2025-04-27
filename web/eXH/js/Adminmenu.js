//********************************************************************************************
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();
//********************************************************************************************
// function goHomePage
//********************************************************************************************
		function goHomePage(){
				
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
			
		}
//********************************************************************************************
// function chcol
//********************************************************************************************
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;

		}
//********************************************************************************************
// function callJSPs
//********************************************************************************************

		function callJSPs(val)
		{

				parent.frames[1].location.href = val;

		}
//********************************************************************************************
