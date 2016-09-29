<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
   
        <%@include file="/WEB-INF/jspf/header.jspf" %>
    
    <body>
        
        
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12"></div>
                </div>

                <%@include file="../jspf/messages.jspf" %>

                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Bioskop</th>
                                    <th>Broj sale</th>
                                    <th>Broj sedista u sali</th>
                                    <th>Ukloni</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${sale}" var="sala">
                                    <tr>
                                        <td id="td_${sala.idSala}">${sala.idSala}</td>
                                        <td id="td_naziv_${sala.fk_Bioskop.naziv}">${sala.fk_Bioskop.naziv} </td>

                                        <td id="td_br_sale_${sala.br_sale}">${sala.br_sale}</td>
                                        <td id="td_br_sedista_${sala.br_sedista}">${sala.br_sedista}</td>
                                        <td>
                                            <a class="btn btn-block btn-info" data-toggle="modal"
                                               data-target="#modal-ukloni-delete" onclick="fillFields('${sala.idSala}', '${sala.fk_Bioskop.idBioskop}', 'delete');" >Ukloni</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <a class="btn btn-success pull-right" data-toggle="modal"
                           data-target="#modal-film-add">Nova Sala</a>
                    </div>
                </div>
                </br>
                <div class="row">
                    <div class="col-md-12">
                        <a class="btn btn-primary pull-right" href="pocetna.jsp">Povratak na pocetnu</a>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- modal dodaj -->        
        <div class="modal fade" id="modal-film-add">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Unesite podatke o salis</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form" action="sala" method="POST">
                            <input type="hidden" name="action" value="add" />

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Bioskop</label>
                                <div class="col-sm-10 selectContainer">
                                    <select class="form-control" name="fk_Bioskop">
                                        <c:forEach items="${sale}" var="sala">
                                            <option value="${sala.fk_Bioskop.idBioskop}">${sala.fk_Bioskop.naziv}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="br_sale" class="control-label">Broj sedista:</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="br_sale" placeholder="br_sedista" name="br_sale">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="br_sedista" class="control-label">Broj sale:</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="br_sedista" placeholder="br_sale" name="br_sedista">
                                </div>
                            </div>

                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-default" data-dismiss="modal">Zatvori</a>

                        <button type="submit" class="btn btn-primary">Dodaj</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- modal rezduzi -->
        <div class="modal fade" id="modal-ukloni-delete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Uklonite salu</h4>

                        <form class="" role="form" action="sala" method="POST">
                            <input type="hidden" name="action" value="delete" />
                            <input type="hidden" id="idSala-delete" name="idSala" value="" />
                            <input type="hidden" id="fk_Bioskop-delete" name="fk_Bioskop" value="" />

                            <div class="modal-footer">
                                <a class="btn btn-default" data-dismiss="modal">Zatvori</a>

                                <button type="submit" class="btn btn-primary">Ukloni</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <script>
                function fillFields(idSala, fk_Bioskop, action) {
                    $("#idSala-" + action).val(idSala);
                    $("#fk_Bioskop-" + action).val(fk_Bioskop);
                }
            </script>
        
    </body>
</html>
