<div class="container">

	<!-- check if cart line is not empty -->
	<c:choose>
		
		<c:when test="${not empty cartLines}">
			<!-- not empty display carLines -->
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartLines}" var="cartLine">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="${images}/products/${cartLine.product.code}.jpg" alt="${cartLine.product.name}"
											class="img-fluid img-thumbnail cartImg" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">
											${cartLine.product.name} 
											<c:if test="${cartLine.available == false}">
												<strong class="unavailable">(Not available)</strong>
											</c:if>
										</h4>
										<p>Brand - ${cartLine.product.brand}</p>
										<p>Description - ${cartLine.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">&#x20A6; ${cartLine.buyingPrice}</td>
							<td data-th="Quantity">
								<input type="number" id="count_${cartLine.id}" min="1" max="10" 
									class="form-control text-center" value="${cartLine.productCount}">
							</td>
							<td data-th="Subtotal" class="text-center">&#x20A6; ${cartLine.total}</td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm" type="button" name="btnRefreshCart" value="${cartLine.id}">
									<i class="fa fa-refresh"></i>
								</button>
								<button class="btn btn-danger btn-sm" type="button" name="btnDeleteCart" value="${cartLine.id}">
									<i class="fa fa-trash-o"></i>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="hidden-md-up">
						<td class="text-center">
							<strong>Total &#x20A6; ${userModel.cart.grandTotal}</strong>
						</td>
					</tr>
					<tr>
						<td>
							<a href="#" class="btn btn-warning">
								<i class="fa fa-angle-left"></i> Continue Shopping
							</a>
						</td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total &#x20A6; ${userModel.cart.grandTotal}</strong></td>
						<td>
							<a href="#" class="btn btn-success btn-block">
								Checkout <i class="fa fa-angle-right"></i>
							</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</c:when>
		
		<c:otherwise>
			<!-- empty display message -->
			<div class="jumbotron">
				<div class="text-center">
					<h1>Your cart is empty</h1>
				</div>
			</div>
		</c:otherwise>
		
	</c:choose>

</div>