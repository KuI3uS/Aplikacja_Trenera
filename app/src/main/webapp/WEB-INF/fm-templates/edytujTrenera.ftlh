<!DOCTYPE html>
<html lang="pl-PL">
<#setting number_format="computer">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <meta charset="UTF-8">
    <title>Edytuj trenera</title>
</head>
<body>
<h2>Edytuj trenera</h2>
<form method="post" action="edytuj" >
    <input type="text" class="form-control" name="id" id="id" value="${trener.id}" hidden>

    <div class="form-group">
        <label for="imie">Imię</label>
        <input type="text" class="form-control" name="imie" id="imie" value="${trener.imie}">
    </div>
    <div class="form-group">
        <label for="nazwisko">Nazwisko</label>
        <input type="text" class="form-control" name="nazwisko" id="nazwisko" value="${trener.nazwisko}">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" name="email" id="email" value="${trener.email}">
    </div>
    <div class="form-group">
        <label for="telefon">Telefon</label>
        <input type="phone" class="form-control" name="telefon" id="telefon" value="${trener.telefon}">
    </div>


    <div class="row"  align="center">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <button type="submit" class="btn btn-primary center-block" >Edytuj</button>
        </div>
        <div class="col-md-4"></div>
    </div>
</form>
</body>
</html>