function create(){
    frm_special_note_detail.location.href="../../eCA/jsp/SpecialNotesDetail.jsp";
}

function reset(){
    frm_special_note_detail.document.specialNotesForm.reset();
	//frm_special_note_detail.location.reload();
}

function apply(){
    frm_special_note_detail.document.specialNotesForm.action = "../../servlet/eCA.SpecialNotesServlet";
    frm_special_note_detail.document.specialNotesForm.target = "messageFrame";
    frm_special_note_detail.document.specialNotesForm.method = "post";
    frm_special_note_detail.document.specialNotesForm.submit();
}

function onSuccess(){
	reset();
}