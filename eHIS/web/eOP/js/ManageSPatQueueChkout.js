/*

    Developed by    :   R.Nanda Kumar
    Created on  :   22/12/2000
    Module      :   Out Patient Management
    Function    :   This file is used for declaring methods which will be
                called by the jsp files in their execution statements.
*/

var rowEle = "";
var refresh_ChkOut;


function query()
{

    //frame1.location.href ="../../eOP/jsp/ManageSPatQueueQueryCriteria.jsp";
    //frame2.location.href ="../../eOP/jsp/ManageSPatResult.jsp";

      frame1.location.href="../../eOP/jsp/ManageSPatQueueFr2.jsp?ChkOut=ChkOut&refresh="+refresh_ChkOut;
}

function PopulateList()
{

    var practcode = parent.frame1.manage_patient.Qpr;
    var loc_code  = parent.frame1.manage_patient.Qloc;

    while ( practcode.options.length > 0 )
        practcode.remove(practcode.options[0]);

    while (loc_code.options.length > 0 )
        loc_code.remove(loc_code.options[0]);

    var operstnid   = manage_patient.Qoperstat.value;

    if (operstnid != null && operstnid != "")
    {
        var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='managepatient' id='managepatient' method='post' action='../../eOP/jsp/ManagePatientQ.jsp'><input type='hidden' name='operstnid' id='operstnid' value='"+operstnid+"'></form></body></html>";
        parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
        parent.messageFrame.document.managepatient.submit();
    }
}

function getRow(obj)
{
    rowEle = obj.rowIndex;
}

async function popupMenu(obj)
{
    var dialogHeight= "10vh" ;
    var dialogWidth = "10vw" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth ;
    var arguments   = "" ;

    var retVal = await window.showModalDialog("../../eOP/jsp/PopUpMenu.jsp?queuestatus="+p_queue_status+"",arguments,features);

    if (retVal=="ok")
    {
        window.close();		
    }
}

function loadMenus()
{

    window.myMenu2      = new Menu("Pat");
    myMenu2.addMenuItem(getLabel("Common.patient.label","Common")+""+getLabel("Common.arrival.label","Common"));
    myMenu2.fontColor   = "red";
    myMenu2.menuItemBgColor = "white";

    myMenu2.writeMenus();
}

function reset() { 

/*Below line was modified by Venkatesh.S on 13-Feb-2013 against 37912 */
window.frames[1].document.location.reload();
  //window.frames[1].ManagePatQueueFrame.document.forms[0].reset();
//window.frames[1].location.href='../../eCommon/html/blank.html';
}

