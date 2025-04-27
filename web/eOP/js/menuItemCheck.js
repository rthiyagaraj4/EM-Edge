function menuItemCheck(Obj){

var HTMLVal = new String();
var u=Obj;


//	


if(u != "clinic" && u != "")
	parent.f_query_add_mod.document.clinic_form.preact_butt.disabled = false;
else
	parent.f_query_add_mod.document.clinic_form.preact_butt.disabled = true;

    if(u!=null || u!=" "|| u!="dummy")
    {
		//parent.f_query_add_mod.document.clinic_form.emergency.checked=false;
		parent.f_query_add_mod.document.clinic_form.clinic_code_hdn.value = u;
		parent.f_query_add_mod.document.clinic_form.first.checked=false;
		parent.f_query_add_mod.document.clinic_form.follow.checked=false;
		parent.f_query_add_mod.document.clinic_form.series.checked=false;
		parent.f_query_add_mod.document.clinic_form.consult.checked=false;
		parent.f_query_add_mod.document.clinic_form.routine.checked=false;
		//var field = 'working_week_1_day_';
		//var main = 'parent.f_query_add_mod.document.clinic_form.';
		//var main = parent.f_query_add_mod.document.clinic_form.working_week_1_day_;
	/*	var i=1;
		for (i=0;i<=7 ;i++)
		{
		var obj = eval("parent.f_query_add_mod.document.getElementById("working_week_1_day_")"+i);
		obj.checked=false;		
		}*/
		//eval(varBodyFrame+".document.getElementById("family_name")").disabled
		
		
		parent.f_query_add_mod.document.clinic_form.pract_working_week_1_day_1.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_1_day_2.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_1_day_3.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_1_day_4.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_1_day_5.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_1_day_6.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_1_day_7.checked=false;

		parent.f_query_add_mod.document.clinic_form.pract_working_week_2_day_1.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_2_day_2.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_2_day_3.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_2_day_4.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_2_day_5.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_2_day_6.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_2_day_7.checked=false;

		parent.f_query_add_mod.document.clinic_form.pract_working_week_3_day_1.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_3_day_2.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_3_day_3.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_3_day_4.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_3_day_5.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_3_day_6.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_3_day_7.checked=false;

		parent.f_query_add_mod.document.clinic_form.pract_working_week_4_day_1.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_4_day_2.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_4_day_3.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_4_day_4.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_4_day_5.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_4_day_6.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_4_day_7.checked=false;

		parent.f_query_add_mod.document.clinic_form.pract_working_week_5_day_1.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_5_day_2.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_5_day_3.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_5_day_4.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_5_day_5.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_5_day_6.checked=false;
		parent.f_query_add_mod.document.clinic_form.pract_working_week_5_day_7.checked=false;

		HTMLVal = "<html><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/ServerValidation.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+u+"'><input type='hidden' name='from_item_chk' id='from_item_chk' value='Y'></form></BODY></HTML>";
		parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[1].document.form1.submit();
		
    }
}










