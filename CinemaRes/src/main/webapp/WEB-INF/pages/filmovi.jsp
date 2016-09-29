<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                    <th>Naziv</th>
                                    <th>Zanr</th>
                                    <th>Izmena</th>
                                    <th>Obriši</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${filmovi}" var="film">
                                    <tr>
                                        <td>${film.idFilm}</td>
                                        <td>${film.naziv}</td>
                                        <td>${film.zanr}</td>


                                        <td>
                                            <a class="btn btn-block btn-info" data-toggle="modal"
                                               data-target="#modal-film-edit" 
                                               onclick="popuniEditFormu('${film.idFilm}', '${film.naziv}', '${film.zanr}');">
                                                Izmeni..</a>
                                        </td>


                                        <td>
                                            <a class="btn btn-block btn-danger" data-toggle="modal"
                                               data-target="#modal-film-delete" 
                                               onclick="popuniDeleteFormu('${film.idFilm}');">
                                                Obriši..</a>
                                        </td>
                                    </tr>  
                                </c:forEach>
                            </tbody>
                        </table>

                        <a class="btn btn-success pull-right" data-toggle="modal"
                           data-target="#modal-film-add">Novi Film..</a>
                        </br>
                        </br>
                        </br>
                        <div class="row">
                            <div class="col-md-12">
                                <a class="btn btn-primary pull-right" href="pocetna.jsp">Povratak na pocetnu</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modalni prozor za dodavanje novog clana. -->
        <div class="modal fade" id="modal-film-add">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Unesite podatke o filmu</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form" action="film" method="POST">
                            <input type="hidden" name="action" value="add" />

                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="naziv" class="control-label">Naziv</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="naziv" placeholder="naziv" name="naziv">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="zanr" class="control-label">Zanr</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="zanr" placeholder="zanr" name="zanr">
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

        <!-- Modalni prozor za azuriranje podataka o clanu. -->
        <div class="modal fade" id="modal-film-edit">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Izmenite podatke o filmu</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form" action="film" method="POST">

                            <input type="hidden" name="action" value="edit" />
                            <input type="hidden" id="idFilm-edit" name="idFilm" value="" />

                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="naziv" class="control-label">Naziv</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="naziv-edit" value="" name="naziv">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="zanr" class="control-label">Zanr</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="zanr-edit" value="" name="zanr">
                                </div>
                            </div>

                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-default" data-dismiss="modal">Zatvori</a>

                        <button type="submit" class="btn btn-primary">Izmeni</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modalni prozor za brisanje clana -->
        <div class="modal fade" id="modal-film-delete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Izbrišite film</h4>

                        <form class="" role="form" action="film" method="POST">
                            <input type="hidden" name="action" value="delete" />

                            <input type="hidden" id="idFilm-delete" name="idFilm" value="" />

                            <div class="modal-footer">
                                <a class="btn btn-default" data-dismiss="modal">Zatvori</a>

                                <button type="submit" class="btn btn-primary">Obriši</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <script>
                //Funkcija uzima dobijene parametre i postavlja ih kao vrednosti input elemenata edit forme.
                function popuniEditFormu(idFilm, naziv, zanr) {
                    /*
                     * Postavljamo vrednosti forme u edit modalnom prozoru.
                     */
                    document.getElementById("idFilm-edit").value = idFilm;
                    document.getElementById("naziv-edit").value = naziv;
                    document.getElementById("zanr-edit").value = zanr;
                }

                //Funkcija uzima dobijeni parametar i postavlja ga kao vrednost skrivenog input elementa pkclan-delete u delete formi.
                function popuniDeleteFormu(idFilm) {
                    /*
                     * Postavljamo vrednosti forme u delete modalnom prozoru.
                     */
                    document.getElementById("idFilm-delete").value = idFilm;
                }
            </script>
    </body>
</html>
