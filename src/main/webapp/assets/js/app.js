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
	
	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0) {
		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}
	
	//----------------------------------------
	// code for jQuery dataTable
	//----------------------------------------
	var $table = $('#productListTable'); 
	
	// execute the code below only if the table exist
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
			        		  
			        		  if(row.quantity < 1 && userRole != 'admin')
			        			  str += '<a href="javascript:void(0" class="btn btn-danger disabled"><span class="fa fa-shopping-cart"></span></a>';
			        		  else
			        			  if (userRole == 'admin') {
			        				  str += '<a href="'+ window.contextRoot +'/manage/'+ data +'/product" class="btn btn-warning"><span class="fa fa-pencil"></span></a>';
			        			  }
			        			  else {
			        				  str += '<a href="'+ window.contextRoot +'/cart/add/'+ data +'/product" class="btn btn-success"><span class="fa fa-shopping-cart"></span></a>';
			        			  }
			        			  
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
			
			lengthMenu: [[5, 10, 20, 50, -1], ['5 Records','10 Records', '15 Records', '20 Records', 'All Records']],
			pageLength: 10,
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
	
	//------Validation for category form ----//
	
	var $categoryForm = $('#categoryForm');
	
	if ($categoryForm.length) {
		
		$categoryForm.validate({
			rules: {
				name: {
					required: true,
					minlength: 2
				},
				
				description: {
					required: true
				}	
			},
			
			messages: {
				name: {
					required: 'Please enter the category name!',
					minLength: 'Category name should not be less than 2 characters!'
				},
				
				description: {
					required: 'Please enter category description!'
				}
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				
				error.insertAfter(element);
			}
		});
	}
	//------ end category form validation --//
	
	
//------Validation for product form ----//
	
	var $productForm = $('#productForm');
	
	if ($productForm.length) {
		
		$productForm.validate({
			rules: {
				name: {
					required: true,
					minlength: 2
				},
				
				brand: {
					required: true,
					minlength: 2
				},
				
				description: {
					required: true,
				},
				
				unitPrice: {
					required: true
				},
				
				quantity: {
					required: true,
					number: true
				},
				
				file: {
					require: true
				}
			},
			
			messages: {
				name: {
					required: 'Please enter the product name!',
					minlength: 'Product name should not be less than 2 characters!'
				},
				
				brand: {
					required: 'Please enter product description!',
					minlength: 'Product brand should not be less than 2 characters!'
				},
				
				description: {
					required: 'Please enter product description!'
				},
				
				unitPrice: {
					required: 'Please enter the product unit price!'
				},
				
				quantity: {
					required: 'Please enter quantity of the product!',
					number: 'Quantity can only be a number!'
				},
				
				file: {
					required: 'Please select an image file to upload!'
				}
				
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				
				error.insertAfter(element);
			}
		});
	}
	//------ end product form validation --//
	
	
	//------Validation for category form ----//	
	var $loginForm = $('#frmLogin');
	
	if ($loginForm.length) {
		
		$loginForm.validate({
			rules: {
				username: {
					required: true,
					email: true
				},
				
				password: {
					required: true
				}	
			},
			
			messages: {
				username: {
					required: 'Please enter the username!',
					email: 'Please enter a valid email address!'
				},
				
				password: {
					required: 'Please enter the password!'
				}
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				
				error.insertAfter(element);
			}
		});
	}
	//------ end category form validation --//
	
})