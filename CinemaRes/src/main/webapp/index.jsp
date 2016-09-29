<!DOCTYPE html>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <%@include file="/WEB-INF/jspf/header.jspf" %>

    <body>

        <%@include file="/WEB-INF/jspf/navbar.jspf" %>

        <section id="intro" class="intro-section ispravka" style="background-image : url('https://i.ytimg.com/vi/TirVCqYdBm0/maxresdefault.jpg')">

            <div class="container" >
                <div class="row">
                    <div class="col-lg-12">


                        <!-- Ubacen BXSlider-->
                        <div id="wrapper_slider" class="responsive" style="width: 800px; height: 600px;">
                            <div class="bxslider responsive" id="carusel_wrapperr">
                                <li><img src="http://moviehole.net/img/maxresdefault-405.jpg" class="img-responsive"/></li>
                                <li><img src="http://www.wpaperhd.com/uploads/originals/2016/01/29/suicide-squad-2016-poster-B1Pk.jpg" class="img-responsive"/></li>
                                <li><img src="http://i2.wp.com/bitcast-a-sm.bitgravity.com/slashfilm/wp/wp-content/images/JB_Triptych_1-Sht_Full_Online_v4_rev_lg.jpg" class="img-responsive"/></li>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Rezerviši kartu Section -->
    <section id="rezervacija" class="about-section ispravka">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1>Rezerviši kartu</h1>
                    <br>
                    <h4>Ovde možete da rezervišete Vašu kartu u svega <strong>par koraka</strong>:</h4>
                    <br>
                    <div class="section">
                        <div class="container">
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Bioskop</label>
                                <div class="col-xs-5 selectContainer">
                                    <select class="form-control" name="bioskop">
                                        <c:forEach items="${bioskopi}" var="bioskop">
                                            <option value="${bioskop.idBioskop}">${bioskop.naziv}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div></br></br>

                            <div class="form-group">
                                <label class="col-xs-3 control-label">Film</label>
                                <div class="col-xs-5 selectContainer">
                                    <select class="form-control" name="size">
                                        <option value="">Choose a size</option>
                                        <option value="s">Small (S)</option>
                                        <option value="m">Medium (M)</option>
                                        <option value="l">Large (L)</option>
                                        <option value="xl">Extra large (XL)</option>
                                    </select>
                                </div>
                            </div></br></br>
                            <div class="form-group">
                                <label class="col-xs-3 control-label">Projekcija</label>
                                <div class="col-xs-5 selectContainer">
                                    <select class="form-control" name="size">
                                        <option value="">Choose a size</option>
                                        <option value="s">Small (S)</option>
                                        <option value="m">Medium (M)</option>
                                        <option value="l">Large (L)</option>
                                        <option value="xl">Extra large (XL)</option>
                                    </select>
                                </div>
                            </div>
                            </br></br></br>
                            <a href="rezervacija.jsp" class="btn btn-info" role="button">Dalje</a>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>

</section>

<!-- Filmovi Section -->
<section id="filmovi" class="services-section responsive">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1>Filmovi</h1>
                <br>
            </div>
            <div class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <ul class="nav nav-pills" id="filmovi_pregled">
                                <li class="active">
                                    <a href="#filmovi" >Top Filmovi</a>
                                </li>
                                <li class="">
                                    <a href="#filmovi" >U bioskopima</a>
                                </li>
                                <li class="">
                                    <a href="#filmovi" >Uskoro</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="container" id="top-filmovi" >
                            <h2>TOP FILMOVI</h2>
                            <div class="row">
                                <div class="col-md-3 responsive">
                                    <img src="http://cdn.movieweb.com/img.site/PHPXPnMD6JavTU_1_l.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">X-MEN: APOKALIPSA</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt3385516/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2495768522&pf_rd_r=10EFA977WV80BGZWX0V9&pf_rd_s=right-7&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_cht_t1" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="http://pop.inquirer.net/files/2016/04/MM-Cannes.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">IGRA NOVCA</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt2241351/?ref_=fn_al_tt_1" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="http://i1.wp.com/www.heyuguys.com/images/2016/03/Warcraft-Poster.jpg?resize=1024%2C768"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">WARCRAFT: POČETAK</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt0803096/?ref_=nv_sr_1" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="http://empireonline.media/jpg/50/0/0/640/480/aspectfit/0/0/0/0/0/0/c/articles/5710c284b602bb802e2099c0/Angry-Birds-final-quad.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">ANGRY BIRDS FILM</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt1985949/?ref_=nv_sr_1" class="pull-left">Detaljnije</a></p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="container hide" id="u-bioskopima" >
                            <h2>U BIOSKOPIMA</h2>
                            <div class="row">
                                <div class="col-md-3 responsive">
                                    <img src="http://www.flickeringmyth.com/wp-content/uploads/2016/04/captain-america-civil-war-poster.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">KAPETAN AMERIKA - GRAĐANSKI RAT</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt3498820/?ref_=nv_sr_1" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="http://cdn.traileraddict.com/content/universal-pictures/neighbors2-2.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">LOŠE KOMŠIJE 2</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt4438848/?ref_=nv_sr_1" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="http://static1.squarespace.com/static/53323bb4e4b0cebc6a28ffa2/t/56632858e4b0288a6979db71/1449338970734/?format=750w"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">DOBRI MOMCI</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt3799694/?ref_=fn_al_tt_1" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="https://i.ytimg.com/vi/d0KqBcSweO8/maxresdefault.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">IZDAJNIK PO NAŠEM UKUSU</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt1995390/?ref_=fn_al_tt_1" class="pull-left">Detaljnije</a></p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="container hide" id="uskoro" >
                            <h2>USKORO</h2>
                            <div class="row">
                                <div class="col-md-3 responsive">
                                    <img src="http://www.ramascreen.com/wp-content/uploads/2016/01/The-Conjuring-2-e1452201546280.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">PRIZIVANJE ZLA 2</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt3065204/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2495768482&pf_rd_r=06588XE3QA60MHNHFK6Z&pf_rd_s=right-4&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_t0" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="http://www.tiempodesanjuan.com/u/fotografias/m/2016/4/19/f620x0-276542_276560_7.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">VELIKA ILUZIJA 2</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt3110958/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2495768482&pf_rd_r=06588XE3QA60MHNHFK6Z&pf_rd_s=right-4&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_t1" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="http://cdn1-www.comingsoon.net/assets/uploads/gallery/central-intelligence/poster2.jpg"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">OBAVEŠTAJCI</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt1489889/?ref_=nv_sr_1" class="pull-left">Detaljnije</a></p>
                                </div>
                                <div class="col-md-3 responsive">
                                    <img src="http://static1.squarespace.com/static/51b3dc8ee4b051b96ceb10de/t/56df202560b5e996983e17d8/1457463344117/?format=1500w"
                                         class="img-responsive filmovi-slike">
                                    <h4 class="pull-left">DAN NEZAVISNOSTI: NOVA PRETNJA</h4>
                                    </br></br>
                                    <a href="http://www.imdb.com/title/tt1628841/?ref_=nv_sr_3" class="pull-left">Detaljnije</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </br>
            
            <!--
            <a href="film" class="btn btn-info" role="button">Dodaj film</a>
            -->

        </div>
    </div>
</section>


<!-- Bioskopi Section -->
<section id="bioskopi" class="contact-section ispravka">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 responsive">
                <h1>Bioskopi</h1>
                <br>

                <div class="container">
                    <div class="row">
                        <div class="col-md-4 responsive">
                            <img src="http://www.bravo.rs/wp-content/uploads/2013/07/c1.jpg" class="img-responsive bioskopi filmovi-slike">
                        </div>
                        <div class="col-md-8">
                            <h3 class="podnaslov">Cineplexx</h3>
                            <p>Jedan od najpoznatijih i najmodernijih bioskopa u Srbiji.</br>
                                Jurija Gagarina 16/16A</br>
                                +381 11 2203 400</br>
                                <a href="http://www.cineplexx.rs/">Detaljnije</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="section">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 responsive">
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 responsive">
                            <img src="http://www.nadlanu.com/upload/thumbs/images/articles/2012/07/27/Tuckwood_IB_09-2211441-2_620x0_675x0.jpg" class="img-responsive bioskopi filmovi-slike">
                        </div>
                        <div class="col-md-8 responsive">
                            <h3 class="podnaslov">Tuckwood</h3>
                            <p>Tuckwood je jedan od najstarijih bioskopa u Beogradu. Nalazi se u strogom centru grada. </br>
                                ul. Kneza Miloša 7a </br>
                                tel: +381 11 32 36 517 </br>
                                <a href="http://www.tuck.rs/">Detaljnije</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="section">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- <div class="container">
                       <div class="row">
                         <div class="col-md-4">
                               <img src="http://www.android.rs/lopare/res/slike/2168.jpg" class="img-responsive bioskopi filmovi-slike">
                         </div>
                         <div class="col-md-8">
                               <h3 class="podnaslov">Roda Cineplexx</h3>
                               <p>Jedan od omiljenih bioskopa za decu.</br>
                               Požeška 83a</br>
                               11030 Beograd</br>
                               (011) 254 52 60</br>
                               <a href="http://www.rodacineplex.com/">Detaljnije</a>
                               </p>
                         </div>
                       </div>
                 </div>-->
                <!--
                <a href="bioskop" class="btn btn-info" role="button">Dodaj bioskop</a>
                <a href="sala" class="btn btn-info" role="button">Dodaj salu</a>
                <a href="projekcija" class="btn btn-info" role="button">Dodaj projekciju</a>-->
            </div>
        </div>
    </div>
</section>

<!-- POP UP DEO  PRIJAVA-->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="loginmodal-container">
            <h1>Prijavi se</h1><br>
            <form role="form" action="login" method="POST">
                <input type="text" name="korisnicko-ime" placeholder="Korisničko ime">
                <input type="password" name="lozinka" placeholder="Lozinka">
                <input type="submit" name="login" class="login loginmodal-submit" value="Prijava">
            </form>

        </div>
    </div>
</div>


<!-- POP UP DEO Registracija -->
<div class="modal fade" id="register-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="registermodal-container">
            <h1>Registruj se</h1><br>
            <form role="form" action="registracija" method="POST">

                <input type="text" name="korisnicko-ime" placeholder="Korisničko ime" id="tbUser" maxlength="15">
                <span class="hide warrning" id="tbUserEmpty">Polje "K. ime" mora biti popunjeno !</span>
                <span class="hide warrning" id="tbUserWar">Dozvoljeni su slova, brojevi i '_'(sem na početku i kraju) u dužini od 5 do 15 karaktera!</span>

                <input type="text" name="email" placeholder="E-mail adresa" id="tbEmail" maxlength="40">
                <span class="hide warrning" id="tbEmailEmpty">Polje "E-mail" mora biti popunjeno !</span>
                <span class="hide warrning" id="tbEmailWar">Email mora biti u formi "primer@primer.ext"</span>

                <input type="password" name="lozinka" placeholder="Lozinka" id="tbLozinka1">
                <span class="hide warrning" id="tbLozinka1Empty">Polje "Lozinka" mora biti popunjeno !</span>
                <span class="hide warrning" id="tbLozinka1War">Lozinka mora imati 8 - 15 karaktera (brojeve, velika i mala slova)!</span>

                <input type="password" name="lozinka" placeholder="Potvrdite lozinku" id="tbLozinka2">
                <span class="hide warrning" id="tbLozinka2Empty">Polje "Potvrda lozinke" mora biti popunjeno !</span>
                <span class="hide warrning" id="tbLozinka2War">Lozinka se ne poklapa sa prethodnom lozinkom!</span>

                <input type="submit" name="registracija" class="register registermodal-submit" value="Registracija" id="sbmRegistracija">
            </form>


        </div>
    </div>
</div>

</body>
</html>
