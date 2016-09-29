
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

    <%@include file="/WEB-INF/jspf/header.jspf" %>

    <body>

        </br>

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
                                    <th>Sala</th>
                                    <th>Film</th>
                                    <th>Termin projekcije</th>
                                    <th>Ukloni</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${projekcije}" var="projekcija">
                                    <tr>
                                        <td id="td_${projekcija.idProjekcija}">${projekcija.idProjekcija}</td>
                                        <td id="td_sala_${projekcija.fk_Sala.idSala}">${projekcija.fk_Sala.br_sale}</td>
                                        <td id="td_film_${projekcija.fk_Film.idFilm}">${projekcija.fk_Film.naziv}</td>
                                        <td id="td_termin_projekcije_${projekcija.termin_projekcije}">${projekcija.termin_projekcije}</td>
                                        <td>
                                            <a class="btn btn-block btn-info" data-toggle="modal"
                                               data-target="#modal-ukloni-delete" onclick="fillFields('${projekcija.idProjekcija}', '${projekcija.fk_Sala.idSala}', 'delete');" >Ukloni</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Dodaj projekciju</h3>
                            </div>
                            <div class="panel-body">
                                <form class="form-horizontal" role="form" action="projekcija" method="POST">
                                    <input type="hidden" name="action" value="add" />
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label for="inputPassword3" class="control-label">Sala</label>
                                        </div>
                                        <div class="col-sm-10">
                                            <select name="fk_Sala" class="form-control" id="sel2">
                                                <c:forEach items="${projekcije}" var="projekcija">
                                                    <option value="${projekcija.fk_Sala.idSala}">${projekcija.fk_Sala.br_sale}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label for="film" class="control-label">Film</label>
                                        </div>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="film" placeholder="Naziv filma" name="film">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label for="termin_projekcije" class="control-label">Termin projekcije</label>
                                        </div>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="termin_projekcije" placeholder="YYYY-MM-DD HH:MM:SS" name="termin_projekcije">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-info">Dodaj</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
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
        </div>

        <!-- modal  -->
        <div class="modal fade" id="modal-ukloni-delete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Uklonite projekciju</h4>

                        <form class="" role="form" action="projekcija" method="POST">
                            <input type="hidden" name="action" value="delete" />
                            <input type="hidden" id="idProjekcija-delete" name="idProjekcija" value="" />
                            <input type="hidden" id="fk_Sala-delete" name="fk_Sala" value="" />

                            <div class="modal-footer">
                                <a class="btn btn-default" data-dismiss="modal">Zatvori</a>

                                <button type="submit" class="btn btn-primary">Ukloni</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <script>
                function fillFields(idProjekcija, fk_Sala, action) {
                    $("#idProjekcija-" + action).val(idProjekcija);
                    $("#fk_Sala-" + action).val(fk_Sala);
                }
            </script>

    </body>
</html>
