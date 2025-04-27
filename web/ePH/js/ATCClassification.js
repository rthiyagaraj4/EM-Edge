  //saved on 27/10/2005
var prevClassName	=	"";
var prevRowObject	=	"";
var result			=	"";
var invalidCode		=  "";
var flag			=	"";
var inMode			=	"";
var val_result		=	"";
var dup_vals	=	new Array();

async function callATC(called_from){
	var dialogHeight= "600px" ;
	var dialogWidth	= "900px" ;
	var dialogTop = "10" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	//alert(called_from);
	//if(called_from=="ATC") {
		retVal = await window.showModalDialog("../../ePH/jsp/ATCClassificationFrames.jsp?called_from=atc",arguments,features);
		parent.parent.parent.frames[1].expand();
	//} else {
	//	retVal = window.showModalDialog("../../ePH/jsp/PharmacologicalClassificationFrames.jsp?called_from=atc",arguments,features);
	//	parent.parent.parent.frames[1].expand();
	//}
}

function showNextLevel(level_no,level_code,level_desc,called_from) {
	if(level_no=='1')	{
		parent.frames[4].location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_INSERT+"&level_num=2&prev_lvl_code="+level_code+"&prev_lvl_desc="+level_desc+"&called_from="+called_from;
			parent.frames[5].location.href="../../eCommon/html/blank.html";
			parent.frames[9].location.href="../../eCommon/html/blank.html";
			parent.frames[10].location.href="../../eCommon/html/blank.html";
			parent.f_view_levels.f_level_descs.location.href="../../ePH/jsp/ATCViewLevel.jsp?level=1&code="+level_code+"&desc="+level_desc;
			//parent.f_view_levels.f_level_descs.document.getElementById("L1_code").value=level_code;

			if(called_from !='generic_atc')
			{
				parent.f_level3.document.getElementById("addlink").innerText='';
				parent.f_level3.document.getElementById("addlink").style.cursor='auto';
				parent.f_level3.document.getElementById("addlink").onclick='';
				parent.f_level4.document.getElementById("addlink").innerText='';
				parent.f_level4.document.getElementById("addlink").style.cursor='auto';
				parent.f_level4.document.getElementById("addlink").onclick='';
				parent.f_level5.document.getElementById("addlink").innerText='';
				parent.f_level5.document.getElementById("addlink").style.cursor='auto';
				parent.f_level5.document.getElementById("addlink").onclick='';
			}
			else	{
				parent.f_view_levels.f_close_levels.document.getElementById("select").disabled=false;
			}
		}

		if(level_no=='2')	{
			l1_code	= parent.f_view_levels.f_level_descs.document.getElementById("L1_code").value;
			l1_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L1_desc").value;

			parent.frames[5].location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_INSERT+"&level_num=3&prev_lvl_code="+level_code+"&prev_lvl_desc="+(level_desc)+"&called_from="+called_from;
			parent.frames[9].location.href="../../eCommon/html/blank.html";
			parent.frames[10].location.href="../../eCommon/html/blank.html";
			parent.f_view_levels.f_level_descs.location.href="../../ePH/jsp/ATCViewLevel.jsp?level=2&code_1="+l1_code+"&desc_1="+l1_desc+"&code="+level_code+"&desc="+level_desc;
			if(called_from !='generic_atc')
			{
				parent.f_level4.document.getElementById("addlink").innerText='';
				parent.f_level4.document.getElementById("addlink").style.cursor='auto';
				parent.f_level4.document.getElementById("addlink").onclick='';
				parent.f_level5.document.getElementById("addlink").innerText='';
				parent.f_level5.document.getElementById("addlink").style.cursor='auto';
				parent.f_level5.document.getElementById("addlink").onclick='';
			}
		}

		if(level_no=='3')	{
			l1_code	= parent.f_view_levels.f_level_descs.document.getElementById("L1_code").value;
			l2_code	= parent.f_view_levels.f_level_descs.document.getElementById("L2_code").value;
			l1_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L1_desc").value;
			l2_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L2_desc").value;

			parent.frames[9].location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_INSERT+"&level_num=4&prev_lvl_code="+level_code+"&prev_lvl_desc="+(level_desc)+"&called_from="+called_from;
			parent.frames[10].location.href="../../eCommon/html/blank.html";
			parent.f_view_levels.f_level_descs.location.href="../../ePH/jsp/ATCViewLevel.jsp?level=3&code_1="+l1_code+"&desc_1="+l1_desc+"&code_2="+l2_code+"&desc_2="+l2_desc+"&code="+level_code+"&desc="+level_desc;
			parent.f_view_levels.f_level_descs.document.getElementById("L3_code").value=level_code;
			if(called_from !='generic_atc')
			{
				parent.f_level5.document.getElementById("addlink").innerText='';
				parent.f_level5.document.getElementById("addlink").style.cursor='auto';
				parent.f_level5.document.getElementById("addlink").onclick='';
			}

		}

		if(level_no=='4')	{
			l1_code	= parent.f_view_levels.f_level_descs.document.getElementById("L1_code").value;
			l2_code	= parent.f_view_levels.f_level_descs.document.getElementById("L2_code").value;
			l3_code	= parent.f_view_levels.f_level_descs.document.getElementById("L3_code").value;
			l1_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L1_desc").value;
			l2_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L2_desc").value;
			l3_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L3_desc").value;

			parent.frames[10].location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_INSERT+"&level_num=5&prev_lvl_code="+level_code+"&prev_lvl_desc="+(level_desc)+"&called_from="+called_from;
			parent.f_view_levels.f_level_descs.location.href="../../ePH/jsp/ATCViewLevel.jsp?level=4&code_1="+l1_code+"&desc_1="+l1_desc+"&code_2="+l2_code+"&desc_2="+l2_desc+"&code_3="+l3_code+"&desc_3="+l3_desc+"&code="+level_code+"&desc="+level_desc;
			parent.f_view_levels.f_level_descs.document.getElementById("L4_code").value=level_code;
			}
		if(level_no=='5')	{
			l1_code	= parent.f_view_levels.f_level_descs.document.getElementById("L1_code").value;
			l2_code	= parent.f_view_levels.f_level_descs.document.getElementById("L2_code").value;
			l3_code	= parent.f_view_levels.f_level_descs.document.getElementById("L3_code").value;
			l4_code	= parent.f_view_levels.f_level_descs.document.getElementById("L4_code").value;

			l1_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L1_desc").value;
			l2_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L2_desc").value;
			l3_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L3_desc").value;
			l4_desc	= parent.f_view_levels.f_level_descs.document.getElementById("L4_desc").value;

			parent.f_view_levels.f_level_descs.location.href="../../ePH/jsp/ATCViewLevel.jsp?level=5&code_1="+l1_code+"&desc_1="+l1_desc+"&code_2="+l2_code+"&desc_2="+l2_desc+"&code_3="+l3_code+"&desc_3="+l3_desc+"&code_4="+l4_code+"&desc_4="+l4_desc+"&code="+level_code+"&desc="+level_desc;
			parent.f_view_levels.f_level_descs.document.getElementById("L5_code").value=level_code;
		}
		}

function changeRowColor(obj,getVal,changeClassName) {

if(document.getElementById("nochild")!=null)
{
	rowslen	=	document.getElementById("desc_detail").rows.length;

	for(i=0; i<rowslen; i++) {
			if(document.getElementById("desc_detail").rows[i].cells[0].style.color=='white')
			document.getElementById("desc_detail").rows[i].cells[0].style.color='red';
	}

	var rowno	=	parseInt(getVal)-1;
	rowobj	=	document.getElementById("desc_detail").rows[rowno];
	if(rowobj.cells[0].style.color=='red')
	rowobj.cells[0].style.color='white';
}

			changeClassName = "ATCROWCOL";
			if(	prevClassName != "" )
				for(i=0; i<prevRowObject.cells.length; i++)
					if(prevRowObject.cells[i].className==changeClassName)
						prevRowObject.cells[i].className = prevClassName;

			prevRowObject	=	obj;
			prevClassName	=	obj.cells[0].className;

			for(i=0; i<obj.cells.length; i++)
				if(obj.cells[i].className=="ATCQRYODD" || obj.cells[i].className == "ATCQRYEVEN")
				{
					obj.cells[i].className = changeClassName;
				}
}
function displayToolTip(level_num,code,desc,display_seq_no,count,called_from) {
			hideToolTip();

			var modify=getLabel("Common.Modify.label","Common");
			var modifyAll=getLabel("Common.Modify.label","Common")+" "+getLabel("Common.all.label","Common");

			buildTable(modify,modifyAll,level_num,code,desc,display_seq_no,count,called_from);

			bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight


			var x 	  = event.x;
			var y 	  = event.y;
	//		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth)
			y 	  = y + (document.getElementById("tooltiplayer").offsetHeight)

	//		if(x<bodwidth)
	//			x = event.x
	//		else
	//			x = x - (document.getElementById("tooltiplayer").offsetWidth*2)
			if(y<bodheight)
				y = event.y
			else
				y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

			y+=document.body.scrollTop
			x+=document.body.scrollLeft
//			document.getElementById("tooltiplayer").style.posLeft= x
			document.getElementById("tooltiplayer").style.posLeft= 20
			document.getElementById("tooltiplayer").style.posTop = y
			document.getElementById("tooltiplayer").style.visibility='visible';


}

function buildTable(modify,modifyAll,level_num,code,desc,display_seq_no,count,called_from){
	if(level_num =="1")
		class_name	=	getLabel("ePH.AnatomicalClass.label","PH");
	if(level_num =="2")
		class_name	=	getLabel("ePH.TherapeuticClass.label","PH")+"("+getLabel("ePH.MainClass.label","PH")+")";
	if(level_num =="3")
		class_name	=	getLabel("ePH.TherapeuticClass.label","PH")+"("+getLabel("Common.SubClass.label","Common")+")";
	if(level_num =="4")
		class_name	=	getLabel("ePH.ChemicalClass.label","PH")+"("+getLabel("ePH.MainClass.label","PH")+")";
	if(level_num =="5")
		class_name	=	getLabel("ePH.ChemicalClass.label","PH")+"("+getLabel("Common.SubClass.label","Common")+")";

			var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='1'   class='BOX' width='100%' height='100%' align='center' >"
			tab_dat     += "<tr onClick=\"javascript:showModify('"+level_num+"','"+code+"','"+desc+"','"+display_seq_no+"','"+count+"','"+called_from+"')\"><th align='left' nowrap class='TOOLTIP' title='"+getLabel("ePH.SingleRecordModification.label","PH")+"'>&nbsp;"+	getLabel("ePH.ModifySelectedItem.label","PH")+"&nbsp;</th></tr>";
			tab_dat     += "<tr onClick=\"javascript:showModifyAll('"+level_num+"','"+called_from+"')\"><th align='left' nowrap class='TOOLTIP' title='"+getLabel("ePH.MultipleRecordModification.label","PH")+"'>&nbsp;"+getLabel("ePH.ModifyAll.label","PH")+"&nbsp;-&nbsp;"+class_name+"&nbsp;</th></tr>";
			tab_dat     += "</table>";

			document.getElementById("t").innerHTML = tab_dat;
}

function hideToolTip() {
		if(parent.f_level1_detail.document.getElementById("tooltiplayer") != null)
		parent.f_level1_detail.document.getElementById("tooltiplayer").style.visibility='hidden';
		if(parent.f_level2_detail.document.getElementById("tooltiplayer") != null)
		parent.f_level2_detail.document.getElementById("tooltiplayer").style.visibility='hidden';
		if(parent.f_level3_detail.document.getElementById("tooltiplayer") != null)
		parent.f_level3_detail.document.getElementById("tooltiplayer").style.visibility='hidden';
		if(parent.f_level4_detail.document.getElementById("tooltiplayer") != null)
		parent.f_level4_detail.document.getElementById("tooltiplayer").style.visibility='hidden';
		if(parent.f_level5_detail.document.getElementById("tooltiplayer") != null)
		parent.f_level5_detail.document.getElementById("tooltiplayer").style.visibility='hidden';
}
async function showModify(level,code,desc,display_seq_no,count,called_from) {

			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var dialogTop = "10" ;
			var center = "1" ;
			var status="no";
			var scrolling="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling;
			var arguments	= "" ;
			retVal = await window.showModalDialog("../../ePH/jsp/ATCClassificationModifyFrames.jsp?level="+level+"&code="+code+"&desc="+desc+"&display_seqno="+display_seq_no+"&count="+count+"&mode="+MODE_MODIFY	,arguments,features);
if(retVal!="cancel")
{

	if(level=="1") 
	{	
	parent.f_level1_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=1&called_from="+called_from;
	parent.f_level2_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level3_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
		if(called_from !='generic_atc')
		{
			parent.f_level2.document.getElementById("addlink").innerText='';
			parent.f_level2.document.getElementById("addlink").style.cursor='pointer';
			parent.f_level2.document.getElementById("addlink").onclick='';
			parent.f_level3.document.getElementById("addlink").innerText='';
			parent.f_level3.document.getElementById("addlink").style.cursor='pointer';
			parent.f_level3.document.getElementById("addlink").onclick='';
			parent.f_level4.document.getElementById("addlink").innerText='';
			parent.f_level4.document.getElementById("addlink").style.cursor='pointer';
			parent.f_level4.document.getElementById("addlink").onclick='';
			parent.f_level5.document.getElementById("addlink").innerText='';
			parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
			parent.f_level5.document.getElementById("addlink").onclick='';
		}
	parent.f_view_levels.f_level_descs.document.getElementById("L1").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L2").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="2") 	{	parent.f_level2_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=2&called_from="+called_from;
	parent.f_level3_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
		if(called_from !='generic_atc')
		{
		parent.f_level3.document.getElementById("addlink").innerText='';
		parent.f_level3.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level3.document.getElementById("addlink").onclick='';
		parent.f_level4.document.getElementById("addlink").innerText='';
		parent.f_level4.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level4.document.getElementById("addlink").onclick='';
		parent.f_level5.document.getElementById("addlink").innerText='';
		parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level5.document.getElementById("addlink").onclick='';
		}
	parent.f_view_levels.f_level_descs.document.getElementById("L2").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="3") {	parent.f_level3_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=3&called_from="+called_from;
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
		if(called_from !='generic_atc')
		{
		parent.f_level4.document.getElementById("addlink").innerText='';
		parent.f_level4.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level4.document.getElementById("addlink").onclick='';
		parent.f_level5.document.getElementById("addlink").innerText='';
		parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level5.document.getElementById("addlink").onclick='';
		}
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="4")	{ 	parent.f_level4_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=4&called_from="+called_from;
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
		if(called_from !='generic_atc')
		{
		parent.f_level5.document.getElementById("addlink").innerText='';
		parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level5.document.getElementById("addlink").onclick='';
		}
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="5")	{
	parent.f_level5_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=5&called_from="+called_from;
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
}
}

async function showModifyAll(level,called_from) {
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var dialogTop = "10" ;
			var center = "1" ;
			var status="no";
			var scrolling="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling;
			var arguments	= "" ;
			retVal = await window.showModalDialog("../../ePH/jsp/ATCClassificationModifyAllFrames.jsp?level="+level+"&mode="+MODE_MODIFY+"&firstTime=yes",arguments,features);


	if(retVal!="cancel")
	{

	if(level=="1") 	{	parent.f_level1_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=1&called_from="+called_from;
	parent.f_level2_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level3_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
		if(called_from !='generic_atc')
		{
			parent.f_level2.document.getElementById("addlink").innerText='';
			parent.f_level2.document.getElementById("addlink").style.cursor='pointer';
			parent.f_level2.document.getElementById("addlink").onclick='';
			parent.f_level3.document.getElementById("addlink").innerText='';
			parent.f_level3.document.getElementById("addlink").style.cursor='pointer';
			parent.f_level3.document.getElementById("addlink").onclick='';
			parent.f_level4.document.getElementById("addlink").innerText='';
			parent.f_level4.document.getElementById("addlink").style.cursor='pointer';
			parent.f_level4.document.getElementById("addlink").onclick='';
			parent.f_level5.document.getElementById("addlink").innerText='';
			parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
			parent.f_level5.document.getElementById("addlink").onclick='';
		}
	parent.f_view_levels.f_level_descs.document.getElementById("L1").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L2").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="2") 	{	parent.f_level2_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=2&called_from="+called_from;
	parent.f_level3_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
		if(called_from !='generic_atc')
		{
		parent.f_level3.document.getElementById("addlink").innerText='';
		parent.f_level3.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level3.document.getElementById("addlink").onclick='';
		parent.f_level4.document.getElementById("addlink").innerText='';
		parent.f_level4.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level4.document.getElementById("addlink").onclick='';
		parent.f_level5.document.getElementById("addlink").innerText='';
		parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level5.document.getElementById("addlink").onclick='';
		}
	parent.f_view_levels.f_level_descs.document.getElementById("L2").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="3") {	parent.f_level3_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=3&called_from="+called_from;
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
		if(called_from !='generic_atc')
		{
		parent.f_level4.document.getElementById("addlink").innerText='';
		parent.f_level4.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level4.document.getElementById("addlink").onclick='';
		parent.f_level5.document.getElementById("addlink").innerText='';
		parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level5.document.getElementById("addlink").onclick='';
		}
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="4")	{ 	parent.f_level4_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=4&called_from="+called_from;
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
		if(called_from !='generic_atc')
		{
		parent.f_level5.document.getElementById("addlink").innerText='';
		parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
		parent.f_level5.document.getElementById("addlink").onclick='';
		}
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="5")	{
	parent.f_level5_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=5&called_from="+called_from;
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
}
}

async function showATCInsert(level,called_from)
{
	var dialogHeight= "80vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop = "75" ;
	var center = "1" ;
	var status="no";
	var scrolling="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +";scroll:"+scrolling;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/ATCClassificationInsertFrames.jsp?mode="+MODE_INSERT+"&level="+level,arguments,features);

if( retVal!="cancel")
{
	if(level=="1") 	{	parent.f_level1_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=1&called_from="+called_from;
	parent.f_level2_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level3_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
	parent.f_view_levels.f_level_descs.document.getElementById("L1").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L2").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";

	}
	if(level=="2")	{	parent.f_level2_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=2&called_from="+called_from;
	parent.f_level3_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
	parent.f_view_levels.f_level_descs.document.getElementById("L2").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="3") {	parent.f_level3_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=3&called_from="+called_from;
	parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
	parent.f_view_levels.f_level_descs.document.getElementById("L3").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="4")	{	parent.f_level4_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=4&called_from="+called_from;
	parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
	parent.f_view_levels.f_level_descs.document.getElementById("L4").innerText="";
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
	if(level=="5")	{	parent.f_level5_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=5&called_from="+called_from;
	parent.f_view_levels.f_level_descs.document.getElementById("L5").innerText="";
	}
}

}

function showAddLink(level_no)
{
	if(level_no=='2')  {
	parent.f_level2.document.getElementById("addlink").innerText=getLabel("Common.Add.label","Common");
	parent.f_level2.document.getElementById("addlink").style.cursor='hand';
	parent.f_level2.document.getElementById("addlink").onclick = new Function("showATCInsert('"+level_no+"')");

	}
	if(level_no=='3')  {
	parent.f_level3.document.getElementById("addlink").innerText=getLabel("Common.Add.label","Common");
	parent.f_level3.document.getElementById("addlink").style.cursor='hand';
	parent.f_level3.document.getElementById("addlink").onclick = new Function("showATCInsert('"+level_no+"')");
	}
	if(level_no=='4')  {
	parent.f_level4.document.getElementById("addlink").innerText=getLabel("Common.Add.label","Common");
	parent.f_level4.document.getElementById("addlink").style.cursor='hand';
	parent.f_level4.document.getElementById("addlink").onclick = new Function("showATCInsert('"+level_no+"')");
	}
	if(level_no=='5')  {
	parent.f_level5.document.getElementById("addlink").innerText=getLabel("Common.Add.label","Common");
	parent.f_level5.document.getElementById("addlink").style.cursor='hand';
	parent.f_level5.document.getElementById("addlink").onclick = new Function("showATCInsert('"+level_no+"')");
	}

}

function apply(mode,innerMode,frm,ifrecordclicked){

//alert(mode);
	if(mode == MODE_INSERT)
	{
	formObj				=	f_atcinsert.document.ATCClassification_Insert ;
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();

	arrFieldName[0]			=	"atc_class_lev_code_";
	arrFieldName[1]			=	"atc_class_lev_desc_";
	//arrFieldName[2]			=	"display_seq_no_";

	arrLegends[0]			=	getLabel("Common.code.label","Common");
	arrLegends[1]			=	getLabel("Common.description.label","Common");
	//arrLegends[2]			=	"Display Sequence No";

	var arrPKFieldNames		=	new Array();
	arrPKFieldNames[0]		=	"atc_class_lev_code_";

	var	frameObj			=	null;
	resetDuplicateClass(formObj,arrPKFieldNames,1);
	var	result2	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,1,MESSAGE_FRAME);
	if (result2){

		checkForDuplicates(formObj);
		eval( formApply(f_atcinsert.document.ATCClassification_Insert,PH_CONTROLLER  ) ) ;

		if( result ) {
			alert(message);
			onSuccess(mode);
		}
		else if(invalidCode!="" || invalidCode!="null"){
				//alert(message+":-"+invalidCode);
				showDuplicates(formObj, arrPKFieldNames, invalidCode,1);
				}
		}
	}
	else if (mode == MODE_MODIFY || mode == MODE_DELETE)
	{
		var res	=	new Array();

	if (mode == MODE_MODIFY && innerMode=="MODIFY_ALL")	{
	formObj	=	f_atcmodify_all.document.ATCClassification_ModifyAll;
		inMode="MODIFY_ALL"
//	val_result	=	validateAll();

//		if(val_result)	{
			eval( formApply(f_atcmodify_all.document.ATCClassification_ModifyAll,PH_CONTROLLER ) ) ;

			if( result && frm!="page") {
				alert(message);
				onSuccess(mode);
			}
			else	{ displayInvalidPages();
			}
//		}
	}
	else	{

		var formObj = f_atcmodify.document.ATCClassification_Modify;
		var fields	;
		var names	;

		if(formObj.level_no.value=='1') {
		fields = new Array ( formObj.atc_class_lev1_code,
							 formObj.atc_class_lev1_desc,
								 formObj.display_seq_no);
		names = new Array ( getLabel("ePH.AnatomicalClassCode.label","PH"),
							getLabel("ePH.AnatomicalClassDescription.label","PH"),
							getLabel("ePH.DisplaySequenceNo.label","PH"));
		}
		if(formObj.level_no.value=='2') {
		fields = new Array ( formObj.atc_class_lev2_code,
								 formObj.atc_class_lev2_desc,
								 formObj.display_seq_no);
		names = new Array ( getLabel("ePH.TherapeuticMainClassCode.label","PH"),
							getLabel("ePH.TherapeuticMainClassDescription.label","PH"),
							getLabel("ePH.DisplaySequenceNo.label","PH"));
		}
		if(formObj.level_no.value=='3') {
		fields = new Array ( formObj.atc_class_lev3_code,
								 formObj.atc_class_lev3_desc,
								 formObj.display_seq_no);
		names = new Array ( getLabel("ePH.TherapeuticSubClassCode.label","PH"),
							getLabel("ePH.TherapeuticSubClassDescription.label","PH"),
							getLabel("ePH.DisplaySequenceNo.label","PH"));
		}
		if(formObj.level_no.value=='4') {

		fields = new Array ( formObj.atc_class_lev4_code,
								 formObj.atc_class_lev4_desc,
								 formObj.display_seq_no);
		names = new Array ( getLabel("ePH.ChemicalClassCode.label","PH"),
							getLabel("ePH.ChemicalClassDescription.label","PH"),
							getLabel("ePH.DisplaySequenceNo.label","PH"));
		}
		if(formObj.level_no.value=='5') {
		fields = new Array ( formObj.atc_class_lev5_code,
								 formObj.atc_class_lev5_desc,
								 formObj.display_seq_no);
		names = new Array ( getLabel("ePH.ChemicalSubClassCode.label","PH"),
							getLabel("ePH.ChemicalSubClassDescription.label","PH"),
							getLabel("ePH.DisplaySequenceNo.label","PH"));
		}


		if(checkFlds( fields, names)) {
			if (ifrecordclicked != "1") {

				if (confirm(getMessage("DELETE_RECORD","Common"))){
					eval( formApply(f_atcmodify.document.ATCClassification_Modify,PH_CONTROLLER  ) ) ;
					alert(message);
					if( result ) {
						onSuccess(mode);
					}
				}
			}
			else {
				eval( formApply(f_atcmodify.document.ATCClassification_Modify,PH_CONTROLLER  ) ) ;
				alert(message);
				if( result ) {
					onSuccess(mode);
				}
			}
		}
	}
	}
}

function onSuccess(mode) {
//	var mode		= f_atcmodify.document.ATCClassification_Modify.mode.value;
	//var close_var	=	 parent.parent.document.getElementById("dialog_tag").close();
	window.close();
}

function assignResult( _result, _message, _flag,_invalidCode ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
	//alert(flag);
	invalidCode = _invalidCode ;
}

function onReset(description,seqno)
{
	f_atcmodify.document.ATCClassification_Modify.elements[1].value=unescape(description);
	f_atcmodify.document.ATCClassification_Modify.elements[2].value=seqno;
}

function deleterecord(){
	f_atcmodify.document.ATCClassification_Modify.mode.value = MODE_DELETE;
	apply(MODE_DELETE);
}

function refreshPreviousLevel(level_no,called_from)
{
if(level_no=="2")	{
parent.f_level1_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=1&called_from="+called_from;
parent.f_level2_detail.location.href="../../eCommon/html/blank.html";
parent.f_level3_detail.location.href="../../eCommon/html/blank.html";
parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
parent.f_level2.document.getElementById("addlink").innerText='';
parent.f_level2.document.getElementById("addlink").style.cursor='pointer';
parent.f_level2.document.getElementById("addlink").onclick='';
}

if(level_no=="3")	{
parent.f_level2_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=2&called_from="+called_from;
parent.f_level3_detail.location.href="../../eCommon/html/blank.html";
parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
parent.f_level3.document.getElementById("addlink").innerText='';
parent.f_level3.document.getElementById("addlink").style.cursor='pointer';
parent.f_level3.document.getElementById("addlink").onclick='';
}

if(level_no=="4")	{
parent.f_level3_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=3&called_from="+called_from;
parent.f_level4_detail.location.href="../../eCommon/html/blank.html";
parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
parent.f_level4.document.getElementById("addlink").innerText='';
parent.f_level4.document.getElementById("addlink").style.cursor='pointer';
parent.f_level4.document.getElementById("addlink").onclick='';
}

if(level_no=="5") {
parent.f_level4_detail.location.href="../../ePH/jsp/ATCLevelDetail.jsp?mode="+MODE_MODIFY+"&level_num=4&called_from="+called_from;
parent.f_level5_detail.location.href="../../eCommon/html/blank.html";
parent.f_level5.document.getElementById("addlink").innerText='';
parent.f_level5.document.getElementById("addlink").style.cursor='pointer';
parent.f_level5.document.getElementById("addlink").onclick='';
}

}

function makeSelectChk(value)
{
var code = eval(self.f_atcinsert.document.getElementById("atc_class_lev_code_"+value)).value;
var desc = eval(self.f_atcinsert.document.getElementById("atc_class_lev_desc_"+value)).value;
	if( (trimCheck(code) == true) && (trimCheck(desc)==true) )
	{
	eval(self.f_atcinsert.document.getElementById("select_"+value)).disabled=false;
	eval(self.f_atcinsert.document.getElementById("select_"+value)).checked=true;
	}
}

function resetInsert(){
f_atcinsert.document.forms[0].reset();
}

function focusFirstItem(mode,frmobj)	{
	if(mode==MODE_INSERT && frmobj=='insert')
	{
	 document.getElementById("f_atcinsert").contentWindow.document.ATCClassification_Insert.elements[0].focus();
	}
	if(mode==MODE_MODIFY && frmobj=='modify')
	{
		document.getElementById("f_atcmodify").contentWindow.document.ATCClassification_Modify.elements[1].focus();
	}
}

function enableDesc(descno)
{
	obj	=	eval("self.f_atcinsert.document.ATCClassification_Insert.atc_class_lev_desc_"+descno);
	obj.disabled=false;
}

function callNextFocusCode(codeno)
{

	var code = eval(parent.f_atcinsert.document.getElementById("atc_class_lev_code_"+codeno)).value;
	var desc = eval(parent.f_atcinsert.document.getElementById("atc_class_lev_desc_"+codeno)).value;
	if( (trimCheck(code) == true) && (trimCheck(desc)==true) )
	{
		var codeno	=	parseInt(codeno) + 1;
		if(codeno==11) {
		parent.f_atcinsert.document.ATCClassification_Insert.record.focus();
		}
		else	{
		obj	=	eval("parent.f_atcinsert.document.ATCClassification_Insert.atc_class_lev_code_"+codeno);
		obj.disabled=false;
		obj.focus();
		}
	}
}

function callClose()
{
	window.returnValue="cancel";
	window.close();
}


function callSelection()
{
var record	=	"";

item_1		=	f_level_descs.document.getElementById("L1_code");
item_2		=	f_level_descs.document.getElementById("L1");
item_3		=	f_level_descs.document.getElementById("L2_code");
item_4		=	f_level_descs.document.getElementById("L2");
item_5		=	f_level_descs.document.getElementById("L3_code");
item_6		=	f_level_descs.document.getElementById("L3");
item_7		=	f_level_descs.document.getElementById("L4_code");
item_8		=	f_level_descs.document.getElementById("L4");
item_9		=	f_level_descs.document.getElementById("L5_code");
item_10		=	f_level_descs.document.getElementById("L5");
//alert("item_1="+item_1.value+" item_2="+item_2.innerText+"item_3="+item_3.value+" item_4="+item_4.innerText+"item_5="+item_5.value+" item_6="+item_6.innerText+" item_7="+item_7.value+" item_8="+item_8.innerText+" item_9="+item_9.value+" item_10="+item_10.innerText);
//alert("code"+item_1.value);
//alert("desc"+item_2.innerText);
if(item_1.value != null && item_1.value!="") {
record		=	item_1.value + "|" + item_2.innerText + "|";
}
else {
record		+=	" " + "|" + " " + "|";
}

if(item_3.value != null && item_3.value!="")	{
record		+=	item_3.value + "|" + item_4.innerText + "|";
}
else {
record		+=	" " + "|" + " " + "|";
}

if(item_5.value != null && item_5.value!="") {
record		+=	item_5.value + "|" + item_6.innerText + "|";
}
else {
record		+=	" " + "|" + " " + "|";
}

if(item_7.value != null && item_7.value!="")	{
record		+=	item_7.value + "|" + item_8.innerText + "|";
}
else {
record		+=	" " + "|" + " " + "|";
}

if(item_9.value != null && item_9.value!="")	{
record		+=	item_9.value + "|" + item_10.innerText;
}
else {
record		+=	" " + "|" + " " + "|";
}

//alert(record);
/*window.returnValue = record;
window.close();*/
let dialogBody = parent.parent.document.getElementById('dialog-body');
dialogBody.contentWindow.returnValue = record;

const dialogTag = parent.parent.document.getElementById("dialog_tag");    
dialogTag.close();   
}

function checkAllDelete()
{
var frmObj	=	f_atcmodify_all.ATCClassification_ModifyAll;

var arrObj = frmObj.elements;
if(f_atcmodify_all.ATCClassification_ModifyAll.del_all.checked == true )	{

			for(i=0;i<arrObj.length;i++) {
				if(arrObj[i].type == "checkbox") {
					if(arrObj[i].name!="del_all") {
						 if ( arrObj[i].disabled == false){
						 arrObj[i].checked = true;
						 }
					}
				}
			}
}
else if(f_atcmodify_all.ATCClassification_ModifyAll.del_all.checked == false )	{

			for(i=0;i<arrObj.length;i++) {
				if(arrObj[i].type == "checkbox") {
					if(arrObj[i].name!="del_all") {
						 if ( arrObj[i].disabled == false)
						 arrObj[i].checked = false;
					}
				}
			}

}
if (f_atcmodify_all.ATCClassification_ModifyAll.del_all.checked == true)
	f_atcmodify_all.ATCClassification_ModifyAll.delete_all.value="checked";
}


function uncheckAllDelete(obj)
{
if (f_atcmodify_all.ATCClassification_ModifyAll.del_all.checked == true)
f_atcmodify_all.ATCClassification_ModifyAll.del_all.checked = false;
}

function disableDeleteAll()
{
f_atcmodify_all.ATCClassification_ModifyAll.del_all.disabled = true;
}

function enableDeleteAll()
{
f_atcmodify_all.ATCClassification_ModifyAll.del_all.disabled = false;
}


function navigation(frmObj,link,pageno)
{

	if(link=="reset")
	{
	f_atcmodify_all.document.getElementById("resetStatus").value="reset";
	}

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var arrObj = frmObj.elements;
	var confirmMessage = false;
	var frmObjs = new Array()
	if(frmObj.name == null)
		frmObjs = frmObj
	else frmObjs[0] = frmObj

	var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
		frmObj = frmObjs[frmCount]
		var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)	{
					arrObj[i].value="Y";
					val = arrObj[i].value;
					confirmMessage = true;
				}
				else
				{
					arrObj[i].value="N";
					val = arrObj[i].value;
				}
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
			}
			else
				val = arrObj[i].value;

			val = checkSpl( val ) ;

			xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
		}
	}
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","ATCModifyAllStore.jsp",false);
	//alert(xmlStr);
	xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
 // alert(responseText);
	//alert(xmlHttp.responseText );

	level_num	=	f_atcmodify_all.document.getElementById("level_no").value;
	start		=	f_atcmodify_all.document.getElementById("start").value;
	end			=	f_atcmodify_all.document.getElementById("end").value;
	mode		=	f_atcmodify_all.document.getElementById("mode").value;

/*	if(link=="previous")	{
	start	=	parseInt(start)-14;
	end		=	parseInt(end)-14;
	f_atcmodify_all.location.href="../../ePH/jsp/ATCClassificationModifyAll.jsp?level="+level_num+	"&from="+start+"&to="+end+"&mode="+mode+"&firstTime=no";
	f_atcmodify_buttons.document.getElementById("curr_pageno").innerText	=	(end/14);
	}
	else if(link=="next")	{
	start	=	parseInt(start)+14;
	end		=	parseInt(end)+14;
	f_atcmodify_all.location.href="../../ePH/jsp/ATCClassificationModifyAll.jsp?level="+level_num+	"&from="+start+"&to="+end+"&mode="+mode+"&firstTime=no";
	f_atcmodify_buttons.document.getElementById("curr_pageno").innerText	=	(end/14);
	}*/
	if(link=="page")	{
		end		=	parseInt(pageno) * 14;
		if(pageno==1)
			start	=	1;
		else
			start	=	end -13;
	f_atcmodify_all.location.href="../../ePH/jsp/ATCClassificationModifyAll.jsp?level="+level_num+	"&from="+start+"&to="+end+"&mode="+mode+"&firstTime=no";
	f_atcmodify_buttons.document.getElementById("curr_pageno").innerText	=	(end/14);

	}
	else if(link=="record")	{
		
		if(confirmMessage==true){
			if (confirm(getMessage("DELETE_RECORD","Common"))){
				apply(mode,"MODIFY_ALL");
			}
		}else{
			
			apply(mode,"MODIFY_ALL");
			/*parent.window.close();*/
		}
	}
	else if(link=="reset")	{
		f_atcmodify_all.location.href="../../ePH/jsp/ATCClassificationModifyAll.jsp?level="+level_num+	"&from="+start+"&to="+end+"&mode="+mode+"&firstTime=no&link=reset";
	}
}


function checkFlds( fields, names) {

	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] + getlabel("Common.Cannotbeblank.label","Common") + "\n" ;
	}
	if ( errors.length != 0 ) {
		alert(errors) ;
		return false ;
	}
	return true ;
}

function validateDispNo(obj,item_no,from)
{
	if(trimCheck(obj.value))	{
		if(!CheckForNumber(obj.value))	{
		if(from!='modify')
		obj.select();
		return;
	}
	}
	else
	{return;}

		if(from!='modify')
		callNextFocusCode(item_no);

}

function ChkMaxLen(lab,obj,max,mode) {

	if(obj.value.length >= max) {
		alert("APP-SM0045 - " + lab + getLabel("ePH.Cannotexceed.label","PH") +" "+max+" "+ getLabel("ePH.characters.label","PH"));
		obj.select();
		return false;
	}
	else 
		return true;
}

function repeatValidations(mode){
	 
	var frmObj	= document.getElementById("f_atcmodify").contentWindow.document.ATCClassification_Modify;
	var desc	= frmObj.elements[1];
	var disp_no	= frmObj.elements[2];
	if(ChkMaxLen('Description',desc,100))	{
/*		if(trimCheck(disp_no.value))	{
		if(!CheckForNumber(disp_no.value))
		disp_no.select();
		}
		else	{ */
		apply(mode, '', '', '1');
	//	}
	}

}

function clickHiddenButton()
{
var frmObj	=	self.f_atcmodify_all.ATCClassification_ModifyAll;
frmObj.resetButton.click();
self.f_atcmodify_buttons.document.getElementById("msg").innerText			=	"";
self.f_atcmodify_buttons.document.getElementById("page_links").innerHTML	=	"&nbsp;";
navigation(frmObj,"reset");
}

function checkDeleteAll()
{
var frmObj	=	parent.f_atcmodify_all.ATCClassification_ModifyAll;
frmObj.del_all.checked=true;
}

function resetColorCode(obj)
{
	var arrPKFieldNames	=	new Array();
	var formObj			=	self.f_atcinsert.document.ATCClassification_Insert ;
	/**
	  * specify the primary key columns
	  */
	arrPKFieldNames[0]	=	"atc_class_lev_code_";
	arrPKFieldNames[1]	=	"display_seq_no_";

	/**
	  * if more than one columns exists in
	  * the primary key, then the next columns
	  * can be given like this
	  */
	//arrPKFieldNames[1]	=	"long_desc_";
	//arrPKFieldNames[2]	=	"short_desc_";
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}

function changeColor(obj)	{
	if(obj.className=="DUPLICATE")
		obj.className="";
}

function checkForDuplicates(formObj){
var totalRecords	=	formObj.totalRecords.value;
var disp_no			=	new Array();
var found			=	false;
var dup_no			=	"";
var j				=	0;
	for(i=1; i<=totalRecords; i++)
	{
	select	=	eval("formObj.select_"+i);
		if(select!=null && select.checked==true)	{
					display_no		=	eval("formObj.display_seq_no_"+i+".value");
				if(!trimCheck(display_no))	{
					alert(getMessage("DISPLAY_SEQ_CANNOT_BE_BLANK","PH"));
					eval("formObj.display_seq_no_"+i+".focus()");
					return;
				}
			disp_no[j++]  =	eval("formObj.display_seq_no_"+i);
			}
	}

var data			=	new Array();
var dup_data		=	new Array();
var dup_obj			=	new Array();
var found			=	false;
var	p				=	0;
var q				=	0;
var n				=	0;

for(i=0; i< disp_no.length; i++)	{
found		=	false;
	temp	=	disp_no[i];

	/*** check in data*****/
	for(j=0; j<data.length; j++)	{
	if(temp.value == data[j].value)
		found	= true;
	}

	/***add to data****/
	if(!found)
		data[p++]	=	temp;
	else {
	found	=	false;
		/**********check dup data **********/
		for(k=0; k<dup_data.length; k++)	{
		if(temp.value == dup_data[k].value)
		found	= true;
		}

		/********* add to dup data***********/
		if(!found)
			dup_data[q++]	=	temp;
		else
			dup_obj[n++]	=	temp;
	}
}

var dups	=	new Array();
for(res=0; res<dup_data.length; res++){
	dups[res]	=	dup_data[res].value;
}



/******Highlight the first duplicate********/

if(dup_data[0] !=null || dup_data[0]!=undefined)
{
alert(getMessage("PH_DUP_SEQ_NO","PH")+":"+dups);
	temp	=	dup_data[0];

	for(l=0; l<disp_no.length; l++){
		if(temp.value ==disp_no[l].value)	{
		disp_no[l].className="DUPLICATE";
		}
		else
		disp_no[l].className="";
	}

}

}

function chkNull(val,link_reqd){
	if(val!="")	{
 return (link_reqd=="Y")?"<a href=\"javascript:parent.callPage(\'"+val+"\')\">&nbsp;"+val+"&nbsp;</a>":val;
	}
}

function callPage(pageno){

	frmObj	=	f_atcmodify_all.document.ATCClassification_ModifyAll;
	link	=	"page";
	navigation(frmObj,link);
				if(pageno==1)	{
				start	=	1;
				end		=	14;
				}
				else if(pageno==2)	{
				start	=	15;
				end		=	28;
				}
				else if(pageno==3)	{
				start	=	29;
				end		=	42;
				}
				else if(pageno==4)	{
				start	=	43;
				end		=	56;
				}
				else if(pageno==5)	{
				start	=	57;
				end		=	70;
				}
				else if(pageno==6)	{
				start	=	71;
				end		=	84;
				}
			f_atcmodify_all.location.href="../../ePH/jsp/ATCClassificationModifyAll.jsp?level="+level_num+	"&from="+start+"&to="+end+"&mode="+mode+"&firstTime=no";
			f_atcmodify_buttons.document.getElementById("curr_pageno").innerText	=	pageno;
}

function validateAll()	{
	var			j	=	0;
	var disp_no		=	new Array();
	formObj			=	f_atcmodify_all.document.ATCClassification_ModifyAll ;
	var	arrObj		=	formObj.elements;
	var result		=	true;

	for(i=0; i<arrObj.length; i++)	{
		var ename	=	arrObj[i].name;
		if(ename.substr(0,3)=="des" || ename.substr(0,3)=="seq" )	{
			if(arrObj[i].value==""){
				arrObj[i].className="DUPLICATE";
				result =false;
			}
		}
		if(dup_vals!=null)	{
			if(ename.substr(0,3)=="seq") {
				for(j=0; j<dup_vals.length; j++)
					if(dup_vals[j]==arrObj[i].value)
					arrObj[i].className="DUPLICATE";
			}
		}
	}


	return result;
}


function displayInvalidPages()	{
		var recno;
		var desc		=	new Array();
		var pageno		=	new Array();
		var no			=	0;
		var pageno_1	=	"";
		var pageno_2	=	"";
		var pageno_3	=	"";
		var pageno_4	=	"";
		var pageno_5	=	"";
		var pageno_6	=	"";
		var values		=	"";

		if(result==false)		{
			res	=	message.split(":");
			for(j=0; j<res.length; j++) {
					if(res[j]=="Blank_Desc"){
						j		=	j+1;
						desc	=	res[j].split(",");

						for(l=0; l<desc.length; l++)	{
							if(parseInt(desc[l]) >=0 && parseInt(desc[l]) <=13 )
							pageno_1		= 1;
							else if(parseInt(desc[l]) >=14 && parseInt(desc[l]) <=27 )
							pageno_2	= 2;
							else if(parseInt(desc[l]) >=28 && parseInt(desc[l]) <=41 )
							pageno_3	= 3;
							else if(parseInt(desc[l]) >=42 && parseInt(desc[l]) <=55 )
							pageno_4	= 4;
							else if(parseInt(desc[l]) >=56 && parseInt(desc[l]) <=69 )
							pageno_5	= 5;
							else if(parseInt(desc[l]) >=70 && parseInt(desc[l]) <=83 )
							pageno_6	= 6;
						}
					}
					else if(res[j]=="Blank_No"){
						j	=	j+1;
						blank_no	=	res[j].split(",");
						for(l=0; l<blank_no.length; l++)	{
							if(parseInt(blank_no[l]) >=0 && parseInt(blank_no[l]) <=13 )
							pageno_1		= 1;
							else if(parseInt(blank_no[l]) >=14 && parseInt(blank_no[l]) <=27 )
							pageno_2	= 2;
							else if(parseInt(blank_no[l]) >=28 && parseInt(blank_no[l]) <=41 )
							pageno_3	= 3;
							else if(parseInt(blank_no[l]) >=42 && parseInt(blank_no[l]) <=55 )
							pageno_4	= 4;
							else if(parseInt(blank_no[l]) >=56 && parseInt(blank_no[l]) <=69 )
							pageno_5	= 5;
							else if(parseInt(blank_no[l]) >=70 && parseInt(blank_no[l]) <=83 )
							pageno_6	= 6;
						}
					}
					else if(res[j]=="Dup_No"){
						j	=	j+1;
						dup_no		=	res[j].split(",");

						for(l=0; l<dup_no.length; l++)	{
							if(parseInt(dup_no[l]) >=0 && parseInt(dup_no[l]) <=13 ) {
							pageno_1		= 1;
							}
							else if(parseInt(dup_no[l]) >=14 && parseInt(dup_no[l]) <=27 )	{
							pageno_2	= 2;
							}
							else if(parseInt(dup_no[l]) >=28 && parseInt(dup_no[l]) <=41 )	{
							pageno_3	= 3;
							}
							else if(parseInt(dup_no[l]) >=42 && parseInt(dup_no[l]) <=55 )	{
							pageno_4	= 4;
							}
							else if(parseInt(dup_no[l]) >=56 && parseInt(dup_no[l]) <=69 )	{
							pageno_5	= 5;
							}
							else if(parseInt(dup_no[l]) >=70 && parseInt(dup_no[l]) <=83 )	{
							pageno_6	= 6;
							}
						}

					}
					else if(res[j]=="Dup_Vals"){
						j	=	j+1;
						dup_vals		=	res[j].split(",");
					}
			}
			msg_1		=	getMessage("BLANK_DESCRIPTION_DUPLICATE_DISPLAY_SEQ_NO_IN_PAGES","PH");
			curr_page	=	f_atcmodify_all.document.getElementById("start").value;
			if(curr_page >=1 && curr_page <=14)
				curr_page = 1;
			else if(curr_page >=15 && curr_page <=28)
				curr_page = 2;
			else if(curr_page >=29 && curr_page <=42)
				curr_page = 3;
			else if(curr_page >=43 && curr_page <=56)
				curr_page = 4;
			else if(curr_page >=57 && curr_page <=70)
				curr_page = 5;
			else if(curr_page >=71 && curr_page <=84)
				curr_page = 6;

			for(n=1; n<=6; n++)	{
				pageno	=	eval("pageno_"+n);
				if(pageno!="")
					values	+=	"&nbsp;"+pageno+"&nbsp;";
			}

			validateAll(dup_vals);
			f_atcmodify_buttons.document.getElementById("msg").innerText			=	msg_1;
			f_atcmodify_buttons.document.getElementById("page_links").innerHTML	=	values;
			f_atcmodify_buttons.document.getElementById("curr_pageno").innerText	=	curr_page;

		}

}

function chkDecimal(obj)	{
	var str_val	=	obj.value;
	if( str_val.indexOf(".")!=-1)	{
	alert(getMessage("INVALID_INTEGER","PH"));
	obj.select();
	}
}

function checkSplChars(obj)	{
	if(!CheckChars(obj))	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.select();
	}
}

function checkForZero(obj){
	if(parseFloat(obj.value) == 0){
		alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
		obj.select();
	}
}

function resetScreen(){
	formObj =   parent.f_atcinsert.document.ATCClassification_Insert;

    var arrPKFieldNames     =   new Array();
    arrPKFieldNames[0]      =   "atc_class_lev_code_";

	resetDuplicateClass( formObj, arrPKFieldNames, 1);
}

function showPhamacologicalLevelDetails(level,result1,result2,obj,index){
//	alert("lev"+level);
//	alert("res1"+result1);
//	alert("res2"+result2);
//	alert("ind"+index);
	if(level=='1')	{
		parent.frames[4].location.href="../../ePH/jsp/PharmacologicalLevelDetail.jsp?level_num=2&level_code="+result1+"&level_desc="+result2+"&called_from="+index;
		parent.frames[5].location.href="../../eCommon/html/blank.html";
		parent.f_view_levels.f_level_descs.location.href="../../ePH/jsp/PharmacologicalViewLevel.jsp?level=1&code="+result1+"&desc="+result2;
	}
	if(level=='2')	{
		parent.frames[5].location.href="../../ePH/jsp/PharmacologicalLevelDetail.jsp?level_num=3&level_code="+result1+"&level_desc="+result2+"&called_from="+index;
		parent.f_view_levels.f_level_descs.location.href="../../ePH/jsp/PharmacologicalViewLevel.jsp?level=2&code="+result1+"&desc="+result2;
	}
	if(level=='3')	{
		parent.f_view_levels.f_level_descs.location.href="../../ePH/jsp/PharmacologicalViewLevel.jsp?level=3&code="+result1+"&desc="+result2;
	}
}

function selectedPharmaLevels(){
	var record	=	"";
	item_1		=	parent.parent.f_view_levels.f_level_descs.PharmaViewLevel.level_code_1;
	item_2		=	parent.parent.f_view_levels.f_level_descs.PharmaViewLevel.level_desc_1;
	item_3		=	parent.parent.f_view_levels.f_level_descs.PharmaViewLevel.level_code_2;
	item_4		=	parent.parent.f_view_levels.f_level_descs.PharmaViewLevel.level_desc_2;
	item_5		=	parent.parent.f_view_levels.f_level_descs.PharmaViewLevel.level_code_3;
	item_6		=	parent.parent.f_view_levels.f_level_descs.PharmaViewLevel.level_desc_3;


	//alert("desc"+item_2.innerText);
	if(item_1.value != null && item_1.value!="") {
		record		=	item_1.value + "|" + item_2.value + "|";
	}else {
		record		+=	" " + "|" + " " + "|";
	}

	if(item_3.value != null && item_3.value!="")	{
		record		+=	item_3.value + "|" + item_4.value + "|";
	}else {
		record		+=	" " + "|" + " " + "|";
	}

	if(item_5.value != null && item_5.value!="") {
		record		+=	item_5.value + "|" + item_6.value + "|";
	}else {
		record		+=	" " + "|" + " " + "|";
	}

	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = record;
	parent.parent.document.getElementById("dialog_tag").close();
	//window.returnValue = record;
	//window.close();
	 parent.parent.document.getElementById("dialog_tag").close();
}
