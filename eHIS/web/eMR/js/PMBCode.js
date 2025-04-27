/*Created by Thamizh selvi on 04/10/2016*/
function query() 
{
	queryFrame.location.href="../../eMR/jsp/PMBCodeQueryCriteria.jsp";
}

function reset()
{
	var url=queryFrame.location.href;
	if(url.indexOf("blank")==-1) 
		queryFrame.location.reload();

}

function fnSetvalue(type){
	if(type=="P"){
		document.forms[0].isPrevClicked.value="Y";
	}else if(type=="N"){
		document.forms[0].isNextClicked.value="Y";
	}
}
