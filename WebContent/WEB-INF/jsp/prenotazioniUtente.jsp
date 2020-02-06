<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerUtente.jsp">
	<jsp:param value="" name="" />
</jsp:include>

<div id="layoutSidenav_content">
	<div class="container-fluid">
		<h1 class="mt-4">Le mie prenotazioni</h1>
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
																		style="width: 110.006px;" aria-sort="ascending">Numero tavolo</th>
																	<th class="sorting" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Position: activate to sort column ascending"
																		style="width: 132.006px;">Data</th>
																	<th class="sorting" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Office: activate to sort column ascending"
																		style="width: 104.006px;">Ora inizio</th>
																	<th class="sorting" tabindex="0"
																		aria-controls="dataTable" rowspan="1" colspan="1"
																		aria-label="Age: activate to sort column ascending"
																		style="width: 78.0057px;">Ora fine</th>
																</tr>
															</thead>
															<tbody>
															<%ArrayList<PrenotazioneBean> prenotazioni = (ArrayList<PrenotazioneBean>)request.getAttribute("prenotazioni");
															for(PrenotazioneBean p : prenotazioni) {%>
																<tr role="row" class="odd">
																	<td class="sorting_1"><%=p.getNumTavolo() %></td>
																	<td><%=p.getData() %></td>
																	<td><%=p.getOraInizio() %></td>
																	<td><%=p.getOraFine() %></td>
																</tr>
																<%} %>
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