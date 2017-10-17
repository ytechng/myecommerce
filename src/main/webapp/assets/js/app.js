$(function() {
	//console.log('Loading....');
	// Selecting active menu
	switch(menu) {
		
		case 'Home':
			$('#home').addClass('active');
		break;
		
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break;
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;
		default:
			$('#listProducts').addClass('active');
			$('#a_' + menu).addClass('active');
			break;
	}
	
	
	/**
	 * Code for jQuery datatable
	 * create a daataset
	 */
/*	var products = [
	                	['1', 'Product Title1'],
	                	['2', 'Product Title2'],
	                	['3', 'Product Title3'],
	                	['4', 'Product Title4'],
	                	['5', 'Product Title6'],
	                	['6', 'Product Title7'],
	                	['7', 'Product Title8'],
	                	['8', 'Product Title9'],
	                	['9', 'Product Title10'],
	                	['10', 'Product Title11']
	               ];*/
	
	//----------------------------------------
	// data table for users
	//----------------------------------------
	var $table = $('#productListTable'); 
	
	// execute the code below ony if the table exist
	if($table.length) {
		
		var jsonUrl = '';
		
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products'; 
		}
		
		$table.DataTable( {
			
			lengthMenu: [[5, 10, 15, 10, -1], ['5 Records', '10 Records', '15 Records', '20 Records', 'All Records']],
			pageLength: 10,
			//data: products //user for dataset
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			          {
			        	  data: 'code',
			        	  mRender: function(data, type, row) {
			        		  var img = '<img src="'+ window.images +'/'+ data +'.jpg" class="dataTableImg"/>';
			        		  
			        		  return img;
			        	  }
			          },
			          {
			        	  data: 'name'
			          },
			          {
			        	  data: 'brand'
			          },
			          {
			        	  data: 'unitPrice',
			        	  mRender: function(data, type, row) {
			        		  return '&#x20A6;' + data
			        	  }
			          },
			          {
			        	  data: 'quantity',
			        	  mRender: function(data, type, row) {
			        		  if (data < 1) {
			        			  return '<span style="color: red;">Out of Stock!</span>';
			        		  } 
			        		  
			        		  return data;
			        	  }
			          },
			          {
			        	  data: 'id',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  var str = '';
			        		  str += '<a href="'+ window.contextRoot +'/show/'+ data +'/product" class="btn btn-primary"><span class="fa fa-eye"></span></a>&#160;';
			        		  
			        		  if(row.quantity < 1)
			        			  str += '<a href="javascript:void(0" class="btn btn-danger disabled"><span class="fa fa-shopping-cart"></span></a>';
			        		  else
			        			  str += '<a href="'+ window.contextRoot +'/cart/add/'+ data +'/product" class="btn btn-success"><span class="fa fa-shopping-cart"></span></a>';
			        			  
			        		  return str;
			        	  }
			          }
			         ]
		});
	}
	
	// dismiss the alert after 5 seconds
	var $alert = $('.alert');
	
	if ($alert.length) { 
		setTimeout(function () {
			$alert.fadeOut('slow');
		}, 3000);
	}
	
	// Modal for activating and deactivating of products
	/*$('.switch input[type="checkbox"]').on('change', function () {
		
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var modalMsg = (checked) ? 
				'Do you want to ACTIVATE the product?' : 
				'Do you want to DEACTIVATE the product?';
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size: 'mdeium',
			title: 'Enable/Disable Product',
			message: modalMsg,
			callback: function (confirmed) {
				
				if (confirmed) {
					
					console.log(value);
					bootbox.alert({
						size: 'medium',
						title: 'Information',
						message: 'You are going to perform an operation on product '+ value
					});
					
				} else {
					checkbox.prop('checked', !checked);
				}
			}
		});
	});*/
	
	
	//-----------------------------------
	// data table for admin
	//-----------------------------------
	var $adminProductsTable = $('#adminProductsTable'); 
	
	// execute the code below ony if the table exist
	if($adminProductsTable.length) {
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		$adminProductsTable.DataTable( {
			
			lengthMenu: [[10, 30, 50, -1], ['10 Records', '30 Records', '50 Records', 'All Records']],
			pageLength: 30,
			//data: products //user for dataset
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			          
			          {
			        	  data: 'id'
			          },
			          {
			        	  data: 'code',
			        	  mRender: function(data, type, row) {
			        		  var img = '<img src="'+ window.images +'/'+ data +'.jpg" class="dataTableImg"/>';
			        		  
			        		  return img;
			        	  }
			          },
			          {
			        	  data: 'name'
			          },
			          {
			        	  data: 'brand'
			          },			          
			          {
			        	  data: 'quantity',
			        	  mRender: function(data, type, row) {
			        		  if (data < 1) {
			        			  return '<span style="color: red;">Out of Stock!</span>';
			        		  } 
			        		  
			        		  return data;
			        	  }
			          },
			          {
			        	  data: 'unitPrice',
			        	  mRender: function(data, type, row) {
			        		  return '&#x20A6;' + data
			        	  }
			          },
			          {
			        	  data: 'active',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  
			        		  var str = '';
			        		  
			        		  str += '<label class="switch">';
			        		  if (data) {
			        			  str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
			        		  } else {
			        			  str += '<input type="checkbox" value="'+row.id+'" />';
			        		  }
			        		  str += '<div class="slider"></div>';
			        		  str += '</label>';
			        		  
			        		  return str;
			        	  }
			          },
			          {
			        	  data: 'id',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  
			        		  var str = '';
			        		  
			        		  str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
			        		  str += '<span class="fa fa-pencil"></span></a>';
			        		  
			        		  return str;
			        	  }
			          }
			          
			         ],
			         
			         initComplete: function () {
			        	 
			        	 var api = this.api();
			        	 api.$('.switch input[type="checkbox"]').on('change', function () {
			        			
			        			var checkbox = $(this);
			        			var checked = checkbox.prop('checked');
			        			var modalMsg = (checked) ? 
			        					'Do you want to ACTIVATE the product?' : 
			        					'Do you want to DEACTIVATE the product?';
			        			var value = checkbox.prop('value');
			        			
			        			bootbox.confirm({
			        				size: 'mdeium',
			        				title: 'Enable/Disable Product',
			        				message: modalMsg,
			        				callback: function (confirmed) {
			        					
			        					if (confirmed) {
			        						
			        						console.log(value);
			        						
			        						var productActivationUrl = window.contextRoot + '/manage/product/'+value+'/activation';
			        						
			        						$.post(productActivationUrl, function (data) {
			        							bootbox.alert({
				        							size: 'medium',
				        							title: 'Information',
				        							message: data
				        						});
			        						});
			        						
			        					} else {
			        						checkbox.prop('checked', !checked);
			        					}
			        				}
			        			});
			        		});
			         }
		});
	}
	//-----------------------------------
	
})