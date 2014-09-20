function validateSearchForm()
{
   var input = document.book_search_form.search_name.value;
   if( input == "" )
   {
     showError('error_form_search');
     return false;
   } else if(/^[A-Za-z]+/.test(input) == false){
	   showError('error_form_search');
	   return false;
   }
   hideError('error_form_search');
   return true;
}
function validateCompareForm()
{
   var re = /(?:\.([^.]+))?$/;
   var input = document.book_compare_form.inputFileCompare.value;
   if( input == "" )
   {
     showError('error_form_compare');
     return false;
   } else if(re.exec(input)[1].toUpperCase() != "JSON"){
	   showError('error_form_compare');
	   return false;
   }
   hideError('error_form_compare');
   return true;
}
function validateAddForm()
{
   var input_name = document.book_add_form.add_name.value;
   var input_phone = document.book_add_form.add_phone.value;
   var input_phone_simpl = input_phone.replace(/[\(\)\.\-\ ]/g, '');
   
   if( input_name == "" || input_phone == "" )
   {
     showError('error_form_add');
     return false;
   } else if(/^[A-Za-z]+/.test(input_name) == false){
	   showError('error_form_add');
	   return false;
   } else if(/^\d{10}$/.test(input_phone_simpl) == false){
	   showError('error_form_add');
	   return false;
   }
   hideError('error_form_add');
   return true;
}
function showError(id)
{
	document.getElementById(id).style.display = 'block';
}
function hideError(id)
{
	document.getElementById(id).style.display = 'none';
}
function checkString(input) {
    for (var i=0; i<input.length; i++) {
        if (input.charCodeAt(i) > 127) {
            return false;
        }
    }
    return true;
}