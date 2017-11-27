$(window).on("load", function() {

	$.ajax({
		type: "GET",

		url: "manage/foodItems",

		success: function(list) {
			data = list;
			handleFoodTable(data);
		},
		error: function(e) {
			alert("error while retrieving Profile" + e)

		}
	})   ;
});
function handleFoodTable(data)
{
	console.log(data);
	$('#adminFoodTable').DataTable({
		data: data,
		columns: [{
			'data': 'id'
		}, {
			'data': 'imagUrl',
			bSortable:false,
			mRender:function(data,type,row){


				return '<img src="FoodItemsImages/'+data+'" class="foodImage"/>';
			}

		}, {
			'data': 'name'
		}, {
			'data': 'price',
			mRender: function(data, type, row) {
				return '&#8377; ' + data
			}
		}, {


			data: 'enabled',
			bSortable:false,
			mRender:function(data,type,row){

				var str = '';
				str +='<label class="switch">';
				if(data){
					str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';  
				}
				else{
					str += '<input type="checkbox"  value="'+row.id+'"/>'
				}
				str += '<div class="slider"></div></label>';										

				return str;

			}

		}

		],
		initComplete:function(){
			var api=this.api();
			api.$('.switch input[type="checkbox"]').on('change',function(){
				var checkbox=$(this);
				var checked=checkbox.prop('checked');
				var dMsg=(checked)? 'You want to activate the Food Item?':
					'You want to deactivate the Food Item?';
				var value=checkbox.prop('value');

				bootbox.confirm({
					size:'medium',
					title:'Food Item Activation & Deactivation',
					message:dMsg,
					callback:function(confirmed){

						if(confirmed){
							console.log(value);
							var prdctActivationUrl= 'manage/product/'+value+'/activation';
							$.post(prdctActivationUrl,function(data){
								bootbox.alert({
									size:'medium',
									title:'Information',
									message:data
								});	
							});


						}
						else{
							checkbox.prop('checked',!checked);
						}
					}

				});

			});

		}
	});	
}





//add items 
		
		$("#addItem").click(function() {
		var formvalue = new FormData($('#addFoodItem')[0]);

		$.ajax({
			type : "POST",
			url : "manage/addNew",
			data : formvalue,
			processData : false,
			contentType : false,
			success : function(response) {
				data = response;
				handleAddingItem(data);
			},
			error : function(e) {
				alert("error while trying to save data" + e)
			}
		});
	});



function handleAddingItem(){
	
	$( "#addFoodItem" )[ 0 ].reset();
	$("#addItemModal .close").click()
	/*alert("save successfully");*/
	location.reload();
	
	
}





		
