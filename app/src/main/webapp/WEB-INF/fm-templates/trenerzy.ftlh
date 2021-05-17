<!DOCTYPE html>
<html lang="pl-PL">
<#setting number_format="computer">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Lista trenerów</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<a href="/projekt/dodajTrenera" >dodaj</a>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">imie</th>
        <th scope="col">nazwisko</th>
        <th scope="col">email</th>
        <th scope="col">telefon</th>
        <th scope="col">operacje</th>
    </tr>
    </thead>
    <tbody>
    <#list trenerzy>
        <#items as trener>
            <tr class="trener">
                <td scope="row">${trener.imie}</td>
                <td scope="row">${trener.nazwisko}</td>
                <td scope="row">${trener.email}</td>
                <td scope="row">${trener.telefon}</td>
                <td scope="col">
                    <a href="/projekt/trenerzy/usun?id=${trener.id}">usuń</a>
                    <a href="/projekt/trenerzy/edytuj?id=${trener.id}">edytuj</a>
                </td>
            </tr>
        </#items>
    </#list>
    </tbody>
</table>


<script>

</script>
</body>
</html>