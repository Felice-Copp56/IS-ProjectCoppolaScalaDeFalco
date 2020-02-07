<%@ page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="headerTitolare.jsp">
	<jsp:param value="" name="" />
</jsp:include>

<div id="layoutSidenav_content">
	<div class="container-fluid">
		<h1 class="mt-4">Prenotazioni</h1>
		<div class="card mb-4">

			<div class="card-body">
				<div class="table-responsive">
					<div id="dataTable_wrapper"
						class="dataTables_wrapper dt-bootstrap4">
						<div class="row">
							<div class="col-sm-12">
								<div id="dataTable_wrapper"
									class="dataTables_wrapper dt-bootstrap4">
									<div class="row p-4">
										<div class="col-sm-12">

											
											<div id="dataTable_wrapper"
												class="dataTables_wrapper dt-bootstrap4 no-footer">
												<div class="row">
													<div class="col-sm-12">
													<table class="table">
															<thead>
																<tr>
																	<th scope="col">Username</th>
																	<th scope="col">N° tavolo</th>
																	<th scope="col">Data</th>
																	<th scope="col">Fascia oraria</th>
																</tr>
															</thead>
															<tbody>
																
																<%ArrayList<PrenotazioneBean> ps = (ArrayList<PrenotazioneBean>)request.getAttribute("ps");
																for(PrenotazioneBean p:ps){%>
																
																<tr>
																	<td class="sorting_1"><%=p.getUsername() %></td>
																	<td><%=p.getNumTavolo()%></td>
																	<td><%=p.getData().toString()%></td>
																	<td><%=p.getOraInizio().toString()+"/"+p.getOraFine().toString()%></td>
																</tr>
																<%
																	}
																%>
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