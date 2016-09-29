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
                                    <th>Adresa</th>
                                    <th>Izmena</th>
                                    <th>Obriši</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!--Iteriramo kroz listu clanova koju smo prethodno u BioskopServletu-u
                                smestili u atribut "clanovi" request objekta.
                                Za svaki od elemenata u listi dodaje se novi *tr* HTML element
                                i odgovarajuci *td* HTML elementi.-->
                                <c:forEach items="${bioskopi}" var="bioskop">
                                    <tr>
                                        <td>${bioskop.idBioskop}</td>
                                        <td>${bioskop.naziv}</td>
                                        <td>${bioskop.adresa}</td>

                                        <!--Dugme/link za azuriranje podataka o clanu.
                                        Kada se klikne na njega Bootstrap ce prikazati modalni prozor ciji je id modal-clan-edit.
                                        Takodje, kada se klikne na njega poziva se JavaScritp funkcija popuniEditFormu kako
                                        bi se podaci u edit formi popunili pre nego sto se prikaze.
                                        -->
                                        <td>
                                            <a class="btn btn-block btn-info" data-toggle="modal"
                                               data-target="#modal-bioskop-edit" 
                                               onclick="popuniEditFormu('${bioskop.idBioskop}', '${bioskop.naziv}', '${bioskop.adresa}');">
                                                Izmeni..</a>
                                        </td>

                                        <!--Dugme/link za brisanje clana.
                                        Funkcionise na istom principu kao i edit dugme.-->
                                        <td>
                                            <a class="btn btn-block btn-danger" data-toggle="modal"
                                               data-target="#modal-bioskop-delete" 
                                               onclick="popuniDeleteFormu('${bioskop.idBioskop}');">
                                                Obriši..</a>
                                        </td>
                                    </tr>  
                                </c:forEach>
                            </tbody>
                        </table>
                        <!--Dugme/link za dodavanje novog clana.
                        Kada se klikne na njega Bootstrap ce prikazati modalni prozor ciji je id modal-clan-add.-->
                        <a class="btn btn-success pull-right" data-toggle="modal"
                           data-target="#modal-bioskop-add">Novi bioskop</a>
                        </br></br></br>
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
        <div class="modal fade" id="modal-bioskop-add">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Unesite podatke o bioskopu</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form" action="bioskop" method="POST">
                            <input type="hidden" name="action" value="add" />

                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="naziv" class="control-label">Naziv</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="naziv" placeholder="Naziv" name="naziv">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="adresa" class="control-label">Adresa</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="adresa" placeholder="Adresa" name="adresa">
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
        <div class="modal fade" id="modal-bioskop-edit">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Izmenite podatke o bioskopu</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form" action="bioskop" method="POST">

                            <input type="hidden" name="action" value="edit" />
                            <input type="hidden" id="idBioskop-edit" name="idBioskop" value="" />

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
                                    <label for="adresa" class="control-label">Prezime</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="adresa-edit" value="" name="adresa">
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
        <div class="modal fade" id="modal-bioskop-delete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Izbrišite bioskop</h4>

                        <form class="" role="form" action="bioskop" method="POST">
                            <input type="hidden" name="action" value="delete" />

                            <input type="hidden" id="idBioskop-delete" name="idBioskop" value="" />

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
                function popuniEditFormu(idBioskop, naziv, adresa) {
                    /*
                     * Postavljamo vrednosti forme u edit modalnom prozoru.
                     */
                    document.getElementById("idBioskop-edit").value = idBioskop;
                    document.getElementById("naziv-edit").value = naziv;
                    document.getElementById("adresa-edit").value = adresa;
                }

                //Funkcija uzima dobijeni parametar i postavlja ga kao vrednost skrivenog input elementa pkclan-delete u delete formi.
                function popuniDeleteFormu(idBioskop) {
                    /*
                     * Postavljamo vrednosti forme u delete modalnom prozoru.
                     */
                    document.getElementById("idBioskop-delete").value = idBioskop;
                }
            </script>
    </body>
</html>
