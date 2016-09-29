<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/header.jspf" %>
    
    <script src="js/jquery.js"></script>
    <body>
        </br>
        </br>
        <div class="container">
            
                <div id="pisi" class="center">
                </div>
                <script>
                    var rezervisano = 0; 
                    var ispis = ""; 
                    var semafor = 0; 
                    
    for (var i = 1; i < <c:forEach items="${sale}" var="sala">${sala.br_sedista}</c:forEach>; i++) {
                        if (semafor == 0) {
                            ispis += "<div class='row'>";
                        }

                        ispis += "<button class='"; 

                        ispis += " dugme velicina' value='" + i + "' >" + i + "</button>"; 

                        if (semafor == 11) {
                            semafor = 0; 
                            ispis += "</div> </br>"; 
                        } else
                            semafor++; 
                    }
                   
                    ispis += "</br></br><form  method='post' action='index.jsp' onsubmit='return provera();'>";
                    ispis += "<input type='hidden' id='rezervisano' value=''>";
                    ispis += "<button type='submit' class='btn btn-primary center-block'>Rezervisi</button></form>";
                    
                    document.getElementById("pisi").innerHTML = ispis; 
                    
                    

                    $(document).ready(function () { 
                        $('.dugme').click(function () { 
                            var id = $('#rezervisano').val();

                            if ($(this).hasClass('crvena')) { 
                                $(this).removeClass('crvena'); 
                                rezervisano--; 
                                if (id.charAt(id.indexOf($(this).val()) - 1) == ',')
                                    $('#rezervisano').val(id.replace(',' + $(this).val(), ''));
                                else {
                                    if (id.charAt(id.indexOf($(this).val()) + 1) != ',')
                                        $('#rezervisano').val(id.replace($(this).val(), ''));
                                    else
                                        $('#rezervisano').val(id.replace($(this).val() + ',', ''));
                                }

                            } else {
                                if (rezervisano == 3) {
                                    alert("Nije moguce rezervisati vise od 3 mesta!");
                                } else {
                                    $(this).addClass('crvena');
                                    rezervisano++;
                                    !id ? $('#rezervisano').val($('#rezervisano').val() + $(this).val()) : $('#rezervisano').val($('#rezervisano').val() + "," + $(this).val());
                                }
                            }


                        });
                    });

                    function provera() {
                        return !(document.getElementById('rezervisano').value) ? false : true;
                    }
                </script>
            </div>
    </body>
</html>
