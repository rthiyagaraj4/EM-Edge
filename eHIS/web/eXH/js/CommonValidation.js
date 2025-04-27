function sanitizeData(formObj)
{	
	var inputs, index;

	//inputs = window.f_query_add_mod.document.forms(formObj.name).elements;
	inputs = formObj.elements;
	var txt = "";
	var i;
	
	for (i = 0; i < inputs.length; i++) {
		
		if (inputs.elements[i].type == "text")
		{
			txt = inputs.elements[i].value;
			txt = sanitizeHTML(txt);
			txt = txt.replace(/&/g, '&amp;');
			txt = txt.replace(/["]/g, '&quot;');
			txt = txt.replace(/[']/g, '&apos;');
			inputs.elements[i].value = txt;	
			//alert(txt);
		}
		
	}
	
}

function sanitizeHTML(text) {
  var element = document.createElement('div');
  element.innerText = text;
  return element.innerHTML;
}
