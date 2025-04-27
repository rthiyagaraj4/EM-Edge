// Functions to default the validations based on menu selection.

//For Arch Menu

function archSelectedMenuRules(arch){
	formObj = document.forms[0];
	if(arch == "U"){
		formObj.lower_arch_applicable_yn.value= "N";
		formObj.UR_quadrant_applicable_yn.value= "N";
		formObj.UL_quadrant_applicable_yn.value= "N";
		formObj.LL_quadrant_applicable_yn.value= "N";
		formObj.LR_quadrant_applicable_yn.value= "N";
	}
	else if(arch == "L"){
		formObj.upper_arch_applicable_yn.value= "N";
		formObj.UR_quadrant_applicable_yn.value= "N";
		formObj.UL_quadrant_applicable_yn.value= "N";
		formObj.LL_quadrant_applicable_yn.value= "N";
		formObj.LR_quadrant_applicable_yn.value= "N";
	}
	
}
function archDeSelectedMenuRules(arch){
	formObj = document.forms[0];
	
	formObj.lower_arch_applicable_yn.value= "Y";
	formObj.upper_arch_applicable_yn.value= "Y";
	formObj.UR_quadrant_applicable_yn.value= "Y";
	formObj.UL_quadrant_applicable_yn.value= "Y";
	formObj.LL_quadrant_applicable_yn.value= "Y";
	formObj.LR_quadrant_applicable_yn.value= "Y";
	
}
function quadrantSelectedMenuRules(quad){
	formObj = document.forms[0];
	if(quad == "UL" || quad == "2" || quad == "6"){
		formObj.UR_quadrant_applicable_yn.value= "N";
		formObj.UL_quadrant_applicable_yn.value= "N";
		formObj.LL_quadrant_applicable_yn.value= "N";
		formObj.LR_quadrant_applicable_yn.value= "N";
	}
	else if(quad == "UR" || quad == "1" || quad == "5"){
		formObj.UR_quadrant_applicable_yn.value= "N";
		formObj.UL_quadrant_applicable_yn.value= "N";
		formObj.LL_quadrant_applicable_yn.value= "N";
		formObj.LR_quadrant_applicable_yn.value= "N";
	}
	else if(quad == "LR" || quad == "4" || quad == "8"){
		formObj.UR_quadrant_applicable_yn.value= "N";
		formObj.UL_quadrant_applicable_yn.value= "N";
		formObj.LR_quadrant_applicable_yn.value= "N";
		formObj.LL_quadrant_applicable_yn.value= "N";
	}
	else if(quad == "LL" || quad == "3" || quad == "7"){
		formObj.UR_quadrant_applicable_yn.value= "N";
		formObj.UL_quadrant_applicable_yn.value= "N";
		formObj.LR_quadrant_applicable_yn.value= "N";
		formObj.LL_quadrant_applicable_yn.value= "N";
	}
	formObj.lower_arch_applicable_yn.value= "N";
	formObj.upper_arch_applicable_yn.value= "N";
	
}

function quadrantDeSelectedMenuRules(quad){
	formObj = document.forms[0];
	
	formObj.UR_quadrant_applicable_yn.value= "Y";
	formObj.UL_quadrant_applicable_yn.value= "Y";
	formObj.LL_quadrant_applicable_yn.value= "Y";
	formObj.LR_quadrant_applicable_yn.value= "Y";
	formObj.lower_arch_applicable_yn.value= "Y";
	formObj.upper_arch_applicable_yn.value= "Y";
	
}

function toothSelectedMenuRules(count){
	formObj = document.forms[0];
	if(count > 0){
		formObj.UR_quadrant_applicable_yn.value= "N";
		formObj.UL_quadrant_applicable_yn.value= "N";
		formObj.LL_quadrant_applicable_yn.value= "N";
		formObj.LR_quadrant_applicable_yn.value= "N";
		formObj.lower_arch_applicable_yn.value= "N";
		formObj.upper_arch_applicable_yn.value= "N";
	}
	else{
		formObj.UR_quadrant_applicable_yn.value= "Y";
		formObj.UL_quadrant_applicable_yn.value= "Y";
		formObj.LL_quadrant_applicable_yn.value= "Y";
		formObj.LR_quadrant_applicable_yn.value= "Y";
		formObj.lower_arch_applicable_yn.value= "Y";
		formObj.upper_arch_applicable_yn.value= "Y";
	}

}
function toothDeSelectedMenuRules(count){
	formObj = document.forms[0];
	formObj.UR_quadrant_applicable_yn.value= "Y";
	formObj.UL_quadrant_applicable_yn.value= "Y";
	formObj.LL_quadrant_applicable_yn.value= "Y";
	formObj.LR_quadrant_applicable_yn.value= "Y";
	formObj.lower_arch_applicable_yn.value= "Y";
	formObj.upper_arch_applicable_yn.value= "Y";
	
}



function archSelectedMenuRules1(){
	formObj.crown_menu_applicable_yn= "N";
	formObj.root_menu_applicable_yn= "N";
	formObj.UR_quadrant_menu_applicable_yn= "N";
	formObj.UL_quadrant_menu_applicable_yn= "N";
	formObj.LR_quadrant_menu_applicable_yn= "N";
	formObj.LL_quadrant_menu_applicable_yn= "N";
	// Selection of muliple ARCHS to be confirmed.
}
function archDeselectedMenuRules(){
	formObj.crown_menu_applicable_yn= "Y";
	formObj.root_menu_applicable_yn= "Y";
	formObj.UR_quadrant_menu_applicable_yn= "Y";
	formObj.UL_quadrant_menu_applicable_yn= "Y";
	formObj.LR_quadrant_menu_applicable_yn= "Y";
	formObj.LL_quadrant_menu_applicable_yn= "Y";
}

/* For Quadrant Menu

*/
function quadrantSelectedMenuRules1(quad_name){
	formObj.crown_menu_applicable_yn= "N";
	formObj.root_menu_applicable_yn= "N";
	formObj.U_arch_menu_applicable_yn= "N";
	formObj.L_arch_menu_applicable_yn= "N";

	// Selection of muliple Quadrants to be confirmed.

}
function quadrantDeSelectedMenuRules1(){
	formObj.crown_menu_applicable_yn= "Y";
	formObj.root_menu_applicable_yn= "Y";
	formObj.U_arch_menu_applicable_yn= "Y";
	formObj.L_arch_menu_applicable_yn= "Y";

	// Selection of muliple Quadrants to be confirmed.
}

/* For Tooth Menu
   1. Disable the Root and Crown Level Menus
*/
function toothSelectedMenuRules1(){
	formObj.crown_menu_applicable_yn= "N";
	formObj.root_menu_applicable_yn= "N";
	formObj.UR_quadrant_menu_applicable_yn= "N";
	formObj.UL_quadrant_menu_applicable_yn= "N";
	formObj.LR_quadrant_menu_applicable_yn= "N";
	formObj.LL_quadrant_menu_applicable_yn= "N";

	formObj.U_arch_menu_applicable_yn= "N";
	formObj.L_arch_menu_applicable_yn= "N";
}
function toothDeSelectedMenuRules1(){
	formObj.crown_menu_applicable_yn= "Y";
	formObj.root_menu_applicable_yn= "Y";
	formObj.UR_quadrant_menu_applicable_yn= "Y";
	formObj.UL_quadrant_menu_applicable_yn= "Y";
	formObj.LR_quadrant_menu_applicable_yn= "Y";
	formObj.LL_quadrant_menu_applicable_yn= "Y";

	formObj.U_arch_menu_applicable_yn= "Y";
	formObj.L_arch_menu_applicable_yn= "Y";
}

/* For Tooth Range Menu
 1. Disable the Root and Crown Level Menus
*/
function toothRangeSelectedMenuRules(){
	formObj.crown_menu_applicable_yn= "N";
	formObj.root_menu_applicable_yn= "N";
	formObj.UR_quadrant_menu_applicable_yn= "N";
	formObj.UL_quadrant_menu_applicable_yn= "N";
	formObj.LR_quadrant_menu_applicable_yn= "N";
	formObj.LL_quadrant_menu_applicable_yn= "N";

	formObj.U_arch_menu_applicable_yn= "N";
	formObj.L_arch_menu_applicable_yn= "N";
}
function toothRangeDeSelectedMenuRules(){
	formObj.crown_menu_applicable_yn= "Y";
	formObj.root_menu_applicable_yn= "Y";
	formObj.UR_quadrant_menu_applicable_yn= "Y";
	formObj.UL_quadrant_menu_applicable_yn= "Y";
	formObj.LR_quadrant_menu_applicable_yn= "Y";
	formObj.LL_quadrant_menu_applicable_yn= "Y";

	formObj.U_arch_menu_applicable_yn= "Y";
	formObj.L_arch_menu_applicable_yn= "Y";
}

