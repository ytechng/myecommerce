<div class="modal fade" id="categoryModal" role="dialog" tabindex="-1" aria-hidden="true">
	
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
				<h4 class="modal-title">Add New Category</h4>
			</div>
			<div class="modal-body">
				<!-- Category Form -->
				<html:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
					<div class="form-group">
						<html:input type="text" path="name" id="category_name" placeholder="Category Name" class="form-control"/>
					</div>
					<div class="form-group">
						<html:textarea type="text" path="description" id="category_description" rows="4" placeholder="Enter category description" class="form-control"/>
					</div>
					<div class="form-group text-right">
						<button class="btn btn-info" type="submit">Add Category</button>
					</div>
				</html:form>
			</div>
			<div class="modal-footer">
				<button data-dismiss="modal" class="btn btn-danger" type="button">Close</button>
			</div>
		</div>
	</div>
	
</div>