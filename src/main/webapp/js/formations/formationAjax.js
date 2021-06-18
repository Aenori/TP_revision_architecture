const ATTR_LIST = ['id', 'date', 'sujet', 'formateur', 'paieFormateur',
        	'statut', 'statutFormateur'];
        
function updateFormationTable(data){
	let new_line = "";
	
	for(let attr of ATTR_LIST) {
		let value = data[attr];
		if(attr === 'sujet' || attr === 'formateur') {
			value = value['nom'];
		}
		new_line += `<td>${value}</td>`;
	}
	
	new_line = `<tr>${new_line}</tr>\n`;
	console.log("new_line : " + new_line);
	$("#formation_table_body")[0].innerHTML += new_line;
};
        
$('#addFormationForm').submit(function(event) {
    // Prévient le comportement normal du formulaire et le rechargement de
    // la page
    event.preventDefault(); 
    
    let form = $(this);
    $.ajax({
      type: form.attr('method'),
      url: 'FormationAjax',
      data: form.serialize()
    }).done(function(data) {
    	console.log('Call to ajax worked !')
    	console.log(JSON.stringify(data));
    	updateFormationTable(data);
      // Optionally alert the user of success here...
    }).catch(function(e) {
    	console.log('Call to ajax worked !')
    	console.log(e);
    });
});