$(document).ready(function () {

$("#updateForm").on("submit", function(){
	
	$.ajax({
	    url: 'rest/cards/update',
	    type: 'PUT',
	    dataType: "xml",
	    data:$("#updateForm").serialize(),
	    success: function(xml) {
	    	console.log(xml);
	    	var card="";
	    	$(xml).find('Card').each(function(){
                $(this).find("cardNo").each(function(){
                    var id = $(this).text();
                    console.log(cardNo);
                    card=card+"cardNo: "+cardNo;
                });
                $(this).find("name").each(function(){
                    var name = $(this).text();
                    console.log(name);
                    card=card+"name: "+name;
                });
                $(this).find("type").each(function(){
                    var age = $(this).text();
                    console.log(type);
                    card=card+"type: "+type;
                });
            });
	    	alert(card);
	    }
	});
   return true;
 })
 
 $("#deleteForm").on("submit", function(){
	$.ajax({
	    url: 'rest/cards/delete',
	    type: 'DELETE',
	    dataType: "xml",
	    data:$("#deleteForm").serialize(),
	    success: function(xml) {
	    	console.log(xml);
	    	$(xml).find('Card').each(function(){
                $(this).find("cardNo").each(function(){
                    var cardNo = $(this).text();
                    console.log(cardNo);
                    alert("Deleted the user with id "+cardNo);
                });
            });
	    	
	    }
	});
   return true;
 })
});