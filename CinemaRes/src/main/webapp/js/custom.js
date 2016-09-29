$(document).ready(function(){

  $('.bxslider').bxSlider({
    auto: true,
  });

//Provera polja Ime u registracija
  $('#tbIme').blur(function(){                //na izlasku iz polja za reg imena pocinje funkcija
    var tbImeReg = /^[A-Z]{1}[a-z]{2,14}$/;   //regularni izraz - Polje pocinje jednim karakterom od A-Z, koje prati 2-14 od a-z
    var tbIme = $('#tbIme').val().trim();     //dohvatanje value polja '#tbIme' i brisanje 'space' sa pocetka i zacelja

    if(!tbIme){                               //ako je var 'tbIme' (value polja '#tbIme') prazan
        $("#tbImeEmpty").removeClass('hide'); //prikaz span-a '#tbImeEmpty' skidanjem css svojstva 'display:none' koje ima klasa 'hide'

        $('#tbIme').addClass('crvena');       //boji border polja '#tbIme' u crvenu dodavanjem klase '.crvena'

        if(!($("#tbImeWar").hasClass('hide'))) //provera da li '#tbImeWar' vec prikazano akka da li nema klasu '.hide' koja ga cini nevidljivnom
          $("#tbImeWar").addClass('hide');     //ako nema, dodaje se, da se nebi desilo da ima 2 warninga istovremeno za prazno polje i pogresno uneseno.
    }
    else{                                     //u suprotnom, ako var 'tbIme' (value polja '#tbIme') ima neku vrednost
      if(!($('#tbImeEmpty').hasClass('hide')))//provera da li je 'span' '#tbImeEmpty' sakriven, ako nije dodaj klasu '.hide'
        $("#tbImeEmpty").addClass('hide');

      if(!tbImeReg.test(tbIme)){              //provera da li uneta vrednost nokon trimovanja nije u skladu sa nasim reg izrazom
        if(!($('#tbIme').hasClass('crvena'))) //provera da li polje '#tbIme' ima crveni border akka ima clasu '.crvena'
          $('#tbIme').addClass('crvena');     //ako nema dodaje, da se nebi desilo stakovanje clase crvena
        $("#tbImeWar").removeClass('hide');   //prikazivanje 'span'-a za upozorenje o formatu imena akka ukidanje klase '.hide'
      }
      else{                                   //ako je sve uredu, polje je popunjeno sa vrednoscu koja odgovara regularnom izrazu
        $('#tbIme').removeClass('crvena');    //ukidanje crvenog bordera klase '.crvena'
        $("#tbImeWar").addClass('hide');      //sakrivanje warninga o formatu imena
      }
    }

  });

//Provera polja Prezime u registracija (Pogledati 'Provera polja Ime' za objasnjenje)
  $('#tbPrezime').blur(function(){
    var tbPrezimeReg = /^[A-Z]{1}[a-z]{2,14}(-[A-Z]{1}[a-z]{2,14})?$/;
    var tbPrezime = $('#tbPrezime').val().trim();

    if(!tbPrezime){
        $("#tbPrezimeEmpty").removeClass('hide');

        $('#tbPrezime').addClass('crvena');

        if(!($("#tbPrezimeWar").hasClass('hide')))
          $("#tbPrezimeWar").addClass('hide');
    }
    else{
      if(!($('#tbPrezimeEmpty').hasClass('hide')))
        $("#tbPrezimeEmpty").addClass('hide');

      if(!tbPrezimeReg.test(tbPrezime)){
        if(!($('#tbPrezime').hasClass('crvena')))
          $('#tbPrezime').addClass('crvena');
        $("#tbPrezimeWar").removeClass('hide');
      }
      else{
        $('#tbPrezime').removeClass('crvena');
        $("#tbPrezimeWar").addClass('hide');
      }
    }

  });

  //Provera polja Korisničko ime u registracija (Pogledati 'Provera polja Ime' za objasnjenje)
    $('#tbUser').blur(function(){
      var tbUserReg = /(?=^.{5,15}$)^[a-zA-Z][a-zA-Z0-9]*([_]?[a-zA-Z0-9]+)*$/;
      var tbUser = $('#tbUser').val().trim();

      if(!tbUser){
          $("#tbUserEmpty").removeClass('hide');

          $('#tbUser').addClass('crvena');

          if(!($("#tbUserWar").hasClass('hide')))
            $("#tbUserWar").addClass('hide');
      }
      else{
        if(!($('#tbUserEmpty').hasClass('hide')))
          $("#tbUserEmpty").addClass('hide');

        if(!tbUserReg.test(tbUser)){
          if(!($('#tbUser').hasClass('crvena')))
            $('#tbUser').addClass('crvena');
          $("#tbUserWar").removeClass('hide');
        }
        else{
          $('#tbUser').removeClass('crvena');
          $("#tbUserWar").addClass('hide');
        }
      }

    });

    //Provera polja Email u registracija (Pogledati 'Provera polja Ime' za objasnjenje)
      $('#tbEmail').blur(function(){
        var tbEmailReg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        var tbEmail = $('#tbEmail').val().trim();

        if(!tbEmail){
            $("#tbEmailEmpty").removeClass('hide');

            $('#tbEmail').addClass('crvena');

            if(!($("#tbEmailWar").hasClass('hide')))
              $("#tbEmailWar").addClass('hide');
        }
        else{
          if(!($('#tbEmailEmpty').hasClass('hide')))
            $("#tbEmailEmpty").addClass('hide');

          if(!tbEmailReg.test(tbEmail)){
            if(!($('#tbEmail').hasClass('crvena')))
              $('#tbEmail').addClass('crvena');
            $("#tbEmailWar").removeClass('hide');
          }
          else{
            $('#tbEmail').removeClass('crvena');
            $("#tbEmailWar").addClass('hide');
          }
        }

      });

      //Provera polja Lozinka u registracija (Pogledati 'Provera polja Ime' za objasnjenje)
        $('#tbLozinka1').blur(function(){
          var tbLozinka1Reg = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,15}$/;
          var tbLozinka1 = $('#tbLozinka1').val().trim();

          if(!tbLozinka1){
              $("#tbLozinka1Empty").removeClass('hide');

              $('#tbLozinka1').addClass('crvena');

              if(!($("#tbLozinka1War").hasClass('hide')))
                $("#tbLozinka1War").addClass('hide');
          }
          else{
            if(!($('#tbLozinka1Empty').hasClass('hide')))
              $("#tbLozinka1Empty").addClass('hide');

            if(!tbLozinka1Reg.test(tbLozinka1)){
              if(!($('#tbLozinka1').hasClass('crvena')))
                $('#tbLozinka1').addClass('crvena');
              $("#tbLozinka1War").removeClass('hide');
            }
            else{
              $('#tbLozinka1').removeClass('crvena');
              $("#tbLozinka1War").addClass('hide');
            }
          }

        });

        //Provera polja Ponovite lozinku u registracija (Pogledati 'Provera polja Ime' za objasnjenje)
          $('#tbLozinka2').blur(function(){
            var tbLozinka1 = $('#tbLozinka1').val();
            var tbLozinka2 = $('#tbLozinka2').val().trim();

            if(!tbLozinka2){
                $("#tbLozinka2Empty").removeClass('hide');

                $('#tbLozinka2').addClass('crvena');

                if(!($("#tbLozinka2War").hasClass('hide')))
                  $("#tbLozinka2War").addClass('hide');
            }
            else{
              if(!($('#tbLozinka2Empty').hasClass('hide')))
                $("#tbLozinka2Empty").addClass('hide');

              if(tbLozinka2 != tbLozinka1){
                if(!($('#tbLozinka2').hasClass('crvena')))
                  $('#tbLozinka2').addClass('crvena');
                $("#tbLozinka2War").removeClass('hide');
              }
              else{
                $('#tbLozinka2').removeClass('crvena');
                $("#tbLozinka2War").addClass('hide');
              }
            }

          });

		  
		//Filmovi Top/New/Soon deo
		//$('#filmovi_pregled a').filter(function(){return this.href==location.href}).parent().addClass('active').siblings().removeClass('active')
		$('#filmovi_pregled a').click(function(){
			$(this).parent().addClass('active').siblings().removeClass('active');
			
			var i = $(this).parent().index();
			
			switch(i){
				case 0:
					$('#u-bioskopima').addClass('hide');
					$('#top-filmovi').removeClass('hide');
					$('#uskoro').addClass('hide');
					break;
				case 1:
					$('#u-bioskopima').removeClass('hide');
					$('#top-filmovi').addClass('hide');
					$('#uskoro').addClass('hide');
					break;
				case 2:
					$('#u-bioskopima').addClass('hide');
					$('#top-filmovi').addClass('hide');
					$('#uskoro').removeClass('hide');
					break;
			}
		});
		
		$("#carusel_wrapperr li").each(function(){
		// Uncomment the following if you need to make this dynamic
		var refH = $(this).height();
		var refW = $(this).width();
		var refRatio = refW/refH;
    
		// Hard coded value...
		//var refRatio = 240/300;
    
		var imgH = $(this).children("img").height();
		var imgW = $(this).children("img").width();
    
		if ( (imgW/imgH) < refRatio ) { 
			$(this).addClass("portrait");
		} else {
			$(this).addClass("landscape");
		}
	});
});
