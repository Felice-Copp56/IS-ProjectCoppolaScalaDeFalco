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
														<table class="table table-borderless">
															<thead>
																<tr>
																	<th scope="col">Numero
																		tavolo</th>
																	<th scope="col">Data</th>
																	<th scope="col">Ora inizio</th>
																	<th scope="col">Ora fine</th>
																	<th scope="col"></th>
																	<th scope="col"></th>
																</tr>
															</thead>
															<tbody>
																<%
																	ArrayList<PrenotazioneBean> prenotazioni = (ArrayList<PrenotazioneBean>) request
																			.getAttribute("prenotazioni");
																	for (PrenotazioneBean p : prenotazioni) {
																%>
																<tr >
																	<td c><%=p.getNumTavolo()%></td>
																	<td><%=p.getData()%></td>
																	<td><%=p.getOraInizio()%></td>
																	<td><%=p.getOraFine()%></td>
																	<td><a href="ModificaPrenotazione" class="text-decoration-none text-danger"><i class="material-icons"> edit </i></a>
																	</button></td>
																	<td><a href="RimuoviPrenotazione?nt=<%=p.getNumTavolo() %>&d=<%=p.getData() %>&t1=<%=p.getOraInizio().toString() %>&t2=<%=p.getOraFine().toString() %>" class="text-decoration-none text-danger" ><i class="material-icons"> cancel </i></a>
																	</button></td>
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