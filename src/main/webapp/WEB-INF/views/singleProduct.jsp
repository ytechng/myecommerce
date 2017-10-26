<div class="container">
	<div class="row">

		<!-- single product -->
		<div class="col-md-12">

			<!-- breadcrumb component -->
			<div class="row">
				<div class="col-xs-12">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item"><a
							href="${contextRoot}/show/all/products">Products</a></li>
						<li class="breadcrumb-item active">${product.name}</li>
					</ol>
				</div>
			</div>
			<!-- /breadcrumb component -->


			<div class="row">
				<!-- Display product image -->
				<div class="col-md-4">
					<div class="thumnail">
						<img src="${images}/products/${product.code}.jpg"
							class="img-fluid img-thumbnail" />
					</div>
				</div>

				<!-- Display product contents -->
				<div class="col-md-8">

					<h3>${product.name}</h3>
					<hr />

					<p>${product.description}
					<hr />

					<h4>
						Price: <strong>&#x20A6; ${product.unitPrice} /-</strong>
					</h4>
					<hr />

					<security:authorize access="hasAuthority('user')">
						<c:choose>
							<c:when test="${product.quantity < 1}">
								<h6>
									Qty Available: <span style="color: red;">Out of Stock!</span>
								</h6>
								
								<a href="javascript:void(0)" class="btn btn-danger disabled"> 
									<strike><span class="fa fa-shopping-cart"></span> Add to Cart</strike>
								</a>
							</c:when>
							<c:otherwise>
								<h6>Qty. In Stock: ${product.quantity}</h6>
	
								<a href="${contextRoot}/cart/add/${product.id}/product"
									class="btn btn-success"> <span class="fa fa-shopping-cart"></span>
									Add to Cart
								</a>
							</c:otherwise>
						</c:choose>
					</security:authorize>
					
					<security:authorize access="hasAuthority('admin')">
						<a href="${contextRoot}/manage/${product.id}/product"
							class="btn btn-warning"><span class="fa fa-pencil"></span> 
							Edit
						</a>
					</security:authorize>

					<a href="${contextRoot}/show/all/products" class="btn btn-link">
						<span class="fa fa-chevron-left"></span> Back to Products
					</a>

				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /products -->

	</div>
</div>