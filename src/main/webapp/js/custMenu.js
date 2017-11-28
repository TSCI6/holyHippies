
$(window).on("load", function() {
	
	    $.ajax({
	        type: "GET",

	        url: "manage/foodItems",

	        success: function(list) {
	            data = list;
	            cleanFoodTable(data);
	        },
	        error: function(e) {
	            alert("error while retrieving Profile" + e)
	        
	        }
	})   ;
});


function cleanFoodTable(data)
{
	 var rows = [];
     for (var i=0;i<data.length;i++)
     {
         if (data[i].enabled)
         rows.push(data[i]);
     }
handleFoodTable(rows);
}

function handleFoodTable(data)
{
    console.log(data);
    $('#adminFoodTable').DataTable({
    	searching: false,
    	paging: false,
    	data: data,
        columns: [{
                'data': 'imagUrl',
            	bSortable:false,
      	      	mRender:function(data,type,row){
      	      		
      	      		
      	      		return '<img src="FoodItemsImages/'+data+'" class="foodImage" height="50" width="50"/>';
      	      	}
                
            }, {
                'data': 'name'
            }, {
                'data': 'price',
                mRender: function(data, type, row) {
         	       return '&#8377; ' + data
         	      }
            }

        ],
   
    });	
}