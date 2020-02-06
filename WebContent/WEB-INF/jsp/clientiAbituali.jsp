<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerTitolare.jsp">
	<jsp:param value="" name="" />
</jsp:include>

<div id="layoutSidenav_content">
	<div class="container-fluid">
		<h1 class="mt-4">Clienti abituali</h1>
		<div class="card mb-4">

			<div class="card-body">
				<div class="table-responsive">
					<div id="dataTable_wrapper"
						class="dataTables_wrapper dt-bootstrap4">
						<div class="row">
							<div class="col-sm-12">
								<div id="dataTable_wrapper"
									class="dataTables_wrapper dt-bootstrap4">
									<div class="row">
										<div class="col-sm-12">

											
											<div id="dataTable_wrapper"
												class="dataTables_wrapper dt-bootstrap4 no-footer">
												<div class="row">
													<div class="col-sm-12">
														<table class="table table-bordered dataTable no-footer"
															id="dataTable" width="100%" cellspacing="0" role="grid"
															aria-describedby="dataTable_info" style="width: 100%;">
															<thead>
																<tr role="row">
																	<th class="sorting_asc" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Name: activate to sort column descending"
																		style="width: 110.006px;" aria-sort="ascending">Name</th>
																	<th class="sorting" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Position: activate to sort column ascending"
																		style="width: 132.006px;">Position</th>
																	<th class="sorting" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Office: activate to sort column ascending"
																		style="width: 104.006px;">Office</th>
																	<th class="sorting" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Age: activate to sort column ascending"
																		style="width: 78.0057px;">Age</th>
																	<th class="sorting" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Start date: activate to sort column ascending"
																		style="width: 150.006px;">Start date</th>
																	<th class="sorting" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Salary: activate to sort column ascending"
																		style="width: 82px;">Salary</th>
																</tr>
															</thead>
															<tbody>
															ripetere per ogni entry
																<tr role="row" class="odd">
																	<td class="sorting_1">Airi Satou</td>
																	<td>Accountant</td>
																	<td>Tokyo</td>
																	<td>33</td>
																	<td>2008/11/28</td>
																	<td>$162,700</td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp">
	<jsp:param value="" name="" />
</jsp:include>